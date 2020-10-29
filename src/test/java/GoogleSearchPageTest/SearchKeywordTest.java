package GoogleSearchPageTest;

import GoogleSearchPageTest.PageObject.GoogleSearchResultsPage;
import GoogleSearchPageTest.PageObject.MainGooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.String;

public class SearchKeywordTest extends SearchKeywordTestSettings
{
    @Test
    public void findAllKeywords()
    {
        MainGooglePage mainGooglePage = new MainGooglePage(driver, wait);
        GoogleSearchResultsPage googleSearchResultsPage;

        String searchResultBlockText;
        String keyword;

        String[] keywordsToSearch = mainGooglePage.getKeywordsToSearch();

        int actualResult = 0;
        int expectedResult = keywordsToSearch.length;


        mainGooglePage.goToGooglePage();

        // Первый поиск осуществляется со страницы google.com
        googleSearchResultsPage = mainGooglePage.search(keywordsToSearch[0]);

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
