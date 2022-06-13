import PageObject.Header;
import PageObject.LoginPage;
import PageObject.PersonalAccountPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LogoutTest {
    @Before
    public void browserSettings() {
        Configuration.startMaximized = true;
    }

    @Test
    @Description("Logout after login")
    @DisplayName("Logout after login")
    public void logoutTest() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.userLoginConfirmation("olga@mail.ru", "qwerty");
        Header header = page(Header.class);
        header.personalAccountButtonClick();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.logoutButtonClick();
        LoginPage loginpage=page(LoginPage.class);
        loginpage.loginButton.shouldBe(Condition.exist);
        assertTrue(loginpage.loginButton.isDisplayed());
    }
}
