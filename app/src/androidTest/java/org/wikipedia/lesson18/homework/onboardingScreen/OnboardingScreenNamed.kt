package org.wikipedia.lesson18.homework.onboardingScreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.homework.baseElements.NamedScreen
import org.wikipedia.lesson18.homework.baseElements.invokeByIndex
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.baseElements.withParent

object OnboardingScreenNamed : NamedScreen<OnboardingScreenNamed>() {

    override val screenName = "Экран онбординга"
    override val layoutId = null
    override val viewClass = null

    val skipButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_skip_button)
        }.name(withParent("Кнопка Skip"))
    }

    val continueButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_forward_button)
        }.name(withParent("Кнопка Continue"))
    }

    val doneButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_done_button)
        }.name(withParent("Кнопка Get Started"))
    }

    val primaryText by lazy {
        KTextView {
            withId(R.id.primaryTextView)
        }.name(withParent("Текст primary"))
    }

    val pager by lazy {
        KViewPager2(
            builder = {
                withId(R.id.fragment_pager)
            },
            itemTypeBuilder = {
                itemType(::OnboardingItem)
            }
        ).name(withParent("Слайдер"))
    }

    // В OnboardinScreen можем добавить обёртку для доступа к слайдам
    fun page(index: Int, fnc: OnboardingItem.() -> Unit) {
        pager.invokeByIndex(index, fnc)
    }
}


class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<LanguageItem>(matcher), TextViewAssertions

