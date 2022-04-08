import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import kaleTestSoftware.*;
import kaleTestSoftware.Login;
import kaleTestSoftware.LoginPageObj;
import kaleTestSoftware.ShareCheck;
import kaleTestSoftware.ShareCheck2;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TermSearchEQ {

	SoftAssertions softly = new SoftAssertions();
	List<String> keywordFound = new ArrayList<String>();
	public String term_eq = "Gear Misalignment";

	CaseBrowse cb1  = new CaseBrowse();
	CaseBrowsePageObj cb = new CaseBrowsePageObj();
	ShareCheck share = new ShareCheck();
	Login login = new Login();
	LoginPageObj lpo = new LoginPageObj();
	CreateHumanCasePageObj human = new CreateHumanCasePageObj();
	CreateEquipPageObj equip = new CreateEquipPageObj();
	ShareCheck2 share2 = new ShareCheck2();

	public List<String> getCasesListFromSearch_eq(WebDriver driver, int y) throws Exception {

		List<String> caseList = new ArrayList<String>();
		int i=1;
		while(true)
		{
			try
			{
				//Look for case collapsibles and add to list
				caseList.add(driver.findElement(By.xpath(".//*[@id='pii-question-list-equip']/div["+y+"]/div[1]/div["+i+"]")).getAttribute("qid"));					
				i=i+1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}
		System.out.println(caseList);
		return caseList;
	}

	public void verifyOrderOfCasesWithPartialMatch(WebDriver driver, String term, List<String> caseList, String collapsibleText, List<String> keywordFound) throws Exception {

		//initialize 2 counters for no of matches and order to calculate order of case
		int count_Small = 0;
		int count_Big = 0;
		int order1 = 0;
		int order2 = 0;
		//Divide term in list of words
		List<String> terms = new ArrayList<String>();
		Pattern p = Pattern.compile("[a-zA-Z]+"); 
		Matcher matcher = p.matcher(term);
		while (matcher.find())
			terms.add(matcher.group());
		for(int i =0;i<terms.size();i++)
		{
			System.out.println(terms.get(i));
		}
		for(int i=0;i<caseList.size();i=i+1)
		{
			//Enter case number in field
			//Case 1
			getCaseInEquipmentAdmin(driver,caseList.get(i));
			System.out.println(caseList.get(i));
			//Look for term on page
			count_Big=0;
			order1=0;
			for(int j=0;j<terms.size();j++)
			{	
				count_Big = count_Big + getNumberOfMatches(driver,terms.get(j),caseList.get(i),collapsibleText);
				System.out.println("Partial match count: "+count_Big);
				//get order of case
				order1 = getOrderOfCaseBasedOnKeywordQuestionAnswerMatch(driver,order1,terms.get(j),collapsibleText,keywordFound);
			}
			keywordFound.clear();
			//Case 2
			i=i+1;
			if(i<caseList.size())
			{
				//get case
				getCaseInEquipmentAdmin(driver,caseList.get(i));
				System.out.println(caseList.get(i));
				//Look for term on page
				//Find term on page
				count_Small=0;
				order2=0;
				for(int j=0;j<terms.size();j++)
				{
					count_Small += getNumberOfMatches(driver,terms.get(j),caseList.get(i),collapsibleText);
					//get order of case
					order2 = getOrderOfCaseBasedOnKeywordQuestionAnswerMatch(driver,order2,terms.get(j),collapsibleText,keywordFound);
				}
				keywordFound.clear();
				//decide if ordering is correct
				decideCaseOrderingCorrect(count_Big,count_Small,order1,order2,caseList,i);
			}
		}
	}

	public void getCaseInEquipmentAdmin(WebDriver driver, String caseID) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on enter case id
		wait.until(ExpectedConditions.visibilityOfElementLocated(equip.EquipCaseSearchCaseIDAdmin)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(equip.EquipCaseSearchCaseIDAdmin)).sendKeys(caseID);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equip.EquipCaseSearchCaseIDAdmin)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//Wait for the list
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(equip.EquipCaseSearchCaseIDDropdownAdmin));
		List<WebElement> casesList = ele.findElements(By.tagName("li"));
		for(WebElement li : casesList)
		{
			if(li.getText().equals(caseID))
				li.click();
		}
		Thread.sleep(1000);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Get the case id loaded
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(equip.EquipCaseIDField)).getAttribute("value").equals(caseID.substring(1, caseID.length())))
			System.out.println("Correct case loaded: "+ wait.until(ExpectedConditions.visibilityOfElementLocated(equip.EquipCaseIDField)).getAttribute("value"));
		else
		{
			System.out.println("Incorrect case loaded: "+ wait.until(ExpectedConditions.visibilityOfElementLocated(equip.EquipCaseIDField)).getAttribute("value"));
			getCaseInEquipmentAdmin(driver,caseID);
		}
	}

	public void verifyCaseAppearsInCorrectCollapsible(String caseID, String term, String collapsibleText, String textToBeMatched) throws Exception {

		//Check for full term matching (Results)
		String patternMatch = "(\\s|\\d|\\W|^).*"+term+"(\\s|\\d|\\W|$).*";
		Pattern p = Pattern.compile(patternMatch); 
		Matcher m = p.matcher(textToBeMatched);
		if(collapsibleText.equals("Results")&& textToBeMatched.contains(term) &&(m.find()==false))
			softly.fail("Case should not be under Results : "+caseID);
		//Check for partial term matching (Similar Results)
		//Spliting the term into different words
		Pattern p1 = Pattern.compile("[a-zA-Z]+"); 
		Matcher m1 = p1.matcher(term); 
		List<String> terms = new ArrayList<String>();
		//Find term on page
		while (m1.find())
			terms.add(m1.group());
		for(int i=0;i<terms.size();i++)
		{
			String patternMatch2 = "(\\s|\\d|\\W|^).*"+terms.get(i)+"(\\s|\\d|\\W|$).*";
			Pattern p2 = Pattern.compile(patternMatch2); 
			Matcher m2 = p2.matcher(textToBeMatched);
			if(textToBeMatched.contains(terms.get(i)))
			{
				if(collapsibleText.equals("Similar Results")&& (m2.find()==true))
					softly.fail("Case should not be under Similar Results : "+caseID);
				if(collapsibleText.equals("Other Results")&& (m2.find()==false))
					softly.fail("Case should not be under Other Results : "+caseID);
				break;
			}
		}
	}

	public void verifyOrderingOfCases (WebDriver driver,List<String> caseList, String term, String collapsibleText,List<String> keywordFound) throws Exception {

		if(caseList.isEmpty()==false)
		{		
			//initialize 2 counters for no of matches and order to calculate order of case
			int count_Small = 0;
			int count_Big = 0;
			int order1 = 0;
			int order2 = 0;
			for(int i=0;i<caseList.size();i=i+1)
			{
				//Enter case number in field
				//Case 1
				getCaseInEquipmentAdmin(driver,caseList.get(i));
				System.out.println(caseList.get(i));
				//Look for term on page
				count_Big = getNumberOfMatches(driver,term,caseList.get(i),collapsibleText);
				System.out.println("count_Big "+count_Big);
				if(count_Big==0)
				{
					verifyOrderOfCasesWithPartialMatch(driver,term,caseList,collapsibleText,keywordFound);
					break;
				}
				else{
					//get order of case
					order1 = getOrderOfCaseBasedOnKeywordQuestionAnswerMatch(driver,order1,term,collapsibleText,keywordFound);
					keywordFound.clear();
					//Case 2
					i=i+1;
					if(i<caseList.size())
					{
						//get case
						getCaseInEquipmentAdmin(driver,caseList.get(i));
						System.out.println(caseList.get(i));
						//Look for term on page
						//Find term on page
						count_Small = getNumberOfMatches(driver,term,caseList.get(i),collapsibleText);
						//get order of case
						order2 = getOrderOfCaseBasedOnKeywordQuestionAnswerMatch(driver,order2,term,collapsibleText,keywordFound);
						keywordFound.clear();
						//decide if ordering is correct
						decideCaseOrderingCorrect(count_Big,count_Small,order1,order2,caseList,i);
					}
				}
			}
		}
	}

	public int getNumberOfMatches(WebDriver driver, String term, String caseID, String collapsibleText) throws Exception {

		int count=0;
		System.out.println("term: from getNumberMatches "+term);
		//Find term in question
		String q = driver.findElement(equip.EquipCaseQuestion).getAttribute("value").toLowerCase();	
		System.out.println("Question "+q+" "+StringUtils.countMatches(q,term.toLowerCase()));
		count = count + StringUtils.countMatches(q,term.toLowerCase());
		System.out.println("q count "+count);
		//From answer
		String a = driver.findElement(equip.EquipCaseAnswer).getAttribute("value").toLowerCase();
		System.out.println("Answer "+a+" "+StringUtils.countMatches(a,term.toLowerCase()));
		count = count + StringUtils.countMatches(a,term.toLowerCase());
		System.out.println("a count "+count);
		//From keywords
		int j=1;
		while(driver.findElement(By.xpath(".//*[@id='pii-admin-efse-keyword-list']/li["+j+"]")).getAttribute("class").contains("ui-last-child")==false)
		{
			String k = driver.findElement(By.xpath(".//*[@id='pii-admin-efse-keyword-list']/li["+j+"]/a")).getText().toLowerCase();
			System.out.println("Keyword "+k+" "+StringUtils.countMatches(k,term.toLowerCase()));
			count = count + StringUtils.countMatches(k,term.toLowerCase());
			j=j+1;
			verifyCaseAppearsInCorrectCollapsible(caseID,term,collapsibleText,k);
		}
		String k = driver.findElement(By.xpath(".//*[@id='pii-admin-efse-keyword-list']/li["+j+"]/a")).getText().toLowerCase();
		System.out.println("Keyword "+k+" "+StringUtils.countMatches(k,term.toLowerCase()));
		count = count + StringUtils.countMatches(k,term.toLowerCase());
		System.out.println("count from getNumberOfMatches "+count);
		//Verify collapsible
		verifyCaseAppearsInCorrectCollapsible(caseID,term,collapsibleText,q);
		verifyCaseAppearsInCorrectCollapsible(caseID,term,collapsibleText,a);
		return count;
	}

	public void decideCaseOrderingCorrect(int count_Big, int count_Small, int order1, int order2, List<String> caseList, int i) throws Exception {

		if(count_Small>=count_Big)
			if((order2<order1))
				if(order2%7<order1%7)
					softly.fail("Ordering not correct for cases:\n Case "+caseList.get(i)+ "order2: "+order2+ " should appear after Case "+caseList.get(i-1)+"order1: "+order1);
	}

	public int verifyValueOfIForCalculatingOrder(String textToBeMatched, String term, int k, String collapsibleText,List<String> keywordFound) throws Exception {

		//k=0 for answer and quesion k=1 for keyword match
		//List for terms
		List<String> terms = new ArrayList<String>();
		/*Order of cases is calculated
		 * i=counter, n = no of terms matched out of total terms
		 * i=0,n=1
		 * i=1,n=2		
		 * 1+7i = K Q A
		 * 2+7i = K Q
		 * 3+7i = K A
		 * 4+7i = Q A
		 * 5+7i = K
		 * 6+7i = Q
		 * 7+7i = A
		 */
		int i=-1;
		Pattern p = Pattern.compile("[a-zA-Z]+"); 
		Matcher matcher = p.matcher(term); 
		//Find term on page
		while (matcher.find())
			terms.add(matcher.group());
		int n = terms.size();
		for(int j=0;j<n;j++)
		{
			System.out.println(terms.get(j).toLowerCase());
			System.out.println(textToBeMatched.toLowerCase().contains(terms.get(j)));
			String patternMatch2 = "(\\s|\\d|\\W|^).*"+terms.get(j).toLowerCase()+"(\\s|\\d|\\W|$).*";
			Pattern p2 = Pattern.compile(patternMatch2); 
			Matcher m2 = p2.matcher(textToBeMatched.toLowerCase());
			Boolean boolean1 = m2.find();
			if(boolean1==false)
			{
				if(collapsibleText.trim().equals("Other Results"))
				{
					i=i+1;	
					System.out.println(i);
				}
			}
			if(boolean1==true)
			{
				if(collapsibleText.trim().equals("Similar Results"))
				{
					i=i+1;	
					System.out.println(i);
				}
				if(collapsibleText.trim().equals("Results"))
				{
					i=i+1;
					System.out.println(i);
				}
			}
			if(k==1)
				keywordFound.add(terms.get(j));
		}
		List<String>newList = keywordFound.stream().distinct().collect(Collectors.toList()); 
		keywordFound.clear();
		keywordFound.addAll(newList);
		System.out.println("i " +i);
		return i;
	}

	public int getOrderOfCaseBasedOnKeywordQuestionAnswerMatch(WebDriver driver, int order, String term,String collapsibleText, List<String> keywordFound) throws Exception {

		//Question
		System.out.println(driver.findElement(equip.EquipCaseQuestion).getAttribute("value"));
		System.out.println(driver.findElement(equip.EquipCaseQuestion).getAttribute("value").toLowerCase().contains(term.toLowerCase()));
		int x = 7*verifyValueOfIForCalculatingOrder(driver.findElement(equip.EquipCaseQuestion).getAttribute("value").toLowerCase(),term.toLowerCase(),0,collapsibleText,keywordFound);
		System.out.println("Q x: "+x);
		if(x>=0)
			order = 6+x;
		//Answer
		System.out.println(driver.findElement(equip.EquipCaseAnswer).getAttribute("value"));
		System.out.println(driver.findElement(equip.EquipCaseAnswer).getAttribute("value").toLowerCase().contains(term.toLowerCase()));
		if((order-6)%7==0)
		{
			x = 7*verifyValueOfIForCalculatingOrder(driver.findElement(equip.EquipCaseAnswer).getAttribute("value").toLowerCase(),term.toLowerCase(),0,collapsibleText,keywordFound);
			System.out.println("A x: "+x);
			if(x>=0)
				order = 4+x;		
		}
		else 
		{
			x = 7*verifyValueOfIForCalculatingOrder(driver.findElement(equip.EquipCaseAnswer).getAttribute("value").toLowerCase(),term.toLowerCase(),0,collapsibleText,keywordFound);
			System.out.println("A x: "+x);
			if(x>=0)
				order = 7+x;
		}
		//Get order from keyword if it contains term
		int j = 1;
		while(driver.findElement(By.xpath(".//*[@id='pii-admin-efse-keyword-list']/li["+j+"]")).getAttribute("class").contains("ui-last-child")==false)
		{
			order = getOrderDecideFromKeywordMatch(driver,order,j,term,collapsibleText,keywordFound);
			j=j+1;
		}
		//Get order if last child in keyword list contains term
		order = getOrderDecideFromKeywordMatch(driver,order,j,term,collapsibleText,keywordFound);
		System.out.println("order: "+order);
		return order;
	}


	public int getOrderDecideFromKeywordMatch(WebDriver driver, int order, int j, String term, String collapsibleText,List<String> keywordFound) throws Exception {

		int n = keywordFound.size();
		System.out.println(keywordFound);
		System.out.println(driver.findElement(By.xpath(".//*[@id='pii-admin-efse-keyword-list']/li["+j+"]/a")).getText().toLowerCase());
		int i=-1;
		while(n>0)
		{
			i = i+1;
			n = n-1;
		}	
		if(order==0)
		{
			int x = 7*verifyValueOfIForCalculatingOrder(driver.findElement(By.xpath(".//*[@id='pii-admin-efse-keyword-list']/li["+j+"]/a")).getText().toLowerCase(),term.toLowerCase(),1,collapsibleText, keywordFound);
			System.out.println("K no match x: "+x);
			if(x>=0)
			{
				if(x>(7*i))
					order = 5 + x;	
				else
					order = 5+(7*i);
			}			
		}
		if(order%7==0)
		{
			int x = 7*verifyValueOfIForCalculatingOrder(driver.findElement(By.xpath(".//*[@id='pii-admin-efse-keyword-list']/li["+j+"]/a")).getText().toLowerCase(),term.toLowerCase(),1,collapsibleText, keywordFound);
			System.out.println("K 7 x: "+x);
			if(x>=0)
			{
				if(x>(7*i))
					order=3 + x;
				else
					order=3+(7*i);
			}
		}
		if((order-6)%7==0)
		{
			int x = 7*verifyValueOfIForCalculatingOrder(driver.findElement(By.xpath(".//*[@id='pii-admin-efse-keyword-list']/li["+j+"]/a")).getText().toLowerCase(),term.toLowerCase(),1,collapsibleText, keywordFound);
			System.out.println("K 6 x: "+x);
			if(x>=0)
			{
				if(x>(7*i))
					order=2 + x;
				else
					order=2+(7*i);
			}
		}
		if((order-4)%7==0)
		{
			int x = 7*verifyValueOfIForCalculatingOrder(driver.findElement(By.xpath(".//*[@id='pii-admin-efse-keyword-list']/li["+j+"]/a")).getText().toLowerCase(),term.toLowerCase(),1,collapsibleText, keywordFound);
			System.out.println("K 4 x: "+x);
			if(x>=0)
			{
				if(x>(7*i))
					order=1 + x;
				else
					order = 1+(7*i);
			}
		}	
		return order;
	}

	public void termSearchVerifyEquipmentDatabank(WebDriver driver, int y, String term) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,2);
		/*Verify order or modules
		 * admin = 0
		 * nonadmin = 1
		 */
		//Go to equipment databank
		cb1.getEquipPerformancePIILink(driver, y);
		//Search for term
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(term);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchKeywordField)).sendKeys(Keys.ENTER);
		share2.loadingServer(driver);
		//Get all cases from Results or Similar results or Other results
		List<String> caseList1 = getCasesListFromSearch_eq(driver,1);
		//Get all cases from Similar results or Other results
		List<String> caseList2 = getCasesListFromSearch_eq(driver,2);
		//Get all cases from Other results
		List<String> caseList3 = getCasesListFromSearch_eq(driver,3);
		//Get collapsible names
		List<String> collapsibleResultsList = new ArrayList<String>();
		collapsibleResultsList.add(wait.until(ExpectedConditions.visibilityOfElementLocated(equip.EquipDropwdownTitle_1st)).getText());
		try{
			collapsibleResultsList.add(wait1.until(ExpectedConditions.visibilityOfElementLocated(equip.EquipDropwdownTitle_2nd)).getText());
			collapsibleResultsList.add(wait1.until(ExpectedConditions.visibilityOfElementLocated(equip.EquipDropwdownTitle_3rd)).getText());
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		//Click on clear
		wait.until(ExpectedConditions.visibilityOfElementLocated(cb.EquipmentSearchClearButton)).click();
		//Go to admin
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		//Waits for black loading message to disappear
		share2.loadingServer(driver);
		share2.scrollToTop(driver);
		//Close sticky
		login.closePopUpSticky(driver);
		while(true)
		{
			if(driver.findElement(human.AdminOption).isDisplayed()==false)
			{
				//Clicks on admin user name on top right corner
				wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
			}
			else
			{
				//Clicks on admin option
				wait.until(ExpectedConditions.visibilityOfElementLocated(human.AdminOption)).click();
				break;
			}
		}
		//Clicks on Errorfree bank option
		if (driver.findElement(equip.EquipCasesLink).isDisplayed()==false)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(human.ErrorFreeBankAdminLink)).click();
		}	
		//Clicks on Equipment cases
		wait.until(ExpectedConditions.visibilityOfElementLocated(equip.EquipCasesLink)).click();	
		share2.loadingServer(driver);
		//Verify case and term matching
		if(collapsibleResultsList.contains("Results"))
		{
			verifyOrderingOfCases(driver,caseList1,term,collapsibleResultsList.get(collapsibleResultsList.indexOf("Results")), keywordFound);
			if(collapsibleResultsList.contains("Similar Results"))
			{
				verifyOrderingOfCases(driver,caseList2,term,collapsibleResultsList.get(collapsibleResultsList.indexOf("Similar Results")), keywordFound);
				if(collapsibleResultsList.contains("Other Results"))
					verifyOrderingOfCases(driver,caseList3,term,collapsibleResultsList.get(collapsibleResultsList.indexOf("Other Results")), keywordFound);
			}
			else
				verifyOrderingOfCases(driver,caseList2,term,collapsibleResultsList.get(collapsibleResultsList.indexOf("Other Results")), keywordFound);
		}
		if(collapsibleResultsList.contains("Results")==false)
		{
			if(collapsibleResultsList.contains("Similar Results"))
			{
				verifyOrderingOfCases(driver,caseList1,term,collapsibleResultsList.get(collapsibleResultsList.indexOf("Similar Results")), keywordFound);
				if(collapsibleResultsList.contains("Other Results"))
					verifyOrderingOfCases(driver,caseList2,term,collapsibleResultsList.get(collapsibleResultsList.indexOf("Other Results")), keywordFound);
			}
			if((collapsibleResultsList.contains("Similar Results")==false)&&(collapsibleResultsList.contains("Other Results")))
				verifyOrderingOfCases(driver,caseList1,term,collapsibleResultsList.get(collapsibleResultsList.indexOf("Other Results")), keywordFound);
		}
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}