package ru.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainQuestions {
    WebDriver webDriver;

    public MainQuestions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public By question = By.className("accordion__button");
    public By questionText = By.xpath("//*[@class='accordion__panel']/p");

    public void clickOnQuestion(int key) {
        List<WebElement> elements = webDriver.findElements(question);
        WebElement element = elements.get(key);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public String getQuestionText(int key) {
        List<WebElement> elements = webDriver.findElements(questionText);
        WebElement element = elements.get(key);
        return element.getText();
    }
}
