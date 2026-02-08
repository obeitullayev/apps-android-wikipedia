package org.wikipedia.lesson03

import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.R
import org.wikipedia.views.AppTextView

val skipButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_skip_button,
    R.string.onboarding_skip
)
val continueButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_forward_button,
    R.string.onboarding_continue
)
val pageIndicator = listOf(TabLayout::class.java, R.id.view_onboarding_page_indicator)
val scrollView = listOf(NestedScrollView::class.java, R.id.scoreView)
val imageCentered = listOf(AppCompatImageView::class.java, R.id.imageViewCentered)
val primaryText =
    listOf(AppTextView::class.java,
        R.id.primaryTextView,
        R.string.onboarding_welcome_title_v2)

val secondaryText = listOf(
    AppTextView::class.java,
    R.id.secondaryTextView,
    R.string.onboarding_multilingual_secondary_text
)
val labelOption = listOf(AppTextView::class.java, R.id.option_label)
val languageList = listOf(RecyclerView::class.java, R.id.languagesList)
val addLanguageButton = listOf(
    MaterialButton::class.java,
    R.id.addLanguageButton,
    R.string.onboarding_multilingual_add_language_text
)

