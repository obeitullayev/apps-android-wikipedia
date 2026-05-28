package org.wikipedia.lesson19.homework

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions

abstract class StepsDsl<T : StepsDsl<T>> {

    abstract val self: T

    operator fun invoke(fnc: T.() -> Unit) {
        self.fnc()
    }
}

private val steps = mutableMapOf<String, StepsDsl<*>>()

val TestContext<*>.action: Actions
    get() {
        return steps.getOrPut(getId(this, "action")) {
            Actions(StepDefinitions(this))
        } as Actions

    }

val TestContext<*>.verify: Verify
    get() {
        return steps.getOrPut(getId(this, "verify")) {
            Verify(StepDefinitions(this))
        } as Verify
    }

private fun getId(testContext: TestContext<*>, stepType: String): String {
    return "${testContext.hashCode()}-$stepType"
}
