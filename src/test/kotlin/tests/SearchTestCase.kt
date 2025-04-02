package tests

import org.junit.jupiter.api.Test
import ui.SearchPageObject

class SearchTestCase : CoreTestCase() {
    @Test
    fun testSearch() = with(SearchPageObject(driver)) {
        skipOnboarding()
        clickSearchField()
        typeSearchQuery()
        clickSearchResult()
        clickSaveButton()
        clickAddToList()
        typeListName()
        clickOkButton()
        clickOpenListButton()
        clickHighlightButton()
        clickOptionsButton()
        clickDeleteListButton()
        clickOkButton()
    }
}