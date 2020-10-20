package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import support.SeleniumCore;

public class AbbPageObject {
	private static final String HOME_URL = "https://new.abb.com/products/2CKA006136A0203/6136-07-811-busch-smarttouch-7";
	private static final String DOWNLOADS_TAB_XPATH = "//div[contains(text(), 'Downloads')]";
	private static final String MOVIE_TAB_XPATH = "//span[@data-docdockind='Movie']";
	private static final String OPEN_MOVIE_BUTTON_XPATH = "//a[@data-dockind='Movie' and @target='_blank']";
	private static final String VIDEO_XPATH = "//video[@id='flashPlayer_video_html5_api']";

	private SeleniumCore seleniumCore;

	@FindBy(xpath = DOWNLOADS_TAB_XPATH)
	private WebElement downloandTab;

	@FindBy(xpath = MOVIE_TAB_XPATH)
	private WebElement movieTab;

	@FindBy(xpath = OPEN_MOVIE_BUTTON_XPATH)
	private WebElement openMovieButton;

	@FindBy(xpath = VIDEO_XPATH)
	private WebElement video;

	public AbbPageObject(SeleniumCore seleniumCore) {
		this.seleniumCore = seleniumCore;
		PageFactory.initElements(this.seleniumCore.getWebDriver(), this);
	}

	public void open() {
		seleniumCore.getWebDriver().get(HOME_URL);
		seleniumCore.getWebDriverWait().until(driver -> downloandTab.isDisplayed());
	}

	public void clickDownloadTab() {
		downloandTab.click();
	}

	public void clickMovieTab() {
		seleniumCore.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(movieTab));
		movieTab.click();
	}

	public void clickOpenMovieButton() {
		seleniumCore.getWebDriverWait().until(ExpectedConditions.visibilityOf(openMovieButton));
		openMovieButton.click();
	}

	public boolean videoIsPlaying() throws InterruptedException {
		seleniumCore.switchToNewCard();
		seleniumCore.getWebDriverWait().until(ExpectedConditions.visibilityOf(video));
		float firstLap = Float.parseFloat(video.getAttribute("currentTime"));
		Thread.sleep(1000);
		float secondLap = Float.parseFloat(video.getAttribute("currentTime"));
		return firstLap < secondLap;
	}
}
