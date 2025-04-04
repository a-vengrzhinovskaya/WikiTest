package tests

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverLogLevel
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.logging.LogType


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
        System.setProperty("webdriver.chrome.logfile", "D:\\chromedriver.log"); //записываем логи в файл

        val chromeOptions =
            ChromeOptions().apply {
                logLevel = ChromeDriverLogLevel.ALL
                setCapability("goog:loggingPrefs", mapOf("driver" to "INFO"))
                addArguments("--remote-allow-origins=*") //нужно для Selenium <4.8.2 версии
            }
        return ChromeDriver(chromeOptions)
    }

    @AfterEach
    fun tearDown() {
        driver.manage().logs().get(LogType.DRIVER).forEach { println(it.message) }
        driver.quit()
    }
}