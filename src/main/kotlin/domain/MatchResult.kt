package domain

class MatchResult(matchStatusList: List<MatchStatus>) {

    private val strike: Int
    private val ball: Int

    init {
        var strike = 0
        var ball = 0
        matchStatusList.forEach {
            when(it) {
                MatchStatus.STRIKE -> strike++
                MatchStatus.BALL -> ball++
                else -> {}
            }
        }
        this.strike = strike
        this.ball = ball
    }

    fun isNothing(): Boolean {
        return strike == 0 && ball == 0
    }
}