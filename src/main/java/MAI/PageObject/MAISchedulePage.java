package MAI.PageObject;

import General.PageSettings.PageSettings;
import MAI.Element.CourseContainerElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MAISchedulePage extends PageSettings
{
    public MAISchedulePage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Отобразить')]")
    public WebElement showScheduleButton;

    @FindBy(xpath = "//select[@id='department']")
    public WebElement department;

    @FindBy(xpath = "//select[@id='course']")
    public WebElement studyCourse;

    public List<CourseContainerElement> courseContainerList = new ArrayList();

    @FindBy(xpath = "//div[@id='schedule-content']/div[@class='sc-container']")
    private List<WebElement> scheduleContentList;


    public void showSchedule()
    {
        selectDepartment();
        selectCourse();
        showScheduleButton.click();

        initializeCourseContainerList();
    }


    private void selectDepartment()
    {
        wait.until(ExpectedConditions.visibilityOf(department));
        Select departmentSelect = new Select(department);
        departmentSelect.selectByValue("Институт №3");
    }


    private void selectCourse()
    {
        wait.until(ExpectedConditions.visibilityOf(studyCourse));
        Select studyCourseSelect = new Select(studyCourse);
        studyCourseSelect.selectByValue("4");
    }


    private void initializeCourseContainerList()
    {
        wait.until(ExpectedConditions.visibilityOfAllElements(scheduleContentList));
        scheduleContentList.forEach(courseContainer -> courseContainerList.add(new CourseContainerElement(courseContainer)));
    }
}
