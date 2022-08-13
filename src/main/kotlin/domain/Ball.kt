package domain

class Ball(position: Int, ballNumber: Int) {

    private val ballNumber: BallNumber
    private val position: Int

    init {
        this.ballNumber = BallNumber(ballNumber)
        this.position = position
    }
}