import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import kaleTestSoftware.*;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoteVerification3 {

	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();
	RemoteVerificationChinese2 rc2 = new RemoteVerificationChinese2();
	RemoteVerification4 rv4 = new RemoteVerification4();
	ShareCheck2 share2 = new ShareCheck2();
	EiRCAPageObj eirca = new EiRCAPageObj();
	UserManagement um = new UserManagement();
	
	//Emails used in User Profile
//	public String emailDevAdminNonAdmin = "rvqaaverifyemail01@gmail.com";
	public String emailDevAdminNonAdmin = "piikaleremote02@gmail.com";
	public String emailDevAdminNonAdminIE11 = "rvqaaverifyemail02@gmail.com";
	public String emailProdAdminNonAdmin = "rvqaaverifyemail01asia@gmail.com";
	public String emailProdAdminNonAdminIE11 = "rvqaaverifyemail02asia@gmail.com";
	
	public String fillRVPage(WebDriver driver, int k, int chiOrEng, SoftAssertions softly) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		rv4.verifyTextOnRVCurrentVerificationPage(driver, softly);
		//Fills the mandatory fields
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).sendKeys(rv.eventTitle(driver,driver.getCurrentUrl()));
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventDetails)).sendKeys(rv.details(driver,driver.getCurrentUrl()));
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).getAttribute("value");
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventDetails)).getAttribute("value");
		if ((ev1.equals(rv.eventTitle(driver,driver.getCurrentUrl()))==false))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).sendKeys(rv.eventTitle(driver,driver.getCurrentUrl()));
		}
		if((ev2.equals(rv.details(driver,driver.getCurrentUrl())))==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventDetails)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventDetails)).sendKeys(rv.details(driver,driver.getCurrentUrl()));
		}
		//Select verifier
		verifierSelect(driver,k);
		Thread.sleep(1000);
		String verifier= wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVVerifierValue)).getAttribute("piivalue");
		//Uploads picture 2
		upload2ndPicture(driver);
		//Uploads picture 1
//		upload1stPicture(driver);
		share2.scrollToTop(driver);
		if(chiOrEng == 1)
		{
			share2.scrollToTop(driver);
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSaveButton)));
			rc2.verifySavePopup(driver, softly);
			wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).click();
		}
		//Save and send to verifier
		//Clicks on Save and Send
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSaveAndSendButton)));
		//Clicks on save and send report
		if(chiOrEng == 1)
		{
			rc2.verifySaveAndSendPopup(driver, softly);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).click();
		driver.findElement(rv.RVSavePopupConfirmButton).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify text for sent for verification and request sent date
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVRequestSentDateLabel)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Request sent date:");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVRequestVerificationStatusLabel)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Verification status:");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVRequestVerificationStatus)).getText();
		softly.assertThat(s2).as("test data").contains("Sent, waiting for verification");
		return verifier;
	}
	
	public void verifierSelect(WebDriver driver, int k) throws Exception {

		//dev admin
		if(k==1)
		{
			driver.findElement(rv.RVVerifierField).sendKeys("qaarvverifier1");
		}
		//dev nonadmin
		if(k==2)
		{
			driver.findElement(rv.RVVerifierField).sendKeys("qaarvverifiernonadmin");
		}
		//dev admin ie11
		if(k==3)
		{
			driver.findElement(rv.RVVerifierField).sendKeys("qaaie11rvverifier");
		}
		//dev nonadmin ie11
		if(k==4)
		{
			driver.findElement(rv.RVVerifierField).sendKeys("qaaie11rvverifiernonadmin");
		}
		//asia admin
		if(k==5)
		{
			driver.findElement(rv.RVVerifierField).sendKeys("qaarvverifier");
		}
		//asia nonadmin
		if(k==6)
		{
			driver.findElement(rv.RVVerifierField).sendKeys("qaarvverifiernonadmin");
		}
		//asia admin ie11
		if(k==7)
		{
			driver.findElement(rv.RVVerifierField).sendKeys("qaaie11rvverifier");
		}
		//asia nonadmin ie11
		if(k==8)
		{
			driver.findElement(rv.RVVerifierField).sendKeys("qaaie11rvverifiernonadmin");
		}
		//us admin
		if(k==9)
		{
			driver.findElement(rv.RVVerifierField).sendKeys("qaausrvverifier");
		}
		//us nonadmin
		if(k==10)
		{
			driver.findElement(rv.RVVerifierField).sendKeys("qaausrvverifiernonadmin");
		}
		//us admin ie11
		if(k==11)
		{
			driver.findElement(rv.RVVerifierField).sendKeys("qaausie11rvverifier");
		}
		//us nonadmin ie11
		if(k==12)
		{
			driver.findElement(rv.RVVerifierField).sendKeys("qaausie11rvverifiernonadmin");
		}
		//Selects the remote verifier		
		share2.scrollToAPoint(driver, 1500);
		WebElement select = driver.findElement(rv.RVVerifierDropdown);
		WebElement option=select.findElement(eirca.FirstSelectionUnderDropdown);		
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.toLowerCase().contains("safari"))
		{
			while(true)
			{
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", option);
				String verifier= driver.findElement(rv.RVVerifierValue).getAttribute("piivalue");
				if(verifier.contains("verifier"))
					break;
			}
		}
		else
			option.click();
	}
	
	public void upload2ndpictureChrome(WebDriver driver) throws Exception {
		//Upload picture for (3) Take or choose a photo of the person requesting verification.
		//Uploads picture 2
		String file2 = "C:/Users/mama/Pictures/Upload/CCYC2355.JPG";
		driver.findElement(rv.RV2ndImageField).sendKeys(file2);
	}

	public void upload2ndpictureFirefox(WebDriver driver) throws Exception {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on browse button of 2nd picture
		jse.executeScript("arguments[0].click();", driver.findElement(rv.RV2ndImageField));
		Thread.sleep(2000);
		//Uploads picture 2
		Process p3=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemum.exe");
		p3.waitFor();
		Thread.sleep(8000);
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
	}

	public void upload2ndPicture(WebDriver driver) throws Exception{

		share2.scrollToElement(driver, driver.findElement(rv.RV2ndImageField));
		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
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
	}

	public void upload1stpictureChrome(WebDriver driver) throws Exception {

		//Uploads picture 1
		String filepath = "C:/Users/Public/Pictures/Sample Pictures/Chrysanthemum.jpg";
		driver.findElement(rv.RV1stImageField).sendKeys(filepath);
	}

	public void upload1stpictureFirefox(WebDriver driver) throws Exception {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on browse button of 1st picture
		jse.executeScript("arguments[0].click();", driver.findElement(rv.RV1stImageField));
		Thread.sleep(2000);
		//Uploads picture 1
		Process p=Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaDesert.exe");
		p.waitFor();
		Thread.sleep(4000);
	}

	public void upload1stpictureIE10(WebDriver driver) throws Exception {

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
	}

	public void upload1stpictureIE11(WebDriver driver) throws Exception {

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
	}

	public void upload1stPicture(WebDriver driver) throws Exception{

		share2.scrollToElement(driver, driver.findElement(rv.RV1stImageField));
		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
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
	}

	public void verifyErrorOnPage (WebDriver driver, SoftAssertions softly) throws Exception{

		//Clicks on Save and Send
		driver.findElement(rv.RVSaveAndSendButton).click();
		share2.verifyWarningPopupForError(driver, softly);
		//Verify all errors
		String titleError = driver.findElement(rv.RVTitleError).getText();
		softly.assertThat(titleError).as("test data").isEqualTo("This field is required");
		String image1stError = driver.findElement(rv.RV1stImageError).getText();
		softly.assertThat(image1stError).as("test data").isEqualTo("This field is required");
		String image2ndError = driver.findElement(rv.RV2ndImageError).getText();
		softly.assertThat(image2ndError).as("test data").isEqualTo("This field is required");
		String detailsError = driver.findElement(rv.RVDetailsError).getText();
		softly.assertThat(detailsError).as("test data").isEqualTo("This field is required");
		String verifierError = driver.findElement(rv.RVVerifierError).getText();
		softly.assertThat(verifierError).as("test data").isEqualTo("Remote Verification Verifier is required");
		//softly.assertAll();
	}

	public void verifySavePopupAfterRename(WebDriver driver, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Enter a very long name in Event title
		driver.findElement(rv.RVEventTitle).clear();
		driver.findElement(rv.RVEventTitle).sendKeys("Really long text which will make the report name o overflow out of the popup");
		//click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSaveButton)).click();
		//Verify the popup
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupNote)).getText();
		softly.assertThat(s).as("test data").contains("‑");
		System.out.println(s);
		String overflow = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupNote)).getCssValue("word-wrap");
		softly.assertThat(overflow).as("test data").isEqualTo("break-word");
		System.out.println(overflow);
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).click();
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavedActivitiesButton)).click();
		share2.loadingServer(driver);
		//Click on first record
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).click();		
		share2.loadingServer(driver);
		//Click on Open
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(1000);
	}
	
	public void verifyEmailForUserAfterReceivingReplyFromVerifier (WebDriver driver,String verifier, String reportName, int k, SoftAssertions softly) throws Exception {

		//Get current Time
		long currentTime = System.currentTimeMillis();
		/*am_changed to 1 mintue
		//Add 15 minutes to it
		long time15 = currentTime + (15*60*1000);*/
		
		//Add 1 minutes to it
		long time15 = currentTime + (1*60*1000);
		String SMTP_HOST = "smtp.gmail.com";
//		String EMAIL_ADDRESS = selectEmailForUser(k);
		String EMAIL_ADDRESS = "piikaleemailtest01@gmail.com";
		System.out.println(EMAIL_ADDRESS);
//		String PASSWORD = "5sepkale";
		String PASSWORD = "pii@2021";
		String INBOX_FOLDER = "INBOX";	    
		Properties props = new Properties();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("11"))
				props.load(new FileInputStream(new File( "C:\\Users\\IEUser\\DriversForSelenium\\smtp.properties" )));
			else
				props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
		}
		else if (browserName.contains("safari"))
			props.load(new FileInputStream(new File( "/Users/pamelachiu/Downloads/smtp.properties" )));
		else
			props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
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
		StringBuffer sb1 = new StringBuffer();
		for (int i = 0; i < messageCount1; i++) {
			Message message1 = messages1[i];
			System.out.println(i);
			System.out.println("Mail Subject:- " + messages1[i].getSubject());
			System.out.println("From: " + message1.getFrom());
			System.out.println("Text: " + message1.getContent().toString());
			System.out.println("Date of email: " + message1.getReceivedDate());
			sb = new StringBuffer( message1.getContent().toString());
			sb1 = new StringBuffer(message1.getSubject().toString());
		}
		System.out.println("**********************************************************************************************************************");
		System.out.println(messages1[messageCount1 -1].getReceivedDate());
		//Get email subject
		String subject = sb1.toString();
		System.out.println(subject);
		softly.assertThat(subject).as("test data").contains("Remote Verification Responded");
		String emailText=sb.toString();
		System.out.println(emailText);
		//Verify content of email
		//Verifier's usernname
		softly.assertThat(emailText).as("test data").contains(verifier);        
		//Modify emailText
		String s = emailText.replace((char)173,'*');
		System.out.println(s);
		String s1 = s.replace((char)60, '<');
		String s2 = s1.replace("<*", "<");
		String s3 = s2.replace("&#34;", "\"");
		String s4 = s3.replace("&lt;&shy;", "<");
		System.out.println(s4);
		softly.assertThat(s4).as("test data").contains(reportName);
		//Verify text
		softly.assertThat(emailText).as("test data").contains("Please login to KALE™ to see verification results. If the results are rejected, please revise your work and resend verification report.");
		//softly.assertAll();
	}
	
	public String selectEmailForUser(int k) throws Exception{

		//dev admin, non admin
		if(k==1||k==2)
		{
			return emailDevAdminNonAdmin;
		}
		//dev admin ie11, nonadmin ie11
		else if(k==3||k==4)
		{
			return emailDevAdminNonAdminIE11;
		}
		//asia admin, nonadmin
		//us admin, nonadmin
		else if(k==5||k==6||k==9||k==10)
		{
			return emailProdAdminNonAdmin;
		}
		//asia admin ie11, nonadmin ie11
		//us admin ie11, nonadmin ie11
		else if(k==7||k==8||k==11||k==12)
		{
			return emailProdAdminNonAdminIE11;
		}
		else
		{
			return null;
		}
	}

}
