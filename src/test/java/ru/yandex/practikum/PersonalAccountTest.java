package ru.yandex.practikum;

import action.UserAction;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pojo.LoginRequest;
import pojo.UserRequest;

import java.util.concurrent.TimeUnit;

import static testdata.UserRequestTestData.getUserRequestWithCorrectData;

public class PersonalAccountTest {
    private WebDriver driver;
    UserRequest userRequest;
    LoginRequest loginRequest;
    UserAction userAction;
    LoginPage loginPage;
    PersonalAccountPage personalAccountPage;
    RegistrationPage registrationPage;
    ConstructorPage constructorPage;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        userAction = new UserAction();
        loginPage = new LoginPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        registrationPage = new RegistrationPage(driver);
        constructorPage = new ConstructorPage(driver);

        userRequest = getUserRequestWithCorrectData();
        loginRequest = new LoginRequest(userRequest.getEmail(), userRequest.getPassword());

        userAction.create(userRequest);
        loginPage.clickLogInAccountButton();
        loginPage.setEmailInField(userRequest.getEmail());
        loginPage.setPasswordInField(userRequest.getPassword());
        loginPage.clickLoginButton();

    }

    @After
    public void leave(){
        LoginRequest loginRequest = new LoginRequest(userRequest.getEmail(), userRequest.getPassword());
        Response response = userAction.login(loginRequest);
        String accessToken = response
                .then()
                .extract()
                .path("accessToken");

        if (accessToken != null) {
            userAction.delete(accessToken);
        }

        driver.quit();
    }

    @Test
    @DisplayName("Transfer to your personal account")
    @Step("Check the click-through to the \"Personal Account\"")
    public void checkSwitchingToPersonalAccount(){
        personalAccountPage.clickPersonalAccountLink();
        personalAccountPage.isDisplayInformAboutPersonalAccountLabel();

    }

    @Test
    @DisplayName("Switching from your personal account to the constructor")
    @Step("Check the transition by clicking on the \"Constructor\"")
    public void checkSwitchConstructorClickOnConstructorLink(){
        personalAccountPage.clickPersonalAccountLink();
        constructorPage.clickConstructorLink();
        constructorPage.isDisplayActionInConstructorLabel();
    }

    @Test
    @DisplayName("Switching from your personal account to the constructor")
    @Step("Check the transition by clicking on the Stellar Burgers logo")
    public void checkSwitchConstructorClickOnLogoLink(){
        personalAccountPage.clickPersonalAccountLink();
        constructorPage.clickLogoLink();
        constructorPage.isDisplayActionInConstructorLabel();
    }

    @Test
    @DisplayName("Log out of account")
    @Step("Check the exit by clicking the \"Exit\" button in personal account")
    public void checkLogOutPersonalAccount(){
        personalAccountPage.clickPersonalAccountLink();
        personalAccountPage.clickLogOutButton();
        loginPage.isDisplayLoginLabel();
    }



}
