package org.wikipedia.lesson27.homework

import android.util.Log
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.qameta.allure.kotlin.AllureId
import org.junit.Assert
import org.junit.AssumptionViolatedException
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.wikipedia.lesson22.homework.BaseTest

class CustomTestRule : TestRule {

    override fun apply(
        base: Statement,
        description: Description
    ): Statement {

        Log.i("KASPRESSO", "Before Test")
        Log.i("KASPRESSO", description.displayName)

        return CustomStatement(base, description)
    }
}

class CustomStatement(
    private val base: Statement,
    private val description: Description
) : Statement() {

    override fun evaluate() {

        val annotation =
            description.getAnnotation(Deprecated::class.java)

        if (annotation != null) {
            throw AssumptionViolatedException("Test is deprecated")
        }

        try {
            base.evaluate()
        } finally {
            Log.i("KASPRESSO", "After Test")
        }
    }
}