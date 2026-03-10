package org.wikipedia.lesson10.homework

import com.kaspersky.components.kautomator.screen.UiScreen


import com.kaspersky.components.kautomator.component.text.UiTextView

object AppLanguagesScreen: UiScreen<AppLanguagesScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val headerText = UiTextView {
        withId(this@AppLanguagesScreen.packageName, "section_header_text")
    }

    val addLanguageButton = UiTextView {
        withId(this@AppLanguagesScreen.packageName, "wiki_language_title")
        withText("Add language")
    }

    val languageTitleRus = UiTextView {
        withId(this@AppLanguagesScreen.packageName, "wiki_language_title")
        withText("Русский")
    }

    val languageTitleDeutsch = UiTextView {
        withId(this@AppLanguagesScreen.packageName, "wiki_language_title")
        withText("Deutsch")
    }

//    val addLanguageImage = UiView {
//        withClassName(this@AppLanguagesScreen.packageName, "android.widget.ImageView")
//    }

}