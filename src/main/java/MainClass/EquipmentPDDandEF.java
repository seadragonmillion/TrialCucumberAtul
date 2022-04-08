package MainClass;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import PageObjects.CaseBrowsePageObj;
import PageObjects.CreateEquipPageObj;
import PageObjects.CreateHumanCasePageObj;
import PageObjects.LoginPageObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EquipmentPDDandEF {

	SoftAssertions softly = new SoftAssertions();	
	LoginPageObj lpo = new LoginPageObj();
	CreateEquipPageObj equipObj = new CreateEquipPageObj();
	CreateEquipmentCase3 equip3 = new CreateEquipmentCase3();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	CaseBrowsePageObj cb = new CaseBrowsePageObj();
	CreateHumanCasePageObj chc = new CreateHumanCasePageObj();

	public String keywordPDD = "QAAPDDTestSlides";
	public String keywordEF = "QAAEFTestSlides";
	public String key1PDD = "QAAzebraPDD";
	public String key2PDD = "QAAcamelPDD";
	public String key3PDD = "QAAhorsePDD";
	public String key1EF = "QAAzebraEF";
	public String key2EF = "QAAcamelEF";
	public String key3EF = "QAAhorseEF";
	public String titlePDD = "QAA PDD Test Slides";
	public String titleEF = "QAA EF Test Slides";
	public String keywordPDDie11 = "QAAPDDTestSlidesie11";
	public String keywordEFie11 = "QAAEFTestSlidesie11";
	public String key1PDDie11 = "QAAzebraPDDie11";
	public String key2PDDie11 = "QAAcamelPDDie11";
	public String key3PDDie11 = "QAAhorsePDDie11";
	public String key1EFie11 = "QAAzebraEFie11";
	public String key2EFie11 = "QAAcamelEFie11";
	public String key3EFie11 = "QAAhorseEFie11";
	public String titlePDDie11 = "QAA IE11 PDD Test Slides";
	public String titleEFie11 = "QAA IE11 EF Test Slides";
	public String keywordPDDUS = "QAAUSPDDTestSlides";
	public String keywordEFUS = "QAAUSEFTestSlides";
	public String key1PDDUS = "QAAUSzebraPDD";
	public String key2PDDUS = "QAAUScamelPDD";
	public String key3PDDUS = "QAAUShorsePDD";
	public String key1EFUS = "QAAUSzebraEF";
	public String key2EFUS = "QAAUScamelEF";
	public String key3EFUS = "QAAUShorseEF";
	public String titlePDDUS = "QAA US PDD Test Slides";
	public String titleEFUS = "QAA US EF Test Slides";
	public String keywordPDDUSie11 = "QAAUSPDDTestSlidesie11";
	public String keywordEFUSie11 = "QAAUSEFTestSlidesie11";
	public String key1PDDUSie11 = "QAAUSzebraPDDie11";
	public String key2PDDUSie11 = "QAAUScamelPDDie11";
	public String key3PDDUSie11 = "QAAUShorsePDDie11";
	public String key1EFUSie11 = "QAAUSzebraEFie11";
	public String key2EFUSie11 = "QAAUScamelEFie11";
	public String key3EFUSie11 = "QAAUShorseEFie11";
	public String titlePDDUSie11 = "QAA US IE11 PDD Test Slides";
	public String titleEFUSie11 = "QAA US IE11 EF Test Slides";
	public String expected_copyright = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2021. Derivative Product Strictly Prohibited.";
	public String expected_copyright1 = "Copyright and Proprietary, Error-Free Inc. and Performance Improvement International LLC, 2021. Derivative Product Strictly Prohibited.";
	public String keywordPDDDev ="SanityPDD";
	public String keywordPDDDevPercent ="SanityPDD%";
	public String keywordPDDDevSpcl ="SanityPDD./";
	public String keywordEFDev ="SanityEF";
	public String keywordEFDevPercent ="SanityEF%";
	public String keywordEFDevSpcl ="SanityEF./";
	public String keywordPDDProd = "packing friction force";
	public String keywordPDDProdPercent = "10%";
	public String keywordEFProd = "Anatomy of Equipment Failures";
	public String keywordEFProdSpcl = "PM2.5 meter";
	public String caseEFDev = "7450";
	public String casePDDDev = "7890";
	public String caseEFProd = "2003";
	public String casePDDProd = "3005";
	public String caseEFProdSpcl = "2017";
	public String casePDDProdPercent = "4034";
	public String titleEFDev = "Sanity: QAA Test (DO NOT DELETE)";
	public String titlePDDDev = "Sanity: QAA Test (DO NOT DELETE)";
	public String titleEFProd = "What are the core capabilities to ensure equipment failure-free operation?"+"\n";
	public String titlePDDProd = "How do you reduce valve packing friction force?";

	public void searchCaseInFailureModes(WebDriver driver, String identifierEF, String identifierPDD, String keywordEF, String keywordPDD) throws Exception {

		//Verify PDD case
		searchCaseIdInFailureModes(driver, identifierPDD);
		searchCaseInFMWithKeyword(driver, keywordPDD, identifierPDD);
		//Verify EF case
		searchCaseIdInFailureModes(driver, identifierEF);
		searchCaseInFMWithKeyword(driver, keywordEF, identifierEF);
	}

	public void searchCasesInPDDAndEFModules(WebDriver driver, String identifierEF, String identifierPDD, String keywordEF, String keywordPDD)throws Exception {

		//Verify that PDD does not appear in EF
		searchCaseInEngineeringFundamentalsWithKeyword(driver, keywordPDD, identifierPDD);
		searchCaseIdInEngineeringFundamentals(driver, identifierPDD);
		//Verify that EF does not appear in PDD
		searchCaseInPreventionOfDesignDeficienciesWithKeyword(driver, keywordEF, identifierEF);
		searchCaseIdInPreventionOfDesignDeficiencies(driver, identifierEF);
	}

	public void searchCaseInPreventionOfDesignDeficienciesWithKeyword (WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		share2.loadingServer(driver);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Prevention of Design Deficiencies
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.PreventionOfDesignDeficienciesLink)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			softly.fail("Case found in Prevention of Design Deficiencies: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Prevention of Design Deficiencies");
		}		
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Prevention of Design Deficiencies case found");	
			System.out.println(s);
			Thread.sleep(2000);	
			//Verify case in error link
			verifyErrorModuleLinkWithKeyword(driver, keyword, identifier);
		}catch(org.openqa.selenium.TimeoutException | NoSuchElementException e)
		{
			System.out.println("warning message not found keyword exists in Prevention of Design Deficiencies: "+keyword);
		}
		//Clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)));
	}

	public void searchCaseIdInPreventionOfDesignDeficiencies(WebDriver driver, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Prevention Of Design Deficiencies
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.PreventionOfDesignDeficienciesLink)).click();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordLabel)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("keyword:");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Prevention of Design Deficiencies Search");
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Enters Equipment Case id to see if it exists
		driver.findElement(cb.EquipmentSearchCaseIdField).sendKeys(identifier);
		driver.findElement(cb.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			softly.fail("Case found in Prevention of Design Deficiencies: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Prevention of Design Deficiencies");
		}
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Prevention of Design Deficiencies case found");	
			softly.assertThat(s).as("test data").doesNotEndWith("..");
			System.out.println(s);
			//Verify case in link in error message
			verifyErrorModuleLinkWithCaseId(driver,identifier);
		}catch(org.openqa.selenium.TimeoutException | NoSuchElementException e)
		{
			System.out.println("warning message not found case exists in Prevention of Design Deficiencies: "+identifier);
		}
		//Clicks on clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)));
	}

	public void searchCaseInEngineeringFundamentalsWithKeyword (WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Engineering Fundamentals
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EngineeringFundamentalsLink)).click();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordLabel)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("keyword:");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Engineering Fundamentals Search");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			softly.fail("Case found in Engineering Fundamentals: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Engineering Fundamentals");
		}	
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Engineering Fundamentals case found");	
			System.out.println(s);
			Thread.sleep(2000);	
			//Verify case in error link
			verifyErrorModuleLinkWithKeyword(driver, keyword, identifier);
		}catch(org.openqa.selenium.TimeoutException | NoSuchElementException e)
		{
			System.out.println("warning message not found keyword exists in Engineering Fundamentals: "+keyword);
		}
		//Clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)));
	}

	public void searchCaseIdInEngineeringFundamentals(WebDriver driver, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Engineering Fundamentals
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EngineeringFundamentalsLink)).click();
		//Clicks on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Enters Equipment Case id to see if it exists
		driver.findElement(cb.EquipmentSearchCaseIdField).sendKeys(identifier);
		driver.findElement(cb.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			softly.fail("Case found in Engineering Fundamentals: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Engineering Fundamentals");
		}	
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Engineering Fundamentals case found");	
			softly.assertThat(s).as("test data").doesNotEndWith("..");
			System.out.println(s);
			//Verify case in link in error message
			verifyErrorModuleLinkWithCaseId(driver,identifier);
		}catch(org.openqa.selenium.TimeoutException | NoSuchElementException e)
		{
			System.out.println("warning message not found case exists in Engineering Fundamentals: "+identifier);
		}
		//Clicks on clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)));
	}

	public void searchCaseIdInFailureModes(WebDriver driver, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Verify that Failure mode cases do not appear in Engineering Fundamentals
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Failure Modes
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		//Clicks on clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)));
		//Enters Equipment Case id to see if it exists
		driver.findElement(cb.EquipmentSearchCaseIdField).sendKeys(identifier);
		driver.findElement(cb.EquipmentSearchCaseIdField).sendKeys(Keys.ENTER);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			softly.fail("Case found in Failure Modes: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Failure Modes");
		}	
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Failure Modes case found");	
			softly.assertThat(s).as("test data").doesNotEndWith("..");
			System.out.println(s);
			//Verify case in link in error message
			verifyErrorModuleLinkWithCaseId(driver,identifier);
		}catch(org.openqa.selenium.TimeoutException | NoSuchElementException e)
		{
			System.out.println("warning message not found case exists in Failure modes: "+identifier);
		}
		//Clicks on clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)));
	}

	public void searchCaseInFMWithKeyword (WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on Failure Modes
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			softly.fail("Case found in Failure Modes: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Failure Modes");
		}	
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Failure Modes case found");	
			System.out.println(s);
			Thread.sleep(2000);	
			//Verify case in error link
			verifyErrorModuleLinkWithKeyword(driver, keyword, identifier);
		}catch(org.openqa.selenium.TimeoutException | NoSuchElementException e)
		{
			System.out.println("warning message not found keyword exists in Failure modes: "+keyword);
		}
		//Clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)));
	}

	public void searchWithPercent(WebDriver driver, String keypercent, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keypercent);
		if(identifier.equals(casePDDProdPercent))
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		else
			clickDropdown(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void searchCaseInEquipSearchByCaseID(WebDriver driver, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		//Clicks on Equipment Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			System.out.println("case found in url:" + driver.getCurrentUrl());
			//if((driver.getCurrentUrl().contains("kaleasia")||driver.getCurrentUrl().contains("kale."))==false)
			softly.fail("Case found in Equipment Search: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Equipment Search");
		}		
		Thread.sleep(2000);	
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Equipment Performance case found");	
			System.out.println(s);
			//Verify case in link in error message
			verifyErrorModuleLinkWithCaseId(driver,identifier);
		}catch(org.openqa.selenium.TimeoutException | NoSuchElementException e)
		{
			System.out.println("warning message not found case exists in Equipment Performance: "+identifier);
		}
		//Clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)));
	}

	public void verifyErrorModuleLinkWithCaseId(WebDriver driver, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on link
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipSearchMessageErrorLink)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Search for case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(identifier);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify case appears
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
	}

	public void searchCaseInEquipSearchByKeyword(WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		//Clicks on Equipment Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verifies no case appears
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
			System.out.println("case found in url:" + driver.getCurrentUrl());
			//if((driver.getCurrentUrl().contains("kaleasia")||driver.getCurrentUrl().contains("kale."))==false)
			softly.fail("Case found in Equipment Search: "+identifier);
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Case not found in Equipment Search");
		}
		try{
			//Verifies warning message
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipSearchMessage)).getText();
			softly.assertThat(s).as("test data").contains("Warning: No Equipment Performance case found");	
			System.out.println(s);
			Thread.sleep(2000);	
			//Verify case in error link
			verifyErrorModuleLinkWithKeyword(driver, keyword, identifier);
		}catch(org.openqa.selenium.TimeoutException | NoSuchElementException e)
		{
			System.out.println("warning message not found keyword exists in Equipment Performance: "+keyword);
		}
		//Clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)));
	}

	public void verifyErrorModuleLinkWithKeyword(WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on link
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipSearchMessageErrorLink)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Search for case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify case appears
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
	}

	public void searchWithSpcl(WebDriver driver, String keyspcl, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(3000);
		//Checks with new keyword with %
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyspcl);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);		
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		Thread.sleep(2000);		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void verifySearchOptions (WebDriver driver, String keyword, String identifier) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clears Everything
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks if clear feature works on term field
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(1000);
		WebElement act= wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordFieldClearButton));
		act.click();
		//Checks for search method with magnifying glass
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordFieldSearchButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Enters the term and check the search by enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));
		share2.scrollToAPoint(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		Thread.sleep(2000);
		//Checks for search method with dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		Thread.sleep(2000);
		clickDropdown(driver);
		//Waits for case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier)));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
	}

	public void clickDropdown(WebDriver driver) throws Exception {

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

	public void verifyCaseModuleNames (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		share2.loadingServer(driver);
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		//Look for Human Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.HumanPerformanceLink));
		//Look for Equipment Data Bank (Instructor Only)
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyLink));
		//Look for Failure modes
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.FailureModeLink));
		//Look for Equipment Performance
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentPerformanceLink));
		//Look for Engineering Fundamentals
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EngineeringFundamentalsLink));
		//Look for Prevention of Design Deficiencies
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.PreventionOfDesignDeficienciesLink));	    
	}

	public void browseCaseID (WebDriver driver, String identifier, String title) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Checks if clear feature works on case id field
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchCaseIdField)).sendKeys(identifier);
		Thread.sleep(1000);
		WebElement ele= driver.findElement(cb.EquipmentSearchCaseIDFieldClearButton);
		ele.click();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))).click();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlideNextButton)).click();
		}
		//Click previous button to browse through case
		previousBrowse(driver,n,expected_title,identifier);
		//Closes the slideshow
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))));
		//Click on clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)));
	}

	public void verifyNoCaseIDSearch (WebDriver driver) throws Exception {

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

	public void browseCaseNonAdmin(WebDriver driver, String keyword, String identifier, String title) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//Types in the keyword to get slide
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		//Get name of current module
		String str = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentModuleTitle)).getText();
		if(str.contains("Equipment Data Bank"))
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))).click();
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
				if(i==4)
				{
					Actions act2 = new Actions(driver);
					Point coordinates = driver.findElement(cb.SlideNextButton).getLocation();
					Robot robot = new Robot();
					robot.mouseMove(coordinates.getX()+100,coordinates.getY());
					Thread.sleep(2000);
					act2.click().build().perform();
				}
				//Clicks on title
				else 
					driver.findElement(By.xpath(title_xpath)).click();
				Thread.sleep(3000);
			}
			//Show slides
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-equip-show-F"+identifier))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlideNextButton)).click();
		}
		if(keyword.equals(keywordPDDDev)||keyword.equals(keywordEFDev)||keyword.equals(keywordEFProd)||keyword.equals(keywordPDDProd))
		{
			//Click previous button to browse through case
			previousBrowse(driver,n,expected_title,identifier);
		}
		//Closes the slideshow
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))));
		//Click on clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)));
		//verify no case id box
		verifyNoCaseIDSearch (driver);
	}

	public void browseCase(WebDriver driver, String keyword, String identifier, String title) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Types in the keyword to get slide
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).clear();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(keyword);
		//Get name of current module
		String str = wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentModuleTitle)).getText();
		if(str.contains("Equipment Data Bank"))
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
		share2.scrollToAPoint(driver, 400);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'pii-collapsible-equip-F"+identifier+"')]/h4/a"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))).click();
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(cb.SlideNextButton)).click();
		}
		if(keyword.equals(keywordPDDDev)||keyword.equals(keywordEFDev)||keyword.equals(keywordEFProd)||keyword.equals(keywordPDDProd))
		{
			//Click previous button to browse through case
			previousBrowse(driver,n,expected_title,identifier);
		}
		//Closes the slideshow
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))));
		//Click on clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)));
	}

	public void previousBrowse(WebDriver driver, int n, String expected_title, String identifier) throws Exception {

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
			//Click on previous
			driver.findElement(cb.SlidePreviousButton).click();
		}
	}

	public void getEquipPerformancePIILink(WebDriver driver) throws Exception {

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
		//Clicks on Equipment Performance Search PII
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentDatabankOnlyLink1)).click();
	}

	public void getPDDLink(WebDriver driver) throws Exception {

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
		//Clicks on Prevention of Design Deficiencies
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.PreventionOfDesignDeficienciesLink)).click();
	}

	public void getEFLink(WebDriver driver) throws Exception {

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
		//Clicks on Engineering Fundamentals
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EngineeringFundamentalsLink)).click();
	}

	public void selectTypeEFPDD(WebDriver driver, String keyword) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
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
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)));
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxTypes));
		if(keyword.equals(keywordEF)||keyword.equals(keywordEFie11)||keyword.equals(keywordEFUS)||keyword.equals(keywordEFUSie11))
		{
			if (browserName.contains("internet")==true)
			{
				equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesFundamentals);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesFundamentals)).click();
		}
		if(keyword.equals(keywordPDD)||keyword.equals(keywordPDDie11)||keyword.equals(keywordPDDUS)||keyword.equals(keywordPDDUSie11))
		{
			if (browserName.contains("internet")==true)
			{
				equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesDesign);
			}
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesDesign)).click();
		}
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxTypesCrossSymbol).click();
		}
	}

	public void selectDisciplineEFPDD(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);

		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDiscipline)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDiscipline)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Discipline
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDiscipline)).click();
			}
		}
		else{
			//Discipline
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseDiscipline)).click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxDiscipline));
		Thread.sleep(1000);
		if (browserName.contains("internet")==true)
		{
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineGeneral);
		}
		else
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineGeneral)).click();
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxDisciplineCrossSymbol).click();
		}
	}
	
	public List<String> createCase(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title)throws Exception{

		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if(browserName.contains("chrome"))
			return createCaseChrome(driver,keyword_same,key1,key2,key3,title);
		else if(browserName.contains("firefox"))
			return createCaseFirefox(driver,keyword_same,key1,key2,key3,title);
		else
		{			
			if(v.startsWith("10"))
				return createCaseIE10(driver,keyword_same,key1,key2,key3,title);
			else
				return createCaseIE11(driver,keyword_same,key1,key2,key3,title);
		}
	}

	public List<String> createCaseChrome(WebDriver driver, String keyword_same, String key1, String key2, String key3, String title) throws Exception{

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
		//Pick a Random number for case id
		Random random = new Random();
		List<String> caseID = new ArrayList<String>();
		String caseId="";
		for(int count=1;count<=5;count++)
		{		
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on new case button
			share2.scrollToTop(driver);
			WebElement newCasebtn= wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton));
			jse.executeScript("arguments[0].scrollIntoView();", newCasebtn);
			jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton)));
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
			selectTypeEFPDD(driver,keyword_same);
			//Select Discipline
			selectDisciplineEFPDD(driver);
			//Select Fields
			equip3.selectFields(driver,softly);
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
			share2.scrollToAPoint(driver, 1700);
			//Enters Keyword
			WebElement enterKey=wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField));
			jse.executeScript("arguments[0].scrollIntoView();", enterKey);
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
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key1);
				share2.loadingServer(driver);
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key2);
				share2.loadingServer(driver);
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)));
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(key3);
				share2.loadingServer(driver);
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)));			  
			}
			else 
			{
				share2.scrollToAPoint(driver, 1700);
	//			WebElement element = driver.findElement(equipObj.EquipCaseKeywordExistingList);
				//element.findElement(chc.FirstAndLastChildInList).click();
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pii-admin-efse-keyword-search-list']//li[@class='ui-first-child ui-last-child']/a"))));

			}
			Thread.sleep(2000);
			//Uploads 5 slides
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
			jse.executeScript("arguments[0].scrollIntoView();", l);
			share2.scrollToElement(driver, l);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageUploadField)).click();
			//Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlides.exe");
			//p.waitFor();
			String file1 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide1.png";
			String file2 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide2.png";
			String file3 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide3.png";
			String file4 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide4.png";
			String file5 = "C:/Users/rramakrishnan/KALE Case Test 1-20/KALE Case Test 1-20/Upload5/Slide5.png";
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageUploadField)).sendKeys(file1+"\n"+file2+"\n"+file3+"\n"+file4+"\n"+file5);
			Thread.sleep(3000);
			//Checks if 5 images have been uploaded
			if(driver.findElement(equipObj.EquipImageCollapsibleExpanded).isDisplayed()==false)
			{
				l = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipImageCollapsible));
				share2.scrollToElement(driver, l);
				jse.executeScript("arguments[0].focus();", l);
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
			jse.executeScript("arguments[0].focus();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))));
			jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))));
			//Clicks on create case
			jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)));
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
			jse.executeScript("arguments[0].scrollIntoView();", equipObj.EquipCaseNewButton);
			jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewButton)));
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
			selectTypeEFPDD(driver,keyword_same);
			//Select Discipline
			selectDisciplineEFPDD(driver);
			//Select Fields
			equip3.selectFields(driver,softly);
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
			share2.scrollToAPoint(driver, 1700);
			//Enters Keyword
			verifyCorrectKeywordEntered(driver,keyword_same);
			Thread.sleep(2000);
			if(count==1)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				verifyCorrectKeywordEntered(driver,key1);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				verifyCorrectKeywordEntered(driver,key2);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				verifyCorrectKeywordEntered(driver,key3);
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
			selectTypeEFPDD(driver,keyword_same);
			//Select Discipline
			selectDisciplineEFPDD(driver);
			//Select Fields
			equip3.selectFields(driver,softly);
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
			share2.scrollToAPoint(driver, 1700);
			//Enters Keyword
			verifyCorrectKeywordEntered(driver,keyword_same);
			Thread.sleep(2000);
			if(count==1)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				verifyCorrectKeywordEntered(driver,key1);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				verifyCorrectKeywordEntered(driver,key2);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				verifyCorrectKeywordEntered(driver,key3);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();			  
			}
			else 
			{
				Thread.sleep(1000);
				share2.scrollToAPoint(driver, 1700);
				WebElement element = driver.findElement(equipObj.EquipCaseKeywordExistingList);
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
			selectTypeEFPDD(driver,keyword_same);
			//Select Discipline
			selectDisciplineEFPDD(driver);
			//Select Fields
			equip3.selectFields(driver,softly);
			//Enters Question
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseQuestion)).sendKeys(title);
			//Enters Answer
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseAnswer)).sendKeys(title);
			share2.scrollToAPoint(driver, 1700);;
			//Enters Keyword
			verifyCorrectKeywordEntered(driver,keyword_same);
			Thread.sleep(2000);
			if(count==1)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				verifyCorrectKeywordEntered(driver,key1);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				verifyCorrectKeywordEntered(driver,key2);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
				verifyCorrectKeywordEntered(driver,key3);
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

	public void verifyCorrectKeywordEntered (WebDriver driver, String keyword) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		while(true)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword);
			Thread.sleep(1000);
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).getAttribute("value");
			if(s.contains(keyword))
				break;
		}
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
