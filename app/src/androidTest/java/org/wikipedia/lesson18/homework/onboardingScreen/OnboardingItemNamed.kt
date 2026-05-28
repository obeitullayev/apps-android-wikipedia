package org.wikipedia.lesson18.homework.onboardingScreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.baseElements.withParent

class OnboardingItem(matcher: Matcher<View>) : KViewPagerItem<OnboardingItem>(matcher) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.imageViewCentered)
        }.name(withParent("Картинка"))
    }

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.primaryTextView)
        }.name(withParent("Заголовок"))
    }

    val addLanguageButton by lazy {
        KButton {
            withId(R.id.addLanguageButton)
        }.name(withParent("Кнопка добавления языка"))
    }


}