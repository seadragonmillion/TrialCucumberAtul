package MainClass;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import PageObjects.EiRCAV2PageObj;
import PageObjects.LoginPageObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EiRCAV2_5 {

	EiRCAV2PageObj eirca = new EiRCAV2PageObj();
	ShareCheck2 share2 = new ShareCheck2();
	LoginPageObj login = new LoginPageObj();
	
	public void verifyPopupStep8NoneConfirmed(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//next
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
		//Wait for popup
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("None Confirmed");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Since none of the failure modes are confirmed, do you want to see report now or modify failure modes?");
		//Verify question on pop up
		String s1a = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopUpMessageNote)).getText();
		softly.assertThat(s1a).as("test data").isEqualTo("Modify failure modes: add failure modes or review their test results.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("see report");
		//Modify button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("modify failure modes");
		//Modify button
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton2)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("confirm existing failure mode");
		//Confirm existing failure mode
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAPopupConfirmButton2)).click();
	}

	public void EiRCAStep8 (WebDriver driver, SoftAssertions softly, HashMap<String,String> step7, String text, int n5, List<String> step3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Verify popup
		verifyPopupStep8NoneConfirmed(driver,softly);
//		softly.assertAll();
		//Verify the table is correct from Step 7
		String fm1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step8TableFailureModeRow1Column1)).getText();
		String rv1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step8TableProbabilityRankingRow1Column2)).getText();
		String fm2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step8TableFailureModeRow2Column1)).getText();
		String rv2 = driver.findElement(eirca.Step8TableProbabilityRankingRow2Column2).getText();
		String fm3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step8TableFailureModeRow3Column1)).getText();
		String rv3 = driver.findElement(eirca.Step8TableProbabilityRankingRow3Column2).getText();
		if(n5==0){
			String fm4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step8TableFailureModeRow4Column1)).getText();
			String rv4 = driver.findElement(eirca.Step8TableProbabilityRankingRow4Column2).getText();
			softly.assertThat(rv4).as("test data").isEqualTo(step7.get(fm4));
		}
		softly.assertThat(rv1).as("test data").isEqualTo(step7.get(fm1));
		softly.assertThat(rv2).as("test data").isEqualTo(step7.get(fm2));
		softly.assertThat(rv3).as("test data").isEqualTo(step7.get(fm3));
		//Select all Failure modes
		int totalFms = 3+step3.size();
		for(int i=1;i<=totalFms;i++)
		{
//		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-8']/table/tbody/tr["+i+"]/td[5]/div/input"))));
			jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-8']/table/tbody/tr["+i+"]/td[5]/div/input"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-8']/table/tbody/tr["+i+"]/td[5]/div/input"))));
			//Fill text
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-8']/table/tbody/tr["+i+"]/td[4]/textarea"))).sendKeys(text);
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-8']/table/tbody/tr["+i+"]/td[1]"))).getText();
			if(n5>0) 
				softly.assertThat(s).as("test data").doesNotContain("Sanity Test \"title\" Sanity1");
		}
		if(n5==0)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-8']/table/tbody/tr["+(totalFms+1)+"]/td[5]/div/input"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-8']/table/tbody/tr["+(totalFms+1)+"]/td[4]/textarea"))).sendKeys(text);
		}
		//next
		share2.scrollToTop(driver);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).click();
	}

	public HashMap<String,String> EiRCAStep7 (WebDriver driver, SoftAssertions softly, String text, int n5, List<String> step3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//total number of fms
		int addedFM;
		int startFM;
		if(n5==0) {
			addedFM = 4;
			startFM = 0;
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-7']/div[2]/h4/a"))).getText();
			softly.assertThat(s).as("test data").contains("Sanity Test \"title\" Sanity1");
		}
		else {
			addedFM = 3;
			startFM = 1;
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-7']/div[2]/h4/a"))).getText();
			softly.assertThat(s).as("test data").contains("Sanity Test \"title\" Sanity2");
		}
		int totalFms = addedFM+step3.size();
		//Verify probability rankings are blank
		for(int fm=1;fm<=totalFms;fm++)
		{
			String rankingValue = driver.findElement(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+fm+"]/td[2]/span")).getText();
			verifyProbabilityRankinfForFailureMode(rankingValue,0,softly);
		}
		//Select ranking for all
		for(int fm=0;fm<totalFms;fm++)
		{
			//Click on collapsible
			jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-7']/div["+(fm+2)+"]/h4/a"))));
//		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-7']/div["+(fm+2)+"]/h4/a"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-7']/div["+(fm+2)+"]/h4/a"))));
			//Get name of failure mode 
			String fmName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-7']/div["+(fm+2)+"]/h4/a/span[1]"))).getText();
			//text verify for 4th point components
			if(fm==0)verify4thPointComponents(driver,softly,n5);
			//Choose a number from 0 to 7 for number of boxes to click
			Random random = new Random();
			int n = random.nextInt(8);
			//Click random checkboxes and match the score
			int sumOfPoints = 0;	
			for(int i=0;i<=n;i++){
				int checkNum = random.nextInt(8);
				By locator;
				switch(checkNum){
				case 0:{
					/*if(n5==0)
						locator = eirca.Step7FailureMode1Checkbox1;
					else
						locator = eirca.Step7FailureMode2Checkbox1;*/
					locator = By.xpath(".//*[@id='pii-ircam2-t7-fm-"+(fm+startFM)+"-condtable']/table/tbody/tr[1]/td[2]/div/input");
					jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
//				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected())
						sumOfPoints+=5;
					else sumOfPoints-=5;
				}
				case 1:{
					/*if(n5==0)
						locator = eirca.Step7FailureMode1Checkbox2;
					else
						locator = eirca.Step7FailureMode2Checkbox2;*/
					locator = By.xpath(".//*[@id='pii-ircam2-t7-fm-"+(fm+startFM)+"-condtable']/table/tbody/tr[2]/td[2]/div/input");
					jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
//				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected())
						sumOfPoints+=4;
					else sumOfPoints-=4;
				}
				case 2:{
					/*if(n5==0)
						locator = eirca.Step7FailureMode1Checkbox3;
					else
						locator = eirca.Step7FailureMode2Checkbox3;*/
					locator = By.xpath(".//*[@id='pii-ircam2-t7-fm-"+(fm+startFM)+"-condtable']/table/tbody/tr[3]/td[2]/div/input");
					jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					//				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected())
						sumOfPoints+=3;
					else sumOfPoints-=3;
				}
				case 3:{
					/*if(n5==0)
						locator = eirca.Step7FailureMode1Checkbox4;
					else
						locator = eirca.Step7FailureMode2Checkbox4;*/
					locator = By.xpath(".//*[@id='pii-ircam2-t7-fm-"+(fm+startFM)+"-condtable']/table/tbody/tr[4]/td[2]/div/input");
					jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					//				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected())
						sumOfPoints+=3;
					else sumOfPoints-=3;
				}
				case 4:{
					/*if(n5==0)
						locator = eirca.Step7FailureMode1Checkbox5;
					else
						locator = eirca.Step7FailureMode2Checkbox5;*/
					locator = By.xpath(".//*[@id='pii-ircam2-t7-fm-"+(fm+startFM)+"-condtable']/table/tbody/tr[5]/td[2]/div/input");
					jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					//				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected())
						sumOfPoints+=2;
					else sumOfPoints-=2;
				}
				case 5:{
					/*if(n5==0)
						locator = eirca.Step7FailureMode1Checkbox6;
					else
						locator = eirca.Step7FailureMode2Checkbox6;*/
					locator = By.xpath(".//*[@id='pii-ircam2-t7-fm-"+(fm+startFM)+"-condtable']/table/tbody/tr[6]/td[2]/div/input");
					jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					//				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected())
						sumOfPoints+=2;
					else sumOfPoints-=2;
				}
				case 6:{
					/*if(n5==0)
						locator = eirca.Step7FailureMode1Checkbox7;
					else
						locator = eirca.Step7FailureMode2Checkbox7;*/
					locator = By.xpath(".//*[@id='pii-ircam2-t7-fm-"+(fm+startFM)+"-condtable']/table/tbody/tr[7]/td[2]/div/input");
					jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					//				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected())
						sumOfPoints+=1;
					else sumOfPoints-=1;
				}
				case 7:{
					/*if(n5==0)
						locator = eirca.Step7FailureMode1Checkbox8;
					else
						locator = eirca.Step7FailureMode2Checkbox8;*/
					locator = By.xpath(".//*[@id='pii-ircam2-t7-fm-"+(fm+startFM)+"-condtable']/table/tbody/tr[8]/td[2]/div/input");
					jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					//				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected())
						sumOfPoints-=1;
					else sumOfPoints+=1;
				}			
				}	
				//Verify probability ranking
				verifyTotalProbability(driver,fmName,totalFms,sumOfPoints,softly);
				/*if(sumOfPoints<0)
				{
					if(n5==0)
						locator = eirca.Step7ProbabilityTableProbabilityRankingRow4Column2;
					else
						locator = eirca.Step7ProbabilityTableProbabilityRankingRow3Column2;
					verifyTotalProbability(driver,fmName,totalFms,sumOfPoints,softly);
				}
				else{
					String rankingValue1 = driver.findElement(eirca.Step7ProbabilityTableProbabilityRankingRow1Column2).getText();
					verifyProbabilityRankinfForFailureMode(rankingValue1,sumOfPoints,softly);
				}*/
			}
			//Verify total probability ranking
			verifyTotalProbability(driver,fmName,totalFms,sumOfPoints,softly);
			/*if(sumOfPoints<0)
			{
				By locator;
				if(n5==0)
					locator = eirca.Step7ProbabilityTableProbabilityRankingRow4Column2;
				else
					locator = eirca.Step7ProbabilityTableProbabilityRankingRow3Column2;
				String rankingValue1 = driver.findElement(locator).getText();
				verifyProbabilityRankinfForFailureMode(rankingValue1,sumOfPoints,softly);
			}
			else{
				String rankingValue1 = driver.findElement(eirca.Step7ProbabilityTableProbabilityRankingRow1Column2).getText();
				verifyProbabilityRankinfForFailureMode(rankingValue1,sumOfPoints,softly);
			}*/
			//Click on collapsible
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-7']/div["+(fm+2)+"]/h4/a"))));
//			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-7']/div["+(fm+2)+"]/h4/a"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-tab-7']/div["+(fm+2)+"]/h4/a"))));
		}
		//Fill text in text boxes
		for(int i=1;i<=totalFms;i++)
		{
			jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[3]/textarea"))));
//		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[3]/textarea"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[3]/textarea"))).sendKeys(text);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[4]/div/textarea[1]"))).sendKeys(text);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[4]/div/textarea[2]"))).sendKeys(text);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[4]/div/textarea[3]"))).sendKeys(text);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[5]/div/textarea[1]"))).sendKeys(text);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[5]/div/textarea[2]"))).sendKeys(text);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[5]/div/textarea[3]"))).sendKeys(text);
		}		
		//Store data in hashmap
		HashMap<String,String> step7 = storeDataFromTableStep7(driver,n5,totalFms);
		//next
		share2.scrollToTop(driver);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)));
		return step7;
	}
	
	public void verifyTotalProbability(WebDriver driver, String fmName, int totalFms, int sumOfPoints, SoftAssertions softly) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		for(int i=1;i<=totalFms;i++){
			String f = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[1]"))).getText();
			System.out.println("**"+f+"**");
			System.out.println("**"+fmName+"**");
			if(f.equals(fmName))
			{
				String rv = driver.findElement(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[2]/span")).getText();
				verifyProbabilityRankinfForFailureMode(rv,sumOfPoints,softly);
				break;
			}
		}
	}

	public void verifyProbabilityRankinfForFailureMode(String rankingValue, int sumOfPoints, SoftAssertions softly) throws Exception {

		System.out.println("Points step 7: "+sumOfPoints);
		System.out.println("Rank step 7: "+rankingValue);
		if(sumOfPoints==0 && rankingValue ==""){
			softly.assertThat(rankingValue).isEmpty();
		}
		if(sumOfPoints>5){
			softly.assertThat(rankingValue).isEqualTo("Very High");
		}		
		if(sumOfPoints<=5 && sumOfPoints>=4){
			softly.assertThat(rankingValue).isEqualTo("High");
		}		
		if(sumOfPoints<=3 && sumOfPoints>=2){
			softly.assertThat(rankingValue).isEqualTo("Medium");
		}		
		if(sumOfPoints<=1 && sumOfPoints>=0 && rankingValue.length()>0){
			softly.assertThat(rankingValue).isEqualTo("Low");
		}		
		if(sumOfPoints<0){
			softly.assertThat(rankingValue).isEqualTo("Extremely Low");
		}
	}

	public HashMap<String,String> storeDataFromTableStep7(WebDriver driver, int n5, int totalFms) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		HashMap<String,String> step7 = new HashMap<String,String>();
		for(int i=1;i<=totalFms;i++)
		{
			String fm1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[1]"))).getText();
			String rv1 = driver.findElement(By.xpath(".//*[@id='pii-ircam2-t7-devsupana-div']/table/tbody/tr["+i+"]/td[2]/span")).getText();
			step7.put(fm1, rv1);
		}
		System.out.println("StoreDataFromTableStep7" +step7);
		return step7;
	}

	public void verify4thPointComponents(WebDriver driver, SoftAssertions softly, int n5) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		if(n5==0)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4MainText)).getText();
			softly.assertThat(s).contains("A failure mode that has high occurrence rate in the past");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4ElectricalHeading)).getText();
			softly.assertThat(s1).isEqualTo("Electrical and I&C components");
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4MechanicalHeading)).getText();
			softly.assertThat(s2).isEqualTo("Mechanical components");
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4ElectricalPoint1)).getText();
			softly.assertThat(s3).isEqualTo("Loose connection");
			String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4ElectricalPoint2)).getText();
			softly.assertThat(s4).isEqualTo("Insulation material degradation");
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4ElectricalPoint3)).getText();
			softly.assertThat(s5).isEqualTo("Voltage surges induced");
			String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4ElectricalPoint4)).getText();
			softly.assertThat(s6).isEqualTo("Corrosion/contamination");
			String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4ElectricalPoint5)).getText();
			softly.assertThat(s7).isEqualTo("Component specific failure mode of high occurrence rate in the past");
			String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4MechanicalPoint1)).getText();
			softly.assertThat(s8).isEqualTo("Loose connection");
			String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4MechanicalPoint2)).getText();
			softly.assertThat(s9).isEqualTo("Corrosion/contamination");
			String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4MechanicalPoint3)).getText();
			softly.assertThat(s10).isEqualTo("Foreign materials or objects");
			String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4MechanicalPoint4)).getText();
			softly.assertThat(s11).isEqualTo("Vibration");
			String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode1Point4MechanicalPoint5)).getText();
			softly.assertThat(s12).isEqualTo("Component specific failure mode of high occurrence rate in the past");
		}
		else{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4MainText)).getText();
			softly.assertThat(s).contains("A failure mode that has high occurrence rate in the past");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4ElectricalHeading)).getText();
			softly.assertThat(s1).isEqualTo("Electrical and I&C components");
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4MechanicalHeading)).getText();
			softly.assertThat(s2).isEqualTo("Mechanical components");
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4ElectricalPoint1)).getText();
			softly.assertThat(s3).isEqualTo("Loose connection");
			String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4ElectricalPoint2)).getText();
			softly.assertThat(s4).isEqualTo("Insulation material degradation");
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4ElectricalPoint3)).getText();
			softly.assertThat(s5).isEqualTo("Voltage surges induced");
			String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4ElectricalPoint4)).getText();
			softly.assertThat(s6).isEqualTo("Corrosion/contamination");
			String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4ElectricalPoint5)).getText();
			softly.assertThat(s7).isEqualTo("Component specific failure mode of high occurrence rate in the past");
			String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4MechanicalPoint1)).getText();
			softly.assertThat(s8).isEqualTo("Loose connection");
			String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4MechanicalPoint2)).getText();
			softly.assertThat(s9).isEqualTo("Corrosion/contamination");
			String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4MechanicalPoint3)).getText();
			softly.assertThat(s10).isEqualTo("Foreign materials or objects");
			String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4MechanicalPoint4)).getText();
			softly.assertThat(s11).isEqualTo("Vibration");
			String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7FailureMode2Point4MechanicalPoint5)).getText();
			softly.assertThat(s12).isEqualTo("Component specific failure mode of high occurrence rate in the past");
		}
	}

}
