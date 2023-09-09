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
    public By orderButtonTop = By.xpath("//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    // Нижняя кнопка "Заказать"
    public By orderButtonDown = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[contains(@class, 'Button_Button__ra12g')]");
    // Поле ввода "*Имя"
    public By formName = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']");
    // Поле ввода "*Фамилия"
    public By formSurname = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Фамилия']");
    // Поле ввода "*Адрес: куда привезти заказ"
    public By formAddress = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Адрес: куда привезти заказ']");
    // Выпадающий список поля "*Станция метро"
    public By formMetroList = By.className("select-search__row");
    // Поле ввода "*Станция метро"
    public By formMetro = By.className("select-search__input");
    // Поле ввода "*Телефон: на него позвонит курьер"
    public By formPhone = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "да все привыкли"
    public By cookieButton = By.xpath("//*[@id='rcc-confirm-button']");
    // Кнопка "Далее"
    public By formButton = By.xpath("//div[@class='Order_NextButton__1_rCA']/button[contains(@class, 'Button_Button__ra12g')]");
    // Поле ввода "*Когда привезти самокат"
    public By secondFormDate = By.xpath("//div[@class='react-datepicker__input-container']/input[contains(@class, 'Input_Input__1iN_Z')]");
    // Поле ввода "*Срок аренды"
    public By secondFormLongTimeArrow = By.className("Dropdown-arrow");
    // Выпадающий список поля "*Срок аренды"
    public By secondFormLongTimeOptions = By.className("Dropdown-option");
    // Поле ввода "Комментарий для курьера"
    public By secondFormComment = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='Комментарий для курьера']");
    // Чекбоксы "Цвет самоката"
    public By secondFormCheckoutInputs = By.className("Checkbox_Input__14A2w");
    // Кнопка "Заказать"
    public By secondFormButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Модальное окно "Хотите оформить заказ?"
    public By confirmationModal = By.className("Order_Modal__YZ-d3");
    // Кнопка "Да" в модальном окне
    public By confirmationModalButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
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

    public void fillingOutFirstForm(String name, String surname, String address, int metro, String phone) {
        pasteName(name);
        pasteSurname(surname);
        pasteAddress(address);
        pasteMetro(metro);
        pastePhone(phone);
        clickCookieButton();
        clickFormButton();
    }

    public void fillingOutSecondForm(String date, int longTime, int colorNumber, String comment) {
        clickSecondFormDate(date);
        pasteLongTime(longTime);
        clickSecondFormCheckoutInput(colorNumber);
        pasteSecondFormComment(comment);
        clickSecondFormButton();
    }
}
