package aoc2022.day11

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.BeforeTest

class MonkeyTest {
    lateinit var monkey: Monkey

    @BeforeTest
    fun init() {
        monkey = Monkey(arrayListOf(BigInteger.valueOf(79), BigInteger.valueOf(98)),
            "new = old * 19", "divisible by 23", "throw to monkey 2",
            "throw to monkey 3")
    }

    @Test
    fun getItemWorryIncrease_79_1501() {
        assertEquals(BigInteger.valueOf(1501), monkey.getItemWorryIncrease(monkey.items[0]))
    }

    @Test
    fun getItemWorryDecrease_1501_500() {
        val actual = monkey.getItemWorryIncrease(monkey.items[0])
        assertEquals(BigInteger.valueOf(500), monkey.getItemWorryDecrease(actual))
    }

    @Test
    fun performTest_500_False() {
        assertFalse(monkey.performTest(BigInteger.valueOf(500)))
    }

    @Test
    fun performTest_46_True() {
        assertTrue(monkey.performTest(BigInteger.valueOf(46)))
    }

    @Test
    fun nextMonkeyToThowTo_500_3() {
        assertEquals(3, monkey.nextMonkeyToThowTo(BigInteger.valueOf(500)))
    }

    @Test
    fun nextMonkeyToThrowTo_25_1() {
        val newMonkey = Monkey(
            arrayListOf(BigInteger.valueOf(74)),
            "new = old + 3",
            "divisible by 17",
            "throw to monkey 0",
            "throw to monkey 1"
        )
        var newWorry = newMonkey.getItemWorryIncrease(newMonkey.items[0])
        newWorry = newMonkey.getItemWorryDecrease(newWorry)
        assertEquals(1, newMonkey.nextMonkeyToThowTo(newWorry))
    }
}