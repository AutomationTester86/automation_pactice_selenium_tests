package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class FailedLoginWithoutRequiredDataTest extends TestBase {


    @Test
    public void asUserLoginWithIncorrectLoginAndPassword() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.
                typeIntoUsernameField("").
                typeIntoPasswordField("").
                clickOnLoginButton();

        String message = loginPage.getMessage();
        assertTrue(message.contains("An email address required."));
    }

}
