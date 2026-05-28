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

    val headerMenu = KImageView (matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val headerTitle = KTextView (matcher) {
        withId(R.id.view_card_header_title)
    }

    val moreLink = KTextView (matcher) {
        withId(R.id.footerActionButton)
    }

    val items = KRecyclerView (
        parent = matcher,
        builder = {withId( R.id.view_list_card_list)},
        itemTypeBuilder = {
            itemType(::TopReadRecycler)
        }
    )
}