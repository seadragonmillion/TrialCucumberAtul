import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kaleTestSoftware.*;
import kaleTestSoftware.EquipmentPDDandEF;
import kaleTestSoftware.ShareCheck;
import kaleTestSoftware.ShareCheck2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CaseBrowse {

	SoftAssertions softly = new SoftAssertions();
	CreateEquipmentCase3 equip3 = new CreateEquipmentCase3();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	CaseBrowsePageObj cb = new CaseBrowsePageObj();
	CreateHumanCasePageObj chc = new CreateHumanCasePageObj();
	CreateEquipPageObj equipObj = new CreateEquipPageObj();

	public String expected_copyright = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2021. Derivative Product Strictly Prohibited.";
	public String expected_copyright1 = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2021. Derivative Product Strictly Prohibited.";
	public String caseEquipALProd = "1545";
	public String caseEquipGProd = "1636";
	public String caseEquipCSDev = "1985";
	public String keywordEquipALDev = "QAA oil color";
	public String keywordEquipCSDev = "QAACaseStudiesEquipment";
	public String keywordEquipDevMK = "M/K";
	public String keywordEquipALProd = "bolted flange";
	public String keywordEquipGProd = "positive sequence";
	public String keywordEquipProdLD = "L/D";
	public String caseHumanColor = "Q1516";
	public String caseEquipColor = "F1516";
	public String caseHumanDev = "1459";
	public String caseEquipDev = "1974";
	public String caseElecDev = "1678";
	public String caseMechDev = "1988";
	public String caseSRIDev = "7543";
	public String caseHumanProd = "746";
	public String caseHumanProdPercent = "209";
	public String caseEquipProd = "231";
	public String caseEquipProdPercent = "1754";
	public String caseElecProd = "1260";
	public String caseMechProd = "1638";
	public String caseEquipProdLD = "274";
	public String keywordHumanDev = "test data";
	public String keywordHumanDevSpcl = "test.1/1";
	public String keywordHumanDevPercent = "Testpercentage%";
	public String keywordEquipSRIDev = "Test data sri";
	public String keywordEquipDev = "test data";
	public String keywordEquipDevSpcl = "test.1/1";
	public String keywordEquipDevPercent = "Testpercentage%";
	public String keywordElecDev = "sanity";
	public String keywordElecDevSpcl = "test.1/1";
	public String keywordElecDevPercent = "Testpercentel%";
	public String keywordMechDev = "Sanity test";
	public String keywordMechDevSpcl = "test.1/1";
	public String keywordMechDevPercent = "Testpercentme%";
	public String keywordHumanProd = "power plant worker";
	public String keywordHumanProdPercent = "100%";
	public String keywordEquipProd = "Static electrification failure mechanism";
	public String keywordEquipProdPercent = "20%";
	public String keywordElecProd = "pneumatic controller";
	public String keywordMechProd = "Failure modes of U-cup Seals";
	public String titleDev = "Sanity Test: DO NOT DELETE: QAA";
	public String titleHumanProd = "How is an Error-Free® work day achieved for power plant workers?";	
	public String titleEquipProd = "What are the controlling parameters affecting static electrification in a transformer?";
	public String titleElecProd = "What are the operating principles and failure modes of a pneumatic controller?";
	public String titleMechProd = "What are the benefits and failure modes of U-cup (U-ring) or an O-ring Loaded U-cup?";
	public String keywordHumanProdAllSpecial = "Testqaa!@#$%^&*,.?/+-=;:_";
	public String keywordHumanProdAllSpecial_ie11 = "Testie11qaa!@#$%^&*,.?/+-=;:_";
	public String keywordEquipProdAllSpecial = "Testqaa!@#$%^&*,.?/+-=;:";
	public String keywordEquipProdAllSpecial_ie11 = "Testie11qaa!@#$%^&*,.?/+-=;:_";
	public String keywordHumanDevAllSpecial = "Testqaa!@#$%^&*,.?/+-=;:_";
	public String keywordHumanDevAllSpecial_ie11 = "Testie11qaa!@#$%^&*,.?/+-=;:_";
	public String keywordEquipDevAllSpecial = "Testqaa!@#$%^&*,.?/+-=;:_";
	public String keywordEquipDevAllSpecial_ie11 = "Testie11qaa!@#$%^&*,.?/+-=;:_";
	public String[] s= {"@","!","#","$","%","&"," ","/","?",",",".","[abcd]", "(pqrs)"};

	public void caseSearchSRI(WebDriver driver, String identifier, String title, String keyword) throws Exception {

		getSRILink(driver);
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			//Search with keyword %
			searchWithPercentEquip(driver, keywordEquipDevPercent, identifier);
			//Search with keyword ./
			searchWithSpclEquip(driver, keywordEquipDevSpcl, identifier);
		}
		//Verify search options
		verifySearchOptionsEquip(driver, keyword, identifier);
		//Browse case with keyword
		browseTermEquip(driver, keyword, identifier, title);
		//Browse case with case id
		browseCaseIDEquip(driver, identifier, title);
	}

	public void getSRILink(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		try{
			//Clicks on ErrorFree Bank
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (org.openqa.selenium.TimeoutException | NoSuchElementException e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.ErrorFreeBankLinkHomePage)).click();
		}
		//Clicks on SRI
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.SRILink)).click();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordLabel)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("keyword:");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Systematic Reliability Inspection Search");
	}

	public void caseSearchWithLD(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		List<String> keywordID = new ArrayList<String>();
		if(driver.getCurrentUrl().contains("kaleasia")||driver.getCurrentUrl().contains("kale."))
		{
			keywordID.add(keywordEquipProdLD);
			keywordID.add(caseEquipProdLD);
		}
		else
		{
			keywordID.add(keywordEquipDevMK);
			keywordID.add(caseEquipDev);
		}
		String keyword = keywordID.get(0);
		String identifier = keywordID.get(1);
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks for search method with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(2000);
		clickDropdownEquip(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void caseSearchEquipmentDatabank(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		EquipmentPDDandEF obj = new EquipmentPDDandEF();
		String caseEquipColor1 = caseEquipColor.replace("F", "");
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		if(driver.getCurrentUrl().contains("kaleasia")||driver.getCurrentUrl().contains("kale."))
		{
			searchWithTypeFilter(driver, keywordEquipALProd, keywordEquipProd, keywordEquipGProd, obj.keywordPDDProd, obj.keywordEFProd, keywordElecProd, obj.caseEFProd, obj.casePDDProd, caseEquipALProd, caseEquipProd, caseEquipGProd, caseElecProd);
		}
		else
		{
			searchWithTypeFilter(driver, keywordEquipALDev, keywordEquipCSDev, keywordEquipDev, obj.keywordPDDDev, obj.keywordEFDev, keywordElecDev, obj.caseEFDev, obj.casePDDDev, caseEquipColor1, caseEquipCSDev, caseEquipDev, caseElecDev);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		caseSearchWithLD(driver);
	}

	public void searchWithTypeFilter(WebDriver driver, String keywordAL, String keywordCS, String keywordG, String keywordPDD, String keywordEF, String keywordFM, String caseEF, String casePDD, String caseAL, String caseCS, String caseG, String caseFM) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		CreateEquipmentCase2 obj = new CreateEquipmentCase2 ();
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Select Type Advanced Learning
		obj.selectTypeAdvancedLearning(driver);
		//Put in keyword and look for case
		lookForCaseWithTypeFilter(driver, keywordAL, caseAL);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Select Type Case Studies
		obj.selectTypeCaseStudies(driver);
		//Put in keyword and look for case
		lookForCaseWithTypeFilter(driver, keywordCS, caseCS);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Select Type General
		obj.selectTypeGeneral(driver);
		//Put in keyword and look for case
		lookForCaseWithTypeFilter(driver, keywordG, caseG);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Select Type Engineering Fundamentals
		obj.selectTypeFundamentals(driver);
		//Put in keyword and look for case
		lookForCaseWithTypeFilter(driver, keywordEF, caseEF);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Select Type Design
		obj.selectTypeDesign(driver);
		//Put in keyword and look for case
		lookForCaseWithTypeFilter(driver, keywordPDD, casePDD);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Select Type Failure modes
		obj.selectTypeFailureMode(driver);
		//Put in keyword and look for case
		lookForCaseWithTypeFilter(driver, keywordFM, caseFM);
	}

	public void lookForCaseWithTypeFilter(WebDriver driver, String keyword, String caseId) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Search for keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message
		share2.loadingServer(driver);
		//Look for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+caseId)));
	}

	public void getHumanPerformanceLink(WebDriver driver, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Clicks on ErrorFree Bank
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.ErrorFreeBankLinkHomePage)).getText();
		softly.assertThat(s).as("test data").contains("Bank");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.ErrorFreeBankLinkHomePage)).click();
		/*Verify order or modules
		 * admin = 0
		 * nonadmin = 1
		 */
		verifyOrderOfModules(driver, y);
		//Clicks on Human Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanPerformanceLink)).click();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordLabel)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("keyword:");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanPerformanceSearchTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Human Performance Search");
	}

	public void getEquipPerformanceLink(WebDriver driver, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.ErrorFreeBankLinkHomePage)).click();
		/*Verify order or modules
		 * admin = 0
		 * nonadmin = 1
		 */
		verifyOrderOfModules(driver, y);
		//Clicks on Equipment Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordLabel)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("keyword:");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Equipment Performance Search");
	}

	public void getEquipPerformancePIILink(WebDriver driver, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.ErrorFreeBankLinkHomePage)).click();
		/*Verify order or modules
		 * admin = 0
		 * nonadmin = 1
		 */
		verifyOrderOfModules(driver, y);
		//Clicks on Equipment Performance PII
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyLink)).click();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordLabel)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("keyword:");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Equipment Data Bank (Instructor Only) Search");
	}

	public void getElecFailureModeLink(WebDriver driver, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.ErrorFreeBankLinkHomePage)).click();
		/*Verify order or modules
		 * admin = 0
		 * nonadmin = 1
		 */
		verifyOrderOfModules(driver, y);
		//Clicks on Electrical Failure Mode
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordLabel)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("keyword:");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Failure Modes Search");
	}

	public void getMechFailureModeLink(WebDriver driver, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.ErrorFreeBankLinkHomePage)).click();
		/*Verify order or modules
		 * admin = 0
		 * nonadmin = 1
		 */
		verifyOrderOfModules(driver, y);
		//Clicks on Mechanical Failure Mode
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();    
	}

	public void chooseDisciplineFailureModeSearch(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on top Error-free bank link
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		//Click on Failure Modes
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		//Search for keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys("failure");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message
		share2.loadingServer(driver);
		//Get number of cases displayed when no discipline is selected
		int i = getNumberOfCasesIn1stCollapsibleListEquip(driver);
		System.out.println("Number of cases without any discipline chosen: "+(i));
		//Select random discipline in Failure mode search
		selectRandomDisciplineInSearchCase(driver);
		Thread.sleep(1000);
		//Click on search button
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message
		share2.loadingServer(driver);
		//Get number of cases displayed when no discipline is selected
		int j = getNumberOfCasesIn1stCollapsibleListEquip(driver);
		//Get text of Discipline box
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineBoxText)).getText();
		System.out.println("Number of cases with one random discipline ("+s+") chosen: "+(j));
		softly.assertThat(j).as("test data").isLessThanOrEqualTo(i);
	}

	public void selectRandomDisciplineInSearchCase(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineBox));
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineBox)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineBox)).click();
			}
		}
		else{
			//Discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineBox)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplineList));
		//Choose a number between 1 and 6 for number of Discipline
		Random random = new Random ();
		int y;
		//Choose a number between 1 and 6
		while(true)
		{
			y = random.nextInt(7);
			if(y==0)
				continue;
			break;
		}
		for(int i=1;i<y;i++)
		{
			int x;
			//Choose a number between 1 and 6
			while(true)
			{
				x = random.nextInt(7);
				if(x==0)
					continue;
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li["+x+"]/a"))).getAttribute("class");
				if(s.contains("ui-checkbox-on"))
					continue;
				break;
			}
			if(x==1)
			{
				if (browserName.contains("internet")==true)
				{
					equip3.clickTypesDisciplineIE(driver, cb.EquipCaseSearchListDisciplineElectrical);
				}
				else
					wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListDisciplineElectrical)).click();			
			}
			if(x==2)
			{
				if (browserName.contains("internet")==true)
				{
					equip3.clickTypesDisciplineIE(driver, cb.EquipCaseSearchListDisciplineGeneral);
				}
				else
					wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListDisciplineGeneral)).click();				
			}
			if(x==3)
			{
				if (browserName.contains("internet")==true)
				{
					equip3.clickTypesDisciplineIE(driver, cb.EquipCaseSearchListDisciplineIC);
				}
				else
					wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListDisciplineIC)).click();			
			}
			if(x==4)
			{
				if (browserName.contains("internet")==true)
				{
					equip3.clickTypesDisciplineIE(driver, cb.EquipCaseSearchListDisciplineMechanical);
				}
				else
					wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListDisciplineMechanical)).click();		
			}
			if(x==5)
			{
				if (browserName.contains("internet")==true)
				{
					equip3.clickTypesDisciplineIE(driver, cb.EquipCaseSearchListDisciplineSoftware);
				}
				else
					wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListDisciplineSoftware)).click();			
			}
			if(x==6)
			{
				if (browserName.contains("internet")==true)
				{
					equip3.clickTypesDisciplineIE(driver, cb.EquipCaseSearchListDisciplineStructural);
				}
				else
					wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipCaseSearchListDisciplineStructural)).click();		
			}
		}
		//Close Discipline pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.CaseSearchDisciplinePopupClose)).click();
	}

	public int getNumberOfCasesIn1stCollapsibleListEquip(WebDriver driver) throws Exception {

		//Get number of cases displayed when no discipline is selected
		int i=1;
		while(true)
		{
			try
			{
				//Look for case collapsibles
				driver.findElement(By.xpath(".//*[@id='pii-question-list-equip']/div[1]/div[1]/div["+i+"]"));				
				i=i+1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}
		return (i-1);
	}

	public void searchColorKeywordEquip(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on top Error-free bank link
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		//Click on Equipment Data Bank only
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyLink1)).click();
		//Enter keyword oil color
		searchColorCasesEquip(driver);
		//Click on top Error-free bank link
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		//Click on Equipment Data Bank only
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
		//Enter keyword oil color
		searchColorCasesEquip(driver);
	}

	public void searchColorKeywordHuman(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on top Error-free bank link
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		//Click on Human Performance only
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanPerformanceLink)).click();
		//Enter keyword oil color
		searchColorCasesHuman(driver);
	}

	public void searchColorCasesHuman(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Search for keyword oil
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys("oil color");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message
		share2.loadingServer(driver);
		int i=1;
		//Check for titles for 1st set of cases (Similar results)
		while(true)
		{
			try
			{
				//Get title
				String title = driver.findElement(By.xpath(".//*[@id='pii-question-list']/div[1]/div[1]/div["+i+"]/h4/a")).getText();
				softly.assertThat(title).as("test data").doesNotContain("color:blue");
				i=i+1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}
		//Get URL
		String url = driver.getCurrentUrl();
		if(url.contains("kaleqa"))
		{
			browseCaseForColorKeywordHuman(driver,caseHumanColor);
		}
		//Choose any one random case from the list of Similar Results cases
		Random random = new Random();
		int num;
		while(true)
		{
			num = random.nextInt(i);
			if(num == 0)
				continue;
			break;
		}
		if(url.contains("kaleasia")||url.contains("kale."))
		{
			//Get case id
			String caseID = driver.findElement(By.xpath(".//*[@id='pii-question-list']/div[1]/div[1]/div["+num+"]")).getAttribute("qid");
			browseCaseForColorKeywordHuman(driver,caseID);
		}
		//Close 1st collapsible and open 2nd collapsible for cases
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearch1stCollapsibleCases)));
		//open 2nd collapsible
		try{
			jse.executeScript("arguments[0].click();", 	wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearch2ndCollapsibleCases)));
		}catch(NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{

		}
		int j=1;
		//Check for titles for 2nd set of cases (Other results)
		while(true)
		{
			try
			{
				//Get title
				String title = driver.findElement(By.xpath(".//*[@id='pii-question-list']/div[2]/div[1]/div["+j+"]/h4/a")).getText();
				softly.assertThat(title).as("test data").doesNotContain("color:blue");
				j=j+1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}

	}

	public void browseCaseForColorKeywordHuman(WebDriver driver, String caseID) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Scroll to case
		WebElement l = driver.findElement(By.id("pii-collapsible-"+caseID));
		share2.scrollToElement(driver, l);
		jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id='pii-question-list']/div[2]/h4/a/div"))));
		//Click on case collapsible
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(By.id("pii-collapsible-"+caseID))).click().build().perform();
		} catch (Exception e) {
			try {
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-"+caseID))));
			} catch (Exception e1) {
				System.out.println("collapsible not click");
			}
		}
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Check in description of case inside collapsible if it has color:blue
		String desc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-collapsible-"+caseID+"']/div/p[1]"))).getText();
		softly.assertThat(desc1).as("test data").doesNotContain("color:blue");
		String desc2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-collapsible-"+caseID+"']/div/p[2]"))).getText();
		softly.assertThat(desc2).as("test data").doesNotContain("color:blue");
		//Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-"+caseID)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-"+caseID));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}
		//Click on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-"+caseID))).sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-"+caseID))).sendKeys(Keys.ENTER);
		//Get title of case and verify if it has color:white
		String titleCase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-"+caseID+"']/ul/li[1]/div"))).getAttribute("textContent");
		softly.assertThat(titleCase).as("test data").doesNotContain("color:white");
		//Close case
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-"+caseID+"']/a"))));
	}

	public void searchColorCasesEquip(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Search for keyword oil
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys("oil color");
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message
		share2.loadingServer(driver);
		int i=1;
		//Check for titles for 1st set of cases (Similar results)
		while(true)
		{
			try
			{
				//Get title
				String title = driver.findElement(By.xpath(".//*[@id='pii-question-list-equip']/div[1]/div[1]/div["+i+"]/h4/a")).getText();
				softly.assertThat(title).as("test data").doesNotContain("color:blue");
				i=i+1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}
		//Get URL
		String url = driver.getCurrentUrl();
		if(url.contains("kaleqa"))
		{
			browseCaseForColorKeywordEquip(driver,caseEquipColor);
		}
		//Choose any one random case from the list of Similar Results cases
		Random random = new Random();
		int num;
		while(true)
		{
			num = random.nextInt(i);
			if(num == 0)
				continue;
			break;
		}
		if(url.contains("kaleasia")||url.contains("kale."))
		{
			//Get case id
			String caseID = driver.findElement(By.xpath(".//*[@id='pii-question-list-equip']/div[1]/div[1]/div["+num+"]")).getAttribute("qid");
			browseCaseForColorKeywordEquip(driver,caseID);
		}
		//Close 1st collapsible and open 2nd collapsible for cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipSearch1stCollapsibleCases)).click();
		//open 2nd collapsible
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipSearch2ndCollapsibleCases)).click();
		}catch(NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{

		}
		int j=1;
		//Check for titles for 2nd set of cases (Other results)
		while(true)
		{
			try
			{
				//Get title
				String title = driver.findElement(By.xpath(".//*[@id='pii-question-list-equip']/div[2]/div[1]/div["+j+"]/h4/a")).getText();
				softly.assertThat(title).as("test data").doesNotContain("color:blue");
				j=j+1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}

	}

	public void browseCaseForColorKeywordEquip(WebDriver driver, String caseID) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Scroll to case
		WebElement l = driver.findElement(By.id("pii-collapsible-equip-"+caseID));
		share2.scrollToElement(driver, l);
		//Click on case collapsible
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(By.id("pii-collapsible-equip-"+caseID))).click().build().perform();
			}catch(org.openqa.selenium.ElementNotInteractableException u){
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-"+caseID))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-"+caseID))));
			}catch(Exception e) {
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-"+caseID))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-"+caseID))).click();;
			}
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Check in description of case inside collapsible if it has color:blue
		String desc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-collapsible-equip-"+caseID+"']/div/p[1]"))).getText();
		softly.assertThat(desc1).as("test data").doesNotContain("color:blue");
		String desc2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-collapsible-equip-"+caseID+"']/div/p[2]"))).getText();
		softly.assertThat(desc2).as("test data").doesNotContain("color:blue");
		//Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-"+caseID)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-"+caseID));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}
		//Click on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-"+caseID))).sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-"+caseID))).sendKeys(Keys.ENTER);
		//Get title of case and verify if it has color:white
		String titleCase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-"+caseID+"']/ul/li[1]/div"))).getAttribute("textContent");
		softly.assertThat(titleCase).as("test data").doesNotContain("color:white");
		//Close case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-"+caseID+"']/a"))).click();
	}

	public void verifyOrderOfModules(WebDriver driver, int y) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify order
		//Human Performance
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanPerformancePosition)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Human Performance");
		//Engineering Fundamentals
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EngineeringFundamentalPosition)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Engineering Fundamentals");
		//Equipment Performance
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformancePosition)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Equipment Performance");
		//Failure Modes
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModesPosition)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Failure Modes");
		//Prevention of Design Deficiencies
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.PreventionOfDesignDeficienciesPosition)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Prevention of Design Deficiencies");
		//SRI
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SystematicReliabilityInspectionDevEquipmentDatabankOnlyPositionProd)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Systematic Reliability Inspection");		
		if(y==0)
		{
			//Equipment Data Bank (Instructor Only)
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyPositionDev)).getText();
			softly.assertThat(s5).as("test data").isEqualTo("Equipment Data Bank (Instructor Only)");			
		}
		if(y==1)
			verifyNoEquipPII(driver);
		//Verify B capital in Error free Bank
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.ErrorFreeBankTitle)).getText();
		softly.assertThat(s5).as("test data").contains("Bank");	
	}

	public void verifyNoEquipPII(WebDriver driver) throws Exception {

		//Checks for equipment search pii
		if(driver.findElement(cb.EquipmentDatabankOnlyLink1).isDisplayed()==false)
		{
			System.out.println("Non admin user cannot see Equipment Search PII");
		}
		else softly.fail("Equipment PII is present in non admin");
	}

	public void addKeywordWithAllSpecialCharactersEquip(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		String url = driver.getCurrentUrl();
		//Clear keyword field
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentAddKeywordField)).clear();
		//Assigns keyword as per browser and url
		if(url.contains("kaleqa"))
		{
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentAddKeywordField)).sendKeys(keywordEquipDevAllSpecial_ie11);
			}
			else
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentAddKeywordField)).sendKeys(keywordEquipDevAllSpecial);
			}
		}
		else
		{
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentAddKeywordField)).sendKeys(keywordEquipProdAllSpecial_ie11);
			}
			else
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentAddKeywordField)).sendKeys(keywordEquipProdAllSpecial);
			}
		}
		Thread.sleep(2000);
		jse.executeScript("scroll(0,2000)");	
		Thread.sleep(2000);
		//Click on add keyword
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentAddKeywordButton)));	
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentAddKeywordField));
		for (int i=0; i<s.length;i++)
		{
			//clear keyword field
			ele.clear();
			Thread.sleep(1000);
			//search for foo<special character>foo
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
				ele.sendKeys("qaafooie"+s[i]+"qaafooie");
			else
				ele.sendKeys("qaafoo"+s[i]+"qaafoo");
			Thread.sleep(1500);
			jse.executeScript("scroll(0,2000)");	
			Thread.sleep(2000);
			//Click on add keyword
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentAddKeywordButton)));	
		}
		Thread.sleep(2000);
		try{
			jse.executeScript("scroll(0,2000)");	
		}catch (org.openqa.selenium.ScriptTimeoutException e)
		{
			Thread.sleep(2000);
			jse.executeScript("scroll(0,2000)");	
		}
		Thread.sleep(2000);
	}

	public void addKeywordWithAllSpecialCharactersHuman(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		String url = driver.getCurrentUrl();
		//Clear keyword field
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanAddKeywordField)).clear();
		Thread.sleep(1000);
		//Assigns keyword as per browser and url
		if(url.contains("kaleqa"))
		{
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanAddKeywordField)).sendKeys(keywordHumanDevAllSpecial_ie11);
			}
			else
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanAddKeywordField)).sendKeys(keywordHumanDevAllSpecial);
			}
		}
		else
		{
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanAddKeywordField)).sendKeys(keywordHumanProdAllSpecial_ie11);
			}
			else
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanAddKeywordField)).sendKeys(keywordHumanProdAllSpecial);
			}
		}
		Thread.sleep(2000);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanAddKeywordField));
		//Click on add keyword
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanAddKeywordButton)));	
		for (int i=0; i<s.length;i++)
		{
			//clear keyword field
			ele.clear();
			Thread.sleep(1000);
			//search for foo<special character>foo
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
				ele.sendKeys("qaafooie"+s[i]+"qaafooie");
			else
				ele.sendKeys("qaafoo"+s[i]+"qaafoo");
			Thread.sleep(1500);
			//Click on add keyword
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanAddKeywordButton)));	
		}
		jse.executeScript("scroll(0,2000)");	
		Thread.sleep(2000);
	}

	public void searchWithKeyKeywordWithAllSpecialCharacters(WebDriver driver,String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement ele=null;
		//Search for either Human or Equipment search element for Term field
		try{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField));
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField));
		}
		//clear term field
		ele.clear();
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		String url = driver.getCurrentUrl();
		//Assigns keyword as per browser and url
		if(url.contains("kaleqa"))
		{
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
			{
				ele.sendKeys(keywordHumanDevAllSpecial_ie11);
			}
			else
			{
				ele.sendKeys(keywordHumanDevAllSpecial);
			}
		}
		else
		{
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
			{
				ele.sendKeys(keywordHumanProdAllSpecial_ie11);
			}
			else
			{
				ele.sendKeys(keywordHumanProdAllSpecial);
			}
		}
		Thread.sleep(2000);
		//Press ENTER
		ele.sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Look for case
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		}		
		//Clear
		try{
			driver.findElement(cb.EquipmentSearchClearButton).click();
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException e)
		{
			driver.findElement(cb.HumanSearchClearButton).click();
		}
	}


	public void searchWithKeywordKALE1964(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		WebElement ele=null;
		//Search for either Human or Equipment search element for Term field
		try{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField));
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField));
		}
		//Array of special characters
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		for (int i=0; i<s.length;i++)
		{
			//clear term field
			ele.clear();
			//search for foo<special character>foo
			if ((browserName.equals("internet explorer"))&&(v.startsWith("11")))
				ele.sendKeys("qaafooie"+s[i]+"qaafooie");
			else
				ele.sendKeys("qaafoo"+s[i]+"qaafoo");
			WebElement dropdown;
			//Look for dynamic dropdown
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchDropDown));
			}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
			{
				try{
					wait1.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchDropDown));
				}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e1)
				{
					System.out.println("Dropdown not visible as no case exists with keyword: " +"qaafoo"+s[i]+"qaafoo");
				}				
			}
			//Press Enter
			ele.sendKeys(Keys.ENTER);
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Verify dropdown has disappeared
			try{
				dropdown = driver.findElement(cb.EquipmentSearchDropDown);
			}catch (NoSuchElementException u)
			{
				dropdown = driver.findElement(cb.HumanSearchDropDown);
			}
			if(dropdown.isDisplayed()==true)
			{
				softly.fail("Dropdown visible and the webelement is: "+dropdown.getAttribute("id"));
			}
			//Clear
			try{
				driver.findElement(cb.EquipmentSearchClearButton).click();
			}catch (NoSuchElementException | org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException e)
			{
				driver.findElement(cb.HumanSearchClearButton).click();
			}
		}	
	}	

	public void searchWithPercentEquip(WebDriver driver, String keypercent, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keypercent);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void searchWithSpclEquip(WebDriver driver, String keyspcl, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyspcl);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void verifySearchOptionsEquip (WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		//Clears Everything
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks if clear feature works on term field
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(1000);
		Actions act1 = new Actions(driver);
		WebElement act= wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordFieldClearButton));
		act1.click(act).build().perform();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Look for dynamic dropdown
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchDropDown));
			softly.fail("Dynamic dropdown visible after click on search button for keyword search");
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			System.out.println("Dropdown not visible");				
		}
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		share2.loadingServer(driver);
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Look for dynamic dropdown
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchDropDown));
			softly.fail("Dynamic dropdown visible after click on search button for keyword search");
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			System.out.println("Dropdown not visible");				
		}
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks for search method with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(2000);
		clickDropdownEquip(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void clickDropdownEquip(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement match=wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDropDownList));
		String text = match.getText();
		System.out.println(text);
		if(text.equals("Exact Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDropDownListTitle)).click();				  
		}
		else if(text.equals("Similar Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDropDownListTitle)).click();
		}
		else if(text.equals("Other Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDropDownListTitle)).click();
		}
		//Wait for loading message to disappear
		share2.loadingServer(driver);	
	}

	public void browseTermEquip (WebDriver driver, String keyword, String identifier, String title) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchLogo)).getAttribute("src");
		System.out.println(s);
		softly.assertThat(s).as("test").contains("images/ErrorFree.gif");
		int n = searchKeywordForBrowseCaseEquip(driver,keyword,identifier);
		Thread.sleep(1000);
		String expected_title = "F"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseEquipAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseEquip(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void browseCaseIDEquip (WebDriver driver, String identifier, String title) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Checks if clear feature works on case id field
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(identifier);
		Thread.sleep(1000);
		WebElement ele= driver.findElement(cb.EquipmentSearchCaseIDFieldClearButton);
		Actions act = new Actions (driver);
		act.click(ele).build().perform();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIDFieldSearchButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on case
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(By.id("pii-collapsible-equip-F"+identifier))).click().build().perform();
			}catch(org.openqa.selenium.ElementNotInteractableException u){
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))));
			}catch(Exception e) {
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))).click();
			}
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+identifier));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-equip-F"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		Thread.sleep(1000);
		String expected_title = "F"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseEquipAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseEquip(driver,n,expected_title,identifier);
		//Closes the slideshow
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void browseTermHuman (WebDriver driver, String keyword, String identifier, String title) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchLogo)).getAttribute("src");
		System.out.println(s);
		softly.assertThat(s).as("test").contains("images/ErrorFree.gif");
		int n = searchKeywordForBrowseCaseHuman(driver,keyword,identifier);
		Thread.sleep(1000);
		String expected_title = "Q"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseHumanAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseHuman(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
	}

	public void browseCaseNonAdminHuman(WebDriver driver, String keyword, String identifier, String title) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(1000);
		int n = searchKeywordForBrowseCaseHuman(driver,keyword,identifier);
		String expected_title = "Q"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseHumanNonAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseHuman(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
		//verify no case id box
		verifyNoCaseIDSearchHuman (driver);
	}

	public void browseCaseIDHuman (WebDriver driver, String identifier, String title) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Checks if clear feature works on case id field
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchCaseIdField)).sendKeys(identifier);
		Thread.sleep(1000);
		WebElement ele= driver.findElement(cb.HumanSearchCaseIDFieldClearButton);
		Actions act = new Actions (driver);
		act.click(ele).build().perform();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchCaseIDFieldSearchButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
		Thread.sleep(2000);
		//Enters case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on case
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(By.id("pii-collapsible-Q"+identifier))).click().build().perform();
			}catch(org.openqa.selenium.ElementNotInteractableException u){
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier))));
			}catch(Exception e) {
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier))).click();
			}
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-Q"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-Q"+identifier));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-Q"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		Thread.sleep(1000);
		String expected_title = "Q"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseHumanAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseHuman(driver,n,expected_title,identifier);
		//Closes the slideshow
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-Q"+identifier+"']/a"))));
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
	}

	public void verifyNoCaseIDSearchEquip (WebDriver driver) throws Exception {

		//Searches for case id box
		try{
			WebElement caseSearch= driver.findElement(cb.EquipmentSearchCaseIdField);
			if (caseSearch.isDisplayed()==true)
				softly.fail("Case id search displayed");
			if(caseSearch.isDisplayed()==false)
				System.out.println("Case id search box not displayed");

		}catch(NoSuchElementException e)
		{
			System.out.println("Case id search box not present.");
		}
	}

	public void verifyNoCaseIDSearchHuman (WebDriver driver) throws Exception {

		//Searches for case id box
		try{
			WebElement caseSearch= driver.findElement(cb.HumanSearchCaseIdField);
			if (caseSearch.isDisplayed()==true)
				softly.fail("Case id search displayed");
			if(caseSearch.isDisplayed()==false)
				System.out.println("Case id search box not displayed");

		}catch(NoSuchElementException e)
		{
			System.out.println("Case id search box not present.");
		}
	}

	public int searchKeywordForBrowseCaseHuman(WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Types in the keyword to get slide
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).clear();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on collapsible 
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(By.id("pii-collapsible-Q"+identifier))).click().build().perform();
			}catch(org.openqa.selenium.ElementNotInteractableException u){
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier))));
			}catch(Exception e) {
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier))).click();;
			}
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-Q"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-Q"+identifier));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
			break;
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-Q"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		return n;
	}

	public int searchKeywordForBrowseCaseEquip(WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Types in the keyword to get slide
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		//Get name of current module
		String str = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentModuleTitle)).getText();
		if(str.contains("Equipment Data Bank (Instructor Only) Search"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		}
		else{
			//Look for case by clicking on dropdown
			Thread.sleep(4000);
			WebElement match = null;
			try{
				match=driver.findElement(cb.EquipmentDropDownList);
			}catch(NoSuchElementException r)
			{
				//Wait for a few seconds and then try again
				Thread.sleep(3000);
				//Types in the keyword to get slide
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
				Thread.sleep(4000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
				Thread.sleep(3000);
				match=driver.findElement(cb.EquipmentDropDownList);
			}
			String text = match.getText();
			System.out.println(text);
			if(text.equals("Exact Match Keywords"))
			{
				driver.findElement(cb.EquipmentDropDownListTitle).click();				  
			}
			else if(text.equals("Similar Match Keywords"))
			{
				driver.findElement(cb.EquipmentDropDownListTitle).click();
			}
			else if(text.equals("Other Match Keywords"))
			{
				driver.findElement(cb.EquipmentDropDownListTitle).click();
			}
		}
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on collapsible 
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(By.id("pii-collapsible-equip-F"+identifier))).click().build().perform();
			}catch(org.openqa.selenium.ElementNotInteractableException u){
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))));
			}catch(Exception e) {
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))).click();
			}
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+identifier));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.contains("Show Slides(")==false)
		{
			Thread.sleep(1000);
			System.out.println(slide);
			slide = element.getText();
		}		
		System.out.println(slide);
		System.out.println(slide.indexOf("(") + "  "+ slide.indexOf(")"));
		String number= slide.substring(slide.indexOf("(")+1, slide.indexOf(")"));
		element.sendKeys(Keys.TAB);
		element.sendKeys(Keys.ENTER);
		driver.findElement(By.id("pii-slideshow-equip-F"+identifier+"-popup"));
		System.out.println(number);
		int n = Integer.parseInt(number);
		return n;
	}

	public void browseCaseNonAdminEquip(WebDriver driver, String keyword, String identifier, String title) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(1000);
		int n = searchKeywordForBrowseCaseEquip(driver,keyword,identifier);
		String expected_title = "F"+identifier+": "+title;
		//Click next button to browse through case
		nextBrowseEquipNonAdmin(driver,n,expected_title,identifier);
		//Click previous button to browse through case
		previousBrowseEquip(driver,n,expected_title,identifier);
		//Closes the slideshow
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))).click();
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//verify no case id box
		verifyNoCaseIDSearchEquip (driver);
	}

	public void nextBrowseEquipNonAdmin(WebDriver driver, int n, String expected_title, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlideNextButton)).click();
		for(int i=2;i<=n;i++)
		{
			System.out.println("Slide "+(i-1));
			String id = "pii-slideimg-F"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			if(driver.getCurrentUrl().contains("kaleqa"))
				softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			else
				softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright1);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			//Moves out of the slideshow and checks for security
			Thread.sleep(1000);
			if(browserName.contains("safari"))
			{
				while(true)
				{
					Actions act2 = new Actions(driver);
					act2.click(driver.findElement(By.xpath(title_xpath))).build().perform();
					Thread.sleep(1000);
					if(driver.findElement(By.id("pii-slideshow-equip-show-F"+identifier)).isDisplayed())
						break;
				}
			}
			else
			{
				//Clicks on copyright
				if(i==2)
					driver.findElement(By.xpath(copyright_xpath)).click();
				//Clicks on logo
				if(i==3)
					driver.findElement(By.xpath(image_xpath)).click();
				//Clicks outside
				/*	if(browserName.contains("chrome")==false)
				{
					if(i==4)
					{
						Actions act2 = new Actions(driver);
						Point coordinates = driver.findElement(cb.SlideNextButton).getLocation();
						Robot robot = new Robot();
						robot.mouseMove(coordinates.getX()+100,coordinates.getY());
						Thread.sleep(2000);
						act2.click().build().perform();
					}
				}*/
				//Clicks on title
				else 
					driver.findElement(By.xpath(title_xpath)).click();
			}
			Thread.sleep(3000);
			//Show slides
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-equip-show-F"+identifier))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlideNextButton)).click();
		}
	}

	public void nextBrowseHumanNonAdmin(WebDriver driver, int n, String expected_title, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);		
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlideNextButton)).click();
		for(int i=2;i<=n;i++)
		{
			System.out.println("Slide "+(i-1));
			String id = "pii-slideimg-Q"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			if(driver.getCurrentUrl().contains("kaleqa"))
				softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			else
				softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright1);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			//Moves out of the slideshow and checks for security
			Thread.sleep(1000);
			if(browserName.contains("safari"))
			{
				while(true)
				{
					Actions act2 = new Actions(driver);
					act2.click(driver.findElement(By.xpath(title_xpath))).build().perform();
					Thread.sleep(1000);
					if(driver.findElement(By.id("pii-slideshow-show-Q"+identifier)).isDisplayed())
						break;
				}
			}
			else
			{
				//Clicks on copyright
				if(i==2)
					driver.findElement(By.xpath(copyright_xpath)).click();
				//Clicks on logo
				if(i==3)
					driver.findElement(By.xpath(image_xpath)).click();
				//Clicks outside
				if(browserName.contains("safari"))
				{
					if(i==4)
					{						
						Actions act2 = new Actions(driver);
						Point coordinates = driver.findElement(cb.SlideNextButton).getLocation();
						Robot robot = new Robot();
						robot.mouseMove(coordinates.getX()+100,coordinates.getY());
						Thread.sleep(2000);
						act2.click().build().perform();
					}
				}
				//Clicks on title
				else 
					driver.findElement(By.xpath(title_xpath)).click();
			}
			Thread.sleep(3000);
			//Show slides
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-show-Q"+identifier))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlideNextButton)).click();
		}
	}

	public void nextBrowseHumanAdmin(WebDriver driver, int n, String expected_title, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlideNextButton)).click();
		for(int i=2;i<=n;i++)
		{
			System.out.println("Slide "+(i-1));
			String id = "pii-slideimg-Q"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			if(driver.getCurrentUrl().contains("kaleqa"))
				softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			else
				softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright1);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlideNextButton)).click();
		}
	}

	public void previousBrowseHuman(WebDriver driver, int n, String expected_title, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
		//Checks if there are slides present
		for (int i=n;i>=2;i--)
		{
			System.out.println("Slide "+(i));
			String id = "pii-slideimg-Q"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			if(driver.getCurrentUrl().contains("kaleqa"))
				softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			else
				softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright1);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-Q"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			//Click on previous
			driver.findElement(cb.SlidePreviousButton).click();
		}
	}

	public void nextBrowseEquipAdmin(WebDriver driver, int n, String expected_title, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click Next
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlideNextButton)));
		for(int i=2;i<=n;i++)
		{
			System.out.println("Slide "+(i-1));
			String id = "pii-slideimg-F"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			if(driver.getCurrentUrl().contains("kaleqa"))
				softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			else
				softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright1);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			//Verify file name of image in new cases after 4.6.1 version in KALE
			if(expected_title.contains(equip3.titleCombo)||expected_title.contains(equip3.titleComboie11)||expected_title.contains(equip3.titleComboUSie11)||expected_title.contains(equip3.titleComboUS)||expected_title.contains(equip3.ee_title)||expected_title.contains(equip3.ee_titleie11)||expected_title.contains(equip3.ee_titleUS)||expected_title.contains(equip3.ee_titleie11US)||expected_title.contains(equip3.eq_title)||expected_title.contains(equip3.eq_titleie11)||expected_title.contains(equip3.eq_titleUS)||expected_title.contains(equip3.eq_titleie11US)||expected_title.contains(equip3.me_title)||expected_title.contains(equip3.me_titleie11)||expected_title.contains(equip3.me_titleUS)||expected_title.contains(equip3.me_titleie11US))
			{
				//Get property piifiles from img
				String filename = driver.findElement(By.xpath(image_xpath)).getAttribute("piifile");
				softly.assertThat(filename).as("test data").isEqualTo("Slide"+(i-1)+".PNG");
			}
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlideNextButton)));
		}
	}

	public void previousBrowseEquip(WebDriver driver, int n, String expected_title, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Click on previous
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlidePreviousButton)).click();
		//Checks if there are slides present
		for (int i=n;i>=2;i--)
		{
			System.out.println("Slide "+(i));
			String id = "pii-slideimg-F"+identifier+"-"+(i-1);
			Thread.sleep(2000);
			driver.findElement(By.id(id));
			Thread.sleep(1500);
			//Checking if title is correct
			String title_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/div";
			String actual_title = driver.findElement(By.xpath(title_xpath)).getAttribute("textContent");
			softly.assertThat(actual_title).as("test data").isEqualTo(expected_title);
			//Checking if copyright is correct
			String copyright_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span";
			String actual_copyright = driver.findElement(By.xpath(copyright_xpath)).getAttribute("textContent");
			if(driver.getCurrentUrl().contains("kaleqa"))
				softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright);
			else
				softly.assertThat(actual_copyright).as("test data").isEqualTo(expected_copyright1);
			//Checking if footer image appears
			String image_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/img";
			if(driver.findElement(By.xpath(image_xpath)).isDisplayed())
				System.out.println("Logo is displayed");
			//Checking if slide number appears and is correct
			String slide_xpath = ".//*[@id='pii-slideshow-equip-F"+identifier+"']/ul/li["+i+"]/span/span[2]";
			String actual_slide = driver.findElement(By.xpath(slide_xpath)).getAttribute("textContent");
			String expected_slide = i+"/"+n;
			softly.assertThat(actual_slide).as("test data").isEqualTo(expected_slide);
			//Verify file name of image in new cases after 4.6.1 version in KALE
			if(expected_title.contains(equip3.titleCombo)||expected_title.contains(equip3.titleComboie11)||expected_title.contains(equip3.titleComboUSie11)||expected_title.contains(equip3.titleComboUS)||expected_title.contains(equip3.ee_title)||expected_title.contains(equip3.ee_titleie11)||expected_title.contains(equip3.ee_titleUS)||expected_title.contains(equip3.ee_titleie11US)||expected_title.contains(equip3.eq_title)||expected_title.contains(equip3.eq_titleie11)||expected_title.contains(equip3.eq_titleUS)||expected_title.contains(equip3.eq_titleie11US)||expected_title.contains(equip3.me_title)||expected_title.contains(equip3.me_titleie11)||expected_title.contains(equip3.me_titleUS)||expected_title.contains(equip3.me_titleie11US))
			{
				//Get property piifiles from img
				String filename = driver.findElement(By.xpath(image_xpath)).getAttribute("piifile");
				softly.assertThat(filename).as("test data").isEqualTo("Slide"+(i-1)+".PNG");
			}
			//Click on previous
			driver.findElement(cb.SlidePreviousButton).click();
		}
	}

	public void searchWithPercentHuman(WebDriver driver, String keypercent, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(keypercent);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
	}

	public void searchWithSpclHuman(WebDriver driver, String keyspcl, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(keyspcl);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
	}

	public void verifySearchOptionsHuman (WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		//Clears Everything
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks if clear feature works on term field
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(1000);
		Actions act1 = new Actions(driver);
		WebElement act= wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordFieldClearButton));
		act1.click(act).build().perform();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
		Thread.sleep(2000);
		//Look for dynamic dropdown
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchDropDown));
			softly.fail("Dynamic dropdown visible after click on search button for keyword search");
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			System.out.println("Dropdown not visible");				
		}
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Look for dynamic dropdown
		try{
			wait1.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchDropDown));
			softly.fail("Dynamic dropdown visible after click on search button for keyword search");
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException e)
		{
			System.out.println("Dropdown not visible");				
		}
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks for search method with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(2000);
		clickDropdownHuman(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-Q"+identifier)));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanSearchClearButton)).click();
	}

	public void clickDropdownHuman(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement match=wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanDropDownList));
		String text = match.getText();
		System.out.println(text);
		if(text.equals("Exact Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanDropDownListTitle)).click();				  
		}
		else if(text.equals("Similar Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanDropDownListTitle)).click();
		}
		else if(text.equals("Other Match Keywords"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanDropDownListTitle)).click();
		}
		//Wait for loading message to disappear
		share2.loadingServer(driver);		
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
