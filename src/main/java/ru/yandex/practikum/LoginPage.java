package ru.yandex.practikum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private final By logInAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By collectBurgerLabel = By.xpath("//h1[text()='Соберите бургер']");
    private final By personalAccountLink = By.xpath("//p[text()='Личный Кабинет']");
    private final By registerLink = By.xpath("//a[text()='Зарегистрироваться']");
    private final By logInThroughRegistrationLink = By.xpath("//a[text()='Войти']");
    private final By recoverPasswordLink = By.xpath("//a[text()='Восстановить пароль']");
    private final By loginLabel = By.xpath("//h2[text()='Вход']");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogInAccountButton(){
        driver.findElement(logInAccountButton).click();
    }

    public void setEmailInField(String name){
        driver.findElement(emailField).sendKeys(name);
    }

    public void setPasswordInField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void isDisplayCollectBurgerLabel() {
        Assert.assertTrue(driver.findElement(collectBurgerLabel).isDisplayed());
    }

    public void clickRegisterLink(){
        driver.findElement(registerLink).click();
    }

    public void clickLogInThroughRegistrationLink(){
        driver.findElement(logInThroughRegistrationLink).click();
    }

    public void clickRecoverPasswordLink(){
        driver.findElement(recoverPasswordLink).click();
    }

    public void isDisplayLoginLabel() {
        Assert.assertTrue(driver.findElement(loginLabel).isDisplayed());
    }

}
