package aoc2022.day2

import dev.johnvinh.getInput

fun calculateScore(opponentPlay: Char, myPlay: Char): Int {
    var score = 0
    when (myPlay) {
        // Rock
        'X' -> {
            score += 1
            when (opponentPlay) {
                // Opponent rock
                'A' -> score += 3
                // Opponent scissors
                'C' -> score += 6
            }
        }
        // Paper
        'Y' -> {
            score += 2
            when (opponentPlay) {
                // Opponent rock
                'A' -> score += 6
                // Opponent paper
                'B' -> score += 3
            }
        }
        // Scissors
        'Z' -> {
            score += 3
            when (opponentPlay) {
                // Opponent paper
                'B' -> score += 6
                // Opponent scissors
                'C' -> score += 3
            }
        }
    }
    return score
}

fun main() {
    val lines = getInput()
    var totalScore = 0
    for (line in lines) {
        val opponentPlay = line[0]
        val myPlay = line[2]
        totalScore += calculateScore(opponentPlay, myPlay)
    }
    println(totalScore)
}