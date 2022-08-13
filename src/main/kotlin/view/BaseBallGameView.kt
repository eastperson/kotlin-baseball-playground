package view

import domain.BaseBallInputString
import domain.Computer
import java.lang.Integer.parseInt
import java.util.Scanner

class BaseBallGameView {

    fun start() {
        val computer = Computer()
        val scanner = Scanner(System.`in`)
        println("게임이 시작되었습니다.")
        var process = true
        while (process) {
            try {
                print("숫자를 입력해 주세요 : ")
                val nextLine = scanner.nextLine()
                println()
                val baseBallInputString = BaseBallInputString(nextLine)
                val match = computer.match(baseBallInputString.integerList())

                if (match.isNothing()) {
                    println("Nothing")
                    continue
                }

                if (match.ball() != 0) {
                    print("Ball: ${match.ball()}")
                }

                if (match.strike() != 0) {
                    print(" Strike: ${match.strike()}")
                }

                println()

                if (match.success()) {
                    println("숫자를 모두 맞추셨습니다. 수고하셨습니다.")
                    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                    val restart = parseInt(scanner.nextLine())
                    if (restart == 2) {
                        process = false
                    }
                }
            } catch (e: Exception) {
                println(e.message)
                continue
            }
        }
        println("게임이 끝났습니다.")
    }
}