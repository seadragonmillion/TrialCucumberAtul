import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kaleTestSoftware.*;
import kaleTestSoftware.CaseBrowse;
import kaleTestSoftware.EquipmentPDDandEF;
import kaleTestSoftware.LoginPageObj;
import kaleTestSoftware.ShareCheck2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCaseSRI {	

	SoftAssertions softly = new SoftAssertions();	
	CreateEquipmentCase equip = new CreateEquipmentCase ();
	CreateEquipmentCase3 equip3 = new CreateEquipmentCase3 ();
	CaseBrowse cb = new CaseBrowse();
	EquipmentPDDandEF epe = new EquipmentPDDandEF ();
	LoginPageObj lpo = new LoginPageObj();
	CreateEquipPageObj equipObj = new CreateEquipPageObj();
	CreateHumanCasePageObj chc = new CreateHumanCasePageObj();
	ShareCheck2 share2 = new ShareCheck2();

	public String keywordSRI = "QAASRITestSlides";
	public String key1SRI = "QAAzebraSRI";
	public String key2SRI = "QAAcamelSRI";
	public String key3SRI = "QAAhorseSRI";
	public String titleSRI = "QAA SRI Test Slides";
	public String keywordSRIie11 = "QAASRITestSlidesie11";
	public String key1SRIie11 = "QAAzebraSRIie11";
	public String key2SRIie11 = "QAAcamelSRIie11";
	public String key3SRIie11 = "QAAhorseSRIie11";
	public String titleSRIie11 = "QAA IE11 SRI Test Slides";
	public String keywordSRIUS = "QAAUSSRITestSlides";
	public String key1SRIUS = "QAAUSzebraSRI";
	public String key2SRIUS = "QAAUScamelSRI";
	public String key3SRIUS = "QAAUShorseSRI";
	public String titleSRIUS = "QAA US SRI Test Slides";
	public String keywordSRIUSie11 = "QAAUSSRITestSlidesie11";
	public String key1SRIUSie11 = "QAAUSzebraSRIie11";
	public String key2SRIUSie11 = "QAAUScamelSRIie11";
	public String key3SRIUSie11 = "QAAUShorseSRIie11";
	public String titleSRIUSie11 = "QAA US IE11 SRI Test Slides";

	public void createCaseSRI (WebDriver driver, String keyword, String key1, String key2, String key3, String title) throws Exception {

		List<String> caseSRI= new ArrayList<String>();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		//Deletes any previous cases if any for SRI
		equip.deletePreviousCase(driver, title);
		//Create cases for SRI
		if(browserName.contains("chrome"))
			caseSRI.addAll(createCaseChrome(driver, keyword, key1, key2, key3, title));
		if(browserName.contains("firefox"))
			caseSRI.addAll(createCaseFirefox(driver, keyword, key1, key2, key3, title));
		if(browserName.contains("internet explorer"))
		{
			if(v.startsWith("10"))
				caseSRI.addAll(createCaseIE10(driver, keyword, key1, key2, key3, title));
			else
				caseSRI.addAll(createCaseIE11(driver, keyword, key1, key2, key3, title));
		}
		System.out.println("Cases for SRI "+caseSRI);
		Thread.sleep(2000);
		//Verify if names of case modules correct
		epe.verifyCaseModuleNames(driver);
		Thread.sleep(2000);
		//Go to Equipment PII link
		epe.getEquipPerformancePIILink(driver);
		Thread.sleep(2000);
		//Browse for SRI case in Equipment PII
		cb.browseCaseIDEquip(driver, caseSRI.get(0), title);
		cb.browseTermEquip(driver, keyword, caseSRI.get(0), title);
		Thread.sleep(2000);
		//Go to SRI link
		cb.getSRILink(driver);
		//Browse for SRI case in SRI
		cb.browseTermEquip(driver, keyword, caseSRI.get(0), title);
		//Search for case in Equipment performance by keyword
		epe.searchCaseInEquipSearchByKeyword(driver, keyword, caseSRI.get(0));
		//Search for case in Equipment performance by case id
		epe.searchCaseInEquipSearchByCaseID(driver, caseSRI.get(0));
		//Search for SRI case in Failure Modes
		epe.searchCaseIdInFailureModes(driver, caseSRI.get(0));
		epe.searchCaseInFMWithKeyword(driver, keyword, caseSRI.get(0));
		//Verify that SRI case does not appear in EF
		epe.searchCaseInEngineeringFundamentalsWithKeyword(driver, keyword, caseSRI.get(0));
		epe.searchCaseIdInEngineeringFundamentals(driver, caseSRI.get(0));
		//Verify that SRI case does not appear in PDD
		epe.searchCaseInPreventionOfDesignDeficienciesWithKeyword(driver, keyword, caseSRI.get(0));
		epe.searchCaseIdInPreventionOfDesignDeficiencies(driver, caseSRI.get(0));		
		//Check keyword and cases in SRI
		equip.checkkeyword(driver, caseSRI, keyword, key1, key2, key3, 3, title);
		//Delete SRI case
		equip.deleteCase(driver, caseSRI);
		System.out.println("Cases deleted for SRI");
	}

	public List<String> createCaseChrome(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
		//Pick a Random number for case id
		Random random = new Random();
		List<String> caseID = new ArrayList<String>();
		String caseId="";
		for(int count=1;count<=5;count++)
		{		
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(equipObj.EquipCaseIDFieldError);
				}catch(NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
			}
			System.out.println("Case id: "+ caseId);
			//Add Case is to list
			caseID.add(caseId);
			//Select Type
			selectTypeSRI(driver,keyword_same);
			//Select Discipline
			epe.selectDisciplineEFPDD(driver);
			//Select Fields
			equip3.selectFields(driver,softly);
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
			share2.scrollToAPoint(driver, 1700);
			//Enters Keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same);
			Thread.sleep(2000);
			//Make sure keyword typed in right
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).getAttribute("value");
			if(s.equals(keyword_same) == false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same);
			}
			if(count==1)
			{
				share2.loadingServer(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key1);
				share2.loadingServer(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key2);
				share2.loadingServer(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key3);
				share2.loadingServer(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();			  
			}
			else 
			{
				share2.scrollToAPoint(driver, 1700);
				WebElement element = driver.findElement(equipObj.EquipCaseKeywordExistingList);
				element.findElement(chc.FirstAndLastChildInList).click();
			}
			Thread.sleep(2000);
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
			share2.scrollToElement(driver, l);
			String file1 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide1.png";
			String file2 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide2.png";
			String file3 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide3.png";
			String file4 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide4.png";
			String file5 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide5.png";
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageUploadField)).sendKeys(file1+"\n"+file2+"\n"+file3+"\n"+file4+"\n"+file5);
			//executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageUploadField)));
			//Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
			//p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(equipObj.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
				share2.scrollToElement(driver, l);
				l.click();
			}
			int i;
			for (i=0; i<5;i++)
			{
				String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
				{
					System.out.println("Uploaded Image : " + (i+1));
					//list.add(driver.findElement(By.xpath(xpath)));
				}

			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible)).click();
			share2.scrollToTop(driver);
			Thread.sleep(2000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
		}
		return caseID;
	}

	public List<String> createCaseFirefox(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share2.scrollToTop(driver);
		Thread.sleep(1000);
		Random random = new Random();
		String caseId="";
		List<String> caseID = new ArrayList<String>();
		for(int count=1;count<=5;count++)
		{	
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Pick a Random number for case id
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(equipObj.EquipCaseIDFieldError);
				}catch(NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
			}
			System.out.println("Case id: "+ caseId);
			//Add case to list
			caseID.add(caseId);
			//Select Type
			selectTypeSRI(driver,keyword_same);
			//Select Discipline
			epe.selectDisciplineEFPDD(driver);
			//Select Fields
			equip3.selectFields(driver,softly);
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
			share2.scrollToAPoint(driver, 1700);
			//Enters Keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same);
			Thread.sleep(2000);
			if(count==1)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key1);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key2);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key3);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();			  
			}
			else 
			{
				share2.scrollToAPoint(driver, 1700);
				WebElement element = driver.findElement(equipObj.EquipCaseKeywordExistingList);
				element.findElement(chc.FirstAndLastChildInList).click();
			}
			Thread.sleep(2000);
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
			share2.scrollToElement(driver, l);
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageUploadField)));
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_Firefox.exe");
			p.waitFor();
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(equipObj.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
				share2.scrollToElement(driver, l);
				l.click();
			}
			int i;
			for (i=0; i<5;i++)
			{
				String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
				{
					System.out.println("Uploaded Image : " + (i+1));
				}

			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible)).click();
			share2.scrollToTop(driver);
			Thread.sleep(2000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
		}
		return caseID;
	}

	public List<String> createCaseIE10(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title) throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> caseID = new ArrayList<String>();
		for(int count=1;count<=5;count++)
		{			
			//Clicks on admin user name on top right corner
			wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
			//Clicks on admin option
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
			}catch(org.openqa.selenium.TimeoutException t)
			{
				Thread.sleep(1000);
				//Clicks on admin user name on top right corner
				wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
				//Clicks on admin option
				wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
			}
			//Clicks on Errorfree bank option
			if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
			}
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share2.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Pick a Random number for case id
			Random random = new Random();
			String caseId="";
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(equipObj.EquipCaseIDFieldError);
				}catch(NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
			}
			System.out.println("Case id: "+ caseId);
			//Add case to list
			caseID.add(caseId);
			//Select Type
			selectTypeSRI(driver,keyword_same);
			//Select Discipline
			epe.selectDisciplineEFPDD(driver);
			//Select Fields
			equip3.selectFields(driver,softly);
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
			share2.scrollToAPoint(driver, 1700);
			//Enters Keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same);
			Thread.sleep(2000);
			if(count==1)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key1);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key2);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key3);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();			  
			}
			else 
			{
				Thread.sleep(1000);
				share2.scrollToAPoint(driver, 1700);
				WebElement element = driver.findElement(equipObj.EquipCaseKeywordExistingList);
				share2.scrollToElement(driver, element);
				element.findElement(chc.FirstAndLastChildInList).click();
			}
			Thread.sleep(2000);
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
			share2.scrollToElement(driver, l);
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageUploadField));
			try{
				jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
			}catch(org.openqa.selenium.ScriptTimeoutException r)
			{
				Thread.sleep(2000);
				jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
				Thread.sleep(2000);
			}
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
			p.waitFor();
			Thread.sleep(4000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(equipObj.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
				share2.scrollToElement(driver, l);
				l.click();
			}
			int i;
			for (i=0; i<5;i++)
			{
				String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
				try{
					if (driver.findElement(By.xpath(xpath)).isDisplayed())
					{
						System.out.println("Uploaded Image : " + (i+1));
					}
				}catch(org.openqa.selenium.TimeoutException | NoSuchElementException r)
				{
					break;
				}
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible)).click();
			share2.scrollToTop(driver);
			Thread.sleep(2000);
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
		}
		return caseID;
	}

	public List<String> createCaseIE11(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title) throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;		
		WebDriverWait wait = new WebDriverWait(driver,40);
		List<String> caseID = new ArrayList<String>();
		for(int count=1;count<=5;count++)
		{
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			if(driver.getCurrentUrl().contains("kale.")||driver.getCurrentUrl().contains("kaleasia"))
				share2.loadingServer(driver);
			while(true)
			{
				try{
					if (driver.findElement(lpo.StickyNote).isDisplayed())
					{
						Thread.sleep(2000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();

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
				catch (ElementNotInteractableException u)
				{
					break;
				}
				catch (org.openqa.selenium.JavascriptException t)
				{
					Thread.sleep(2000);
					break;
				}

			}			
			while(true)
			{
				//Clicks on admin user name on top right corner
				wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
				try{
					//Clicks on admin option
					wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
					break;
				}catch(org.openqa.selenium.TimeoutException| NoSuchElementException t)
				{
					continue;
				}
			}
			//Clicks on Errorfree bank option
			if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
			}
			//Clicks on Equipment cases
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			Thread.sleep(1000);
			share2.scrollToTop(driver);
			Thread.sleep(1000);
			//Clicks on new case button
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton)).click();
			//Clicks on new case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Pick a Random number for case id
			Random random = new Random();
			String caseId="";
			while (true)
			{
				Thread.sleep(1000);
				int y=random.nextInt(10000);
				if(y<1000)
					continue;
				caseId = String.format("%d", y);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).sendKeys(caseId);
				Thread.sleep(1000);
				Thread.sleep(1000);
				WebElement errorCaseId;
				try{
					errorCaseId=driver.findElement(equipObj.EquipCaseIDFieldError);
				}catch(NoSuchElementException e)
				{
					break;
				}
				if(errorCaseId.isDisplayed()==true)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
					continue;
				}
				if(errorCaseId.isDisplayed()==false)
					break;
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseIDField)).clear();
			}
			System.out.println("Case id: "+ caseId);
			//Add case to list
			caseID.add(caseId);
			//Select Type
			selectTypeSRI(driver,keyword_same);
			//Select Discipline
			epe.selectDisciplineEFPDD(driver);
			//Select Fields
			equip3.selectFields(driver,softly);
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
			share2.scrollToAPoint(driver, 1700);;
			//Enters Keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same);
			Thread.sleep(2000);
			if(count==1)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key1);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key2);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key3);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();			  
			}
			else 
			{
				share2.scrollToAPoint(driver, 1700);
				WebElement element = driver.findElement(equipObj.EquipCaseKeywordExistingList);
				element.findElement(chc.FirstAndLastChildInList).click();
			}
			Thread.sleep(2000);
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
			share2.scrollToElement(driver, l);
			jse.executeScript("return document.getElementById('pii-admin-efse-upload-file-input').click();");
			Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlides_IE10.exe");
			p.waitFor();
			Thread.sleep(4000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(equipObj.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
				share2.scrollToElement(driver, l);
				l.click();
			}
			int i;
			for (i=0; i<5;i++)
			{
				String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
				try{
					if (driver.findElement(By.xpath(xpath)).isDisplayed())
					{
						System.out.println("Uploaded Image : " + (i+1));
					}
				}catch(org.openqa.selenium.TimeoutException | NoSuchElementException r)
				{
					break;
				}
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible)).click();
			share2.scrollToTop(driver);
			Thread.sleep(2000);
			//Clicks on save
			jse.executeScript("return document.getElementById('pii-admin-efse-button-save').click();");
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle));
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Wait again for ie11
			share2.loadingServer(driver);
		}
		return caseID;
	}

	public void selectTypeSRI(WebDriver driver, String keyword) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Type
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
			}
		}
		else{
			//Type
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxTypes));
		if (browserName.contains("internet")==true)
		{
			//if(v.startsWith("11")==true)
			//{
				equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesSRI);
			//}
		}
		else
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesSRI)).click();
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxTypesCrossSymbol).click();
		}
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
