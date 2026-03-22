package org.wikipedia.lesson12.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ReferencePage : KScreen<ReferencePage>() {
    override val layoutId: Int?= null
    override val viewClass: Class<*>?=null

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

    val containerBottomSheet = KView{
        withId(R.id.container)
    }

}

