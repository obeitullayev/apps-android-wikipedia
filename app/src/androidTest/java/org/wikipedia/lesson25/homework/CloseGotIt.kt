package org.wikipedia.lesson25.homework

import android.util.Log
import androidx.test.uiautomator.UiObjectNotFoundException
import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import io.qameta.allure.kotlin.Allure


class CloseGotIt(testContext: BaseTestContext) : ScreenBehaviorBase(testContext) {

    override val step = "Закрывает блок Got It"
    override val action: Allure.StepContext.() -> Unit = {
        val button = getElementById("buttonView")

        if (button.waitForExists(3000)) {

            try {
                button.click()

                testContext.testLogger.i(
                    "GotIt button clicked"
                )

            } catch (e: UiObjectNotFoundException) {

                testContext.testLogger.i(
                    "GotIt button disappeared before click"
                )
            }
        } else {

            testContext.testLogger.i(
                "GotIt button not found"
            )
        }
    }
    override fun isConditionMet(): Boolean {
        Log.i("KASPRESSO", checkScreenById("textView").toString())
        return checkScreenById("textView")
    }
}