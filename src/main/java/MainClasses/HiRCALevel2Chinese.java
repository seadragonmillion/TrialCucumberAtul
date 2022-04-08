import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import kaleTestSoftware.*;
import kaleTestSoftware.HiRCAChinese17;
import kaleTestSoftware.HiRCAChinese18;
import kaleTestSoftware.HiRCAChinese19;
import kaleTestSoftware.HiRCAChinese20;
import kaleTestSoftware.HiRCAChinese21;
import kaleTestSoftware.HiRCAChinese31;
import kaleTestSoftware.HiRCAChinese33;
import kaleTestSoftware.HiRCAChinese34;
import kaleTestSoftware.HiRCAChinese35;
import kaleTestSoftware.HiRCAChinese39;
import kaleTestSoftware.HiRCAChinese5;
import kaleTestSoftware.HiRCAChinese6;
import kaleTestSoftware.HiRCAFunctionsForLevel1_2_3;
import kaleTestSoftware.HiRCALevel2;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HiRCALevel2Chinese {

	public String text = "HiRCA Level 2 Chinese";
	SoftAssertions softly = new SoftAssertions();
	
	HiRCAFunctionsForLevel1_2_3 hfl123 = new HiRCAFunctionsForLevel1_2_3();
	HiRCAChinese5 hc5 = new HiRCAChinese5();
	HiRCAChinese6 hc6 = new HiRCAChinese6();
	HiRCAChinese17 hc17 = new HiRCAChinese17();
	HiRCAChinese18 hc18 = new HiRCAChinese18();
	HiRCAChinese19 hc19 = new HiRCAChinese19();
	HiRCAChinese20 hc20 = new HiRCAChinese20();
	HiRCAChinese21 hc21 = new HiRCAChinese21();
	HiRCAChinese31 hc31 = new HiRCAChinese31();
	HiRCAChinese33 hc33 = new HiRCAChinese33();
	HiRCAChinese34 hc34 = new HiRCAChinese34();
	HiRCAChinese35 hc35 = new HiRCAChinese35();
	HiRCAChinese39 hc39 = new HiRCAChinese39();
	ShareCheck share = new ShareCheck();
	ShareCheck2 share2 = new ShareCheck2();
	HiRCAObj hirca = new HiRCAObj();
	HiRCALOPBug2 hlb2 = new HiRCALOPBug2 ();

	public void pathHiRCALevel2(WebDriver driver) throws Exception{

		HiRCALevel2 obj3 = new HiRCALevel2();
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Hashmaps for storing notes and answers
		MultiValuedMap<String,String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		//create a new report
		hlb2.fillUpHiRCAEventInfo(driver, text);
		//Select3LOPs means 1. select "Act of Nature" and "Yes + random options"
		List<String> lopSelected = select3LOPs(driver);
		//Select answers for 1st lop
		Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables1 = answerLOPRelatedQuestions(driver);
		List<String> level21stLOP = obj3.level2List(pairOfReturnVariables1.getValue());
		List<String> level31stLOP = obj3.level3List(pairOfReturnVariables1.getValue()).stream().distinct().collect(Collectors.toList());
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Select answers for 2nd lop
		Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables2 = answerLOPRelatedQuestions(driver);
		List<String> level22ndLOP = obj3.level2List(pairOfReturnVariables2.getValue());
		List<String> level32ndLOP = obj3.level3List(pairOfReturnVariables2.getValue()).stream().distinct().collect(Collectors.toList());
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Select answers for 3rd lop
		Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables3 = answerLOPRelatedQuestions(driver);
		List<String> level23rdLOP = obj3.level2List(pairOfReturnVariables3.getValue());
		List<String> level33rdLOP = obj3.level3List(pairOfReturnVariables3.getValue()).stream().distinct().collect(Collectors.toList());
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Verify 2.20
		chineseQ220(driver);
		//2.20 - make some selections and click next
		List<String> list220 = selectAllLevel3(driver,12).stream().distinct().collect(Collectors.toList());
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.22 - skip
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Step 3 skip
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		/*Step 4 / Step 5 / Report/ pdf
		0=english
		1=chinese
		*/
		hircaNoteLopSURE.putAll(pairOfReturnVariables1.getKey());
		hircaNoteLopSURE.putAll(pairOfReturnVariables2.getKey());
		hircaNoteLopSURE.putAll(pairOfReturnVariables3.getKey());
		obj3.verifyRemainingSteps(driver,lopSelected,level31stLOP,level32ndLOP,level33rdLOP,level21stLOP,level22ndLOP,level23rdLOP,list220,1,hircaNoteLopSURE,softly);
	}
	
	public Pair<MultiValuedMap<String,String>, List<String>> answerLOPRelatedQuestions(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel2 obj1 = new HiRCALevel2();
		List<String> combined = new ArrayList<String>();
		List<String> level2 = new ArrayList<String>();
		List<String> level3 = new ArrayList<String>();
		//Hashmaps for storing notes and answers
		MultiValuedMap<String,String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		//2.1
		//Choose option to select
		int n = obj.chooseRandomOption(2, 0); //n=0 > Yes, n=1 > No
		Thread.sleep(1000);
		//Add answer to list
		chineseStep2q21(driver); //chineseStep2Q21: assert pagetext, yes and no
		Thread.sleep(5000);
		level2.add(obj1.selectLevel2Answer(driver,n)); //chineseStep2Q21: add Yes or No answer to list
		//Get note
		String note = hfl123.getNoteShowingPreviousAnswer(driver); //print chineseStep2Q21 Yes or No answer 
		if(n==0) //n=0 > select Yes
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			//Select random level 3 answers for 3.17
			hc33.chineseStepOneL317(driver, softly);
//			chineseStep2verify317(driver, softly);
			level3.addAll(selectAllLevel3(driver,7));
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));
			combined.addAll(level2);
			combined.addAll(level3);
			//To return the Pair of List<String> and MultiValuedMap<String,String>
		return new MutablePair<MultiValuedMap<String,String>, List<String>>(hircaNoteLopSURE, combined);
		}
		//Click next
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		
		/*am_tempt
		//2.2
		//Choose option to select
		n = obj.chooseRandomOption(3, 0);
		//Add answer to list
		chineseStep2q22(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//get note
		String note1 = hfl123.getNoteShowingPreviousAnswer(driver);
		*/

		/*am_n==0 > will connect to L317
		if(n==0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.16
			hc31.chineseStepOneL316(driver, softly);
			level3.addAll(selectAllLevel3(driver,7));
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));
			/*if((wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText().contains("LOP 1/3"))&&(driver.getCurrentUrl().contains("kaleqa")==false))
			{
				combined.addAll(level2);
				combined.addAll(level3);
				return combined;
			}
			else
			{*/
				//Click next
//am_tempt		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				//2.3 to 2.8
//am_tempt		Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions23To28(driver);
//am_tempt		level2.addAll(obj1.level2List(pairOfReturnVariables.getValue()));
//am_tempt		level3.addAll(obj1.level3List(pairOfReturnVariables.getValue()));
//am_tempt		hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());
		//	}
//		}
		
		if(n==1)//n==1 > select No
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			
			//////am_added
			//2.2
			//Choose option to select
			int ss = obj.chooseRandomOption(3, 0);
			//Add answer to list
			chineseStep2q22(driver);
			level2.add(obj1.selectLevel2Answer(driver,ss)); //.//*[@for='efi-irca-answer-"+n+"']
			//get note
			String note2 = hfl123.getNoteShowingPreviousAnswer(driver);
			if(ss==0 || ss==3) {
				//Click next
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				
				//Select random level 3 answers for 3.16
				hc31.chineseStepOneL316(driver, softly);
				level3.addAll(selectAllLevel3(driver,7));
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));
			}	
			if(ss==1) {
				//Click next
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				//2.3 (remove 2.4-2.8)
				Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions23To28(driver);
				level2.addAll(obj1.level2List(pairOfReturnVariables.getValue()));
				level3.addAll(obj1.level3List(pairOfReturnVariables.getValue()));
				hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());
			}
			if(ss==2) {
				//Click next
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
				
			//2.9 to 2.12
			Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions29To212(driver);
			level2.addAll(obj1.level2List(pairOfReturnVariables.getValue()));
			level3.addAll(obj1.level3List(pairOfReturnVariables.getValue()));
			hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());
			//////am_added
			
			/*am_not applicable
			//2.3 to 2.8
			Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions23To28(driver);
			level2.addAll(obj1.level2List(pairOfReturnVariables.getValue()));
			level3.addAll(obj1.level3List(pairOfReturnVariables.getValue()));
			hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());*/
			}
		}
		/*am_no n==2
		if(n==2)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//2.9 to 2.12
			Pair<MultiValuedMap<String,String>, List<String>> pairOfReturnVariables = followQuestions29To212(driver);
			level2.addAll(obj1.level2List(pairOfReturnVariables.getValue()));
			level3.addAll(obj1.level3List(pairOfReturnVariables.getValue()));
			hircaNoteLopSURE.putAll(pairOfReturnVariables.getKey());
		}*/
		
		combined.addAll(level2);
		combined.addAll(level3);
		//To return the Pair of List<String> and MultiValuedMap<String,String>
		return new MutablePair<MultiValuedMap<String,String>, List<String>>(hircaNoteLopSURE, combined);
	}
	
	public Pair<MultiValuedMap<String,String>, List<String>> followQuestions29To212(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel2 obj1 = new HiRCALevel2();
		List<String> combined = new ArrayList<String>();
		List<String> level2 = new ArrayList<String>();
		List<String> level3 = new ArrayList<String>();
		//Hashmaps for storing notes and answers
		MultiValuedMap<String,String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		//2.9
		//Choose option to select
		int n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q29(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0) //n==0, select Yes
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.12
			hc35.chineseStepOneL312(driver, softly);
			level3.addAll(selectAllLevel3(driver,5));			
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.10
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q210(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note1 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.13
			hc17.chineseStepOneL313(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,4);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note1, lopOptions));
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.11
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q211(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note2 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.14
			hc17.chineseStepOneL314(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,5);		
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note2, lopOptions));	
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.12
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q212(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note3 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.15
			hc39.chineseStepOneL315(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,4);			
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
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel2 obj1 = new HiRCALevel2();
		List<String> combined = new ArrayList<String>();
		List<String> level2 = new ArrayList<String>();
		List<String> level3 = new ArrayList<String>();
		//Hashmaps for storing notes and answers
		MultiValuedMap<String,String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		//2.3
		//Choose option to select
		int n = obj.chooseRandomOption(3, 0);
		//Add answer to list
		chineseStep2q23(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.6
			hc21.chineseStepOneL36(driver, softly);
			level3.addAll(selectAllLevel3(driver,9));			
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
		}
		if(n==1)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.22
			hc18.chineseStepOneL322(driver, softly);
			level3.addAll(selectAllLevel3(driver,5));
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
		}
		if(n==2) {
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.6
			hc21.chineseStepOneL36(driver, softly);
			level3.addAll(selectAllLevel3(driver,9));			
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.22
			hc18.chineseStepOneL322(driver, softly);
			level3.addAll(selectAllLevel3(driver,5));
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, level3));	
		}
		/*if((wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText().contains("LOP 1/3"))&&(driver.getCurrentUrl().contains("kaleqa")==false))
		{
			combined.addAll(level2);
			combined.addAll(level3);
			return combined;
		}
		else
		{*/
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//}
		//2.4
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q24(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note1 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.7
			hc19.chineseStepOneL37(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,10);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note1, lopOptions));	
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.5
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q25(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note2 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.8
			hc20.chineseStepOneL38(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,8);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note2, lopOptions));		
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.6
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q26(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note3 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.9
			hc39.chineseStepOneL39(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,6);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note3, lopOptions));		
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.7
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q27(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note4 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.10
			hc6.chineseStepOneL310(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,5);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note4, lopOptions));		
		}
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//2.8
		//Choose option to select
		n = obj.chooseRandomOption(2, 0);
		//Add answer to list
		chineseStep2q28(driver);
		level2.add(obj1.selectLevel2Answer(driver,n));
		//Get note
		String note5 = hfl123.getNoteShowingPreviousAnswer(driver);
		if(n==0)
		{
			//Click next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
			//Select random level 3 answers for 3.11
			hc6.chineseStepOneL311(driver, softly);
			List<String> lopOptions = selectAllLevel3(driver,5);			
			level3.addAll(lopOptions);	
			//Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note5, lopOptions));			
		}
		
		combined.addAll(level2);
		combined.addAll(level3);
		//To return the Pair of List<String> and MultiValuedMap<String,String>
		return new MutablePair<MultiValuedMap<String,String>, List<String>>(hircaNoteLopSURE, combined);
	}
	
	public List<String> selectAllLevel3(WebDriver driver, int count) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		List<String> ac = new ArrayList<String>();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		outer:
			for(int j=1;j<=count;j++)
			{
				//Select any answer between 1 and count
				//Choose a number between 1 and count
				WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+(j+1)+"]/fieldset/div/div/input")));
				if(e.isSelected())
				{
					ac.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+(j+1)+"]/fieldset/div/div/label"))).getText());
					continue outer;
				}					
				//Click on answer
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+(j+1)+"]/fieldset/div/div/label")));
				//Scroll to element
				share2.scrollToElement(driver, l);
				executor.executeScript("arguments[0].focus();", l);
				executor.executeScript("arguments[0].click();", l);
				//Get answer name and store in list
				String s1 = l.getText();
				ac.add(s1);	
			}
		//Scroll to top
		share2.scrollToTop(driver);
		return ac;		
	}
	
	public List<String> select3LOPs(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		List<String> a = new ArrayList<String>();
		//Click on Act of nature
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		Thread.sleep(2000);
		//Click on LOP
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		Thread.sleep(2000);
		//Click on Yes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-lopinplace-yes']"))).click();
		Thread.sleep(2000);
		//Verify Step 2 question 1
		chinesestep2Q20(driver);
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
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			//Click on LOP
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			a.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getText());
		}
		//Scroll to the top
		share2.scrollToTop(driver);
		//Click next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		return a;
	}
	
	public void chineseQ220(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(s).as("test data").contains("[2.20] 若此事件需额外的屏障，请选择所需屏障:");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("请选择执行后可防止这一失误再次发生的其它屏障。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Answers - LOPs
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("工前会、班前会、交底会等等");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("监护制");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("防护设计");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("独立检查");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("及时报警");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("及时提醒（标牌、禁止事项张贴）");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("实体保护（安全绳索、安全带等等）");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("同事提醒");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)).getText();
		softly.assertThat(s9).as("test data").isEqualTo("审查");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10)).getText();
		softly.assertThat(s10).as("test data").isEqualTo("自检");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer11)).getText();
		softly.assertThat(s11).as("test data").isEqualTo("组长监督");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer12)).getText();
		softly.assertThat(s12).as("test data").contains("其他:");
	}
	
	public void chineseStep2q212 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.12 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.12] 有意违反屏障要求是否由同事默许导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨了缺乏来自同事的提醒（好文化的存在）是否是故意违章导致屏障失效的原因。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q211 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.11 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.11] 有意违反屏障要求是否由预期风险低导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨了预期风险低是否导致屏障失效的原因。我们的研究发现当工作人员认为违规的风险较低时更容易违反规定。风险是两个方面的和。一个方面是被抓到的概率和受惩罚后果的乘积。另一方面是受伤的概率和受伤后果的乘积。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q210 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.10 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.10] 有意违反屏障要求是否由不当动机导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨故意违章使得屏障失效（如：简化屏障要求，比如不按照要求执行PJB等）是否是由于不当动机造成的，如：提前回家、逃避恶劣的工作环境等");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q29 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.9] 有意违反屏障要求是否由麻烦负担导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨故意违反是否是由于执行屏障时感觉麻烦负担造成的。麻烦负担是一种感觉，认为花费在执行屏障上的时间或努力都是不值得的。造成这种麻烦负担的原因有：问责机制存在不足、不理解屏障存在的必要性、过度规定繁琐屏障。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q28 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.8 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.8] 屏障失效是否由问责不足导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨了屏障失效是否是因为几乎没有问责机制导致没有执行所需屏障。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q27 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.7 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.7] 屏障失效是否由资质授权不足导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("授权是培训完成后的一种能力证明（类似获得驾照前的驾驶执照考试）。这个问题评估重点屏障的使用如审查和独立验证是否有授权考核。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q26 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.6 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.6] 屏障失效是否由培训不足导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨了屏障失效是否是由于缺少培训导致的。例如，如果员工没有接受过执行工前会的培训（课堂培训或在岗培训），导致缺工前会执行不到位或未执行。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q25 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.5 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.5] 屏障失效是否由规则模糊不明确导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨屏障失效是否是由于要求不明确导致的。例如，由于员工不理解什么工作需要工前会、什么不需要工前会，而不执行工前会。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q24 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.4 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.4] 屏障失效是否由偏差控制不妥导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("要正确执行屏障（如工前会），通常采用偏差控制措施。包括：行为标准、禁止事项警告、检查清单、工作现场提醒单、程序步骤标记等。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}
	
	public void chineseStep2q23 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.3 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.3] 屏障失效是由规则不全面还是规则不正确导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("屏障失效的两个情况为设计不完整或设计时规则不正确。屏障不完整的例子如：无法涵盖所有工况。例如，\"审查\"屏障不完整时，未要求审查人员验证假设的有效性。屏障不正确的情况，包含一些不正确的指令。例如，不正确的");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("规则不全面");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("规则有误");
	}
	
	public void chineseStep2q22 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.2 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.2] 屏障失效是由规则存在不足、规则不正确还是粗心犯错导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("这个问题探讨了屏障失效（如，未执行独立检查）是故意还是非故意的？");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("粗心犯错");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("规则存在不足或规则不正确");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("皆非");
	}
	
	public void chineseStep2q21 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析 - 屏障 ");
		//2.1 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.1] 屏障失效是由设备失效导致？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("一些屏障与为实体设备使用相关，如安全带、坠落保护带、及时警报等。设备故障的促成因素包括下列四类：授权存在不足、检查性试验不到位、维护存在不足、操作存在不足。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
	}	

	public void chinesestep2Q20(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		HiRCALevel2Text obj1 = new HiRCALevel2Text();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("第二步：屏障失效分析");
		//Question before 2.0
		String q11a = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.PageQuestionBefore20)).getText();		
		softly.assertThat(q11a).as("test data").contains("屏障是否存在能预防始发事件的发生？");
		//Description
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.DescriptionPlusSignBefore20)).click();
		String descTab = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.DescriptionPlusSignBefore20)).getText();
		softly.assertThat(descTab).as("test data").contains("描述");
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.DescriptionTextBefore20)).getText();
		softly.assertThat(lop3).as("test data").contains("屏障：为预防、侦测和阻止事件发生的机制。可以程序、实体保护或是行动来落实。");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.DescriptionPlusSignBefore20)).click();
		//Verify Yes 
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.AnswerYes)).getText();		
		softly.assertThat(ans1).as("test data").contains("是");
		//Verify No
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(obj1.AnswerNo)).getText();		
		softly.assertThat(ans2).as("test data").contains("否");
		//2.0 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.0] 请选择哪些失效屏障造成事件的发生(至多3个)？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans3).as("test data").contains("工前会、班前会、交底会等等");
		//Answer 2
		String ans4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans4).as("test data").contains("监护制");
		//Answer 3
		String ans5 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans5).as("test data").contains("防护设计");
		//Answer 1
		String ans6 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)).getText();		
		softly.assertThat(ans6).as("test data").contains("独立检查");
		//Answer 2
		String ans7 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)).getText();		
		softly.assertThat(ans7).as("test data").contains("及时报警");
		//Answer 3
		String ans8 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)).getText();
		softly.assertThat(ans8).as("test data").contains("及时提醒（标牌、禁止事项张贴）");
		//Answer 1
		String ans9 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)).getText();		
		softly.assertThat(ans9).as("test data").contains("实体保护（安全绳索、安全带等等）");
		//Answer 2
		String ans10 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)).getText();		
		softly.assertThat(ans10).as("test data").contains("同事提醒");
		//Answer 3
		String ans11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)).getText();
		softly.assertThat(ans11).as("test data").contains("审查");
		//Answer 1
		String ans12 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10)).getText();		
		softly.assertThat(ans12).as("test data").contains("自检");
		//Answer 2
		String ans13 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer11)).getText();		
		softly.assertThat(ans13).as("test data").contains("组长监督");
		//Answer 3
		String ans14 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer12)).getText();
		softly.assertThat(ans14).as("test data").contains("其他:");
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
