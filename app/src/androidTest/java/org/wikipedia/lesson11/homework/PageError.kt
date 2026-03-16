package org.wikipedia.lesson11.homework

import android.view.View
import androidx.browser.R
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.lesson09.homework.FeaturedArticleCustomize

object PageErrorScreen: KScreen<PageErrorScreen>() {
    override val layoutId = null
    override val viewClass = null

    val retryButton = KButton () {
        withId(org.wikipedia.R.id.view_card_offline_button_retry)
    }

    val errorText = KTextView () {
        withText(org.wikipedia.R.string.view_offline_card_text)
    }

}
