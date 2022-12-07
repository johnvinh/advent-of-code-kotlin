package aoc2022.day7

import dev.johnvinh.getInput

open class File(val name: String, var size: Int, val parent: Directory?) {
    constructor(name: String, parent: Directory?) : this(name, 0, parent)
}

class Directory(name: String, parent: Directory?) : File(name, parent) {
    val children = ArrayList<File>()
}

/**
 * Construct the file system from the input
 */
fun constructDirTree(lines: List<String>): Directory {
    val fileRegex = Regex("^([0-9]+?) (.+)$")
    val dirRegex = Regex("^dir (.+)$")
    val cdRegex = Regex("^\\$ cd (.+)$")

    // "ls" command output for the root directory starts on line 3
    var currentDirectory = Directory("/", null)

    for (i in 2 until lines.size) {
        val match =
            fileRegex.matchEntire(lines[i]) ?: dirRegex.matchEntire(lines[i]) ?: cdRegex.matchEntire(lines[i])
        // Add each file
        if (fileRegex.matches(lines[i])) {
            val size = match?.groups?.get(1)?.value?.toInt() ?: 0
            val fileName = match?.groups?.get(2)?.value ?: ""
            val newFile = File(fileName, size, currentDirectory)
            currentDirectory.children.add(newFile)
        } else if (dirRegex.matches(lines[i])) {
            val directoryName = match?.groups?.get(1)?.value ?: ""
            val newDirectory = Directory(directoryName, currentDirectory)
            currentDirectory.children.add(newDirectory)
        }
        // Change directories
        else if (cdRegex.matches(lines[i])) {
            val dirName = match?.groups?.get(1)?.value ?: ""
            // Move one directory up
            if (dirName == "..") {
                if (currentDirectory.parent != null) {
                    currentDirectory = currentDirectory.parent!!
                }
            }
            // Move into a directory by name
            else {
                for (file in currentDirectory.children) {
                    if (file.name == dirName) {
                        currentDirectory = file as Directory
                    }
                }
            }
        }
    }

    // Reset currentDirectory to root
    while (currentDirectory.name != "/" && currentDirectory.parent != null) {
        currentDirectory = currentDirectory.parent!!
    }
    return currentDirectory
}

/**
 * Get a directory's total size
 */
fun getDirSize(dir: Directory): Int {
    // Base case
    if (dir.children.size == 0) {
        return 0
    }
    var sum = 0
    for (file in dir.children) {
        sum += if (file is Directory) {
            getDirSize(file)
        } else {
            file.size
        }
    }
    return sum
}

/**
 * Get all the directories which are children of a directory
 */
fun getChildDirs(dir: Directory): HashSet<Directory> {
    val childDirs = HashSet<Directory>()
    for (file in dir.children) {
        if (file is Directory) {
            for (childDir in getChildDirs(file)) {
                childDirs.add(childDir)
            }
            childDirs.add(file)
        }
    }
    return childDirs
}

internal object ProblemConstants {
    const val TARGET_MAX_SIZE = 100000
}

fun main() {
    val input = getInput()
    val root = constructDirTree(input)
    val childDirs = getChildDirs(root)
    // Now that we have every directory, get the ones
    // with size at most 100000
    val smallSizes = ArrayList<Int>()
    for (dir in childDirs) {
        val dirSize = getDirSize(dir)
        if (dirSize <= ProblemConstants.TARGET_MAX_SIZE) {
            smallSizes.add(dirSize)
        }
    }
    println(smallSizes.sum())
}