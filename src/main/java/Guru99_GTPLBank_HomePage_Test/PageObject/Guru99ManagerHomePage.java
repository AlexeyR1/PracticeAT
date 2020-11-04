package Guru99_GTPLBank_HomePage_Test.PageObject;

import General.PageSettings.PageSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Guru99ManagerHomePage extends PageSettings
{
    public Guru99ManagerHomePage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
    }


    public String getPageTitle() { return driver.getTitle(); }
}
