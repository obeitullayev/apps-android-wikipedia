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
        base: Statement?,
        description: Description?
    ): Statement? {
        Log.i("KASPRESSO", "Before Test")
        Log.i("KASPRESSO", description?.displayName?: "Empty display name")
//        val allureId = description?.getAnnotation<AllureId>(AllureId::class.java)?.value
        return CustomStatement(base, description)
        }
    }

//object Config{
//    val testCases = listOf("1","2","3")
//}

class CustomStatement(val base: Statement?,
                      val description: Description?
): Statement() {
    override fun evaluate() {
        val annotation= description?.getAnnotation(Deprecated::class.java)
        if ( annotation != null){
            throw AssumptionViolatedException("Test is deprecated")
        }
        try {
            base?.evaluate()
        } catch (e: AssumptionViolatedException){
            Log.i("KASPRESSO", e.message ?: "не имеется Deprecated тест")
        }
        Log.i("KASPRESSO", "After Test")
    }
}