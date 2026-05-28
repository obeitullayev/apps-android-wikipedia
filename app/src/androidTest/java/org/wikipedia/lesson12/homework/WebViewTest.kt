package org.wikipedia.lesson12.homework

import androidx.compose.ui.test.hasText
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.lesson10.homework.OnboardingUiScreen
import org.wikipedia.lesson11.homework.FeaturedArticle
import org.wikipedia.lesson12.homework.ArticlePage
import org.wikipedia.lesson8.homework.ExploreScreen.items
import org.wikipedia.main.MainActivity

class WebViewTest : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun findElementsOnWebpage() {
        run {
            step("skip"){ OnboardingUiScreen.skipButton.click() }

            step("open featured"){
                items.childWith<FeaturedArticle> {
                    withDescendant { withId(R.id.articleTitle) }
                } perform {
                    titleText.click()
                }
            }
                ArticlePage.webView {
            step("close popup"){
                ArticlePage{
                    closePopupButton.click()
                }
            }

            step("scroll to reference"){
                    withElement(Locator.XPATH, "//*[@id=\"References\"]") {
                        scroll()
                        hasText("References")
                    }
                }
            step("click to hiperlink 5"){
                    withElement(
                        Locator.XPATH,
                        // может упасть если в статье будет одна ссылка, потому что сейчас выбрана вторая ссылка дублирующая, так как первая скрыта
                        "(//sup[contains(@class, \"reference\")]//*[text()=\"5\"])[2]"
                    ) {
                        scroll()
                        click()
                    }
                }
            }

            step("check reference botomscheet text"){
                ReferencePage.containerBottomSheet {
                    hasText("Reference ")
                    hasText("5.")
                }
            }

            step("pres back"){
                device.uiDevice.pressBack()
                Thread.sleep(3000)
            }

            step("open second link"){

                ArticlePage.webView {
                    withElement(Locator.XPATH, "(//*[@class=\"mw-redirect\"])[2]") {
                        step("scroll"){scroll()}
                        step("click"){click()}

            step("bottomsheet botton click"){
                    ArticlePage.readArticleBottomSheetButton.click()
                }
            step("scroll to references"){
                    withElement(Locator.XPATH, "//*[@id=\"References\"]") {
                        scroll()
                        hasText("References")
                    }
            }

            }
        }
    }
}}}