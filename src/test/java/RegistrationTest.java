import pageObject.LoginPage;
import pageObject.RegisterPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {


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
    public void successfulRegistration() throws InterruptedException {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        registerPage.userConfirmation("Ivan Ivanov", "petrov3211@mail.ru", "qwerty");
        registerPage.registrationButton.shouldBe(enabled);
        registerPage.registrationButtonClick();
        LoginPage loginPage = page(LoginPage.class);
        Thread.sleep(5000);
        Assertions.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
