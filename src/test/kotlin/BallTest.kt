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
}