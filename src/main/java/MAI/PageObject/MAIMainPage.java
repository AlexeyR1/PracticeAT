package MAI.PageObject;

import General.PageSettings.PageSettings;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MAIMainPage extends PageSettings
{
    public MAIMainPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@id='navbar']/.//span[contains(text(), 'Образование')]")
    public WebElement educationLink;

    private final String url           = "https://mai.ru/";
    private final String expectedTitle = "МАИ";


    public void goToMainPage()
    {
        driver.navigate().to(url);
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }


    public MAISchedulePage goToSchedulePage()
    {
        Actions actions = new Actions(driver);

        wait.until(ExpectedConditions.visibilityOf(educationLink));
        WebElement scheduleLink = educationLink.findElement(By.xpath("../..//a[contains(text(), 'Расписание')]"));
        actions.moveToElement(educationLink).moveToElement(scheduleLink).click().perform();

        return new MAISchedulePage(driver, wait);
    }
}
