package aoc2022.day10

import dev.johnvinh.getInput

class Part1 {
    private var currentTick = 1
    private var x = 1
    val valuesOfXPerTick = HashMap<Int, Int>()
    var screen = Array(6){Array(40) {'0'}}
    //private val screen = Array(240){'0'}
    private var currentScreenPosition = 0
    private var currentScreenRow = 0

    fun noop() {
        valuesOfXPerTick[currentTick] = x
        updateScreen()
        currentTick++
    }

    fun addx(v: Int) {
        // 1 tick
        valuesOfXPerTick[currentTick] = x
        updateScreen()
        currentTick++
        // 2 ticks
        valuesOfXPerTick[currentTick] = x
        updateScreen()
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
        val cycle20 = 20 * valuesOfXPerTick[20]!!
        val cycle60 = 60 * valuesOfXPerTick[60]!!
        val cycle100 = 100 * valuesOfXPerTick[100]!!
        val cycle140 = 140 * valuesOfXPerTick[140]!!
        val cycle180 = 180 * valuesOfXPerTick[180]!!
        val cycle220 = 220 * valuesOfXPerTick[220]!!
        return cycle20 + cycle60 + cycle100 + cycle140 + cycle180 + cycle220
    }

    private fun updateScreen() {
        if (currentScreenPosition == x || currentScreenPosition == (x - 1) || currentScreenPosition == (x + 1)) {
            screen[currentScreenRow][currentScreenPosition] = '█'
        } else {
            screen[currentScreenRow][currentScreenPosition] = '░'
        }
        if (currentScreenPosition == 39) {
            currentScreenPosition = 0
            currentScreenRow++
        } else {
            currentScreenPosition++
        }
    }

    fun printScreen() {
        for (i in screen.indices) {
            for (j in screen[i].indices) {
                print(screen[i][j])
            }
            println("")
        }
    }
}

fun main() {
    val lines = getInput()
    val part1 = Part1()
    part1.executeInstructions(lines)
    println(part1.getSixSignalStrengthSum())

}