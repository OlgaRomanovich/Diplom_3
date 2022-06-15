package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {
    public static final String URL= "https://stellarburgers.nomoreparties.site/register/";

    //локатор поля "Имя"
    @FindBy(how = How.XPATH, using =".//input[@name='name']")
    private SelenideElement nameField;
    // локатор поля "Email"
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailField;
    // локатор поля "Пароль"
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordField;

    // локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    public SelenideElement registrationButton;

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj']")
    private SelenideElement logInButton;

    //локатор текста ошибки заполнения поля "Пароль"
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    public SelenideElement errorText;

    //метод нажатия кнопки "Войти"
    public void logInButtonClick() {
        logInButton.click();
    }

    //метод нажатия кнопки "Зарегистрироваться"
    public void registrationButtonClick() {
        registrationButton.click();
    }

    public void setUserName(String name) {
        nameField.setValue(name);
    }
    public void setUserEmail(String email) {
        emailField.setValue(email);
    }
    public void setUserPassword(String password) {
        passwordField.setValue(password);
    }

    //метод заполнения полей формы регистрации
    public void userConfirmation(String name, String email, String password) {
        setUserName(name);
        setUserEmail(email);
        setUserPassword(password);
    }

}
