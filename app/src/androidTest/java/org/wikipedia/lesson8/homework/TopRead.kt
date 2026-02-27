package org.wikipedia.lesson8.homework

import android.view.View
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {

    val image = KImageView (matcher) {
        withId(R.id.view_list_card_header_menu)
        isDisplayed()
    }

    val header = KTextView (matcher) {
        withId(R.id.view_card_header_title)
        isInstanceOf(MaterialTextView::class.java)
    }

    val text = KTextView (matcher) {
        withId(R.id.footerActionButton)
        isClickable()
    }

    val items = KRecyclerView (
        builder = {withId( R.id.view_list_card_list)},
        itemTypeBuilder = {
            itemType(::TopReadRecycler)
        }
    )
}