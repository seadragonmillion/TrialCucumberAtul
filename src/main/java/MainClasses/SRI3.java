import kaleTestSoftware.EiRCAPageObj;
import kaleTestSoftware.Login;
import kaleTestSoftware.SRIPageObj;
import kaleTestSoftware.ShareCheck;
import kaleTestSoftware.ShareCheck2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SRI3 {

	EiRCAPageObj eirca = new EiRCAPageObj();
	SRIPageObj sri = new SRIPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	Login login = new Login ();

	public void verifyReportCanBeOpenedAfterLogin(WebDriver driver, String username, String password) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Logout and Login, click on activity
		share.logInToUser(driver, username, password);
		//Clicks on SRI side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);	
	}

	public void verifyOnlyEvenNumberOfRowsInStep2Table(WebDriver driver, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,2);
		int rowCount = 0;
		while(true)
		{
			rowCount = rowCount+1;
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr["+rowCount+"]")));
			}catch(org.openqa.selenium.TimeoutException r)
			{
				break;
			}
		}
		if(rowCount%2!=0)
			softly.fail("Extra row at the end, total number of rows is: "+(rowCount-1));
	}

	public void savePartialReport(WebDriver driver, SoftAssertions softly)	throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveButton)).click();
		verifySaveReportPopup(driver,softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveConfirmButton)).click();
		share2.loadingServer(driver);
	}

	public String saveSRIReport(WebDriver driver, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Save report
		savePartialReport(driver,softly);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavedActivitiesButton)).click();
		share2.loadingServer(driver);
		String recordName = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).getText();
		//CLick on new record
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).click();
		share2.loadingServer(driver);
		return recordName;
	}

	public void verifyOpenReportPopup(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Open");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("Do you confirm you want to open SRI™ report referenced as: "+r1+"?");
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

	public void deleteMeasurementFromStep2(WebDriver driver, SoftAssertions softly, String username, String password) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);	
		verifyReportCanBeOpenedAfterLogin(driver,username,password);
		//Click on open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Click on Step 2 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIStep2Tab)).click();
		//Get date 1
		WebElement ele;
		try{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Date));
		}catch(org.openqa.selenium.TimeoutException t)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1DateFirefox));
		}
		String date = ele.getAttribute("value");
		//Get time 1
		try{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Time));
		}catch(org.openqa.selenium.TimeoutException t)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1TimeFirefox));
		}
		String time = ele.getAttribute("value");
		//Get Measurement 1
		String meas = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Measurement)).getText();
		//Click on delete for 1st measurement
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1DeleteButton)).click();
		verifyDeleteMeasurementPopup(driver,softly,date,time,meas);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveConfirmButton)).click();
		//Save
		saveSRIReport(driver,softly);
	}

	public void verifyDeleteMeasurementPopup(WebDriver driver, SoftAssertions softly, String date, String time, String measurement) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Delete");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to delete the following event:");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavePopupNote)).getText();
		softly.assertThat(s4).as("test data").contains("Date: "+date+", Time: "+time+", Measurement: "+measurement);
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("delete");
	}

	public void verifyPageSwitchesToStep2TabWhenErrorIsPresent(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Click on open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Click on Step 2 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIStep2Tab)).click();
		//Clear measurement
		Select s = new Select(driver.findElement(sri.Step2Measurement1MeasurementSelectMenu));
		s.selectByIndex(0);
		//Click on Step 1 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIStep1Tab)).click();
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveButton)).click();
		share2.verifyWarningPopupForSRIError(driver, softly);
		//Verify on step 2 by looking for measurement field of 1st measurement
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Measurement));
		/*
		 *Only till components get fixed in SRI Analysis 
		 */
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavedActivitiesButton)).click();
		share2.loadingServer(driver);
		//CLick on new record
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).click();
		share2.loadingServer(driver);
		
	}

	public void changeComponentVerifyMissingMeasurementAndUnit(WebDriver driver, String component, SoftAssertions softly) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);	
		//Click on open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Click on Step 1 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIStep1Tab)).click();
		//Change component to electrical
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1ElectricalComponentLabel)).click();
		//Component
		Select s = new Select(driver.findElement(sri.Step1Component));
		s.selectByVisibleText(component);
		//Click on Step 2 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIStep2Tab)).click();
		/*
		//Get Measurement 1
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Measurement)).getText();
		softly.assertThat(s2).as("test data").isEqualTo(" ");
		//Get unit 1
		String s2a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Unit)).getText();
		softly.assertThat(s2a).as("test data").isEqualTo(" ");
		*/
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavedActivitiesButton)).click();
		share2.loadingServer(driver);
		//CLick on new record
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).click();
		share2.loadingServer(driver);
		//softly.assertAll();
	}

	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("New Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Would you like to confirm you want to erase the current report and create a new report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavePopupNote)).getText();
		softly.assertThat(s4).as("test data").contains("Note: erased content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("new report");
	}

	public void verifySaveReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save current event report?");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("save report");
	}

}
