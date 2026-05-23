package org.wikipedia.lesson28.homework

import android.util.Log
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.wikipedia.BuildConfig
import io.qameta.allure.kotlin.Description as AllureDescription


class CustomTestRule2 : TestRule {

    var testData: String = ""

    override fun apply(
        base: Statement,
        description: Description
    ): Statement {

        return object : Statement() {

            override fun evaluate() {

                Log.i("KASPRESSO", "Before Test")
                Log.i("KASPRESSO", description.displayName)

                val annotation =
                    description.getAnnotation(AllureDescription::class.java)

                testData =
                    if (annotation?.value == "valid") {
                        BuildConfig.VALID_SEARCH
                    } else {
                        BuildConfig.INVALID_SEARCH
                    }

                try {
                    base.evaluate()
                } finally {
                    Log.i("KASPRESSO", "After Test")
                }
            }
        }
    }
}