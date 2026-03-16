package org.wikipedia.lesson09.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class FeaturedArticleCustomize(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticleCustomize>(matcher) {

    val titleText = KTextView (matcher) {
        withId(R.id.feed_content_type_title)
    }

    val subtitleText = KTextView (matcher) {
        withId(R.id.feed_content_type_subtitle)
    }

    val switcher = KSwitch (matcher) {
        withId(R.id.feed_content_type_checkbox)
    }

    val dragImage = KImageView (matcher) {
        withId(R.id.feed_content_type_drag_handle)
    }
}