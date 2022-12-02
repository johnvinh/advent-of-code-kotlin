package aoc2022.day2

import dev.johnvinh.getInput

fun calculateScore2(opponentPlay: Char, endResult: Char): Int {
    var score = 0
    // X = lose, Y = draw, Z = win
    when (endResult) {
        // Lose
        'X' -> {
            when (opponentPlay) {
                // Opponent picks rock, I pick scissors
                'A' -> score += 3
                // Opponent picks paper, I pick rock
                'B' -> score += 1
                // Opponent picks scissors, I pick paper
                'C' -> score += 2
            }
        }
        // Draw
        'Y' -> {
            score += 3
            when (opponentPlay) {
                // Opponent picks rock, I pick rock
                'A' -> score += 1
                // Opponent picks paper, I pick paper
                'B' -> score += 2
                // Opponent picks scissors, I pick scissors
                'C' -> score += 3
            }
        }
        // Win
        'Z' -> {
            score += 6
            when (opponentPlay) {
                // Opponent picks rock, I pick paper
                'A' -> score += 2
                // Opponent picks paper, I pick scissors
                'B' -> score += 3
                // Opponent picks scissors, I pick rock
                'C' -> score += 1
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
        val endResult = line[2]
        totalScore += calculateScore2(opponentPlay, endResult)
    }
    println(totalScore)
}