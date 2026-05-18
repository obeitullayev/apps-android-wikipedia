package org.wikipedia.lesson28

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.BuildConfig
import org.wikipedia.lesson18.homework.baseElements.getName
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed.addLanguageButton
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed.invoke
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed.primaryText
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed.titleDE
import org.wikipedia.lesson18.homework.onboardingScreen.OnboardingScreenNamed.titleRU
import org.wikipedia.lesson19.homework.action
import org.wikipedia.lesson19.homework.verify
import org.wikipedia.lesson22.homework.BaseTest
import org.wikipedia.lesson24.homework.AddLanguageScreenCompose
import org.wikipedia.lesson24.homework.AddLanguageScreenCompose.invoke
import org.wikipedia.lesson24.homework.LanguageListScreen
import org.wikipedia.lesson24.homework.LanguageListScreen.addLanguageButton
import org.wikipedia.lesson24.homework.LanguageListScreen.headerText
import org.wikipedia.lesson24.homework.LanguageListScreen.invoke
import org.wikipedia.lesson24.homework.getName
import org.wikipedia.lesson24.homework.itemLanguagePosition
import org.wikipedia.lesson24.homework.itemPosition
import org.wikipedia.main.MainActivity

val testValue = BuildConfig.DEFAULT_RESTBASE_URI_FORMAT

class AddLanguageComposeTest : BaseTest() {

    @get:Rule()
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @get:Rule()
    val kakaoRule = KakaoComposeTestRule(composeTestRule, true)

    @Test
    fun checkAddedDeutschLanguage() {
        run {
            OnboardingScreenNamed {
                verify.containsText(primaryText, "The Free Encyclopedia")
                action.click(addLanguageButton)
            }

            LanguageListScreen {
                verify.hasText(headerText, "Your languages")
                action.click(addLanguageButton)
            }

            AddLanguageScreenCompose {
                itemPosition(3) {
                    verify.hasText(localName, BuildConfig.LOCAL_LANGUAGE)
                    verify.hasText(canonicName, BuildConfig.CANONICAL_LANGUAGE)
                    action.click(localName)
                }
            }

            LanguageListScreen {
                itemLanguagePosition(2) {
                    verify.hasText(title, BuildConfig.LOCAL_LANGUAGE)
                    verify.hasText(langOrder, "2")
                    verify.hasText(langCode, BuildConfig.LANGUAGE_CODE)

                    step("Нажимает назад") {
                        device.uiDevice.pressBack()
                    }
                }
            }

            OnboardingScreenNamed {
                lang(BuildConfig.LOCAL_LANGUAGE, {
                    verify.hasText(this, BuildConfig.LOCAL_LANGUAGE)
                })
            }

        }
    }

}