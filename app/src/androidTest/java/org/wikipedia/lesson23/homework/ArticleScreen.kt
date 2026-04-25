package org.wikipedia.lesson23.homework

import org.wikipedia.R
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.lesson18.homework.baseElements.NamedScreen

object ArticleScreen: NamedScreen<ArticleScreen>() {
    override val screenName = "Экран статьи"

    private val webView by lazy {
        KWebView{
            withId(R.id.page_web_view)
        }
    }

//    val title by lazy {
//        webView.withXPath("//h1").name(withParent("Заголовок"))
//    }

}