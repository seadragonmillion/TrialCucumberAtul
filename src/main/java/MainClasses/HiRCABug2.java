import kaleTestSoftware.*;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCABug2 {

	HiRCALOPBug2 hlb2 = new HiRCALOPBug2();
	HiRCALevel1 hircaL1 = new HiRCALevel1();
	HiRCALevel2 hircaL2 = new HiRCALevel2();
	ShareCheck share = new ShareCheck();
	ShareCheck2 share2 = new ShareCheck2();
	CreateEquipPageObj equip = new CreateEquipPageObj();

	public String text = "HiRCA bug";
	SoftAssertions softly = new SoftAssertions();

	public void uploadImageChrome(WebDriver driver, int j) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions builder = new Actions(driver);
		String filepath = "C:/Users/mama/Pictures/Upload/CCYC2355.JPG";
		String id = "pii-irca-event-filecollapsible-"+j;
		//Focus on Bottom Next Button
		WebElement nextb=driver.findElement(By.xpath(".//div[@class='ui-controlgroup-controls ']/button[@type='submit']"));
		jse.executeScript("arguments[0].scrollIntoView();", nextb);
		Thread.sleep(400);
		builder.moveToElement(driver.findElement(By.id("pii-irca-event-filecollapsible-0"))).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-button-"+j)));
		//Uploads file
		String file = "pii-irca-event-file-"+j;
		WebElement l=driver.findElement(By.id(file));
		l.sendKeys(filepath);
		String img = "pii-irca-event-file-img-"+j;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-button-"+j)));
	}

	public void uploadImageFirefox(WebDriver driver, int j) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String id = "pii-irca-event-filecollapsible-"+j;
		share2.scrollToElement(driver, driver.findElement(By.id(id)));
		driver.findElement(By.id(id)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-button-"+j)));
		//Uploads file
		String file = "pii-irca-event-file-"+j;
		WebElement l=driver.findElement(By.id(file));
		jse.executeScript("arguments[0].scrollIntoView();", l);
		jse.executeScript("arguments[0].click();", l);
		Thread.sleep(2000);
		Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumHiRCA.exe");
		p.waitFor();
		Thread.sleep(2000);
		String img = "pii-irca-event-file-img-"+j;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-button-"+j)));
	}

	public void uploadImageIE10(WebDriver driver, int j) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String id = "pii-irca-event-filecollapsible-"+j;
		share2.scrollToElement(driver, driver.findElement(By.id(id)));
		driver.findElement(By.id(id)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-button-"+j)));
		//Uploads file
		String file = "pii-irca-event-file-"+j;
		WebElement l=driver.findElement(By.id(file));
		share2.scrollToElement(driver, l);
		jse.executeScript("return document.getElementById('"+file+"').click();");
		Thread.sleep(8000);
		try {
			Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
			p.waitFor();
		}catch (UnhandledAlertException f){		
			System.out.println("Unexpecetd alert for picture 2");
			driver.switchTo().alert().accept();
		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(6000);
		String img = "pii-irca-event-file-img-"+j;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-button-"+j)));
	}

	public void uploadImageIE11(WebDriver driver, int j) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String id = "pii-irca-event-filecollapsible-"+j;
		share2.scrollToElement(driver, driver.findElement(By.id(id)));
		driver.findElement(By.id(id)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-button-"+j)));
		//Uploads file
		String file = "pii-irca-event-file-"+j;
		WebElement l=driver.findElement(By.id(file));
		share2.scrollToElement(driver, l);
		jse.executeScript("return document.getElementById('"+file+"').click();");
		Thread.sleep(2000);
		try {
			Process p = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
			p.waitFor();
		}catch (UnhandledAlertException f){		
			System.out.println("Unexpecetd alert for picture 2");
			driver.switchTo().alert().accept();
		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(2000);
		String img = "pii-irca-event-file-img-"+j;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-button-"+j)));
	}

	public void enterTitleDesc(WebDriver driver, int j) throws Exception {

		//Fill title and description
		String title_id="pii-irca-event-file-title-"+j;
		driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
		String desc = "pii-irca-event-file-description-"+j;
		driver.findElement(By.id(desc)).sendKeys("Description0"+j);
	}

	public void uploadImage(WebDriver driver, int j) throws Exception {

		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if(browserName.equals("chrome"))
			uploadImageChrome(driver,j);
		if(browserName.equals("firefox"))
			uploadImageFirefox(driver,j);
		if(browserName.equals("internet explorer"))
		{
			if(v.startsWith("10"))
				uploadImageIE10(driver,j);
			if(v.startsWith("11"))
				uploadImageIE11(driver,j);
		}
	}

	public void bugKALE2332QAA758(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		hlb2.fillPage(driver, text);
		//Scroll to image and upload one image with title
		uploadImage(driver,0);
		enterTitleDesc(driver, 0);
		//Click on add supporting file
		WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
		share2.scrollToElement(driver, add);
		WebElement nextb=driver.findElement(By.xpath(".//div[@class='ui-controlgroup-controls ']/button[@type='submit']"));
		jse.executeScript("arguments[0].scrollIntoView();", nextb);
		add.click();
		//save hirca report and open report
		share2.scrollToTop(driver);
		hircaL2.saveHiRCAReport(driver);
		//Scroll down
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-h-event-report-filecollapsible-0"))));
		
		//Click on collapsible of image
		WebElement col=driver.findElement(By.id("pii-irca-h-event-report-filecollapsible-0"));
		jse.executeScript("arguments[0].scrollIntoView();", col);
		jse.executeScript("arguments[0].click();", col);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify no warning message
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-h-event-report-file-status-0"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("Warning: no file attached.");
			softly.fail("No warning message should appear: "+s);
		}catch(org.openqa.selenium.TimeoutException t)
		{

		}
		share2.scrollToTop(driver);
		//Delete report
		hircaL1.deleteReport(driver);
	}

	public void bugKALE2330QAA757(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		hlb2.fillPage(driver, text);
		for(int j=0;j<3;j++)
		{
			//Scroll to image and upload one image with title
			uploadImage(driver,j);
			//Click on add supporting file
			WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
			jse.executeScript("arguments[0].scrollIntoView();", add);
			share2.scrollToElement(driver, add);
			add.click();
		}
		//save hirca report and open report
		share2.scrollToTop(driver);
		hircaL2.saveHiRCAReport(driver);
		//Scroll down
		WebElement col=driver.findElement(By.id("pii-irca-h-event-report-filecollapsible-0"));
		jse.executeScript("arguments[0].scrollIntoView();", col);
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-h-event-report-filecollapsible-0"))));
		//Checks the 5 images if appearing
		for (int j=0; j<3; j++)
		{				  
			//Click on Supporting file details
			Thread.sleep(500);
			String id = "pii-irca-h-event-report-filecollapsible-"+j;
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			if(browserName.contains("chrome"))
			{
				while(true)
				{
					jse.executeScript("arguments[0].focus();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='"+id+"']/h4/a"))));
					jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='"+id+"']/h4/a"))));
					if(driver.findElement(By.xpath(".//*[@id='"+id+"']/div/div/table")).isDisplayed())
					{
						break;
					}
				}
			}
			else
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			    jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			String img = "pii-irca-h-event-report-file-img-"+j;
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img))));
			jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img))));
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				System.out.println("Image "+ (j+1) + " is displayed");	
			}
		}
		share2.scrollToTop(driver);
		//Delete report
		hircaL1.deleteReport(driver);
	}

	public void pathHiRCABug(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//KALE2332 or QAA758
		bugKALE2332QAA758(driver);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(equip.KaleHomePage)).click();
		//KALE2330 or QAA757
		bugKALE2330QAA757(driver);
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
