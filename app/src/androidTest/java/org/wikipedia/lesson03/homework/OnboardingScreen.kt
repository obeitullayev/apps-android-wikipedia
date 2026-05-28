package org.wikipedia.lesson03.homework

import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson8.homework.ExploreScreen
import org.wikipedia.views.AppTextView

object OnboardingScreen: KScreen<OnboardingScreen>() {
    override val layoutId = null
    override val viewClass = null

    val skipButton = KButton () {
        withId(R.id.fragment_onboarding_skip_button)
    }

    val continueButton = KButton () {
        withId(R.id.fragment_onboarding_forward_button)
    }

//    val pageIndicator = listOf(TabLayout::class.java, R.id.view_onboarding_page_indicator)
//    val image = listOf(AppCompatImageView::class.java, R.id.imageViewCentered)
    val primaryText = KTextView {
            withId(R.id.primaryTextView)
        }
//
//    val secondaryText = listOf(
//        AppTextView::class.java,
//        R.id.secondaryTextView,
//        R.string.onboarding_multilingual_secondary_text
//    )
//    val labelOption = listOf(AppTextView::class.java, R.id.option_label)
//    val languageList = listOf(RecyclerView::class.java, R.id.languagesList)
//    val addLanguageButton = listOf(
//        MaterialButton::class.java,
//        R.id.addLanguageButton,
//        R.string.onboarding_multilingual_add_language_text
//    )
}