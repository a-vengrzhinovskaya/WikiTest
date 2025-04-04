package ui

import org.openqa.selenium.chrome.ChromeDriver

private const val DEFAULT_WAITING_TIME: Long = 5
private const val HEADER_SEARCH_BUTTON_PATH =
    "//*[@class='tm-header-user-menu__item tm-header-user-menu__search']"
private const val SEARCH_FIELD_PATH = "//*[@class='tm-search__input tm-input-text-decorated__input']"
private const val SEARCH_QUERY = "Selenium WebDriver"
private const val SEARCH_FIELD_SEARCH_BUTTON_PATH = "//*[@class='tm-svg-img tm-svg-icon']"
private const val SEARCH_RESULT_TEXT = "Что такое Selenium?"
private const val DATE_PATH = "//*[@title='2012-09-28, 17:14']"
private const val DATE_EXPECTED = "28 сен 2012 в 17:14"
private const val ARTICLES_FOOTER_PATH = "//a[@href='/ru/articles/' and @class='footer-menu__item-link']"

class HabrPageObject(driver: ChromeDriver) : MainPageObject(driver) {
    fun clickSearchInHeader() = waitForElementAndClickByPath(HEADER_SEARCH_BUTTON_PATH, DEFAULT_WAITING_TIME)
    fun checkIfSearchFieldIsFocused() = checkIfElementIsFocusedByPath(SEARCH_FIELD_PATH, DEFAULT_WAITING_TIME)
    fun typeSearchQuery() = waitForElementAndSendKeysByPath(SEARCH_FIELD_PATH, SEARCH_QUERY, DEFAULT_WAITING_TIME)
    fun clickSearchInSearchField() = waitForElementAndClickByPath(SEARCH_FIELD_SEARCH_BUTTON_PATH, DEFAULT_WAITING_TIME)
    fun clickSearchResult() = waitForElementAndClickByLinkText(SEARCH_RESULT_TEXT, DEFAULT_WAITING_TIME)
    fun checkIfDateIsCorrect() = checkIfElementTextEqualsExpectedByPath(DATE_PATH, DATE_EXPECTED, DEFAULT_WAITING_TIME)
    fun scrollToFooter() = scrollDown()
    fun clickArticlesInFooter() = waitForElementAndClickByPath(ARTICLES_FOOTER_PATH, DEFAULT_WAITING_TIME)
}