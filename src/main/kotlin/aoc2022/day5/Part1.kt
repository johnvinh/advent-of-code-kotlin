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

fun executeInstructions(input: List<String>, stacks: ArrayList<Stack<Char>>): ArrayList<Stack<Char>> {
    var firstInstructionIndice = 0
    // Find the line where the instructions start
    for (i in input.indices) {
        val line = input[i]
        if (line.startsWith("move")) {
            firstInstructionIndice = i
            break
        }
    }
    // Start executing the instructions
    val regex = Regex("^move ([0-9]+?) from ([0-9]+?) to ([0-9]+)$")
    for (i in firstInstructionIndice until input.size) {
        val line = input[i]
        val match = regex.matchEntire(line)
        val amount = match?.groups?.get(1)?.value?.toInt() ?: 0
        val from = match?.groups?.get(2)?.value?.toInt() ?: 0
        val to = match?.groups?.get(3)?.value?.toInt() ?: 0
        println("Amount: $amount, From: $from, To: $to")
        // Move one at a time
        for (j in 1..amount) {
            val item = stacks[from - 1].pop()
            stacks[to - 1].push(item)
        }
    }
    return ArrayList()
}

fun main() {
    val lines = getInput()
    val stacks = initializeStacks(lines)
    executeInstructions(lines, stacks)
    println(stacks)
}