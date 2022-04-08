package MainClass;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import PageObjects.OPiRCAPageObj;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterables;



public class HiRCALevel2 {

	public String text = "HiRCA Level 2";
	public String reason = "Level 2 reason entry";
	SoftAssertions softly = new SoftAssertions();
	HiRCAFunctionsForLevel1_2_3 hfl123 = new HiRCAFunctionsForLevel1_2_3();
	ErrorMeter2 em2 = new ErrorMeter2 ();
	OPiRCAPageObj opirca = new OPiRCAPageObj();
	OPiRCA3 op3 = new OPiRCA3();
	ShareCheck share = new ShareCheck();
	TextBoxResizing tbr = new TextBoxResizing ();
	ShareCheck2 share2 = new ShareCheck2();
	HiRCALOPBug2 hlb2 = new HiRCALOPBug2 ();

	public void pathHiRCALevel2(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//create a new report
		hlb2.fillUpHiRCAEventInfo(driver, text);
		//Select 3 lops with Act of Nature
		List<String> lopSelected = select3LOPs(driver);
		//Hashmaps for storing notes and answers
		MultiValuedMap<String,String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		//Select answers for 1st lop
		Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables1 = answerLOPRelatedQuestions(driver);
		List<String> level21stLOP = level2List(pairOfReturnVariables1.getValue());
		List<String> level31stLOP = level3List(pairOfReturnVariables1.getValue()).stream().distinct().collect(Collectors.toList());
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Select answers for 2nd lop
		Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables2 = answerLOPRelatedQuestions(driver);
		List<String> level22ndLOP = level2List(pairOfReturnVariables2.getValue());
		List<String> level32ndLOP = level3List(pairOfReturnVariables2.getValue()).stream().distinct().collect(Collectors.toList());
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Select answers for 3rd lop
		Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables3 = answerLOPRelatedQuestions(driver);
		List<String> level23rdLOP = level2List(pairOfReturnVariables3.getValue());
		List<String> level33rdLOP = level3List(pairOfReturnVariables3.getValue()).stream().distinct().collect(Collectors.toList());
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.20 - make some selections and click next
		List<String> list220 = selectOptions(driver,12).stream().distinct().collect(Collectors.toList());
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.22 - skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Step 3 skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		/*Step 4 / Step 5 / Report/ pdf
		0=english
		1=chinese
		 */
		hircaNoteLopSURE.putAll(pairOfReturnVariables1.getKey());
		hircaNoteLopSURE.putAll(pairOfReturnVariables2.getKey());
		hircaNoteLopSURE.putAll(pairOfReturnVariables3.getKey());
		System.out.println(hircaNoteLopSURE);
		verifyRemainingSteps(driver,lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,0,hircaNoteLopSURE,softly);
	}

	private void pressSkip(WebDriver driver ) {
		//am_add///
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}catch(Exception e) {
		}
		////
	}
	
	public void verifyRemainingSteps(WebDriver driver, List<String> lopSelected, List<String> level31stLOP, List<String> level32ndLOP, List<String> level33rdLOP, List<String> level21stLOP, List<String> level22ndLOP, List<String> level23rdLOP, List<String> list220, int chineseOrEnglish, MultiValuedMap<String,String> hircaNoteLopSURE, SoftAssertions softly) throws Exception{
		System.out.println("recompile 2");
		HiRCALevel1 obj1 = new HiRCALevel1();
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Step 4 verify select HML
		
		HashMap<String,String> hml1 = verifyStep4LOP1(driver,lopSelected,level31stLOP,2,hircaNoteLopSURE,chineseOrEnglish,softly);
		//Get corrective action from step 4
		List<String> correctiveActionLOP1 = getCorrectiveAction(driver,level31stLOP,2);
		int n3 = 3;
		if(level31stLOP.isEmpty())
			n3 = 2;
		HashMap<String,String> hml2 = verifyStep4LOP1(driver,lopSelected,level32ndLOP,n3,hircaNoteLopSURE,chineseOrEnglish,softly);
		//Get corrective action from step 4
		List<String> correctiveActionLOP2 = getCorrectiveAction(driver,level32ndLOP,n3);
		if(level32ndLOP.isEmpty())
			n3 = 3;
		if(level32ndLOP.isEmpty() && level31stLOP.isEmpty())
			n3 = 2;
		if(level32ndLOP.isEmpty()==false && level31stLOP.isEmpty()==false)
			n3 = 4;
		HashMap<String,String> hml3 = verifyStep4LOP1(driver,lopSelected,level33rdLOP,n3,hircaNoteLopSURE,chineseOrEnglish,softly);
		//Get corrective action from step 4
		List<String> correctiveActionLOP3 = getCorrectiveAction(driver,level33rdLOP,n3);
		share2.scrollToTop(driver);
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Step 5 select random
		List<Integer> step5 = selectStep5(driver);
		if(chineseOrEnglish==1)
		{
			//On Step 5
			hlb2.bugKALE2494(driver,softly);
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Save report
		saveHiRCAReport(driver);
		//Verify report
		
		//verifyHTMLReport(driver,chineseOrEnglish,lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,step5,hml1,hml2,hml3,list220,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3,hircaNoteLopSURE,softly);
		//download
		downloadSelectFunction(driver,lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3,softly,chineseOrEnglish);
		if(chineseOrEnglish==0)
		{
			modifyStep4(driver,level31stLOP,level32ndLOP,level33rdLOP);
			modifyLOPVerifyAnswersSaved(driver,lopSelected);
		}
		//delete
		obj1.deleteReport(driver);
	}



	public void modifyLOPVerifyAnswersSaved(WebDriver driver, List<String> lopSelected) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> for1 = new ArrayList<String>();
		List<Integer> digits = new ArrayList<Integer>();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//Click on open button
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))));
		//Open confirm button
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))));
		share2.scrollToTop(driver);
		//Go to step 2
		executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-2"))));
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-2"))));
		//Get for value of all lops selected
		for(int i =0;i<lopSelected.size();i++)
		{
			String s = driver.findElement(By.xpath("//label[contains(text(), '"+lopSelected.get(i)+"')]")).getAttribute("for");
			for1.add(s);
			String digit = s.substring(s.length()-1,s.length());
			digits.add(Integer.parseInt(digit));
		}
		Collections.sort(digits);
		System.out.println(digits+"\n"+for1);
		//Click on lop that comes first and uncheck it
		executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-"+digits.get(0)+"']"))));
//		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-"+digits.get(0)+"']"))));
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-"+digits.get(0)+"']"))));
		//Click on modify
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))));
		//select a lop
		int y;
		Random random = new Random();
		while(true)
		{
			y=random.nextInt(9);
			if(y==0||y==1||y==(digits.get(0)+2))
				continue;
			String e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getAttribute("class");
			if(e.contains("ui-checkbox-on"))
				continue;
			break;
		}
		Thread.sleep(500);
		//Scroll to element
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		//Click on LOP
		executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		String lopName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getText().trim();
		System.out.println(lopName);
		share2.scrollToTop(driver);
		//Decide order of new LOP selected
		digits.remove(0);
		String s = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label")).getAttribute("for");
		System.out.println(s);
		String digit = s.substring(s.length()-1,s.length());
		digits.add(Integer.parseInt(digit));
		Collections.sort(digits);
		System.out.println(digits);
		int index = digits.indexOf(Integer.parseInt(digit));
		System.out.println(index);
		//Click next
		executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		if(index==0)
		{
			//Check for 1/3 in page title
			String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText().trim();
			softly.assertThat(title).as("test data").contains("1/3");
			softly.assertThat(title).as("test data").contains(lopName);
		}
		if(index==1)
		{
			//click next till you see 2/3 in page title
			outer: while(true)
			{
				Thread.sleep(1000);
				String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText().trim();
				if(title.contains("2/3"))
				{
					softly.assertThat(title).as("test data").contains(lopName);
					break outer;
				}
				share2.scrollToTop(driver);
				//Click next
				try{
					executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				}catch(org.openqa.selenium.WebDriverException r)
				{
					share2.scrollToTop(driver);
					executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				}
			}				
		}
		if(index==2)
		{
			//click next till you see 3/3 in page title
			outer: while(true)
			{
				Thread.sleep(1000);
				String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText().trim();
				if(title.contains("3/3"))
				{
					softly.assertThat(title).as("test data").contains(lopName);
					break outer;
				}
				share2.scrollToTop(driver);
				//Click next
				try{
					executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				}catch(org.openqa.selenium.WebDriverException r)
				{
					share2.scrollToTop(driver);
					executor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				}
			}	
		}
		//Check for 2.1 question
		String question = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText().trim();
		softly.assertThat(question).as("test data").contains("[2.1] Did equipment failure cause LOP to fail?");
		//Next button disabled
		String next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).getAttribute("class");
		softly.assertThat(next).as("test data").contains("ui-state-disabled");
		//Skip button disabled
		String skip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		softly.assertThat(skip).as("test data").contains("ui-state-disabled");			
		//Verify Yes is not selected
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-answer-0"))).isSelected()==true)
			softly.fail("Yes is selected");
		//Verify No is not selected
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-answer-1"))).isSelected()==true)
			softly.fail("No is selected");
		//Get browser name and version
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//Verify reason entry is empty
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("textContent");
		if(browserName.equals("internet explorer"))
			softly.assertThat(reason).as("test data").contains("Optionally enter the reason of your selection");
		else
			softly.assertThat(reason).as("test data").isEmpty();
		//save report
		saveHiRCAReport(driver);
	}

	public void verifyHTMLReport(WebDriver driver, int chineseOrEnglish, List<String> lopSelected, List<String> level31stLOP, List<String> level32ndLOP, List<String> level33rdLOP, List<String> level21stLOP, List<String> level22ndLOP, List<String> level23rdLOP, List<Integer> step5, HashMap<String,String> hml1, HashMap<String,String> hml2, HashMap<String,String> hml3, List<String> list220, List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3, MultiValuedMap<String,String> hircaNoteLopSURE, SoftAssertions softly) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,10);
		//Verify failed LOPs
		String lop1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table[1]/tbody/tr/td[1]"))).getText().trim();
		softly.assertThat(lop1).as("test data").isIn(lopSelected);
		String lop2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table[1]/tbody/tr/td[2]"))).getText().trim();
		softly.assertThat(lop2).as("test data").isIn(lopSelected);
		String lop3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table[1]/tbody/tr/td[3]"))).getText().trim();
		softly.assertThat(lop3).as("test data").isIn(lopSelected);
		//LOP1
		verifyLOPTable(driver,lopSelected,level31stLOP,hml1,2,correctiveActionLOP1,softly,chineseOrEnglish);
		//LOP2
		verifyLOPTable(driver,lopSelected,level32ndLOP,hml2,3,correctiveActionLOP2,softly,chineseOrEnglish);
		//LOP3
		verifyLOPTable(driver,lopSelected,level33rdLOP,hml3,4,correctiveActionLOP3,softly,chineseOrEnglish);
		//2.20
		verifyAdditionalLOPSRequired(driver,list220);
		//Verify selected failed LOPs
		String lop1a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[2]/td[2]/ul/li[1]"))).getText().trim();
		softly.assertThat(lop1a).as("test data").isIn(lopSelected);
		String lop2a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[2]/td[2]/ul/li[2]"))).getText().trim();
		softly.assertThat(lop2a).as("test data").isIn(lopSelected);
		String lop3a = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[2]/td[2]/ul/li[3]"))).getText().trim();
		softly.assertThat(lop3a).as("test data").isIn(lopSelected);
		//LOP1
		verifyLevel2and3AnswersForLOP(driver,lopSelected,level31stLOP,level21stLOP,8,softly);
		//LOP2
		verifyLevel2and3AnswersForLOP(driver,lopSelected,level32ndLOP,level22ndLOP,9,softly);
		//LOP3
		verifyLevel2and3AnswersForLOP(driver,lopSelected,level33rdLOP,level23rdLOP,10,softly);
		//2.20
		verifySupportingInfoAdditionalLOPs(driver,list220,softly);
	}

	public void modifyStep4(WebDriver driver, List<String> level31stLOP, List<String> level32ndLOP, List<String> level33rdLOP) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on open button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))).click();
		//Open confirm button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();		
		//Go to step 4
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-4"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-4"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-4"))).click();
		//Change the text
		changeCorrectiveAction (driver,level31stLOP, 2);
		List<String> correctiveActionLOP1 = getCorrectiveAction(driver,level31stLOP,2);
		int n3 = 3;
		if(level31stLOP.isEmpty())
			n3 = 2;
		changeCorrectiveAction(driver,level32ndLOP,n3);
		//Get corrective action from step 4
		List<String> correctiveActionLOP2 = getCorrectiveAction(driver,level32ndLOP,n3);
		if(level32ndLOP.isEmpty())
			n3 = 3;
		if(level32ndLOP.isEmpty() && level31stLOP.isEmpty())
			n3 = 2;
		if(level32ndLOP.isEmpty()==false && level31stLOP.isEmpty()==false)
			n3 = 4;
		changeCorrectiveAction(driver,level33rdLOP,n3);
		List<String> correctiveActionLOP3 = getCorrectiveAction(driver,level33rdLOP,n3);
		//Scroll up
		share2.scrollToTop(driver);
		//Save report
		saveHiRCAReport(driver);
		//Verify change in text in html
		//LOP1
		verifyChangeCorrectiveActionInLOPTable(driver,2,correctiveActionLOP1,level31stLOP);
		//LOP2
		verifyChangeCorrectiveActionInLOPTable(driver,3,correctiveActionLOP2,level32ndLOP);
		//LOP3
		verifyChangeCorrectiveActionInLOPTable(driver,4,correctiveActionLOP3,level33rdLOP);
		//Download report and verify in pdf new corrective action
		downloadSelectFunctionChangeCorrectiveAction(driver,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3);
	}

	public void downloadSelectFunctionChangeCorrectiveAction(WebDriver driver, List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3)throws Exception {

		OPiRCA obj = new OPiRCA();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if(browserName.toLowerCase().contains("safari")==false)
		{
			//deletes files in reports folder before starting to download
			File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//"); 
			obj.deleteFiles(file);
		}
		//Download report to check pdf
		if (browserName.equals("chrome"))
			downloadReportChangeCorrectiveActionChrome(driver,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3);
		if (browserName.equals("firefox"))
			downloadReportChangeCorrectiveActionFirefox(driver,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				downloadReportChangeCorrectiveActionIE10(driver,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3);
			if (v.startsWith("11"))
				downloadReportChangeCorrectiveActionIE11(driver,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3);
		}
		if(browserName.toLowerCase().contains("safari"))
			driver.switchTo().defaultContent();
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(2000);
	}

	public void downloadReportChangeCorrectiveActionChrome(WebDriver driver, List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		EiRCA2 obj1 = new EiRCA2();
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Verify pdf pop up
		obj1.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify download pop up
		obj1.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(10000);
		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\ChromSavePDF5_amlocal.exe");
		Thread.sleep(20000);
//		pdfCheckChangeCorrectiveAction(correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);
	}

	public void downloadReportChangeCorrectiveActionFirefox(WebDriver driver, List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		EiRCA2 obj1 = new EiRCA2();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Verify pdf pop up
		obj1.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear			
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		obj1.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(8000);
		for(String winHandle : driver.getWindowHandles())
		{
			System.out.println(winHandle);
			if(winHandle.isEmpty()==false)
			{
				if(winHandle.equals(window)==false)
					driver.switchTo().window(winHandle);
			}
		}
		Thread.sleep(2000);/*
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("viewerContainer"))).sendKeys(Keys.chord(Keys.CONTROL + "s"));
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
		p.waitFor();*/
//		pdfCheckChangeCorrectiveAction(correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();
	}

	public void downloadReportChangeCorrectiveActionIE10(WebDriver driver, List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		EiRCA2 obj1 = new EiRCA2();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Verify pdf pop up
		obj1.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		obj1.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(7000);
		//pdf verification
		pdfCheckChangeCorrectiveAction(correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3);
		Thread.sleep(4000);
		//Switch to window
		driver.switchTo().window(window);
	}

	public void downloadReportChangeCorrectiveActionIE11(WebDriver driver, List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		EiRCA2 obj1 = new EiRCA2();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Verify pdf pop up
		obj1.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		obj1.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/ChromSavePDF5_amlocal.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(7000);
		//pdf verification
		pdfCheckChangeCorrectiveAction(correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3);
		Thread.sleep(4000);
		//Switch to window
		driver.switchTo().window(window);
	}

	public void pdfCheckChangeCorrectiveAction(List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3) throws Exception{

		// specify your directory
		Path dir = Paths.get("C://Users//mama//Pictures//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		try{
			System.out.println(lastFilePath.get());
		}catch(java.util.NoSuchElementException t)
		{

		}
		//Loads the file to check if correct data is present
		String fileName=lastFilePath.get().toString();
		File oldfile = new File(fileName);
		PDDocument pddoc= PDDocument.load(oldfile);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		String newData1="";
		for (int i = 0; i < ans.size(); i++)
		{
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData1 = newData1+ans.get(i);
			else if (ans.get(i).charAt(n)!=' ')
				newData1 = newData1+" "+ans.get(i);
		}
		newData1 = newData1.replace("  ", " ");
		System.out.println(newData1);
		//Verify all lists present in pdf
		softly.assertThat(newData1).as("test data").contains(correctiveActionLOP1);
		softly.assertThat(newData1).as("test data").contains(correctiveActionLOP2);
		softly.assertThat(newData1).as("test data").contains(correctiveActionLOP3);
		//Close pdf
		pddoc.close();
	}

	public void verifyChangeCorrectiveActionInLOPTable(WebDriver driver, int tableNumber, List<String> correctiveActionLOP1, List<String> level31stLOP)throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,10);		
		for(int i=1;i<=level31stLOP.size();i++)
		{
			//Verify the corrective action
			String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table["+tableNumber+"]/tbody/tr["+i+"]/td[3]"))).getText().trim();
			String r1 = s.replaceAll("\u00AD", "");
			softly.assertThat(r1).as("test data").isIn(correctiveActionLOP1);
		}
	}

	public void changeCorrectiveAction (WebDriver driver, List<String> level31stLOP, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		List<String> text = em2.error50Data(driver,driver.getCurrentUrl());
		Iterator<String> iter = Iterables.cycle(text).iterator();
		if(level31stLOP.isEmpty()==false)
		{			
			System.out.println("change corrective action: \n"+level31stLOP);
			System.out.println(level31stLOP.size());
			for(int i=1;i<=(level31stLOP.size()*3);i=i+3)
			{
				try{
					//Move to element
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+n+"]/tbody/tr["+(i+3)+"]/td/textarea"))));
					jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+n+"]/tbody/tr["+(i+3)+"]/td/textarea"))));
				}catch(org.openqa.selenium.TimeoutException r)
				{
					break;
				}
				//Clear text box
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+n+"]/tbody/tr["+(i+3)+"]/td/textarea"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+n+"]/tbody/tr["+(i+3)+"]/td/textarea"))).clear();
				//Fill text box
				if(iter.hasNext()) 
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+n+"]/tbody/tr["+(i+3)+"]/td/textarea"))).sendKeys(iter.next());				
			}			
		}
	}

	public List<String> getCorrectiveAction(WebDriver driver, List<String> level31stLOP, int n)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,3);
		List<String> k = new ArrayList<String>();
		if(level31stLOP.isEmpty()==false)
		{
			//Get corrective action
			for(int i=1;i<=(level31stLOP.size()*3);i=i+3)
			{
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+n+"]/tbody/tr["+(i+3)+"]/td/textarea"))).getAttribute("value");
				k.add(s1);
			}
		}
		return k;
	}

	public void verifyLevel2and3AnswersForLOP(WebDriver driver, List<String> lopSelected, List<String> level31stLOP, List<String> level21stLOP,int divNumber, SoftAssertions softly)throws Exception {

		OPiRCAChinese4 obj = new OPiRCAChinese4();
		WebDriverWait wait1 = new WebDriverWait(driver,3);
		//list without [ ] :
		List<String> temp = obj.removeColonFromAnswers(op3.modifyList(level31stLOP));
		//heading
		String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+divNumber+"]/table/thead/tr/th[1]"))).getText().trim();
		int n = s1.indexOf(":");
		String s = s1.substring(n+2, s1.length());
		softly.assertThat(s).as("test data").isIn(lopSelected);
		int i=0;
		int k=0;
		while(k<level21stLOP.size())
		{
			i=i+1;
			//verify level 3 selected is present
			String s2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+divNumber+"]/table/tbody/tr["+i+"]/td[2]/ul/li"))).getText().trim();
			share.checkColorOfElement(driver, By.xpath(".//*[@id='irca-rpt']/div["+divNumber+"]/table/tbody/tr["+i+"]/td[2]/ul/li"), softly);
			//System.out.println(s2);
			softly.assertThat(s2).as("test data").isEqualTo(level21stLOP.get(k));
			k=k+1;
			String t = s2.trim();
			if(t.equals("No")||t.equals("Inadequate or Incorrect rules")||t.equals("å�¦")||t.equals("规则存在不足或规则不正确")||t.equals("皆非"))
			{
				continue;
			}
			else
			{
				i=i+1;
				//verify level 3 selected under lop 
				verifyLevel3Answers(driver,temp,divNumber,i);
			}
		}
	}

	public void verifyLevel3Answers (WebDriver driver, List<String> temp, int divNumber, int i) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,3);
		int m=0;
		while(true)
		{
			try{
				m=m+1;
				//verify level 3 selected is present
				String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+divNumber+"]/table/tbody/tr["+i+"]/td/div/table/tbody/tr["+m+"]/td[1]"))).getText().trim();
				share.checkColorOfElement(driver, By.xpath(".//*[@id='irca-rpt']/div["+divNumber+"]/table/tbody/tr["+i+"]/td/div/table/tbody/tr["+m+"]/td[1]"), softly);
				//System.out.println(s);
				softly.assertThat(s).as("test data").isIn(temp);				
			}catch(org.openqa.selenium.TimeoutException r)
			{
				break;
			}
		}
	}

	public void verifySupportingInfoAdditionalLOPs(WebDriver driver, List<String> list220, SoftAssertions softly) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,3);
		//System.out.println(list220.size()+" "+list220);
		for(int i=1;i<list220.size();i++)
		{
			String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[2]/ul/li["+i+"]"))).getText().trim();
			share.checkColorOfElement(driver, By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[2]/ul/li["+i+"]"), softly);
			//System.out.println(s);
			softly.assertThat(s).as("test data").isIn(list220);
		}
	}

	public void verifyAdditionalLOPSRequired(WebDriver driver, List<String> list220) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,3);
		int count = 0;
		outer:
			for(int i=1;i<=4;i++)
			{
				for(int m=1;m<=3;m++)
				{
					try{
						String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table[5]/tbody/tr["+i+"]/td["+m+"]"))).getText().trim();
						share.checkColorOfElement(driver, By.xpath(".//*[@id='irca-rpt']/table[5]/tbody/tr["+i+"]/td["+m+"]"), softly);
						softly.assertThat(s).as("test data").isIn(list220);
						count = count + 1;
						if(count>=list220.size())
							break outer;
					}catch(org.openqa.selenium.TimeoutException r)
					{
						break outer;
					}
				}
			}
	}

	public void verifyLOPTable(WebDriver driver, List<String> lopSelected, List<String> level31stLOP, HashMap<String,String> hml, int tableNumber, List<String> correctiveActionLOP1, SoftAssertions softly, int chineseOrEnglish)throws Exception {

		OPiRCAChinese4 obj = new OPiRCAChinese4();
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		System.out.println(hml);
		//list without [ ] :
		List<String> temp = obj.removeColonFromAnswers(op3.modifyList(level31stLOP));
		System.out.println(temp.size()+" " +temp);
		//list without [ ] but with :
		List<String> temp1 = op3.modifyList(level31stLOP);
		System.out.println(temp1.size()+" " +temp1);
		//heading
		String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table["+tableNumber+"]/thead/tr/th[1]"))).getText().trim();
		int n1 = s1.indexOf(":");
		String s = s1.substring(n1+2, s1.length());
		softly.assertThat(s).as("test data").isIn(lopSelected);
		int b=4;
		for(int i=1;i<=temp.size();i++)
		{
			//verify level 3 selected is present
			String s2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table["+tableNumber+"]/tbody/tr["+i+"]/td[1]"))).getText().trim();
			share.checkColorOfElement(driver, By.xpath(".//*[@id='irca-rpt']/table["+tableNumber+"]/tbody/tr["+i+"]/td[1]"), softly);
			softly.assertThat(s2).as("test data").isIn(temp);
			if(chineseOrEnglish==0)
			{
				//Get value of HML
				if(temp.contains(s2))
				{
					int n  = temp.indexOf(s2);
					//Get same value from temp1 and get hml from hashmap
					String s3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table["+tableNumber+"]/tbody/tr["+i+"]/td[2]"))).getText().trim();
					System.out.println(temp1.get(n) + " "+n+ " "+s2);
					if(hml.get(temp1.get(n)).equals("None"))
					{
						softly.assertThat(s3).as("test data").isEqualTo("");
					}
					else
						softly.assertThat(s3).as("test data").isEqualTo(hml.get(temp1.get(n)));
					//Verify hml order
					b = checkHMLOrder(b,s3,softly);
				}
			}
			//Verify the corrective action
			String s4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table["+tableNumber+"]/tbody/tr["+i+"]/td[3]"))).getText().trim();
			share.checkColorOfElement(driver, By.xpath(".//*[@id='irca-rpt']/table["+tableNumber+"]/tbody/tr["+i+"]/td[3]"), softly);
			softly.assertThat(s4).as("test data").isIn(correctiveActionLOP1);
		}
	}

	public int checkHMLOrder(int b, String s, SoftAssertions softly) throws Exception{

		if(s.equals("High"))
		{
			if(b>3||b==3)
			{
				b=3;
				//System.out.println("Order is correct:High");
			}
			if(b<3)
				softly.fail("Currently in High Block: Order is wrong");
		}
		if(s.equals("Medium"))
		{
			if(b>2||b==2)
			{
				b=2;
				//System.out.println("Order is correct:Medium");
			}
			if(b<2)
				softly.fail("Currently in Medium Block: Order is wrong");
		}
		if(s.equals("Low"))
		{
			if(b>1||b==1)
			{
				b=1;
				//System.out.println("Order is correct:Low");
			}
			if(b<1)
				softly.fail("Currently in Low Block: Order is wrong");
		}
		if(s.equals("")||s==""||s.equals(null))
		{
			if(b>0||b==0)
			{
				b=0;
				//System.out.println("Order is correct:None");
			}
			if(b<0)
				softly.fail("Currently in None Block: Order is wrong");
		}
		return b;
	}

	public HashMap<String,String> verifyStep4LOP1 (WebDriver driver, List<String> lopSelected, List<String> level31stLOP, int n, MultiValuedMap<String,String> hircaNoteLopSURE, int engOrChi, SoftAssertions softly) throws Exception {

		HashMap<String,String> hml = new HashMap<String,String>();
		WebDriverWait wait = new WebDriverWait(driver,10);
		List <String> temp = new ArrayList<String>(); 
		
		if(level31stLOP.isEmpty()==false)
		{
			//LOP 1
	/*am_removed
			//Verify title
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+n+"]/tbody/tr[1]/th[1]"))).getText().trim();
			int a = s.indexOf(":");
			String r = s.substring(a+2, s.length()-1);
			softly.assertThat(r).as("test data").isIn(lopSelected);
		*/
			//Modify level 3 list,  remove [ and replace ] with :
			temp.addAll(op3.modifyList(level31stLOP));
			//Verify level 3 selected
			for(int i=1;i<=(level31stLOP.size()*3);i=i+3)
			{
				try{
					String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+n+"]/tbody/tr["+(i+1)+"]/td[1]"))).getText().trim();
					share.checkColorOfElement(driver, By.xpath(".//*[@id='efi-irca-answers']/table["+n+"]/tbody/tr["+(i+1)+"]/td[1]"), softly);
					softly.assertThat(s1).as("test data").isIn(temp);
					String imp = selectHML(driver,i,n);
					System.out.println(s1+ " "+i);
					System.out.println(imp);
					hml.put(s1, imp);
					//Verify note
					String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+n+"]/tbody/tr["+(i+2)+"]/td/span"))).getText().trim();
					if(engOrChi==1)
						softly.assertThat(note).as("test data").contains("备注：从以下问题所选的答案而来");
					String r1 = s1.substring(0, s1.indexOf(":")) + s1.substring(s1.indexOf(":")+1, s1.length());
					if(hircaNoteLopSURE.get(r1).contains(note)==false)
					{
						softly.fail("Note is not correct in SUEP table in step 3: "+hircaNoteLopSURE.get(r1)+"\n"+note+"\n"+r1);
					}
				}catch(org.openqa.selenium.TimeoutException w)
				{
					break;
				}
			}
			//clear temp
			temp.clear();
		}
		return hml;
	}

	public String selectHML(WebDriver driver, int i, int tableNumber) throws Exception {

		OPiRCA2 obj = new OPiRCA2();
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Choose a number
		int n = obj.chooseRandomOption(4, 0);
		//Scroll to element
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+tableNumber+"]/tbody/tr["+(i+1)+"]/td[3]/fieldset/div/div[1]/label"))));
		if(n==0)
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+tableNumber+"]/tbody/tr["+(i+1)+"]/td[3]/fieldset/div/div[1]/label"))));
			return "High";
		}
		if(n==1)
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+tableNumber+"]/tbody/tr["+(i+1)+"]/td[3]/fieldset/div/div[2]/label"))));
			return "Medium";
		}
		if(n==2)
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table["+tableNumber+"]/tbody/tr["+(i+1)+"]/td[3]/fieldset/div/div[3]/label"))));
			return "Low";
		}
		else return "None";
	}

	public List<Integer> selectStep5(WebDriver driver) throws Exception {

		OPiRCA2 obj = new OPiRCA2();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		List<Integer> a = new ArrayList<Integer>();
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Choose a number between 1 to 20
		int n = obj.chooseRandomOption(20, 1);
		outer:
			for(int j=0;j<n;j++)
			{
				//Select any answer between 1 and 21
				//Choose a number between 1 and 21
				int y;
				while(true)
				{
					Random random = new Random();
					y=random.nextInt(21);
					if(y==0)
						continue;
					share.checkColorOfElement(driver, By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+(y+1)+"]/td[1]"), softly);
					share.checkColorOfElement(driver, By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+(y+1)+"]/td[1]"), softly);
					WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+(y+1)+"]/td[3]/div/input")));
					if(e.isSelected())
					{
						continue outer;
					}
					break;
				}
				WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+(y+1)+"]/td[3]/div/input")));
				//Scroll to element
				share2.scrollToElement(driver, e);
				jse.executeScript("arguments[0].focus();", e);
				jse.executeScript("arguments[0].click();", e);
				//add number to list
				a.add(y);	
			}
		//Scroll to top
		share2.scrollToTop(driver);
		return a;
	}

	public void downloadSelectFunction(WebDriver driver, List<String> lopSelected, List<String> level31stLOP, List<String> level32ndLOP, List<String> level33rdLOP, List<String> level21stLOP, List<String> level22ndLOP, List<String> level23rdLOP, List<String> list220, List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3, SoftAssertions softly, int chineseOrEnglish)throws Exception {

		OPiRCA obj = new OPiRCA();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if(browserName.toLowerCase().contains("safari")==false)
		{
			//deletes files in reports folder before starting to download
			File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
			obj.deleteFiles(file);
		}
		//Download report to check pdf
		if (browserName.equals("chrome"))
			downloadReportChrome(driver,lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3,softly,chineseOrEnglish);
		if (browserName.equals("firefox"))
			downloadReportFirefox(driver,lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3,softly,chineseOrEnglish);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				downloadReportIE10(driver,lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3,softly,chineseOrEnglish);
			if (v.startsWith("11"))
				downloadReportIE11(driver,lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3,softly,chineseOrEnglish);
		}
		if(browserName.toLowerCase().contains("safari"))
			driver.switchTo().defaultContent();
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(2000);
	}

	public void downloadReportChrome(WebDriver driver, List<String> lopSelected, List<String> level31stLOP, List<String> level32ndLOP, List<String> level33rdLOP, List<String> level21stLOP, List<String> level22ndLOP, List<String> level23rdLOP, List<String> list220, List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3, SoftAssertions softly, int chineseOrEnglish) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		EiRCA2 obj1 = new EiRCA2();
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Verify pdf pop up
		obj1.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify download pop up
		if(chineseOrEnglish==0)
			obj1.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(8000);
//		pdfCheck(lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3,softly,chineseOrEnglish);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\ChromSavePDF5_amlocal.exe");
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);
	}

	public void downloadReportFirefox(WebDriver driver, List<String> lopSelected, List<String> level31stLOP, List<String> level32ndLOP, List<String> level33rdLOP, List<String> level21stLOP, List<String> level22ndLOP, List<String> level23rdLOP, List<String> list220, List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3, SoftAssertions softly, int chineseOrEnglish) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		EiRCA2 obj1 = new EiRCA2();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Verify pdf pop up
		obj1.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear			
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		if(chineseOrEnglish==0)
			obj1.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(8000);
		for(String winHandle : driver.getWindowHandles())
		{
			System.out.println(winHandle);
			if(winHandle.isEmpty()==false)
			{
				if(winHandle.equals(window)==false)
					driver.switchTo().window(winHandle);
			}
		}
		Thread.sleep(2000);/*
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("viewerContainer"))).sendKeys(Keys.chord(Keys.CONTROL + "s"));
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
		p.waitFor();*/
		pdfCheck(lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3,softly,chineseOrEnglish);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();
	}

	public void downloadReportIE10(WebDriver driver, List<String> lopSelected, List<String> level31stLOP, List<String> level32ndLOP, List<String> level33rdLOP, List<String> level21stLOP, List<String> level22ndLOP, List<String> level23rdLOP, List<String> list220, List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3, SoftAssertions softly, int chineseOrEnglish) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		EiRCA2 obj1 = new EiRCA2();
		OPiRCA obj2 = new OPiRCA();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Verify pdf pop up
		obj1.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		if(chineseOrEnglish==0)
			obj1.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/ChromSavePDF5_amlocal.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(7000);
		List<String> results = new ArrayList<String>();
		File[] files = new File("C://Users//mama//Pictures//").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		for (File file1 : files) {
			if (file1.isFile()) {
				results.add(file1.getName());
			}
		}
		System.out.println(results.get(0));
		if(results.get(0).endsWith(".pdf")==false)
		{
			obj2.deleteFiles(new File("C://Users//mama//Pictures//"));
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(4000);
			try {
				Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/ChromSavePDF5_amlocal.exe");
				q.waitFor();
			}catch (UnhandledAlertException f){	
				System.out.println("Unexpected alert");
				driver.switchTo().alert().accept();

			}catch (NoAlertPresentException f){
				System.out.println ("No unexpected alert");
			}
			Thread.sleep(6000);
		}
		//pdf verification
		pdfCheck(lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3,softly,chineseOrEnglish);
		Thread.sleep(4000);
		//Switch to window
		driver.switchTo().window(window);	
	}

	public void downloadReportIE11(WebDriver driver, List<String> lopSelected, List<String> level31stLOP, List<String> level32ndLOP, List<String> level33rdLOP, List<String> level21stLOP, List<String> level22ndLOP, List<String> level23rdLOP, List<String> list220, List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3, SoftAssertions softly, int chineseOrEnglish) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		EiRCA2 obj1 = new EiRCA2();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Verify pdf pop up
		obj1.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		if(chineseOrEnglish==0)
			obj1.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/ChromSavePDF5_amlocal.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(7000);
		//pdf verification
		pdfCheck(lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,correctiveActionLOP1,correctiveActionLOP2,correctiveActionLOP3,softly,chineseOrEnglish);
		Thread.sleep(4000);
		//Switch to window
		driver.switchTo().window(window);
	}

	public void pdfCheck(List<String> lopSelected, List<String> level31stLOP, List<String> level32ndLOP, List<String> level33rdLOP, List<String> level21stLOP, List<String> level22ndLOP, List<String> level23rdLOP, List<String> list220, List<String> correctiveActionLOP1, List<String> correctiveActionLOP2, List<String> correctiveActionLOP3, SoftAssertions softly, int chineseOrEnglish) throws Exception{

		OPiRCAChinese4 obj = new OPiRCAChinese4();
		// specify your directory
		Path dir = Paths.get("C://Users//mama//Downloads//EFTestDownloadReportsPictures//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		try{
			System.out.println(lastFilePath.get());
		}catch(java.util.NoSuchElementException t)
		{

		}
		//Loads the file to check if correct data is present
		String fileName=lastFilePath.get().toString();
		File oldfile = new File(fileName);
		PDDocument pddoc= PDDocument.load(oldfile);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		String newData1="";
		for (int i = 0; i < ans.size(); i++)
		{	
			int n=ans.get(i).length()-1;
			try{
				if (ans.get(i).charAt(n)==' ')
					newData1 = newData1+ans.get(i);
				else if (ans.get(i).charAt(n)!=' ')
					newData1 = newData1+" "+ans.get(i);
			}catch(IllegalArgumentException r)
			{
				softly.fail("threw exception: java.lang.IllegalArgumentException \n"+r+"\n"+ans);
			}
		}
		newData1 = newData1.replace("  ", " ");
		System.out.println(newData1);
		//Verify all lists present in pdf
		softly.assertThat(newData1).as("test data").contains(lopSelected);   			
		softly.assertThat(newData1).as("test data").contains(level21stLOP);  
		softly.assertThat(newData1).as("test data").contains(level22ndLOP);  
		softly.assertThat(newData1).as("test data").contains(level23rdLOP);  
		softly.assertThat(newData1).as("test data").contains(list220);  
		try{
		if(chineseOrEnglish==0)
		{
			if(correctiveActionLOP1.isEmpty()==false)
				softly.assertThat(newData1).as("test data").contains(correctiveActionLOP1);
			if(correctiveActionLOP2.isEmpty()==false)
				softly.assertThat(newData1).as("test data").contains(correctiveActionLOP2);
			if(correctiveActionLOP3.isEmpty()==false)
				softly.assertThat(newData1).as("test data").contains(correctiveActionLOP3);
			softly.assertThat(newData1).as("test data").contains(obj.removeColonFromAnswers(op3.modifyList(level31stLOP)));  
			softly.assertThat(newData1).as("test data").contains(obj.removeColonFromAnswers(op3.modifyList(level32ndLOP)));  
			softly.assertThat(newData1).as("test data").contains(obj.removeColonFromAnswers(op3.modifyList(level33rdLOP)));  
		}
		}catch(IllegalArgumentException j){
			System.out.println(j);
		}
		//Close pdf
		pddoc.close();
	}

	public void saveHiRCAReport(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		//Clicks on Save
		share2.scrollToTop(driver);
		WebElement topSavebtn=driver.findElement(By.id("efi-irca-button-save"));
		jse.executeScript("arguments[0].scrollIntoView();", topSavebtn);
		jse.executeScript("arguments[0].click();", topSavebtn);
		//Clicks on Save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title")));
		jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))));
		Thread.sleep(2000);
		share2.loadingServer(driver);		
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("11"))
			{
				share2.loadingServer(driver);	
				//Clicks on Save
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
				//Clicks on Save report
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title")));
				jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))));
				share2.loadingServer(driver);
			}
		}
		//Clicks on Saved activities
		WebElement savAc=driver.findElement(By.id("efi-irca-btn-savedactivities"));
		jse.executeScript("arguments[0].scrollIntoView();", savAc);
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))));
		share2.loadingServer(driver);
		//Clicks on side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		share2.loadingServer(driver);
	}


	public String selectLevel2Answer(WebDriver driver, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Fill reason entry
		//tbr.sizeCheck(driver, By.id("pii-irca-reason-entry"), softly);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason);
		//CLick on answer
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-"+n+"']"))));
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-"+n+"']"))).getText().trim();
		return s;
	}

	public Pair<MultiValuedMap<String,String>, List<String>> answerLOPRelatedQuestions(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel2Text obj1 = new HiRCALevel2Text();
		HiRCAHumanError obj2 = new HiRCAHumanError();
		List<String> combined = new ArrayList<String>();
		List<String> level2 = new ArrayList<String>();
		List<String> level3 = new ArrayList<String>();
		//Hashmaps for storing notes and answers
		MultiValuedMap<String,String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		//2.1
		//Choose option to select
		int n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		obj1.step2q21(driver, softly); //[2.1] Yes or No page Text Assert
		level2.add(selectLevel2Answer(driver,n)); //choose Yes or No
		Thread.sleep(1000);
		//Get note
		String note = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0) //n=0 > select Yes
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.17
			obj1.step2verify317(driver, softly);
			level3.addAll(selectOptions(driver,7));
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));
			combined.addAll(level2);
			combined.addAll(level3);
			//To return the Pair of List<String> and MultiValuedMap<String,String>
			return new MutablePair<MultiValuedMap<String,String>, List<String>>(hircaNoteLopSURE, combined);
		}
		
		/*
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.2
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		level2.add(selectLevel2Answer(driver,n));
		//Add answer to list
		obj1.step2q22(driver, softly);
		level2.add(selectLevel2Answer(driver,n));
		//get note
		String note1 = hfl123.getNoteShowingPreviousAnswer(driver);
		
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.16
			obj2.verify316(driver, softly);
			level3.addAll(selectOptions(driver,7));
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note1, level3));
			if((wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText().contains("LOP 1/3"))&&(driver.getCurrentUrl().contains("kaleqa")==false))
			{
				combined.addAll(level2);
				combined.addAll(level3);
				return new MutablePair<MultiValuedMap<String,String>, List<String>>(hircaNoteLopSURE, combined);
			}
			else
			{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//2.3 to 2.8
			Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions23To28(driver);
			level2.addAll(level2List(pairOfReturnVariables.getValue()));
			level3.addAll(level3List(pairOfReturnVariables.getValue()));
			hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());
			}
		}*/
	
		
		if(n==1) //n==1 > select No
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			
		//////am_added
					//2.2
					//Choose option to select
					int ss = obj.chooseRandomOption(3, 0);
					level2.add(selectLevel2Answer(driver,ss));
					//Add answer to list
					obj1.step2q22(driver,softly);
					level2.add(selectLevel2Answer(driver,ss)); //.//*[@for='efi-irca-answer-"+n+"']
					//get note
					String note1 = hfl123.getNoteShowingPreviousAnswer(driver);
					if(ss==0 || ss==3) { //[2.2] 0=Inattention-to detail, 3=All
						//Click next
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
						
						//Select random level 3 answers for 3.16
						obj2.verify316(driver, softly);
						level3.addAll(selectOptions(driver,7));
						hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note1, level3));
					}	
					if(ss==1) { //[2.2] 1=Inadequate or incorrect rules
						//Click next
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
						
						//2.3 random 3 options: Incompleteness, Incorrect rules, Both
						Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions23To28(driver);
						level2.addAll(level2List(pairOfReturnVariables.getValue()));
						level3.addAll(level3List(pairOfReturnVariables.getValue()));
						hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());
					}
					if(ss==2) { //[2.2] 2=None
						//Click next
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
						
					//2.9 to 2.12
					Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions29To212(driver);
					level2.addAll(level2List(pairOfReturnVariables.getValue()));
					level3.addAll(level3List(pairOfReturnVariables.getValue()));
					hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());
					//////am_added
					}
		}
		/* am_not applicable			
		if(n==2)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//2.9 to 2.12
			Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions29To212(driver);
			level2.addAll(level2List(pairOfReturnVariables.getValue()));
			level3.addAll(level3List(pairOfReturnVariables.getValue()));
			hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());
		}*/
		combined.addAll(level2);
		combined.addAll(level3);
		//To return the Pair of List<String> and MultiValuedMap<String,String>
		return new MutablePair<MultiValuedMap<String,String>, List<String>>(hircaNoteLopSURE, combined);
	}
	
	public List<String> level2List(List<String>combined) throws Exception{

		List<String> a = new ArrayList<String>();
		for(int i=0;i<combined.size();i++)
		{
			if(combined.get(i).startsWith("["))
				break;
			else
				a.add(combined.get(i));
		}		
		//System.out.println(a);
		return a;
	}

	public List<String> level3List(List<String>combined) throws Exception{

		List<String> a = new ArrayList<String>();
		for(int i=0;i<combined.size();i++)
		{
			if(combined.get(i).startsWith("[") == false)
				continue;
			else
				a.add(combined.get(i));
		}
		//System.out.println(a);
		return a;
	}

	public Pair<MultiValuedMap<String,String>, List<String>> followQuestions29To212(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel2Text obj1 = new HiRCALevel2Text();
		HiRCAHumanError obj2 = new HiRCAHumanError();
		List<String> combined = new ArrayList<String>();
		List<String> level2 = new ArrayList<String>();
		List<String> level3 = new ArrayList<String>();
		//Hashmaps for storing notes and answers
		MultiValuedMap<String,String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		//2.9
		//Choose option to select
		int n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		obj1.step2q29(driver, softly);
		level2.add(selectLevel2Answer(driver,n));
		//Get note
		String note = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0) //[2.9] Yes
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.12
			obj2.verify312(driver, softly);
			level3.addAll(selectOptions(driver,5));		
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));		
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.10
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		obj1.step2q210(driver, softly);
		level2.add(selectLevel2Answer(driver,n));
		//Get note
		String note1 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.13
			obj2.verify313(driver, softly);
			List<String> lopOptions = selectOptions(driver,4);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note1, lopOptions));
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.11
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		obj1.step2q211(driver, softly);
		level2.add(selectLevel2Answer(driver,n));
		//Get note
		String note2 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.14
			obj2.verify314(driver, softly);
			List<String> lopOptions = selectOptions(driver,5);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note2, lopOptions));
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.12
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		obj1.step2q212(driver, softly);
		level2.add(selectLevel2Answer(driver,n));
		//Get note
		String note3 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.15
			obj2.verify315(driver, softly);
			List<String> lopOptions = selectOptions(driver,4);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note3, lopOptions));
		}
		combined.addAll(level2);
		combined.addAll(level3);
		//To return the Pair of List<String> and MultiValuedMap<String,String>
		return new MutablePair<MultiValuedMap<String,String>, List<String>>(hircaNoteLopSURE, combined);
	}

	public Pair<MultiValuedMap<String,String>, List<String>> followQuestions23To28(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel2Text obj1 = new HiRCALevel2Text();
		HiRCAHumanError obj2 = new HiRCAHumanError();
		HiRCAHumanError2 obj3 = new HiRCAHumanError2();
		List<String> combined = new ArrayList<String>();
		List<String> level2 = new ArrayList<String>();
		List<String> level3 = new ArrayList<String>();
		//Hashmaps for storing notes and answers
		MultiValuedMap<String,String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		//2.3
		//Choose option to select
		int n = obj.chooseRandomOption(3, 0); 
		//Add answer to list
		obj1.step2q23(driver, softly);
		level2.add(selectLevel2Answer(driver,n));
		//Get note
		String note = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0) //[2.3] incompleteness  
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.6
			obj2.verify36(driver, softly);
			level3.addAll(selectOptions(driver,9));		
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
		}
		if(n==1) //[2.3] incorrect rules 
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.22
			obj3.verify322(driver, softly);
			level3.addAll(selectOptions(driver,5));
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));				
		}
		if(n==2) //[2.3] both
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.6
			obj2.verify36(driver, softly);
			level3.addAll(selectOptions(driver,9));			
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.22
			obj3.verify322(driver, softly);
			level3.addAll(selectOptions(driver,5));
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
		}
		
		
		/*
		if((wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText().contains("LOP 1/3"))&&(driver.getCurrentUrl().contains("kaleqa")==false))
		{
			combined.addAll(level2);
			combined.addAll(level3);
			return combined;
		}
		else
		{*/
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//}
		//2.4
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		obj1.step2q24(driver, softly);
		level2.add(selectLevel2Answer(driver,n));
		//Get note
		String note1 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0) //[2.4] yes
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.7
			obj2.verify37(driver, softly);
			List<String> lopOptions = selectOptions(driver,10);
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note1, lopOptions));			
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.5
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		obj1.step2q25(driver, softly);
		level2.add(selectLevel2Answer(driver,n));
		//Get note
		String note2 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0) //[2.5] yes
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.8
			obj2.verify38(driver, softly);
			List<String> lopOptions = selectOptions(driver,8);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note2, lopOptions));		
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.6
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		obj1.step2q26(driver, softly);
		level2.add(selectLevel2Answer(driver,n));
		//Get note
		String note3 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.9
			obj3.verify39(driver, softly);
			List<String> lopOptions = selectOptions(driver,6);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note3, lopOptions));		
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.7
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		obj1.step2q27(driver, softly);
		level2.add(selectLevel2Answer(driver,n));
		//Get note
		String note4 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.10
			obj3.verify310(driver, softly);
			List<String> lopOptions = selectOptions(driver,5);		
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note4, lopOptions));			
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.8
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		obj1.step2q28(driver, softly);
		level2.add(selectLevel2Answer(driver,n));
		//Get note
		String note5 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.11
			obj3.verify311(driver, softly);
			List<String> lopOptions = selectOptions(driver,5);		
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note5, lopOptions));			
		}
		combined.addAll(level2);
		combined.addAll(level3);
		//To return the Pair of List<String> and MultiValuedMap<String,String>
		return new MutablePair<MultiValuedMap<String,String>, List<String>>(hircaNoteLopSURE, combined);
	}

	public List<String> selectOptions(WebDriver driver, int count) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		
		List<String> ac = new ArrayList<String>();
		int x;
		//Select number of options to select between 1 to count
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
					System.out.println("print div number"+count+" : "+ y);
					WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+(y+1)+"]/fieldset/div/div/input")));
					if(e.isSelected())
					{
						ac.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+(y+1)+"]/fieldset/div/div/label"))).getText().trim());
						continue outer;
					}
					break;
				}
			System.out.println("print div numbe 2nd"+count+" : "+ y);
				//Click on answer
				
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+(y+1)+"]/fieldset/div/div/label")));
				//Scroll to element
				share2.scrollToElement(driver, l);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", l);
				//Get answer name and store in list
				String s1 = l.getText().trim();
				if(s1.substring(s1.length()-1, s1.length()).equals(" "))
					ac.add(s1.substring(0, s1.length()-1));
				else ac.add(s1);
				}	
			
		//Scroll to top
		share2.scrollToTop(driver);
		return ac;		
	}

	public List<String> select3LOPs(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCALevel2Text obj1 = new HiRCALevel2Text();
		List<String> a = new ArrayList<String>();
		//Click on Act of nature
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on Yes
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))));
		Thread.sleep(2000);
		//Verify Step 2 question 1
		obj1.step2Q20(driver, softly);
		//Select 3 LOPs randomly
		//Choose a number between 2 and 13 for LOPs
		Random random = new Random();
		int y;
		for(int i=0;i<3;i++)
		{
			while(true)
			{
				y=random.nextInt(9);
				//System.out.println("Chose a no"+y);
				if(y==0||y==1)
					continue;
				String e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getAttribute("class");
				if(e.contains("ui-checkbox-on"))
					continue;
				break;
			}
			//System.out.println("Picked a no");
			//System.out.println("Option no: "+y);
			Thread.sleep(500);
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			//Click on LOP
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			a.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getText().trim());
		}
		//Scroll to the top
		share2.scrollToTop(driver);
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		return a;
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
