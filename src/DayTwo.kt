data class Dimension(val length: Int, val width: Int, val height: Int)

fun main() {
    fun part1(input: List<String>): Int {
        val dimensions = input.map {
            val dimension = it.split("x")
            Dimension(dimension[0].toInt(), dimension[1].toInt(), dimension[2].toInt())
        }
        val totalSqFt = dimensions.fold(0) { acc, dimension ->
            val (length, width, height) = dimension
            val areaList = listOf<Int>(
                length*width,
                width*height,
                height*length
            )
            acc + (2*areaList[0] + 2*areaList[1] + 2*areaList[2] + areaList.min())
        }

        return totalSqFt
    }

    fun part2(input: List<String>): Int {
        val dimensions = input.map {
            val dimension = it.split("x")
            Dimension(dimension[0].toInt(), dimension[1].toInt(), dimension[2].toInt())
        }
        val totalFt = dimensions.fold(0) { acc, dimension ->
            val (length, width, height) = dimension
            val sortedSideBasedOnLength = listOf(length, width, height).sorted()
            val lengthOfRibbon = sortedSideBasedOnLength[0]*2 + sortedSideBasedOnLength[1]*2
            val presentVolume = length*width*height
            acc + lengthOfRibbon + presentVolume
        }
        return totalFt
    }

    val input = readInput("daytwo")
    println(part1(input))
    println(part2(input))
}
