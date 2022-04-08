package MainClass;


import PageObjects.EiRCAPageObj;
import PageObjects.LoginPageObj;
import PageObjects.RemoteVerificationPageObj;
import PageObjects.ShareCheckPageObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RemoteVerification2 {

	EiRCAPageObj eirca = new EiRCAPageObj();
	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();
	RemoteVerification rv1 = new RemoteVerification();
	RemoteVerification3 rv3 = new RemoteVerification3();
	ShareCheck share = new ShareCheck();
	Login login = new Login();
	LoginPageObj lpo = new LoginPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheckPageObj shareObj = new ShareCheckPageObj();
	UserManagement um = new UserManagement();

	SoftAssertions softly = new SoftAssertions();

	public String password = "S2FsZWplbmtpbnNAMTIz";
	public String rejectComment = "Rejected for test";
	public String passComment = "Passed for test";

	public void loginToUser(WebDriver driver, String username, String password1) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//logout
		login.logout(driver);
		Thread.sleep(2000);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			driver.switchTo().defaultContent();
		}
		//Thread.sleep(8000);
		int login1 = login.LoginUser(driver, username, password1);
		System.out.println("Title after login: "+driver.getTitle());
		//Thread.sleep(10000);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(lpo.Iframe));
		//Thread.sleep(8000);
		if (login1==1)
		{

			while(true)
			{
				Thread.sleep(1000);
				if (driver.findElement(shareObj.StickyPopUp).isDisplayed())
				{
					WebElement ele =driver.findElement(shareObj.StickyPopUp);
					ele.findElement(lpo.StickyClose).click();
					break;
				}
				else break;
			}
		}	
		//Thread.sleep(4000);
		//Click on notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationBell)).click();
		share2.scrollToTop(driver);
	}

	public void verifierNotification(WebDriver driver, String verifier, String username, String password1, int k) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//Creates the expected name of record
		String creation_date = driver.findElement(rv.RVCreationDate).getText();
		creation_date= creation_date.substring(22, creation_date.length());
		String reportName = creation_date +"_"+ username + "_" + rv.eventTitle(driver,driver.getCurrentUrl());
		//Verify email
		rv1.verifyEmailForVerifier (driver,username,reportName,k);
		System.out.println("finished verifyEmailforVerifier");
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		loginToUser(driver,verifier,password);
		//Verify version of report
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecordDescriptionText)).getText();
		System.out.println("Reason in rv in verifier notification center: "+reason);
		softly.assertThat(reason).as("test data").contains("Remote Verification Requested - v1");
		//Click on 1st record/notification
		while(true)
		{
			if(browserName.equals("safari")||browserName.equals("firefox"))
			{
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)));
			}
			else
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)).click();
				}catch(org.openqa.selenium.WebDriverException r)
				{

				}
			}
			if(driver.findElement(shareObj.NotificationOpenButton).isEnabled())
				break;		
		}
		share2.loadingServer(driver);
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationOpenButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on Reject button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.VerifierRejectButton)).click();
		String noHtml = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.AcceptRejectConfirmPopupTitle)).getText();
		softly.assertThat(noHtml).as("test data").doesNotContain("<br/>");
		//Enter comment
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.VerifierRejectComment)).sendKeys(rejectComment);
		//Click on reject confirm button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.VerifierRejectConfirmButton)).click();
		share2.loadingServer(driver);
		share.markNotificationsRead(driver, browserName,0,softly);
		//login to report creator
		loginToUser(driver,username,password1);
		System.out.println("before fromVerifier");
		//verify email of user 
		rv3.verifyEmailForUserAfterReceivingReplyFromVerifier(driver, verifier, reportName, k, softly);
		//Click on 1st record/notification
		while(true)
		{
			if(browserName.equals("safari")||browserName.equals("firefox"))
			{
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)));
			}
			else
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)).click();
				}catch(org.openqa.selenium.WebDriverException r)
				{

				}
			}
			if(driver.findElement(shareObj.NotificationOpenButton).isEnabled())
				break;		
		}
		share2.loadingServer(driver);
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationOpenButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify the Verification status
		String status = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationStatus)).getText();
		softly.assertThat(status).as("test data").contains("responded to request for verification");
		//Verification result
		String result = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationRejectedResult)).getText();
		softly.assertThat(result).as("test data").contains("REJECTED");
		//Verification comments
		String comments = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationComments)).getText();
		softly.assertThat(comments).as("test data").contains(rejectComment);
		//Click on Revise button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationReviseButton)).click();
		String note = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(note).as("test data").isEqualTo("WARNING: Revise report content for acceptance. Rejected verification will be archived.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Clicks on Save and Send
		driver.findElement(rv.RVSaveAndSendButton).click();
		//Clicks on save and send report
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).click();
		driver.findElement(rv.RVSavePopupConfirmButton).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Mark notification as read
		share.markNotificationsRead(driver, browserName,0,softly);
		//Verify email
		rv1.verifyEmailForVerifier (driver,username,reportName,k);
		//MainClass.Login to verifier
		loginToUser(driver,verifier,password);
		//Verify version of report
		String reason1 = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecordDescriptionText)).getText();
		System.out.println("Reason in rv in verifier notification center: "+reason1);
		softly.assertThat(reason1).as("test data").contains("Remote Verification Requested - v2");
		//Click on 1st record/notification
		while(true)
		{
			if(browserName.equals("safari")||browserName.equals("firefox"))
			{
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)));
			}
			else
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)).click();
				}catch(org.openqa.selenium.WebDriverException r)
				{

				}
			}
			if(driver.findElement(shareObj.NotificationOpenButton).isEnabled())
				break;		
		}
		share2.loadingServer(driver);
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationOpenButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on Accept button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.VerifierAcceptButton)).click();
		String noHtml1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.AcceptRejectConfirmPopupTitle)).getText();
		softly.assertThat(noHtml1).as("test data").doesNotContain("<br/>");
		//Enter comment
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.VerifierRejectComment)).sendKeys(passComment);
		//Click on reject confirm button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.VerifierRejectConfirmButton)).click();
		share2.loadingServer(driver);
		//Mark notification as read
		share.markNotificationsRead(driver, browserName,0,softly);
		//login to report creator
		loginToUser(driver,username,password1);
		//Click on 1st record/notification
		while(true)
		{
			if(browserName.equals("safari")||browserName.equals("firefox"))
			{
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)));
			}
			else
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)).click();
				}catch(org.openqa.selenium.WebDriverException r)
				{

				}
			}
			if(driver.findElement(shareObj.NotificationOpenButton).isEnabled())
				break;		
		}
		share2.loadingServer(driver);
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationOpenButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Download report
		//Get version
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			share.downloadReportChrome(driver);
		if (browserName.equals("firefox"))
			share.downloadReportFirefox(driver);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				share.downloadReportIE(driver);
			if (v.startsWith("11"))
				share.downloadReportIE11(driver);
		}
		//Mark notification as read
		share.markNotificationsRead(driver, browserName,0,softly);
		//MainClass.Login to report creator
		loginToUser(driver,username,password1);
		//Verify version of report
		String reason2 = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecordDescriptionText)).getText();
		System.out.println("Reason in rv in creator notification center: "+reason1);
		softly.assertThat(reason2).as("test data").contains("Remote Verification Accepted - v2");
		//Click on 1st record/notification
		while(true)
		{
			if(browserName.equals("safari")||browserName.equals("firefox"))
			{
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)));
			}
			else
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationFirstRecord)).click();
				}catch(org.openqa.selenium.WebDriverException r)
				{

				}
			}
			if(driver.findElement(shareObj.NotificationOpenButton).isEnabled())
				break;		
		}
		share2.loadingServer(driver);
		//Click on Open Report button
		wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationOpenButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify the Verification status
		String status1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationStatus)).getText();
		softly.assertThat(status1).as("test data").contains("responded to request for verification");
		//Verification result
		String result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationAcceptedResult)).getText();
		softly.assertThat(result1).as("test data").contains("ACCEPTED");
		//Verification comments
		String comments1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerificationComments)).getText();
		softly.assertThat(comments1).as("test data").contains(passComment);
	}

	public void deleteReport(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Clicks on delete button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVDeleteButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle));
		//Clicks on delete report
		driver.findElement(eirca.ConfirmPopupButton).click();
		share2.loadingServer(driver);
	}
	
	public void rvVerifierTest(WebDriver driver, int k, String username, String password1) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Mark email read of verifier and user
		um.emailMarkRead(rv1.selectEmail(k), driver);
		String EMAIL_ADDRESS = rv3.selectEmailForUser(k);
		System.out.println(EMAIL_ADDRESS);
		um.emailMarkRead(EMAIL_ADDRESS, driver);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Analysis 
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(rv.AnalysisLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Remote Verification
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVLink)).click();
		
		//am_not applicable anymore
		//rv3.verifyErrorOnPage(driver, softly);
		//Fill page
		String verifier = rv3.fillRVPage(driver,k,0,softly);
		//Verify if verifier got notification
		verifierNotification(driver,verifier,username,password1,k);
		//Delete report
		deleteReport(driver);
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
