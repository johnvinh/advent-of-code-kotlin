package aoc2015.day7

import dev.johnvinh.getInput
import java.lang.IllegalArgumentException

enum class Operation {
    AND, OR, LSHIFT, RSHIFT, NOT, CONSTANT
}

class Part1(private val lines: List<String>) {
    val wires = HashMap<String, Int>()

    fun initializeMap(lines: List<String>) {
        val constantRegex = Regex("^([0-9]+?) -> ([A-Za-z]+)$")
        for (line in lines) {
            val match = constantRegex.find(line)
            if (match != null) {
                val signal = match.groups[1]?.value?.toInt()!!
                val wire = match.groups[2]?.value!!
                wires[wire] = signal
            }
        }
    }

    private fun calculateBinaryOperationResult(match: MatchResult, wire: String, operation: Operation): Int {
        val operand1 = match.groups[1]?.value!!
        val operand2 = match.groups[2]?.value!!

        val operand1Value: Int = if (operand1.toIntOrNull() == null) {
            if (wires.containsKey(operand1)) {
                wires[operand1]!!
            } else {
                calculateSignalValue(operand1)
            }
        } else {
            operand1.toInt()
        }
        wires[operand1] = operand1Value

        val operand2Value: Int = if (operand2.toIntOrNull() == null) {
            if (wires.containsKey(operand2)) {
                wires[operand2]!!
            } else {
                calculateSignalValue(operand2)
            }
        } else {
            operand2.toInt()
        }
        wires[operand2] = operand2Value

        val finalResult = when (operation) {
            Operation.AND -> operand1Value and operand2Value
            Operation.OR -> operand1Value or operand2Value
            Operation.LSHIFT -> operand1Value shl operand2Value
            Operation.RSHIFT -> operand1Value shr operand2Value
            else -> throw IllegalArgumentException()
        }
        wires[wire] = finalResult
        return finalResult
    }

    private fun calculateUnaryOperation(match: MatchResult, wire: String, operation: Operation): Int {
        val operand = match.groups[1]?.value!!
        val operandValue: Int = if (operand.toIntOrNull() == null) {
            if (wires.containsKey(operand)) {
                wires[operand]!!
            } else {
                calculateSignalValue(operand)
            }
        } else {
            operand.toInt()
        }

        return when (operation) {
            Operation.CONSTANT -> {
                wires[operand] = operandValue
                operandValue
            }

            Operation.NOT -> {
                val finalResult = 65535 + operandValue.inv() + 1
                wires[wire] = finalResult
                finalResult
            }

            else -> throw IllegalArgumentException()
        }
    }

    fun calculateSignalValue(wire: String): Int {
        if (wires.containsKey(wire) && wires[wire] != null) {
            return wires[wire]!!
        }

        val andRegex = Regex("^([A-Za-z0-9]+?) AND ([A-Za-z0-9]+?) -> ([A-Za-z]+?)$")
        val orRegex = Regex("^([A-Za-z0-9]+?) OR ([A-Za-z0-9]+?) -> ([A-Za-z]+?)$")
        val lshiftRegex = Regex("^([A-Za-z0-9]+?) LSHIFT ([A-Za-z0-9]+?) -> ([A-Za-z]+?)$")
        val rshiftRegex = Regex("^([A-Za-z0-9]+?) RSHIFT ([A-Za-z0-9]+?) -> ([A-Za-z]+?)$")
        val notRegex = Regex("^NOT ([A-Za-z]+?) -> ([A-Za-z]+?)$")
        val constantRegex = Regex("^([A-Za-z0-9]+?) -> ([A-Za-z]+)$")
        val assignmentRegex = Regex("-> ([A-Za-z]+)$")

        for (line in lines) {
            val assignmentMatch = assignmentRegex.find(line)
            if ((assignmentMatch != null) && (assignmentMatch.groups[1]?.value == wire)) {
                val andMatch = andRegex.matchEntire(line)
                val orMatch = orRegex.matchEntire(line)
                val lshiftMatch = lshiftRegex.matchEntire(line)
                val rshiftMatch = rshiftRegex.matchEntire(line)
                val notMatch = notRegex.matchEntire(line)
                val constantMatch = constantRegex.matchEntire(line)
                if (constantMatch != null) {
                    return calculateUnaryOperation(constantMatch, wire, Operation.CONSTANT)
                } else if (andMatch != null) {
                    return calculateBinaryOperationResult(andMatch, wire, Operation.AND)
                } else if (orMatch != null) {
                    return calculateBinaryOperationResult(orMatch, wire, Operation.OR)
                } else if (lshiftMatch != null) {
                    return calculateBinaryOperationResult(lshiftMatch, wire, Operation.LSHIFT)
                } else if (rshiftMatch != null) {
                    return calculateBinaryOperationResult(rshiftMatch, wire, Operation.RSHIFT)
                } else if (notMatch != null) {
                    return calculateUnaryOperation(notMatch, wire, Operation.NOT)
                }
            }
        }
        return -1
    }
}

fun main() {
    val lines = getInput()
    val part1 = Part1(lines)
    part1.initializeMap(lines)
    println(part1.calculateSignalValue("a"))
}