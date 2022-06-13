package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountPage {
    public static final String URL= "https://stellarburgers.nomoreparties.site/account";

    //локатор поля "Имя"
    //локатор поля "Email"
    //локатор поля "Пароль"
    //Локатор кнопки "Сохранить"
    //локатор кнопки "Отмена"
    //локатор левого меню ("Профиль", "История заказов", "Выход")
    @FindBy(how = How.XPATH, using = ".//*[@class='Account_list__3KQQf mb-20']")
    public SelenideElement accountMenu;

    //локатор вкладки "Профиль" в левом меню
    //локатор вкладки "История заказов" в левом меню
    //локатор вкладки "Выход" в левом меню
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    public SelenideElement logoutButton;

    //метод нажатия на "Выход"
    public void logoutButtonClick() {
        logoutButton.click();
    }


}
