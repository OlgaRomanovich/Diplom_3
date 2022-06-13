import PageObject.LoginPage;
import PageObject.RegisterPage;
import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    @Before
    public void browserSettings() {
        Configuration.startMaximized = true;
    }

    @Test
    @Description("Registration with invalid password")
    @DisplayName("Registration with invalid password")
    public void incorrectPasswordRegistration() {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        registerPage.userConfirmation("Ivan", "olga_ivan@mail.ru", "qwer");
        registerPage.registrationButtonClick();
        assertTrue(registerPage.errorText.isDisplayed());
    }

    @Test
    @Description("Successful registration with valid creds")
    @DisplayName("Successful registration with valid creds")
    public void successfulRegistration() {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        registerPage.userConfirmation("IvanPetrov", "petrov31@mail.ru", "qwerty");
        registerPage.registrationButton.shouldBe(enabled);
        registerPage.registrationButtonClick();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginButton.shouldBe(enabled);
        assertTrue(loginPage.loginButton.isDisplayed());
    }
}
