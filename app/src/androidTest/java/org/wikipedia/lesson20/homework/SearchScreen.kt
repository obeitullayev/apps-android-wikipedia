package org.wikipedia.lesson20.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.SearchView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.searchview.KSearchView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson11.homework.FeaturedArticle
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed.withParent
import org.wikipedia.lesson8.homework.CustomizeItem
import org.wikipedia.lesson8.homework.DayItem
import org.wikipedia.lesson8.homework.NewsItem
import org.wikipedia.lesson8.homework.SearchItem
import org.wikipedia.lesson8.homework.TopReadItem
import org.wikipedia.views.SearchAndFilterActionProvider

object SearchScreen: KScreen<SearchScreen>() {
    override val layoutId = R.layout.view_search_and_filter
    override val viewClass = SearchAndFilterActionProvider::class.java


    val icon by lazy {
        KImageView() {
            withIndex(0) {
                isInstanceOf(AppCompatImageView::class.java)
            }
        }.name(withParent("Иконка поиска"))
    }

    val searchField by lazy {
        KImageView() {
            withId( R.id.search_card)
        }.name(withParent("  поиск"))
    }

    val searchInput by lazy {
        KEditText(){
            withParent {
                R.id.search_container
            }
            isInstanceOf(SearchView.SearchAutoComplete::class.java)
        }
    }

    val text by lazy {
        KTextView() {
            withText(R.string.search_hint)
        }.name(withParent("Текст плейсхолдера"))
    }


    val historyTitle = KTextView {
        withId(R.id.history_title)
    }

    val historyEmptyImage = KImageView {
        withId(R.id.history_empty_image)
    }


}
