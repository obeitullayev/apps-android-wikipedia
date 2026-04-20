package org.wikipedia.lesson20

import android.view.View
import android.widget.Button
import android.widget.Checkable
import android.widget.EditText
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import io.github.kakaocup.kakao.common.views.KBaseView
import org.hamcrest.Matcher
import org.junit.Test
import org.wikipedia.lesson03.homework.OnboardingScreen

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
            is Checkable -> view.isChecked = true
            is EditText -> ViewActions.typeText(enableText).perform(uiController, view)
            is Button -> view.performClick()
        }
    }
}

fun KBaseView<*>.multiAction() {
    view.perform(MultiAction("On"))
}

class ActionClass{

    @Test
    fun multiActionTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
        }
    }

}