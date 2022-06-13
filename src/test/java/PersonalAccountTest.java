import PageObject.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class PersonalAccountTest {

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
    @Description("switch to personal account after login")
    @DisplayName("Switch to personal account")
    public void correctSwitchToPersonalAccount() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.userLoginConfirmation("olga@mail.ru", "qwerty");
        Header header = page(Header.class);
        header.personalAccountButtonClick();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.accountMenu.shouldBe(Condition.exist);
        assertTrue(personalAccountPage.accountMenu.isDisplayed());
    }

    @Test
    @Description("switch from personal account to designer")
    @DisplayName("Switch to designer")
    public void switchFromPersonalAccountToConstructor() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.userLoginConfirmation("olga@mail.ru", "qwerty");
        Header header = page(Header.class);
        header.personalAccountButtonClick();
        header.designerButtonClick();
        MainPage mainPage=page(MainPage.class);
        mainPage.createBurger.shouldBe(Condition.exist);
        assertTrue(mainPage.createBurger.isDisplayed());
    }

    @Test
    @Description("switch from personal account to main page(designer) by logo")
    @DisplayName("Switch to designer")
    public void switchFromPersonalAccountToConstructorByLogo() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.userLoginConfirmation("olga@mail.ru", "qwerty");
        Header header = page(Header.class);
        header.logoButtonClick();
        header.designerButtonClick();
        MainPage mainPage=page(MainPage.class);
        assertTrue(mainPage.createBurger.isDisplayed());

    }
}

