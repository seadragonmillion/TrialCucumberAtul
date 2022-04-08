import kaleTestSoftware.*;
import kaleTestSoftware.ErrorMeter2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ErrorMeter3 {

	ErrorMeter2 em2 = new ErrorMeter2 ();
	ErrorMeterPageObj emObj = new ErrorMeterPageObj();
	EiRCA2 ec2 = new EiRCA2();
	EiRCAPageObj eircaObj = new EiRCAPageObj();
	ShareCheck2 share2 = new ShareCheck2();

	public void verifyGuideOnPAPEPage(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on  Guide
		wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterGuideLink)).click();
		//Verify PAPE
		String p=wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterGuideParagraph3Label)).getText();
		softly.assertThat(p).as("test data").contains("PAPE");
		softly.assertThat(p).as("test data").doesNotContain("TAPE");
		//Click on Guide
		wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterGuideLink)).click();
	}

	public void clickElementForSafariBrowser (WebDriver driver, By locator) throws Exception {		

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
	}

	public void verifyCheckBoxChecked (WebDriver driver, By locator) throws Exception {		

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		while(true)
		{
			Thread.sleep(500);
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected())
				break;
			Thread.sleep(1000);
			executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
			Thread.sleep(1000);
		}	
		System.out.println("done");
	}

	public void verifyCheckBoxNotChecked (WebDriver driver, By locator) throws Exception {		

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		while(true)
		{
			Thread.sleep(500);
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected()==false)
				break;
			executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
			Thread.sleep(1000);
		}		
		System.out.println("done2");
	}

	public String decideSharer (int y) throws Exception{

		/* Dev/Asia
		 * 0=admin
		 * 1=non admin
		 * 2= admin ie11
		 * 3= non admin ie11
		 * US
		 * 4=admin
		 * 5=non admin
		 * 6=admin ie11
		 * 7=non admin ie11
		 */
		if(y==0)
		{
			String sharer ="qaasharer";
			return sharer;
		}
		if(y==1)
		{
			String sharer ="qaasharernonadmin";
			return sharer;
		}
		if(y==2)
		{
			String sharer ="qaasharerie11";
			return sharer;
		}
		if(y==3)
		{
			String sharer ="qaasharernonadminie11";
			return sharer;
		}
		if(y==4)
		{
			String sharer ="qaasharerus";
			return sharer;
		}
		if(y==5)
		{
			String sharer ="qaasharernonadminus";
			return sharer;
		}
		if(y==6)
		{
			String sharer ="qaasharerusie11";
			return sharer;
		}
		else
		{
			String sharer ="qaasharernonadminusie11";
			return sharer;
		}

	}

	public String decideSharerAdded (int y) throws Exception{

		/* Dev/Asia
		 * 0=admin
		 * 1=non admin
		 * 2= admin ie11
		 * 3= non admin ie11
		 * US
		 * 4=admin
		 * 5=non admin
		 * 6=admin ie11
		 * 7=non admin ie11
		 */
		if(y==0)
		{
			String sharer ="QAA (qaasharer)";
			return sharer;
		}
		if(y==1)
		{
			String sharer ="QAA (qaasharernonadmin)";
			return sharer;
		}
		if(y==2)
		{
			String sharer ="QAA (qaasharerie11)";
			return sharer;
		}
		if(y==3)
		{
			String sharer ="QAA (qaasharernonadminie11)";
			return sharer;
		}
		if(y==4)
		{
			String sharer ="QAA (qaasharerus)";
			return sharer;
		}
		if(y==5)
		{
			String sharer ="QAA (qaasharernonadminus)";
			return sharer;
		}
		if(y==6)
		{
			String sharer ="QAA (qaasharerusie11)";
			return sharer;
		}
		else
		{
			String sharer ="QAA (qaasharernonadminusie11)";
			return sharer;
		}
	}

	public void verifyChangeOfTabTitleWhenScreenIsSmall(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Set new size to make it small
//		driver.manage().window().setSize(new Dimension(650,900));
		//Verify tab titles
		//E
		String e = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentTab)).getText();
		softly.assertThat(e).as("test data").isEqualTo("E");
		//P
		String pr = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEPeopleTab)).getText();
		softly.assertThat(pr).as("test data").isEqualTo("P");
		//A
		String a = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEActivityTab)).getText();
		softly.assertThat(a).as("test data").isEqualTo("A");
		//P
		String p = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEProcedureTab)).getText();
		softly.assertThat(p).as("test data").isEqualTo("P");
		//Set window to maximise
		driver.manage().window().maximize();
		//softly.assertAll();
	}

	public int getCharCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(emObj.JobTitleCharacterCount).getText().trim();
		s=s.substring(1,s.indexOf("/"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public int getTotalCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(emObj.JobTitleCharacterCount).getText();
		s=s.substring((s.indexOf("/")+1), s.indexOf(")"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public void errorMeterFillFirstPage(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on Analysis 
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(eircaObj.AnalysisLink)).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on SPV Error meter
		wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterLink)).click();
		Thread.sleep(2000);
		//Verify text in Env tab Job type= Construction 
		verifyTextEnvironmentTabJobTypeConstruction(driver,softly);
		//verify new report popup
		verifyNewReportPopup(driver,softly);
		share2.loadingServer(driver);
		//Select Purpose from dropdown
		WebElement element = driver.findElement(emObj.ErrorMeterPurpose);
		Select s = new Select (element);
		s.selectByVisibleText("PJB");
		Thread.sleep(2000);
		//Select Job type
		element = driver.findElement(emObj.ErrorMeterJobType);
		Select s1 = new Select (element);
		if(driver.getCurrentUrl().contains("kaleqa"))
			s1.selectByVisibleText("Analysis");
		else
			s1.selectByVisibleText("Construction");
		Thread.sleep(2000);
		//Fills Job title
		wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterJobTitle)).sendKeys(ec2.textCreate(driver));
		/*	String ev1= driver.findElement(emObj.ErrorMeterJobTitle).getAttribute("value");
		if(ev1.equals(ec2.textCreate(driver))==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterJobTitle)).sendKeys(ec2.textCreate(driver));*/
		//Get count
		int count = getCharCountFromTitle(driver);
		int total = getTotalCountFromTitle(driver);
		for(int i=count+1;i<=total;i++)
		{
			driver.findElement(emObj.ErrorMeterJobTitle).sendKeys("z");
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterJobTitle)).sendKeys(Keys.ENTER);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterNextButton)).click();
		Thread.sleep(2000);
	}

	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterNewButton)).click();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("New Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Would you like to confirm you want to erase the current report and create a new report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: erased content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("new report");
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPopupConfirmButton)).click();
	}

	public void verifyFinalizeReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Finalize Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save and finalize current report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Note: later, saved data can be seen by clicking \"saved activities\" button.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("save & finalize");
	}

	public void verifyTextEnvironmentTabJobTypeConstruction(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Select Purpose from dropdown
		WebElement element = driver.findElement(emObj.ErrorMeterPurpose);
		Select s = new Select (element);
		s.selectByVisibleText("PJB");
		Thread.sleep(2000);
		//Select Job type
		element = driver.findElement(emObj.ErrorMeterJobType);
		Select s1 = new Select (element);
		s1.selectByVisibleText("Construction");
		Thread.sleep(2000);
		//Fills Job title
		wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterJobTitle)).sendKeys(ec2.textCreate(driver));
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterNextButton)).click();
		Thread.sleep(2000);
		//Click on Environment of PAPE
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentTab)).click();		
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(emObj.ErrorMeterPAPEEnvironmentTabRow3Question)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Are there weather effects like rain, snow or typhoon?");
	}
}