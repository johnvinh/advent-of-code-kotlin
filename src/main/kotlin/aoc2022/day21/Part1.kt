package aoc2022.day21

import dev.johnvinh.getInput
import kotlin.math.floor

enum class BinaryOperation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}

fun calculateBinaryOperation(operation: BinaryOperation, regex: Regex, monkeys: HashMap<String, Int>, line: String, monkey: String, lines: List<String>): Int {
    val match = regex.matchEntire(line)
    val monkey1Name = match!!.groups[2]!!.value
    val monkey2Name = match.groups[3]!!.value
    val monkey1Value = if (monkeys.containsKey(monkey1Name)) {
        monkeys[monkey1Name]
    } else {
        calculateMonkeyNumber(lines, monkey1Name, monkeys)
    }
    val monkey2Value = if (monkeys.containsKey(monkey2Name)) {
        monkeys[monkey2Name]
    } else {
        calculateMonkeyNumber(lines, monkey2Name, monkeys)
    }

    when (operation) {
        BinaryOperation.ADD -> {
            val sum = monkey1Value!! + monkey2Value!!
            monkeys[monkey] = sum
            return sum
        }
        BinaryOperation.SUBTRACT -> {
            val difference = monkey1Value!! - monkey2Value!!
            monkeys[monkey] = difference
            return difference
        }
        BinaryOperation.DIVIDE -> {
            val quotient = monkey1Value!! / monkey2Value!!
            monkeys[monkey] = quotient
            return quotient
        }
        BinaryOperation.MULTIPLY -> {
            val product = monkey1Value!! * monkey2Value!!
            monkeys[monkey] = product
            return product
        }
    }
}

fun calculateMonkeyNumber(lines: List<String>, monkey: String, monkeys: HashMap<String, Int>): Int {
    if (monkeys.containsKey(monkey) && monkeys[monkey] != null) {
        return monkeys[monkey]!!
    }

    val constantRegex = Regex("^([A-Za-z]+?): ([0-9]+)$")
    val addRegex = Regex("^([A-Za-z]+?): ([A-Za-z]+?) \\+ ([A-Za-z]+?)$")
    val subtractRegex = Regex("^([A-Za-z]+?): ([A-Za-z]+?) - ([A-Za-z]+?)$")
    val multiplyRegex = Regex("^([A-Za-z]+?): ([A-Za-z]+?) \\* ([A-Za-z]+?)$")
    val divideRegex = Regex("^([A-Za-z]+?): ([A-Za-z]+?) / ([A-Za-z]+?)$")
    for (line in lines) {
        if (!(line.contains("${monkey}:"))) {
            continue
        }
        if (constantRegex.matches(line)) {
            val match = constantRegex.matchEntire(line)
            val key = match!!.groups[1]!!.value
            val value = match.groups[2]!!.value
            monkeys[key] = value.toInt()
            return value.toInt()
        } else if (addRegex.matches(line)) {
            return calculateBinaryOperation(BinaryOperation.ADD, addRegex, monkeys, line, monkey, lines)
        } else if (subtractRegex.matches(line)) {
            return calculateBinaryOperation(BinaryOperation.SUBTRACT, subtractRegex, monkeys, line, monkey, lines)
        } else if (multiplyRegex.matches(line)) {
            return calculateBinaryOperation(BinaryOperation.MULTIPLY, multiplyRegex, monkeys, line, monkey, lines)
        } else if (divideRegex.matches(line)) {
            return calculateBinaryOperation(BinaryOperation.DIVIDE, divideRegex, monkeys, line, monkey, lines)
        }
    }
    return -1
}

fun main() {
    val lines = getInput()
    val monkeys = HashMap<String, Int>()
    println(calculateMonkeyNumber(lines, "root", monkeys))
}