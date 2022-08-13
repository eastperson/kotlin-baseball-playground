package domain

class Ball(position: Int, ballNumber: Int) {

    private val ballNumber: BallNumber
    private val position: Int

    init {
        this.ballNumber = BallNumber(ballNumber)
        this.position = position
    }

    fun match(targetBall: Ball): MatchStatus {
        if (this == targetBall) {
            return MatchStatus.STRIKE
        }
        if (isEqualBallNumber(targetBall)) {
            return MatchStatus.BALL
        }
        return MatchStatus.NOTHING
    }

    private fun isEqualBallNumber(targetBall: Ball): Boolean {
        return this.ballNumber == targetBall.ballNumber
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Ball

        if (ballNumber != other.ballNumber) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = ballNumber.hashCode()
        result = 31 * result + position
        return result
    }
}