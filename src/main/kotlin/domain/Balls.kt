package domain

class Balls(ballsNumbers: List<Int>) {

    private val balls: List<Ball>

    init {
        validate(ballsNumbers)
        val mutableListOf = mutableListOf<Ball>()
        ballsNumbers.forEachIndexed {  index, number -> mutableListOf.add(Ball(index + 1, number)) }
        this.balls = mutableListOf.toList()
    }

    fun match(targetBalls: Balls): MatchResult {
        val matchStatusList = mutableListOf<MatchStatus>()
        targetBalls.balls.forEach {
            matchStatusList.add(this.match(it))
        }
        return MatchResult(matchStatusList.toList())
    }

    fun match(targetBall: Ball): MatchStatus {
        this.balls.forEach {
            val resultStatus = it.match(targetBall)
            if (resultStatus == MatchStatus.STRIKE || resultStatus == MatchStatus.BALL) {
                return resultStatus
            }
        }
        return MatchStatus.NOTHING
    }

    private fun validate(ballsNumbers: List<Int>) {
        val toSet = ballsNumbers.toSet()
        if (ballsNumbers.size != 3 || toSet.size != 3) {
            throw IllegalArgumentException("정수 숫자가 3개이면서 중복되는 숫자가 있으면 안됩니다")
        }
    }
}