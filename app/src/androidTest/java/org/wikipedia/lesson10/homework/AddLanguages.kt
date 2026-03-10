package org.wikipedia.lesson10.homework


import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.screen.UiScreen


import com.kaspersky.components.kautomator.component.text.UiTextView

object AddLanguagesScreen: UiScreen<AddLanguagesScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val pageContent = UiView {
        withId(this@AddLanguagesScreen.packageName, "content")
    }

    val addLanguageRus = UiTextView {
        withText( "Русский")
    }

    val addLanguageDeutsch = UiTextView {
        withText( "Deutsch")
    }

    val languageListItem = UiView {
        withClassName("org.wikipedia.alpha.ui.view.LanguageListItemView")
    }

}