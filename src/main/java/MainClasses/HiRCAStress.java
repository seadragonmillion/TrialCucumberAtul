import java.awt.image.RenderedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import kaleTestSoftware.HiRCAEvent;
import kaleTestSoftware.HiRCALOPBug2;
import kaleTestSoftware.HiRCALevel1;
import kaleTestSoftware.HiRCAObj;
import kaleTestSoftware.ShareCheck;
import kaleTestSoftware.ShareCheck2;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAStress {

	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	HiRCAObj hirca = new HiRCAObj();
	HiRCALOPBug2 hlb2 = new HiRCALOPBug2 ();

	public String text = "HiRCA Stress test";
	SoftAssertions softly = new SoftAssertions();

	public void HiRCAUpload10Images(WebDriver driver) throws Exception {

		HiRCALevel1 obj2 = new HiRCALevel1();
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Go to Analysis page and fill Info page
		hlb2.fillPage(driver, text);
		//Upload 10 images
		uploadFiveImages(driver);
		//Clicks on Saved activities
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		share2.loadingServer(driver);
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		share2.loadingServer(driver);
		//Checks the 5 images if appearing
		for (int j=0; j<5; j++)
		{				  
			//Click on Supporting file details
			Thread.sleep(500);
			String id = "pii-irca-h-event-report-filecollapsible-"+j;
//			share2.scrollToElement(driver, driver.findElement(By.id(id)));
			jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			String img = "pii-irca-h-event-report-file-img-"+j;
			try{
				jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img))));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			}catch(org.openqa.selenium.TimeoutException y)
			{
				softly.fail("Image not visible");
			}

		}
		Thread.sleep(1000);
		share2.scrollToTop(driver);
		//Downloads record
		downloadSelectFunction(driver);
		Thread.sleep(2000);	
		//Delete report
		obj2.deleteReport(driver);
	}

	public  void downloadSelectFunction (WebDriver driver) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			downloadRecordChrome(driver);
		if (browserName.equals("firefox"))
			downloadRecordFirefox(driver);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				downloadRecordIE10(driver);
			if (v.startsWith("11"))
				downloadRecordIE11(driver);
		}
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(2000);
	}

	public  void pdfCheck() throws Exception{

		HiRCAEvent obj = new HiRCAEvent();
		List<String> results = new ArrayList<String>();
		//Gets the file name which has been downloaded
		File[] files = new File("C://Users//mama//Downloads//EFTestDownloadReports//").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		for (File file : files) {
			if (file.isFile()) {
				results.add(file.getName());
			}
		}
		System.out.println(results.get(0));
		//Loads the file to check if correct data is present
		String fileName="C://Users//mama//Downloads//EFTestDownloadReports//"+results.get(0);
		File oldfile = new File(fileName);
		//Checks number of images in pdf
		PDDocument pddoc= PDDocument.load(oldfile);
		List<RenderedImage> images = new ArrayList<>();
		images=obj.getImagesFromPDF(pddoc);
		System.out.println("Number of images: "+images.size());
		softly.assertThat(images.size()).as("test data").isEqualTo(20);
		pddoc.close();	      
	}

	public void downloadRecordChrome (WebDriver driver) throws Exception {

//		HiRCAEvent obj2 = new HiRCAEvent();
		//deletes files in reports folder before starting to download
//		File file = new File("C://Users//mama//Pictures//");
//		obj2.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String window = driver.getWindowHandle();
		//Clicks on download button
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]")))); 
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
//		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\ChromSavePDF5_amlocal.exe");
		Thread.sleep(4000);
		try {
		Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/ChromSavePDF5_amlocal.exe");

		q.waitFor();
		}catch (UnhandledAlertException f){	
		System.out.println("Unexpected alert");
		driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
		System.out.println ("No unexpected alert");}
//		pdfCheck();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);
	}


	public  void downloadRecordFirefox(WebDriver driver) throws Exception {

		HiRCAEvent obj2 = new HiRCAEvent();
		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		obj2.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(8000);
		for(String winHandle : driver.getWindowHandles())
		{
			System.out.println(winHandle);
			if(winHandle.isEmpty()==false)
			{
				if(winHandle.equals(window)==false)
					driver.switchTo().window(winHandle);
			}
		}
		Thread.sleep(4000);/*
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
		p.waitFor();*/
		pdfCheck();
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();
	}

	public  void downloadRecordIE10(WebDriver driver) throws Exception {

		HiRCAEvent obj2 = new HiRCAEvent();
		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		obj2.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert for picture 2");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(7000);
		List<String> results = new ArrayList<String>();
		File[] files = new File("C://Users//mama//Downloads//EFTestDownloadReports//").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		for (File file1 : files) {
			if (file1.isFile()) {
				results.add(file.getName());
			}
		}
		System.out.println(results.get(0));
		if(results.get(0).endsWith(".pdf")==false)
		{
			obj2.deleteFiles(file);
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(4000);
			try {
				Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
				q.waitFor();
			}catch (UnhandledAlertException f){	
				System.out.println("Unexpected alert");
				driver.switchTo().alert().accept();

			}catch (NoAlertPresentException f){
				System.out.println ("No unexpected alert");
			}
			Thread.sleep(6000);
		}
		//pdf verification
		pdfCheck();
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);				    		    	
	}


	public  void downloadRecordIE11(WebDriver driver) throws Exception {

		HiRCAEvent obj2 = new HiRCAEvent();
		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		obj2.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(4000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(8000);
		//pdf verification
		pdfCheck();
		Thread.sleep(4000);
		//Close pdf
		//Switch to window    	
		driver.switchTo().window(window);			    		    	
	}

	public  void uploadTenImagesChrome(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String filepath = "C:/Users/mama/Pictures/Upload/CCYC2355.JPG";
		for (int j=0; j<10; j++)
		{
			//Click on Supporting file details
//			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))));
			//Click on bottom next button
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-controlgroup-controls ']/button[@type='submit']"))));
			//Click on Supporting File Collapsible
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-irca-event-filecollapsible-"+j+"']/h4/a"))));
//			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-"+j))));
			//Fill title and description
			String title_id="pii-irca-event-file-title-"+j;
			jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-"+j))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title0"+j);
			//Upload Photo
			String file = "pii-irca-event-file-"+j;
			WebElement l=driver.findElement(By.id(file));
			//Actions act= new Actions(driver);
			//act.moveToElement(l).build().perform();
			Thread.sleep(1000);
			l.sendKeys(filepath);
//			driver.findElement(By.id("pii-irca-event-file-"+j)).sendKeys(filepath);
			//Wait for image
//			jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+j))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+j)));
			if(j<9)
			{
				//Click on attach another file
				WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
				jse.executeScript("arguments[0].focus();", add);
				jse.executeScript("arguments[0].click();", add);
//				share2.scrollToElement(driver, add);
//				add.click();
			}
		}
		share2.scrollToTop(driver);
		jse.executeScript("document.getElementById('efi-irca-button-save').focus();");
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		jse.executeScript("arguments[0].focus();", driver.findElement(By.id("efi-irca-button-save")));
		jse.executeScript("arguments[0].click();", driver.findElement(By.id("efi-irca-button-save")));
//		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));
		share2.loadingServer(driver);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);		
		//Clicks on Save
		jse.executeScript("arguments[0].focus();", driver.findElement(By.id("efi-irca-button-save")));
		jse.executeScript("arguments[0].click();", driver.findElement(By.id("efi-irca-button-save")));
//		driver.findElement(By.id("efi-irca-button-save")).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));
		Thread.sleep(500);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
	}

	public  void uploadTenImagesFirefox(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		for (int j=0; j<10; j++)
		{
			//Click on Supporting file details
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))).click();
			//Uploads file
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-"+j))));
			//Fill title and description
			String title_id="pii-irca-event-file-title-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title0"+j);
			driver.findElement(By.id("pii-irca-event-file-"+j)).click();
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumHiRCA.exe");
			q.waitFor();
			//Wait for image
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+j)));
			if(j<9)
			{
				//Click on attach another file
				WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
				share2.scrollToElement(driver, add);
				add.click();
			}
		}
		share2.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		share2.loadingServer(driver);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
	}

	public  void uploadTenImagesIE10(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (int j=0; j<10; j++)
		{
			//Click on Supporting file details
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))).click();
			//Uploads file
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-"+j))));
			//Fill title and description
			String title_id="pii-irca-event-file-title-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title0"+j);
			String file = "pii-irca-event-file-"+j;
			jse.executeScript("return document.getElementById('"+file+"').click();");
			try {
				Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpecetd alert for picture 2");
				driver.switchTo().alert().accept();
			}catch (NoAlertPresentException f){
				System.out.println ("No unexpected alert for picture 2");
			}
			//Wait for image
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+j)));
			if(j<9)
			{
				//Click on attach another file
				WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
				share2.scrollToElement(driver, add);
				add.click();
			}
		}
		share2.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		share2.loadingServer(driver);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
	}

	public  void uploadTenImagesIE11(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (int j=0; j<10; j++)
		{
			//Click on Supporting file details
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+j))).click();
			//Uploads file
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-"+j))));
			//Fill title and description
			String title_id="pii-irca-event-file-title-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title0"+j);
			String file = "pii-irca-event-file-"+j;
			jse.executeScript("return document.getElementById('"+file+"').click();");
			try {
				Process p = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpecetd alert for picture 2");
				driver.switchTo().alert().accept();
			}catch (NoAlertPresentException f){
				System.out.println ("No unexpected alert for picture 2");
			}
			//Wait for image
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+j)));
			if(j<9)
			{
				//Click on attach another file
				WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
				share2.scrollToElement(driver, add);
				add.click();
			}
		}
		share2.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		share2.loadingServer(driver);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Verify if all 10 images are present
		verifyImagesUploaded(driver);
	}

	public  void verifyImagesUploaded(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for (int i=0;i<=9;i++)
		{
			jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+i))));
			if(driver.findElement(By.id("pii-irca-event-file-img-"+i)).isDisplayed())
			{
				System.out.println("Image"+i+ "   is Displayed");
			}
		}
		/*
		for (int i=0;i<=9;i++)
		{
//			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+i))));
			jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+i))));
			//Clicks on collapsible
			if(driver.findElement(By.id("pii-irca-event-file-img-"+i)).isDisplayed()==false)
				jse.executeScript("arguments[0].focus();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))));
				//Checks for image
				jse.executeScript("arguments[0].focus();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+i))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+i)));
			Thread.sleep(2000);
			//Clicks on collapsible again
			jse.executeScript("arguments[0].focus();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))).click();
		}*/
		share2.scrollToTop(driver);
		share2.scrollToTop(driver);
	}

	public  void uploadFiveImages(WebDriver driver) throws Exception {

		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			uploadTenImagesChrome(driver);
		if (browserName.equals("firefox"))
			uploadTenImagesFirefox(driver);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				uploadTenImagesIE10(driver);
			if (v.startsWith("11"))
				uploadTenImagesIE11(driver);
		}
	}

	public  void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
