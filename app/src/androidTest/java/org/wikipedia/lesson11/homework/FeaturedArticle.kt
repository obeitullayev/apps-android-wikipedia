package org.wikipedia.lesson11.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.web.KWebView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson09.homework.FeaturedArticleCustomize

class FeaturedArticle(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticle>(matcher) {

    val titleText = KTextView {
        withId(R.id.articleTitle)
    }

    val webView = KWebView {
        withId(R.id.page_web_view)
    }


}