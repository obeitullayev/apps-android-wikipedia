package org.wikipedia.lesson11.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson09.homework.FeaturedArticleCustomize

class FeaturedArticle(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticle>(matcher) {

    val titleText = KTextView(matcher) {
        withId(R.id.articleTitle)
    }

}