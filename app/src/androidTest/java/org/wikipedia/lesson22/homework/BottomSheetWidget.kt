package org.wikipedia.lesson22.homework

import org.wikipedia.lesson18.homework.baseElements.NamedScreen
import org.wikipedia.lesson18.homework.baseElements.name

object BottomSheetWidget : NamedScreen<BottomSheetWidget>( ) {

    override val screenName = "BottomSheet"

    val themeWidget by lazy {
        ThemeWidget()
            .name(withParent("Виджет темы"))
    }

    val textWidget by lazy {
        TextWidget()
            .name(withParent("Виджет текста"))
    }
}