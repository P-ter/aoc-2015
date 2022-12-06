fun main() {
    fun part1(input: List<String>): Int {
        val floor = input.first().fold(0) { floor, char ->
            when (char) {
                '(' -> floor + 1
                ')' -> floor - 1
                else -> floor
            }
        }
        return floor
    }

    fun part2(input: List<String>): Int {
        var firstBasement = 0
        var floor = 0
        input.first().forEachIndexed { index, char ->
            when (char) {
                '(' -> floor++
                ')' -> floor--
            }
            if (floor == -1) {
                firstBasement = (index + 1)
                return firstBasement
            }
        }
        return firstBasement
    }

    val input = readInput("dayone")
    println(part1(input))
    println(part2(input))
}
