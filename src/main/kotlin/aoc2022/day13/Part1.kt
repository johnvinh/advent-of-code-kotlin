package aoc2022.day13

fun isInRightOrder(num1: Int, num2: Int): Array<Boolean> {
    // value 1: is in right order
    // value 2: continue checking
    if (num1 == num2) {
        return arrayOf(false, true) // keep checking
    } else if (num1 < num2) {
        return arrayOf(true, false) // right order
    }
    return arrayOf(false, false) // incorrect order
}

fun isInRightOrder(list1: MutableList<Int>, list2: MutableList<Int>) {
    var i = 0
    
}