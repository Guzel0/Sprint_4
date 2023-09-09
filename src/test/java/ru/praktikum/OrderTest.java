package ru.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.praktikum.pageobject.MainOrder;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {
    MainOrder mainOrder;
    WebDriver webDriver;
    String browser;
    int button_type;
    String name;
    String surname;
    String address;
    int metro;
    String phone;
    String date;
    int longTime;
    int colorNumber;
    String comment;

    public OrderTest(
            String browser,
            int button_type,
            String name,
            String surname,
            String address,
            int metro,
            String phone,
            String date,
            int longTime,
            int colorNumber,
            String comment
            ) {
        this.browser = browser;
        this.button_type = button_type;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.longTime = longTime;
        this.colorNumber = colorNumber;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][] {
                {"chrome", 1, "Имя", "Фамилия", "Адрес", 0, "89871874895", "10.09.2023", 0, 0, "Комментарий"},
                {"firefox", 2, "Гузель", "Карабаева", "Казань", 1, "79178976311", "11.09.2023", 1, 1, "Ура!"}
        };
    }

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.get(this.browser);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainOrder = new MainOrder(webDriver);
    }

    @Test
    public void firstTest() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        mainOrder.clickOnOrderButton(this.button_type);
        mainOrder.fillingOutFirstForm(this.name, this.surname, this.address, this.metro, this.phone);
        mainOrder.fillingOutSecondForm(this.date, this.longTime, this.colorNumber, this.comment);
        mainOrder.clickConfirmButton();
        boolean result = mainOrder.successModalIsDisplayed();
        assertTrue("Не удалось оформить заказ", result);
    }

    @After
    public void cleanBrowser() {
        webDriver.quit();
    }
}
