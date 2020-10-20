package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import support.SeleniumCore;

public class OrderPageObject {
	private static final String INSTALLMENT_ZERO_LABEL_XPATH = "//a[@data-analytics-interaction-value='installmentZero']";
	private static final String ADD_TO_CART_BUTTON_XPATH = "//button[@id='add-to-cart-button']";
	private static final String GO_TO_CART_BUTTON_XPATH = "//a[@href='/koszyk']";

	private SeleniumCore seleniumCore;

	@FindBy(xpath = INSTALLMENT_ZERO_LABEL_XPATH)
	private WebElement installmentZeroLabel;

	@FindBy(xpath = ADD_TO_CART_BUTTON_XPATH)
	private WebElement addToCartButton;

	@FindBy(xpath = GO_TO_CART_BUTTON_XPATH)
	private WebElement goToCartButton;

	public OrderPageObject(SeleniumCore seleniumCore) {
		this.seleniumCore = seleniumCore;
		PageFactory.initElements(this.seleniumCore.getWebDriver(), this);
	}

	public boolean itemCanBeOrderedOnInstallmentZero() {
		seleniumCore.getWebDriverWait().until(ExpectedConditions.visibilityOf(installmentZeroLabel));
		return installmentZeroLabel.isDisplayed();
	}

	public OrderPageObject clickAddToCartButton() {
		addToCartButton.click();
		return this;
	}

	public CartPageObject clickGoToCartButton() {
		goToCartButton.click();
		return new CartPageObject(seleniumCore);
	}
}
