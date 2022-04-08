import kaleTestSoftware.*;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCA2 {

	EiRCAPageObj eirca = new EiRCAPageObj();
	LoginPageObj login = new LoginPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	HiRCAObj hirca = new HiRCAObj();
	EiRCA3 eirca3 = new EiRCA3();

	public void verifyStickyUserAccountAfterChange(WebDriver driver, SoftAssertions softly, int chiOrEng) throws Exception {

		//WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			/*WebElement ele = driver.findElement(By.cssSelector(".sticky border-top-right.sticky-warning"));
			String s = ele.findElement((login.StickyNote)).getText();
			if(chiOrEng==0)
				softly.assertThat(s).as("test data").isEqualTo("Please logout and login again for any changed data to apply to current user account");
			if(chiOrEng==1)
				softly.assertThat(s).as("test data").isEqualTo("请重新登入生效变更");
			System.out.println(s);
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();*/
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find account save pop up");
		}
	}

	public void verifyStickyUserAccount(WebDriver driver, SoftAssertions softly, String username) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			/*String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			softly.assertThat(s).as("test data").isEqualTo("User updated: "+username+".");
			System.out.println(s);*/
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find save pop up");
		}
		softly.assertAll();
	}

	public void verifySticky1ImageUploaded(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			softly.assertThat(s).as("test data").isEqualTo("All changed supporting files saved successfully (1)");
			System.out.println(s);
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find share save pop up");
		}
	}

	public void verifySticky5ImageUploaded(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			softly.assertThat(s).as("test data").isEqualTo("All changed supporting files saved successfully (5)");
			System.out.println(s);
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find supporting files saved pop up");
		}
	}

	public void verifyStickySaveReport(WebDriver driver, SoftAssertions softly, String username, String reportTitle, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			eirca3.verifyBreakWordPropertyStickyNote(driver, softly);
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			String css = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getCssValue("overflow");
			System.out.println("overflow: "+css);
			String r = s.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").contains(username+"_"+reportTitle);
			if(n == 0)
				softly.assertThat(r).as("test data").contains("HiRCA™ Data created for id: ");
			else
				softly.assertThat(r).as("test data").contains("HiRCA™ Data updated for id: ");
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find save pop up");
		}
	}

	public void verifyStickyDeleteReport(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			eirca3.verifyBreakWordPropertyStickyNote(driver, softly);
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			String r = s.replaceAll("\u00AD", "");
			String r1 = recordName.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").isEqualTo("HiRCA™ data deleted: "+r1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find delete pop up");
		}
	}

	public void verifyDeleteFilePopup(WebDriver driver, SoftAssertions softly, int k) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Delete Supporting file");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to delete supporting file ("+k+")?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Warning: deleted content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("delete");
	}

	public void verifyNoSupportingFilePopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Use existing empty form");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Please use existing empty supporting file form above");
		//ok button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("ok");
	}

	public void verifyInfoPageErrorPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Invalid Data Entry");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Please fix all errors mentioned in red.");
		//ok button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("ok");
	}

	public void verifySavePopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save current event report?");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("save report");
	}

	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("New Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Would you like to confirm you want to erase the current report and create a new report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: erased content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("new report");
	}	

	public void verifyOpenReportPopup(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Open");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("Do you confirm you want to open HiRCA™ report referenced as: "+r1+"?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Warning: once you load this version, any changes on the report will override existing data.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("open");
	}	

	public void verifyDeleteReportPopup(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Delete Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		if(r.contains("This report is currently open in "))
			softly.assertThat(r).as("test data").isEqualTo("This report is currently open in HiRCA™, are you sure you want to delete this report ["+r1+"]?");
		else
			softly.assertThat(r).as("test data").isEqualTo("Are you sure you want to delete this HiRCA™ report ["+r1+"]?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: deleted data cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("delete report");
	}

	public void verifyLOPRCPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("LOP or Root Cause");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Do you want to (1) continue to analyze Layer Of Protection failures or (2) proceed to determine event root cause?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: LOP can be done afterwards by re-opening an existing report.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Cancel");
		//LOP button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("LOP");
		//LOP button
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton2)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Root Cause");
	}

	public void verifyChangeLanguage(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		HiRCAChinese obj1 = new HiRCAChinese();
		LanguageCheckOfReports obj2 = new LanguageCheckOfReports();
		//Change language to english
		obj1.changeToEnglish(driver);
		//Click on Analysis
		share2.loadingServer(driver);  
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Click on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		//Verify the language as english
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		if (obj2.containsHanScript(s)==true)
			softly.fail("Not in english");
		//Change language to chinese
		obj1.changeToChinese(driver);		
		//Click on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Click on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		//Verify the language as chinese in test		
		share2.loadingServer(driver);
	}	

	public void verifySavePopupAfterRename(WebDriver driver, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify the popup
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupNote)).getText();
		softly.assertThat(s).as("test data").contains("‑");
		System.out.println(s);
		String overflow = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupNote)).getCssValue("word-wrap");
		softly.assertThat(overflow).as("test data").isEqualTo("break-word");
		System.out.println(overflow);
	}
	
	public void clickOnTrashCan(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.id("efi-irca-question")));
		try{
		jse.executeAsyncScript("arguments[0].click();", el.findElement(By.id("pii-irca-clear")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed")));
		//}catch(org.openqa.selenium.ScriptTimeoutException r){
		}catch(Exception e){
				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-clear"))).click();
				} catch (Exception e1) {
				}
			}
	}
}
