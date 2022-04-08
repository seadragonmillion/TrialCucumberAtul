import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kaleTestSoftware.OPiRCAPageObj;
import kaleTestSoftware.ShareCheck;
import kaleTestSoftware.ShareCheck2;
import kaleTestSoftware.TextBoxResizing;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OPiRCA3 {

	ShareCheck share = new ShareCheck();
	OPiRCAPageObj opirca = new OPiRCAPageObj();
	TextBoxResizing tbr = new TextBoxResizing ();
	ShareCheck2 share2 = new ShareCheck2();
	
	public void verifySavePopupAfterRename(WebDriver driver, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on first record
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).click();
		share2.loadingServer(driver);
		//Click on open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OpenButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		//Click on Info tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoTab)).click();
		//Enter a very long name in Event title
		driver.findElement(opirca.OPiRCAEventTitleField).clear();
		driver.findElement(opirca.OPiRCAEventTitleField).sendKeys("Really long text which will make the report name o overflow out of the popup");
		//click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveButton)).click();
		//Verify the popup
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAPopupNote)).getText();
		softly.assertThat(s).as("test data").contains("‑");
		System.out.println(s);
		String overflow = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAPopupNote)).getCssValue("word-wrap");
		softly.assertThat(overflow).as("test data").isEqualTo("break-word");
		System.out.println(overflow);
		//Click on cancel
		wait.until(ExpectedConditions.elementToBeClickable(opirca.OPiRCASaveCancelButton)).click();
		//Click on saved activities
		wait.until(ExpectedConditions.elementToBeClickable(opirca.OPiRCASavedActivitiesButton)).click();
		share2.loadingServer(driver);		
	}
	
	public List<String> modifyList(List<String> apparentCausesAnswers)  throws Exception{

		List<String> ac = new ArrayList<String>();
		for(int i=0;i<apparentCausesAnswers.size();i++)
		{
			String s = apparentCausesAnswers.get(i).trim();
			s=s.replace("]", ":");
			s=s.replace("[", "");
			ac.add(s);
		}	    	
		return ac;
	}
	
	public void collapsibleCheckDescription(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify the presence of description
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionPlusSign));	    		
		}catch (NoSuchElementException|org.openqa.selenium.TimeoutException r)
		{
			System.out.println("No description text on this page");
			return;
		}
		//Verify description text not visible
		try{
			WebElement l = driver.findElement(opirca.Step1DescriptionText);
			if(l.isDisplayed()==true)
				softly.fail("Description text visible");
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException r)
		{
			System.out.println("No description text visible as the + sign for description has not been clicked");
		}
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionPlusSign)).click();
		//Verify description text
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionText));
		//Click on Description again
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionPlusSign)).click();
		//Verify description text not visible
		try{
			WebElement l = driver.findElement(opirca.Step1DescriptionText);
			if(l.isDisplayed()==true)
				softly.fail("Description text visible");
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException r)
		{
			System.out.println("No description text visible as the + sign for description has not been clicked");
		}
	}
	
	public List<String> selectOptions(WebDriver driver, int count, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> ac = new ArrayList<String>();
		//Check the description collapsible 
		collapsibleCheckDescription(driver,softly);
		int x;
		//Select number of options to select
		while(true)
		{
			Random random = new Random();
			x=random.nextInt(count+1);
			if(x==0)
				continue;
			else break;
		}
		outer:
			for(int j=0;j<x;j++)
			{
				//Select any answer between 1 and count
				//Choose a number between 1 and count
				int y;
				while(true)
				{
					Random random = new Random();
					y=random.nextInt(count+1);
					if(y==0)
						continue;
					WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div/input")));
					if(e.isSelected())
					{
						ac.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div/label"))).getText());
						continue outer;
					}
					break;	    			
				}
				//Click on answer
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div/label")));
				//Scroll to element
				share2.scrollToElement(driver, l);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",l);
				//Get answer name and store in list
				String s1 = l.getText().trim();
				ac.add(verifyIfDAnswer(driver, y,s1));
				//Check if Evidence entry and Possible corrective action are in collapsible form
				Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
				String browserName = cap.getBrowserName().toLowerCase();
				if (browserName.contains("chrome")||browserName.contains("firefox")||browserName.contains("internet explorer"))
				{
					checkCollapsibleEvidenceEntryPossibleCorrectiveAction(driver,y,softly);	
				}
			}
		System.out.println("ac: "+ac);
		return ac;		
	}
	
	public void checkCollapsibleEvidenceEntryPossibleCorrectiveAction(WebDriver driver,int y, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify Evidence Entry text not visible
		try{
			WebElement l = driver.findElement(By.id("efi-opa-evidence-text-"+(y-1)));
			if(l.isDisplayed()==true)
				softly.fail("Evidence Entry text visible");
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException r)
		{
			System.out.println("No Evidence Entry visible as the + sign for Evidence Entry has not been clicked");
		}
		//Click on Evidence Entry
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-evidence-text-div-"+(y-1)+"']/h4/a"))));
		//Verify Evidence Entry text
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-opa-evidence-text-"+(y-1))));
		//tbr.sizeCheck(driver, By.id("efi-opa-evidence-text-"+(y-1)),softly);
		//Click on Evidence Entry again
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-evidence-text-div-"+(y-1)+"']/h4/a"))));
		//Verify Evidence Entry text not visible
		try{
			WebElement l = driver.findElement(By.id("efi-opa-evidence-text-"+(y-1)));
			share2.scrollToElement(driver, l);
			if(l.isDisplayed()==true)
				softly.fail("Evidence Entry text visible");
		}catch (NoSuchElementException | org.openqa.selenium.TimeoutException r)
		{
			System.out.println("No Evidence Entry text visible as the + sign for Evidence Entry has not been clicked");
		}
		/*am_not applicable
		//Verify Possible Corrective Action text not visible
		try{
			WebElement l = driver.findElement(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/div"));
			if(l.isDisplayed()==true)
				softly.fail("Possible Corrective Action text visible");
		}catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException r)
		{
			System.out.println("No Possible Corrective Action text visible as the + sign for Possible Corrective Action has not been clicked");
		}
		//Click on Possible Corrective Action 
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/h4/a"))));
		//Verify Possible Corrective Action text
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/div")));
		//Click on Possible Corrective Action again
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//Verify Possible Corrective Action text not visible
		try{
			WebElement l = driver.findElement(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/div"));
			if(l.isDisplayed()==true)
				softly.fail("Possible Corrective Action text visible");
		}catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException r)
		{
			System.out.println("No Possible Corrective Action text visible as the + sign for Possible Corrective Action has not been clicked");
		}*/
	}
	public String verifyIfDAnswer(WebDriver driver, int y, String s1)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		String opirca_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText().trim();
		if(opirca_desc.startsWith("[D"))
		{
			String s = opirca_desc.substring(opirca_desc.indexOf("[")+1,opirca_desc.indexOf("]") );
			String s2 = s+"."+y+": "+s1;
			return s2;
		}
		else return s1;
	}

	public String addContributingFactor(WebDriver driver, int y) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Scroll to add cf button
		//Click on answer
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAAddContributingFactorButton));
		//Scroll to element
		share2.scrollToElement(driver, l);
		//Click on add new contributing factor
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", l);
		//Enter contributing factor
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANewContributingFactorField)));
		String sendKeys1 = ("contributing factor");
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANewContributingFactorField)).sendKeys(sendKeys1);
		Thread.sleep(1000);
		//Click on save
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAAddContributingFactorSaveButton)));
		Thread.sleep(1000);
		//Wait for loading message
		share2.loadingServer(driver);
		Thread.sleep(1000);
		//Get text of new contributing factor
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+y+"]/fieldset/div/div/label")));
		int r = l.getText().lastIndexOf("r");
		return l.getText().substring(0, r+1);
	}
	
	public List<String> selectApparentCausesAnswers(WebDriver driver,List<String> apparentCauses, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,5);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Create a list to store any apparent cause answer selected
		List<String> ac = new ArrayList<String>();
		for(int i=0;i<apparentCauses.size();i++)
		{
			int count = 0;
			int k=1;
			//Identify number of answers for an apparent cause
			while(true)
			{
				try{
					String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+k+"]"))).getAttribute("class");
					k=k+1;
					if(s.equals("ui-contain"))
						count = count +1;
				}catch(NoSuchElementException |org.openqa.selenium.TimeoutException e)
				{
					break;
				}
			}
			//System.out.println("count "+count);
			//Get answers list
			ac.addAll(selectOptions(driver,count,softly));
			//Add contributing factor
			String s = addContributingFactor(driver, count+1);
			ac.add(s);
			//Scroll to top
			Thread.sleep(2000);
			share2.scrollToTop(driver);
			Thread.sleep(2000);
			//Click on next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		}	    	
		return ac;
	}

}
