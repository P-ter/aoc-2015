fun main() {

    val map = buildMap<Int, MutableList<Boolean>> {
        (0 .. 999).forEach {row ->
            this[row] = (0 .. 999).map { false }.toMutableList()
        }
    }

    fun part1(input: List<String>): Int {
        var total = 0
        val firstMap = map.toMap().toMutableMap()
        input.forEach { line ->
            val word = line.split(" ")
            val (from, to) = word.filter { it.contains(",") }
            val (fromX, fromY) = from.split(",").map { it.toInt() }
            val (toX, toY) = to.split(",").map { it.toInt() }
            for(i in fromX .. toX) {
                for(y in fromY .. toY) {
                    if(line.contains("toggle")) {
                        firstMap[i]?.set(y, !firstMap[i]?.get(y)!!)
                    } else if (line.contains("turn off")) {
                        firstMap[i]?.set(y, false)
                    } else if (line.contains("turn on")){
                        firstMap[i]?.set(y, true)
                    }
                }
            }
        }
        total = firstMap.values.fold(0) { count, row ->
            count + row.count { it == true }
        }
        return total
    }

    fun part2(input: List<String>): Int {
        val secondMap = buildMap<Int, MutableList<Int>> {
            (0 .. 999).forEach {row ->
                this[row] = (0 .. 999).map { 0 }.toMutableList()
            }
        }
        var total = 0
        input.forEach { line ->
            val word = line.split(" ")
            val (from, to) = word.filter { it.contains(",") }
            val (fromX, fromY) = from.split(",").map { it.toInt() }
            val (toX, toY) = to.split(",").map { it.toInt() }
            for(i in fromX .. toX) {
                for(y in fromY .. toY) {
                    if(line.contains("toggle")) {
                        secondMap[i]?.set(y, secondMap[i]?.get(y)!! + 2)
                    } else if (line.contains("turn off")) {
                        secondMap[i]?.set(y, (secondMap[i]?.get(y)!! - 1).takeIf { it >= 0 } ?: 0)
                    } else if (line.contains("turn on")){
                        secondMap[i]?.set(y, secondMap[i]?.get(y)!! + 1)
                    }
                }
            }
        }
        total = secondMap.values.fold(0) { count, row ->
            count + row.reduce { acc, i -> acc + i }
        }

        return total
    }

    val input = readInput("daysix")
//    val input = listOf("toggle 0,0 through 999,0")
    println(part1(input))
    println(part2(input))
}
