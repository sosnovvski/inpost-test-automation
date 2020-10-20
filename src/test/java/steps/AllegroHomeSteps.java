package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AllegroHomePage;
import pages.CartPageObject;
import pages.LoginPageObject;
import pages.MonthlyPaymentPageObject;
import pages.OrderPageObject;

import static org.testng.Assert.assertTrue;

public class AllegroHomeSteps extends TestRunnerTestNG {
	private AllegroHomePage allegroHomePage = new AllegroHomePage(seleniumCore);
	private MonthlyPaymentPageObject monthlyPaymentPageObject = new MonthlyPaymentPageObject(seleniumCore);
	private OrderPageObject orderPageObject = new OrderPageObject(seleniumCore);
	private CartPageObject cartPageObject = new CartPageObject(seleniumCore);
	private LoginPageObject loginPageObject = new LoginPageObject(seleniumCore);

	@Given("^Otworzylem strone glowna allegro$")
	public void openAllegroHomePage() {
		allegroHomePage.open();
		allegroHomePage.closePopupWindowIfExists();
	}

	@And("^Wybralem zakladke raty zero$")
	public void clickMonthlyPaymentButton() {
		allegroHomePage.clickMonthlyPaymentButton();
	}

	@And("^Wybieram pierwszy produkt dostepny w karuzeli produktow$")
	public void clickFirstItemFromFirstCarousel() {
		monthlyPaymentPageObject.clickFirstItemFromFirstCarousel();
	}

	@When("^Sprawdzam czy przedmiot mozna kupic na raty zero$")
	public void checkItemCanBeOrderedOnInstallmentZero() {
		assertTrue(orderPageObject.itemCanBeOrderedOnInstallmentZero(), "Installment button was not displayed");
	}

	@And("^Dodaje przedmiot do koszyka$")
	public void clickGoToCartButton() {
		orderPageObject.clickAddToCartButton().clickGoToCartButton();
	}

	@Then("^Sprawdzam w koszyku mozliwosc zakupu na raty zero$")
	public void checkItemCanBeBuyOnInstallmentZero() {
		assertTrue(cartPageObject.itemCanBeBuyOnInstallmentZero(), "Buy on installment button was not displayed");
	}

	@And("^Naciskam przycisk: KUP NA RATY ZERO$")
	public void clickInstallmentButton() {
		cartPageObject.clickInstallmentButton();
	}

	@And("^Wybieram logowanie przez facebooka$")
	public void ClickLoginByFacebookButton() {
		loginPageObject.ClickLoginByFacebookButton();
	}

	@And("^Popup logowania zostaje wyswietlony$")
	public void facebookLoginFormIsDisplayed() {
		loginPageObject.facebookLoginFormIsDisplayed();
	}
}
