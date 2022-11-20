package ru.yandex.practikum;

import action.UserAction;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pojo.LoginRequest;
import pojo.UserRequest;
import java.util.concurrent.TimeUnit;
import static testdata.UserRequestTestData.getUserRequestWithCorrectData;

public class LoginTest {
	private WebDriver driver;
	UserRequest userRequest;
	UserAction userAction;
	LoginPage loginPage;
	PersonalAccountPage personalAccountPage;

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://stellarburgers.nomoreparties.site/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		userAction = new UserAction();
		loginPage = new LoginPage(driver);
		personalAccountPage = new PersonalAccountPage(driver);
		userRequest = getUserRequestWithCorrectData();
		userAction.create(userRequest);
	}

	@After
	public void leave() {
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
	@DisplayName("Log in using the \"Log in to account\" button on the main page")
	@Description("Check the login using the \"Log in to account\" button on the main page")
	public void checkLogInToAccountWithButtonOnMainPage() {
		loginPage.clickLogInAccountButton();
		loginPage.setEmailInField(userRequest.getEmail());
		loginPage.setPasswordInField(userRequest.getPassword());
		loginPage.clickLoginButton();
		loginPage.isDisplayCollectBurgerLabel();
	}

	@Test
	@DisplayName("Log in using the \"Personal Account\" button")
	@Description("Check the login using the \"Personal Account\" button")
	public void checkLogInThroughPersonalAccount() {
		personalAccountPage.clickPersonalAccountLink();
		loginPage.setEmailInField(userRequest.getEmail());
		loginPage.setPasswordInField(userRequest.getPassword());
		loginPage.clickLoginButton();
		loginPage.isDisplayCollectBurgerLabel();
	}

	@Test
	@DisplayName("Log in using the link in the registration form")
	@Description("Check the login using the link in the registration form")
	public void checkLogInThroughRegistrationForm() {
		loginPage.clickLogInAccountButton();
		loginPage.clickRegisterLink();
		loginPage.clickLogInThroughRegistrationLink();
		loginPage.setEmailInField(userRequest.getEmail());
		loginPage.setPasswordInField(userRequest.getPassword());
		loginPage.clickLoginButton();
		loginPage.isDisplayCollectBurgerLabel();
	}

	@Test
	@DisplayName("Log in using the link in the password recovery form")
	@Description("Check the login using the link in the password recovery form")
	public void checkLogInThroughRecoverPasswordForm() {
		personalAccountPage.clickPersonalAccountLink();
		loginPage.clickRecoverPasswordLink();
		loginPage.clickLogInThroughRegistrationLink();
		loginPage.setEmailInField(userRequest.getEmail());
		loginPage.setPasswordInField(userRequest.getPassword());
		loginPage.clickLoginButton();
		loginPage.isDisplayCollectBurgerLabel();
	}
}
