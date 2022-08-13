package domain

class MatchResult(matchStatusList: List<MatchStatus>) {

    companion object {
        const val NOTHING_NUM = 0
        const val SUCCESS_STRIKE_NUM = 3
    }

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

    fun isNothing(): Boolean = strike == NOTHING_NUM && ball == NOTHING_NUM

    fun strike(): Int = this.strike

    fun ball(): Int = this.ball

    fun success(): Boolean = this.strike == SUCCESS_STRIKE_NUM
}