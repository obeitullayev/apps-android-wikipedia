package org.wikipedia.lesson18.homework.baseElements

import androidx.test.espresso.matcher.ViewMatchers
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.hamcrest.Matchers.anyOf
import org.wikipedia.lesson18.homework.baseElements.NameHierarchy

private val elements = mutableMapOf<BaseActions, NameHierarchy>()

fun <T : BaseActions> T.name(nameHierarchy: NameHierarchy): T {
    elements[this] = nameHierarchy
    return this
}

fun <T : BaseActions> T.getName(): NameHierarchy {
    return elements[this] ?: NameHierarchy("NO_LABEL", null)
}

fun <T : BaseActions> T.withParent(name: String): NameHierarchy {
    return getName().withParent(name)
}




// Расширения для KRecyclerView
inline fun <reified T : KRecyclerItem<T>> KRecyclerView.getByIndex(index: Int): T {
    return childWith<T> {
        onPosition(index)
    }.name(withParent("$index"))
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.getByText(text: String): T {
    return childWith<T> {
        withMatcher(
            anyOf(
                ViewMatchers.withText(text),
                ViewMatchers.hasDescendant(ViewMatchers.withText(text))
            )
        )
    }.name(withParent(text))
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndex(index: Int, fnc: T.() -> Unit) {
    getByIndex<T>(index).fnc()
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeWithText(text: String, fnc: T.() -> Unit) {
    getByText<T>(text).fnc()
}

// Расширение для KViewPager2
inline fun <reified T : KViewPagerItem<T>> KViewPager2.invokeByIndex(index: Int, fnc: T.() -> Unit) {
    val pager = this
    childAt<T>(index) {
        name(pager.withParent("$index"))
        fnc()
    }
}

class NameHierarchy(private val name: String, private val parent: NameHierarchy? = null) {

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, this)
    }

    override fun toString(): String {
        return (parent?.let { "$it : " } ?: "") + name
    }
}

abstract class NamedScreen <T : NamedScreen<T>> : KScreen<T>() {

    abstract val screenName: String

    private val nameHierarchy by lazy {
        NameHierarchy(screenName)
    }

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, nameHierarchy)
    }
}