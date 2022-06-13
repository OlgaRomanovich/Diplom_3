import PageObject.MainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class DesignerTest {
    @Before
    public void browserSettings() {
        Configuration.startMaximized = true;
    }

    @Test
    @Description("switch between Ingredients")
    @DisplayName("switch between Ingredients")
    public void switchBetweenIngredientsTest() {
        MainPage mainPage=open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.fillingButton.shouldBe(Condition.exist);
        mainPage.fillingButtonClick();
        assertTrue(mainPage.firstFilling.isDisplayed());
        mainPage.bunButtonClick();
        assertTrue(mainPage.firstBun.isDisplayed());
        mainPage.souseButtonClick();
        assertTrue(mainPage.firstSouse.isDisplayed());
    }
}
