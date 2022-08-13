package domain

class Ball(position: Int, ballNumber: Int) {

    private val ballNumber: BallNumber
    private val position: Int

    init {
        this.ballNumber = BallNumber(ballNumber)
        this.position = position
    }

    fun match(targetBall: Ball): MatchStatus {
        if (isEqualBallNumber(targetBall)) {
            return MatchStatus.BALL
        }
        return MatchStatus.NOTHING
    }

    private fun isEqualBallNumber(targetBall: Ball): Boolean {
        return this.ballNumber == targetBall.ballNumber
    }
}