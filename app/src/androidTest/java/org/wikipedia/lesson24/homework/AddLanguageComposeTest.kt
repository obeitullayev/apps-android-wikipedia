package org.wikipedia.lesson24.homework

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.wikipedia.lesson18.homework.baseElements.getName
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.main.MainActivity
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson09.homework.CustomizeFeedScreen
import org.wikipedia.lesson09.homework.FeaturedArticleCustomize
import org.wikipedia.lesson22.homework.BaseTest

class AddLanguageComposeTest : BaseTest() {

    @get:Rule()
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    @get:Rule()
    val kakaoRule = KakaoComposeTestRule(composeTestRule, true)

    @Test
    fun checkAddedRusLanguage() {
        run {
            OnboardingScreenNamed {
                step("Проверяет текст ${primaryText.getName()}") {
                    verify.containsText(primaryText, "The Free Encyclopedia")
                }

                step("Нажимает на кнопку ${addLanguageButton.getName()}") {
                    action.click(addLanguageButton)
                }
            }

            LanguageListScreen {
                step("Проверяет текст ${headerText.getName()}") {
                    verify.hasText(headerText, "Your languages")
                }

                step("Нажимает на кнопку ${addLanguageButton.getName()}") {
                    action.click(addLanguageButton)
                }

                step("ждет 3000 млс. ") {
                    Thread.sleep(3000)
                }
            }

            AddLanguageScreenCompose {

                itemPosition(2) {
                    step("Проверяет текст ${localName.getName()}") {
                        verify.hasText(localName, "Русский")
                    }

                    step("Проверяет текст ${canonicName.getName()}") {
                        verify.hasText(canonicName, "Russian")
                    }

                    step("Нажимает на ${localName.getName()}") {
                        action.click(localName)
                    }
                }
            }

            LanguageListScreen {
                itemLanguagePosition(2) {
                    step("Проверяет текст ${title.getName()}") {
                        verify.hasText(title, "Русский")
                    }

                    step("Проверяет текст ${langOrder.getName()}") {
                        verify.hasText(langOrder, "2")
                    }

                    step("Проверяет текст ${langCode.getName()}") {
                        verify.hasText(langCode, "RU")
                    }

                    step("Нажимает назад") {
                        device.uiDevice.pressBack()
                    }
                }
            }

            OnboardingScreenNamed {
                step("Проверяет текст ${titleRU.getName()}") {
                    verify.containsText(titleRU, "Русский")
                }
            }
        }
    }

    @Test
    fun checkAddedDeutschLanguage() {
        run {
            OnboardingScreenNamed {
                step("Проверяет текст заголовка") {
                    verify.containsText(primaryText, "The Free Encyclopedia")
                }

                step("Нажимает на кнопку Add Language") {
                    action.click(addLanguageButton)
                }
            }

            LanguageListScreen {
                step("Проверяет текст ${headerText.getName()}") {
                    verify.hasText(headerText, "Your languages")
                }

                step("Нажимает на кнопку ${addLanguageButton.getName()}") {
                    action.click(addLanguageButton)
                }

            }

            AddLanguageScreenCompose {

                itemPosition(3) {
                    step("Проверяет текст ${localName.getName()}") {
                        verify.hasText(localName, "Deutsch")
                    }

                    step("Проверяет текст ${canonicName.getName()}") {
                        verify.hasText(canonicName, "German")
                    }

                    step("Нажимает на ${localName.getName()}") {
                        action.click(localName)
                    }
                }
            }

            LanguageListScreen {
                itemLanguagePosition(2) {
                    step("Проверяет текст ${title.getName()}") {
                        verify.hasText(title, "Deutsch")
                    }

                    step("Проверяет текст ${langOrder.getName()}") {
                        verify.hasText(langOrder, "2")
                    }

                    step("Проверяет текст ${langCode.getName()}") {
                        verify.hasText(langCode, "DE")
                    }
                    step("Нажимает назад") {
                        device.uiDevice.pressBack()
                    }

                }
            }

            OnboardingScreenNamed {
                    step("Проверяет текст ${titleDE.getName()}") {
                        verify.containsText(titleDE, "Deutsch")
                    }
                }

        }
    }

}