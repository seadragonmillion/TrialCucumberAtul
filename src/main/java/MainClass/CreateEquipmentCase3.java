package MainClass;

import java.util.ArrayList;
import java.util.Collections;
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
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateEquipmentCase3 {

	CreateEquipPageObj equipObj = new CreateEquipPageObj();
	LoginPageObj lpo = new LoginPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	CaseBrowsePageObj cb = new CaseBrowsePageObj();
	CreateHumanCasePageObj chc = new CreateHumanCasePageObj();
	
	public String titleCombo = "QAA Type Discipline Field Filters Combo Test";
	public String titleComboUS = "QAA US Type Discipline Field Filters Combo Test";
	public String titleComboie11 = "QAA IE11 Type Disciplineie11 Fieldie11 Filters Combo Test";
	public String titleComboUSie11 = "QAA US IE11 Type Disciplineie11 Fieldie11 Filters Combo Test";
	public String keywordCombo = "QAADiscFieldCombo";
	public String keywordComboUS = "QAAUSDiscFieldCombo";
	public String keywordComboie11 = "QAAie11DiscFieldCombo";
	public String keywordComboUSie11 = "QAAUSie11DiscFieldCombo";
	public String noVideoLink = "http://www.murdoch.edu.au/School-of-Engineering-and-Information-Technology/";
	public String noVideoLinkTitle1 = "Apple \"pie\"";
	public String noVideoLinkTitle2 = "Banana";
	public String noVideoLinkTitle3 = "Coconut";
	public String noVideoLinkTitle4 = "Dance";
	public String noVideoLinkTitle5 = "Elephant";
	public String noVideoLinkTitle6 = "Fruit";
	public String noVideoLinkTitle7 = "Guava";
	public String noVideoLinkTitle8 = "Honey";
	public String noVideoLinkTitle9 = "Ink";
	public String noVideoLinkTitle10 = "Jamaica";
	public String videoLink = "https://www.youtube.com/watch?v=KQ9Za0oLPPM";
	public String videoLinkTitle1 = "Tiger";
	public String videoLinkTitle2 = "Whale";
	public String videoLinkTitle3 = "Zebra";
	public String keyword_same_eq="QAAfiveeq";
	public String key1_eq="QAAzebraeq";
	public String key2_eq="QAAcameleq";
	public String key3_eq="QAAgiraffeeq";
	public String keyword_same_ee="QAAfiveee";
	public String key1_ee="QAAzebraee";
	public String key2_ee="QAAcamelee";
	public String key3_ee="QAAgiraffeee";
	public String keyword_same_me="QAAfiveme";
	public String key1_me="QAAzebrame";
	public String key2_me="QAAcamelme";
	public String key3_me="QAAgiraffeme";
	public String eq_title="QAA Equipment Search Case Upload";
	public String ee_title="QAA Electrical Failure Case Upload";
	public String me_title="QAA Mechanical Failure Case Upload";
	public String keyword_same_eqUS="QAAfiveeqUS";
	public String key1_eqUS="QAAzebraeqUS";
	public String key2_eqUS="QAAcameleqUS";
	public String key3_eqUS="QAAgiraffeeqUS";
	public String keywordUS_same_ee="QAAfiveeeUS";
	public String key1_eeUS="QAAzebraeeUS";
	public String key2_eeUS="QAAcameleeUS";
	public String key3_eeUS="QAAgiraffeeeUS";
	public String keywordUS_same_me="QAAfivemeUS";
	public String key1_meUS="QAAzebrameUS";
	public String key2_meUS="QAAcamelmeUS";
	public String key3_meUS="QAAgiraffemeUS";
	public String eq_titleUS="QAA US Equipment Search Case Upload";
	public String ee_titleUS="QAA US Electrical Failure Case Upload";
	public String me_titleUS="QAA US Mechanical Failure Case Upload";
	public String keyword_same_eqie11="QAAie11fiveeq";
	public String key1_eqie11="QAAie11zebraeq";
	public String key2_eqie11="QAAie11cameleq";
	public String key3_eqie11="QAAie11giraffeeq";
	public String keyword_same_eeie11="QAAie11fiveee";
	public String key1_eeie11="QAAie11zebraee";
	public String key2_eeie11="QAAie11camelee";
	public String key3_eeie11="QAAie11giraffeee";
	public String keyword_same_meie11="QAAie11fiveme";
	public String key1_meie11="QAAie11zebrame";
	public String key2_meie11="QAAie11camelme";
	public String key3_meie11="QAAie11giraffeme";
	public String eq_titleie11="QAA IE11 Equipment Case Upload";
	public String ee_titleie11="QAA IE11 Electrical Case Upload";
	public String me_titleie11="QAA IE11 Mechanical Case Upload";
	public String keyword_same_eqie11US="QAAie11fiveeqUS";
	public String key1_eqie11US="QAAie11zebraeqUS";
	public String key2_eqie11US="QAAie11cameleqUS";
	public String key3_eqie11US="QAAie11giraffeeqUS";
	public String keyword_same_eeie11US="QAAie11fiveeeUS";
	public String key1_eeie11US="QAAie11zebraeeUS";
	public String key2_eeie11US="QAAie11cameleeUS";
	public String key3_eeie11US="QAAie11giraffeeeUS";
	public String keyword_same_meie11US="QAAie11fivemeUS";
	public String key1_meie11US="QAAie11zebrameUS";
	public String key2_meie11US="QAAie11camelmeUS";
	public String key3_meie11US="QAAie11giraffemeUS";
	public String eq_titleie11US="QAA US IE11 Equipment Case Upload";
	public String ee_titleie11US="QAA US IE11 Electrical Case Upload";
	public String me_titleie11US="QAA US IE11 Mechanical Case Upload";
	
	public void verifyPaddingOnRelatedLinksSlide(WebDriver driver, SoftAssertions softly, By locator) throws Exception {

		//Get css value padding-right
		String paddingRight = driver.findElement(locator).getCssValue("padding-right");
		softly.assertThat(paddingRight).as("test data").isEqualTo("50px");
		//Get css value padding-left
		String paddingLeft = driver.findElement(locator).getCssValue("padding-left");
		softly.assertThat(paddingLeft).as("test data").isEqualTo("60px");
		System.out.println("***"+paddingRight+"***");
		System.out.println("***"+paddingLeft+"***");
	}
	
	public void selectFields(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Fields
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Fields
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).click();
			}
		}
		else{
			//Fields
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxFields));	
		//Verify fields list
		verifyFieldsList(driver, softly);
		//Choose a number between 1 and 5 for number of Fields
		Random random = new Random ();
		int x;
		//Choose a number between 1 and 5
		while(true)
		{
			x = random.nextInt(6);
			if(x==0)
				continue;
			break;
		}
		if(x==1)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsAuto)).click();			
		}
		if(x==2)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsNuclear)).click();				
		}
		if(x==3)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsOther)).click();			
		}
		if(x==4)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsPharmaceutical)).click();			
		}
		if(x==5)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsWelding)).click();			
		}
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxFieldsCrossSymbol).click();
		}
	}
	
	public void verifyFieldsList(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verifies that list contains the required options
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsAuto)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Auto");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsNuclear)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Nuclear");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsOther)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Other");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsPharmaceutical)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Pharmaceutical");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsWelding)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Welding");
	}

	public void clickTypesDisciplineIE(WebDriver driver, By element) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get checkbox clicked or not value
		while(true)
		{
			Thread.sleep(1000);
			String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getAttribute("class");
			System.out.println(c1);
			if(c1.contains("ui-checkbox-on")==true)
				break;
			wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
			Thread.sleep(1000);
		}
	}

	public void lookForCases(WebDriver driver, List<String> cases) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int j=0;j<cases.size();j++)
		{
			//Look for case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+cases.get(j))));
		}
	}

	public List<By> disciplineCaseSearchList()  throws Exception{

		List<By> dl = new ArrayList<By>();
		//Add discipline to list
		Collections.addAll(dl, cb.EquipCaseSearchListDisciplineElectrical, cb.EquipCaseSearchListDisciplineGeneral, cb.EquipCaseSearchListDisciplineIC, cb.EquipCaseSearchListDisciplineMechanical, cb.EquipCaseSearchListDisciplineSoftware, cb.EquipCaseSearchListDisciplineStructural);
		return dl;
	}

	public List<By> fieldCaseSearchList()  throws Exception{

		List<By> fl = new ArrayList<By>();
		//Add discipline to list
		Collections.addAll(fl, cb.EquipCaseSearchListFieldAuto, cb.EquipCaseSearchListFieldNuclear, cb.EquipCaseSearchListFieldOther, cb.EquipCaseSearchListFieldPharmaceutical, cb.EquipCaseSearchListFieldWelding);
		return fl;
	}

	public void selectFieldsForComboTest(WebDriver driver, By element, String browserName, String v) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		if (browserName.contains("internet")==true)
		{
			if (v.startsWith("10")==true)
			{
				//Fields
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).sendKeys(Keys.ENTER);
			}
			if (v.startsWith("11")==true)
			{
				//Fields
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).click();
			}
		}
		else{
			//Fields
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseFields)).click();
		}
		Thread.sleep(1000);
		//Waits for the popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxFields));	
		//Click on field
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();		
		//Close pop up
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxFieldsCrossSymbol).click();
		}
	}

	public void selectDisciplineForComboTest(WebDriver driver, By element, String browserName, String v) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
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
		Thread.sleep(1000);
		//Waits for the page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxDiscipline));
		if (browserName.contains("internet")==true)
			clickTypesDisciplineIE(driver, element);
		else
			wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
		//Close pop up
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxDisciplineCrossSymbol).click();
		}
	}

	public void addKeywordEquip(WebDriver driver, String caseID, String keyword_same)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
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
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(caseID);
		}catch(org.openqa.selenium.WebDriverException t)
		{
			Thread.sleep(1000);
			share2.scrollToTop(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDAdmin)).sendKeys(caseID);
		}
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSearchCaseIDDropdownAdmin)).click();
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share2.scrollToTop(driver);
		Thread.sleep(1000);
		//Click on Edit
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseEditButton)));
		Thread.sleep(2000);
		//Scroll down
		try{
			jse.executeScript("scroll(0,2000)");
		}catch (org.openqa.selenium.ScriptTimeoutException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,2000)");
		}
		Thread.sleep(3000);
		//Add new keyword
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same);
		share2.loadingServer(driver);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)));
		/*
		if(browserName.contains("safari")||browserName.contains("firefox"))
		{
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)));
		}else
		{
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
			}catch(org.openqa.selenium.WebDriverException r)
			{
				while(true)
				{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).getAttribute("textContent");
					System.out.println(s);
					if(s.contains(keyword_same))
					{
						share2.scrollToAPoint(driver, 2000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
					}
					else{
						share2.scrollToAPoint(driver, 2000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).clear();
						wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordField)).sendKeys(keyword_same);
						share2.scrollToAPoint(driver, 2000);
						try{
							wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseNewKeywordAddButton)).click();
						}catch(org.openqa.selenium.WebDriverException t){
							
						}
					}
				}
			}
		}*/
		Thread.sleep(1000);
		share2.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on save
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)));
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupTitle)).click();
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCasePopupConfirmButton)));
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(1000);
		share2.scrollToTop(driver);
		Thread.sleep(1000);
		//Clicks on Error free bank
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(chc.ErrorFreeBankTopLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
	}
		
	public void verifyErrorOnPage (WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Scroll top
		share2.scrollToTop(driver);
		//Click on save
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseSaveButton)));
		//share2.verifyWarningPopupForError(driver, softly);
		//Verify all errors
		String idError = driver.findElement(equipObj.CaseIDError).getText();
		softly.assertThat(idError).as("test data").isEqualTo("ID is required");
		String typeError = driver.findElement(equipObj.TypeError).getText();
		softly.assertThat(typeError).as("test data").isEqualTo("Case type is required");
		String discError = driver.findElement(equipObj.DisciplineError).getText();
		softly.assertThat(discError).as("test data").isEqualTo("Case discipline is required");
		String fieldError = driver.findElement(equipObj.FieldError).getText();
		softly.assertThat(fieldError).as("test data").isEqualTo("Case field is required");
		String questionError = driver.findElement(equipObj.QuestionError).getText();
		softly.assertThat(questionError).as("test data").isEqualTo("Case question is required");
		String answerError = driver.findElement(equipObj.AnswerError).getText();
		softly.assertThat(answerError).as("test data").isEqualTo("Case answer is required");
		String imageError = driver.findElement(equipObj.PNGFileError).getText();
		softly.assertThat(imageError).as("test data").isEqualTo("Please select some PNG files with .png extension");
		String keywordError = driver.findElement(equipObj.KeywordError).getText();
		softly.assertThat(keywordError).as("test data").isEqualTo("Please attach some keywords to this case");
		//softly.assertAll();
	}

}
