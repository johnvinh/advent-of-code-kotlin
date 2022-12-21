package aoc2022.day20

fun createList(input: List<String>): IntArray {
    val out = IntArray(input.size){0}
    for (i in input.indices) {
        out[i] = input[i].toInt()
    }
    return out
}

fun moveNumber(indice: Int, numbers: List<Int>) {

}