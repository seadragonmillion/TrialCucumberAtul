import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import kaleTestSoftware.ChineseCommonFunctions;
import kaleTestSoftware.EiRCA2;
import kaleTestSoftware.EiRCAPageObj;
import kaleTestSoftware.HiRCAChinese;
import kaleTestSoftware.HiRCAChinese17;
import kaleTestSoftware.HiRCAEvent;
import kaleTestSoftware.HiRCALevel1;
import kaleTestSoftware.LoginPageObj;
import kaleTestSoftware.ShareCheck;
import kaleTestSoftware.ShareCheck2;
import kaleTestSoftware.ShareCheck3;
import kaleTestSoftware.ShareCheckPageObj;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EiRCAChinese {

	public String text = "Chinese check";

	SoftAssertions softly = new SoftAssertions();

	EiRCAPageObj eircaObj = new EiRCAPageObj();
	LoginPageObj login = new LoginPageObj();
	EiRCA2 e2 = new EiRCA2();
	ShareCheck3 share3 = new ShareCheck3();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	ShareCheckPageObj shareObj = new ShareCheckPageObj();
	HiRCAChinese17 hc17 = new HiRCAChinese17();
	HiRCAChinese hc = new HiRCAChinese();
	ChineseCommonFunctions ccf = new ChineseCommonFunctions();

	public void EiRCApath (WebDriver driver, String username, String password1) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		HiRCALevel1 obj2 = new HiRCALevel1();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.AnalysisLink)).click();
		//Bug KALE-1963
		bugKALE1963(driver);
		//Create a new EiRCA report 
		chineseEventInfoFill(driver);
		//Sequence of events
		chineseSequenceOfEvents(driver);
		//Create a new event
		e2.createNewEvent(driver, text,softly);
		//Verify Headers of the Sequence of event table
		chineseVerifySequenceOfEventsTable(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 1
		chineseStep1(driver);
		//Select some answers in Step1 to move forward
		selectAnswersStep1(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 2
		chineseStep2(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 3
		chineseStep3(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 4
		chineseStep4(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		Thread.sleep(1000);
		//Verify popup text
		chinesePopupAfterStep4(driver);
		//Click on confirm 
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupConfirmButton)).click();
		//Step 5
		chineseStep5(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 6
		chineseStep6(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 7
		chineseStep7SUEP(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Report Tab
		chineseReportTab(driver);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCASaveButton)).click();
		//Save popup
		chineseSavePopup(driver);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupConfirmButton)).click();
		//Wait for loading message 
		share2.loadingServer(driver);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCASavedActivitiesButton)).click();
		//Wait for loading message 
		share2.loadingServer(driver);
		//Click on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAFirstRecord)).click();
		//Wait for loading message 
		share2.loadingServer(driver);
		//Verify HTML report
		List<String> chineseData = chineseHTML(driver);
		//Download pdf and verify pdf
		downloadSelectFunction(driver,chineseData);
		//Delete 1st report
		obj2.deleteReport(driver);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.KALEHomePage)).click();
		//Path 2
		EiRCApath2(driver, username, password1);
		//Path 3
		EiRCApath3(driver);
	}

	public void EiRCApath3 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Create a new EiRCA report 
		chineseEventInfoFill(driver);
		//Sequence of events
		chineseSequenceOfEvents(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 1
		chineseStep1(driver);
		//Select some answers in Step1 to move forward
		selectAnswersStep1(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 2
		chineseStep2(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 3
		chineseStep3(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 4
		chineseStep4(driver);
		//Select yes for 4.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step4TableOption44CheckBox)).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Verify popup text
		chinesePopupAfterStep4(driver);
		//Click on confirm 
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupConfirmButton)).click();
		//Step 5
		chineseStep5(driver);
		//Scroll to element 5.5 checkbox
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5TableOption55CheckBox));
		share2.scrollToElement(driver, l);
		//Select yes for 5.5
		l.click();
		//Scroll to element 5.6 checkbox
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5TableOption56CheckBox));
		share2.scrollToElement(driver, l);
		//Select yes for 5.6	  	
		l.click();
		//Scroll to top
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 6
		chineseStep6(driver);
		//Select yes for 6.5 to 6.8 and verify chinese on 3rd column
		selectStep6(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 7
		chineseStep7SUEP(driver);
		//Verify additional chinese translation in SUEP table and click on checkboxes for root cause and contributing factor
		chineseStep7SUEPTable(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Verify Report Tab
		chineseReportTabPath3(driver);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCASaveButton)).click();
		//Save popup
		chineseSavePopup(driver);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupConfirmButton)).click();
		//Wait for loading message 
		share2.loadingServer(driver);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCASavedActivitiesButton)).click();
		//Wait for loading message 
		share2.loadingServer(driver);
		//Click on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAFirstRecord)).click();
		//Wait for loading message 
		share2.loadingServer(driver);
		//Verify HTML report
		List<String> chineseData = chineseHTMLPath3(driver);
		//Download pdf and verify pdf
		downloadSelectFunction(driver,chineseData);
	}

	public void chineseStep7SUEPTable (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//SUEP Table
		//Column 1 heading
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEPTableColumn1Heading)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("促成因素");
		//Column 6 heading
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEPTableColumn6Heading)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("纠正行动");
		//Row 1
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEPTableRow1)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("失效模式");
		//Row 2
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEPTableRow2)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("导致故障的工作活动");
		//Row 3
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEPTableRow3)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("不当的预防性维修计划");
		//Row 4
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEPTableRow4)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("维修失误");
		//Row 5
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEPTableRow5)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("运行失误");
		//Click all 4 checkboxes for Row 2: first line of SUEP boxes
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEPTableRow2Chk1)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEPTableRow2Chk2)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEPTableRow2Chk3)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEPTableRow2Chk4)).click();
	}

	public void selectStep6 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Select yes for 6.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption65CheckBox)).click();
		//Select yes for 6.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption66CheckBox)).click();
		//Select yes for 6.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption67CheckBox)).click();
		//Select yes for 6.8
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption68CheckBox)).click();
		//Verify message in 3rd column for 6.6
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption66MessageColumn3)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("不当的预防性维修计划为促成因素");
		//Verify message in 3rd column for 6.7
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption67MessageColumn3)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("维修失误为促成因素");
		//Verify message in 3rd column for 6.8
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption68MessageColumn3)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("运行失误为促成因素");
	}

	public void EiRCApath2 (WebDriver driver, String username, String password1) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		HiRCALevel1 obj2 = new HiRCALevel1();
		//Create a new EiRCA report 
		chineseEventInfoFill(driver);
		//Sequence of events
		chineseSequenceOfEvents(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 1
		chineseStep1(driver);
		//Select some answers in Step1 to move forward
		selectAnswersStep1(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 2
		chineseStep2(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		//Step 3
		chineseStep3(driver);
		//Select all boxes of Step 3 
		selectAllCheckboxesStep3(driver);
		//Verify all yes in third column of Step3
		chineseYesStep3Column3(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		Thread.sleep(1000);
		//Verify pop up at Step 3
		chinesePopupAfterStep3(driver);
		//Click on green button, Preview report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupCancelButton)).click();
		//to accomodate bug
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3Tab)).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCANextButton)).click();
		Thread.sleep(1000);
		//Click on green button, Preview report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupCancelButton)).click();
		//Verify Report Tab
		chineseReportTabPath2(driver);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCASaveButton)).click();
		//Save popup
		chineseSavePopup(driver);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupConfirmButton)).click();
		//Wait for loading message 
		share2.loadingServer(driver);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCASavedActivitiesButton)).click();
		//Wait for loading message 
		share2.loadingServer(driver);
		//Click on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAFirstRecord)).click();
		//Wait for loading message 
		share2.loadingServer(driver);
		//Verify HTML report
		List<String> chineseData = chineseHTMLPath2(driver);
		//Download pdf and verify pdf
		downloadSelectFunction(driver,chineseData);
		//Share pop up verify chinese
		chineseShareReportAndVerifySharePopUp(driver, username, password1);
		//Delete 1st report
		obj2.deleteReport(driver);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.KALEHomePage)).click();
	}

	public void chineseShareReportAndVerifySharePopUp(WebDriver driver, String username, String password1) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		String sharer = ccf.decideSharerChinese(driver);
		String sharerAdded = ccf.decideSharerAddedChinese(driver);
		//Click on share button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ShareButton)).click();
		share3.shareTwice(driver, softly, 1);
		//Choose chinese sharer name and username
		//Enters username
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ShareTextBox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ShareTextBox)).sendKeys(sharer);
		Thread.sleep(2000);
		//Selects from dropdown
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ShareDropdown));
		dropdown.findElement(eircaObj.FirstSelectionUnderDropdown).click();
		//Clicks on add user
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupButton)).click();
		//Verifies user added
		String user=wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.SharerAdded)).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		//Click save on share page
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ShareSaveButton)).click();
		//Calls the Share check function
		share.receiveNotification(driver, sharer, 1,softly);
		share.logInToUser(driver, username, password1);
		//Clicks on EiRCA side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCASidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAFirstRecord)).click();
	}

	public void chinesePopupAfterStep3 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Title of popup
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupHeader)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("完成排除");
		//Popup message title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("所有可能的失效模式已排除，需要继续新增失效模式或预览报告？");
		//Popup message
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopUpMessageNote)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("编辑失效模式：新增失效模式或审核排除证明。");
		//Confirm button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("编辑失效模式");
		//Cancel button
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupCancelButton)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("预览报告");
	}

	public void chineseYesStep3Column3 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//3.1 
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption31Column3)).getText();
		softly.assertThat(s).as("test data").contains("是");
		//3.2
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption32Column3)).getText();
		softly.assertThat(s1).as("test data").contains("是");
		//3.3
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption33Column3)).getText();
		softly.assertThat(s2).as("test data").contains("是");
		//3.4
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption34Column3)).getText();
		softly.assertThat(s3).as("test data").contains("是");
		//3.5
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption35Column3)).getText();
		softly.assertThat(s4).as("test data").contains("是");
		//3.6
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption36Column3)).getText();
		softly.assertThat(s5).as("test data").contains("是");
	}

	public void selectAllCheckboxesStep3 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on check box for 3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption31CheckBox)).click();
		//Click on check box for 3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption32CheckBox)).click();
		//Click on check box for 3.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption33CheckBox)).click();
		//Click on check box for 3.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption34CheckBox)).click();
		//Scroll to the bottom
		share2.scrollToAPoint(driver, 1200);
		//Click on check box for 3.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption35CheckBox)).click();
		//Click on check box for 3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption36CheckBox)).click();
		//Scroll to the top
		share2.scrollToTop(driver);
	}


	public void downloadSelectFunction (WebDriver driver, List<String> chineseData) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj2 = new HiRCAEvent();
		obj2.deleteFiles(file);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			downloadReportChrome(driver,chineseData);
		if (browserName.equals("firefox"))
			downloadReportFirefox(driver,chineseData);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				downloadReportIE10(driver,chineseData);
			if (v.startsWith("11"))
				downloadReportIE11(driver,chineseData);
		}
	}

	public void downloadReportChrome (WebDriver driver, List<String> verifyChinese) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		HiRCAEvent obj2 = new HiRCAEvent();
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.DownloadButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupButton)).click();
		Thread.sleep(8000);
		List<String> results = new ArrayList<String>();
		File[] files = new File("C://Users//mama//Downloads//EFTestDownloadReports//").listFiles();
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		//If this pathname does not denote a directory, then listFiles() returns null. 
		for (File file1 : files) {
			if (file1.isFile()) {
				results.add(file.getName());
			}
		}
		System.out.println(results.get(0));
		if(results.get(0).endsWith(".pdf")==false)
		{
			driver.switchTo().window(window);
			obj2.deleteFiles(file);
			//Switch to iframe
			driver.switchTo().frame(driver.findElement(login.Iframe));
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.DownloadButton)).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupTitle)).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupButton)).click();
			Thread.sleep(8000);
		}
		//pdf check
		pdfCheck(driver,verifyChinese);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);
		Thread.sleep(2000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(login.Iframe));
	}

	public void downloadReportFirefox(WebDriver driver, List<String> verifyChinese) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.DownloadButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupButton)).click();
		Thread.sleep(8000);
		for(String winHandle : driver.getWindowHandles())
		{
			System.out.println(winHandle);
			if(winHandle.isEmpty()==false)
			{
				if(winHandle.equals(window)==false)
					driver.switchTo().window(winHandle);
			}
		}
		Thread.sleep(4000);/*
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
		p.waitFor();
		Thread.sleep(3000);
		//If no pdf repeat
		// specify your directory
		Path dir = Paths.get("C://Users//mama//Downloads//EFTestDownloadReports//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		try{
			System.out.println(lastFilePath.get());
		}catch(java.util.NoSuchElementException r)
		{
			//deletes files in reports folder before starting to download
			File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
			HiRCAEvent obj2 = new HiRCAEvent();
			obj2.deleteFiles(file);
			// press Ctrl+S the Robot's way
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_S);
			Thread.sleep(2000);
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
			q.waitFor();
			Thread.sleep(7000);
		}*/
		//pdf check
		pdfCheck(driver,verifyChinese);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();      
		Thread.sleep(2000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(login.Iframe));
	}

	public void downloadReportIE10(WebDriver driver, List<String> verifyChinese)throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.DownloadButton)).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupButton)).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(7000);
		//pdf verification
		pdfCheck(driver,verifyChinese);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);
		Thread.sleep(2000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(login.Iframe));
	}

	public void downloadReportIE11(WebDriver driver, List<String> verifyChinese)throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.DownloadButton)).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupButton)).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(7000);
		//pdf verification
		pdfCheck(driver,verifyChinese);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);	
		Thread.sleep(2000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(login.Iframe));
	}

	public void pdfCheck(WebDriver driver, List<String> verifyChinese) throws Exception {

		// specify your directory
		Path dir = Paths.get("C://Users//mama//Downloads//EFTestDownloadReports//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		try{
			System.out.println(lastFilePath.get());
		}catch(java.util.NoSuchElementException t)
		{

		}
		//Loads the file to check if correct data is present
		String fileName=lastFilePath.get().toString();
		File oldfile = new File(fileName);
		PDDocument pddoc= PDDocument.load(oldfile);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		String newData1="";
		for (int i = 0; i < ans.size(); i++)
		{	        	
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData1 = newData1+ans.get(i);
			if (ans.get(i).charAt(n)!=' ')
				newData1 = newData1+ans.get(i);	        	
		}
		//Verifies all chinese texts
		for(int i=0;i<verifyChinese.size();i++)
		{
			softly.assertThat(newData1).as("test data").contains(verifyChinese.get(i));
		}
		//Close pdf
		pddoc.close();
	}

	public List<String> chineseHTMLPath3 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> c = new ArrayList<String>();
		//Verify the buttons
		hc17.chineseReportButtons(driver,softly);
		List<String> c1 = chineseHTMLTable1 (driver);
		c.addAll(c1);
		//Heading before Table 2
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Title)).getText();
		c.add(s1);
		softly.assertThat(s1).as("test data").contains("事件原因");
		//Table 2
		//Column 1 title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Column1Title)).getText();
		c.add(s2);
		softly.assertThat(s2).as("test data").contains("根本原因");
		//Column 2 title
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Column2Title)).getText();
		c.add(s3);
		softly.assertThat(s3).as("test data").contains("纠正行动");
		//Row 1 
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Row1Column1)).getText();
		c.add(s4);
		softly.assertThat(s4).as("test data").contains("失效模式");
		//Row 2
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Row2Column1)).getText();
		c.add(s5);
		softly.assertThat(s5).as("test data").contains("导致故障的工作活动");
		//Table 3
		//Column 1 title
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Column1Title)).getText();
		c.add(s6);
		softly.assertThat(s6).as("test data").contains("促成因素");
		//Column 2 title
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Column2Title)).getText();
		softly.assertThat(s7).as("test data").contains("纠正行动");
		c.add(s7);
		//Row 1 
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Row1Column1)).getText();
		softly.assertThat(s8).as("test data").contains("失效模式");
		c.add(s8);
		//Row 2
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Row2Column1)).getText();
		softly.assertThat(s11).as("test data").contains("不当的预防性维修计划");
		c.add(s11);
		//Row 3 
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Row3Column1)).getText();
		softly.assertThat(s9).as("test data").contains("维修失误");
		c.add(s9);
		//Row 4 
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Row4Column1)).getText();
		softly.assertThat(s12).as("test data").contains("运行失误");
		c.add(s12);
		//Heading before Table 5
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable4Title)).getText();
		softly.assertThat(s14).as("test data").contains("第一步 - 失效设备与失效症状");
		c.add(s14);
		//Table 4
		//Column 1 title
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable4Column1Title)).getText();
		softly.assertThat(s15).as("test data").contains("问题");
		c.add(s15);
		//Column 2 title
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable4Column2Title)).getText();
		softly.assertThat(s16).as("test data").contains("答案");
		c.add(s16);
		//Row 1
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable4Row1Column1)).getText();
		softly.assertThat(s17).as("test data").contains("1.1: 这是故障排查还是根本原因分析？");
		c.add(s17);
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable4Row1Column2)).getText();
		softly.assertThat(s18).as("test data").contains("故障排查");
		c.add(s18);
		//Row 2
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable4Row2Column1)).getText();
		softly.assertThat(s19).as("test data").contains("1.2: 故障部件是什么？");
		c.add(s19);
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable4Row2Column2)).getText();
		softly.assertThat(s20).as("test data").contains("---- 其他电气与仪控相关部件");
		c.add(s20);
		//Row 3
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable4Row3Column1)).getText();
		softly.assertThat(s21).as("test data").contains("1.3: 故障部件的主要故障症状是什么？");
		c.add(s21);
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable4Row3Column2)).getText();
		softly.assertThat(s22).as("test data").contains("---- 其他机械相关失效症状 ----");
		c.add(s22);
		//Row 4
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable4Row4Column1)).getText();
		softly.assertThat(s23).as("test data").contains("1.4: 除了主要故障症状外，还观察到了哪些降级？（非必选）");
		c.add(s23);
		//Row 5
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable4Row5Column1)).getText();
		softly.assertThat(s24).as("test data").contains("1.5: 与主要故障症状巧合的异常现象有哪些？（非必选）");
		c.add(s24);
		//Row 6
		String s25 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable4Row6Column1)).getText();
		softly.assertThat(s25).as("test data").contains("1.6: 与主要故障症状巧合的操作有哪些？（非必选）");
		c.add(s25);
		//Heading before Table 5
		String s26 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable5Title)).getText();
		softly.assertThat(s26).as("test data").contains("第二步 - 可能的失效模式");
		c.add(s26);
		//Table 5
		//Column 1 title
		String s27 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable5Column1Title)).getText();
		softly.assertThat(s27).as("test data").contains("失效模式");
		c.add(s27);
		//Column 2 title
		String s28 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable5Column2Title)).getText();
		softly.assertThat(s28).as("test data").contains("描述");
		c.add(s28);
		//Row 1
		//String s29 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable5Row1Column2)).getText();
		//softly.assertThat(s29).as("test data").contains("不适用");
		//c.add(s29);
		//Heading before Table 6
		String s30 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6Title)).getText();
		softly.assertThat(s30).as("test data").contains("第三步 - 排除失效模式");
		c.add(s30);/*
		//Subtitle before Table 6
		String s31 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6SubTitle1)).getText();
		softly.assertThat(s31).as("test data").contains("1. 失效模式:");
		c.add(s31);
		String s32 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6SubTitle2Part1)).getText();
		softly.assertThat(s32).as("test data").contains("失效模式描述:");
		c.add(s32);
		String s33 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6SubTitle2Part2)).getText();
		softly.assertThat(s33).as("test data").contains("不适用");
		//Table 6
		//Column 1 title
		String s34 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6Column1Title)).getText();
		softly.assertThat(s34).as("test data").contains("排除问题");
		c.add(s34);
		//Column 2 title
		String s35 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6Column2Title)).getText();
		softly.assertThat(s35).as("test data").contains("答案");
		c.add(s35);
		//Column 3 title
		String s36 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6Column3Title)).getText();
		softly.assertThat(s36).as("test data").contains("排除");
		c.add(s36);
		//Column 4 title
		String s37 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6Column4Title)).getText();
		softly.assertThat(s37).as("test data").contains("原因");
		c.add(s37);
		//Row 1
		String s38 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6Row1)).getText();
		softly.assertThat(s38).as("test data").contains("3.1: 该故障模式与观察到的症状无关");
		c.add(s38);
		//Row 2
		String s39 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6Row2)).getText();
		softly.assertThat(s39).as("test data").contains("3.2: 该故障模式没有导致观察到的主要症状");
		c.add(s39);
		//Row 3
		String s40 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6Row3)).getText();
		softly.assertThat(s40).as("test data").contains("3.3: 该故障模式没有导致任何所述降级且异常情况纯属巧合");
		c.add(s40);
		//Row 4
		String s41 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6Row4)).getText();
		softly.assertThat(s41).as("test data").contains("3.4: 该故障模式可以因为缺乏某一必要的故障触发因素而被排除");
		c.add(s41);
		//Row 5
		String s42 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6Row5)).getText();
		softly.assertThat(s42).as("test data").contains("3.5: 该故障模式可以因为缺乏必要的环境来影响故障机理而被排除");
		c.add(s42);
		//Row 6
		String s43 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable6Row6)).getText();
		softly.assertThat(s43).as("test data").contains("3.6: 该故障可以因为缺乏某一必要的故障症状而被排除");
		c.add(s43);*/
		//Heading before Table 7
		String s44 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Title)).getText();
		softly.assertThat(s44).as("test data").contains("第四步 - 发生概率和行动");
		c.add(s44);
		//Subtitle before Table 7
		String s45 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7SubTitle1)).getText();
		softly.assertThat(s45).as("test data").contains("未排除的失效模式是根据最高的可能性到最低可能性显示。");
		c.add(s45);
		String s46 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7SubTitle2)).getText();
		softly.assertThat(s46).as("test data").contains("失效模式:");
		c.add(s46);
		String s47 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7SubTitle3Part1)).getText();
		softly.assertThat(s47).as("test data").contains("失效模式描述:");
		c.add(s47);
		//String s48 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7SubTitle3Part2)).getText();
		//softly.assertThat(s48).as("test data").contains("不适用");
		//Column 1 title
		String s49 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Column1Title)).getText();
		softly.assertThat(s49).as("test data").contains("问题");
		c.add(s49);
		//Column 2 title
		String s50 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Column2Title)).getText();
		softly.assertThat(s50).as("test data").contains("答案");
		c.add(s50);
		//Column 3 title
		String s51 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Column3Title)).getText();
		softly.assertThat(s51).as("test data").contains("信息");
		c.add(s51);
		//Row 1
		String s52 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row1Column1)).getText();
		softly.assertThat(s52).as("test data").contains("4.1: 该故障模式是否曾在故障部件或其类似部件上发生过？");
		c.add(s52);
		String s53 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row1Column2)).getText();
		softly.assertThat(s53).as("test data").contains("不适用");
		//Row 2
		String s54 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row2Column1)).getText();
		softly.assertThat(s54).as("test data").contains("4.2: 该故障模式是否与（1）松动螺栓，（2）泄漏 ，（3）腐蚀，（4）异物有关?");
		c.add(s54);
		String s55 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row2Column2)).getText();
		softly.assertThat(s55).as("test data").contains("不适用");
		//Row 3
		String s56 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row3Column1)).getText();
		softly.assertThat(s56).as("test data").contains("4.3: 该故障模式是否存在支持性证据？");
		c.add(s56);
		String s57 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row3Column2)).getText();
		softly.assertThat(s57).as("test data").contains("不适用");
		//Row 4
		String s58 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row4Column1)).getText();
		softly.assertThat(s58).as("test data").contains("4.4: 该故障模式是否与设计、运行或维修活动（活动后立即发生的）有关？");
		c.add("4.4: 该故障模式是否与设计、运行或维修活动（活动后立即发生的）有关？");
		String s59 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row4Column2)).getText();
		softly.assertThat(s59).as("test data").contains("是");
		//Row 5
		String s60 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row5Column1)).getText();
		softly.assertThat(s60).as("test data").contains("4.5: 该故障模式是否与老化有关且与老化超出预期寿命的故障子部件有关？");
		c.add(s60);
		String s61 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row5Column2)).getText();
		softly.assertThat(s61).as("test data").contains("不适用");
		//Row 6
		String s62 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row6Column1)).getText();
		softly.assertThat(s62).as("test data").contains("4.6: 若子部件替换了是否可以修正失效模式？");
		c.add(s62);
		String s63 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row6Column2)).getText();
		softly.assertThat(s63).as("test data").contains("不适用");
		//Row 6
		String s64 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row7Column1)).getText();
		softly.assertThat(s64).as("test data").contains("4.7: 能否获得更多的数据来排除该故障模式？");
		c.add(s64);
		String s67 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable7Row7Column2)).getText();
		softly.assertThat(s67).as("test data").contains("不适用");
		//Title before Table 8
		String s68 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable8Title1)).getText();
		softly.assertThat(s68).as("test data").contains("第五步 - 识别可能的促成因素");
		c.add(s68);
		String s69 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable8Title2)).getText();
		softly.assertThat(s69).as("test data").contains("失效模式:");
		c.add(s69);
		String s70 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable8Title3Part1)).getText();
		softly.assertThat(s70).as("test data").contains("失效模式描述:");
		c.add(s70);
		//String s71 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable8Title3Part2)).getText();
		//softly.assertThat(s71).as("test data").contains("不适用");
		//Table 8 for 5.1
		//Column 1 title
		String s72 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable8Column1Title)).getText();
		softly.assertThat(s72).as("test data").contains("设计变更");
		c.add(s72);
		//Column 2 title
		String s73 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable8Column2Title)).getText();
		softly.assertThat(s73).as("test data").contains("描述");
		c.add(s73);
		//Row 1
		String s86 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable8Row1)).getText();
		softly.assertThat(s86).as("test data").contains("5.1: 故障发生前的设计变更有哪些（如有的话）？若有多起相同故障，可往前追溯。");
		c.add(s86);
		//Table 9 for 5.2
		//Column 1 title
		String s74 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable9Column1Title)).getText();
		softly.assertThat(s74).as("test data").contains("维护实践变更");
		c.add(s74);
		//Column 2 title
		String s75 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable9Column2Title)).getText();
		softly.assertThat(s75).as("test data").contains("描述");
		c.add(s75);
		//Row 1
		String s87 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable9Row1)).getText();
		softly.assertThat(s87).as("test data").contains("5.2: 故障发生前的维修实践变更有哪些（如有的话）？若有多起相同故障，可往前追溯。");
		c.add(s87);
		//Table 10 for 5.3
		//Column 1 title
		String s76 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable10Column1Title)).getText();
		softly.assertThat(s76).as("test data").contains("运行实践变更");
		c.add(s76);
		//Column 2 title
		String s77 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable10Column2Title)).getText();
		softly.assertThat(s77).as("test data").contains("描述");
		//Row 1
		String s88 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable10Row1)).getText();
		softly.assertThat(s88).as("test data").contains("5.3: 故障发生前的运行实践变更有哪些（如有的话）？若有多起相同故障，可往前追溯。");
		c.add(s88);
		//Table 11 for 5.4
		//Column 1 title
		String s78 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable11Column1Title)).getText();
		softly.assertThat(s78).as("test data").contains("新子部件安装");
		c.add(s78);
		//Column 2 title
		String s79 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable11Column2Title)).getText();
		softly.assertThat(s79).as("test data").contains("描述");
		//Row 1
		String s89 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable11Row1)).getText();
		softly.assertThat(s89).as("test data").contains("5.4: 故障发生之前故障部件上安装的新子部件有哪些（如有的话）？若有多起相同故障，可往前追溯。");
		c.add(s89);
		//Table 12 for 5.5
		//Column 1 title
		String s80 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable12Column1Title)).getText();
		softly.assertThat(s80).as("test data").contains("问题");
		c.add(s80);
		//Column 2 title
		String s81 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable12Column2Title)).getText();
		softly.assertThat(s81).as("test data").contains("答案");
		c.add(s81);
		//Column 3 title
		String s82 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable12Column3Title)).getText();
		softly.assertThat(s82).as("test data").contains("描述");
		c.add(s82);
		//Row 1
		String s90 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable12Row1Column1Part1)).getText();
		softly.assertThat(s90).as("test data").contains("5.5: 故障部件在操作运行上有没有超出供应商建议的运行限值？");
		String forPDF1 = s90.replace("\n", "");
		c.add(forPDF1);
		String s91 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable12Row1Column1Part2)).getText();
		softly.assertThat(s91).as("test data").contains("(如为“是”，请描述运行条件，为期时间与厂家限值)");
		c.add(s91);
		String s92 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable12Row1Column2)).getText();
		softly.assertThat(s92).as("test data").contains("是");
		c.add(s92);
		//Table 13 for 5.6 	
		//Column 1 title
		String s83 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable13Column1Title)).getText();
		softly.assertThat(s83).as("test data").contains("问题");
		c.add(s83);
		//Column 2 title
		String s84 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable13Column2Title)).getText();
		softly.assertThat(s84).as("test data").contains("答案");
		c.add(s84);
		//Column 3 title
		String s85 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable13Column3Title)).getText();
		softly.assertThat(s85).as("test data").contains("描述");
		c.add(s85);
		//Row 1
		String s93 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable13Row1Column1Part1)).getText();
		softly.assertThat(s93).as("test data").contains("5.6: 故障部件（或子部件）的使用年限有没有超过MTBF（平均故障间隔时间）寿命的两倍？");
		String forPDF2 = s93.replace("\n", "");
		c.add(forPDF2);
		String s94 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable13Row1Column1Part2)).getText();
		softly.assertThat(s94).as("test data").contains("(如为“是”，请描述故障部件和可疑子部件的预期寿命（MTBF）和实际使用年限)");
		c.add(s94);
		String s95 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable13Row1Column2)).getText();
		softly.assertThat(s95).as("test data").contains("是");
		//Heading before Table 14
		String s96 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Title1)).getText();
		softly.assertThat(s96).as("test data").contains("第六步 - 确定促成因素");
		c.add(s96);
		String s97 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Title2)).getText();
		softly.assertThat(s97).as("test data").contains("失效模式:");
		c.add(s97);
		String s98 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Title3Part1)).getText();
		softly.assertThat(s98).as("test data").contains("失效模式描述:");
		c.add(s98);
		//String s99 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Title3Part2)).getText();
		//softly.assertThat(s99).as("test data").contains("不适用");
		//Column 1 title
		String s100 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Column1Title)).getText();
		softly.assertThat(s100).as("test data").contains("问题");
		c.add(s100);
		//Column 2 title
		String s101 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Column2Title)).getText();
		softly.assertThat(s101).as("test data").contains("答案");
		c.add(s101);
		//Column 3 title
		String s102 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Column3Title)).getText();
		softly.assertThat(s102).as("test data").contains("促成因素");
		c.add(s102);
		//Row 1
		String s103 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row1)).getText();
		softly.assertThat(s103).as("test data").contains("6.1: 任何所述的设计变更（如有）是否可能导致该未被排除的故障模式？");
		c.add(s103);
		//Row 2
		String s104 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row2)).getText();
		softly.assertThat(s104).as("test data").contains("6.2: 任何所述的维修实践变更（如有）是否可能导致该未被排除的故障模式？");
		c.add(s104);
		//Row 3
		String s105 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row3)).getText();
		softly.assertThat(s105).as("test data").contains("6.3: 任何所述的运行实践变更（如有）是否可能导致该未被排除的故障模式？");
		c.add(s105);
		//Row 4
		String s106 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row4)).getText();
		softly.assertThat(s106).as("test data").contains("6.4: 任何所述的新安装子部件是否可能导致该未被排除的故障模式？");
		c.add(s106);
		//Row 5
		String s107 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row5Column1Part1)).getText();
		softly.assertThat(s107).as("test data").contains("6.5: 故障部件附近是否有任何工作活动（如有）可能导致该未被排除的故障模式？");
		String forPDF3 = s107.replace("\n", "");
		c.add(forPDF3);
		String s108 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row5Column1Part2)).getText();
		softly.assertThat(s108).as("test data").contains("(如为“是”，请描述导致故障的工作活动)");
		c.add(s108);
		String s109 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row5Column2)).getText();
		softly.assertThat(s109).as("test data").contains("是");
		//Row 6
		String s110 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row6Column1)).getText();
		softly.assertThat(s110).as("test data").contains("6.6: 不当的预防性维修计划是否可能导致该未被排除的故障模式？");
		c.add(s110);
		String s111 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row6Column2)).getText();
		softly.assertThat(s111).as("test data").contains("是");
		String s112 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row6Column3)).getText();
		softly.assertThat(s112).as("test data").contains("不当的预防性维修计划为促成因素");
		c.add(s112);
		//Row 7
		String s113 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row7Column1)).getText();
		softly.assertThat(s113).as("test data").contains("6.7: 新安装子部件的安装失误是否可能导致未被排除的故障模式？");
		c.add(s113);
		String s114 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row7Column2)).getText();
		softly.assertThat(s114).as("test data").contains("是");
		String s115 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row7Column3)).getText();
		softly.assertThat(s115).as("test data").contains("维修失误为促成因素");
		c.add(s115);
		//Row 8
		String s116 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row8Column1)).getText();
		softly.assertThat(s116).as("test data").contains("6.8: 运行失误是否可能导致该未被排除的故障模式？");
		c.add(s116);
		String s117 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row8Column2)).getText();
		softly.assertThat(s117).as("test data").contains("是");
		String s118 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable14Row8Column3)).getText();
		softly.assertThat(s118).as("test data").contains("运行失误为促成因素");
		c.add(s118);
		//SUEP title before table 15
		String s119 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15SUEPTitle)).getText();
		softly.assertThat(s119).as("test data").contains("第七步 - 识别根本原因和制定纠正行动 (");
		c.add(s119);
		String s120 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15SUEP_S)).getText();
		softly.assertThat(s120).as("test data").contains("是否存在不合标准的实践");
		c.add(s120);
		String s121 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15SUEP_U)).getText();
		softly.assertThat(s121).as("test data").contains("是否在管理层控制下");
		c.add(s121);
		String s122 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15SUEP_E)).getText();
		softly.assertThat(s122).as("test data").contains("是否在事件时序早期");
		c.add(s122);
		String s123 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15SUEP_P)).getText();
		softly.assertThat(s123).as("test data").contains("是否防止再次发生");
		c.add(s123);
		String s124 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15Column1Title)).getText();
		softly.assertThat(s124).as("test data").contains("促成因素");
		c.add(s124);
		String s125 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15Column6Title)).getText();
		softly.assertThat(s125).as("test data").contains("纠正行动");
		c.add(s125);
		//Row 1
		String s126 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15Row1)).getText();
		softly.assertThat(s126).as("test data").contains("失效模式");
		c.add(s126);
		//Row 2
		String s127 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15Row2Column1)).getText();
		softly.assertThat(s127).as("test data").contains("导致故障的工作活动");
		c.add(s127);
		String s128 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15Row2Column2)).getText();
		softly.assertThat(s128).as("test data").contains("是");
		String s129 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15Row2Column3)).getText();
		softly.assertThat(s129).as("test data").contains("是");
		String s130 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15Row2Column4)).getText();
		softly.assertThat(s130).as("test data").contains("是");
		String s131 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15Row2Column5)).getText();
		softly.assertThat(s131).as("test data").contains("是");
		//Row 3
		String s132 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15Row3)).getText();
		softly.assertThat(s132).as("test data").contains("不当的预防性维修计划");
		c.add(s132);
		//Row 4
		String s133 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15Row4)).getText();
		softly.assertThat(s133).as("test data").contains("维修失误");
		c.add(s133);
		//Row 5   	
		String s134 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3HTMLTable15Row5)).getText();
		softly.assertThat(s134).as("test data").contains("运行失误");
		c.add(s134);
		return c;
	}

	public List<String> chineseHTML (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> c = new ArrayList<String>();
		//Verify the buttons
		hc17.chineseReportButtons(driver,softly);
		//Mark critical
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.MarkCritical)).getText();
		softly.assertThat(s).as("test data").contains("重要");
		//Click on mark critical
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.MarkCritical)).click();		
		//confirm button click
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupButton)).click();
		//Wait for loading
		share2.loadingServer(driver);
		//Mark critical text
		share2.loadingServer(driver);
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.MarkCritical)).getAttribute("class");
		softly.assertThat(s1).as("test data").contains("ui-checkbox-on");
		//Click on mark critical again
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.MarkCritical)).click();
		//confirm button click
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ConfirmPopupButton)).click();
		//Wait for loading
		share2.loadingServer(driver);
		List<String> c1 = chineseHTMLTable1 (driver);
		c.addAll(c1);
		//Heading before Table 2
		String s1a = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Title)).getText();
		softly.assertThat(s1a).as("test data").contains("事件原因");
		c.add(s1a);
		//Table 2
		//Column 1 title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Column1Title)).getText();
		softly.assertThat(s2).as("test data").contains("根本原因");
		c.add(s2);
		//Column 2 title
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Column2Title)).getText();
		softly.assertThat(s3).as("test data").contains("纠正行动");
		c.add(s3);
		//Row 1 
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Row1Column1)).getText();
		softly.assertThat(s4).as("test data").contains("不适用");
		c.add(s4);
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Row1Column2)).getText();
		softly.assertThat(s5).as("test data").contains("不适用");
		//Table 3
		//Column 1 title
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Column1Title)).getText();
		softly.assertThat(s6).as("test data").contains("促成因素");
		c.add(s6);
		//Column 2 title
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Column2Title)).getText();
		softly.assertThat(s7).as("test data").contains("纠正行动");
		c.add(s7);
		//Row 1 
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Row1Column1)).getText();
		softly.assertThat(s8).as("test data").contains("不适用");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Row1Column2)).getText();
		softly.assertThat(s9).as("test data").contains("不适用");
		//Heading before Table 4
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Title)).getText();
		softly.assertThat(s10).as("test data").contains("事件时序");
		c.add(s10);
		//Table 4
		//Column 1 title
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Column1Title)).getText();
		softly.assertThat(s11).as("test data").contains("日期, 时间");
		c.add(s11);
		//Column 2 title
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Column2Title)).getText();
		softly.assertThat(s12).as("test data").contains("发生了什么事？");
		c.add(s12);
		//Column 3 title
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Column3Title)).getText();
		softly.assertThat(s13).as("test data").contains("应该发生什么事？");
		c.add(s13);
		//Heading before Table 5
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Title)).getText();
		softly.assertThat(s14).as("test data").contains("第一步 - 失效设备与失效症状");
		c.add(s14);
		//Table 5
		//Column 1 title
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Column1Title)).getText();
		softly.assertThat(s15).as("test data").contains("问题");
		c.add(s15);
		//Column 2 title
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Column2Title)).getText();
		softly.assertThat(s16).as("test data").contains("答案");
		c.add(s16);
		//Row 1
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Row1Column1)).getText();
		softly.assertThat(s17).as("test data").contains("1.1: 这是故障排查还是根本原因分析？");
		c.add(s17);
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Row1Column2)).getText();
		softly.assertThat(s18).as("test data").contains("故障排查");
		c.add(s18);
		//Row 2
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Row2Column1)).getText();
		softly.assertThat(s19).as("test data").contains("1.2: 故障部件是什么？");
		c.add(s19);
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Row2Column2)).getText();
		softly.assertThat(s20).as("test data").contains("---- 其他电气与仪控相关部件");
		c.add(s20);
		//Row 3
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Row3Column1)).getText();
		softly.assertThat(s21).as("test data").contains("1.3: 故障部件的主要故障症状是什么？");
		c.add(s21);
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Row3Column2)).getText();
		softly.assertThat(s22).as("test data").contains("---- 其他机械相关失效症状 ----");
		c.add(s22);
		//Row 4
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Row4Column1)).getText();
		softly.assertThat(s23).as("test data").contains("1.4: 除了主要故障症状外，还观察到了哪些降级？（非必选）");
		c.add(s23);
		//Row 5
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Row5Column1)).getText();
		softly.assertThat(s24).as("test data").contains("1.5: 与主要故障症状巧合的异常现象有哪些？（非必选）");
		c.add(s24);
		//Row 6
		String s25 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Row6Column1)).getText();
		softly.assertThat(s25).as("test data").contains("1.6: 与主要故障症状巧合的操作有哪些？（非必选）");
		c.add(s25);
		//Heading before Table 6
		String s26 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable6Title)).getText();
		softly.assertThat(s26).as("test data").contains("第二步 - 可能的失效模式");
		c.add(s26);
		//Table 6
		//Column 1 title
		String s27 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable6Column1Title)).getText();
		softly.assertThat(s27).as("test data").contains("失效模式");
		c.add(s27);
		//Column 2 title
		String s28 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable6Column2Title)).getText();
		softly.assertThat(s28).as("test data").contains("描述");
		c.add(s28);
		//Row 1
		//String s29 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable6Row1Column2)).getText();
		//softly.assertThat(s29).as("test data").contains("不适用");
		//Heading before Table 7
		String s30 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLSkippedStep3Message)).getText();
		softly.assertThat(s30).as("test data").contains("第三步 - 排除失效模式");/*
		c.add(s30);
		//Subtitle before Table 7
		String s31 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7SubTitle1)).getText();
		softly.assertThat(s31).as("test data").contains("1. 失效模式:");
		c.add(s31);
		String s32 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7SubTitle2Part1)).getText();
		softly.assertThat(s32).as("test data").contains("失效模式描述:");
		c.add(s32);
		String s33 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7SubTitle2Part2)).getText();
		softly.assertThat(s33).as("test data").contains("不适用");
		//Table 7
		//Column 1 title
		String s34 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7Column1Title)).getText();
		softly.assertThat(s34).as("test data").contains("排除问题");
		c.add(s34);
		//Column 2 title
		String s35 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7Column2Title)).getText();
		softly.assertThat(s35).as("test data").contains("答案");
		c.add(s35);
		//Column 3 title
		String s36 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7Column3Title)).getText();
		softly.assertThat(s36).as("test data").contains("排除");
		c.add(s36);
		//Column 4 title
		String s37 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7Column4Title)).getText();
		softly.assertThat(s37).as("test data").contains("原因");
		c.add(s37);
		//Row 1
		String s38 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7Row1)).getText();
		softly.assertThat(s38).as("test data").contains("3.1: 该故障模式与观察到的症状无关");
		c.add(s38);
		//Row 2
		String s39 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7Row2)).getText();
		softly.assertThat(s39).as("test data").contains("3.2: 该故障模式没有导致观察到的主要症状");
		c.add(s39);
		//Row 3
		String s40 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7Row3)).getText();
		softly.assertThat(s40).as("test data").contains("3.3: 该故障模式没有导致任何所述降级且异常情况纯属巧合");
		c.add(s40);
		//Row 4
		String s41 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7Row4)).getText();
		softly.assertThat(s41).as("test data").contains("3.4: 该故障模式可以因为缺乏某一必要的故障触发因素而被排除");
		c.add(s41);
		//Row 5
		String s42 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7Row5)).getText();
		softly.assertThat(s42).as("test data").contains("3.5: 该故障模式可以因为缺乏必要的环境来影响故障机理而被排除");
		c.add(s42);
		//Row 6
		String s43 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable7Row6)).getText();
		softly.assertThat(s43).as("test data").contains("3.6: 该故障可以因为缺乏某一必要的故障症状而被排除");
		c.add(s43);*/
		//Heading before Table 8
		String s44 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLSkippedStep4Message)).getText();
		softly.assertThat(s44).as("test data").contains("第四步 - 发生概率和行动");
		c.add(s44);/*
		//Subtitle before Table 8
		String s45 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8SubTitle1)).getText();
		softly.assertThat(s45).as("test data").contains("未排除的失效模式是根据最高的可能性到最低可能性显示。");
		c.add(s45);
		String s46 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8SubTitle2)).getText();
		softly.assertThat(s46).as("test data").contains("失效模式:");
		c.add(s46);
		String s47 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8SubTitle3Part1)).getText();
		softly.assertThat(s47).as("test data").contains("失效模式描述:");
		c.add(s47);
		String s48 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8SubTitle3Part2)).getText();
		softly.assertThat(s48).as("test data").contains("不适用");
		//Column 1 title
		String s49 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Column1Title)).getText();
		softly.assertThat(s49).as("test data").contains("问题");
		c.add(s49);
		//Column 2 title
		String s50 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Column2Title)).getText();
		softly.assertThat(s50).as("test data").contains("答案");
		c.add(s50);
		//Column 3 title
		String s51 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Column3Title)).getText();
		softly.assertThat(s51).as("test data").contains("信息");
		c.add(s51);
		//Row 1
		String s52 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row1Column1)).getText();
		softly.assertThat(s52).as("test data").contains("4.1: 该故障模式是否曾在故障部件或其类似部件上发生过？");
		c.add(s52);
		String s53 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row1Column2)).getText();
		softly.assertThat(s53).as("test data").contains("不适用");
		//Row 2
		String s54 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row2Column1)).getText();
		softly.assertThat(s54).as("test data").contains("4.2: 该故障模式是否与（1）松动螺栓，（2）泄漏 ，（3）腐蚀，（4）异物有关?");
		c.add(s54);
		String s55 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row2Column2)).getText();
		softly.assertThat(s55).as("test data").contains("不适用");
		//Row 3
		String s56 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row3Column1)).getText();
		softly.assertThat(s56).as("test data").contains("4.3: 该故障模式是否存在支持性证据？");
		c.add(s56);
		String s57 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row3Column2)).getText();
		softly.assertThat(s57).as("test data").contains("不适用");
		//Row 4
		String s58 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row4Column1)).getText();
		softly.assertThat(s58).as("test data").contains("4.4: 该故障模式是否与设计、运行或维修活动（活动后立即发生的）有关？");
		c.add("4.4: 该故障模式是否与设计、运行或维修活动（活动后立即发生的）有关？");
		String s59 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row4Column2)).getText();
		softly.assertThat(s59).as("test data").contains("不适用");
		//Row 5
		String s60 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row5Column1)).getText();
		softly.assertThat(s60).as("test data").contains("4.5: 该故障模式是否与老化有关且与老化超出预期寿命的故障子部件有关？");
		c.add(s60);
		String s61 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row5Column2)).getText();
		softly.assertThat(s61).as("test data").contains("不适用");
		//Row 6
		String s62 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row6Column1)).getText();
		softly.assertThat(s62).as("test data").contains("4.6: 若子部件替换了是否可以修正失效模式？");
		c.add(s62);
		String s63 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row6Column2)).getText();
		softly.assertThat(s63).as("test data").contains("不适用");
		//Row 6
		String s64 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row7Column1)).getText();
		softly.assertThat(s64).as("test data").contains("4.7: 能否获得更多的数据来排除该故障模式？");
		c.add(s64);
		String s65 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable8Row7Column2)).getText();
		softly.assertThat(s65).as("test data").contains("不适用");*/
		//Skipped Step 5 message
		String s66 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLSkippedStep5Message)).getText();
		softly.assertThat(s66).as("test data").contains("第五步 - 识别可能的促成因素 (skipped)");
		c.add(s66);
		//Skipped Step 6 message
		String s67 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLSkippedStep6Message)).getText();
		softly.assertThat(s67).as("test data").contains("第六步 - 确定促成因素 (skipped)");
		c.add(s67);
		//Skipped Step 7 message
		String s68 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLSkippedStep7Message)).getText();
		softly.assertThat(s68).as("test data").contains("第七步 - 识别根本原因和制定纠正行动 (");
		c.add(s68);
		//Last Table
		//Heading
		String s69 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable9Heading)).getText();
		softly.assertThat(s69).as("test data").contains("签字");
		c.add(s69);
		//Row1column1
		String s70 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable9Row1Column1)).getText();
		softly.assertThat(s70).as("test data").contains("编写:");
		c.add(s70);
		//Row1column2
		String s71 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable9Row1Column2)).getText();
		softly.assertThat(s71).as("test data").contains("日期:");
		c.add(s71);
		//Row2column1
		String s72 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable9Row2Column1)).getText();
		softly.assertThat(s72).as("test data").contains("审查:");
		c.add(s72);
		//Row2column2
		String s73 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable9Row2Column2)).getText();
		softly.assertThat(s73).as("test data").contains("日期:");
		//Row3column1
		String s74 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable9Row3Column1)).getText();
		softly.assertThat(s74).as("test data").contains("批准:");
		c.add(s74);
		//Row3column2
		String s75 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable9Row3Column2)).getText();
		softly.assertThat(s75).as("test data").contains("日期:");
		return c;
	}

	public List<String> chineseHTMLTable1 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> c = new ArrayList<String>();
		//Heading
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Title)).getText();
		softly.assertThat(s1).as("test data").contains("事件信息");
		c.add(s1);
		//Label 1
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label1)).getText();
		softly.assertThat(s2).as("test data").contains("事件名称");
		c.add(s2);
		//Label 2
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label2)).getText();
		softly.assertThat(s3).as("test data").contains("事件编号代码");
		c.add(s3);
		//Label 3
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label3)).getText();
		softly.assertThat(s4).as("test data").contains("事件地点");
		c.add(s4);
		//Label 4
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label4)).getText();
		softly.assertThat(s5).as("test data").contains("发现时间");
		c.add(s5);
		//Label 5
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label5)).getText();
		softly.assertThat(s6).as("test data").contains("发现人员");
		c.add(s6);
		//Label 6
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label6)).getText();
		softly.assertThat(s7).as("test data").contains("故障的时间（如已知）");
		c.add(s7);
		//Label 7
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label7)).getText();
		softly.assertThat(s8).as("test data").contains("调查启动的时间");
		c.add(s8);
		//Label 8
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label8)).getText();
		softly.assertThat(s9).as("test data").contains("调查人员的姓名");
		c.add(s9);
		//Label 9
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label9)).getText();
		softly.assertThat(s10).as("test data").contains("审查人员的姓名");
		c.add(s10);
		//Label 10
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label10)).getText();
		softly.assertThat(s11).as("test data").contains("管理发起人的姓名");
		c.add(s11);
		//Label 11
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label11)).getText();
		softly.assertThat(s12).as("test data").contains("问题陈述");
		c.add(s12);
		//Label 12
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label12)).getText();
		softly.assertThat(s13).as("test data").contains("接受调查的可疑故障部件");
		c.add(s13);
		//Label 13
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable1Label13)).getText();
		softly.assertThat(s14).as("test data").contains("报告建立时间");
		c.add(s14);
		return c;
	}

	public void chineseSavePopup (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Title of popup
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupHeader)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("保存报告");
		//Popup message title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("请确认你要存入现有报告进度?");
		//Confirm button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("保存报告");
		//Cancel button
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupCancelButton)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("取消");
	}

	public List<String> chineseHTMLPath2 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> c = new ArrayList<String>();
		//Table 1
		List<String> c1 = chineseHTMLTable1 (driver);
		c.addAll(c1);
		//Heading before Table 2
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Title)).getText();
		softly.assertThat(s1).as("test data").contains("事件原因");
		c.add(s1);
		//Table 2
		//Column 1 title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Column1Title)).getText();
		softly.assertThat(s2).as("test data").contains("根本原因");
		c.add(s2);
		//Column 2 title
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Column2Title)).getText();
		softly.assertThat(s3).as("test data").contains("纠正行动");
		c.add(s3);
		//Row 1 
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Row1Column1)).getText();
		softly.assertThat(s4).as("test data").contains("不适用");
		c.add(s4);
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable2Row1Column2)).getText();
		softly.assertThat(s5).as("test data").contains("不适用");
		//Table 3
		//Column 1 title
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Column1Title)).getText();
		softly.assertThat(s6).as("test data").contains("促成因素");
		c.add(s6);
		//Column 2 title
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Column2Title)).getText();
		softly.assertThat(s7).as("test data").contains("纠正行动");
		c.add(s7);
		//Row 1 
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Row1Column1)).getText();
		softly.assertThat(s8).as("test data").contains("不适用");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable3Row1Column2)).getText();
		softly.assertThat(s9).as("test data").contains("不适用");
		//Heading before Table 4
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Title)).getText();
		softly.assertThat(s10).as("test data").contains("第一步 - 失效设备与失效症状");
		c.add(s10);
		//Table 4
		//Column 1 title
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Column1Title)).getText();
		softly.assertThat(s11).as("test data").contains("问题");
		c.add(s11);
		//Column 2 title
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Column2Title)).getText();
		softly.assertThat(s12).as("test data").contains("答案");
		c.add(s12);
		//Row 1
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Row1Column1)).getText();
		softly.assertThat(s13).as("test data").contains("1.1: 这是故障排查还是根本原因分析？");
		c.add(s13);
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Row1Column2)).getText();
		softly.assertThat(s14).as("test data").contains("故障排查");
		c.add(s14);
		//Row 2
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Row2Column1)).getText();
		softly.assertThat(s15).as("test data").contains("1.2: 故障部件是什么？");
		c.add(s15);
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Row2Column2)).getText();
		softly.assertThat(s16).as("test data").contains("---- 其他电气与仪控相关部件");
		c.add(s16);
		//Row 3
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Row3Column1)).getText();
		softly.assertThat(s17).as("test data").contains("1.3: 故障部件的主要故障症状是什么？");
		c.add(s17);
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Row3Column2)).getText();
		softly.assertThat(s18).as("test data").contains("---- 其他机械相关失效症状 ----");
		c.add(s18);
		//Row 4
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Row4Column1)).getText();
		softly.assertThat(s19).as("test data").contains("1.4: 除了主要故障症状外，还观察到了哪些降级？（非必选）");
		c.add(s19);
		//Row 5
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Row5Column1)).getText();
		softly.assertThat(s20).as("test data").contains("1.5: 与主要故障症状巧合的异常现象有哪些？（非必选）");
		c.add(s20);
		//Row 6
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable4Row6Column1)).getText();
		softly.assertThat(s21).as("test data").contains("1.6: 与主要故障症状巧合的操作有哪些？（非必选）");
		c.add(s21);
		//Heading before Table 5
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.HTMLTable5Title)).getText();
		softly.assertThat(s22).as("test data").contains("第二步 - 可能的失效模式");
		c.add(s22);
		//Table 5
		//Column 1 title
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable5Column1Title)).getText();
		softly.assertThat(s23).as("test data").contains("失效模式");
		c.add(s23);
		//Column 2 title
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable5Column2Title)).getText();
		softly.assertThat(s24).as("test data").contains("描述");
		c.add(s24);
		//Row 1
		String s25 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable5Row1)).getText();
		softly.assertThat(s25).as("test data").contains("[排除]");
		c.add(s25);
		//Heading before Table 6
		String s26 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Title)).getText();
		softly.assertThat(s26).as("test data").contains("第三步 - 排除失效模式");
		c.add(s26);
		//Text before Table 6
		String s31 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6SubTitle1Part1)).getText();
		softly.assertThat(s31).as("test data").contains("失效模式:");
		c.add(s31);
		String s32 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6SubTitle1Part2)).getText();
		softly.assertThat(s32).as("test data").contains("[排除]");
		c.add(s32);
		String s33 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6SubTitle2)).getText();
		softly.assertThat(s33).as("test data").contains("失效模式描述:");
		c.add(s33);
		//Table 6
		//Column 1 title
		String s34 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Column1Title)).getText();
		softly.assertThat(s34).as("test data").contains("排除问题");
		c.add(s34);
		//Column 2 title
		String s35 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Column2Title)).getText();
		softly.assertThat(s35).as("test data").contains("答案");
		c.add(s35);
		//Column 3 title
		String s36 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Column3Title)).getText();
		softly.assertThat(s36).as("test data").contains("排除");
		c.add(s36);
		//Column 4 title
		String s37 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Column4Title)).getText();
		softly.assertThat(s37).as("test data").contains("原因");
		c.add(s37);
		//Row 1
		String s38 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row1Column1)).getText();
		softly.assertThat(s38).as("test data").contains("3.1: 该故障模式与观察到的症状无关");
		c.add(s38);
		String s44 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row1Column2)).getText();
		softly.assertThat(s44).as("test data").contains("是");
		c.add(s44);
		String s45 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row1Column3)).getText();
		softly.assertThat(s45).as("test data").contains("是");
		//Row 2
		String s39 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row2Column1)).getText();
		softly.assertThat(s39).as("test data").contains("3.2: 该故障模式没有导致观察到的主要症状");
		c.add(s39);
		String s46 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row2Column2)).getText();
		softly.assertThat(s46).as("test data").contains("是");
		String s47 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row2Column3)).getText();
		softly.assertThat(s47).as("test data").contains("是");
		//Row 3
		String s40 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row3Column1)).getText();
		softly.assertThat(s40).as("test data").contains("3.3: 该故障模式没有导致任何所述降级且异常情况纯属巧合");
		c.add(s40);
		String s48 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row3Column2)).getText();
		softly.assertThat(s48).as("test data").contains("是");
		String s49 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row3Column3)).getText();
		softly.assertThat(s49).as("test data").contains("是");
		//Row 4
		String s41 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row4Column1)).getText();
		softly.assertThat(s41).as("test data").contains("3.4: 该故障模式可以因为缺乏某一必要的故障触发因素而被排除");
		c.add(s41);
		String s50 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row4Column2)).getText();
		softly.assertThat(s50).as("test data").contains("是");
		String s51 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row4Column3)).getText();
		softly.assertThat(s51).as("test data").contains("是");
		//Row 5
		String s42 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row5Column1)).getText();
		softly.assertThat(s42).as("test data").contains("3.5: 该故障模式可以因为缺乏必要的环境来影响故障机理而被排除");
		c.add(s42);
		String s52 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row5Column2)).getText();
		softly.assertThat(s52).as("test data").contains("是");
		String s53 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row5Column3)).getText();
		softly.assertThat(s53).as("test data").contains("是");
		//Row 6
		String s43 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row6Column1)).getText();
		softly.assertThat(s43).as("test data").contains("3.6: 该故障可以因为缺乏某一必要的故障症状而被排除");
		c.add(s43);
		String s54 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row6Column2)).getText();
		softly.assertThat(s54).as("test data").contains("是");
		String s55 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLTable6Row6Column3)).getText();
		softly.assertThat(s55).as("test data").contains("是");
		//Skipped Step 4 message
		String s56 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLSkippedStep4MessagePart1)).getText();
		softly.assertThat(s56).as("test data").contains("第四步 - 发生概率和行动");
		c.add(s56);/*
		String s57 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLSkippedStep4MessagePart2)).getText();
		softly.assertThat(s57).as("test data").contains("未排除的失效模式是根据最高的可能性到最低可能性显示。");
		c.add(s57);*/
		//Skipped Step 5 message
		String s58 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLSkippedStep5Message)).getText();
		softly.assertThat(s58).as("test data").contains("第五步 - 识别可能的促成因素 (skipped)");
		c.add(s58);
		//Skipped Step 6 message
		String s59 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLSkippedStep6Message)).getText();
		softly.assertThat(s59).as("test data").contains("第六步 - 确定促成因素 (skipped)");
		c.add(s59);
		//Skipped Step 7 message
		String s60 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2HTMLSkippedStep7Message)).getText();
		softly.assertThat(s60).as("test data").contains("第七步 - 识别根本原因和制定纠正行动 (");
		c.add(s60);
		return c;
	}

	public void chineseReportTabPath3 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Table 1
		chineseReportTabTable1(driver);
		//Heading before Table 2
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Title)).getText();
		softly.assertThat(s1).as("test data").contains("事件原因");
		//Table 2
		//Column 1 title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Column1Title)).getText();
		softly.assertThat(s2).as("test data").contains("根本原因");
		//Column 2 title
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Column2Title)).getText();
		softly.assertThat(s3).as("test data").contains("纠正行动");
		//Row 1 
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Row1Column1)).getText();
		softly.assertThat(s4).as("test data").contains("失效模式");
		//Row 2
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Row2Column1)).getText();
		softly.assertThat(s5).as("test data").contains("导致故障的工作活动");
		//Table 3
		//Column 1 title
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Column1Title)).getText();
		softly.assertThat(s6).as("test data").contains("促成因素");
		//Column 2 title
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Column2Title)).getText();
		softly.assertThat(s7).as("test data").contains("纠正行动");
		//Row 1 
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Row1Column1)).getText();
		softly.assertThat(s8).as("test data").contains("失效模式");
		//Row 2
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Row2Column1)).getText();
		softly.assertThat(s11).as("test data").contains("不当的预防性维修计划");
		//Row 3 
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Row3Column1)).getText();
		softly.assertThat(s9).as("test data").contains("维修失误");
		//Row 4 
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Row4Column1)).getText();
		softly.assertThat(s12).as("test data").contains("运行失误");
		//Heading before Table 5
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable4Title)).getText();
		softly.assertThat(s14).as("test data").contains("第一步 - 失效设备与失效症状");
		//Table 4
		//Column 1 title
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable4Column1Title)).getText();
		softly.assertThat(s15).as("test data").contains("问题");
		//Column 2 title
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable4Column2Title)).getText();
		softly.assertThat(s16).as("test data").contains("答案");
		//Row 1
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable4Row1Column1)).getText();
		softly.assertThat(s17).as("test data").contains("1.1: 这是故障排查还是根本原因分析？");
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable4Row1Column2)).getText();
		softly.assertThat(s18).as("test data").contains("故障排查");
		//Row 2
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable4Row2Column1)).getText();
		softly.assertThat(s19).as("test data").contains("1.2: 故障部件是什么？");
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable4Row2Column2)).getText();
		softly.assertThat(s20).as("test data").contains("---- 其他电气与仪控相关部件");
		//Row 3
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable4Row3Column1)).getText();
		softly.assertThat(s21).as("test data").contains("1.3: 故障部件的主要故障症状是什么？");
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable4Row3Column2)).getText();
		softly.assertThat(s22).as("test data").contains("---- 其他机械相关失效症状 ----");
		//Row 4
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable4Row4Column1)).getText();
		softly.assertThat(s23).as("test data").contains("1.4: 除了主要故障症状外，还观察到了哪些降级？（非必选）");
		//Row 5
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable4Row5Column1)).getText();
		softly.assertThat(s24).as("test data").contains("1.5: 与主要故障症状巧合的异常现象有哪些？（非必选）");
		//Row 6
		String s25 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable4Row6Column1)).getText();
		softly.assertThat(s25).as("test data").contains("1.6: 与主要故障症状巧合的操作有哪些？（非必选）");
		//Heading before Table 5
		String s26 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable5Title)).getText();
		softly.assertThat(s26).as("test data").contains("第二步 - 可能的失效模式");
		//Table 5
		//Column 1 title
		String s27 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable5Column1Title)).getText();
		softly.assertThat(s27).as("test data").contains("失效模式");
		//Column 2 title
		String s28 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable5Column2Title)).getText();
		softly.assertThat(s28).as("test data").contains("描述");
		//Row 1
		//String s29 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable5Row1Column2)).getText();
		//softly.assertThat(s29).as("test data").contains("不适用");
		//Heading before Table 6
		String s30 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6Title)).getText();
		softly.assertThat(s30).as("test data").contains("第三步 - 排除失效模式");/*
		//Subtitle before Table 6
		String s31 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6SubTitle1)).getText();
		softly.assertThat(s31).as("test data").contains("1. 失效模式:");
		String s32 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6SubTitle2Part1)).getText();
		softly.assertThat(s32).as("test data").contains("失效模式描述:");
		String s33 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6SubTitle2Part2)).getText();
		softly.assertThat(s33).as("test data").contains("不适用");
		//Table 6
		//Column 1 title
		String s34 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6Column1Title)).getText();
		softly.assertThat(s34).as("test data").contains("排除问题");
		//Column 2 title
		String s35 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6Column2Title)).getText();
		softly.assertThat(s35).as("test data").contains("答案");
		//Column 3 title
		String s36 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6Column3Title)).getText();
		softly.assertThat(s36).as("test data").contains("排除");
		//Column 4 title
		String s37 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6Column4Title)).getText();
		softly.assertThat(s37).as("test data").contains("原因");
		//Row 1
		String s38 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6Row1)).getText();
		softly.assertThat(s38).as("test data").contains("3.1: 该故障模式与观察到的症状无关");
		//Row 2
		String s39 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6Row2)).getText();
		softly.assertThat(s39).as("test data").contains("3.2: 该故障模式没有导致观察到的主要症状");
		//Row 3
		String s40 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6Row3)).getText();
		softly.assertThat(s40).as("test data").contains("3.3: 该故障模式没有导致任何所述降级且异常情况纯属巧合");
		//Row 4
		String s41 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6Row4)).getText();
		softly.assertThat(s41).as("test data").contains("3.4: 该故障模式可以因为缺乏某一必要的故障触发因素而被排除");
		//Row 5
		String s42 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6Row5)).getText();
		softly.assertThat(s42).as("test data").contains("3.5: 该故障模式可以因为缺乏必要的环境来影响故障机理而被排除");
		//Row 6
		String s43 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable6Row6)).getText();
		softly.assertThat(s43).as("test data").contains("3.6: 该故障可以因为缺乏某一必要的故障症状而被排除");*/
		//Heading before Table 7
		String s44 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Title)).getText();
		softly.assertThat(s44).as("test data").contains("第四步 - 发生概率和行动");
		//Subtitle before Table 7
		String s45 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7SubTitle1)).getText();
		softly.assertThat(s45).as("test data").contains("未排除的失效模式是根据最高的可能性到最低可能性显示。");
		String s46 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7SubTitle2)).getText();
		softly.assertThat(s46).as("test data").contains("失效模式:");
		String s47 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7SubTitle3Part1)).getText();
		softly.assertThat(s47).as("test data").contains("失效模式描述:");
		//String s48 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7SubTitle3Part2)).getText();
		//softly.assertThat(s48).as("test data").contains("不适用");
		//Column 1 title
		String s49 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Column1Title)).getText();
		softly.assertThat(s49).as("test data").contains("问题");
		//Column 2 title
		String s50 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Column2Title)).getText();
		softly.assertThat(s50).as("test data").contains("答案");
		//Column 3 title
		String s51 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Column3Title)).getText();
		softly.assertThat(s51).as("test data").contains("信息");
		//Row 1
		String s52 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row1Column1)).getText();
		softly.assertThat(s52).as("test data").contains("4.1: 该故障模式是否曾在故障部件或其类似部件上发生过？");
		String s53 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row1Column2)).getText();
		softly.assertThat(s53).as("test data").contains("不适用");
		//Row 2
		String s54 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row2Column1)).getText();
		softly.assertThat(s54).as("test data").contains("4.2: 该故障模式是否与（1）松动螺栓，（2）泄漏 ，（3）腐蚀，（4）异物有关?");
		String s55 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row2Column2)).getText();
		softly.assertThat(s55).as("test data").contains("不适用");
		//Row 3
		String s56 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row3Column1)).getText();
		softly.assertThat(s56).as("test data").contains("4.3: 该故障模式是否存在支持性证据？");
		String s57 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row3Column2)).getText();
		softly.assertThat(s57).as("test data").contains("不适用");
		//Row 4
		String s58 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row4Column1)).getText();
		softly.assertThat(s58).as("test data").contains("4.4: 该故障模式是否与设计、运行或维修活动（活动后立即发生的）有关？");
		String s59 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row4Column2)).getText();
		softly.assertThat(s59).as("test data").contains("是");		
		//Row 5
		String s60 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row5Column1)).getText();
		softly.assertThat(s60).as("test data").contains("4.5: 该故障模式是否与老化有关且与老化超出预期寿命的故障子部件有关？");
		String s61 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row5Column2)).getText();
		softly.assertThat(s61).as("test data").contains("不适用");
		//Row 6
		String s62 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row6Column1)).getText();
		softly.assertThat(s62).as("test data").contains("4.6: 若子部件替换了是否可以修正失效模式？");
		String s63 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row6Column2)).getText();
		softly.assertThat(s63).as("test data").contains("不适用");
		//Row 6
		String s64 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row7Column1)).getText();
		softly.assertThat(s64).as("test data").contains("4.7: 能否获得更多的数据来排除该故障模式？");
		String s67 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable7Row7Column2)).getText();
		softly.assertThat(s67).as("test data").contains("不适用");
		//Title before Table 8
		String s68 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable8Title1)).getText();
		softly.assertThat(s68).as("test data").contains("第五步 - 识别可能的促成因素");
		String s69 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable8Title2)).getText();
		softly.assertThat(s69).as("test data").contains("失效模式:");
		String s70 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable8Title3Part1)).getText();
		softly.assertThat(s70).as("test data").contains("失效模式描述:");
		//String s71 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable8Title3Part2)).getText();
		//softly.assertThat(s71).as("test data").contains("不适用");
		//Table 8 for 5.1
		//Column 1 title
		String s72 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable8Column1Title)).getText();
		softly.assertThat(s72).as("test data").contains("设计变更");
		//Column 2 title
		String s73 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable8Column2Title)).getText();
		softly.assertThat(s73).as("test data").contains("描述");
		//Row 1
		String s86 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable8Row1)).getText();
		softly.assertThat(s86).as("test data").contains("5.1: 故障发生前的设计变更有哪些（如有的话）？若有多起相同故障，可往前追溯。");
		//Table 9 for 5.2
		//Column 1 title
		String s74 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable9Column1Title)).getText();
		softly.assertThat(s74).as("test data").contains("维护实践变更");
		//Column 2 title
		String s75 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable9Column2Title)).getText();
		softly.assertThat(s75).as("test data").contains("描述");
		//Row 1
		String s87 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable9Row1)).getText();
		softly.assertThat(s87).as("test data").contains("5.2: 故障发生前的维修实践变更有哪些（如有的话）？若有多起相同故障，可往前追溯。");
		//Table 10 for 5.3
		//Column 1 title
		String s76 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable10Column1Title)).getText();
		softly.assertThat(s76).as("test data").contains("运行实践变更");
		//Column 2 title
		String s77 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable10Column2Title)).getText();
		softly.assertThat(s77).as("test data").contains("描述");
		//Row 1
		String s88 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable10Row1)).getText();
		softly.assertThat(s88).as("test data").contains("5.3: 故障发生前的运行实践变更有哪些（如有的话）？若有多起相同故障，可往前追溯。");
		//Table 11 for 5.4
		//Column 1 title
		String s78 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable11Column1Title)).getText();
		softly.assertThat(s78).as("test data").contains("新子部件安装");
		//Column 2 title
		String s79 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable11Column2Title)).getText();
		softly.assertThat(s79).as("test data").contains("描述");
		//Row 1
		String s89 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable11Row1)).getText();
		softly.assertThat(s89).as("test data").contains("5.4: 故障发生之前故障部件上安装的新子部件有哪些（如有的话）？若有多起相同故障，可往前追溯。");
		//Table 12 for 5.5
		//Column 1 title
		String s80 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable12Column1Title)).getText();
		softly.assertThat(s80).as("test data").contains("问题");
		//Column 2 title
		String s81 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable12Column2Title)).getText();
		softly.assertThat(s81).as("test data").contains("答案");
		//Column 3 title
		String s82 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable12Column3Title)).getText();
		softly.assertThat(s82).as("test data").contains("描述");
		//Row 1
		String s90 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable12Row1Column1Part1)).getText();
		softly.assertThat(s90).as("test data").contains("5.5: 故障部件在操作运行上有没有超出供应商建议的运行限值？");
		String s91 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable12Row1Column1Part2)).getText();
		softly.assertThat(s91).as("test data").contains("(如为“是”，请描述运行条件，为期时间与厂家限值)");
		String s92 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable12Row1Column2)).getText();
		softly.assertThat(s92).as("test data").contains("是");
		//Table 13 for 5.6 	
		//Column 1 title
		String s83 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable13Column1Title)).getText();
		softly.assertThat(s83).as("test data").contains("问题");
		//Column 2 title
		String s84 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable13Column2Title)).getText();
		softly.assertThat(s84).as("test data").contains("答案");
		//Column 3 title
		String s85 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable13Column3Title)).getText();
		softly.assertThat(s85).as("test data").contains("描述");
		//Row 1
		String s93 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable13Row1Column1Part1)).getText();
		softly.assertThat(s93).as("test data").contains("5.6: 故障部件（或子部件）的使用年限有没有超过MTBF（平均故障间隔时间）寿命的两倍？");
		String s94 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable13Row1Column1Part2)).getText();
		softly.assertThat(s94).as("test data").contains("(如为“是”，请描述故障部件和可疑子部件的预期寿命（MTBF）和实际使用年限)");
		String s95 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable13Row1Column2)).getText();
		softly.assertThat(s95).as("test data").contains("是");
		//Heading before Table 14
		String s96 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Title1)).getText();
		softly.assertThat(s96).as("test data").contains("第六步 - 确定促成因素");
		String s97 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Title2)).getText();
		softly.assertThat(s97).as("test data").contains("失效模式:");
		String s98 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Title3Part1)).getText();
		softly.assertThat(s98).as("test data").contains("失效模式描述:");
		//String s99 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Title3Part2)).getText();
		//softly.assertThat(s99).as("test data").contains("不适用");
		//Column 1 title
		String s100 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Column1Title)).getText();
		softly.assertThat(s100).as("test data").contains("问题");
		//Column 2 title
		String s101 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Column2Title)).getText();
		softly.assertThat(s101).as("test data").contains("答案");
		//Column 3 title
		String s102 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Column3Title)).getText();
		softly.assertThat(s102).as("test data").contains("促成因素");
		//Row 1
		String s103 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row1)).getText();
		softly.assertThat(s103).as("test data").contains("6.1: 任何所述的设计变更（如有）是否可能导致该未被排除的故障模式？");
		//Row 2
		String s104 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row2)).getText();
		softly.assertThat(s104).as("test data").contains("6.2: 任何所述的维修实践变更（如有）是否可能导致该未被排除的故障模式？");
		//Row 3
		String s105 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row3)).getText();
		softly.assertThat(s105).as("test data").contains("6.3: 任何所述的运行实践变更（如有）是否可能导致该未被排除的故障模式？");
		//Row 4
		String s106 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row4)).getText();
		softly.assertThat(s106).as("test data").contains("6.4: 任何所述的新安装子部件是否可能导致该未被排除的故障模式？");
		//Row 5
		String s107 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row5Column1Part1)).getText();
		softly.assertThat(s107).as("test data").contains("6.5: 故障部件附近是否有任何工作活动（如有）可能导致该未被排除的故障模式？");
		String s108 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row5Column1Part2)).getText();
		softly.assertThat(s108).as("test data").contains("(如为“是”，请描述导致故障的工作活动)");
		String s109 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row5Column2)).getText();
		softly.assertThat(s109).as("test data").contains("是");
		//Row 6
		String s110 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row6Column1)).getText();
		softly.assertThat(s110).as("test data").contains("6.6: 不当的预防性维修计划是否可能导致该未被排除的故障模式？");
		String s111 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row6Column2)).getText();
		softly.assertThat(s111).as("test data").contains("是");
		String s112 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row6Column3)).getText();
		softly.assertThat(s112).as("test data").contains("不当的预防性维修计划为促成因素");
		//Row 7
		String s113 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row7Column1)).getText();
		softly.assertThat(s113).as("test data").contains("6.7: 新安装子部件的安装失误是否可能导致未被排除的故障模式？");
		String s114 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row7Column2)).getText();
		softly.assertThat(s114).as("test data").contains("是");
		String s115 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row7Column3)).getText();
		softly.assertThat(s115).as("test data").contains("维修失误为促成因素");
		//Row 8
		String s116 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row8Column1)).getText();
		softly.assertThat(s116).as("test data").contains("6.8: 运行失误是否可能导致该未被排除的故障模式？");
		String s117 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row8Column2)).getText();
		softly.assertThat(s117).as("test data").contains("是");
		String s118 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable14Row8Column3)).getText();
		softly.assertThat(s118).as("test data").contains("运行失误为促成因素");
		//SUEP title before table 15
		String s119 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15SUEPTitle)).getText();
		softly.assertThat(s119).as("test data").contains("第七步 - 识别根本原因和制定纠正行动 (");
		String s120 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15SUEP_S)).getText();
		softly.assertThat(s120).as("test data").contains("是否存在不合标准的实践");
		String s121 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15SUEP_U)).getText();
		softly.assertThat(s121).as("test data").contains("是否在管理层控制下");
		String s122 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15SUEP_E)).getText();
		softly.assertThat(s122).as("test data").contains("是否在事件时序早期");
		String s123 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15SUEP_P)).getText();
		softly.assertThat(s123).as("test data").contains("是否防止再次发生");
		String s124 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15Column1Title)).getText();
		softly.assertThat(s124).as("test data").contains("促成因素");
		String s125 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15Column6Title)).getText();
		softly.assertThat(s125).as("test data").contains("纠正行动");
		//Row 1
		String s126 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15Row1)).getText();
		softly.assertThat(s126).as("test data").contains("失效模式");
		//Row 2
		String s127 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15Row2Column1)).getText();
		softly.assertThat(s127).as("test data").contains("导致故障的工作活动");
		String s128 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15Row2Column2)).getText();
		softly.assertThat(s128).as("test data").contains("是");
		String s129 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15Row2Column3)).getText();
		softly.assertThat(s129).as("test data").contains("是");
		String s130 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15Row2Column4)).getText();
		softly.assertThat(s130).as("test data").contains("是");
		String s131 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15Row2Column5)).getText();
		softly.assertThat(s131).as("test data").contains("是");
		//Row 3
		String s132 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15Row3)).getText();
		softly.assertThat(s132).as("test data").contains("不当的预防性维修计划");
		//Row 4
		String s133 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15Row4)).getText();
		softly.assertThat(s133).as("test data").contains("维修失误");
		//Row 5   	
		String s134 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path3ReportTabTable15Row5)).getText();
		softly.assertThat(s134).as("test data").contains("运行失误");
	}

	public void chineseReportTabPath2 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Table 1
		chineseReportTabTable1(driver);
		//Heading before Table 2
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Title)).getText();
		softly.assertThat(s1).as("test data").contains("事件原因");
		//Table 2
		//Column 1 title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Column1Title)).getText();
		softly.assertThat(s2).as("test data").contains("根本原因");
		//Column 2 title
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Column2Title)).getText();
		softly.assertThat(s3).as("test data").contains("纠正行动");
		//Row 1 
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Row1Column1)).getText();
		softly.assertThat(s4).as("test data").contains("不适用");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Row1Column2)).getText();
		softly.assertThat(s5).as("test data").contains("不适用");
		//Table 3
		//Column 1 title
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Column1Title)).getText();
		softly.assertThat(s6).as("test data").contains("促成因素");
		//Column 2 title
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Column2Title)).getText();
		softly.assertThat(s7).as("test data").contains("纠正行动");
		//Row 1 
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Row1Column1)).getText();
		softly.assertThat(s8).as("test data").contains("不适用");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Row1Column2)).getText();
		softly.assertThat(s9).as("test data").contains("不适用");
		//Heading before Table 4
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Title)).getText();
		softly.assertThat(s10).as("test data").contains("第一步 - 失效设备与失效症状");
		//Table 4
		//Column 1 title
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Column1Title)).getText();
		softly.assertThat(s11).as("test data").contains("问题");
		//Column 2 title
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Column2Title)).getText();
		softly.assertThat(s12).as("test data").contains("答案");
		//Row 1
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Row1Column1)).getText();
		softly.assertThat(s13).as("test data").contains("1.1: 这是故障排查还是根本原因分析？");
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Row1Column2)).getText();
		softly.assertThat(s14).as("test data").contains("故障排查");
		//Row 2
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Row2Column1)).getText();
		softly.assertThat(s15).as("test data").contains("1.2: 故障部件是什么？");
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Row2Column2)).getText();
		softly.assertThat(s16).as("test data").contains("---- 其他电气与仪控相关部件");
		//Row 3
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Row3Column1)).getText();
		softly.assertThat(s17).as("test data").contains("1.3: 故障部件的主要故障症状是什么？");
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Row3Column2)).getText();
		softly.assertThat(s18).as("test data").contains("---- 其他机械相关失效症状 ----");
		//Row 4
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Row4Column1)).getText();
		softly.assertThat(s19).as("test data").contains("1.4: 除了主要故障症状外，还观察到了哪些降级？（非必选）");
		//Row 5
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Row5Column1)).getText();
		softly.assertThat(s20).as("test data").contains("1.5: 与主要故障症状巧合的异常现象有哪些？（非必选）");
		//Row 6
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Row6Column1)).getText();
		softly.assertThat(s21).as("test data").contains("1.6: 与主要故障症状巧合的操作有哪些？（非必选）");
		//Heading before Table 5
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Title)).getText();
		softly.assertThat(s22).as("test data").contains("第二步 - 可能的失效模式");
		//Table 5
		//Column 1 title
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable5Column1Title)).getText();
		softly.assertThat(s23).as("test data").contains("失效模式");
		//Column 2 title
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable5Column2Title)).getText();
		softly.assertThat(s24).as("test data").contains("描述");
		//Row 1
		String s25 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable5Row1)).getText();
		softly.assertThat(s25).as("test data").contains("[排除]");
		//Heading before Table 6
		String s26 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Title)).getText();
		softly.assertThat(s26).as("test data").contains("第三步 - 排除失效模式");
		//Text before Table 6
		String s31 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6SubTitle1Part1)).getText();
		softly.assertThat(s31).as("test data").contains("失效模式:");
		String s32 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6SubTitle1Part2)).getText();
		softly.assertThat(s32).as("test data").contains("[排除]");
		String s33 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6SubTitle2)).getText();
		softly.assertThat(s33).as("test data").contains("失效模式描述:");
		//Table 6
		//Column 1 title
		String s34 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Column1Title)).getText();
		softly.assertThat(s34).as("test data").contains("排除问题");
		//Column 2 title
		String s35 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Column2Title)).getText();
		softly.assertThat(s35).as("test data").contains("答案");
		//Column 3 title
		String s36 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Column3Title)).getText();
		softly.assertThat(s36).as("test data").contains("排除");
		//Column 4 title
		String s37 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Column4Title)).getText();
		softly.assertThat(s37).as("test data").contains("原因");
		//Row 1
		String s38 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row1Column1)).getText();
		softly.assertThat(s38).as("test data").contains("3.1: 该故障模式与观察到的症状无关");
		String s44 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row1Column2)).getText();
		softly.assertThat(s44).as("test data").contains("是");
		String s45 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row1Column3)).getText();
		softly.assertThat(s45).as("test data").contains("是");
		//Row 2
		String s39 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row2Column1)).getText();
		softly.assertThat(s39).as("test data").contains("3.2: 该故障模式没有导致观察到的主要症状");
		String s46 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row2Column2)).getText();
		softly.assertThat(s46).as("test data").contains("是");
		String s47 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row2Column3)).getText();
		softly.assertThat(s47).as("test data").contains("是");
		//Row 3
		String s40 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row3Column1)).getText();
		softly.assertThat(s40).as("test data").contains("3.3: 该故障模式没有导致任何所述降级且异常情况纯属巧合");
		String s48 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row3Column2)).getText();
		softly.assertThat(s48).as("test data").contains("是");
		String s49 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row3Column3)).getText();
		softly.assertThat(s49).as("test data").contains("是");
		//Row 4
		String s41 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row4Column1)).getText();
		softly.assertThat(s41).as("test data").contains("3.4: 该故障模式可以因为缺乏某一必要的故障触发因素而被排除");
		String s50 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row4Column2)).getText();
		softly.assertThat(s50).as("test data").contains("是");
		String s51 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row4Column3)).getText();
		softly.assertThat(s51).as("test data").contains("是");
		//Row 5
		String s42 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row5Column1)).getText();
		softly.assertThat(s42).as("test data").contains("3.5: 该故障模式可以因为缺乏必要的环境来影响故障机理而被排除");
		String s52 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row5Column2)).getText();
		softly.assertThat(s52).as("test data").contains("是");
		String s53 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row5Column3)).getText();
		softly.assertThat(s53).as("test data").contains("是");
		//Row 6
		String s43 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row6Column1)).getText();
		softly.assertThat(s43).as("test data").contains("3.6: 该故障可以因为缺乏某一必要的故障症状而被排除");
		String s54 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row6Column2)).getText();
		softly.assertThat(s54).as("test data").contains("是");
		String s55 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabTable6Row6Column3)).getText();
		softly.assertThat(s55).as("test data").contains("是");
		//Skipped Step 4 message
		String s56 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabSkippedStep4MessagePart1)).getText();
		softly.assertThat(s56).as("test data").contains("第四步 - 发生概率和行动");/*
		String s57 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabSkippedStep4MessagePart2)).getText();
		softly.assertThat(s57).as("test data").contains("未排除的失效模式是根据最高的可能性到最低可能性显示。");*/
		//Skipped Step 5 message
		String s58 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabSkippedStep5Message)).getText();
		softly.assertThat(s58).as("test data").contains("第五步 - 识别可能的促成因素 (skipped)");
		//Skipped Step 6 message
		String s59 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabSkippedStep6Message)).getText();
		softly.assertThat(s59).as("test data").contains("第六步 - 确定促成因素 (skipped)");
		//Skipped Step 7 message
		String s60 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Path2ReportTabSkippedStep7Message)).getText();
		softly.assertThat(s60).as("test data").contains("第七步 - 识别根本原因和制定纠正行动 (");
	}

	public void chineseReportTab (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		ccf.verifyChineseButtonsReportTabEiRCA(driver, softly);
		//Table 1
		chineseReportTabTable1(driver);
		//Heading before Table 2
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Title)).getText();
		softly.assertThat(s1).as("test data").contains("事件原因");
		//Table 2
		//Column 1 title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Column1Title)).getText();
		softly.assertThat(s2).as("test data").contains("根本原因");
		//Column 2 title
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Column2Title)).getText();
		softly.assertThat(s3).as("test data").contains("纠正行动");
		//Row 1 
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Row1Column1)).getText();
		softly.assertThat(s4).as("test data").contains("不适用");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable2Row1Column2)).getText();
		softly.assertThat(s5).as("test data").contains("不适用");
		//Table 3
		//Column 1 title
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Column1Title)).getText();
		softly.assertThat(s6).as("test data").contains("促成因素");
		//Column 2 title
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Column2Title)).getText();
		softly.assertThat(s7).as("test data").contains("纠正行动");
		//Row 1 
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Row1Column1)).getText();
		softly.assertThat(s8).as("test data").contains("不适用");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable3Row1Column2)).getText();
		softly.assertThat(s9).as("test data").contains("不适用");
		//Heading before Table 4
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Title)).getText();
		softly.assertThat(s10).as("test data").contains("事件时序");
		//Table 4
		//Column 1 title
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Column1Title)).getText();
		softly.assertThat(s11).as("test data").contains("日期, 时间");
		//Column 2 title
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Column2Title)).getText();
		softly.assertThat(s12).as("test data").contains("发生了什么事？");
		//Column 3 title
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable4Column3Title)).getText();
		softly.assertThat(s13).as("test data").contains("应该发生什么事？");
		//Heading before Table 5
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Title)).getText();
		softly.assertThat(s14).as("test data").contains("第一步 - 失效设备与失效症状");
		//Table 5
		//Column 1 title
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Column1Title)).getText();
		softly.assertThat(s15).as("test data").contains("问题");
		//Column 2 title
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Column2Title)).getText();
		softly.assertThat(s16).as("test data").contains("答案");
		//Row 1
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Row1Column1)).getText();
		softly.assertThat(s17).as("test data").contains("1.1: 这是故障排查还是根本原因分析？");
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Row1Column2)).getText();
		softly.assertThat(s18).as("test data").contains("故障排查");
		//Row 2
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Row2Column1)).getText();
		softly.assertThat(s19).as("test data").contains("1.2: 故障部件是什么？");
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Row2Column2)).getText();
		softly.assertThat(s20).as("test data").contains("---- 其他电气与仪控相关部件");
		//Row 3
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Row3Column1)).getText();
		softly.assertThat(s21).as("test data").contains("1.3: 故障部件的主要故障症状是什么？");
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Row3Column2)).getText();
		softly.assertThat(s22).as("test data").contains("---- 其他机械相关失效症状 ----");
		//Row 4
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Row4Column1)).getText();
		softly.assertThat(s23).as("test data").contains("1.4: 除了主要故障症状外，还观察到了哪些降级？（非必选）");
		//Row 5
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Row5Column1)).getText();
		softly.assertThat(s24).as("test data").contains("1.5: 与主要故障症状巧合的异常现象有哪些？（非必选）");
		//Row 6
		String s25 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable5Row6Column1)).getText();
		softly.assertThat(s25).as("test data").contains("1.6: 与主要故障症状巧合的操作有哪些？（非必选）");
		//Heading before Table 6
		String s26 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable6Title)).getText();
		softly.assertThat(s26).as("test data").contains("第二步 - 可能的失效模式");
		//Table 6
		//Column 1 title
		String s27 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable6Column1Title)).getText();
		softly.assertThat(s27).as("test data").contains("失效模式");
		//Column 2 title
		String s28 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable6Column2Title)).getText();
		softly.assertThat(s28).as("test data").contains("描述");
		//Row 1
		//String s29 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable6Row1Column2)).getText();
		//softly.assertThat(s29).as("test data").contains("不适用");
		//Heading before Table 7
		String s30 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabSkippedStep3Message)).getText();
		softly.assertThat(s30).as("test data").contains("第三步 - 排除失效模式");/*
		//Subtitle before Table 7
		String s31 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7SubTitle1)).getText();
		softly.assertThat(s31).as("test data").contains("1. 失效模式:");
		String s32 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7SubTitle2Part1)).getText();
		softly.assertThat(s32).as("test data").contains("失效模式描述:");
		String s33 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7SubTitle2Part2)).getText();
		softly.assertThat(s33).as("test data").contains("不适用");
		//Table 7
		//Column 1 title
		String s34 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7Column1Title)).getText();
		softly.assertThat(s34).as("test data").contains("排除问题");
		//Column 2 title
		String s35 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7Column2Title)).getText();
		softly.assertThat(s35).as("test data").contains("答案");
		//Column 3 title
		String s36 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7Column3Title)).getText();
		softly.assertThat(s36).as("test data").contains("排除");
		//Column 4 title
		String s37 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7Column4Title)).getText();
		softly.assertThat(s37).as("test data").contains("原因");
		//Row 1
		String s38 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7Row1)).getText();
		softly.assertThat(s38).as("test data").contains("3.1: 该故障模式与观察到的症状无关");
		//Row 2
		String s39 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7Row2)).getText();
		softly.assertThat(s39).as("test data").contains("3.2: 该故障模式没有导致观察到的主要症状");
		//Row 3
		String s40 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7Row3)).getText();
		softly.assertThat(s40).as("test data").contains("3.3: 该故障模式没有导致任何所述降级且异常情况纯属巧合");
		//Row 4
		String s41 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7Row4)).getText();
		softly.assertThat(s41).as("test data").contains("3.4: 该故障模式可以因为缺乏某一必要的故障触发因素而被排除");
		//Row 5
		String s42 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7Row5)).getText();
		softly.assertThat(s42).as("test data").contains("3.5: 该故障模式可以因为缺乏必要的环境来影响故障机理而被排除");
		//Row 6
		String s43 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable7Row6)).getText();
		softly.assertThat(s43).as("test data").contains("3.6: 该故障可以因为缺乏某一必要的故障症状而被排除");*/
		//Heading before Table 8
		String s44 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabSkippedStep4Message)).getText();
		softly.assertThat(s44).as("test data").contains("第四步 - 发生概率和行动");/*
		//Subtitle before Table 8
		String s45 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8SubTitle1)).getText();
		softly.assertThat(s45).as("test data").contains("未排除的失效模式是根据最高的可能性到最低可能性显示。");
		String s46 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8SubTitle2)).getText();
		softly.assertThat(s46).as("test data").contains("失效模式:");
		String s47 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8SubTitle3Part1)).getText();
		softly.assertThat(s47).as("test data").contains("失效模式描述:");
		String s48 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8SubTitle3Part2)).getText();
		softly.assertThat(s48).as("test data").contains("不适用");
		//Column 1 title
		String s49 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Column1Title)).getText();
		softly.assertThat(s49).as("test data").contains("问题");
		//Column 2 title
		String s50 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Column2Title)).getText();
		softly.assertThat(s50).as("test data").contains("答案");
		//Column 3 title
		String s51 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Column3Title)).getText();
		softly.assertThat(s51).as("test data").contains("信息");
		//Row 1
		String s52 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row1Column1)).getText();
		softly.assertThat(s52).as("test data").contains("4.1: 该故障模式是否曾在故障部件或其类似部件上发生过？");
		String s53 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row1Column2)).getText();
		softly.assertThat(s53).as("test data").contains("不适用");
		//Row 2
		String s54 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row2Column1)).getText();
		softly.assertThat(s54).as("test data").contains("4.2: 该故障模式是否与（1）松动螺栓，（2）泄漏 ，（3）腐蚀，（4）异物有关?");
		String s55 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row2Column2)).getText();
		softly.assertThat(s55).as("test data").contains("不适用");
		//Row 3
		String s56 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row3Column1)).getText();
		softly.assertThat(s56).as("test data").contains("4.3: 该故障模式是否存在支持性证据？");
		String s57 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row3Column2)).getText();
		softly.assertThat(s57).as("test data").contains("不适用");
		//Row 4
		String s58 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row4Column1)).getText();
		softly.assertThat(s58).as("test data").contains("4.4: 该故障模式是否与设计、运行或维修活动（活动后立即发生的）有关？");
		String s59 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row4Column2)).getText();
		softly.assertThat(s59).as("test data").contains("不适用");
		//Row 5
		String s60 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row5Column1)).getText();
		softly.assertThat(s60).as("test data").contains("4.5: 该故障模式是否与老化有关且与老化超出预期寿命的故障子部件有关？");
		String s61 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row5Column2)).getText();
		softly.assertThat(s61).as("test data").contains("不适用");
		//Row 6
		String s62 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row6Column1)).getText();
		softly.assertThat(s62).as("test data").contains("4.6: 若子部件替换了是否可以修正失效模式？");
		String s63 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row6Column2)).getText();
		softly.assertThat(s63).as("test data").contains("不适用");
		//Row 6
		String s64 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row7Column1)).getText();
		softly.assertThat(s64).as("test data").contains("4.7: 能否获得更多的数据来排除该故障模式？");
		String s65 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable8Row7Column2)).getText();
		softly.assertThat(s65).as("test data").contains("不适用");*/
		//Skipped Step 5 message
		String s66 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabSkippedStep5Message)).getText();
		softly.assertThat(s66).as("test data").contains("第五步 - 识别可能的促成因素 (skipped)");
		//Skipped Step 6 message
		String s67 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabSkippedStep6Message)).getText();
		softly.assertThat(s67).as("test data").contains("第六步 - 确定促成因素 (skipped)");
		//Skipped Step 7 message
		String s68 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabSkippedStep7Message)).getText();
		softly.assertThat(s68).as("test data").contains("第七步 - 识别根本原因和制定纠正行动 (");
		//Last Table
		//Heading
		String s69 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable9Heading)).getText();
		softly.assertThat(s69).as("test data").contains("签字");
		//Row1column1
		String s70 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable9Row1Column1)).getText();
		softly.assertThat(s70).as("test data").contains("编写:");
		//Row1column2
		String s71 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable9Row1Column2)).getText();
		softly.assertThat(s71).as("test data").contains("日期:");
		//Row2column1
		String s72 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable9Row2Column1)).getText();
		softly.assertThat(s72).as("test data").contains("审查:");
		//Row2column2
		String s73 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable9Row2Column2)).getText();
		softly.assertThat(s73).as("test data").contains("日期:");
		//Row3column1
		String s74 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable9Row3Column1)).getText();
		softly.assertThat(s74).as("test data").contains("批准:");
		//Row3column2
		String s75 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable9Row3Column2)).getText();
		softly.assertThat(s75).as("test data").contains("日期:");
	}

	public void chineseReportTabTable1 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Heading
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Title)).getText();
		softly.assertThat(s1).as("test data").contains("事件信息");
		//Label 1
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label1)).getText();
		softly.assertThat(s2).as("test data").contains("事件名称");
		//Label 2
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label2)).getText();
		softly.assertThat(s3).as("test data").contains("事件编号代码");
		//Label 3
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label3)).getText();
		softly.assertThat(s4).as("test data").contains("事件地点");
		//Label 4
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label4)).getText();
		softly.assertThat(s5).as("test data").contains("发现时间");
		//Label 5
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label5)).getText();
		softly.assertThat(s6).as("test data").contains("发现人员");
		//Label 6
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label6)).getText();
		softly.assertThat(s7).as("test data").contains("故障的时间（如已知）");
		//Label 7
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label7)).getText();
		softly.assertThat(s8).as("test data").contains("调查启动的时间");
		//Label 8
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label8)).getText();
		softly.assertThat(s9).as("test data").contains("调查人员的姓名");
		//Label 9
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label9)).getText();
		softly.assertThat(s10).as("test data").contains("审查人员的姓名");
		//Label 10
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label10)).getText();
		softly.assertThat(s11).as("test data").contains("管理发起人的姓名");
		//Label 11
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label11)).getText();
		softly.assertThat(s12).as("test data").contains("问题陈述");
		//Label 12
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label12)).getText();
		softly.assertThat(s13).as("test data").contains("接受调查的可疑故障部件");
		//Label 13
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.ReportTabTable1Label13)).getText();
		softly.assertThat(s14).as("test data").contains("报告建立时间");
	}

	public void chineseStep7SUEP (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify title
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7Title)).getText();
		softly.assertThat(s1).as("test data").contains("第七步 - 识别根本原因和制定纠正行动 (");
		//Text under title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7TextUnderTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("根本原因为满足SUEP四个条件。选择全符合以下条件:");
		//SUEP
		//S
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEP_S)).getText();
		softly.assertThat(s).as("test data").contains("是否存在不合标准的实践");
		//U
		String u = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEP_U)).getText();
		softly.assertThat(u).as("test data").contains("是否在管理层控制下");
		//E
		String e = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEP_E)).getText();
		softly.assertThat(e).as("test data").contains("是否在事件时序早期");
		//P
		String p = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7SUEP_P)).getText();
		softly.assertThat(p).as("test data").contains("是否防止再次发生");
		//Text above table
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step7TextAboveTable)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("勾选答案为“是”的选项。若答案为否或不适用勿勾选。");
	}

	public void chineseStep6 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify title
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6Title)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("第六步 - 确定促成因素");
		//Text under title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TextUnderTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("展开以选择并确定促成因素：");
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6FailureCollapsible)).click();
		//Title under collapsible
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TitleUnderCollapsible)).getText();
		softly.assertThat(s3).as("test data").contains("失效模式描述:");
		//Text under title of collapsible
		//String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TextUnderTitleUnderCollapsible)).getText();
		//softly.assertThat(s4).as("test data").isEqualTo("不适用");
		//Table column1 title
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableColumn1Title)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("问题");
		//Table column2 title
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableColumn2Title)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("是?");
		//Table column3 title
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableColumn3Title)).getText();
		softly.assertThat(s7).as("test data").contains("促成因素");
		//Table option 6.1
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption61)).getText();
		softly.assertThat(s8).as("test data").contains("6.1: 任何所述的设计变更（如有）是否可能导致该未被排除的故障模式？");    	
		//Table option 6.2
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption62)).getText();
		softly.assertThat(s9).as("test data").contains("6.2: 任何所述的维修实践变更（如有）是否可能导致该未被排除的故障模式？");
		//Table option 6.3
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption63)).getText();
		softly.assertThat(s10).as("test data").contains("6.3: 任何所述的运行实践变更（如有）是否可能导致该未被排除的故障模式？");
		//Table option 6.4
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption64)).getText();
		softly.assertThat(s11).as("test data").contains("6.4: 任何所述的新安装子部件是否可能导致该未被排除的故障模式？");
		//Table option 6.5
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption65Part1)).getText();
		softly.assertThat(s12).as("test data").contains("6.5: 故障部件附近是否有任何工作活动（如有）可能导致该未被排除的故障模式？");
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption65Part2)).getText();
		softly.assertThat(s13).as("test data").contains("(如为“是”，请描述导致故障的工作活动)");
		//Table option 6.6
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption66)).getText();
		softly.assertThat(s14).as("test data").contains("6.6: 不当的预防性维修计划是否可能导致该未被排除的故障模式？");
		//Table option 6.7
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption67)).getText();
		softly.assertThat(s15).as("test data").contains("6.7: 新安装子部件的安装失误是否可能导致未被排除的故障模式？");
		//Table option 6.8
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step6TableOption68)).getText();
		softly.assertThat(s16).as("test data").contains("6.8: 运行失误是否可能导致该未被排除的故障模式？");
	}

	public void chineseStep5 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify title
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Title)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("第五步 - 识别可能的促成因素");
		//Text under title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5TextUnderTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("展开以进行促成因素的分析：");
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5FailureCollapsible)).click();
		//Title under collapsible
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5TitleUnderCollapsible)).getText();
		softly.assertThat(s3).as("test data").contains("失效模式描述:");
		//Text under title of collapsible
		//String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5TextUnderTitleUnderCollapsible)).getText();
		//softly.assertThat(s4).as("test data").isEqualTo("不适用");
		//Table 1 
		//5.1
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table1Option51)).getText();
		softly.assertThat(s5).as("test data").contains("5.1: 故障发生前的设计变更有哪些（如有的话）？若有多起相同故障，可往前追溯。");    	
		//Table 2
		//Heading for table under 5.1
		//Column 1
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table2Under51Column1Title)).getText();
		softly.assertThat(s6).as("test data").contains("设计变更 (必填)");    
		//Column 2
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table2Under51Column2Title)).getText();
		softly.assertThat(s7).as("test data").contains("输入相关信息 (非必填)"); 
		//Textbox 1
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table2Under51Textbox1)).getAttribute("placeholder");
		softly.assertThat(s8).as("test data").contains("输入设计变更(必填)");    
		//Textbox 2
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table2Under51Textbox2)).getAttribute("placeholder");
		softly.assertThat(s9).as("test data").contains("输入描述(非必填)");    
		//Add contributing factor
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table2Under51AddContributingFactorButton)).getText();
		softly.assertThat(s10).as("test data").contains("新增设计变更"); 
		//Table 3
		//5.2
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table3Option52)).getText();
		softly.assertThat(s11).as("test data").contains("5.2: 故障发生前的维修实践变更有哪些（如有的话）？若有多起相同故障，可往前追溯。");    
		//Table 4
		//Heading for table under 5.2
		//Column 1
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table4Under52Column1Title)).getText();
		softly.assertThat(s12).as("test data").contains("维护实践变更 (必填)");    
		//Column 2
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table4Under52Column2Title)).getText();
		softly.assertThat(s13).as("test data").contains("输入相关信息 (非必填)"); 
		//Textbox 1
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table4Under52Textbox1)).getAttribute("placeholder");
		softly.assertThat(s14).as("test data").contains("输入维护实践变更(必填)");    
		//Textbox 2
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table4Under52Textbox2)).getAttribute("placeholder");
		softly.assertThat(s15).as("test data").contains("输入描述(非必填)");    
		//Add contributing factor
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table4Under52AddContributingFactorButton)).getText();
		softly.assertThat(s16).as("test data").contains("新增维护实践变更"); 
		//Table 5
		//5.3
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table5Option53)).getText();
		softly.assertThat(s17).as("test data").contains("5.3: 故障发生前的运行实践变更有哪些（如有的话）？若有多起相同故障，可往前追溯。");    
		//Table 6
		//Heading for table under 5.3
		//Column 1
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table6Under53Column1Title)).getText();
		softly.assertThat(s18).as("test data").contains("运行实践变更 (必填)");    
		//Column 2
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table6Under53Column2Title)).getText();
		softly.assertThat(s19).as("test data").contains("输入相关信息 (非必填)"); 
		//Textbox 1
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table6Under53Textbox1)).getAttribute("placeholder");
		softly.assertThat(s20).as("test data").contains("输入运行实践变更(必填)");    
		//Textbox 2
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table6Under53Textbox2)).getAttribute("placeholder");
		softly.assertThat(s21).as("test data").contains("输入描述(非必填)");    
		//Add contributing factor
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table6Under53AddContributingFactorButton)).getText();
		softly.assertThat(s22).as("test data").contains("新增运行实践变更"); 
		//Table 7
		//5.4
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table7Option54)).getText();
		softly.assertThat(s23).as("test data").contains("5.4: 故障发生之前故障部件上安装的新子部件有哪些（如有的话）？若有多起相同故障，可往前追溯。");    
		//Table 8
		//Heading for table under 5.4
		//Column 1
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table8Under54Column1Title)).getText();
		softly.assertThat(s24).as("test data").contains("新子部件安装 (必填)");    
		//Column 2
		String s25 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table8Under54Column2Title)).getText();
		softly.assertThat(s25).as("test data").contains("输入相关信息 (非必填)"); 
		//Textbox 1
		String s26 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table8Under54Textbox1)).getAttribute("placeholder");
		softly.assertThat(s26).as("test data").contains("输入新子部件安装(必填)");    
		//Textbox 2
		String s27 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table8Under54Textbox2)).getAttribute("placeholder");
		softly.assertThat(s27).as("test data").contains("输入描述(非必填)");    
		//Add contributing factor
		String s28 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table8Under54AddContributingFactorButton)).getText();
		softly.assertThat(s28).as("test data").contains("新增新子部件安装"); 
		//Table 9
		//Table column1 title
		String s29 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table9Column1Title)).getText();
		softly.assertThat(s29).as("test data").isEqualTo("问题");
		//Table column2 title
		String s30 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table9Column2Title)).getText();
		softly.assertThat(s30).as("test data").isEqualTo("是?");
		//Table column3 title
		String s31 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table9Column3TitlePart1)).getText();
		softly.assertThat(s31).as("test data").contains("输入相关信息");
		String s32 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table9Column3TitlePart2)).getText();
		softly.assertThat(s32).as("test data").contains("(非必填)");
		//Table option 5.5
		String s33 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table9Option55Part1)).getText();
		softly.assertThat(s33).as("test data").contains("5.5: 故障部件在操作运行上有没有超出供应商建议的运行限值？");    	
		String s34 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table9Option55Part2)).getText();
		softly.assertThat(s34).as("test data").contains("(如为“是”，请描述运行条件，为期时间与厂家限值)");  
		//Table option 5.6
		String s35 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table9Option56Part1)).getText();
		softly.assertThat(s35).as("test data").contains("5.6: 故障部件（或子部件）的使用年限有没有超过MTBF（平均故障间隔时间）寿命的两倍？");    	
		String s36 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step5Table9Option56Part2)).getText();
		softly.assertThat(s36).as("test data").contains("(如为“是”，请描述故障部件和可疑子部件的预期寿命（MTBF）和实际使用年限)");  
	}

	public void chinesePopupAfterStep4 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Title of popup
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupHeader)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("完成故障排除?");
		//Popup message title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("你要完成故障排除直接列印报告吗？");
		//Confirm button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("进行RCA");
		//Cancel button
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupCancelButton)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("报告");
	}

	public void chineseStep4 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify title
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step4Title)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("第四步 - 发生概率和行动");
		//Text under title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step4TextUnderTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("展开以分析每个失效模式的发生概率：");
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step4FailureCollapsible)).click();
		//Title under collapsible
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step4TitleUnderCollapsible)).getText();
		softly.assertThat(s3).as("test data").contains("失效模式描述:");
		//Text under title of collapsible
		//String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step4TextUnderTitleUnderCollapsible)).getText();
		//softly.assertThat(s4).as("test data").isEqualTo("不适用");
		//Table column1 title
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step4TableColumn1Title)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("问题");
		//Table column2 title
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step4TableColumn2Title)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("是?");
		//Table column3 title
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step4TableColumn3TitlePart1)).getText();
		softly.assertThat(s7).as("test data").contains("输入相关信息");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step4TableColumn3TitlePart2)).getText();
		softly.assertThat(s8).as("test data").contains("(非必填)");
		//Table option 4.4
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step4TableOption44Part1)).getText();
		softly.assertThat(s9).as("test data").contains("4.4: 该故障模式是否与设计、运行或维修活动（活动后立即发生的）有关？");    	
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step4TableOption44Part2)).getText();
		softly.assertThat(s10).as("test data").contains("(如为“是”，描述活动。)");  
	}

	public void chineseStep3 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify title
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3Title)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("第三步 - 排除失效模式");
		//Text under title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TextUnderTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("展开每个失效模式进行排除：");
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3FailureCollapsible)).click();
		//Title under collapsible
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TitleUnderCollapsible)).getText();
		softly.assertThat(s3).as("test data").contains("失效模式描述:");
		//Text under title of collapsible
		//String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TextUnderTitleUnderCollapsible)).getText();
		//softly.assertThat(s4).as("test data").isEqualTo("不适用");
		//Title of Table under collapsible
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableTitleUnderCollapsible)).getText();
		softly.assertThat(s5).as("test data").contains("勾选答案为“是”的选项。若答案为否或不适用勿勾选。");
		//Table column1 title
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableColumn1Title)).getText();
		softly.assertThat(s6).as("test data").contains("排除的原因");
		//Table column2 title
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableColumn2Title)).getText();
		softly.assertThat(s7).as("test data").contains("是?");
		//Table column3 title
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableColumn3Title)).getText();
		softly.assertThat(s8).as("test data").contains("排除");
		//Table column4 title
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableColumn4TitlePart1)).getText();
		softly.assertThat(s9).as("test data").contains("原因");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableColumn4TitlePart2)).getText();
		softly.assertThat(s10).as("test data").contains("(非必填)");
		//Table option 3.1
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption31)).getText();
		softly.assertThat(s11).as("test data").contains("3.1: 该故障模式与观察到的症状无关");    	
		//Table option 3.2
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption32)).getText();
		softly.assertThat(s12).as("test data").contains("3.2: 该故障模式没有导致观察到的主要症状");
		//Table option 3.3
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption33)).getText();
		softly.assertThat(s13).as("test data").contains("3.3: 该故障模式没有导致任何所述降级且异常情况纯属巧合");
		//Table option 3.4
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption34)).getText();
		softly.assertThat(s14).as("test data").contains("3.4: 该故障模式可以因为缺乏某一必要的故障触发因素而被排除");
		//Table option 3.5
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption35)).getText();
		softly.assertThat(s15).as("test data").contains("3.5: 该故障模式可以因为缺乏必要的环境来影响故障机理而被排除");
		//Table option 3.6
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step3TableOption36)).getText();
		softly.assertThat(s16).as("test data").contains("3.6: 该故障可以因为缺乏某一必要的故障症状而被排除");
	}

	public void chineseStep2 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify title
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step2Title)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("第二步 - 可能的失效模式");
		//Text under title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step2TextUnderTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("输入所有可能的失效模式进行分析：");
		//title for first text box
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step2Row11stTextBoxTitle)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("失效模式 (必填):");
		//title for 2nd text box
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step2Row12ndTextBoxTitle)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("描述 (非必填):");
		//Add failure button
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step2AddFailureButton)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("新增失效模式");
		//Click on add failure mode button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step2AddFailureButton)).click();
		Thread.sleep(1000);
		//Title of popup
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupHeader)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("新增失效模式");
		//Popup message title
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupTitle)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("请使用已存在模版。");
		//Popup message
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopUpMessageNote)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("注意：需填入失效模式才能进行下一步分析。");
		//Click on ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAPopupConfirmButton)).click();
		//Fill text in 1st box 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step2Row11stTextBoxField)).sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step2Row12ndTextBoxField)).sendKeys(text);
		//Click on add failure mode button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step2AddFailureButton)).click();
		//title for first text box
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step2Row21stTextBoxTitle)).getText();
		softly.assertThat(s9).as("test data").isEqualTo("失效模式:");
		//title for 2nd text box
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step2Row22ndTextBoxTitle)).getText();
		softly.assertThat(s10).as("test data").isEqualTo("描述 (非必填):");
	}

	public void selectAnswersStep1 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Select answer for q1.1
		WebElement dropdown = driver.findElement(eircaObj.Step1Q11Answer);
		Select s = new Select(dropdown);
		s.selectByVisibleText("故障排查");
		//Select answer for q1.2 that brings up text box
		WebElement dropdown1 = driver.findElement(eircaObj.Step1Q12Answer);
		Select s1 = new Select(dropdown1);
		s1.selectByVisibleText("---- 其他电气与仪控相关部件");
		//Verify placeholder of text box
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step1Q12AnswerTextBox)).getAttribute("placeholder");
		softly.assertThat(r1).as("test data").isEqualTo("输入其他的选项（非必选）");
		//Select answer for q1.3 that brings up text box
		WebElement dropdown2 = driver.findElement(eircaObj.Step1Q13Answer);
		Select s2 = new Select(dropdown2);
		s2.selectByVisibleText("---- 其他机械相关失效症状 ----");
		//Verify placeholder of text box
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step1Q13AnswerTextBox)).getAttribute("placeholder");
		softly.assertThat(r2).as("test data").isEqualTo("输入其他的选项（非必选）");
	}

	public void chineseStep1 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify title
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step1Title)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("第一步 - 失效设备与失效症状");
		//Text under title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step1TextUnderTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("问题1.1, 1.2, 1.3为必填.");
		//1.1 question
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step1Q11)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("1.1: 这是故障排查还是根本原因分析？");
		//Answers of 1.1
		chineseStep1Answers11(driver);
		//1.2 question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step1Q12)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("1.2: 故障部件是什么？");
		//Answers of 1.2
		chineseStep1Answers12(driver);
		//1.3 question
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step1Q13)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("1.3: 故障部件的主要故障症状是什么？");
		//Answers of 1.3
		chineseStep1Answers13(driver);
		//1.4 question
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step1Q14)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("1.4: 除了主要故障症状外，还观察到了哪些降级？（非必选）");
		//1.5 question
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step1Q15)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("1.5: 与主要故障症状巧合的异常现象有哪些？（非必选）");
		//1.6 question
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.Step1Q16)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("1.6: 与主要故障症状巧合的操作有哪些？（非必选）");
	}

	public void chineseStep1Answers13 (WebDriver driver) throws Exception {

		WebElement ele = driver.findElement(eircaObj.Step1Q13Answer);
		String s1 = ele.findElement(eircaObj.AnswerOptionNone).getText();
		softly.assertThat(s1).as("test data").isEqualTo("选择一个答案...");
		String s2 = ele.findElement(eircaObj.AnswerOption0).getText();
		softly.assertThat(s2).as("test data").isEqualTo("水锤");
		String s3 = ele.findElement(eircaObj.AnswerOption1).getText();
		softly.assertThat(s3).as("test data").isEqualTo("磨损");
		String s4 = ele.findElement(eircaObj.AnswerOption2).getText();
		softly.assertThat(s4).as("test data").isEqualTo("润滑");
		String s5 = ele.findElement(eircaObj.AnswerOption3).getText();
		softly.assertThat(s5).as("test data").isEqualTo("卡塞");
		String s6 = ele.findElement(eircaObj.AnswerOption4).getText();
		softly.assertThat(s6).as("test data").isEqualTo("过度接触力");
		String s7 = ele.findElement(eircaObj.AnswerOption5).getText();
		softly.assertThat(s7).as("test data").isEqualTo("韧性断裂或变形");
		String s8 = ele.findElement(eircaObj.AnswerOption6).getText();
		softly.assertThat(s8).as("test data").isEqualTo("脆性断裂");
		String s9 = ele.findElement(eircaObj.AnswerOption7).getText();
		softly.assertThat(s9).as("test data").isEqualTo("疲劳开裂");
		String s10 = ele.findElement(eircaObj.AnswerOption8).getText();
		softly.assertThat(s10).as("test data").isEqualTo("沉积物/异物");
		String s11 = ele.findElement(eircaObj.AnswerOption9).getText();
		softly.assertThat(s11).as("test data").isEqualTo("几何结构/配置变更");
		String s12 = ele.findElement(eircaObj.AnswerOption10).getText();
		softly.assertThat(s12).as("test data").isEqualTo("混凝土故障模式");
		String s13 = ele.findElement(eircaObj.AnswerOption11).getText();
		softly.assertThat(s13).as("test data").isEqualTo("火灾（爆炸）");
		String s14 = ele.findElement(eircaObj.AnswerOption12).getText();
		softly.assertThat(s14).as("test data").isEqualTo("生物淤积");
		String s15 = ele.findElement(eircaObj.AnswerOption13).getText();
		softly.assertThat(s15).as("test data").isEqualTo("金属铸造");
		String s16 = ele.findElement(eircaObj.AnswerOption14).getText();
		softly.assertThat(s16).as("test data").isEqualTo("振动");
		String s17 = ele.findElement(eircaObj.AnswerOption15).getText();
		softly.assertThat(s17).as("test data").isEqualTo("腐蚀/侵蚀");
		String s18 = ele.findElement(eircaObj.AnswerOption16).getText();
		softly.assertThat(s18).as("test data").isEqualTo("---- 其他机械相关失效症状 ----");
		String s19 = ele.findElement(eircaObj.AnswerOption17).getText();
		softly.assertThat(s19).as("test data").isEqualTo("无法启动");
		String s20 = ele.findElement(eircaObj.AnswerOption18).getText();
		softly.assertThat(s20).as("test data").isEqualTo("无法根据要求启动和跳停");
		String s21 = ele.findElement(eircaObj.AnswerOption19).getText();
		softly.assertThat(s21).as("test data").isEqualTo("闭锁");
		String s22 = ele.findElement(eircaObj.AnswerOption20).getText();
		softly.assertThat(s22).as("test data").isEqualTo("振动或疲劳开裂");
		String s23 = ele.findElement(eircaObj.AnswerOption21).getText();
		softly.assertThat(s23).as("test data").isEqualTo("尺寸变形");
		String s24 = ele.findElement(eircaObj.AnswerOption22).getText();
		softly.assertThat(s24).as("test data").isEqualTo("污染/碎片");
		String s25 = ele.findElement(eircaObj.AnswerOption23).getText();
		softly.assertThat(s25).as("test data").isEqualTo("间歇性故障（卡固和释放）");
		String s26 = ele.findElement(eircaObj.AnswerOption24).getText();
		softly.assertThat(s26).as("test data").isEqualTo("间歇性故障（电气噪音、干扰）");
		String s27 = ele.findElement(eircaObj.AnswerOption25).getText();
		softly.assertThat(s27).as("test data").isEqualTo("电弧作用");
		String s28 = ele.findElement(eircaObj.AnswerOption26).getText();
		softly.assertThat(s28).as("test data").isEqualTo("异常信号（电压/电流）输出");
		String s29 = ele.findElement(eircaObj.AnswerOption27).getText();
		softly.assertThat(s29).as("test data").isEqualTo("过热或火灾");
		String s30 = ele.findElement(eircaObj.AnswerOption28).getText();
		softly.assertThat(s30).as("test data").isEqualTo("爆炸");
		String s31 = ele.findElement(eircaObj.AnswerOption29).getText();
		softly.assertThat(s31).as("test data").isEqualTo("开路故障");
		String s32 = ele.findElement(eircaObj.AnswerOption30).getText();
		softly.assertThat(s32).as("test data").isEqualTo("短路故障");
		String s33 = ele.findElement(eircaObj.AnswerOption31).getText();
		softly.assertThat(s33).as("test data").isEqualTo("老化");
		String s34 = ele.findElement(eircaObj.AnswerOption32).getText();
		softly.assertThat(s34).as("test data").isEqualTo("---- 其他电气与仪控相关失效症状 ----");
	}

	public void chineseStep1Answers12 (WebDriver driver) throws Exception {

		WebElement ele = driver.findElement(eircaObj.Step1Q12Answer);
		String s1 = ele.findElement(eircaObj.AnswerOptionNone).getText();
		softly.assertThat(s1).as("test data").isEqualTo("选择一个答案...");
		String s2 = ele.findElement(eircaObj.AnswerOption0).getText();
		softly.assertThat(s2).as("test data").isEqualTo("接头（螺栓，法兰）");
		String s3 = ele.findElement(eircaObj.AnswerOption1).getText();
		softly.assertThat(s3).as("test data").isEqualTo("轴承（轴颈轴承、滚珠轴承、止推轴承）");
		String s4 = ele.findElement(eircaObj.AnswerOption2).getText();
		softly.assertThat(s4).as("test data").isEqualTo("泵（卧式泵、立式泵）");
		String s5 = ele.findElement(eircaObj.AnswerOption3).getText();
		softly.assertThat(s5).as("test data").isEqualTo("止回阀（摆动式止回阀、蝶式止回阀）");
		String s6 = ele.findElement(eircaObj.AnswerOption4).getText();
		softly.assertThat(s6).as("test data").isEqualTo("闸阀");
		String s7 = ele.findElement(eircaObj.AnswerOption5).getText();
		softly.assertThat(s7).as("test data").isEqualTo("截止阀");
		String s8 = ele.findElement(eircaObj.AnswerOption6).getText();
		softly.assertThat(s8).as("test data").isEqualTo("安全卸压阀");
		String s9 = ele.findElement(eircaObj.AnswerOption7).getText();
		softly.assertThat(s9).as("test data").isEqualTo("阀操纵器（液压、气动和电动）");
		String s10 = ele.findElement(eircaObj.AnswerOption8).getText();
		softly.assertThat(s10).as("test data").isEqualTo("汽轮机");
		String s11 = ele.findElement(eircaObj.AnswerOption9).getText();
		softly.assertThat(s11).as("test data").isEqualTo("柴油机");
		String s12 = ele.findElement(eircaObj.AnswerOption10).getText();
		softly.assertThat(s12).as("test data").isEqualTo("热交换器（给水加热器、凝汽器、蒸汽发生器）");
		String s13 = ele.findElement(eircaObj.AnswerOption11).getText();
		softly.assertThat(s13).as("test data").isEqualTo("管道/支架/排水");
		String s14 = ele.findElement(eircaObj.AnswerOption12).getText();
		softly.assertThat(s14).as("test data").isEqualTo("焊接");
		String s15 = ele.findElement(eircaObj.AnswerOption13).getText();
		softly.assertThat(s15).as("test data").isEqualTo("---- 其他机械相关部件");
		String s16 = ele.findElement(eircaObj.AnswerOption14).getText();
		softly.assertThat(s16).as("test data").isEqualTo("控制系统");
		String s17 = ele.findElement(eircaObj.AnswerOption15).getText();
		softly.assertThat(s17).as("test data").isEqualTo("电源");
		String s18 = ele.findElement(eircaObj.AnswerOption16).getText();
		softly.assertThat(s18).as("test data").isEqualTo("逆变器");
		String s19 = ele.findElement(eircaObj.AnswerOption17).getText();
		softly.assertThat(s19).as("test data").isEqualTo("开关/接触器");
		String s20 = ele.findElement(eircaObj.AnswerOption18).getText();
		softly.assertThat(s20).as("test data").isEqualTo("继电器（线性继电器、旋转继电器、延时继电器）");
		String s21 = ele.findElement(eircaObj.AnswerOption19).getText();
		softly.assertThat(s21).as("test data").isEqualTo("熔断器");
		String s22 = ele.findElement(eircaObj.AnswerOption20).getText();
		softly.assertThat(s22).as("test data").isEqualTo("电缆/连接/接地");
		String s23 = ele.findElement(eircaObj.AnswerOption21).getText();
		softly.assertThat(s23).as("test data").isEqualTo("电磁线圈");
		String s24 = ele.findElement(eircaObj.AnswerOption22).getText();
		softly.assertThat(s24).as("test data").isEqualTo("电路板（电容器、电阻器、晶体管、二极管）");
		String s25 = ele.findElement(eircaObj.AnswerOption23).getText();
		softly.assertThat(s25).as("test data").isEqualTo("微处理器");
		String s26 = ele.findElement(eircaObj.AnswerOption24).getText();
		softly.assertThat(s26).as("test data").isEqualTo("仪表（压力表、温度RDT、热电偶）");
		String s27 = ele.findElement(eircaObj.AnswerOption25).getText();
		softly.assertThat(s27).as("test data").isEqualTo("浪涌抑制器（电压浪涌、电流浪涌）");
		String s28 = ele.findElement(eircaObj.AnswerOption26).getText();
		softly.assertThat(s28).as("test data").isEqualTo("可编程逻辑控制器（PLC）");
		String s29 = ele.findElement(eircaObj.AnswerOption27).getText();
		softly.assertThat(s29).as("test data").isEqualTo("---- 其他电气与仪控相关部件");
	}

	public void chineseStep1Answers11 (WebDriver driver) throws Exception {

		WebElement ele = driver.findElement(eircaObj.Step1Q11Answer);
		String s1 = ele.findElement(eircaObj.AnswerOptionNone).getText();
		softly.assertThat(s1).as("test data").isEqualTo("选择一个答案...");
		String s2 = ele.findElement(eircaObj.AnswerOption0).getText();
		softly.assertThat(s2).as("test data").isEqualTo("故障排查");
		String s3 = ele.findElement(eircaObj.AnswerOption1).getText();
		softly.assertThat(s3).as("test data").isEqualTo("根本原因分析");
	}

	public void chineseVerifySequenceOfEventsTable (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify date box header
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.TableDateHeader)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("日期");
		//Verify time box header
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.TableTimeHeader)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("时间");
		//Verify What happened box header
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.TableWhatHappenedHeader)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("发生了什么事？");
		//Verify What is supposed to happen box header
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.TableWhatIsSupposedToHappenHeader)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("应该发生什么事？");
	}

	public void chineseSequenceOfEvents (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify Sequence of Events title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAInfoPageTitle)).getText();
		softly.assertThat(title).as("test data").contains("事件时序");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.DescriptionPlusSign)).click();
		//Verify description text
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.DescriptionText)).getText();
		softly.assertThat(s).as("test data").contains("事件时序为触发事件前后所发生的一系列事情。调查过程中需将时间点与所发生的事实原始呈现直到最后后果发生。将事件时序列出的目的为确认导致最后错误发生的触发事件。"
				+" "+ "将每一个节点所发生的事情加以描述且将其时间点列出。右栏描述应该发生什么事。这样可以协助识别异常节点在哪发生。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.DescriptionPlusSign)).click();
		//Verify date box header
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.DateHeader)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("日期:");
		//Verify time box header
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.TimeHeader)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("时间:");
		//Verify What happened box header
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.WhatHappenedHeader)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("发生了什么事？:");
		//Verify What is supposed to happen box header
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.WhatIsSupposedToHappenHeader)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("应该发生什么事？:");
		//Verify placeholder for What happened box
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.WhatHappenedField)).getAttribute("placeholder");
		softly.assertThat(s6).as("test data").isEqualTo("依时序描述事件前后所发生的事情。");
		//Verify placeholder for What is supposed to happen box
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.WhatIsSupposedToHappenField)).getAttribute("placeholder");
		softly.assertThat(s7).as("test data").isEqualTo("描述应该发生的情形。");
	}

	public void closeStickyPopup (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(1000);
		//Close any pop up on right top corner
		while(true)
		{
			try{
				if (driver.findElement(eircaObj.StickyNote).isDisplayed())
				{
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.StickyClose)).click();

				}}catch (NoSuchElementException e)
			{
					break;
			}
			catch( StaleElementReferenceException f)
			{

				break;
			}
			catch (org.openqa.selenium.TimeoutException u)
			{
				break;
			}
			catch (org.openqa.selenium.ElementNotInteractableException u)
			{
				break;
			}
			catch (org.openqa.selenium.JavascriptException t)
			{
				Thread.sleep(2000);
				break;
			}

		}
	}


	public void bugKALE1963 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Clicks on EiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCALink)).click();
		//Verifies the info page in English
		verifyEnglish(driver);
		Thread.sleep(2000);
		//Change language to Chinese
		hc.changeToChinese(driver);
		//Clicks on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.AnalysisLink)).click();
		//Clicks on EiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCALink)).click();
		//Verifies the info page in Chinese
		verifyChinese(driver);
		Thread.sleep(2000);
		//Change language to English
		hc.changeToEnglish(driver);
		//Clicks on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.AnalysisLink)).click();
		//Clicks on EiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCALink)).click();
		//Verifies the info page in English
		verifyEnglish(driver);
		Thread.sleep(2000);
		//Change language to Chinese
		hc.changeToChinese(driver);
	}

	public void verifyChinese (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(1000);
		//Check if title contains english EiRCA
		String eirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAInfoPageTitle)).getText();
		System.out.println(eirca_title);
		softly.assertThat(eirca_title).as("test data").contains(" - 启动调查与基本问题");
	}

	public void verifyEnglish (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(2000);
		//Check if title contains english EiRCA
		String eirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAInfoPageTitle)).getText();
		System.out.println(eirca_title);
		softly.assertThat(eirca_title).as("test data").contains(" - Report Initiation and General Questions");
	}

	public void chineseInfoPage (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Check if title contains english EiRCA
		String eirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAInfoPageTitle)).getText();
		softly.assertThat(eirca_title).as("test data").contains(" - 启动调查与基本问题");
		//EiRCA Description of page
		String eirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAInfoPageDesc)).getText();
		softly.assertThat(eirca_desc).as("test data").contains("填入事件基础信息：");
		//Event title label
		String eircaEventTitleLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventTitleLabel)).getText();
		softly.assertThat(eircaEventTitleLabel).as("test data").contains("事件名称:");
		//Event title field
		String eircaEventTitleField = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventTitleField)).getAttribute("placeholder");
		softly.assertThat(eircaEventTitleField).as("test data").contains("输入事件名称");
		//Event id label
		String eircaEventIdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventIdLabel)).getText();
		softly.assertThat(eircaEventIdLabel).as("test data").contains("事件编号代码:");
		//Event id field
		String eircaEventIdField = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventIdField)).getAttribute("placeholder");
		softly.assertThat(eircaEventIdField).as("test data").contains("输入事件编号代码 (非必填)");
		//Event location label
		String eircaEventLocLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventLocationLabel)).getText();
		softly.assertThat(eircaEventLocLabel).as("test data").contains("事件地点:");
		//Event location field
		String eircaEventLocField = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventLocationField)).getAttribute("placeholder");
		softly.assertThat(eircaEventLocField).as("test data").contains("输入事件地点");
		//Event Failure date label
		String eircaEventFailDateLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventFailureDateLabel)).getText();
		softly.assertThat(eircaEventFailDateLabel).as("test data").contains("故障的时间（如已知）:");
		//Event Problem Statement label
		String eircaEventpbLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventProblemStatementLabel)).getText();
		softly.assertThat(eircaEventpbLabel).as("test data").contains("问题陈述:");
		//Event Problem Statement field
		String eircaEventpbField = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventProblemStatementField)).getAttribute("placeholder");
		softly.assertThat(eircaEventpbField).as("test data").contains("输入问题陈述");
		//Event Component label
/*		String eircaEventcmpLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventComponentLabel)).getText();
		softly.assertThat(eircaEventcmpLabel).as("test data").contains("接受调查的可疑故障部件:");*/
		//Event Component field
/*		String eircaEventcmpField = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventComponentField)).getAttribute("placeholder");
		softly.assertThat(eircaEventcmpField).as("test data").contains("输入接受调查的可疑故障部件");*/
		//Event Discovery date label
		String eircaEventDiscDateLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventDiscoveryDateLabel)).getText();
		softly.assertThat(eircaEventDiscDateLabel).as("test data").contains("发现时间:");
		//Event Reporter label
		String eircaEventReporterLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventReporterLabel)).getText();
		softly.assertThat(eircaEventReporterLabel).as("test data").contains("发现人员:");
		//Event Reporter field
		String eircaEventReporterField = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventReporterField)).getAttribute("placeholder");
		softly.assertThat(eircaEventReporterField).as("test data").contains("输入发现人员");
		//Event Initiation date label
		String eircaEventIniDateLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventInitiatedDateLabel)).getText();
		softly.assertThat(eircaEventIniDateLabel).as("test data").contains("调查启动的时间:");
		//Event Investigator label
		String eircaEventInvestigatorLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventInvestigatorLabel)).getText();
		softly.assertThat(eircaEventInvestigatorLabel).as("test data").contains("调查人员的姓名:");
		//Event Investigator field
		String eircaEventInvestigatorField = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventInvestigatorField)).getAttribute("placeholder");
		softly.assertThat(eircaEventInvestigatorField).as("test data").contains("输入调查人员的姓名");
		//Event Reviewer label
		String eircaEventReviewerLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventReviewerLabel)).getText();
		softly.assertThat(eircaEventReviewerLabel).as("test data").contains("审查人员的姓名:");
		//Event Reviewer field
		String eircaEventReviewerField = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventReviewerField)).getAttribute("placeholder");
		softly.assertThat(eircaEventReviewerField).as("test data").contains("输入审查人员的姓名");
		//Event Sponsor label
		String eircaEventSponsorLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventSponsorLabel)).getText();
		softly.assertThat(eircaEventSponsorLabel).as("test data").contains("管理发起人的姓名:");
		//Event Sponsor field
		String eircaEventSponsorField = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventSponsorField)).getAttribute("placeholder");
		softly.assertThat(eircaEventSponsorField).as("test data").contains("输入管理发起人的姓名");
		//Event Report date label
		String eircaEventRepDateLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventReportDateLabel)).getText();
		softly.assertThat(eircaEventRepDateLabel).as("test data").contains("报告建立时间:");
	}


	public void chineseEventInfoFill (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.AnalysisLink)).click();
		//Clicks on EiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCALink)).click();
		Thread.sleep(2000);
		//Verify everything on Event Information page is in 
		chineseInfoPage(driver);
		ccf.verifyChineseTabsInsideEiRCA(driver, softly);
		ccf.verifyChineseButtonsInfoTabEiRCA(driver, softly);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventTitleField)).sendKeys(text);
		//Event id
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventIdField)).sendKeys(text);
		//Location of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventLocationField)).sendKeys(text);
		//Problem Statement
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventProblemStatementField)).sendKeys(text);
		//Component
//		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventComponentField)).sendKeys(text);
		//Reporter
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventReporterField)).sendKeys(text);
		//Investigators
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventInvestigatorField)).sendKeys(text);
		//Reviewer
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventReviewerField)).sendKeys(text);
		//Sponsor
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.EiRCAEventSponsorField)).sendKeys(text);
		share2.scrollToAPoint(driver, 1500);
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.NextButtonBottomOfInfoPage)).click();
		//Scroll top
		share2.scrollToTop(driver);	
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
