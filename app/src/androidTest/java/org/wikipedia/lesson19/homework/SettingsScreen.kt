package org.wikipedia.lesson19.homework

import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.NamedScreen
import org.wikipedia.lesson18.homework.baseElements.invokeAtIndex
import org.wikipedia.lesson18.homework.baseElements.invokeWithText
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.baseElements.withParent
import org.wikipedia.lesson18.homework.exploreScreen.CustomizeItemNamed
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed.items
import org.wikipedia.lesson18.homework.exploreScreen.TopReadRecyclerNamed

object SettingsScreenNamed : NamedScreen<SettingsScreenNamed>() {

    override val screenName  = "Настройки"
    override val layoutId = null
    override val viewClass = null

    val items by lazy {
        KRecyclerView(
            builder = { withId(R.id.recycler_view) },
            itemTypeBuilder = {
                itemType(::SettingsItemNamed)
            }
        ).name(withParent("Список в настройках"))
    }

    fun itemSettingsByText(text: String, fnc: SettingsItemNamed.() -> Unit){
        items.invokeWithText(text, fnc)
    }

    fun itemSettingsByIndex( fnc: SettingsItemNamed.() -> Unit){
        items.invokeAtIndex<SettingsItemNamed>(3, fnc)
    }
}
class SettingsItemNamed(matcher: Matcher<View>) : KRecyclerItem<SettingsItemNamed>(matcher){

    val title1 by lazy {
        KTextView() {
            withText("Show link previews")
        }.name(withParent("Тайтл"))
    }

    val showLinkCheckBox by lazy {
        KCheckBox(matcher) {
            withId(R.id.switchWidget)
        }.name(withParent("Чекбокс"))
    }

}