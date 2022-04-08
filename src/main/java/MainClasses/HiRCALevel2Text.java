import kaleTestSoftware.HiRCAObj;
import kaleTestSoftware.ShareCheck;
import kaleTestSoftware.ShareCheck2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiRCALevel2Text {

	ShareCheck share = new ShareCheck();
	ShareCheck2 share2 = new ShareCheck2();
	HiRCAObj hirca = new HiRCAObj();
	
	//Question before 2.0
	public By PageQuestionBefore20 = By.xpath(".//*[@class='efi-irca-question']");
	public By DescriptionPlusSignBefore20 = By.xpath(".//*[@id='efi-irca-initialquestions']/div/div[2]/h4/a");
	public By DescriptionTextBefore20 = By.xpath(".//*[@class='pii-description-text']");
	public By AnswerYes = By.xpath(".//*[@for='efi-irca-lopinplace-yes']");
	public By AnswerNo = By.xpath(".//*[@for='efi-irca-lopinplace-no']");
	
	//Level 3
	public By UnderDescriptionText = By.xpath(".//*[@id='efi-irca-answers']/div[1]");
	public By FurtherInvestigationCollapsibleAnswer1 = By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a");
	public By FurtherInvestigationCollapsibleAnswer2 = By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a");
	public By FurtherInvestigationCollapsibleAnswer3 = By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a");
	public By FurtherInvestigationCollapsibleAnswer4 = By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a");
	public By FurtherInvestigationCollapsibleAnswer5 = By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a");
	public By FurtherInvestigationCollapsibleAnswer6 = By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a");
	public By FurtherInvestigationCollapsibleAnswer7 = By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a");
	public By PossibleCorrectiveActionAnswer1 = By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a");
	public By PossibleCorrectiveActionAnswer2 = By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a");
	public By PossibleCorrectiveActionAnswer3 = By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a");
	public By PossibleCorrectiveActionAnswer4 = By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a");
	public By PossibleCorrectiveActionAnswer5 = By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a");
	public By PossibleCorrectiveActionAnswer6 = By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a");
	public By PossibleCorrectiveActionAnswer7 = By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a");
	
	public void step2verify317 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(heading).as("test data").contains("QTM - equipment qualification, testing and maintenance");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(UnderDescriptionText)).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(desc).as("test data").contains("If the triggering event is caused by equipment, the user can do a preliminary assessment on the equipment's design spec qualification, testing and maintenance. It is recommended to use EiRCA™ to do a troubleshooting specifically for equipment failures.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//3.17.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(q341).as("test data").contains("[3.17.1] Inadequate procurement and/or design specifications");
		//2nd collapsible for 3.17.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer1)).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer1)).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("Industry standards used for spec development?");
		String c2a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c2a).as("test data").contains("QA/QC?");
		String c2b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c2b).as("test data").contains("Vendor qualification?");
		//Click on 2nd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer1)).click();
		
		/*am_not applicable
		//3rd collapsible 3.17.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer1)).getText();
		softly.assertThat(c10).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer1)).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("Improvement in risk control program");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("Use of expert committee for high risk specs");
		String c26a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		softly.assertThat(c26a).as("test data").contains("Standardizing of repeat specs");
		//Click on 3rd collapsible for 3.17.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer1)).click();
		*/
		//3.17.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(q342).as("test data").contains("[3.17.2] Inadequate source audit / inspection QA/QC for compliance (if applicable)");
		//2nd collapsible for 3.17.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer2)).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer2)).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("Training and qualification for QA/QC staff?");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c22).as("test data").contains("Full scope QA audit?");
		String c22a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c22a).as("test data").contains("Continuous audit / inspection or spot audit / inspection?");
		//Click on 2nd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer2)).click();
		
		/*am_not applicable
		//3rd collapsible 3.17.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer2)).getText();
		softly.assertThat(c11).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer2)).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("Improvement of source QA/QC program");
		//Click on 3rd collapsible for 3.17.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer2)).click();
		*/
		//3.17.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(q343).as("test data").contains("[3.17.3] Inadequate design qualification and/or testing before use");
		//2nd collapsible for 3.17.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer3)).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.17.3
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer3)));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("Extrapolate too far without qualification tests?");
		String c8a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c8a).as("test data").contains("Independent verification of complex analysis or calculations?");
		String c8b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c8b).as("test data").contains("Uncertainty analysis of non-code calculations?");
		//Click on 2nd collapsible for 3.17.3
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer3)));
		
		/*am_not applicable
		//3rd collapsible 3.17.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer3)).getText();
		softly.assertThat(c12).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.17.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer3)));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c9).as("test data").contains("Improvement in design qualification and qualification testing program");
		//Click on 3rd collapsible for 3.17.3
		wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer3)).click();
		*/
		//3.17.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)).getText();
		softly.assertThat(q344).as("test data").contains("[3.17.4] Inadequate operation: (1) Inadequate operation procedure; (2) Inadequate operating condition; (3) Operation errors");
		//2nd collapsible for 3.17.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer4)).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.17.4
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer4)));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("Review operation procedure preparation guidelines?");
		//Click on 2nd collapsible for 3.17.4
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer4)));
		
		/*am_not applicable
		//3rd collapsible 3.17.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer4)).getText();
		softly.assertThat(c16).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.17.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer4)));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("Correcting deficiencies in operating procedures");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c37).as("test data").contains("Improving operating procedure preparation guidelines");
		//Click on 3rd collapsible for 3.17.4
		wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer4)).click();
		//Scroll to the end
		//share2.scrollToAPoint(driver, 1500);
		*/
		//3.17.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)).getText();
		softly.assertThat(q345).as("test data").contains("[3.17.5] Inadequate periodic surveillance testing");
		//2nd collapsible for 3.17.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer5)).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.17.5
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer5)));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("Surveillance tests not performed?");
		//Click on 2nd collapsible for 3.17.5
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer5)));
		
		/*am_not applicable
		//3rd collapsible 3.17.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer5)).getText();
		softly.assertThat(c20).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.17.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer5)));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("Surveillance testing program improvement");
		//Click on 3rd collapsible for 3.17.5
		wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer5)).click();
		*/
		//3.17.6 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)));
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)).getText();
		softly.assertThat(q396).as("test data").contains("[3.17.6] Inadequate maintenance");
		//2nd collapsible for 3.17.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer6)).getText();
		softly.assertThat(c15).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.17.6
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer6)));
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c28).as("test data").contains("Preventive maintenance not performed?");
		String c28a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c28a).as("test data").contains("Corrective maintenance not effective?");
		//Click on 2nd collapsible for 3.17.6
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer6)));
		
		/*am_not applicable
		//3rd collapsible 3.17.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer6)).getText();
		softly.assertThat(c30).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.17.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer6)));
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c31).as("test data").contains("Improvement in preventive maintenance program");
		String c31a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c31a).as("test data").contains("Improvement in corrective maintenance program");
		//Click on 3rd collapsible for 3.17.6
		wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer6)).click();
		*/
		//3.17.7 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)));
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)).getText();
		softly.assertThat(q367).as("test data").contains("[3.17.7] Inadequate equipment labeling and identification");
		//2nd collapsible for 3.17.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer7)).getText();
		softly.assertThat(c41).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.17.7
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer7)));
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c42).as("test data").contains("Check that all necessary and referred to equipment is not only labeled, but also labeled correctly");
		//Click on 2nd collapsible for 3.17.7
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(FurtherInvestigationCollapsibleAnswer7)));
		
		/*am_not applicable
		//3rd collapsible 3.17.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer7)).getText();
		softly.assertThat(c44).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.17.7
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer7)));
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c45).as("test data").contains("Improve equipment labeling and identification");
		//Click on 3rd collapsible for 3.17.7
		wait.until(ExpectedConditions.visibilityOfElementLocated(PossibleCorrectiveActionAnswer7)).click();
		*/
		//Scroll to the top
		share2.scrollToTop(driver);
	}
	
	public void step2q212 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
		//2.12 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.12] Was the intentional violation of LOP requirements caused by tacit acceptance by peers?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("This question explores if the inadequate positive peer pressure is a cause of the intentional violation.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		
		/*am_not applicable
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		*/
		
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
	}
	
	public void step2q211 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
		//2.11 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.11] Was the intentional violation of LOP requirements caused by low perceived risk?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("This question explores if low perceived risk was the cause for the LOP violation. Our research found when a worker feels the risk of violation is low, there is a greater tendency to violate the rules. Risk is the sum of two terms. One term is the product of the probability of being caught and the consequences of penalty. The other term is the product of the probability of injury and the consequences of the injury.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		/*am_not applicable
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		*/
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
	}
	
	public void step2q210 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
		//2.10 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.10] Was the intentional violation of LOP requirements caused by undue motivation?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("This question explores if the intentional violation (such as short-cutting LOP requirements like not performing a PJB as required, etc.) is caused by undue motivation such as going home early, getting out of an uncomfortable working environment, etc.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		
		/*am_not applicable
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		*/
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
	}
	
	public void step2q29 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
		//2.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.9] Was the intentional violation of LOP requirements caused by excessive burden?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("This question explores if the intentional violation was caused by perceived burden to execute an LOP. Perceived burden is a feeling that the time or effort spent on implementing an LOP is not worthwhile. Causes for the perception of burden could be: Inadequate accountability, Inadequate understanding for the need, or Excessive prescription of an LOP (e.g. PPE required for greater voltage or arc-flash rating).");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		
		/*am_not applicable
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		*/
		
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
	}
	
	public void step2q28 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
		//2.8 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.8] Was the LOP failure caused by a lack of accountability?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("This question explores whether the LOP failed because there is little to no accountability if this needed LOP is not performed.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		
		/*am_not applicable
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		*/
		
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
	}
	
	public void step2q27 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
		//2.7 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.7] Was the LOP failure caused by a lack of qualification?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("Qualification is a demonstration of ability after training (like a driving test before getting a license). In critical LOPs, such as review and independent check, qualification is often required.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		
		/*am_not applicable
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		*/
		
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
	}
	
	public void step2q26 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
		//2.6 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.6] Was the LOP failure caused by inadequate training?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("This question explores if the LOP failure was due to a lack of training. For example, if staff has not been trained to conduct a PJB (either classroom training or on-the-job training), a lack of PJB training could be a contributing factor for a PJB not being performed.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		
		/*am_not applicable
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		*/
		
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
	}
	
	public void step2q25 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
		//2.5 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.5] Was the LOP failure caused by vague words or ambiguity?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("This question is to explore if the LOP failure was caused by ambiguous requirements. For example, a PJB might not be performed because the staff does not understand what work needs a PJB and what doesn’t.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		
		/*am_not applicable
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		*/
		
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
	}
	
	public void step2q24 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
		//2.4 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.4] Was the LOP failure caused by inadequate bypass control?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("To have an LOP (e.g. PJB) executed correctly, bypass control measures are usually employed. These measures include: Behavior standards, Not-to-do warnings, Checklists, Job-site reminders, Place holders, etc.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		
		/*am_not applicable
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		*/
		
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
	}
	
	public void step2q23 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
		//2.3 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.3] Was the LOP failure caused by incompleteness or incorrect rules?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("An LOP can be incomplete in that it does not cover some conditions. For example, when \"review\", as an LOP, does not require the reviewer to crosscheck the validity of assumptions, it is incomplete. LOP is incorrect in that it contains incorrect instructions. For example, an incorrect specification of PPE (personal protective equipment) is an incorrect LOP.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		
		/*am_not applicable
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		*/
		
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Incompleteness");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("Incorrect rules");
	}
	
	public void step2q22 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
		//2.2 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.2] Was the LOP failure caused by inadequate rules, incorrect rules, or inattention-to-detail?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains("This question is to determine whether the LOP failure was intentional or unintentional.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		
		/*am_not applicable
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		*/
		
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Inattention-to-detail");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("Inadequate or Incorrect rules");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("No");
	}
	
	public void step2q21 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry - LOP");
		//2.1 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("Contributing factor for inattention-to-detail");
		softly.assertThat(q11).as("test data").contains("[2.1] Did equipment failure cause LOP to fail?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
//		softly.assertThat(lop3).as("test data").contains("Inattention-to-detail is an error-prone behavior. It is characterized by errors resulting from not paying full attention to the task at hand");
		softly.assertThat(lop3).as("test data").contains("Some LOPs are related to the use of equipment (e.g. safety belt, fall protection harness, JIT alarm, etc.). There are four categories of contributing factors in equipment failures: Inadequate qualification, Inadequate surveillance testing, Inadequate maintenance, Inadequate operation.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
		
	}

	public void step2Q20(WebDriver driver, SoftAssertions softly) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 2: Layers of Protection Failure Inquiry");
		//Question before 2.0
		String q11a = wait.until(ExpectedConditions.visibilityOfElementLocated(PageQuestionBefore20)).getText();		
		softly.assertThat(q11a).as("test data").contains("Were there LOPs in place to prevent the triggering event?");
		//Description
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionPlusSignBefore20)).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionTextBefore20)).getText();
		softly.assertThat(lop3).as("test data").contains("Layer of Protection (LOP): A practice that detects and/or prevents errors to stop an event from occurring. It can be a procedure, an action or a physical barrier (equipment).");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionPlusSignBefore20)).click();
		//Verify Yes 
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AnswerYes)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes");
		//Verify No
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(AnswerNo)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
		//2.0 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[2.0] What were the failed LOPs (3 max) that caused this event to happen?");
		
		/*am_not applicable
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		*/
		
		//Answer 1
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans3).as("test data").contains("Briefings (PJB, MJB, PSM, TO, etc.)");
		//Answer 2
		String ans4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans4).as("test data").contains("Concurrent check");
		//Answer 3
		String ans5 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans5).as("test data").contains("Error-proof design");
		//Answer 4
		String ans6 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)).getText();		
		softly.assertThat(ans6).as("test data").contains("Independent check");
		//Answer 5
		String ans7 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)).getText();		
		softly.assertThat(ans7).as("test data").contains("JIT alarm");
		//Answer 6
		String ans8 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)).getText();
		softly.assertThat(ans8).as("test data").contains("JIT reminder (signage, not-to do postings)");
		//Answer 7
		String ans9 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)).getText();		
		softly.assertThat(ans9).as("test data").contains("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
		//Answer 8
		String ans10 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)).getText();		
		softly.assertThat(ans10).as("test data").contains("Peer coaching");
		//Answer 9
		String ans11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)).getText();
		softly.assertThat(ans11).as("test data").contains("Review (PNR, Technical review)");
		//Answer 10
		String ans12 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10)).getText();		
		softly.assertThat(ans12).as("test data").contains("Self-check");
		//Answer 11
		String ans13 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer11)).getText();		
		softly.assertThat(ans13).as("test data").contains("Supervisory intervention");
		//Answer 12
		String ans14 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer12)).getText();
		softly.assertThat(ans14).as("test data").contains("Other:");
	}
}
