package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;

// Эта страница является разделом "Конструктор"
public class MainPage {
    public static final String URL= "https://stellarburgers.nomoreparties.site/";

    //локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement loginButton;

    // локатор надписи "Соберите бургер"
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-large mb-5 mt-10']")
    public SelenideElement createBurger;

    // локатор кнопки "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunButton;

    // локатор первой позиции в разделе "Булки"
    @FindBy(how = How.XPATH, using = ".//p[text()='Флюоресцентная булка R2-D3']")
    public SelenideElement firstBun;


    // локатор кнопки "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement souseButton;

    // локатор первой позиции в разделе "Соусы"
    @FindBy(how = How.XPATH, using = ".//p[text()='Соус Spicy-X']")
    public SelenideElement firstSouse;

    // локатор кнопки "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    public SelenideElement fillingButton;

    // локатор первой позиции в разделе "Начинки"
    @FindBy(how = How.XPATH, using = ".//p[text()='Мясо бессмертных моллюсков Protostomia']")
    public SelenideElement firstFilling;

    //локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public SelenideElement createOrderButton;

    //метод нажатия кнопки "Войти в аккаунт"
    public void loginButtonClick() {
        loginButton.click();
    }

    //метод нажатия на вкладку "Соусы"
    public void souseButtonClick() {souseButton.click();}

    //метод нажатия на вкладку "Булки"
    public void bunButtonClick() {bunButton.click();}

    //метод нажатия на вкладку "Начинки"
    public void fillingButtonClick() {fillingButton.click();}


}
