package org.wikipedia.lesson06.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object Theme : KScreen<Theme>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val headerReading = KTextView {
        withId(R.id.textSettingsCategory)
    }

    val sizePercentText = KTextView {
        withId(R.id.text_size_percent)
    }

    val decreaseText = KTextView {
        withId(R.id.buttonDecreaseTextSize)
    }

    val increaseText= KTextView {
        withId(R.id.buttonIncreaseTextSize)
    }

    val textSizeBar= KSeekBar {
        withId(R.id.text_size_seek_bar)
    }

    val buttonFontSans = KButton {
        withId(R.id.button_font_family_sans_serif)
    }

    val buttonFontSerif = KButton {
        withId(R.id.button_font_family_serif)
    }

    val appImage = KImageView {
        isDescendantOfA{
            withId(R.id.readingFocusModeContainer)}

        withoutText("focus mode")
    }

    val themeChooserFocus = KCheckBox {
        containsText("focus mode")
    }

    val themeChooserDescription = KTextView {
        withId(R.id.theme_chooser_reading_focus_mode_description)
    }

    val headerTheme = KTextView {
        containsText("Theme")
    }

    val themeButtonLight = KButton {
        withId(R.id.button_theme_light)
    }

    val themeChooserSystem = KCheckBox {
        withId(R.id.theme_chooser_match_system_theme_switch)
    }

    val themeChooserDark = KCheckBox {
        withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    }

}