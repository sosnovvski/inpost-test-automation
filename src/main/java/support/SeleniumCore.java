package support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SeleniumCore {
	private static final long WEB_DRIVER_WAIT_TIMEOUT_IN_SECONDS = 80;

	private Wait<WebDriver> webDriverWait;
	private WebDriver webDriver;

	public SeleniumCore() {
		webDriver = initializeDriverSession();
		webDriverWait = new WebDriverWait(webDriver, WEB_DRIVER_WAIT_TIMEOUT_IN_SECONDS, 2000);

	}

	public Wait<WebDriver> getWebDriverWait() {
		return webDriverWait;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	private WebDriver initializeDriverSession() {
		ChromeDriverManager.getInstance(ChromeDriver.class).setup();
		Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.prompt_for_download", false);

		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setExperimentalOption("prefs", chromePrefs);
		browserOptions.addArguments("--disable-extensions");
		browserOptions.addArguments("--no-sandbox");
		browserOptions.addArguments("start-maximized");
		return new ChromeDriver(browserOptions);
	}

	public void switchToNewCard() {
		String oldTab = getWebDriver().getWindowHandle();
		ArrayList<String> newTab = new ArrayList<>(getWebDriver().getWindowHandles());
		newTab.remove(oldTab);
		getWebDriver().switchTo().window(newTab.get(0));
	}
}
