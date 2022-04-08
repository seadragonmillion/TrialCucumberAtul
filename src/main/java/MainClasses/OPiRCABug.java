import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import kaleTestSoftware.*;
import kaleTestSoftware.OPiRCA;
import kaleTestSoftware.OPiRCA3;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class OPiRCABug {

	ShareCheck share = new ShareCheck();
	OPiRCAPageObj op = new OPiRCAPageObj();
	OPiRCA3 op3 = new OPiRCA3();
	OPiRCA op1 = new OPiRCA();
	EiRCAPageObj eirca = new EiRCAPageObj();
	CreateEquipmentCase cec =  new CreateEquipmentCase();
	OPiRCAChinese opc = new OPiRCAChinese();
	ShareCheck2 share2 = new ShareCheck2();
	
	SoftAssertions softly = new SoftAssertions();

	public String text = "QAA Bug Test";
	
	public List<String> selectOneHiRCALevel3 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Scroll top
		share2.scrollToTop(driver);	
		//Click on dropdown field
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.HiRCADropdownMenuButton)).click();
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(op.HiRCADropdownMenuPopup));
		int y;
		//Choose a number between 1 and 31
		Random random = new Random();
		while(true)
		{
			y = random.nextInt(32);
			//if option is already checked then choose another number
			String s1 = ele.findElement(By.xpath(".//*[@data-option-index='"+y+"']/a")).getAttribute("class");
			if(y<1)
				continue;	    			
			else if(s1.contains("ui-checkbox-on"))
				continue;
			else 
				break;
		}	    		
		WebElement l = ele.findElement(By.xpath(".//*[@data-option-index='"+y+"']/a"));
		//Scroll to element
		share2.scrollToElement(driver, l);			
		//Click on option
		l.click();
		//Scroll to the top
		share2.scrollToTop(driver);
		//Close the pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.HiRCADropdownMenuCloseButton)).click();	  
		//Store apparent causes selected
		List<String> apparentCauseSelected = op1.storeApparentCauses(driver);
		apparentCauseSelected.add(String.valueOf(y));
		return apparentCauseSelected;
	}
	
	public HashMap<String,String> markHMLFillText(WebDriver driver,HashMap<String,Integer>options,List<String>apparentCausesAnswersNew) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		HashMap<String,String> hml= new HashMap<String,String>();
		//Get number of Root causes in Level 3 answers
		int count = options.get("Root causes");
		System.out.println("No of root causes:"+count);
		//Gets number of contributing factors
		int count1 = apparentCausesAnswersNew.size()-count;
		System.out.println("No of contributing factors:"+count1);	
		
/*	// Custom code to randomly select all the available HML
			List<WebElement> eleList = driver.findElements(By.xpath("//td[@class='pii-opa-td-hml']"));
			for (int t = 1; t < eleList.size(); t++) {
				int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
				Thread.sleep(1000);
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//td[@class='pii-opa-td-hml'])[" + t + "]//div/div[" + randomNum + "])"))));
				Thread.sleep(1000); 
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//td[@class='pii-opa-td-hml'])[" + t + "]//div/div[" + randomNum + "])"))));
				Thread.sleep(1000); 
			}*/
		
		//Click on H for RootCause
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[3]/fieldset/div/div[1]/label")));
		ele.click();
		hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[3]/fieldset/div/div[1]/label"))).getText(), "H");
		
		/*
		//tr starts at 2 and each root cause has 4 four rows
		int i=2;
		//Verify if any root causes are appearing
		while(i<=((count*3)+1))
		{
			//HML random select
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]")));
			//Scroll to element
			share2.scrollToElement(driver, ele);
			//Select a number between 0 to 3 for H,M,L
			Random random =new Random();
			int y=random.nextInt(4);
			if(y!=0)
			{
				//Click on H/M/L
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
				if(y==1)
					hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText(), "H");
				if(y==2)
					hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText(), "M");
				if(y==3)
					hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText(), "L");
			}
			else
				hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText(), "");
			//Increase i for extra root cause text boxes
			i=i+1;
			//Enter text in 1st box Extent of condition
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[1]"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[1]"))).sendKeys(text);
			//Enter text in 2nd box Operating Experience
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[2]"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[2]"))).sendKeys(text);
			//Enter text in 3rd box Safety Culture
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[3]"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[3]"))).sendKeys(text);
			//Increase i for corrective actions
			i=i+1;
			//Enter text in corrective actions
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[1]"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[1]"))).sendKeys(text);
			//Increase i for next root cause
			i=i+1;
		}
		//Verifies if any contributing factors
		//tr starts at 2 and each root cause has 4 four rows
		int start = i-1;
		//Verify if any contributing factors are appearing
		while(i<=((count1*2)+start))
		{
			//HML random select
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]")));
			//Scroll to element
			share2.scrollToElement(driver, ele);
			//Select a number between 0 to 3 for H,M,L
			Random random =new Random();
			int y=random.nextInt(4);
			if(y!=0)
			{
				//Click on H/M/L
				jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
				if(y==1)
					hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText(), "H");
				if(y==2)
					hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText(), "M");
				if(y==3)
					hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText(), "L");
			}
			else
				hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText(), "");
			//Increase i for changing corrective actions
			i=i+1;
			//Enter text in corrective actions
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[1]"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[1]"))).sendKeys(text);
			//Increase i for next contributing factor
			i=i+1;
		}*/
		//Scroll up
		share2.scrollToTop(driver);
		System.out.println("print out hml" +hml);
		return hml;
	}
	
	public void selectAllStep5 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Select all checkbox in Step 5
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5TableRow1Column3)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5TableRow2Column3)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5TableRow3Column3)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5TableRow4Column3)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5TableRow5Column3)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5TableRow6Column3)).click();
	}
	
	public void verifyStep3 (WebDriver driver, HashMap<String,Integer> options) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on Step 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep3Tab)).click();
		//Verify the apparent causes selected and the SURE selections
		for(int i =2;i<=options.size();i++)
		{
			//Get text of apparent answer
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText();
			int boxes = options.get(s);
			for (int j=1;j<=boxes;j++)
			{
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input")));
				//Click on checkbox of SURE
				if(l.isSelected()==false)
					softly.fail("box not selected: "+j+"/"+boxes);
			}
		}
		//Scroll up
		share2.scrollToTop(driver);
		share2.scrollToTop(driver);
	}
	
	public void verifyStep4 (WebDriver driver, HashMap<String,String> hml, HashMap<String,Integer> options) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);		
		//Get number of Root causes in Level 3 answers
		int count = options.get("Root causes");
		System.out.println("No of root causes:"+count);
		//Gets number of contributing factors
		int count1 = options.size()-count-1;
		System.out.println("No of contributing factors:"+count1);		
		//tr starts at 2 and each root cause has 4 four rows
		int i=2;
		//Verify if any root causes are appearing
		while(i<=((count*3)+1))
		{
			//Verify the H,M,L selection
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]")));
			//Select a number between 0 to 3 for H,M,L
			String imp = hml.get(ele.getText());
			System.out.println(ele.getText() + " :"+imp);
			if(imp.equals("")==false)
			{
				if((imp.equals("H"))&&(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[1]/input"))).getAttribute("checked").equals("false")))
					softly.fail("High not selected");
				if((imp.equals("M"))&&(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[2]/input"))).getAttribute("checked").equals("false")))
					softly.fail("Medium not selected");
				if((imp.equals("L"))&&(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[3]/input"))).getAttribute("checked").equals("false")))
					softly.fail("Low not selected");
			}
			else
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[1]/input"))).getAttribute("checked");
				}catch(NullPointerException t)
				{
					softly.fail("High selected for None");
				}
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[2]/input"))).getAttribute("checked");
				}catch(NullPointerException t)
				{
					softly.fail("Medium selected for None");
				}
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[3]/input"))).getAttribute("checked");
				}catch(NullPointerException t)
				{
					softly.fail("Low selected for None");
				}
			}
			//Increase i for extra root cause text boxes
			i=i+1;
			//Enter text in 1st box Extent of condition
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[1]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo(text);
			//Enter text in 2nd box Operating Experience
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[2]"))).getText();
			softly.assertThat(s1).as("test data").isEqualTo(text);
			//Enter text in 3rd box Safety Culture
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[3]"))).getText();
			softly.assertThat(s2).as("test data").isEqualTo(text);
			//Increase i for corrective actions
			i=i+1;
			//Enter text in corrective actions
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[1]"))).getText();
			softly.assertThat(s3).as("test data").isEqualTo(text);
			//Increase i for next root cause
			i=i+1;
		}
		//Verifies if any contributing factors
		//tr starts at 2 and each root cause has 4 four rows
		int start = i-1;
		//Verify if any contributing factors are appearing
		while(i<=((count1*2)+start))
		{
			//Verify the H,M,L selection
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]")));
			//Select a number between 0 to 3 for H,M,L
			String imp = hml.get(ele.getText());
			System.out.println(ele.getText() + " :"+imp);
			if(imp.equals("")==false)
			{
				if((imp.equals("H"))&&(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[1]/input"))).getAttribute("checked").equals("false")))
					softly.fail("High not selected for " +ele.getText());
				if((imp.equals("M"))&&(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[2]/input"))).getAttribute("checked").equals("false")))
					softly.fail("Medium not selected for " +ele.getText());
				if((imp.equals("L"))&&(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[3]/input"))).getAttribute("checked").equals("false")))
					softly.fail("Low not selected for " +ele.getText());
			}
			else
			{
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[1]/input"))).getAttribute("checked");
				}catch(NullPointerException t)
				{
					softly.fail("High selected for None for " +ele.getText());
				}
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[2]/input"))).getAttribute("checked");
				}catch(NullPointerException t)
				{
					softly.fail("Medium selected for None for " +ele.getText());
				}
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[3]/input"))).getAttribute("checked");
				}catch(NullPointerException t)
				{
					softly.fail("Low selected for None for " +ele.getText());
				}
			}
			//Increase i for changing corrective actions
			i=i+1;
			//Enter text in corrective actions
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea[1]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo(text);
			//Increase i for next contributing factor
			i=i+1;
		}
		//Scroll up
		share2.scrollToTop(driver);
		share2.scrollToTop(driver);
	}
	
	public void verifyStep5 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5TableRow1Column3)).isSelected()==false)
			softly.fail("box 1 not selected in step 5");
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5TableRow2Column3)).isSelected()==false)
			softly.fail("box 2 not selected in step 5");
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5TableRow3Column3)).isSelected()==false)
			softly.fail("box 3 not selected in step 5");
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5TableRow4Column3)).isSelected()==false)
			softly.fail("box 4 not selected in step 5");
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5TableRow5Column3)).isSelected()==false)
			softly.fail("box 5 not selected in step 5");
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5TableRow6Column3)).isSelected()==false)
			softly.fail("box 6 not selected in step 5");
	}
	
	public HashMap<String, List<String>> dAnswersMatchedToApparentCauses() throws Exception {

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		//O1
		List<String> l31= new ArrayList<>(Arrays.asList("D1.3","D4.2","D4.4"));
		map.put("O1", l31);
		//O3
		List<String> l32= new ArrayList<>(Arrays.asList("D1.2","D2.4","D4.5","D7.2"));
		map.put("O3", l32);
		//O5
		List<String> l331= new ArrayList<>(Arrays.asList("D1.4","D4.3","D6.3","D9.2","D12.2"));
		map.put("O5", l331);	  
		//OO1
		List<String> l332= new ArrayList<>(Arrays.asList("D5.4"));
		map.put("OO1", l332);
		//OO2
		List<String> l333= new ArrayList<>(Arrays.asList("D5.4"));
		map.put("OO2", l333);
		//OO3
		List<String> l334= new ArrayList<>(Arrays.asList("D5.4"));
		map.put("OO3", l334);
		//OP1
		List<String> l335= new ArrayList<>(Arrays.asList("D3.6","D12.3"));
		map.put("OP1", l335);
		//OP2
		List<String> l336= new ArrayList<>(Arrays.asList("D9.4"));
		map.put("OP2", l336);
		//OP3
		List<String> l337= new ArrayList<>(Arrays.asList("D10.1"));
		map.put("OP3", l337);
		//OP4
		List<String> l338= new ArrayList<>(Arrays.asList("D5.3","D9.3"));
		map.put("OP4", l338);
		//P1
		List<String> l339= new ArrayList<>(Arrays.asList("D3.2"));
		map.put("P1", l339);
		List<String> l3310= new ArrayList<>(Arrays.asList("D3.3"));
		//P2
		map.put("P2", l3310);
		List<String> l3311= new ArrayList<>(Arrays.asList("D3.4"));
		//P3
		map.put("P3", l3311);
		List<String> l3312= new ArrayList<>(Arrays.asList("D3.5"));
		//P4
		map.put("P4", l3312);
		//P5
		List<String> l36= new ArrayList<>(Arrays.asList("D2.5","D7.3","D11.2"));
		map.put("P5", l36);
		return map;
	}
	
	public int pickOneApparentCause (WebDriver driver, List<String> apparentCauseSelected) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		if(apparentCauseSelected.size()>1)
		{
			Random random = new Random();
			int n = random.nextInt(apparentCauseSelected.size());
			for(int i=0; i<n;i++)
			{
				//Skip
				wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)).click();
			}	
			return n;
		}
		else
		{
			return 0;
		}
	}
	
	public List<String> decideDOption (WebDriver driver, int index, List<String> apparentCauseSelected) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		String s = apparentCauseSelected.get(index);
		//Get hashmap of D# and apparent causes
		HashMap<String, List<String>> hm = dAnswersMatchedToApparentCauses();
		//Extract number of apparent cause before :
		String ac = s.substring(0, s.indexOf(":"));
		//Get list of D# answers from map corresponding to ac
		List<String> dAnswers = hm.get(ac);
		//Pick one of the options from D# answers
		Random random = new Random();
		int n = random.nextInt(dAnswers.size());
		System.out.println(dAnswers.get(n));
		//Get Number of D# question as string then convert to integer
		String dQuestion = dAnswers.get(n).substring(1, dAnswers.get(n).indexOf("."));
		int dQuestionNumber = Integer.parseInt(dQuestion);
		System.out.println(dQuestion + " "+dQuestionNumber);
		//Skip till D# question dQuestionNumber
		for(int i=1; i<dQuestionNumber;i++)
		{
			System.out.println(i);
			//Skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)).click();
		}
		//Get the answer option from dAnswers.get(n)
		String dQuestionAnswer = dAnswers.get(n).substring(dAnswers.get(n).indexOf(".")+1, dAnswers.get(n).length());
		//Click on answer
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+(Integer.parseInt(dQuestionAnswer)+1)+"]/fieldset/div/div/label")));
		//Scroll to element
		share2.scrollToElement(driver, l);
		l.click();
		//Scroll up 
		share2.scrollToTop(driver);
		//Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)).click();
		System.out.println(apparentCauseSelected);
		List<String> onlyOneApparentCause = new ArrayList<String>();
		onlyOneApparentCause.add(apparentCauseSelected.get(index));
		System.out.println(onlyOneApparentCause);
		//Select some apparent cause answers
		List<String> answers = op3.selectApparentCausesAnswers(driver, onlyOneApparentCause,softly);
		//Scroll up 
		share2.scrollToTop(driver);
		//Skip till Step 3
		for(int i=dQuestionNumber+1; i<=12;i++)
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)).click();
		}		
		answers.add(String.valueOf(dQuestionNumber));
		return answers;
	}
	
	public void verifyStep3WithAnswerPresence (WebDriver driver, List<String> modifiedListApparentCausesAnswers) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,5);
		int i=2;
		while(true)
		{
			try{
				//Get text of apparent cause answer
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText();
				softly.assertThat(s).as("test data").isIn(modifiedListApparentCausesAnswers);
				i=i+1;
			}catch(org.openqa.selenium.TimeoutException e)
			{
				break;
			}
		}	
	}
	
	public void unselectHiRCALevel (WebDriver driver, String hircaLevelOption) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Scroll top
		share2.scrollToTop(driver);	
		//Click on Step 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep1Tab)).click();
		//Scroll top
		share2.scrollToTop(driver);	
		//Click on dropdown field
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.HiRCADropdownMenuButton)).click();
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(op.HiRCADropdownMenuPopup));
		WebElement l = ele.findElement(By.xpath(".//*[@data-option-index='"+hircaLevelOption+"']/a"));
		//Scroll to element
		share2.scrollToElement(driver, l);			
		//Click on option
		l.click();
		//Scroll to the top
		share2.scrollToTop(driver);
		//Close the pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.HiRCADropdownMenuCloseButton)).click();	  
	}
	
	public void clearDAnswer (WebDriver driver, String dQuestion) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		int dQuestionNumber = Integer.parseInt(dQuestion);
		//Skip till D# question dQuestionNumber
		for(int i=1; i<dQuestionNumber;i++)
		{
			//Skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)).click();
		}
		//Clear D answers
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.DQuestionAnswersClearButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASaveConfirmButton)).click();
		//Wait for popup to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(op.OPiRCASaveConfirmButton));
		//Skip till Step 3
		for(int i=dQuestionNumber; i<=12;i++)
		{
			//Skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)).click();
		}
	}
	
	public void verifyStep3Empty (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,3);
		//Get text of boxes under sure and check all n/a
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("n/a");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(s1).as("test data").isEqualTo("n/a");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("n/a");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[4]"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo("n/a");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[2]/td[5]"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo("n/a");
		//Verify no 3rd row
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[3]/td[1]")));
			softly.fail("Third row present with text: " + wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[3]/td[1]"))).getText());
		}catch (org.openqa.selenium.TimeoutException t)
		{
			
		}
	}
	
	public List<String> selectApparentCausesAnswers(WebDriver driver,List<String> apparentCauses) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,5);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Create a list to store any apparent cause answer selected
		List<String> ac = new ArrayList<String>();
		int c=1;
		while(c==1)
		{
			//Get title of page and see if it is same as apparent Causes
			String title = wait.until(ExpectedConditions.visibilityOfElementLocated(op.PageTitle)).getText();
			String title_expected = apparentCauses.get(0).substring((apparentCauses.get(0).indexOf(": ")+2), apparentCauses.get(0).length());
			if(title.contains(title_expected)==true)
				break;
			else 
			{
				//Click on skip
				wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)).click();
			}
		}
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
		//Get answers list
		ac.addAll(op3.selectOptions(driver,count,softly));
		//Add contributing factor
		String s = op3.addContributingFactor(driver, count+1);
		ac.add(s);
		//Scroll to top
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		//Click on next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));    	
		return ac;
	}

	public void opircaBugKALE2268Path (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.AnalysisLink)).click();
		//Clicks on OPiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCALink)).click();
		//Click on info tab
//		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-opa-tab-0"))));
		Thread.sleep(3000);
		//Click on +new button
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-opa-button-new"))));
		Thread.sleep(500);
		try{
			WebElement newButton = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("pii-opa-dialog-confirmed")));
			newButton.click();
					}catch(org.openqa.selenium.WebDriverException t)
					{
					}
	    //Wait for loading message
			share2.loadingServer(driver);
			
		//Fill mandatory details on Info page and click next
		opc.chineseEventInfoFill(driver,text);
	  //Clicks on skip button on Info Page:Sequence of Event
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)));
		//Select only one
		//Select HiRCA options for level 3
		List<String> apparentCauseSelected = selectOneHiRCALevel3(driver);
		//Seperate the option of Hirca Level index from list from apparentCauseSelected list
		String hircaLevelOption = apparentCauseSelected.get(apparentCauseSelected.size()-1);
		apparentCauseSelected.remove(hircaLevelOption);
		//Next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		//Pick one of the apparent causes selected if multiple
		int index = pickOneApparentCause(driver,apparentCauseSelected);
		//Select apparent cause answers
		List<String> oneApparentCause = new ArrayList<String>();
		oneApparentCause.add(apparentCauseSelected.get(index));
		System.out.println(oneApparentCause);
		List<String> apparentCausesAnswersNew1 = selectApparentCausesAnswers(driver, oneApparentCause);
		for(int i=index+1; i<apparentCauseSelected.size();i++)
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)).click();
		}
		//Figure out which D question to select
		List<String> answers = decideDOption(driver,index,apparentCauseSelected);
		//Seperate the option of D # question from list from answers list
		String dQuestionNumber = answers.get(answers.size()-1);
		answers.remove(dQuestionNumber);
		//combine both answers
		answers.addAll(apparentCausesAnswersNew1);
		List<String> apparentCausesAnswersNew = answers.stream().distinct().collect(Collectors.toList());
		//Verify the answers are present on Step 3
		verifyStep3WithAnswerPresence(driver,op3.modifyList(apparentCausesAnswersNew));
		//Go to step1 and unselect the hirca level option
		unselectHiRCALevel(driver,hircaLevelOption);
		//Skip
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)));
		//Go to D# question and clear all answers and skip till Step 3
		clearDAnswer(driver,dQuestionNumber);
		//Verify Step 3 has no answers
		verifyStep3Empty(driver);	
		System.out.println("2nd bug verify finished");
	}

	public void opircaBugKALE2138Path (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Wait for loading message
		share2.loadingServer(driver);
		//Click on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.AnalysisLink)).click();
		//Clicks on OPiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCALink)).click();
		//Fill mandatory details on Info page and click next
		opc.chineseEventInfoFill(driver,text);
	//Clicks on skip button on Info Page:Sequence of Event
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)));
		//Select only one
		//Select HiRCA options for level 3
		List<String> apparentCauseSelected = selectOneHiRCALevel3(driver);
		//Next
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		//Select options under the 1st apparentCause
		List<String> oneApparentCause = new ArrayList<String>();
		oneApparentCause.add(apparentCauseSelected.get(0));
		List<String> apparentCausesAnswersNew1 = op3.selectApparentCausesAnswers(driver, oneApparentCause,softly);
		List<String> apparentCausesAnswersNew = apparentCausesAnswersNew1.stream().distinct().collect(Collectors.toList());
		//Skip till question D1
		for (int i=1;i<apparentCauseSelected.size()-1;i++)
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)).click();
		}
		//Skip all Step 2 questions
		for (int i=0;i<12;i++)
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)).click();
		}
		//Mark SURE
		HashMap<String,Integer> options = op1.markSUREStep3(driver, apparentCausesAnswersNew);
		//Next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		//Select HML
		HashMap<String,String> hml = markHMLFillText(driver,options,apparentCausesAnswersNew);
		//Next
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		//Step 5
		selectAllStep5(driver);
		//Click next to go to Report Tab
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		//Click on Step 2
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep2Tab)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep2Tab)));
		//Select D1 as no
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAApparentCauseAnswer1)).click();
		//Verify Step 3,4,5 and Report Tab are enabled
		verifyStep3(driver,options);
		//Next
  	jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
//	verifyStep4(driver,hml,options);
		//Next
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		verifyStep5(driver);
	}
	
	public void opircaBugKALE2011Path (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on new button
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.NewButton)));
		//Click on +new button
				jse.executeScript("arguments[0].click();", driver.findElement(By.id("efi-opa-button-new")));
				try{
					WebElement newButton = new WebDriverWait(driver, 30).until(
					        ExpectedConditions.elementToBeClickable(By.id("pii-opa-dialog-confirmed")));
					newButton.click();
							}catch(org.openqa.selenium.WebDriverException t)
							{
								jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'new report')]"))));
							}
	//Wait for loading message
		share2.loadingServer(driver);
		//Click on Analysis
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[text()='Analysis']"))).click();
		//Clicks on OPiRCA
//		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCALink)).click();
		
		//Fill mandatory details on Info page and click next
		opc.chineseEventInfoFill(driver,text);
	  //Clicks on skip button on Info Page:Sequence of Event
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)));
		//Click on skip Step 1
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)));
		//Select No for D1
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAApparentCauseAnswer1)).click();
		//Next
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		//D2.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAApparentCauseAnswer2)).click();
		//Next
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		//OP1.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAApparentCauseAnswer1)).click();
		//Next
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		//D3.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAApparentCauseAnswer6)).click();
		//Next
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		//OP1.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAApparentCauseAnswer2)).click();
		//Next
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		//Skip d4 to d12 and Step 3/4/5= 9+3 skips 
		for(int i=1;i<=12;i++)
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASkipButton)).click();
		}
		//Click on Step 2 tab
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep2Tab)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep2Tab)));
		//Next on D1
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCANextButton)));
		//Clear D2
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.DQuestionAnswersClearButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCASaveConfirmButton)).click();
		//Wait for popup to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(op.OPiRCASaveConfirmButton));
		share2.scrollToTop(driver);
		//Click on Step 3
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep3Tab)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep3Tab)));
		//Verify Step 3 title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(op.PageTitle)).getText();
		softly.assertThat(s).as("test data").contains("Step 3");
		share2.scrollToTop(driver);
		//Click on Step 4
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep4Tab)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep4Tab)));
		//Verify Step 4 title
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(op.PageTitle)).getText();
		softly.assertThat(s1).as("test data").contains("Step 4");
		//Click on Step 5
		share2.scrollToTop(driver);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5Tab)).click();
		//Verify Step 5 title
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(op.PageTitle)).getText();
		softly.assertThat(s2).as("test data").contains("Step 5");
		share2.scrollToTop(driver);
		//Click on Report Tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAReportTab)).click();
		//Verify Report Tab by looking for finalize button and download button
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAFinalizeButton));
		wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAReportTabDownloadButton));
		//Event information table title
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='module-opa-rpt']/div[1]/table/tbody/tr[2]/td[1]")));
		share2.scrollToTop(driver);
		//Click on Step 5
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5Tab)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(op.OPiRCAStep5Tab)));
		//Verify Step 5 title
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(op.PageTitle)).getText();
		softly.assertThat(s3).as("test data").contains("Step 5");
	}
	
	public void pathForAllBugs(WebDriver driver) throws Exception{
		
		//KALE 2138 / QAA 614
//  	opircaBugKALE2138Path(driver);
		//KALE 2268 / QAA 613
  	opircaBugKALE2268Path(driver);
		//KALE 2011
  	opircaBugKALE2011Path(driver);
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}