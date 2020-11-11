package MAI;

import General.TestSettings;
import MAI.Element.CourseContainerElement;
import MAI.PageObject.MAIMainPage;
import MAI.PageObject.MAISchedulePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectScheduleTest extends TestSettings
{
    @Test
    public void selectSchedule()
    {
        int expectedCourseContainerElementsNumber = 1;
        String expectedCourseNumber = "4 курс";
        int expectedDepartmentsNumber = 1;
        String expectedDepartmentNumber = "Институт №3";

        MAIMainPage mainPage = new MAIMainPage(driver, wait);
        mainPage.goToMainPage();
        MAISchedulePage schedulePage = mainPage.goToSchedulePage();
        schedulePage.showSchedule();

        Assert.assertEquals(schedulePage.courseContainerList.size(), expectedCourseContainerElementsNumber);
        Assert.assertEquals(schedulePage.courseContainerList.get(0).courseNumber.getText(), expectedCourseNumber);
        Assert.assertEquals(schedulePage.courseContainerList.get(0).departments.size(), expectedDepartmentsNumber);
        Assert.assertEquals(schedulePage.courseContainerList.get(0).departments.get(0).getText(), expectedDepartmentNumber);
    }
}
