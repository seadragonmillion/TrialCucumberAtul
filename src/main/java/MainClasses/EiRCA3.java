import java.util.HashMap;

import kaleTestSoftware.EiRCAPageObj;
import kaleTestSoftware.LoginPageObj;
import kaleTestSoftware.ShareCheck2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EiRCA3 {	

	EiRCAPageObj eirca = new EiRCAPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	LoginPageObj login = new LoginPageObj();

	public void verifyHTMLSUEPTableContributingFactorBoldFont(WebDriver driver, int z) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,2);
		System.out.println("Step 7 table bold html");
		for(int i=1;i<=z;i++)
		{
			if(i==1)
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column1RC));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column1));
					}catch(org.openqa.selenium.TimeoutException q)
					{
						try{
							wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row2Column1a));
						}catch(org.openqa.selenium.TimeoutException q1)
						{

						}
					}
				}							
			}
			if(i==2)
			{
				//Verify corrective action
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column1RC));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column1));
					}catch(org.openqa.selenium.TimeoutException q)
					{
						wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row3Column1a));
					}
				}				
			}
			if(i==3)
			{
				//Verify corrective action
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column1RC));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column1));
					}catch(org.openqa.selenium.TimeoutException q)
					{
						wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row4Column1a));
					}
				}				
			}
			if(i==4)
			{
				//Verify corrective action
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column1RC));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column1));
					}catch(org.openqa.selenium.TimeoutException q)
					{
						wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLStep7Row5Column1a));
					}
				}				
			}
		}
	}	 

	public void verifySavePopupAfterRename(WebDriver driver, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Click on Info tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.InfoTab)).click();
		//Enter a very long name in Event title
		driver.findElement(eirca.EiRCAEventTitleField).clear();
		driver.findElement(eirca.EiRCAEventTitleField).sendKeys("Really long text which will make the report name to overflow out of the popup");
		//click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).click();
		//Verify the popup
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopUpMessageNote)).getText();
		softly.assertThat(s).as("test data").contains("‑");
		System.out.println(s);
		String overflow = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopUpMessageNote)).getCssValue("word-wrap");
		softly.assertThat(overflow).as("test data").isEqualTo("break-word");
		System.out.println(overflow);
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).click();
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).click();
		share2.loadingServer(driver);
		//Click on first record
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAFirstRecord)).click();		
		share2.loadingServer(driver);
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

	public String addTimeTo1stEvent(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait1 = new WebDriverWait(driver,1);
		//Select time
		//Click on clock icon
		while(true)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockSignTime1stEvent)).click();
			try{
				if(driver.findElement(eirca.ClockSetTime).isDisplayed())
					break;
			}catch(org.openqa.selenium.NoSuchElementException r)
			{

			}
		}
		//Click on set time
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockSetTime)).click();
		Thread.sleep(1000);
		//Wait for disappearance of time box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ClockSetTime));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		String time = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Time1stEvent)).getAttribute("value");
		return time;
	}

	public String changeTime1stEvent(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait1 = new WebDriverWait(driver,1);
		//Select time
		//Click on clock icon
		while(true)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockSignTime1stEvent)).click();
			try{
				if(driver.findElement(eirca.ClockHourMinusSign).isDisplayed())
					break;
			}catch(org.openqa.selenium.NoSuchElementException r)
			{

			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockHourMinusSign)).click();
		//Click on set time
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockSetTime)).click();
		Thread.sleep(1000);
		//Wait for disappearance of time box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ClockSetTime));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		String time = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Time1stEvent)).getAttribute("value");
		return time;
	}

	public String changeDateFuture1stEvent(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait1 = new WebDriverWait(driver,1);
		//Select time
		//Click on calender icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalenderSignTime1stEvent)).click();
		//Go 3 months forward
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		Thread.sleep(250);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		Thread.sleep(250);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		Thread.sleep(250);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		Thread.sleep(250);
		//Select 1st date of 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Calendar1stRow1stDate)).click();
		Thread.sleep(1000);
		//Wait for disappearance of time box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.Calendar1stRow1stDate));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		String time = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date2ndEvent)).getAttribute("value");
		return time;
	}

	public void verify1stEventTimeAndDate(WebDriver driver, String date, String time, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		String dateActual = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date1stEvent)).getAttribute("value");
		String timeActual = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Time1stEvent)).getAttribute("value");
		System.out.println(date+" "+time);
		System.out.println(dateActual+" "+timeActual);
		//Verify if date correct
		softly.assertThat(dateActual).as("test data").isNotEmpty();
		softly.assertThat(dateActual).as("test data").contains(date);
		//Verify if time correct
		softly.assertThat(timeActual).as("test data").isNotEmpty();
		softly.assertThat(timeActual).as("test data").contains(time);
	}

	public void verify2ndEventTimeAndDate(WebDriver driver, String date, String time, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		String dateActual = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Date2ndEvent)).getAttribute("value");
		String timeActual = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Time2ndEvent)).getAttribute("value");
		System.out.println(date+" "+time);
		System.out.println(dateActual+" "+timeActual);
		//Verify if date correct
		softly.assertThat(dateActual).as("test data").isNotEmpty();
		softly.assertThat(dateActual).as("test data").contains(date);
		//Verify if time correct
		softly.assertThat(timeActual).as("test data").isNotEmpty();
		softly.assertThat(timeActual).as("test data").contains(time);
	}

	public String createEventNoTime(WebDriver driver, String text, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait1 = new WebDriverWait(driver,1);
		//Select date
		//Click on calendar icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarIconAddEvent)).click();
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
		//Get date from date box before adding event
		String dateOfEvent = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.DateField)).getAttribute("value");
		//Enter text in what happened
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatHappenedField)).sendKeys(text);
		//Enter text in what is supposed to happen
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.WhatIsSupposedToHappenField)).sendKeys(text);
		//Click on add sign
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EventAddSign)).click();
		return(dateOfEvent);
	}

	public void verifyAddSharerPopup(WebDriver driver, SoftAssertions softly, String sharer) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Share to user");
		//Verify question on pop up, sharer in format = QAA (ritica_only_nonadmin)
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to share current activity to user ["+sharer+"]?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: report will be shared after you save your changes.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("add user");
	}

	public void verifyRemoveSharerPopup(WebDriver driver, SoftAssertions softly, String sharer) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Remove sharing to a user");
		//Verify question on pop up, sharer in format = QAA (ritica_only_nonadmin)
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to remove user ["+sharer+"] from 'shared to' users?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: sharing to user will be removed after you save your changes.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Remove Sharing
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("remove sharing");		
	}

	public void verifyBreakWordPropertyStickyNote(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		String wordWrap = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getCssValue("word-wrap");
		softly.assertThat(wordWrap).as("test data").isEqualTo("break-word");
		System.out.println("wordWrap "+wordWrap);
	}
}
