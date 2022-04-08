package MainClass;

import java.util.Iterator;
import java.util.List;

import PageObjects.EiRCAPageObj;
import PageObjects.HPIObj;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HPI {

	EiRCAPageObj eirca = new EiRCAPageObj();
	HPIObj hpi = new HPIObj();
	HPI2 hpi2 = new HPI2();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	ShareCheck3 share3 = new ShareCheck3();
	ErrorMeter3 em3 = new ErrorMeter3 ();

	SoftAssertions softly = new SoftAssertions();

	public String createReport (WebDriver driver,String username) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Clicks on MainClass.HPI
		wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPILink)).click();
		Thread.sleep(2000);
		hpi2.verifyNewReportPopup(driver, softly);
		//Select Purpose from dropdown
		WebElement element = driver.findElement(By.id("pii-hpi-select-purpose"));
		Select s = new Select (element);
		s.selectByVisibleText("PJB");
		Thread.sleep(2000);
		//Select Job type
		element = driver.findElement(By.id("pii-hpi-select-condition"));
		Select s1 = new Select (element);
		s1.selectByVisibleText("Analysis");
		Thread.sleep(2000);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-btn-next"))).click();
		Thread.sleep(2000);
		hops(driver);
		hopsBottomUp(driver);
		//Click on finalize
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-btn-done"))).click();
		Thread.sleep(2000);
		hpi2.verifyFinalizeReportPopup(driver, softly);
		//Click on finalize and save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-dialog-confirmed"))).click(); 
		//Waits for the green popup on the right top corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Creates expected record name
		Thread.sleep(3000);
		String date= driver.findElement(By.xpath(".//*[@id='pii-hpi-rpt-header']/span/span")).getText();
		System.out.println(date);
		String name = date + "_" +username;
		System.out.println ("Expected name of record: " +name);
		//Checks for 100% readiness in report
		WebElement element_id=driver.findElement(By.id("pii-hpi-rpt-gauge"));
		List<WebElement> element1 =element_id.findElements(By.tagName("text"));
		Iterator<WebElement> iter = element1.iterator();
		iter.next();
		String readiness=iter.next().getText();
		System.out.println("Readiness in report is: "+readiness);
		if (readiness.equals("100"))
			System.out.println("Shows in report 100%");
		else softly.fail("Doesnt show in report 100%");
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		//Gets the name of the record created
		WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"));
		String recordName = record.getText();
		if (record.isDisplayed())
		{
			System.out.println("Record found: "+ recordName);
		}
		else
			System.out.println ("Record not found.");

		//Checks if the record name is correct
		softly.assertThat(name).isEqualTo(recordName);
		return recordName;
	}

	public void deleteNewRecord(WebDriver driver, String recordName, int y) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//CLicks on first newly created record
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
		//Clicks on delete button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		//Clicks on delete report
		driver.findElement(By.id("pii-user-home-dialog-confirmed")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		Thread.sleep(2000);
		//Click on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		//Verify record deleted
		//Click on 1st record
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a")).getText();
		System.out.println(name);
		if (name!=recordName)
			System.out.println("Record deleted");
		else
			System.out.println("Record could not be deleted");
		//Verify report not retrieved by shared to person
		String sharer = em3.decideSharer (y);
		share.checkNoReportAfterDelete(driver, sharer, softly);
	}


	public void shareReport(WebDriver driver, String username, String password1, int y) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String sharer = em3.decideSharer (y);
		String sharerAdded = em3.decideSharerAdded (y);	
		//CLicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
		//Switches to the iframe
		//wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		//Clicks on share button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Enters username
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys(sharer);
		Thread.sleep(500);
		//Selects from dropdown
		WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
		dropdown.findElement(By.cssSelector(".ui-first-child")).click();
		//Clicks on add user
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Verifies user added
		String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		share3.shareTwice (driver,softly,0);
		//Clicks on save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Checks the username of creator and verifier
		WebElement creator = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='hpi-rpt']/div/span[2]/span")));
		String creatorUsername= creator.getText();
		System.out.println(creatorUsername);
		softly.assertThat(username).as("test data").isEqualTo(creatorUsername);
		WebElement sharedTo=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='hpi-rpt']/div/span[3]/span")));
		String sharedToUsername = sharedTo.getText();
		System.out.println(sharedToUsername);
		softly.assertThat(sharer).as("test data").isEqualTo(sharedToUsername);
		WebElement shared=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='hpi-rpt']/div/span[3]")));
		String sharedText = shared.getText();
		System.out.println(sharedText);
		softly.assertThat("Shared to:").as("test data").isSubstringOf(sharedText);
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Share icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a/span[1]")));		
		//Calls the Share check function
		share.receiptReport(driver, sharer, username, password1);
		//Clicks on MainClass.HPI side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
	}

	public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on mark critical
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Checks if marked critical
		share2.loadingServer(driver);
		String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
		softly.assertThat(s).as("test data").contains("ui-checkbox-on");
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Marked critical icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a/span[1]")));
		//Verify presence of shared icon 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a/span[2]")));
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
		share2.loadingServer(driver);
		//Clicks on mark critical again
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(2000);
		share2.loadingServer(driver);
		String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
		softly.assertThat(s1).as("test data").contains("ui-checkbox-off");
		//Verify report not retrieved by shared to person
		String sharer = em3.decideSharer (y);
		share.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on MainClass.HPI side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).click();
	}


	public void hops(WebDriver driver) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//Clicks on check boxes on of H for HOPS
		String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(hpi.HTab2ndParagraphLabel1)).getText();
		softly.assertThat(s).as("test data").isEqualTo("(1) Do all involved participate in the PJB?");
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q1-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q2-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m1-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q1-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q2-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m1-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m1-l"))));


		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q3-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q4-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q5-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m2-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q3-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q4-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q5-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m2-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m2-l"))));

		share2.scrollToAPoint(driver, 1500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q6-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q7-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q8-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q9-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q10-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m3-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q6-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q7-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q8-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q9-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q10-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m3-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m3-l"))));


		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q11-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q12-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q13-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m4-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q11-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q12-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q13-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m4-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m4-l"))));


		//Click on O of HOPS
		share2.scrollToTop(driver);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-2"))));
		String sa = wait1.until(ExpectedConditions.visibilityOfElementLocated(hpi.OTab1stParagraphLabel1)).getText();
		softly.assertThat(sa).as("test data").isEqualTo("(1) Time related HRS identified in Error Meter?");
		String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(hpi.OTab2ndParagraphLabel2)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("(2) Activity related HRS identified in Error Meter?");
		String s2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(hpi.OTab3rdParagraphLabel1)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("(1) Person related HRS identified in Error Meter?");
		String s3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(hpi.OTab4thParagraphLabel1)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("(1) Environment related HRS identified in Error Meter?");
		//Click on checkboxes of O in HOPS
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q1-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q2-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m1-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		executor.executeScript("arguments[0].click();",	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q1-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q2-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m1-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m1-l"))));


		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q3-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q4-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q5-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m2-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q3-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q4-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q5-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m2-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m2-l"))));

		share2.scrollToAPoint(driver, 1500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q6-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q7-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m3-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q6-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q7-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m3-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m3-l"))));


		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q8-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q9-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m4-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q8-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q9-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m4-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m4-l"))));


		//Click on P of HOPS
		share2.scrollToTop(driver);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-3"))));
		//Click on checkboxes of P in HOPS
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q1-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q2-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q3-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q4-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q5-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m1-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q1-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q2-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q3-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q4-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q5-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m1-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m1-l"))));


		share2.scrollToAPoint(driver, 500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q6-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q7-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q8-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q9-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q10-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m2-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q6-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q7-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q8-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q9-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q10-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m2-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m2-l"))));


		share2.scrollToAPoint(driver, 1500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q11-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q12-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q13-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q16-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q17-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m3-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q11-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q12-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q13-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q16-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q17-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m3-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m3-l"))));


		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q14-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q15-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m4-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q14-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q15-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m4-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m4-l"))));


		//Click on S of HOPS
		share2.scrollToTop(driver);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-4"))));
		//Click on checkboxes of S in HOPS
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q1-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m1-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q1-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m1-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m1-l"))));


		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q3-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q4-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q5-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q6-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m2-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q3-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q4-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q5-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q6-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m2-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m2-l"))));


		share2.scrollToAPoint(driver, 1500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q7-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q8-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q9-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q10-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m3-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q7-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q8-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q9-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q10-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m3-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m3-l"))));


		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q11-l"))));
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m4-l")));
		}catch (org.openqa.selenium.TimeoutException u)
		{
			System.out.println("Corrective action not visible");
		}
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q11-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m4-l"))));
		Thread.sleep(500);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m4-l"))));
		share2.scrollToTop(driver);
		WebElement element_id=driver.findElement(By.id("pii-hpi-gauge"));
		List<WebElement> element =element_id.findElements(By.tagName("text"));
		Iterator<WebElement> iter = element.iterator();
		iter.next();
		String readiness=iter.next().getText();
		System.out.println("Readiness is: "+readiness);
		if (readiness.equals("0"))
			System.out.println("Shows 0%");
		else softly.fail("Doesnt show 0%");

	}

	public void hopsBottomUp(WebDriver driver) throws Exception{
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//Clicks on H of HOPS
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-1"))).click();
		//Clicks on bottom up on H for HOPS
		//Corrective action click
		share2.scrollToAPoint(driver, 2000);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m4-l"))));
		//Click on other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q13-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q12-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q11-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m4-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m4-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Adequate situation awareness?");
		}
		//Corrective action click
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m3-l"))));
		//Click other checkboxes 
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q10-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q9-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q8-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q7-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q6-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m3-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m3-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Adequate resources, structure, and TQA?");
		}
		share2.scrollToTop(driver);
		//Corrective action click
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m2-l"))));
		//Click other checkboxes 
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q5-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q4-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q3-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m2-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m2-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Participants ready for PJB?");
		}
		//Corrective action click
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m1-l"))));
		//Click other checkboxes 
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q2-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-q1-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m1-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-1-m1-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Adequate PJB level selection?");
		}


		//Click on O of HOPS
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-2"))).click();
		//Clicks on bottom up on O for HOPS
		//Corrective action click
		share2.scrollToAPoint(driver, 2000);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m4-l"))));
		//Click other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q9-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q8-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m4-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m4-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Environment related operating experience addressed?");
		}
		//Corrective action click
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m3-l"))));
		//Click other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q7-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q6-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m3-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m3-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Person related operating experience addressed?");
		}
		share2.scrollToTop(driver);
		//Corrective action click
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m2-l"))));
		//Click other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q5-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q4-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q3-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m2-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m2-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Activity related operating experience addressed?");
		}
		//Corrective action click
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m1-l"))));
		//Click other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q2-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-q1-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m1-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-2-m1-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Time related operating experience addressed?");
		}


		//Click on P of HOPS
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-3"))).click();
		//Clicks on bottom up on P for HOPS
		//Corrective action click
		share2.scrollToAPoint(driver, 2000);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m4-l"))));
		//Click other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q15-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q14-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m4-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m4-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Adequate deviation scenario management?");
		}
		//Corrective action click
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m3-l"))));
		//Click other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q17-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q16-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q13-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q12-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q11-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m3-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m3-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Adequate single-point-vulnerability (SPV) control?");
		}
		share2.scrollToTop(driver);
		//Corrective action click
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m2-l"))));
		//Click other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q10-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q9-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q8-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q7-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q6-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m2-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m2-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Plan complete (ROAST)?");
		}
		//Corrective action click
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m1-l"))));
		//Click other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q5-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q4-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q3-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q2-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-q1-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m1-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-3-m1-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Tool and equipment ready?");
		}


		//Click on S of HOPS
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-navbar-tab-4"))).click();
		//Verify FUSE full form
		String fuse_abbr = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-hpi-tab-4-fieldset']/label[2]/abbr"))).getAttribute("globtitle");
		softly.assertThat(fuse_abbr).as("test data").isEqualTo("First Time Evolution, Unbalanced Interests, SPV, Expertise Deficiency");
		//Clicks on bottom up on S for HOPS
		//Corrective action click
		share2.scrollToAPoint(driver, 2000);
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m4-l"))));
		//Click other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q11-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m4-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m4-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Project risk");
		}
		//Corrective action click
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m3-l"))));
		//Click other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q10-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q9-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q8-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q7-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m3-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m3-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in FUSE items mitigated?");
		}
		share2.scrollToTop(driver);
		//Corrective action click
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m2-l"))));
		//Click other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q6-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q5-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q4-l"))));
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q3-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m2-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m2-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in FUSE items identified?");
		}
		//Corrective action click
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m1-l"))));
		//Click other checkboxes
		executor.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-q1-l"))));
		Thread.sleep(1000);
		//Checks if corrective action checkbox got unselected
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m1-l"))).isSelected()==false)
		{
			System.out.println("Corrective action not checked");
		}
		if(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-tab-4-m1-l"))).isSelected()==true)
		{
			softly.fail("Failed: Corrective action checked in Project failure");
		}


		//Checks if the Readiness meter is 100%id("pii-hpi-gauge")/svg[1]/text[2]/tspan[1]
		//String readiness=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-hpi-gauge']/svg[1]/text[2]/tspan[1]"))).getText();
		WebElement element_id=driver.findElement(By.id("pii-hpi-gauge"));
		List<WebElement> element =element_id.findElements(By.tagName("text"));
		Iterator<WebElement> iter = element.iterator();
		iter.next();
		String readiness=iter.next().getText();
		System.out.println("Readiness is: "+readiness);
		if (readiness.equals("100"))
			System.out.println("Shows 100%");
		else softly.fail("Doesnt show 100%");

	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
