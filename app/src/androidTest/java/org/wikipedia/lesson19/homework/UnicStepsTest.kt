package org.wikipedia.lesson19.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.baseElements.getName
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed
import org.wikipedia.lesson18.homework.exploreScreen.TopReadRecyclerNamed
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed
import org.wikipedia.main.MainActivity

class SimpleTest : TestCase(Kaspresso.Builder.withForcedAllureSupport(false)) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun goToExploreAndTopRead() {
        run {
            action.click(OnboardingScreenNamed.skipButton)
            ExploreScreenNamed {
                customizeBlockByIndex {
                    verify.isDisplayed(this)
                }
                topReadBlockByIndex {
                    verify.isDisplayed(this)
                    itemPosition(2){
                        verify.isDisplayed(image)
                    }
                }
            }

            OnboardingScreenNamed {
                step("Проверяет что '${skipButton.getName()}' отображается") {
                    skipButton.isDisplayed()
                }
                step("Нажимает на '${skipButton.getName()}'") {
                    skipButton.click()
                }

                step("Проверяет что '${primaryText.getName()}' скрыт") {
                    primaryText.doesNotExist()
                }
            }
        }
    }

    @Test
    fun goToExploreAndToggle() {
        run {
            action.click(OnboardingScreenNamed.skipButton)
            ExploreScreenNamed {
                customizeBlockByIndex {
                    verify.isDisplayed(this)
                }
                topReadBlockByIndex {
                    verify.isDisplayed(this)
                    itemPosition(2){
                        verify.isDisplayed(image)
                    }
                }
            }
        }
    }
}