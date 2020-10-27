import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest
{
    @Test
    void goToGooglePage()
    {
        String expectedResult = "Google";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        String actualResult = driver.getTitle();
        System.out.println(actualResult);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
