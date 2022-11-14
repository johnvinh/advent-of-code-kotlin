package dev.johnvinh

import java.io.BufferedReader
import java.io.FileReader

fun getInput(): List<String> {
    FileReader("input.txt").use { itFr ->
        BufferedReader(itFr).use {
            return it.readLines()
        }
    }
}