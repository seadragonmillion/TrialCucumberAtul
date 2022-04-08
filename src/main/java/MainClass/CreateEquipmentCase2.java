package MainClass;

import java.util.ArrayList;
import java.util.List;

import PageObjects.CaseBrowsePageObj;
import PageObjects.CreateEquipPageObj;
import PageObjects.CreateHumanCasePageObj;
import PageObjects.LoginPageObj;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateEquipmentCase2 {	

	LoginPageObj lpo = new LoginPageObj();
	CreateEquipPageObj equipObj = new CreateEquipPageObj();
	CreateEquipmentCase3 equip = new CreateEquipmentCase3();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	CaseBrowsePageObj cb = new CaseBrowsePageObj();
	CreateHumanCasePageObj chc = new CreateHumanCasePageObj();

	public String keyword = "KeywordQAAadded";
	public String keywordUS = "KeywordUSQAAadded";
	public String keywordie11 = "Keywordie11QAAadded";
	public String keywordUSie11 = "KeywordUSie11QAAadded";

	public String keywordDecide(WebDriver driver) throws Exception {

		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		//Get url
		if(driver.getCurrentUrl().contains("kale."))
		{
			if(browserName.equals("internet explorer")&&(v.startsWith("11")))
			{
				return keywordUSie11;
			}
			else
				return keywordUS;
		}
		else{
			if(browserName.equals("internet explorer")&&(v.startsWith("11")))
			{
				return keywordie11;
			}
			else
				return keyword;
		}
	}

	public void addNewKeywordToOldCase (WebDriver driver, String caseID) throws Exception {

		CaseBrowse obj = new CaseBrowse();
		EquipmentPDDandEF obj1 = new EquipmentPDDandEF();
		WebDriverWait wait = new WebDriverWait(driver,10);
		if((caseID.equals(obj.caseElecDev))||(caseID.equals(obj.caseMechDev))||(caseID.equals(obj.caseEquipDev))||(caseID.equals(obj1.caseEFDev))||(caseID.equals(obj1.casePDDDev)))
		{
			//Add keyword
			equip.addKeywordEquip(driver,caseID,keywordDecide(driver));
		}
		if((caseID.equals(obj.caseElecDev))||(caseID.equals(obj.caseMechDev)))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click(); 
		}
		if(caseID.equals(obj.caseEquipDev))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
		}
		if(caseID.equals(obj1.caseEFDev))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EngineeringFundamentalsLink)).click();
		}
		if(caseID.equals(obj1.casePDDDev))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.PreventionOfDesignDeficienciesLink)).click();
		}
		//Clears Everything
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keywordDecide(driver));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseID)));
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Remove added keyword
		removeAddedKeyword(driver,caseID);
	}

	public void removeAddedKeyword(WebDriver driver, String caseID) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.AdminOption)).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(equipObj.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankAdminLink)).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasesLink)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share2.scrollToTop(driver);
		Thread.sleep(1000);
		//CLick on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(caseID);
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share2.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseEditButton)).click();
		Thread.sleep(2000);
		//Scroll down
		try{
			jse.executeScript("scroll(0,2000)");
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,2000)");
		}
		Thread.sleep(1000);
		//Click on added new keyword
		int i=0;
		while(true)
		{
			i=i+1;
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-keyword-form']/div/ul/li["+i+"]/a"))).getText();
			System.out.println(s);
			if(s.contains(keywordDecide(driver)))
			{
				//click on it
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-keyword-form']/div/ul/li["+i+"]/a"))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-keyword-form']/div/ul/li["+i+"]/a"))));
				Thread.sleep(2000);
				break;
			}
		}
		Thread.sleep(2000);
		//Clicks on remove keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)));
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(2000);
		//Scroll to top
		share2.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share2.scrollToTop(driver);
		Thread.sleep(1000);
	}

	public void decideEquipmentModule(WebDriver driver, int x) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		if((x == 1)||(x==2)||(x==6))
		{
			//click on Equipment performance
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
			//Select Type
			selectTypeAsPerX(driver,x);
		}
		if(x==3)
		{
			//Click on Prevention of Design Deficiencies
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.PreventionOfDesignDeficienciesLink)).click();
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		}
		if(x==4)
		{
			//Click on Failure mode
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		}
		if(x==5)
		{
			//Click on Engineering Fundamentals
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EngineeringFundamentalsLink)).click();
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		}
	}

	public void selectTypeRandom (WebDriver driver, int x, String browserName, String v) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
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
		//Waits for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxTypes));
		//Click type random
		if(x==1)
		{
			if (browserName.contains("internet"))
			{
				equip.clickTypesDisciplineIE(driver, equipObj.EquipListTypesAdvancedLearning);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesAdvancedLearning)).click();
		}
		if(x==2)
		{
			if (browserName.contains("internet"))
			{
				equip.clickTypesDisciplineIE(driver, equipObj.EquipListTypesCaseStudies);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesCaseStudies)).click();
		}
		if(x==3)
		{
			if (browserName.contains("internet"))
			{
				equip.clickTypesDisciplineIE(driver, equipObj.EquipListTypesDesign);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesDesign)).click();
		}
		if(x==4)
		{
			if (browserName.contains("internet"))
			{
				equip.clickTypesDisciplineIE(driver, equipObj.EquipListTypesFailureModes);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesFailureModes)).click();
		}
		if(x==5)
		{
			if (browserName.contains("internet"))
			{
				equip.clickTypesDisciplineIE(driver, equipObj.EquipListTypesFundamentals);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesFundamentals)).click();
		}
		if(x==6)
		{
			if (browserName.contains("internet"))
			{
				equip.clickTypesDisciplineIE(driver, equipObj.EquipListTypesGeneral);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesGeneral)).click();
		}		
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxTypesCrossSymbol).click();
		}
		System.out.println("Selected type: "+x);			
	}

	public void verifyTypeNotEmpty(WebDriver driver, int x, String browserName, String v) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		while(true)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypeFieldText)).getText();			
			if(s.isEmpty()==true)
			{
				selectTypeRandom (driver, x, browserName, v);
			}
			else break;
		}
	}
	
	public void verifyDisciplineNotEmpty(WebDriver driver, By element, String browserName, String v) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		while(true)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDisciplineFieldText)).getText();			
			if(s.isEmpty()==true)
			{
				equip.selectDisciplineForComboTest(driver, element, browserName, v);
			}
			else break;
		}
	}
	
	public void verifyFieldNotEmpty(WebDriver driver, By element, String browserName, String v) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		while(true)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFieldsFieldText)).getText();			
			if(s.isEmpty()==true)
			{
				equip.selectFieldsForComboTest(driver, element, browserName, v);
			}
			else break;
		}
	}

	public void caseSearchWithDisciplineFieldComboEquipmentDatabank(WebDriver driver, int x, String keyword, List<String> electrical, List<String> general, List<String> ic, List<String> mechanical, List<String> software, List<String> structural) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Go to Failure mode
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Equipment Databank (Instructor only)
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyLink1)).click();
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Search for keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message
		share2.loadingServer(driver);
		//Look for all cases without filter
		equip.lookForCases(driver, electrical);
		equip.lookForCases(driver, general);
		equip.lookForCases(driver, ic);
		equip.lookForCases(driver, mechanical);
		equip.lookForCases(driver, software);
		equip.lookForCases(driver, structural);
		//Look for case with filter
		//Create a list with discipline filters for case search
		List<By> discList = equip.disciplineCaseSearchList();
		//Create a list with field filters for case search
		List<By> fieldList = equip.fieldCaseSearchList();
		//Search and verify case with filter
		for(int i=0;i<discList.size();i++)
		{
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
			//Select Type
			selectTypeAsPerX(driver, x);
			//Click on discipline box
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineBox)).click();
			//Wait for popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineList));
			//Click on discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(discList.get(i))).click();
			//Close pop up
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplinePopupClose)).click();
			//Search for keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
			//Wait for loading message
			share2.loadingServer(driver);
			//Verify cases with only discipline filter
			verifyCasesWithOnlyDisciplineFilter(driver, i, electrical, general, ic, mechanical, software, structural);
			//Select field filter and disc filter
			selectFieldDiscFilter (driver, x, i, discList, fieldList, keyword, electrical, general, ic, mechanical, software, structural);
		}
	}

	public void selectTypeAsPerX(WebDriver driver, int x) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeList));
		//Click on type
		if(x==1)
		{
			//Click on Advanced Learning 
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesAdvancedLearning)).click();
		}
		if(x==2)
		{
			//Click on Case Studies
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesCaseStudies)).click();
		}
		if(x==3)
		{
			//Click on Design
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesDesign)).click();
		}
		if(x==4)
		{
			//Click on Failure mode
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesFailureMode)).click();
		}
		if(x==5)
		{
			//Click on Fundamentals
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesFundamentals)).click();
		}
		if(x==6)
		{
			//Click on General
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesGeneral)).click();
		}	
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypesPopupClose)).click();
	}

	public void selectTypeAdvancedLearning(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeList));
		//Click on type
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesAdvancedLearning)).click();
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypesPopupClose)).click();
	}

	public void selectTypeGeneral(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeList));
		//Click on type
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesGeneral)).click();
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypesPopupClose)).click();
	}

	public void selectTypeFailureMode(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeList));
		//Click on type
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesFailureMode)).click();
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypesPopupClose)).click();
	}

	public void selectTypeCaseStudies(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeList));
		//Click on type
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesCaseStudies)).click();
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypesPopupClose)).click();
	}

	public void selectTypeDesign(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeList));
		//Click on type
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesDesign)).click();
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypesPopupClose)).click();
	}

	public void selectTypeFundamentals(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on type box
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeBox)).click();
		//Wait for popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypeList));
		//Click on type
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListTypesFundamentals)).click();
		//Close pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchTypesPopupClose)).click();
	}

	public void selectFieldDiscFilter (WebDriver driver, int x, int i, List<By> discList, List<By> fieldList, String keyword, List<String> electrical, List<String> general, List<String> ic, List<String> mechanical, List<String> software, List<String> structural) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int j=0;j<fieldList.size();j++)
		{
			//Clicks on clear
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
			//Select Type
			selectTypeAsPerX(driver,x);
			//Click on discipline box
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineBox)).click();
			//Wait for popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineList));
			//Click on 1st discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(discList.get(i))).click();
			//Close pop up
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplinePopupClose)).click();
			//Click on field box
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchFieldBox)).click();
			//Wait for popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchFieldList));
			//Click on field
			wait.until(ExpectedConditions.visibilityOfElementLocated(fieldList.get(j))).click();
			//Close pop up
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchFieldPopupClose)).click();
			//Search for keyword
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
			//Wait for loading message
			share2.loadingServer(driver);
			//Look for case with 2 filters
			verifyCasesWith2DisciplineFieldFilters(driver, i, j, electrical, general, ic, mechanical, software, structural);
		}
	}

	public void verifyCasesWith2DisciplineFieldFilters(WebDriver driver, int i, int j, List<String> electrical, List<String> general, List<String> ic, List<String> mechanical, List<String> software, List<String> structural) throws Exception{

		List<String> cases = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(driver,10);
		if(i==0)
		{
			cases.addAll(electrical);
		}
		if(i==1)
		{
			cases.addAll(general);
		}
		if(i==2)
		{
			cases.addAll(ic);
		}
		if(i==3)
		{
			cases.addAll(mechanical);
		}
		if(i==4)
		{
			cases.addAll(software);
		}
		if(i==5)
		{
			cases.addAll(structural);
		}
		//Look for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+cases.get(j))));
	}

	public void verifyCasesWithOnlyDisciplineFilter(WebDriver driver, int i, List<String> electrical, List<String> general, List<String> ic, List<String> mechanical, List<String> software, List<String> structural) throws Exception{

		List<String> cases = new ArrayList<String>();
		if(i==0)
		{
			cases.addAll(electrical);
		}
		if(i==1)
		{
			cases.addAll(general);
		}
		if(i==2)
		{
			cases.addAll(ic);
		}
		if(i==3)
		{
			cases.addAll(mechanical);
		}
		if(i==4)
		{
			cases.addAll(software);
		}
		if(i==5)
		{
			cases.addAll(structural);
		}
		equip.lookForCases(driver, cases);
	}

}
