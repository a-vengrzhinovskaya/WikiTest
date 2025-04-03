package tests

import org.junit.jupiter.api.Test
import org.openqa.selenium.Dimension
import ui.HabrPageObject

private const val BASE_URL = "https://habr.com/ru/articles/"

class HabrTestCase : CoreTestCase() {
    @Test
    fun testSearch() {
        driver.apply {
            manage().window().size = Dimension(1920, 1080)
            get(BASE_URL)
        }
        with(HabrPageObject(driver)) {
            clickSearchInHeader()
            checkIfSearchFieldIsFocused()
            typeSearchQuery()
            clickSearchInSearchField()
            clickSearchResult()
            checkIfDateIsCorrect()
            scrollToFooter()
            clickArticlesInFooter()
        }
    }
}