package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import support.SeleniumCore;

public class InPostHomePageObject {
	private static final String FIND_PARCEL_XPATH = "//button[@type='submit']";
	private static final String HOME_URL = "https://inpost.pl/";
	private static final String SEARCH_INPUT_XPATH = "//input[@name='number']";

	private SeleniumCore seleniumCore;

	@FindBy(xpath = FIND_PARCEL_XPATH)
	private WebElement findParcel;

	@FindBy(xpath = SEARCH_INPUT_XPATH)
	private WebElement searchInput;

	public InPostHomePageObject(SeleniumCore webDriver) {
		this.seleniumCore = webDriver;
		PageFactory.initElements(this.seleniumCore.getWebDriver(), this);
	}

	public void open() {
		seleniumCore.getWebDriver().get(HOME_URL);
	}

	public TrackShipmentPageObject clickFindParcel() {
		clickAcceptPopupButton();
		return new TrackShipmentPageObject(seleniumCore);
	}

	private void clickAcceptPopupButton() {
		findParcel.click();
	}

	public void fillSearchInput(String parcelNumber) {
		searchInput.sendKeys(parcelNumber);
	}
}
