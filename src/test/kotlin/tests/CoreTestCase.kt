package tests

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions


abstract class CoreTestCase {
    protected lateinit var driver: ChromeDriver

    @BeforeEach
    fun setUp() {
        driver = initDriver()
    }

    private fun initDriver(): ChromeDriver {
        System.setProperty(
            "webdriver.chrome.driver",
            "D:\\IntellijProjects\\WikiTest\\src\\main\\driver\\chromedriver.exe"
        )
        val chromeOptions = ChromeOptions().apply { addArguments("--remote-allow-origins=*") }
        return ChromeDriver(chromeOptions)
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}