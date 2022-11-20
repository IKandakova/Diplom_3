package ru.yandex.practikum;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {
	private final WebDriver driver;
	private final By constructorLink = By.xpath("//p[text()='Конструктор']");
	private final By logoLink = By.className("AppHeader_header__logo__2D0X2");
	private final By actionInConstructorLabel = By.xpath("//h1[text()='Соберите бургер']");
	private final By burgerIngredients = By.className("BurgerIngredients_ingredients__list__2A-mT");
	private final By activeTab = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']");
	private final By sauceTab = By.xpath("//span[text()='Соусы']");

	public ConstructorPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click the \"Constructor\" link")
	public void clickConstructorLink() {
		driver.findElement(constructorLink).click();
	}

	@Step("Click the \"Login\" link")
	public void clickLogoLink() {
		driver.findElement(logoLink).click();
	}

	@Step("Display of the \"Collect burger\" field")
	public void isDisplayActionInConstructorLabel() {
		Assert.assertTrue(driver.findElement(actionInConstructorLabel).isDisplayed());
	}

	@Step("Click on the ingredient \"Bun\"")
	public void clickBun() {
		driver.findElements(burgerIngredients).get(0).click();
	}

	@Step("Click on the ingredient \"Sauce\"")
	public void clickSauce() {
		driver.findElement(sauceTab).click();
	}

	@Step("Click on the ingredient \"Filling\"")
	public void clickFilling() {
		driver.findElements(burgerIngredients).get(2).click();
	}

	@Step("Text of the active tab")
	public String getTextActiveTab() {
		return driver.findElement(activeTab).getText();
	}
}
