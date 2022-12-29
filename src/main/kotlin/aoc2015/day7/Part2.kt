package aoc2015.day7

import dev.johnvinh.getInput

fun main() {
    val lines = getInput()
    val part1 = Part1(lines)
    part1.initializeMap(lines)
    val a = part1.calculateSignalValue("a")
    part1.wires.clear()
    part1.wires["b"] = a
    val newA = part1.calculateSignalValue("a")
    println(newA)
}