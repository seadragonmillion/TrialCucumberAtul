import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import kaleTestSoftware.*;
import kaleTestSoftware.HiRCA2;
import kaleTestSoftware.HiRCAFunctionsForLevel1_2_3;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiRCAHumanError {

	SoftAssertions softly = new SoftAssertions();
	HiRCAFunctionsForLevel1_2_3 hfl123 = new HiRCAFunctionsForLevel1_2_3();
	HiRCAObj hirca = new HiRCAObj();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	HiRCALOPBug2 hlb2 = new HiRCALOPBug2();

	public void stepOneq11(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		// Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		// 1.1 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(q11).as("test data")
				.contains("[1.1] Was the triggering event a human error, an equipment failure, or an act of nature?");
		// Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		// Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField))
				.getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		// Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(ans1).as("test data").contains("Human error");
		// Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(ans2).as("test data").contains("Equipment failure");
		// Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Act of nature");
	}

	public void stepOneq12(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		// Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		// 1.2 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(q11).as("test data").contains("[1.2] What was the type of human error?");
		// Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		// Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField))
				.getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		// Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(ans1).as("test data").contains("Knowledge-based");
		// Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(ans2).as("test data").contains("Rule-based");
		// Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Skill-based");
	}

	public void stepOneq13(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		// Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		// 1.3 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(q11).as("test data")
				.contains("[1.3] For a rule-based error, was the error intentional or unintentional?");
		// Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		// Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField))
				.getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		// Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(ans1).as("test data").contains("Intentional");
		// Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(ans2).as("test data").contains("Unintentional");
		// Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		softly.assertThat(ans3).as("test data").contains("Unknown");
	}

	public void stepOneq14(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		// Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		// 1.3 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(q11).as("test data").contains(
				"[1.4] Was the unintentional error related to inattention-to-detail behavior or inadequate rules?");
		// Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		// Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField))
				.getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		// Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(ans1).as("test data").contains("Inattention to detail");
		// Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(ans2).as("test data").contains("Inadequate rules");
	}

	public void stepOneq15(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		// Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageTitle)).getText();
		softly.assertThat(heading).as("test data").contains("Step 1: Root Cause Investigation Component");
		// 1.3 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(q11).as("test data")
				.contains("[1.5] If I were the error-maker, would I make the same error?");
		// Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryLabel)).getText();
		softly.assertThat(reason).as("test data").contains("Reason Entry:");
		// Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField))
				.getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("Optionally enter the reason of your selection");
		// Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(ans1).as("test data").contains("No");
		// Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(ans2).as("test data").contains("Yes");
	}

	public String selectAnswer(WebDriver driver, int x) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		OPiRCA2 obj = new OPiRCA2();
		HiRCALevel1 obj1 = new HiRCALevel1();
		// Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).sendKeys(obj1.text(driver));
		// Choose a number between 0 to x
		Thread.sleep(2000);
		int n = obj.chooseRandomOption(x, 0);
		Thread.sleep(2000);
		// Choose the option based on selection
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-" + n + "']")))
				.click();
		Thread.sleep(500);
		String s = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-" + n + "']")))
				.getText();
		System.out.println(s);
		Thread.sleep(500);
		return s;
	}

	public List<String> selectAnswersLevel3(WebDriver driver, int m) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		HiRCALevel1 obj = new HiRCALevel1();
		List<String> lopOptions1 = new ArrayList<String>();
		Random random = new Random();
		// Choose a number between 0 and m for number of selections
		int n = random.nextInt(m);
		int y;
		outer: for (int i = 1; i <= n; i++) {
			// Choose a number between 2 and m+1
			while (true) {
				y = random.nextInt(m + 1);
				if (y == 0 || y == 1)
					continue;
				if (wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[" + y + "]/fieldset")))
						.getAttribute("class").contains("ui-state-disabled")) {
					if (wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-irca-answers']/div[" + y + "]/fieldset/div/div/label"))).getText()
							.contains("3.16"))
						continue;
				}
				WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[" + y + "]/fieldset/div/div/input")));
				if (e.isSelected())
					continue outer;
				break;
			}
			// Scroll to element
			WebElement el=driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div[" + y + "]/fieldset/div/div/label"));
			jse.executeScript("arguments[0].scrollIntoView();", el);
//			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-irca-answers']/div[" + y + "]/fieldset/div/div/label"))));
			// Click on a lop answer
			jse.executeScript("arguments[0].click();", el);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[" + y + "]/fieldset/div/div/label"))).click();
			Thread.sleep(500);
			// Click on Evidence Entry
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[" + y + "]/fieldset/div/div[2]/div/h4/a"))).click();
			while (true) {
				if (driver
						.findElement(By.xpath(
								".//*[@id='efi-irca-answers']/div[" + y + "]/fieldset/div/div[2]/div/div/textarea"))
						.isDisplayed() == true)
					break;
				else
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-irca-answers']/div[" + y + "]/fieldset/div/div[2]/div/h4/a")))
							.click();
			}
			// Evidence entry
			String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-evidence-text-div-" + (y - 2) + "']/h4/a"))).getText();
			softly.assertThat(ev1).as("test data").contains("Evidence Entry");
			// Evidence entry place holder
			String ph1 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-" + (y - 2))))
					.getAttribute("placeholder");
			softly.assertThat(ph1).as("test data").contains("Fill in Evidence Entry (optional)");
			// Fill in evidence entry text
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[" + y + "]/fieldset/div/div[2]/div/div/textarea")))
					.sendKeys(obj.textEvidence(driver));
			Thread.sleep(500);
			// Click on Evidence Entry
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[" + y + "]/fieldset/div/div[2]/div/h4/a"))).click();
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[" + y + "]/fieldset/div/div/label"))).getText();
			lopOptions1.add(s);
		}
		// Add contributing factor
		lopOptions1.add(obj.addContributingFactor(driver));
		// Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if (browserName.equals("chrome"))
			share2.scrollToTop(driver);
		System.out.println(lopOptions1);
		// Click next
		// Scroll to element
//		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)));
		// Click on next
		jse.executeScript("arguments[0].focus();",
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
		return lopOptions1;
	}

	public void verify312(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		// Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionText)).getText();
		softly.assertThat(lop3).as("test data").contains(
				"This question explores if the intentional violation was caused by perceived burden to execute an LOP or the work itself. Perceived burden is only a feeling that the time or effort spent on implementing an LOP is not worthwhile.");
		// Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.DescriptionPlusSign)).click();
		// 3.12 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(q11).as("test data").contains("Contributing factor for \"perceived burden\"");
		// text under description
		String textD = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]")))
				.getText();
		softly.assertThat(textD).as("test data").contains(
				"If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		// 3.12.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(q341).as("test data").contains("[3.12.1] Perceived burden to obtain tools and equipment");
		// 2nd collapsible for 3.12.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.12.1
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c2).as("test data").contains(
				"Observation of staff; using their own tools (such as multi-function pocket tools, i.e., Swiss army knifes); Observing engineers?");
		// Click on 2nd collapsible for 3.12.1
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.12.1 String c10 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c10).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.12.1 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c3 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c3).as("test data").
		 * contains("Delivery of tools when in emergency"); String c35 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c35).as("test data").
		 * contains("Simplification of tool staging process"); String c37 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[3]"
		 * ))).getText(); softly.assertThat(c37).as("test data").
		 * contains("Setting tools and equipment at convenient locations"); //Click on
		 * 3rd collapsible for 3.12.1
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.12.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(q342).as("test data").contains("[3.12.2] Perceived burden to obtain documents or procedures");
		// 2nd collapsible for 3.12.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.12.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c5).as("test data").contains("Observation of staff in the field carrying procedures");
		String c46 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c46).as("test data")
				.contains("Observation of staff locating the right procedures before doing the work");
		// Click on 2nd collapsible for 3.12.2
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.12.2 String c11 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c11).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.12.2 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c6 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c6).as("test data").
		 * contains("Use of a digital system to acquire documents or procedures");
		 * String c26 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c26).as("test data").
		 * contains("Attaching appropriate sections of referenced procedures in the main procedure"
		 * ); //Click on 3rd collapsible for 3.12.2
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.12.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")))
				.getText();
		softly.assertThat(q343).as("test data").contains("[3.12.3] Perceived burden to obtain and wear PPE");
		// 2nd collapsible for 3.12.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.12.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c8).as("test data").contains(
				"Observation of staff who forget to bring their hard hats, gloves, or hard-tip shoes to job sites; watching if they could get replacements without burden?");
		// Click on 2nd collapsible for 3.12.3
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.12.3 String c12 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c12).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.12.3 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c9 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c9).as("test data").
		 * contains("Setting PPEs at convenient locations"); String c36 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c36).as("test data").
		 * contains("Avoidance of over-specification of PPEs"); //Click on 3rd
		 * collapsible for 3.12.3
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.12.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")))
				.getText();
		softly.assertThat(q344).as("test data")
				.contains("[3.12.4] Perceived burden to work with an over-complex or burdensome procedure");
		// 2nd collapsible for 3.12.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.12.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c14 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c14).as("test data")
				.contains("Observation of staff working without step-by-step procedures at hand?");
		// Click on 2nd collapsible for 3.12.4
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.12.4 String c16 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c16).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.12.4 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c17 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c17).as("test data").
		 * contains("Use of a paperless procedure system"); //Click on 3rd collapsible
		 * for 3.12.4
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.12.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")))
				.getText();
		softly.assertThat(q345).as("test data")
				.contains("[3.12.5] Did not go into field and verify in field due to task being too burdensome");
		// 2nd collapsible for 3.12.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.12.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c19 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c19).as("test data").contains("Observe and interview error makers and co-workers");
		// Click on 2nd collapsible for 3.12.5
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.12.5 String c20 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c20).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.12.5 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c21 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c21).as("test data").
		 * contains("Add bypass control methods such as pictures to record physical field inspection"
		 * ); //Click on 3rd collapsible for 3.12.5
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		share2.scrollToTop(driver);
	}

	public void verify313(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(heading).as("test data").contains("Contributing factor for \"undue motivation\"");
		// text under description
		String textD = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]")))
				.getText();
		softly.assertThat(textD).as("test data").contains(
				"If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text")))
				.getText();
		softly.assertThat(desc).as("test data").contains(
				"This question explores if the intentional violation (such as short-cutting the LOP requirements like not doing the PJB as required, etc.) is caused by undue motivation such as going home early, getting out of an uncomfortable working environment, etc. Please state the any evidence of undue motivation as a contributing factor for this error.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// 3.13.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(q341).as("test data")
				.contains("[3.13.1] Completion of work sooner so that the staff can go home earlier");
		// 2nd collapsible for 3.13.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.13.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c2).as("test data").contains("Observation of staff going home early than shift time");
		// Click on 2nd collapsible for 3.13.1
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.13.1 String c10 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c10).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.13.1 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c3 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c3).as("test data").
		 * contains("Elimination of undue motivation by requiring staff to stay in office to do other related work"
		 * ); //Click on 3rd collapsible for 3.13.1
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.13.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(q342).as("test data").contains(
				"[3.13.2] Completion of work sooner so that staff could be rewarded with bonus or to avoid penalty");
		// 2nd collapsible for 3.13.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.13.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c5).as("test data")
				.contains("Interview staff about the accountability system that affects them");
		// Click on 2nd collapsible for 3.13.2
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.13.2 String c11 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c11).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.13.2 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c6 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c6).as("test data").
		 * contains("Elimination of undue motivation"); String c26 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c26).as("test data").
		 * contains("Use a balanced reward system in quality and production"); //Click
		 * on 3rd collapsible for 3.13.2
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.13.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")))
				.getText();
		softly.assertThat(q343).as("test data").contains(
				"[3.13.3] Completion of work sooner so that staff could start other jobs (especially for contractors who are paid based on number of tasks completed)");
		// 2nd collapsible for 3.13.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.13.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c8).as("test data").contains("Interview co-staff");
		// Click on 2nd collapsible for 3.13.3
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.13.3 String c12 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c12).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.13.3 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c9 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c9).as("test data").
		 * contains("Use of incentive or penalty system to deter hurry-up attitude");
		 * //Click on 3rd collapsible for 3.13.3
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.13.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")))
				.getText();
		softly.assertThat(q344).as("test data").contains(
				"[3.13.4] Completion of work sooner so that the staff could rest in a more comfortable environment (especially working at high temperature, radiation, or humid environment)");
		// 2nd collapsible for 3.13.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.13.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c14 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c14).as("test data").contains("Observe of working environment");
		// Click on 2nd collapsible for 3.13.4
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.13.4 String c16 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c16).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.13.4 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c17 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c17).as("test data").
		 * contains("Implementation of adequate break times"); String c35 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c35).as("test data").
		 * contains("Reduction of uncomfortable conditions at work places"); //Click on
		 * 3rd collapsible for 3.13.4
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// Scroll to the top
		share2.scrollToTop(driver);
	}

	public void verify314(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(heading).as("test data").contains("Contributing factor for \"low perceived risk\"");
		// text under description
		String textD = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]")))
				.getText();
		softly.assertThat(textD).as("test data").contains(
				"If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text")))
				.getText();
		softly.assertThat(desc).as("test data").contains(
				"This question explores if low perceived risk was the cause of the error.Our research found when a worker feels the risk of violation is low, s/he has a greater tendency to violate the rules. Risk is the sum of two terms. One term is the product of the probability of being caught and the consequences of penalty. The other term is the product of the probability of injury and the consequences of the injury.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// 3.14.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(q341).as("test data")
				.contains("[3.14.1] Supervisors do not provide feedback about job performance");
		// 2nd collapsible for 3.14.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.14.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c2).as("test data")
				.contains("Observation of the frequency and quality of supervisory feedback to their subordinates");
		// Click on 2nd collapsible for 3.14.1
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.14.1 String c10 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c10).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.14.1 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c3 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c3).as("test data").contains("Supervisory skills training"
		 * ); //Click on 3rd collapsible for 3.14.1
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.14.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(q342).as("test data").contains(
				"[3.14.2] Violation of established rules is not easily known (especially when working alone)");
		// 2nd collapsible for 3.14.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.14.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c5).as("test data").contains("Interview of supervisors about possible short-cuts");
		// Click on 2nd collapsible for 3.14.2
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.14.2 String c11 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c11).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.14.2 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c6 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c6).as("test data").
		 * contains("Enhancing job performance monitoring"); //Click on 3rd collapsible
		 * for 3.14.2
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.14.3 question
		String q343 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")))
				.getText();
		softly.assertThat(q343).as("test data").contains(
				"[3.14.3] The consequences of violations are perceived to be insignificant due to lack of a clear accountability system");
		// 2nd collapsible for 3.14.3
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.14.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c8).as("test data")
				.contains("Interview of staff supervisors about their perception of the accountability system");
		// Click on 2nd collapsible for 3.14.3
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.14.3 String c12 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c12).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.14.3 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c9 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c9).as("test data").
		 * contains("Improvement of accountability system"); //Click on 3rd collapsible
		 * for 3.14.3
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.14.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")))
				.getText();
		softly.assertThat(q344).as("test data")
				.contains("[3.14.4] Risk of injury due to violation is considered to be none or minimal");
		// 2nd collapsible for 3.14.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.14.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c14 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c14).as("test data")
				.contains("Observation of lessons learned meetings to see if risk of injury is discussed frequently");
		// Click on 2nd collapsible for 3.14.4
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.14.4 String c16 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c16).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.14.4 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c17 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c17).as("test data").
		 * contains("Improvement of accountability system"); //Click on 3rd collapsible
		 * for 3.14.4
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.14.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")))
				.getText();
		softly.assertThat(q345).as("test data").contains(
				"[3.14.5] Feeling of low perceived risk due to peer observation (others are doing it the same way)");
		// 2nd collapsible for 3.14.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.14.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c19 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c19).as("test data").contains("Survey staff about their common practice");
		// Click on 2nd collapsible for 3.14.5
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.14.5 String c20 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c20).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.14.5 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c21 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c21).as("test data").contains("Improving supervision");
		 * String c26 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c26).as("test data").
		 * contains("Improving field observation program"); String c35 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[3]"
		 * ))).getText(); softly.assertThat(c35).as("test data").
		 * contains("Improvement of accountability system"); //Click on 3rd collapsible
		 * for 3.14.5
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// Scroll to the top
		share2.scrollToTop(driver);
	}

	public void verify315(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(heading).as("test data")
				.contains("Contributing factors for inadequate peer coaching (assistance)");
		// text under description
		String textD = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]")))
				.getText();
		softly.assertThat(textD).as("test data").contains(
				"If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text")))
				.getText();
		softly.assertThat(desc).as("test data").contains(
				"Did the lack of peer coaching contribute to this error? If so, why was peer coaching inadequate or ineffective? Peer coaching is related to mutual coaching or assistance to help one another from getting hurt or violating rules. Peer coaching is effective only if peer coaching is set up as a program and workers are trained and held accountable for coaching one another.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// 3.15.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(q341).as("test data")
				.contains("[3.15.1] Staff is not trained to coach or correct violations of other staff");
		// 2nd collapsible for 3.15.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.15.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c2).as("test data").contains("Review the training program");
		// Click on 2nd collapsible for 3.15.1
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.15.1 String c10 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c10).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.15.1 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c3 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li")))
		 * .getText();
		 * softly.assertThat(c3).as("test data").contains("Co-worker coaching training"
		 * ); //Click on 3rd collapsible for 3.15.1
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.15.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(q342).as("test data")
				.contains("[3.15.2] Staff is not held accountable to correct violations of other staff");
		// 2nd collapsible for 3.15.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.15.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c5).as("test data")
				.contains("Review the management expectations and standards in peer coaching");
		// Click on 2nd collapsible for 3.15.2
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.15.2 String c11 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c11).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.15.2 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c6 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li")))
		 * .getText(); softly.assertThat(c6).as("test data").
		 * contains("Establishment of management expectations on co-worker coaching");
		 * //Click on 3rd collapsible for 3.15.2
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.15.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")))
				.getText();
		softly.assertThat(q343).as("test data")
				.contains("[3.15.3] Staff does not fully understand the behavior standards");
		// 2nd collapsible for 3.15.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.15.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c8).as("test data")
				.contains("Observe PJB and jobs about supervisory reinforcement of behavior standards");
		// Click on 2nd collapsible for 3.15.3
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.15.3 String c12 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c12).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.15.3 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c9 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c9).as("test data").contains("Behavior standards training"
		 * ); String c23 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c23).as("test data").
		 * contains("Use of behavior standards reminders"); String c24 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[3]"
		 * ))).getText(); softly.assertThat(c24).as("test data").
		 * contains("Use of a not-to-do warning list"); //Click on 3rd collapsible for
		 * 3.15.3 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.15.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")))
				.getText();
		softly.assertThat(q344).as("test data")
				.contains("[3.15.4] Supervisors do not reinforce peer coaching in the field");
		// 2nd collapsible for 3.15.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.15.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c14 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c14).as("test data")
				.contains("Observe PJB and jobs about supervisory reinforcement of behavior standards");
		// Click on 2nd collapsible for 3.15.4
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.15.4 String c16 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c16).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.15.4 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c17 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c17).as("test data").contains("Supervisory skills training"
		 * ); String c15 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c15).as("test data").
		 * contains("Accountability of supervisory reinforcement by the management");
		 * //Click on 3rd collapsible for 3.15.4
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		share2.scrollToTop(driver);
	}

	public void verify316(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			// question
			String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
			softly.assertThat(heading).as("test data").contains("Contributing factor for inattention-to-detail");
			// text under description
			String textD = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]")))
					.getText();
			softly.assertThat(textD).as("test data").contains(
					"If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
			// Click on Description
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
					.click();
			// Description text
			String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text")))
					.getText();
			softly.assertThat(desc).as("test data").contains(
					"Inattention-to-detail is an error-prone behavior. It is characterized by errors resulting from not paying full attention to the task at hand. One or more error-prone mental states can cause inattention-to-detail errors. These five error-prone mental states are (1) existing drowsiness (2) distractions and preoccupation, (3) overconfidence, (4) time pressure, and (5) attention bank and span insufficiency.");
			// Click on Description
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
					.click();
			// 3.16.1 question
			String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
			softly.assertThat(q341).as("test data").contains(
					"[3.16.1] Drowsiness: (1) Occurs at about 3-4 am; (2) Occurs at about 2-3 pm; (3) Long working hours");
			// 2nd collapsible for 3.16.1
			String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
			softly.assertThat(c1).as("test data").contains("Further Investigation");
			// Click on 2nd collapsible for 3.16.1
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
			// text inside
			String c2 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
					.getText();
			softly.assertThat(c2).as("test data").contains("Examine past events");
			// Click on 2nd collapsible for 3.16.1
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();

			/*
			 * am_not applicable //3rd collapsible 3.16.1 String c10 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * getText(); softly.assertThat(c10).as("test data").
			 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
			 * 3.16.1 executor.executeScript("arguments[0].click();",
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
			 * //text inside String c3 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
			 * ))).getText();
			 * softly.assertThat(c3).as("test data").contains("Rest break management");
			 * String c26 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
			 * ))).getText(); softly.assertThat(c26).as("test data").
			 * contains("Error-Free® behavior training (BEDS"); //Click on 3rd collapsible
			 * for 3.16.1
			 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * click();
			 */
			// 3.16.2 question
			String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
			softly.assertThat(q342).as("test data")
					.contains("[3.16.2] Distractions: (1) Multi-tasking; (2) Interruption; (3) Preoccupation");
			// 2nd collapsible for 3.16.2
			String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
			softly.assertThat(c4).as("test data").contains("Further Investigation");
			// Click on 2nd collapsible for 3.16.2
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
			// text inside
			String c5 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
					.getText();
			softly.assertThat(c5).as("test data").contains("Interview the error-maker");
			String c22 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
					.getText();
			softly.assertThat(c22).as("test data").contains("Interview co-workers");
			// Click on 2nd collapsible for 3.16.2
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();

			/*
			 * am_not applicable //3rd collapsible 3.16.2 String c11 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * getText(); softly.assertThat(c11).as("test data").
			 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
			 * 3.16.2 executor.executeScript("arguments[0].click();",
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
			 * //text inside String c6 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
			 * ))).getText(); softly.assertThat(c6).as("test data").
			 * contains("Error-Free® behavior training (MIND"); //Click on 3rd collapsible
			 * for 3.16.2
			 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * click();
			 */
			// 3.16.3 question
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
			String q343 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")))
					.getText();
			softly.assertThat(q343).as("test data").contains(
					"[3.16.3] Overconfidence: (1) First-time evolution without seeking adequate help; (2) Routine work without noticing small changes and new situations; (3) Tedious work without periodic self-check (such as data entry); (4) Using information or data without QV&V℠; (5) Failure to check for SPV(s) and perform self-checks on SPV(s) found; (6) Recalling steps by operating from memory (working without procedure at hand)");
			// 2nd collapsible for 3.16.3
			String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
			softly.assertThat(c7).as("test data").contains("Further Investigation");
			// Click on 2nd collapsible for 3.16.3
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
			// text inside
			String c8 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
					.getText();
			softly.assertThat(c8).as("test data").contains("Interview the error-maker");
			// Click on 2nd collapsible for 3.16.3
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();

			/*
			 * am_not applicable //3rd collapsible 3.16.3 String c12 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * getText(); softly.assertThat(c12).as("test data").
			 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
			 * 3.16.3 executor.executeScript("arguments[0].click();",
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
			 * //text inside String c9 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
			 * ))).getText(); softly.assertThat(c9).as("test data").
			 * contains("SPV and FTE discussions at PJB, MJB, TO, or PSM"); String c36 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
			 * ))).getText(); softly.assertThat(c36).as("test data").
			 * contains("Error-Free® behavior training"); //Click on 3rd collapsible for
			 * 3.16.3 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * click();
			 */
			// 3.16.4 question
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
			String q344 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")))
					.getText();
			softly.assertThat(q344).as("test data").contains("[3.16.4] Time pressure: Rushing to complete job");
			// 2nd collapsible for 3.16.4
			String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
			softly.assertThat(c13).as("test data").contains("Further Investigation");
			// Click on 2nd collapsible for 3.16.4
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
			// text inside
			String c14 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
					.getText();
			softly.assertThat(c14).as("test data").contains("Field observation");
			String c38 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
					.getText();
			softly.assertThat(c38).as("test data").contains("Interview co-workers");
			// Click on 2nd collapsible for 3.16.4
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();

			/*
			 * am_not applicable //3rd collapsible 3.16.4 String c16 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * getText(); softly.assertThat(c16).as("test data").
			 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
			 * 3.16.4 executor.executeScript("arguments[0].click();",
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
			 * //text inside String c17 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
			 * ))).getText(); softly.assertThat(c17).as("test data").
			 * contains("Error-Free® behavior training (PRSM"); String c37 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
			 * ))).getText(); softly.assertThat(c37).as("test data").
			 * contains("Improvement in scheduling and planning system"); //Click on 3rd
			 * collapsible for 3.16.4
			 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * click(); //Scroll to the end //share2.scrollToAPoint(driver, 1500);
			 */
			// 3.16.5 question
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
			String q345 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")))
					.getText();
			softly.assertThat(q345).as("test data").contains(
					"[3.16.5] Attention bank and span insufficiency: 1. working without break > 140 minutes; 2. Work around 10am; 3. Work over 10 hours");
			// 2nd collapsible for 3.16.5
			String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
			softly.assertThat(c18).as("test data").contains("Further Investigation");
			// Click on 2nd collapsible for 3.16.5
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
			// text inside
			String c19 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
					.getText();
			softly.assertThat(c19).as("test data").contains("Field observation");
			String c23 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
					.getText();
			softly.assertThat(c23).as("test data").contains("Interview co-workers");
			// Click on 2nd collapsible for 3.16.5
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();

			/*
			 * am_not applicable //3rd collapsible 3.16.5 String c20 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * getText(); softly.assertThat(c20).as("test data").
			 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
			 * 3.16.5 executor.executeScript("arguments[0].click();",
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
			 * //text inside String c21 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
			 * ))).getText(); softly.assertThat(c21).as("test data").
			 * contains("Taking appropriate rest breaks"); String c24 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
			 * ))).getText();
			 * softly.assertThat(c24).as("test data").contains("Minimizing distractions");
			 * //Click on 3rd collapsible for 3.16.5
			 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * click();
			 */
			// 3.16.6 question
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)));
			String q396 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")))
					.getText();
			softly.assertThat(q396).as("test data").contains("[3.16.6] Inadequate rules to develop skills");
			// 2nd collapsible for 3.16.6
			String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
			softly.assertThat(c15).as("test data").contains("Further Investigation");
			// Click on 2nd collapsible for 3.16.6
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))));
			// text inside
			String c28 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
					.getText();
			softly.assertThat(c28).as("test data").contains("Review the original rules");
			// Click on 2nd collapsible for 3.16.6
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();

			/*
			 * am_not applicable //3rd collapsible 3.16.6 String c30 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * getText(); softly.assertThat(c30).as("test data").
			 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
			 * 3.16.6 executor.executeScript("arguments[0].click();",
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))));
			 * //text inside String c31 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
			 * ))).getText();
			 * softly.assertThat(c31).as("test data").contains("Retaining of right skills");
			 * //Click on 3rd collapsible for 3.16.6
			 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * click();
			 */
			// 3.16.7 question
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)));
			String q367 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")))
					.getText();
			softly.assertThat(q367).as("test data")
					.contains("[3.16.7] Inadequate knowledge to select right skills to apply");
			// 2nd collapsible for 3.16.7
			String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
			softly.assertThat(c41).as("test data").contains("Further Investigation");
			// Click on 2nd collapsible for 3.16.7
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))));
			// text inside
			String c42 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
					.getText();
			softly.assertThat(c42).as("test data").contains("Interview error maker");
			// Click on 2nd collapsible for 3.16.7
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();

			/*
			 * am_not applicable //3rd collapsible 3.16.7 String c44 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * getText(); softly.assertThat(c44).as("test data").
			 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
			 * 3.16.7 executor.executeScript("arguments[0].click();",
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))));
			 * //text inside String c45 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
			 * ))).getText(); softly.assertThat(c45).as("test data").
			 * contains("Training in selection of skills"); String c34 =
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
			 * ))).getText(); softly.assertThat(c34).as("test data").
			 * contains("Elimination of selection options through specific rules");
			 * 
			 * //Click on 3rd collapsible for 3.16.7
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).
			 * click();
			 */
		} catch (org.openqa.selenium.WebDriverException r) {

		}

		// Scroll to the top
		share2.scrollToTop(driver);
	}

	public void verify36(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(heading).as("test data").contains("Inadequate \"all-inclusiveness\"");
		// text under description
		String textD = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]")))
				.getText();
		softly.assertThat(textD).as("test data").contains(
				"If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text")))
				.getText();
		softly.assertThat(desc).as("test data").contains(
				"Did a lack of requirements, operating conditions, assumptions, scope, testing/measurements, missing sections or elements contribute to this error? Inadequate All-Inclusiveness looks to see if the program design covers all requirements, conditions, assumptions, and work scope. If the error is caused by confusion due to a lack of established guidance or necessary functions/steps are omitted from a procedure, then all-inclusiveness is most likely inadequate.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// 3.6.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(q341).as("test data").contains("[3.6.1] Omission of programmatic requirements");
		// 2nd collapsible for 3.6.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.6.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c2).as("test data").contains("Code and standards");
		String c26 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c26).as("test data").contains("Commercial or contractual requirements");
		String c29 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[3]")))
				.getText();
		softly.assertThat(c29).as("test data").contains("Interfacing requirements with other program");
		// Click on 2nd collapsible for 3.6.1
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.6.1 String c10 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c10).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.6.1 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c3 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c3).as("test data").contains("Improving the rules"); String
		 * c27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c27).as("test data").
		 * contains("Training in procedure design");
		 */
		// Click on 3rd collapsible for 3.6.1
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		// 3.6.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(q342).as("test data").contains("[3.6.2] Omission of operating conditions in program(s)");
		// 2nd collapsible for 3.6.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.6.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c5).as("test data").contains("Range of operating conditions under which the rules are valid");
		String c34 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c34).as("test data").contains("Prerequisite conditions for entering the rules");
		String c35 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]")))
				.getText();
		softly.assertThat(c35).as("test data").contains("Conditions to exit the rules");
		// Click on 2nd collapsible for 3.6.2
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.6.2 String c11 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c11).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.6.2 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c6 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c6).as("test data").contains("Improving the rules"); String
		 * c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c22).as("test data").
		 * contains("Training in procedure design");
		 */
		// Click on 3rd collapsible for 3.6.2
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		// 3.6.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")))
				.getText();
		softly.assertThat(q343).as("test data")
				.contains("[3.6.3] Omission of assumptions to be called out in program(s)");
		// 2nd collapsible for 3.6.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.6.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c8).as("test data").contains("Assumptions not stated");
		String c36 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c36).as("test data")
				.contains("Validation of assumptions not required before completion of the task");
		String c37 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[3]")))
				.getText();
		softly.assertThat(c37).as("test data").contains("No mitigation for assumptions not validated");
		// Click on 2nd collapsible for 3.6.3
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.6.3 String c12 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c12).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.6.3 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c9 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c9).as("test data").contains("Improving the rules"); String
		 * c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c23).as("test data").
		 * contains("Training in procedure design");
		 */
		// Click on 3rd collapsible for 3.6.3
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		// 3.6.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")))
				.getText();
		softly.assertThat(q344).as("test data").contains("[3.6.4] Omission of scope in program(s)");
		// 2nd collapsible for 3.6.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.6.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));

		/*
		 * am_not applicable //text inside String c14 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c14).as("test data").
		 * contains("Use of a generic rule, missing details of various specific applications"
		 * ); String c38 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"
		 * ))).getText();
		 * softly.assertThat(c38).as("test data").contains("Missing steps"); String c39
		 * = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[3]"
		 * ))).getText(); softly.assertThat(c39).as("test data").
		 * contains("Missing actions when abnormal situations are encountered"); //Click
		 * on 2nd collapsible for 3.6.4
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).
		 * click();
		 * 
		 * 
		 * //3rd collapsible 3.6.4 String c16 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c16).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.6.4 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c17 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c17).as("test data").contains("Improving the rules");
		 * String c25 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c25).as("test data").
		 * contains("Training in procedure design");
		 */
		// Click on 3rd collapsible for 3.6.4
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		// 3.6.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")))
				.getText();
		softly.assertThat(q345).as("test data")
				.contains("[3.6.5] Omission of testing or measurements in program validation");
		// 2nd collapsible for 3.6.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.6.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c19 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c19).as("test data")
				.contains("Missing testing or measurements to accept the correctness of execution");
		// Click on 2nd collapsible for 3.6.5
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.6.5 String c20 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c20).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.6.5 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c21 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c21).as("test data").contains("Improving the rules");
		 * String c24 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c24).as("test data").
		 * contains("Training in procedure design");
		 */
		// Click on 3rd collapsible for 3.6.5
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		// Scroll to the end
		// share2.scrollToAPoint(driver, 1200);
		// 3.6.6 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)));
		String q396 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")))
				.getText();
		softly.assertThat(q396).as("test data").contains(
				"[3.6.6] Missing sections in: (1) Description of purpose; (2) Description of prerequisite; (3) Description of terminology; (4) Description of lessons learned in not-to-do lists; (5) References; (6) Request feedback from users");
		// 2nd collapsible for 3.6.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c15).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.6.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c28 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c28).as("test data").contains("Interview procedure preparer");
		String c40 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c40).as("test data").contains("Investigate training program in procedure preparation");
		// Click on 2nd collapsible for 3.6.6
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.6.6 String c30 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c30).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.6.6 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c31 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c31).as("test data").
		 * contains("Training in procedure design"); String c32 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c32).as("test data").
		 * contains("Improving the defective guidelines or procedures");
		 */
		// Click on 3rd collapsible for 3.6.6
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		// 3.6.7 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)));
		String q367 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")))
				.getText();
		softly.assertThat(q367).as("test data")
				.contains("[3.6.7] Omission of elements in programs due to inadequate review");
		// 2nd collapsible for 3.6.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c41).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.6.7
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))));
		/*
		 * am_not applicable //text inside String c42 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c42).as("test data").contains("Interview reviewer"); String
		 * c43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c43).as("test data").
		 * contains("Investigate training program in review"); //Click on 2nd
		 * collapsible for 3.6.7
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).
		 * click();
		 * 
		 * //3rd collapsible 3.6.7 String c44 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c44).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.6.7 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c45 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c45).as("test data").contains("Training in review");
		 */
		// Click on 3rd collapsible for 3.6.7
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		// 3.6.8 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)));
		String q368 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']")))
				.getText();
		softly.assertThat(q368).as("test data")
				.contains("[3.6.8] Omission of elements in programs due to inadequate previous root cause analysis");
		// 2nd collapsible for 3.6.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c46).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.6.8
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))));

		/*
		 * am_not applicable //text inside String c47 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c47).as("test data").
		 * contains("Interview root cause analyst"); String c48 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c48).as("test data").
		 * contains("Investigate training program in root cause analysis"); //Click on
		 * 2nd collapsible for 3.6.8
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).
		 * click();
		 * 
		 * //3rd collapsible 3.6.8 String c49 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c49).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.6.8 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c50 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c50).as("test data").
		 * contains("Training in root cause analysis"); //Click on 3rd collapsible for
		 * 3.6.8 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.6.9 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)));
		String q369 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']")))
				.getText();
		softly.assertThat(q369).as("test data")
				.contains("[3.6.9] Omission of elements in programs due to corrective action not carried out");
		// 2nd collapsible for 3.6.9
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c51).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.6.9
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c52 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c52).as("test data").contains("Interview corrective action program manager");
		String c53 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c53).as("test data").contains("Investigate corrective action program deficiencies");
		// Click on 2nd collapsible for 3.6.9
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.6.9 String c54 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c54).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.6.9 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c55 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c55).as("test data").
		 * contains("Improving corrective action program monitoring and execution");
		 */
		// Click on 3rd collapsible for 3.6.9
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		// Scroll to the top
		share2.scrollToTop(driver);
	}

	public void verify38(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(heading).as("test data").contains("Inadequate clarity");
		// text under description
		String textD = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]")))
				.getText();
		softly.assertThat(textD).as("test data").contains(
				"If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text")))
				.getText();
		softly.assertThat(desc).as("test data").contains(
				"Did a lack of clarity contribute to the occurrence of this error? Inadequate Clarity means there are vague terms that require judgment, technical terms without definition, description of a configuration without visual aids, or incorrect instructions. Examples include: Use of subjective terms is common in rules and procedures, Line organizations create vague requirements to avoid QA findings, Incorrect steps.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// 3.8.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(q341).as("test data").contains(
				"[3.8.1] Use of vague or interpretable words (such as appropriate, as required, necessary, etc.) due to inexperienced rule preparers");
		// 2nd collapsible for 3.8.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.8.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c2).as("test data").contains("Interview rule preparers");
		String c26 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c26).as("test data").contains("Review rule preparation guidelines");
		// Click on 2nd collapsible for 3.8.1
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.8.1 String c10 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c10).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.8.1 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c3 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c3).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for rule preparers"
		 * ); //Click on 3rd collapsible for 3.8.1
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.8.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(q342).as("test data").contains(
				"[3.8.2] Use of non-quantifiable or interpretable conditions (such as reviewing sufficient samples, etc.) to avoid internal QA findings");
		// 2nd collapsible for 3.8.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.8.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c5).as("test data").contains("Interview rule preparers");
		String c34 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c34).as("test data").contains("Review rule preparation guidelines");
		// Click on 2nd collapsible for 3.8.2
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.8.2 String c11 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c11).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.8.2 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c6 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c6).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for rule preparers"
		 * ); String c22 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c22).as("test data").
		 * contains("Holding responsible managers accountable for LOP clarity");
		 */
		// Click on 3rd collapsible for 3.8.2
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		// 3.8.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")))
				.getText();
		softly.assertThat(q343).as("test data").contains("[3.8.3] Requirement of judgment to execute procedure steps");
		// 2nd collapsible for 3.8.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.8.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c8).as("test data").contains("Interview rule preparers");
		String c36 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c36).as("test data").contains("Review rule preparation guidelines");
		// Click on 2nd collapsible for 3.8.3
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.8.3 String c12 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c12).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.8.3 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c9 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c9).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for rule preparers"
		 * ); //Click on 3rd collapsible for 3.8.3
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.8.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")))
				.getText();
		softly.assertThat(q344).as("test data")
				.contains("[3.8.4] Interfaces with other procedures not clearly defined");
		// 2nd collapsible for 3.8.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.8.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c14 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c14).as("test data").contains("Interview rule preparers");
		String c38 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c38).as("test data").contains("Review rule preparation guidelines");
		// Click on 2nd collapsible for 3.8.4
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.8.4 String c16 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c16).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.8.4 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c17 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c17).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for LOP interface design"
		 * ); //Click on 3rd collapsible for 3.8.4
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.8.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")))
				.getText();
		softly.assertThat(q345).as("test data")
				.contains("[3.8.5] Inadequate readability (i.e., greater than 8th grade reading level)");
		// 2nd collapsible for 3.8.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.8.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c19 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c19).as("test data").contains("Interview rule preparers");
		String c23 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c23).as("test data").contains("Review rule preparation guidelines");
		// Click on 2nd collapsible for 3.8.5
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.8.5 String c20 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c20).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.8.5 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c21 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c21).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for LOP interface design"
		 * ); //Click on 3rd collapsible for 3.8.5
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// Scroll to the end
		// share2.scrollToAPoint(driver, 1200);
		// 3.8.6 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)));
		String q396 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")))
				.getText();
		softly.assertThat(q396).as("test data").contains(
				"[3.8.6] Unclear and inconsistent equipment labeling and identification between equipment and procedure");
		// 2nd collapsible for 3.8.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c15).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.8.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c28 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c28).as("test data")
				.contains("Cross-check between procedure and equipment for clarity and consistency");
		// Click on 2nd collapsible for 3.8.6
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.8.6 String c30 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c30).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.8.6 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c31 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c31).as("test data").
		 * contains("Improve clarity and consistency of equipment labeling and identification between equipment and procedure"
		 * ); //Click on 3rd collapsible for 3.8.6
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.8.7 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)));
		String q367 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")))
				.getText();
		softly.assertThat(q367).as("test data").contains("[3.8.7] Time sensitive steps not called out");
		// 2nd collapsible for 3.8.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c41).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.8.7
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c42 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c42).as("test data").contains("Interview procedure preparer and reviewer");
		// Click on 2nd collapsible for 3.8.7
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.8.7 String c44 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c44).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.8.7 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c45 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c45).as("test data").contains("Update procedure"); //Click
		 * on 3rd collapsible for 3.8.7
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.8.8 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)));
		String q368 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']")))
				.getText();
		softly.assertThat(q368).as("test data").contains("[3.8.8] Measurement units are not clarified or quantified");
		// 2nd collapsible for 3.8.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c46).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.8.8
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c47 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c47).as("test data").contains("Interview procedure preparer and reviewer");
		// Click on 2nd collapsible for 3.8.8
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.8.8 String c49 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c49).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.8.8 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c50 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText();
		 * softly.assertThat(c50).as("test data").contains("Update procedure"); //Click
		 * on 3rd collapsible for 3.8.8
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click(); //Scroll to the top
		 */
		share2.scrollToTop(driver);
	}

	public void verify37(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(heading).as("test data").contains("Inadequate bypass control");
		// text under description
		String textD = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]")))
				.getText();
		softly.assertThat(textD).as("test data").contains(
				"If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text")))
				.getText();
		softly.assertThat(desc).as("test data").contains(
				"Were there missing placeholders, checks, or requirements that contributed to the occurrence of this error?");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// 3.7.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(q341).as("test data")
				.contains("[3.7.1] Inadequate guidance for out-of-program or out-of-procedure situations");
		// 2nd collapsible for 3.7.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.7.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c2).as("test data").contains("Interview rule preparers");
		String c26 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c26).as("test data").contains("Review rule preparation guidelines");
		// Click on 2nd collapsible for 3.7.1
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.7.1 String c10 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c10).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.7.1 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c3 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c3).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for bypass control"
		 * ); String c3a =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText();
		 * softly.assertThat(c3a).as("test data").contains(" of rule preparers");
		 */
		// Click on 3rd collapsible for 3.7.1
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		// 3.7.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(q342).as("test data").contains(
				"[3.7.2] Inadequate self-check or independent check of single-point-vulnerability (SPV) steps");
		// 2nd collapsible for 3.7.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.7.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c5).as("test data").contains("Interview rule preparers");
		String c34 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c34).as("test data").contains("Review rule preparation guidelines");
		// Click on 2nd collapsible for 3.7.2
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.7.2 String c11 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c11).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.7.2 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c6 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c6).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for bypass control"
		 * ); String c6a =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText();
		 * softly.assertThat(c6a).as("test data").contains(" of rule preparers");
		 * //Click on 3rd collapsible for 3.7.2
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.7.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")))
				.getText();
		softly.assertThat(q343).as("test data").contains(
				"[3.7.3] Point-of-no-return (PNR) steps not identified (to provide with review) to ensure past errors are corrected before proceeding");
		// 2nd collapsible for 3.7.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.7.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c8).as("test data").contains("Interview rule preparers");
		String c36 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c36).as("test data").contains("Review rule preparation guidelines");
		// Click on 2nd collapsible for 3.7.3
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.7.3 String c12 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c12).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.7.3 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c9 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c9).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for bypass control"
		 * ); String c9a =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText();
		 * softly.assertThat(c9a).as("test data").contains(" of rule preparers");
		 * //Click on 3rd collapsible for 3.7.3
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.7.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")))
				.getText();
		softly.assertThat(q344).as("test data")
				.contains("[3.7.4] Place holding \"checks\" not used to prevent skipping steps or pages");
		// 2nd collapsible for 3.7.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.7.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c14 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c14).as("test data").contains("Interview rule preparers");
		String c38 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c38).as("test data").contains("Review rule preparation guidelines");
		// Click on 2nd collapsible for 3.7.4
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.7.4 String c16 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c16).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.7.4 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c17 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c17).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for bypass control"
		 * ); String c17a =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText();
		 * softly.assertThat(c17a).as("test data").contains(" of rule preparers");
		 * //Click on 3rd collapsible for 3.7.4
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.7.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")))
				.getText();
		softly.assertThat(q345).as("test data").contains(
				"[3.7.5] Likely noncompliance situations not analyzed and mitigated (through symptom verification, over-check, not-to-do warnings, etc.)");
		// 2nd collapsible for 3.7.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.7.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c19 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c19).as("test data").contains("Interview rule preparers");
		String c22 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c22).as("test data").contains("Review rule preparation guidelines");
		// Click on 2nd collapsible for 3.7.5
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.7.5 String c20 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c20).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.7.5 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c21 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c21).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for bypass control"
		 * ); String c21a =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText();
		 * softly.assertThat(c21a).as("test data").contains(" of rule preparers");
		 * //Click on 3rd collapsible for 3.7.5
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click(); //Scroll to the end //share2.scrollToAPoint(driver, 1200);
		 */
		// 3.7.6 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)));
		String q396 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-5']")))
				.getText();
		softly.assertThat(q396).as("test data").contains(
				"[3.7.6] Lack of job-site reminders to prevent inattention-to-detail errors for routine work");
		// 2nd collapsible for 3.7.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c15).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.7.6
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c28 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c28).as("test data").contains("Interview rule preparers");
		String c40 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c40).as("test data").contains("Review rule preparation guidelines");
		// Click on 2nd collapsible for 3.7.6
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.7.6 String c30 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c30).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.7.6 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c31 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c31).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for bypass control"
		 * ); String c31a =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText();
		 * softly.assertThat(c31a).as("test data").contains(" of rule preparers");
		 * //Click on 3rd collapsible for 3.7.6
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.7.7 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)));
		String q367 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-6']")))
				.getText();
		softly.assertThat(q367).as("test data")
				.contains("[3.7.7] Lack of checklists to prevent forgetting-related errors");
		// 2nd collapsible for 3.7.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c41).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.7.7
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c42 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c42).as("test data").contains("Interview rule preparers");
		String c43 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c43).as("test data").contains("Review rule preparation guidelines");
		// Click on 2nd collapsible for 3.7.7
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.7.7 String c44 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c44).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.7.7 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c45 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c45).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for bypass control"
		 * ); String c45a =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText();
		 * softly.assertThat(c45a).as("test data").contains(" of rule preparers");
		 * //Click on 3rd collapsible for 3.7.7
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.7.8 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)));
		String q368 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-7']")))
				.getText();
		softly.assertThat(q368).as("test data").contains(
				"[3.7.8] Inadequate positive peer pressure amongst employees to encourage and reinforce compliant behavior standards");
		// 2nd collapsible for 3.7.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c46).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.7.8
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c47 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c47).as("test data").contains("Interview the error-maker");
		String c48 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c48).as("test data").contains("Interview co-workers");
		// Click on 2nd collapsible for 3.7.8
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.7.8 String c49 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c49).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.7.8 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c50 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c50).as("test data").
		 * contains("Training and coaching in holding peer accountable to comply to rules"
		 * ); String c23 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c23).as("test data").
		 * contains("Improving defective guidelines or rules in procedures"); //Click on
		 * 3rd collapsible for 3.7.8
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.7.9 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)));
		String q369 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-8']")))
				.getText();
		softly.assertThat(q369).as("test data").contains("[3.7.9] Inadequate review");
		// 2nd collapsible for 3.7.9
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c51).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.7.9
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c52 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c52).as("test data").contains("Interview reviewers");
		String c53 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c53).as("test data").contains("Investigate review guidelines");
		// Click on 2nd collapsible for 3.7.9
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.7.9 String c54 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c54).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.7.9 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c55 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c55).as("test data").
		 * contains("Establishing rule preparation standards or guidelines for bypass control"
		 * ); String c55a =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText();
		 * softly.assertThat(c55a).as("test data").contains(" of rule preparers");
		 * //Click on 3rd collapsible for 3.7.9
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.7.10 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10)));
		String q3691 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-9']")))
				.getText();
		softly.assertThat(q3691).as("test data").contains(
				"[3.7.10] Inadequate maintenance: (1) Inadequate predictive maintenance; (2) Inadequate preventive maintenance; (3) Inadequate corrective maintenance; (4) Inadequate post-maintenance testing; (5) Inadequate troubleshooting and RCA; and (6) Maintenance errors");
		// 2nd collapsible for 3.7.10
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c25).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.7.10
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c24 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c24).as("test data").contains("Benchmark maintenance practice with similar organizations");
		String c29 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c29).as("test data").contains("Determine quality of troubleshooting and RCA reports");
		String c32 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[3]")))
				.getText();
		softly.assertThat(c32).as("test data").contains("Examine common causes of repeat failures");
		// Click on 2nd collapsible for 3.7.10
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.7.10 String c35 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c35).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.7.10 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c37 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c37).as("test data").
		 * contains("Correcting deficiencies in maintenance programs"); //Click on 3rd
		 * collapsible for 3.7.10
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// Scroll to the top
		share2.scrollToTop(driver);
	}

	public void verify318(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(heading).as("test data").contains("Knowledge-based errors");
		// text under description
		String textD = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]")))
				.getText();
		softly.assertThat(textD).as("test data").contains(
				"If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text")))
				.getText();
		softly.assertThat(desc).as("test data").contains(
				"Is there evidence that any of the following mindsets contributed to the error-maker’s misjudgment in this error?");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// 3.18.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(q341).as("test data").contains("[3.18.1] Blind trust: Inadequate QV&V℠ critical information");
		// 2nd collapsible for 3.18.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.18.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c2).as("test data").contains("Review training materials?");
		String c22 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c22).as("test data").contains("Review past similar events?");
		// Click on 2nd collapsible for 3.18.1
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.18.1 String c10 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c10).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.18.1 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c3 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li")))
		 * .getText(); softly.assertThat(c3).as("test data").
		 * contains("Improvement of QV&V℠ training for engineer and decision makers");
		 * //Click on 3rd collapsible for 3.18.1
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.4.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(q342).as("test data").contains(
				"[3.18.2] Overconfidence: (1) Over-estimate of self-efficacy; (2) Not aware of changes of impact; (3) Not seeking wisdom; (4) Not learning from the past; (5) missing LOP to prevent error");
		// 2nd collapsible for 3.18.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.18.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c5).as("test data").contains("Perform first-time task without careful planning?");
		String c23 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c23).as("test data").contains("Any past events involving working beyond capabilities?");
		String c24 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]")))
				.getText();
		softly.assertThat(c24).as("test data").contains("Undue extrapolation of engineering work without due testing?");
		// Click on 2nd collapsible for 3.18.2
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.18.2 String c11 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c11).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.18.2 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c6 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li")))
		 * .getText(); softly.assertThat(c6).as("test data").
		 * contains("Error-Free® behavior training for over-confidence avoidance");
		 * //Click on 3rd collapsible for 3.18.2
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.18.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")))
				.getText();
		softly.assertThat(q343).as("test data").contains(
				"[3.18.3] Out of sight, out of mind (OOS/OOM): (1) Inadequate risk control of low probability/high risk events; (2) Ignoring issues not relating to performance indicators or incentives; (3) missing LOP due to overlooking associated risks");
		// 2nd collapsible for 3.18.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.18.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c8).as("test data").contains("Review risk control process involving the triggering events?");
		String c25 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c25).as("test data")
				.contains("Review management oversight or project committee meeting minutes?");
		// Click on 2nd collapsible for 3.18.3
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.18.3 String c12 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c12).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.18.3 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c9 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"
		 * ))).getText(); softly.assertThat(c9).as("test data").
		 * contains("Improvement of risk control program (FUSE"); String fuse_abbr =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]/abbr"
		 * ))).getAttribute("globtitle"); softly.assertThat(fuse_abbr).as("test data").
		 * isEqualTo("First Time Evolution, Unbalanced Interests, SPV, Expertise Deficiency"
		 * ); String c26 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"
		 * ))).getText(); softly.assertThat(c26).as("test data").
		 * contains("Improvement of performance monitoring & trending system"); //Click
		 * on 3rd collapsible for 3.18.3
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.18.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")))
				.getText();
		softly.assertThat(q344).as("test data").contains(
				"[3.18.4] Sunk-cost bias: (1) Defending past incorrect decisions or indecisions due to complacency and/or ignorance; (2) Expecting different results by repeating same problematic practices, standards, or strategies");
		// 2nd collapsible for 3.18.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.18.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c14 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c14).as("test data")
				.contains("Review management oversight or project committee meeting minutes?");
		// Click on 2nd collapsible for 3.18.4
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.18.4 String c16 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c16).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.18.4 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c17 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li")))
		 * .getText(); softly.assertThat(c17).as("test data").
		 * contains("Enhancing management oversight in reviewing effectiveness of past decisions"
		 * ); //Click on 3rd collapsible for 3.18.4
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.18.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")))
				.getText();
		softly.assertThat(q345).as("test data").contains(
				"[3.18.5] Two-option bias: Inadequate decision, problem solving, or planning to ensure multiple options are analyzed");
		// 2nd collapsible for 3.18.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.18.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c19 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c19).as("test data")
				.contains("Review management oversight or project committee meeting minutes?");
		// Click on 2nd collapsible for 3.18.5
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.18.5 String c20 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c20).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.18.5 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c21 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li")))
		 * .getText(); softly.assertThat(c21).as("test data").
		 * contains("Enhancing decision making, problem solving, and planning structure (committees) and process"
		 * ); //Click on 3rd collapsible for 3.18.5
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		share2.scrollToTop(driver);
	}

	public void verify34(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.PageQuestion)).getText();
		softly.assertThat(heading).as("test data").contains("Inadequate critical thinking and questioning");
		// text under description
		String textD = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]")))
				.getText();
		softly.assertThat(textD).as("test data").contains(
				"If not applicable, click \"skip\". User can also add new contributing factor at the end of the page.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text")))
				.getText();
		softly.assertThat(desc).as("test data").contains(
				"If time was taken to critically think or ask questions, could the error have been mitigated? Critical thinking refers to the introspection of how to make the day or task successful; including examination of mental states of the individual and others or examination of procedural problems. Critical questioning is probing about whether preparation is adequate for success; including clarifying anything unknown.");
		// Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a")))
				.click();
		// 3.4.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		softly.assertThat(q341).as("test data").contains(
				"[3.4.1] Not thinking about planning (such as prioritization, opportunities, communication, time management) before actions");
		// 2nd collapsible for 3.4.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c1).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.4.1
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c2).as("test data").contains("Interview error-maker");
		// Click on 2nd collapsible for 3.4.1
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.4.1 String c10 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c10).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.4.1 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c3 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li")))
		 * .getText(); softly.assertThat(c3).as("test data").
		 * contains("Training in critical thinking and questioning"); //Click on 3rd
		 * collapsible for 3.4.1
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.4.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(q342).as("test data")
				.contains("[3.4.2] Not thinking about error-prone mental states before actions");
		// 2nd collapsible for 3.4.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c4).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.4.2
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c5).as("test data").contains("Interview error maker");
		// Click on 2nd collapsible for 3.4.2
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.4.2 String c11 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c11).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.4.2 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c6 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li")))
		 * .getText(); softly.assertThat(c6).as("test data").
		 * contains("Training in critical thinking and questioning"); //Click on 3rd
		 * collapsible for 3.4.2
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.4.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']")))
				.getText();
		softly.assertThat(q343).as("test data")
				.contains("[3.4.3] Not thinking about high risk situations (such as SPVs) before actions");
		// 2nd collapsible for 3.4.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.4.3
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c8).as("test data").contains("Interview error maker");
		// Click on 2nd collapsible for 3.4.3
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.4.3 String c12 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c12).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.4.3 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c9 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li")))
		 * .getText(); softly.assertThat(c9).as("test data").
		 * contains("Training in critical thinking and questioning"); //Click on 3rd
		 * collapsible for 3.4.3
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.4.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-3']")))
				.getText();
		softly.assertThat(q344).as("test data").contains("[3.4.4] Inadequate questioning when confused");
		// 2nd collapsible for 3.4.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c13).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.4.4
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c14 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]")))
				.getText();
		softly.assertThat(c14).as("test data").contains("Interview error maker");
		String c15 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]")))
				.getText();
		softly.assertThat(c15).as("test data").contains("Interview supervisor");
		// Click on 2nd collapsible for 3.4.4
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.4.4 String c16 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c16).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.4.4 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c17 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li")))
		 * .getText(); softly.assertThat(c17).as("test data").
		 * contains("Training in critical thinking and questioning"); //Click on 3rd
		 * collapsible for 3.4.4
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		// 3.4.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-4']")))
				.getText();
		softly.assertThat(q345).as("test data").contains("[3.4.5] Inadequate questioning to prepare for tasks");
		// 2nd collapsible for 3.4.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c18).as("test data").contains("Further Investigation");
		// Click on 2nd collapsible for 3.4.5
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		// text inside
		String c19 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li")))
				.getText();
		softly.assertThat(c19).as("test data").contains("Interview error maker");
		// Click on 2nd collapsible for 3.4.5
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();

		/*
		 * am_not applicable //3rd collapsible 3.4.5 String c20 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * getText(); softly.assertThat(c20).as("test data").
		 * contains("Possible Corrective Action(s)"); //Click on 3rd collapsible for
		 * 3.4.5 executor.executeScript("arguments[0].click();",
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		 * //text inside String c21 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li")))
		 * .getText(); softly.assertThat(c21).as("test data").
		 * contains("Training in critical thinking and questioning"); //Click on 3rd
		 * collapsible for 3.4.5
		 * //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * ".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).
		 * click();
		 */
		share2.scrollToTop(driver);
	}

	public void pathHiRCA(WebDriver driver, String username) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		HiRCAHumanError2 obj2 = new HiRCAHumanError2();
		HiRCA2 obj3 = new HiRCA2();
		HiRCALevel1 obj4 = new HiRCALevel1();
		// List for storing answers to questions
		List<String> ans = new ArrayList<String>();
		// List for storing level 3 answers
		List<String> level3 = new ArrayList<String>();
		// Hashmaps for storing notes and answers
		MultiValuedMap<String, String> hircaNoteLopSURE = new ArrayListValuedHashMap<>();
		HashMap<String, String> hircaNoteLopStep4 = new HashMap<String, String>();
		// Waiting for loading message
		share2.loadingServer(driver);
		// Go to hirca and fill mandatory details on event info
		hlb2.fillUpHiRCAEventInfo(driver, obj4.text(driver));
		// Scroll up
		share2.scrollToTop(driver);
		// Verify text on 1.1
		stepOneq11(driver);
		// Enter reason entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.ReasonEntryField)).sendKeys(obj4.text(driver));
		// Select Human Error and click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).click();
		// Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
		// Verify text on 1.2
		stepOneq12(driver);
		// Select an answer in Q1.2
		String s = selectAnswer(driver, 3);
		String note = hfl123.getNoteShowingPreviousAnswer(driver);
		// Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
		ans.add(s);
///////////////////////////////////////////////////////////////////////////////////////////////
		// Rule-based/Skill-based/Knowledge-based
		if (s.contains("Rule-based")) {
			// Verify text in Q1.3
			stepOneq13(driver);
			// Select an answer in Q1.3
			String s1 = selectAnswer(driver, 3);
			String note1 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s1);
			if (s1.equals("Unintentional")) {
				// Verify text in Q1.4
				stepOneq14(driver);
				// Select an answer in Q1.4
				String s2 = selectAnswer(driver, 2);
				String note2 = hfl123.getNoteShowingPreviousAnswer(driver);
				// Click next
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
				ans.add(s2);
				if (s2.equals("Inattention to detail")) {
					// 3.16
					verify316(driver, softly);
					// Select answers
					List<String> lopOptions = selectAnswersLevel3(driver, 7);
					level3.addAll(lopOptions);
					// Join the list with the note for SURE
					hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note2, lopOptions));
					// Join the list with the note for Step4
					hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note2, lopOptions));
				}
				if (s2.equals("Inadequate rules")) {
					// 3.6
					verify36(driver, softly);
					// Select answers
					List<String> lopOptions = selectAnswersLevel3(driver, 9);
					// 3.7
					verify37(driver, softly);
					// Select answers
					lopOptions.addAll(selectAnswersLevel3(driver, 10));
					// 3.8
					verify38(driver, softly);
					// Select answers
					lopOptions.addAll(selectAnswersLevel3(driver, 8));
					// 3.18
					verify318(driver);
					// Select answers
					lopOptions.addAll(selectAnswersLevel3(driver, 5));
					level3.addAll(lopOptions);
					// Join the list with the note for SURE
					hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note2, lopOptions));
					// Join the list with the note for Step4
					hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note2, lopOptions));
				}
			}
			if (s1.equals("Intentional")) {
				// 3.12
				verify312(driver, softly);
				// Select answers
				List<String> lopOptions = selectAnswersLevel3(driver, 5);
				// 3.13
				verify313(driver, softly);
				// Select answers
				lopOptions.addAll(selectAnswersLevel3(driver, 4));
				// 3.14
				verify314(driver, softly);
				// Select answers
				lopOptions.addAll(selectAnswersLevel3(driver, 5));
				// 3.15
				verify315(driver, softly);
				// Select answers
				lopOptions.addAll(selectAnswersLevel3(driver, 4));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note1, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note1, lopOptions));
			}
			// Verify text in Q1.5
			stepOneq15(driver);
			// Select an answer in Q1.5
			String s2 = selectAnswer(driver, 2);
			String note2 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s2);
			if (s2.equals("No")) {
				// 3.1
				obj2.verify31(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 6);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note2, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note2, lopOptions));
			}
			if (s2.equals("Yes")) {
				// 3.11
				obj2.verify311(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 5);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note2, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note2, lopOptions));
			}
			// Verify text in Q1.6
			obj2.stepOneq16(driver, softly);
			// Select an answer in Q1.6
			String s16 = selectAnswer(driver, 3);
			String note4 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s16);
			if (s16.equals("Yes")) {
				// 3.15
				verify315(driver, softly);
				// Select answers
				List<String> lopOptions = selectAnswersLevel3(driver, 4);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note4, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note4, lopOptions));
			}
//Verify text in Q1.7
			obj2.stepOneq17(driver, softly);
//Select an answer in Q1.7
			String s3 = selectAnswer(driver, 3);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s3);
//Verify text in Q1.8
			obj2.stepOneq18(driver, softly);
//Select an answer in Q1.8
			String s4 = selectAnswer(driver, 3);
			String note5 = hfl123.getNoteShowingPreviousAnswer(driver);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s4);
			if (s4.equals("No")) {
				// 3.9
				obj2.verify39(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 6);
				// 3.10
				obj2.verify310(driver, softly);
				lopOptions.addAll(selectAnswersLevel3(driver, 5));
				// 3.11
				obj2.verify311(driver, softly);
				lopOptions.addAll(selectAnswersLevel3(driver, 5));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note5, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note5, lopOptions));
			}
			if (s4.equals("Yes, but more than 2 years ago")) {
				// 3.9
				obj2.verify39(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 6);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note5, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note5, lopOptions));
			}
//Verify text in Q1.9
			obj2.stepOneq19(driver, softly);
//Select an answer in Q1.9
			String s5 = selectAnswer(driver, 3);
			String note6 = hfl123.getNoteShowingPreviousAnswer(driver);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s5);
			if (s5.equals("No, not at all")) {
				// 3.2
				obj2.verify32(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 6);
				// 3.11
				obj2.verify311(driver, softly);
				lopOptions.addAll(selectAnswersLevel3(driver, 5));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note6, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note6, lopOptions));
			}
//Verify text in Q1.10
			obj2.stepOneq110(driver, softly);
//Select an answer in Q1.10
			String s6 = selectAnswer(driver, 2);
			String note7 = hfl123.getNoteShowingPreviousAnswer(driver);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s6);
			if (s6.equals("The risks were not discussed due to lack of knowledge")) {
				// 3.21
				obj2.verify321(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 4);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note7, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note7, lopOptions));
			}
//Verify text in Q1.11
			obj2.stepOneq111(driver, softly);
//Select an answer in Q1.11
			String s7 = selectAnswer(driver, 3);
			String note8 = hfl123.getNoteShowingPreviousAnswer(driver);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s7);
			if (s7.equals("Due to new procedures without adequate training")) {
				// 3.9
				obj2.verify39(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 6);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note8, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note8, lopOptions));
			}
			if (s7.equals("Due to new or infrequent task(s) for the error-maker")) {
				// 3.5
				obj2.verify35(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 4);
				// 3.9
				obj2.verify39(driver, softly);
				lopOptions.addAll(selectAnswersLevel3(driver, 6));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note8, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note8, lopOptions));
			}
//Verify text in Q1.12
			obj2.stepOneq112(driver, softly);
//Select an answer in Q1.12
			String s8 = selectAnswer(driver, 3);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s8);
//Verify text in Q1.13
			obj2.stepOneq113(driver, softly);
//Select an answer in Q1.13
			String s9 = selectAnswer(driver, 2);
			String note9 = hfl123.getNoteShowingPreviousAnswer(driver);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s9);
			if (s9.equals("Yes")) {
				// 3.3
				obj2.verify33(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 10);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note9, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note9, lopOptions));
			}
//Verify text in Q1.14
			obj2.stepOneq114(driver, softly);
//Select an answer in Q1.14
			String s10 = selectAnswer(driver, 3);
			String note10 = hfl123.getNoteShowingPreviousAnswer(driver);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s10);
			if (s10.equals("No, most of his peers conduct routine meetings")) {
				// 3.2
				obj2.verify32(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 6);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note10, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note10, lopOptions));
			}
			if (s10.equals("No, but it is common among his peers not to conduct routine meetings")) {
				// 3.3
				obj2.verify33(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 10);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note10, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note10, lopOptions));
			}
//Verify text in Q1.15
			obj2.stepOneq115(driver, softly);
//Select an answer in Q1.15
			String s11 = selectAnswer(driver, 3);
			String note11 = hfl123.getNoteShowingPreviousAnswer(driver);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s11);
			if (s11.equals("Yes, but not identified ahead of time")) {
				// 3.6
				verify36(driver, softly);
				// Select answers
				List<String> lopOptions = selectAnswersLevel3(driver, 9);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note11, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note11, lopOptions));
			}
			if (s11.equals("Yes, identified but without mitigation actions")) {
				// 3.16
				verify316(driver, softly);
				// Select answers
				List<String> lopOptions = selectAnswersLevel3(driver, 7);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note11, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note11, lopOptions));
			}
//Verify text in Q1.16
			obj2.stepOneq116(driver, softly);
//Select an answer in Q1.16
			String s12 = selectAnswer(driver, 3);
			String note12 = hfl123.getNoteShowingPreviousAnswer(driver);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s12);
			if (s12.equals("Yes, as compared to other supervisory groups with similar functions")) {
				// 3.2
				obj2.verify32(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 6);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note12, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note12, lopOptions));
			}
//Verify text in Q1.17
			obj2.stepOneq117(driver, softly);
//Select an answer in Q1.17
			String s13 = selectAnswer(driver, 3);
			String note13 = hfl123.getNoteShowingPreviousAnswer(driver);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s13);
			if (s13.equals("Yes, as compared to other groups with similar functions")) {
				// 3.3
				obj2.verify33(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 10);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note13, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note13, lopOptions));
			}
//Verify text in Q1.18
			obj2.stepOneq118(driver, softly);
//Select an answer in Q1.18
			String s14 = selectAnswer(driver, 2);
			String note14 = hfl123.getNoteShowingPreviousAnswer(driver);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s14);
			if (s14.equals("Yes")) {
				// 3.22
				obj2.verify322(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 5);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note14, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note14, lopOptions));
			}
//Verify text in Q1.19
			obj2.stepOneq119(driver, softly);
//Select an answer in Q1.19
			String s15 = selectAnswer(driver, 3);
			String note15 = hfl123.getNoteShowingPreviousAnswer(driver);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s15);
			if (s15.equals("Yes")) {
				// 3.3
				obj2.verify33(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 10);
				// 3.5
				obj2.verify35(driver, softly);
				lopOptions.addAll(selectAnswersLevel3(driver, 4));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note15, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note15, lopOptions));
			}
//Verify text in Q1.20
			obj2.stepOneq120(driver, softly);
//Select an answer in Q1.20
			String s120 = selectAnswer(driver, 3);
			String note16 = hfl123.getNoteShowingPreviousAnswer(driver);
//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s120);
			if (s120.equals("Yes")) {
				// 3.5
				obj2.verify35(driver, softly);
				List<String> lopOptions = selectAnswersLevel3(driver, 4);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note16, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note16, lopOptions));
			}
		}

		if (ans.get(0).equals("Knowledge-based")) {
			// 3.4
			verify34(driver);
			// Select answers
			List<String> lopOptions = selectAnswersLevel3(driver, 5);
			level3.addAll(lopOptions);
			// Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, lopOptions));
			// Join the list with the note for Step4
			hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note, lopOptions));
			// Verify text in Q1.21
			obj2.stepOneq121(driver, softly);
			// Select an answer in Q1.21
			String s22 = selectAnswer(driver, 2);
			String note22 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click Next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s22);
			if (s22.equals("Decision error")) {
				// 3.18
				verify318(driver);
				// Select answers
				lopOptions.addAll(selectAnswersLevel3(driver, 5));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note22, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note22, lopOptions));
			}
			if (s22.equals("Indecision error")) {
				obj2.verify323(driver, softly);
				// Select answers
				lopOptions.addAll(selectAnswersLevel3(driver, 4));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note22, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note22, lopOptions));
			}
			// Verify text in Q1.22
			obj2.stepOneq122(driver, softly);
			// Select an answer in Q1.22
			String s3 = selectAnswer(driver, 2);
			String note3 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click Next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s3);
			if (s3.equals("Yes")) {
				// Verify3.6
				verify36(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 9);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note3, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note3, lopOptions));
			}
			// Verify text in Q1.23
			obj2.stepOneq123(driver, softly);
			// Select an answer in Q1.23
			String s123 = selectAnswer(driver, 3);
			String note123 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click Next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s123);
			if (s123.equals("Yes, it was ineffective")) {
				obj2.verify324(driver, softly);
				// Select answers
				lopOptions.addAll(selectAnswersLevel3(driver, 5));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note123, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note123, lopOptions));
			}
			// Verify text in Q1.24
			obj2.stepOneq124(driver, softly);
			// Select an answer in Q1.23
			String s124 = selectAnswer(driver, 3);
			String note124 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click Next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s124);
			if (s124.equals("Yes, needed information was not collected")) {
				obj2.verify326(driver, softly);
				// Select answers
				lopOptions.addAll(selectAnswersLevel3(driver, 6));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note124, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note124, lopOptions));
			}
			if (s124.equals("Yes, information was mis-used in decision-making")) {
				obj2.verify327(driver, softly);
				// Select answers
				lopOptions.addAll(selectAnswersLevel3(driver, 5));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note124, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note124, lopOptions));
			}
			// Verify text in Q1.25
			obj2.stepOneq125(driver, softly);
			// Select an answer in Q1.25
			String s125 = selectAnswer(driver, 3);
			String note125 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click Next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s125);
			if (s125.equals("Yes, due to lack of prediction analysis")) {
				obj2.verify328(driver, softly);
				// Select answers
				lopOptions.addAll(selectAnswersLevel3(driver, 3));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note125, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note125, lopOptions));
			}
			if (s125.equals("Yes, due to invalid prediction analysis")) {
				obj2.verify329(driver, softly);
				// Select answers
				lopOptions.addAll(selectAnswersLevel3(driver, 5));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note125, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note125, lopOptions));
			}
			// Verify text in Q1.26
			obj2.stepOneq126(driver, softly);
			// Select an answer in Q1.26
			String s126 = selectAnswer(driver, 3);
			String note126 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click Next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s126);
			if (s126.equals("Yes, the right choice was omitted for consideration")) {
				obj2.verify330(driver, softly);
				// Select answers
				lopOptions.addAll(selectAnswersLevel3(driver, 7));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note126, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note126, lopOptions));
			}
			if (s126.equals("Yes, the right choice was not selected")) {
				obj2.verify331(driver, softly);
				// Select answers
				lopOptions.addAll(selectAnswersLevel3(driver, 6));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note126, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note126, lopOptions));
			}
		}

		if (ans.get(0).equals("Skill-based")) {
			// 3.16
			verify316(driver, softly);
			// Select answers
			List<String> lopOptions = selectAnswersLevel3(driver, 7);
			level3.addAll(lopOptions);
			// Join the list with the note for SURE
			hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note, lopOptions));
			// Join the list with the note for Step4
			hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note, lopOptions));
			// Verify text in Q1.5
			stepOneq15(driver);
			// Sel ect an answer in Q1.5
			String s2 = selectAnswer(driver, 2);
			String note2 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s2);
			if (s2.equals("No")) {
				// 3.1
				obj2.verify31(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 6);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note2, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note2, lopOptions));
			}
			if (s2.equals("Yes")) {
				// 3.11
				obj2.verify311(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 5);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note2, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note2, lopOptions));
			}
			// Verify text in Q1.6
			obj2.stepOneq16(driver, softly);
			// Select an answer in Q1.6
			String s16 = selectAnswer(driver, 3);
			String note4 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s16);
			if (s16.equals("Yes")) {
				// 3.15
				verify315(driver, softly);
				// Select answers
				lopOptions = selectAnswersLevel3(driver, 4);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note4, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note4, lopOptions));
			}
			// Verify text in Q1.7
			obj2.stepOneq17(driver, softly);
			// Select an answer in Q1.7
			String s3 = selectAnswer(driver, 3);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s3);
			// Verify text in Q1.8
			obj2.stepOneq18(driver, softly);
			// Select an answer in Q1.8
			String s4 = selectAnswer(driver, 3);
			String note5 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s4);
			if (s4.equals("No")) {
				// 3.9
				obj2.verify39(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 6);
				// 3.10
				obj2.verify310(driver, softly);
				lopOptions.addAll(selectAnswersLevel3(driver, 5));
				// 3.11
				obj2.verify311(driver, softly);
				lopOptions.addAll(selectAnswersLevel3(driver, 5));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note5, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note5, lopOptions));
			}
			if (s4.equals("Yes, but more than 2 years ago")) {
				// 3.9
				obj2.verify39(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 6);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note5, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note5, lopOptions));
			}
			// Verify text in Q1.9
			obj2.stepOneq19(driver, softly);
			// Select an answer in Q1.9
			String s5 = selectAnswer(driver, 3);
			String note6 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s5);
			if (s5.equals("No, not at all")) {
				// 3.2
				obj2.verify32(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 6);
				// 3.11
				obj2.verify311(driver, softly);
				lopOptions.addAll(selectAnswersLevel3(driver, 5));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note6, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note6, lopOptions));
			}
			// Verify text in Q1.10
			obj2.stepOneq110(driver, softly);
			// Select an answer in Q1.10
			String s6 = selectAnswer(driver, 2);
			String note7 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s6);
			if (s6.equals("The risks were not discussed due to lack of knowledge")) {
				// 3.21
				obj2.verify321(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 4);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note7, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note7, lopOptions));
			}
			// Verify text in Q1.11
			obj2.stepOneq111(driver, softly);
			// Select an answer in Q1.11
			String s7 = selectAnswer(driver, 3);
			String note8 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s7);
			if (s7.equals("Due to new procedures without adequate training")) {
				// 3.9
				obj2.verify39(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 6);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note8, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note8, lopOptions));
			}
			if (s7.equals("Due to new or infrequent task(s) for the error-maker")) {
				// 3.5
				obj2.verify35(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 4);
				// 3.9
				obj2.verify39(driver, softly);
				lopOptions.addAll(selectAnswersLevel3(driver, 6));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note8, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note8, lopOptions));
			}
			// Verify text in Q1.12
			obj2.stepOneq112(driver, softly);
			// Select an answer in Q1.12
			String s8 = selectAnswer(driver, 3);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s8);
			// Verify text in Q1.13
			obj2.stepOneq113(driver, softly);
			// Select an answer in Q1.13
			String s9 = selectAnswer(driver, 2);
			String note9 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s9);
			if (s9.equals("Yes")) {
				// 3.3
				obj2.verify33(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 10);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note9, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note9, lopOptions));
			}
			// Verify text in Q1.14
			obj2.stepOneq114(driver, softly);
			// Select an answer in Q1.14
			String s10 = selectAnswer(driver, 3);
			String note10 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s10);
			if (s10.equals("No, most of his peers conduct routine meetings")) {
				// 3.2
				obj2.verify32(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 6);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note10, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note10, lopOptions));
			}
			if (s10.equals("No, but it is common among his peers not to conduct routine meetings")) {
				// 3.3
				obj2.verify33(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 10);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note10, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note10, lopOptions));
			}
			// Verify text in Q1.15
			obj2.stepOneq115(driver, softly);
			// Select an answer in Q1.15
			String s11 = selectAnswer(driver, 3);
			String note11 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s11);
			if (s11.equals("Yes, but not identified ahead of time")) {
				// 3.6
				verify36(driver, softly);
				// Select answers
				lopOptions = selectAnswersLevel3(driver, 9);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note11, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note11, lopOptions));
			}
			if (s11.equals("Yes, identified but without mitigation actions")) {
				// 3.16
				verify316(driver, softly);
				// Select answers
				lopOptions = selectAnswersLevel3(driver, 7);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note11, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note11, lopOptions));
			}
			// Verify text in Q1.16
			obj2.stepOneq116(driver, softly);
			// Select an answer in Q1.16
			String s12 = selectAnswer(driver, 3);
			String note12 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s12);
			if (s12.equals("Yes, as compared to other supervisory groups with similar functions")) {
				// 3.2
				obj2.verify32(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 6);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note12, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note12, lopOptions));
			}
			// Verify text in Q1.17
			obj2.stepOneq117(driver, softly);
			// Select an answer in Q1.17
			String s13 = selectAnswer(driver, 3);
			String note13 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s13);
			if (s13.equals("Yes, as compared to other groups with similar functions")) {
				// 3.3
				obj2.verify33(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 10);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note13, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note13, lopOptions));
			}
			// Verify text in Q1.18
			obj2.stepOneq118(driver, softly);
			// Select an answer in Q1.18
			String s14 = selectAnswer(driver, 2);
			String note14 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s14);
			if (s14.equals("Yes")) {
				// 3.22
				obj2.verify322(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 5);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note14, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note14, lopOptions));
			}
			// Verify text in Q1.19
			obj2.stepOneq119(driver, softly);
			// Select an answer in Q1.19
			String s15 = selectAnswer(driver, 3);
			String note15 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s15);
			if (s15.equals("Yes")) {
				// 3.3
				obj2.verify33(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 10);
				// 3.5
				obj2.verify35(driver, softly);
				lopOptions.addAll(selectAnswersLevel3(driver, 4));
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note15, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note15, lopOptions));
			}
			// Verify text in Q1.20
			obj2.stepOneq120(driver, softly);
			// Select an answer in Q1.20
			String s120 = selectAnswer(driver, 3);
			String note16 = hfl123.getNoteShowingPreviousAnswer(driver);
			// Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.NextButton)).click();
			ans.add(s120);
			if (s120.equals("Yes")) {
				// 3.5
				obj2.verify35(driver, softly);
				lopOptions = selectAnswersLevel3(driver, 4);
				level3.addAll(lopOptions);
				// Join the list with the note for SURE
				hircaNoteLopSURE.putAll(hfl123.joinNoteWithAnswerForSURE(driver, note16, lopOptions));
				// Join the list with the note for Step4
				hircaNoteLopStep4.putAll(hfl123.joinNoteWithAnswerWithSemicolon(driver, note16, lopOptions));
			}
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Verify LOP/RC popup
		obj3.verifyLOPRCPopup(driver, softly);
		// Click on Root cause
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton2)));
		// Verify selections made in Step 3/4/5 and report
		obj2.verifySelections(driver, level3, softly, username, obj4.text(driver), hircaNoteLopSURE, hircaNoteLopStep4);
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
