package aoc2022.day20

import dev.johnvinh.getInput
import kotlin.math.abs

fun createList(input: List<String>): IntArray {
    val out = IntArray(input.size){0}
    for (i in input.indices) {
        out[i] = input[i].toInt()
    }
    return out
}

fun mixNumbers(numbers: IntArray): IntArray {
    val numbersCopy = numbers.copyOf()
    val numberCurrentIndices = HashMap<Int, Int>()
    for (i in numbers.indices) {
        numberCurrentIndices[numbers[i]] = i
    }
    for (i in numbersCopy.indices) {
        val currentNumber = numbers[i]
        val currentNumberIndice = numberCurrentIndices[currentNumber]!!
        if (currentNumber >= 0) {
            val newIndice = (currentNumberIndice + currentNumber) % numbers.size
            val newIndiceValue = numbersCopy[newIndice]
            numbersCopy[newIndice] = currentNumber
            numbersCopy[i] = newIndiceValue
            numberCurrentIndices[currentNumber] = newIndice
        } else {
            val newIndice = numbers.size - abs(currentNumber)
            val newIndiceValue = numbersCopy[newIndice]
            numbersCopy[newIndice] = currentNumber
            numbersCopy[i] = newIndiceValue
            numberCurrentIndices[currentNumber] = newIndice
        }
    }
    return numbersCopy
}

fun main() {
    val input = getInput()
    var numbers = createList(input)
    numbers = mixNumbers(numbers)
    print("[")
    for (i in numbers.indices) {
        if (i == numbers.size-1) {
            print(numbers[i])
        } else {
            print("${numbers[i]}, ")
        }
    }
    print("]")
}