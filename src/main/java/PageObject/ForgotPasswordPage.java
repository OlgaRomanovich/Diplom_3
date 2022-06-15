package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    public static final String URL= "https://stellarburgers.nomoreparties.site/register/forgot-password";

    //локатор поля "Email"
    @FindBy(how = How.XPATH, using = ".//input[@class='text input__textfield text_type_main-default']")
    private SelenideElement emailField;

    //локатор кнопки "Восстановить"
    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement recoverPasswordButton;

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj']")
    private SelenideElement loginButton;

    public void loginButtonClick() {
        loginButton.click();
    }

}
