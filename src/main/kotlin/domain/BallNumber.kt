package domain

class BallNumber(ballNumber: Int) {

    private val number: Int

    init {
        validate(ballNumber)
        this.number = ballNumber
    }

    private fun validate(ballNumber: Int) {
        if (9 < ballNumber || ballNumber < 1) {
            throw IllegalArgumentException("공의 숫자는 0보다 크고 10보다 작은 정수여야 합니다.")
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