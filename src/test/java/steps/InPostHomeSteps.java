package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.InPostHomePageObject;

public class InPostHomeSteps extends TestRunnerTestNG {
	private InPostHomePageObject inPostHomePageObject = new InPostHomePageObject(seleniumCore);

	@Given("^Otworzylem strone glowna inpost$")
	public void openHomePage() {
		inPostHomePageObject.open();
	}

	@And("^Wpisuje numer przesylki \"([^\"]*)\"$")
	public void enterParcelNumber(String parcelNumber) {
		inPostHomePageObject.fillSearchInput(parcelNumber);
	}
}
