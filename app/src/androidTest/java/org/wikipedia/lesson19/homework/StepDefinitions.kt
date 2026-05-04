package org.wikipedia.lesson19.homework

import android.widget.Checkable
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson23.homework.KWebViewElement
import org.wikipedia.lesson24.homework.assertTrimmedTextIsEquals
import org.wikipedia.lesson24.homework.clickIfEnabled

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

    fun click(step: String, element: NodeActions) {
        execute(step) {
            element.clickIfEnabled()
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

    fun hasText(step: String, element: NodeAssertions, text: String) {
        execute(step) {
                element.assertTrimmedTextIsEquals ( text )
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