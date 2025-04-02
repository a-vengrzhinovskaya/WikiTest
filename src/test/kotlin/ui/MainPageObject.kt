package ui

import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

private const val DEFAULT_WAITING_TIME: Long = 10

abstract class MainPageObject(private val driver: AndroidDriver) {
    private fun waitForElementToBeClickableByPath(path: String, waitingTime: Long = DEFAULT_WAITING_TIME): WebElement {
        try {
            return WebDriverWait(driver, Duration.ofSeconds(waitingTime)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.xpath(path))
            )
        } catch (e: Exception) {
            throw e
        }
    }

    private fun waitForElementPresentByPath(path: String, waitingTime: Long = DEFAULT_WAITING_TIME): WebElement {
        try {
            return WebDriverWait(driver, Duration.ofSeconds(waitingTime)).until(
                ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath(path))
            )
        } catch (e: Exception) {
            throw e
        }
    }

    protected fun waitForElementAndClickByPath(path: String, waitingTime: Long = DEFAULT_WAITING_TIME) = try {
        waitForElementToBeClickableByPath(path, waitingTime).click()
    } catch (e: Exception) {
        throw e
    }

    protected fun waitForElementAndSendKeysByPath(path: String, text: String, waitingTime: Long = DEFAULT_WAITING_TIME) = try {
        waitForElementPresentByPath(path, waitingTime).sendKeys(text)
    } catch (e: Exception) {
        throw e
    }
}