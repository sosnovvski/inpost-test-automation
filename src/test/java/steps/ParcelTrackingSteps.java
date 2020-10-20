package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.InPostHomePageObject;
import pages.TrackShipmentPageObject;

import static org.testng.Assert.assertTrue;

public class ParcelTrackingSteps extends TestRunnerTestNG {
	private InPostHomePageObject inPostHomePageObject = new InPostHomePageObject(seleniumCore);
	private TrackShipmentPageObject trackShipmentPageObject;

	@And("^Nasickam przycisk Znajdz$")
	public void clickFindParcel() {
		trackShipmentPageObject = inPostHomePageObject.clickFindParcel();
	}

	@Then("^Wyswietlona zostaje formatka sledzenia przesylki$")
	public void waitForParcelTracking() {
		trackShipmentPageObject.waitForPageDisplayed();
	}

	@And("^Status przesylki to \"([^\"]*)\"$")
	public void checkParcelStatus(String status) {
		assertTrue(trackShipmentPageObject.fetchLastParcelStatus().contains(status),
				"Parcel is not in the status: " + status);
	}
}
