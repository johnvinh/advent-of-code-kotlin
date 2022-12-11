package aoc2022.day11

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.BeforeTest

class MonkeyTest {
    lateinit var monkey: Monkey

    @BeforeTest
    fun init() {
        monkey = Monkey(arrayListOf(79, 98), "new = old * 19", "divisible by 23", "throw to monkey 2",
            "throw to monkey 3")
    }

    @Test
    fun getItemWorryIncrease_79_1501() {
        assertEquals(1501, monkey.getItemWorryIncrease(monkey.items[0]))
    }

    @Test
    fun getItemWorryDecrease_1501_500() {
        val actual = monkey.getItemWorryIncrease(monkey.items[0])
        assertEquals(500, monkey.getItemWorryDecrease(actual))
    }
}