fun main() {
    val matrix = mutableListOf(
        mutableListOf(1, 2, 1),
        mutableListOf(2, 2, 2),
        mutableListOf(2, 2, 2),
        mutableListOf(1, 2, 3),
        mutableListOf(2, 2, 1)
    )
    print(solution(matrix))
}

fun solution(matrix: MutableList<MutableList<Int>>): Int {
    val n = matrix.size
    val m = matrix[0].size

    val k = countIdentical2x2Squares(matrix)

    return (n - 1) * (m - 1) - k
}

fun countIdentical2x2Squares(matrix: MutableList<MutableList<Int>>): Int {
    val counts = mutableMapOf<List<Int>, Int>()
    var k = 0

    for (i in 0 until matrix.size - 1) {
        for (j in 0 until matrix[0].size - 1) {
            val square = listOf(
                matrix[i][j], matrix[i][j + 1],
                matrix[i + 1][j], matrix[i + 1][j + 1]
            )
            if (square in counts) {
                counts[square] = counts[square]!! + 1
            } else {
                counts[square] = 1
            }
        }
    }

    for (count in counts.values) {
        if (count > 1) {
            k += count - 1
        }
    }

    return k
}