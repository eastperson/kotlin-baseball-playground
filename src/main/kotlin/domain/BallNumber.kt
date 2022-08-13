package domain

class BallNumber(ballNumber: Int) {

    private val number: Int

    companion object {
        const val MAX_NUMBER = 9
        const val MIN_NUMBER = 1
    }

    init {
        validate(ballNumber)
        this.number = ballNumber
    }

    private fun validate(ballNumber: Int) {
        if (MAX_NUMBER < ballNumber || ballNumber < MIN_NUMBER) {
            throw IllegalArgumentException("공의 숫자는 ${MIN_NUMBER - 1}보다 크고 ${MAX_NUMBER + 1}보다 작은 정수여야 합니다.")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BallNumber

        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number
    }
}