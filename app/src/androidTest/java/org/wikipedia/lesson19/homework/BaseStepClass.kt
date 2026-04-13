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

class StepDefinitions(private val testContext: TestContext<*>) {

    fun click(step: String, element: BaseActions) {
        execute(step) {
            element.click()
        }
    }

    fun isDisplayed(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisplayed()
        }
    }

    fun hasText(step: String, element: TextViewAssertions, text: String, isSubstring: Boolean) {
        execute(step) {
            if (isSubstring) {
                element.containsText(text)
            } else {
                element.hasText(text)
            }
        }
    }

    fun doesNotExist(step: String, element: BaseAssertions) {
        execute(step) {
            element.doesNotExist()
        }
    }

    private fun execute(step: String, fnc: () -> Unit) {
        testContext.step(step) {
            fnc()
        }
    }
}