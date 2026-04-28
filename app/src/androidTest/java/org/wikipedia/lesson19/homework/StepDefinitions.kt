package org.wikipedia.lesson19.homework

import android.widget.Checkable
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson23.homework.KWebViewElement

class StepDefinitions(private val testContext: TestContext<*>) {

    fun click(step: String, element: BaseActions) {
        execute(step) {
            element.click()
        }
    }

    fun click(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction { click() }
        }
    }

    fun isDisplayed(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisplayed()
        }
    }

    fun isDisplayed(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction { scroll() }
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

    fun hasText(step: String, element: KWebViewElement, text: String, isSubstring: Boolean) {
        execute(step) {
            if (isSubstring) {
                element.performWebViewAction { containsText(text) }
            } else {
                element.performWebViewAction { hasText(text) }
            }
        }
    }

    fun isChecked(step: String, element: CheckableAssertions) {
        execute(step) {
            element.isChecked()
        }
    }

    fun isNotChecked(step: String, element: CheckableAssertions) {
        execute(step) {
            element.isNotChecked()
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