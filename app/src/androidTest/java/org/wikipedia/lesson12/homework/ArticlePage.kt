package org.wikipedia.lesson12.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object ArticlePage : KScreen<ArticlePage>() {
    override val layoutId: Int?= null
    override val viewClass: Class<*>?=null

    val webView = KWebView {
        withId(R.id.page_web_view)
    }

    val titleBottomSheet = KTextView{
        withId(R.id.link_preview_title)
    }

    val imageBottomSheet = KImageView{
        withId(R.id.link_preview_thumbnail)
    }

    val baseTextBottomSheet = KImageView{
        withId(R.id.link_preview_extract)
    }

    val openInTabBottomSheetButton = KImageView{
        withId(R.id.link_preview_extract)
    }

    val readArticleBottomSheetButton = KImageView{
        withId(R.id.link_preview_primary_button)
    }

    val referenceTitleBottomSheet = KTextView{
        withId(R.id.reference_title_text)
    }

    val referenceIdBottomSheet = KTextView{
        withId(R.id.reference_id)
    }

    val referenceTextBottomSheet = KTextView{
        withId(R.id.reference_text)
    }

    val closePopupButton = KImageView{
        withId(R.id.closeButton)
    }

    val gotItButtonPopup = KButton{
        withId(R.id.buttonView)
    }

    val containerBottomSheet = KView{
        withId(R.id.container)
    }

}