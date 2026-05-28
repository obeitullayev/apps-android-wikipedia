package org.wikipedia.lesson23.homework

import androidx.compose.animation.veilOut
import org.junit.Test
import org.wikipedia.lesson12.homework.ArticlePage.closePopupButton
import org.wikipedia.lesson18.homework.baseElements.getName
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed
import org.wikipedia.lesson18.homework.exploreScreen.FeaturedArticleNamed
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.lesson22.homework.BaseTest

class TestWebViewDsl: BaseTest(){

    @Test
    fun checkReferenceIndexAndArticleTitle() {
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
            ArticleScreen{
//                step("нажимает ${closePopupButton.getName()}") {
//                    closePopupButton.click()
//                }
                step("проверяет ${title.getName()}") {
                    verify.isDisplayed(ArticleScreen.title)
                }
                step("нажимает ${closePopupButton.getName()}") {
                    action.click(references)
                }
//                referencesList{
                    referencesItem(2){
                        step("проверяет текст в ${index.getName()}") {
                            verify.containsText(index,"2")
                        }
                    }
//                }
            }
        }
    }
}