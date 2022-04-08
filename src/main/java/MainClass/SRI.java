package MainClass;

import java.util.HashMap;
import java.util.Random;

import PageObjects.EiRCAPageObj;
import PageObjects.HiRCAObj;
import PageObjects.LoginPageObj;
import PageObjects.OPiRCAPageObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SRI {

	SoftAssertions softly = new SoftAssertions();
	Random random = new Random();

	HiRCAObj hc = new HiRCAObj();
	EiRCAPageObj eirca = new EiRCAPageObj();
	EiRCA2 eirca2 = new EiRCA2();
	EiRCA3 eirca3 = new EiRCA3();
	ShareCheck share = new ShareCheck();
	ErrorMeter3 em3 = new ErrorMeter3 ();
	OPiRCAPageObj opirca = new OPiRCAPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck3 share3 = new ShareCheck3();
	SRIPageObj sri = new SRIPageObj();
	SRI2 sri2 = new SRI2();
	SRI3 sri3 = new SRI3();
	SRIAdmin sriA = new SRIAdmin();
	SRIAdmin2 sriA2 = new SRIAdmin2();
	LoginPageObj login = new LoginPageObj();

	public void shareReport(WebDriver driver, String username, String password1, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		String sharer = em3.decideSharer (y);
		String sharerAdded = em3.decideSharerAdded (y);	 
		//Click on share button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareButton)).click();
		//Enters username
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareTextBox)).sendKeys(sharer);
		Thread.sleep(500);
		//Selects from dropdown
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareDropdown));
		dropdown.findElement(opirca.FirstSelectionUnderDropdown).click();
		//Clicks on add user
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		//Verifies user added
		String user=wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.SharerAdded)).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		share3.shareTwice (driver,softly,0);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareSaveButton)).click();
		//Verify share save sticky
		eirca2.verifyStickyShareSave(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Share icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIShareIconOrCriticalIcon));
		//Calls the Share check function
		share.receiptReport(driver, sharer, username, password1);
		//Clicks on MainClass.SRI side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
	}

	public void markCriticalReport(WebDriver driver, String username, String password1, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);	
		//Clicks on mark critical
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		//Mark critical pop up
		eirca2.verifyMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		//Checks if marked critical
		share2.loadingServer(driver);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
		softly.assertThat(s).as("test data").contains("ui-checkbox-on");
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Marked critical icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIShareIconOrCriticalIcon));
		//Verify presence of shared icon 
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIShareIconWhenAlsoMarkedCritical));
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).click();
		share2.loadingServer(driver);
		//Clicks on mark critical again
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		//Un-mark critical pop up
		eirca2.verifyUnMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(2000);
		share2.loadingServer(driver);
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
		softly.assertThat(s1).as("test data").contains("ui-checkbox-off");
		//Verify report not retrieved by shared to person
		String sharer = em3.decideSharer (y);		
		share.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on MainClass.SRI side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISidePanel)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);	    	
		//Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).click();
		share2.loadingServer(driver);
	}

	public void verifyDeleteReportPopup(WebDriver driver, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Delete Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("Do you confirm you want to delete MainClass.SRI™ report referenced as: "+r1+"?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: deleted data cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//delete button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("delete report");
	}

	public void deleteReport(WebDriver driver, String recordName, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on delete
		driver.findElement(eirca.DeleteButton).click();
		//Verify delete popup
		verifyDeleteReportPopup(driver, recordName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle));
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		share2.loadingServer(driver);
		sriA.deleteAll(driver,softly);
		//Verify report not retrieved by shared to person		
		String sharer = em3.decideSharer (y);
		share.checkNoReportAfterDelete(driver, sharer, softly);	
	}

	public void changeTimeOfMeasurementsAndVerifyOrderOfMeasurements(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Change date of 2nd event to match 1st event
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2CalendarIcon)).click();
		//Click on - sign five times
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
		//get data from step 2
		HashMap<String,String> storeDataStep2 = getStep2Data(driver);
		//Verify order of measurements
		verifyOrderOfMeasurements(driver,storeDataStep2.get("date1"),storeDataStep2.get("date2"),storeDataStep2.get("time1"),storeDataStep2.get("time2"));	
		//Change time of 1st measurement
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1ClockIcon)).click();
		//Set hour to 5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).clear();
		while(true)
		{
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).sendKeys(Keys.CONTROL,"a");
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).sendKeys(Keys.DELETE);
				wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).sendKeys("05");
				Thread.sleep(500);
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).getAttribute("value");
				System.out.println(s);
				if(s.equals("05"))
					break;
			}catch(org.openqa.selenium.WebDriverException e)
			{
				continue;
			}
		}
		//Click on set time
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockSetTime)));
		Thread.sleep(1000);
		//Wait for disappearance of time box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ClockSetTime));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		//get data from step 2
		HashMap<String,String> storeDataStep2a = getStep2Data(driver);
		System.out.println(storeDataStep2a);
		//Verify order of measurements
		verifyOrderOfMeasurements(driver,storeDataStep2a.get("date1"),storeDataStep2a.get("date2"),storeDataStep2a.get("time1"),storeDataStep2a.get("time2"));	
		//Verify the current 1st meaurement time is equal to old 2nd measurement time
		softly.assertThat(storeDataStep2.get("time1").substring(0, 2)).as("test data").isEqualTo(storeDataStep2a.get("time2").substring(0, 2));
		//Verify the hour changed in current measurement 2 
		softly.assertThat(storeDataStep2a.get("time1").substring(0, 2)).as("test data").isEqualTo("05");
	}

	public void changeDate1stMeasurementAndVerifyOrderOfMeasurements(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Get date of present 1st measurement
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Date)).getAttribute("value");
		//Change date of 1st measurement to 2 months ahead of present 2nd event
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1CalendarIcon)));
		//Click on + sign five times
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.CalendarPlusSign)).click();
		//Select 1st date of 1st row
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Calendar1stRow1stDate)).click();
		Thread.sleep(1000);
		//Wait for disappearance of date box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.Calendar1stRow1stDate));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		//Verify the current 1st measurement has the date of previous 2nd event
		WebElement ele;
		//Get date 1
		try{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Date));
		}catch(org.openqa.selenium.TimeoutException t)
		{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1DateFirefox));
		}
		String date1 = ele.getAttribute("value");
		softly.assertThat(date1).as("test data").isEqualTo(s);
		//get data from step 2
		HashMap<String,String> storeDataStep2 = getStep2Data(driver);
		//Verify order of measurements
		verifyOrderOfMeasurements(driver,storeDataStep2.get("date1"),storeDataStep2.get("date2"),storeDataStep2.get("time1"),storeDataStep2.get("time2"));		
	}

	public void verifyOrderOfMeasurements(WebDriver driver, String date1, String date2, String time1, String time2) throws Exception {

		//Compare date and time
		String year1 = date1.substring(0, 4);
		String year2 = date2.substring(0, 4);
		String month1 = date1.substring(5, 7);
		String month2 = date2.substring(5, 7);
		String day1 = date1.substring(8, 10);
		String day2 = date2.substring(8, 10);	
		String hour1 = time1.substring(0, 2);
		String hour2 = time2.substring(0, 2);
		String minute1 = time1.substring(3, 5);
		String minute2 = time2.substring(3, 5);
		//Verify order of 1st and 2nd measurement
		eirca3.compareDateTime(year1,year2,month1,month2,day1,day2,hour1,hour2,minute1,minute2,softly);
	}

	public void step2AddMeasurement(WebDriver driver, String text, String measurement, String unit, String value) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Fill Date
		//Click on calendar icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2CalendarIconAddMeasurement)).click();
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
		//Fill time
		//Click on clock icon
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2ClockIconAddMeasurement)).click();
		//Set hour to 2
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).clear();
		Thread.sleep(500);
		while(true)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).sendKeys(Keys.CONTROL,"a");
			Thread.sleep(300);
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).sendKeys(Keys.DELETE);
			Thread.sleep(300);
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).sendKeys("02");
			Thread.sleep(500);
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockTimeHourField)).getAttribute("value");
			System.out.println(s);
			if(s.equals("02"))
				break;
		}
		//Click on set time
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ClockSetTime)));
		Thread.sleep(1000);
		//Wait for disappearance of time box
		try{
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(eirca.ClockSetTime));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		//Select Measurement
		Select s = new Select(driver.findElement(sri.Step2Measurment));
		s.selectByVisibleText(measurement);
		//Select Unit 
		Select s1 = new Select(driver.findElement(sri.Step2Unit));
		s1.selectByVisibleText(unit);
		//Clear value 
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Value)).clear();
		//Fill value
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Value)).sendKeys(value);
		//Fill notes
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Notes)).sendKeys(text);
		//Click on add button
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2AddButton)));
	}

	public void verifyStep1Label(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Event title
		String placeholder1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).getAttribute("placeholder");
		softly.assertThat(placeholder1).as("test data").isEqualTo("Fill in Report title");
		String label1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitleLabel)).getText();
		softly.assertThat(label1).as("test data").isEqualTo("Report title:");
	}

	public void step1DataFill(WebDriver driver, String text, String component, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).sendKeys(text);
		//Get count
		int count = getCharCountFromTitle(driver);
		int total = getTotalCountFromTitle(driver);
		for(int i=count+1;i<=total;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).sendKeys("z");
		}
		//Inspection staff
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1InspectionStaff)).sendKeys(text);
		/*Select label mechanical or electrical
		 *0=mechanical
		 *1=electrical
		 */
		if(y==0)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1MechanicalComponentLabel)).click();
		}
		if(y==1)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1ElectricalComponentLabel)).click();
		}
		//Component
		Select s = new Select(driver.findElement(sri.Step1Component));
		s.selectByVisibleText(component);
	}

	public void checkForErrorStep1(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		share2.loadingServer(driver);
		//Click on save button step 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveButton)).click();
		share2.verifyWarningPopupForError(driver, softly);
		//Error on Event title
		String titleError = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitleErrorText)).getText();
		softly.assertThat(titleError).as("test data").isEqualTo("Report title is required");
		//Error on Inspection staff
		String inspectionStaffError = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1InspectionStaffErrorText)).getText();
		softly.assertThat(inspectionStaffError).as("test data").isEqualTo("Inspection staff is required");
		//Error on Component
		String componentError = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1ComponentErrorText)).getText();
		softly.assertThat(componentError).as("test data").isEqualTo("Component is required");
		//softly.assertAll();
	}

	public HashMap<String,String> getStep1Data(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HashMap<String,String> storeData = new HashMap<String,String>();
		//Get event title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).getAttribute("value");
		//Get Inspection staff
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1InspectionStaff)).getAttribute("value");
		//Get component
		String s2 = driver.findElement(sri.Step1Component).getAttribute("value");
		//Get other text
		if(s2.contains("Other"))
		{
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1ComponentOther)).getAttribute("value");
			storeData.put("other", s3);
		}
		//Report creation time and date
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1ReportCreation)).getAttribute("value");
		storeData.put("event title", s);
		storeData.put("inspection staff", s1);
		storeData.put("component", s2);
		storeData.put("report creation", s3);
		return storeData;
	}	

	public HashMap<String,String> getStep2Data(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,3);
		HashMap<String,String> storeData = new HashMap<String,String>();
		WebElement ele;
		//Get date 1
		try{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Date));
		}catch(org.openqa.selenium.TimeoutException t)
		{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1DateFirefox));
		}
		String s = ele.getAttribute("value");
		//Get time 1
		try{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Time));
		}catch(org.openqa.selenium.TimeoutException t)
		{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1TimeFirefox));
		}
		String s1 = ele.getAttribute("value");
		//Get Measurement 1
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Measurement)).getText();
		//Get value 1
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Value)).getAttribute("value");
		//Get note 1
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Note)).getAttribute("value");
		//Get date 2
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Date)).getAttribute("value");
		//Get time 2
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Time)).getAttribute("value");
		//Get Measurement 2
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Measurement)).getText();
		//Get value 2
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Value)).getAttribute("value");
		//Get note 2
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Note)).getAttribute("value");
		storeData.put("date1", s);
		storeData.put("time1", s1);
		storeData.put("measurement1", s2);
		storeData.put("value1", s3);
		storeData.put("note1", s4);
		storeData.put("date2", s5);
		storeData.put("time2", s6);
		storeData.put("measurement2", s7);
		storeData.put("value2", s8);
		storeData.put("note2", s9);
		return storeData;
	}

	public void verifyReportTab(WebDriver driver,  HashMap<String,String> storeDataStep1,  HashMap<String,String> storeDataStep2)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify data in Report tab
		//Event information
		//Event title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabEventTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo(storeDataStep1.get("Report title"));
		//Inspection staff
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabInspectionStaff)).getText();
		softly.assertThat(s1).as("test data").isEqualTo(storeDataStep1.get("Inspection staff"));
		//Component
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabComponent)).getText();
		softly.assertThat(s2).as("test data").isEqualTo(storeDataStep1.get("component"));
		//Measurements
		//1
		//Date
		String date1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1Date)).getText();
		softly.assertThat(date1).as("test data").isEqualTo(storeDataStep2.get("date1"));
		//Time
		String time1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1Time)).getText();
		softly.assertThat(time1).as("test data").isEqualTo(storeDataStep2.get("time1"));
		//Measurement
		String measurement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1Measurement)).getText();
		softly.assertThat(measurement1).as("test data").isEqualTo(storeDataStep2.get("measurement1"));
		//unit
		String unit1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1Unit)).getText();
		softly.assertThat(unit1).as("test data").isEqualTo(storeDataStep2.get("unit1"));
		//Value
		String value1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1Value)).getText();
		softly.assertThat(value1).as("test data").isEqualTo(storeDataStep2.get("value1"));
		//Notes
		String note1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1Note)).getText();
		softly.assertThat(note1).as("test data").isEqualTo(storeDataStep2.get("note1"));
		//Conclusion
		String conclusion1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1Conclusion)).getText();
		sri2.verifyConclusion(driver, conclusion1, value1, measurement1, softly);
		String conclusion1a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement1ConclusionColorText)).getText();
		sri2.verifyConclusionColorAndText(driver,conclusion1a,value1,measurement1,softly);
		//2
		//Date
		String date2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2Date)).getText();
		softly.assertThat(date2).as("test data").isEqualTo(storeDataStep2.get("date2"));
		//Time
		String time2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2Time)).getText();
		softly.assertThat(time2).as("test data").isEqualTo(storeDataStep2.get("time2"));
		//Measurement
		String measurement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2Measurement)).getText();
		softly.assertThat(measurement2).as("test data").isEqualTo(storeDataStep2.get("measurement2"));
		//unit
		String unit2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2Unit)).getText();
		softly.assertThat(unit2).as("test data").isEqualTo(storeDataStep2.get("unit2"));
		//Value
		String value2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2Value)).getText();
		softly.assertThat(value2).as("test data").isEqualTo(storeDataStep2.get("value2"));
		//Notes
		String note2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2Note)).getText();
		softly.assertThat(note2).as("test data").isEqualTo(storeDataStep2.get("note2"));
		//Conclusion
		String conclusion2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2Conclusion)).getText();
		sri2.verifyConclusion(driver, conclusion2, value2, measurement2, softly);
		String conclusion2a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement2ConclusionColorText)).getText();
		sri2.verifyConclusionColorAndText(driver,conclusion2a,value2,measurement2,softly);
		//3
		//Date
		String date3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement3Date)).getText();
		softly.assertThat(date3).as("test data").isEqualTo(storeDataStep2.get("date3"));
		//Time
		String time3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement3Time)).getText();
		softly.assertThat(time3).as("test data").isEqualTo(storeDataStep2.get("time3"));
		//Measurement
		String measurement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement3Measurement)).getText();
		softly.assertThat(measurement3).as("test data").isEqualTo(storeDataStep2.get("measurement3"));
		//unit
		String unit3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement3Unit)).getText();
		softly.assertThat(unit3).as("test data").isEqualTo(storeDataStep2.get("unit3"));
		//Value
		String value3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement3Value)).getText();
		softly.assertThat(value3).as("test data").isEqualTo(storeDataStep2.get("value3"));
		//Notes
		String note3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement3Note)).getText();
		softly.assertThat(note3).as("test data").isEqualTo(storeDataStep2.get("note3"));
		//Conclusion
		String conclusion3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement3Conclusion)).getText();
		sri2.verifyConclusion(driver, conclusion3, value3, measurement3, softly);
		String conclusion3a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement3ConclusionColorText)).getText();
		sri2.verifyConclusionColorAndText(driver,conclusion3a,value3,measurement3,softly);
		//4
		//Date
		String date4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement4Date)).getText();
		softly.assertThat(date4).as("test data").isEqualTo(storeDataStep2.get("date4"));
		//Time
		String time4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement4Time)).getText();
		softly.assertThat(time4).as("test data").isEqualTo(storeDataStep2.get("time4"));
		//Measurement
		String measurement4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement4Measurement)).getText();
		softly.assertThat(measurement4).as("test data").isEqualTo(storeDataStep2.get("measurement4"));
		//unit
		String unit4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement4Unit)).getText();
		softly.assertThat(unit4).as("test data").isEqualTo(storeDataStep2.get("unit4"));
		//Value
		String value4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement4Value)).getText();
		softly.assertThat(value4).as("test data").isEqualTo(storeDataStep2.get("value4"));
		//Notes
		String note4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement4Note)).getText();
		softly.assertThat(note4).as("test data").isEqualTo(storeDataStep2.get("note4"));
		//Conclusion
		String conclusion4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement4Conclusion)).getText();
		sri2.verifyConclusion(driver, conclusion4, value4, measurement4, softly);
		String conclusion4a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement4ConclusionColorText)).getText();
		sri2.verifyConclusionColorAndText(driver,conclusion4a,value4,measurement4,softly);
		//5
		//Date
		String date5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement5Date)).getText();
		softly.assertThat(date5).as("test data").isEqualTo(storeDataStep2.get("date5"));
		//Time
		String time5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement5Time)).getText();
		softly.assertThat(time5).as("test data").isEqualTo(storeDataStep2.get("time5"));
		//Measurement
		String measurement5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement5Measurement)).getText();
		softly.assertThat(measurement5).as("test data").isEqualTo(storeDataStep2.get("measurement5"));
		//unit
		String unit5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement5Unit)).getText();
		softly.assertThat(unit5).as("test data").isEqualTo(storeDataStep2.get("unit5"));
		//Value
		String value5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement5Value)).getText();
		softly.assertThat(value5).as("test data").isEqualTo(storeDataStep2.get("value5"));
		//Notes
		String note5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement5Note)).getText();
		softly.assertThat(note5).as("test data").isEqualTo(storeDataStep2.get("note5"));
		//Conclusion
		String conclusion5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement5Conclusion)).getText();
		sri2.verifyConclusion(driver, conclusion5, value5, measurement5, softly);
		String conclusion5a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement5ConclusionColorText)).getText();
		sri2.verifyConclusionColorAndText(driver,conclusion5a,value5,measurement5,softly);
		//6
		//Date
		String date6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement6Date)).getText();
		softly.assertThat(date6).as("test data").isEqualTo(storeDataStep2.get("date6"));
		//Time
		String time6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement6Time)).getText();
		softly.assertThat(time6).as("test data").isEqualTo(storeDataStep2.get("time6"));
		//Measurement
		String measurement6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement6Measurement)).getText();
		softly.assertThat(measurement6).as("test data").isEqualTo(storeDataStep2.get("measurement6"));
		//unit
		String unit6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement6Unit)).getText();
		softly.assertThat(unit6).as("test data").isEqualTo(storeDataStep2.get("unit6"));
		//Value
		String value6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement6Value)).getText();
		softly.assertThat(value6).as("test data").isEqualTo(storeDataStep2.get("value6"));
		//Notes
		String note6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement6Note)).getText();
		softly.assertThat(note6).as("test data").isEqualTo(storeDataStep2.get("note6"));
		//Conclusion
		String conclusion6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement6Conclusion)).getText();
		sri2.verifyConclusion(driver, conclusion6, value6, measurement6, softly);
		String conclusion6a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement6ConclusionColorText)).getText();
		sri2.verifyConclusionColorAndText(driver,conclusion6a,value6,measurement6,softly);
		//7
		//Date
		String date7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement7Date)).getText();
		softly.assertThat(date7).as("test data").isEqualTo(storeDataStep2.get("date7"));
		//Time
		String time7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement7Time)).getText();
		softly.assertThat(time7).as("test data").isEqualTo(storeDataStep2.get("time7"));
		//Measurement
		String measurement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement7Measurement)).getText();
		softly.assertThat(measurement7).as("test data").isEqualTo(storeDataStep2.get("measurement7"));
		//unit
		String unit7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement7Unit)).getText();
		softly.assertThat(unit7).as("test data").isEqualTo(storeDataStep2.get("unit7"));
		//Value
		String value7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement7Value)).getText();
		softly.assertThat(value7).as("test data").isEqualTo(storeDataStep2.get("value7"));
		//Notes
		String note7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement7Note)).getText();
		softly.assertThat(note7).as("test data").isEqualTo(storeDataStep2.get("note7"));
		//Conclusion
		String conclusion7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement7Conclusion)).getText();
		sri2.verifyConclusion(driver, conclusion7, value7, measurement7, softly);
		String conclusion7a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement7ConclusionColorText)).getText();
		sri2.verifyConclusionColorAndText(driver,conclusion7a,value7,measurement7,softly);
		//8
		//Date
		String date8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement8Date)).getText();
		softly.assertThat(date8).as("test data").isEqualTo(storeDataStep2.get("date8"));
		//Time
		String time8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement8Time)).getText();
		softly.assertThat(time8).as("test data").isEqualTo(storeDataStep2.get("time8"));
		//Measurement
		String measurement8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement8Measurement)).getText();
		softly.assertThat(measurement8).as("test data").isEqualTo(storeDataStep2.get("measurement8"));
		//unit
		String unit8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement8Unit)).getText();
		softly.assertThat(unit8).as("test data").isEqualTo(storeDataStep2.get("unit8"));
		//Value
		String value8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement8Value)).getText();
		softly.assertThat(value8).as("test data").isEqualTo(storeDataStep2.get("value8"));
		//Notes
		String note8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement8Note)).getText();
		softly.assertThat(note8).as("test data").isEqualTo(storeDataStep2.get("note8"));
		//Conclusion
		String conclusion8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement8Conclusion)).getText();
		sri2.verifyConclusion(driver, conclusion8, value8, measurement8, softly);
		String conclusion8a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.ReportTabMeasurement8ConclusionColorText)).getText();
		sri2.verifyConclusionColorAndText(driver,conclusion8a,value8,measurement8,softly);
	}

	public int getCharCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(sri.Step1TitleCharacterCount).getText();
		s=s.substring(1,s.indexOf("/"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public int getTotalCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(sri.Step1TitleCharacterCount).getText();
		s=s.substring((s.indexOf("/")+1), s.indexOf(")"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public void step2Verify(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify value is empty
		String value = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Value)).getAttribute("value");
		softly.assertThat(value).as("test data").isEmpty();
		//Verify date is empty
		String date = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2DateField)).getAttribute("value");
		softly.assertThat(date).as("test data").isEmpty();
		//Verify time is empty
		String time = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2TimeField)).getAttribute("value");
		softly.assertThat(time).as("test data").isEmpty();
		//Verify Measurement is empty
		String meas = driver.findElement(sri.Step2Measurement).getAttribute("value");
		softly.assertThat(meas).as("test data").isEqualTo("0");
		//Verify unit is empty
		String unit = driver.findElement(sri.Step2Unit).getAttribute("value");
		softly.assertThat(unit).as("test data").isEqualTo("0");
		//Verify notes is empty
		String notes = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Notes)).getAttribute("value");
		softly.assertThat(notes).as("test data").isEmpty();
		//softly.assertAll();
	}

	public void checkTitleCountReset(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).sendKeys("aaaa");
		Thread.sleep(500);
		//Get count
		int count = getCharCountFromTitle(driver);
		if(count!=4)
			softly.fail("Count did not match: aaaa: " + count);
		//Clear text
		for(int i=0;i<4;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(250);
		}
		count = getCharCountFromTitle(driver);
		
		if(count!=1)
			softly.fail("Count did not match: aaaa: " + count);
	}

	public String path_SRI(WebDriver driver, String username, String password)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		WebDriverWait wait2 = new WebDriverWait(driver,2);
		sriA.SRIAdminTest(driver,softly);
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(hc.AnalysisLink)).click();
		//Click on MainClass.SRI
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRILink)).click();
		//Verify no success popup
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(login.StickySuccessPopup));
			softly.fail("Sticky popup seen: "+wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText());
		}catch(org.openqa.selenium.TimeoutException t)
		{

		}
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewButton)).click();
		sri3.verifyNewReportPopup(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveConfirmButton)).click();
		
		
		
		
		//Step 1 check for errors
		checkForErrorStep1(driver);
		//Check title count reset when characters are entered and deleted
//		checkTitleCountReset(driver);
		//Fill Step 1 for mechanical component
		step1DataFill(driver,sri2.text,sriA2.mechanicalComponent1,0);
		
		//Get Data from Step 1
		HashMap<String,String> storeDataStep1 = getStep1Data(driver);
		//Click on next step 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIStep1NextButton)).click();

		
		
		//Step 2 - add 2 measurements
		//Verify no warning message appears in new reports
		try{
			wait2.until(ExpectedConditions.visibilityOfElementLocated(login.StickyWarningPopup));
			softly.fail("Sticky popup seen: "+wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText());
		}catch(org.openqa.selenium.TimeoutException e)
		{
			
		}
		step2Verify(driver);
		//1
		step2AddMeasurement(driver,sri2.text,sriA2.mechanicalMeasurement1, sriA2.mechanicalUnit1, "9");
		//2
		step2AddMeasurement(driver,sri2.text,sriA2.mechanicalMeasurement2, sriA2.mechanicalUnit2, "-2");
		//Change date of 1st measurement twice
		changeDate1stMeasurementAndVerifyOrderOfMeasurements(driver);
		changeDate1stMeasurementAndVerifyOrderOfMeasurements(driver);
		//Change time of 1st measurement twice and make date equal with 2nd measurement
		changeTimeOfMeasurementsAndVerifyOrderOfMeasurements(driver);
		//Step 2 - add more measurements
		//3
		step2AddMeasurement(driver,sri2.text,sriA2.mechanicalMeasurement1, sriA2.mechanicalUnit1, "11");
		//4
		step2AddMeasurement(driver,sri2.text,sriA2.mechanicalMeasurement2, sriA2.mechanicalUnit2, "-0.98");
		//5
		step2AddMeasurement(driver,sri2.text,sriA2.mechanicalMeasurement1, sriA2.mechanicalUnit1, "22");
		//6
		step2AddMeasurement(driver,sri2.text,sriA2.mechanicalMeasurement2, sriA2.mechanicalUnit2, "2.5");
		//7
		step2AddMeasurement(driver,sri2.text,sriA2.mechanicalMeasurement1, sriA2.mechanicalUnit1, "32");
		//8
		step2AddMeasurement(driver,sri2.text,sriA2.mechanicalMeasurement2, sriA2.mechanicalUnit2, "3.5");
		//get data from step 2
		HashMap<String,String> storeDataStep2 = sri2.getStep2AllData(driver);
		//Verify only even number of rows in table of step 2 and no extra row at the end
		sri3.verifyOnlyEvenNumberOfRowsInStep2Table(driver, softly);
		//Verify order of measurements
		verifyOrderOfMeasurements(driver,storeDataStep2.get("date1"),storeDataStep2.get("date2"),storeDataStep2.get("time1"),storeDataStep2.get("time2"));
		
		
		/*am_fastchecking
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1EventTitle)).sendKeys("xxx");

		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step1InspectionStaff)).sendKeys("xxx");
		


		Select dropdown = new Select(driver.findElement(By.id("pii-sri-tab-1-component")));

		dropdown.selectByVisibleText("gear");
		am_fastchecking*/
		
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINextButton)).click();
		//Verify everything on report
//		verifyReportTab(driver,storeDataStep1,storeDataStep2);
		//Save report and open the report
		String recordName = sri3.saveSRIReport(driver,softly);
		//Verify data on HTML
//		sri2.verifyHTML(driver,storeDataStep1,storeDataStep2,softly);
		//Verify rename popup overflow
		sri2.verifySavePopupAfterRename(driver, softly,recordName,username,password,sriA2.electricalComponent1);
		return recordName;
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
