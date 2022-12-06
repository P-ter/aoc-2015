fun main() {

    val exclusions = listOf("ab", "cd", "pq", "xy")
    val vowels = listOf("a", "e", "i", "o", "u")


    fun part1(input: List<String>): Int {
        var total = 0
        input.forEach {line ->
            val pairs = line.windowed(2)
            if(pairs.intersect(exclusions).isEmpty() &&
                pairs.any { it[0] == it[1] } && line.filter { vowels.contains("$it") }.length >= 3) {
                total++
            }
        }

        return total
    }

    fun part2(input: List<String>): Int {
        var total = 0
        input.forEach { line ->
            val pairs = line.windowed(2)
            val overlaped = pairs.any { pair ->
                val firstIndex = pairs.indexOfFirst { it == pair }
                val lastIndex = pairs.indexOfLast { it == pair }
                (firstIndex != lastIndex) && (firstIndex+1 != lastIndex)
            }
            val repeat = line.windowed(3).any { it.first() == it.last() }
            if(overlaped && repeat) {
                total++
            }
        }
        return total
    }

    val input = readInput("dayfive")
    println(part1(input))
    println(part2(input))
}
