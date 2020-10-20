package steps;

import java.util.List;

import api.RestService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.testng.Assert.assertEquals;

public class RestApiSteps {
	private RestService restService = new RestService();
	private String status;
	private List<String> parcelLockersInfo;

	@Given("^Pobieram status przesylki dla numeru paczki: \"([^\"]*)\"$")
	public void getParcelTrackingStatus(String arg0) throws Throwable {
		this.status = restService.getParcelService().getParcelTrackingStatus(arg0);
	}

	@Then("^sprawdzam czy poprany status to \"([^\"]*)\"$")
	public void checkParcelTrackingStatus(String expectedStatus) {
		assertEquals(this.status, expectedStatus, "Parcel tracking status is not correct");
	}

}
