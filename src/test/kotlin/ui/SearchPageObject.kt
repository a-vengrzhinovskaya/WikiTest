package ui

import io.appium.java_client.android.AndroidDriver

private const val DEFAULT_WAITING_TIME: Long = 10
private const val SKIP_PATH = "//*[@text='Пропустить']"
private const val SEARCH_PATH = "//*[@text='Поиск по Википедии']"
private const val SEARCH_QUERY = "хоббит, или туда и обратно"
private const val SEARCH_RESULT = "//*[@text='Хоббит, или Туда и обратно']"
private const val SAVE_BUTTON_PATH = "//*[@text='Сохранить']"
private const val ADD_TO_LIST_PATH = "//*[@text='Добавить в список']"
private const val LIST_NAME_TEXT_FIELD_PATH = "//*[@text='Название этого списка']"
private const val LIST_NAME = "hobbit"
private const val OK_BUTTON_PATH = "//*[@text='ОК']"
private const val HIGHLIGHT_BUTTON_PATH = "//*[@text='Понятно']"
private const val OPEN_LIST_BUTTON_PATH = "//*[@text='Посмотреть список']"
private const val OPTIONS_BUTTON_PATH = "//*[@resource-id='org.wikipedia:id/item_overflow_menu']"
private const val DELETE_LIST_BUTTON_PATH = "//*[@text='Удалить список']"

class SearchPageObject(driver: AndroidDriver) : MainPageObject(driver) {
    fun skipOnboarding() = waitForElementAndClickByPath(SKIP_PATH, DEFAULT_WAITING_TIME)
    fun clickSearchField() = waitForElementAndClickByPath(SEARCH_PATH, DEFAULT_WAITING_TIME)
    fun typeSearchQuery() = waitForElementAndSendKeysByPath(SEARCH_PATH, SEARCH_QUERY, DEFAULT_WAITING_TIME)
    fun clickSearchResult() = waitForElementAndClickByPath(SEARCH_RESULT, DEFAULT_WAITING_TIME)
    fun clickSaveButton() = waitForElementAndClickByPath(SAVE_BUTTON_PATH, DEFAULT_WAITING_TIME)
    fun clickAddToList() = waitForElementAndClickByPath(ADD_TO_LIST_PATH, DEFAULT_WAITING_TIME)
    fun typeListName() = waitForElementAndSendKeysByPath(LIST_NAME_TEXT_FIELD_PATH, LIST_NAME, DEFAULT_WAITING_TIME)
    fun clickOkButton() = waitForElementAndClickByPath(OK_BUTTON_PATH, DEFAULT_WAITING_TIME)
    fun clickOpenListButton() = waitForElementAndClickByPath(OPEN_LIST_BUTTON_PATH, DEFAULT_WAITING_TIME)
    fun clickHighlightButton() = waitForElementAndClickByPath(HIGHLIGHT_BUTTON_PATH, DEFAULT_WAITING_TIME)
    fun clickOptionsButton() = waitForElementAndClickByPath(OPTIONS_BUTTON_PATH, DEFAULT_WAITING_TIME)
    fun clickDeleteListButton() = waitForElementAndClickByPath(DELETE_LIST_BUTTON_PATH, DEFAULT_WAITING_TIME)
}