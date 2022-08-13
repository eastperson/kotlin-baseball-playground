import domain.Ball
import domain.MatchStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BallTest {

    @Test
    fun `볼은 1~9 이외의 숫자를 입력했을 때 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Ball(position = 1, ballNumber = 10)
        }
    }

    @Test
    fun `볼의 숫자가 다르면 Nothing 이다`() {
        val ball = Ball(position = 1, ballNumber = 3)
        val targetBall = Ball(position = 1, ballNumber = 4)
        assertThat(ball.match(targetBall)).isEqualTo(MatchStatus.NOTHING)
    }

    @Test
    fun `볼의 위치는 다르지만 숫자가 같으면 ball 이다`() {
        val ball = Ball(position = 1, ballNumber = 3)
        val targetBall = Ball(position = 2, ballNumber = 3)
        assertThat(ball.match(targetBall)).isEqualTo(MatchStatus.BALL)
    }
}