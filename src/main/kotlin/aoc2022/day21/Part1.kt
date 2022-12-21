package aoc2022.day21

fun createMap(input: List<String>): HashMap<String, Int> {
    val constantRegex = Regex("^([A-Za-z]+?): ([0-9]+)$")
    val addRegex = Regex("^([A-Za-z]+?): ([A-Za-z]+?) + ([A-Za-z]+?)$")
    val subtractRegex = Regex("^([A-Za-z]+?): ([A-Za-z]+?) - ([A-Za-z]+?)$")
    val multiplyRegex = Regex("^([A-Za-z]+?): ([A-Za-z]+?) * ([A-Za-z]+?)$")
    val divideRegex = Regex("^([A-Za-z]+?): ([A-Za-z]+?) / ([A-Za-z]+?)$")
    for (line in input) {

    }
    return HashMap()
}