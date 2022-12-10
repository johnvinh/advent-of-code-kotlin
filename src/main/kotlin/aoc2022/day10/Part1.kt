package aoc2022.day10

import dev.johnvinh.getInput

class Part1 {
    private var currentTick = 1
    private var x = 1
    val valuesOfXPerTick = HashMap<Int, Int>()

    fun noop() {
        valuesOfXPerTick[currentTick] = x
        currentTick++
    }

    fun addx(v: Int) {
        // 1 tick
        valuesOfXPerTick[currentTick] = x
        currentTick++
        // 2 ticks
        valuesOfXPerTick[currentTick] = x
        currentTick++
        // After 2 ticks passed, increment x
        x += v
    }

    fun executeInstructions(input: List<String>) {
        for (line in input) {
            if (line == "noop") {
                noop()
            } else if (line.startsWith("addx")) {
                val parts = line.split(" ")
                val value = parts[1].toInt()
                addx(value)
            }
        }
    }

    fun getSixSignalStrengthSum(): Int {
        val cycle_20 = 20 * valuesOfXPerTick[20]!!
        val cycle_60 = 60 * valuesOfXPerTick[60]!!
        val cycle_100 = 100 * valuesOfXPerTick[100]!!
        val cycle_140 = 140 * valuesOfXPerTick[140]!!
        val cycle_180 = 180 * valuesOfXPerTick[180]!!
        val cycle_220 = 220 * valuesOfXPerTick[220]!!
        return cycle_20 + cycle_60 + cycle_100 + cycle_140 + cycle_180 + cycle_220
    }
}

fun main() {
    val lines = getInput()
    val part1 = Part1()
    part1.executeInstructions(lines)
    println(part1.getSixSignalStrengthSum())
}