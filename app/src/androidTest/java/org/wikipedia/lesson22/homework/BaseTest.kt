package org.wikipedia.lesson22.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.components.composesupport.config.ComposeConfig
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.wikipedia.main.MainActivity

open class BaseTest: TestCase(
    Kaspresso.Builder
    .withForcedAllureSupport(false)
    .apply { ComposeConfig.Builder.default(this) {}}) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

}