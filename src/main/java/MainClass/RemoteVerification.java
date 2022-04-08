package MainClass;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import PageObjects.EiRCAPageObj;
import PageObjects.LoginPageObj;
import PageObjects.RemoteVerificationPageObj;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;


public class RemoteVerification {

	SoftAssertions softly = new SoftAssertions();
	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();
	RemoteVerification3 rv3 = new RemoteVerification3();
	RemoteVerification4 rv4 = new RemoteVerification4();
	EiRCAPageObj eirca = new EiRCAPageObj();
	EiRCA3 eirca3 = new EiRCA3();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck3 share3 = new ShareCheck3();
	ShareCheck share = new ShareCheck();
	LoginPageObj lpo = new LoginPageObj();
	ErrorMeter3 em3 = new ErrorMeter3 ();
	UserManagement um = new UserManagement();

	public String testBugEmail = "testverifierusemail@gmail.com";


	public void checkStatusReport (WebDriver driver, String username, int k) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Mark read verifier email		
//		String email = selectEmail(k);
		String email = selectEmail(1);
		um.emailMarkRead(email, driver);
		//Clicks on Save
		share2.scrollToTop(driver);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSaveButton)));
		rv4.verifySaveReportPopup(driver, softly);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)));
		//Wait for loading message to disappear		
		share2.loadingServer(driver);
		//Click on Saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavedActivitiesButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify status
		String status = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportNotSentStatusMessage)).getText();
		softly.assertThat(status).as("test data").contains("Not yet sent to verifier");
		//Click on Open
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		String noHtml = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(noHtml).as("test data").doesNotContain("<br/>");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(1000);
		//Verify the report rename popup overflow text
		rv3.verifySavePopupAfterRename(driver, softly);
		//Clicks on Save and Send
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.toLowerCase().contains("safari"))
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", driver.findElement(rv.RVSaveAndSendButton));
		}
		else driver.findElement(rv.RVSaveAndSendButton).click();
		//Clicks on save and send report
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).click();
		rv4.verifySaveAndSendReportPopup(driver, softly);
		driver.findElement(rv.RVSavePopupConfirmButton).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify status
		String status1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportSentStatusMessage)).getText();
		softly.assertThat(status1).as("test data").contains("Sent, waiting upon verification");
		//Creates the expected name of record
		String creation_date = driver.findElement(rv.RVCreationDate).getText();
		creation_date= creation_date.substring(22, creation_date.length());
		String reportName = creation_date +"_"+ username + "_" + rv.eventTitle(driver,driver.getCurrentUrl());
		//Verify email
		verifyEmailForVerifier (driver,username,reportName,k);
	}

	public String selectEmail(int k) throws Exception{

		//dev admin
		if(k==1)
		{
			return um.emailDev;
		}
		//dev nonadmin
		if(k==2)
		{
			return um.emailDev;
		}
		//dev admin ie11
		if(k==3)
		{
			return um.emailDevie11;
		}
		//dev nonadmin ie11
		if(k==4)
		{
			return um.emailDevie11;
		}
		//asia admin
		if(k==5)
		{
			return um.emailAsia;
		}
		//asia nonadmin
		if(k==6)
		{
			return um.emailAsia;
		}
		//asia admin ie11
		if(k==7)
		{
			return um.emailAsiaie11;
		}
		//asia nonadmin ie11
		if(k==8)
		{
			return um.emailAsiaie11;
		}
		//us admin
		if(k==9)
		{
			return um.emailUS;
		}
		//us nonadmin
		if(k==10)
		{
			//return obj.emailUS;
			return testBugEmail;
		}
		//us admin ie11
		if(k==11)
		{
			return um.emailUSie11;
		}
		//us nonadmin ie11
		else
		{
			return um.emailUSie11;
		}
	}

	public void verifyEmailForVerifier (WebDriver driver,String username, String reportName, int k) throws Exception {

		//Get current Time
		long currentTime = System.currentTimeMillis();
		
		/*am_reduce to 1 minute
		//Add 15 minutes to it
		long time15 = currentTime + (15*60*1000);*/
		
		//Add 1 minutes to it
		long time15 = currentTime + (1*60*1000);
		String SMTP_HOST = "smtp.gmail.com";
//		String EMAIL_ADDRESS = selectEmail(k);
		String EMAIL_ADDRESS = "piikaleemailtest01@gmail.com";
//		String PASSWORD = "5sepkale";
		String PASSWORD = "pii@2021";
		String INBOX_FOLDER = "INBOX";	    
		Properties props = new Properties();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println("browserName is    :" +browserName);
		String v = cap.getVersion().toString();
		System.out.println("browserVersion is    :" +v);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("11"))
				props.load(new FileInputStream(new File( "C:\\Users\\IEUser\\DriversForSelenium\\smtp.properties" )));
			else
				props.load(new FileInputStream(new File( "C:\\Users\\rramakrishnan\\DriversForSelenium\\smtp.properties" )));
		}
		else if (browserName.contains("safari"))
			props.load(new FileInputStream(new File( "/Users/pamelachiu/Downloads/smtp.properties" )));
		else
			props.load(new FileInputStream(new File( "C:\\Users\\rramakrishnan\\DriversForSelenium\\smtp.properties" )));
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect(SMTP_HOST, EMAIL_ADDRESS, PASSWORD);
		Folder inbox = store.getFolder(INBOX_FOLDER);
		inbox.open(Folder.READ_ONLY);
		int messageCount = inbox.getMessageCount(); 
		System.out.println("Total Messages:- " + messageCount);
		Flags seen = new Flags(Flags.Flag.SEEN);
		FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
		Message[] messages1 = inbox.search(unseenFlagTerm);
		int messageCount1 = messages1.length;
		System.out.println("currentTime is    :"+ currentTime);
		System.out.println("time15 is    :"+ time15);
		System.out.println("messageCount1 is     :"+messageCount1);
		System.out.println("messages1 is     :" +messages1);
		
		while(true)
		{
			Thread.sleep(2000);
			if(currentTime>time15)
			{
				System.out.println("Time elapsed for email: More than 15 minutes");
				um.excelStore();
				break;
			}
			if (messageCount1>0)
				break;
			messages1 = inbox.getMessages();
			Thread.sleep(1000);
			messages1 = inbox.search(unseenFlagTerm);
			messageCount1 = messages1.length;
		}
		System.out.println("Unread messages: "+messageCount1);
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < messageCount1; i++) {
			Message message1 = messages1[i];
			System.out.println(i);
			System.out.println("Mail Subject:- " + messages1[i].getSubject());
			System.out.println("From: " + message1.getFrom());
			System.out.println("Text: " + message1.getContent().toString());
			System.out.println("Date of email: " + message1.getReceivedDate());
			sb = new StringBuffer( message1.getContent().toString());
		}
		System.out.println("**********************************************************************************************************************");
		System.out.println(messages1[messageCount1 -1].getReceivedDate());
		String emailText=sb.toString();
		System.out.println(emailText);
		//Verify content of email
		softly.assertThat(emailText).as("test data").contains(username);        
		//Modify reportname
		String s = emailText.replace((char)173,'*');
		System.out.println(s);
		String s1 = s.replace((char)60, '<');
		String s2 = s1.replace("<*", "<");
		System.out.println(s2);
		softly.assertThat(emailText).as("test data").contains(s2);
	}

	public void upload1stpictureSafari(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Uploads picture 1
		String filepath = "/Users/pamelachiu/Documents/Kale Case Test 1-20/Slide1.jpg";
		driver.findElement(rv.RV1stImageField).sendKeys(filepath);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageClearButton)).click();
		//Re-uploads same picture 1
		driver.findElement(rv.RV1stImageField).sendKeys(filepath);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageClearButton)).click();
		//Re-uploads different picture 1
		driver.findElement(rv.RV1stImageField).sendKeys("/Users/pamelachiu/Documents/Kale Case Test 1-20/Slide2.jpg");
		//Rotates image 1 twice
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageRotateButton)).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageRotateButton)).click();
	}

	public void upload1stpictureChrome(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Uploads picture 1
		String filepath = "C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg";
		driver.findElement(rv.RV1stImageField).sendKeys(filepath);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageClearButton)).click();
		//Re-uploads same picture 1
		driver.findElement(rv.RV1stImageField).sendKeys(filepath);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageClearButton)).click();
		//Re-uploads different picture 1
		driver.findElement(rv.RV1stImageField).sendKeys("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");
		//Rotates image 1 twice
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageRotateButton)).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageRotateButton)).click();
	}

	public void upload1stpictureFirefox(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on browse button of 1st picture
		jse.executeScript("arguments[0].click();", driver.findElement(rv.RV1stImageField));
		Thread.sleep(2000);
		//Uploads picture 1
		Process p=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		p.waitFor();
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageClearButton)).click();
		//Re-uploads same picture 1
		jse.executeScript("arguments[0].click();", driver.findElement(rv.RV1stImageField));
		Thread.sleep(2000);
		Process p1=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		p1.waitFor();
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageClearButton)).click();
		//Re-uploads different picture 1
		jse.executeScript("arguments[0].click();", driver.findElement(rv.RV1stImageField));
		Thread.sleep(2000);
		Process p2=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		p2.waitFor();
		Thread.sleep(4000);
		//Rotates image 1 twice
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageRotateButton)).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageRotateButton)).click();
	}

	public void upload1stpictureIE10(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,20);
		Actions act = new Actions(driver);
		//Clicks twice on browse button of 1st picture
		WebElement element2 =  driver.findElement(rv.RV1stImageField);
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
			try {
				//Uploads picture 1
				Process q=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEChrysanthemum.exe");				  
				q.waitFor();
			}catch (UnhandledAlertException g){
				System.out.println("Unexpected alert for picture 1");
				driver.switchTo().alert().accept();
			}
		}catch (NoAlertPresentException g){			  
			System.out.println ("No unexpected alerts for picture 1");
		}			 
		Thread.sleep(4000);
		//*Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageClearButton)).click();
		//Re-uploads picture 1
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
			try {
				//Uploads picture 1
				Process q=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEDesert.exe");				  
				q.waitFor();
			}catch (UnhandledAlertException g){
				System.out.println("Unexpected alert for picture 1");
				driver.switchTo().alert().accept();
			}
		}catch (NoAlertPresentException g){			  
			System.out.println ("No unexpected alerts for picture 1");
		}			 
		Thread.sleep(4000);
		//Rotates image 1 twice
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageRotateButton)).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageRotateButton)).click();
	}

	public void upload1stpictureIE11(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Clicks twice on browse button of 1st picture
		WebElement element2 =  driver.findElement(rv.RV1stImageField);
		Actions act = new Actions(driver);
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
			try {
				//Uploads picture 1
				Process q=Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEChrysanthemum.exe");				  
				q.waitFor();
			}catch (UnhandledAlertException g){
				System.out.println("Unexpected alert for picture 1");
				driver.switchTo().alert().accept();
			}
		}catch (NoAlertPresentException g){			  
			System.out.println ("No unexpected alerts for picture 1");
		}			 
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageClearButton)).click();
		//Same image
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
			try {
				//Uploads picture 1
				Process q=Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEChrysanthemum.exe");				  
				q.waitFor();
			}catch (UnhandledAlertException g){
				System.out.println("Unexpected alert for picture 1");
				driver.switchTo().alert().accept();
			}
		}catch (NoAlertPresentException g){			  
			System.out.println ("No unexpected alerts for picture 1");
		}			 
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageClearButton)).click();
		//Re-uploads different picture 1
		act.doubleClick(element2).build().perform();
		Thread.sleep(3000);
		try{
			try {
				//Uploads picture 1
				Process q=Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEDesert.exe");				  
				q.waitFor();
			}catch (UnhandledAlertException g){
				System.out.println("Unexpected alert for picture 1");
				driver.switchTo().alert().accept();
			}
		}catch (NoAlertPresentException g){			  
			System.out.println ("No unexpected alerts for picture 1");
		}			 
		Thread.sleep(4000);
		//Rotates image 1 twice
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageRotateButton)).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV1stImageRotateButton)).click();
	}

	public void upload2ndpictureSafari(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Uploads picture 2
		String file2 = "/Users/pamelachiu/Documents/Kale Case Test 1-20/Slide1.jpg";
		driver.findElement(rv.RV2ndImageField).sendKeys(file2);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageClearButton)).click();
		//Re-uploads same picture 2
		driver.findElement(rv.RV2ndImageField).sendKeys(file2);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageClearButton)).click();
		//Re-uploads different picture 2
		driver.findElement(rv.RV2ndImageField).sendKeys("/Users/pamelachiu/Documents/Kale Case Test 1-20/Slide2.jpg");
		//Rotates image 2 once
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageRotateButton)).click();
	}

	public void upload2ndpictureChrome(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Uploads picture 2
		String file2 = "C:/Users/mama/Pictures/Upload/CCYC2355.JPG";
		driver.findElement(rv.RV2ndImageField).sendKeys(file2);
		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\clickcancel2.exe");
		//Clears image
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageClearButton)));
		//Re-uploads same picture 2
		driver.findElement(rv.RV2ndImageField).sendKeys(file2);
		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\clickcancel2.exe");
		//Clears image
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageClearButton)));
		//Re-uploads different picture 2
		driver.findElement(rv.RV2ndImageField).sendKeys("C:/Users/mama/Pictures/Upload/BBGA2184.jpg");
		//Rotates image 2 once
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageRotateButton)));
	}

	public void upload2ndpictureFirefox(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on browse button of 2nd picture
		jse.executeScript("arguments[0].click();", driver.findElement(rv.RV2ndImageField));
		Thread.sleep(2000);
		//Uploads picture 2
		Process p3=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		p3.waitFor();
		Thread.sleep(8000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageClearButton)).click();
		//Re-uploads same picture 2
		jse.executeScript("arguments[0].click();", driver.findElement(rv.RV2ndImageField));
		Thread.sleep(2000);
		Process p2=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		p2.waitFor();
		Thread.sleep(8000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageClearButton)).click();
		//Re-uploads different picture 2
		jse.executeScript("arguments[0].click();", driver.findElement(rv.RV2ndImageField));
		Thread.sleep(2000);
		Process p1=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		p1.waitFor();
		Thread.sleep(8000);
		//Rotates image 2 once
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageRotateButton)).click();
	}

	public void upload2ndpictureIE10(WebDriver driver) throws Exception {

		//Clicks twice on browse button of 2nd picture
		WebElement element =  driver.findElement(rv.RV2ndImageField);
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
		Thread.sleep(3000);
		try{
			try {
				//Uploads picture 2
				Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEChrysanthemum.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpected alert for picture 2");
				driver.switchTo().alert().accept();
			}
		}catch (NoAlertPresentException f){			  
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(4000);
		//Clears image
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageClearButton)).click();
		//Re-uploads picture 2
		act.doubleClick(element).build().perform();
		Thread.sleep(3000);
		try{
			try {
				//Uploads picture 2
				Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/IEDesert.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpected alert for picture 2");
				driver.switchTo().alert().accept();
			}

		}catch (NoAlertPresentException f){			  
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(4000);
		//Rotates image 2 once
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageRotateButton)).click();
	}

	public void upload2ndpictureIE11(WebDriver driver) throws Exception {

		//Clicks twice on browse button of 2nd picture
		WebElement element =  driver.findElement(rv.RV2ndImageField);
		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
		Thread.sleep(3000);
		try{
			try {
				//Uploads picture 2
				Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEChrysanthemum.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpected alert for picture 2");
				driver.switchTo().alert().accept();
			}

		}catch (NoAlertPresentException f){			  
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(4000);
		//Clears image
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageClearButton)).click();
		//Re-uploads same picture 2
		act.doubleClick(element).build().perform();
		Thread.sleep(3000);
		try{
			try {
				//Uploads picture 2
				Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEChrysanthemum.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpected alert for picture 2");
				driver.switchTo().alert().accept();
			}

		}catch (NoAlertPresentException f){			  
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(4000);
		//Clears image
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageClearButton)).click();
		//Re-uploads same picture 2
		act.doubleClick(element).build().perform();
		Thread.sleep(3000);
		try{
			try {
				//Uploads picture 2
				Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IEDesert.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpected alert for picture 2");
				driver.switchTo().alert().accept();
			}

		}catch (NoAlertPresentException f){			  
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(4000);
		//Rotates image 2 once
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RV2ndImageRotateButton)).click();
	}

	public void verifyDateTime(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Get time and date from RV location map
		String timeDate = wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVDateTimeAboveLocationImage)).getText();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		int minute = cal.get(Calendar.MINUTE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		//Verify if hour is correct
		softly.assertThat(timeDate).as("test data").contains(Integer.toString(hour));
		//Verify if minute is within 20 minutes of present time + or -
		if((minute>=minute-10) ||(minute<=minute+10))
		{
			System.out.println("Minute correct");
		}
		else softly.fail("Time minutes part is not within 20 minutes of actual time");
		//Verify if date is correct
		softly.assertThat(timeDate).as("test data").contains(dateFormat1.format(cal.getTime()));

	}

	public void verifyLongitudeLatitude(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Get browser value
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//String version = cap.getVersion().toLowerCase();
		//Get longitude latitude from rv location image
		String location = wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVLatitudeLongitudeAboveLocationImage)).getText();
		System.out.println(location); 
		String url = driver.getCurrentUrl();
		if(url.contains("kaleqa")&&browserName.contains("safari")==false)
		{
			//Store in excel
			//excelStore(location,browserName,version);
		}	    
//		String address = "462 Stevens Avenue, Suite #306 Solana Beach, CA 92705";
		String address = "Taipei";
		Thread.sleep(4000);
		String latLongs[] = getLatLongPositions(address);
		if((latLongs[0]!="") && (latLongs[1]!=""))
		{
			System.out.println("Latitude: "+latLongs[0]+" and Longitude: "+latLongs[1]);
			//Verify image appears
			wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVLocationImage));
			//check if longitude matches upto first decimal point
			String longitude = latLongs[1].toString().substring(0, 5);
			softly.assertThat(location).as("test data").contains(longitude);
			//check if latitude matches upto first decimal point
			String latitude = latLongs[0].toString().substring(0, 3);
			softly.assertThat(location).as("test data").contains(latitude);
		}		
	}

	public void excelStore (String location, String browserName, String version) throws Exception{

		File file = new File("E:/EmailError.xlsx");		
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(file);
		// Access the required test data sheet
		XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelWSheet = ExcelWBook.getSheet("RV location DEV");
		//Get number of rows
		int rows = ExcelWSheet.getPhysicalNumberOfRows();
		//Get current date 
		SimpleDateFormat sfdate = new SimpleDateFormat("MM/dd/yyy HH:mm:ss a");
		Date date = new Date();
		System.out.println(sfdate.format(date));
		//Create a new row for only images
		Row row1 = ExcelWSheet.createRow(rows);
		row1.createCell(0).setCellValue(sfdate.format(date));
		row1.createCell(1).setCellValue(browserName + " " + version);
		row1.createCell(2).setCellValue(location);
		//Close File input stream
		ExcelFile.close();
		//Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);
		ExcelWBook.write(outputStream);
		ExcelWBook.close();
		outputStream.close();
	}

	public String[] getLatLongPositions(String address) throws Exception
	{
		int responseCode = 0;
		String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
		URL url = new URL(api);
		HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
		httpConnection.connect();
		responseCode = httpConnection.getResponseCode();
		if(responseCode == 200)
		{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
			Document document = builder.parse(httpConnection.getInputStream());
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile("/GeocodeResponse/status");
			String status = (String)expr.evaluate(document, XPathConstants.STRING);
			if(status.equals("OK"))
			{
				expr = xpath.compile("//geometry/location/lat");
				String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
				expr = xpath.compile("//geometry/location/lng");
				String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
				return new String[] {latitude, longitude};
			}
			else
			{
				System.out.println("Error from the API - response status: "+status);
			}
		}
		return new String[] {"",""};
	}

	public void shareReport(WebDriver driver, String verifier, String username,String password1,int y) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String sharer = em3.decideSharer (y);
		String sharerAdded = em3.decideSharerAdded (y);    	
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.contains("safari"))
		{
			//Clicks on first newly created record
			wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();
			share2.loadingServer(driver);
			driver.switchTo().defaultContent();
		}
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		//Clicks on share button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVShareButton)).click();
		//Verifies if verifier displayed is disabled
		WebElement verify = wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSharePageVerifierBlock));
		String s = verify.getAttribute("data-inset");
		System.out.println(s);
		if(s.equals("true")==false)
			softly.fail("Verifier text box not suppose to be enabled");    	
		//Enters verifier username and tries to add verifier
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareTextBox)).sendKeys(verifier);
		//Selects from dropdown
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareDropdown));
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("No verifier in search for shared to user list");
		}
		/*	dropdown1.findElement(eirca.FirstSelectionUnderDropdown).click();
		//Gets text from error pop up and verifies text
		String error = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(error).as("test data").contains("Sorry, the current activity is already shared to user");
		//Verifies cancel button not available
		WebElement cancel = driver.findElement(eirca.ConfirmCancelButton);
		if(cancel.isDisplayed()==true)
			softly.fail("Cancel button not suppose to be displayed");
		//Verifies if only ok button available and clicks on ok
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ConfirmPopupButton));*/
		//Adds sharer
		//Enters sharer username
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareTextBox)).clear();
		Thread.sleep(3000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareTextBox)).sendKeys(sharer);
		Thread.sleep(500);
		//Selects from dropdown
		WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareDropdown));
		dropdown.findElement(eirca.FirstSelectionUnderDropdown).click();
		/*
		if(browserName.contains("safari"))
		{
			while (true)
			{
				Thread.sleep(3000);
				dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareDropdown));
				jse.executeScript("arguments[0].click();",dropdown.findElement(eirca.FirstSelectionUnderDropdown));
				Thread.sleep(2000);
				//	executor.executeScript("arguments[0].click();", dropdown.findElement(obj2.FirstSelectionUnderDropdown));
				try{
					if(driver.findElement(eirca.ConfirmPopupTitle).isDisplayed())
						break;
				}catch(org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException t)
				{
					break;
				}
			}
		}
		else dropdown.findElement(eirca.FirstSelectionUnderDropdown).click();*/
		//Clicks on add user
		jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)));
		jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)));
		//Verifies user added
		String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.SharerAdded)).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);		
		share3.shareTwice (driver,softly,0);
		//Clicks on save
		jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareSaveButton)));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Checks the username of creator and verifier
		WebElement creator = wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportCreatorUsername));
		String creatorUsername= creator.getText();
		System.out.println("creatorUsername is:    "+creatorUsername);
		softly.assertThat(username).as("test data").isSubstringOf(creatorUsername);
		WebElement verifier1=wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerifierUsername));
		String verifierUsername = verifier1.getText();
		System.out.println("verifierUsername is:    "+verifierUsername);
		softly.assertThat(verifier).as("test data").isSubstringOf(verifierUsername);
		//Click back
		jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)));
		share2.loadingServer(driver);
		//Verify Share icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVShareIconOrCriticalIcon));
		//Calls the Share check function
		share.receiptReport(driver, sharer, username, password1);
		//Clicks on Remote Verification side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();
		share2.loadingServer(driver);
	}

	public void downloadRecordChrome(WebDriver driver, String verifier, String username) throws Exception {

		//deletes files in reports folder before starting to download
//		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
//		deleteFiles(file);	    	
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String url = driver.getCurrentUrl();
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVDownloadButton)).click();
		//Wait for loading message to disappear		
		share2.loadingServer(driver);		
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\ChromSavePDF5_amlocal.exe");
		Thread.sleep(7000);
		pdfCheck(driver,verifier,username,url);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);

	}

	public void downloadRecordFirefox(WebDriver driver, String verifier, String username) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		deleteFiles(file);		  
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String url = driver.getCurrentUrl();
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVDownloadButton)).click();
		//Wait for loading message to disappear		
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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
		Thread.sleep(2000);/*
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
		p.waitFor();*/
		pdfCheck(driver,verifier,username,url);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();

	}

	public void downloadRecordIE(WebDriver driver, String verifier, String username) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		String url = driver.getCurrentUrl();
		deleteFiles(file);		  
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVDownloadButton)).click();
		//Wait for loading message to disappear		
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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
		Thread.sleep(10000);
		//pdf verification
		pdfCheck(driver,verifier,username,url);
		Thread.sleep(4000);
		driver.switchTo().window(window);

	}


	public void downloadRecordIE11(WebDriver driver, String verifier, String username) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		String url = driver.getCurrentUrl();
		deleteFiles(file);		  
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVDownloadButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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
		Thread.sleep(10000);
		//pdf verification
		pdfCheck(driver,verifier,username,url);
		Thread.sleep(4000);
		driver.switchTo().window(window);

	}

	public void deleteFiles(File folder) throws IOException {
		File[] files = folder.listFiles();
		for(File file: files){
			if(file.isFile()){
				String fileName = file.getName();
				boolean del= file.delete();
				System.out.println(fileName + " : got deleted ? " + del);
			}else if(file.isDirectory()) {
				deleteFiles(file);
			}
		}
	}

	public void pdfCheck(WebDriver driver, String verifier, String username, String url) throws Exception {
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
		images=getImagesFromPDF(pddoc);
		System.out.println("Number of images: "+images.size());
		softly.assertThat(images.size()).as("test data").isEqualTo(3);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		String newData="";
		for (int i = 0; i < ans.size(); i++)
		{

			//System.out.println(ans.get(i));
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData = newData+ans.get(i);
			if (ans.get(i).charAt(n)!=' ')
				newData = newData+" "+ans.get(i);

		}
		String newData2=newData.replace("  ", " ");
		String newData1 = newData2.replace("$ ", "$");
		System.out.println(newData1);
		//Checks verifier
		softly.assertThat(verifier).as("test data").isSubstringOf(newData1);
		//Checks username
		softly.assertThat(username).as("test data").isSubstringOf(newData1);
		//Checks event title
		softly.assertThat(rv.eventTitle(driver,url)).as("test data").isSubstringOf(newData1);
		//Checks verification details
		softly.assertThat(rv.details(driver,url)).as("test data").isSubstringOf(newData1);
		//Close pdf
		pddoc.close();
	}

	public List<RenderedImage> getImagesFromPDF(PDDocument document) throws IOException {
		List<RenderedImage> images = new ArrayList<>();
		for (PDPage page : document.getPages()) {
			images.addAll(getImagesFromResources(page.getResources()));
		}

		return images;
	}

	public List<RenderedImage> getImagesFromResources(PDResources resources) throws IOException {
		List<RenderedImage> images = new ArrayList<>();

		for (COSName xObjectName : resources.getXObjectNames()) {
			PDXObject xObject = resources.getXObject(xObjectName);

			if (xObject instanceof PDFormXObject) {
				images.addAll(getImagesFromResources(((PDFormXObject) xObject).getResources()));
			} else if (xObject instanceof PDImageXObject) {
				images.add(((PDImageXObject) xObject).getImage());
			}
		}

		return images;
	}

	public void verifyTextInHTML(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify report title
		String title=wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportTitle)).getText();
		String r = title.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").contains(rv.eventTitle(driver,driver.getCurrentUrl()));
		//Verify event details
		String details=wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportEventDetails)).getText();
		String r1 = details.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").contains(rv.details(driver,driver.getCurrentUrl()));
	}

	public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Verify text in HTML
		verifyTextInHTML(driver);
		//Clicks on mark critical
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Checks if marked critical
		share2.loadingServer(driver);
		String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
		softly.assertThat(s).as("test data").contains("ui-checkbox-on");
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Marked critical icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVShareIconOrCriticalIcon));
		//Verify presence of shared icon 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVShareIconWhenAlsoMarkedCritical));
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();
		share2.loadingServer(driver);		
		//Clicks on mark critical again
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(2000);
		share2.loadingServer(driver);
		String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
		softly.assertThat(s1).as("test data").contains("ui-checkbox-off");
		//Verify report not retrieved by shared to person	    
		String sharer = em3.decideSharer (y);
		share.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on rv side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();	
		share2.loadingServer(driver);
	}

	public void deleteNewRecord(WebDriver driver, String recordName, int y) throws Exception{

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Clicks on delete button	
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVDeleteButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle));
		String noHtml = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(noHtml).as("test data").doesNotContain("<br/>");
		//Clicks on delete report
		driver.findElement(eirca.ConfirmPopupButton).click();
		eirca3.verifyBreakWordPropertyStickyNote(driver, softly);
		Thread.sleep(2000);
		driver.findElement(rv.RVSidePanel).click();
		//Wait for loading message to disappear		  
		share2.loadingServer(driver);
		//Verify record deleted
		//Get name of 1st record
		String name = driver.findElement(rv.RVNewlyCreatedFirstRecord).getText();
		System.out.println(name);
		if (name!=recordName)
			System.out.println("Record deleted");
		else
			System.out.println("Record could not be deleted");

		while(true)
		{
			Thread.sleep(1000);
			try{
				if (driver.findElement(lpo.StickyNote).isDisplayed())
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();

				}}catch (NoSuchElementException e)
			{
					break;
			}
			catch( StaleElementReferenceException f)
			{
				break;
			}
			catch (org.openqa.selenium.TimeoutException u)
			{
				break;
			}
			catch (org.openqa.selenium.ElementNotInteractableException u)
			{
				break;
			}
		}

		//Verify report not retrieved by shared to person
		String sharer = em3.decideSharer (y);
		share.checkNoReportAfterDelete(driver, sharer, softly);	  			  
	}

	public void upload2ndPicture(WebDriver driver) throws Exception{

		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		if(browserName.equals("chrome"))
			upload2ndpictureChrome(driver);
		if(browserName.equals("firefox"))
			upload2ndpictureFirefox(driver);
		if(browserName.equals("internet explorer"))
		{
			if(v.startsWith("10"))
				upload2ndpictureIE10(driver);
			if(v.startsWith("11"))
				upload2ndpictureIE11(driver);
		}
		if(browserName.contains("safari"))
			upload2ndpictureSafari(driver);
	}

	public void upload1stPicture(WebDriver driver) throws Exception{

		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		if(browserName.equals("chrome"))
			upload1stpictureChrome(driver);
		if(browserName.equals("firefox"))
			upload1stpictureFirefox(driver);
		if(browserName.equals("internet explorer"))
		{
			if(v.startsWith("10"))
				upload1stpictureIE10(driver);
			if(v.startsWith("11"))
				upload1stpictureIE11(driver);
		}
		if(browserName.contains("safari"))
			upload1stpictureSafari(driver);
	}

	public int getCharCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(rv.RVTitleCharacterCount).getText();
		s=s.substring(1,s.indexOf("/"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public void checkTitleCountReset(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).sendKeys("aaaa");
		//Get count
		int count = getCharCountFromTitle(driver);
		if(count!=4)
			softly.fail("Count did not match: aaaa: " + count);
		//Clear text
		for(int i=0;i<4;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(250);
		}
		count = getCharCountFromTitle(driver);
		if(count!=1)
			softly.fail("Count did not match: aaaa: " + count);
	}

	public int getTotalCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(rv.RVTitleCharacterCount).getText();
		s=s.substring((s.indexOf("/")+1), s.indexOf(")"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public List<String> createReport(WebDriver driver, String username, int k) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Analysis 
		try
		{
			driver.findElement(rv.AnalysisLink).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Remote Verification
		driver.findElement(rv.RVLink).click();
		rv4.verifyNewReportPopup(driver, softly);
		//Check title count reset when characters are entered and deleted
//		checkTitleCountReset(driver);
		//Fills the mandatory fields
		driver.findElement(rv.RVEventTitle).sendKeys(rv.eventTitle(driver,driver.getCurrentUrl()));
		//Get count
		int count = getCharCountFromTitle(driver);
	int total = getTotalCountFromTitle(driver);
		for(int i=count+1;i<=total;i++)
		{
			driver.findElement(rv.RVEventTitle).sendKeys("z");
	}
		
//		driver.findElement(rv.RVEventTitle).sendKeys("z");
		driver.findElement(rv.RVEventDetails).sendKeys(rv.details(driver,driver.getCurrentUrl()));
		String ev1 = driver.findElement(rv.RVEventTitle).getAttribute("value");
		String ev2 = driver.findElement(rv.RVEventDetails).getAttribute("value");
		/*	if ((ev1.equals(rv.eventTitle(driver,driver.getCurrentUrl()))==false))
		{
			driver.findElement(rv.RVEventTitle).clear();
			driver.findElement(rv.RVEventTitle).sendKeys(rv.eventTitle(driver,driver.getCurrentUrl()));
		}*/
		if((ev2.equals(rv.details(driver,driver.getCurrentUrl())))==false)
		{
			driver.findElement(rv.RVEventDetails).clear();
			driver.findElement(rv.RVEventDetails).sendKeys(rv.details(driver,driver.getCurrentUrl()));
		}
		//(2)Click checkbox I certify...
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-photo-icertify-checkbox"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgwork-photo-icertify-checkbox"))));
		//(2)Verify supporting file should be expanded as default setting 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-rv-event-filecollapsible-0']//span[contains(text(),'click to collapse contents')]")));
		//Upload photo (3) Take or choose a photo of the person requesting verification.
		String filepath = "C:/Users/mama/Pictures/Upload/CCYC2355.JPG";
		
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-rv-imgperson-photo-input"))));
		driver.findElement(By.id("pii-rv-imgperson-photo-input")).sendKeys(filepath);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/clickcancel2.exe");
			q.waitFor();
			}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

			}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");}
		
		//Select verifier
		rv3.verifierSelect(driver,k);
		Thread.sleep(1000);
		String verifier= driver.findElement(rv.RVVerifierValue).getAttribute("piivalue");
		//Uploads picture 2
		upload2ndPicture(driver);
		/*
		share2.scrollToAPoint(driver, 250);
		Thread.sleep(3000);
		//Uploads picture 1
		upload1stPicture(driver);
		*/
		share2.scrollToTop(driver);
		//Verifies Date and time
		verifyDateTime(driver);
		//Verifies location of office
		verifyLongitudeLatitude(driver);
		//Verify status 
		checkStatusReport(driver,username,k);
		Thread.sleep(3000);
		//Creates the expected name of record
		String creation_date = driver.findElement(rv.RVCreationDate).getText();
		creation_date= creation_date.substring(22, creation_date.length());
		String name = creation_date +"_"+ username + "_" + ev1;
		System.out.println("Expected name of record: " + name);
		//Clicks on Remote Verification
		driver.findElement(rv.RVSidePanel).click();
		Thread.sleep(3000);
		//Gets the name of the record created
		WebElement record = driver.findElement(rv.RVNewlyCreatedFirstRecord);
		String recordName = record.getText();
		String r = recordName.replaceAll("\u00AD", "");
		if (record.isDisplayed())
		{
			System.out.println("Record found: "+ recordName);
		}
		else
			System.out.println ("Record not found.");
		//Checks if the name displayed on record is same as expected
		softly.assertThat(r).as("test data").isEqualTo(name);
		return Arrays.asList(verifier,r);
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
