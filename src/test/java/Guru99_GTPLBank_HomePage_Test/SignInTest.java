package Guru99_GTPLBank_HomePage_Test;

import Guru99_GTPLBank_HomePage_Test.PageObject.GTPLBank_HomePage;
import Guru99_GTPLBank_HomePage_Test.PageObject.Guru99Bank_HomePage;
import Guru99_GTPLBank_HomePage_Test.PageObject.Guru99Bank_HomePageWithSignInData;
import Guru99_GTPLBank_HomePage_Test.PageObject.Guru99ManagerHomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignInTest extends Guru99_GTPLBank_HomePage_TestSettings
{
    @Test
    @Parameters({"email"})
    public void signIn(String email)
    {
        String expectedResult = "GTPL Bank Manager HomePage";

        GTPLBank_HomePage GTPLBankHomePage = new GTPLBank_HomePage(driver, wait);
        GTPLBankHomePage.goToGPTLBank();
        Guru99Bank_HomePage Guru99Bank_HomePage = GTPLBankHomePage.visitGettingSignInAccessSite();
        Guru99Bank_HomePageWithSignInData Guru99Bank_HomePageWithSignInData = Guru99Bank_HomePage.getSignInAccess(email);

        String login = Guru99Bank_HomePageWithSignInData.getLogin();
        String password = Guru99Bank_HomePageWithSignInData.getPassword();

        GTPLBankHomePage = Guru99Bank_HomePageWithSignInData.goToGTPLBank();
        Guru99ManagerHomePage Guru99ManagerHomePage = GTPLBankHomePage.signIn(login, password);

        Assert.assertEquals(expectedResult, Guru99ManagerHomePage.getPageTitle());
    }
}
