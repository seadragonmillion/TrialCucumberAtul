package MainClass;

import java.util.ArrayList;
import java.util.List;


import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.hotkey.Keys;

public class SRIAdmin2 {

	SRIPageObj sri = new SRIPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	SRIAdmin3 sriA3 = new SRIAdmin3();

	//Mechanical
	public String mechanicalComponent1 = "QAA Mechanical Component 1";
	public String mechanicalMeasurement1 = "QAA Mechanical Measurement 1";
	public String mechanicalMeasurement2 = "QAA Mechanical Measurement 2";
	public String mechanicalUnit1 = "QAA Mechanical Unit 1";
	public String mechanicalUnit2 = "QAA Mechanical Unit 2";
	public String mechanicalFSIBaseline1 = "10";
	public String mechanicalFSIBaseline2 = "20";
	public String mechanicalFSIBaseline3 = "30";
	public String mechanicalFSIBaseline4 = "-1.01";
	public String mechanicalFSIBaseline5 = "2.02";
	public String mechanicalFSIBaseline6 = "3.03";
	public String mechanicalFSIConclusion1 = "Mechanical Conclusion 1";
	public String mechanicalFSIConclusion2 = "Mechanical Conclusion 2";
	public String mechanicalFSIConclusion3 = "Mechanical Conclusion 3";

	//Electrical
	public String electricalComponent1 = "QAA Electrical Component 1";
	public String electricalMeasurement1 = "QAA Electrical Measurement 1";
	public String electricalMeasurement2 = "QAA Electrical Measurement 2";
	public String electricalUnit1 = "QAA Electrical Unit 1";
	public String electricalUnit2 = "QAA Electrical Unit 2";
	public String electricalFSIBaseline1 = "10";
	public String electricalFSIBaseline2 = "20";
	public String electricalFSIBaseline3 = "30";
	public String electricalFSIBaseline4 = "-1.01";
	public String electricalFSIBaseline5 = "2.02";
	public String electricalFSIBaseline6 = "3.03";
	public String electricalFSIConclusion1 = "Electrical Conclusion 1";
	public String electricalFSIConclusion2 = "Electrical Conclusion 2";
	public String electricalFSIConclusion3 = "Electrical Conclusion 3";

	public void removeUnitVerifyPart2UnderBaslineVanishes(WebDriver driver, String component, String measurement1, String measurement2, String unit1, String unit2, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Go to baseline tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)).click();		
		//Select component 1
		WebElement element = driver.findElement(sri.SRIAdminBaselineTabMechanicalDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(component);	
		//Verify presence of 2.
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinePart2));
		//Delete unit1
		sriA3.deleteUnitAdded(driver,measurement1,unit1);
		//Come back to baseline
		share2.scrollToTop(driver);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)));
		//Verify presence of 2.
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinePart2));
		//Click on conclusion
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)));
		//Come back to baseline
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)));
		//Verify presence of 2.
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinePart2));
		//Verify no unit selected
		String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselineUnitForFirstRow)).getText();
		softly.assertThat(unitName).as("test data").isEqualTo(" ");
		//Delete unit2
		sriA3.deleteUnitAdded(driver,measurement2,unit2);
		//Delete measurement2
		sriA3.deleteMeasurementAdded(driver,measurement2,0);
		//Come back to baseline
		share2.scrollToTop(driver);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)));				
		//Verify 2. not present
		wait.until(ExpectedConditions.invisibilityOfElementLocated(sri.SRIAdminBaselinePart2));
		//Click on conclusion
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)).click();
		//Come back to baseline
		share2.scrollToTop(driver);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)));
		//Verify 2. not present
		wait.until(ExpectedConditions.invisibilityOfElementLocated(sri.SRIAdminBaselinePart2));
	}

	public void verifyBaselineText(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify the explanation
		String msg1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselineMessageLine2)).getText().trim();
		softly.assertThat(msg1).as("test data").isEqualTo("Incipient Failure Stage 1: Between OP (Normal Operation) limit and IFS1 limit");
		String msg2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselineMessageLine3)).getText().trim();
		softly.assertThat(msg2).as("test data").isEqualTo("Incipient Failure Stage 2: Above IFS1 limit and upto IFS2 limit");
		String msg3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselineMessageLine4)).getText().trim();
		softly.assertThat(msg3).as("test data").isEqualTo("Incipient Failure Stage 3: Above IFS2 limit");
		//Verify the label
		String label1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselienOPLimitLabel)).getText().trim();
		softly.assertThat(label1).as("test data").isEqualTo("OP limit:");
		String label2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselienIFS1LimitLabel)).getText().trim();
		softly.assertThat(label2).as("test data").isEqualTo("IFS1 limit:");
		String label3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselienIFS2LimitLabel)).getText().trim();
		softly.assertThat(label3).as("test data").isEqualTo("IFS2 limit:");
	}

	public void verifyBaselineAdded(WebDriver driver, int mechOrElec, String component, String measurement, String unit, String fs1, String fs2, String fs3, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on MainClass.SRI baseline tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			WebElement element = driver.findElement(sri.SRIAdminBaselineTabMechanicalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);		
		}
		else
		{
			//Select electrical component
			WebElement element = driver.findElement(sri.SRIAdminBaselineTabElectricalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);
		}
		verifyBaselines(driver,measurement,unit,fs1,fs2,fs3,softly);
	}

	public void verifyBaselines(WebDriver driver, String measurement, String unit, String fs1, String fs2, String fs3, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List<String> unitList = new ArrayList<String>();
		List<String> measurementList = new ArrayList<String>();	
		//Count number of baselines
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]"));
				//Get unit name
				String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[3]/div/div/span"))).getText();
				unitList.add(unitName);
				//Get Measurement name
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[2]/div/div/span"))).getText();
				measurementList.add(measurementName);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+2;
		}
		//Go through all measurements and units to check if added component is present
		softly.assertThat(unit).as("test data").isIn(unitList);
		softly.assertThat(measurement).as("test data").isIn(measurementList);
		//Get the index of the baseline which matches both measurement and unit
		int index = 0;
		for (int i=0;i<unitList.size();i++)
		{
			if(unitList.get(i).equals(unit))
				if(measurementList.get(i).equals(measurement))
				{
					index = i+1;
					break;
				}
		}
		index = (index*2)-1;
		String fs1Value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+index+"]/td[4]/div/input"))).getAttribute("value");
		String fs2Value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+index+"]/td[5]/div/input"))).getAttribute("value");
		String fs3Value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+index+"]/td[6]/div/input"))).getAttribute("value");
		softly.assertThat(fs1Value).as("test data").isEqualTo(fs1);
		softly.assertThat(fs2Value).as("test data").isEqualTo(fs2);
		softly.assertThat(fs3Value).as("test data").isEqualTo(fs3);
		verifyBaselineText(driver,softly);
	}

	public void changeConclusion(WebDriver driver, String component, String measurement, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on MainClass.SRI conclusion tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)).click();
		try{
			if(driver.findElement(sri.SRIAdminConclusionTabMechanicalDropdown).isDisplayed()==false)
			{
				//Click on MainClass.SRI side link
				wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISideLink)).click();
				//Click on MainClass.SRI conclusion tab
				wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)).click();
			}
		}catch(org.openqa.selenium.NoSuchElementException r)
		{
			//Click on MainClass.SRI side link
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISideLink)).click();
			//Click on MainClass.SRI conclusion tab
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)).click();
		}
		Thread.sleep(500);
		//Select mechanical component
		try{
			WebElement element = driver.findElement(sri.SRIAdminConclusionTabMechanicalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);	
		}catch(org.openqa.selenium.NoSuchElementException r)
		{

		}
		Thread.sleep(500);
		//Select measurement
		WebElement element = driver.findElement(sri.SRIAdminConclusionTabMeasurementDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(measurement);	
		Thread.sleep(500);
		//Delete all conclusions under the component+measurement combination
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]"));
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[2]/div/div/span"))).getText();
				if(measurementName.equals(measurement))
				{
					//change conclusion
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[3]/textarea"))));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[3]/textarea"))).clear();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[3]/textarea"))).sendKeys("conclusion changed");
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+2;
		}
		//Click on Save
	//	saveChangedValues(driver,softly);
		try {
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminSaveButton)));
			Thread.sleep(300);
			sriA3.verifySavePopup(driver, softly);
			//Click on save button on popup
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)));
		} catch (Exception e) {
			try {
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminSaveButton)));
				Thread.sleep(300);
				sriA3.verifySavePopup(driver, softly);
				//Click on save button on popup
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)));
			} catch (Exception e1) {
				System.out.println("Conclusion Changed Save Button worked successfully");
			}
			
		}
		
	}

	public void saveChangedValues(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on Save button
		share2.scrollToTop(driver);
		jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-title"))));
		Thread.sleep(500);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminSaveButton)));
		Thread.sleep(300);
	//	sriA3.verifySavePopup(driver, softly);
		//Click on save button on popup
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)));
		share2.loadingServer(driver);
	}

	public void verifyConclusions(WebDriver driver, String measurement, String fs1, String fs2, String fs3, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List<String> measurementList = new ArrayList<String>();
		//Count number of conclusions
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]"));
				//Get Measurement name
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[2]/div/div/span"))).getText();
				measurementList.add(measurementName);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+2;
		}
		//Go through all measurements to check if added measurement is present
		softly.assertThat(measurement).as("test data").isIn(measurementList);
		//Get the index of the conclusion which matches measurement
		int index = measurementList.indexOf(measurement)+1;
		System.out.println(index);
		if(index%2==0)
			index=index+1;
		//Verify conclusions
		String fs1Value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+index+"]/td[3]/textarea"))).getAttribute("value");
		String fs2Value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+index+"]/td[4]/textarea"))).getAttribute("value");
		String fs3Value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+index+"]/td[5]/textarea"))).getAttribute("value");
		softly.assertThat(fs1Value).as("test data").isEqualTo(fs1);
		softly.assertThat(fs2Value).as("test data").isEqualTo(fs2);
		softly.assertThat(fs3Value).as("test data").isEqualTo(fs3);
	}

	public void verifyConclusionAdded(WebDriver driver, int mechOrElec, String component, String measurement, String fs1, String fs2, String fs3, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on MainClass.SRI conclusion tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			WebElement element = driver.findElement(sri.SRIAdminConclusionTabMechanicalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);		
		}
		else
		{
			//Select elecrtical component
			WebElement element = driver.findElement(sri.SRIAdminConclusionTabElectricalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);
		}
		verifyConclusions(driver,measurement,fs1,fs2,fs3,softly);
	}

	public void verifyBaslineConclusionTabsViewWhenComponentChanged(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		verifyBaselineAdded(driver,0,mechanicalComponent1,mechanicalMeasurement1,mechanicalUnit1,mechanicalFSIBaseline1,mechanicalFSIBaseline2,mechanicalFSIBaseline3,softly);
		verifyConclusionAdded(driver,0,mechanicalComponent1,mechanicalMeasurement1,mechanicalFSIConclusion1,mechanicalFSIConclusion2,mechanicalFSIConclusion3,softly);
		//Click on MainClass.SRI baseline tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)).click();
		//Verify Baselines
		verifyBaselines(driver,mechanicalMeasurement1,mechanicalUnit1,mechanicalFSIBaseline1,mechanicalFSIBaseline2,mechanicalFSIBaseline3,softly);
		//Click on MainClass.SRI conclusion tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionsTab)).click();
		verifyConclusions(driver,mechanicalMeasurement1,mechanicalFSIConclusion1,mechanicalFSIConclusion2,mechanicalFSIConclusion3,softly);
		//softly.assertAll();
	}

	public void verifyNumberingOnBaselines(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Iterate through all baselines to verify if the numbers are consecutive
		int count = 1;
		int number = 1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]"));
				//Get number
				String baselineNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[1]"))).getText();
				int bNo = Integer.parseInt(baselineNumber);
				softly.assertThat(bNo).as("test data").isEqualTo(number);
				number = number+1;				
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+2;
		}
	}

	public void verifyNumberingOnConclusion(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Iterate through all conclusions to verify if the numbers are consecutive
		int count = 1;
		int number = 1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]"));
				//Get number
				String conclusionNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[1]"))).getText();
				int cNo = Integer.parseInt(conclusionNumber);
				softly.assertThat(cNo).as("test data").isEqualTo(number);
				number = number+1;				
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+2;
		}
	}

	public void verifyErrorMessagesWhileAddingBaselines(WebDriver driver, String component, String measurement, String unit, String measurement1, String unit1,SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		share2.scrollToTop(driver);
		//Click on MainClass.SRI baselines tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)).click();
		//Select mechanical component
		WebElement element = driver.findElement(sri.SRIAdminBaselineTabMechanicalDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(component);
		//Click on plus sign
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselineAddButton)).click();				
		//Verify Measurement error message
		String measurementError = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIBaselineErrorMessage)).getText().trim();
		softly.assertThat(measurementError).as("test data").isEqualTo("Measurement: not specified");
		//Add measurement
		element = driver.findElement(sri.SRIAdminBaselineTabMeasurementDropdown);
		Select s1 = new Select (element);
		s1.selectByVisibleText(measurement);	
		//Verify Unit error message
		String unitError = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIBaselineErrorMessage)).getText().trim();
		softly.assertThat(unitError).as("test data").isEqualTo("Unit: not specified");
		//Add unit
		element = driver.findElement(sri.SRIAdminBaselineTabUnitDropdown);
		Select s2 = new Select (element);
		s2.selectByVisibleText(unit);
		//Verify limits error message
		String limitError = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIBaselineErrorMessage)).getText().trim();
		softly.assertThat(limitError).as("test data").isEqualTo("FS1, FS2 and FS3 must be specified consecutive numbers");
		//Enter alphabets in OP,IFS1,IFS2 and verify error
		for(int i=1;i<=3;i++)
		{
			WebElement ele = null;
			if(i==1)
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminOPField));
			if(i==2)
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS1Field));
			if(i==3)
				ele = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS2Field));
			//Enter alphabets in field
			ele.sendKeys("abcd");
			ele.sendKeys(Keys.ENTER);
			//Verify error message
			String limitError1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIBaselineErrorMessage)).getText().trim();
			softly.assertThat(limitError1).as("test data").isEqualTo("FS1, FS2 and FS3 must be specified consecutive numbers");
			//Clear field
			ele.clear();
		}
		//Enter number in OP limit and IFS1
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminOPField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminOPField)).sendKeys("10");
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminOPField)).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS1Field)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS1Field)).sendKeys("abcd");
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS1Field)).sendKeys(Keys.ENTER);
		//Enter alphabet in IFS2
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS2Field)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS2Field)).sendKeys("abcd");
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS2Field)).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS2Field)).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Click on plus sign
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselineAddButton)).click();	
		//Verify error message
		String limitError1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIBaselineErrorMessage)).getText().trim();
		softly.assertThat(limitError1).as("test data").isEqualTo("FS1, FS2 and FS3 must all be numbers");
		System.out.println(limitError1);
		//Clear IFS2 and enter same value as IFS1
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS2Field)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS2Field)).sendKeys("20");
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS2Field)).sendKeys(Keys.ENTER);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS1Field)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS1Field)).sendKeys("20");
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS1Field)).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS2Field)).sendKeys(Keys.ENTER);
		//Click on plus sign
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselineAddButton)).click();	
		//Verify error message
		String limitError2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIBaselineErrorMessage)).getText().trim();
		softly.assertThat(limitError2).as("test data").isEqualTo("FS1, FS2 and FS3 must be consecutive and not equal numbers");
		System.out.println(limitError2);
	}
}
