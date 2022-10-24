import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class MainPage {

    public static final String URL = "http://127.0.0.1:8043/";

    //Поиск кнопки Test Case 12223
    @FindBy(how = How.ID, using = "72384")
    private SelenideElement buttonMethods;

    @FindBy(how = How.ID, using = "91113")
    private SelenideElement buttonFiltersRt;

    /**
     * Клик по кнопке для перехода на страницу Методов
     */
    @Step
    public void clickButtonMethods() {
        buttonMethods.click();

    }

    /**
     * Клик по кнопке для перехода на страницу Фильтры RT
     */
    @Step
    public void clickButtonFiltersRt() {
        buttonFiltersRt.click();

    }
}
