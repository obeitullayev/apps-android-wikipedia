package org.wikipedia.lesson19.homework

import android.widget.Checkable
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson18.homework.baseElements.getName
import org.wikipedia.lesson23.homework.KWebViewElement

class Verify(private val steps: StepDefinitions) : StepsDsl<Verify>() {

    override val self = this

    fun isDisplayed(element: BaseAssertions) {
        steps.isDisplayed(
            "Проверяет, что отображается '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun isDisplayed(element: KWebViewElement) {
        steps.isDisplayed(
            "Проверяет, что отображается '${element.getName()}'",
            element
        )
    }


    fun hasText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' эквивалентен '$text'",
            element,
            text,
            false
        )
    }

    fun hasText(element: KWebViewElement, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${element.getName()}' эквивалентен '$text'",
            element,
            text,
            false
        )
    }

    fun containsText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' содержит подстроку '$text'",
            element,
            text,
            true
        )
    }

    fun containsText(element: KWebViewElement, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${element.getName()}' содержит подстроку '$text'",
            element,
            text,
            true
        )
    }
    
    fun isChecked(element: CheckableAssertions) {
        steps.isChecked(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' активен",
            element)
    }

    fun isNotChecked(element: CheckableAssertions) {
        steps.isNotChecked(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' не активен",
            element)
    }

    fun doesNotExist(element: BaseAssertions) {
        steps.doesNotExist(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' отсутствует",
            element
        )
    }
}