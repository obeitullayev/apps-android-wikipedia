package org.wikipedia.lesson24.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.NamedScreen
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson24.homework.LanguageListScreen.items

//import org.wikipedia.lesson24.homework.AddLanguageScreenCompose.items

object LanguageListScreen : NamedScreen<LanguageListScreen>() {
    override val screenName = "LanguageListScreen"

    val headerText by lazy {
        KTextView{
            withId(R.id.section_header_text)
        }
    }

    val addLanguageButton by lazy {
        KButton {
            withId(R.id.wiki_language_title)
            withText("Add language")
        }.name(withParent("кнопка Add language"))
    }

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.wikipedia_languages_recycler)
                      },
            itemTypeBuilder = {
                itemType(::LanguageListItem)
            }
        ).name(withParent("Список языков"))
    }
}

class LanguageListItem(matcher: Matcher<View>) : KRecyclerItem<LanguageListItem>(matcher){
    val title by lazy {
        KTextView (matcher){
            withId(R.id.wiki_language_title)
        }
    }

    val langCode by lazy {
        KTextView (matcher) {
            withId(R.id.langCodeText)
        }
    }

    val langOrder by lazy {
        KTextView (matcher) {
            withId(R.id.wiki_language_order)
        }
    }

    val langCheckbox by lazy {
        KImageView (matcher) {
            withId(R.id.wiki_language_drag_handle)
        }
    }
}

fun itemLanguagePosition(index: Int, fnc: LanguageListItem.() -> Unit) {
    items.childAt<LanguageListItem>(index,fnc)
}
