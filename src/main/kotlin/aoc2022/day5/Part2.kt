package aoc2022.day5

import dev.johnvinh.getInput
import java.util.*
import kotlin.collections.ArrayList

/**
 * This time, each stack is an ArrayList instead of an actual stack
 */
fun initializeListStacks(input: List<String>): ArrayList<ArrayList<Char>> {
    val stacks = ArrayList<ArrayList<Char>>()
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
        stacks.add(ArrayList<Char>())
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
            stacks[stackToAddTo].add(0, line[j + 1])
            stackToAddTo++
        }
    }
    return stacks
}

fun getMessage2(stacks: ArrayList<ArrayList<Char>>): String {
    val output = StringBuilder()
    for (stack in stacks) {
        output.append(stack[0])
    }
    return output.toString()
}

fun executeInstructions2(input: List<String>, stacks: ArrayList<ArrayList<Char>>) {
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
        // Move the whole amount at once
        val movedItems = stacks[from - 1].subList(0, amount)
        // Loop in reverse to keep order
        for (j in movedItems.size-1 downTo 0) {
            stacks[to - 1].add(0, movedItems[j])
        }
        // Remember to actually remove the items from the original list
        movedItems.clear()
    }
}

fun main() {
    val lines = getInput()
    val stacks = initializeListStacks(lines)
    executeInstructions2(lines, stacks)
    println(getMessage2(stacks))
}