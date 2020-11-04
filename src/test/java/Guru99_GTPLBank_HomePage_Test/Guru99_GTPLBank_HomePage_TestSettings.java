package Guru99_GTPLBank_HomePage_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Guru99_GTPLBank_HomePage_TestSettings
{
    protected WebDriver     driver;
    protected WebDriverWait wait;

    private int howLongToWait = 4;


    @BeforeTest
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait   = new WebDriverWait(driver, howLongToWait);
    }


    @AfterTest
    public void cleanUp() { driver.quit(); }
}
