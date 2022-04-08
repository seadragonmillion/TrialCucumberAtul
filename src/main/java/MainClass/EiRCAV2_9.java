package MainClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import PageObjects.EiRCAV2PageObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EiRCAV2_9 {

	EiRCAV2PageObj eirca = new EiRCAV2PageObj();
	ShareCheck2 share2 = new ShareCheck2();

	public void verifyReportTabSectionHeadings(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep1SectionTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("1. Event Information");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabSequenceOfEventsTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Sequence of Events");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep2SectionTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("2. Data Collection");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep3SectionTitle)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("3. FACTS Symptom Characterization");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep4SectionTitle)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("4. Possible Failure Modes");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep5SectionTitle)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("5. Non-Presence Refuting Method");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep6SectionTitle)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("6. Identify Failed Component through Leading-Following Differential Analysis");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep7SectionTitle)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("7. Probability of Occurrence and Actions");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep8SectionTitle)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("8. Perform Supporting Analysis");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep9SectionTitle)).getText();
		softly.assertThat(s9).as("test data").isEqualTo("9. Direct Cause, Apparent Cause Confirmation & Cause Quality Check");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabStep10SectionTitle)).getText();
		softly.assertThat(s10).as("test data").isEqualTo("10. Corrective Actions");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ReportTabSignaturesSectionTitle)).getText();
		softly.assertThat(s11).as("test data").isEqualTo("Signatures");
	}

	public void verifyHTMLReportSectionHeadings(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		share2.loadingServer(driver);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep1SectionTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("1. Event Information");
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportSequenceOfEventsTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Sequence of Events");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep2SectionTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("2. Data Collection");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep3SectionTitle)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("3. FACTS Symptom Characterization");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep4SectionTitle)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("4. Possible Failure Modes");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep5SectionTitle)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("5. Non-Presence Refuting Method");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep6SectionTitle)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("6. Identify Failed Component through Leading-Following Differential Analysis");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep7SectionTitle)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("7. Probability of Occurrence and Actions");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep8SectionTitle)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("8. Perform Supporting Analysis");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep9SectionTitle)).getText();
		softly.assertThat(s9).as("test data").isEqualTo("9. Direct Cause, Apparent Cause Confirmation & Cause Quality Check");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep10SectionTitle)).getText();
		softly.assertThat(s10).as("test data").isEqualTo("10. Corrective Actions");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportSignaturesSectionTitle)).getText();
		softly.assertThat(s11).as("test data").isEqualTo("Signatures");
	}

	public void verifyHTMLReport(WebDriver driver, SoftAssertions softly, 
			HashMap<String,String>hmStep1, HashMap<String,String> hmStep2symptomsData, HashMap<String,String> hmStep3Data, 
			HashMap<String,List<String>> hmStep3FACTSData, List<String> step4, List<String> step3, 
			int n5, String analysisAdded, HashMap<String,String> step7, List<String> dcAcCfNames) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		WebDriverWait wait1 = new WebDriverWait(driver,3);
		//Step 1
		//Event title
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportTable1EventTitle)).getText();
		String r3 = s4.replace("\u00AD", "");
		softly.assertThat(r3).as("test data").contains(hmStep1.get("Event title"));
		//Location of event
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportTable1LocationOfEvent)).getText();
		String r4 = s5.replace("\u00AD", "");
		softly.assertThat(r4).as("test data").isEqualTo(hmStep1.get("Event location"));
		//Who discovered
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportTable1WhoDiscovered)).getText();
		String r5 = s6.replace("\u00AD", "");
		softly.assertThat(r5).as("test data").isEqualTo(hmStep1.get("Event reporter"));
		//Investigators
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportTable1Investigators)).getText();
		String r6 = s7.replace("\u00AD", "");
		softly.assertThat(r6).as("test data").isEqualTo(hmStep1.get("Investigator"));
		//Reviewers
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportTable1Reviewers)).getText();
		String r7 = s8.replace("\u00AD", "");
		softly.assertThat(r7).as("test data").isEqualTo(hmStep1.get("Reviewer"));
		//Management sponsors
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportTable1ManagementSponsors)).getText();
		String r8 = s9.replace("\u00AD", "");
		softly.assertThat(r8).as("test data").isEqualTo(hmStep1.get("Sponsor"));
		//Problem Statement
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportTable1ProblemStatement)).getText();
		String r9 = s10.replace("\u00AD", "");
		softly.assertThat(r9).as("test data").isEqualTo(hmStep1.get("Problem statement"));
		//Suspected failed component
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportTable1SuspectedFailedComponent)).getText();
		String r10 = s11.replace("\u00AD", "");
		if(r10.toLowerCase().contains("other")) softly.assertThat(r10).as("test data").isEqualTo(hmStep1.get("Other suspected failed component"));
		else softly.assertThat(r10).as("test data").isEqualTo(hmStep1.get("Suspected failed component"));
		//Primary symptoms
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportTable1PrimarySymptom)).getText();
		String r11 = s12.replace("\u00AD", "");
		if(r11.toLowerCase().contains("other")) softly.assertThat(r11).as("test data").isEqualTo(hmStep1.get("Other primary symptom"));
		else softly.assertThat(r11).as("test data").isEqualTo(hmStep1.get("Primary symptom"));
		//Report findings
		WebElement reportFinding = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportTable1ReportFindingTr));
		//total number of fms
		int addedFM;
		if(n5==0) {
			addedFM = 4;
		}
		else {
			addedFM = 3;
		}
		int totalFms = addedFM+step3.size();
		int loopEnd;
		if(totalFms<=5)
			loopEnd=totalFms;
		else
			loopEnd = 5;
		for(int i=1;i<=loopEnd;i++)
		{
			//dc
			String s = reportFinding.findElement(By.xpath(".//*[@colspan='3']/ol[1]/li["+i+"]")).getText();
			softly.assertThat(s).as("test data").isEqualTo(dcAcCfNames.get(i-1));
			//ac
			String s1 = reportFinding.findElement(By.xpath(".//*[@colspan='3']/ol[2]/li["+i+"]")).getText();
			softly.assertThat(s1).as("test data").isEqualTo(dcAcCfNames.get(i+4));
		}		
		for(int i=1;i<=(loopEnd*2);i++)
		{
			//cf
			String s = reportFinding.findElement(By.xpath(".//*[@colspan='3']/ol[3]/li["+i+"]")).getText();
			softly.assertThat(s).as("test data").isEqualTo(dcAcCfNames.get(i+9));
		}

		//Step 2
		//Design
		for(int i=1;i<=4;i++)
		{
			for(int j=2;j<=4;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[3]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2WithNextLine);
			}
		}
		//O
		for(int i=1;i<=3;i++)
		{
			for(int j=2;j<=4;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[4]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2WithNextLine);
			}
		}
		//O
		for(int i=1;i<=1;i++)
		{
			for(int j=2;j<=2;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[5]/table[1]/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2WithNextLine);
			}
		}
		for(int i=1;i<=1;i++)
		{
			for(int j=2;j<=3;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[5]/table[2]/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2WithNextLine);
			}
		}
		//M
		for(int i=1;i<=3;i++)
		{
			for(int j=2;j<=4;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[6]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2WithNextLine);
			}
		}
		//Table 5 : Symptoms
		//1
		for(int i=1;i<=3;i++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/table/tbody/tr["+i+"]/td[2]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("Symptom "+i);
		}
		//2
		//SBI
		for (int i=1;i<=100;i++)
		{
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[5]")));
				String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[1]"))).getText();
				softly.assertThat(a1).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Symptom for inspection "+i));
				String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[2]"))).getText();
				softly.assertThat(a2).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Inspection parameter "+i));
				String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[3]"))).getText();
				softly.assertThat(a3).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Inspection notes "+i));
				String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[4]"))).getText();
				softly.assertThat(a4).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Inspection findings "+i));
			}catch(org.openqa.selenium.TimeoutException t)
			{
				try{
					String a2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[1]"))).getText();
					softly.assertThat(a2).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Inspection parameter "+i));
					String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[2]"))).getText();
					softly.assertThat(a3).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Inspection notes "+i));
					String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[1]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[3]"))).getText();
					softly.assertThat(a4).as("test data").isEqualTo(hmStep2symptomsData.get("SBI Inspection findings "+i));
				}catch(org.openqa.selenium.TimeoutException e)
				{
					break;
				}				
			}
		}
		//MainClass.SRI
		for (int i=1;i<=100;i++)
		{
			try{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[5]")));
				String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[1]"))).getText();
				softly.assertThat(a1).as("test data").isEqualTo(hmStep2symptomsData.get("MainClass.SRI Symptom for inspection "+i));
				String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[2]"))).getText();
				softly.assertThat(a2).as("test data").isEqualTo(hmStep2symptomsData.get("MainClass.SRI Inspection parameter "+i));
				String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[3]"))).getText();
				softly.assertThat(a3).as("test data").isEqualTo(hmStep2symptomsData.get("MainClass.SRI Inspection notes "+i));
				String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[4]"))).getText();
				softly.assertThat(a4).as("test data").isEqualTo(hmStep2symptomsData.get("MainClass.SRI Inspection findings "+i));
			}catch(org.openqa.selenium.TimeoutException t)
			{
				try{
					String a2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[1]"))).getText();
					softly.assertThat(a2).as("test data").isEqualTo(hmStep2symptomsData.get("MainClass.SRI Inspection parameter "+i));
					String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[2]"))).getText();
					softly.assertThat(a3).as("test data").isEqualTo(hmStep2symptomsData.get("MainClass.SRI Inspection notes "+i));
					String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[7]/div[2]/table/tbody[2]/tr[1]/td[2]/table/thead/tr["+(i+1)+"]/td[3]"))).getText();
					softly.assertThat(a4).as("test data").isEqualTo(hmStep2symptomsData.get("MainClass.SRI Inspection findings "+i));
				}catch(org.openqa.selenium.TimeoutException e)
				{
					break;
				}				
			}
		}
		//Interviews
		//1
		for(int i=1;i<=2;i++)
		{
			for(int j=1;j<=2;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[8]/div[4]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2);
			}
		}
		//2
		for(int i=1;i<=2;i++)
		{
			for(int j=1;j<=2;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[8]/div[7]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2);
			}
		}
		//3
		for(int i=1;i<=2;i++)
		{
			for(int j=1;j<=2;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[8]/div[10]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2);
			}
		}
		//4
		for(int i=1;i<=2;i++)
		{
			for(int j=1;j<=2;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[8]/div[13]/table/tbody/tr["+i+"]/td["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(eirca.textStep2);
			}
		}

		//Step 3 
		//FACTS table
		for(int i=1;i<=step3.size();i++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[9]/table/tbody/tr["+i+"]/td[1]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo(hmStep3Data.get("Symptoms type"+i));
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[9]/table/tbody/tr["+i+"]/td[2]"))).getText();
			softly.assertThat(s1).as("test data").isEqualTo(hmStep3Data.get("Symptoms name"+i));
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[9]/table/tbody/tr["+i+"]/td[5]"))).getText();
			softly.assertThat(s2).as("test data").isEqualTo(hmStep3Data.get("Implication"+i));
			List<String> f1 = hmStep3FACTSData.get("FACT "+i);
			List<String> c1 = hmStep3FACTSData.get("Char "+i);
			for(int j=0;j<f1.size();j++)
			{
				String f = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[9]/table/tbody/tr["+i+"]/td[3]/ul/li["+(j+1)+"]"))).getText();
				softly.assertThat(f).as("test data").isEqualTo("["+(j+1)+"] "+f1.get(j));
				String c = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[9]/table/tbody/tr["+i+"]/td[4]/ul/li["+(j+1)+"]"))).getText();
				if(c1.get(j).contains("Choose characteristics"))
					softly.assertThat(c).as("test data").isEqualTo("["+(j+1)+"] n/a");
				else
					softly.assertThat(c).as("test data").isEqualTo("["+(j+1)+"] "+c1.get(j));
			}
		}

		//Step 4
		int count =1;
		for(int i = 0;i<(step4.size()-3);i++)
		{
			if(count>3) break;
			String num = step4.get(i);
			System.out.println(num);
			int n = Integer.parseInt(num);
			for(int j=1;j<=n;j++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[10]/table/tbody/tr["+count+"]/td[1]/ul/li["+j+"]"))).getText();
				softly.assertThat(s).as("test data").isEqualTo(step4.get(i+j));
			}
			i=i+n+1;			
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[10]/table/tbody/tr["+count+"]/td[2]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo(step4.get(i));
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[10]/table/tbody/tr["+count+"]/td[3]"))).getText();
			softly.assertThat(s1).as("test data").isEqualTo(step4.get(i));
			count = count + 1;
		}
		for(int i=4;i<=step3.size();i++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[10]/table/tbody/tr["+i+"]/td[1]/ul/li[1]"))).getText();
			softly.assertThat(s).as("test data").isEqualTo("Symptoms (failure factor analysis)");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[10]/table/tbody/tr["+i+"]/td[2]"))).getText();
			int n = s1.indexOf("Generated from Step 3 symptoms' implications");
			softly.assertThat(s1.substring(0,n-1)).as("test data").isIn(step3);
		}
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[10]/table/tbody/tr["+(4+step3.size())+"]/td[1]/ul/li[1]"))).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Initiation factors (failure factor analysis)");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[10]/table/tbody/tr["+(4+step3.size())+"]/td[2]"))).getText();
		softly.assertThat(s3).as("test data").isIn(step4.get(step4.size()-1));

		//Step 5
		if(n5>0)
		{
			//Refuted failure mode
			String f = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep5RefutedFailureModeTitle)).getText();
			softly.assertThat(f).as("test data").isEqualTo("Refuted failure modes:");
			String f1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep5RefutedFailureModeName1)).getText();
			softly.assertThat(f1).as("test data").contains("Sanity Test \"title\" Sanity1");
			String f2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep5RefutedFailureModeDescription1)).getText();
			softly.assertThat(f2).as("test data").contains("Sanity Test \"title\" Sanity1");
			String f3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep5RefutedFailureModeMethods1)).getText();
			softly.assertThat(f3).as("test data").isEqualTo("Initiation factors (failure factor analysis), Symptoms (failure factor analysis), Delta analysis, Past events");
			String f4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep5UnrefutedFailureModeTitle)).getText();
			softly.assertThat(f4).as("test data").isEqualTo("Un-refuted failure modes:");
			//Refuted table
			for(int i=1;i<=n5;i++)
			{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[11]/table/tbody/tr["+i+"]/td[2]/strong"))).getText();
				softly.assertThat(s).as("test data").isEqualTo("Yes");
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[11]/table/tbody/tr["+i+"]/td[3]"))).getText();
				softly.assertThat(s1).as("test data").isEqualTo(eirca.textEiRCAv2);
			}
		}
		else{
			String f4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep5UnrefutedFailureModeTitleWithNoneRefuted)).getText();
			softly.assertThat(f4).as("test data").isEqualTo("Un-refuted failure modes:");
		}
		//List of unrefuted failure modes		
		for(int i=1;i<=totalFms;i++)
		{
			String fm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[11]/ol/li["+i+"]"))).getText();
			if(n5>0)
			{
				if(i==1)
					softly.assertThat(fm).as("test data").isEqualTo(eirca.textEiRCAv2+"2");
				if(i==2)
					softly.assertThat(fm).as("test data").isEqualTo(eirca.textEiRCAv2+"3");
				if(i>2 && i<totalFms) 
					softly.assertThat(fm).as("test data").isIn(step3);
			}
			else {
				if(i==1)
					softly.assertThat(fm).as("test data").isEqualTo(eirca.textEiRCAv2+"1");
				if(i==2)
					softly.assertThat(fm).as("test data").isEqualTo(eirca.textEiRCAv2+"2");
				if(i==3)
					softly.assertThat(fm).as("test data").isEqualTo(eirca.textEiRCAv2+"3");
				if(i>3 && i<totalFms) 
					softly.assertThat(fm).as("test data").isIn(step3);
			}
			if(i==totalFms)
				softly.assertThat(fm).as("test data").isEqualTo(eirca.textEiRCAv2+"4");
		}
		//Step 6
		String a1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep6AnalysisTypeR1)).getText();
		softly.assertThat(a1).as("test data").isEqualTo(analysisAdded);
		String a2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep6AnalysisNameR1)).getText();
		softly.assertThat(a2).as("test data").isEqualTo(eirca.textEiRCAv2);
		String a3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep6AnalysisComponentR1)).getText();
		softly.assertThat(a3).as("test data").isEqualTo(eirca.textEiRCAv2);
		String a4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep6AnalysisTypeR2)).getText();
		softly.assertThat(a4).as("test data").isEqualTo("n/a");
		List<String> allFMs = new ArrayList<String>();
		allFMs.addAll(step3);
		allFMs.addAll(step4);
		for(int i=2;i<=totalFms;i++)
		{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[12]/h4["+i+"]"))).getText();
			softly.assertThat(s).as("test data").contains(" (skipped)");
			int index = s.indexOf(" (skipped");
			int index1 = s.indexOf(":");
			String s1 = s.substring(index1+2, index);
			softly.assertThat(s1).as("test data").isIn(allFMs);
		}
		//Step 7
		for(int i=1;i<=totalFms;i++)
		{
			String fm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[13]/table["+(totalFms+1)+"]/tbody/tr["+i+"]/td[1]"))).getText();
			String rank = driver.findElement(By.xpath(".//*[@id='mirca-rpt']/div[13]/table["+(totalFms+1)+"]/tbody/tr["+i+"]/td[2]/span")).getText();
			if(step7.get(fm).length()==0)
			{
				if(driver.getCurrentUrl().contains("kaleqa"))
					softly.assertThat(rank).as("test data").isEqualTo("n/a");
				else
					softly.assertThat(rank).as("test data").isEqualTo("");
			}
			else softly.assertThat(rank).as("test data").isEqualTo(step7.get(fm));
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[13]/table["+(totalFms+1)+"]/tbody/tr["+i+"]/td[3]"))).getText();
			softly.assertThat(s1).as("test data").isEqualTo(eirca.textEiRCAv2);			
			String s1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[13]/table["+(totalFms+1)+"]/tbody/tr["+i+"]/td[4]/div/div[1]"))).getText();
			softly.assertThat(s1a).as("test data").isEqualTo(eirca.textEiRCAv2);			
			String s1b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[13]/table["+(totalFms+1)+"]/tbody/tr["+i+"]/td[4]/div/div[2]"))).getText();
			softly.assertThat(s1b).as("test data").isEqualTo(eirca.textEiRCAv2);			
			String s1c = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[13]/table["+(totalFms+1)+"]/tbody/tr["+i+"]/td[4]/div/div[3]"))).getText();
			softly.assertThat(s1c).as("test data").isEqualTo(eirca.textEiRCAv2);			
			String s1d = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[13]/table["+(totalFms+1)+"]/tbody/tr["+i+"]/td[5]/div/div[1]"))).getText();
			softly.assertThat(s1d).as("test data").isEqualTo(eirca.textEiRCAv2);			
			String s1e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[13]/table["+(totalFms+1)+"]/tbody/tr["+i+"]/td[5]/div/div[2]"))).getText();
			softly.assertThat(s1e).as("test data").isEqualTo(eirca.textEiRCAv2);			
			String s1f = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[13]/table["+(totalFms+1)+"]/tbody/tr["+i+"]/td[5]/div/div[3]"))).getText();
			softly.assertThat(s1f).as("test data").isEqualTo(eirca.textEiRCAv2);			
		}
		//Step 8
		for(int i=1;i<=totalFms;i++)
		{
			String fm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[14]/table/tbody/tr["+i+"]/td[1]"))).getText();
			String rank = driver.findElement(By.xpath(".//*[@id='mirca-rpt']/div[14]/table/tbody/tr["+i+"]/td[2]/span")).getText();
			if(step7.get(fm).length()==0)
			{
				if(driver.getCurrentUrl().contains("kaleqa"))
					softly.assertThat(rank).as("test data").isEqualTo("n/a");
				else
					softly.assertThat(rank).as("test data").isEqualTo("");
			}
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[14]/table/tbody/tr["+i+"]/td[3]"))).getText();
			softly.assertThat(s1).as("test data").isEqualTo(eirca.textEiRCAv2);			
			String s1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[14]/table/tbody/tr["+i+"]/td[4]"))).getText();
			softly.assertThat(s1a).as("test data").isEqualTo(eirca.textEiRCAv2);			
			String s1f = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[14]/table/tbody/tr["+i+"]/td[5]/strong"))).getText();
			softly.assertThat(s1f).as("test data").isEqualTo("Yes");			
		}
		//Step 9
		count = 1;
		String step9DivText = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.HTMLReportStep9Div)).getText();
		softly.assertThat(step9DivText).as("test data").contains("Possible Direct Cause: n/a");
		softly.assertThat(step9DivText).as("test data").contains("Possible Apparent Cause: n/a");
		List<String> qualityScore = new ArrayList<String>();
		for(int i=loopEnd*4;i<dcAcCfNames.size();i++){
			qualityScore.add(dcAcCfNames.get(i));
		}
		int qCount=0;
		for(int i=1;i<=loopEnd;i++)
		{
			String fmName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/h4["+i+"]/span[1]"))).getText();
			String dc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]/tbody/tr[1]/td[1]"))).getText();
			softly.assertThat(dc1).as("test data").isEqualTo(fmName+" DC 1");
			String dc2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]/tbody/tr[2]/td[1]"))).getText();
			softly.assertThat(dc2).as("test data").isEqualTo(fmName+" DC 2");
			String dc1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]/tbody/tr[1]/td[2]"))).getText();
			softly.assertThat(dc1a).as("test data").isEqualTo("Yes");
			String dc2a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]/tbody/tr[2]/td[2]"))).getText();
			softly.assertThat(dc2a).as("test data").isEqualTo("Yes");
			count = count +1;
			String ac1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]/tbody/tr[1]/td[1]"))).getText();
			softly.assertThat(ac1).as("test data").isEqualTo(fmName+" AC 1");
			String ac2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]/tbody/tr[2]/td[1]"))).getText();
			softly.assertThat(ac2).as("test data").isEqualTo(fmName+" AC 2");
			String ac1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]/tbody/tr[1]/td[2]"))).getText();
			softly.assertThat(ac1a).as("test data").isEqualTo("Yes");
			String ac2a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]/tbody/tr[2]/td[2]"))).getText();
			softly.assertThat(ac2a).as("test data").isEqualTo("Yes");
			count = count +1;
			WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]")));
			String score = l.findElement(By.className("pii-ircam2-t9-fm-qc-score")).getText();
			softly.assertThat(score).as("test data").isEqualTo(qualityScore.get(qCount));
			qCount += 1;
			count = count +1;
			WebElement l1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]")));
			String score1 = l1.findElement(By.className("pii-ircam2-t9-fm-qc-score")).getText();
			softly.assertThat(score1).as("test data").isEqualTo(qualityScore.get(qCount));
			qCount += 1;
			count = count +1;
			WebElement l2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]")));
			String score2 = l2.findElement(By.className("pii-ircam2-t9-fm-qc-score")).getText();
			softly.assertThat(score2).as("test data").isEqualTo(qualityScore.get(qCount));
			qCount += 1;
			count = count +1;			
			WebElement l3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]")));
			String score3 = l3.findElement(By.className("pii-ircam2-t9-fm-qc-score")).getText();
			softly.assertThat(score3).as("test data").isEqualTo(qualityScore.get(qCount));
			qCount += 1;
			count = count +1;
		}
		for(int i=count;i<=totalFms;i++)
		{
			String dc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]/tbody/tr[1]/td[1]"))).getText();
			softly.assertThat(dc1).as("test data").isEqualTo("n/a");
			String dc1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]/tbody/tr[1]/td[2]"))).getText();
			softly.assertThat(dc1a).as("test data").isEqualTo("n/a");
			count = count +1;
			String ac1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]/tbody/tr[1]/td[1]"))).getText();
			softly.assertThat(ac1).as("test data").isEqualTo("n/a");
			String ac1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[15]/table["+count+"]/tbody/tr[1]/td[2]"))).getText();
			softly.assertThat(ac1a).as("test data").isEqualTo("n/a");
			count = count +1;
		}
		//Step 10
		count=1;
		for(int fm=0;fm<loopEnd;fm++)
		{
			for(int j=count;j<=count+4;j++)
			{
				String dc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[16]/table["+count+"]/tbody/tr[1]/td[2]/div/div[1]"))).getText();
				softly.assertThat(dc1).as("test data").isEqualTo(eirca.textEiRCAv2);
				String dc2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[16]/table["+count+"]/tbody/tr[1]/td[2]/div/div[2]"))).getText();
				softly.assertThat(dc2).as("test data").isEqualTo(eirca.textEiRCAv2);
				String dc3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[16]/table["+count+"]/tbody/tr[1]/td[2]/div/div[3]"))).getText();
				softly.assertThat(dc3).as("test data").isEqualTo(eirca.textEiRCAv2);
				String dc4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[16]/table["+count+"]/tbody/tr[2]/td[2]/div/div[1]"))).getText();
				softly.assertThat(dc4).as("test data").isEqualTo(eirca.textEiRCAv2);
				String dc5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[16]/table["+count+"]/tbody/tr[2]/td[2]/div/div[2]"))).getText();
				softly.assertThat(dc5).as("test data").isEqualTo(eirca.textEiRCAv2);
				String dc6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='mirca-rpt']/div[16]/table["+count+"]/tbody/tr[2]/td[2]/div/div[3]"))).getText();
				softly.assertThat(dc6).as("test data").isEqualTo(eirca.textEiRCAv2);
			}
			count = count+4;
		}
	}

	public void verifyBackButtonWorks(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click back on report tab
		//Step 10
		share2.scrollToTop(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step10TabPageTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo("Corrective Actions");
		//Step 9
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step9TabPageTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("Direct Cause, Apparent Cause Confirmation & Cause Quality Check");
		//Step 8
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step8TabPageTitle)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("Perform Supporting Analysis");
		//Step 7
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step7TabPageTitle)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("Probability of Occurrence and Actions");
		//Step 6
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step6TabPageTitle)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("Identify Failed Component through Leading-Following Differential Analysis");
		//Step 5
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step5TabPageTitle)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("Non-Presence Refuting Method");
		//Step 4
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step4TabPageTitle)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("Possible Failure Modes");
		//Step 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.Step3TabPageTitle)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("FACTS Symptom Characterization");
		//Step 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2TabInstruction)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("Enter DOOMS Data and Delta DOOMS Data based on evidence collection.");
		/*
		Thread.sleep(3000);
		//Sequence of events
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1PageTitle)).getText();
		softly.assertThat(s9).as("test data").isEqualTo("Sequence of Events");
		System.out.println(s9);
		softly.assertAll();*/
		//Step 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCABackButton)).click();
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1PageTitle)).getText();
		softly.assertThat(s10).as("test data").isEqualTo("MainClass.EiRCA™ v2 - Report Initiation and General Questions");
	}

}
