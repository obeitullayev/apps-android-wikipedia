package org.wikipedia.lesson28.homework

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import io.qameta.allure.kotlin.Description
import org.junit.Rule
import org.junit.Test
import org.wikipedia.BuildConfig
import org.wikipedia.lesson18.homework.baseElements.getName
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.NavBarNamed
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.lesson20.equalsWithTrim
import org.wikipedia.lesson20.homework.SearchComposeScreen
import org.wikipedia.lesson20.homework.SearchScreen
import org.wikipedia.lesson20.homework.SearchScreen.invoke
import org.wikipedia.lesson20.homework.SearchScreen.searchField
import org.wikipedia.lesson20.homework.SearchScreen.searchInput
import org.wikipedia.lesson20.homework.SearchScreen.text
import org.wikipedia.lesson20.multiAction
import org.wikipedia.lesson22.homework.BaseTest
import org.wikipedia.main.MainActivity

class DescriptionSearchTest: BaseTest() {

    @get:Rule(1)
    val baseRule = CustomTestRule2()
    @get:Rule(2)
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    @get:Rule(3)
    val kakaoRule = KakaoComposeTestRule(composeTestRule, true)

    private fun searchValidScenario() {
        run {
            action.click(OnboardingScreenNamed.skipButton)
            verify.isDisplayed(NavBarNamed.iconSearch)
            action.click(NavBarNamed.iconSearch)

            SearchScreen {
                verify.isDisplayed(text)
                action.click(searchField)
            }
            step("Вводит запрос и проверяет в ${searchInput.getName()} ") {
                searchInput {
                    multiAction(baseRule.testData)
                    Thread.sleep(3000)
                    equalsWithTrim(baseRule.testData)
                }
                Thread.sleep(3000)
                SearchComposeScreen.searchEmptyResult.assertIsNotDisplayed()

            }
        }
    }

    private fun searchInvalidScenario() {
        run {
            action.click(OnboardingScreenNamed.skipButton)
            verify.isDisplayed(NavBarNamed.iconSearch)
            action.click(NavBarNamed.iconSearch)

            SearchScreen {
                verify.isDisplayed(text)
                action.click(searchField)
            }
            step("Вводит запрос и проверяет в ${searchInput.getName()} ") {
                searchInput {
                    multiAction(baseRule.testData)
                    Thread.sleep(3000)
                    equalsWithTrim(baseRule.testData)
                }
                Thread.sleep(3000)
                SearchComposeScreen.searchEmptyResult.assertIsDisplayed()
            }
        }
    }

    @Test
    @Description("valid")
    fun validSearchTest() {
        searchValidScenario()
    }

    @Test
    @Description("invalid")
    fun invalidSearchTest() {
        searchInvalidScenario()
    }
}