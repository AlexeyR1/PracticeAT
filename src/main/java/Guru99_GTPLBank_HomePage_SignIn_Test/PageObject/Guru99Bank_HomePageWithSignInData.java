package Guru99_GTPLBank_HomePage_SignIn_Test.PageObject;

import General.PageSettings.PageSettings;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Guru99Bank_HomePageWithSignInData extends PageSettings
{
    public Guru99Bank_HomePageWithSignInData(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//table/.//td[@class='accpage' and contains(text(), 'User ID')]/following-sibling::td[1]")
    private WebElement userIDData;

    @FindBy(xpath = "//table/.//td[@class='accpage' and contains(text(), 'Password')]/following-sibling::td[1]")
    private WebElement passwordData;


    public String getLogin()
    {
        wait.until(ExpectedConditions.visibilityOf(userIDData));
        return userIDData.getText();
    }


    public String getPassword()
    {
        wait.until(ExpectedConditions.visibilityOf(passwordData));
        return passwordData.getText();
    }


    public GTPLBank_HomePage goToGTPLBank(GTPLBank_HomePage GTPLBankHomePage)
    {
        GTPLBankHomePage.goToGPTLBank();

        return new GTPLBank_HomePage(driver, wait);
    }
}
