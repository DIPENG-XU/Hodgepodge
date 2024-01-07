package utils

object TextUtils {
    /**
     * It's equaled with "str".repeat(times)
     */
    operator fun String.times(num: Int): String {
        var value = ""
        for (i in 0 until num) {
            value += this
        }
        return value
//        return this.repeat(num)
    }
}