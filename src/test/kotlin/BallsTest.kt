import domain.Balls
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BallsTest {

    @Test
    fun `3개의 정수를 원소로 가진 리스트를 순서대로 Ball 리스트로 만든다`() {
        val balls = Balls(listOf(4, 5, 6))
    }
}