package org.wikipedia.lesson12.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object NewArticleBottomSheet : KScreen<NewArticleBottomSheet>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val titleBottomSheet = KTextView {
        withId(R.id.link_preview_title)
    }

    val imageBottomSheet = KImageView {
        withId(R.id.link_preview_thumbnail)
    }

    val baseTextBottomSheet = KImageView {
        withId(R.id.link_preview_extract)
    }

    val openInTabBottomSheetButton = KImageView {
        withId(R.id.link_preview_extract)
    }

    val readArticleBottomSheetButton = KImageView {
        withId(R.id.link_preview_extract)
    }
}