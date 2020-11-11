package QAStack.PageObject;

import General.PageSettings.PageSettings;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class QAStackAskPage extends PageSettings
{
    public QAStackAskPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//article[@class='media'][1]/.//span[@class='icon-new-window']/..")
    public WebElement sourceLink;

    public final String expectedAskPageTitle = "Как сделать, чтобы Chrome открывал закладки и URL в новых вкладках?";

    private final String url = "https://qastack.ru/superuser/166871/how-to-make-chrome-open-bookmarks" + "-and-urls" +
            "-in" + "-new-tabs";


    public String goToAskPage()
    {
        driver.navigate().to(url);
        Assert.assertEquals(expectedAskPageTitle, driver.getTitle());

        return driver.getWindowHandle();
    }


    public String goToSourcePage()
    {
        Set<String> oldOpenedWindowsSet = driver.getWindowHandles();

        wait.until(ExpectedConditions.visibilityOf(sourceLink));
        sourceLink.click();

        String newOpenedWindow = getNewOpenedWindowDescriptor(oldOpenedWindowsSet);
        driver.switchTo().window(newOpenedWindow);

        return newOpenedWindow;
    }


    private String getNewOpenedWindowDescriptor(Set<String> oldOpenedWindowsSet)
    {
        wait.until(ExpectedConditions.numberOfWindowsToBe(oldOpenedWindowsSet.size() + 1));
        Set<String> newOpenedWindowsSet = driver.getWindowHandles();
        newOpenedWindowsSet.removeAll(oldOpenedWindowsSet);

        return newOpenedWindowsSet.iterator().next();
    }
}
