package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import support.SeleniumCore;

public class AllegroHomePage {
	private static final String LOGO_XPATH = "//a[@href = 'https://allegro.pl']";
	private static final String ACCEPT_POPUP_BUTTON_XPATH = "//button[@data-role='close-and-accept-consent']";
	private static final String HOME_URL = "http://www.allegro.pl/";
	private static final String MONTHLY_PAYMENT_XPATH = "//a[@href = '/zobacz/ratyzero']";

	private SeleniumCore seleniumCore;

	@FindBy(xpath = LOGO_XPATH)
	private WebElement logo;

	@FindBy(xpath = ACCEPT_POPUP_BUTTON_XPATH)
	private WebElement acceptPopupButton;

	@FindBy(xpath = MONTHLY_PAYMENT_XPATH)
	private WebElement monthlyPaymentButton;

	public AllegroHomePage(SeleniumCore webDriver) {
		this.seleniumCore = webDriver;
		PageFactory.initElements(this.seleniumCore.getWebDriver(), this);
	}

	public void open() {
		seleniumCore.getWebDriver().get(HOME_URL);
		seleniumCore.getWebDriverWait().until(driver -> logo.isDisplayed());
	}

	public void closePopupWindowIfExists() {
		if (acceptPopupButton.isDisplayed()) {
			clickAcceptPopupButton();
		}
	}

	private void clickAcceptPopupButton() {
		acceptPopupButton.click();
	}

	public MonthlyPaymentPageObject clickMonthlyPaymentButton() {
		seleniumCore.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(monthlyPaymentButton));
		monthlyPaymentButton.click();
		return new MonthlyPaymentPageObject(seleniumCore);
	}
}
