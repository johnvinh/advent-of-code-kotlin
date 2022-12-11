package aoc2022.day11

import dev.johnvinh.getInput
import java.math.BigInteger

fun main() {
    val input = getInput()
    val monkeys = createMonkeyList(input)
    playRounds(monkeys, 10000)
    monkeys.sortByDescending{monkey -> monkey.numInspections}

    val bigInteger1 = BigInteger(monkeys[0].numInspections.toString())
    val bigInteger2 = BigInteger(monkeys[1].numInspections.toString())
    println(bigInteger1.multiply(bigInteger2))
}