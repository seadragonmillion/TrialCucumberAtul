import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import kaleTestSoftware.*;
import kaleTestSoftware.ErrorMeter2;
import kaleTestSoftware.ErrorMeter3;
import kaleTestSoftware.HiRCAEvent;
import kaleTestSoftware.LoginPageObj;
import kaleTestSoftware.ShareCheck;
import kaleTestSoftware.ShareCheck2;
import kaleTestSoftware.ShareCheck3;
import kaleTestSoftware.TextBoxResizing;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.util.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterables;


public class EiRCA {

	SoftAssertions softly = new SoftAssertions();

	TextBoxResizing tbr = new TextBoxResizing ();
	ErrorMeter2 em2 = new ErrorMeter2 ();
	ErrorMeter3 em3 = new ErrorMeter3 ();
	EiRCAPageObj eirca = new EiRCAPageObj();
	LoginPageObj login = new LoginPageObj();
	EiRCA2 eirca2 = new EiRCA2();
	EiRCA3 eirca3 = new EiRCA3();
	ShareCheck3 share3 = new ShareCheck3();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();

	public String textToVerifyClearTextBox = "to verify clearing of text";

	public void deleteNewRecord(WebDriver driver,String recordName, int y) throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		//Clicks on delete button
		share2.loadingServer(driver);
		driver.findElement(eirca.DeleteButton).click();
		//Verify delete popup
		if (browserName.contains("safari")==false)
		{					
			eirca2.verifyDeleteReportPopup(driver, softly, recordName);
		}
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle));
		//Clicks on delete report
		jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		//Verify delete pop up
		if (browserName.contains("safari")==false)
		{					
			eirca2.verifyStickyDeleteReport(driver, softly, recordName);
		}
		Thread.sleep(2000);
		jse.executeScript("return document.getElementById('pii-user-home-panel-btn-mirca').click();");
		//Verify record deleted
		//Click on 1st record
		String name = driver.findElement(eirca.EiRCAFirstRecord).getText();
		System.out.println(name);
		if (name!=recordName)
			System.out.println("Record deleted");
		else
			System.out.println("Record could not be deleted");
		//Verify report not retrieved by shared to person		
		String sharer = em3.decideSharer (y);
		share.checkNoReportAfterDelete(driver, sharer, softly);		  			  
	}

	public void add2ndFailureMode(WebDriver driver, String username) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		String text = eirca2.textCreate(driver);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable4Step1Q11)).getText().contains("Troubleshooting"))
		{
			//Click on open button
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle));
			//Clicks on open report
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
			//Click on step 3
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3Tab)).click();
			//Remove any selection made in Step 3 if any
			removeAllStep3Selections(driver);
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
			//Verify Step 4 has only 4.4
			verifyStep4Uncheck44(driver);
			//Click on step 2
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2Tab)).click();
			//Enter text in 2nd row failure 
			//tbr.sizeCheck(driver, eirca.Step2Row21stTextBoxField,softly);
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2Row21stTextBoxField)).sendKeys(text);
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
			//Verify that 2 collapsibles are visible in Step 3
			//Click on collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsibleFailureMode2)).click();
			//Click on collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsible)).click();
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
			//Verify Step 4 with 2 failure modes
			verifyStep4With2FailureModes(driver);
			//In 1st failure mode select all but 4.3 and 4.4
			enable45In1stFailureMode(driver);
			//In 2nd failure mode make 4.4 enabled
			enable44In2ndFailureMode(driver);
			//Save report
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();
			//Save pop verify
			eirca2.verifySavePopup(driver, softly);
			//Clicks on Save report
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
			//Verify save sticky
			eirca2.verifyStickySaveReport(driver, softly, username, text,1);
			share2.loadingServer(driver);
			share2.loadingServer(driver);
			share2.scrollToTop(driver);
			//Clicks on Saved activities
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).click();
			share2.loadingServer(driver);
			share2.scrollToTop(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();
			share2.loadingServer(driver);
			share2.scrollToTop(driver);
			//Clicks on first newly created record
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
			share2.loadingServer(driver);
			//Verify html
			verifyHTMLWith2FailureModesAndStep4(driver);
		}
	}

	public void verifyHTMLWith2FailureModesAndStep4(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Text of failure mode
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable5Step2Row2Column1)).getText();
		String r1 = s.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
		//Step 4 table 1
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table1Row1Column2)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table1Row2Column2)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Yes");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table1Row3Column2)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Yes");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table1Row4Column2)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Yes");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table1Row5Column2)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("n/a");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table1Row6Column2)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Yes");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table1Row7Column2)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Yes");
		//Step 4 table 2
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table2Row1Column2)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Yes");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table2Row2Column2)).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Yes");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table2Row3Column2)).getText();
		softly.assertThat(s10).as("test data").isEqualTo("");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table2Row4Column2)).getText();
		softly.assertThat(s11).as("test data").isEqualTo("n/a");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table2Row5Column2)).getText();
		softly.assertThat(s12).as("test data").isEqualTo("Yes");
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table2Row6Column2)).getText();
		softly.assertThat(s13).as("test data").isEqualTo("Yes");
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table2Row7Column2)).getText();
		softly.assertThat(s14).as("test data").isEqualTo("Yes");
	}

	public void enable44In2ndFailureMode(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Scroll to the bottom
		share2.scrollToAPoint(driver, 1500);
		Thread.sleep(1000);
		//4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option42CheckBox)).click();
		//4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option43CheckBox)).click();
		Thread.sleep(1000);
		//4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option44CheckBox)).click();
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option47CheckBox)));
		//4.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option46CheckBox)).click();
		//4.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option47CheckBox)).click();
		//Scroll to top
		share2.scrollToTop(driver);
	}

	public void enable45In1stFailureMode(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Scroll to top
		share2.scrollToTop(driver);
		//4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TableOption44CheckBox)).click();
		//4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode1Option42CheckBox)).click();
		//4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode1Option45CheckBox)).click();
		//4.6
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode1Option46CheckBox));
		//Scroll to 4.6
		share2.scrollToElement(driver, l);
		l.click();
		//4.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode1Option47CheckBox)).click();
	}

	public void verifyStep4With2FailureModes(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on 1st collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)).click();
		//Verify 4.4 is disabled
		if(driver.findElement(eirca.Step4FailureMode1Option44Row).getAttribute("class").contains("disabled")==false)
			softly.fail("In Step 4, option 4.4 is enabled.");
		//Verify presence of all checkboxes other than 4.4
		//4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TableOption44CheckBox));
		//4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode1Option42CheckBox));
		//4.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode1Option43CheckBox));
		//4.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode1Option45CheckBox));
		//4.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode1Option46CheckBox));
		//4.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode1Option47CheckBox));
		//Scroll to 2nd collapsible
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsibleFailureMode2));
		share2.scrollToElement(driver, l);
		//Click on 2nd collapsible
		l.click();
		//Verify 4.4 is disabled
		if(driver.findElement(eirca.Step4FailureMode2Option44Row).getAttribute("class").contains("disabled")==false)
			softly.fail("In Step 4, option 4.4 is enabled.");
		//Verify presence of all checkboxes other than 4.4
		//4.1
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option41CheckBox)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option41CheckBox));
		//4.2
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option42CheckBox)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option42CheckBox));
		//4.3
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option43CheckBox)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option43CheckBox));
		//4.5
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option45CheckBox)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option45CheckBox));
		//4.6
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option46CheckBox)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option46CheckBox));
		//4.7
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option47CheckBox)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode2Option47CheckBox));
		share2.scrollToTop(driver);
	}

	public void verifyStep4Uncheck44(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,3);
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)).click();
		//Verify 4.4 is only present as the only option
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TableOption44Part1)).getText();
		softly.assertThat(s).as("test data").contains("4.4: Does the failure mode occur right after and related to a design, operation, or maintenance activity?");
		//UnSelect 4.4
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TableOption44CheckBox)).getAttribute("checked");
		if(Strings.isNullOrEmpty(s1)==false&&s1.contains("true"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TableOption44CheckBox)).click();
		//Verify no subsequent rows are present
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureMode1Option42CheckBox));
			softly.fail("Subsequent Step 4 rows present after 1st option (in this case should be 4.4)");
		}catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException r)
		{
			System.out.println("Only 4.4 present in one failure mode");
		}
	}

	public void removeAllStep3Selections(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(1000);
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsible)).click();
		Thread.sleep(1000);
		//3.1
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBox)).getAttribute("checked");
		System.out.println(s);
		if(Strings.isNullOrEmpty(s)==false&&s.contains("true"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBox)).click();
		//3.2
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption32CheckBox)).getAttribute("checked");
		System.out.println(s1);
		if(Strings.isNullOrEmpty(s1)==false&&s1.contains("true"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption32CheckBox)).click();
		//3.3
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption33CheckBox)).getAttribute("checked");
		System.out.println(s2);
		if(Strings.isNullOrEmpty(s2)==false&&s2.contains("true"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption33CheckBox)).click();
		//3.4
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption34CheckBox)).getAttribute("checked");
		System.out.println(s3);
		if(Strings.isNullOrEmpty(s3)==false&&s3.contains("true"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption34CheckBox)).click();
		//3.5
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption35CheckBox)).getAttribute("checked");
		System.out.println(s4);
		if(Strings.isNullOrEmpty(s4)==false&&s4.contains("true"))
		{
			//Scroll to the bottom
			share2.scrollToAPoint(driver, 1200);
			//Click on check box for 3.5
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption35CheckBox)).click();
		}
		//3.5
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption36CheckBox)).getAttribute("checked");
		System.out.println(s5);
		if(Strings.isNullOrEmpty(s5)==false&&s5.contains("true"))
		{
			//Scroll to the bottom
			share2.scrollToAPoint(driver, 1200);
			//Click on check box for 3.6
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption36CheckBox)).click();
		}
		//Scroll to top
		share2.scrollToTop(driver);
	}

	public void verifyHTML(WebDriver driver,HashMap<String,String>hm, String text, int n,int x, int y, int z, String ans1, String ans2, String ans3, HashMap<String,Integer> c)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		share2.loadingServer(driver);
		//Verify Sequence of Events title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Sequence of Events");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageDateTimeTitle1)).getText();
		softly.assertThat(s1).as("test data").isEqualTo(hm.get("date1")+", "+hm.get("time1"));
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageWhatHappenedTitle1)).getText();
		String r1 = s2.replace("\u00AD", "");
		softly.assertThat(r1).as("test data").isEqualTo(hm.get("what happened1"));
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageWhatShouldHappenTitle1)).getText();
		String r2 = s3.replace("\u00AD", "");
		softly.assertThat(r2).as("test data").isEqualTo(hm.get("what is supposed to happen1"));	
		System.out.println("\n \n"+r1 + "\n" +r2);
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageDateTimeTitle2)).getText();
		softly.assertThat(s14).as("test data").isEqualTo(hm.get("date2")+", "+hm.get("time2"));
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageWhatHappenedTitle2)).getText();
		String r11 = s15.replace("\u00AD", "");
		softly.assertThat(r11).as("test data").isEqualTo(hm.get("what happened2"));
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageWhatShouldHappenTitle2)).getText();
		String r12 = s16.replace("\u00AD", "");
		softly.assertThat(r12).as("test data").isEqualTo(hm.get("what is supposed to happen2"));	
		System.out.println("\n \n"+r11 + "\n" +r12);
		//Verify text filled in first table
		//Event title
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable1EventTitle)).getText();
		String r3 = s4.replace("\u00AD", "");
		softly.assertThat(r3).as("test data").contains(text);
		//Location of event
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable1LocationOfEvent)).getText();
		String r4 = s5.replace("\u00AD", "");
		softly.assertThat(r4).as("test data").isEqualTo(text);
		//Who discovered
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable1WhoDiscovered)).getText();
		String r5 = s6.replace("\u00AD", "");
		softly.assertThat(r5).as("test data").isEqualTo(text);
		//Investigators
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable1Investigators)).getText();
		String r6 = s7.replace("\u00AD", "");
		softly.assertThat(r6).as("test data").isEqualTo(text);
		//Reviewers
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable1Reviewers)).getText();
		String r7 = s8.replace("\u00AD", "");
		softly.assertThat(r7).as("test data").isEqualTo(text);
		//Management sponsors
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable1ManagementSponsors)).getText();
		String r8 = s9.replace("\u00AD", "");
		softly.assertThat(r8).as("test data").isEqualTo(text);
		//Problem Statement
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable1ProblemStatement)).getText();
		String r9 = s10.replace("\u00AD", "");
		softly.assertThat(r9).as("test data").isEqualTo(text);
		//Suspected failed component
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable1SuspectedFailedComponent)).getText();
		String r10 = s11.replace("\u00AD", "");
		softly.assertThat(r10).as("test data").isEqualTo(text);
		//Convert Value of hashmap to list
		List<Integer> c1 = returnListFromHMValue(c);
		//Root cause and contributing factor
		if(z!=0)
			HTMLRCTable(driver,z,c,c1);
		//Step 1 Table
		HTMLStep1Table(driver,ans1,ans2,ans3);
		//Step 2 Table
		HTMLStep2Table(driver);
		//Step 3 Table
		HTMLStep3Table(driver,n);
		//Verify Step 5,6,7 skipped when there is some selections in Step 3
		if(n>0)
		{
			WebElement ele;
			try{
				ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4SkippedRCA));
			}catch(org.openqa.selenium.TimeoutException t)
			{
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4SkippedRCA2));
			}
			String s12 = ele.getText();
			if(ans1.contains("Root Cause Analysis"))
				softly.assertThat(s12).as("test data").isEqualTo("Step 4 - Probability of Occurrence and Actions (skipped)");
			else{
				softly.assertThat(s12).as("test data").contains("Step 4 - Probability of Occurrence and Actions (skipped)");
				//softly.assertThat(s12).as("test data").contains("Unrefuted failure modes are shown from highest to lowest probability of occurence.");
			}
			try{
				ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep5Skipped));
			}catch(org.openqa.selenium.TimeoutException t)
			{
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep5Skipped2));
			}
			String s13 = ele.getText();
			softly.assertThat(s13).as("test data").isEqualTo("Step 5 - Identify Possible Contributing Factors (skipped)");
			try{
				ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Skipped));
			}catch(org.openqa.selenium.TimeoutException t)
			{
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Skipped3));
			}
			String s17 = ele.getText();
			softly.assertThat(s17).as("test data").isEqualTo("Step 6 - Determine Contributing Factors (skipped)");
			try{
				ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Skipped));
			}catch(org.openqa.selenium.TimeoutException t)
			{
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Skipped3));
			}
			String s18 = ele.getText();
			softly.assertThat(s18).as("test data").contains("Step 7 - Root Causes Determination Checklist (SUEP");
			softly.assertThat(s18).as("test data").contains("(skipped)");
		}
		else{
			//Verify step 4 skipped
			if(ans1.contains("Root Cause Analysis"))
			{
				WebElement ele;
				try{
					ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4SkippedRCA));
				}catch(org.openqa.selenium.TimeoutException t)
				{
					ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4SkippedRCA2));
				}
				String s12 = ele.getText();
				softly.assertThat(s12).as("test data").isEqualTo("Step 4 - Probability of Occurrence and Actions (skipped)");
				//Verify step5 skipped
				if(y==0)
				{
					/*String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep5Skipped)).getText();
				softly.assertThat(s13).as("test data").isEqualTo("Step 5 - Identify Possible Contributing Factors (skipped)");*/
					//Commented the lines because the bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 5 is not skipped
					//int x1 = 2;
					//HTMLStep5Text(driver,x);
				}
				else
				{
					//bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 5 is not skipped
					//int x1 = 2;
					HTMLStep5Text(driver,x);
					HTMLStep5(driver,x);
				}
				//Verify step 6 skipped
				if(z==0)
				{
					try{
						String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Skipped)).getText();
						softly.assertThat(s13).as("test data").isEqualTo("Step 6 - Determine Contributing Factors (skipped)");
					}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException r)
					{
						String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Skipped2)).getText();
						softly.assertThat(s13).as("test data").isEqualTo("Step 6 - Determine Contributing Factors (skipped)");
					}
					//Commented the lines because the bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 6 is not skipped
					//int x1 = 2;
					//HTMLStep6Text(driver,y);
				}
				else
				{
					//bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 6 is not skipped
					//int x1 = 1;
					HTMLStep6Text(driver,y);
					HTMLStep6(driver,y);
				}
				//Verify step 7 skipped
				if(z==0)
				{
					try{
						String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Skipped)).getText();
						softly.assertThat(s13).as("test data").contains("Step 7 - Root Causes Determination Checklist (SUEP");
						softly.assertThat(s13).as("test data").contains("(skipped)");
					}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException r)
					{
						String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Skipped2)).getText();
						softly.assertThat(s13).as("test data").contains("Step 7 - Root Causes Determination Checklist (SUEP");
						softly.assertThat(s13).as("test data").contains("(skipped)");
					}

				}
				else
				{
					HTMLStep7RCTr(driver,z,c1);
				}
			}	      
			//Verify step 4 skipped
			if(ans1.contains("Troubleshooting"))
			{
				String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4SkippedTr)).getText();
				softly.assertThat(s12).as("test data").contains("Step 4 - Probability of Occurrence and Actions");
				/*	try{
				String s12a = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4SkippedTr1)).getText();
				softly.assertThat(s12a).as("test data").isEqualTo("Unrefuted failure modes are shown from highest to lowest probability of occurence.");
				}catch(org.openqa.selenium.TimeoutException t)
				{

				}*/
				//Verify step5 skipped
				if(y==0)
				{
					/*
				String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep5Skipped)).getText();
				softly.assertThat(s13).as("test data").isEqualTo("Step 5 - Identify Possible Contributing Factors (skipped)");*/
					//Commented the lines because the bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 5 is not skipped
					//int x1 = 2;
					//HTMLStep5Text(driver,x1);
					WebElement ele;
					try{
						ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep5Skipped));
					}catch(org.openqa.selenium.TimeoutException t)
					{
						try{
							ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep5Skipped2));
						}catch(org.openqa.selenium.TimeoutException t1)
						{
							ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep5Skipped3));
						}
					}
					String s13 = ele.getText();
					softly.assertThat(s13).as("test data").isEqualTo("Step 5 - Identify Possible Contributing Factors (skipped)");
				}
				else
				{
					//bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 5 is not skipped
					int x1 = 2;
					HTMLStep5Text(driver,x1);
					HTMLStep5(driver,x);
				}
				//Verify step 6 skipped
				if(z==0)
				{
					/*String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Skipped)).getText();
				softly.assertThat(s13).as("test data").isEqualTo("Step 6 - Determine Contributing Factors (skipped)");*/
					//Commented the lines because the bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 6 is not skipped
					//int x1 = 2;
					HTMLStep6Text(driver,y);
				}
				else
				{
					//bug exists for eirca, even if nothing is selected, the text enetered will show up in report and step 6 is not skipped
					//int x1 = 1;
					HTMLStep6Text(driver,y);
					HTMLStep6(driver,y);
				}
				//Verify step 7 skipped
				if(z==0)
				{
					try{
						String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Skipped)).getText();
						softly.assertThat(s13).as("test data").contains("Step 7 - Root Causes Determination Checklist (SUEP");
						softly.assertThat(s13).as("test data").contains("(skipped)");
					}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException r)
					{
						String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Skipped2)).getText();
						softly.assertThat(s13).as("test data").contains("Step 7 - Root Causes Determination Checklist (SUEP");
						softly.assertThat(s13).as("test data").contains("(skipped)");
					}
				}
				else
				{
					HTMLStep7RCTr(driver,z,c1);
				}
			}
		}
	}

	public List<Integer> returnListFromHMValue(HashMap<String,Integer> c) throws Exception {

		List<Integer>c1 = new ArrayList<Integer>();
		if(c.isEmpty()==false)
		{
			if(c.get("Culprit work activities")!=null)
				c1.add(c.get("Culprit work activities"));
			if(c.get("Inadequate preventive maintenance schedule")!=null)
				c1.add(c.get("Inadequate preventive maintenance schedule"));
			if(c.get("Sub-standard practice: maintenance error")!=null)
				c1.add(c.get("Sub-standard practice: maintenance error"));
			if(c.get("Sub-standard practice: operating errors")!=null)
				c1.add(c.get("Sub-standard practice: operating errors"));
		}
		return c1;
	}

	public void HTMLRCTable(WebDriver driver, int z, HashMap<String,Integer> c, List<Integer> c1) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		int i=1;
		int j=1;
		if(c.get("Culprit work activities")!=null)
		{
			if(c.get("Culprit work activities")==4)
			{
				i=i+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[1]"))).getText();
				System.out.println(s);
				softly.assertThat(s).as("test data").contains("Culprit work activities");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
			else
			{
				j=j+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[1]"))).getText();
				System.out.println(s);
				softly.assertThat(s).as("test data").contains("Culprit work activities");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
		}
		if(c.get("Inadequate preventive maintenance schedule")!=null)
		{
			if(c.get("Inadequate preventive maintenance schedule")==4)
			{
				i=i+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Inadequate preventive maintenance schedule");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
			else
			{
				j=j+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Inadequate preventive maintenance schedule");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
		}
		if(c.get("Sub-standard practice: maintenance error")!=null)
		{
			if(c.get("Sub-standard practice: maintenance error")==4)
			{
				i=i+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Sub-standard practice: maintenance error");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
			else
			{
				j=j+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Sub-standard practice: maintenance error");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
		}
		if(c.get("Sub-standard practice: operating errors")!=null)
		{
			if(c.get("Sub-standard practice: operating errors")==4)
			{
				i=i+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Sub-standard practice: operating errors");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
			else
			{
				j=j+1;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Sub-standard practice: operating errors");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+j+"]/td[2]"))).getText();
				String r1 = s1.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
		}		  
	}

	public void HTMLStep7RCTr(WebDriver driver, int z, List<Integer> c) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,2);
		eirca3.verifyHTMLSUEPTableContributingFactorBoldFont(driver, z);
		for(int i=1;i<=z;i++)
		{
			int f = c.get(i-1);
			if(i==1)
			{
				//Verify corrective action
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column6RC)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column6)).getText();
						String r1 = s.replaceAll("\u00AD", "");
						softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
					}catch(org.openqa.selenium.TimeoutException q)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column6a)).getText();
							String r1 = s.replaceAll("\u00AD", "");
							softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
						}catch(org.openqa.selenium.TimeoutException q1)
						{

						}
					}
				}				
				if(f>=1)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column2RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column2)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column2a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}

				}
				if(f>=2)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column3RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column3)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column3a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
				if(f>=3)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column4RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column4)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column4a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
				if(f==4)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column5RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column5)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column5a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
			}
			if(i==2)
			{
				//Verify corrective action
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column6RC)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column6)).getText();
						String r1 = s.replaceAll("\u00AD", "");
						softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
					}catch(org.openqa.selenium.TimeoutException q)
					{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column6a)).getText();
						String r1 = s.replaceAll("\u00AD", "");
						softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
					}
				}
				if(f>=1)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column2RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column2)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column2a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
				if(f>=2)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column3RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column3)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column3a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
				if(f>=3)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column4RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column4)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column4a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
				if(f==4)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column5RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column5)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column5a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
			}
			if(i==3)
			{
				//Verify corrective action
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column6RC)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column6)).getText();
						String r1 = s.replaceAll("\u00AD", "");
						softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
					}catch(org.openqa.selenium.TimeoutException q)
					{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column6a)).getText();
						String r1 = s.replaceAll("\u00AD", "");
						softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
					}
				}
				if(f>=1)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column2RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column2)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column2a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
				if(f>=2)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column3RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column3)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column3a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
				if(f>=3)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column4RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column4)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column4a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
				if(f==4)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column5RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column5)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column5a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
			}
			if(i==4)
			{
				//Verify corrective action
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column6RC)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column6)).getText();
						String r1 = s.replaceAll("\u00AD", "");
						softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
					}catch(org.openqa.selenium.TimeoutException q)
					{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column6a)).getText();
						String r1 = s.replaceAll("\u00AD", "");
						softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
					}
				}
				if(f>=1)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column2RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column2)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column2a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
				if(f>=2)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column3RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column3)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column3a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
				if(f>=3)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column4RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column4)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column4a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
				if(f==4)
				{
					try{
						String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column5RC)).getText();
						softly.assertThat(s).as("test data").isEqualTo("Yes");
					}catch(org.openqa.selenium.TimeoutException r)
					{
						try{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column5)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}catch(org.openqa.selenium.TimeoutException q)
						{
							String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column5a)).getText();
							softly.assertThat(s).as("test data").isEqualTo("Yes");
						}
					}
				}
			}
		}
	}	 

	public void HTMLStep6Text(WebDriver driver, int x) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int i=1;i<=x;i++)
		{
			if(i==1)
			{
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Row5Column3)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Row5Column3a)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
				}
			}
		}
	}

	public void HTMLStep6(WebDriver driver, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int i=1;i<=y;i++)
		{
			if(i==1)
			{
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Row5Column2)).getText();
					softly.assertThat(s).as("test data").isEqualTo("Yes");
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Row5Column2a)).getText();
					softly.assertThat(s).as("test data").isEqualTo("Yes");
				}
			}
			if(i==2)
			{
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Row6Column2)).getText();
					softly.assertThat(s).as("test data").isEqualTo("Yes");
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Row6Column2a)).getText();
					softly.assertThat(s).as("test data").isEqualTo("Yes");
				}
			}
			if(i==3)
			{
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Row7Column2)).getText();
					softly.assertThat(s).as("test data").isEqualTo("Yes");
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Row7Column2a)).getText();
					softly.assertThat(s).as("test data").isEqualTo("Yes");
				}
			}
			if(i==4)
			{
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Row8Column2)).getText();
					softly.assertThat(s).as("test data").isEqualTo("Yes");
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep6Row8Column2a)).getText();
					softly.assertThat(s).as("test data").isEqualTo("Yes");
				}
			}
		}
	}

	public void HTMLStep5(WebDriver driver, int x) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int i=1;i<=x;i++)
		{
			if(i==1)
			{
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable14Step5Row1Column2)).getText();
					softly.assertThat(s).as("test data").isEqualTo("Yes");
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable14Step5Row1Column2a)).getText();
					softly.assertThat(s).as("test data").isEqualTo("Yes");
				}
			}
			if(i==2)
			{
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable14Step5Row2Column2)).getText();
					softly.assertThat(s).as("test data").isEqualTo("Yes");
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable14Step5Row2Column2a)).getText();
					softly.assertThat(s).as("test data").isEqualTo("Yes");
				}
			}
		}
	}

	public void HTMLStep5Text(WebDriver driver, int x) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int i=1;i<=x;i++)
		{
			if(i==1)
			{
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable14Step5Row1Column3)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable14Step5Row1Column3a)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
				}
			}
			if(i==2)
			{
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable14Step5Row2Column3)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable14Step5Row2Column3a)).getText();
					String r1 = s.replaceAll("\u00AD", "");
					softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
				}
			}
		}
	}

	public void HTMLStep3TableText(WebDriver driver, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int i=1;i<=n;i++)
		{
			if(i==1)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row1Column4)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
			if(i==2)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row2Column4)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
			if(i==3)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row3Column4)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
			if(i==4)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row4Column4)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
			if(i==5)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row5Column4)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
			if(i==6)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row6Column4)).getText();
				String r1 = s.replaceAll("\u00AD", "");
				softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
			}
		}
	}

	public void HTMLStep3Table(WebDriver driver, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//For now x is 6 because there is a bug that exists in eirca, by which even if nothing is selected, the ext still shows up
		//Once it is fixed change function
		//	int x=6;
		HTMLStep3TableText(driver,n);
		for(int i=1;i<=n;i++)
		{
			if(i==1)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row1Column2)).getText();
				softly.assertThat(s).as("test data").isEqualTo("Yes");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row1Column3)).getText();
				softly.assertThat(s1).as("test data").isEqualTo("Yes");
			}
			if(i==2)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row2Column2)).getText();
				softly.assertThat(s).as("test data").isEqualTo("Yes");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row2Column3)).getText();
				softly.assertThat(s1).as("test data").isEqualTo("Yes");
			}
			if(i==3)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row3Column2)).getText();
				softly.assertThat(s).as("test data").isEqualTo("Yes");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row3Column3)).getText();
				softly.assertThat(s1).as("test data").isEqualTo("Yes");
			}
			if(i==4)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row4Column2)).getText();
				softly.assertThat(s).as("test data").isEqualTo("Yes");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row4Column3)).getText();
				softly.assertThat(s1).as("test data").isEqualTo("Yes");
			}
			if(i==5)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row5Column2)).getText();
				softly.assertThat(s).as("test data").isEqualTo("Yes");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row5Column3)).getText();
				softly.assertThat(s1).as("test data").isEqualTo("Yes");
			}
			if(i==6)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row6Column2)).getText();
				softly.assertThat(s).as("test data").isEqualTo("Yes");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row6Column3)).getText();
				softly.assertThat(s1).as("test data").isEqualTo("Yes");
			}
		}
	}

	public void HTMLStep2Table(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Text of failure mode
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable5Step2Row1Column1)).getText();
		String r1 = s.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable5Step2Row1Column2)).getText();
		String r2 = s1.replaceAll("\u00AD", "");
		softly.assertThat(r2).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
	}

	public void HTMLStep1Table(WebDriver driver, String ans1, String ans2, String ans3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//1.1
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable4Step1Q11)).getText();
		softly.assertThat(s).as("test data").isEqualTo(ans1);
		//1.2
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable4Step1Q12)).getText();
		softly.assertThat(s1).as("test data").contains(ans2);
		if(ans2.contains("Other MECHANICAL related components")||ans2.contains("Other ELECTRICAL related components"))
		{
			String r = s1.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
		}
		//1.3
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable4Step1Q13)).getText();
		softly.assertThat(s2).as("test data").contains(ans3);
		if(ans3.contains("Other MECHANICAL related symptoms")||ans3.contains("Other ELECTRICAL related symptoms"))
		{
			String r = s2.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
		}
		//1.4
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable4Step1Q14)).getText();
		String r1 = s3.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
		//1.5
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable4Step1Q15)).getText();
		String r2 = s4.replaceAll("\u00AD", "");
		softly.assertThat(r2).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
		//1.6
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable4Step1Q16)).getText();
		String r3 = s5.replaceAll("\u00AD", "");
		softly.assertThat(r3).as("test data").contains(EiRCA.this.eirca2.textCreate(driver));
	}

	public void pdfCheck(WebDriver driver, HashMap<String,String>hm, String textTitle) throws Exception{

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
		System.out.println(ans);
		String newData2="";
		for (int i = 0; i < ans.size(); i++)
		{	        	
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData2 = newData2+ans.get(i);
			if (ans.get(i).charAt(n)!=' ')
				newData2 = newData2+" "+ans.get(i);	        	
		}
		String newData1 = newData2.replace("  ", " ");
		//Verify text with html
		softly.assertThat(newData1).as("test data").contains(textTitle);
		//Verify Sequence of Events in pdf
		softly.assertThat(newData1).as("test data").contains("Sequence of Events");
		softly.assertThat(newData1).as("test data").contains(hm.get("date1")+", "+hm.get("time1"));
		softly.assertThat(newData1).as("test data").contains(hm.get("what happened1"));
		softly.assertThat(newData1).as("test data").contains(hm.get("what is supposed to happen1"));
		softly.assertThat(newData1).as("test data").contains(hm.get("date2")+", "+hm.get("time2"));
		softly.assertThat(newData1).as("test data").contains(hm.get("what happened2"));
		softly.assertThat(newData1).as("test data").contains(hm.get("what is supposed to happen2"));
		//Close pdf
		pddoc.close();
	}

	public void openReport(WebDriver driver, String recordName) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Clicks on Open button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		//Verify open report pop up
		eirca2.verifyOpenReportPopup(driver, softly, recordName);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		//Clicks on open report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Clicks on Save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();
		//Save pop verify
		eirca2.verifySavePopup(driver, softly);
		//Clicks on Save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		Thread.sleep(1000);
		//Clicks on Saved activities
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).click();
		share2.loadingServer(driver);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		if (browserName.contains("safari"))
		{					
			//Clicks on first newly created record
			wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
			share2.loadingServer(driver);
			//Open eirca report and uncheck the checkboxes
			editEiRCAReport(driver);
		}
	}

	public void downloadRecordChrome(WebDriver driver, HashMap <String,String> hm) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String textTitle = eirca2.textCreate(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)).click();
		//Verify pdf pop up
		eirca2.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify download pop up
		eirca2.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(8000);
		pdfCheck(driver,hm,textTitle);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);	 
		Thread.sleep(3000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		//Open eirca report and uncheck the checkboxes
		editEiRCAReport(driver);
	}

	public void downloadRecordFirefox(WebDriver driver, HashMap <String,String> hm) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String textTitle = eirca2.textCreate(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)).click();
		//Verify pdf pop up
		eirca2.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		System.out.println("original window: "+window);
		//Verify download pop up
		eirca2.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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
		Thread.sleep(2000);/*
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
		p.waitFor();*/
		pdfCheck(driver,hm,textTitle);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();	  
		Thread.sleep(3000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		//Open eirca report and uncheck the checkboxes
		editEiRCAReport(driver);
	}

	public void downloadRecordIE10(WebDriver driver, HashMap <String,String> hm) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String textTitle = eirca2.textCreate(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)).click();
		//Verify pdf pop up
		eirca2.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		eirca2.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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
		pdfCheck(driver,hm,textTitle);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);	   
		Thread.sleep(3000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		//Open eirca report and uncheck the checkboxes
		editEiRCAReport(driver);
	}

	public void downloadRecordIE11(WebDriver driver, HashMap <String,String> hm) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String textTitle = eirca2.textCreate(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)).click();
		//Verify pdf pop up
		eirca2.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		eirca2.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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
		pdfCheck(driver,hm,textTitle);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);
		Thread.sleep(3000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		//Open eirca report and uncheck the checkboxes
		editEiRCAReport(driver);
	}

	public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{

		String sharer = em3.decideSharer (y);
		String sharerAdded = em3.decideSharerAdded (y);	
		shareReportAfterChoosingSharer(driver,username,password1,sharer,sharerAdded);
	}

	public void shareReportAfterChoosingSharer(WebDriver driver,String username, String password1, String sharer, String sharerAdded) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Clicks on share button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareButton)).click();
		//Enters username
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareTextBox)).sendKeys(sharer);
		Thread.sleep(2000);
		//Selects from dropdown
		WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareDropdown));
		dropdown.findElement(eirca.FirstSelectionUnderDropdown).click();
		//Clicks on add user
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Verifies user added
		String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.SharerAdded)).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		share3.shareTwice (driver,softly,0);
		//Clicks on save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareSaveButton)).click();		
		//Verify share save sticky
		eirca2.verifyStickyShareSave(driver, softly);
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Share icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAShareIconOrCriticalIcon));
		//Calls the Share check function
		share.receiptReport(driver, sharer, username, password1);
		//Clicks on EiRCA side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
	}

	public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on mark critical
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		//Mark critical pop up
		eirca2.verifyMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Checks if marked critical
		share2.loadingServer(driver);
		String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
		softly.assertThat(s).as("test data").contains("ui-checkbox-on");
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Marked critical icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAShareIconOrCriticalIcon));
		//Verify presence of shared icon 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAShareIconWhenAlsoMarkedCritical));
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		share2.loadingServer(driver);
		//Clicks on mark critical again
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		//Un Mark critical pop up
		eirca2.verifyUnMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(2000);
		share2.loadingServer(driver);
		String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
		softly.assertThat(s1).as("test data").contains("ui-checkbox-off");
		//Verify report not retrieved by shared to person
		String sharer = em3.decideSharer (y);
		share.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on EiRCA side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
	}

	public void editEiRCAReport(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Open Report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();/*
		//Click on Step 1 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Tab)).click();
		//Select other mechanical/electrical and erase
		WebElement dropdown1 = driver.findElement(eirca.Step1Q13Answer);
		Select s1 = new Select(dropdown1);
		s1.selectByIndex(17);
		//Enter text in textbox
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step1Q13AnswerTextBox)).sendKeys(textToVerifyClearTextBox);
		//Select some other option
		s1.selectByIndex(12);
		//Verify the text is gone
		if(driver.findElement(eirca.Step1Q13AnswerTextBox).isDisplayed()==false)
			softly.fail("Step 1 text box visible after selecting other options other than mechanical/electrical related symptoms");*/
		//Click on Step 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep3Tab)).click();
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsible)).click();
		//Check any boxes
		if(driver.findElement(eirca.Step3TableOption31CheckBox).isSelected() ==false)
		{
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBox)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBox)));
		}
		if(driver.findElement(eirca.Step3TableOption32CheckBox).isSelected() ==false)
		{
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption32CheckBox)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption32CheckBox)));
		}
		if(driver.findElement(eirca.Step3TableOption33CheckBox).isSelected() ==false)
		{
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption33CheckBox)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption33CheckBox)));
		}
		if(driver.findElement(eirca.Step3TableOption34CheckBox).isSelected() ==false)
		{
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption34CheckBox)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption34CheckBox)));
		}
		if(driver.findElement(eirca.Step3TableOption35CheckBox).isSelected() ==false)
		{
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption35CheckBox)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption35CheckBox)));
		}
		if(driver.findElement(eirca.Step3TableOption36CheckBox).isSelected() ==false)
		{
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption36CheckBox)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption36CheckBox)));
		}
		share2.scrollToTop(driver);
		//Enter text
		fillTextStep3(driver,textToVerifyClearTextBox);
		// KALE 2227 or QAA 619, click next on step 3 after refuting the failure mode and verify that report tab is seen
		//*
		//Save report
		saveEiRCAReport(driver);
		//uncheck the boxes and verify the text is gone
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row1Column4)).getText();
		softly.assertThat(s).as("test data").contains(textToVerifyClearTextBox);
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row2Column4)).getText();
		softly.assertThat(s1).as("test data").contains(textToVerifyClearTextBox);
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row3Column4)).getText();
		softly.assertThat(s2).as("test data").contains(textToVerifyClearTextBox);
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row4Column4)).getText();
		softly.assertThat(s3).as("test data").contains(textToVerifyClearTextBox);
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row5Column4)).getText();
		softly.assertThat(s4).as("test data").contains(textToVerifyClearTextBox);
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row6Column4)).getText();
		softly.assertThat(s5).as("test data").contains(textToVerifyClearTextBox);
		//Open Report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Click on Step 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep3Tab)).click();
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsible)).click();
		//UnCheck any boxes
		if(driver.findElement(eirca.Step3TableOption31CheckBox).isSelected() ==true)
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBox)).click();
		if(driver.findElement(eirca.Step3TableOption32CheckBox).isSelected() ==true)
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption32CheckBox)).click();
		if(driver.findElement(eirca.Step3TableOption33CheckBox).isSelected() ==true)
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption33CheckBox)).click();
		if(driver.findElement(eirca.Step3TableOption34CheckBox).isSelected() ==true)
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption34CheckBox)).click();
		if(driver.findElement(eirca.Step3TableOption35CheckBox).isSelected() ==true)
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption35CheckBox)).click();
		if(driver.findElement(eirca.Step3TableOption36CheckBox).isSelected() ==true)
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption36CheckBox)).click();
		//Save report
		saveEiRCAReport(driver);
		//Verify no text is visible in step 3 table
		/*	try{
			String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row1Column4)).getText();
			softly.assertThat(s6).as("test data").isEmpty();
			String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row2Column4)).getText();
			softly.assertThat(s7).as("test data").isEmpty();
			String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row3Column4)).getText();
			softly.assertThat(s8).as("test data").isEmpty();
			String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row4Column4)).getText();
			softly.assertThat(s9).as("test data").isEmpty();
			String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row5Column4)).getText();
			softly.assertThat(s10).as("test data").isEmpty();
			String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Row6Column4)).getText();
			softly.assertThat(s11).as("test data").isEmpty();
		}catch(org.openqa.selenium.TimeoutException t)
		{*/
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable7Step3Skipped)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Step 3 - Statements of Refutability (skipped)");
		//	}
		//Open Report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Click on Step 4
		System.out.println(driver.findElement(eirca.EiRCAStep4Tab).getAttribute("class"));
		if(driver.findElement(eirca.EiRCAStep4Tab).getAttribute("class").contains("ui-state-disabled")==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep4Tab)).click();			
			//Click on collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)).click();
			//Check any boxes
			String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TableOption44CheckBox)).getAttribute("checked");
			System.out.println("Strings.isNullOrEmpty(s12) : "+Strings.isNullOrEmpty(s12) + " "+s12);
			if(Strings.isNullOrEmpty(s12)==true)
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TableOption44CheckBox)).click();
			//Enter text
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeOption44Textbox)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeOption44Textbox)).sendKeys(textToVerifyClearTextBox);
			//Save report
			saveEiRCAReport(driver);
			//verify text in html in step 4 table
			String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table1Row4Column3)).getText();
			softly.assertThat(s13).as("test data").contains(textToVerifyClearTextBox);
			//Open Report
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
			//uncheck the boxes and verify the text is gone
			//Click on Step 4
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep4Tab)).click();
			//Click on collapsible
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)).click();
			//Uncheck
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TableOption44CheckBox)).click();
			//Save report
			saveEiRCAReport(driver);
			//Verify text is gone
			/*	try{
				String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4Table1Row4Column3)).getText();
				softly.assertThat(s14).as("test data").isEmpty();
			}catch(org.openqa.selenium.TimeoutException y)
			{*/
			WebElement ele;
			try{
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4SkippedRCA));
			}catch(org.openqa.selenium.TimeoutException t)
			{
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep4SkippedRCA2));
			}
			String s14 = ele.getText();
			softly.assertThat(s14).as("test data").contains("Step 4 - Probability of Occurrence and Actions (skipped)");
			//}
			//Open Report
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();		
		}
		//Scroll to Tab Step 5
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep5Tab)));
		//	if(driver.findElement(eirca.EiRCAStep5Tab).isEnabled()==false)
		//{
		if(driver.findElement(eirca.EiRCAStep4Tab).getAttribute("class").contains("ui-state-disabled")==false)
		{
			//Click on Step 4
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep4Tab)).click();	
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();			
			//click on continue to rca
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();	
		}
		else
		{
			//Click on Step 3
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep3Tab)).click();	
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();			
		}	
		//}
		//else
		//wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep5Tab)).click();
		//	try{
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5FailureCollapsible)).click();
		//Check any boxes
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption55CheckBox));
		share2.scrollToElement(driver, l);
		//Click on 5.5
		if(l.isSelected()==false)
			jse.executeScript("arguments[0].click();", l);
		WebElement l1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption56CheckBox));
		share2.scrollToElement(driver, l1);
		//Click on 5.6
		if(l1.isSelected()==false)
			jse.executeScript("arguments[0].click();", l1);
		//Enter text		
		l = driver.findElement(eirca.Step5TableOption55Textbox);
		share2.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption55Textbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption55Textbox)).sendKeys(textToVerifyClearTextBox);
		l = driver.findElement(eirca.Step5TableOption56Textbox);
		share2.scrollToElement(driver, l);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption56Textbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption56Textbox)).sendKeys(textToVerifyClearTextBox);
		/*	}catch(org.openqa.selenium.TimeoutException r)
		{

		}*/
		//Save report
		saveEiRCAReport(driver);
		//Verify text
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable14Step5Row1Column3)).getText();
		softly.assertThat(s15).as("test data").contains(textToVerifyClearTextBox);
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLTable14Step5Row2Column3)).getText();
		softly.assertThat(s16).as("test data").contains(textToVerifyClearTextBox);
		//Open Report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//uncheck the boxes and verify the text is gone
		//Click on Step 5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep5Tab)).click();
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5FailureCollapsible)).click();
		//Check any boxes
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption55CheckBox));
		share2.scrollToElement(driver, l);
		//Click on 5.5
		l.click();
		l1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption56CheckBox));
		share2.scrollToElement(driver, l1);
		//Click on 5.6
		l1.click();
		//Save report and verify html that it has no text from Step 5
		saveEiRCAReport(driver);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		if (browserName.contains("safari")==false)
		{					
			String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep5Skipped)).getText();
			softly.assertThat(s17).as("test data").isEqualTo("Step 5 - Identify Possible Contributing Factors (skipped)");
		}
		//Verify save popup overflow text for rename report
		eirca3.verifySavePopupAfterRename(driver, softly);
	}

	public void saveEiRCAReport(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Save report
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		//Verify save sticky
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Clicks on Saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).click();
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		share2.loadingServer(driver);
	}

	public void verifyProbStatementPlaceHolder(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get place holder of Problem Statement and verify that it is not "foo"
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventProblemStatementField)).getAttribute("placeholder");
		softly.assertThat(s).as("test data").isEqualTo("Fill in Problem statement");
	}

	public void verifySequenceOfEvents(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAInfoPageTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Sequence of Events");
		//Verify description text not visible
		try{
			WebElement l = driver.findElement(eirca.DescriptionText);
			if(l.isDisplayed()==true)
				softly.fail("Description text visible");
		}catch (org.openqa.selenium.NoSuchElementException r)
		{
			System.out.println("No description text visible as the + sign for description has not been clicked");
		}
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.DescriptionPlusSign)).click();
		//Verify description text
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.DescriptionText)).getText();
		String desc = "The sequence of events is a series of related situations occurring prior to and after the triggering error. "
				+ "It is composed of a series of time-specific events of facts and data. The time-specific events are presented in a timeline to describe how"
				+ " the final failure (or event or unacceptable consequence) occurred. The purpose of developing the sequence of events is to determine the "
				+ "triggering error(s) that provoked the chain of events leading to the final failure (or unacceptable consequence).";
		String desc1 = "Add and describe each time-specific event (or step) leading up to the final failure or unacceptable consequence. In the column to the right, "
				+ "describe what should have happened instead of what actually occurred. This will help point out where any abnormal condition occurred.";
		softly.assertThat(s1).as("test data").contains(desc);
		softly.assertThat(s1).as("test data").contains(desc1);
		//Click on Description again
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.DescriptionPlusSign)).click();
		//Verify description text not visible
		try{
			WebElement l = driver.findElement(eirca.DescriptionText);
			if(l.isDisplayed()==true)
				softly.fail("Description text visible");
		}catch (org.openqa.selenium.NoSuchElementException r)
		{
			System.out.println("No description text visible as the + sign for description has not been clicked");
		}
		//Verify date box header
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.DateHeader)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Date:");
		//Verify time box header
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.TimeHeader)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Time:");
		//Verify What happened box header
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappenedHeader)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("What happened?:");
		//Verify What is supposed to happen box header
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappenHeader)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("What is supposed to happen?:");
		//Verify placeholder for What happened box
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappenedField)).getAttribute("placeholder");
		softly.assertThat(s6).as("test data").isEqualTo("Description of each related step prior to and after the triggering error, leading to the event.");
		//Verify placeholder for What is supposed to happen box
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappenField)).getAttribute("placeholder");
		softly.assertThat(s7).as("test data").isEqualTo("Description of what should happen instead of the abnormal condition that occurred.");
	}



	public void verifyEmptyTexBox(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify empty text in what happened
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappenedField)).getText();
		//Verify empty text in what is supposed to happen
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappenField)).getText();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		if (browserName.equals("internet explorer"))
		{
			softly.assertThat(s).as("test data").isEqualTo("Description of each related step prior to and after the triggering error, leading to the event.");
			softly.assertThat(s1).as("test data").isEqualTo("Description of what should happen instead of the abnormal condition that occurred.");
		}
		else
		{
			softly.assertThat(s).as("test data").isEqualTo("");
			softly.assertThat(s1).as("test data").isEqualTo("");
		}
	}

	public void verifyTextEditable(WebDriver driver,WebElement ele, String text) throws Exception {

		//Get text present in text box
		String s = ele.getAttribute("value");
		System.out.println(s);
		//CLear some text
		for (int i=0;i<6;i++)
			ele.sendKeys(Keys.BACK_SPACE);
		//Clear all text
		ele.clear();
		//Enter new text in text box
		ele.sendKeys(text);
		String s1 = ele.getAttribute("value");
		System.out.println(s1);
		if(s.equals(s1)==true)
			softly.fail("Text could not be edited for web element: \n"+ele);
	}

	public HashMap<String,String> storeEvent(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//First listed event
		//Get date
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date1stEvent)).getAttribute("value");
		//Get time
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Time1stEvent)).getAttribute("value");
		//Get what happened
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappened1stEvent)).getAttribute("value");
		//Get what is supposed to happen
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappen1stEvent)).getAttribute("value");
		//Second listed event
		//Get date
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date2ndEvent)).getAttribute("value");
		//Get time
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Time2ndEvent)).getAttribute("value");
		//Get what happened
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappened2ndEvent)).getAttribute("value");
		//Get what is supposed to happen
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappen2ndEvent)).getAttribute("value");
		//Store in HashMap
		HashMap <String,String> hm = new HashMap<String,String>();
		hm.put("date1", s.replace("\u00AD", ""));
		hm.put("time1", s1.replace("\u00AD", ""));
		hm.put("what happened1", s2.replace("\u00AD", ""));
		hm.put("what is supposed to happen1", s3.replace("\u00AD", ""));	    	
		hm.put("date2", s4.replace("\u00AD", ""));
		hm.put("time2", s5.replace("\u00AD", ""));
		hm.put("what happened2", s6.replace("\u00AD", ""));
		hm.put("what is supposed to happen2", s7.replace("\u00AD", ""));	
		return hm;
	}



	public void changeDate(WebDriver driver, By CalendarIcon) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on calendar icon add event
		wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarIcon)).click();
		//Click on - sign twice
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarMinusSign)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarMinusSign)).click();
		//Select 1st date of 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Calendar1stRow1stDate)).click();
	}

	public void makeDateSame(WebDriver driver, By CalendarIcon) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on calendar icon on event
		wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarIcon)).click();
		//Click on - sign once
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarMinusSign)).click();
		//Select 1st date of 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Calendar1stRow1stDate)).click();	    	
	}

	public void changeTime(WebDriver driver, By ClockIcon) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on clock icon on 2nd event
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClockIcon)).click();
		//Click on - sign of hour
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockHourMinusSign)).click();
		//Click on set time
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockSetTime)).click();
	}

	public String[] editTextBox(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappened1stEvent)).sendKeys("aaaaa");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappen1stEvent)).sendKeys("aaaaa");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappened1stEvent)).getAttribute("value");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappen1stEvent)).getAttribute("value");
		String[]s = {s1,s2};
		return s;
	}

	public void verifyEditedText(WebDriver driver, String[]s) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappened2ndEvent)).getAttribute("value");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappen2ndEvent)).getAttribute("value");
		softly.assertThat(s1).as("test data").isEqualTo(s[0]);
		softly.assertThat(s2).as("test data").isEqualTo(s[1]);
	}

	public void delete2ndEvent(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on cross symbol of 2nd event row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.DeleteSign2ndEvent)).click();
		//Click delete button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
	}

	public HashMap<String,String> pathEiRCASequenceOfEvents(WebDriver driver, String username) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Scroll to the bottom
		share2.scrollToAPoint(driver, 1200);
		//Click next
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NextButtonBottomOfInfoPage)));
		Thread.sleep(2000);
		//Scroll to the top
		share2.scrollToTop(driver);
		//Verify text in Sequence of Events
		verifySequenceOfEvents(driver);
		//Get list of text
		List <String> list1=em2.error50Data(driver,driver.getCurrentUrl());
		Iterator<String> iter = Iterables.cycle(list1).iterator();
		//Create a new event
		eirca2.createNewEvent(driver, iter.next(),softly);
		//Verify text boxes empty after adding event
		verifyEmptyTexBox(driver);
		//Edit text in boxes of event added
		String[]s=editTextBox(driver);
		//Create another new event
		eirca2.createNewEvent(driver, iter.next(),softly);
		//Verify text edited in event added first
		verifyEditedText(driver,s);
		//Verify text boxes empty after adding event
		verifyEmptyTexBox(driver);
		//Verify text is editable in what happened box for 1st row
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappened1stEvent));
		verifyTextEditable(driver,ele, iter.next());
		//Verify text is editable in what is supposed to happen box for 1st row
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappen1stEvent));
		verifyTextEditable(driver,ele, iter.next());
		//Verify text is editable in what happened box for 2nd row
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappened2ndEvent));
		verifyTextEditable(driver,ele, iter.next());
		//Verify text is editable in what is supposed to happen box for 2nd row
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappen2ndEvent));
		verifyTextEditable(driver,ele, iter.next());
		//Create another new event
		eirca2.createNewEvent(driver, iter.next(),softly);
		//Verify the events are organised as per date and time
		HashMap<String,String> hm = eirca3.verifyOrderOfEvents(driver,softly,3);
		System.out.println(hm);
		//Change date on 2nd row
		changeDate(driver,eirca.CalendarIcon2ndEvent);
		Thread.sleep(1000);
		//Verify the events are organised as per date and time
		HashMap<String,String> hm1 = eirca3.verifyOrderOfEvents(driver,softly,3);
		System.out.println(hm1);
		//Verify changes have been saved
		verifyChangesSavedSequenceOfEvents(driver,hm1, username,0);
		//Change date on 3rd row
		changeDate(driver,eirca.CalendarIcon3rdEvent);
		Thread.sleep(1000);
		//Verify the events are organised as per date and time
		HashMap<String,String> hm4 = eirca3.verifyOrderOfEvents(driver,softly,3);
		System.out.println(hm4);
		//Verify changes have been saved
		verifyChangesSavedSequenceOfEvents(driver,hm4, username,1);
		//Make date same and change time on 3rd row
		makeDateSame(driver,eirca.CalendarIcon3rdEvent);
		Thread.sleep(1000);
		//Make date same and change time on 3rd row
		makeDateSame(driver,eirca.CalendarIcon3rdEvent);
		Thread.sleep(1000);
		//Make time different
		changeTime(driver,eirca.ClockIcon2ndEvent);
		Thread.sleep(1000);
		changeTime(driver,eirca.ClockIcon3rdEvent);
		Thread.sleep(1000);
		changeTime(driver,eirca.ClockIcon2ndEvent);
		Thread.sleep(1000);
		//Verify the events are organised as per date and time
		HashMap<String,String> hm2 = eirca3.verifyOrderOfEvents(driver,softly,3);
		System.out.println(hm2);
		//Verify changes have been saved
		verifyChangesSavedSequenceOfEvents(driver,hm2, username,1);
		//Delete 2nd event
		delete2ndEvent(driver);
		//Store all event data in hashmap
		HashMap<String,String>hm3 = storeEvent(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();		
		return hm3;
	}

	public void verifyChangesSavedSequenceOfEvents(WebDriver driver, HashMap<String,String> hm1, String username, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(1000);
		share2.scrollToTop(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		Thread.sleep(1000);
		//Click on info page
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.InfoTab)).click();	
		Thread.sleep(1000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Verify the events are organised as per date and time
		HashMap<String,String> hm = eirca3.verifyOrderOfEvents(driver, softly,3);
		System.out.println(hm);
		Thread.sleep(1000);
		//boolean b = hm.entrySet().stream().filter(value -> hm1.entrySet().stream().anyMatch(value1 -> (value1.getKey() == value.getKey() && value1.getValue() == value.getValue()))).findAny().isPresent();
		boolean b = hm.equals(hm1);
		System.out.println(b);
		if(b==false)
			softly.fail("Changes did not get saved: \n"+hm1+"\n"+hm);
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();	
		//Save pop verify
		eirca2.verifySavePopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		//Verify sticky save
		eirca2.verifyStickySaveReport(driver, softly, username, eirca2.textCreate(driver), n);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		Thread.sleep(1000);
		//Saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).click();	
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();	
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Click on 1st record
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		share2.loadingServer(driver);
		//Verify the time and date of the sequence of events
		//Verify Sequence of Events title
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageDateTimeTitle1)).getText();
		softly.assertThat(s1).as("test data").isEqualTo(hm1.get("Date 1st row")+", "+hm1.get("Time 1st row"));    
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageDateTimeTitle2)).getText();
		softly.assertThat(s2).as("test data").isEqualTo(hm1.get("Date 2nd row")+", "+hm1.get("Time 2nd row"));    
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageDateTimeTitle3)).getText();
		softly.assertThat(s3).as("test data").isEqualTo(hm1.get("Date 3rd row")+", "+hm1.get("Time 3rd row"));    
		//Click on open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
	}

	public void EIRCAStep2(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(1000);
		//Verify no next button without mandatory dropdowns selected
		if(driver.findElement(eirca.EiRCANextButton).isDisplayed()==true)
			softly.fail("Next button visible in Step 2 without adding a failure mode");
		//Fill text in 1st box 1st row
		//tbr.sizeCheck(driver, eirca.Step2Row11stTextBoxField,softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2Row11stTextBoxField)).sendKeys(eirca2.textCreate(driver));
		//tbr.sizeCheck(driver, eirca.Step2Row12ndTextBoxField,softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2Row12ndTextBoxField)).sendKeys(eirca2.textCreate(driver));
		//Verify next button is visible after mandatory dropdowns are selected
		if(driver.findElement(eirca.EiRCANextButton).isDisplayed()==false)
			softly.fail("Next button not visible in Step 2 after adding failure mode");
		//Click on add failure mode button
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2AddFailureButton)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2AddFailureButton)).click();
		while(true)
		{
			if(driver.findElement(eirca.Step2Row21stTextBoxField).isDisplayed())
				break;
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2AddFailureButton)).click();
		}
		//Verify visibility of 2nd row of boxes
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step2Row21stTextBoxField));
		Thread.sleep(1000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();		
	}

	public int EIRCAStep3(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3FailureCollapsible)).click();
		//Choose a number between 0 to 6
		Random random = new Random();
		int n = random.nextInt(7);
		//Fill text in Step 3
		//fillTextStep3(driver, eirca2.textCreate(driver));
		//n = 0;
		Thread.sleep(1000);
		if(n==0)
		{
			System.out.println("No failure modes are refuted.");
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
			return n;
		}
		//Select options in Step 3
		for(int i=1;i<=n;i++)
		{
			if(i==1)
			{
				//Click on check box for 3.1
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31CheckBox)).click();		
				tbr.sizeCheck(driver, eirca.Step3TableOption31Textbox,softly);
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31Textbox)).sendKeys(eirca2.textCreate(driver));
			}
			if(i==2)
			{
				//Click on check box for 3.2
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption32CheckBox)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption32CheckBox)));	
				tbr.sizeCheck(driver, eirca.Step3TableOption32Textbox,softly);
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption32Textbox)).sendKeys(eirca2.textCreate(driver));
			}
			if(i==3)
			{
				//Click on check box for 3.3
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption33CheckBox)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption33CheckBox)));	
				tbr.sizeCheck(driver, eirca.Step3TableOption33Textbox,softly);
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption33Textbox)).sendKeys(eirca2.textCreate(driver));
			}
			if(i==4)
			{
				//Click on check box for 3.4
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption34CheckBox)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption34CheckBox)));		
				tbr.sizeCheck(driver, eirca.Step3TableOption34Textbox,softly);
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption34Textbox)).sendKeys(eirca2.textCreate(driver));
			}
			if(i==5)
			{
				//Click on check box for 3.5
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption35CheckBox)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption35CheckBox)));	
				tbr.sizeCheck(driver, eirca.Step3TableOption35Textbox,softly);
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption35Textbox)).sendKeys(eirca2.textCreate(driver));
			}
			if(i==6)
			{
				//Click on check box for 3.6
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption36CheckBox)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption36CheckBox)));	
				tbr.sizeCheck(driver, eirca.Step3TableOption36Textbox,softly);
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption36Textbox)).sendKeys(eirca2.textCreate(driver));
			}	    		
		}
		//Scroll to the top
		Thread.sleep(500);
		share2.scrollToTop(driver);
		Thread.sleep(500);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Click on see report
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).click();	
		return n;
	}

	public void fillTextStep3(WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Fill in text in 3.1	
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31Textbox)));
		tbr.sizeCheck(driver, eirca.Step3TableOption31Textbox,softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31Textbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption31Textbox)).sendKeys(text);
		//Fill in text in 3.2	
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption32Textbox)));
		tbr.sizeCheck(driver, eirca.Step3TableOption32Textbox,softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption32Textbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption32Textbox)).sendKeys(text);
		//Fill in text in 3.3	
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption33Textbox)));
		tbr.sizeCheck(driver, eirca.Step3TableOption33Textbox,softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption33Textbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption33Textbox)).sendKeys(text);
		//Fill in text in 3.4	
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption34Textbox)));
		tbr.sizeCheck(driver, eirca.Step3TableOption34Textbox,softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption34Textbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption34Textbox)).sendKeys(text);
		//Fill in text in 3.5	
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption35Textbox)));
		tbr.sizeCheck(driver, eirca.Step3TableOption35Textbox,softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption35Textbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption35Textbox)).sendKeys(text);
		//Fill in text in 3.6	
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption36Textbox)));
		tbr.sizeCheck(driver, eirca.Step3TableOption36Textbox,softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption36Textbox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TableOption36Textbox)).sendKeys(text);
		//Scroll to the top
		Thread.sleep(500);
		share2.scrollToTop(driver);
		Thread.sleep(500);
	}

	public int EIRCAStep4OneFailureMode(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Choose 0 or 1
		Random random = new Random ();
		int n = random.nextInt(2);
		Thread.sleep(1000);
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureCollapsible)).click();
		if(n==1)
		{
			//Select 4.4
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TableOption44CheckBox)).click();
			//Fill in text in 4.4	
			tbr.sizeCheck(driver, eirca.Step4FailureModeOption44Textbox,softly);
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4FailureModeOption44Textbox)).sendKeys(eirca2.textCreate(driver));
		}
		Thread.sleep(1000);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		Thread.sleep(1000);
		//Click on continue
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		Thread.sleep(1000);
		return n;
	}

	public int EIRCAStep5OneFailureMode(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5FailureCollapsible)).click();
		Thread.sleep(1000);
		//Choose 0 to 2
		Random random = new Random ();
		int n = random.nextInt(3);
		//Fill text in 5.5 and 5.6
		//fillTextStep5(driver);
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
			return n;
		}
		for(int i=1;i<=n;i++)
		{
			if(i==1)
			{
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption55CheckBox));
				share2.scrollToElement(driver, l);
				//Click on 5.5
				l.click();
				//Fill in text in 5.5
				tbr.sizeCheck(driver, eirca.Step5TableOption55Textbox,softly);
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption55Textbox)).sendKeys(eirca2.textCreate(driver));
			}
			if(i==2)
			{
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption56CheckBox));
				share2.scrollToElement(driver, l);
				//Click on 5.6
				l.click();
				//Fill in text in 5.6
				tbr.sizeCheck(driver, eirca.Step5TableOption56Textbox,softly);
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption56Textbox)).sendKeys(eirca2.textCreate(driver));
			}
		}
		//Scroll to the top
		Thread.sleep(500);
		share2.scrollToTop(driver);
		Thread.sleep(500);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		return n;
	}

	public void fillTextStep5(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption56CheckBox));
		share2.scrollToElement(driver, l);
		//Fill in text in 5.5
		tbr.sizeCheck(driver, eirca.Step5TableOption55Textbox,softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption55Textbox)).sendKeys(eirca2.textCreate(driver));
		//Fill in text in 5.6
		tbr.sizeCheck(driver, eirca.Step5TableOption56Textbox,softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TableOption56Textbox)).sendKeys(eirca2.textCreate(driver));
		//Scroll to the top
		Thread.sleep(500);
		share2.scrollToTop(driver);
		Thread.sleep(500);
	}

	public int EIRCAStep6OneFailureMode(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6FailureCollapsible)).click();
		//Choose 0 to 4
		Random random = new Random ();
		int n = random.nextInt(5);
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
			return n;
		}
		for(int i=1;i<=n;i++)
		{
			if(i==1)
			{
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6TableOption65CheckBox));
				share2.scrollToElement(driver, l);
				//Click on 6.5
				l.click();
				//Fill in text in 6.5
				tbr.sizeCheck(driver, eirca.Step6TableOption65Textbox,softly);
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6TableOption65Textbox)).sendKeys(eirca2.textCreate(driver));
			}
			if(i==2)
			{
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6TableOption66CheckBox));
				share2.scrollToElement(driver, l);
				//Click on 6.6
				l.click();
			}
			if(i==3)
			{
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6TableOption67CheckBox));
				share2.scrollToElement(driver, l);
				//Click on 6.7
				l.click();
			}
			if(i==4)
			{
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6TableOption68CheckBox));
				share2.scrollToElement(driver, l);
				//Click on 6.8
				l.click();
			}
		}
		//Scroll to the top
		Thread.sleep(500);
		share2.scrollToTop(driver);
		Thread.sleep(500);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		return n;
	}

	public int chooseNumberOfSUEPBoxes() throws Exception {

		//Choose 0 to 4
		Random random = new Random();
		return random.nextInt(5);
	}

	public String checkIfStep6Option65IsSelected(String key) throws Exception {

		if(key.contains("Culprit work activities"))
		{
			int n = key.indexOf(":");
			String s = key.substring(0, n);
			return s;
		}
		else return key;
	}

	public HashMap<String,Integer> EiRCAStep7OneFailureMode(WebDriver driver, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		HashMap<String,Integer> c = new HashMap<String,Integer>();
		eirca2.verifyBoldContributingFactorFont(driver, n);
		for(int i=1;i<=n;i++)
		{
			int k = chooseNumberOfSUEPBoxes();
			if(i==1)
			{
				String key = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow2)).getText();
				c.put(checkIfStep6Option65IsSelected(key), k);
				if(k==1)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow2Chk1)).click();
				}
				if(k==2)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow2Chk1)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow2Chk2)).click();
				}
				if(k==3)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow2Chk1)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow2Chk2)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow2Chk3)).click();
				}
				if(k==4)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow2Chk1)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow2Chk2)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow2Chk3)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow2Chk4)).click();
				}
				//Fill corrective action
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow2CorrectiveAction)).sendKeys(eirca2.textCreate(driver));
			}
			if(i==2)
			{
				String key = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow3)).getText();
				c.put(checkIfStep6Option65IsSelected(key), k);
				if(k==1)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow3Chk1)).click();
				}
				if(k==2)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow3Chk1)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow3Chk2)).click();
				}
				if(k==3)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow3Chk1)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow3Chk2)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow3Chk3)).click();
				}
				if(k==4)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow3Chk1)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow3Chk2)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow3Chk3)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow3Chk4)).click();
				}
				//Fill corrective action
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow3CorrectiveAction)).sendKeys(eirca2.textCreate(driver));
			}
			if(i==3)
			{
				String key = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow4)).getText();
				c.put(checkIfStep6Option65IsSelected(key), k);
				if(k==1)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow4Chk1)).click();
				}
				if(k==2)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow4Chk1)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow4Chk2)).click();
				}
				if(k==3)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow4Chk1)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow4Chk2)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow4Chk3)).click();
				}
				if(k==4)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow4Chk1)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow4Chk2)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow4Chk3)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow4Chk4)).click();
				}
				//Fill corrective action
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow4CorrectiveAction)).sendKeys(eirca2.textCreate(driver));
			}
			if(i==4)
			{
				String key = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow5)).getText();
				c.put(checkIfStep6Option65IsSelected(key), k);
				if(k==1)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow5Chk1)).click();
				}
				if(k==2)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow5Chk1)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow5Chk2)).click();
				}
				if(k==3)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow5Chk1)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow5Chk2)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow5Chk3)).click();
				}
				if(k==4)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow5Chk1)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow5Chk2)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow5Chk3)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow5Chk4)).click();
				}
				//Fill corrective action
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7SUEPTableRow5CorrectiveAction)).sendKeys(eirca2.textCreate(driver));
			}
		}
		return c;
	}

	public int getCharCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(eirca.TitleCharacterCount).getText();
		s=s.substring(1,s.indexOf("/"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public int getTotalCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(eirca.TitleCharacterCount).getText();
		s=s.substring((s.indexOf("/")+1), s.indexOf(")"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public void checkTitleCountReset(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventTitleField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventTitleField)).sendKeys("aaaa");
		//Get count
		int count = getCharCountFromTitle(driver);
		if(count!=4)
			softly.fail("Count did not match: aaaa: " + count);
		//Clear text
		for(int i=0;i<4;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventTitleField)).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(250);
		}
		count = getCharCountFromTitle(driver);
		if(count!=1)
			softly.fail("Count did not match: aaaa: " + count);
	}

	public HashMap<String,String> reportCreate(WebDriver driver,String username) throws Exception {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		String text = eirca2.textCreate(driver);
		//Clicks on EiRCA
		jse.executeScript("return document.getElementById('pii-a-menu-eirca').click();");
		Thread.sleep(1000);
		//Verify placeholder of problem statement
		verifyProbStatementPlaceHolder(driver);
		//Verify new report pop up
		eirca2.verifyNewReportPopup(driver, softly);
		//Verify Error Messages for mandatory fields on Info page
		eirca2.verifyErrorMessagesInfoPage(driver,softly);
		//Check title count reset when characters are entered and deleted
		checkTitleCountReset(driver);
		//Fills all mandatory fields
		//Verify the optional in event id
		String opt = driver.findElement(eirca.EiRCAEventIdField).getAttribute("placeholder");
		softly.assertThat(opt).as("test data").isEqualTo("Fill in Event ID (optional)");
		driver.findElement(eirca.EiRCAEventTitleField).sendKeys(text);
		//Get count
		int count = getCharCountFromTitle(driver);
		int total = getTotalCountFromTitle(driver);
		for(int i=count+1;i<=total;i++)
		{
			driver.findElement(eirca.EiRCAEventTitleField).sendKeys("z");
		}
		driver.findElement(eirca.EiRCAEventLocationField).sendKeys(text);
		//tbr.sizeCheck(driver, eirca.EiRCAEventReporterField, softly);
		driver.findElement(eirca.EiRCAEventReporterField).sendKeys(text); 
		tbr.sizeCheck(driver, eirca.EiRCAEventInvestigatorField, softly);
		driver.findElement(eirca.EiRCAEventInvestigatorField).sendKeys(text);
		//tbr.sizeCheck(driver, eirca.EiRCAEventReviewerField, softly);
		driver.findElement(eirca.EiRCAEventReviewerField).sendKeys(text);
		//tbr.sizeCheck(driver, eirca.EiRCAEventSponsorField, softly);
		driver.findElement(eirca.EiRCAEventSponsorField).sendKeys(text);
		tbr.sizeCheck(driver, eirca.EiRCAEventProblemStatementField, softly);
		driver.findElement(eirca.EiRCAEventProblemStatementField).sendKeys(text);
		//tbr.sizeCheck(driver, eirca.EiRCAEventComponentField, softly);
//		driver.findElement(eirca.EiRCAEventComponentField).sendKeys(text);
		String ev1 = driver.findElement(eirca.EiRCAEventTitleField).getAttribute("value");
		String ev2 = driver.findElement(eirca.EiRCAEventLocationField).getAttribute("value");
		String ev3 = driver.findElement(eirca.EiRCAEventReporterField).getAttribute("value");
		String ev4 = driver.findElement(eirca.EiRCAEventInvestigatorField).getAttribute("value");
		String ev5 = driver.findElement(eirca.EiRCAEventReviewerField).getAttribute("value");
		String ev6 = driver.findElement(eirca.EiRCAEventSponsorField).getAttribute("value");
		String ev7= driver.findElement(eirca.EiRCAEventProblemStatementField).getAttribute("value");
//		String ev8= driver.findElement(eirca.EiRCAEventComponentField).getAttribute("value");
		/*if ((ev1.equals(text)==false))
		{
			driver.findElement(eirca.EiRCAEventTitleField).clear();
			driver.findElement(eirca.EiRCAEventTitleField).sendKeys(text);
		}*/
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
		/*if ((ev8.equals(text)==false))
		{
			driver.findElement(eirca.EiRCAEventComponentField).clear();
			driver.findElement(eirca.EiRCAEventComponentField).sendKeys(text);
		}*/
		//Verify errors have disappeared
		eirca2.verifyNoErrorsOnInfoPage(driver);
		//Sequence of Events
		HashMap<String,String>hm = pathEiRCASequenceOfEvents(driver,username);
		//Step1
		eirca2.EIRCAStep1Troubleshooting(driver,eirca2.textCreate(driver),softly);
		String s2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q11AnswerSelected)).getText();
		//Get 1.2 selected answer
		String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q12AnswerSelected)).getText();
		//Get 1.3 selected answer
		String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q13AnswerSelected)).getText();
		//Click next
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)));	
		//Step2
		EIRCAStep2(driver);
		//Step3
		int n = EIRCAStep3(driver);
		int x,y,z;
		x=0;
		y=0;
		z=0;
		if(n==0)
		{
			//Step 4
			if(s2.equals("Troubleshooting"))
				x = EIRCAStep4OneFailureMode(driver);
			Thread.sleep(2000);
			//Step 5
			y = EIRCAStep5OneFailureMode(driver);
			Thread.sleep(2000);
			//Step 6
			z = EIRCAStep6OneFailureMode(driver);
		}
		//Step 7
		HashMap<String,Integer> c = EiRCAStep7OneFailureMode(driver,z);
		Thread.sleep(2000);
		//Clicks on Save button
		jse.executeScript("return document.getElementById('pii-ircam-save').click();");
		Thread.sleep(2000);
		//Clicks on Save Report button			  
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).click();
		Thread.sleep(2000);
		jse.executeScript("return document.getElementById('pii-ircam-dialog-confirmed').click();");
		//Waits for the green popup on the right top corner
		//Verify sticky save
		eirca2.verifyStickySaveReport(driver, softly, username, text,1);
		Thread.sleep(2000);
		//Clicks on info tab
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.InfoTab)).click();
		//Gets the value from the text field report creation date
		String creationDate = driver.findElement(eirca.ReportCreationDateField).getAttribute("value");
		String name = creationDate + "_"+username+"_"+ev1 ;
		System.out.println(name);
		//Clicks on Saved activities button
		jse.executeScript("return document.getElementById('pii-ircam-savedactivities').click();");
		Thread.sleep(2000);
		//Clicks on panel on the left on EiRCA
		jse.executeScript("return document.getElementById('pii-user-home-panel-btn-mirca').click();");
		Thread.sleep(2000);
		//Gets the name of the record created
		WebElement record = driver.findElement(eirca.EiRCAFirstRecord);
		String recordName = record.getText();
		//Replace the shy character in chrome
		String r1 = recordName.replaceAll("\u00AD", "");
		if (record.isDisplayed())
		{
			System.out.println("Record found: "+ r1);
		}
		else
			System.out.println ("Record not found.");
		//Checks if the name displayed on record is same as expected
		softly.assertThat(r1).as("test data").isEqualTo(name);
		hm.put("record name", r1);
		//Open HTML and verify Sequence of Events
		verifyHTML(driver,hm, text, n, x, y, z, s2, s, s1,c);
		return hm;
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}