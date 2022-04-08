package MainClass;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiRCAChinese36 {

	HiRCAChinese2 hc2 = new HiRCAChinese2();
	HiRCAChinese3 hc3 = new HiRCAChinese3();
	HiRCAChinese5 hc5 = new HiRCAChinese5();
	HiRCAChinese8 hc8 = new HiRCAChinese8();
	HiRCAChinese9 hc9 = new HiRCAChinese9();
	HiRCAChinese10 hc10 = new HiRCAChinese10();
	HiRCAChinese11 hc11 = new HiRCAChinese11();
	HiRCAChinese12 hc12 = new HiRCAChinese12();
	HiRCAChinese13 hc13 = new HiRCAChinese13();
	HiRCAChinese14 hc14 = new HiRCAChinese14();
	HiRCAChinese15 hc15 = new HiRCAChinese15();
	HiRCAChinese16 hc16 = new HiRCAChinese16();
	HiRCAChinese17 hc17 = new HiRCAChinese17();
	HiRCAChinese28 hc28 = new HiRCAChinese28();
	HiRCAChinese29 hc29 = new HiRCAChinese29();
	HiRCAChinese37 hc37 = new HiRCAChinese37();

	public void saveReport6th (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		hc16.chineseSUEP(driver,softly);
		//Verify all selections in SUEP as 6th path
		hc11.chineseLevel3SelectionsSUEP6th(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		hc16.chineseStep4(driver,softly);
		//Verify all selections in step 4 as 6th path		
		hc5.chineseLevel3SelectionsStep4_6th(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		hc17.chineseHIRCAChecklist(driver,softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Report
		//hc17.chineseReport(driver,softly);
		//Verify report for 6th path
		//hc10.chineseReport6thPath(driver,softly);
		//Save
		hc17.saveNewReport(driver,softly);
		//Verify HTML report
		List <String> verifyChinese = new ArrayList<String>();
		//verifyChinese.addAll(hc15.chineseHTMLReport6thPath(driver, softly));
		//Download report and check pdf
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			hc8.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			hc8.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				hc8.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				hc8.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
		//Delete report function is in main calling function
	}

	public void saveReport5th (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCALevel1 obj3 = new HiRCALevel1();
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		hc16.chineseSUEP(driver,softly);
		//Verify all selections in SUEP as 5th path
		hc11.chineseLevel3SelectionsSUEP5th(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		hc16.chineseStep4(driver,softly);
		//Verify all selections in step 4 as 5th path		
		hc5.chineseLevel3SelectionsStep4_5th(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		hc17.chineseHIRCAChecklist(driver,softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Report
		//hc17.chineseReport(driver,softly);
		//Verify report for 5th path
		//hc29.chineseReport5thPath(driver,softly);
		//Save
		hc17.saveNewReport(driver,softly);
		//Verify HTML report
		List <String> verifyChinese= new ArrayList<String>();
		//verifyChinese.addAll(hc14.chineseHTMLReport5thPath(driver, softly));
		//Download report and check pdf
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			hc8.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			hc8.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				hc8.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				hc8.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
		//Delete report
		obj3.deleteReport(driver);
	}

	public void saveReport4th (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCALevel1 obj2 = new HiRCALevel1();
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		hc16.chineseSUEP(driver,softly);
		//Verify all selections in SUEP as 4th path
		hc11.chineseLevel3SelectionsSUEP4th(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		hc16.chineseStep4(driver,softly);
		//Verify all selections in step 4 as 4th path		
		hc5.chineseLevel3SelectionsStep4_4th(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		hc17.chineseHIRCAChecklist(driver,softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Report
		//hc17.chineseReport(driver,softly);
		//Verify report for 4th path
		//hc28.chineseReport4thPath(driver,softly);
		//Save
		hc17.saveNewReport(driver,softly);
		//Verify HTML report
		List <String> verifyChinese= new ArrayList<String>();
		//verifyChinese.addAll(hc3.chineseHTMLReport4thPath(driver, softly));
		//Download report and check pdf
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			hc8.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			hc8.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				hc8.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				hc8.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
		//Delete report
		obj2.deleteReport(driver);
	}

	public void saveReport3rd (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		hc16.chineseSUEP(driver,softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		hc16.chineseStep4(driver,softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		hc17.chineseHIRCAChecklist(driver,softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Report
		//hc17.chineseReport(driver,softly);
		//Verify report for 3rd path
		//hc9.chineseReport3rdPath(driver,softly);
		//Save
		hc17.saveNewReport(driver,softly);
		//Verify HTML report
		List <String> verifyChinese= new ArrayList<String>();
		//verifyChinese.addAll(hc11.chineseHTMLReport3rdPath(driver, softly));
		//Download report and check pdf
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			hc8.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			hc8.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				hc8.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				hc8.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
		//Delete report
		HiRCALevel1 obj2 = new HiRCALevel1();
		obj2.deleteReport(driver);
	}	

	public void saveReport2nd (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		hc16.chineseSUEP(driver,softly);
		//Verify all selections in SUEP as 2nd path
		hc8.chineseLevel3SelectionsSUEP2nd(driver, softly);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		hc16.chineseStep4(driver,softly);
		//Verify all selections in step 4 as 2nd path		
		hc8.chineseLevel3SelectionsStep4_2nd(driver, softly);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		hc17.chineseHIRCAChecklist(driver,softly);
		hc8.selectAllChecklist(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Verify Report
		//hc17.chineseReport(driver,softly);
		//Verify report for 2nd path
		//hc9.chineseReport2ndPath(driver,softly);
		//Save
		hc17.saveNewReport(driver,softly);
		//Verify HTML report
		List <String> verifyChinese= new ArrayList<String>();
		//verifyChinese.addAll(hc12.chineseHTMLReport2ndPath(driver, softly));
		//Download report and check pdf
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			hc8.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			hc8.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				hc8.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				hc8.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
		//Delete report
		HiRCALevel1 obj1 = new HiRCALevel1();
		obj1.deleteReport(driver);
	}	

	public void saveReport1st (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCALevel1 obj2 = new HiRCALevel1();
		//LOP pop up opens, click Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		Thread.sleep(2000);
		//Verify SUEP
		hc16.chineseSUEP(driver,softly);
		//Verify all selections in SUEP as 1st path
		hc11.chineseLevel3SelectionsSUEP1st(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Step 4
		hc16.chineseStep4(driver,softly);
		//Verify all selections in step 4 as 1st path		
		hc37.chineseLevel3SelectionsStep4_1st(driver, softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify HiRCA Checklist
		hc17.chineseHIRCAChecklist(driver,softly);
		//Click skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		Thread.sleep(2000);
		//Verify Report
		//hc17.chineseReport(driver,softly);
		//Verify report for 1st path
		//hc2.chineseReport1stPath(driver,softly);
		//Save
		hc17.saveNewReport(driver,softly);
		//Verify HTML report
		List <String> verifyChinese= new ArrayList<String>();
		//verifyChinese.addAll(hc13.chineseHTMLReport1stPath(driver, softly));
		//Download report and check pdf
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			hc8.downloadReportChrome(driver,softly,verifyChinese);
		if (browserName.equals("firefox"))
			hc8.downloadReportFirefox(driver,softly,verifyChinese);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				hc8.downloadReportIE(driver,softly,verifyChinese);
			if (v.startsWith("11"))
				hc8.downloadReportIE11(driver,softly,verifyChinese);
		}
		Thread.sleep(2000);
		//Delete report
		obj2.deleteReport(driver);
	}
}