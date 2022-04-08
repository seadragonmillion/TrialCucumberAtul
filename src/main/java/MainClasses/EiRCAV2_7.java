import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import kaleTestSoftware.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EiRCAV2_7 {

	ShareCheck3 share3 = new ShareCheck3();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	ErrorMeter3 em3 = new ErrorMeter3 ();
	EiRCAV2PageObj eirca = new EiRCAV2PageObj();
	LoginPageObj login = new LoginPageObj();

	public void shareReport(WebDriver driver,String username, String password1,int y, SoftAssertions softly) throws Exception{

		String sharer = em3.decideSharer (y);
		String sharerAdded = em3.decideSharerAdded (y);	
		shareReportAfterChoosingSharer(driver,username,password1,sharer,sharerAdded,softly);
	}

	public void shareReportAfterChoosingSharer(WebDriver driver,String username, String password1, String sharer, String sharerAdded, SoftAssertions softly) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on share button
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareButton)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareButton)));
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
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareSaveButton)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareSaveButton)));		
		//Verify share save sticky
		verifyStickyShareSave(driver, softly);
		//Click back
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)));
		jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)));
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

	public void deleteNewRecord(WebDriver driver,String recordName, int y, SoftAssertions softly) throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		//Clicks on delete button
		share2.loadingServer(driver);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.DeleteButton))); 
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.DeleteButton))); 
//	driver.findElement(eirca.DeleteButton).click();
		//Verify delete popup
		if (browserName.contains("safari")==false)
		{					
			verifyDeleteReportPopup(driver, softly, recordName);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle));
		//Clicks on delete report
		jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		//Verify delete pop up
		if (browserName.contains("safari")==false)
		{					
			verifyStickyDeleteReport(driver, softly, recordName);
		}
		Thread.sleep(2000);
		jse.executeScript("return document.getElementById('pii-user-home-panel-btn-mirca').click();");
		//Verify record deleted
		//Click on 1st record
		String name = driver.findElement(eirca.EiRCAFirstRecord).getText();
		System.out.println("SavedActivities1stReportname is   "+name);
		if (name!=recordName)
			System.out.println("Record deleted");
		else
			System.out.println("Record could not be deleted");
		//Verify report not retrieved by shared to person		
		String sharer = em3.decideSharer (y);
		share.checkNoReportAfterDelete(driver, sharer, softly);		  			  
	}

	public void downloadReport(WebDriver driver, HashMap <String,String> hm, SoftAssertions softly, String textTitle, 
			HashMap<String,String> hmStep1, HashMap<String,String> hmStep2symptomsData, HashMap<String,String> hmStep3Data, 
			HashMap<String,List<String>> hmStep3FACTSData, List<String> step4, List<String> step3, 
			String analysisAdded, HashMap<String,String> step7, List<String> symptoms, List<String> dcAcCfNames)throws Exception {

		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		//Download report to check pdf
		if (browserName.equals("chrome"))
			downloadRecordChrome(driver,hm,softly,textTitle, hmStep1, hmStep2symptomsData, hmStep3Data, hmStep3FACTSData, step4, step3, analysisAdded, step7, symptoms, dcAcCfNames);
		if (browserName.equals("firefox"))
			downloadRecordFirefox(driver,hm,softly,textTitle, hmStep1, hmStep2symptomsData, hmStep3Data, hmStep3FACTSData, step4, step3, analysisAdded, step7, symptoms, dcAcCfNames);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				downloadRecordIE10(driver,hm,softly,textTitle, hmStep1, hmStep2symptomsData, hmStep3Data, hmStep3FACTSData, step4, step3, analysisAdded, step7, symptoms, dcAcCfNames);
			if (v.startsWith("11"))
				downloadRecordIE11(driver,hm,softly,textTitle, hmStep1, hmStep2symptomsData, hmStep3Data, hmStep3FACTSData, step4, step3, analysisAdded, step7, symptoms, dcAcCfNames);
		}
		if(browserName.toLowerCase().contains("safari"))
			driver.switchTo().defaultContent();
	}

	public void downloadRecordChrome(WebDriver driver, HashMap <String,String> hm, SoftAssertions softly, String textTitle, 
			HashMap<String,String> hmStep1, HashMap<String,String> hmStep2symptomsData, HashMap<String,String> hmStep3Data, 
			HashMap<String,List<String>> hmStep3FACTSData, List<String> step4, List<String> step3, 
			String analysisAdded, HashMap<String,String> step7, List<String> symptoms, List<String> dcAcCfNames) throws Exception {

		//deletes files in reports folder before starting to download
		//File file = new File("C://Users//rramakrishnan//report//");
		HiRCAEvent obj1 = new HiRCAEvent();
		//obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String window = driver.getWindowHandle();
		//Clicks on download button
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)));
//	wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)).click();
		//Verify pdf pop up
		verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify download pop up
		verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
	//	wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(8000);
		//pdfCheck(driver,hm,textTitle,softly, hmStep1, hmStep2symptomsData, hmStep3Data, hmStep3FACTSData, step4, step3, analysisAdded, step7, symptoms, dcAcCfNames);
		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\ChromSavePDF5_amlocal.exe");
		Thread.sleep(10000);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(4000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}

	public void downloadRecordFirefox(WebDriver driver, HashMap <String,String> hm, SoftAssertions softly, String textTitle, 
			HashMap<String,String> hmStep1, HashMap<String,String> hmStep2symptomsData, HashMap<String,String> hmStep3Data, 
			HashMap<String,List<String>> hmStep3FACTSData, List<String> step4, List<String> step3, 
			String analysisAdded, HashMap<String,String> step7, List<String> symptoms, List<String> dcAcCfNames) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)).click();
		//Verify pdf pop up
		verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		System.out.println("original window: "+window);
		//Verify download pop up
		verifyDownloadReportPopup(driver, softly);
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
		Thread.sleep(2000);
		pdfCheck(driver,hm,textTitle,softly, hmStep1, hmStep2symptomsData, hmStep3Data, hmStep3FACTSData, step4, step3, analysisAdded, step7, symptoms, dcAcCfNames);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();	  
		Thread.sleep(3000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}

	public void downloadRecordIE10(WebDriver driver, HashMap <String,String> hm, SoftAssertions softly, String textTitle, 
			HashMap<String,String> hmStep1, HashMap<String,String> hmStep2symptomsData, HashMap<String,String> hmStep3Data, 
			HashMap<String,List<String>> hmStep3FACTSData, List<String> step4, List<String> step3, 
			String analysisAdded, HashMap<String,String> step7, List<String> symptoms, List<String> dcAcCfNames) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)).click();
		//Verify pdf pop up
		verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		verifyDownloadReportPopup(driver, softly);
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
		pdfCheck(driver,hm,textTitle,softly, hmStep1, hmStep2symptomsData, hmStep3Data, hmStep3FACTSData, step4, step3, analysisAdded, step7, symptoms, dcAcCfNames);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);	   
		Thread.sleep(3000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}

	public void downloadRecordIE11(WebDriver driver, HashMap <String,String> hm, SoftAssertions softly, String textTitle, 
			HashMap<String,String> hmStep1, HashMap<String,String> hmStep2symptomsData, HashMap<String,String> hmStep3Data, 
			HashMap<String,List<String>> hmStep3FACTSData, List<String> step4, List<String> step3, 
			String analysisAdded, HashMap<String,String> step7, List<String> symptoms, List<String> dcAcCfNames) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)).click();
		//Verify pdf pop up
		verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		verifyDownloadReportPopup(driver, softly);
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
		pdfCheck(driver,hm,textTitle,softly, hmStep1, hmStep2symptomsData, hmStep3Data, hmStep3FACTSData, step4, step3, analysisAdded, step7, symptoms, dcAcCfNames);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);
		Thread.sleep(3000);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}

	public void pdfCheck(WebDriver driver, HashMap<String,String>hm, String textTitle, SoftAssertions softly, 
			HashMap<String,String> hmStep1, HashMap<String,String> hmStep2symptomsData, HashMap<String,String> hmStep3Data, 
			HashMap<String,List<String>> hmStep3FACTSData, List<String> step4, List<String> step3, 
			String analysisAdded, HashMap<String,String> step7, List<String> symptoms, List<String> dcAcCfNames) throws Exception{

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
		String newData3 = newData2.replace("  ", " ");
		String newData1 = newData3.replace("/ ", "/");
		//Verify text with html
		softly.assertThat(newData1).as("test data").contains(textTitle);
		//Suspected failed component
		if(hmStep1.get("Other suspected failed component")==null) softly.assertThat(newData1).as("test data").contains(hmStep1.get("Suspected failed component"));
		else softly.assertThat(newData1).as("test data").contains(hmStep1.get("Other suspected failed component"));
		//Primary symptoms
		if(hmStep1.get("Other primary symptom")==null) softly.assertThat(newData1).as("test data").contains(hmStep1.get("Primary symptom"));
		else softly.assertThat(newData1).as("test data").contains(hmStep1.get("Other primary symptom"));
		//Verify Sequence of Events in pdf
		softly.assertThat(newData1).as("test data").contains("Sequence of Events");
		softly.assertThat(newData1).as("test data").contains(hm.get("date1")+", "+hm.get("time1"));
		softly.assertThat(newData1).as("test data").contains(hm.get("what happened1"));
		softly.assertThat(newData1).as("test data").contains(hm.get("what is supposed to happen1"));
		softly.assertThat(newData1).as("test data").contains(hm.get("date2")+", "+hm.get("time2"));
		softly.assertThat(newData1).as("test data").contains(hm.get("what happened2"));
		softly.assertThat(newData1).as("test data").contains(hm.get("what is supposed to happen2"));
		//other data
		softly.assertThat(newData1).as("test data").contains(eirca.textStep2);
		for(int i=0;i<step4.size();i++)
		{
			softly.assertThat(newData1).as("test data").contains(step4.get(i));
		}
		for(int i=0;i<step3.size();i++)
		{
			softly.assertThat(newData1).as("test data").contains(step3.get(i));
		}
		for(int i=0;i<symptoms.size();i++)
		{
			softly.assertThat(newData1).as("test data").contains(symptoms.get(i));
		}
		int lengthOfSymptomsInspection = symptoms.size()-3;
		//SBI
		for (int i=1;i<=lengthOfSymptomsInspection;i++)
		{
			if(hmStep2symptomsData.get("SBI Symptom for inspection "+i)==null)
				break;
			softly.assertThat(newData1).as("test data").contains(hmStep2symptomsData.get("SBI Symptom for inspection "+i));
			softly.assertThat(newData1).as("test data").contains(hmStep2symptomsData.get("SBI Inspection parameter "+i));
			softly.assertThat(newData1).as("test data").contains(hmStep2symptomsData.get("SBI Inspection findings "+i));			
		}
		//SRI
		for (int i=1;i<=lengthOfSymptomsInspection;i++)
		{
			if(hmStep2symptomsData.get("SRI Symptom for inspection "+i)==null)
				break;
			softly.assertThat(newData1).as("test data").contains(hmStep2symptomsData.get("SRI Symptom for inspection "+i));
			softly.assertThat(newData1).as("test data").contains(hmStep2symptomsData.get("SRI Inspection parameter "+i));
			softly.assertThat(newData1).as("test data").contains(hmStep2symptomsData.get("SRI Inspection findings "+i));		
		}
		//Step 3
		for(int i=1;i<=step3.size();i++)
		{
			softly.assertThat(newData1).as("test data").contains(hmStep3Data.get("Symptoms type"+i));
			softly.assertThat(newData1).as("test data").contains(hmStep3Data.get("Symptoms name"+i));
			softly.assertThat(newData1).as("test data").contains(hmStep3Data.get("Implication"+i));
			List<String> f1 = hmStep3FACTSData.get("FACT "+i);
			List<String> c1 = hmStep3FACTSData.get("Char "+i);
			for(int j=0;j<f1.size();j++)
			{
				softly.assertThat(newData1).as("test data").contains("["+(j+1)+"] "+f1.get(j));
				softly.assertThat(newData1).as("test data").contains("["+(j+1)+"] "+c1.get(j));
			}
		}
		for(int i=0;i<dcAcCfNames.size();i++)
		{
			softly.assertThat(newData1).as("test data").contains(dcAcCfNames.get(i));
		}
		//Close pdf
		pddoc.close();
	}
	
	public void markCritical(WebDriver driver,String username, String password1,int y, SoftAssertions softly) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on mark critical
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		//Mark critical pop up
		verifyMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Checks if marked critical
		share2.loadingServer(driver);
		String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
		softly.assertThat(s).as("test data").contains("ui-checkbox-on");
		//Click back
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)));
//	wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
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
		verifyUnMarkCriticalPopup(driver, softly);
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

	public void verifyDownloadReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("PDF Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Your PDF report is ready.");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: The report will open in a separate window");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("open PDF report");		
	}

	public void verifyMarkCriticalPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Change Criticality");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to mark critical?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: \"Shared to\" users will be notified report is marked critical.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("confirm change");
	}

	public void verifyUnMarkCriticalPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Change Criticality");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to un-mark critical?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: \"Shared to\" users will be notified report is no longer marked critical.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("confirm change");
	}

	public void verifyDeleteReportPopup(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Delete Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("Are you sure you want to delete this EiRCA™ report ["+r1+"]?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: deleted data cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("delete report");
	}

	public void verifyBreakWordPropertyStickyNote(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		String wordWrap = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getCssValue("word-wrap");
		softly.assertThat(wordWrap).as("test data").isEqualTo("break-word");
		System.out.println("wordWrap "+wordWrap);
	}

	public void verifyStickySaveReport(WebDriver driver, SoftAssertions softly, String username, String reportTitle, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			verifyBreakWordPropertyStickyNote(driver, softly);
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			String r = s.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").contains(username+"_"+reportTitle);
			if(n == 0)
				softly.assertThat(r).as("test data").contains("EiRCA™ Data created for id:");
			else
				softly.assertThat(r).as("test data").contains("EiRCA™ Data updated for id:");
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException r)
		{
			System.out.println("Couldn't find save pop up");
			Thread.sleep(2000);
		}
	}

	public void verifyStickyShareSave(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);		
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			softly.assertThat(s).as("test data").isEqualTo("Sharing updated successfully.");
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException r)
		{
			System.out.println("Couldn't find share save pop up");
		}
	}

	public void verifyStickyCreatePDF(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);		
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			softly.assertThat(s).as("test data").isEqualTo("PDF successfully built and downloaded");
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException r)
		{
			System.out.println("Couldn't find pdf create pop up");
		}
	}

	public void verifyStickyDeleteReport(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);		
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyNote)).getText();
			String r = s.replaceAll("\u00AD", "");
			String r1 = recordName.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").isEqualTo("EiRCA™ data deleted: "+r1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(login.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException r)
		{
			System.out.println("Couldn't find delete pop up");
		}
	}
}
