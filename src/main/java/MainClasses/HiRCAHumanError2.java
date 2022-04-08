import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kaleTestSoftware.HiRCALevel1;
import kaleTestSoftware.HiRCAObj;
import kaleTestSoftware.ShareCheck;
import kaleTestSoftware.ShareCheck2;
import org.apache.commons.collections4.MultiValuedMap;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAHumanError2 {
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	HiRCAObj hirca = new HiRCAObj();

	public void verify31 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Individual specific");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("These contributing factors are attributed to the individual as it relates to errors that impact organizational performance.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.1.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.1.1] Inadequate capability");
		//2nd collapsible for 3.1.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.1.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Repeat errors?");
		//Click on 2nd collapsible for 3.1.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.1.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.1.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("Reassignment to the right job");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c37).as("test data").contains("Training");
		//Click on 3rd collapsible for 3.1.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.1.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.1.2] Mismatch of attitude and task");
		//2nd collapsible for 3.1.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.1.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c5).as("test data").contains("Personality-attitude mapping?");
		//Click on 2nd collapsible for 3.1.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.1.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.1.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c6).as("test data").contains("Improvement of task assignment strategy");
		//Click on 3rd collapsible for 3.1.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.1.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.1.3] Mismatch of personality and task");
		//2nd collapsible for 3.1.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.1.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("Personality-attitude mapping?");
		//Click on 2nd collapsible for 3.1.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.1.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.1.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c9).as("test data").contains("Improvement of task assignment strategy");
		//Click on 3rd collapsible for 3.1.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();		
		*/
		//3.1.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.1.4] Inexperience in subject matter");
		//2nd collapsible for 3.1.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.1.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c14).as("test data").contains("Job history?");
		//Click on 2nd collapsible for 3.1.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.1.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.1.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("Provision of JIT wisdom at PJB and MJB");
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c15).as("test data").contains("Mentoring");
		//Click on 3rd collapsible for 3.1.4
		////wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.1.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q345).as("test data").contains("[3.1.5] Inadequate knowledge of and compensation for self-weakness");
		//2nd collapsible for 3.1.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.1.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("Interview co-workers");
		//Click on 2nd collapsible for 3.1.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.1.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.1.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("Mentoring");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("Training in self analysis");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		softly.assertThat(c24).as("test data").contains("Performing self analysis");
		//Click on 3rd collapsible for 3.1.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//share2.scrollToAPoint(driver, 1200);
		*/
		//3.1.6 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)));
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();		
		softly.assertThat(q396).as("test data").contains("[3.1.6] Unfit for work (sick, ill, preoccupied, etc.)");
		//2nd collapsible for 3.1.6
		String c151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c151).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.1.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();		
		softly.assertThat(c28).as("test data").contains("Interview co-workers");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();		
		softly.assertThat(c29).as("test data").contains("Interview supervisors");
		//Click on 2nd collapsible for 3.1.6
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.1.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c30).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.1.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c31).as("test data").contains("Supervisory behavior monitoring training");
		//Click on 3rd collapsible for 3.1.6
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		share2.scrollToTop(driver);
	}

	public void verify311 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Inadequate job accountability");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("Did a lack of accountability contribute to the occurrence of this error? Accountability refers to the system that holds the owner accountable for the performance of the program.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.11.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.11.1] Inadequate Performance Monitoring and Trending (PM&T) and feedback to staff");
		//2nd collapsible for 3.11.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.11.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Feedback to staff on results of performance trends?");
		//Click on 2nd collapsible for 3.11.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.11.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.11.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("Improvement in PM&T system");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c22).as("test data").contains("Improvement in feedback of trends");
		//Click on 3rd collapsible for 3.11.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.11.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.11.2] Inadequate supervisory skills in Instant Feedback and Constant Reinforcement (IF&CR)");
		//2nd collapsible for 3.11.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.11.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("Adequate field time to observe and supervise work?");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c23).as("test data").contains("Constant reinforcement of standards?");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c24).as("test data").contains("Instant feedback when observing deviations?");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[4]"))).getText();
		softly.assertThat(c27).as("test data").contains("More positive than negative feedback?");
		//Click on 2nd collapsible for 3.11.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.11.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.11.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("Improvement in accountability of supervisors");
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c28).as("test data").contains("Improvement in Error-Free® training of supervisors");
		//Click on 3rd collapsible for 3.11.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.11.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.11.3] Inadequate penalty/reward system for performance control");
		//2nd collapsible for 3.11.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.11.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("Is the system fast?");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c25).as("test data").contains("Is the system firm?");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c29).as("test data").contains("Is the system fair?");
		//Click on 2nd collapsible for 3.11.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.11.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.11.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c9).as("test data").contains("Improvement of penalty/reward system");
		//Click on 3rd collapsible for 3.11.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.11.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.11.4] Inadequate problem reporting, RCA and corrective actions and feedback to staff");
		//2nd collapsible for 3.11.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.11.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();		
		String r = c14.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").contains("Check the ratio of number of minor events reported for analysis and the number of injuries (<10)?");
		//Click on 2nd collapsible for 3.11.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.11.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.11.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("Enforcing all-inclusive and timeliness in problem reporting policy");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("RCA training and qualification");
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		softly.assertThat(c30).as("test data").contains("Improvement in feedback of RCA results");
		//Click on 3rd collapsible for 3.11.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.11.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q345).as("test data").contains("[3.11.5] Inadequate field observation and feedback to staff");
		//2nd collapsible for 3.11.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.11.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("Field observation program established in every department?");
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c31).as("test data").contains("Effectiveness review of past field observation results?");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c32).as("test data").contains("Time spent in the field?");
		//Click on 2nd collapsible for 3.11.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.11.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.11.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("Improvement in feedback to staff of field observation results");
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c33).as("test data").contains("Improvement in JO program and TQA");
		softly.assertThat(c33).as("test data").contains(" for field observers");
		//Click on 3rd collapsible for 3.11.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		share2.scrollToTop(driver);
	}

	public void verify310 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Inadequate qualification");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("Qualification is a demonstration of learned skills and ability for critical jobs that impact safety or production (such as plant operators, reviewers, managers, etc.).");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.10.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.10.1] Inadequate task specific qualification of staff on critical jobs");
		//2nd collapsible for 3.10.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.10.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Qualification policy and certificates?");
		//Click on 2nd collapsible for 3.10.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.10.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.10.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c3).as("test data").contains("Improvement of task specific qualification");
		//Click on 3rd collapsible for 3.10.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.10.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.10.2] Inadequate qualification of supervisors and/or managers of critical jobs");
		//2nd collapsible for 3.10.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.10.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c5).as("test data").contains("Qualification policy and certificates?");
		//Click on 2nd collapsible for 3.10.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.10.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.10.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c6).as("test data").contains("Improvement in job qualification of supervisors and managers");
		//Click on 3rd collapsible for 3.10.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.10.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.10.3] Inadequate qualification of vendors' services (QA/QC, source inspection)");
		//2nd collapsible for 3.10.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.10.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("Qualification policy and certificates?");
		//Click on 2nd collapsible for 3.10.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.10.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.10.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c9).as("test data").contains("Improvement in vendor control program");
		//Click on 3rd collapsible for 3.10.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.10.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.10.4] Inadequate qualification of vendors' employees working on site");
		//2nd collapsible for 3.10.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.10.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("Qualification policy and certificates?");
		//Click on 2nd collapsible for 3.10.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.4.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.10.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c17).as("test data").contains("Improvement in vendor control program");
		//Click on 3rd collapsible for 3.10.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.10.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q345).as("test data").contains("[3.10.5] Inadequate qualification of training instructors");
		//2nd collapsible for 3.10.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.10.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c19).as("test data").contains("Qualification policy and certificates?");
		//Click on 2nd collapsible for 3.10.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.10.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.10.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c21).as("test data").contains("Improvement of management standards and policy in training instructor's qualification");
		//Click on 3rd collapsible for 3.10.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		share2.scrollToTop(driver);
	}

	public void verify39 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Inadequate training");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("When it comes to not receiving adequate training, explore training scope, training contact, training experience.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.9.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.9.1] Inadequate training materials in scope, timeliness, or usefulness");
		//2nd collapsible for 3.9.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.9.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("Benchmark with similar organizations?");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c22).as("test data").contains("Training effectiveness review through job observation?");
		//Click on 2nd collapsible for 3.9.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.9.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.9.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("Training resource enhancement");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c27).as("test data").contains("Job-task analysis to match training materials, classes, and timing with tasks performed by staff");
		//Click on 3rd collapsible for 3.9.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.9.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.9.2] Inadequate frequency of refresher training (>> one year)");
		//2nd collapsible for 3.9.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.9.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("Frequency of refresher training based on complexity and frequency of use?");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c23).as("test data").contains("Format of refresher training?");
		//Click on 2nd collapsible for 3.9.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.9.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.9.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c6).as("test data").contains("Refresher training frequency and format improvement");
		//Click on 3rd collapsible for 3.9.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.9.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.9.3] Inadequate line management participation in training materials, development, and delivery");
		//2nd collapsible for 3.9.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.9.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("Training materials review comments from line managers?");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c25).as("test data").contains("Classes monitored by line managers?");
		//Click on 2nd collapsible for 3.9.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.9.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.9.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c9).as("test data").contains("Improvement in requirements for management participation in training materials development or delivery");
		//Click on 3rd collapsible for 3.9.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();		
		*/
		//3.9.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.9.4] Inadequate inclusion of lessons learned into training");
		//2nd collapsible for 3.9.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.9.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c14).as("test data").contains("Review common causes (in terms of LOPs, error traps, etc.) of past events?");
		//Click on 2nd collapsible for 3.9.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*am_not applicable
		//3rd collapsible 3.9.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.9.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c17).as("test data").contains("Improvement in training effectiveness review");
		//Click on 3rd collapsible for 3.9.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.9.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q345).as("test data").contains("[3.9.5] Inadequate provision of needed training (off-the-job)");
		//2nd collapsible for 3.9.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.9.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("Training attendance sheets and % of staff being trained?");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c24).as("test data").contains("Contractors on site not trained?");
		//Click on 2nd collapsible for 3.9.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.9.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.9.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("Improvement of vendor control's policy");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("Improvement of training resources");
		//Click on 3rd collapsible for 3.9.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//share2.scrollToAPoint(driver, 1200);
		*/
		//3.9.6 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)));
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		softly.assertThat(q396).as("test data").contains("[3.9.6] Inadequate provision of needed training (on-the-job)");
		//2nd collapsible for 3.9.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c15).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.9.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c28).as("test data").contains("Policy for on-the-job training?");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c29).as("test data").contains("Inexperienced staff not trained?");
		//Click on 2nd collapsible for 3.9.6
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.9.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c30).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.9.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c31).as("test data").contains("Improvement of policy for on-the-job training");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c32).as("test data").contains("Improvement of training resources");
		//Click on 3rd collapsible for 3.9.6
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		share2.scrollToTop(driver);
	}

	public void verify32 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Supervisor specific");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("These contributing factors are attributed to the supervisor as it relates to errors that impact the individual and organizational performance.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.2.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.2.1] Inadequate supervisor capabilities in reinforcing standards");
		//2nd collapsible for 3.2.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.2.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("Interview co-workers");
		//Click on 2nd collapsible for 3.2.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.2.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.2.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("Supervisor training");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c27).as("test data").contains("Management of supervisor behavior standards");
		//Click on 3rd collapsible for 3.2.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.2.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.2.2] Inadequate supervisor capabilities in performance feedback");
		//2nd collapsible for 3.2.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.2.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("Interview co-workers");
		//Click on 2nd collapsible for 3.2.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.2.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.2.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("Supervisor training");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c22).as("test data").contains("Management of supervisor behavior standards");
		//Click on 3rd collapsible for 3.2.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.2.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.2.3] Inadequate supervisor practice in holding lessons learned meetings");
		//2nd collapsible for 3.2.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.2.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("Interview co-workers");
		//Click on 2nd collapsible for 3.2.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.2.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.2.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c9).as("test data").contains("Supervisor training");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c23).as("test data").contains("Management of supervisor behavior standards");
		//Click on 3rd collapsible for 3.2.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.2.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.2.4] Inadequate supervisor capabilities in providing on-the-job training");
		//2nd collapsible for 3.2.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.2.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c14).as("test data").contains("Interview co-workers");
		//Click on 2nd collapsible for 3.2.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.2.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.2.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("Supervisor training");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c25).as("test data").contains("Management of supervisor behavior standards");
		//Click on 3rd collapsible for 3.2.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.2.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q345).as("test data").contains("[3.2.5] Inadequate supervisor knowledge of and compensation for team weaknesses");
		//2nd collapsible for 3.2.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.2.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c19).as("test data").contains("Interview co-workers");
		//Click on 2nd collapsible for 3.2.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.2.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.2.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("Supervisor training");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c24).as("test data").contains("Management of supervisor behavior standards");
		//Click on 3rd collapsible for 3.2.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		share2.scrollToAPoint(driver, 1200);
		//3.2.6 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)));
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		softly.assertThat(q396).as("test data").contains("[3.2.6] Inadequate supervisor communication and coordination skills in giving instructions and follow-through");
		//2nd collapsible for 3.2.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c15).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.2.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c28).as("test data").contains("Interview subordinates");
		//Click on 2nd collapsible for 3.2.6
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		/*am_not applicable
		//3rd collapsible 3.2.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c30).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.2.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c31).as("test data").contains("Supervisor training");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c32).as("test data").contains("Management of supervisor behavior standards");
		//Click on 3rd collapsible for 3.2.6
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		share2.scrollToTop(driver);
	}
	public void verify321 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(heading).as("test data").contains("High Risk Situations (TAPE");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("30% of consequential errors are attributed by high-risk situations.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.21.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.21.1] Time related high risk situations not identified and mitigated such as daily cycle error traps, working hours, holiday effects, etc.");
		//2nd collapsible for 3.21.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.21.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("Situation awareness training?");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c27).as("test data").contains("Pre-job awareness system improvements?");
		//Click on 2nd collapsible for 3.21.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.21.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c10).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.21.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("Situation awareness training");
		String c3a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c3a).as("test data").contains("Pre-job situation awareness (such as TAPE");
		softly.assertThat(c3a).as("test data").contains(", PJB, etc.) requirements about when, who, and what");
		//Click on 3rd collapsible for 3.21.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.21.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.21.2] Activity related high risk situations not identified and mitigated such as First-Time-Evolution and in Disguise, unbalanced interest, Single Point Vulnerabilities not managed, expertise deficient, etc.");
		//2nd collapsible for 3.21.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.21.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("Situation awareness training?");
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c51).as("test data").contains("Pre-job awareness system improvements?");
		//Click on 2nd collapsible for 3.21.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.21.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c11).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.21.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c6).as("test data").contains("Situation awareness training");
		//Click on 3rd collapsible for 3.21.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.21.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.21.3] Person related high risk situations not identified and mitigated such as inadequate capabilities, attitude, personality, and experience of interfacing people.");
		//2nd collapsible for 3.21.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.21.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();		
		softly.assertThat(c8).as("test data").contains("Situation awareness training?");
		String c81 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c81).as("test data").contains("Pre-job awareness system improvements?");
		//Click on 2nd collapsible for 3.21.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.21.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c12).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.21.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();		
		softly.assertThat(c9).as("test data").contains("Situation awareness training");
		//Click on 3rd collapsible for 3.21.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.21.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.21.4] Environment related high risk situations not identified and mitigated such as harsh working conditions (temperature, lights, noise, high radiation, etc.), and human-machine interfaces (labels, displays, controls, etc.)");
		//2nd collapsible for 3.21.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.21.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("Situation awareness training?");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c23).as("test data").contains("Pre-job awareness system improvements?");
		//Click on 2nd collapsible for 3.21.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.21.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.21.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("Situation awareness training");
		//Click on 3rd collapsible for 3.21.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		share2.scrollToTop(driver);
	}

	public void verify35 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Inadequate situation awareness");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("Situation awareness identifies and analyzes internal and external risks that influence error rate. Internal risk pertains to error-prone mental states. External risk pertains to high-risk situations. Is there evidence that a lack of situation awareness contributed to this error?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.5.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.5.1] Inadequate pre-job situation awareness (such as error-prone mental states and high risk situations)");
		//2nd collapsible for 3.5.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.5.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("Situation awareness training?");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c22).as("test data").contains("Pre-job awareness system improvements?");
		//Click on 2nd collapsible for 3.5.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.5.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.5.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("Situation awareness training");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c23).as("test data").contains("Pre-job situation awareness (such as TAPE");
		softly.assertThat(c23).as("test data").contains("PJB, etc.) requirements about when, who, and what");
		//Click on 3rd collapsible for 3.5.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.5.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.5.2] Inadequate situation awareness during job(such as error prone mental states and high risk situations)");
		//2nd collapsible for 3.5.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.5.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("Situation awareness training?");
		//Click on 2nd collapsible for 3.5.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.5.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.5.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("Situation awareness training");
		//Click on 3rd collapsible for 3.5.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.5.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.5.3] Inadequate human performance observation techniques");
		//2nd collapsible for 3.5.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.5.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("Situation awareness training?");
		//Click on 2nd collapsible for 3.5.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.5.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.5.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c9).as("test data").contains("Observation techniques for human performance training");
		//Click on 3rd collapsible for 3.5.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.5.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.5.4] Inadequate equipment performance observation techniques");
		//2nd collapsible for 3.5.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.5.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("Interview error maker");
		String c14a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c14a).as("test data").contains("Interview PJB team leader");
		//Click on 2nd collapsible for 3.5.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.5.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.5.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("Training in observation techniques for equipment performance, such as degradation, abnormality, and changes");
		//Click on 3rd collapsible for 3.5.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		share2.scrollToTop(driver);
	}
	
	public void verify33 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Manager specific");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("These contributing factors are attributed to the manager as it relates to errors that impact the organizational performance.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.3.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.3.1] Inadequate resource allocation in the manager's group, by the manager");
		//2nd collapsible for 3.3.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.3.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("Work over-load for some groups and under-load for other groups?");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("Allocation of work more for correcting than preventing problems");
		//Click on 2nd collapsible for 3.3.1
		////wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		
		/*am_not applicable
		//3rd collapsible 3.3.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.3.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("Improvement of management skills and system in resource allocation");
		//Click on 3rd collapsible for 3.3.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.3.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.3.2] Inadequate provision of needed training in the manager's group, by the manager");
		//2nd collapsible for 3.3.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.3.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("Planning of training based on efficiency and quality improvement?");
		//Click on 2nd collapsible for 3.3.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.3.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.3.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("Establishing a training planning committee");
		//Click on 3rd collapsible for 3.3.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.3.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.3.3] Inadequate accountability system in the manager's group, by the manager");
		//2nd collapsible for 3.3.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.3.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("Adequate PM&T");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c36).as("test data").contains("Adequate Job Observation?");
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c37).as("test data").contains("Adequate RCA?");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[4]"))).getText();
		softly.assertThat(c22).as("test data").contains("Adequate ORRA");
		//Click on 2nd collapsible for 3.3.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.3.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.3.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c9).as("test data").contains("Improvement of accountability system");
		//Click on 3rd collapsible for 3.3.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.3.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.3.4] Inadequate prioritization and planning of work in the manager's group, by the manager");
		//2nd collapsible for 3.3.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.3.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("Work process does not include prioritization of work?");
		String c38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c38).as("test data").contains("Prioritization criteria are not balanced in three factors: time, scope (quality), and costs?");
		//Click on 2nd collapsible for 3.3.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.3.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.3.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("Improvement management prioritization and planning system");
		//Click on 3rd collapsible for 3.3.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.3.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q345).as("test data").contains("[3.3.5] Inadequate standard setting by the manager in (1) behavior (2) procedure and LOPs");
		//2nd collapsible for 3.3.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.3.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("Self analysis (assessment)?");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c23).as("test data").contains("Benchmarking with high performers?");
		//Click on 2nd collapsible for 3.3.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.3.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.3.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("Management training in standard setting");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c24).as("test data").contains("Training in procedure and LOP design");
		//Click on 3rd collapsible for 3.3.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Scroll to the end
		//share2.scrollToAPoint(driver, 1300);
		*/
		//3.3.6 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)));
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']"))).getText();
		softly.assertThat(q396).as("test data").contains("[3.3.6] Inadequate performance monitoring and trending in the manager's group");
		//2nd collapsible for 3.3.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c15).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.3.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c28).as("test data").contains("Inadequate KPIs?");
		String c40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c40).as("test data").contains("No periodic common cause analysis?");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c25).as("test data").contains("No trending of similar events or errors?");
		//Click on 2nd collapsible for 3.3.6
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.3.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c30).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.3.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c31).as("test data").contains("Performing periodic common cause analysis");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c32).as("test data").contains("Improving the performance monitoring and trending program");
		String c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		softly.assertThat(c27).as("test data").contains("Improving KPIs");
		//Click on 3rd collapsible for 3.3.6
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.3.7 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)));
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']"))).getText();
		softly.assertThat(q367).as("test data").contains("[3.3.7] Inadequate establishment of common goals, common interests, and common accountability for team work in the manager's group");
		//2nd collapsible for 3.3.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c41).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.3.7
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c42).as("test data").contains("Interfacing problems among managers?");
		String c43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c43).as("test data").contains("Infighting among supervisors or managers?");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c29).as("test data").contains("Work not done because interfacing problem between two management groups?");
		//Click on 2nd collapsible for 3.3.7
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.3.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c44).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.3.7
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c45).as("test data").contains("Management training in organizational design");
		String c34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c34).as("test data").contains("Establishing common goals, common interests, and common accountability among managers");
		//Click on 3rd collapsible for 3.3.7
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.3.8 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)));
		String q368 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']"))).getText();
		softly.assertThat(q368).as("test data").contains("[3.3.8] Inadequate corrective actions program in the manager's group");
		//2nd collapsible for 3.3.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c46).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.3.8
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c47).as("test data").contains("Repeat event from inadequate RCA?");
		String c48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c48).as("test data").contains("Not addressing emerging issues due to inattention to critical and changing issues?");
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c35).as("test data").contains("Excessive backlog corrective actions due to over-prescription of corrective actions?");
		//Click on 2nd collapsible for 3.3.8
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.3.8
		String c49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c49).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.3.8
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c50).as("test data").contains("Improvement in corrective action program implementation");
		String c39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c39).as("test data").contains("Improvement in RCA methods");
		String c56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[3]"))).getText();
		softly.assertThat(c56).as("test data").contains("Improvement in emergent issue (crisis) management system");
		//Click on 3rd collapsible for 3.3.8
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.3.9 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)));
		String q369 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']"))).getText();
		softly.assertThat(q369).as("test data").contains("[3.3.9] Inadequate vertical communication system in the manager's group");
		//2nd collapsible for 3.3.9
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c51).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.3.9
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c52).as("test data").contains("Policy training?");
		String c53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c53).as("test data").contains("Management coaching to staff?");
		String c57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c57).as("test data").contains("Inadequate work instructions to staff?");
		String c58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[4]"))).getText();
		softly.assertThat(c58).as("test data").contains("Routine staff meeting?");
		//Click on 2nd collapsible for 3.3.9
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.3.9
		String c54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c54).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.3.9
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c55).as("test data").contains("Improvement in vertical communication system");
		//Click on 3rd collapsible for 3.6.9
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.3.10 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10)));
		String q3310 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']"))).getText();
		softly.assertThat(q3310).as("test data").contains("[3.3.10] Inadequate lateral communication in the manager's group");
		//2nd collapsible for 3.3.10
		String c59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c59).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.3.10
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c60).as("test data").contains("Improvement in procedure design?");
		String c61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c61).as("test data").contains("Inadequate procedure design?");
		//Click on 2nd collapsible for 3.3.10
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.3.10
		String c62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c62).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.3.10
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c63).as("test data").contains("Management training in organizational design");
		String c64 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c64).as("test data").contains("Setting common goals and common interests");
		//Click on 3rd collapsible for 3.3.10
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//Scroll to the top
		share2.scrollToTop(driver);
	}
	
	public void verify322 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Incorrect Rules");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("If rules were set incorrectly, what were the reasons for it?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.22.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q341).as("test data").contains("[3.22.1] Inadequate field testing of the rules");
		//2nd collapsible for 3.22.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.22.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Any field tests?");
		//Click on 2nd collapsible for 3.22.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_no longer applicable
		//3rd collapsible 3.22.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.22.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div/h4/a"))));
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("Performing field testing before publishing rules/procedures");
		//Click on 3rd collapsible for 3.22.1
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.22.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q342).as("test data").contains("[3.22.2] Inadequate feedback to rule preparers to correct the incorrect rules");
		//2nd collapsible for 3.22.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.22.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("Any feedback?");
		//Click on 2nd collapsible for 3.22.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_no longer applicable
		//3rd collapsible 3.22.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c11).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.22.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c6).as("test data").contains("Designing procedures to allow doers to record errors for preparers to correct");
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();
		softly.assertThat(c28).as("test data").contains("Setting up a policy that requires stopping work when a critical error is encountered in a procedure");
		//Click on 3rd collapsible for 3.22.2
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.22.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q343).as("test data").contains("[3.22.3] Blind trust of the incorrect rules");
		//2nd collapsible for 3.22.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		
		//Click on 2nd collapsible for 3.22.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("Were clarification questions asked?");
		//Click on 2nd collapsible for 3.22.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.22.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c12).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.22.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();
		softly.assertThat(c9).as("test data").contains("QV&V℠ training");
		//Click on 3rd collapsible for 3.22.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.22.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q344).as("test data").contains("[3.22.4] Inadequate review of rules");
		//2nd collapsible for 3.22.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		
		//Click on 2nd collapsible for 3.22.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c14).as("test data").contains("How were the procedures/rules reviewed?");
		//Click on 2nd collapsible for 3.22.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.22.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c16).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.22.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c17).as("test data").contains("Providing reviewer training for effective review (such as OAR-3 Pass method)");
		//Click on 3rd collapsible for 3.22.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.22.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q345).as("test data").contains("[3.22.5] Inadequate rules for PJB, MJB, PSM, TO");
		//2nd collapsible for 3.22.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		
		//Click on 2nd collapsible for 3.22.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("Were the incorrect rules/procedures identified during pre job brief?");
		//Click on 2nd collapsible for 3.22.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.22.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("Possible Corrective Action(s)");
		//Click on 3rd collapsible for 3.22.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c21).as("test data").contains("Improvement of rules for PJB, MJB, PSM, TO");
		//Click on 3rd collapsible for 3.22.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		share2.scrollToTop(driver);
	}
	
	public void verify323 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Knowledge-Based Indecision Errors");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//3.23.1 question
		String q3231 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q3231).as("test data").contains("[3.23.1] Complacency: (1) Happy with the status quo");
		//2nd collapsible for 3.23.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.23.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Is the decision-maker happy with the status quo");
		
		
		//3.23.2 question
		String q3232 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q3232).as("test data").contains("[3.23.2] Laziness: (1) Making many excuses");
		//2nd collapsible for 3.23.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.22.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c5).as("test data").contains("Is the decision-maker one who tends to");
		
		
		//3.23.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q3233 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q3233).as("test data").contains("[3.23.3] Ignorance: (1) Isolated from information");
		//2nd collapsible for 3.23.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.23.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c8).as("test data").contains("threat (SWOT) to initiate decisions?");
		//3.23.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q3234 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q3234).as("test data").contains("[3.23.4] Fear: (1) Fear of failure, (2) Fear of being different");
		//2nd collapsible for 3.23.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.23.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c14).as("test data").contains("Is the decision-maker one who tends to think he is about to be humiliated");
		share2.scrollToTop(driver);
	}
	
	public void verify324 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Contributing factor for ineffective risk analysis");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//3.24.1 question
		String q3241 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q3241).as("test data").contains("[3.24.1] Showstoppers were not identified and managed");
		//2nd collapsible for 3.24.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.24.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Request and review showstoppers identified, and how they were managed");
		//3.24.2 question
		String q3242 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q3242).as("test data").contains("[3.24.2] SPVs were not identified and managed");
		//2nd collapsible for 3.24.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.24.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c5).as("test data").contains("Request and review showstoppers identified, and how they were managed");
		//3.24.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q3243 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q3243).as("test data").contains("[3.24.3] MPVs were not identified and managed");
		//2nd collapsible for 3.24.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.24.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("Request and review MPVs identified, and how they were managed");
		//3.24.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q3244 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q3244).as("test data").contains("[3.24.4] did not consider business risk and disaster risk in decisions");
		//2nd collapsible for 3.24.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.24.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("Request and review business risk and disaster identified, and how they were managed");
		//3.24.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q3245 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q3245).as("test data").contains("[3.24.5] No protocol providing guidelines to identify and mitigate decision risk, business risk, and disaster risks");
		//2nd collapsible for 3.24.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.24.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c19).as("test data").contains("Request and review protocols for guidelines");
		share2.scrollToTop(driver);
	}

	public void verify325 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Contributing factor for inadequate risk analysis");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//3.25.1 question
		String q3251 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q3251).as("test data").contains("[3.25.1] Decision made under time pressure");
		//2nd collapsible for 3.25.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.25.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Interview decision makers");
		//3.25.2 question
		String q3252 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q3252).as("test data").contains("[3.25.2] Not knowing how to perform a risk analysis due to a lack of training");
		//2nd collapsible for 3.54.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.25.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c5).as("test data").contains("Interview decision makers");
		//3.25.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q3253 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q3253).as("test data").contains("[3.25.3] No business protocol requiring a risk analysis (business only)");
		//2nd collapsible for 3.25.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.25.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("Interview decision makers");
		share2.scrollToTop(driver);
	}
	
	public void verify326 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Contributing factor for needed information not collected");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//3.26.1 question
		String q3261 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q3261).as("test data").contains("[3.26.1] Information not collected due to time pressure");
		//2nd collapsible for 3.26.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.24.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Interview decision makers");
		//3.26.2 question
		String q3262 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q3262).as("test data").contains("[3.26.2] Information not collected due to a lack of effort");
		//2nd collapsible for 3.26.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.26.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c5).as("test data").contains("Interview decision makers");
		//3.26.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q3263 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q3263).as("test data").contains("[3.26.3] Information not collected due to unavailability");
		//2nd collapsible for 3.26.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.26.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("Interview decision makers");
		//3.26.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q3264 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q3264).as("test data").contains("[3.26.4] Information not collected due to omission");
		//2nd collapsible for 3.26.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.26.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("Interview decision makers");
		//3.26.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q3265 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q3265).as("test data").contains("[3.26.5] Information not collected because of a wrong information collection channel (such as a newspaper search instead of internet search, hearsay versus formal interview, etc.)");
		//2nd collapsible for 3.26.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.26.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c19).as("test data").contains("Interview decision makers");
		//3.26.6 question
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
				String q3266 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
				softly.assertThat(q3266).as("test data").contains("[3.26.6] No business protocol providing guidelines of information collection (business only)");
				//2nd collapsible for 3.24.5
				String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
				softly.assertThat(c18).as("test data").contains("Further Investigation");
				//Click on 2nd collapsible for 3.24.5
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
				//text inside
				String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
				softly.assertThat(c19).as("test data").contains("Interview decision makers");
				share2.scrollToTop(driver);
		share2.scrollToTop(driver);
	}
	
	public void verify327 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Contributing factor for misuse of information in decision-making");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//3.27.1 question
		String q3271 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q3271).as("test data").contains("[3.27.1] Did not use QV&V to avoid taking false information as truth");
		//2nd collapsible for 3.27.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.27.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Interview decision makers");
		//3.27.2 question
		String q3272 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q3272).as("test data").contains("[3.27.2] Did not use QV&V to avoid taking true information as false");
		//2nd collapsible for 3.27.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.27.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c5).as("test data").contains("Interview decision makers");
		//3.27.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q3273 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q3273).as("test data").contains("[3.27.3] Not using the targeted information scoping (TIS) technique to collect needed information");
		//2nd collapsible for 3.27.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.27.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("Interview decision makers");
		//3.27.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q3274 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q3274).as("test data").contains("[3.27.4] No training on the avoidance of information usage errors");
		//2nd collapsible for 3.27.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.27.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("Interview decision makers");
		//3.27.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q3275 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q3275).as("test data").contains("[3.27.5] No business protocol providing guidelines of how to avoid information usage errors (business only)");
		//2nd collapsible for 3.27.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.27.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c19).as("test data").contains("Interview decision makers");
			share2.scrollToTop(driver);
	}
	
	public void verify328 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Contributing factor for lack of prediction analysis");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//3.28.1 question
		String q3281 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q3281).as("test data").contains("[3.28.1] No prediction analysis capability");
		//2nd collapsible for 3.28.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.28.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Interview decision makers");
		//3.28.2 question
		String q3282 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q3282).as("test data").contains("[3.28.2] Not knowing the need to perform prediction analysis");
		//2nd collapsible for 3.28.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.28.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c5).as("test data").contains("Interview decision makers");
		//3.28.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q3283 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q3283).as("test data").contains("[3.28.3] No business protocol requiring prediction analysis when the decision involves a future situation (business only)");
		//2nd collapsible for 3.28.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.28.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("Interview decision makers");
		share2.scrollToTop(driver);
	}
	
	public void verify329 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Contributing factor for invalid prediction analysis");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//3.29.1 question
		String q3291 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q3291).as("test data").contains("[3.29.1] Wrong method is used");
		//2nd collapsible for 3.29.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.29.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Interview decision makers");
		//3.29.2 question
		String q3292 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q3292).as("test data").contains("[3.29.2] Uncertainty is too large");
		//2nd collapsible for 3.29.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.29.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c5).as("test data").contains("Interview decision makers");
		//3.29.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q3293 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q3293).as("test data").contains("[3.29.3] Assumptions in prediction not validated");
		//2nd collapsible for 3.29.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.29.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("Interview decision makers");
		//3.29.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q3294 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q3294).as("test data").contains("[3.29.4] Prediction model not verified");
		//2nd collapsible for 3.29.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.29.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("Interview decision makers");
		//3.29.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q3295 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q3295).as("test data").contains("[3.29.5] No business protocol providing guidelines for performing prediction analysis (business only)");
		//2nd collapsible for 3.29.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.29.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c19).as("test data").contains("Interview decision makers");
			share2.scrollToTop(driver);
	}
	
	public void verify330 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Contributing factor for right choice omitted");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//3.30.1 question
		String q3301 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q3301).as("test data").contains("[3.30.1] Experienced people not involved in brainstorming");
		//2nd collapsible for 3.30.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.30.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Interview decision makers");
		//3.30.2 question
		String q3302 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q3302).as("test data").contains("[3.30.2] Future occurrence with unknown outcome not considered in decision tree");
		//2nd collapsible for 3.30.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.30.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c5).as("test data").contains("Interview decision makers");
		//3.30.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q3303 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q3303).as("test data").contains("[3.30.3] Choices derived from benchmarking with others not considered     ");
		//2nd collapsible for 3.30.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.30.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("Interview decision makers");
		//3.30.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q3304 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q3304).as("test data").contains("[3.30.4] Choices derived from a process to identify the omitted not considered");
		//2nd collapsible for 3.30.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.30.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("Interview decision makers");
		//3.30.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q3305 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q3305).as("test data").contains("[3.30.5] Choices involving extension and integration of the existing product/service not considered");
		//2nd collapsible for 3.30.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.30.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c19).as("test data").contains("Interview decision makers");
		//3.30.6 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q3306 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q3306).as("test data").contains("[3.30.6] Choices involving transfer of applications in other areas not considered");
		//2nd collapsible for 3.30.6
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.30.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c21).as("test data").contains("Interview decision makers");
		//3.30.7 question
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
				String q3307 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
				softly.assertThat(q3307).as("test data").contains("[3.30.7] No business protocol providing guidelines of identifying all viable choices (business only)");
				//2nd collapsible for 3.30.7
				String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
				softly.assertThat(c22).as("test data").contains("Further Investigation");
				//Click on 2nd collapsible for 3.30.7
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
				//text inside
				String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
				softly.assertThat(c23).as("test data").contains("Interview decision makers");
			share2.scrollToTop(driver);
	}
	
	public void verify331 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("Contributing factor for right choice not selected");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(textD).as("test data").contains("If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		//3.31.1 question
		String q3311 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(q3311).as("test data").contains("[3.31.1] Educated judgment being inadequate to select the best choice");
		//2nd collapsible for 3.31.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.31.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c2).as("test data").contains("Interview decision makers");
		//3.31.2 question
		String q3312 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(q3312).as("test data").contains("[3.31.2] Inadequate selection attributes used in weighted attribute matrix analysis");
		//2nd collapsible for 3.31.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.31.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c5).as("test data").contains("Interview decision makers and review selection attributes used for weighted attribute matrix analysis");
		//3.31.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q3313 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(q3313).as("test data").contains("[3.31.3] Not using adequate game strategy in decision-making");
		//2nd collapsible for 3.31.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.31.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c8).as("test data").contains("Interview decision makers");
		//3.31.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q3314 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']"))).getText();
		softly.assertThat(q3314).as("test data").contains("[3.31.4] Not using probability analysis to quantify the value of the choices");
		//2nd collapsible for 3.31.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.31.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c14).as("test data").contains("Interview decision makers");
		//3.31.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q3315 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q3315).as("test data").contains("[3.31.5] Not using Bayles law to help make a decision in front of indirect evidence");
		//2nd collapsible for 3.31.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.31.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c19).as("test data").contains("Interview decision makers");
		//3.31.6 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q3316 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']"))).getText();
		softly.assertThat(q3316).as("test data").contains("[3.31.6] No business protocol providing guidelines of choice selection (business only)");
		//2nd collapsible for 3.31.6
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c20).as("test data").contains("Further Investigation");
		//Click on 2nd collapsible for 3.31.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();
		softly.assertThat(c21).as("test data").contains("Interview decision makers");
			share2.scrollToTop(driver);
	}
	
	public void stepOneq16 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("This question is looking to assess company/organization culture. If there are many workers witnessing the error-maker make the error and they do not intervene, then there is a cultural and management issue in terms of establishing standards and accountability.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.3 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.6] When the error-maker violated the established standards or policies, was there other staff looking on?");
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
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Unknown");
	}

	public void stepOneq17 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("Independent or self check is used to ensure correctness of an action by an independent checker or step in a procedure. The independent check can be performed before the action, called concurrent check, or after the action, called independent check.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.3 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.7] Could the error have been prevented by self check or independent check?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("No");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("Yes, as required by procedure but it wasn't done");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Yes, but not required by procedure");
	}

	public void stepOneq18 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("This question explores whether the error-maker is prepared to avoid personal errors contributed to by error-prone mental states or high-risk situations. If not, training is needed.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.3 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.8] Was the error-maker trained to manage error-prone mental states and high risk situations?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("No");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("Yes, but more than 2 years ago");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Yes, trained less than 2 years ago");
	}

	public void stepOneq19 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("This question explores the existing accountability system. If an error is made, regardless of whether it is unintentional or intentional, there is a lesson to be learned. Accountability does not mean punishment. It means the error is accounted for. If the supervisor or management has not talked to the error-maker, and a full investigation has not been completed, there could be a problem in the accountability system.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.9] Was the error-maker held accountable after the event by his or her supervisor or by management?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("No, not at all");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("Yes");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Unknown");
	}
	
	public void stepOneq110 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("This question explores the effectiveness of the PJB, PSM, TO, and MJB in terms of its identification and mitigation of risk.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.3 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.10] If a PJB (or PSM, TO, MJB) was held, why was the participant not aware so that he or she could mitigate the risk?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Not fully engaged");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("The risks were not discussed due to lack of knowledge");
	}
	
	public void stepOneq111 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("This question explores why this error has or has not happened before.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.11] Why did this error occur now, and not before?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Due to new procedures without adequate training");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("Due to new or infrequent task(s) for the error-maker");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Actually, similar errors have occurred before");
	}
	
	public void stepOneq112 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("Before a task a PJB, PSM, TO or MJB is usually performed to identify and mitigate risks. Not performing the PJB, MJB, TO or PSM could contribute to the error.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.12] If PJB (or PSM, TO, MJB) was not performed, why?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Not performed due to intentional violation");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("Not performed due to unintentional violation (inadequate rules or requirements for PJB)");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Not performed because PJB is not required");
	}
	
	public void stepOneq113 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("This question checks if error-prone mental states or high-risk situations are identified. Our research has shown there are 16 error-prone mental states and 16 high-risk situations that could increase error rates significantly (see ‘About’ panel). 70% of our errors are driven by our error-prone mental states without any contribution from external factors (e.g. poor working conditions, inadequate work instructions, etc.). About 30% of consequential errors are contributed by abnormal, external influences also known as high-risk situations. High-risk means there is increased risk of an event occurrence in probability or in consequence.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.13 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.13] Was the error contributed to by error-prone mental states and/or high-risk situations?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("No. WARNING: Please re-think the answer.");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("Yes");
	}
	
	public void stepOneq114 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("Lessons learned meetings have two goals: (1) To learn how to prevent similar events; (2) To reinforce standards by the supervisors.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.14] Did the supervisor conduct routine meetings to discuss lessons learned?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("No, most of his peers conduct routine meetings");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No, but it is common among his peers not to conduct routine meetings");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Yes");
	}

	public void stepOneq115 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("A single point vulnerability (SPV) is a procedure step, action, tool, or piece of equipment, which, if it fails or is incorrectly carried out, would cause consequential events or cause the entire process to fail. Also, SPVs are not self-revealing; thus, it is not detectable until it causes the final failure.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.15] Did the event involve a single-point-vulnerability item?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes, but not identified ahead of time");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("Yes, identified but without mitigation actions");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("No");
	}
	
	public void stepOneq116 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("This question explores the possibility the error was contributed to by supervision effectiveness; such as in regards to reinforcement standards, performance feedback, interaction with staff in the field, coaching program, etc.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.16] Was the error related to inadequate supervision?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes, as compared to other supervisory groups with similar functions");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Unknown");
	}
	
	public void stepOneq117 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("This question explores the possibility the error was contributed to by management effectiveness; examples include setting organizational standards, performance accountability, etc.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.17 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.17] Did inadequate management by the manager contribute to this error?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Yes, as compared to other groups with similar functions");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();		
		softly.assertThat(ans2).as("test data").contains("No");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Unknown");
	}
	
	public void stepOneq118 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("This question explores whether the existing rule system is erroneous.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.18 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.18] Was the error caused by incorrect rules?");
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
	
	public void stepOneq119 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("This question explores whether the extent of the issue relates to organizational management and performance control.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.19 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.19] Was there a rising trend of similar errors?");
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
		softly.assertThat(ans2).as("test data").contains("No, decreasing trend");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("No trend");
	}
	
	public void stepOneq120 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();
		softly.assertThat(desc).as("test data").contains("This question explores if changes during the job are responsible for the error. Changes during the job could introduce new and unfamiliar things that could create error-prone situations.");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.20 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.20] Was the error contributed to by changes during jobs?");
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
		softly.assertThat(ans2).as("test data").contains("Yes, it is an unpredicted natural event");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("No");
	}
	
	public void stepOneq121 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.21 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.21] Was the knowledge-based error a decision error or indecision error?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("Decision error");
		//Answer 2
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(ans3).as("test data").contains("Indecision error");
	}
	
	public void stepOneq122 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.22 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.22] Could this error be prevented by providing a decision guideline?");
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
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(ans3).as("test data").contains("No");
	}
	
	public void stepOneq123 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.23 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.23] Was the decision error caused by ineffective or inadequate risk analysis?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("No");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(ans2).as("test data").contains("Yes, it was ineffective");
		//Answer 2
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Yes, it was omitted");
	}
	
	public void stepOneq124 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.24 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.24] Was the decision error caused by information error?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("No");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(ans2).as("test data").contains("Yes, needed information was not collected");
		//Answer 2
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Yes, information was mis-used in decision-making");
	}
	public void stepOneq125 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.24 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.25] Was the decision error caused by prediction error?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("No");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(ans2).as("test data").contains("Yes, due to lack of prediction analysis");
		//Answer 2
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Yes, due to invalid prediction analysis");
	}
	
	public void stepOneq126 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();		
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		//1.24 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();		
		softly.assertThat(q11).as("test data").contains("[1.26] Was the decision error caused by selection error?");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();		
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();		
		softly.assertThat(ans1).as("test data").contains("No");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(ans2).as("test data").contains("Yes, the right choice was omitted for consideration");
		//Answer 2
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Yes, the right choice was not selected");
	}
	
	public void verifySelections(WebDriver driver, List<String> lopOptions, SoftAssertions softly, String username, String text, MultiValuedMap<String,String>hircaNoteLopSURE,HashMap<String,String>hircaNoteLopStep4) throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		HiRCALevel1 obj = new HiRCALevel1();
		List<String>lopOptions1 = new ArrayList<String>();
		for(int i=0;i<lopOptions.size();i++)
		{
			String s = lopOptions.get(i).replace("[", "");
			lopOptions1.add(s);
		}
		//Verify Step 3 SUEP
		HashMap<String,Integer> options = obj.verifySUEP(driver,lopOptions1, softly,hircaNoteLopSURE);
		jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		String skip=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		Thread.sleep(2000);
		if(skip.contains("ui-state-disabled"))
		{
			//Click on next
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
	//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		//Verify Step 4
		HashMap<String,String> hml = obj.verifyStep4(driver,options,lopOptions1,hircaNoteLopStep4);
		Thread.sleep(6000);
		jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		String skip2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip2.contains("ui-state-disabled"))
		{
			//Click on next
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		Thread.sleep(2000);
		//Verify Step 5
		List<String> checklist=obj.verifyHiRCAChecklist(driver);
		Thread.sleep(4000);
		jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		String skip1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip1.contains("ui-state-disabled"))
		{
			//Click on next
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		Thread.sleep(2000);
		//Verify if on Report Tab by looking for finalize button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-finalize")));
		//obj.verifyReport(driver, lopOptions1, options, hml, checklist,0,hircaNoteLopSURE);
		//Click on save
		jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("11"))
			{
				share2.loadingServer(driver);	
				//Clicks on Save
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
				//Clicks on Save report
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title")));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				share2.loadingServer(driver);
			}
		}
		//Clicks on Info tab
		jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();
		//Create an expected name
		String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		String name = creationDate + "_"+username+"_"+ text;
		System.out.println(name);	 
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Gets newly created record name
		WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"));
		String recordName = record.getText();
		String r1 = recordName.replaceAll("\u00AD", "");
		if (record.isDisplayed())
		{
			System.out.println("Record found: "+ r1);
		}
		else
			System.out.println("Record not found.");
		//Checks if expected name and actual name is correct
		//softly.assertThat(r1).as("test data").isEqualTo(name);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			obj.downloadReportChrome(driver,lopOptions1,hml,options,checklist);
		if (browserName.equals("firefox"))
			obj.downloadReportFirefox(driver,lopOptions1,hml,options,checklist);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				obj.downloadReportIE(driver,lopOptions1,hml,options,checklist);
			if (v.startsWith("11"))
				obj.downloadReportIE11(driver,lopOptions1,hml,options,checklist);
		}
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(2000);
		//Delete report
		obj.deleteReport(driver);
	}
}
