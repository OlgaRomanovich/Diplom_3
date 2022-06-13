package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Header {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //локатор логотипа "Stellar Burgers"
    @FindBy(how = How.XPATH, using = ".//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoButton;

    // локатор кнопки "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement designerButton;

   // локатор Кнопки "Личный кабинет"
   @FindBy(how = How.XPATH, using = ".//*[text()='Личный Кабинет']")
   private static SelenideElement personalAccountButton;

   // локатор кнопки "Лента заказов"
   @FindBy(how = How.XPATH, using = ".//p[text()='Лента заказов']")
   private SelenideElement orderFeedButton;


    //метод нажатия кнопки "Личный кабинет"
    public void personalAccountButtonClick() {
        personalAccountButton.click();
    }

    //метод нажатия кнопки "Конструктор"
    public void designerButtonClick() {
        designerButton.click();
    }

    //метод нажатия на логотип
    public void logoButtonClick() {
        logoButton.click();
    }
}