package org.wikipedia.lesson26.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import io.qameta.allure.kotlin.Allure.step
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed.customizeBlockByIndex
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.main.MainActivity

class SimpleTestInterceptor : TestCase(
    kaspressoBuilder = Kaspresso.Builder.advanced().apply{
        testRunWatcherInterceptors.add(MyInterceptors())
    }) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun logStartFinish() {
        val testName = "Lifecycle_Logging_Test"

        before("Подготовка к тесту") {
            // Лог начала подготовки
            testLogger.i("LOG_ORDER: Начинаем блок BEFORE для $testName")

            step("Предусловие: Сброс состояния приложения") {
                // Здесь может быть сброс кэша или БД
                testLogger.i("LOG_ORDER: Выполняется шаг подготовки внутри BEFORE")
            }

        }.after {
            // Лог начала очистки
            testLogger.i("LOG_ORDER: Начинаем блок AFTER для $testName")

            step("Постусловие: Закрытие ресурсов") {
                testLogger.i("LOG_ORDER: Выполняется шаг очистки внутри AFTER")
            }

        }.run {
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