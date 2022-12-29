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

fun calculateSignalValue(lines: List<String>, wire: String, wires: HashMap<String, Int>): Int {
    if (wires.containsKey(wire)) {
        return wires[wire]!!
    }

    val andRegex = Regex("^([A-Za-z0-9]+?) AND ([A-Za-z0-9]+?) -> ([A-Za-z]+?)$")
    val orRegex = Regex("^([A-Za-z0-9]+?) OR ([A-Za-z0-9]+?) -> ([A-Za-z]+?)$")
    val lshiftRegex = Regex("^([A-Za-z0-9]+?) LSHIFT ([A-Za-z0-9]+?) -> ([A-Za-z]+?)$")
    val rshiftRegex = Regex("^([A-Za-z0-9]+?) RSHIFT ([A-Za-z0-9]+?) -> ([A-Za-z]+?)$")
    val notRegex = Regex("^NOT ([A-Za-z]+?) -> ([A-Za-z]+?)$")

    for (line in lines) {
        // Find the assignment line
        if (line.contains("-> $wire")) {
            val andMatch = andRegex.matchEntire(line)
            val orMatch = orRegex.matchEntire(line)
            val lshiftMatch = lshiftRegex.matchEntire(line)
            val rshiftMatch = rshiftRegex.matchEntire(line)
            val notMatch = notRegex.matchEntire(line)
            if (andMatch != null) {
                val operand1 = andMatch.groups[1]?.value!!
                val operand2 = andMatch.groups[2]?.value!!

                val operand1Value: Int = if (operand1.toIntOrNull() == null) {
                    if (wires.containsKey(operand1)) {
                        wires[operand1]!!
                    } else {
                        calculateSignalValue(lines, operand1, wires)
                    }
                } else {
                    operand1.toInt()
                }
                wires[operand1] = operand1Value

                val operand2Value: Int = if (operand2.toIntOrNull() == null) {
                    if (wires.containsKey(operand2)) {
                        wires[operand2]!!
                    } else {
                        calculateSignalValue(lines, operand2, wires)
                    }
                } else {
                    operand2.toInt()
                }
                wires[operand2] = operand2Value

                val finalResult = operand1Value and operand2Value
                wires[wire] = finalResult
                return finalResult
            } else if (orMatch != null) {
                val operand1 = orMatch.groups[1]?.value!!
                val operand2 = orMatch.groups[2]?.value!!

                val operand1Value: Int = if (operand1.toIntOrNull() == null) {
                    if (wires.containsKey(operand1)) {
                        wires[operand1]!!
                    } else {
                        calculateSignalValue(lines, operand1, wires)
                    }
                } else {
                    operand1.toInt()
                }
                wires[operand1] = operand1Value

                val operand2Value: Int = if (operand2.toIntOrNull() == null) {
                    if (wires.containsKey(operand2)) {
                        wires[operand2]!!
                    } else {
                        calculateSignalValue(lines, operand2, wires)
                    }
                } else {
                    operand2.toInt()
                }
                wires[operand2] = operand2Value

                val finalResult = operand1Value or operand2Value
                wires[wire] = finalResult
                return finalResult
            } else if (lshiftMatch != null) {
                val operand1 = lshiftMatch.groups[1]?.value!!
                val operand2 = lshiftMatch.groups[2]?.value!!

                val operand1Value: Int = if (operand1.toIntOrNull() == null) {
                    if (wires.containsKey(operand1)) {
                        wires[operand1]!!
                    } else {
                        calculateSignalValue(lines, operand1, wires)
                    }
                } else {
                    operand1.toInt()
                }
                wires[operand1] = operand1Value

                val operand2Value: Int = if (operand2.toIntOrNull() == null) {
                    if (wires.containsKey(operand2)) {
                        wires[operand2]!!
                    } else {
                        calculateSignalValue(lines, operand2, wires)
                    }
                } else {
                    operand2.toInt()
                }
                wires[operand2] = operand2Value

                val finalResult = operand1Value shl operand2Value
                wires[wire] = finalResult
                return finalResult
            } else if (rshiftMatch != null) {
                val operand1 = rshiftMatch.groups[1]?.value!!
                val operand2 = rshiftMatch.groups[2]?.value!!

                val operand1Value: Int = if (operand1.toIntOrNull() == null) {
                    if (wires.containsKey(operand1)) {
                        wires[operand1]!!
                    } else {
                        calculateSignalValue(lines, operand1, wires)
                    }
                } else {
                    operand1.toInt()
                }
                wires[operand1] = operand1Value

                val operand2Value: Int = if (operand2.toIntOrNull() == null) {
                    if (wires.containsKey(operand2)) {
                        wires[operand2]!!
                    } else {
                        calculateSignalValue(lines, operand2, wires)
                    }
                } else {
                    operand2.toInt()
                }
                wires[operand2] = operand2Value

                val finalResult = operand1Value shr operand2Value
                wires[wire] = finalResult
                return finalResult
            } else if (notMatch != null) {
                val operand = notMatch.groups[1]?.value!!
                val value = if (operand.toIntOrNull() == null) {
                    if (wires.containsKey(operand)) {
                        wires[operand]!!
                    } else {
                        calculateSignalValue(lines, operand, wires)
                    }
                } else {
                    operand.toInt()
                }

                val finalResult = 65535 + value.inv() + 1
                wires[wire] = finalResult
                return finalResult
            }
        }
    }
    return -1
}

fun main() {
    val lines = getInput()
    val wires = initializeMap(lines)
    println(calculateSignalValue(lines, "a", wires))
}