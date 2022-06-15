import pageObject.MainPage;
import com.codeborne.selenide.Condition;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.open;
public class DesignerTest {

    @Test
    @Description("switch between Ingredients")
    @DisplayName("Check souse section selected")
    public void goToSauceSection() throws InterruptedException {
       MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.souseButton.shouldBe(enabled);
        mainPage.souseButtonClick();
        Thread.sleep(5000);
        Assertions.assertFalse(mainPage.bunButton.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
        Assertions.assertTrue(mainPage.souseButton.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
        Assertions.assertFalse(mainPage.fillingButton.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
    }
    @Test
    @DisplayName("switch between Ingredients")
    @Description("Check bun section selected")
    public void goToBunSection() throws InterruptedException {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.souseButtonClick();
        Thread.sleep(5000);
        mainPage.bunButtonClick();
        Thread.sleep(5000);
        Assertions.assertTrue(mainPage.bunButton.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
        Assertions.assertFalse(mainPage.souseButton.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
        Assertions.assertFalse(mainPage.fillingButton.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
    }

    @Test
    @DisplayName("switch between Ingredients")
    @Description("Check filling section selected")
    public void goToFillingSection() throws InterruptedException {
       MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.fillingButton.shouldBe(Condition.exist, Duration.ofMillis(10000));
        mainPage.fillingButtonClick();
        Thread.sleep(5000);
        Assertions.assertFalse(mainPage.bunButton.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
        Assertions.assertFalse(mainPage.souseButton.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
        Assertions.assertTrue(mainPage.fillingButton.find(new By.ByXPath("..")).getAttribute("class").contains("current"));
    }

}
