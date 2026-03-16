package org.wikipedia.lesson11.homework

import android.view.Surface
import androidx.browser.R
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.device.languages.Language
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertNull
import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson03.homework.OnboardingScreen
import org.wikipedia.lesson10.homework.OnboardingUiScreen
import org.wikipedia.lesson10.homework.OnboardingUiScreen.primaryText
import org.wikipedia.lesson10.homework.OnboardingUiScreen.skipButton
import org.wikipedia.lesson8.homework.CustomizeItem
import org.wikipedia.lesson8.homework.ExploreScreen
import org.wikipedia.lesson8.homework.TopReadItem
import org.wikipedia.main.MainActivity
import java.util.Locale

class OnboardingAdbTest : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

// поворот экрана и проверка ориентации через метод device.uiDevice.isNaturalOrientation
    @Test
    fun preAndPostScenarioOrientation() {
        before("поворот экрана и проверка ориентации") {
            device.uiDevice.setOrientationLandscape()
        }.after {
            device.uiDevice.setOrientationNatural()
        }.run {
            step("Проверяет текст заголовка") {
                primaryText.containsText("The Free Encyclopedia")
            }

            step("Проверяет ориентацию") {
                //device.uiDevice.getDisplayRotation()
                val act = device.uiDevice.getDisplayRotation()
                val ex = Surface.ROTATION_90
                device.uiDevice.isNaturalOrientation.not()
                Assert.assertEquals( ex, act)
            }
        }
    }


    // выключение экрана, включение и проверка отображения элемента (любого)
    @Test
    fun checkEnableAndDisable() {
        before("Проверка отключения/включения") {
        }.after {
            device.uiDevice.wakeUp()
        }.run {
            OnboardingUiScreen {
                step("Проверяет текст заголовка") {
                    primaryText.containsText("The Free Encyclopedia")
                }

                step("отключение/включение") {
                    device.uiDevice.sleep()
                    primaryText.hasNoText("The Free Encyclopedia")
                    device.uiDevice.wakeUp()
                    primaryText.containsText("The Free Encyclopedia")
                }
            }
        }
    }

    // "свернуть" приложение кнопкой home и развернуть дважды нажав recent apps и проверить отображение элемента (любого)
    @Test
    fun collapseAndExpandApp() {
        run {
            OnboardingScreen {
                step("Проверка  сворачивание и востановление приложения ") {
                    primaryText.containsText("The Free Encyclopedia")
                }

                step("\"свернуть\" приложение кнопкой home") {
                    device.uiDevice.pressHome()
                    assertNull(device.activities.getResumed())
                }

                step("развернуть дважды нажав recent apps и проверить отображение элемента (любого)"){
                    device.uiDevice.pressRecentApps()
                    Thread.sleep(200)
                    device.uiDevice.pressRecentApps()
                    primaryText.containsText("The Free Encyclopedia")
                }
            }
        }
    }

    //выключить сеть, перейти в статью и проверить отображение ошибки и кнопки Retry.
    //Включить сеть и нажать Retry, проверить отображение заголовка (может работать некорректно, в этом случае забить на тест)
    @Test
    fun preAndPostScenarioNetwork() {
        before("Проверка сети") {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
//            )
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
        }.run {
            step("Нажимает на статью") {
                val buttonSkip = device.uiDevice.findObject(UiSelector().textContains("Skip"))
                buttonSkip.click()
                device.uiDevice.swipe(
                    500, 400,   // start
                    500, 1200,  // end
                    20
                )

            step("Проверяет текст ошибки и нажимает на кнопку ретрай") {
                PageErrorScreen.errorText.containsText("Content cannot be loaded")
                PageErrorScreen.retryButton.isDisplayed()
            }
            step("Вкл. сеть и нажимает на кнопку ретрай") {
                device.network.enable()
                Thread.sleep(5000)
                PageErrorScreen.retryButton.click()
                Thread.sleep(3000)
                PageErrorScreen.retryButton.doesNotExist()
            }
            }
        }
    }

    //поменять язык приложения и проверить текст какой-нибудь кнопки (не через ресурсы)
    @Test
    fun preAndPostScenarioLanguage() {
        before("Название теста") {
            device.language.switchInApp(Locale.FRANCE)
            adbServer.performShell(
                command = "cmd",
                arguments = listOf("locale", "set", "ru-RU")
            )
        }.after {
            adbServer.performShell(
                command = "cmd",
                arguments = listOf("locale", "set", "en-EN")
            )
        }.run {
            skipButton.containsText("Пропустить")
        }
    }

//    проверить, что сейчас активна MainActivity.
@Test
fun checkActivity() {
    val buttonSkip = device.uiDevice.findObject(UiSelector().textContains("Skip"))
    buttonSkip.click()
    device.activities.isCurrent(MainActivity::class.java)
}


@Test
fun languageTest() {
    before {
        adbServer.performAdb("shell cmd locale set-app-locales org.wikipedia.alpha ru")
        adbServer.performAdb("shell am force-stop org.wikipedia")
        adbServer.performAdb("shell monkey -p org.wikipedia.alpha -c android.intent.category.LAUNCHER 1")

    }.run {
        skipButton.containsText("Пропустить")
    }
}
}