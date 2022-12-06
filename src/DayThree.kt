data class House(val rowIndex: Int, val colIndex: Int)

fun main() {
    fun part1(input: List<String>): Int {
        val direction = input.first()
        val santaMap = mutableMapOf(House(0, 0) to 1)
        var count = 1
        var currentHouse = santaMap.keys.first()
        direction.forEach {
            val (rowIndex, colIndex) = currentHouse
            currentHouse = when(it) {
                '^' -> currentHouse.copy(rowIndex = rowIndex - 1)
                'v' -> currentHouse.copy(rowIndex = rowIndex + 1)
                '>' -> currentHouse.copy(colIndex = colIndex + 1)
                '<' -> currentHouse.copy(colIndex = colIndex -1)
                else -> currentHouse
            }
            val numOfPresent = santaMap.getOrDefault(currentHouse, 0)
            if(numOfPresent == 0) {
                count++
            }
            santaMap[currentHouse] = numOfPresent + 1
        }

        return count
    }

    fun part2(input: List<String>): Int {
        val instruction = input.first()
        val presentMap = mutableMapOf(House(0, 0) to 2)
        var santaCurrentHouse = House(0, 0)
        var robotCurrentHouse = House(0,0)
        var count = 1
        instruction.forEachIndexed { index, direction ->
            var currentHouse = if(index%2 == 0) santaCurrentHouse else robotCurrentHouse
            val (rowIndex, colIndex) = currentHouse
            currentHouse = when(direction) {
                '^' -> currentHouse.copy(rowIndex = rowIndex - 1)
                'v' -> currentHouse.copy(rowIndex = rowIndex + 1)
                '>' -> currentHouse.copy(colIndex = colIndex + 1)
                '<' -> currentHouse.copy(colIndex = colIndex -1)
                else -> currentHouse
            }
            val numOfPresent = presentMap.getOrDefault(currentHouse, 0)
            if(numOfPresent == 0) {
                count++
            }
            presentMap[currentHouse] = numOfPresent + 1
            if(index % 2 == 0) {
                santaCurrentHouse = currentHouse
            } else {
                robotCurrentHouse = currentHouse
            }
        }
        return count
    }

    val input = readInput("daythree")
    println(part1(input))
    println(part2(input))
}
