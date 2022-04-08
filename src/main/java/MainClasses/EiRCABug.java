import java.util.List;
import java.util.Random;

import kaleTestSoftware.EiRCA2;
import kaleTestSoftware.EiRCA3;
import kaleTestSoftware.EiRCAPageObj;
import kaleTestSoftware.ShareCheck2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EiRCABug {

	SoftAssertions softly = new SoftAssertions();

	EiRCA2 eirca2 = new EiRCA2();
	EiRCA3 eirca3 = new EiRCA3();
	ShareCheck2 share2 = new ShareCheck2();
	EiRCAPageObj eirca = new EiRCAPageObj();

	public String textFillBug = "EiRCA bug";

	public void EiRCAInfoPageFill(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventTitleField)).sendKeys(text);
		//Event id
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventIdField)).sendKeys(text);
		//Location of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventLocationField)).sendKeys(text);
		//Problem Statement
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventProblemStatementField)).sendKeys(text);
		//Component
//		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventComponentField)).sendKeys(text);
		//Reporter
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventReporterField)).sendKeys(text);
		//Investigators
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventInvestigatorField)).sendKeys(text);
		//Reviewer
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventReviewerField)).sendKeys(text);
		//Sponsor
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventSponsorField)).sendKeys(text);
		share2.scrollToAPoint(driver, 1500);
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NextButtonBottomOfInfoPage)).click();
		//Scroll top
		share2.scrollToTop(driver);	
	}

	public void addOneFailureModes(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Add 2 failure modes
		//Fill text in 1st box 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2Row11stTextBoxField)).sendKeys("EiRCA FM 1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2Row12ndTextBoxField)).click();
	}

	public void add2FailureModes(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Add 2 failure modes
		//Fill text in 1st box 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2Row11stTextBoxField)).sendKeys("EiRCA FM 1");
		//Click on add failure mode button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2AddFailureButton)).click();
		//Fill text in 2nd row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2Row21stTextBoxField)).sendKeys("EiRCA FM 2");
		Thread.sleep(1000);
	}

	public void EiRCABugKALE2157QAA624(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);				
		//Click next on sequence of events
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Fill step 1
		eirca2.EIRCAStep1Troubleshooting(driver, textFillBug, softly);
		//Select Troubleshooting
		WebElement dropdown1 = driver.findElement(eirca.Step1Q11Answer);
		Select s1 = new Select(dropdown1);
		s1.selectByIndex(1);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		add2FailureModes(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();		
		//Click on failure mode 1 collapsible in Step 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsible)).click();
		//Click on 3.1 for FM 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBox)).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Click on collapsible in Step 4
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)).click();
		//Click on 4.4 checkbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TableOption44CheckBox)).click();
		//Enter text
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeOption44Textbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeOption44Textbox)).sendKeys(textFillBug);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Click on continue
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		Thread.sleep(1000);
		//Click on Step 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep3Tab)).click();
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsible)).click();
		//Click on 3.1 for FM 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBox)).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify 4.4 is greyed out for FM 1
		//Click on collapsible for FM 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)).click();
		//Verify 4.4 text is greyed out
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode1Option44Row)).getAttribute("class").contains("ui-state-disabled")==false)
			softly.fail("Text for 4.4 is not greyed out FM 1");
		//Verify 4.4 check is not visible
		if(driver.findElement(eirca.Step4FailureMode1Option44CheckBox).isDisplayed()==true)
			softly.fail("Check box for 4.4 is visible for FM 1");
		//Verify 4.4 textbox is not visible
		if(driver.findElement(eirca.Step4FailureMode1Option44TextBox).isDisplayed()==true)
			softly.fail("Textbox for 4.4 is visible for FM 1");
		//Click on collapsible for FM 1
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)).click();
		Thread.sleep(500);
		//Click on collapsible for FM 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsibleFailureMode2)).click();
		Thread.sleep(500);
		//Verify 4.4 text is greyed out
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option44Row)).getAttribute("class").contains("ui-state-disabled")==false)
			softly.fail("Text for 4.4 is not greyed out FM 2");
		//Verify 4.4 check is not visible
		if(driver.findElement(eirca.Step4FailureMode2Option44CheckBox).isDisplayed()==true)
			softly.fail("Check box for 4.4 is visible for FM 2");
		//Verify 4.4 textbox is not visible
		if(driver.findElement(eirca.Step4FailureMode2Option44TextBox).isDisplayed()==true)
			softly.fail("Textbox for 4.4 is visible for FM 2");
		//Click on collapsible for FM 2
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsibleFailureMode2)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsibleFailureMode2)).click();
		//scroll up
		share2.scrollToTop(driver);
	}

	public void verifyReportTab(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Event title
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1EventTitle)).getText();
		String r3 = s4.replace("\u00AD", "");
		softly.assertThat(r3).as("test data").isEqualTo(text);
		//Location of event
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1LocationOfEvent)).getText();
		String r4 = s5.replace("\u00AD", "");
		softly.assertThat(r4).as("test data").isEqualTo(text);
		//Who discovered
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1WhoDiscovered)).getText();
		String r5 = s6.replace("\u00AD", "");
		softly.assertThat(r5).as("test data").isEqualTo(text);
		//Investigators
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1Investigators)).getText();
		String r6 = s7.replace("\u00AD", "");
		softly.assertThat(r6).as("test data").isEqualTo(text);
		//Reviewers
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1Reviewers)).getText();
		String r7 = s8.replace("\u00AD", "");
		softly.assertThat(r7).as("test data").isEqualTo(text);
		//Management sponsors
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1ManagementSponsors)).getText();
		String r8 = s9.replace("\u00AD", "");
		softly.assertThat(r8).as("test data").isEqualTo(text);
		//Problem Statement
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1ProblemStatement)).getText();
		String r9 = s10.replace("\u00AD", "");
		softly.assertThat(r9).as("test data").isEqualTo(text);
		//Suspected failed component
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabTable1SuspectedFailedComponent)).getText();
		String r10 = s11.replace("\u00AD", "");
		softly.assertThat(r10).as("test data").isEqualTo(text);
	}

	public void EiRCABugKALE2227QAA619(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NewButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		Thread.sleep(2000);
		//Fill info page and clicks next
		EiRCAInfoPageFill(driver, textFillBug);
		//Click next on sequence of events
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Fill Step 1
		eirca2.EIRCAStep1Troubleshooting(driver, textFillBug, softly);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Choose 1 or 0
		Random random = new Random();
		int n = random.nextInt(2);
		if(n==1)
			add2FailureModes(driver);
		else
			addOneFailureModes(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();		
		if(n==1)
		{
			//Click on collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsible)).click();
			//Click on 3.1 for FM 1
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBox)).click();
			//Click on collapsible 2
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsibleFailureMode2)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsibleFailureMode2)).click();
			//Click on 3.1 for FM 2
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBoxFM2)).click();
		}
		else
		{
			//Click on collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsible)).click();
			//Click on 3.1 for FM 1
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBox)).click();
		}
		//Click next
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();		
		//Click on see report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).click();
		//Verify the page is the Report tab
		verifyReportTab(driver,textFillBug);
	}

	public void EiRCABugKALE2119QAA655(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NewButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		Thread.sleep(2000);
		//Fill info page and clicks next
		EiRCAInfoPageFill(driver, textFillBug);
		//Scenario 1
		//Add event one with no time
		String dateExpected = eirca3.createEventNoTime(driver, textFillBug, softly);
		//Add time
		String timeExpected = eirca3.addTimeTo1stEvent(driver);
		//Add 2nd event
		List<String> dateTime = eirca2.createNewEvent(driver, textFillBug,softly);
		//Verify 1st and 2nd event date and time
		eirca3.verify1stEventTimeAndDate(driver, dateTime.get(0), dateTime.get(1), softly);
		eirca3.verify2ndEventTimeAndDate(driver, dateExpected, timeExpected, softly);		
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NewButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		Thread.sleep(2000);
		//Fill info page and clicks next
		EiRCAInfoPageFill(driver, textFillBug);
		//Scenario 2
		//Add 1st event
		eirca2.createNewEvent(driver, textFillBug,softly);
		//Change Event 1
		String timeChanged = eirca3.changeTime1stEvent(driver);
		String date = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date1stEvent)).getAttribute("value");
		//Add 2nd event
		dateTime.addAll(eirca2.createNewEvent(driver, textFillBug,softly));
		//Verify 1st and 2nd event date and time
		eirca3.verify1stEventTimeAndDate(driver, dateTime.get(2), dateTime.get(3), softly);
		eirca3.verify2ndEventTimeAndDate(driver, date, timeChanged, softly);
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NewButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		Thread.sleep(2000);
		//Fill info page and clicks next
		EiRCAInfoPageFill(driver, textFillBug);
		//Scenario 3
		//Add 2 events
		eirca2.createNewEvent(driver, textFillBug,softly);
		//Get date of 1st event
		String date1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date1stEvent)).getAttribute("value");
		eirca2.createNewEvent(driver, textFillBug,softly);
		//Get date of 1st event: the previous 1st event is now 2nd event
		String date2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date1stEvent)).getAttribute("value");
		eirca3.verifyOrderOfEvents(driver, softly,2);
		//Change date of 1st event to be future
		eirca3.changeDateFuture1stEvent(driver);
		//Get date of 1st event
		String date1Changed = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date1stEvent)).getAttribute("value");
		//Get date of 2nd event
		String date2Changed = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date2ndEvent)).getAttribute("value");
		eirca3.verifyOrderOfEvents(driver, softly,2);
		//Verify date changes
		System.out.println(date1+" "+date2);
		System.out.println(date1Changed+" "+date2Changed);
		softly.assertThat(date1).as("test data").isNotEqualTo(date2Changed);
		softly.assertThat(date2).as("test data").isNotEqualTo(date1Changed);
		softly.assertThat(date1).as("test data").isEqualTo(date1Changed);
	}

	public void EiRCABugPath(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.AnalysisLink)).click();
		//Clicks on EiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCALink)).click();
		Thread.sleep(2000);
		//Fill info page and clicks next
		EiRCAInfoPageFill(driver, textFillBug);
		//KALE 2157 or QAA 624 : 4.4 selection still visible when changing answer from 1 Unrefuted to 2 Unrefuted Failure Modes
		EiRCABugKALE2157QAA624(driver);
		//KALE 2227 or QAA 619 : Unrefute all failure modes in Step3 and click on see report> verify page navigated to is Report tab
		EiRCABugKALE2227QAA619(driver);
		//KALE 2119 or QAA 655: Verify the 1st row of Sequence of Events reflects date and time change
		EiRCABugKALE2119QAA655(driver);
	}	

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
