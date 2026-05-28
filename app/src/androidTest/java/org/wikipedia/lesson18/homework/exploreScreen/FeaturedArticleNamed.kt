package org.wikipedia.lesson18.homework.exploreScreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.web.KWebView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.baseElements.withParent

class FeaturedArticleNamed(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticleNamed>(matcher)  {

    val titleText by lazy {
        KTextView {
            withId(R.id.articleTitle)
        }.name(withParent("Текст"))
    }


    val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }
}