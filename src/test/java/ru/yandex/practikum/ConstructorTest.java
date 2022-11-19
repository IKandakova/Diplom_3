package ru.yandex.practikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ConstructorTest {
    private WebDriver driver;
    ConstructorPage constructorPage;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        constructorPage = new ConstructorPage(driver);

    }

    @After
    public void leave(){
        driver.quit();
    }



    @Test
    @DisplayName("The transition to the \"Sauces\" section")
    @Step("Check the transition to the \"Sauces\" section")
    public void checkNavigateToSauceSections() {
        constructorPage.clickSauce();
        Assert.assertEquals("Соусы", constructorPage.getTextActiveTab());

    }

    @Test
    @DisplayName("The transition to the \"Fillings\" section")
    @Step("Check the transition to the \"Fillings\" section")
    public void checkNavigateToFillingSections() {
        constructorPage.clickFilling();
        Assert.assertEquals("Начинки", constructorPage.getTextActiveTab());

    }

    @Test
    @DisplayName("The transition to the \"Bun\" section")
    @Step("Check the transition to the \"Bun\" section")
    public void checkNavigateToBunSections() {
       constructorPage.clickBun();
       Assert.assertEquals("Булки", constructorPage.getTextActiveTab());

    }


}
