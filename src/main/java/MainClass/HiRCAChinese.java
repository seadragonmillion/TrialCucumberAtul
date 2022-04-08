package MainClass;

import PageObjects.LoginPageObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAChinese {

	SoftAssertions softly = new SoftAssertions();
	LoginPageObj lpo = new LoginPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	HiRCAChinese4 hc4 = new HiRCAChinese4();
	HiRCAChinese6 hc6 = new HiRCAChinese6();
	HiRCAChinese7 hc7 = new HiRCAChinese7();
	HiRCAChinese16 hc16 = new HiRCAChinese16();
	HiRCAChinese17 hc17 = new HiRCAChinese17();
	HiRCAChinese18 hc18 = new HiRCAChinese18();
	HiRCAChinese19 hc19 = new HiRCAChinese19();
	HiRCAChinese20 hc20 = new HiRCAChinese20();
	HiRCAChinese21 hc21 = new HiRCAChinese21();
	HiRCAChinese30 hc30 = new HiRCAChinese30();
	HiRCAChinese31 hc31 = new HiRCAChinese31();
	HiRCAChinese32 hc32 = new HiRCAChinese32();
	HiRCAChinese33 hc33 = new HiRCAChinese33();
	HiRCAChinese34 hc34 = new HiRCAChinese34();
	HiRCAChinese35 hc35 = new HiRCAChinese35();
	HiRCAChinese36 hc36 = new HiRCAChinese36();
	HiRCAChinese37 hc37 = new HiRCAChinese37();
	HiRCAChinese38 hc38 = new HiRCAChinese38();
	HiRCAChinese39 hc39 = new HiRCAChinese39();
	LanguageCheckOfReports lcr = new LanguageCheckOfReports();
	ChineseCommonFunctions ccf = new ChineseCommonFunctions();
	HiRCALOPBug2 hlb2 = new HiRCALOPBug2 ();

	public String text = "Chinese check";

	public void chineseEventInfoFill (WebDriver driver, String text) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Clicks on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		Thread.sleep(2000);
		//Verify everything on Event Information page is in 
		hc7.chineseEventInfo(driver,softly);
		ccf.verifyChineseTabsInsideHiRCA(driver, softly);
		ccf.verifyChineseButtonsInfoTabHiRCA(driver, softly);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys(text);
		//Location of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-location"))).sendKeys(text);
		//Department
		WebElement dropdown = driver.findElement(By.id("pii-irca-event-department"));
		Select s = new Select (dropdown);
		s.selectByVisibleText("Construction");
		//Problem Statement
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement"))).sendKeys(text);
		//Timeline of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-events"))).sendKeys(text);
		//Background info
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos"))).sendKeys(text);
		//Investigators
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-investigators"))).sendKeys(text);
		//Gets value of date
		String get_date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-date"))).getAttribute("value");
		System.out.println(get_date);
		//Gets value of time
		String get_time = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-time"))).getAttribute("value");
		System.out.println(get_time);
		//Gets value of department
		String get_dept = driver.findElement(By.id("pii-irca-event-department")).getAttribute("value");
		System.out.println(get_dept);
		share2.scrollToAPoint(driver, 6500);
		//Clicks on next
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))));
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))));
		Thread.sleep(2000);
	}

	public void pathHiRCA(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCA2 obj2 = new HiRCA2();
		share2.loadingServer(driver);  
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Go to hirca and fill mandatory details on event info
		chineseEventInfoFill(driver,text);		
		//Verify chinese on Step1 tab q1.1
		hc7.chineseStepOneq11(driver,softly);
		//Check language change
		obj2.verifyChangeLanguage(driver, softly);
		ccf.verifyChineseButtonsInBetweenTabsHiRCA(driver, softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.2
		hc7.chineseStepOneq12(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.4
		hc38.chineseStepOneL34(driver,softly);
		//Check language change
		obj2.verifyChangeLanguage(driver, softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.18
		hc38.chineseStepOneL318(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.6
		hc7.chineseStepOneq16(driver,softly);
		//Check language change
		obj2.verifyChangeLanguage(driver, softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.15
		hc39.chineseStepOneL315(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.7
		hc7.chineseStepOneq17(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.8
		hc7.chineseStepOneq18(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.9
		hc39.chineseStepOneL39(driver,softly);
		//Check language change
		obj2.verifyChangeLanguage(driver, softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.10
		hc6.chineseStepOneL310(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.11
		hc6.chineseStepOneL311(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.9
		hc16.chineseStepOneq19(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.2
		hc18.chineseStepOneL32(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.11
		hc6.chineseStepOneL311(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.10
		hc16.chineseStepOneq110(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.11
		hc16.chineseStepOneq111(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.9
		hc39.chineseStepOneL39(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.12
		hc16.chineseStepOneq112(driver,softly);
		//Check language change
		obj2.verifyChangeLanguage(driver, softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.13
		hc16.chineseStepOneq113(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.14
		hc16.chineseStepOneq114(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.2
		hc18.chineseStepOneL32(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.15
		hc16.chineseStepOneq115(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.6
		hc21.chineseStepOneL36(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.16
		hc16.chineseStepOneq116(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.2
		hc18.chineseStepOneL32(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.17
		hc16.chineseStepOneq117(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.3
		hc30.chineseStepOneL33(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.18
		hc16.chineseStepOneq118(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.22
		hc18.chineseStepOneL322(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.19
		hc16.chineseStepOneq119(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.3
		hc30.chineseStepOneL33(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.5
		hc32.chineseStepOneL35(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.20
		hc16.chineseStepOneq120(driver,softly);
		//Select answer 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.5
		hc32.chineseStepOneL35(driver,softly);
		//Check language change
		obj2.verifyChangeLanguage(driver, softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify pop up for LOP/RC
		hc16.chineseLOPRC(driver,softly);
		//Save 1st path
		hc36.saveReport1st(driver,softly);
		share2.loadingServer(driver); 
		//2nd path
		//Go to Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Go to hirca and fill mandatory details on event info
		chineseEventInfoFill(driver,text);
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		hc7.chineseStepOneq11(driver,softly);
		//Select answer 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.17
		hc33.chineseStepOneL317(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify pop up for LOP/RC
		hc16.chineseLOPRC(driver,softly);		
		//Save 2nd path
		hc36.saveReport2nd(driver,softly);	
		//3rd path
		share2.loadingServer(driver); 
		//Go to Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();		
		//Go to hirca and fill mandatory details on event info
		chineseEventInfoFill(driver,text);
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		hc7.chineseStepOneq11(driver,softly);
		//Select answer 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify pop up for LOP/RC
		hc16.chineseLOPRC(driver,softly);
		//Save 3rd path
		hc36.saveReport3rd(driver,softly);
		//4th path
		share2.loadingServer(driver); 
		//Go to Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Go to hirca and fill mandatory details on event info
		chineseEventInfoFill(driver,text);
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		hc7.chineseStepOneq11(driver,softly);
		//Select answer 1.1.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.2
		hc7.chineseStepOneq12(driver,softly);
		//Select answer 1.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.3
		hc7.chineseStepOneq13(driver,softly);
		//Select answer 1.3.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.12
		hc35.chineseStepOneL312(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.13
		hc17.chineseStepOneL313(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.14
		hc17.chineseStepOneL314(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.15
		hc39.chineseStepOneL315(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.5
		hc7.chineseStepOneq15(driver,softly);
		//Select answer 1.5.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.1
		hc4.chineseStepOneL31(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip 1.6 to 1.9
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.10
		hc16.chineseStepOneq110(driver,softly);
		//Select answer 1.10.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.21
		hc4.chineseStepOneL321(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip 1.11 to 1.20
		for(int i=1;i<=10;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			Thread.sleep(2000);
		}
		//Verify pop up for LOP/RC
		hc16.chineseLOPRC(driver,softly);
		//Save 4th path
		hc36.saveReport4th(driver,softly);		
		//5th path
		share2.loadingServer(driver); 
		//Go to Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Go to hirca and fill mandatory details on event info
		chineseEventInfoFill(driver,text);
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		hc7.chineseStepOneq11(driver,softly);
		//Select answer 1.1.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.2
		hc7.chineseStepOneq12(driver,softly);
		//Select answer 1.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.3
		hc7.chineseStepOneq13(driver,softly);
		hlb2.bugKALE2493(driver, softly);
		//Select answer 1.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.4
		hc7.chineseStepOneq14(driver,softly);
		//Select answer 1.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.16
		hc31.chineseStepOneL316(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip 1.5 to 1.20
		for(int i=1;i<=16;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			Thread.sleep(2000);
		}
		//Verify pop up for LOP/RC
		hc16.chineseLOPRC(driver,softly);
		//Save 5th path
		hc36.saveReport5th(driver,softly);
		//6th path
		share2.loadingServer(driver); 
		//Go to Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		//Go to hirca and fill mandatory details on event info
		chineseEventInfoFill(driver,text);
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.1
		hc7.chineseStepOneq11(driver,softly);
		//Select answer 1.1.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.2
		hc7.chineseStepOneq12(driver,softly);
		//Select answer 1.2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.3
		hc7.chineseStepOneq13(driver,softly);
		//Select answer 1.3.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify chinese on Step1 tab q1.4
		hc7.chineseStepOneq14(driver,softly);
		//Select answer 1.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.6
		hc21.chineseStepOneL36(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.7
		hc19.chineseStepOneL37(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.8
		hc20.chineseStepOneL38(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify 3.18
		hc38.chineseStepOneL318(driver,softly);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Skip 1.5 to 1.20
		for(int i=1;i<=16;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
			Thread.sleep(2000);
		}
		//Verify pop up for LOP/RC
		hc16.chineseLOPRC(driver,softly);
		//Save 6th path
		hc36.saveReport6th(driver,softly);
	}

	public void changeToChinese (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		while(true)
		{
			try{
				if (driver.findElement(lpo.StickyNote).isDisplayed())
				{
					Thread.sleep(1000);
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
			catch (org.openqa.selenium.ElementNotInteractableException u)
			{
				break;
			}
			catch (org.openqa.selenium.JavascriptException t)
			{
				Thread.sleep(2000);
				break;
			}

		}
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			//Clicks on Account
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		}
		else
		{
			Actions act = new Actions (driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
			WebElement element = driver.findElement(By.id("pii-user-loginname"));
			act.click(element).build().perform();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct")));
			element = driver.findElement(By.id("pii-user-acct"));
			act.click(element).build().perform();
			Thread.sleep(2000);
		}
		share2.loadingServer(driver);
		//Changes language to Chinese
		WebElement dropdown1 = driver.findElement(By.id("pii-admin-user-language"));
		Select s4 = new Select (dropdown1);
		s4.selectByVisibleText("Chinese");
		share2.loadingServer(driver);
		//Clicks on save
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		lcr.verifyLabelAdminUserAccountChinese(driver, softly);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	}

	public void changeToEnglish (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		while(true)
		{
			try{
				if (driver.findElement(By.className("sticky-note")).isDisplayed())
				{
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();

				}
			}catch (NoSuchElementException e)
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
			catch (org.openqa.selenium.ElementNotInteractableException u)
			{
				break;
			}
			catch (org.openqa.selenium.JavascriptException t)
			{
				Thread.sleep(2000);
				break;
			}

		}
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			//Clicks on Admin
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
			while(true)
			{
				Thread.sleep(1000);
				try{
					//Clicks on Account
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
					break;
				}catch(org.openqa.selenium.TimeoutException r)
				{
					//Clicks on Admin
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
				}
			}
			Thread.sleep(2000);
		}
		else
		{
			Actions act = new Actions (driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
			WebElement element = driver.findElement(By.id("pii-user-loginname"));
			act.click(element).build().perform();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct")));
			element = driver.findElement(By.id("pii-user-acct"));
			act.click(element).build().perform();
			Thread.sleep(2000);
			try{
				driver.findElement(By.id("pii-admin-user-language"));
			}catch(NoSuchElementException r){
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
				element = driver.findElement(By.id("pii-user-loginname"));
				act.click(element).build().perform();
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct")));
				element = driver.findElement(By.id("pii-user-acct"));
				act.click(element).build().perform();
				Thread.sleep(2000);
			}
		}
		share2.loadingServer(driver);
		//Changes language to English
		WebElement dropdown1 = driver.findElement(By.id("pii-admin-user-language"));
		Select s4 = new Select (dropdown1);
		s4.selectByVisibleText("English");
		//Clicks on save
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pii-logo-div-element-kale"))).click();
	}		

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
