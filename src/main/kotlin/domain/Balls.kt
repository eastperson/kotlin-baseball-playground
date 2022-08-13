package domain

class Balls(ballsNumbers: List<Int>) {

    private val balls: List<Ball>

    init {
        val mutableListOf = mutableListOf<Ball>()
        ballsNumbers.forEachIndexed {  index, number -> mutableListOf.add(Ball(index, number)) }
        this.balls = mutableListOf.toList()
    }

    fun match(targetBall: Ball): MatchStatus {
        this.balls.forEach {
            val resultStatus = it.match(targetBall)
            if (resultStatus == MatchStatus.BALL) {
                return resultStatus
            }
        }
        return MatchStatus.NOTHING
    }
}