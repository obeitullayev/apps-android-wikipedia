package org.wikipedia.lesson26.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed.customizeBlockByIndex
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.main.MainActivity

class SimpleTestNamed : TestCase(Kaspresso.Builder.withForcedAllureSupport(false)) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun goToExploreAndTopRead() {
        run {
            step("Проверяет что '${OnboardingScreenNamed.skipButton}' нажимается") {
                action.click(OnboardingScreenNamed.skipButton)
            }
            ExploreScreenNamed {
                step("Проверяет что '${customizeBlockByIndex {}}' отображается") {
                    customizeBlockByIndex {
                        verify.isDisplayed(this)
                    }
                }
            }
        }
    }
}