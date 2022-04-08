import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import kaleTestSoftware.*;
import kaleTestSoftware.HiRCAChinese;
import kaleTestSoftware.LanguageCheckOfReports;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OPiRCA2 {

	ShareCheck share = new ShareCheck();
	EiRCAPageObj eirca = new EiRCAPageObj ();
	EiRCA2 eirca2 = new EiRCA2();
	EiRCA3 eirca3 = new EiRCA3();
	OPiRCAPageObj opirca = new OPiRCAPageObj();
	OPiRCA3 op3 = new OPiRCA3();
	TextBoxResizing tbr = new TextBoxResizing ();
	ShareCheck2 share2 = new ShareCheck2();

	public void verifyOrderOfRootCausesContributingFactorsInStep4(WebDriver driver,List<String> apparentCausesSelected, SoftAssertions softly, int count, int i, int rc, int start, int num) throws Exception{

//		WebDriverWait wait = new WebDriverWait(driver,10);
//		//Verify order
//		//Counter for list
//		int n = 0;
//		System.out.println("Size:"+apparentCausesSelected.size());
//		while(i<=((count*num)+start))
//		{
//			//Get name of level 3 answer
//			String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
//			softly.assertThat(level3).as("test data").isEqualTo(apparentCausesSelected.get(n));
//			System.out.println(level3+"\n"+apparentCausesSelected.get(n));
//			n = n+1;
//			//rc=1 means root cause else contributing factor
//			if(rc==1)
//			{
//				//Increase i for extra root cause text boxes
//				i=i+1;
//			}
//			//Increase i for changing corrective actions
//			i=i+1;
//			//Increase i for next root cause
//			i=i+1;
//		}
	}

	public void step2HTML(WebDriver driver, SoftAssertions softly, int rc, List<String>step2QuestionAnswers, List<String>step2ApparentCausesAnswers, List<String>apparentCausesAnswersNew) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,3);
		System.out.println(step2QuestionAnswers);
		int i = 1;
		//Counter for answers to d1 to d12
		int j = 0;
		int start = 0;
		while (true)
		{
			Thread.sleep(500);
			try{
				System.out.println(i);
				//div for step 2 will be rc+6
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+(rc+6)+"]/table/tbody/tr["+i+"]/td[2]"))).getText().trim();
				int m = s.indexOf(":");
				String s1 = s.substring(m+2, s.length());
				System.out.println("step2 html "+s);
				if(j<12){/*
				if(s.contains("D1.1: "))
				{
					String s2 = s1.substring(6, s1.length());
					softly.assertThat(s2).as("test data").isEqualTo(step2QuestionAnswers.get(j));
				}
				else*/
					softly.assertThat(s).as("test data").isEqualTo(step2QuestionAnswers.get(j));
				}
				j=j+1;
				if(s.startsWith("D9.")||s.startsWith("D12."))
				{
					if(s1.equals("Yes")||s1.equals("是"))
					{
						i=i+1;
						String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+(rc+6)+"]/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
						if(s2.contains("is in conflict with answers")==true)
							i=i+1;
					}
					else
					{
						i=i+1;
						int k = verifyApparentCauseAnswersStep2HTML(driver,softly,step2ApparentCausesAnswers,rc,i,start,apparentCausesAnswersNew);
						start = k-1;
						i=i+1;
						System.out.println("end of try catch "+i);
					}
				}
				else if(s.startsWith("D10."))
				{
					if(s1.contains("High")||s1.contains("高（大于0.2）"))
					{
						i=i+1;
						String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+(rc+6)+"]/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
						if(s2.contains("is in conflict with answers")==true)
							i=i+1;
					}
					else
					{
						i=i+1;
						int k = verifyApparentCauseAnswersStep2HTML(driver,softly,step2ApparentCausesAnswers,rc,i,start,apparentCausesAnswersNew);
						start = k-1;
						i=i+1;
						System.out.println("end of try catch "+i);
					}
				}
				else if(s1.equals("No"))
				{
					i=i+1;
					String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+(rc+6)+"]/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
					if(s2.contains("is in conflict with answers")==true)
						i=i+1;
				}
				else
				{
					i=i+1;
					int k = verifyApparentCauseAnswersStep2HTML(driver,softly,step2ApparentCausesAnswers,rc,i,start,apparentCausesAnswersNew);
					start = k-1;
					i=i+1;
					System.out.println("end of try catch "+i);
				}
			}catch(org.openqa.selenium.TimeoutException r)
			{
				System.out.println(r);
				break;
			}
		}	
	}

	public int verifyApparentCauseAnswersStep2HTML(WebDriver driver, SoftAssertions softly, List<String>step2ApparentCausesAnswers, int rc, int i, int start, List<String>apparentCausesAnswersNew) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,1);
		int j=0;
		System.out.println(i);
		//count no of apparent causes under each question of step 2
		while(true)
		{
			try{
				j=j+1;
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+(rc+6)+"]/table/tbody/tr["+i+"]/td/div/table/tbody/tr["+j+"]/td[1]")));
			}catch(org.openqa.selenium.TimeoutException e)
			{
				break;
			}
		}
		//Create a sublist
		List<String> sub = new ArrayList<String>();
		for(int k = start; k<j;k++ )
		{
			String s = step2ApparentCausesAnswers.get(k).replace("[", "");
			String s1 = s.replace("]", "");
			sub.add(s1);
		}
		//Verify the apparent cause is in the sub list
		for(int k=1;k<j;k++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div["+(rc+6)+"]/table/tbody/tr["+i+"]/td/div/table/tbody/tr["+k+"]/td[1]"))).getText().trim();
			if(sub.contains(s)==false)
			{
				if(apparentCausesAnswersNew.contains(s)==false)
					softly.fail("Apparent cause not selected, yet is appearing in HTML under step2 "+s+"\n"+sub+"\n"+apparentCausesAnswersNew);
			}
		}
		System.out.println("end of apparent cause function "+i);
		return j;
	}

	public int getOptionsForStep2(WebDriver driver) throws Exception {

		int count = 0;
		int k=1;
		//Identify number of answers for an apparent cause
		while(true)
		{
			try{
				String s = driver.findElement(By.xpath(".//*[@id='efi-opa-answers']/div["+k+"]")).getAttribute("class");
				k=k+1;
				if(s.equals("ui-contain"))
					count = count +1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}
		return count;
	}

	public List<String> opircaStep2(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Create list to add all apparent cause answers
		List<String> ac = new ArrayList<String>();
		//D1: integer is total no of answers in d1
		List<String> d1 = selectStep2D(driver,4,0,softly);
		//Select apparent cause for d1
		if(Integer.parseInt(d1.get(1))>0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		//D2: integer is total no of answers in d2
		d1.addAll(selectStep2D(driver,7,0,softly));
		//Select apparent cause for d1
		if(Integer.parseInt(d1.get(3))>0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();			
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		//D3: integer is total no of answers in d3
		d1.addAll(selectStep2D(driver,6,0,softly));
		//Select apparent cause for d3
		if(Integer.parseInt(d1.get(5))>0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		//D4: integer is total no of answers in d4
		d1.addAll(selectStep2D(driver,5,0,softly));
		//Select apparent cause for d4
		if(Integer.parseInt(d1.get(7))>0)
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		//D5: integer is total no of answers in d5
		d1.addAll(selectStep2D(driver,4,0,softly));
		//Select apparent cause for d5
		if(Integer.parseInt(d1.get(9))>0)
		{

			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
			if(Integer.parseInt(d1.get(9))==3)
			{
				//Click next for oo2
				wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
				//Select Apparent cause answers
				ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
				share2.scrollToTop(driver);
				//Click next for oo3
				wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
				//Select Apparent cause answers
				ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
				share2.scrollToTop(driver);
			}
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		//D6: integer is total no of answers in d6
		d1.addAll(selectStep2D(driver,4,0,softly));
		//Select apparent cause for d6
		if(Integer.parseInt(d1.get(11))>0)
		{

			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
			if(Integer.parseInt(d1.get(11))==3)
			{
				//Click next for p2
				wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
				//Select Apparent cause answers
				ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
				share2.scrollToTop(driver);
			}
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		//D7: integer is total no of answers in d7
		d1.addAll(selectStep2D(driver,4,0,softly));
		//Select apparent cause for d6
		if(Integer.parseInt(d1.get(13))>0)
		{

			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
			if(Integer.parseInt(d1.get(13))==3)
			{
				//Click next for p2
				wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
				//Select Apparent cause answers
				ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
				share2.scrollToTop(driver);
			}
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		//D8: integer is total no of answers in d8
		share2.loadingServer(driver);
		String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.PageTitle)).getText();
		softly.assertThat(q1).as("test data").contains("[D8] Has there been a recent event (in the past year) where precursors were known beforehand, but not managed?");
		d1.addAll(selectStep2D(driver,2,0,softly));
		//Select apparent cause for d8
		if(Integer.parseInt(d1.get(15))==0)
		{

			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
			
			//am_temp added
			//Click next for pp1
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
			//Click next for pp2
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
		}
		
		//Click next
				wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		//D9: integer is total no of answers in d9
		d1.addAll(selectStep2D(driver,5,0,softly));
		//Select apparent cause for d9
		if(Integer.parseInt(d1.get(17))>0)
		{

			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		//D10: integer is total no of answers in d10
		d1.addAll(selectStep2D(driver,2,0,softly));
		//Select apparent cause for d10
		if(Integer.parseInt(d1.get(19))==0)
		{
			//Click next for op2
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
			//Click next for op3
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
			/*am_temp removed, wait for verify
			//Click next for pp1
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
			//Click next for pp2
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
			*/
			//Click next for o5
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		//D11: integer is total no of answers in d11
		share2.loadingServer(driver);
		String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.PageTitle)).getText();
		softly.assertThat(q2).as("test data").contains("[D11] Is the supervisory time in he field inadequate (<20%) to interact with workers?");
		//softly.assertAll();
		d1.addAll(selectStep2D(driver,3,0,softly));
		//Select apparent cause for d6
		if(Integer.parseInt(d1.get(21))>0)
		{

			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
			if(Integer.parseInt(d1.get(21))==2)
			{
				//Click next for p2
				wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
				//Select Apparent cause answers
				ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
				share2.scrollToTop(driver);
			}
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		//D12: integer is total no of answers in d12
		d1.addAll(selectStep2D(driver,4,0,softly));
		//Select apparent cause for d9
		if(Integer.parseInt(d1.get(23))>0)
		{

			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
			//Select Apparent cause answers
			ac.addAll(op3.selectOptions(driver,getOptionsForStep2(driver),softly));
			share2.scrollToTop(driver);
		}
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		//Create a list to combine d1 and d12 answers and apparent causes selected 
		List<String> combinedStep2 = new ArrayList<String>();
		for(int i=0;i<d1.size();i=i+2)
		{
			combinedStep2.add(d1.get(i));
		}
		System.out.println("combinedstep2: "+combinedStep2);
		combinedStep2.addAll(ac);
		return combinedStep2;
	}

	public List<String> step2QuestionsAnswersOnly(List<String> combined) throws Exception {

		List<String> b = new ArrayList<String>();
		for(int i=0;i<12;i++)
			b.add(combined.get(i));
		return b;
	}

	public List<String> step2ApparentCausesAnswersOnly(List<String> combined) throws Exception {

		List<String> b = new ArrayList<String>();
		for(int i=12;i<combined.size();i++)
			b.add(combined.get(i));
		return b;
	}

	public List<String> sortListPerCategory (List<String> listWithoutDuplicates, String start) throws Exception {

		List<String> b = new ArrayList<String>();
		HashMap <Integer,String>hm = new HashMap <Integer,String>();
		for(int i=0;i<listWithoutDuplicates.size();i++)
		{
			int n = listWithoutDuplicates.get(i).indexOf(".");
			String s = listWithoutDuplicates.get(i).substring(0, n);
			if(s.equals(start)==true)
				b.add(listWithoutDuplicates.get(i).trim());			
		}
		for(int i=0;i<b.size();i++)
		{
			int n = b.get(i).indexOf(".");
			int y = b.get(i).indexOf(":");
			String number = b.get(i).substring(n+1, y);
			hm.put(Integer.parseInt(number), b.get(i));
		}
		//System.out.println(hm);
		List<String> b1 = new ArrayList<String>();
		//loop is till 12 because none of the apparent causes have options more than 12
		for(int i=0;i<=12;i++)
		{
			if(hm.containsKey(i))
				b1.add(hm.get(i));
		}
		//System.out.println(b1);
		return b1;
	}

	public List<String> combineApparentCausesFromStep1AndStep2(List<String> step1,List<String>step2) throws Exception {

		List<String> b = new ArrayList<String>();
		b.addAll(step1);
		b.addAll(step2);
		List<String> listWithoutDuplicates1 = b.stream().distinct().collect(Collectors.toList());
		List<String> listWithoutDuplicates = op3.modifyList(listWithoutDuplicates1);
		//System.out.println(listWithoutDuplicates);
		//Combine all the lists
		List<String> b1 = new ArrayList<String>();
		//O1
		List<String> o1 = sortListPerCategory(listWithoutDuplicates, "O1");
		b1.addAll(o1);
		//O2
		List<String> o2 = sortListPerCategory(listWithoutDuplicates, "O2");
		b1.addAll(o2);
		//O3
		List<String> o3 = sortListPerCategory(listWithoutDuplicates, "O3");
		b1.addAll(o3);
		//O4
		List<String> o4 = sortListPerCategory(listWithoutDuplicates, "O4");
		b1.addAll(o4);
		//O5
		List<String> o5 = sortListPerCategory(listWithoutDuplicates, "O5");
		b1.addAll(o5);
		//OO1
		List<String> oo1 = sortListPerCategory(listWithoutDuplicates, "OO1");
		b1.addAll(oo1);
		//OO2
		List<String> oo2 = sortListPerCategory(listWithoutDuplicates, "OO2");
		b1.addAll(oo2);
		//OO3
		List<String> oo3 = sortListPerCategory(listWithoutDuplicates, "OO3");
		b1.addAll(oo3);
		//OP1
		List<String> op1 = sortListPerCategory(listWithoutDuplicates, "OP1");
		b1.addAll(op1);
		//OP2
		List<String> op2 = sortListPerCategory(listWithoutDuplicates, "OP2");
		b1.addAll(op2);
		//OP3
		List<String> op3 = sortListPerCategory(listWithoutDuplicates, "OP3");
		b1.addAll(op3);
		//OP4
		List<String> op4 = sortListPerCategory(listWithoutDuplicates, "OP4");
		b1.addAll(op4);
		//P1
		List<String> p1 = sortListPerCategory(listWithoutDuplicates, "P1");
		b1.addAll(p1);
		//P2
		List<String> p2 = sortListPerCategory(listWithoutDuplicates, "P2");
		b1.addAll(p2);
		//P3
		List<String> p3 = sortListPerCategory(listWithoutDuplicates, "P3");
		b1.addAll(p3);
		//P4
		List<String> p4 = sortListPerCategory(listWithoutDuplicates, "P4");
		b1.addAll(p4);
		//P5
		List<String> p5 = sortListPerCategory(listWithoutDuplicates, "P5");
		b1.addAll(p5);
		//PP1
		List<String> pp1 = sortListPerCategory(listWithoutDuplicates, "PP1");
		b1.addAll(pp1);
		//PP2
		List<String> pp2 = sortListPerCategory(listWithoutDuplicates, "PP2");
		b1.addAll(pp2);
		//System.out.println(b1);
		return b1;
	}

	public List<String> selectStep2D(WebDriver driver, int x, int y, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		List<String>ac = new ArrayList<String>();
		//Enter reason entry
		//tbr.sizeCheck(driver, opirca.OPiRCAReasonEntryField, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReasonEntryField)).sendKeys(eirca2.textCreate(driver));
		//Choose a number between 0 to x
		int n = chooseRandomOption(x,y);
		//Choose the option based on selection
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-opa-answer-"+n+"']"))));
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-opa-answer-"+n+"']"))).getText().trim();
/*		String temp = op3.verifyIfDAnswer(driver, n+1, s);
		System.out.println(temp);
		ac.add(temp);
		System.out.println(n);*/
		ac.add(op3.verifyIfDAnswer(driver, n+1, s));
		ac.add(Integer.toString(n));
		return ac;
	}

	public int chooseRandomOption(int range, int m) throws Exception {

		Random random = new Random();
		//m=0 is english , m=1 is chinese
		int n;
		if(m==0) 
		{
			//Choose a number between 0 to range (range is exclusive)
			n = random.nextInt(range);
		}
		else
		{
			while(true)
			{
				//Choose a number between 1 to range (range is exclusive)
				n = random.nextInt(range);
				if(n>0)
					break;
			}
		}
		return n;
	}

	public void verifyStickySaveReport(WebDriver driver, SoftAssertions softly, String username, String reportTitle, int n) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			eirca3.verifyBreakWordPropertyStickyNote(driver, softly);
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.StickyNote)).getText().trim();
			String r = s.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").contains(username+"_"+reportTitle);
			if(n == 0)
				softly.assertThat(r).as("test data").contains("Object created for id: ");
			else
				softly.assertThat(r).as("test data").contains("O&P iRCA™ Data updated for id: ");
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find save pop up");
		}
	}

	public void verifyStickyDeleteReport(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		try{
			eirca3.verifyBreakWordPropertyStickyNote(driver, softly);
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.StickyNote)).getText().trim();
			String r = s.replaceAll("\u00AD", "");
			String r1 = recordName.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").isEqualTo("O&P iRCA™ data deleted: "+r1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("Couldn't find delete pop up");
		}
	}

	public void verifyErrorMessagesInfoPage(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveButton)).click();
		Thread.sleep(1000);
		share2.verifyWarningPopupForError(driver, softly);
		//verifyInfoPageErrorPopup(driver,softly);
		//Verify errors
		//Event title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.EventTitleError)).getText().trim();
		softly.assertThat(s).as("test data").isEqualTo("Event title is required");
		//Location of event
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.EventLocationError)).getText().trim();
		softly.assertThat(s1).as("test data").isEqualTo("Location of event is required");
		//Problem statement
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ProblemStatementError)).getText().trim();
		softly.assertThat(s2).as("test data").isEqualTo("Problem statement is required");
		/*am_not applicable
		//Timeline
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.TimelineOfEventsError)).getText().trim();
		softly.assertThat(s3).as("test data").isEqualTo("Timeline of event is required");*/
		//Background
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.BackgroundInfoError)).getText().trim();
		softly.assertThat(s4).as("test data").isEqualTo("Background information is required");
		//investigator
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.InvestigatorError)).getText().trim();
		softly.assertThat(s5).as("test data").isEqualTo("Investigators is required");
	}

	public void verifyNoErrorsOnInfoPage(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify no errors
		//Event title
		wait.until(ExpectedConditions.invisibilityOfElementLocated(opirca.EventTitleError));
		//Location of event
		wait.until(ExpectedConditions.invisibilityOfElementLocated(opirca.EventLocationError));
		//Problem statement
		wait.until(ExpectedConditions.invisibilityOfElementLocated(opirca.ProblemStatementError));
		/*am_not applicable
		//Failed component
		wait.until(ExpectedConditions.invisibilityOfElementLocated(opirca.TimelineOfEventsError));*/
		//who discovered
		wait.until(ExpectedConditions.invisibilityOfElementLocated(opirca.BackgroundInfoError));
		//investigator
		wait.until(ExpectedConditions.invisibilityOfElementLocated(opirca.InvestigatorError));
	}

	public void verifyInfoPageErrorPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavePopupHeader)).getText().trim();
		softly.assertThat(s).as("test data").isEqualTo("Invalid Data Entry");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavePopupTitle)).getText().trim();
		softly.assertThat(s1).as("test data").isEqualTo("Please fix all errors mentioned in red.");
		//ok button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveConfirmButton)).getText().trim();
		softly.assertThat(s2).as("test data").isEqualTo("ok");
	}

	public void verifySavePopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavePopupHeader)).getText().trim();
		softly.assertThat(s).as("test data").isEqualTo("Save Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavePopupTitle)).getText().trim();
		softly.assertThat(s1).as("test data").isEqualTo("Are you sure you want to save current event report?");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveCancelButton)).getText().trim();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Save button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveConfirmButton)).getText().trim();
		softly.assertThat(s3).as("test data").isEqualTo("save report");
	}

	public void verifyNewReportPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on new button
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.NewButton)).click();
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavePopupHeader)).getText().trim();
		softly.assertThat(s).as("test data").isEqualTo("New Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavePopupTitle)).getText().trim();
		softly.assertThat(s1).as("test data").isEqualTo("Would you like to confirm you want to erase the current report and create a new report?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAPopupNote)).getText().trim();
		softly.assertThat(s4).as("test data").isEqualTo("Note: erased content cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveCancelButton)).getText().trim();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//New button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveConfirmButton)).getText().trim();
		softly.assertThat(s3).as("test data").isEqualTo("new report");
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveCancelButton)).click();
	}	

	public void verifyOpenReportPopup(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText().trim();
		softly.assertThat(s).as("test data").isEqualTo("Open");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText().trim();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("Do you confirm you want to open O&P Assessment report referenced as: "+r1+"?");
		/*else
			softly.assertThat(r).as("test data").isEqualTo("Do you confirm you want to open O&P Assessment report referenced as: <br/>"+r1+"?");*/
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText().trim();
		softly.assertThat(s4).as("test data").isEqualTo("Warning: once you load this version, any changes on the report will override existing data.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText().trim();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText().trim();
		softly.assertThat(s3).as("test data").isEqualTo("open");
	}	

	public void verifyDeleteReportPopup(WebDriver driver, SoftAssertions softly, String recordName) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText().trim();
		softly.assertThat(s).as("test data").isEqualTo("Delete Report");
		//Verify question on pop up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText().trim();
		String r = s1.replaceAll("\u00AD", "");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo("Are you sure you want to delete this O&P iRCA™ report ["+r1+"]?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText().trim();
		softly.assertThat(s4).as("test data").isEqualTo("Note: deleted data cannot be recovered later.");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText().trim();
		softly.assertThat(s2).as("test data").isEqualTo("cancel");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText().trim();
		softly.assertThat(s3).as("test data").isEqualTo("delete report");
	}

	public void verifyChangeLanguage(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		HiRCAChinese hc = new HiRCAChinese();
		LanguageCheckOfReports lcor = new LanguageCheckOfReports();/*
		//Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.OPiRCASaveButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj3.OPiRCASaveConfirmButton)).click();*/
		//Change language to english
		hc.changeToEnglish(driver);
		//Click on Analysis
		share2.loadingServer(driver);  
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.AnalysisLink)).click();
		//Click on OPiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCALink)).click();
		//Verify the language as english
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.PageTitle)).getText().trim();		
		if (lcor.containsHanScript(s)==true)
			softly.fail("Not in english");
		//Change language to chinese
		hc.changeToChinese(driver);		
		//Click on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.AnalysisLink)).click();
		//Click on OPiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCALink)).click();
		//Verify the language as chinese in test		
	}
}
