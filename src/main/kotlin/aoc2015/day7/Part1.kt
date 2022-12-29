package aoc2015.day7

import dev.johnvinh.getInput

fun initializeMap(lines: List<String>): HashMap<String, Int> {
    val out = HashMap<String, Int>()
    val constantRegex = Regex("^([0-9]+?) -> ([A-Za-z]+)$")
    for (line in lines) {
        val match = constantRegex.find(line)
        if (match != null) {
            val signal = match.groups[1]?.value?.toInt()!!
            val wire = match.groups[2]?.value!!
            out[wire] = signal
        }
    }
    return out
}

fun calculateSignalValue(wire: String, wires: HashMap<String, Int>): Int {
    return 0
}

fun main() {
    val lines = getInput()
    val wires = initializeMap(lines)
    println(wires)
}