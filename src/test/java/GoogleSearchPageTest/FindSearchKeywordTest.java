package GoogleSearchPageTest;

import GoogleSearchPageTest.PageObject.GoogleSearchResultsPage;
import GoogleSearchPageTest.PageObject.GoogleMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.String;

public class FindSearchKeywordTest extends GoogleSearchPageTestSettings
{
    @Test
    public void findAllSearchKeywords()
    {
        GoogleMainPage googleMainPage = new GoogleMainPage(driver, wait);
        GoogleSearchResultsPage googleSearchResultsPage;

        String searchResultBlockText;
        String keyword;

        String[] keywordsToSearch = googleMainPage.getKeywordsToSearch();

        int actualResult = 0;
        int expectedResult = keywordsToSearch.length;


        googleMainPage.goToGooglePage();

        // Первый поиск осуществляется со страницы google.com
        googleSearchResultsPage = googleMainPage.search(keywordsToSearch[0]);

        for (int i = 0; i < keywordsToSearch.length; i++)
        {
            keyword = keywordsToSearch[i];

            // Последующий поиск осуществляется со страницы результатов поиска введенного ранее слова
            if (i != 0) googleSearchResultsPage = googleSearchResultsPage.search(keyword);

            // Ищем только в первом блоке результатов поиска
            searchResultBlockText = googleSearchResultsPage.getBlockText(0);

            // Полученный текстовый блок содержит в себе поисковое слово
            if (searchResultBlockText.toLowerCase().contains(keyword)) actualResult++;
        }

        Assert.assertEquals(actualResult, expectedResult);
    }
}
