package aoc2022.day7

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.BeforeTest

class Part1KtTest {
    private var input = arrayListOf("\$ cd /",
        "\$ ls",
        "dir a",
        "14848514 b.txt",
        "8504156 c.dat",
        "dir d",
        "\$ cd a",
        "\$ ls",
        "dir e",
        "29116 f",
        "2557 g",
        "62596 h.lst",
        "\$ cd e",
        "\$ ls",
        "584 i",
        "\$ cd ..",
        "\$ cd ..",
        "\$ cd d",
        "\$ ls",
        "4060174 j",
        "8033020 d.log",
        "5626152 d.ext",
        "7214296 k")
    private lateinit var root: Directory

    @BeforeTest
    fun init() {
        root = constructDirTree(input)
    }

    @Test
    fun getDirSize_RootSize_48381165() {
        assertEquals(48381165, getDirSize(root))
    }
}