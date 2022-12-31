package aoc2022.day21

import dev.johnvinh.getInput
import kotlin.math.floor

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
        if (constantRegex.matches(line)) {
            val match = constantRegex.matchEntire(line)
            val key = match!!.groups[1]!!.value
            if (key != monkey) {
                continue
            }
            val value = match.groups[2]!!.value
            monkeys[key] = value.toInt()
            return value.toInt()
        } else if (addRegex.matches(line)) {
            val match = addRegex.matchEntire(line)
            val key = match!!.groups[1]!!.value
            if (key != monkey) {
                continue
            }
            val monkey1Name = match.groups[2]!!.value
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

            val sum = monkey1Value!! + monkey2Value!!
            monkeys[monkey] = sum
            return sum
        } else if (subtractRegex.matches(line)) {
            val match = subtractRegex.matchEntire(line)
            val key = match!!.groups[1]!!.value
            if (key != monkey) {
                continue
            }
            val monkey1Name = match.groups[2]!!.value
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

            val sum = monkey1Value!! - monkey2Value!!
            monkeys[monkey] = sum
            return sum
        } else if (multiplyRegex.matches(line)) {
            val match = multiplyRegex.matchEntire(line)
            val key = match!!.groups[1]!!.value
            if (key != monkey) {
                continue
            }
            val monkey1Name = match.groups[2]!!.value
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

            val sum = monkey1Value!! * monkey2Value!!
            monkeys[monkey] = sum
            return sum
        } else if (divideRegex.matches(line)) {
            val match = divideRegex.matchEntire(line)
            val key = match!!.groups[1]!!.value
            if (key != monkey) {
                continue
            }
            val monkey1Name = match.groups[2]!!.value
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

            val quotient = floor((monkey1Value!! / monkey2Value!!).toDouble())
            monkeys[monkey] = quotient.toInt()
            return quotient.toInt()
        }
    }
    return 0
}

fun main() {
    val lines = getInput()
    val monkeys = HashMap<String, Int>()
    println(calculateMonkeyNumber(lines, "root", monkeys))
}