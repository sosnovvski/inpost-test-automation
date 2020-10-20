package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import support.SeleniumCore;

public class LoginPageObject {
	private static final String LOG_IN_BY_FACEBOOK_BUTTON_XPATH = "//button[@ng-click='socialMedia.onFacebookIconClick()']";
	private static final String LOG_IN_BY_FACEBOOK_POPUP_XPATH = "//form[@id='platformDialogForm']";
	private static final String FACEBOOK_LOGIN_URL = "https://www.facebook.com/login.php";

	private SeleniumCore seleniumCore;

	@FindBy(xpath = LOG_IN_BY_FACEBOOK_BUTTON_XPATH)
	private WebElement loginByFacebookButton;

	@FindBy(xpath = LOG_IN_BY_FACEBOOK_POPUP_XPATH)
	private WebElement loginByFacebookPopup;

	public LoginPageObject(SeleniumCore seleniumCore) {
		this.seleniumCore = seleniumCore;
		PageFactory.initElements(this.seleniumCore.getWebDriver(), this);
	}

	public void ClickLoginByFacebookButton() {
		seleniumCore.getWebDriverWait().until(ExpectedConditions.visibilityOf(loginByFacebookButton));
		loginByFacebookButton.click();
	}

	public boolean facebookLoginFormIsDisplayed() {
		seleniumCore.getWebDriverWait()
				.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
						.equals("complete"));
		return seleniumCore.getWebDriver().getCurrentUrl().contains(FACEBOOK_LOGIN_URL);
	}
}
