import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kaleTestSoftware.EiRCAV2PageObj;
import kaleTestSoftware.ShareCheck;
import kaleTestSoftware.ShareCheck2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EiRCAV2_3 {

	// EiRCA2 eirca2 = new EiRCA2();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	EiRCAV2PageObj eirca = new EiRCAV2PageObj();
	Random ram = new Random();

	public List<String> EiRCAStep2(WebDriver driver, SoftAssertions softly) throws Exception {

		List<String> symptoms = new ArrayList<String>();
		// Enter text in all tabs
//		verifyTabNames(driver, softly);
		designDataTab(driver, eirca.textStep2WithNextLine);
		operatingPracticeTab(driver, eirca.textStep2WithNextLine);
		operatingExperienceTab(driver, eirca.textStep2WithNextLine);
		maintenanceDataTab(driver, eirca.textStep2WithNextLine);
		symptoms.addAll(symptomsTab(driver, eirca.textStep2WithNextLine, softly));
		// Verify no <br> in text boxes
		/*
		 * verifyNobrInDOOMSTextBoxes(driver,softly); //Enter text in DELTA DOOMS Tab
		 * deltaDOOMSTab(driver,textStep2WithNextLine,softly); //Verify no <br> in text
		 * boxes verifyNobrInDeltaDOOMSTextBoxes(driver,softly); //Add 4 symptoms in
		 * Comprehensive Field Inspection Tab List<String> inspectionsAndDetailsAll =
		 * comprehensiveFieldInspection(driver,textStep2,softly); for(int
		 * i=4;i<inspectionsAndDetailsAll.size();i=i+5) {
		 * symptoms.add(inspectionsAndDetailsAll.get(i));
		 * System.out.println(inspectionsAndDetailsAll.get(i)); }
		 */
		// Add interviews in Interview Tab
		interviews(driver, eirca.textStep2, softly);
		share2.scrollToTop(driver);

		return symptoms;
	}

	public void verifyTabNames(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTab)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("D-\"Design Data\"");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTab)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("O-\"Operating Practice and Condition Data\"");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingExperienceTab)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("O-\"Operating Experience\"");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTab)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("M-\"Maintenance Data\"");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTab)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("S-\"Symptoms\"");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewsTab)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Interviews");
	}
	/*
	 * public void verifyNobrInDeltaDOOMSTextBoxes(WebDriver driver, SoftAssertions
	 * softly) throws Exception {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver,10); //Verify text in Failure
	 * Component String s1 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DeltaDOOMSFailureComponentTextbox1)).getAttribute("value");
	 * softly.assertThat(s1).as("test data").doesNotContain("<br>"); String s2 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DeltaDOOMSFailureComponentTextbox2)).getAttribute("value");
	 * softly.assertThat(s2).as("test data").doesNotContain("<br>"); //Non-Failure
	 * Similar Components String s3 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DeltaDOOMSNonFailureSimilarComponentTextbox1)).getAttribute("value"
	 * ); softly.assertThat(s3).as("test data").doesNotContain("<br>"); String s4 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DeltaDOOMSNonFailureSimilarComponentTextbox2)).getAttribute("value"
	 * ); softly.assertThat(s4).as("test data").doesNotContain("<br>");
	 * //Non-Failure Components with Similar Functions String s5 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DeltaDOOMSNonFailureComponentSimilarFunctionTextbox1)).getAttribute
	 * ("value"); softly.assertThat(s5).as("test data").doesNotContain("<br>"); }
	 * 
	 * public void verifyNobrInDOOMSTextBoxes(WebDriver driver, SoftAssertions
	 * softly) throws Exception {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver,10); //Verify text in Design
	 * data String s1 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DesignDataTextbox1R1C1)).getAttribute("value");
	 * softly.assertThat(s1).as("test data").doesNotContain("<br>"); String s2 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DesignDataTextbox1R1C2)).getAttribute("value");
	 * softly.assertThat(s2).as("test data").doesNotContain("<br>"); String s3 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DesignDataTextbox1R1C3)).getAttribute("value");
	 * softly.assertThat(s3).as("test data").doesNotContain("<br>"); String s4 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DOOMSDesignDataTextbox4)).getAttribute("value");
	 * softly.assertThat(s4).as("test data").doesNotContain("<br>"); String s5 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DOOMSDesignDataTextbox5)).getAttribute("value");
	 * softly.assertThat(s5).as("test data").doesNotContain("<br>"); //Operating
	 * practice and condition data String s6 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DOOMSOperatingPracticeTextbox1)).getAttribute("value");
	 * softly.assertThat(s6).as("test data").doesNotContain("<br>"); String s7 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DOOMSOperatingPracticeTextbox2)).getAttribute("value");
	 * softly.assertThat(s7).as("test data").doesNotContain("<br>"); //operating
	 * experience String s8 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DOOMSOperatingExperienceTextbox1)).getAttribute("value");
	 * softly.assertThat(s8).as("test data").doesNotContain("<br>"); String s9 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DOOMSOperatingExperienceTextbox2)).getAttribute("value");
	 * softly.assertThat(s9).as("test data").doesNotContain("<br>"); //maintenance
	 * data String s10 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DOOMSMaintenanceDataTextbox1)).getAttribute("value");
	 * softly.assertThat(s10).as("test data").doesNotContain("<br>"); String s11 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DOOMSMaintenanceDataTextbox2)).getAttribute("value");
	 * softly.assertThat(s11).as("test data").doesNotContain("<br>"); String s12 =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2DOOMSMaintenanceDataTextbox3)).getAttribute("value");
	 * softly.assertThat(s12).as("test data").doesNotContain("<br>"); }
	 */

	public void interviews(WebDriver driver, String text, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//Focus on Save button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)));
		jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'pii-ircam2-tab2-tab6-a') and contains(text(),'Interviews')]"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'pii-ircam2-tab2-tab6-a') and contains(text(),'Interviews')]"))));
		// Table 1
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row1Column1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row1Column1)).sendKeys(text);
		Thread.sleep(500);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row1Column2)));
		Thread.sleep(500);
		// Verify no undefined in Interview textbox
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row1Column2)).getAttribute("textcontent");
		softly.assertThat(s).as("test data").isNull();
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row1Column2)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row1Column2)).sendKeys(text);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row2Column2)));
		Thread.sleep(500);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row2Column2)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row2Column2)).sendKeys(text);
		Thread.sleep(500);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row2Column1)));
		Thread.sleep(500);
		// Verify no undefined in Name textbox
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row2Column1)).getAttribute("textcontent");
		softly.assertThat(s1).as("test data").isNull();
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row2Column1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable1Row2Column1)).sendKeys(text);
		Thread.sleep(500);
		// Table 2
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row1Column1)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row1Column1)));
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row1Column1)).sendKeys(text);
		Thread.sleep(500);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row1Column2)));
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row1Column2)).sendKeys(text);
		Thread.sleep(1000);
//		share2.scrollToAPoint(driver, 600);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column1)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column1)));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column1)).click();
		Thread.sleep(500);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column1)).sendKeys(text);
		Thread.sleep(500);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column2)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column2)));
		Thread.sleep(500);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column2)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row2Column2)).sendKeys(text);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row3Column1)));
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row3Column1)).sendKeys(text);
		Thread.sleep(500);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row3Column2)));
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row3Column2)).sendKeys(text);
		Thread.sleep(1000);
		// Delete 3rd interview in table 2
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row3Column3DeleteButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row3Column3DeleteButton)));
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)));
		Thread.sleep(1000);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable2Row4Column1)).click();
			softly.fail("interview did not get deleted");
		} catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException t) {

		}
		// Table 3
//		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row1Column1)));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row1Column1)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row1Column1)));
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row1Column1)).sendKeys(text);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row1Column2)).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row1Column2)).sendKeys(text);
		Thread.sleep(1000);
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column1)));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column1)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column1)));
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column1)).sendKeys(text);
		Thread.sleep(500);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column2)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column2)));
		Thread.sleep(500);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column2)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable3Row2Column2)).sendKeys(text);
		Thread.sleep(500);
		// Table 4
//	share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column1)));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column1)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column1)));
		Thread.sleep(500); 
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column1)).sendKeys(text);
		Thread.sleep(500);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column2)));
		Thread.sleep(500);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column2)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row1Column2)).sendKeys(text);
		Thread.sleep(1000);
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column1)));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column1)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column1)));
		Thread.sleep(500);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column1)).sendKeys(text);
		Thread.sleep(500);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column2)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column2)));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column2)).click();
		Thread.sleep(500);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column2)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InterviewTabTable4Row2Column2)).sendKeys(text);
		Thread.sleep(500);
		share2.scrollToTop(driver);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
	}

	public void designDataTab(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTab)).click();
		// Fill text in Design data
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox1R1C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox1R1C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox1R1C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox2R2C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox2R2C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox2R2C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox3R3C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox3R3C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox3R3C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox4R4C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox4R4C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox4R4C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox5R5C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox5R5C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2DesignDataTextbox5R5C3)).sendKeys(text);
	}

	public void operatingPracticeTab(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTab)).click();
		// Operating practice and condition data
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox1R1C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox1R1C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox1R1C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox2R2C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox2R2C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox2R2C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox3R3C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox3R3C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingPracticeTextbox3R3C3)).sendKeys(text);
	}

	public void operatingExperienceTab(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingExperienceTab)).click();
		// Operating experience
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingExperienceTextbox1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingExperienceTextbox2R2C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2OperatingExperienceTextbox2R2C2)).sendKeys(text);
	}

	public void maintenanceDataTab(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTab)).click();
		// maintenance data
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox1R1C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox1R1C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox1R1C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox2R2C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox2R2C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox2R2C3)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox3R3C1)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox3R3C2)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2MaintenanceDataTextbox3R3C3)).sendKeys(text);
	}

	public List<String> symptomsTab(WebDriver driver, String text, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		List<String> symptoms = new ArrayList<String>();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTab)).click();
		// symptoms
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox1)).sendKeys("Symptom 1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox2)).sendKeys("Symptom 2");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTextbox3)).sendKeys("Symptom 3");
		symptoms.add("Symptom 1");
		symptoms.add("Symptom 2");
		symptoms.add("Symptom 3");
		share2.scrollToAPoint(driver, 700);

		// Click SBI dropdown
		WebElement sbiElement = driver.findElement(By.id("pii-ircam2-t3-inspections-type-button"));
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-type-button"))));
		jse.executeScript("arguments[0].focus();", sbiElement);
		jse.executeScript("arguments[0].click();", sbiElement);
//		sbiElement.click();
		// Checkbox SBI: Abnormal smell
		WebElement sbiCheckbox = driver.findElement(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-isymptom-menu']//a[text()='Abnormal smell']"));
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-isymptom-menu']//a[text()='Abnormal smell']"))));
		jse.executeScript("arguments[0].focus();", sbiCheckbox);
		jse.executeScript("arguments[0].click();", sbiCheckbox);
//		sbiCheckbox.click();
		// Click SBI:Abnormal small subOption dropdown
		share2.scrollToAPoint(driver, 400);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-0"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-0"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-0"))).click();
		// Checkbox 2 inside SBI: Abnormal small dropdown
		WebElement sbiAbsmall = driver.findElement(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-ifocus-0-menu']//a[text()='Burning of insulation polymers']"));
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-ifocus-0-menu']//a[text()='Burning of insulation polymers']"))));
		jse.executeScript("arguments[0].focus();", sbiAbsmall);
		jse.executeScript("arguments[0].click();", sbiAbsmall);
//		sbiAbsmall.click();
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-ifocus-0-menu']//a[text()='Burning of lubrication oil']"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-ifocus-0-menu']//a[text()='Burning of lubrication oil']"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-ifocus-0-menu']//a[text()='Burning of lubrication oil']"))).click();
		// Close Checkbox 2 inside SBI: Abnormal small dropdown
		WebElement closeAbsmall = driver.findElement(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-ifocus-0-listbox']//a[text()='Close']"));
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-ifocus-0-listbox']//a[text()='Close']"))));
		jse.executeScript("arguments[0].focus();", closeAbsmall);
		jse.executeScript("arguments[0].click();", closeAbsmall);
//		closeAbsmall.click();
		// Sendtext in SBI: Abnormal small textbox: 1st row: Inspection Notes
		WebElement sbiAbsmalltext1 = driver.findElement(By.xpath("//*[@id='pii-ircam2-t2t3-inotes-td']/textarea[@piifocus='0']"));
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-inotes-td']/textarea[@piifocus='0']"))));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-inotes-td']/textarea[@piifocus='0']"))));
		sbiAbsmalltext1.sendKeys("XXX");
		// 1st row: Symptoms Findings
		WebElement sbiAbsmalltext2 = driver.findElement(By.xpath("//*[@id='pii-ircam2-t2t3-ifindings-td']/textarea[@piifocus='0']"));
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-ifindings-td']/textarea[@piifocus='0']"))));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-ifindings-td']/textarea[@piifocus='0']"))));
		sbiAbsmalltext2.sendKeys("XXX");
		// Sendtext in SBI: Abnormal small textbox: 2nd row: Inspection Notes
		WebElement sbiAbsmalltext2nd1 = driver.findElement(By.xpath("//*[@id='pii-ircam2-t2t3-inotes-td']/textarea[@piifocus='1']"));
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-inotes-td']/textarea[@piifocus='1']"))));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-inotes-td']/textarea[@piifocus='1']"))));
		sbiAbsmalltext2nd1.sendKeys("XXX");
		// 2nd row: Symptoms Findings
		WebElement sbiAbsmalltext2nd2 = driver.findElement(By.xpath("//*[@id='pii-ircam2-t2t3-ifindings-td']/textarea[@piifocus='1']"));
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-ifindings-td']/textarea[@piifocus='1']"))));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-ifindings-td']/textarea[@piifocus='1']"))));
		sbiAbsmalltext2nd2.sendKeys("XXX");

		// Click SRI dropdown
		WebElement sriElement = driver.findElement(By.xpath("//*[@id='pii-ircam2-t3-inspections-type-button' and @piitype='1']"));
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t3-inspections-type-button' and @piitype='1']"))));
		jse.executeScript("arguments[0].focus();", sriElement);
		jse.executeScript("arguments[0].click();", sriElement);
//		sriElement.click();
		// Click SRI: Leak option
		WebElement sriLeakOption = driver.findElement(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-isymptom-SRI-menu']//a[text()='Leak/Drain related']"));
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-isymptom-SRI-menu']//a[text()='Leak/Drain related']"))));
		jse.executeScript("arguments[0].focus();", sriLeakOption);
		jse.executeScript("arguments[0].click();", sriLeakOption);
//		sriLeakOption.click();

		// Click SRI:Leak subOption dropdown
		share2.scrollToAPoint(driver, 800);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t3-inspections-focus-button-SRI-2' and @piiindex='4']"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t3-inspections-focus-button-SRI-2' and @piiindex='4']"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t3-inspections-focus-button-SRI-2' and @piiindex='4']"))).click();

		// Checkbox SRI:Leak:
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-ifocus-SRI-2-menu']//a[text()='Heat from steam pipe leak (Thermal image)']"))));

		// Close SRI:Leak subOption dropdown
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-ifocus-SRI-2-listbox']//a[text()='Close']"))));

		// Sendtext in SRI: Leak: Inspection Notes
		WebElement sriLeaktext1 = driver.findElement(By.xpath("//*[@id='pii-ircam2-t2t3-inotes-SRI-td']/textarea"));
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-inotes-SRI-td']/textarea"))));
		jse.executeScript("arguments[0].focus();", sriLeaktext1);
		sriLeaktext1.sendKeys("XXX");
		// Sendtext in SRI: Leak: Symptoms Findings
		WebElement sriLeaktext2 = driver.findElement(By.xpath("//*[@id='pii-ircam2-t2t3-ifindings-SRI-td']/textarea"));
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-ircam2-t2t3-ifindings-SRI-td']/textarea"))));
		jse.executeScript("arguments[0].focus();", sriLeaktext2);
		sriLeaktext2.sendKeys("XXX");
		//Focus on Save button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)));

//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		List<WebElement> els = driver.findElements( By.xpath(".//*[@id='pii-ircam2-t2t3-newentry-isymptom-menu']/li"));
//		js.executeScript("arguments[0].click();", eirca.EiRCAStep2SenseBasedInspectionButton);
//		for ( WebElement el : els ) {
//		    if ( !el.isSelected() ) {
//		        Thread.sleep(300);
//		        js.executeScript("arguments[0].click();", el);
//		        js.executeScript("arguments[0].click();", eirca.EiRCAStep2SenseBasedInspectionButton);
//		    	Thread.sleep(300);
//		    	share2.scrollToAPoint(driver, 600);
//		    }
//		}
//		
//		List<WebElement> elements=driver.findElements(By.xpath(".//*[starts-with(@id,'ct100_cPH_rptrDisplayRecords')]"));
//		int numberOfElements=elements.size();
//		for(int i=0;i<numberOfElements;i++){
//		    elements=driver.findElements(By.xpath(".//*[starts-with(@id,'ct100_cPH_rptrDisplayRecords')]"));
//		    elements.get(i).click();
//		    //click edit button and manage the popup
//		    // Uncomment below code if the selection of the check box is not automatically cleared on closing the popup
//		    /* elements=driver.findElements(By.xpath(".//*[starts-with(@id,'ct100_cPH_rptrDisplayRecords')]"));
//		    elements.get(i).click(); */
//		}

		// Add symptoms in Comprehensive field Inspection

//		scrollToSBIButtonElement(driver);
//		List<String> symp = addSymptomsInComprehensiveFieldInspectionSenseBasedInspection(driver, text, softly);
//		System.out.println("Symp"+ symp);
//		symptoms.addAll(symp);
//		Thread.sleep(1500);
//		symptoms.addAll(addSymptomsInComprehensiveFieldInspectionSRI(driver, text, softly, symp));
//		System.out.println("Symptoms"+ symptoms);

		/*
		 * am_edit:SBI rewrite List<WebElement> sbiOptionsLst = driver
		 * .findElements(By.xpath("//*[@id='pii-ircam2-t2t3-newentry-isymptom-menu']//a"
		 * )); int sbiOptionsSize = sbiOptionsLst.size(); for (int i = 0; i <
		 * sbiOptionsSize; i++) { WebElement sbiElement =
		 * driver.findElement(By.id("pii-ircam2-t3-inspections-type-button"));
		 * share2.scrollToElement(driver, wait.until(
		 * ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "pii-ircam2-t3-inspections-type-button")))); sbiElement.click();
		 * driver.findElement( By.xpath(
		 * "//*[@id='pii-ircam2-t2t3-newentry-isymptom-menu']//*[@data-option-index='" +
		 * i + "']/a")) .click();
		 * 
		 * WebElement openSubMenu = driver.findElement(By.xpath("//tr[@piiindex='" + i +
		 * "']//button")); share2.scrollToElement(driver, wait.until(
		 * ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@piiindex='" + i
		 * + "']//button")))); openSubMenu.click();
		 * 
		 * List<WebElement> sbiSubOptionsLst = driver.findElements( By.
		 * xpath("//*[@class='ui-popup-container ui-popup-active']//li[@data-icon='false']//a"
		 * )); int sbiSubOptionsSize = sbiSubOptionsLst.size();
		 * 
		 * for (int j = 0; j < sbiSubOptionsSize; j++) { driver.findElements( By.
		 * xpath("//*[@class='ui-popup-container ui-popup-active']//li[@data-icon='false']//a"
		 * )).get(j) .click();
		 * 
		 * } driver.findElement(By.
		 * xpath("//*[@class='ui-popup-container ui-popup-active']//*[text()='Close']"))
		 * .click();
		 * 
		 * for (int k = 0; k < sbiSubOptionsSize; k++) {
		 * driver.findElement(By.xpath("//tr[@piiindex='" + i + "' and @piifocus='" + k
		 * + "']//td[@id='pii-ircam2-t2t3-inotes-td']//textarea"))
		 * .sendKeys("adgssdfgfsgfsgsdgfsgsfvsfvfsgvsvgsfgfsg");
		 * driver.findElement(By.xpath("//tr[@piiindex='" + i + "' and @piifocus='" + k
		 * + "']//td[@id='pii-ircam2-t2t3-ifindings-td']//textarea"))
		 * .sendKeys("adgssdfgfsgfsgsdgfsgsfvsfvfsgvsvgsfgfsg"); } }
		 * 
		 * 
		 * /////////////am_edit:SRI rewrite //List SRI 7 option common xpath
		 * List<WebElement> sriOptionsLst = driver.findElements(By.xpath(
		 * "//*[@id='pii-ircam2-t2t3-newentry-isymptom-SRI-menu']//a")); int
		 * sriOptionsSize = sriOptionsLst.size(); for (int i = 0; i < sriOptionsSize;
		 * i++) { WebElement sriElement =
		 * driver.findElement(By.xpath("//*[contains(text(), 'reliability')]"));
		 * share2.scrollToElement(driver, wait.until(
		 * ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//*[contains(text(), 'reliability')]")))); sriElement.click();
		 * driver.findElement( By.xpath(
		 * "//*[@id='pii-ircam2-t2t3-newentry-isymptom-SRI-menu']//*[@data-option-index='"
		 * + i + "']/a")).click();
		 * 
		 * WebElement openSubMenu = driver.findElement(By.xpath(
		 * "//*[contains(@id,'pii-ircam2-t2t3-inspections-table-SRI-tbody')]/tr[@piiindex='"
		 * + i + "']//button")); share2.scrollToElement(driver, wait.until(
		 * ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[contains(@id,'pii-ircam2-t2t3-inspections-table-SRI-tbody')]/tr[@piiindex='"
		 * + i + "']//button")))); openSubMenu.click();
		 * 
		 * List<WebElement> sriSubOptionsLst = driver.findElements( By.
		 * xpath("//*[@class='ui-popup-container ui-popup-active']//li[@data-icon='false']//a"
		 * )); int sriSubOptionsSize = sriSubOptionsLst.size(); //checkbox clicks on all
		 * sriSubOptions for (int j = 0; j < sriSubOptionsSize; j++) {
		 * driver.findElements( By.
		 * xpath("//*[@class='ui-popup-container ui-popup-active']//li[@data-icon='false']//a"
		 * )).get(j) .click();
		 * 
		 * } //close sriSubOption menu popup driver.findElement(By.
		 * xpath("//*[@class='ui-popup-container ui-popup-active']//*[text()='Close']"))
		 * .click(); //enter textarea for each sriSubOption for (int k = 0; k <
		 * sriSubOptionsSize; k++) { driver.findElement(By.xpath("//tr[@piiindex='" + i
		 * + "' and @piifocus='" + k +
		 * "']//td[@id='pii-ircam2-t2t3-inotes-SRI-td']//textarea"))
		 * .sendKeys("adgssdfgfsgfsgsdgfsgsfvsfvfsgvsvgsfgfsg");
		 * driver.findElement(By.xpath("//tr[@piiindex='" + i + "' and @piifocus='" + k
		 * + "']//td[@id='pii-ircam2-t2t3-ifindings-SRI-td']//textarea"))
		 * .sendKeys("adgssdfgfsgfsgsdgfsgsfvsfvfsgvsvgsfgfsg"); } }
		 * 
		 */
		share2.scrollToTop(driver);
		return symptoms;
	}

	public void scrollToSBIButtonElement(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Point p = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SenseBasedInspectionButton)).getLocation();
		int yaxis = p.getY() - 250;
		Thread.sleep(1000);
		try {
			jse.executeScript("scroll(0," + yaxis + ")");
		} catch (org.openqa.selenium.ScriptTimeoutException | JavascriptException | org.openqa.selenium.StaleElementReferenceException r) {
			Thread.sleep(3000);
			jse.executeScript("scroll(0," + yaxis + ")");
		}
		Thread.sleep(1000);
	}

	public void scrollToSRIButtonElement(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Point p = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton)).getLocation();
		int yaxis = p.getY() - 250;
		Thread.sleep(1000);
		try {
			jse.executeScript("scroll(0," + yaxis + ")");
		} catch (org.openqa.selenium.ScriptTimeoutException | JavascriptException | org.openqa.selenium.StaleElementReferenceException r) {
			Thread.sleep(3000);
			jse.executeScript("scroll(0," + yaxis + ")");
		}
		Thread.sleep(1000);
	}

	public static void main(String[] args) {
		Random random = new Random();
		// int num = random.nextInt(7);
		int num = random.nextInt(6);
		if (num == 0) {
			num = num + 1;
		}
		System.out.println(num);
	}

	/*
	 * ///////////////////////Comment out SBI dropdown: new loop is located in
	 * symptomsTab public List<String>
	 * addSymptomsInComprehensiveFieldInspectionSenseBasedInspection(WebDriver
	 * driver, String text, SoftAssertions softly) throws Exception {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, 30); List<String> symptoms =
	 * new ArrayList<String>(); // Sense Based inspection // Select randomly
	 * symptoms Random random = new Random(); // int num = random.nextInt(7); int
	 * num = random.nextInt(6); if (num == 0) { num = num + 1; } // Click on SBI
	 * dropdown list button
	 * 
	 * /* Below coding only click SBI dropdown list > Abnormal Noises only
	 * share2.scrollToElement(driver,
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2SenseBasedInspectionButton))); //Click SBI list dropdown
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2SenseBasedInspectionButton)).click(); //SBI list popup
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.
	 * EiRCAStep2InspectionSymptomListPopup)); WebElement menu1 =
	 * driver.findElement(eirca.EiRCAStep2InspectionSymptomListMenu); String cL1 =
	 * menu1.findElement(eirca.EiRCAStep2SymptomsOption1).getAttribute("class");
	 * if(cL1.contains("ui-checkbox-off")) //Click on Abnormal Noises:
	 * EiRCAStep2SymptomsOption1
	 */
	// menu1.findElement(eirca.EiRCAStep2SymptomsOption1).click();

//		System.out.println("random" + num);
//		for (int i = 0; i <= num; i++) {
//					//Click on button
//					
//					try{
//						share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SenseBasedInspectionButton)));
//					}catch(org.openqa.selenium.StaleElementReferenceException e){
//						share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SenseBasedInspectionButton)));
//					}
//			Thread.sleep(500);
//			scrollToSBIButtonElement(driver);
//			Thread.sleep(500);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SenseBasedInspectionButton))
//					.click();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListPopup));
//			WebElement menu = driver.findElement(eirca.EiRCAStep2InspectionSymptomListMenu);
//			String cL = menu.findElement(By.xpath(".//*[@data-option-index='" + i + "']/a")).getAttribute("class");
//			if (cL.contains("ui-checkbox-off"))
//				menu.findElement(By.xpath(".//*[@data-option-index='" + i + "']/a")).click();
//			Thread.sleep(200);
//		}
//				
////				
////				public By EiRCAStep2SymptomsTextbox1 = By.xpath(".//*[@piiid='2.1.11']");
////				public By EiRCAStep2SymptomsTextbox2 = By.xpath(".//*[@piiid='2.1.13']");
////				public By EiRCAStep2SymptomsTextbox3 = By.xpath(".//*[@piiid='2.1.15']");
////				public By EiRCAStep2SenseBasedInspectionButton = By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-outer-table-tbody-SB']/tr[1]/td[1]/button");
////				public By EiRCAStep2SystematicReliabilityInspectionButton = By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-outer-table-tbody-SRI']/tr[1]/td[1]/button");
////				
////				public By EiRCAStep2InspectionSymptomListPopup = By.id("pii-ircam2-t2t3-newentry-isymptom-listbox-popup");
////				public By EiRCAStep2InspectionSymptomListSBIPopupCloseButton = By.xpath(".//*[@id='pii-ircam2-t2t3-newentry-isymptom-listbox']/div/a");
////				public By EiRCAStep2InspectionSymptomListSRIPopupCloseButton = By.xpath(".//*[@id='pii-ircam2-t2t3-newentry-isymptom-SRI-listbox']/div/a");
////				public By EiRCAStep2InspectionSymptomListMenu = By.id("pii-ircam2-t2t3-newentry-isymptom-menu");
////				public By EiRCAStep2InspectionSymptomListPopupSRI = By.id("pii-ircam2-t2t3-newentry-isymptom-SRI-listbox-popup");
////				public By EiRCAStep2InspectionSymptomListMenuSRI = By.id("pii-ircam2-t2t3-newentry-isymptom-SRI-menu");
////				public By EiRCAStep2SymptomsOption0 = By.xpath(".//*[@data-option-index='0']/a");
////				public By EiRCAStep2SymptomsOption1 = By.xpath(".//*[@data-option-index='1']/a");
////				public By EiRCAStep2SBISelectMenu = By.id("pii-ircam2-t2t3-newentry-isymptom");
////				public By EiRCAStep2SRISelectMenu = By.id("pii-ircam2-t2t3-newentry-isymptom-SRI");
////				public By EiRCAStep2SBIIFocusButton1WhenNoSelection = By.id("pii-ircam2-t3-inspections-focus-button-0");
////				public By EiRCAStep2SBITbody = By.id("pii-ircam2-t2t3-inspections-outer-table-tbody-SB");
////				public By EiRCAStep2SRITbody = By.id("pii-ircam2-t2t3-inspections-outer-table-tbody-SRI");
////				public By EiRCAStep2TableHeadingC1 = By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table']/thead/tr[1]/th[1]");
////				public By EiRCAStep2TableHeadingC2 = By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table']/thead/tr[1]/th[2]");
////				public By EiRCAStep2TableHeadingC3 = By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table']/thead/tr[1]/th[3]");
////				public By EiRCAStep2TableHeadingC4 = By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table']/thead/tr[1]/th[4]");
////				
//				
//				//List for counting number of rows in SBI
//		List<Integer> rows = new ArrayList<Integer>();
//		for (int i = 1; i <= num; i++) {
//			// Click on button for selecting inspection parameter
//			Thread.sleep(500);
//			share2.scrollToElement(driver, wait.until(ExpectedConditions
//					.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-" + (i - 1)))));
//			wait.until(ExpectedConditions
//					.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-" + (i - 1)))).click();
//			WebElement menu = driver.findElement(By.id("pii-ircam2-t2t3-newentry-ifocus-" + (i - 1) + "-menu"));
//			int y = 2;
//			if (i == 4)
//				y = 3;
//			// Select options
//			int n = random.nextInt(y);
//			System.out.println("576Random" + n);
//			rows.add(n);
//			for (int j = 0; j < n; j++) {
//				String cL = menu.findElement(By.xpath(".//*[@data-option-index='" + j + "']/a")).getAttribute("class");
//				if (cL.contains("ui-checkbox-off"))
//					menu.findElement(By.xpath(".//*[@data-option-index='" + j + "']/a")).click();
//			}
//			// close popup
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='pii-ircam2-t2t3-newentry-ifocus-" + (i - 1) + "-listbox']/div/a"))).click();
//		}
//
//		// Fill text in notes and findings
//		int countRow = 0;
//		for (int j = 0; j < rows.size(); j++) {
//			for (int i = 0; i <= rows.get(j); i++) {
//				if (i == 0) {
//					// Notes
//					share2.scrollToElement(driver,
//							wait.until(ExpectedConditions.visibilityOfElementLocated(
//									By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["
//											+ (i + countRow + 1) + "]/td[3]/textarea"))));
//					wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr[" + (i + countRow + 1)
//									+ "]/td[3]/textarea")))
//							.sendKeys(text);
//					// Findings
//					wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr[" + (i + countRow + 1)
//									+ "]/td[4]/textarea")))
//							.sendKeys("Symptoms findings SBI " + j + i);
//					symptoms.add("Symptoms findings SBI " + j + i);
//				} else {
//					// Notes
//					System.out.println("SBI print countRow" + countRow);
//					System.out.println("SBI print i" + i);
//
//					share2.scrollToElement(driver,
//							wait.until(ExpectedConditions.visibilityOfElementLocated(
//									By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr["
//											+ (i + countRow + 1) + "]/td[3]/textarea"))));
//					wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr[" + (i + countRow + 1)
//									+ "]/td[3]/textarea")))
//							.sendKeys(text);
//
//					/*
//					 * share2.scrollToElement(driver,
//					 * wait.until(ExpectedConditions.visibilityOfElementLocated(
//					 * By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr[" + (i +
//					 * countRow + 1) + "]/td[2]/textarea"))));
//					 * wait.until(ExpectedConditions.visibilityOfElementLocated(
//					 * By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr[" + (i +
//					 * countRow + 1) + "]/td[2]/textarea"))) .sendKeys(text);
//					 */
//
//					// Findings
//					wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr[" + (i + countRow + 1)
//									+ "]/td[4]/textarea")))
//							.sendKeys("Symptoms findings SBI " + j + i);
//					symptoms.add("Symptoms findings SBI " + j + i);
//
//					/*
//					 * // Findings wait.until(ExpectedConditions.visibilityOfElementLocated(
//					 * By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-tbody']/tr[" + (i +
//					 * countRow + 1) + "]/td[3]/textarea"))) .sendKeys("Symptoms findings SBI " + j
//					 * + i); symptoms.add("Symptoms findings SBI " + j + i);
//					 */
//				}
//			}
//			countRow += rows.get(j) + 1;
//		}
//		// Pair<type1, type2> pair = new Pair<type1, type2>(value1, value2);
//		return symptoms;
//	}

////////////////////////Comment out SBI dropdown: new loop is located in symptomsTab */

	public List<String> addSymptomsInComprehensiveFieldInspectionSRI(WebDriver driver, String text, SoftAssertions softly, List<String> symp) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		List<String> symptoms = new ArrayList<String>();
		// SRI
		// Select randomly symptoms
		Random random = new Random();
		int num = random.nextInt(8);
		if (num == 0) {
			num = num + 1;
		}

//		
////		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListSBIPopupCloseButton)).click();
////		Thread.sleep(500);
////		// Click on button
////		JavascriptExecutor jse=((JavascriptExecutor)driver);
////		jse.executeScript("window.scrollBy(0,400)");
////		//share2.scrollToElement(driver, wait.until(
////				ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton);
////		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton)).click();
////		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListPopupSRI));
////		WebElement menu1 = driver.findElement(eirca.EiRCAStep2InspectionSymptomListMenuSRI);
////		
////		 String cL1 = menu1.findElement(eirca.EiRCAStep2SymptomsOption1).getAttribute("class");
////		 if(cL1.contains("ui-checkbox-off"))
////			 menu1.findElement(eirca.EiRCAStep2SymptomsOption1).click();
////		// close SBI popup
////		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListSRIPopupCloseButton)).click();
////		 
		for (int i = 1; i <= num; i++) {
//			//Click on button
////				//try{
////				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton)));
////				}catch(org.openqa.selenium.StaleElementReferenceException e){
////					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton)));
////				}
			Thread.sleep(500);
			scrollToSRIButtonElement(driver);
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SystematicReliabilityInspectionButton)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListPopupSRI));
			WebElement menu = driver.findElement(eirca.EiRCAStep2InspectionSymptomListMenuSRI);
			String cL = menu.findElement(By.xpath(".//*[@data-option-index='" + i + "']/a")).getAttribute("class");
			if (cL.contains("ui-checkbox-off"))
				menu.findElement(By.xpath(".//*[@data-option-index='" + i + "']/a")).click();
			// close SRI popup
			// Thread.sleep(200);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListSRIPopupCloseButton)).click();

		}
//		// List for counting number of rows in SRI
		List<Integer> rows = new ArrayList<Integer>();
		int lastIndexOfSBI = symp.size();
		System.out.println("lastIndexofSBI" + lastIndexOfSBI);
		System.out.println("688num" + num);
		for (int i = 1; i <= num; i++) {
			// Click on button for selecting inspection parameter
			Thread.sleep(500);
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-SRI-" + (lastIndexOfSBI + i - 1)))));
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-SRI-" + (lastIndexOfSBI + i - 1)))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-ircam2-t3-inspections-focus-button-SRI-" + (lastIndexOfSBI + i - 1)))));
			WebElement menu = driver.findElement(By.id("pii-ircam2-t2t3-newentry-ifocus-SRI-" + (lastIndexOfSBI + i - 1) + "-menu"));

////			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(
////					By.id("pii-ircam2-t3-inspections-focus-button-SRI-" + (lastIndexOfSBI + i - 1)))));
////			wait.until(ExpectedConditions.visibilityOfElementLocated(
////					By.id("pii-ircam2-t3-inspections-focus-button-SRI-" + (lastIndexOfSBI + i - 1)))).click();
			int y = 2;
			if (i == 4)
				y = 3;
			// Select options
			int n = random.nextInt(y);
			System.out.println("706Random" + n);
			rows.add(n);
			for (int j = 0; j < n + 1; j++) {
				String cL = menu.findElement(By.xpath(".//*[@data-option-index='" + j + "']/a")).getAttribute("class");
				if (cL.contains("ui-checkbox-off"))
					menu.findElement(By.xpath(".//*[@data-option-index='" + j + "']/a")).click();
			}
			// close popup
			// wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2InspectionSymptomListSRIPopupCloseButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-newentry-ifocus-SRI-" + (lastIndexOfSBI + i - 1) + "-listbox']/div/a"))).click();
		}
		// Fill text in notes and findings
		int countRow = 0;
		for (int j = 0; j < rows.size(); j++) {
			for (int i = 0; i <= rows.get(j); i++) {
				if (i == 0) {
					// Notes
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr[" + (i + countRow + 1) + "]/td[3]/textarea"))));
					jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr[" + (i + countRow + 1) + "]/td[3]/textarea"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr[" + (i + countRow + 1) + "]/td[3]/textarea"))).sendKeys(text);
					// Findings
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr[" + (i + countRow + 1) + "]/td[4]/textarea"))).sendKeys("Symptoms findings SRI " + j + i);
					symptoms.add("Symptoms findings SRI " + j + i);
				} else {
					// Notes
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr[" + (i + countRow + 1) + "]/td[2]/textarea"))));
					jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr[" + (i + countRow + 1) + "]/td[2]/textarea"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr[" + (i + countRow + 1) + "]/td[2]/textarea"))).sendKeys(text);
					// Findings
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table-SRI-tbody']/tr[" + (i + countRow + 1) + "]/td[3]/textarea"))).sendKeys("Symptoms findings SRI " + j + i);
					symptoms.add("Symptoms findings SRI " + j + i);
				}
			}
			countRow += rows.get(j) + 1;
		}
		return symptoms;
	}

	public void verifyInspectionFocusDropdownIsCorrect(WebDriver driver, SoftAssertions softly) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		// SBI
		for (int i = 0; i <= 6; i++) {
			if (i == 1)
				i = i + 1;
			WebElement inspection = driver.findElement(By.id("pii-ircam2-t2t3-newentry-ifocus-" + i));
			if (i == 0)
				inspectionFocus.addAll(inspectionFocusForAbnormalConfiguration(driver));
			if (i == 2)
				inspectionFocus.addAll(inspectionFocusForAbnormalNoises(driver));
			if (i == 3)
				inspectionFocus.addAll(inspectionFocusForAbnormalSmell(driver));
			if (i == 4)
				inspectionFocus.addAll(inspectionFocusForCrackWearPitting(driver));
			if (i == 5)
				inspectionFocus.addAll(inspectionFocusForDiscoloration(driver));
			if (i == 6)
				inspectionFocus.addAll(inspectionFocusForLeakCorrosion(driver));
			List<WebElement> insList = inspection.findElements(By.tagName("option"));
			for (int j = 0; j < insList.size(); j++) {
				softly.assertThat(insList.get(j).getText()).as("test data").isIn(inspectionFocus);
			}
			inspectionFocus.clear();
		}
		// SRI
		for (int i = 1; i < 13; i++) {
			WebElement inspection = driver.findElement(By.id("pii-ircam2-t2t3-newentry-ifocus-SRI-" + i));
			if (i == 1) {
				inspectionFocus.addAll(inspectionFocusForBurningOverheating(driver));
				i = 6;
			}
			if (i == 7)
				inspectionFocus.addAll(inspectionFocusForDustAndWater(driver));
			if (i == 8)
				inspectionFocus.addAll(inspectionFocusForElectronicAndElectricalEquipment(driver));
			if (i == 9)
				inspectionFocus.addAll(inspectionFocusForEMNearField(driver));
			if (i == 10)
				inspectionFocus.addAll(inspectionFocusForLeakDrainRelated(driver));
			if (i == 11)
				inspectionFocus.addAll(inspectionFocusForVibrationRelated(driver));
			if (i == 12)
				inspectionFocus.addAll(inspectionFocusForWearAndTear(driver));
			List<WebElement> insList = inspection.findElements(By.tagName("option"));
			for (int j = 0; j < insList.size(); j++) {
				softly.assertThat(insList.get(j).getText()).as("test data").isIn(inspectionFocus);
			}
			inspectionFocus.clear();
		}
	}

	public List<String> inspectionFocusForLeakCorrosion(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Corrosion marks in pipe insulation");
		inspectionFocus.add("Water pool underneath pipe");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForDiscoloration(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Chemical reactions");
		inspectionFocus.add("Over-heating in loose terminals");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForCrackWearPitting(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Arcing pits");
		inspectionFocus.add("Cracking in casing, shaft or containers");
		inspectionFocus.add("Scratch marks from pipe movements");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForAbnormalSmell(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Burning of insulation polymers");
		inspectionFocus.add("Burning of lubrication oil");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForAbnormalNoises(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Ball bearing grinding");
		inspectionFocus.add("Check valve banging");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForAbnormalConfiguration(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Pipe deformation from water hammers");
		inspectionFocus.add("Sagging of pipe from inadequate support");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForWearAndTear(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Bearing lining thinning (Ultrasound)");
		inspectionFocus.add("Gasket and cable aging (Durometer)");
		inspectionFocus.add("Internal tear and wear (Endoscope, Mirror)");
		inspectionFocus.add("Pipe wall thinning (Ultrasound)");
		inspectionFocus.add("Wear patterns (Microscope)");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForVibrationRelated(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Cavitation induced vibrations (Acoustic emission)");
		inspectionFocus.add("Heat from loss of lubrication (Thermal image)");
		inspectionFocus.add("Impact noises (Acoustic emission)");
		inspectionFocus.add("Valve stem facture (Thermal image)");
		inspectionFocus.add("Vibrating components (Vibration meter)");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForLeakDrainRelated(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Cold steam traps/tanks (Thermal image)");
		inspectionFocus.add("Condenser in-leak (Acoustic emission, Smoke meter)");
		inspectionFocus.add("Heat from steam pipe leak (Thermal image)");
		inspectionFocus.add("Leaks (Acoustic emission and humidity meters)");
		inspectionFocus.add("Leak detection by smoke (Smoke meter)");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForEMNearField(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Alternating electrical field from unshielded power cable (Electric field meter)");
		inspectionFocus.add("Alternating magnetic field from welding machine (Magnetic field meter)");
		inspectionFocus.add("Gauss field (Gauss meter)");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForElectronicAndElectricalEquipment(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("EMI noises from arcing (EMI meter)");
		inspectionFocus.add("Heat from arcing (Thermal image)");
		inspectionFocus.add("Heat in cables and windings (Thermal image)");
		inspectionFocus.add("Heat in circuit boards (Thermal image)");
		inspectionFocus.add("Heat in loose connections (Thermal image)");
		inspectionFocus.add("Ozone from arcing (Ozone meter)");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForDustAndWater(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Dust ingress (PM2.5)");
		inspectionFocus.add("Humidity related condensation (Humidity meter)");
		inspectionFocus.add("Internal particle generation (PM2.5 meter)");
		return inspectionFocus;
	}

	public List<String> inspectionFocusForBurningOverheating(WebDriver driver) throws Exception {

		List<String> inspectionFocus = new ArrayList<String>();
		inspectionFocus.add("Smoke dust (PM2.5 meter)");
		inspectionFocus.add("Total organic volatile (TVOC meter)");
		return inspectionFocus;
	}

	public List<String> symptomsForInspectionForSenseBasedInspection(WebDriver driver) throws Exception {

		List<String> symptoms = new ArrayList<String>();
		symptoms.add("Abnormal configuration");
		symptoms.add("Abnormal noises");
		symptoms.add("Abnormal smell");
		symptoms.add("Crack/Wear/Pitting");
		symptoms.add("Discoloration");
		symptoms.add("Leak/Corrosion");
		return symptoms;
	}

	public List<String> symptomsForInspectionForSystematicReliabilityInspection(WebDriver driver) throws Exception {

		List<String> symptoms = new ArrayList<String>();
		symptoms.add("Burning/Overheating");
		symptoms.add("Dust and water");
		symptoms.add("Electronic and electrical equipment");
		symptoms.add("EM near field");
		symptoms.add("Leak/Drain related");
		symptoms.add("Vibration related");
		symptoms.add("Wear and tear");
		return symptoms;
	}

	public void verifySymptomDropdownIsCorrect(WebDriver driver, SoftAssertions softly) throws Exception {

		// Select Inspection type = Sense Based Inspection
		WebElement inspection = driver.findElement(eirca.EiRCAStep2SBISelectMenu);
		// Verify the values in symptoms dropdown
		List<String> symptoms = symptomsForInspectionForSenseBasedInspection(driver);
		for (int i = 0; i < 6; i++) {
			String s1 = inspection.findElement(By.xpath(".//*[@value='" + i + "']")).getText();
			softly.assertThat(s1).as("test data").isIn(symptoms);
		}
		// Select Inspection type = Systematic Reliability Inspection
		WebElement inspection1 = driver.findElement(eirca.EiRCAStep2SRISelectMenu);
		// Verify the values in symptoms dropdown
		List<String> symptoms1 = symptomsForInspectionForSystematicReliabilityInspection(driver);
		for (int i = 0; i < 7; i++) {
			String s1a = inspection1.findElement(By.xpath(".//*[@value='" + i + "']")).getText();
			softly.assertThat(s1a).as("test data").isIn(symptoms1);
		}
	}
}
