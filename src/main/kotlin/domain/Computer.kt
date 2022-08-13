package domain

class Computer {

    private lateinit var balls: Balls

    init {
        generateRandomBalls()
    }

    private fun generateRandomBalls() {
        val range = (1..9)
        val set = mutableSetOf<Int>()
        while (set.size < 3) {
            set.add(range.random())
        }
        this.balls = Balls(set.toList())
    }

    fun match(numbers: List<Int>) = this.balls.match(Balls(numbers))
}