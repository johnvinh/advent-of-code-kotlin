package aoc2022.day10

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
}