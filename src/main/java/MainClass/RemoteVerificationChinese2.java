package MainClass;

import PageObjects.*;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoteVerificationChinese2 {


	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();
	EiRCAPageObj eirca = new EiRCAPageObj();
	Login login = new Login();
	LoginPageObj lpo = new LoginPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	UserManagementPageObj um = new UserManagementPageObj();
	CreateEquipPageObj equip = new CreateEquipPageObj();

	public void verifyEmailOfUser(WebDriver driver, String username, String password) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);	
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//Clicks on Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		String email=wait.until(ExpectedConditions.visibilityOfElementLocated(um.UserProfileEmailField)).getAttribute("value");
		System.out.println(email);
		if(email.equals("rramakrishnan@errorfree.com")==false)
		{
			//Change email id
			wait.until(ExpectedConditions.visibilityOfElementLocated(um.UserProfileEmailField)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(um.UserProfileEmailField)).sendKeys("rramakrishnan@errorfree.com");
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(um.UserProfileSaveButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(um.UserProfileSavePopupTitle));
			wait.until(ExpectedConditions.visibilityOfElementLocated(um.UserProfileSavePopupConfirmButton)).click();
			//wait for loading message
			share2.loadingServer(driver);
			//Logs out
			login.logout(driver);
			if (browserName.equals("firefox"))
				driver.switchTo().defaultContent();
			//MainClass.Login again
			login.LoginUser(driver, username, password);
			//Switches to the iframe
			driver.switchTo().frame(driver.findElement(lpo.Iframe));
		}
		else
		{
			//Go to KALE homepage
			wait.until(ExpectedConditions.visibilityOfElementLocated(equip.KaleHomePage)).click();
		}
	}

	public void verifySavePopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("????????????");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("????????????????????????????????????????");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("??????");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("????????????");
	}

	public void verifyReviseReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("??????");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").contains("????????????????????? ???????????? ??????");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("????????????????????????????????????????????????????????????????????????");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("??????");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("????????????");
	}

	public void verifySaveAndSendPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("??????????????????");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").contains("????????????????????????????????????????????????: ");
		//Note
		String s1a = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupNote)).getText();
		softly.assertThat(s1a).as("test data").isEqualTo("??????: ???????????????????????????????????????????????????.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("??????");
		//Save and send button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("??????????????????");
	}

	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewButton)).click();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("????????????????????????");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("?????????????????????????????????????????????????????????????????????????");
		//Note
		String s1a = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupNote)).getText();
		softly.assertThat(s1a).as("test data").isEqualTo("?????????????????????????????????????????????.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("??????");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("?????????????????????");
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).click();
	}


}
