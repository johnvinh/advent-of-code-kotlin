package aoc2022.day9

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.BeforeTest

class Part1KtTest {
    private var input = listOf(
        "R 4",
        "U 4",
        "L 3",
        "D 1",
        "R 4",
        "D 1",
        "L 5",
        "R 2"
    )

    @BeforeTest
    fun init() {

    }

    @Test
    fun moveHead_R4_40_30() {
        val expected = arrayOf(intArrayOf(4, 0), intArrayOf(3, 0))
        val actual = moveHead('R', 4, 0, 0, 0, 0)
        // assertEquals will compare the object address for arrays,
        // so we need to compare item equality by doing this
        for (i in actual.indices) {
            for (j in actual[i].indices) {
                assertEquals(expected[i][j], actual[i][j])
            }
        }
    }

    @Test
    fun moveHead_U4_44_43() {
        val expected = arrayOf(intArrayOf(4, 4), intArrayOf(4, 3))
        val actual = moveHead('U', 4, 4, 0, 3, 0)
        // assertEquals will compare the object address for arrays,
        // so we need to compare item equality by doing this
        for (i in actual.indices) {
            for (j in actual[i].indices) {
                assertEquals(expected[i][j], actual[i][j])
            }
        }
    }
}