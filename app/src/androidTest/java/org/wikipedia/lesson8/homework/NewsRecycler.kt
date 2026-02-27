package org.wikipedia.lesson8.homework

import android.view.View
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsRecycler(matcher: Matcher<View>) : KRecyclerItem<NewsRecycler>(matcher) {

    val text = KTextView (matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
        isInstanceOf(MaterialTextView::class.java)
    }

    val image = KImageView (matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
        isDisplayed()
    }
}