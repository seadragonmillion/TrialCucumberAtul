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
		softly.assertThat(s).as("test data").isEqualTo("保存报告");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("请确认你要存入现有报告进度?");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("取消");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("保存报告");
	}

	public void verifyReviseReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("开启");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").contains("请核实你要开启 远程验证 报告");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("警告：修改報告內容以供接受。拒絕的驗證將被存檔。");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("取消");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("重新编辑");
	}

	public void verifySaveAndSendPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("保存发送报告");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").contains("请确认你要保存并发送报告给验证人: ");
		//Note
		String s1a = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupNote)).getText();
		softly.assertThat(s1a).as("test data").isEqualTo("信息: 验证人将会收到电邮通知进行远程验证.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("取消");
		//Save and send button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("保存发送报告");
	}

	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewButton)).click();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("新增远程验证报告");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("请确认你要清除现有报告内容，新增新的远程验证报告?");
		//Note
		String s1a = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupNote)).getText();
		softly.assertThat(s1a).as("test data").isEqualTo("警告：未保存的内容事后无法找回.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("取消");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("新增程验证报告");
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).click();
	}


}
