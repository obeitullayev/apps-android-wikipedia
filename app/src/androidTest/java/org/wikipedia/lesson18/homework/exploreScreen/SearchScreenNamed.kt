package org.wikipedia.lesson18.homework.exploreScreen

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.SearchView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.searchview.KSearchView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.baseElements.withParent

class SearchItemNamed(matcher: Matcher<View>) : KRecyclerItem<SearchItemNamed>(matcher) {

    val icon by lazy {
        KImageView(matcher) {
            withIndex(0) {
                isInstanceOf(AppCompatImageView::class.java)
            }
        }.name(withParent("Иконка поиска"))
    }

    val searchField by lazy {
        KImageView(matcher) {
            withId( R.id.search_card)
        }.name(withParent("  поиск"))
    }

    val searchInput by lazy {
        KEditText(matcher){
            withParent {
                    R.id.search_container
                    }
            isInstanceOf(SearchView.SearchAutoComplete::class.java)
        }
    }

    val text by lazy {
        KTextView(matcher) {
            withText(R.string.search_hint)
        }.name(withParent("Текст плейсхолдера"))
    }

    val voiceIcon by lazy {
        KImageView(matcher) {
            withId(R.id.voice_search_button)
        }.name(withParent("Иконка голосового поиска"))
    }
}