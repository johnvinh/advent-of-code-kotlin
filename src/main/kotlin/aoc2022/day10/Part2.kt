package aoc2022.day10

import dev.johnvinh.getInput

/**
 * Run Part 2
 */
fun main() {
    val lines = getInput()
    val part1 = Part1()
    part1.executeInstructions(lines)
    part1.printScreen()
}