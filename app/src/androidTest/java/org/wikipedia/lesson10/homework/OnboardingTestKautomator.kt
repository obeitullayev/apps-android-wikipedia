package org.wikipedia.lesson10.homework



import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import com.kaspersky.kaspresso.screens.KScreen
import org.wikipedia.lesson10.homework.OnboardingUiScreen
import org.wikipedia.lesson09.homework.CustomizeFeedScreen
import org.wikipedia.lesson09.homework.FeaturedArticle
import org.wikipedia.lesson8.homework.CustomizeItem
import org.wikipedia.lesson8.homework.ExploreScreen

class OnboardingScreenTest : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkFirstScreenText() {
        run {
            OnboardingUiScreen {
                step("Проверяет текст заголовка") {
                    primaryText.containsText("The Free Encyclopedia")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.containsText("on your device")
                }

                step("Нажимает на кнопку continue") {
                    continueButton.click()
                }


                step("Проверяет текст заголовка") {
                    primaryText.hasNoText("The Free Encyclopedia")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.hasNoText("on your device")
                }

                step("Нажимает на кнопку continue") {
                    continueButton.click()
                }


                step("Проверяет текст заголовка") {
                    primaryText.hasNoText("The Free Encyclopedia")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.hasNoText("on your device")
                }

                step("Нажимает на кнопку continue") {
                    continueButton.click()
                }


                step("Проверяет текст заголовка") {
                    primaryText.hasNoText("The Free Encyclopedia")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.hasNoText("on your device")
                }

                step("Проверяет кнопку continue") {
                   getStartedButton.isDisplayed()
                }
            }

        }
    }

    @Test
    fun checkSecondScreenText() {
        run {
            OnboardingUiScreen {

                step("Проверяет текст заголовка") {
                    primaryText.hasNoText("New ways to explore")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.hasNoText("Dive down the Wikipedia")
                }

                step("Нажимает на кнопку continue") {
                    continueButton.click()
                }


                step("Проверяет текст заголовка") {
                    primaryText.containsText("New ways to explore")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.containsText("Dive down the Wikipedia")
                }

                step("Нажимает на кнопку continue") {
                    continueButton.click()
                }


                step("Проверяет текст заголовка") {
                    primaryText.hasNoText("New ways to explore")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.hasNoText("Dive down the Wikipedia")
                }

                step("Нажимает на кнопку continue") {
                    continueButton.click()
                }


                step("Проверяет текст заголовка") {
                    primaryText.hasNoText("New ways to explore")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.hasNoText("Dive down the Wikipedia")
                }

                step("Проверяет кнопку continue") {
                    getStartedButton.isDisplayed()
                }
            }

        }
    }

    @Test
    fun checkThirdScreenText() {
        run {
            OnboardingUiScreen {

                step("Проверяет текст заголовка") {
                    primaryText.hasNoText("Reading lists with")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.hasNoText("You can make reading")
                }

                step("Нажимает на кнопку continue") {
                    continueButton.click()
                }


                step("Проверяет текст заголовка") {
                    primaryText.hasNoText("Reading lists with")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.hasNoText("You can make reading")
                }

                step("Нажимает на кнопку continue") {
                    continueButton.click()
                }


                step("Проверяет текст заголовка") {
                    primaryText.containsText("Reading lists with")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.containsText("You can make reading")
                }

                step("Нажимает на кнопку continue") {
                    continueButton.click()
                }


                step("Проверяет текст заголовка") {
                    primaryText.hasNoText("Reading lists with")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.hasNoText("You can make reading")
                }

                step("Проверяет кнопку continue") {
                    getStartedButton.isDisplayed()
                }
            }

        }
    }

    @Test
    fun checkFourthScreenText() {
        run {
            OnboardingUiScreen {

                step("Проверяет текст заголовка") {
                    primaryText.hasNoText("Data & Privacy")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.hasNoText("We believe that")
                }

                step("Нажимает на кнопку continue") {
                    continueButton.click()
                }


                step("Проверяет текст заголовка") {
                    primaryText.hasNoText("Data & Privacy")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.hasNoText("We believe that")
                }

                step("Нажимает на кнопку continue") {
                    continueButton.click()
                }


                step("Проверяет текст заголовка") {
                    primaryText.hasNoText("Data & Privacy")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.hasNoText("We believe that")
                }

                step("Нажимает на кнопку continue") {
                    continueButton.click()
                }


                step("Проверяет текст заголовка") {
                    primaryText.containsText("Data & Privacy")
                }

                step("Проверяет текст подзаголовка") {
                    secondaryText.containsText("We believe that")
                }

                step("Проверяет кнопку continue") {
                    getStartedButton.isDisplayed()
                }
            }

        }
    }
}