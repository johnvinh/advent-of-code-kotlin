package aoc2022.day11

import kotlin.math.floor

class Monkey(val items: ArrayList<Int>, private val operation: String,
             val test: String, val trueAction: String, val falseAction: String) {
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
}