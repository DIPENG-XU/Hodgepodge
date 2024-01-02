package classicalTopic

import classicalTopic.EightQueenByMe.Companion.toChess
import utils.TextUtils.times
import kotlin.math.abs

class EightQueenByMe(
    private val size: Int,
) {
    /**
     * @return All solutions. Each solution is List<Int>, whose index of the element represents the X-axis position and the value represents the Y-axis position
     */
    fun solve(): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()
        for (start in 0 until size) {
            backTracking(result, mutableListOf(), 0, start)
        }
        return result
    }

    private fun backTracking(
        results: MutableList<List<Int>>,
        result: List<Int>,
        currentXAxis: Int,
        currentYAxis: Int,
    ) {
        if (isConfirm(result, currentXAxis, currentYAxis)) return
        for (nextYAxis in 0 until size) {
            val nextResult = result + currentYAxis
            if (nextResult.size >= size) {
                results.add(nextResult)
                return
            }
            backTracking(results, nextResult, currentXAxis + 1, nextYAxis)
        }
    }

    private fun isConfirm(result: List<Int>, currentXAxis: Int, currentYAxis: Int): Boolean {
        for (cursorXAxis in 0 until currentXAxis) {
            val cursorYAxis = result.getOrNull(cursorXAxis) ?: return true
            if ((abs(cursorYAxis - currentYAxis) == abs(cursorXAxis - currentXAxis)) || (cursorYAxis == currentYAxis)) {
                return true
            }
        }
        return false
    }

    companion object {
        fun List<Int>.toChess(): Array<String> {
            val result = Array(size = this.size) { _ -> "X" }
            this.forEachIndexed { xAxis, yAxis ->
                val text = ("X" * xAxis + "Q" + "X" * (size - xAxis - 1))
                result[size - yAxis - 1] = text
            }
            return result
        }
    }
}

fun main() {
    val results = EightQueenByMe(8).solve()
    results.forEach {
        println(it)
        it.toChess().forEach { column ->
            println(column)
        }
        println("--------------")
    }
    println(results.size)
}