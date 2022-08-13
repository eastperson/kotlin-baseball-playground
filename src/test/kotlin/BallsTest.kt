import domain.Ball
import domain.Balls
import domain.MatchStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BallsTest {

    private lateinit var balls: Balls

    @BeforeEach
    internal fun setUp() {
        balls = Balls(listOf(1, 2, 3))
    }

    @Test
    fun `공 낫싱 테스트`() {
        val userBall = Ball(1, 4)
        val matchStatus = balls.match(userBall)
        assertThat(matchStatus).isEqualTo(MatchStatus.NOTHING)
    }

    @Test
    fun `공 볼 테스트`() {
        val userBall = Ball(1, 3)
        val matchStatus = balls.match(userBall)
        assertThat(matchStatus).isEqualTo(MatchStatus.BALL)
    }

    @Test
    fun `공 스트라이크 테스트`() {
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

    @Test
    fun `Balls 간 비교 낫싱`() {
        val targetBalls = Balls(listOf(4, 5, 6))
        val matchResult = balls.match(targetBalls)
        assertThat(matchResult.isNothing()).isTrue()
    }

    @Test
    fun `Balls 간 비교 2볼 1스트라이크`() {
        val targetBalls = Balls(listOf(3, 2, 1))
        val matchResult = balls.match(targetBalls)
        assertThat(matchResult.strike()).isEqualTo(1)
        assertThat(matchResult.ball()).isEqualTo(2)
    }

    @Test
    fun `Balls 간 비교 3스트라이크`() {
        val targetBalls = Balls(listOf(1, 2, 3))
        val matchResult = balls.match(targetBalls)
        assertThat(matchResult.success()).isTrue()
    }
}