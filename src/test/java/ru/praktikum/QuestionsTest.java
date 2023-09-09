package ru.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.praktikum.pageobject.MainQuestions;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionsTest {
    MainQuestions mainQuestions;
    WebDriver webDriver;
    String browser;
    int number;
    String answer;

    public QuestionsTest(String browser, int number, String answer) {
        this.browser = browser;
        this.number = number;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][] {
                {"chrome", 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"chrome", 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"chrome", 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"chrome", 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"chrome", 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"chrome", 5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"chrome", 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"chrome", 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.get(this.browser);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainQuestions = new MainQuestions(webDriver);
    }

    @Test
    public void firstTest() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        mainQuestions.clickOnQuestion(this.number);
        String text = mainQuestions.getQuestionText(this.number);
        assertEquals("Неправильный вывод в вопросе номер" + this.number, text, this.answer);
    }

    @After
    public void cleanBrowser() {
        webDriver.quit();
    }

}
