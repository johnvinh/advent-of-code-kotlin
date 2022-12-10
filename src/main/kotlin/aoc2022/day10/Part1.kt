package aoc2022.day10

import dev.johnvinh.getInput

/**
 * A class for day 10 part 1.
 *
 * Its only purpose is to share the x values and x ticks easily across the whole program.
 */
class Part1 {
    /**
     * Store the current tick (time unit) of the program.
     */
    private var currentTick = 1

    /**
     * The current value of x.
     */
    private var x = 1

    /**
     * A HashMap with each tick as the key
     * and the value of x at that tick as the value.
     */
    val valuesOfXPerTick = HashMap<Int, Int>()

    /**
     * An array of char arrays which represent
     * the sprite output.
     */
    var screen = Array(6){Array(40) {'0'}}

    /**
     * The current screen position to write to.
     */
    private var currentScreenPosition = 0

    /**
     * The current row to write to.
     */
    private var currentScreenRow = 0

    /**
     * Does nothing for one tick.
     */
    fun noop() {
        valuesOfXPerTick[currentTick] = x
        updateScreen()
        currentTick++
    }

    /**
     * Takes two ticks to add v to x.
     * @param v the amount to add to x
     */
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

    /**
     * Execute a list of instructions.
     * @param   input   The list of input instructions.
     */
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

    /**
     * Get the signal strengths of tick 20, 60, 100, 140, 180, and 220.
     * This is the output for part 1.
     */
    fun getSixSignalStrengthSum(): Int {
        val cycle20 = 20 * valuesOfXPerTick[20]!!
        val cycle60 = 60 * valuesOfXPerTick[60]!!
        val cycle100 = 100 * valuesOfXPerTick[100]!!
        val cycle140 = 140 * valuesOfXPerTick[140]!!
        val cycle180 = 180 * valuesOfXPerTick[180]!!
        val cycle220 = 220 * valuesOfXPerTick[220]!!
        return cycle20 + cycle60 + cycle100 + cycle140 + cycle180 + cycle220
    }

    /**
     * Update the screen based on whether x is pointed to
     * one of the three current sprite pixels.
     */
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

    /**
     * Print the output of the screen.
     */
    fun printScreen() {
        for (i in screen.indices) {
            for (j in screen[i].indices) {
                print(screen[i][j])
            }
            println("")
        }
    }
}

/**
 * Run Part 1.
 */
fun main() {
    val lines = getInput()
    val part1 = Part1()
    part1.executeInstructions(lines)
    println(part1.getSixSignalStrengthSum())
}