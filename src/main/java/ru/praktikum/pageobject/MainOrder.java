package ru.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainOrder {
    WebDriver webDriver;

    public MainOrder(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    // Верхняя кнопка "Заказать"
    public By orderButtonTop = By.xpath("//*[@id='root']/div/div[1]/div[1]/div[2]/button[1]");
    // Нижняя кнопка "Заказать"
    public By orderButtonDown = By.xpath("//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button");
    // Поле ввода "*Имя"
    public By formName = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    // Поле ввода "*Фамилия"
    public By formSurname = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    // Поле ввода "*Адрес: куда привезти заказ"
    public By formAddress = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");
    // Выпадающий список поля "*Станция метро"
    public By formMetroList = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[2]/ul/li");
    // Поле ввода "*Станция метро"
    public By formMetro = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div/input");
    // Поле ввода "*Телефон: на него позвонит курьер"
    public By formPhone = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");
    // Кнопка "да все привыкли"
    public By cookieButton = By.xpath("//*[@id='rcc-confirm-button']");
    // Кнопка "Далее"
    public By formButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");
    // Поле ввода "*Когда привезти самокат"
    public By secondFormDate = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div/input");
    // Поле ввода "*Срок аренды"
    public By secondFormLongTimeArrow = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/div[2]/span");
    // Выпадающий список поля "*Срок аренды"
    public By secondFormLongTimeOptions = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[2]/div");
    // Поле ввода "Комментарий для курьера"
    public By secondFormComment = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/input");
    // Чекбоксы "Цвет самоката"
    public By secondFormCheckoutInputs = By.className("Checkbox_Input__14A2w");
    // Кнопка "Далее"
    public By secondFormButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");
    // Модальное окно "Хотите оформить заказ?"
    public By confirmationModal = By.xpath("//*[@id='root']/div/div[2]/div[5]");
    // Кнопка "Да" в модальном окне
    public By confirmationModalButton = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
    // Модальное окно об успешном содании заказа
    public By successModal = By.xpath("//*[contains(text(), 'Посмотреть статус')]");

    public void clickOnOrderButtonTop() {
        WebElement element = webDriver.findElement(orderButtonTop);
        element.click();
    }

    public void clickOnOrderButtonDown() {
        WebElement element = webDriver.findElement(orderButtonDown);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void clickOnOrderButton(int type) {
        if(type == 1) {
            clickOnOrderButtonTop();
        } else {
            clickOnOrderButtonDown();
        }
    }

    public void pasteName(String name) {
        WebElement element = webDriver.findElement(formName);
        element.sendKeys(name);
    }

    public void pasteSurname(String surname) {
        WebElement element = webDriver.findElement(formSurname);
        element.sendKeys(surname);
    }

    public void pasteAddress(String address) {
        WebElement element = webDriver.findElement(formAddress);
        element.sendKeys(address);
    }

    public void showMetroList() {
        WebElement element = webDriver.findElement(formMetro);
        element.click();
    }
    public void clickMetro(int metro_id) {
        List<WebElement> elements = webDriver.findElements(formMetroList);
        WebElement element = elements.get(metro_id);
        element.click();
    }

    public void pasteMetro(int metro_id) {
        showMetroList();
        clickMetro(metro_id);
    }

    public void pastePhone(String phone) {
        WebElement element = webDriver.findElement(formPhone);
        element.sendKeys(phone);
    }

    public void clickCookieButton() {
        WebElement element = webDriver.findElement(cookieButton);
        if(element.isDisplayed()) {
            element.click();
        }
    }

    public void clickFormButton() {
        WebElement element = webDriver.findElement(formButton);
        element.click();
    }

    public void clickSecondFormDate(String date) {
        WebElement element = webDriver.findElement(secondFormDate);
        element.sendKeys(date);
    }

    public void showSecondFormLongTime() {
        WebElement element = webDriver.findElement(secondFormLongTimeArrow);
        element.click();
    }
    public void clickSecondFormLongTimeOption(int number) {
        List<WebElement> elements = webDriver.findElements(secondFormLongTimeOptions);
        WebElement element = elements.get(number);
        element.click();
    }

    public void pasteLongTime(int number) {
        showSecondFormLongTime();
        clickSecondFormLongTimeOption(number);
    }

    public void clickSecondFormCheckoutInput(int number) {
        List<WebElement> elements = webDriver.findElements(secondFormCheckoutInputs);
        WebElement element = elements.get(number);
        element.click();
    }

    public void pasteSecondFormComment(String comment) {
        WebElement element = webDriver.findElement(secondFormComment);
        element.sendKeys(comment);
    }

    public void clickSecondFormButton() {
        WebElement element = webDriver.findElement(secondFormButton);
        element.click();
    }

    public void clickConfirmButton() {
        if(webDriver.findElement(confirmationModal).isDisplayed()) {
            WebElement element = webDriver.findElement(confirmationModalButton);
            element.click();
        }
    }

    public boolean successModalIsDisplayed() {
        return webDriver.findElement(successModal).isDisplayed();
    }
}
