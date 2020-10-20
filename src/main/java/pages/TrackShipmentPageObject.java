package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import support.SeleniumCore;

public class TrackShipmentPageObject {
	private static final String TRACK_SHIPMENT_PAGE_XPATH = "//div[@class= 'track-parcel']";

	private static final String PARCEL_STATUSES_XPATH = "//div[contains(@class,'parcel--statuses--list')]//div[contains(@class,'messageBox')]";

	private SeleniumCore seleniumCore;

	@FindBy(xpath = TRACK_SHIPMENT_PAGE_XPATH)
	private WebElement trackShipmentPage;

	@FindBy(xpath = PARCEL_STATUSES_XPATH)
	private List<WebElement> parcelStatuses;

	public TrackShipmentPageObject(SeleniumCore seleniumCore) {
		this.seleniumCore = seleniumCore;
		PageFactory.initElements(this.seleniumCore.getWebDriver(), this);
	}

	public void waitForPageDisplayed() {
		seleniumCore.getWebDriverWait().until(webDriver -> trackShipmentPage.isDisplayed());
	}

	public String fetchLastParcelStatus() {
		return fetchListOfParcelStatuses().stream().findFirst().orElse(null);
	}

	private List<String> fetchListOfParcelStatuses() {
		return parcelStatuses.stream().map(WebElement::getText).collect(Collectors.toList());
	}

}
