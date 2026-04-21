package org.wikipedia.lesson19.homework

import androidx.compose.ui.test.hasText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.NamedScreen

object NavBarNamed : NamedScreen<NavBarNamed>() {

    override val screenName = "Навбар"
    override val layoutId = null
    override val viewClass = null

    val icon by lazy {
        KImageView() {
            withId(R.id.nav_tab_more)
        }
    }

    val moreButton by lazy {
        KTextView() {
            hasText("more")
        }
    }

    val setingsButton = KButton () {
        withId(R.id.main_drawer_settings_container)
    }

}