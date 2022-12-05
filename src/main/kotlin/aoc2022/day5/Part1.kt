package aoc2022.day5

import dev.johnvinh.getInput
import java.util.Stack

fun initializeStacks(input: List<String>): ArrayList<Stack<Char>> {
    val stacks = ArrayList<Stack<Char>>()
    // Find which line the stack declaration numbers begin
    var stackDeclarations = ""
    var stackDeclarationIndice = 0
    for (i in input.indices) {
        if (input[i][1] == '1') {
            stackDeclarations = input[i]
            stackDeclarationIndice = i
            break
        }
    }
    // Create as many stacks as the input has
    for (i in stackDeclarations.split("   ").indices) {
        stacks.add(Stack<Char>())
    }
    // Give each stack their respective items
    for (i in stackDeclarationIndice-1 downTo 0 ) {
        val line = input[i]
        var stackToAddTo = 0
        for (j in line.indices step 4) {
            // Each item begins with a '[' character
            if (line[j] != '[') {
                stackToAddTo++
                continue
            }
            // The actual item to add is always the second character
            // ie [D]
            stacks[stackToAddTo].push(line[j + 1])
            stackToAddTo++
        }
    }
    return stacks
}

fun main() {
    val lines = getInput()
    val stacks = initializeStacks(lines)
    println(stacks)
}