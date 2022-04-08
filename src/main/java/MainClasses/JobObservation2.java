import kaleTestSoftware.JobObservationObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobObservation2 {

	JobObservationObj jo = new JobObservationObj();

	public void verifyErrorOnPage (WebDriver driver, SoftAssertions softly) throws Exception{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click Submit Observation
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(jo.Step1Observer));
		driver.findElement(jo.JOmiddleSubmitButton).click();
		//Verify all errors
		String observerError = driver.findElement(jo.Step1ObserverError).getText();
		softly.assertThat(observerError).as("test data").isEqualTo("Observer is required");
		String orgError = driver.findElement(jo.Step1OrgError).getText();
		softly.assertThat(orgError).as("test data").isEqualTo("Organization is required");
		String deptError = driver.findElement(jo.Step1DeptError).getText();
		softly.assertThat(deptError).as("test data").isEqualTo("Department is required");
		String locationError = driver.findElement(jo.Step1LocationError).getText();
		softly.assertThat(locationError).as("test data").isEqualTo("Location is required");
		String jobObsError = driver.findElement(jo.Step1JobObservedError).getText();
		softly.assertThat(jobObsError).as("test data").isEqualTo("Job is required");
		//softly.assertAll();
	}

	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Start New Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to erase current changes and start a new report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupNote)).getText();
		softly.assertThat(s4).as("test data").contains("Warning: erased content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("new report");
	}

	public void verifySaveReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save Job Observation Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save current job observation report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: saved data can be seen by clicking \"saved activities\" button.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("save report");
	}

	public void verifyBuildReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Build Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to build report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Warning: you cannot modify job observations once you click build report.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//build report button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(jo.JOPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("build report");
	}
}
