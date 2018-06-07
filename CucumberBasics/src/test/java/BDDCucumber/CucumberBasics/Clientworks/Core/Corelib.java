package BDDCucumber.CucumberBasics.Clientworks.Core;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Corelib {
	WebDriver driver = null;
	Properties envConf = null;
	Properties ORConf = null;

	public Corelib() {

		if (envConf == null) {
			try {
				FileInputStream EnvFS = new FileInputStream(
						System.getProperty("user.dir")
								+ "\\src\\test\\java\\BDDCucumber\\CucumberBasics\\Clientworks\\Config\\EnvConfig.Properties");
				envConf = new Properties();
				envConf.load(EnvFS);

				FileInputStream ORFS = new FileInputStream(
						System.getProperty("user.dir")
								+ "\\src\\test\\java\\BDDCucumber\\CucumberBasics\\Clientworks\\Config\\OR.Properties");
				ORConf = new Properties();
				ORConf.load(ORFS);

			} catch (Exception e) {
				System.out
						.println("Failed to initialize the EnvConf Properties");
			}
		}
		// TODO Auto-generated constructor stub
	}

	public void OpenBrowser(String BrowserName) {
		try {
			if (BrowserName.trim().equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						ORConf.getProperty("Chrome64Driver"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				options.setCapability("chrome.binary", "");
				options.setCapability("chrome.switches",
						Arrays.asList("--ignore-certificate-errors"));
				options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				HashMap<String, Object> prefs = new HashMap();
				prefs.put("download.default_directory", "C:\\downloads");
				options.setExperimentalOption("prefs", prefs);
				options.addArguments(Arrays.asList(
						"allow-running-insecure-content",
						"ignore-certificate-errors"));
				options.addArguments(Arrays.asList("test-type",
						"start-maximized", "no-default-browser-check"));
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--disable-extensions");
				options.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(options);

			} else if (BrowserName.trim().equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						ORConf.getProperty("GeckoDriver"));
				driver = new FirefoxDriver();
				driver.manage().window().maximize();

			} else if (BrowserName.trim().equalsIgnoreCase("ie")) {
				Runtime.getRuntime().exec(
						"RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2");
				// Deleting IE Cookies
				Runtime.getRuntime().exec(
						"RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 8");
				// Deleting IE Saved Passwords
				Runtime.getRuntime().exec(
						"RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 16");
				// Deleting IE Saved Form data
				Runtime.getRuntime().exec(
						"RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 32");
				System.out
						.println("---------------Internet Explorer driver initialized ---------- OS : "
								+ System.getProperty("os.name") + "----------");
				System.setProperty("webdriver.ie.driver",
						ORConf.getProperty("IE32Driver"));
				InternetExplorerOptions ieOptions = new InternetExplorerOptions();
				ieOptions
						.setCapability(
								InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
								true);
				ieOptions.setCapability(
						InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,
						false);
				ieOptions.setCapability(
						InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				ieOptions.setCapability(
						InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				ieOptions.setCapability(
						InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR,
						UnexpectedAlertBehaviour.IGNORE);
				ieOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				// This command will be updated later
				String cmd = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\New Windows\" /F /V \"PopupMgr\" /T REG_SZ /D \"no\"";

				// Setting Default Download Folder for IE
				String downloadFolderCmd = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\Main\" /F /V \"Download Directory\" /T REG_SZ /D "
						+ "\"" + "C:\\downloads" + "\"";
				String defdownloadFolderCmd = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\Main\" /F /V \"Default Download Directory\" /T REG_SZ /D "
						+ "\"" + "C:\\downloads" + "\"";

				Runtime.getRuntime().exec(cmd);
				Runtime.getRuntime().exec(downloadFolderCmd);
				Runtime.getRuntime().exec(defdownloadFolderCmd);

				driver = new InternetExplorerDriver(ieOptions);
				driver.manage().window().maximize();

			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Error in launching the Webdriver");
		}
	}

	public void staticWait(int timeInSeconds) {
		try {
			driver.manage().timeouts()
					.implicitlyWait(timeInSeconds, TimeUnit.SECONDS);

		} catch (Exception e) {
			System.out.println("Failed to wait for the defined time");
			e.printStackTrace();
		}
	}

	public void navigate() {
		driver.get(envConf.getProperty("URL"));
	}

	public void waitUntilVisible(WebDriver driver, final By objName,
			int timeInSeconds) {
		try {
			new WebDriverWait(driver, timeInSeconds)
					.until(new Function<WebDriver, Boolean>() {
						public Boolean apply(WebDriver driver) {
							boolean isObjectFound = false;
							try {
								int Count = driver.findElements(objName).size();
								if (Count > 0) {
									isObjectFound = true;
								}

							} catch (NoSuchElementException e) {
								System.out
										.println("Your Window Name not found");
								System.out.println(driver.getTitle());
								return isObjectFound;
							}
							return isObjectFound;
						}
					});

		} catch (Exception e) {

		}
	}

}