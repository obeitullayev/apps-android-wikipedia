package org.wikipedia.lesson25.homework

import androidx.test.uiautomator.UiSelector
import org.junit.Test
import org.wikipedia.lesson12.homework.ArticlePage.closePopupButton
import org.wikipedia.lesson18.homework.baseElements.getName
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed.invoke
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed.topReadBlockByText
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.lesson22.homework.BaseTest
import org.wikipedia.lesson23.homework.ArticleScreen

class SmartScenarioTest: BaseTest(){

    @Test
    fun closeBannerTest(){
        run{

            step("нажимает ${OnboardingScreenNamed.skipButton.getName()} ") {
                action.click(OnboardingScreenNamed.skipButton)
            }
            ExploreScreenNamed{
                topReadBlockByText{
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
            step("закрывает баннеры через SmartScenario") {
                smartScenarios.closePlayTodayGame()
                Thread.sleep(3000)
                smartScenarios.closeGotIt()
            }
            ArticleScreen{
                step("проверяет ${title.getName()}") {
                    verify.isDisplayed(ArticleScreen.title)
                }
                step("ждет 3000 млс. ") {
                    Thread.sleep(3000)
                }
            }
        }
    }
}