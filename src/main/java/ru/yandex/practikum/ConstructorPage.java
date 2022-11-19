package ru.yandex.practikum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {
    private WebDriver driver;
    private final By constructorLink = By.xpath("//p[text()='Конструктор']");
    private final By logoLink = By.className("AppHeader_header__logo__2D0X2");
    private final By actionInConstructorLabel = By.xpath("//h1[text()='Соберите бургер']");
    private final By burgerIngredients = By.className("BurgerIngredients_ingredients__list__2A-mT");

    private final By bunLabel = By.xpath("//h2[text()='Булки']");
    private final By sauceLabel = By.xpath("//h2[text()='Соусы']");
    private final By fillingLabel = By.xpath("//h2[text()='Начинки']");

    private final By fillingTab = By.xpath("//span[text()='Начинки']");
    private final By bunTab = By.xpath("//span[text()='Булки']");
    private final By activeTab = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']");

    private final By sauceTab = By.xpath("//span[text()='Соусы']");


    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConstructorLink(){
        driver.findElement(constructorLink).click();
    }

    public void clickLogoLink(){
        driver.findElement(logoLink).click();
    }

    public void isDisplayActionInConstructorLabel() {
        Assert.assertTrue(driver.findElement(actionInConstructorLabel).isDisplayed());
    }

    public void clickBun() {
        driver.findElements(burgerIngredients).get(0).click();
    }

    public void clickSauce() {
        driver.findElement(sauceTab).click();

    }

    public void clickFilling() {
        driver.findElements(burgerIngredients).get(2).click();
    }


    public String getTextActiveTab() {
        return driver.findElement(activeTab).getText();
    }


}
