package domain

import java.lang.Integer.parseInt

class BaseBallInputString(input: String) {

    private val integerList: List<Int>

    init {
        val array = Array(input.length) { input[it].toString() }
        validate(array)
        this.integerList = array.map { parseInt(it) }.toList()
    }

    private fun validate(array: Array<String>) {
        if (array.size != 3) {
            throw IllegalArgumentException("숫자는 3자리만 입력해야 합니다.")
        }
        try {
            array.forEach { parseInt(it) }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자만 입력해야 합니다.")
        }
    }

    fun integerList() = this.integerList
}