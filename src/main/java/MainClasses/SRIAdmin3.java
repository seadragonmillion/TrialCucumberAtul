import javax.annotation.concurrent.ThreadSafe;

import kaleTestSoftware.LoginPageObj;
import kaleTestSoftware.SRIPageObj;
import kaleTestSoftware.ShareCheck2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SRIAdmin3 {

	SRIPageObj sri = new SRIPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	LoginPageObj lpo = new LoginPageObj();

	public void verifyIfNoUnitBaselineNotSaved(WebDriver driver, SoftAssertions softly, String component) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Go to baseline tab
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)).click();	
		//Select component
		WebElement element = driver.findElement(sri.SRIAdminBaselineTabElectricalDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(component);
		//Select unit
		WebElement element1 = driver.findElement(sri.SRIAdminBaselineUnitForFirstRowSelect);
		Select s1 = new Select (element1);
		s1.selectByIndex(0);
		//Click on Save button
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminSaveButton)).click();
		//Wait for warning message
		String warning = wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote)).getText();
		softly.assertThat(warning).as("test data").isEqualTo("Cannot save as there are errors in the table of baselines");
		//Click on undo
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUndoButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)).click();
		share2.loadingServer(driver);
	}

	public void verifyAppearanceOfMissingValuesInBaseline(WebDriver driver, SoftAssertions softly, String component, String measurement, String unit) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		verifyIfNoUnitBaselineNotSaved(driver,softly,component);
		//Delete unit
		deleteUnitAdded(driver,measurement,unit);
		//Go to baseline tab
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)).click();		
		//Select component
		WebElement element = driver.findElement(sri.SRIAdminBaselineTabElectricalDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(component);
		//Verify no unit selected
		String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselineUnitForFirstRow)).getText();
		softly.assertThat(unitName).as("test data").isEqualTo(" ");
		//Delete measurement
		deleteMeasurementAdded(driver,measurement,0);
		//Go to baseline tab
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)).click();		
		//Select component
		WebElement element1 = driver.findElement(sri.SRIAdminBaselineTabElectricalDropdown);
		Select s1 = new Select (element1);
		s1.selectByVisibleText(component);
		//Verify no unit selected
		String unitName1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselineUnitForFirstRow)).getText();
		softly.assertThat(unitName1).as("test data").isEqualTo(" ");
		//Verify no measurement selected
		String measName = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselineMeasurementForFirstRow)).getText();
		softly.assertThat(measName).as("test data").isEqualTo(" ");
		//Click on SRI conclusion tab
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)).click();
		//Select mechanical component
		WebElement element2 = driver.findElement(sri.SRIAdminConclusionTabElectricalDropdown);
		Select s2 = new Select (element2);
		s2.selectByVisibleText(component);
		//Verify no measurement selected
		String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionMeasurementForFirstRow)).getText();
		softly.assertThat(measurementName).as("test data").isEqualTo(" ");
		//Click on undo
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUndoButton)));
		Thread.sleep(300);
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)));
		share2.loadingServer(driver);
	}

	public int deleteMeasurementAdded(WebDriver driver, String measurement, int mechOrElec) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,2);	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		share2.scrollToTop(driver);
		//Click on SRI measurement tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementTab)).click();
		int sum=0;
		Thread.sleep(500);
		//Count number of measurements
		int count=1;
		while(true)
		{
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]")));
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				if(measurementName.equals(measurement))
				{
					//delete measurement
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[4]/a"))));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[4]/a"))));
					Thread.sleep(300);
					//Delete confirm button
					jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)));
					sum=1;
				}
			}catch(org.openqa.selenium.TimeoutException e)
			{
				break;
			}
			count=count+2;
		}
		return sum;
	}

	public int deleteUnitAdded(WebDriver driver, String measurement, String unit) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		share2.scrollToTop(driver);
		//Click on SRI units tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitsTab)).click();
		//Select measurement
		/*try{
			WebElement element = driver.findElement(sri.SRIAdminUnitTabMeasurementDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(measurement);	
		}catch(org.openqa.selenium.NoSuchElementException r)
		{
			return 0;
		}*/
		//Thread.sleep(500);
		//Count number of units
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]"));
				String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				if(unitName.equals(unit))
				{
					//if(driver.findElement(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[2]/div/input")).isSelected())
					//{
						//delete unit
						share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[4]/a"))));
						jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[4]/a"))));
						//Delete confirm button
						jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)));
						//share2.loadingServer(driver);
					//}
						return 1;
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				//System.out.println(e);
				break;
			}
			count=count+2;
		}
		return 0;
	}


	public void verifyErrorMessageForSameNameElements(WebDriver driver, SoftAssertions softly, String component, String measurement, String unit) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		share2.scrollToTop(driver);
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//Click on SRI components tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTab)).click();
		//Click on SRI components tab electrical option
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabElectricalOption)).click();
		//Enter same english name for component
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentNameFieldEnglish)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentNameFieldEnglish)).sendKeys(component);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentNameFieldEnglish)).sendKeys(Keys.ENTER);
		if(browserName.contains("internet explorer"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentNameFieldEnglish)).sendKeys(Keys.TAB);
		Thread.sleep(500);
		//Verify error message
		String error1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentMessage)).getText();
		softly.assertThat(error1).as("test data").isEqualTo("Warning: this component already exist");
		//Enter same english name + s for component
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentNameFieldEnglish)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentNameFieldEnglish)).sendKeys(component+"s");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentNameFieldEnglish)).sendKeys(Keys.ENTER);
		Thread.sleep(500);
		if(browserName.contains("internet explorer"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentNameFieldEnglish)).sendKeys(Keys.TAB);
		Thread.sleep(500);
		//Verify error message
		String error2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentMessage)).getText();
		softly.assertThat(error2).as("test data").isEmpty();
		//Click on SRI measurement tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementTab)).click();
		//Enter same english name for measurement
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameFieldEnglish)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameFieldEnglish)).sendKeys(measurement);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameFieldEnglish)).sendKeys(Keys.ENTER);
		Thread.sleep(500);
		if(browserName.contains("internet explorer"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameFieldEnglish)).sendKeys(Keys.TAB);
		Thread.sleep(500);
		//Verify error message
		String error3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementMessage)).getText();
		System.out.println(error3);
		softly.assertThat(error3).as("test data").isEqualTo("Warning: this measurement already exist");
		Thread.sleep(500);
		//Enter same english name + s for measurement
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameFieldEnglish)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameFieldEnglish)).sendKeys(measurement+"s");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameFieldEnglish)).sendKeys(Keys.ENTER);
		Thread.sleep(500);
		if(browserName.contains("internet explorer"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameFieldEnglish)).sendKeys(Keys.TAB);
		Thread.sleep(500);
		//Verify error message
		String error4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementMessage)).getText();
		System.out.println(error4);
		softly.assertThat(error4).as("test data").isEmpty();
		Thread.sleep(500);
		//Click on SRI units tab
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitsTab)).click();
		//Enter unit
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitName)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitName)).sendKeys(unit);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitName)).sendKeys(Keys.ENTER);
		if(browserName.contains("internet explorer"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitName)).sendKeys(Keys.TAB);
		Thread.sleep(500);
		//Verify error message
		String error5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitMessage)).getText();
		softly.assertThat(error5).as("test data").isEqualTo("Warning: this unit already exist");
		//Enter unit
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitName)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitName)).sendKeys(unit.toLowerCase());
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitName)).sendKeys(Keys.ENTER);
		if(browserName.contains("internet explorer"))
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitName)).sendKeys(Keys.TAB);
		Thread.sleep(500);
		//Verify error message
		String error6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitMessage)).getText();
		softly.assertThat(error6).as("test data").isEmpty();
	}
	
	public void verifySavePopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupNote)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Warning: once you save this version, any changes in configuration will override existing data.");
	}
	
	public void verifySizeOfPlusSignBaselineTab(WebDriver driver, SoftAssertions softly, String component) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		share2.scrollToTop(driver);
		//Baseline tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)).click();		
		//Select component
		WebElement element = driver.findElement(sri.SRIAdminBaselineTabMechanicalDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(component);
		/*
		//Set new size to make screen small
		Thread.sleep(200);
		driver.manage().window().setSize(new Dimension(620,900));
		Thread.sleep(200);
		//Verify size of plus sign
		Dimension elementSize = driver.findElement(sri.SRIAdminBaselineAddButton).getSize();
		int x = elementSize.getWidth();
		int y = elementSize.getHeight();
		softly.assertThat(x).as("test data").isEqualTo(42);
		softly.assertThat(y).as("test data").isEqualTo(39);		
		*/
		//Maximize
		driver.manage().window().maximize();
		//softly.assertAll();
	}

}
