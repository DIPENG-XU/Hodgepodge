package classicalTopic

import kotlin.math.pow


class WordSet(
    private val parentSet: List<Int>,
) {
    private fun getParentSet(): List<Int> = this.parentSet.sorted()


    /**
     * @return all the subset
     */
    fun solve(): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        backTracking(results, mutableListOf(), 0)
        return results
    }

    private fun backTracking(
        results: MutableList<List<Int>>,
        result: List<Int>,
        nextIndex: Int,
    ) {
        results.add(result)
        for (index in nextIndex..getParentSet().size) {
            backTracking(
                results,
                result + (getParentSet().getOrNull(index) ?: return),
                index + 1,
            )
        }
    }
}

fun main() {
    val parentSet = listOf(2, 3, 5, 6, 8)
    val result = WordSet(parentSet).solve()
    result.forEach { subSet ->
        println(subSet)
        println("---------")
    }

    println("Actual subset length is ${result.size}")
    println("Predicted subset length is ${(2.0).pow(parentSet.size).toInt()}")
}