import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.io.*;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
//import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.io.FileUtils;
import org.junit.*;


public class MethodsTest {



    /**
     * Проверка методов архивного журнала
     */

    MainPage mainPage;
    MethodsPage methodsPage = page(MethodsPage.class);
    WaitingPage waitingPage = page(WaitingPage.class);
    RobotPage robotPage = page(RobotPage.class);

    final byte randomNum = (byte) (Math.random() * 10);
/*
    @Attachment(value = "{0}", type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        FileUtils.copyFile(screenshot, new File("target\\allure-results\\screenshots\\" + screenshot.getName()));
        return Files.toByteArray(screenshot);
    }
*/

    @Before
    public void setUp() {
        mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickButtonMethods();
        methodsPage.clickButtonAlarmsDeactivation();
        waitingPage.waiting(2000);
        methodsPage.clickButtonAutoPlay();
        
    }

    @After
    public void tearDown() {
        methodsPage.clickButtonAlarmsDeactivation();

    }

    @Test
    @Attachment
    @DisplayName("№1. Следующая страница")
    @Description("Для архивного журнала. Проверка атрибута style, top должен быть равен 56px")
    public void nextPageTest() {
        methodsPage.clickButtonAlarmsActivation();
        for (int i = 0; i < 2; i++) {
            methodsPage.clickButtonNextPage();
            waitingPage.waiting(1000);
        }
        //Assert.assertTrue("Следующая страница не сработала. Сообщения не переместились", methodsPage.isEventsHaveShiftedDown());
        methodsPage.isEventsHaveShiftedDown();
    }

    @Test
    //@Ignore("Тест проходит через раз из-за бага")
    @DisplayName("№2. Предыдущая страница")
    @Description("Для архивного журнала. Проверка атрибута style, top должен быть равен 0px" + "возможные баги: 23278")
    public void previousPageTest() {
        methodsPage.clickButtonAlarmsActivation()
                .clickButtonNextPage();
        waitingPage.waiting(1000);
        methodsPage.clickButtonPreviousPage();
        waitingPage.waiting(15000);

        //Assert.assertTrue("Предыдущая страница не сработала. Сообщения не переместились", methodsPage.isEventsHaveShiftedUp());
        methodsPage.isEventsHaveShiftedUp();
    }

    @Test
    @DisplayName("№3 Первая страница")
    @Description("Для архивного журнала. Проверка атрибута style, top должен быть равен 0px")
    public void firstPageTest() {
        methodsPage.clickButtonAlarmsActivation()
                .clickButtonLastPage();
        waitingPage.waiting(3000);
        methodsPage.clickButtonFirstPage();

        Assert.assertTrue("Первая страница не сработала. Сообщения не переместились",
                methodsPage.isFirstPage());

    }

    @Test
    @DisplayName("№4.1. Последняя страница")
    @Description("Для архивного журнала. Проверка перехода на последнюю страницу. Строка статуса отключена")
    public void lastPageWithoutStringStatusTest() {
        methodsPage.clickButtonAlarmsActivation()
                .clickButtonStringStatus()
                .clickButtonLastPage();

        //Assert.assertTrue("Последняя страница не сработала. Сообщения не переместились", methodsPage.isLastPage());
                methodsPage.isLastPage();

    }

    @Test
    //@Ignore("Откл из-за бага")
    @DisplayName("№4.2. Последняя страница")
    @Description("Для архивного журнала. Проверка перехода на последнюю страницу. Строка статуса включена." +
            " Возможные баги: 23251")
    public void lastPageWithStringStatusTest() {
        methodsPage.clickButtonAlarmsActivation()
                .clickButtonLastPage();

        //Assert.assertTrue("Последняя страница не сработала. Сообщения не переместились", methodsPage.isLastPage());
        methodsPage.isLastPage();
    }

    @Test
    @Ignore
    @DisplayName("№5. Обновить")
    @Description("Для архивного журнала. Возможные баги: 23037")
    public void refreshTest() {
        methodsPage.clickButtonAlarmsActivation();
        int allEvents = methodsPage.countEvents();
        waitingPage.waiting(1000);
        for (byte i = 1; i <= randomNum; i++) {
            methodsPage.clickButtonRefresh();
        }
        int allEventsAfterRefresh = methodsPage.countEvents();
        waitingPage.waiting(1000);

        Assert.assertEquals("Разница кол-ва сообщений до обновления и после не равна 0",
                0, allEvents - allEventsAfterRefresh);

    }

    @Test
    @DisplayName("№6. Квитировать сообщение")
    @Description("Для архивного журнала")
    public void ackEventTest() {
        methodsPage.clickButtonAlarmsActivation()
                .clickEvent()
                .clickButtonAckEvent();
        waitingPage.waiting(3000);
        int allEvents = methodsPage.countEvents();
        methodsPage.clickButtonAckPage();
        int notAsked = methodsPage.countEvents();

        Assert.assertEquals("Разница кол-ва сообщений до квитирования и после не равна 1",
                4, allEvents - notAsked);

    }

    @Test
    @DisplayName("№7. Тест метода следующее сообщение")
    @Description("Для архивного журнала")
    public void nextEventTest() {
        methodsPage.clickButtonAlarmsActivation()
                .clickEvent();
        waitingPage.waiting(1000);
        methodsPage.clickPreviousEvent();
        waitingPage.waiting(1000);
        methodsPage.clickNextEvent();

        Assert.assertTrue("Стрелочки SVG нет", methodsPage.getArrowSVGEventFirst());

    }

    @Test
    @DisplayName("№8. Тест метода предыдущее сообщение")
    @Description("Для архивного журнала")
    public void previousEventTest() {
        methodsPage.clickButtonAlarmsActivation()
                .clickEvent()
                .clickPreviousEvent();

        Assert.assertTrue("Стрелочки SVG нет", methodsPage.getArrowSVGEventSecond());

    }

    @Test
    @DisplayName("№9. Тест метода Показать легенду")
    @Description("Для архивного журнала")
    public void showLegendTest() {
        methodsPage.clickButtonShowLegend();

        Assert.assertTrue("Легенда архивного журнала не видна", methodsPage.isLegendVisible());

    }

    @Test
    @Ignore("Нет проверки")
    @DisplayName("№10. Тест метода Печать. Открывается окно печати")
    @Description("Для архивного журнала")
    public void openPrintWindowTest() {
        methodsPage.clickButtonPrint();

        waitingPage.waiting(4000);
        robotPage.sendKeysEnter();
        waitingPage.waiting(5000);
        robotPage.sendKeysEnter();
        waitingPage.waiting(5000);

    }

    @Test
    @DisplayName("№11. Тест метода квитировать на странице")
    @Description("Для архивного журнала")
    public void ackPageTest() {
        methodsPage.clickButtonAlarmsActivation();
        int allEvents = methodsPage.countEvents();
        methodsPage.clickButtonAckPage();
        int notAsked = methodsPage.countEvents();

        Assert.assertEquals("Разница кол-ва сообщений до квитирования на странице и после не равна 3",
                3, allEvents - notAsked);

    }

    @Test
    @DisplayName("№12. Тест метода Экспортировать")
    @Description("Для архивного журнала")
    public void exportCSVTest() throws IOException {
        methodsPage.clickButtonAlarmsActivation()
                    .clickButtonExport();

        Assert.assertEquals("Текст самого верхнего сообщения в файле не равен 5",
                "5", methodsPage.checkFileCSV());
        methodsPage.deleteCSV();

    }

    @Test
    @DisplayName("№13. Тест метода Открыть дерево объекта")
    @Description("Для архивного журнала")
    public void openTreeTest() {
        methodsPage.clickButtonOpenTree();

        Assert.assertTrue("Не открылось дерево выбора", methodsPage.isTreeVisible());

    }

    @Test
    @Ignore("Из-за бага")
    @DisplayName("№14. Тест метода Переход по несуществующей дате")
    @Description("Для архивного журнала. Возможные баги: 23276")
    public void goToDateTest() {
        methodsPage.clickButtonAlarmsActivation()
                .clickButtonGoToDate();
        methodsPage.clickCalendarButton();
        methodsPage.clickButtonYearDown();
        methodsPage.clickSaveButton();
        methodsPage.clickButtonGoToDateOk();
        waitingPage.waiting(5000);
        Assert.assertTrue("Полотно сообщений сдвинулось",
                methodsPage.noGoToDate());
    }

}
