package org.wikipedia.lesson18.homework.exploreScreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.baseElements.withParent

class CustomizeItemNamed(matcher: Matcher<View>) : KRecyclerItem<CustomizeItemNamed>(matcher) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.view_announcement_header_image)
        }.name(withParent("Картинка"))
    }
    val text by lazy {
        KTextView(matcher) {
            withId(R.id.view_announcement_text)
        }.name(withParent("Текст"))
    }
    val customizeButton by lazy {
        KButton(matcher) {
            withId(R.id.view_announcement_action_positive)
        }.name(withParent("Кнопка Customize"))
    }
    val button by lazy {
        KButton(matcher) {
            withId(R.id.view_announcement_action_negative)
        }.name(withParent("Кнопка Got It"))
    }

}