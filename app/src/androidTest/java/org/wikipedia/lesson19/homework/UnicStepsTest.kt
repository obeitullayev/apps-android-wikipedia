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

class SimpleTestNamed : TestCase(Kaspresso.Builder.withForcedAllureSupport(false)) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun goToExploreAndTopRead() {
        run {
            step("Проверяет что '${OnboardingScreenNamed.skipButton}' нажимается"){
                action.click(OnboardingScreenNamed.skipButton)
            }
            ExploreScreenNamed {
                step("Проверяет что '${customizeBlockByIndex {}}' отображается") {
                    customizeBlockByIndex {
                        verify.isDisplayed(this)
                    }
                }
                step("Проверяет что '${topReadBlockByText {}}' отображается") {
                    topReadBlockByText {
                        verify.isDisplayed(this)
                        itemPosition(2) {
                            verify.isDisplayed(image)
                        }
                    }
                }

            }
        }
    }

    @Test
    fun goToExploreAndToggle() {
        run {
            step("Проверяет что '${OnboardingScreenNamed.skipButton}' нажимается"){
                action.click(OnboardingScreenNamed.skipButton)
            }
            ExploreScreenNamed {
                step("Проверяет что '${customizeBlockByIndex{}}' отображается"){
                    customizeBlockByIndex {
                        verify.isDisplayed(this)
                    }
                }
                step("открывает '${NavBarNamed}'"){
                    NavBarNamed{
                        iconMore.isDisplayed()
                        iconMore.click()
                        setingsButton.isDisplayed()
                        setingsButton.click()
                    }
                }
            SettingsScreenNamed{
                itemSettingsShowLink{
                    step("проверяет наличие '${titleShowLink}'"){
                        titleShowLink.isDisplayed()
                    }
                    step(" активирует '${switchCheckBox}'") {
                        switchCheckBox.setChecked(false)
                    }
                    step(" проверяет '${switchCheckBox}'") {
                        switchCheckBox.isNotChecked()
                    }
                }
            }
        }
    }
}}