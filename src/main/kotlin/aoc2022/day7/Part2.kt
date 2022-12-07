package aoc2022.day7

import dev.johnvinh.getInput

object ProblemConsants {
    const val TOTAL_DISK_SPACE = 70000000
    const val SPACE_REQUIRED = 30000000
}

fun main() {
    val input = getInput()
    val root = constructDirTree(input)
    val childDirs = getChildDirs(root)

}