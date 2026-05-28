package org.wikipedia.lesson20

import android.view.View
import android.widget.Button
import android.widget.Checkable
import android.widget.EditText
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.common.views.KBaseView
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson03.homework.OnboardingScreen
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed.customizeBlockByIndex
import org.wikipedia.lesson19.homework.NavBarNamed
import org.wikipedia.lesson19.homework.NavBarNamed.iconSearch
import org.wikipedia.lesson19.homework.NavBarNamed.invoke
import org.wikipedia.main.MainActivity

class MultiAction(private val enableText: String) : ViewAction {

    override fun getConstraints(): Matcher<View?>? {
        return ViewMatchers.isDisplayed()
    }

    override fun getDescription(): String? {
        return "Toggle on toggleable or type 'On' in text input"
    }

    override fun perform(
        uiController: UiController?,
        view: View?
    ) {
        if (view == null) return
        when (view) {
            is Button -> view.performClick()
            is Checkable -> view.isChecked = true
            is EditText -> ViewActions.typeText(enableText).perform(uiController, view)
        }
    }
}

fun KBaseView<*>.multiAction(text: String) {
    view.perform(MultiAction(text))
}

class ActionClass
    : TestCase() {
        @get:Rule
        val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun multiActionTest() {
        run {
            OnboardingScreen.skipButton.multiAction("")
            ExploreScreenNamed {
                step("Проверяет что '${customizeBlockByIndex {}}' отображается") {
                    NavBarNamed {
                        iconSearch.isDisplayed()
                        iconSearch.click()
                    }}}
        }
    }
}