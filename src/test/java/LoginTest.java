import PageObject.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.*;

public class  LoginTest {
    @Before
    public void browserSettings() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void logout() {
        PersonalAccountPage mainPage = open(PersonalAccountPage.URL, PersonalAccountPage.class);
        mainPage.logoutButton.click();
        LoginPage loginpage = page(LoginPage.class);
        loginpage.loginButton.shouldBe(Condition.exist);
    }


    @Test
    @Description("Login from main page")
    @DisplayName("Login from main page")
    public void successfulLoginFromMainPage() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.loginButtonClick();
        LoginPage loginpage = page(LoginPage.class);
        loginpage.userLoginConfirmation("olga@mail.ru", "qwerty");
        MainPage mainPage1 = page(MainPage.class);
        mainPage.createOrderButton.shouldBe(Condition.exist);
        assertTrue(mainPage1.createOrderButton.isDisplayed()); //нажимается кнопка здесь.

    }

    @Test
    @Description("Login from personal account page")
    @DisplayName("Login from personal account page")
    public void successfulLoginFromPersonalAccountPage() {
        Header header= open("https://stellarburgers.nomoreparties.site", Header.class);
        header.personalAccountButtonClick();
        LoginPage loginpage = page(LoginPage.class);
        loginpage.userLoginConfirmation("olga@mail.ru", "qwerty");
        MainPage mainPage = page(MainPage.class);
        mainPage.createOrderButton.shouldBe(Condition.exist);
        assertTrue(mainPage.createOrderButton.isDisplayed());

    }

    @Test
    @Description("Login from register page")
    @DisplayName("Login from register page")
    public void successfulLoginFromRegistrationPage() {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        registerPage.logInButtonClick();
        LoginPage loginpage = page(LoginPage.class);
        loginpage.userLoginConfirmation("olga@mail.ru", "qwerty");
        MainPage mainPage = page(MainPage.class);
        mainPage.createOrderButton.shouldBe(Condition.exist);
        assertTrue(mainPage.createOrderButton.isDisplayed());


    }

    @Test
    @Description("Login after pressing on recover password button")
    @DisplayName("Login after pressing on recover password button")
    public void successfulLoginFromRecoverPasswordPage() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.recoverPasswordButton.shouldBe(Condition.exist);
        //loginPage.recoverPasswordButton.shouldBe(Condition.exist);
        loginPage.recoverPasswordButtonClick();
        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.loginButtonClick();
        LoginPage loginpage = page(LoginPage.class);
        loginpage.userLoginConfirmation("olga@mail.ru", "qwerty");
        MainPage mainPage = page(MainPage.class);
        mainPage.createOrderButton.shouldBe(Condition.exist);
        assertTrue(mainPage.createOrderButton.isDisplayed());
    }
}
