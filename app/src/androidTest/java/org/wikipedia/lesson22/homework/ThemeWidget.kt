package org.wikipedia.lesson22.homework

import io.github.kakaocup.kakao.switch.KSwitch
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.baseElements.withParent

class ThemeWidget : KWidget<ThemeWidget>({withId(R.id.textSettingsCategory)}) {

    val buttonThemeLight by lazy {
        KSwitch() {
            withId( R.id.button_theme_light)
        }.name(withParent("тема светлая "))
    }

    val buttonThemeDark by lazy {
        KSwitch() {
            withId( R.id.button_theme_dark)
        }.name(withParent("тема темная "))
    }

    val systemThemeSwitcher by lazy {
        KSwitch() {
            withId( R.id.theme_chooser_match_system_theme_switch)
        }.name(withParent("свитчер системная тема "))
    }

    val imageDimmingSwitcher by lazy {
        KSwitch() {
            withId( R.id.theme_chooser_dark_mode_dim_images_switch)
        }.name(withParent("свитчер затенения изображения "))
    }
}