import domain.Ball
import domain.Balls
import domain.MatchStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BallsTest {

    @Test
    fun `공 낫싱 테스트`() {
        val balls = Balls(listOf(1, 2, 3))
        val userBall = Ball(1, 4)
        val matchStatus = balls.match(userBall)
        assertThat(matchStatus).isEqualTo(MatchStatus.NOTHING)
    }
}