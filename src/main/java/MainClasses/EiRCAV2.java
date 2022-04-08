import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import kaleTestSoftware.EiRCAV2PageObj;
import kaleTestSoftware.EiRCAV2_2;
import kaleTestSoftware.EiRCAV2_3;
import kaleTestSoftware.EiRCAV2_4;
import kaleTestSoftware.EiRCAV2_5;
import kaleTestSoftware.EiRCAV2_6;
import kaleTestSoftware.EiRCAV2_7;
import kaleTestSoftware.EiRCAV2_8;
import kaleTestSoftware.EiRCAV2_9;
import kaleTestSoftware.ErrorMeter2;
import kaleTestSoftware.ShareCheck2;
import kaleTestSoftware.TextBoxResizing;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterables;

public class EiRCAV2 {
	
	SoftAssertions softly = new SoftAssertions();
	
	TextBoxResizing tbr = new TextBoxResizing ();
	ShareCheck2 share2 = new ShareCheck2();
	EiRCAV2PageObj eirca = new EiRCAV2PageObj();
	/////
	//EiRCA2 eirca2 = new EiRCA2();
	EiRCAV2_2 eircav2 = new EiRCAV2_2();
	EiRCAV2_3 eircav3 = new EiRCAV2_3();
	EiRCAV2_4 eircav4 = new EiRCAV2_4();
	EiRCAV2_5 eircav5 = new EiRCAV2_5();
	EiRCAV2_6 eircav6 = new EiRCAV2_6();
	EiRCAV2_7 eircav7 = new EiRCAV2_7();
	EiRCAV2_8 eircav8 = new EiRCAV2_8();
	EiRCAV2_9 eircav9 = new EiRCAV2_9();
	ErrorMeter2 em2 = new ErrorMeter2 ();
	
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
	
	public void verifyProbStatementPlaceHolder(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get place holder of Problem Statement and verify that it is not "foo"
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAEventProblemStatementField)).getAttribute("placeholder");
		softly.assertThat(s).as("test data").isEqualTo("Fill in Problem statement");
	}
	
	public int getCharCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(eirca.TitleCharacterCount).getText();
		s=s.substring(1,s.indexOf("/"));
		int count = Integer.parseInt(s);
		return count;
	}

	public int getTotalCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(eirca.TitleCharacterCount).getText();
		s=s.substring((s.indexOf("/")+1), s.indexOf(")"));
		int count = Integer.parseInt(s);
		return count;
	}
	
	public void verifyAdditionalBoxDisappearsWhenAnswerNotChosen(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Q1.2
		//Select Other mechanical
		share2.scrollToElement(driver, driver.findElement(eirca.Step1Q12Answer));
		WebElement dropdown1 = driver.findElement(eirca.Step1Q12Answer);
		Select s1 = new Select(dropdown1);
		s1.selectByIndex(14);
		//detect additional box
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q12AnswerTextBox));
		//Select Choose answer
		s1.selectByIndex(0);
		//Detect no extra box
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.EiRCAStep1Q12AnswerTextBox));
		//Select Other electrical
		s1.selectByIndex(29);
		//detect additional box
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q12AnswerTextBox));
		//Select Choose answer
		s1.selectByIndex(0);
		//Detect no extra box
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.EiRCAStep1Q12AnswerTextBox));
		//Q1.3
		//Select Other mechanical
		WebElement dropdown2 = driver.findElement(eirca.Step1Q13Answer);
		Select s2 = new Select(dropdown2);
		s2.selectByIndex(17);
		//detect additional box
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q13AnswerTextBox));
		//Select Choose answer
		s2.selectByIndex(0);
		//Detect no extra box
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.EiRCAStep1Q13AnswerTextBox));
		//Select Other elecrical
		s2.selectByIndex(33);
		//detect additional box
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q13AnswerTextBox));
		//Select Choose answer
		s2.selectByIndex(0);
		//Detect no extra box
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.EiRCAStep1Q13AnswerTextBox));
	}

	public void detectAdditionalBoxStep1(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get 1.2 selected answer
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q12AnswerSelected)).getText();
		//Get 1.3 selected answer
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q13AnswerSelected)).getText();
		//1.2 extra box
		if(s.contains("Other MECHANICAL related components")||s.contains("Other ELECTRICAL related components"))
		{
			//tbr.sizeCheck(driver, eirca.EiRCAStep1Q12AnswerTextBox, softly);
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q12AnswerTextBox)).sendKeys(eirca.textEiRCAv2);
		}
		//1.3 extra box
		if(s1.contains("Other MECHANICAL related symptoms")||s1.contains("Other ELECTRICAL related symptoms"))
		{
			//tbr.sizeCheck(driver, eirca.EiRCAStep1Q13AnswerTextBox, softly);
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Q13AnswerTextBox)).sendKeys(eirca.textEiRCAv2);
		}
	}
	
	public void selectDropdown12(WebDriver driver) throws Exception {

		Random random = new Random ();
		int y;
		y = random.nextInt(28);
		if(y<27)
			y=y+1;
		WebElement dropdown1 = driver.findElement(eirca.Step1Q12Answer);
		Select s1 = new Select(dropdown1);
		s1.selectByIndex(y);
	}

	public void selectDropdown13(WebDriver driver) throws Exception {

		Random random = new Random ();
		int y = random.nextInt(34);
		if(y<33)
			y=y+1;
		WebElement dropdown1 = driver.findElement(eirca.Step1Q13Answer);
		Select s1 = new Select(dropdown1);
		s1.selectByIndex(y);
	}
		
	
	public void EIRCAStep1Dropboxes(WebDriver driver, String text, SoftAssertions softly) throws Exception {

		//Verify no next button without mandatory dropdowns selected
		if(driver.findElement(eirca.EiRCANextButton).isDisplayed()==true)
			softly.fail("Next button visible in Step 1 without selecting 1.1, 1.2, 1.3");
		verifyAdditionalBoxDisappearsWhenAnswerNotChosen(driver,softly);
		Thread.sleep(1000);
		//Select 1.2
		selectDropdown12(driver);
		WebElement dropdown1 = driver.findElement(eirca.Step1Q12Answer);
		String s = dropdown1.findElement(By.xpath(".//*[@piiindex='14']")).getText();
		softly.assertThat(s).as("test data").isEqualTo("Breaker");
		Thread.sleep(1000);
		//Select 1.3
		selectDropdown13(driver);
		Thread.sleep(1000);
		//Verify extra ex box is appears and enter text in it
		detectAdditionalBoxStep1(driver,softly);
		//Verify next button is visible after mandatory dropdowns are selected
		if(driver.findElement(eirca.EiRCANextButton).isDisplayed()==false)
			softly.fail("Next button not visible in Step 1 after selecting 1.2, 1.3");
	}
	
	public void verifyNoErrorsOnInfoPage(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify no errors
		//Event title
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.EventTitleError));
		//Location of event
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.EventLocationError));
		//Problem statement
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ProblemStatementError));
		//Failed component
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.FailedComponentError));
		//Primary symptom of failed components
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.PrimarySymptomFailedComponentError));
		//who discovered
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.WhoDiscoveredError));
		//investigator
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.InvestigatorError));
		//reviewer
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ReviewerError));
		//sponsor
		wait.until(ExpectedConditions.invisibilityOfElementLocated(eirca.SponsorError));
	}
	
	public HashMap<String,String> pathEiRCASequenceOfEvents(WebDriver driver, String username) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Scroll to the top
		share2.scrollToTop(driver);
		//Verify text in Sequence of Events
		eircav2.verifySequenceOfEvents(driver,softly);
		//Get list of text
		List <String> list1=em2.error50Data(driver,"kaleasia");
		Iterator<String> iter = Iterables.cycle(list1).iterator();
		//Create a new event
		eircav2.createNewEvent(driver, iter.next(),softly);
		//Verify text boxes empty after adding event
		eircav2.verifyEmptyTexBox(driver,softly);
		//Edit text in boxes of event added
		String[]s=eircav2.editTextBox(driver);
		//Create another new event
		eircav2.createNewEvent(driver, iter.next(),softly);
		//Verify text edited in event added first
		eircav2.verifyEditedText(driver,s,softly);
		//Verify text boxes empty after adding event
		eircav2.verifyEmptyTexBox(driver,softly);
		//Verify text is editable in what happened box for 1st row
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappened1stEvent));
		eircav2.verifyTextEditable(driver,ele, iter.next(),softly);
		//Verify text is editable in what is supposed to happen box for 1st row
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappen1stEvent));
		eircav2.verifyTextEditable(driver,ele, iter.next(),softly);
		//Verify text is editable in what happened box for 2nd row
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappened2ndEvent));
		eircav2.verifyTextEditable(driver,ele, iter.next(),softly);
		//Verify text is editable in what is supposed to happen box for 2nd row
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappen2ndEvent));
		eircav2.verifyTextEditable(driver,ele, iter.next(),softly);
		//Create another new event
		eircav2.createNewEvent(driver, iter.next(),softly);
		//Verify the events are organised as per date and time
		HashMap<String,String> hm = eircav2.verifyOrderOfEvents(driver,softly,3);
		System.out.println(hm);
		//Change date on 2nd row
		eircav2.changeDate(driver,eirca.CalendarIcon2ndEvent);
		Thread.sleep(1000);
		//Verify the events are organised as per date and time
		HashMap<String,String> hm1 = eircav2.verifyOrderOfEvents(driver,softly,3);
		System.out.println(hm1);
		//Verify changes have been saved
		eircav2.verifyChangesSavedSequenceOfEvents(driver,hm1, username,0,softly);
		//Change date on 3rd row
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarIcon3rdEvent)));
		eircav2.changeDate(driver,eirca.CalendarIcon3rdEvent);
		Thread.sleep(1000);
		//Verify the events are organized as per date and time
		HashMap<String,String> hm4 = eircav2.verifyOrderOfEvents(driver,softly,3);
		System.out.println(hm4);
		//Verify changes have been saved
		eircav2.verifyChangesSavedSequenceOfEvents(driver,hm4, username,1,softly);
		//Make date same and change time on 3rd row
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarIcon3rdEvent)));
		eircav2.makeDateSame(driver,eirca.CalendarIcon3rdEvent);
		Thread.sleep(1000);
		//Make date same and change time on 3rd row
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarIcon3rdEvent)));
		eircav2.makeDateSame(driver,eirca.CalendarIcon3rdEvent);
		Thread.sleep(1000);
		//Make time different
		eircav2.changeTime(driver,eirca.ClockIcon2ndEvent);
		Thread.sleep(1000);
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarIcon3rdEvent)));
		eircav2.changeTime(driver,eirca.ClockIcon3rdEvent);
		Thread.sleep(1000);
		eircav2.changeTime(driver,eirca.ClockIcon2ndEvent);
		Thread.sleep(1000);
		//Verify the events are organised as per date and time
		HashMap<String,String> hm2 = eircav2.verifyOrderOfEvents(driver,softly,3);
		System.out.println(hm2);
		//Verify changes have been saved
//		eircav2.verifyChangesSavedSequenceOfEvents(driver,hm2, username,1,softly);
		//Store 1st 2 event data
		HashMap<String,String>hm3 = eircav2.storeEvent(driver);
		//Delete 2nd event
		eircav2.delete2ndEvent(driver,hm3,softly);
		//Store all event data in hashmap
		HashMap<String,String>hm5 = eircav2.storeEvent(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();		
		return hm5;
	}
	
	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NewButton)).click();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("New Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Would you like to confirm you want to erase the current report and create a new report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopUpMessageNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: erased content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("new report");
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).click();
	}
	
	public void verifyErrorMessagesInfoPage(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);				
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();
		share2.verifyWarningPopupForError(driver, softly);
		//Verify errors
		//Event title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EventTitleError)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Event title is required");
		//Location of event
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EventLocationError)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Location of event is required");
		//Problem statement
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ProblemStatementError)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Problem statement is required");
		//Failed component
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.FailedComponentError)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Suspected failed component is required");
		//Primary symptom of failed components
		String s3a = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.PrimarySymptomFailedComponentError)).getText();
		softly.assertThat(s3a).as("test data").isEqualTo("Primary symptom of failed component is required");
		//who discovered
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhoDiscoveredError)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Who discovered is required");
		//investigator
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.InvestigatorError)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Investigator(s) is required");
		//reviewer
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReviewerError)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Reviewer(s) is required");
		//sponsor
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SponsorError)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("Management sponsor(s) is required");
	}


	public void reportCreate(WebDriver driver,String username, String password, int y) throws Exception {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		String text = eirca.textEiRCAv2;	
		//Clicks on Analysis 
		try
		{
			driver.findElement(By.id("pii-main-menu-button-a")).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on EiRCA
		jse.executeScript("return document.getElementById('pii-a-menu-eirca').click();");
		Thread.sleep(1000);
		/*am_quicktest
		driver.findElement(eirca.EiRCAEventIdField).sendKeys("xxx");
		driver.findElement(eirca.EiRCAEventTitleField).sendKeys("xxx");
		driver.findElement(eirca.EiRCAEventLocationField).sendKeys("xxx");
		driver.findElement(eirca.EiRCAEventInvestigatorField).sendKeys("xxx");
		driver.findElement(eirca.EiRCAEventProblemStatementField).sendKeys("xxx");
		EIRCAStep1Dropboxes(driver,eirca.textEiRCAv2,softly);
		driver.findElement(By.id("pii-ircam2-tab-1-who")).sendKeys("xxx");
		driver.findElement(eirca.EiRCAEventReviewerField).sendKeys("xxx");
		driver.findElement(eirca.EiRCAEventSponsorField).sendKeys("xxx");
		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.NextButtonBottomOfStep1Page)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.NextButtonBottomOfStep1Page)));	
		Thread.sleep(600);
		driver.findElement(By.id("pii-ircam2-next")).click();
		*/
		
		
		//Verify placeholder of problem statement
		verifyProbStatementPlaceHolder(driver);
		//Verify new report pop up
		verifyNewReportPopup(driver, softly);
		//Verify Error Messages for mandatory fields on Info page
		verifyErrorMessagesInfoPage(driver,softly);
		//Check title count reset when characters are entered and deleted
		//checkTitleCountReset(driver);
		//Fills all mandatory fields
		//Verify the optional in event id
		String opt = driver.findElement(eirca.EiRCAEventIdField).getAttribute("placeholder");
		System.out.println("first");
		softly.assertThat(opt).as("test data").isEqualTo("Fill in Event ID (optional)");
		System.out.println("second");
		if(driver.getCurrentUrl().contains("kaleqa")) {
			System.out.println("1"); 
			driver.findElement(eirca.EiRCAEventTitleField).sendKeys(text+"<div>");
			System.out.println("2"); 
		}else { driver.findElement(eirca.EiRCAEventTitleField).sendKeys(text);
		
		}
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
		String ev1 = driver.findElement(eirca.EiRCAEventTitleField).getAttribute("value");
		String ev2 = driver.findElement(eirca.EiRCAEventLocationField).getAttribute("value");
		String ev3 = driver.findElement(eirca.EiRCAEventReporterField).getAttribute("value");
		String ev4 = driver.findElement(eirca.EiRCAEventInvestigatorField).getAttribute("value");
		String ev5 = driver.findElement(eirca.EiRCAEventReviewerField).getAttribute("value");
		String ev6 = driver.findElement(eirca.EiRCAEventSponsorField).getAttribute("value");
		String ev7= driver.findElement(eirca.EiRCAEventProblemStatementField).getAttribute("value");
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
		
		EIRCAStep1Dropboxes(driver,eirca.textEiRCAv2,softly);

		//Verify errors have disappeared
		verifyNoErrorsOnInfoPage(driver);
		HashMap<String,String> hmStep1 = eircav6.getStep1Data(driver);
		
	
		
		
		
		
		
		//Step1
		//Click next
		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.NextButtonBottomOfStep1Page)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.NextButtonBottomOfStep1Page)));	
		//Sequence of Events
		HashMap<String,String>hm = pathEiRCASequenceOfEvents(driver,username);
		Thread.sleep(1000);
		
		
		
		//Step2
		List<String> symptoms = eircav3.EiRCAStep2(driver,softly);
		HashMap<String,String> hmStep2symptomsData = eircav6.getStep2SymptomsData(driver);
		//Step 3
		List<String> step3 = eircav4.EiRCAStep3(driver,softly,text,symptoms);
		HashMap<String,String> hmStep3Data = eircav6.getStep3Data(driver, step3);
		HashMap<String,List<String>> hmStep3FACTSData = eircav6.getStep3FACTSCharaceristicsData(driver,step3);
		//Step 4
		List<String> step4 = eircav4.EiRCAStep4(driver,softly,text,step3);
		//Step 5
		int n = eircav4.EiRCAStep5(driver,softly,text,step3,step4);
		//Step 6
		String analysisAdded = eircav4.EiRCAStep6(driver,softly,text,n);
		//Step 7
		HashMap<String,String> step7 = eircav5.EiRCAStep7(driver,softly,text,n,step3);
		//Step 8
		eircav5.EiRCAStep8(driver,softly,step7,text,n,step3);
		//Step 9
		List<String> dcAcCfNames = eircav6.EiRCAStep9(driver, softly, text, n, step3);
		//Step 10
		eircav8.EiRCAStep10(driver, softly, text, n, step3, dcAcCfNames);
		//Verify report tab
		//eircav9.verifyReportTabSectionHeadings(driver, softly);
		//eircav8.verifyReportTab(driver, softly, hmStep1, hmStep2symptomsData, hmStep3Data, hmStep3FACTSData, step4, step3, n, analysisAdded, step7, dcAcCfNames);
		Thread.sleep(2000);
		eircav9.verifyBackButtonWorks(driver, softly);
		//Clicks on Save button
		share2.scrollToTop(driver);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();
		Thread.sleep(2000);
		//Clicks on Save Report button			  
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).click();
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		//Waits for the green popup on the right top corner
		//Verify sticky save
//		eircav2.verifyStickySaveReport(driver, softly, username, text,1);
		Thread.sleep(2000);
		//Clicks on step1 tab
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Tab)).click();
		//Gets the value from the text field report creation date
		String creationDate = driver.findElement(eirca.ReportCreationDateField).getAttribute("value");
//		String name = creationDate + "_"+username+"_"+ev1 ;
//		System.out.println(name);
		//Clicks on Saved activities button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).click();
		Thread.sleep(2000);
		//Clicks on panel on the left on EiRCA
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASidePanel)).click();
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
//		softly.assertThat(r1).as("test data").isEqualTo(name);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();
		//verify HTML report
		//eircav9.verifyHTMLReportSectionHeadings(driver, softly);
		//eircav9.verifyHTMLReport(driver, softly, hmStep1, hmStep2symptomsData, hmStep3Data, hmStep3FACTSData, step4, step3, n, analysisAdded, step7, dcAcCfNames);
		//Download report
		eircav7.downloadReport(driver, hm, softly, text, hmStep1, hmStep2symptomsData, hmStep3Data, hmStep3FACTSData, step4, step3, analysisAdded, step7, symptoms, dcAcCfNames);
		//Share report
		eircav7.shareReport(driver, username, password, y, softly);
		//Mark Critical
		eircav7.markCritical(driver, username, password, y, softly);
		//Delete report
		eircav7.deleteNewRecord(driver, recordName, y, softly);
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
