import java.util.ArrayList;
import java.util.List;

import kaleTestSoftware.*;
import kaleTestSoftware.ErrorMeter;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GroupModerator {

	ShareCheck share = new ShareCheck();
	Login login = new Login();
	LoginPageObj lpo = new LoginPageObj();
	ErrorMeter em = new ErrorMeter();
	HiRCALOPBug2 hirca = new HiRCALOPBug2();
	EiRCAPageObj eirca = new EiRCAPageObj();
	EiRCAV2 eircav2 =new EiRCAV2();
	OPiRCAPageObj opirca = new OPiRCAPageObj();
	PassReviewPageObj prObj = new PassReviewPageObj();
	JobObservation jo = new JobObservation();
	JobObservationObj joObj = new JobObservationObj();
	RemoteVerification3 rv3 = new RemoteVerification3();
	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheckPageObj shareObj = new ShareCheckPageObj();

	SoftAssertions softly = new SoftAssertions();

	public String text = "Group moderator test";
	public String textEiRCAv2 = "Sanity Test \"title\" Sanity";

	//Dev/asia/us
	public String username1 ="qaapaagroupauser1";
	public String username2 ="qaapaagroupauser2";
	public String username3 ="qaapaagroupauser3";
	public String username4 ="qaapaagroupbuser4";
	public String username5 ="qaapaagroupbuser5";
	public String username6 ="qaapaagroupcuser6";

	//Ie11
	//Dev/asia/us
	public String username1_ie11 ="qaapaagroupauser1_ie11";
	public String username2_ie11 ="qaapaagroupauser2_ie11";
	public String username3_ie11 ="qaapaagroupauser3_ie11";
	public String username4_ie11 ="qaapaagroupbuser4_ie11";
	public String username5_ie11 ="qaapaagroupbuser5_ie11";
	public String username6_ie11 ="qaapaagroupcuser6_ie11";

	public String password = "S2FsZWplbmtpbnNAMTIz";

	public String createEMReport(WebDriver driver, String username) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		share2.loadingServer(driver);
		//Clicks on SPV Error meter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em"))).click();
		share2.loadingServer(driver);
		//Select Purpose from dropdown
		WebElement element = driver.findElement(By.id("pii-epm-select-purpose"));
		Select s = new Select (element);
		s.selectByVisibleText("PJB");
		Thread.sleep(2000);
		//Select Job type
		element = driver.findElement(By.id("pii-epm-select-condition"));
		Select s1 = new Select (element);
		if((driver.getCurrentUrl().contains("kale."))||(driver.getCurrentUrl().contains("kaleasia")))
			s1.selectByVisibleText("Construction");
		else
			s1.selectByVisibleText("Analysis");
		Thread.sleep(2000);
		//Fills Job title
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(text);
		String ev1= driver.findElement(By.id("pii-epm-job-title")).getAttribute("value");
		if(ev1.equals(text)==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-job-title"))).sendKeys(text);
		Thread.sleep(2000);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-next"))).click();
		share2.loadingServer(driver);
		//Time tab: click 4 checkbox
		for(int i=1;i<5;i++)
		{
		WebElement timeCheckBox = driver.findElement(By.id("pii-epm-tab-t-q"+i+"-l"));
		jse.executeScript("arguments[0].scrollIntoView(true);",	timeCheckBox);
		jse.executeScript("arguments[0].click();", timeCheckBox);
		}
		//Time tab: select dropdown for 4 checkbox
		for(int i=1;i<5;i++)
		{
		WebElement timeDropDown = driver.findElement(By.id("pii-epm-tab-t-q"+i+"-spv"));
		jse.executeScript("arguments[0].scrollIntoView(true);",	timeDropDown);
		Select s0 = new Select(timeDropDown);
		s0.selectByVisibleText("SPV with an Existing, Adequate LOP");
		}
		//Time tab: fill in required textbox for 4 checkbox
		for(int i=1;i<5;i++)
		{
			jse.executeScript("arguments[0].scrollIntoView(true);",	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-em-sr-t"+i))));
			driver.findElement(By.id("pii-em-sr-t"+i)).sendKeys(text);
		}	
		//Time tab: fill in non-required 4 rows textarea for 4 checkbox
		for(int i=1;i<5;i++)
		{
			for(int j=1;j<5;j++)
			{
				WebElement e = driver.findElement(By.xpath("//textarea[@id='pii-epm-tab-t-q"+i+"-lop"+j+"']"));
				jse.executeScript("arguments[0].scrollIntoView(true);", e);
				e.sendKeys(text);
			}
		}
		share2.scrollToTop(driver);
		jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-next"))));
		for(int i=1;i<5;i++)
		{
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-btn-next"))));
			Thread.sleep(400);
		}
		/*
		for(int i=2;i<5;i++) {
			WebElement e = driver.findElement(By.id("pii-epm-tab-t-q["+i+"]-l"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", e);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-epm-tab-t-q["+i+"]-l"))).click();
		}*/
		
		//Save report
		return(em.saveReport(driver,username));
	}

	public String createHPIReport(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on HPI
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hpi"))).click();
		Thread.sleep(2000);
		//Select Purpose from dropdown
		WebElement element = driver.findElement(By.id("pii-hpi-select-purpose"));
		Select s = new Select (element);
		s.selectByVisibleText("PJB");
		Thread.sleep(2000);
		//Select Job type
		element = driver.findElement(By.id("pii-hpi-select-condition"));
		Select s1 = new Select (element);
		s1.selectByVisibleText("Analysis");
		Thread.sleep(2000);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-btn-next"))).click();
		Thread.sleep(2000);
		//Click on finalize
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-btn-done"))).click();
		Thread.sleep(2000);
		//Click on finalize and save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-hpi-dialog-confirmed"))).click(); 
		//Waits for the green popup on the right top corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Gets the name of the record created
		return(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li[2]/a"))).getText());
	}

	public String createEiRCAReport(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on EiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-eirca"))).click();
		Thread.sleep(1000);
		//Fills all mandatory fields
		driver.findElement(eirca.EiRCAEventTitleField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventLocationField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventReporterField).sendKeys(text); 
		driver.findElement(eirca.EiRCAEventInvestigatorField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventReviewerField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventSponsorField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventProblemStatementField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventSummary).sendKeys(text);
		String ev1 = driver.findElement(eirca.EiRCAEventTitleField).getAttribute("value");
		String ev2 = driver.findElement(eirca.EiRCAEventLocationField).getAttribute("value");
		String ev3 = driver.findElement(eirca.EiRCAEventReporterField).getAttribute("value");
		String ev4 = driver.findElement(eirca.EiRCAEventInvestigatorField).getAttribute("value");
		String ev5 = driver.findElement(eirca.EiRCAEventReviewerField).getAttribute("value");
		String ev6 = driver.findElement(eirca.EiRCAEventSponsorField).getAttribute("value");
		String ev7= driver.findElement(eirca.EiRCAEventProblemStatementField).getAttribute("value");
		String ev8= driver.findElement(eirca.EiRCAEventSummaryLabel).getAttribute("value");
		if ((ev1.equals(text)==false))
		{
			driver.findElement(eirca.EiRCAEventTitleField).clear();
			driver.findElement(eirca.EiRCAEventTitleField).sendKeys(text);
		}
		if ((ev2.equals(text)==false))
		{
			driver.findElement(eirca.EiRCAEventLocationField).clear();
			driver.findElement(eirca.EiRCAEventLocationField).sendKeys(text);
		}
		if ((ev3.equals(text)==false))
		{
			driver.findElement(eirca.EiRCAEventReporterField).clear();
			driver.findElement(eirca.EiRCAEventReporterField).sendKeys(text);
		}
		if ((ev4.equals(text)==false))
		{
			driver.findElement(eirca.EiRCAEventInvestigatorField).clear();
			driver.findElement(eirca.EiRCAEventInvestigatorField).sendKeys(text);
		}
		if ((ev5.equals(text)==false))
		{
			driver.findElement(eirca.EiRCAEventReviewerField).clear();
			driver.findElement(eirca.EiRCAEventReviewerField).sendKeys(text);
		}
		if ((ev6.equals(text)==false))
		{
			driver.findElement(eirca.EiRCAEventSponsorField).clear();
			driver.findElement(eirca.EiRCAEventSponsorField).sendKeys(text);
		}
		if ((ev7.equals(text)==false))
		{
			driver.findElement(eirca.EiRCAEventProblemStatementField).clear();
			driver.findElement(eirca.EiRCAEventProblemStatementField).sendKeys(text);
		}
		/*
		if ((ev8.equals(text)==false))
		{
			driver.findElement(eirca.EiRCAEventSummary).clear();
			driver.findElement(eirca.EiRCAEventSummary).sendKeys(text);
		}*/
		eircav2.EIRCAStep1Dropboxes(driver,textEiRCAv2,softly);
		
		//Clicks on Save button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)));
		jse.executeScript("arguments[0].click();", 	wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();
		share2.loadingServer(driver);
		//Clicks on Save Report button			  
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)));
		share2.loadingServer(driver);
		//Clicks on Saved activities button
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)));
		share2.loadingServer(driver);
		//side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();
		share2.loadingServer(driver);
		return(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).getText());
	}

	public String createOPiRCAReport(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on O&P IRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-opirca"))).click();
		//Fills the mandatory fields
		driver.findElement(opirca.OPiRCAEventTitleField).sendKeys(text);
		driver.findElement(opirca.OPiRCAEventLocationField).sendKeys(text);
		driver.findElement(opirca.OPiRCAProblemStatementField).sendKeys(text);
//		driver.findElement(opirca.OPiRCATimelineOfEventField).sendKeys(text);
		driver.findElement(opirca.OPiRCABackgroundInfoField).sendKeys(text);
		driver.findElement(opirca.OPiRCAInvestigatorsField).sendKeys(text);
		String ev1 = driver.findElement(opirca.OPiRCAEventTitleField).getAttribute("value");
		String ev2 = driver.findElement(opirca.OPiRCAEventLocationField).getAttribute("value");
		String ev3 = driver.findElement(opirca.OPiRCAProblemStatementField).getAttribute("value");
//		String ev4 = driver.findElement(opirca.OPiRCATimelineOfEventField).getAttribute("value");
		String ev5 = driver.findElement(opirca.OPiRCABackgroundInfoField).getAttribute("value");
		String ev6 = driver.findElement(opirca.OPiRCAInvestigatorsField).getAttribute("value");
		if ((ev1.equals(text)==false))
		{
			driver.findElement(opirca.OPiRCAEventTitleField).clear();
			driver.findElement(opirca.OPiRCAEventTitleField).sendKeys(text);
		}
		if ((ev2.equals(text)==false))
		{
			driver.findElement(opirca.OPiRCAEventLocationField).clear();
			driver.findElement(opirca.OPiRCAEventLocationField).sendKeys(text);
		}
		if ((ev3.equals(text)==false))
		{
			driver.findElement(opirca.OPiRCAProblemStatementField).clear();
			driver.findElement(opirca.OPiRCAProblemStatementField).sendKeys(text);
		}
/*		if ((ev4.equals(text)==false))
		{
			driver.findElement(opirca.OPiRCATimelineOfEventField).clear();
			driver.findElement(opirca.OPiRCATimelineOfEventField).sendKeys(text);
		}*/
		if ((ev5.equals(text)==false))
		{
			driver.findElement(opirca.OPiRCABackgroundInfoField).clear();
			driver.findElement(opirca.OPiRCABackgroundInfoField).sendKeys(text);
		}
		if ((ev6.equals(text)==false))
		{
			driver.findElement(opirca.OPiRCAInvestigatorsField).clear();
			driver.findElement(opirca.OPiRCAInvestigatorsField).sendKeys(text);
		}
		//Clicks on save button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveButton)));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveButton)).click();
		//Clicks on save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavePopupTitle));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveConfirmButton)));
		share2.loadingServer(driver);
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavedActivitiesButton)).click();
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Click on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASidePanel)).click();
		share2.loadingServer(driver);
		return(wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).getText());
	}

	public String createpassReviewReport(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on 3 Pass review
		wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.PassReviewLink)).click();
		Thread.sleep(2000);
		//Fills in mandatory details
		driver.findElement(prObj.Reviewer).sendKeys(text);
		driver.findElement(prObj.DocumentTitle).sendKeys(text);
		driver.findElement(prObj.Organisation).sendKeys(text);
		String ev1 = driver.findElement(prObj.Reviewer).getAttribute("value");
		String ev2 = driver.findElement(prObj.DocumentTitle).getAttribute("value");
		String ev3 = driver.findElement(prObj.Organisation).getAttribute("value");
		if ((ev1.equals(text)==false))
		{
			driver.findElement(prObj.Reviewer).clear();
			driver.findElement(prObj.Reviewer).sendKeys(text);
		}
		if ((ev2.equals(text)==false))
		{
			driver.findElement(prObj.DocumentTitle).clear();
			driver.findElement(prObj.DocumentTitle).sendKeys(text);
		}
		if ((ev3.equals(text)==false))
		{
			driver.findElement(prObj.Organisation).clear();
			driver.findElement(prObj.Organisation).sendKeys(text);
		}
		//Select ReviewType dropdown
		WebElement elementReviewerType = driver.findElement(prObj.ReviwerType);
		Select s1 = new Select(elementReviewerType);
		s1.selectByVisibleText("Technical review");
		
		//Select DocumentType dropdown
		WebElement element = driver.findElement(prObj.DocumentType);
		Select s = new Select (element);
		s.selectByVisibleText("Drawing");
		Thread.sleep(2000);
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.NextButttonAtBottom)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.NextButttonAtBottom)));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.NextButttonAtBottom)).click();
		//Click on save
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.SaveButton))); 
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.SaveButton)));
		Thread.sleep(2000);
		//Clicks on save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.SavePopupTitle)).click();
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.SavePopupConfirmButton)));
		//Waits for the green popup on the right top corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote));
		//Wait for loading message
		share2.loadingServer(driver);
		//Clicks on saved activities
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.SavedAcivitiesButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.SavedAcivitiesButton)));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.SavedAcivitiesButton)).click();
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Click on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.PassReviewSidePanel)).click();
		share2.loadingServer(driver);
		return(wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.FirstRecord)).getText());
	}

	public String createJobObsReport(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on Job Observation Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-jo"))).click();
		//Fills mandatory details in step1
		Thread.sleep(1000);
		driver.findElement(By.id("pii-joa-tab-1-observer")).sendKeys(text);
		driver.findElement(By.id("pii-joa-tab-1-org")).sendKeys(text);
		driver.findElement(By.id("pii-joa-tab-1-dpt")).sendKeys(text);
		driver.findElement(By.id("pii-joa-tab-1-location")).sendKeys(text);
		driver.findElement(By.id("pii-joa-tab-1-job")).sendKeys(text);
		String ev1 = driver.findElement(By.id("pii-joa-tab-1-observer")).getAttribute("value");
		String ev2 = driver.findElement(By.id("pii-joa-tab-1-location")).getAttribute("value");
		String ev3 = driver.findElement(By.id("pii-joa-tab-1-job")).getAttribute("value");
		if ((ev1.equals(text)==false))
		{
			driver.findElement(By.id("pii-joa-tab-1-observer")).clear();
			driver.findElement(By.id("pii-joa-tab-1-observer")).sendKeys(text);
		}
		if ((ev2.equals(text)==false))
		{
			driver.findElement(By.id("pii-joa-tab-1-location")).clear();
			driver.findElement(By.id("pii-joa-tab-1-location")).sendKeys(text);
		}
		if ((ev3.equals(text)==false))
		{
			driver.findElement(By.id("pii-joa-tab-1-job")).clear();
			driver.findElement(By.id("pii-joa-tab-1-job")).sendKeys(text);
		}
		/*
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-joa-tab-1-form']/div[5]/div/button"))).click();
		//Clicks on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-2-next"))).click();
		//Select Step 3/4/5
		jo.selectStep3Step4Step5Random(driver);
		//Clicks on Next
		driver.findElement(By.id("pii-joa-tab-5-button")).click();
		//Clicks on build report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-tab-6-report"))).click();
		//Clicks on build report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-confirmed"))).click();
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(joObj.JOSaveButton)).click();
		//Clicks on save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-joa-dialog-confirmed"))).click();
		share2.loadingServer(driver);*/
		
		//Click on submit job observation
		jse.executeScript("arguments[0].focus();", driver.findElement(By.id("pii-joa-submitjo-footer")));
		jse.executeScript("arguments[0].click();", driver.findElement(By.id("pii-joa-submitjo-footer")));
//		driver.findElement(By.id("pii-joa-submitjo-footer")).click();
		//Click on generate report button on top
		jse.executeScript("arguments[0].focus();", driver.findElement(By.id("pii-joa-genrep")));
		jse.executeScript("arguments[0].click();", driver.findElement(By.id("pii-joa-genrep")));
		//Click on From: 2nd row 1st date (apply to all months)
		jse.executeScript("arguments[0].focus();", driver.findElement(By.xpath(".//*[@id='pii-generate-report-from']/div/table/tbody/tr[2]/td[1]")));
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='pii-generate-report-from']/div/table/tbody/tr[2]/td[1]")));
		//Click on To: 2nd row 1st date (apply to all months)
		jse.executeScript("arguments[0].focus();", driver.findElement(By.xpath(".//*[@id='pii-generate-report-to']/div/table/tbody/tr[2]/td[1]")));
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='pii-generate-report-to']/div/table/tbody/tr[2]/td[1]")));
		//Click on generate button 
		jse.executeScript("arguments[0].click();", driver.findElement(By.id("pii-joa-genrep-do")));
		//Clicks on saved activities
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(joObj.JOSavedActivitiesButton))); 
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(joObj.JOSavedActivitiesButton)));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(joObj.JOSavedActivitiesButton)).click();
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(joObj.JOSidePanel)).click();
		share2.loadingServer(driver);
		return (wait.until(ExpectedConditions.visibilityOfElementLocated(joObj.JOFirstRecord)).getText());
	}

	public String createRVReport(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on Remote Verification
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVLink)).click();
		//Fills the mandatory fields
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).sendKeys(rv.eventTitle(driver,driver.getCurrentUrl()));
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventDetails)).sendKeys(rv.details(driver,driver.getCurrentUrl()));
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).getAttribute("value");
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventDetails)).getAttribute("value");
		if ((ev1.equals(rv.eventTitle(driver,driver.getCurrentUrl()))==false))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventTitle)).sendKeys(rv.eventTitle(driver,driver.getCurrentUrl()));
		}
		if((ev2.equals(rv.details(driver,driver.getCurrentUrl())))==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventDetails)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVEventDetails)).sendKeys(rv.details(driver,driver.getCurrentUrl()));
		}
		//Select verifier
		driver.findElement(rv.RVVerifierField).sendKeys("qaapaaverifier");
		Thread.sleep(1000);
		//Selects the remote verifier		
		share2.scrollToAPoint(driver, 1500);
		WebElement select = driver.findElement(rv.RVVerifierDropdown);
		WebElement option=select.findElement(eirca.FirstSelectionUnderDropdown);
		option.click();
		//Uploads picture 2
		rv3.upload2ndPicture(driver);
		//Uploads picture 1
//		rv3.upload1stPicture(driver);
		//*
		share2.scrollToTop(driver);
		//Save and send to verifier
		//Clicks on Save and Send
		jse.executeScript("arguments[0].focus();", driver.findElement(rv.RVSaveAndSendButton));
		jse.executeScript("arguments[0].click();", driver.findElement(rv.RVSaveAndSendButton));
//		driver.findElement(rv.RVSaveAndSendButton).click();
		//Clicks on save and send report
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSavePopupTitle)).click();
		jse.executeScript("arguments[0].click();", driver.findElement(rv.RVSavePopupConfirmButton));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Remote Verification side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		return(wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVNewlyCreatedFirstRecord)).getText());
	}

	public String createHiRCAReport(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,20);
		//Fill mandatory details
		hirca.fillPage(driver, text);
		//Save report
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		share2.scrollToTop(driver);
		//Clicks on Save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Clicks on Save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title")));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		share2.loadingServer(driver);		
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("11"))
			{
				share2.loadingServer(driver);	
				//Clicks on Save
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
				//Clicks on Save report
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title")));
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				share2.loadingServer(driver);
			}
		}
		//Clicks on Saved activities
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		share2.loadingServer(driver);
		//Clicks on side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		//Clicks on side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		return(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).getText());
	}

	public List<String> createReports(WebDriver driver, String username) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		List<String> allReportNames = new ArrayList<String>();
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Create error meter report
		allReportNames.add(createEMReport(driver,username));
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Create hpi report
		allReportNames.add(createHPIReport(driver));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
		//create HiRCA report
		allReportNames.add(createHiRCAReport(driver));
		//Clicks on Analysis 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Create EiRCA report
		allReportNames.add(createEiRCAReport(driver));
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Create O&PiRCA report
		allReportNames.add(createOPiRCAReport(driver));
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Create 3 pass report
		allReportNames.add(createpassReviewReport(driver));
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Create Job obs report
		allReportNames.add(createJobObsReport(driver));
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Create Remote Verification report
		allReportNames.add(createRVReport(driver));		
		return allReportNames;
	}

	public void loginToUsersForTest(WebDriver driver, String username, String password) throws Exception{

		System.out.println(username);
		int login1 = login.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		//Thread.sleep(8000);		  
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
			if (login1==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (org.openqa.selenium.TimeoutException e){
			throw e;
		}
		//Thread.sleep(2000);
	}

	public void chooseAllUsersUnderUserDropdown(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Wait for visibility of User Button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-user-select-button")));
		Select s = new Select(driver.findElement(By.id("pii-user-home-user-select")));
		s.selectByVisibleText("All");
	}

	public void groupModeratorViewReportsFromUsers(WebDriver driver, List<String> allReportNames) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Activity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-activity"))).click();
		//Select All in Users
		chooseAllUsersUnderUserDropdown(driver);
		/*Based on the number of names in allReportNames list decide how many report names to verify
		 * if size >8 then 2 users have created reports and so first 2 names have to be verified
		 * else only 1 name has to be verified
		 */
		int n;
		if(allReportNames.size()>8)
			n=3;
		else n=2;
		//Clicks on Error Meter side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
		share2.loadingServer(driver);
		//Verify if the reports from users under group are visible
		for(int i=2;i<=n;i++)
		{
			String recordName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li["+i+"]/a"))).getText();
			softly.assertThat(recordName).as("test data").isIn(allReportNames);
			System.out.println(recordName);
			//Click on record
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-epm']/ul/li["+i+"]/a"))).click();
			share2.loadingServer(driver);
			//Clicks on Error Meter side panel
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-epm"))).click();
			share2.loadingServer(driver);
		}
		//Clicks on HPI side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
		share2.loadingServer(driver);
		//Verify if the reports from users under group are visible
		for(int i=2;i<=n;i++)
		{
			String recordName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li["+i+"]/a"))).getText();
			softly.assertThat(recordName).as("test data").isIn(allReportNames);
			System.out.println(recordName);
			//Click on record
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-hpi']/ul/li["+i+"]/a"))).click();
			share2.loadingServer(driver);
			//Clicks on HPI side panel
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-hpi"))).click();
			share2.loadingServer(driver);
		}
		//Clicks on HiRCA side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		share2.loadingServer(driver);
		//Verify if the reports from users under group are visible
		for(int i=2;i<=n;i++)
		{
			String recordName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li["+i+"]/a"))).getText();
			softly.assertThat(recordName).as("test data").isIn(allReportNames);
			System.out.println(recordName);
			//Click on record
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li["+i+"]/a"))).click();
			share2.loadingServer(driver);
			//Clicks on HiRCA side panel
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
			share2.loadingServer(driver);
		}
		//Clicks on EiRCA side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();
		share2.loadingServer(driver);
		//Verify if the reports from users under group are visible
		for(int i=2;i<=n;i++)
		{
			String recordName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li["+i+"]/a"))).getText();
			softly.assertThat(recordName).as("test data").isIn(allReportNames);
			System.out.println(recordName);
			//Click on record
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-mirca']/ul/li["+i+"]/a"))).click();
			share2.loadingServer(driver);
			//Clicks on EiRCA side panel
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();
			share2.loadingServer(driver);
		}
		//Clicks on O&PiRCA side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASidePanel)).click();
		share2.loadingServer(driver);
		//Verify if the reports from users under group are visible
		for(int i=2;i<=n;i++)
		{
			String recordName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li["+i+"]/a"))).getText();
			softly.assertThat(recordName).as("test data").isIn(allReportNames);
			System.out.println(recordName);
			//Click on record
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-opa']/ul/li["+i+"]/a"))).click();
			share2.loadingServer(driver);
			//Clicks on O&PiRCA side panel
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASidePanel)).click();
			share2.loadingServer(driver);
		}
		//Clicks on Job Obs side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-joa"))).click();
		share2.loadingServer(driver);
		//Verify if the reports from users under group are visible
		for(int i=2;i<=n;i++)
		{
			String recordName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li["+i+"]/a"))).getText();
			softly.assertThat(recordName).as("test data").isIn(allReportNames);
			System.out.println(recordName);
			//Click on record
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li["+i+"]/a"))).click();
			share2.loadingServer(driver);
			//Clicks on Job Obs side panel
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-joa"))).click();
			share2.loadingServer(driver);
		}
		//Clicks on 3 Pass review side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.PassReviewSidePanel)).click();
		share2.loadingServer(driver);
		//Verify if the reports from users under group are visible
		for(int i=2;i<=n;i++)
		{
			String recordName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li["+i+"]/a"))).getText();
			softly.assertThat(recordName).as("test data").isIn(allReportNames);
			System.out.println(recordName);
			//Click on record
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li["+i+"]/a"))).click();
			share2.loadingServer(driver);
			//Clicks on 3 Pass review side panel
			wait.until(ExpectedConditions.visibilityOfElementLocated(prObj.PassReviewSidePanel)).click();
			share2.loadingServer(driver);
		}
		//Clicks on RV side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSidePanel)).click();
		share2.loadingServer(driver);
		//Verify if the reports from users under group are visible
		for(int i=2;i<=n;i++)
		{
			String recordName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li["+i+"]/a"))).getText();
			softly.assertThat(recordName).as("test data").isIn(allReportNames);
			System.out.println(recordName);
			//Click on record
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-rv']/ul/li["+i+"]/a"))).click();
			share2.loadingServer(driver);
			//Clicks on RV side panel
			wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVSidePanel)).click();
			share2.loadingServer(driver);
		}
	}

	public void groupModeratorTest(WebDriver driver, String user1gm, String user2, String user3, String user4gm, String user5) throws Exception {

		List<String> allReportNamesFromGroup1 = new ArrayList<String>();
		List<String> allReportNamesFromGroup2 = new ArrayList<String>();
		//Login to user 2 and create reports
		loginToUsersForTest(driver,user2,password);
		//Create reports
		allReportNamesFromGroup1.addAll(createReports(driver,user2));
		//Logout
		login.logout(driver);
		//Switch to default content
		driver.switchTo().defaultContent();
		//Login to user 3 and create reports
		loginToUsersForTest(driver,user3,password);
		//Create reports
		allReportNamesFromGroup1.addAll(createReports(driver,user3));
		//Logout
		login.logout(driver);
		//Switch to default content
		driver.switchTo().defaultContent();
		//Login to user 5 and create reports
		loginToUsersForTest(driver,user5,password);
		//Create reports
		allReportNamesFromGroup2.addAll(createReports(driver,user5));
		//Logout
		login.logout(driver);
		//Switch to default content
		driver.switchTo().defaultContent();
		//Group Moderator 1 (user1) for group 1 will view reports from all user 2 and 3
		//Login to user 1 gm
		loginToUsersForTest(driver,user1gm,password);
		System.out.println(allReportNamesFromGroup1);
		//View reports
		groupModeratorViewReportsFromUsers(driver,allReportNamesFromGroup1);
		//Logout
		login.logout(driver);
		//Switch to default content
		driver.switchTo().defaultContent();
		//Group Moderator 2 (user4) for group 2 will view reports of user 5
		//Login to user 4 gm
		loginToUsersForTest(driver,user4gm,password);
		System.out.println(allReportNamesFromGroup2);
		//View reports
		groupModeratorViewReportsFromUsers(driver,allReportNamesFromGroup2);
		//Logout
		login.logout(driver);
		//Clear lists
		allReportNamesFromGroup1.clear();
		allReportNamesFromGroup2.clear();
		/*		//Switch to default content
		driver.switchTo().defaultContent();
		//Company Moderator (user6) will view reports from users2,3,5
		//Login to user 6 cm
		loginToUsersForTest(driver,user6cm,password);
		allReportNamesFromGroup1.addAll(allReportNamesFromGroup2);
		//View reports
		groupModeratorViewReportsFromUsers(driver,allReportNamesFromGroup1);
		//Logout
		login.logout(driver);*/
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
