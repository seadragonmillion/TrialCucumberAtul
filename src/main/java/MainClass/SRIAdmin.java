package MainClass;

import java.util.ArrayList;
import java.util.List;

import PageObjects.CreateEquipPageObj;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SRIAdmin {

	SRIPageObj sri = new SRIPageObj();
	SRIAdmin2 sriA2 = new SRIAdmin2();
	SRIAdmin3 sriA3 = new SRIAdmin3();
	ShareCheck2 share2 = new ShareCheck2();
	Login login = new Login();
	ShareCheck share = new ShareCheck();
	CreateEquipPageObj equipObj = new CreateEquipPageObj();



	public void SRIAdminTest(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Get to MainClass.SRI Admin part
		getToSRIAdmin(driver);
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		//Delete all previous
		//Delete all mechanical
		//Click on MainClass.SRI
		int sum = deleteConclusionAdded(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1);
		sum = sum + deleteConclusionAdded(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement2);
		sum = sum + deleteBaselineAdded(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1,sriA2.mechanicalUnit1);
		sum = sum + deleteBaselineAdded(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement2,sriA2.mechanicalUnit2);
		sum = sum + sriA3.deleteUnitAdded(driver,sriA2.mechanicalMeasurement1,sriA2.mechanicalUnit1);
		sum = sum + sriA3.deleteUnitAdded(driver,sriA2.mechanicalMeasurement2,sriA2.mechanicalUnit2);
		sum = sum + sriA3.deleteMeasurementAdded(driver,sriA2.mechanicalMeasurement1,0);
		sum = sum + sriA3.deleteMeasurementAdded(driver,sriA2.mechanicalMeasurement2,0);
		sum = sum + deleteComponentAdded(driver,sriA2.mechanicalComponent1,0);
		System.out.println("printOut sum #47: "+sum);
		//Save
		if(sum>0)
			sriA2.saveChangedValues(driver,softly);
		sum = 0;
		//Delete all electrical
		sum = sum + deleteConclusionAdded(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement1);
		sum = sum + deleteConclusionAdded(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement2);
		sum = sum + deleteBaselineAdded(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement1,sriA2.electricalUnit1);
		sum = sum + deleteBaselineAdded(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement2,sriA2.electricalUnit2);
		sum = sum + sriA3.deleteUnitAdded(driver,sriA2.electricalMeasurement1,sriA2.electricalUnit1);
		sum = sum + sriA3.deleteUnitAdded(driver,sriA2.electricalMeasurement2,sriA2.electricalUnit2);
		sum = sum + sriA3.deleteMeasurementAdded(driver,sriA2.electricalMeasurement1,1);
		sum = sum + sriA3.deleteMeasurementAdded(driver,sriA2.electricalMeasurement2,1);
		sum = sum + deleteComponentAdded(driver,sriA2.electricalComponent1,1);
		System.out.println("printOut#63sum: "+sum);
		//Save
		if(sum>0)
			sriA2.saveChangedValues(driver,softly);
		//Mechanical
		//Add a component
		addSRIComponentInAdmin(driver,0,sriA2.mechanicalComponent1);
		//Add a measurement
		addSRIMeasurementInAdmin(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1,softly);
		//Add 2nd measurement
		addSRIMeasurementInAdmin(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement2,softly);
		//Add a unit
		addSRIUnitInAdmin(driver,sriA2.mechanicalMeasurement1,sriA2.mechanicalUnit1);
		//Add 2nd unit
		addSRIUnitInAdmin(driver,sriA2.mechanicalMeasurement2,sriA2.mechanicalUnit2);
		//Verify errors on baseline tab
		sriA2.verifyErrorMessagesWhileAddingBaselines(driver,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1,sriA2.mechanicalUnit1,sriA2.mechanicalMeasurement2,sriA2.mechanicalUnit2,softly);
		//Add a baseline
		addSRIBaselineInAdmin(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1,sriA2.mechanicalUnit1,sriA2.mechanicalFSIBaseline1,sriA2.mechanicalFSIBaseline2,sriA2.mechanicalFSIBaseline3);
		//Add 2nd baseline
		addSRIBaselineInAdmin(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement2,sriA2.mechanicalUnit2,sriA2.mechanicalFSIBaseline4,sriA2.mechanicalFSIBaseline5,sriA2.mechanicalFSIBaseline6);
		//Verify size of plus sign on basline tab when screen is made small
//		sriA3.verifySizeOfPlusSignBaselineTab(driver, softly, sriA2.mechanicalComponent1);
		//Add a conclusion
		addSRIConclusionInAdmin(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1,sriA2.mechanicalFSIConclusion1,sriA2.mechanicalFSIConclusion2,sriA2.mechanicalFSIConclusion3);
		//Add 2nd conclusion
		addSRIConclusionInAdmin(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement2,sriA2.mechanicalFSIConclusion1,sriA2.mechanicalFSIConclusion2,sriA2.mechanicalFSIConclusion3);
		//Save
		sriA2.saveChangedValues(driver,softly);
		//Verify all added values
		verifyComponentAdded(driver,sriA2.mechanicalComponent1,0,softly);
		verifyMeasurementAdded(driver,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1,0,softly);
		verifyMeasurementAdded(driver,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement2,0,softly);
		verifyUnitAdded(driver,sriA2.mechanicalMeasurement1,sriA2.mechanicalUnit1,softly);
		verifyUnitAdded(driver,sriA2.mechanicalMeasurement2,sriA2.mechanicalUnit2,softly);
		sriA2.verifyBaselineAdded(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1,sriA2.mechanicalUnit1,sriA2.mechanicalFSIBaseline1,sriA2.mechanicalFSIBaseline2,sriA2.mechanicalFSIBaseline3,softly);
		sriA2.verifyBaselineAdded(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement2,sriA2.mechanicalUnit2,sriA2.mechanicalFSIBaseline4,sriA2.mechanicalFSIBaseline5,sriA2.mechanicalFSIBaseline6,softly);
		//Verify the numbering in baselines
		sriA2.verifyNumberingOnBaselines(driver, softly);
		sriA2.verifyConclusionAdded(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1,sriA2.mechanicalFSIConclusion1,sriA2.mechanicalFSIConclusion2,sriA2.mechanicalFSIConclusion3,softly);
		sriA2.verifyConclusionAdded(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement2,sriA2.mechanicalFSIConclusion1,sriA2.mechanicalFSIConclusion2,sriA2.mechanicalFSIConclusion3,softly);
		//Verify the numbering in conclusions
		sriA2.verifyNumberingOnConclusion(driver, softly);
		//Electrical
		//Add a component
		addSRIComponentInAdmin(driver,1,sriA2.electricalComponent1);
		//Add a measurement
		addSRIMeasurementInAdmin(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement1,softly);
		//Add 2nd measurement
		addSRIMeasurementInAdmin(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement2,softly);
		//Add a unit
		addSRIUnitInAdmin(driver,sriA2.electricalMeasurement1,sriA2.electricalUnit1);
		//Add 2nd unit
		addSRIUnitInAdmin(driver,sriA2.electricalMeasurement2,sriA2.electricalUnit2);
		//Add a baseline
		addSRIBaselineInAdmin(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement1,sriA2.electricalUnit1,sriA2.electricalFSIBaseline1,sriA2.electricalFSIBaseline2,sriA2.electricalFSIBaseline3);
		//Add 2nd baseline
		addSRIBaselineInAdmin(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement2,sriA2.electricalUnit2,sriA2.electricalFSIBaseline4,sriA2.electricalFSIBaseline5,sriA2.electricalFSIBaseline6);
		//Add a conclusion
		addSRIConclusionInAdmin(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement1,sriA2.electricalFSIConclusion1,sriA2.electricalFSIConclusion2,sriA2.electricalFSIConclusion3);
		//Add 2nd conclusion
		addSRIConclusionInAdmin(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement2,sriA2.electricalFSIConclusion1,sriA2.electricalFSIConclusion2,sriA2.electricalFSIConclusion3);
		//Save
		sriA2.saveChangedValues(driver,softly);
		//Verify all added values
		verifyComponentAdded(driver,sriA2.electricalComponent1,1,softly);
		verifyMeasurementAdded(driver,sriA2.electricalComponent1,sriA2.electricalMeasurement1,1,softly);
		verifyMeasurementAdded(driver,sriA2.electricalComponent1,sriA2.electricalMeasurement2,1,softly);
		verifyUnitAdded(driver,sriA2.electricalMeasurement1,sriA2.electricalUnit1,softly);
		verifyUnitAdded(driver,sriA2.electricalMeasurement2,sriA2.electricalUnit2,softly);
		sriA2.verifyBaselineAdded(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement1,sriA2.electricalUnit1,sriA2.electricalFSIBaseline1,sriA2.electricalFSIBaseline2,sriA2.electricalFSIBaseline3,softly);
		sriA2.verifyBaselineAdded(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement2,sriA2.electricalUnit2,sriA2.electricalFSIBaseline4,sriA2.electricalFSIBaseline5,sriA2.electricalFSIBaseline6,softly);
		//Verify the numbering in baselines
		sriA2.verifyNumberingOnBaselines(driver, softly);
		sriA2.verifyConclusionAdded(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement1,sriA2.electricalFSIConclusion1,sriA2.electricalFSIConclusion2,sriA2.electricalFSIConclusion3,softly);
		sriA2.verifyConclusionAdded(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement2,sriA2.electricalFSIConclusion1,sriA2.electricalFSIConclusion2,sriA2.electricalFSIConclusion3,softly);
		//Verify the numbering in conclusions
		sriA2.verifyNumberingOnConclusion(driver, softly);
		//Verify the previous data is shown when the componen is changed in Conclusion and baseline tabs
		sriA2.verifyBaslineConclusionTabsViewWhenComponentChanged(driver, softly);
		//Go to KALE homepage
		wait.until(ExpectedConditions.visibilityOfElementLocated(equipObj.KaleHomePage)).click();
		/*	//bug needs to be fixed
		login.logout(driver);
		driver.switchTo().defaultContent();
		login.LoginUser(driver, username, password);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));*/
	}

	public void deleteAll(WebDriver driver, SoftAssertions softly) throws Exception {

		//Get to MainClass.SRI Admin part
		getToSRIAdmin(driver);
		//Change conclusion and verify save
		sriA2.changeConclusion(driver,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1,softly);
		//remove Unit Verify Part2 Under Basline Vanishes
		sriA2.removeUnitVerifyPart2UnderBaslineVanishes(driver,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1,sriA2.mechanicalMeasurement2,sriA2.mechanicalUnit1,sriA2.mechanicalUnit2,softly);
		//Verify error message for adding duplicate component and measurement names
		sriA3.verifyErrorMessageForSameNameElements(driver, softly, sriA2.electricalComponent1, sriA2.electricalMeasurement1,sriA2.electricalUnit1);
		//Delete all mechanical
		deleteConclusionAdded(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1);
		//deleteConclusionAdded(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement2);
		//deleteBaselineAdded(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement1,sriA2.mechanicalUnit1);
		//deleteBaselineAdded(driver,0,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement2,sriA2.mechanicalUnit2);
		//sriA2.deleteUnitAdded(driver,sriA2.mechanicalMeasurement1,sriA2.mechanicalUnit1);
		//sriA2.deleteUnitAdded(driver,sriA2.mechanicalMeasurement2,sriA2.mechanicalUnit2);
		sriA3.deleteMeasurementAdded(driver,sriA2.mechanicalMeasurement1,0);
		//sriA2.deleteMeasurementAdded(driver,sriA2.mechanicalComponent1,sriA2.mechanicalMeasurement2,0);
		deleteComponentAdded(driver,sriA2.mechanicalComponent1,0);
		//Save
		sriA2.saveChangedValues(driver,softly);
		sriA3.verifyAppearanceOfMissingValuesInBaseline(driver, softly, sriA2.electricalComponent1,sriA2.electricalMeasurement1,sriA2.electricalUnit1);
		//Delete all electrical
		deleteConclusionAdded(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement1);
		deleteConclusionAdded(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement2);
		deleteBaselineAdded(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement1,sriA2.electricalUnit1);
		deleteBaselineAdded(driver,1,sriA2.electricalComponent1,sriA2.electricalMeasurement2,sriA2.electricalUnit2);
		sriA3.deleteUnitAdded(driver,sriA2.electricalMeasurement1,sriA2.electricalUnit1);
		sriA3.deleteUnitAdded(driver,sriA2.electricalMeasurement2,sriA2.electricalUnit2);
		sriA3.deleteMeasurementAdded(driver,sriA2.electricalMeasurement1,1);
		sriA3.deleteMeasurementAdded(driver,sriA2.electricalMeasurement2,1);
		deleteComponentAdded(driver,sriA2.electricalComponent1,1);
		//Save
		sriA2.saveChangedValues(driver,softly);
	}

	public int deleteComponentAdded(WebDriver driver, String component, int mechOrElec) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,2);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		share2.scrollToTop(driver);
		//Click on MainClass.SRI components tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTab)).click();
		Thread.sleep(1000);
		for(int i=0;i<10;i++)
		{
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabMechanicalOption));
				break;
			}catch(org.openqa.selenium.WebDriverException r)
			{
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTab)));
				Thread.sleep(1000);
			}
		}
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Click on MainClass.SRI components tab mechanical option
			jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabMechanicalOption)));
		}
		else
		{
			//Click on MainClass.SRI components tab electrical option
			jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabElectricalOption)));
		}
		//Count number of components
		int count=1;
		int deleted = 0;
		while(true)
		{
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-components-table']/tbody/tr["+count+"]")));
				String componentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-components-table']/tbody/tr["+count+"]/td[2]/div/input"))).getAttribute("value");
				if(componentName.equals(component))
				{
					//delete measurement
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-components-table']/tbody/tr["+count+"]/td[4]/a"))));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-components-table']/tbody/tr["+count+"]/td[4]/a"))));
					//Delete confirm button
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)));
					//share2.loadingServer(driver);
					deleted = 1;
				}
			}catch(org.openqa.selenium.TimeoutException e)
			{
				break;
			}
			count=count+2;
		}
		if(deleted == 1)
			return 1;
		else return 0;
	}

	public int deleteBaselineAdded(WebDriver driver, int mechOrElec, String component, String measurement, String unit) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,2);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on MainClass.SRI baseline tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselinesTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			try{
				WebElement element = driver.findElement(sri.SRIAdminBaselineTabMechanicalDropdown);
				Select s = new Select (element);
				s.selectByVisibleText(component);	
			}catch(org.openqa.selenium.NoSuchElementException r)
			{
				return 0;
			}
		}
		else
		{
			//Select elecrtical component
			try{
				WebElement element = driver.findElement(sri.SRIAdminBaselineTabElectricalDropdown);
				Select s = new Select (element);
				s.selectByVisibleText(component);
			}catch(org.openqa.selenium.NoSuchElementException r)
			{
				return 0;
			}
		}
		Thread.sleep(500);
		//Delete all baselines under the component+measurement+unit combination
		int count=1;
		while(true)
		{
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]")));
				//Get unit name
				String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[3]/div/div/span"))).getText();
				//Get Measurement name
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[2]/div/div/span"))).getText();
				if(measurementName.equals(measurement))
				{
					if(unitName.equals(unit))
					{
						//delete baseline
						share2.scrollToElement(driver, driver.findElement(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[7]/a")));
						jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[7]/a"))));
						System.out.println("printOut count for delete baseline xpath: "+count);
						jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr["+count+"]/td[7]/a"))));
						//Delete confirm button
						jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)));
						//share2.loadingServer(driver);
					}
				}
			}catch(org.openqa.selenium.TimeoutException e)
			{
				break;
			}
			count=count+2;
		}
		return 1;
	}

	public int deleteConclusionAdded(WebDriver driver, int mechOrElec, String component, String measurement) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,2);
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
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			try{
				WebElement element = driver.findElement(sri.SRIAdminConclusionTabMechanicalDropdown);
				Select s = new Select (element);
				s.selectByVisibleText(component);	
			}catch(org.openqa.selenium.NoSuchElementException r)
			{
				return 0;
			}
		}
		else
		{
			//Select elecrtical component
			try{
				WebElement element = driver.findElement(sri.SRIAdminConclusionTabElectricalDropdown);
				Select s = new Select (element);
				s.selectByVisibleText(component);
			}catch(org.openqa.selenium.NoSuchElementException r)
			{
				return 0;
			}
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
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]")));
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[2]/div/div/span"))).getText();
				if(measurementName.equals(measurement))
				{
					//delete conclusion
					share2.scrollToElement(driver, driver.findElement(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[6]/a")));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr["+count+"]/td[6]/a"))));
					Thread.sleep(500);
					//Delete confirm button
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminPopupConfirmButton)));
					//share2.loadingServer(driver);
				}
			}catch(org.openqa.selenium.TimeoutException e)
			{
				break;
			}
			count=count+2;
		}
		return 1;
	}

	public void verifyComponentAdded(WebDriver driver, String component, int mechOrElec, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List<String> componentList = new ArrayList<String>();
		//Click on MainClass.SRI components tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Click on MainClass.SRI components tab mechanical option
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabMechanicalOption)).click();
		}
		else
		{
			//Click on MainClass.SRI components tab electrical option
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabElectricalOption)).click();
		}
		//Count number of components
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-components-table']/tbody/tr["+count+"]"));
				String componentName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-components-table']/tbody/tr["+count+"]/td[2]/div/input"))).getAttribute("value");
				componentList.add(componentName);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+2;
		}
		//Go through all components to check if added component is present
		softly.assertThat(component).as("test data").isIn(componentList);
	}

	public void verifyMeasurementAdded(WebDriver driver, String component, String measurement, int mechOrElec, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List<String> measurementList = new ArrayList<String>();
		//Click on MainClass.SRI measurement tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Select mechanical component
			WebElement element = driver.findElement(sri.SRIAdminMeasurementTabMechanicalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);		
		}
		else
		{
			//Select electrical component
			WebElement element = driver.findElement(sri.SRIAdminMeasurementTabElectricalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);
		}
		//Count number of measurements
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]"));
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				measurementList.add(measurementName);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+2;
		}
		//Go through all measurements to check if added component is present
		softly.assertThat(measurement).as("test data").isIn(measurementList);
		//Verify the checkmark on the measurement
		count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]"));
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				if(measurementName.equals(measurement))
				{
					if(driver.findElement(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[2]/div/input")).isSelected()==false)
						softly.fail("Measurement: "+measurement+" not selected for component: "+component);
					else
						break;
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+2;
		}

	}

	public void verifyUnitAdded(WebDriver driver, String measurement, String unit, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List<String> unitList = new ArrayList<String>();
		//Click on MainClass.SRI units tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitsTab)).click();
		//Select measurement
		WebElement element = driver.findElement(sri.SRIAdminUnitTabMeasurementDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(measurement);	
		//Count number of units
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]"));
				String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				unitList.add(unitName);
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+2;
		}
		//Go through all units to check if added component is present
		softly.assertThat(unit).as("test data").isIn(unitList);
		//Verify the checkmark on the unit
		count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]"));
				String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				if(unitName.equals(unit))
				{
					if(driver.findElement(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[2]/div/input")).isSelected()==false)
						softly.fail("Unit: "+unit+" not selected for measurement: "+measurement);
					else
						break;
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+2;
		}

	}

	public void getToSRIAdmin(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		login.closePopUpSticky(driver);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.LoginNameOnTop)).click();
		//Click on Admin
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.AdminOption)).click();
		//Click on Analysis
		if(driver.findElement(sri.SRISideLink).isDisplayed()==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.AnalysisSideLink)).click();
		//Click on MainClass.SRI
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISideLink)).click();
		share2.loadingServer(driver);
	}

	public void addSRIComponentInAdmin(WebDriver driver, int mechOrElec, String component) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		share2.scrollToTop(driver);
		//Click on MainClass.SRI components tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTab)).click();
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Click on MainClass.SRI components tab mechanical option
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabMechanicalOption)).click();
			//Enter english name
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentNameFieldEnglish)).sendKeys(component);
		}
		else
		{
			//Click on MainClass.SRI components tab electrical option
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentsTabElectricalOption)).click();
			//Enter english name
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentNameFieldEnglish)).sendKeys(component);
		}
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminComponentAddButton)).click();		
	}

	public void addSRIMeasurementInAdmin(WebDriver driver, int mechOrElec, String component, String measurement, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		share2.scrollToTop(driver);
		//Click on MainClass.SRI measurement tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementTab)).click();
		String label1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameLabel)).getText();
		softly.assertThat(label1).as("test data").isEqualTo("Measurement name:");
		/* 0 = Mechanical
		 * 1 = Electrical
		 */
		if(mechOrElec==0)
		{
			//Enter english name
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameFieldEnglish)).sendKeys(measurement);
			//Select mechanical component
			WebElement element = driver.findElement(sri.SRIAdminMeasurementTabMechanicalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);		
		}
		else
		{
			//Enter english name
			wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementNameFieldEnglish)).sendKeys(measurement);
			//Select elecrtical component
			WebElement element = driver.findElement(sri.SRIAdminMeasurementTabElectricalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);
		}
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminMeasurementAddButton)).click();	
		//Select added measurement
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]"));
				System.out.println("printOut count"+count);
				String measurementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				System.out.println("printOut measurementName:  "+measurementName);
				if(measurementName.equals(measurement))
				{
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[2]/div/input"))));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-meas-table']/tbody/tr["+count+"]/td[2]/div/input"))));
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+2;
		}
	}

	public void addSRIUnitInAdmin(WebDriver driver, String measurement, String unit) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		share2.scrollToTop(driver);
		//Click on MainClass.SRI units tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitsTab)).click();
		//Enter unit
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitName)).sendKeys(unit);
		//Select measurement
		WebElement element = driver.findElement(sri.SRIAdminUnitTabMeasurementDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(measurement);				
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminUnitAddButton)).click();		
		//Select added unit
		int count=1;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]"));
				String unitName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[3]/div/input"))).getAttribute("value");
				if(unitName.equals(unit))
				{
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[2]/div/input"))));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-asri-unit-table']/tbody/tr["+count+"]/td[2]/div/input"))));
				}
			}catch(org.openqa.selenium.NoSuchElementException e)
			{
				break;
			}
			count=count+2;
		}
	}

	public void addSRIBaselineInAdmin(WebDriver driver, int mechOrElec, String component, String measurement, String unit, String fs1, String fs2, String fs3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		share2.scrollToTop(driver);
		//Click on MainClass.SRI baselines tab
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
			//Select elecrtical component
			WebElement element = driver.findElement(sri.SRIAdminBaselineTabElectricalDropdown);
			Select s = new Select (element);
			s.selectByVisibleText(component);
		}
		//Select measurement
		WebElement element = driver.findElement(sri.SRIAdminBaselineTabMeasurementDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(measurement);	
		//Select unit
		WebElement element1 = driver.findElement(sri.SRIAdminBaselineTabUnitDropdown);
		Select s1 = new Select (element1);
		s1.selectByVisibleText(unit);	
		//Enter FS1
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminOPField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminOPField)).sendKeys(fs1);
		//Enter FS2
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS1Field)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS1Field)).sendKeys(fs2);
		//Enter FS3
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS2Field)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminIFS2Field)).sendKeys(fs3);
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminBaselineAddButton)).click();		
	}

	public void addSRIConclusionInAdmin(WebDriver driver, int mechOrElec, String component, String measurement, String fs1Conclusion, String fs2Conclusion, String fs3Conclusion) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		share2.scrollToTop(driver);
		login.closePopUpSticky(driver);
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
		//Select measurement
		WebElement element = driver.findElement(sri.SRIAdminConclusionTabMeasurementDropdown);
		Select s = new Select (element);
		s.selectByVisibleText(measurement);	
		//Enter FS1 Conclusion
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminFS1ConclusionField)).sendKeys(fs1Conclusion);
		//Enter FS2 Conclusion
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminFS2ConclusionField)).sendKeys(fs2Conclusion);
		//Enter FS3 Conclusion
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminFS3ConclusionField)).sendKeys(fs3Conclusion);
		//Click on add button
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIAdminConclusionAddButton)).click();		
	}

}
