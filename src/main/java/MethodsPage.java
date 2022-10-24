import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByShadow;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import au.com.bytecode.opencsv.CSVReader;

public class MethodsPage {
    String filePath = "";

    //Поиск кнопки активации тревог
    @FindBy(how = How.ID, using = "73352")
    private SelenideElement buttonAlarmsActivation;

    //Поиск кнопки Следующая страница для архивного журнала
    @FindBy(how = How.ID, using = "72850")
    private SelenideElement buttonNextPage;

    //Поиск кнопки Предыдущая страница для архивного журнала
    @FindBy(how = How.ID, using = "72885")
    private SelenideElement buttonPreviousPage;

    //Поиск кнопки Первая страница для архивного журнала
    @FindBy(how = How.ID, using = "72919")
    private SelenideElement buttonFirstPage;

    //Поиск кнопки Последняя страница для архивного журнала
    @FindBy(how = How.ID, using = "72953")
    private SelenideElement buttonLastPage;

    //Поиск кнопки Обновить для архивного журнала
    @FindBy(how = How.ID, using = "72987")
    private SelenideElement buttonRefresh;

    //Поиск кнопки Квитировать сообщение для архивного журнала
    @FindBy(how = How.ID, using = "73021")
    private SelenideElement buttonAckEvent;

    //Поиск кнопки Следующее сообщение для архивного журнала
    @FindBy(how = How.ID, using = "73055")
    private SelenideElement buttonNextEvent;

    //Поиск кнопки Предыдущее сообщение для архивного журнала
    @FindBy(how = How.ID, using = "73089")
    private SelenideElement buttonPreviousEvent;

    //Поиск кнопки Показать легенду для архивного журнала
    @FindBy(how = How.ID, using = "73123")
    private SelenideElement buttonShowLegend;

    //Поиск кнопки Печать для архивного журнала
    @FindBy(how = How.ID, using = "73157")
    private SelenideElement buttonPrint;

    //Поиск кнопки Квитировать на странице для архивного журнала
    @FindBy(how = How.ID, using = "73191")
    private SelenideElement buttonAckPage;

    //Поиск кнопки Экспортировать для архивного журнала
    @FindBy(how = How.ID, using = "73225")
    private SelenideElement buttonExport;

    //Поиск кнопки Открыть дерево объекта для архивного журнала
    @FindBy(how = How.ID, using = "73259")
    private SelenideElement buttonOpenTree;

    //Поиск кнопки Переход по дате
    @FindBy(how = How.ID, using = "73293")
    private SelenideElement buttonGoToDate;

    //Поиск кнопки Отображать строку статуса
    @FindBy(how = How.ID, using = "83008")
    private SelenideElement buttonStringStatus;

    @FindBy(how = How.CSS, using = "#down")
    private ElementsCollection buttonYearDown;

    @FindBy(how = How.CSS, using = "#save")
    private SelenideElement buttonSave;

    //-------------------------------------------------------------------------------------------------------------------

    public MethodsPage() {

    }

    /**
     * Клик по кнопке Активации тревог
     */
    @Step
    public MethodsPage clickButtonAlarmsActivation() {
        buttonAlarmsActivation.shouldBe(visible).click();
        $(shadowCss(".ack", "#\\37 2420")).shouldBe(visible);
        System.err.println("Тревоги активированы");

        return this;
    }

    /**
     * Клик по кнопке Следующая станица для архивного журнала
     */
    @Step
    public void clickButtonNextPage() {
        buttonNextPage.click();
    }

    /**
     * Клик по кнопке Предыдущая страница для архивного журнала
     */
    @Step
    public void clickButtonPreviousPage() {
        buttonPreviousPage.click();
    }

    /**
     * Клик по кнопке Первая страница для архивного журнала
     */
    @Step
    public void clickButtonFirstPage() {
        buttonFirstPage.click();
    }

    /**
     * Клик по кнопке Последняя страница для архивного журнала
     */
    @Step
    public void clickButtonLastPage() {
        buttonLastPage.click();

    }

    /**
     * Клик по кнопке Обновить для архивного журнала
     */
    @Step
    public void clickButtonRefresh() {
        buttonRefresh.click();
    }

    /**
     * Клик по кнопке Квитировать для архивного журнала
     */
    @Step
    public void clickButtonAckEvent() {
        buttonAckEvent.click();
    }

    /**
     * Клик по кнопке Следующее сообщение для архивного журнала
     */
    @Step
    public void clickNextEvent() {
        buttonNextEvent.click();
    }

    /**
     * Клик по кнопке Следующее сообщение для архивного журнала
     */
    @Step
    public void clickPreviousEvent() {
        buttonPreviousEvent.click();
    }

    /**
     * Клик по кнопке показать Легенду для Архивного журнала
     */
    @Step
    public void clickButtonShowLegend() {
        buttonShowLegend.click();
    }

    /**
     * Клик по кнопке Печать для архивного журнала
     */
    @Step
    public void clickButtonPrint() {
        buttonPrint.click();
    }

    /**
     * Клик по кнопке Квитировать на странице
     */
    @Step
    public void clickButtonAckPage() {
        buttonAckPage.click();
    }

    /**
     * Клик по кнопку Отображать строку статуса
     */
    @Step
    public MethodsPage clickButtonStringStatus() {
        buttonStringStatus.shouldBe(visible).click();
        return this;
    }

    /**
     * Клик по кнопке Открыть дерево для архивного журнала
     */
    @Step
    public void clickButtonOpenTree() {
        buttonOpenTree.click();
    }

    /**
     * Проверка открытия дерева для архивного журнала (есть ли чек-бокс)
     */
    @Step
    public boolean isTreeVisible() {
        $(ByShadow.cssSelector("#\\37 2150", "body > div:nth-child(7) > ms-popup > ms-tree"))
                .shouldBe(visible);
        return true;
    }

    /**
     * Проверка появления легенды (есть ли слово Время)
     */
    @Step
    public boolean isLegendVisible() {
        $(ByShadow.cssSelector("#footer > table > tbody > tr:nth-child(1) > td:nth-child(1)",
                "#\\37 2420")).shouldBe(visible);
        return true;
    }

    /**
     * Подсчет кол-ва сообщений в архивном журнале
     */
    @Step
    public int countEvents() {
        ElementsCollection elements = $$(shadowCss(".ack", "#\\37 2420"));
        return elements.size();
    }

    /**
     * Поиск самого верхнего сообщения в архивном журнале и клик по нему
     */
    public MethodsPage clickEvent() {
        SelenideElement elementEvent = $(ByShadow.cssSelector("td:nth-child(4)", "#\\37 2420"));
        elementEvent.shouldBe(visible).click();
        return this;
    }

    /**
     * Наличие SVG стрелочки у первого сверху элемента архивного журнала
     */
    public boolean getArrowSVGEventFirst() {
        $(ByShadow.cssSelector("tr:nth-child(1) >td:nth-child(1) > svg",
                "#\\37 2420")).shouldBe(visible);
        return true;
    }

    /**
     * Наличие SVG стрелочки у второго сверху элемента архивного журнала
     */
    public boolean getArrowSVGEventSecond() {
        $(ByShadow.cssSelector("tr:nth-child(2) >td:nth-child(1) > svg",
                "#\\37 2420")).shouldBe(visible);
        return true;
    }

    /**
     * Проверка перемещения сообщений вниз в рабочей области журнала
     */
    public MethodsPage isEventsHaveShiftedDown() {
        String s = "position: absolute; top: 56px; height: 88px; left: 22px; width: 4px; " +
                "background-color: transparent; cursor: col-resize; z-index: 1;";
        $(ByShadow.cssSelector("#sp", "#\\37 2420"))
                .shouldBe(Condition.attribute("style", s));
        return this;

    }

    /**
     * Проверка перемещения сообщений вверх в рабочей области журнала
     */
    public MethodsPage isEventsHaveShiftedUp() {
        String s = "position: absolute; top: 0px; height: 88px; left: 22px; width: 4px; " +
                "background-color: transparent; cursor: col-resize; z-index: 1;";
        $(ByShadow.cssSelector("#sp", "#\\37 2420"))
                .shouldBe(Condition.attribute("style", s));
        return this;

    }

    public boolean isFirstPage() {
        String s = "position: absolute; top: 0px; height: 88px; left: 22px; width: 4px; " +
                "background-color: transparent; cursor: col-resize; z-index: 1;";
        $(ByShadow.cssSelector("#sp", "#\\37 2420"))
                .shouldBe(Condition.attribute("style", s));
        return true;
    }

    /**
     * Проверка перемещения сообщений вниз (последняя страница) в рабочей области журнала
     */
    public MethodsPage isLastPage() {
        String s = "position: absolute; top: 33px; height: 111px; left: 22px; width: 4px;" +
                " background-color: transparent; cursor: col-resize; z-index: 1;";
        $(ByShadow.cssSelector("#sp", "#\\37 2420"))
                .shouldBe(Condition.attribute("style", s));
        return this;

    }

    /**
     * Клик по кнопке Экспортировать
     */
    @Step
    public void clickButtonExport() {
        File file;
        Configuration.fileDownload = FOLDER;

        try {
            file = buttonExport.download();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        filePath = file.getParent();
        System.err.println("FILE Path: " + filePath);

    }

    /**
     * Чтение 2-ой строки файла journal.csv
     */
    @Step
    public String checkFileCSV() throws IOException {

        List<String[]> allRows;
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(filePath + "\\journal.csv"), ',', '"', 1);
            allRows = reader.readAll();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                assert reader != null;
                reader.close();
            }catch (IOException e){
                System.err.println("Error" + e);
            }
        }

        for(String[] row : allRows){
            System.err.println(Arrays.toString(row));
        }
        String s = Arrays.toString(allRows.get(0));
        String[] words = s.split(";");

        return words[2];

    }

    /**
     * Удаление CSV файла
     */
    public void deleteCSV() {
        try {
            FileUtils.deleteDirectory(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.err.println("Файл journal.csv удален");
    }

    /**
     * Отжатие кнопки активации тревог, если на момент теста кнопка нажата
     */
    public void clickButtonAlarmsDeactivation() {
        String buttonClass = $(ByShadow.cssSelector("div", "#\\37 3352")).getAttribute("class");
        assert buttonClass != null;
        if (buttonClass.equals("tbmain button active")) {
            buttonAlarmsActivation.click();
            System.err.println("Тревоги деактивированы");
        }
    }

    /**
     * Включить автопрокрутку, если она выключена
     */
    public void clickButtonAutoPlay() {
        String s = $(ByShadow.cssSelector("#toolbar > div:nth-child(11)",
                "#\\37 2420", "#toolbar")).getAttribute("class");
        assert s != null;
        if (s.equals("btn hmi-j-play")) {
            $(ByShadow.cssSelector("#toolbar > div:nth-child(11)",
                    "#\\37 2420", "#toolbar")).click();
        }
    }

    /**
     * Кликнуть по кнопке Переход по дате
     */
    public MethodsPage clickButtonGoToDate() {
        buttonGoToDate.click();
        return this;

    }

    /**
     *  Открытия календаря для перехода по дате
     */
    //document.querySelector("#\\37 2420").shadowRoot.querySelector("#divCancel > div > ms-dtpicker").shadowRoot.querySelector("#btnCal")
    public void clickCalendarButton() {
        SelenideElement calendarButton = $(ByShadow.cssSelector("#btnCal","#\\37 2420",
                "#divCancel > div > ms-dtpicker"));
        calendarButton.click();

    }

    public void clickButtonYearDown() {
        buttonYearDown.get(2).click();

    }

    public void clickSaveButton() {
        buttonSave.click();

    }


    /**
     *  Подтвердить переход по дате
     */
    public void clickButtonGoToDateOk() {
        //document.querySelector("#\\37 2420").shadowRoot.querySelector("#btnOk")
        SelenideElement buttonGoToDateOk = $(ByShadow.cssSelector("#btnOk", "#\\37 2420"));
        buttonGoToDateOk.shouldBe(visible).click();
    }

    /**
     * Переход не должен произойти, так как дата неверна
     */
    public boolean noGoToDate() {
        String s = "position: absolute; top: 0px; height: 128px; left: 22px; width: " +
                "4px; background-color: transparent; cursor: col-resize; z-index: 1;";
        $(ByShadow.cssSelector("#sp", "#\\37 2420"))
                .shouldBe(Condition.attribute("style", s));
        return true;
    }

}
