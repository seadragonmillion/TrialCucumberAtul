package MainClass;

import java.util.List;

import PageObjects.EiRCAV2PageObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;

public class EiRCAPath2_1 {

	ShareCheck2 share2 = new ShareCheck2();
	EiRCAV2PageObj eirca = new EiRCAV2PageObj();
	EiRCAV2 e1 = new EiRCAV2();
	EiRCAV2_3 eircav3 = new EiRCAV2_3();
	EiRCAV2_4 eircav4 = new EiRCAV2_4();

	public void verifyBugsInStep5 (WebDriver driver, SoftAssertions softly, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click Next
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//refute all failure modes
		for(int i=3;i<=5;i++)
		{
			//Click on collapsible
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-5']/div["+i+"]"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-5']/div["+i+"]"))).click();
			//Click on check box for 5.1
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-5']/div["+i+"]/div/table/tbody/tr[1]/td[2]/div/input"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-5']/div["+i+"]/div/table/tbody/tr[1]/td[2]/div/input"))).click();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-5']/div["+i+"]/div/table/tbody/tr[1]/td[4]/textarea"))).sendKeys(text);
		}
		//Scroll to the top
		share2.scrollToTop(driver);
		verifyPopupStep5AllRefuted(driver,softly);
		//Click on see report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).click();	
		//Verify reason
		for(int i=1;i<=3;i++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[11]/table["+i+"]/tbody/tr[1]/td[2]/strong"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("Yes");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[11]/table["+i+"]/tbody/tr[1]/td[3]"))).getText();
			softly.assertThat(s1).as("test data").isEqualTo(text);
		}
		//Verify skipped on step 6
		String skip1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep6SectionTitle)).getText();
		softly.assertThat(skip1).as("test data").isEqualTo("6. Identify Failed Component through Leading-Following Differential Analysis (skipped)");
		//Verify skipped on step 7
		String skip2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep7SectionTitle)).getText();
		softly.assertThat(skip2).as("test data").isEqualTo("7. Probability of Occurrence and Actions (skipped)");
		//Verify skipped on step 8
		String skip3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep8SectionTitle)).getText();
		softly.assertThat(skip3).as("test data").isEqualTo("8. Perform Supporting Analysis (skipped)");
		//Verify skipped on step 9
		String skip4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep9SectionTitle)).getText();
		softly.assertThat(skip4).as("test data").isEqualTo("9. Direct Cause, Apparent Cause Confirmation & Cause Quality Check (skipped)");
		//Verify skipped on step 10
		String skip5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep10SectionTitle)).getText();
		softly.assertThat(skip5).as("test data").isEqualTo("10. Corrective Actions (skipped)");
		//Click on step 5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5Tab)).click();	
		//unrefute all failure modes
		for(int i=3;i<=5;i++)
		{
			//Click on collapsible
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-5']/div["+i+"]"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-5']/div["+i+"]"))).click();
			//Click on check box for 5.1
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-5']/div["+i+"]/div/table/tbody/tr[1]/td[2]/div/input"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-5']/div["+i+"]/div/table/tbody/tr[1]/td[2]/div/input"))).click();	
		}
		//Scroll to the top
		share2.scrollToTop(driver);
		//Click on report tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAReportTab)).click();	
		//Verify no refuted failure modes
		String f = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep5RefutedFailureModeTitle)).getText();
		softly.assertThat(f).as("test data").isEqualTo("Refuted failure modes: n/a");
		//List of unrefuted failure modes
		for(int i=1;i<=3;i++)
		{
			String fm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-11']/div[11]/ol/li["+i+"]"))).getText();			
			if(i==1)
				softly.assertThat(fm).as("test data").isEqualTo("IMP FM 7");
			if(i==2)
				softly.assertThat(fm).as("test data").isEqualTo("IMP FM 8");
			if(i==3)
				softly.assertThat(fm).as("test data").isEqualTo("IMP FM 9");
		}
		//Click on step 5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5Tab)).click();	
		//Click next step 6
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Click next step 7
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Click next step 8
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Click next to popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Click on see report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).click();	
		//Verify skipped on step 9
		String skip1a = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep9SectionTitle)).getText();
		softly.assertThat(skip1a).as("test data").isEqualTo("9. Direct Cause, Apparent Cause Confirmation & Cause Quality Check (skipped)");
		//Verify skipped on step 10
		String skip2a = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep10SectionTitle)).getText();
		softly.assertThat(skip2a).as("test data").isEqualTo("10. Corrective Actions (skipped)");
		//Click on step 4
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4Tab)).click();	
		//Add a failure mode
		eircav4.addFailureMode(driver, 2, text, softly);
		//Click Next
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify Step 5 collapsible name
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fm-title-0"))).getText();
		softly.assertThat(s).as("test data").isIn(text);
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		//Change 1st failure mode name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t4-fms-table']/tbody/tr[1]/td[2]/textarea"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t4-fms-table']/tbody/tr[1]/td[2]/textarea"))).sendKeys(Key.TAB);
		share2.loadingServer(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t4-fms-table']/tbody/tr[1]/td[2]/textarea"))).sendKeys("IMP FM change name");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t4-fms-table']/tbody/tr[1]/td[2]/textarea"))).sendKeys(Key.TAB);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t4-fms-table']/tbody/tr[1]/td[3]/textarea"))).sendKeys(Key.TAB);
		//Click Next
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Verify Step 5 collapsible name
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fm-title-0"))).getText();
		softly.assertThat(s1).as("test data").isIn("IMP FM change name");		
	}	

	public void verifyPopupStep5AllRefuted(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//next
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Wait for popup
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("All Refuted");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Since all possible valid failure modes are refuted, do you want to see report now or modify failure modes?");
		//Verify question on pop up
		String s1a = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopUpMessageNote)).getText();
		softly.assertThat(s1a).as("test data").isEqualTo("Modify failure modes: add failure modes or review their statements of refutability.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("see report");
		//Modify button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("modify failure modes");
	}

	public void verifyEiRCAPath2 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		String text = eirca.textEiRCAv2Bug;	
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Clicks on MainClass.EiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-eirca"))).click();
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NewButton)).click();
		//New button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		//Fills all mandatory fields
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventTitleField)).sendKeys(text);
		driver.findElement(eirca.EiRCAEventLocationField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventReporterField).sendKeys(text); 
		driver.findElement(eirca.EiRCAEventInvestigatorField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventReviewerField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventSponsorField).sendKeys(text);
		driver.findElement(eirca.EiRCAEventProblemStatementField).sendKeys(text);
		e1.EIRCAStep1Dropboxes(driver,eirca.textEiRCAv2,softly);
		//Click Next
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Click Next
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Clicks on Save button
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();
		//Clicks on Save Report button			  
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();		
		//Clicks on Saved activities button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).click();
		share2.loadingServer(driver);
		//Clicks on panel on the left on MainClass.EiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Click on 1st record
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		share2.loadingServer(driver);
		//Verify interview n/a
		//Interviews
		//1
		for(int j=1;j<=2;j++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[4]/table/tbody/tr[1]/td["+j+"]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("n/a");
		}
		//2
		for(int j=1;j<=2;j++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[7]/table/tbody/tr[1]/td["+j+"]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("n/a");
		}
		//3
		for(int j=1;j<=2;j++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[10]/table/tbody/tr[1]/td["+j+"]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("n/a");
		}
		//4
		for(int j=1;j<=2;j++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[13]/table/tbody/tr[1]/td["+j+"]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("n/a");
		}
		//Verify no Comprehensive Field Inspection table
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[6]/div[2]/table")));
		//Click on open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();	
		//Click on step 2 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2Tab)).click();
		//Interview tab - 2nd row test
		eircav3.interviews(driver, text, softly);
		//Click on symptoms
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2SymptomsTab)).click();
		//Get the WebElement list for the table heads
		List<WebElement> listHead = driver.findElements(By.xpath(".//*[@id='pii-ircam2-t2t3-inspections-table']/thead"));
		softly.assertThat(listHead.size()).as("test data").isEqualTo(0);
		//Clicks on Saved activities button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).click();
		share2.loadingServer(driver);
		//Clicks on panel on the left on MainClass.EiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Click on 1st record
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		share2.loadingServer(driver);
		//Delete report
		driver.findElement(eirca.DeleteButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		share2.loadingServer(driver);
	}

}
