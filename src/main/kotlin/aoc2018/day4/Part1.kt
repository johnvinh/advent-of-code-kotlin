package aoc2018.day4

import dev.johnvinh.getInput

data class LogEntry(val month: Int, val day: Int, val hour: Int, val minute: Int, val action: String): Comparable<LogEntry> {
    override fun compareTo(other: LogEntry): Int {
        return compareValuesBy(this, other, { it.month }, { it.day }, { it.hour }, { it.minute })
    }
}

fun getMinutesAsleep(logEntries: ArrayList<LogEntry>): HashMap<Int, Int> {
    val minutesAsleep = HashMap<Int, Int>()
    val startRegex = Regex("^([0-9]+?) start$")
    var currentGuard = -1
    var startSleepingMinute = -1
    for (logEntry in logEntries) {
        val startMatch = startRegex.find(logEntry.action)
        // Check if the guard is changing first
        if (startMatch != null) {
            currentGuard = startMatch.groups[1]?.value?.toInt() ?: -1
        } else {
            if (logEntry.action == "sleep") {
                startSleepingMinute = logEntry.minute
            } else if (logEntry.action == "wakes up") {
                minutesAsleep[currentGuard] = minutesAsleep.getOrDefault(currentGuard, 0) + (logEntry.minute - startSleepingMinute)
            }
        }
    }
    return minutesAsleep
}

fun getMostSleepyMinute(logEntries: ArrayList<LogEntry>, guardId: Int): Int {
    // Key: Minute, value: num times asleep
    val sleepyMinutes = HashMap<Int, Int>()
    val regex = Regex("^([0-9]+?) start$")
    var currentGuard = -1
    var startSleepingMinute = 0
    for (logEntry in logEntries) {
        val match = regex.find(logEntry.action)
        // Check if a guard changed first
        if (match != null) {
            currentGuard = match.groups[1]?.value?.toInt() ?: -1
        } else {
            if (logEntry.action == "sleep") {
                startSleepingMinute = logEntry.minute
            } else if (logEntry.action == "wakes up") {
                if (currentGuard == guardId) {
                    // Each of the minutes in-between the start sleep and wakeup times are considered sleeping minutes
                    for (minute in startSleepingMinute..logEntry.minute) {
                        sleepyMinutes[minute] = sleepyMinutes.getOrDefault(minute, 0) + 1
                    }
                }
            }
        }
    }
    return (sleepyMinutes.maxBy { it.value }).key
}

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
            val month = timeMatch.groups[1]?.value?.toInt() ?: -1
            val day = timeMatch.groups[2]?.value?.toInt() ?: -1
            val hour = timeMatch.groups[3]?.value?.toInt() ?: -1
            val minute = timeMatch.groups[4]?.value?.toInt() ?: -1

            var match = shiftBeginRegex.find(line)
            if (match != null) {
                val guardId = match.groups[1]?.value
                logEntries.add(LogEntry(month, day, hour, minute, "$guardId start"))
                continue
            }
            match = fallsAsleepRegex.find(line)
            if (match != null) {
                logEntries.add(LogEntry(month, day, hour, minute, "sleep"))
                continue
            }
            match = wakesUpRegex.find(line)
            if (match != null) {
                logEntries.add(LogEntry(month, day, hour, minute, "wakes up"))
            }
        }
    }

    // 1. Sort the entries in chronological order
    logEntries.sort()
    // 2. Find the guard with the most minutes asleep
    val minutesAsleep = getMinutesAsleep(logEntries)
    val maxId = minutesAsleep.maxBy { it.value }
    // 3. Find the minute that guard spends the most time asleep
    val sleepyMinute = getMostSleepyMinute(logEntries, maxId.key)
    println(maxId.key * sleepyMinute)
}