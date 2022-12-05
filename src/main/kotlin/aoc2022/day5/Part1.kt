package aoc2022.day5

import dev.johnvinh.getInput
import java.util.Stack

fun initializeStacks(input: List<String>): ArrayList<Stack<Char>> {
    // Find which line the stack declaration numbers begin
    var stackDeclarationIndice = 0
    for (i in input.indices) {
        if (input[i][1] == '1') {
            stackDeclarationIndice = i
            break
        }
    }
    println(stackDeclarationIndice)
    return ArrayList()
}

fun main() {
    val lines = getInput()
    initializeStacks(lines)
}