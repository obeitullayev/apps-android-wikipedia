package org.wikipedia.lesson09.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import com.kaspersky.kaspresso.screens.KScreen
import org.wikipedia.lesson03.homework.OnboardingScreen
import org.wikipedia.lesson8.homework.CustomizeItem
import org.wikipedia.lesson8.homework.ExploreScreen

class SimpleTest : TestCase() {
@get:Rule
val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun disableFeaturedArticle() {
        run {
            OnboardingScreen {
                step("Проверяет что кнопка Skip отображается") {
                    skipButton.isDisplayed()
                }
                step("Нажимает на кнопку Skip") {
                    skipButton.click()
                }

                step("Проверяет что онбординг скрыт") {
                    primaryText.doesNotExist()
                }
            }

            ExploreScreen.items.childAt<CustomizeItem>(1) {
                    step("Проверяет что кнопка Customize отображается") {
                        customizeButton.isDisplayed()
                    }
                    step("Нажимает на кнопку Customize") {
                        customizeButton.click()
                    }
                }

            CustomizeFeedScreen.items.childAt<FeaturedArticle>(1) {
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

            ExploreScreen.items.childAt<CustomizeItem>(1) {
                step("Проверяет что кнопка Customize отображается") {
                    customizeButton.doesNotExist()
                }
            }
        }
    }
}