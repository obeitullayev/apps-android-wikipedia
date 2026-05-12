package org.wikipedia.lesson26.homework

import android.util.Log
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.testcases.models.info.TestInfo

class MyInterceptors : TestRunWatcherInterceptor {
    override fun onTestStarted(testInfo: TestInfo){
        Log.i("KASPRESSO", "Старт теста")
    }

    override fun onBeforeSectionStarted(testInfo: TestInfo){
        Log.i("KASPRESSO", "Старт блока перед тестом")
    }

    override fun onMainSectionStarted(testInfo: TestInfo){
        Log.i("KASPRESSO", "Старт блока теста")
    }

    override fun onAfterSectionStarted(testInfo: TestInfo){
        Log.i("KASPRESSO", "Старт блока после теста")
    }

    override fun onBeforeSectionFinishedSuccess(testInfo: TestInfo){
        Log.i("KASPRESSO", "Финиш блока перед тестом")
    }

    override fun onMainSectionFinishedSuccess(testInfo: TestInfo){
        Log.i("KASPRESSO", "Финиш блока теста")
    }

    override fun onAfterSectionFinishedSuccess(testInfo: TestInfo){
        Log.i("KASPRESSO", "Финиш блока после теста")
    }

    override fun onTestFinished(testInfo: TestInfo, success: Boolean){
        Log.i("KASPRESSO", "Финиш теста")
    }
}
