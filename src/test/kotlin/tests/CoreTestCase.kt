package tests

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import java.net.URL

private const val APPIUM_URL = "http://192.168.1.101:4723/"
private const val PACKAGE_NAME = "org.wikipedia"
private const val ACTIVITY_NAME = ".main.MainActivity"
private const val APP_PATH = "D:\\IntellijProjects\\WikiTest\\src\\main\\apk\\org.wikipedia_50522.apk"

abstract class CoreTestCase {
    protected lateinit var driver: AndroidDriver

    @BeforeEach
    fun setUp() {
        driver = initDriver()
    }

    private fun initDriver(): AndroidDriver {
        val options = UiAutomator2Options().apply {
            setApp(APP_PATH)
            setAppPackage(PACKAGE_NAME)
            setAppActivity(ACTIVITY_NAME)
        }
        return AndroidDriver(URL(APPIUM_URL), options)
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}