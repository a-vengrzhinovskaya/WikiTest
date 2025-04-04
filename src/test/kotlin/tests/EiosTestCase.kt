package tests

import org.junit.jupiter.api.Test
import org.openqa.selenium.Dimension
import ui.SignInPageObject

private const val BASE_URL = "https://eios.kemsu.ru/a/eios"

class EiosTestCase : CoreTestCase() {
    @Test
    fun testSignIn() {
        driver.apply {
            manage().window().size = Dimension(1920, 1080)
            get(BASE_URL)
        }
        with(SignInPageObject(driver)) {
            clearLogin()
            clearPassword()
            typeLogin()
            typePassword()
            clickSingInButton()
            checkName()
            logOut()
            checkIfLogOutSuccessful(BASE_URL)
        }
    }
}