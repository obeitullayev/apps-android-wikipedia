package org.wikipedia.lesson10.homework

import android.icu.text.LocaleDisplayNames
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen
import io.github.kakaocup.kakao.image.KImageView


import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.uiautomator.UiCollection
import androidx.test.uiautomator.UiScrollable
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson8.homework.ExploreScreen
import org.wikipedia.views.AppTextView

object OnboardingUiScreen: UiScreen<OnboardingUiScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val skipButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val continueButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }

    val getStartedButton = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_done_button")
    }

    val pageIndicator = UiView {
        withId(this@OnboardingUiScreen.packageName, "view_onboarding_page_indicator")
    }

    val image = UiView {
        withId(this@OnboardingUiScreen.packageName, "imageViewCentered")
    }

    val primaryText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }

    val secondaryText = UiTextView {
        withId (this@OnboardingUiScreen.packageName, "secondaryTextView")
    }

    val labelOption = UiView {
        withId(this@OnboardingUiScreen.packageName, "option_label")
    }

    val languageList = UiView{
        withId(this@OnboardingUiScreen.packageName, "languagesList")
    }

    val addLanguageButton = UiButton{
        withId(this@OnboardingUiScreen.packageName,"addLanguageButton")
    }
}