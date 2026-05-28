package org.wikipedia.lesson18.homework.exploreScreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.baseElements.withParent
import org.wikipedia.lesson8.homework.NewsRecycler

class NewsItemNamed(matcher: Matcher<View>) : KRecyclerItem<NewsItemNamed>(matcher) {

    val header by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Тайтл заголовка"))
    }
    val icon by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Иконка"))
    }
    val items by lazy {
        KRecyclerView(
            parent = matcher,
            builder = { withId(R.id.view_list_card_list) },
            itemTypeBuilder = {
                itemType(::NewsRecycler)
            }
        ).name(withParent("Список новостей"))
    }
}