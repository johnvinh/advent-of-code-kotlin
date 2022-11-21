package aoc2018.day4

import dev.johnvinh.getInput

fun getGuardMostSleepyMinute(logEntries: ArrayList<LogEntry>) {
    var currentGuard = -1
    val numTimesAsleepPerMinute = HashMap<Int, HashMap<Int, Int>>()
    val startRegex = Regex("^([0-9]+?) start$")
    var startSleepingMinute = 0
    for (logEntry in logEntries) {
        val startMatch = startRegex.find(logEntry.action)
        // Check if a guard changed first
        if (startMatch != null) {
            currentGuard = startMatch.groups[1]?.value?.toInt() ?: -1
        } else {
            if (logEntry.action == "sleep") {
                startSleepingMinute = logEntry.minute
            } else if (logEntry.action == "wakes up") {
                for (minute in startSleepingMinute..logEntry.minute) {
                    var guardMinutes = numTimesAsleepPerMinute[currentGuard]
                    if (guardMinutes != null) {
                        guardMinutes[minute] = guardMinutes.getOrDefault(minute, 0) + 1
                    } else {
                        numTimesAsleepPerMinute[currentGuard] = HashMap<Int, Int>()
                        guardMinutes = numTimesAsleepPerMinute[currentGuard]
                        guardMinutes?.set(minute, guardMinutes.getOrDefault(minute, 0) + 1)
                    }
                }
            }
        }
    }
    var max = 0
    var maxGuard = 0
    var maxMinute = 0
    for (guard in numTimesAsleepPerMinute.keys) {
        if (numTimesAsleepPerMinute[guard]?.maxBy {it.value}?.value!! > max) {
            max = numTimesAsleepPerMinute[guard]?.maxBy {it.value}?.value ?: -1
            maxGuard = guard
            maxMinute = numTimesAsleepPerMinute[guard]?.maxBy {it.value}?.key ?: -1
        }
    }
    println("Guard ID: $maxGuard")
    println("Minute: $maxMinute")
}

fun main() {
    val lines = getInput()
    val logEntries = ArrayList<LogEntry>()
    convertToLogEntries(lines,  logEntries)
    logEntries.sort()
    getGuardMostSleepyMinute(logEntries)
}