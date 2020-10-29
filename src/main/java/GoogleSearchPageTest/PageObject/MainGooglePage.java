package GoogleSearchPageTest.PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import General.PageSettings.PageSettings;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainGooglePage extends PageSettings
{
    public MainGooglePage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//form[@id='tsf']/.//input[@name='q' and  @class='gLFyf gsfi']")
    private WebElement inputField;

    private final String expectedPageTitle = "Google";
    private final String url               = "https://google.com";

    private String[] keywordsToSearch = new String[] { "hello", "world", "c#", "cool", "language" };


    public String[] getKeywordsToSearch() { return keywordsToSearch; }


    public void goToGooglePage()
    {
        driver.navigate().to(url);
        Assert.assertEquals(expectedPageTitle, driver.getTitle());
    }


    public GoogleSearchResultsPage search(String stringToSearch)
    {
        wait.until(ExpectedConditions.visibilityOf(inputField));
        inputField.click();
        inputField.sendKeys(stringToSearch);
        inputField.submit();

        return new GoogleSearchResultsPage(driver, wait);
    }
}
