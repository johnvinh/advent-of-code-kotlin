package aoc2022.day11

import dev.johnvinh.getInput
import kotlin.math.floor

class Monkey(val items: ArrayList<Int>, private val operation: String,
             val test: String, val trueAction: String, val falseAction: String) {
    var numInspections = 0

    fun getItemWorryIncrease(item: Int): Int {
        val operationRegex = Regex("^new = old ([+*]) (.+)$")
        val match = operationRegex.find(operation)
        val operator = match?.groups?.get(1)?.value
        val operand = match?.groups?.get(2)?.value
        var actualOperand = when (operand) {
            "old" -> {
                item
            }
            else -> operand?.toInt()!!
        }
        // Could be + or *
        when (operator) {
            "+" -> {
                return item + actualOperand
            }
            "*" -> {
                return item * actualOperand
            }
        }
        return -1
    }

    fun getItemWorryDecrease(item: Int): Int {
        return floor((item / 3).toDouble()).toInt()
    }

    fun performTest(item: Int): Boolean {
        val testRegex = Regex("^divisible by ([0-9]+)$")
        val match = testRegex.matchEntire(test)
        val divisor = match?.groups?.get(1)?.value?.toInt() ?: 1
        return (item % divisor) == 0
    }

    fun nextMonkeyToThowTo(item: Int): Int {
        val trueMonkey = trueAction.split(" ")[3].toInt()
        val falseMonkey = falseAction.split(" ")[3].toInt()
        if (performTest(item)) {
            return trueMonkey
        }
        return falseMonkey
    }
}

fun createMonkeyList(input: List<String>): ArrayList<Monkey> {
    val out = ArrayList<Monkey>()
    var startingItems: String = ""
    var startingItemsList: ArrayList<Int>
    var operation: String = ""
    var test: String = ""
    var trueAction: String = ""
    var falseAction: String = ""

    for (i in input.indices) {
        val line = input[i]
        // Make sure the final monkey in the file gets created
        if (i == (input.size - 1)) {
            val ifFalseRegex = Regex("If false: (.+)$")
            val match = ifFalseRegex.find(line)
            falseAction = match?.groups?.get(1)?.value.toString()

            val startingItemParts = startingItems.split(", ")
            startingItemsList = ArrayList()
            for (part in startingItemParts) {
                startingItemsList.add(part.toInt())
            }
            out.add(
                Monkey(
                    startingItemsList,
                    operation,
                    test,
                    trueAction,
                    falseAction
                )
            )
        }
        else if (line == "") {
            val startingItemParts = startingItems.split(", ")
            startingItemsList = ArrayList()
            for (part in startingItemParts) {
                startingItemsList.add(part.toInt())
            }
            out.add(
                Monkey(
                    startingItemsList,
                    operation,
                    test,
                    trueAction,
                    falseAction
                )
            )
        } else if (line.indexOf("Starting items") != -1) {
            val startingItemsRegex = Regex("Starting items: (.+)$")
            val match = startingItemsRegex.find(line)
            startingItems = match?.groups?.get(1)?.value.toString()
        } else if (line.indexOf("Operation") != -1) {
            val operationRegex = Regex("Operation: (.+)$")
            val match = operationRegex.find(line)
            operation = match?.groups?.get(1)?.value.toString()
        } else if (line.indexOf("Test") != -1) {
            val testRegex = Regex("Test: (.+)$")
            val match = testRegex.find(line)
            test = match?.groups?.get(1)?.value.toString()
        } else if (line.indexOf("If true") != -1) {
            val ifTrueRegex = Regex("If true: (.+)$")
            val match = ifTrueRegex.find(line)
            trueAction = match?.groups?.get(1)?.value.toString()
        } else if (line.indexOf("If false") != -1) {
            val ifFalseRegex = Regex("If false: (.+)$")
            val match = ifFalseRegex.find(line)
            falseAction = match?.groups?.get(1)?.value.toString()
        }
    }
    return out
}

fun playRounds(monkeys: ArrayList<Monkey>, numRounds: Int) {
    // n rounds
    for (n in 1..numRounds) {
        for (i in monkeys.indices) {
            val monkey = monkeys[i]
            // A list of indices to remove later
            for (j in monkey.items.indices) {
                val item = monkey.items[j]
                // Inspection begins
                var newWorryLevel = monkey.getItemWorryIncrease(item)
                // Monkey gets bored
                newWorryLevel = monkey.getItemWorryDecrease(newWorryLevel)
                // Get new monkey to pass to
                val newMonkey = monkey.nextMonkeyToThowTo(newWorryLevel)
                // Pass to new monkey
                monkeys[newMonkey].items.add(newWorryLevel)
                // Finally, increment inspections
                monkey.numInspections++
            }
            // Remove the items
            monkey.items.clear()
        }
    }
}

fun main() {
    val input = getInput()
    val monkeys = createMonkeyList(input)
    playRounds(monkeys, 20)
    monkeys.sortByDescending{monkey -> monkey.numInspections}
    println(monkeys[0].numInspections * monkeys[1].numInspections)
}