package steps;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

	@Given("^Pobieram (\\d+) paczkomatow$")
	public void getParcelLockerInfo(int count) throws IOException {
		parcelLockersInfo = restService.getParcelLockerService().getParcelLockerInfo(count);
	}

	@Then("^Zapisuje liste paczkomatow jako plik$")
	public void saveParcelLockerInfoToFile() throws IOException {
		Path out = Paths.get("output.txt");
		Files.write(out, parcelLockersInfo, Charset.defaultCharset());

	}
}
