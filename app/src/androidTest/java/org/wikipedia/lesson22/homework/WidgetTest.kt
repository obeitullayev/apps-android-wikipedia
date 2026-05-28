package org.wikipedia.lesson22.homework

import org.junit.Test
import org.wikipedia.lesson11.homework.FeaturedArticle
import org.wikipedia.lesson12.homework.ArticlePage
import org.wikipedia.lesson18.homework.baseElements.getName
import org.wikipedia.lesson18.homework.exploreScreen.ExploreScreenNamed
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.lesson20.multiAction

class WidgetTest: BaseTest() {

    @Test
    fun testForTextWidget(){
        run{
            step("нажимает ${OnboardingScreenNamed.skipButton.getName()} "){
                OnboardingScreenNamed.skipButton.multiAction("")
            }

            ExploreScreenNamed {
                featureArticleByText {
                    step("нажимает ${titleText.getName()} ") {
                        action.click(titleText)
                    }
                }
            }
            ArticlePage {
                step("нажимает ${closePopupButton.getName()}") {
                    closePopupButton.click()
                }

                step("нажимает ${navThemeAction.getName()} ") {
                    navThemeAction.click()
                }
            }
                BottomSheetWidget {
                    textWidget {
                        step("нажимает ${textButtonIncrease.getName()} ") {
                            action.click(textButtonIncrease)
                        }
                        step("проверяет ${textSize.getName()} ") {
                            verify.hasText(textSize, "110%")
                        }
                        step("нажимает ${textButtonDecrease.getName()} ") {
                            repeat(2, { action.click(textButtonDecrease) })
                        }
                        step("проверяет ${textSize.getName()} ") {
                            verify.hasText(textSize, "90%")
                        }
                    }
                }

        }
    }

    @Test
    fun testForThemeWidget(){
        run{
            step("нажимает ${OnboardingScreenNamed.skipButton.getName()} "){
                OnboardingScreenNamed.skipButton.multiAction("")
            }

            ExploreScreenNamed {
                featureArticleByText {
                    step("нажимает ${titleText.getName()} ") {
                        action.click(titleText)
                    }
                }
            }

            ArticlePage {
                step("нажимает ${closePopupButton.getName()}") {
                    closePopupButton.click()
                }

                step("нажимает ${ navThemeAction.getName()} ") {
                    navThemeAction.click()
                }
                BottomSheetWidget {
                    themeWidget {
                        step("нажимает ${systemThemeSwitcher.getName()} ") {
                            systemThemeSwitcher.multiAction("")
                        }
                        step("проверяет ${systemThemeSwitcher.getName()} ") {
                            verify.isNotChecked(systemThemeSwitcher)
                        }
                        step("нажимает ${systemThemeSwitcher.getName()} ") {
                            action.click(systemThemeSwitcher)
                        }
                        step("проверяет ${systemThemeSwitcher.getName()} ") {
                            verify.isChecked(systemThemeSwitcher)
                        }
                    }
                }
            }
        }
    }
}