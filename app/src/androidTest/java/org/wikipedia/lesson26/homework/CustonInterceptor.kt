package org.wikipedia.lesson26.homework

import android.util.Log
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor

class MyInterceptors : ViewBehaviorInterceptor {
    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ):T {
    Log.i("KASPRESSO", "Start message")
        var res = action()
    return res
    }
}
