package org.wikipedia.lesson8.homework

import android.view.View
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeItem>(matcher) {

    val image = KImageView (matcher) {
        withId(R.id.view_announcement_header_image)
    }

    val text = KTextView (matcher) {
        withId(R.id.view_announcement_text)
    }

    val customizeButton = KButton (matcher) {
        withId(R.id.view_announcement_action_positive)
    }

    val button = KButton (matcher) {
        withId(R.id.view_announcement_action_negative)
    }
}