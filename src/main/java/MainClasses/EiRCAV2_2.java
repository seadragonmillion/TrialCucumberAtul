import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kaleTestSoftware.EiRCA2;
import kaleTestSoftware.EiRCAV2PageObj;
import kaleTestSoftware.LoginPageObj;
import kaleTestSoftware.ShareCheck2;
import kaleTestSoftware.TextBoxResizing;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EiRCAV2_2 {
	
	TextBoxResizing tbr = new TextBoxResizing ();
	EiRCAV2PageObj eirca = new EiRCAV2PageObj();
	ShareCheck2 share2 = new ShareCheck2();
	LoginPageObj login = new LoginPageObj();
	EiRCA2 eirca2 = new EiRCA2();
	
	
	public void verifyStickySaveReport(WebDriver driver, SoftAssertions softly, String username, String reportTitle, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			//eirca3.verifyBreakWordPropertyStickyNote(driver, softly);
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			String r = s.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").contains(username+"_"+reportTitle);
			if(n == 0)
				softly.assertThat(r).as("test data").contains("Data created for id:");
			else
				softly.assertThat(r).as("test data").contains("Data updated for id:");
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException r)
		{
			System.out.println("Couldn't find save pop up");
			Thread.sleep(2000);
		}
	}
	
	public HashMap<String,String> verifyOrderOfEvents(WebDriver driver, SoftAssertions softly, int numberOfEventsAdded) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get date from 1st row
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date1stEvent)).getAttribute("value");
		//Get date from 2nd row
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date2ndEvent)).getAttribute("value");
		//Get time from 1st row
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Time1stEvent)).getAttribute("value");
		//Get time from 2nd row
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Time2ndEvent)).getAttribute("value");
		//Store date and time in HashMap
		HashMap <String,String> hm = new HashMap<String,String>();
		hm.put("Date 1st row", s);
		hm.put("Date 2nd row", s1);
		hm.put("Time 1st row", s2);
		hm.put("Time 2nd row", s3);
		//Compare date and time
		String year1 = s.substring(0, 4);
		String year2 = s1.substring(0, 4);
		String month1 = s.substring(5, 7);
		String month2 = s1.substring(5, 7);
		String day1 = s.substring(8, 10);
		String day2 = s1.substring(8, 10);	
		String hour1 = s2.substring(0, 2);
		String hour2 = s3.substring(0, 2);
		String minute1 = s2.substring(3, 5);
		String minute2 = s3.substring(3, 5);
		//Verify order of 1st and 2nd event
		compareDateTime(year1,year2,month1,month2,day1,day2,hour1,hour2,minute1,minute2,softly);
		if(numberOfEventsAdded==3)
		{
			//Get date from 3rd row
			String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date3rdEvent)).getAttribute("value");
			//Get time from 3rd row
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Time3rdEvent)).getAttribute("value");
			hm.put("Date 3rd row", s4);
			hm.put("Time 3rd row", s5);
			String year3 = s4.substring(0, 4);
			String month3 = s4.substring(5, 7);
			String day3 = s4.substring(8, 10);
			String hour3 = s5.substring(0, 2);
			String minute3 = s5.substring(3, 5);			
			//Verify order of 2nd and 3rd event
			compareDateTime(year2,year3,month2,month3,day2,day3,hour2,hour3,minute2,minute3,softly);
		}		
		return hm;
	}

	public void compareDateTime (String year1, String year2, String month1, String month2, String day1, String day2, String hour1, String hour2, String minute1, String minute2, SoftAssertions softly) throws Exception {

		//Compare year
		int n1 = Integer.parseInt(year1);
		int n2 = Integer.parseInt(year2);
		if(n1>n2)
		{
			softly.fail("Year: Order wrong as later date "+n1+ " event appears before previous date event"+n2);
		}
		if(n1==n2)
		{
			//Compare month
			n1 = Integer.parseInt(month1);
			n2 = Integer.parseInt(month2);
			if(n1>n2)
			{
				softly.fail("Month: Order wrong as later date "+n1+ " event appears before previous date event"+n2);
			}
			if(n1==n2)
			{
				//Compare day
				n1 = Integer.parseInt(day1);
				n2 = Integer.parseInt(day2);
				if(n1>n2)
				{
					softly.fail("Day: Order wrong as later date "+n1+ " event appears before previous date event"+n2);
				}
				if(n1==n2)
				{
					//Compare time
					//Minute
					n1 = Integer.parseInt(hour1);
					n2 = Integer.parseInt(hour2);
					if(n1>n2)
					{
						softly.fail("Minute: Order wrong as later date and time"+n1+ " event appears before previous date and time event"+n2);
					}
					if(n1==n2)
					{
						//Compare time
						//Second
						n1 = Integer.parseInt(minute1);
						n2 = Integer.parseInt(minute2);
						if(n1>n2)
						{
							softly.fail("Second: Order wrong as later date and time"+n1+ " event appears before previous date and time event"+n2);
						}
					}
				}
			}
		}
	}
	
	public void verifySavePopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Save Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save current event report?");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("save report");
	}
	
	public void verifyChangesSavedSequenceOfEvents(WebDriver driver, HashMap<String,String> hm1, String username, int n, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		share2.scrollToTop(driver);
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		Thread.sleep(1000);
		//Click on info page
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Tab)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Tab)));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Tab)).click();	
		Thread.sleep(1000);
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();	
		//Verify the events are organised as per date and time
		HashMap<String,String> hm = verifyOrderOfEvents(driver, softly,3);
		System.out.println(hm);
		Thread.sleep(1000);
		//boolean b = hm.entrySet().stream().filter(value -> hm1.entrySet().stream().anyMatch(value1 -> (value1.getKey() == value.getKey() && value1.getValue() == value.getValue()))).findAny().isPresent();
		boolean b = hm.equals(hm1);
		System.out.println(b);
		if(b==false)
			softly.fail("Changes did not get saved: \n"+hm1+"\n"+hm);
		//Save report
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();	
		//Save pop verify
		verifySavePopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
		//Verify sticky save
		verifyStickySaveReport(driver, softly, username, eirca2.textCreateEIRCAv2(driver), n);
		share2.loadingServer(driver);
		share2.loadingServer(driver);
		Thread.sleep(1000);
		//Saved activities
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).click();	
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
		/*
		//Verify Sequence of Events title
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageDateTimeTitle1)).getText();
		softly.assertThat(s1).as("test data").isEqualTo(hm1.get("Date 1st row")+", "+hm1.get("Time 1st row"));    
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageDateTimeTitle2)).getText();
		softly.assertThat(s2).as("test data").isEqualTo(hm1.get("Date 2nd row")+", "+hm1.get("Time 2nd row"));    
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.SequenceOfEventPageDateTimeTitle3)).getText();
		softly.assertThat(s3).as("test data").isEqualTo(hm1.get("Date 3rd row")+", "+hm1.get("Time 3rd row"));    
		*/
		//Click on open button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)));	
	}
	
	public List<String> createNewEvent(WebDriver driver, String text, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait1 = new WebDriverWait(driver,1);
		List<String> dateTime = new ArrayList<String>();
		//Select date
		//Click on calendar icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarIconAddEvent)).click();
		while(true)
		{
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarMinusSign));
				break;
			}catch(org.openqa.selenium.TimeoutException t)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarIconAddEvent)).click();
			}
		}
		//Click on - sign
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarMinusSign)).click();
		//Select 1st date of 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Calendar1stRow1stDate)).click();
		Thread.sleep(1000);
		//Wait for disappearance of date box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.Calendar1stRow1stDate));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		dateTime.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.DateField)).getAttribute("value"));
		//Select time
		//Click on clock icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockIconAddEvent)).click();
		//Click on set time
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockSetTime)).click();
		Thread.sleep(1000);
		//Wait for disappearance of time box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ClockSetTime));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		dateTime.add(wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.TimeField)).getAttribute("value"));
		//Enter text in what happened
		tbr.sizeCheck(driver, eirca.WhatHappenedField, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappenedField)).sendKeys(text);
		//Enter text in what is supposed to happen
		tbr.sizeCheck(driver, eirca.WhatIsSupposedToHappenField, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappenField)).sendKeys(text);
		//Click on add sign
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EventAddSign)).click();
		return dateTime;
	}

	public void verifySequenceOfEvents(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1PageTitle)).getText();
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
		softly.assertThat(s4).as("test data").isEqualTo("What happened?");
		//Verify What is supposed to happen box header
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappenHeader)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("What is supposed to happen?");
		//Verify placeholder for What happened box
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappenedField)).getAttribute("placeholder");
		softly.assertThat(s6).as("test data").isEqualTo("Description of each related step prior to and after the triggering error, leading to the event.");
		//Verify placeholder for What is supposed to happen box
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappenField)).getAttribute("placeholder");
		softly.assertThat(s7).as("test data").isEqualTo("Description of what should happen instead of the abnormal condition that occurred.");
		//Verify ok button on cannot add popup
		//Click on add sign
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EventAddSign)).click();
		//Verify text on ok button
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("ok");
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).click();
	}



	public void verifyEmptyTexBox(WebDriver driver, SoftAssertions softly) throws Exception {

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

	public void verifyTextEditable(WebDriver driver,WebElement ele, String text, SoftAssertions softly) throws Exception {

		//Get text present in text box
		String s = ele.getAttribute("value");
		System.out.println(s);
		System.out.println("#377");
		//CLear some text
		for (int i=0;i<6;i++)
			System.err.println("before back_space");
			ele.sendKeys(Keys.BACK_SPACE);
			System.err.println("after back_space");
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

		WebDriverWait wait = new WebDriverWait(driver,60);
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

	public void verifyEditedText(WebDriver driver, String[]s, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappened2ndEvent)).getAttribute("value");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappen2ndEvent)).getAttribute("value");
		softly.assertThat(s1).as("test data").isEqualTo(s[0]);
		softly.assertThat(s2).as("test data").isEqualTo(s[1]);
	}

	public void delete2ndEvent(WebDriver driver, HashMap<String,String> hm, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on cross symbol of 2nd event row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.DeleteSign2ndEvent)).click();
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopUpMessageNote)).getText();
		softly.assertThat(s).as("test data").contains("Date: "+hm.get("date2"));
		softly.assertThat(s).as("test data").contains("Time: "+hm.get("time2"));
		softly.assertThat(s).as("test data").contains("What happened?: "+hm.get("what happened2"));
		//Click delete button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)));
	}

}
