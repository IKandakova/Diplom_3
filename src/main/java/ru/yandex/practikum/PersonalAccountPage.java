package ru.yandex.practikum;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    private final WebDriver driver;
    private final By personalAccountLink = By.xpath("//p[text()='Личный Кабинет']");
    private final By logOutButton = By.xpath("//button[text()='Выход']");
    private final By informAboutPersonalAccountLabel = By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on the link \"Personal Account\"")
    public void clickPersonalAccountLink(){
        driver.findElement(personalAccountLink).click();
    }

    @Step("Click on the \"LogOut\" button")
    public void clickLogOutButton(){
        driver.findElement(logOutButton).click();
    }

    @Step("Display of information about personal account")
    public void isDisplayInformAboutPersonalAccountLabel() {
        Assert.assertTrue(driver.findElement(informAboutPersonalAccountLabel).isDisplayed());
    }
}
