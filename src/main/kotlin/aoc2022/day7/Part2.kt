package aoc2022.day7

import dev.johnvinh.getInput

object ProblemConsants {
    const val TOTAL_DISK_SPACE = 70000000
    const val SPACE_REQUIRED = 30000000
}

fun main() {
    val input = getInput()
    val root = constructDirTree(input)
    val allDirs = getChildDirs(root)
    allDirs.add(root)

    val usedSpace = getDirSize(root)
    val unusedSpace = ProblemConsants.TOTAL_DISK_SPACE - usedSpace

    // Sizes of dirs which can be deleted to free up enough space for the update
    val deletionCandidates = ArrayList<Int>()
    for (dir in allDirs) {
        val dirSize = getDirSize(dir)
        if ((unusedSpace + dirSize) >= ProblemConsants.SPACE_REQUIRED) {
            deletionCandidates.add(dirSize)
        }
    }
    // Find the min of these
    println(deletionCandidates.min())
}