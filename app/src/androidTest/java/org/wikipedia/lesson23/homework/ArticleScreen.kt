package org.wikipedia.lesson23.homework

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
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

    val button by lazy {
        KButton{
//            withId(R.id.buttonView)
            withText(R.string.onboarding_got_it)
        }
    }

//    val title by lazy {
//        KWebViewElement(
//            webView,
//            "//h1")
//            .name(withParent("Заголовок"))
//    }

    val title by lazy {
        webView.withXPath("//h1")
            .name(withParent("Заголовок"))
    }

    val image by lazy {
        KImageView {withId(R.id.view_page_header_image)}
    }

    val references by lazy {
        webView.withXPath("//*[@id=\"References\"]")
            .name(withParent("Блок References"))
    }

    val referencesList by lazy {
        KWebViewList(webView, "(//ol)[2]")
            .name(withParent("Список"))
    }

    fun referencesItem(index: Int, fnc: ReferencesItem.() -> Unit){
        referencesList.childAt(index, fnc)
    }
}