package aoc2018.day4

import dev.johnvinh.getInput

class LogEntry(val month: Int, val year: Int, val hour: Int, val minute: Int)

fun main() {
    val lines = getInput()
    val logEntries = ArrayList<LogEntry>()
    val timeRegex = Regex("^\\[1518-([0-9]+?)-([0-9]+?) ([0-9]+?):([0-9]+?)]")
    val shiftBeginRegex = Regex("Guard #([0-9]+?) begins shift$")
    val fallsAsleepRegex = Regex("falls asleep$")
    val wakesUpRegex = Regex("wakes up$")
}