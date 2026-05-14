package org.wikipedia.lesson27.homework

import android.util.Log
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson22.homework.BaseTest

class ExampleTest : BaseTest(){

    @get:Rule
    val baseRule = CustomTestRule()

    @Test
    fun logTest(){
        Log.i("KASPRESSO", "Inside Test Log 1")
    }

    @Test
    @Deprecated("")
    fun logTest2(){
        Log.i("KASPRESSO", "Inside Test Log 2")
    }

    @Test
    fun logTest3(){
        Log.i("KASPRESSO", "Inside Test Log 3")
    }
}