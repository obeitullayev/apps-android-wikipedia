package org.wikipedia.lesson19.homework

import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.lesson18.homework.baseElements.getName
import org.wikipedia.lesson23.homework.KWebViewElement

// Шаги действий
class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun click(element: KWebViewElement) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }
}
