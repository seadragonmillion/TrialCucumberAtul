package MainClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import PageObjects.CreateEquipPageObj;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EquipmentCaseLoad {


	CreateEquipmentCase3 equip3 = new CreateEquipmentCase3();
	CreateEquipPageObj equipObj = new CreateEquipPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	
	public String keyword1eq = "Slide100imageseq";
	public String keyword2eq = "Slide100NoImageseq";
	public String keyword3eq = "Slide100Images50eq";
	public String keyword1ee = "Slide100imagesee";
	public String keyword2ee = "Slide100NoImagesee";
	public String keyword3ee = "Slide100Images50ee";
	public String keyword1me = "Slide100Imagesme";
	public String keyword2me = "Slide100NoImagesme";
	public String keyword3me = "Slide100Images50me";
	public String keyword1eqie = "Slide100imageseqie";
	public String keyword2eqie = "Slide100NoImageseqie";
	public String keyword3eqie = "Slide100Images50eqie";
	public String keyword1eeie = "Slide100imageseeie";
	public String keyword2eeie = "Slide100NoImageseeie";
	public String keyword3eeie = "Slide100Images50eeie";
	public String keyword1meie = "Slide100Imagesmeie";
	public String keyword2meie = "Slide100NoImagesmeie";
	public String keyword3meie = "Slide100Images50meie";
	public String title1 = "QAA 100 Slides only images";
	public String title2 = "QAA 100 Slides no images";
	public String title3 = "QAA 100 Slides 50 images";
	public String title1ie = "QAA IE11 100 Slides only images";
	public String title2ie = "QAA IE11 100 Slides no images";
	public String title3ie = "QAA IE11 100 Slides 50 images";
	public String sheetEquipDev = "EquipmentPerformanceDev";
	public String sheetEquipAsia = "EquipmentPerformanceAsia";
	public String sheetEquipUSA = "EquipmentPerformanceUSA";
	public String sheetElecDev = "ElectricalFailureDev";
	public String sheetElecAsia = "ElectricalFailureAsia";
	public String sheetElecUSA = "ElectricalFailureUSA";
	public String sheetMechDev = "MechanicalFailureDev";
	public String sheetMechAsia = "MechanicalFailureAsia";
	public String sheetMechUSA = "MechanicalFailureUSA";
	
	public void selectFields(WebDriver driver) throws Exception {

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
		//Click all fields
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListFieldsAuto)).click();
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxFieldsCrossSymbol).click();
		}
	}
	
	public void selectDiscipline(WebDriver driver) throws Exception {

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
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxDiscipline));	 
		if (browserName.contains("internet")==true)
		{
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListDisciplineElectrical);
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListDisciplineElectrical)).click();
		}
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxDisciplineCrossSymbol).click();
		}
	}
	
	public void selectTypes (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipCaseTypes)).click();
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListBoxTypes));
		if (browserName.contains("internet"))
		{
			equip3.clickTypesDisciplineIE(driver, equipObj.EquipListTypesAdvancedLearning);	
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.EquipListTypesAdvancedLearning)).click();	
		}
		try{
			driver.findElement(equipObj.ListCrossSymbol).click();
		}catch (NoSuchElementException | ElementNotInteractableException e)
		{
			driver.findElement(equipObj.EquipListBoxTypesCrossSymbol).click();
		}
	}

	public void getEquipPerformanceLink(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		//Clicks on Equipment Performance Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance"))).click();
	}

	public void getElecPerformanceLink(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		//Clicks on Electrical Failure mode Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electrical Failure Modes"))).click();
	}

	public void getMechPerformanceLink(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Clicks on ErrorFree Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		//Clicks on Mechanical failure mode Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mechanical Failure Modes"))).click();
	}

	public String createCaseChrome (WebDriver driver, String title, String keyword, int r) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,50);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(By.id("pii-admin-efse-manage-button")).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button"))).click();
		//Enters mandatory data
		//Enters case id
		Random random = new Random();
		String caseId="";
		List<WebElement> list = new ArrayList<WebElement>();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on new case button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-new"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-new"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-new"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on new case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))));
		while (true)
		{
			Thread.sleep(1000);
			int y=random.nextInt(10000);
			if(y<1000)
				continue;
			caseId = String.format("%d", y);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).sendKeys(caseId);
			Thread.sleep(1000);
			Thread.sleep(1000);
			WebElement errorCaseId;
			try{
				errorCaseId=driver.findElement(By.id("pii-admin-efse-id-error"));
			}catch(NoSuchElementException e)
			{
				break;
			}
			if(errorCaseId.isDisplayed()==true)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
				continue;
			}
			if(errorCaseId.isDisplayed()==false)
				break;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
		}
		System.out.println("Case id: "+ caseId);/*
		  //Selects Category
		  if(keyword.equals(keyword1eq)||keyword.equals(keyword2eq)||keyword.equals(keyword3eq))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("General");			  
		  }
		  if(keyword.equals(keyword1ee)||keyword.equals(keyword2ee)||keyword.equals(keyword3ee))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Electrical Failure Mode");
		  }
		  if(keyword.equals(keyword1me)||keyword.equals(keyword2me)||keyword.equals(keyword3me))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Mechanical Failure Mode");
		  }*/
		//Select all Filters
		selectTypes(driver);
		selectDiscipline(driver);
		selectFields(driver);
		//Enters Question
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-question"))).sendKeys(title);
		//Enters Answer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-answer"))).sendKeys(title);
		share2.scrollToAPoint(driver, 1700);
		//Enters Keyword
		jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keyword);
		Thread.sleep(3000);
		share2.scrollToAPoint(driver, 2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-list"))).click();
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))));
		share2.scrollToTop(driver);
		//Uploads 100 slides r=1 for no images, r=2 for 100 images, r=3 for 50 images
		share2.scrollToAPoint(driver, 400);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.id("pii-admin-efse-upload-file-input"))).click().build().perform();
		
		//WebElement element = driver.findElement(By.id("pii-admin-efse-upload-file-input"));
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].click();", element);
		Thread.sleep(500);
		
		//share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input"))));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input"))).click();
		if(r==1)
		{
			Process p =Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\UploadHumanCaseSlidesChromeNoImages100.exe");
			p.waitFor();
			Thread.sleep(3000);
		}
		if(r==2)
		{
			Process p =Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\UploadHumanCaseSlidesChromeOnlyImages100.exe");
			p.waitFor();
			Thread.sleep(3000);
		}
		if(r==3)
		{
			Process p =Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\UploadHumanCaseSlidesChrome50ImagesAndText100.exe");
			p.waitFor();
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
		//Checks if 100 images have been uploaded
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a"))));
		Thread.sleep(2000);
		int i;
		for (i=0; i<100;i++)
		{
			//String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
			String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/div/div/div["+(i+1)+"]";
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
			{
				System.out.println("Uploaded Image : " + (i+1));
				list.add(driver.findElement(By.xpath(xpath)));
			}

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a"))).click();
		share2.scrollToTop(driver);
		//Clicks on save
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		if(r==2 ||r==3)
		{
			//Waits for black loading message to disappear
			try{
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
			{

			}
		}
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-delete"))).isEnabled()==false)
		{
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
			//Waits for black loading message to disappear
			try{
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
			{

			}
			if(r==2 ||r==3)
			{
				//Waits for black loading message to disappear
				try{
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
					Thread.sleep(5000);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				}catch (org.openqa.selenium.TimeoutException e)
				{

				}
			}
		}
		return caseId;		  
	}

	public String createCaseFirefox (WebDriver driver, String title, String keyword, int r) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,90);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(By.id("pii-admin-efse-manage-button")).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button"))).click();
		//Enters mandatory data
		//Enters case id
		Random random = new Random();
		String caseId="";
		List<WebElement> list = new ArrayList<WebElement>();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Clicks on new case button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-new"))).click();
		//Clicks on new case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		while (true)
		{
			Thread.sleep(1000);
			int y=random.nextInt(10000);
			if(y<1000)
				continue;
			caseId = String.format("%d", y);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).sendKeys(caseId);
			Thread.sleep(1000);
			Thread.sleep(1000);
			WebElement errorCaseId;
			try{
				errorCaseId=driver.findElement(By.id("pii-admin-efse-id-error"));
			}catch(NoSuchElementException e)
			{
				break;
			}
			if(errorCaseId.isDisplayed()==true)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
				continue;
			}
			if(errorCaseId.isDisplayed()==false)
				break;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
		}
		System.out.println("Case id: "+ caseId);/*
		  //Selects Category
		  if(keyword.equals(keyword1eq)||keyword.equals(keyword2eq)||keyword.equals(keyword3eq))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("General");			  
		  }
		  if(keyword.equals(keyword1ee)||keyword.equals(keyword2ee)||keyword.equals(keyword3ee))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Electrical Failure Mode");
		  }
		  if(keyword.equals(keyword1me)||keyword.equals(keyword2me)||keyword.equals(keyword3me))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Mechanical Failure Mode");
		  }*/
		//Select all Filters
		selectTypes(driver);
		selectDiscipline(driver);
		selectFields(driver);
		//Enters Question
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-question"))).sendKeys(title);
		//Enters Answer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-answer"))).sendKeys(title);
		share2.scrollToAPoint(driver, 1700);
		//Enters Keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keyword);
		Thread.sleep(3000);
		share2.scrollToAPoint(driver, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();
		share2.scrollToTop(driver);
		//Uploads 100 slides r=1 for no images, r=2 for 100 images, r=3 for 50 images
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input"))).click();
		if(r==1)
		{
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesFirefoxNoImages100.exe");
			p.waitFor();
		}
		if(r==2)
		{
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesFirefoxOnlyImages100.exe");
			p.waitFor();
		}
		if(r==3)
		{
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesFirefox50ImagesAndText100.exe");
			p.waitFor();
		}
		Thread.sleep(3000);
		//Checks if 100 images have been uploaded
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a"))).click();
		Thread.sleep(2000);
		int i;
		for (i=0; i<100;i++)
		{
			try{
				String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
				{
					System.out.println("Uploaded Image : " + (i+1));
					list.add(driver.findElement(By.xpath(xpath)));
				}
			}catch (org.openqa.selenium.TimeoutException e)
			{
				System.out.println("Couldn't view images at position "+(i+1));
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a"))).click();
		share2.scrollToTop(driver);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		if(r==2 ||r==3)
		{
			//Waits for black loading message to disappear
			try{
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
			{

			}
		}
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-delete"))).isEnabled()==false)
		{
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			if(r==2 ||r==3)
			{
				//Waits for black loading message to disappear
				try{
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
					Thread.sleep(5000);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				}catch (org.openqa.selenium.TimeoutException e)
				{

				}
			}
		}
		share2.scrollToTop(driver);
		return caseId;
	}

	public String createCaseIE (WebDriver driver, String title, String keyword, int r) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,90);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(By.id("pii-admin-efse-manage-button")).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button"))).click();
		//Enters mandatory data
		//Enters case id
		Random random = new Random();
		String caseId="";
		List<WebElement> list = new ArrayList<WebElement>();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Clicks on new case button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-new"))).click();
		//Clicks on new case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		while (true)
		{
			Thread.sleep(1000);
			int y=random.nextInt(10000);
			if(y<1000)
				continue;
			caseId = String.format("%d", y);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).sendKeys(caseId);
			Thread.sleep(1000);
			Thread.sleep(1000);
			WebElement errorCaseId;
			try{
				errorCaseId=driver.findElement(By.id("pii-admin-efse-id-error"));
			}catch(NoSuchElementException e)
			{
				break;
			}
			if(errorCaseId.isDisplayed()==true)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
				continue;
			}
			if(errorCaseId.isDisplayed()==false)
				break;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
		}
		System.out.println("Case id: "+ caseId);/*
		  //Selects Category
		  if(keyword.equals(keyword1eq)||keyword.equals(keyword2eq)||keyword.equals(keyword3eq))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("General");			  
		  }
		  if(keyword.equals(keyword1ee)||keyword.equals(keyword2ee)||keyword.equals(keyword3ee))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Electrical Failure Mode");
		  }
		  if(keyword.equals(keyword1me)||keyword.equals(keyword2me)||keyword.equals(keyword3me))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Mechanical Failure Mode");
		  }*/
		//Select all Filters
		selectTypes(driver);
		selectDiscipline(driver);
		selectFields(driver);
		//Enters Question
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-question"))).sendKeys(title);
		//Enters Answer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-answer"))).sendKeys(title);
		share2.scrollToAPoint(driver, 1700);
		//Enters Keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keyword);
		Thread.sleep(4000);
		share2.scrollToAPoint(driver, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();
		share2.scrollToTop(driver);
		//Uploads 100 slides r=1 for no images, r=2 for 100 images, r=3 for 50 images
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input"))).click();
		if(r==1)
		{
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesIE10NoImages100.exe");
			p.waitFor();
		}
		if(r==2)
		{
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesIE10OnlyImages100.exe");
			p.waitFor();
		}
		if(r==3)
		{
			Process p =Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/UploadHumanCaseSlidesIE1050ImagesAndText100.exe");
			p.waitFor();
		}
		Thread.sleep(3000);
		//Checks if 100 images have been uploaded
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a"))).click();
		Thread.sleep(2000);
		int i;
		for (i=0; i<100;i++)
		{
			String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
			if (driver.findElement(By.xpath(xpath)).isDisplayed())
			{
				System.out.println("Uploaded Image : " + (i+1));
				list.add(driver.findElement(By.xpath(xpath)));
			}

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a"))).click();
		share2.scrollToTop(driver);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		if(r==2 ||r==3)
		{
			//Waits for black loading message to disappear
			try{
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
			{

			}
		}
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-delete"))).isEnabled()==false)
		{
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			if(r==2 ||r==3)
			{
				//Waits for black loading message to disappear
				try{
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
					Thread.sleep(5000);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				}catch (org.openqa.selenium.TimeoutException e)
				{

				}
			}
		}
		share2.scrollToTop(driver);
		return caseId;
	}

	public String createCaseIE11 (WebDriver driver, String title, String keyword, int r) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,90);
		Actions act1 = new Actions (driver);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Errorfree bank option
		if (driver.findElement(By.id("pii-admin-efse-manage-button")).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		}
		WebElement button= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button")));
		act1.click(button).build().perform();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		Thread.sleep(6000);
		//Enters mandatory data
		//Enters case id
		Random random = new Random();
		String caseId="";
		List<WebElement> list = new ArrayList<WebElement>();
		//Clicks on new case button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-new"))).click();
		//Clicks on new case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		while (true)
		{
			Thread.sleep(2000);
			int y=random.nextInt(10000);
			if(y<1000)
				continue;
			caseId = String.format("%d", y);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).sendKeys(caseId);
			Thread.sleep(1000);
			Thread.sleep(1000);
			WebElement errorCaseId;
			try{
				errorCaseId=driver.findElement(By.id("pii-admin-efse-id-error"));
			}catch(NoSuchElementException e)
			{
				break;
			}
			if(errorCaseId.isDisplayed()==true)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
				continue;
			}
			if(errorCaseId.isDisplayed()==false)
				break;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-id"))).clear();
		}
		System.out.println("Case id: "+ caseId);/*
		  //Selects Category
		  if(keyword.equals(keyword1eqie)||keyword.equals(keyword2eqie)||keyword.equals(keyword3eqie))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("General");			  
		  }
		  if(keyword.equals(keyword1eeie)||keyword.equals(keyword2eeie)||keyword.equals(keyword3eeie))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Electrical Failure Mode");
		  }
		  if(keyword.equals(keyword1meie)||keyword.equals(keyword2meie)||keyword.equals(keyword3meie))
		  {
			  WebElement dropdown = driver.findElement(By.id("pii-admin-efse-level"));
			  Select s = new Select (dropdown);
			  s.selectByVisibleText("Mechanical Failure Mode");
		  }*/
		//Select all Filters
		selectTypes(driver);
		selectDiscipline(driver);
		selectFields(driver);
		//Enters Question
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-question"))).sendKeys(title);
		//Enters Answer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-answer"))).sendKeys(title);
		share2.scrollToAPoint(driver, 1700);
		//Enters Keyword
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-search-input"))).sendKeys(keyword);
		Thread.sleep(4000);
		share2.scrollToAPoint(driver, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-keyword-new"))).click();
		share2.scrollToTop(driver);
		//Uploads 100 slides r=1 for no images, r=2 for 100 images, r=3 for 50 images
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input"))));
		WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-upload-file-input")));
		act1.click(ele).build().perform();
		Thread.sleep(2000);
		if(r==1)
		{
			Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlidesIE10NoImages100.exe");
			p.waitFor();
		}
		if(r==2)
		{
			Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlidesIE10OnlyImages100.exe");
			p.waitFor();
		}
		if(r==3)
		{
			Process p =Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/UploadHumanCaseSlidesIE1050ImagesAndText100.exe");
			p.waitFor();
		}
		Thread.sleep(6000);
		//Checks if 100 images have been uploaded
		WebElement collapsible=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a")));
		act1.click(collapsible).build().perform();
		Thread.sleep(6000);
		int i;
		for (i=0; i<100;i++)
		{
			String xpath = ".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div["+(i+1)+"]";
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed())
			{
				System.out.println("Uploaded Image : " + (i+1));
				list.add(driver.findElement(By.xpath(xpath)));
			}

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a"))).click();
		share2.scrollToTop(driver);
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
		//Clicks on create case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		if(r==2 ||r==3)
		{
			//Waits for black loading message to disappear
			try{
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
			}catch (org.openqa.selenium.TimeoutException e)
			{

			}
		}
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-delete"))).isEnabled()==false)
		{
			//Clicks on save
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-save"))).click();
			//Clicks on create case
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			if(r==2 ||r==3)
			{
				//Waits for black loading message to disappear
				try{
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-icon-loading")));
					Thread.sleep(5000);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-icon-loading")));
				}catch (org.openqa.selenium.TimeoutException e)
				{

				}
			}
		}
		share2.scrollToTop(driver);
		return caseId;	  
	}

	public int deletePreviousCase(WebDriver driver, String keyword) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,40);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Error free bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-e"))).click();
		//Clicks on Equipment Performance Search (PII)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-e-menu-equipPII"))).click();
		//Enters the title in term search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Checks if Exact matches appear
		try{
			driver.findElement(By.xpath(".//*[@id='pii-question-list-equip']/div/h4/a/div"));			
		}catch (NoSuchElementException e)
		{
			System.out.println("No existing cases for "+keyword);
			return 0;
		}		
		int i=1;
		String [] caseIdArray=new String[50];
		while(true)
		{
			try
			{
				String xpath=".//*[@id='pii-question-list-equip']/div[1]/div[1]/div["+i+"]";
				System.out.println(xpath);
				WebElement row=driver.findElement(By.xpath(xpath));
				String rowCaseId=row.getAttribute("qid");
				rowCaseId=rowCaseId.substring(1);
				System.out.println("Case id:" +rowCaseId);
				caseIdArray[i-1]=rowCaseId;
				i=i+1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}
		for(int count = 0;count<=(i-2);count++)
		{
			System.out.println(caseIdArray[count]);
			deleteCase(driver, caseIdArray[count]);
		}
		return 1;				
	}

	public void deleteCase(WebDriver driver, String caseId) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,40);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		Thread.sleep(1000);
		//Clicks on Errorfree bank option
		if (driver.findElement(By.id("pii-admin-efse-manage-button")).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-efbank']/h3/a"))).click();
		}
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-manage-button"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-input"))).sendKeys(caseId);
		Thread.sleep(2000);
		//Clicks on case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-ul"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on delete button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-delete"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-delete"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-button-delete"))).click();
		//Clicks on delete case
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-title"))).click();
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-dialog-confirmed"))));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Checks if case deleted
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-input"))).sendKeys(caseId);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-efse-list-input"))).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		if(driver.findElement(By.id("pii-admin-efse-list-ul")).isDisplayed()==false)
			System.out.println("Case deleted "+caseId);		  
	}

	public long searchCase100(WebDriver driver, String keyword, String identifier) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Types in the keyword to get slide 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-searchbykw-input"))).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on collapsible 
		try{
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(By.id("pii-collapsible-equip-F"+identifier))).click().build().perform();
					}catch(org.openqa.selenium.WebDriverException t)
					{
						jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))));
					}
 //		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-collapsible-equip-F"+identifier))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Show Slides
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideshow-button-equip-F"+identifier)));
		WebElement element =  driver.findElement(By.id("pii-slideshow-button-equip-F"+identifier));
		String slide = element.getText();
		System.out.println(slide);
		while (slide.equals("Show Slides(101)")==false)
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
		long total=0;
		for(int i=0;i<n-1;i++)
		{
			long f1=System.currentTimeMillis();
			System.out.println("Slide "+(i+1));
			if(i==0)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
			String load=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideimg-F"+identifier+"-"+(i+1)))).getAttribute("src");
			while (load.contains("loading.gif")==true)
			{
				load=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-slideimg-F"+identifier+"-"+(i+1)))).getAttribute("src");	
			}
			long f2=System.currentTimeMillis();
			System.out.println("Total loading time in milliseconds: "+ (f2-f1));
			total=total+(f2-f1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next"))).click();
		}
		System.out.println("Total time in milliseconds for case with only images:"+total);
		System.out.println("Total time in seconds for case with only images:"+(total/1000));
		//Closes the slideshow
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-slideshow-equip-F"+identifier+"']/a"))));
		//Click on clear
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-efse-clear"))));
		return total;
	}

	public void storeData(WebDriver driver, long total1, long total2, long total3, String sheet) throws Exception {

		File file = new File("C:\\Users\\rramakrishnan\\KALE Case Test 1-20\\LoadCase.xlsx");		
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(file);
		// Access the required test data sheet
		XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelWSheet = ExcelWBook.getSheet(sheet);
		//Get number of rows
		int rows = ExcelWSheet.getPhysicalNumberOfRows();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		//Get date
		SimpleDateFormat sfdate = new SimpleDateFormat("MM/dd/yyy");
		Date date = new Date();
		//System.out.println(sfdate.format(date));
		//Create a new row for only images
		Row row1 = ExcelWSheet.createRow(rows);
		row1.createCell(0).setCellValue("Only Images");
		row1.createCell(1).setCellValue(total1/1000);	
		row1.createCell(2).setCellValue(browserName);
		row1.createCell(3).setCellValue(sfdate.format(date));
		//Create a new row for No images
		Row row2 = ExcelWSheet.createRow(rows+1);
		row2.createCell(0).setCellValue("No Images");
		row2.createCell(1).setCellValue(total2/1000);
		row2.createCell(2).setCellValue(browserName);
		row2.createCell(3).setCellValue(sfdate.format(date));
		//Create a new row for 50 images
		Row row3 = ExcelWSheet.createRow(rows+2);
		row3.createCell(0).setCellValue("50 Images");
		row3.createCell(1).setCellValue(total3/1000);
		row3.createCell(2).setCellValue(browserName);
		row3.createCell(3).setCellValue(sfdate.format(date));
		//Close File input stream
		ExcelFile.close();
		//Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);
		ExcelWBook.write(outputStream);
		ExcelWBook.close();
		outputStream.close();

	}

}
