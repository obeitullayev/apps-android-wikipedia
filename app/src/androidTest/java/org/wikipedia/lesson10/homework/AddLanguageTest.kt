package org.wikipedia.lesson10.homework

import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingLanguageScreen : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkAddedRusLanguage() {
        run {
            OnboardingUiScreen {
                step("Проверяет текст заголовка") {
                    primaryText.containsText("The Free Encyclopedia")
                }

                step("Нажимает на кнопку Add Language") {
                    addLanguageButton.click()
                }
            }

            AppLanguagesScreen{
                step("Проверяет текст заголовка"){
                    headerText.containsText("Your languages")
                }

                step("Нажимает на кнопку Add Language"){
                    addLanguageButton.click()
                }
            }


            AddLanguagesScreen{
                step("Проверяет текст заголовка"){
                    pageContent {
                        hasText("All languages")
                    }
                }

                step("Нажимает на элемент Add Language Deutsch"){
                    addLanguageDeutsch.click()
                }
            }

            AppLanguagesScreen{
                step("Проверяет текст заголовка"){
                    headerText.containsText("Your languages")
                }

                step("Проверяет текст лейбла Deutsch"){
                    languageTitleDeutsch.containsText("Deutsch")
                }

                step("Нажимает назад") {
                    device.uiDevice.pressBack()
                }
            }

            OnboardingUiScreen {
                step("Проверяет текст заголовка") {
                    primaryText.containsText("The Free Encyclopedia")
                }

                step("Проверяет текст в списке Deutsch") {
                    languageList{
                        isDisplayed()
                        hasText("2.Deutsch")
                    }
                }

                step("Нажимает на кнопку Add Language") {
                    addLanguageButton.click()
                }
            }

        }
    }
}