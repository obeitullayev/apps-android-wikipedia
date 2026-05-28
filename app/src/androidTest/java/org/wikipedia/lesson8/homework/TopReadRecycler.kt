package org.wikipedia.lesson8.homework

import android.view.View
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadRecycler(matcher: Matcher<View>) : KRecyclerItem<TopReadRecycler>(matcher) {

    val number = KTextView (matcher) {
        withId(R.id.numberView)
    }

    val header = KTextView (matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val subtitle = KTextView (matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }

    val graph = KView (matcher) {
        withId(R.id.view_list_card_item_graph)
    }

    val pageViews = KView (matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }

    val image = KImageView (matcher) {
        withId(R.id.view_list_card_item_image)
    }

    val baseNumber = KTextView (matcher){
        withId(R.id.baseNumberView)
    }
}