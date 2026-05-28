package org.wikipedia.lesson18.homework


import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson09.homework.CustomizeFeedScreen
import org.wikipedia.lesson09.homework.FeaturedArticleCustomize
import org.wikipedia.lesson18.homework.baseElements.getName
import org.wikipedia.lesson18.homework.baseElements.invokeAtIndex
import org.wikipedia.lesson18.homework.exploreScreen.CustomizeItemNamed
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed
import org.wikipedia.lesson22.homework.BaseTest
import org.wikipedia.main.MainActivity

class SimpleTest : BaseTest() {

    @Test
    fun testWithNamedElements() {
        run {
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

            ExploreScreenNamed {
                customizeBlockByIndex {

                    step("Проверяет что '${customizeButton.getName()}' отображается") {
                        customizeButton.isDisplayed()
                    }
                    step("Нажимает на '${customizeButton.getName()}'") {
                        customizeButton.click()
                    }
                }
            }

            CustomizeFeedScreen.items.childAt<FeaturedArticleCustomize>(1) {
                step("Проверяет что чекбокс отображается") {
                    switcher.isChecked()
                }

                step("Нажимает на чекбокс") {
                    switcher.click()
                }
                step("Проверяет что чекбокс не активен") {
                    switcher.isNotChecked()
                }
                step("Нажимает назад") {
                    device.uiDevice.pressBack()
                }
            }

            ExploreScreenNamed {
                customizeBlockByIndex {
                    step("Проверяет что '${customizeButton.getName()}' не отображается") {
                        customizeButton.doesNotExist()
                    }
                }
            }
        }
    }
}