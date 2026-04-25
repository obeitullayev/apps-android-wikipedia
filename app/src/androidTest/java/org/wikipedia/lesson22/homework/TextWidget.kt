package org.wikipedia.lesson22.homework

import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.baseElements.withParent

class TextWidget  : KWidget<TextWidget>({withId(R.id.textSettingsCategory)}) {

    val textSize by lazy {
        KTextView() {
            withId( R.id.text_size_percent)
        }.name(withParent("размер текста"))
    }

    val textButtonDecrease by lazy {
        KTextView() {
            withId( R.id.buttonDecreaseTextSize)
        }.name(withParent("кнопка уменьшения текста"))
    }

    val textButtonIncrease by lazy {
        KTextView() {
            withId( R.id.buttonIncreaseTextSize)
        }.name(withParent("кнопка увеличения текста"))
    }

    val textSeekBar by lazy {
        KTextView() {
            withId( R.id.text_size_seek_bar)
        }.name(withParent("размер текста"))
    }

    val textSansSerif by lazy {
        KButton() {
            withId( R.id.button_font_family_sans_serif)
        }.name(withParent("текст без засечек"))
    }

    val textSerif by lazy {
        KButton() {
            withId( R.id.button_font_family_serif)
        }.name(withParent("текст с засечками"))
    }

    val readingModeSwitcher by lazy {
        KSwitch() {
            withId( R.id.button_font_family_serif)
        }.name(withParent("свитчер режим фокусировки"))
    }
}