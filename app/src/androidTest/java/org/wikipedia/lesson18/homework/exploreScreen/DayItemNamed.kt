package org.wikipedia.lesson18.homework.exploreScreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.baseElements.withParent

class DayItemNamed(matcher: Matcher<View>) : KRecyclerItem<DayItemNamed>(matcher) {

    val text by lazy {
        KTextView(matcher) {
            withId(R.id.day_header_text)
        }.name(withParent("Текст карточки даты"))
    }
}