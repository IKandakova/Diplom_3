package ru.yandex.practikum;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By registerForm = By.xpath("//input[@class='text input__textfield text_type_main-default']");
    private final By passwordErrorField = By.xpath("//p[text()='Некорректный пароль']");
    private final By loginButton = By.xpath("//button[text()='Войти']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDataRegisterForm(String name, String email, String password) {
        driver.findElements(registerForm).get(0).sendKeys(name);
        driver.findElements(registerForm).get(1).sendKeys(email);
        driver.findElements(registerForm).get(2).sendKeys(password);
    }


    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    public void isDisplayLoginButton() {
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed());

    }

    public String getTextPasswordErrorField() {
        return driver.findElement(passwordErrorField).getText();
    }

}
