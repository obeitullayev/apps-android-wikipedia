package org.wikipedia.lesson18.homework.onboardingScreen

import android.view.View
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.R.*
import org.wikipedia.lesson18.homework.baseElements.NamedScreen
import org.wikipedia.lesson18.homework.baseElements.invokeAtIndex
import org.wikipedia.lesson18.homework.baseElements.invokeByIndex
import org.wikipedia.lesson18.homework.baseElements.invokeWithText
import org.wikipedia.lesson18.homework.baseElements.name
import org.wikipedia.lesson18.homework.baseElements.withParent
import org.wikipedia.views.AppTextView

object OnboardingScreenNamed : NamedScreen<OnboardingScreenNamed>() {

    override val screenName = "Экран онбординга"
    override val layoutId = null
    override val viewClass = null

    val titleRU by lazy {
        KTextView {
            withId(id.option_label)
            containsText("Русский")
        }.name(withParent("элемент списка"))
    }

    val titleDE by lazy {
        KTextView {
            withId(id.option_label)
            containsText("Deutsch")
        }.name(withParent("элемент списка"))
    }

    val skipButton by lazy {
        KButton {
            withId(id.fragment_onboarding_skip_button)
        }.name(withParent("Кнопка Skip"))
    }

   val addLanguageButton by lazy {
        KButton {
            withId(id.addLanguageButton)
        }.name(withParent("Кнопка Add Language"))
    }

    val continueButton by lazy {
        KButton {
            withId(id.fragment_onboarding_forward_button)
        }.name(withParent("Кнопка Continue"))
    }

    val doneButton by lazy {
        KButton {
            withId(id.fragment_onboarding_done_button)
        }.name(withParent("Кнопка Get Started"))
    }

    val primaryText by lazy {
        KTextView {
            withId(id.primaryTextView)
        }.name(withParent("Текст primary"))
    }

    val pager by lazy {
        KViewPager2(
            builder = {
                withId(id.fragment_pager)
            },
            itemTypeBuilder = {
                itemType(::OnboardingItem)
            }
        ).name(withParent("Слайдер"))
    }

//    val items by lazy {
//        KRecyclerView(
//            builder = {
//                withId(id.languagesList)
//            },
//            itemTypeBuilder = {
//                itemType(::ItemLanguage)
//            }
//        ).name(withParent("Список языков"))
//    }

    // В OnboardinScreen можем добавить обёртку для доступа к слайдам
    fun page(index: Int, fnc: OnboardingItem.() -> Unit) {
        pager.invokeByIndex(index, fnc)
    }

//    fun languageItem(index: Int, fnc: ItemLanguage.() -> Unit) {
//        items.invokeAtIndex<ItemLanguage>(index, fnc)
//    }
//
//    fun languageItemText(index: String, fnc: ItemLanguage.() -> Unit) {
//        items.invokeWithText<ItemLanguage>(index, fnc)
//    }
}

//class ItemLanguage(matcher: Matcher<View>) : KRecyclerItem<ItemLanguage>(matcher){
//
//    val title by lazy {
//        KTextView(matcher) {
//            withClassName("org.wikipedia.alpha.ui.view.AppTextView")
////            withId(R.id.option_label)
////            containsText("Deutsch")
//        }.name(withParent("элемент списка"))
//    }
//
//}

