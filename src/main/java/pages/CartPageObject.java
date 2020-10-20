package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import support.SeleniumCore;

public class CartPageObject {

	private static final String INSTALLMENTS_BUTTON_XPATH = "//button[@data-role='installments-button']";

	private SeleniumCore seleniumCore;

	@FindBy(xpath = INSTALLMENTS_BUTTON_XPATH)
	private WebElement installmentButton;

	public CartPageObject(SeleniumCore seleniumCore) {
		this.seleniumCore = seleniumCore;
		PageFactory.initElements(this.seleniumCore.getWebDriver(), this);
	}

	public boolean itemCanBeBuyOnInstallmentZero() {
		seleniumCore.getWebDriverWait().until(ExpectedConditions.visibilityOf(installmentButton));
		return installmentButton.isDisplayed() && installmentButton.isEnabled();
	}

	public LoginPageObject clickInstallmentButton() {
		installmentButton.click();
		return new LoginPageObject(seleniumCore);
	}
}
