package org.wikipedia.lesson8.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsItem(matcher: Matcher<View>) : KRecyclerItem<NewsItem>(matcher) {

    val header = KTextView (matcher) {
        withId(R.id.view_card_header_title)
        isInstanceOf(MaterialTextView::class.java)
    }

    val icon = KImageView (matcher) {
        withId(R.id.view_list_card_header_menu)
        isInstanceOf(AppCompatImageView::class.java)
        isDisplayed()
    }

    val items = KRecyclerView (
        builder = {withId( R.id.view_list_card_list)},
        itemTypeBuilder = {
            itemType(::NewsRecycler)
        }
    )
}

