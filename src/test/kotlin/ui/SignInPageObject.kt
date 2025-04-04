package ui

import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.chrome.ChromeDriver
import org.opentest4j.AssertionFailedError
import ui.EiosCredentials.LOGIN
import ui.EiosCredentials.PASSWORD

private const val DEFAULT_WAITING_TIME: Long = 5
private const val DEFAULT_ATTEMPT_COUNT = 2
private const val LOGIN_PATH = "//input[@placeholder='логин']"
private const val PASSWORD_PATH = "//input[@placeholder='пароль']"
private const val SING_IN_BUTTON_PATH = "//button[@type='submit']"
private const val NAME_PATH = "//a[@class='css-10pdxt6 efn4aem0']"
private const val EXPECTED_NAME = "Венгржиновская А.С."
private const val LOG_OUT_PATH = "//button[@class='css-1oslnw8 efn4aem0']"

class SignInPageObject(driver: ChromeDriver) : MainPageObject(driver) {
    fun clearLogin() = clearInputByPath(LOGIN_PATH, DEFAULT_WAITING_TIME)
    fun clearPassword() = clearInputByPath(PASSWORD_PATH, DEFAULT_WAITING_TIME)
    fun typeLogin() = waitForElementAndSendKeysByPath(LOGIN_PATH, LOGIN, DEFAULT_WAITING_TIME)
    fun typePassword() = waitForElementAndSendKeysByPath(PASSWORD_PATH, PASSWORD, DEFAULT_WAITING_TIME)
    fun clickSingInButton() = waitForElementAndClickByPath(SING_IN_BUTTON_PATH, DEFAULT_WAITING_TIME)
    fun checkName() = checkIfElementTextEqualsExpectedByPath(NAME_PATH, EXPECTED_NAME, DEFAULT_WAITING_TIME)

    fun logOut() {
        var attemptCount = 0
        while (attemptCount < DEFAULT_ATTEMPT_COUNT) {
            try {
                waitForElementAndClickByPath(LOG_OUT_PATH, DEFAULT_WAITING_TIME)
                break
            } catch (e: StaleElementReferenceException) {
                attemptCount++
            }
        }
    }

    fun checkIfLogOutSuccessful(expectedUrl: String) {
        var attemptCount = 0
        while (attemptCount < DEFAULT_ATTEMPT_COUNT) {
            try {
                checkIfUrlChanged(expectedUrl, DEFAULT_WAITING_TIME)
                break
            } catch (e: AssertionFailedError) {
                attemptCount++
            }
        }
    }
}