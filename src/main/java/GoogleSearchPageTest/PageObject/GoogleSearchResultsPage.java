package GoogleSearchPageTest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import General.PageSettings.PageSettings;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class GoogleSearchResultsPage extends PageSettings
{
    public GoogleSearchResultsPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> allSearchResultBlocks;

    @FindBy(xpath = "//form[@id='tsf']/.//input[@name='q' and @class='gLFyf gsfi']")
    private WebElement inputField;


    public String getBlockText(int index)
    {
        WebElement searchResultBlock = allSearchResultBlocks.get(index);
        wait.until(ExpectedConditions.visibilityOf(searchResultBlock));

        return searchResultBlock.getText();
    }


    public GoogleSearchResultsPage search(String stringToSearch)
    {
        inputField.click();
        inputField.clear();
        inputField.sendKeys(stringToSearch);
        inputField.submit();

        return new GoogleSearchResultsPage(driver, wait);
    }
}
