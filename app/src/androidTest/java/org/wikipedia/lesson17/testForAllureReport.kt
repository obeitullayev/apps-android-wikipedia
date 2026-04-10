package org.wikipedia.lesson17

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson03.homework.OnboardingScreen
import org.wikipedia.main.MainActivity


class TestForAllureReport : TestCase (Kaspresso.Builder.withForcedAllureSupport(false)){

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testForAllure(){
        run {
            step("Кнопка skip отображается"){
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Текст primaryText отображается"){
                OnboardingScreen.primaryText.isDisplayed()
            }

        }
    }

    @Test
    fun testForAllureFailed(){
        run {
            step("Кнопка skip отображается"){
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Текст primaryText отображается"){
                OnboardingScreen.primaryText.isNotDisplayed()
            }

        }
    }

}