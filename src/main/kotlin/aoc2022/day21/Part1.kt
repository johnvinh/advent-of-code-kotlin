package aoc2022.day21

fun createMap(input: List<String>): HashMap<String, String> {
    val constantRegex = Regex("^([A-Za-z]+?): ([0-9]+)$")
    val addRegex = Regex("^([A-Za-z]+?): ([A-Za-z]+?) + ([A-Za-z]+?)$")
    val subtractRegex = Regex("^([A-Za-z]+?): ([A-Za-z]+?) - ([A-Za-z]+?)$")
    val multiplyRegex = Regex("^([A-Za-z]+?): ([A-Za-z]+?) * ([A-Za-z]+?)$")
    val divideRegex = Regex("^([A-Za-z]+?): ([A-Za-z]+?) / ([A-Za-z]+?)$")
    for (line in input) {
        if (constantRegex.matches(line)) {
            val match = constantRegex.matchEntire(line)
            val key = match!!.groups[1]!!.value
            val value = match.groups[2]!!.value
        }
    }
    return HashMap()
}