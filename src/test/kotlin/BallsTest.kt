import domain.Ball
import domain.Balls
import domain.MatchStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BallsTest {

    @Test
    fun `공 낫싱 테스트`() {
        val balls = Balls(listOf(1, 2, 3))
        val userBall = Ball(1, 4)
        val matchStatus = balls.match(userBall)
        assertThat(matchStatus).isEqualTo(MatchStatus.NOTHING)
    }

    @Test
    fun `공 볼 테스트`() {
        val balls = Balls(listOf(1, 2, 3))
        val userBall = Ball(1, 3)
        val matchStatus = balls.match(userBall)
        assertThat(matchStatus).isEqualTo(MatchStatus.BALL)
    }

    @Test
    fun `공 스트라이크 테스트`() {
        val balls = Balls(listOf(1, 2, 3))
        val userBall = Ball(1, 1)
        val matchStatus = balls.match(userBall)
        assertThat(matchStatus).isEqualTo(MatchStatus.STRIKE)
    }

    @Test
    fun `Balls 생성시 중복되는 숫자가 있는 경우 예외 발생`() {
        val list = listOf(1, 2, 2)
        assertThrows<IllegalArgumentException> {
            Balls(list)
        }
    }

    @Test
    fun `Balls 생성시 정수 리스트가 3개가 아닌 경우`() {
        val list = listOf(1, 2, 3, 4)
        assertThrows<IllegalArgumentException> {
            Balls(list)
        }
    }
}