package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AbbPageObject;

import static org.testng.Assert.assertTrue;

public class AbbSteps extends TestRunnerTestNG {
	private AbbPageObject abbPageObject = new AbbPageObject(seleniumCore);

	@Given("^Otworzylem strone glowna abb$")
	public void openAbbPage() {
		abbPageObject.open();
	}

	@And("^Wybralem zakladke: Downloads$")
	public void clickDownloadTab() {
		abbPageObject.clickDownloadTab();
	}

	@And("^Wybieram zakladke: Movie$")
	public void clickMovieTab() {
		abbPageObject.clickMovieTab();
	}

	@When("^Naciskam na tytul filmu$")
	public void clickOpenMovieButton() {
		abbPageObject.clickOpenMovieButton();
	}

	@Then("^Film jest odtwarzany w osobnej karcie$")
	public void checkVideoIsPlaying() throws InterruptedException {
		assertTrue(abbPageObject.videoIsPlaying(), "Video is not playing");
	}
}
