package ui

import org.junit.jupiter.api.Assertions
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import java.time.Duration

private const val DEFAULT_WAITING_TIME: Long = 10

abstract class MainPageObject(private val driver: ChromeDriver) {
    private fun waitForElementAndFindByPath(
        path: String, waitingTime: Long = DEFAULT_WAITING_TIME
    ): WebElement {
        try {
            with(driver) {
                manage().timeouts().implicitlyWait(Duration.ofSeconds(waitingTime))
                return findElement(By.xpath(path))
            }
        } catch (e: Exception) {
            throw e
        }
    }

    private fun waitForElementAndFindByLinkText(
        text: String, waitingTime: Long = DEFAULT_WAITING_TIME
    ): WebElement {
        try {
            with(driver) {
                manage().timeouts().implicitlyWait(Duration.ofSeconds(waitingTime))
                return findElement(By.linkText(text))
            }
        } catch (e: Exception) {
            throw e
        }
    }

    protected fun waitForElementAndClickByPath(
        path: String, waitingTime: Long = DEFAULT_WAITING_TIME
    ) = try {
        waitForElementAndFindByPath(path, waitingTime).click()
    } catch (e: Exception) {
        throw e
    }

    protected fun waitForElementAndSendKeysByPath(
        path: String, text: String, waitingTime: Long = DEFAULT_WAITING_TIME
    ) = try {
        waitForElementAndFindByPath(path, waitingTime).sendKeys(text)
    } catch (e: Exception) {
        throw e
    }

    protected fun waitForElementAndClickByLinkText(
        text: String, waitingTime: Long = DEFAULT_WAITING_TIME
    ) = try {
        waitForElementAndFindByLinkText(text, waitingTime).click()
    } catch (e: Exception) {
        throw e
    }

    protected fun checkIfElementIsFocusedByPath(
        path: String, waitingTime: Long = DEFAULT_WAITING_TIME
    ) = try {
        Assertions.assertEquals(
            waitForElementAndFindByPath(path, waitingTime),
            driver.switchTo().activeElement()
        )
    } catch (e: Exception) {
        throw e
    }

    protected fun checkIfElementTextEqualsExpectedByPath(
        path: String, expectedText: String, waitingTime: Long = DEFAULT_WAITING_TIME
    ) = try {
        Assertions.assertEquals(
            expectedText,
            waitForElementAndFindByPath(path, waitingTime).text
        )
    } catch (e: Exception) {
        throw e
    }

    protected fun clearInputByPath(path: String, waitingTime: Long = DEFAULT_WAITING_TIME) {
        waitForElementAndFindByPath(path, waitingTime).clear()
    }

    protected fun scrollDown() {
        driver.executeScript("window.scrollTo(0, document.body.scrollHeight)")
    }

    protected fun checkIfUrlChanged(url: String, waitingTime: Long = DEFAULT_WAITING_TIME) {
        with(driver) {
            manage().timeouts().implicitlyWait(Duration.ofSeconds(waitingTime))
            Assertions.assertEquals(url, currentUrl)
        }
    }
}