package aoc2022.day11

import dev.johnvinh.getInput
import java.math.BigInteger
import kotlin.math.floor

class Monkey(val items: ArrayList<BigInteger>, private val operation: String,
             val test: String, val trueAction: String, val falseAction: String) {
    var numInspections = 0
    var divisor = 0

    fun initDivisor() {
        val testRegex = Regex("^divisible by ([0-9]+)$")
        val match = testRegex.matchEntire(test)
        val divisor = match?.groups?.get(1)?.value?.toInt() ?: 1
        this.divisor = divisor
    }
    fun getItemWorryIncrease(item: BigInteger): BigInteger {
        val operationRegex = Regex("^new = old ([+*]) (.+)$")
        val match = operationRegex.find(operation)
        val operator = match?.groups?.get(1)?.value
        val operand = match?.groups?.get(2)?.value
        var actualOperand = when (operand) {
            "old" -> {
                item
            }
            //else -> operand?.toInt()!!
            else -> {
                if (operand != null) {
                    BigInteger(operand)
                } else {
                    BigInteger("0")
                }
            }
        }
        // Could be + or *
        when (operator) {
            "+" -> {
                return item.add(actualOperand)
            }
            "*" -> {
                return item.multiply(actualOperand)
            }
        }
        return BigInteger.valueOf(-1)
    }

    fun getItemWorryDecrease(item: BigInteger): BigInteger {
        return item.divide(BigInteger.valueOf(3))
    }

    fun performTest(item: BigInteger): Boolean {
        val testRegex = Regex("^divisible by ([0-9]+)$")
        val match = testRegex.matchEntire(test)
        val divisor = match?.groups?.get(1)?.value?.toInt() ?: 1
        return item.mod(BigInteger.valueOf(divisor.toLong())) == BigInteger.ZERO
    }

    fun nextMonkeyToThowTo(item: BigInteger): Int {
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
    var startingItemsList: ArrayList<BigInteger>
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
                startingItemsList.add(BigInteger(part))
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
                startingItemsList.add(BigInteger(part))
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
    var lcm = BigInteger.valueOf(1)
    for (i in monkeys.indices) {
        val monkey = monkeys[i]
        monkey.initDivisor()
        val numInspectionsBigInt = BigInteger.valueOf(monkey.divisor.toLong())
        lcm = lcm.multiply(numInspectionsBigInt)
    }

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
                //newWorryLevel = monkey.getItemWorryDecrease(newWorryLevel)
                newWorryLevel = if (numRounds == 20) {
                    monkey.getItemWorryDecrease(newWorryLevel)
                } else {
                    newWorryLevel.mod(lcm)
                }
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