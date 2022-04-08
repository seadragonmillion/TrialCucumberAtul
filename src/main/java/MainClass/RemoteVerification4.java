package MainClass;


import PageObjects.RemoteVerificationPageObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoteVerification4 {

	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();

	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on new button
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewButton)));
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Start New Remote Verification");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to erase current report and start a new remote verification?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Warning: unsaved content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("new remote verification");
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).click();
	}

	public void verifySaveReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save current event report?");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("save report");
	}

	public void verifySaveAndSendReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save and Send Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).getText();
		softly.assertThat(s1).as("test data").contains("Are you sure you want to save & send current report to verification user:");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Information: verification user will receive an email and will be able to verify report.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("save and send report");
	}
	
	public void verifyTextOnRVCurrentVerificationPage(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);	
		//Main title
		String mainTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVMainTitle)).getText();
		softly.assertThat(mainTitle).as("test data").isEqualTo("Remote Verification: Enter all necessary data needed for verification. - v1");
		//Report info
		String reportInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportInfoTitle)).getText();
		softly.assertThat(reportInfo).as("test data").isEqualTo("(1) Report Information.");
		//Report title
		String reportTitleLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportTitleLabel)).getText();
		softly.assertThat(reportTitleLabel).as("test data").isEqualTo("Verification Report Title: ");
		//date time
		String dateTimeLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportDateTimeLabel)).getText();
		softly.assertThat(dateTimeLabel).as("test data").isEqualTo("Creation date and time: ");
		//location
		String locationLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportLocationLabel)).getText();
		softly.assertThat(locationLabel).as("test data").isEqualTo("Photo upload location: ");
		//photo 1
		String image1Label = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportImage1Label)).getText();
		softly.assertThat(image1Label).as("test data").isEqualTo("(2) Take or choose a photo of work needing verification.");
		//photo 2
		String image2Label = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportImage2Label)).getText();
		softly.assertThat(image2Label).as("test data").isEqualTo("(3) Take or choose a photo of the person requesting verification.");
		//details
		String detailsLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportDetailsLabel)).getText();
		softly.assertThat(detailsLabel).as("test data").isEqualTo("(4) Fill in relevant details and description of work needing verification.");
		//verifier
		String verifierLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerifierLabel)).getText();
		softly.assertThat(verifierLabel).as("test data").isEqualTo("(5) Select whether this verification is:");
		String verifierSelectedLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerifierSelectedLabel)).getText();
		softly.assertThat(verifierSelectedLabel).as("test data").isEqualTo("Selected verifier: ");
		//report verify title
		String reportVerifySend = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVReportVerifierSendLabel)).getText();
		softly.assertThat(reportVerifySend).as("test data").isEqualTo("(6) Save and send verification report to verifier for approval.");
	}

}
