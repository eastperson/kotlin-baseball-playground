import domain.BaseBallInputString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseBallInputStringTest{

    @Test
    fun `사용자가 입력한 문자열이 길이가 3이 아니면 예외`() {
        val string = "1234"
        assertThrows<IllegalArgumentException> {
            BaseBallInputString(string)
        }
    }

    @Test
    fun `사용자가 입력한 문자열이 정수가 아니면 예외`() {
        val string = "12ㄱ"
        assertThrows<IllegalArgumentException> {
            BaseBallInputString(string)
        }
    }

    @Test
    fun `사용자가 입력한 문자열을 리스트로 잘 받는지`() {
        val string = "123"
        val inputString = BaseBallInputString(string)
        val expected = listOf(1, 2, 3)
        assertThat(inputString.integerList()).isEqualTo(expected)
    }
}