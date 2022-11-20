package aoc2018.day4

import dev.johnvinh.getInput
import kotlin.math.min

class LogEntry(val month: Int, val year: Int, val hour: Int, val minute: Int)

fun main() {
    val lines = getInput()
    val logEntries = ArrayList<LogEntry>()
    val timeRegex = Regex("\\[1518-([0-9]+?)-([0-9]+?) ([0-9]+?):([0-9]+?)]")
    val shiftBeginRegex = Regex("Guard #([0-9]+?) begins shift$")
    val fallsAsleepRegex = Regex("falls asleep$")
    val wakesUpRegex = Regex("wakes up$")
    for (line in lines) {
        val timeMatch = timeRegex.find(line)
        if (timeMatch != null) {
            val month = timeMatch.groups[1]?.value
            val day = timeMatch.groups[2]?.value
            val hour = timeMatch.groups[3]?.value
            val minute = timeMatch.groups[4]?.value
            println(minute)
        }
    }
}