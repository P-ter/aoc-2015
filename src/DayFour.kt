fun main() {
    val dayfour = "iwrupvqb"

    fun part1(input: List<String>): Int {
        var total = 0
        (0 .. Int.MAX_VALUE).forEach {
            val hash = ("$dayfour$it").md5()
            if(hash.startsWith("00000")) {
                return it
            }
        }

        return total
    }

    fun part2(input: List<String>): Int {
        (0 .. Int.MAX_VALUE).forEach {
            val hash = ("$dayfour$it").md5()
            if(hash.startsWith("000000")) {
                return it
            }
        }
        return 0
    }

    val input = emptyList<String>()
    println(part1(input))
    println(part2(input))
}
