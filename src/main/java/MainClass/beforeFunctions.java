package MainClass;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


public class beforeFunctions {

	public WebDriver beforeChromeTest(WebDriver driver, String url) throws MalformedURLException{

		System.out.println("Test in Chrome on Windows");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		chromeOptionsMap.put("plugins.plugins_disabled", new String[] {
				"Chrome PDF Viewer"
		});
		chromeOptionsMap.put("plugins.always_open_pdf_externally", true);
		options.setExperimentalOption("prefs", chromeOptionsMap);
		String downloadFilepath = "C:\\Users\\mama\\Downloads\\EFTestDownloadReports";
		chromeOptionsMap.put("download.default_directory", downloadFilepath);
		options.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver beforeSafariTechTest(WebDriver driver,String url) throws MalformedURLException{

		System.out.println("Test in Safari on MAC");
		System.setProperty("webdriver.safari.driver", "/Applications/Safari Technology Preview.app/Contents/MacOS/safaridriver");
		SafariOptions options = new SafariOptions();
		options.setUseTechnologyPreview(true);
		driver = new SafariDriver(options);
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public WebDriver beforeSafariTest(WebDriver driver,String url) throws MalformedURLException{

		System.out.println("Test in Safari on MAC");
		driver = new SafariDriver();
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver beforeFirefoxTest(WebDriver driver,String url) throws MalformedURLException{

		System.out.println("Test in Firefox on Windows");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\geckodriver.exe");
		ProfilesIni ffProfiles = new ProfilesIni();
		FirefoxProfile profile = ffProfiles.getProfile("MainClass.HiRCAEvent");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", "C:\\Users\\mama\\Downloads\\EFTestDownloadReports");
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability(FirefoxDriver.PROFILE, profile);
		driver = new FirefoxDriver(options);
		Dimension initialSize= driver.manage().window().getSize();
		System.out.println(initialSize);
		int height=initialSize.getHeight();
		if(height<950)
		{
			//Browser is maximized
			driver.manage().window().maximize(); 
		}
		Dimension finalSize=driver.manage().window().getSize();
		System.out.println(finalSize);
		//Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver beforeIE10Test(WebDriver driver,String url) throws MalformedURLException{

		System.out.println("Test in IE10 on Windows");
		System.setProperty("webdriver.ie.driver","C:\\Users\\rramakrishnan\\DriversForSelenium\\IEDriverServer.exe");
		InternetExplorerOptions options = new InternetExplorerOptions(); 
		options.setCapability("ignoreZoomSettings", true);
		options.setCapability("requireWindowFocus", true);
		driver = new InternetExplorerDriver(options);
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public WebDriver beforeIE11Test(WebDriver driver,String url) throws MalformedURLException{

		System.out.println("Test in IE11 on Windows");
		System.setProperty("webdriver.ie.driver","C:\\Users\\IEUser\\DriversForSelenium\\IEDriverServer.exe");
		InternetExplorerOptions options = new InternetExplorerOptions(); 
		options.setCapability("ignoreZoomSettings", true);
		options.setCapability("requireWindowFocus", true);
		driver = new InternetExplorerDriver(options);
		//Browser is maximized
		driver.manage().window().maximize();
		//Browser navigates to the KALE url
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
