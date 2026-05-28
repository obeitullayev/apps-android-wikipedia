package org.wikipedia.lesson18.homework.exploreScreen

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.invokeAtIndex
import org.wikipedia.lesson18.homework.baseElements.invokeByIndex
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.baseElements.withParent
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingItem
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed.pager

class TopReadItemNamed(matcher: Matcher<View>) : KRecyclerItem<TopReadItemNamed>(matcher) {

    val headerMenu by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Иконка"))
    }
    val headerTitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Тайтл заголовка"))
    }
    val moreLink by lazy {
        KTextView(matcher) {
            withId(R.id.footerActionButton)
        }.name(withParent("Ссылка"))
    }
    val items by lazy {
        KRecyclerView(
            parent = matcher,
            builder = { withId(R.id.view_list_card_list) },
            itemTypeBuilder = {
                itemType(::TopReadRecyclerNamed)
            }
        ).name(withParent("Список в TopRead"))
    }

    fun itemPosition(index: Int, fnc: TopReadRecyclerNamed.() -> Unit) {
        items.invokeAtIndex<TopReadRecyclerNamed>(index, fnc)
    }
}

class TopReadRecyclerNamed(matcher: Matcher<View>) : KRecyclerItem<TopReadRecyclerNamed>(matcher) {

    val number by lazy {
        KTextView(matcher) {
            withId(R.id.numberView)
        }.name(withParent("Текстовый номер"))
    }
    val header by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.name(withParent("Заголовок"))
    }
    val subtitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_subtitle)
        }.name(withParent("Подзаголовок"))
    }
    val graph by lazy {
        KView(matcher) {
            withId(R.id.view_list_card_item_graph)
        }.name(withParent("График"))
    }
    val pageViews by lazy {
        KView(matcher) {
            withId(R.id.view_list_card_item_pageviews)
        }.name(withParent("Кол-во просмотров"))
    }
    val image by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_item_image)
        }.name(withParent("Картинка"))
    }
    val baseNumber by lazy {
        KTextView(matcher) {
            withId(R.id.baseNumberView)
        }.name(withParent("Номер"))
    }
}