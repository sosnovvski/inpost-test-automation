package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import support.SeleniumCore;

public class MonthlyPaymentPageObject {

	private static final String LIST_OF_ITEMS_FROM_FIRST_CAROUSEL_XPATH = "//a[@name='oferty-karuzela-na-raty1']//..//div[contains(@class, 'carousel-item')]";

	private SeleniumCore seleniumCore;

	@FindBy(xpath = LIST_OF_ITEMS_FROM_FIRST_CAROUSEL_XPATH)
	private List<WebElement> itemsFromFirstCarousel;

	public MonthlyPaymentPageObject(SeleniumCore seleniumCore) {
		this.seleniumCore = seleniumCore;
		PageFactory.initElements(this.seleniumCore.getWebDriver(), this);
	}

	public OrderPageObject clickFirstItemFromFirstCarousel() {
		seleniumCore.getWebDriverWait().until(webDriver -> itemsFromFirstCarousel.size() > 1);
		itemsFromFirstCarousel.stream().findFirst().orElseThrow(() -> new IllegalStateException("Item not found"))
				.click();
		return new OrderPageObject(seleniumCore);
	}
}
