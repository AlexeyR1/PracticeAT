package MAI;

import General.TestSettings;
import MAI.PageObject.MAIMainPage;
import MAI.PageObject.MAISchedulePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectScheduleTest extends TestSettings
{
    @Test
    public void selectSchedule()
    {
        int expectedElementsNumber = 1;

        MAIMainPage mainPage = new MAIMainPage(driver, wait);
        mainPage.goToMainPage();
        MAISchedulePage schedulePage = mainPage.goToSchedulePage();
        schedulePage.showSchedule();

        Assert.assertEquals(schedulePage.scheduleContentList.size(), expectedElementsNumber);
    }
}
