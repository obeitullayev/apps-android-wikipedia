package org.wikipedia.lesson25.homework

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.junit.Test

class SmartScenarios(private val testContext: TestContext<*>) {
    fun closeGotIt() = CloseGotIt(testContext).initBehaviorRepeatedly(3)
    fun closePlayTodayGame() = ClosePlayTodayGame(testContext).initBehavior()

}

val TestContext<*>.smartScenarios: SmartScenarios
    get() = SmartScenarios(this)
