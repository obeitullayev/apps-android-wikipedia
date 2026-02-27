package org.wikipedia.lesson8.homework

import android.view.View
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class DayItem(matcher: Matcher<View>) : KRecyclerItem<DayItem>(matcher) {

    val text = KTextView (matcher) {
        withId(R.id.day_header_text)
        isInstanceOf(MaterialTextView::class.java)
    }
}