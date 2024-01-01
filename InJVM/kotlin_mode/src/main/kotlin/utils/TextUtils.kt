package utils

object TextUtils {
    operator fun String.times(num: Int): String {
        var value = ""
        for (i in 0 until num) {
            value += this
        }
        return value
    }
}