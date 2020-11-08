package QAStack;

import General.TestSettings;
import QAStack.PageObject.QAStackAskPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchingBetweenTabsTest extends TestSettings
{
    @Test
    public void switchBetweenTabs()
    {
        String expectedSourcePageTitle = "Page not found - Super User";

        QAStackAskPage askPage = new QAStackAskPage(driver, wait);
        String askPageDescriptor = askPage.goToAskPage();
        askPage.goToSourcePage();

        Assert.assertEquals(driver.getTitle(), expectedSourcePageTitle);
        driver.switchTo().window(askPageDescriptor);
        Assert.assertEquals(driver.getTitle(), askPage.expectedAskPageTitle);
    }
}
