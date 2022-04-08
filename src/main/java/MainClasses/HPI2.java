import kaleTestSoftware.HPIObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HPI2 {
	
	HPIObj hpi = new HPIObj();

	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPINewButton)).click();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPIPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Start New Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPIPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to erase current changes and start a new report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPIPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Warning: erased content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPIPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPIPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("new report");
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPIPopupCancelButton)).click();
	}
	
	public void verifyFinalizeReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPIPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Finalize Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPIPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save and finalize current report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPIPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: later, saved data can be seen by clicking \"saved activities\" button.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPIPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPIPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("save & finalize");
	}

}
