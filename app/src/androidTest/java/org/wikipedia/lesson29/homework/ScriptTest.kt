package org.wikipedia.lesson29.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.baseElements.getName
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson22.homework.BaseTest

class ScriptTest: BaseTest(){

    @Test
    fun checkArticleTitle() {
        run{
            step("нажимает ${OnboardingScreenNamed.skipButton.getName()} ") {
                action.click(OnboardingScreenNamed.skipButton)
            }
            ExploreScreenNamed {
                topReadBlockByText {
                    itemPosition(1) {
                        step("нажимает ${header.getName()}") {
                            action.click(header)
                        }
                        step("ждет 3000 млс. ") {
                            Thread.sleep(3000)
                        }
                    }
                }
            }
        }
    }
}