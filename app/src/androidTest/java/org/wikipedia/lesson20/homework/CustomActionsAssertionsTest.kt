package org.wikipedia.lesson20.homework

import org.wikipedia.lesson19.homework.NavBarNamed
import org.wikipedia.lesson19.homework.SettingsScreenNamed
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify


import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.baseElements.getName
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed
import org.wikipedia.lesson18.homework.exploreScreen.SearchItemNamed
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed
import org.wikipedia.lesson20.equalsWithTrim
import org.wikipedia.lesson20.multiAction
import org.wikipedia.main.MainActivity

class CustomActionsAssertionsTest : TestCase(Kaspresso.Builder.withForcedAllureSupport(false)) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun customActionScenario() {
        run {
            step("нажимает ${OnboardingScreenNamed.skipButton.getName()}  "){
                OnboardingScreenNamed.skipButton.multiAction("")
            }

            step("Проверяет что '${NavBarNamed.iconSearch.getName()}' отображается и кликает") {
                NavBarNamed {
                    iconSearch.isDisplayed()
                    iconSearch.click()
                }
            }

            SearchScreen {
                text.isDisplayed()
                step("Клик на ${searchField.getName()}") {
                    searchField.click()
                }
                step("Вводит 'On' и проверяет в ${searchInput.getName()} ") {
                    searchInput {
                        multiAction("On")
                        equalsWithTrim("On")
                    }
                }
            }

            step("Нажатие назад") {
                repeat(2){device.uiDevice.pressBack()}
            }


            step("открывает настройку '${NavBarNamed.setingsButton.getName()}'"){
                    NavBarNamed{
                        iconMore.isDisplayed()
                        iconMore.click()
                        setingsButton.isDisplayed()
                        setingsButton.click()
                    }
            }

            SettingsScreenNamed{
                itemSettingsByText("Show images"){}
                itemSettingsByText("Download only over Wi-Fi"){
                    step("проверяет наличие '${titleWiFI.getName()}'"){
                        titleWiFI.isDisplayed()
                    }
                    step(" активирует '${switchCheckBox.getName()}'") {
                        switchCheckBox.setChecked(true)
                    }
                    step(" проверяет '${switchCheckBox.getName()}'") {
                        switchCheckBox.isChecked()
                    }
                }
            }
        }
    }
}
