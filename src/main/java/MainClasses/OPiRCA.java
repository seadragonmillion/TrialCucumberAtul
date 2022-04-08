import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import kaleTestSoftware.*;
import kaleTestSoftware.ErrorMeter3;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OPiRCA {

	SoftAssertions softly = new SoftAssertions();

	OPiRCAChinese opc = new OPiRCAChinese();
	OPiRCA2 op2 = new OPiRCA2();
	OPiRCA3 op3 = new OPiRCA3();
	ShareCheck share = new ShareCheck();
	ShareCheck3 share3 = new ShareCheck3();
	EiRCA2 eirca2 = new EiRCA2();
	EiRCAPageObj eirca = new EiRCAPageObj();
	OPiRCAPageObj opirca = new OPiRCAPageObj();
	TextBoxResizing tbr = new TextBoxResizing();
	ShareCheck2 share2 = new ShareCheck2();
	ErrorMeter3 em3 = new ErrorMeter3();
	public String text = "Enter some text <title>here";

	public void deleteNewRecord(WebDriver driver, String recordName, int y) throws Exception {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		OPiRCA2 obj2 = new OPiRCA2();
		// Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).click();
		share2.loadingServer(driver);
		// Clicks on delete button
		driver.findElement(opirca.DeleteButton).click();
		// Verify delete popup
		obj2.verifyDeleteReportPopup(driver, softly, recordName);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle));
		// Clicks on delete report
		jse.executeScript("return document.getElementById('pii-user-home-dialog-confirmed').click();");
		obj2.verifyStickyDeleteReport(driver, softly, recordName);
		Thread.sleep(2000);
		jse.executeScript("return document.getElementById('pii-user-home-panel-btn-opa').click();");
		// Verify record deleted
		// Click on 1st record
		String name = driver.findElement(opirca.OPiRCAFirstRecord).getText().trim();
		System.out.println(name);
		String r = recordName.replaceAll("\u00AD", "");
		if (name != r)
			System.out.println("Record deleted");
		else
			System.out.println("Record could not be deleted");
		// Verify report not retrieved by shared to person
		String sharer = em3.decideSharer(y);
		share.checkNoReportAfterDelete(driver, sharer, softly);
	}

	public void bugForReportTab(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(500);
		// Click on Info Tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoTab)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.PageTitle));
		Thread.sleep(500);
		// Click on Report Tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTab)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFinalizeButton));
		Thread.sleep(500);
		// Choose a random number between 0 to 4
		Random random = new Random();
		int n = random.nextInt(5);
		share2.scrollToTop(driver);
		if (n == 0) {
			// Click on Step 1
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep1Tab)).click();
			Thread.sleep(500);
			// Verify Step 1 title
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageTitle)).getText()
					.trim();
			softly.assertThat(s).as("test data").contains("Step 1");
		}
		if (n == 1) {
			// Click on Step 2
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep2Tab)).click();
			Thread.sleep(500);
			// Verify Step 2 title
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageTitle)).getText()
					.trim();
			softly.assertThat(s).as("test data").contains("Step 2");
		}
		if (n == 2) {
			// Click on Step 3
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep3Tab)).click();
			Thread.sleep(500);
			// Verify Step 3 title
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.PageTitle)).getText().trim();
			softly.assertThat(s).as("test data").contains("Step 3");
		}
		if (n == 3) {
			// Click on Step 4
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep4Tab)).click();
			Thread.sleep(500);
			// Verify Step 4 title
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.PageTitle)).getText().trim();
			softly.assertThat(s).as("test data").contains("Step 4");
		}
		if (n == 4) {
			// Click on Step 5
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep5Tab)).click();
			Thread.sleep(500);
			// Verify Step 5 title
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.PageTitle)).getText().trim();
			softly.assertThat(s).as("test data").contains("Step 5");
		}
	}

	public void openReport(WebDriver driver, String recordName) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		// Clicks on Open button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OpenButton)).click();
		// Verify open report pop up
		op2.verifyOpenReportPopup(driver, softly, recordName);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		// Clicks on open report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		// Verify no bug when clicking on info tab and report tab and other tabs
		bugForReportTab(driver);
		// Clicks on Save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveButton)).click();
		// Save pop verify
		op2.verifySavePopup(driver, softly);
		// Clicks on Save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavePopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveConfirmButton)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.StickySuccess));
		// Wait for loading message
		share2.loadingServer(driver);
		Thread.sleep(1000);
		// Clicks on Saved activities
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavedActivitiesButton)).click();
		Thread.sleep(2000);
		// Wait for loading message
		share2.loadingServer(driver);
	}

	public void downloadRecordChrome(WebDriver driver, List<String> hircaNewList, List<String> apparentCausesNew,
			List<String> apparentCausesAnswersNew, HashMap<String, String> hml, HashMap<String, Integer> options,
			List<String> step2) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		// Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).click();
		// Wait for loading message
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		// Clicks on download button
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.DownloadButton)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.DownloadButton)));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.DownloadButton)).click();
		// Verify pdf pop up
		eirca2.verifyStickyCreatePDF(driver, softly);
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		// Verify download pop up
		eirca2.verifyDownloadReportPopup(driver, softly);
		// Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(8000);
		System.out.println("Print before pdfCheck before downloadReportChrome");
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/ChromSavePDF5_amlocal.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){
			System.out.println("Unexpected alert for download");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert for download");
		}
//		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\ChromSavePDF5_amlocal.exe");
		pdfCheck(hircaNewList, apparentCausesNew, apparentCausesAnswersNew, hml, options, step2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);
	}

	public void downloadRecordFirefox(WebDriver driver, List<String> hircaNewList, List<String> apparentCausesNew,
			List<String> apparentCausesAnswersNew, HashMap<String, String> hml, HashMap<String, Integer> options,
			List<String> step2) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		// Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).click();
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		// Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.DownloadButton)).click();
		// Verify pdf pop up
		eirca2.verifyStickyCreatePDF(driver, softly);
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		// Verify download pop up
		eirca2.verifyDownloadReportPopup(driver, softly);
		// Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(8000);
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println(winHandle);
			if (winHandle.isEmpty() == false) {
				if (winHandle.equals(window) == false)
					driver.switchTo().window(winHandle);
			}
		}
		Thread.sleep(2000);/*
							 * //wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(
							 * "viewerContainer"))).sendKeys(Keys.chord(Keys.CONTROL + "s")); Robot robot =
							 * new Robot(); // press Ctrl+S the Robot's way
							 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_S);
							 * robot.keyRelease(KeyEvent.VK_CONTROL); robot.keyRelease(KeyEvent.VK_S);
							 * Process p= Runtime.getRuntime().exec(
							 * "C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe"); p.waitFor();
							 */
		pdfCheck(hircaNewList, apparentCausesNew, apparentCausesAnswersNew, hml, options, step2);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();
	}

	public void downloadRecordIE10(WebDriver driver, List<String> hircaNewList, List<String> apparentCausesNew,
			List<String> apparentCausesAnswersNew, HashMap<String, String> hml, HashMap<String, Integer> options,
			List<String> step2) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		// Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).click();
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		// Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.DownloadButton)).click();
		// Verify pdf pop up
		eirca2.verifyStickyCreatePDF(driver, softly);
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		// Verify download pop up
		eirca2.verifyDownloadReportPopup(driver, softly);
		// Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
			q.waitFor();
		} catch (UnhandledAlertException f) {
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		} catch (NoAlertPresentException f) {
			System.out.println("No unexpected alert");
		}
		Thread.sleep(7000);
		// pdf verification
		pdfCheck(hircaNewList, apparentCausesNew, apparentCausesAnswersNew, hml, options, step2);
		Thread.sleep(4000);
		// Switch to window
		driver.switchTo().window(window);
	}

	public void downloadRecordIE11(WebDriver driver, List<String> hircaNewList, List<String> apparentCausesNew,
			List<String> apparentCausesAnswersNew, HashMap<String, String> hml, HashMap<String, Integer> options,
			List<String> step2) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		// Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).click();
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		// Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.DownloadButton)).click();
		// Verify pdf pop up
		eirca2.verifyStickyCreatePDF(driver, softly);
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		// Verify download pop up
		eirca2.verifyDownloadReportPopup(driver, softly);
		// Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
			q.waitFor();
		} catch (UnhandledAlertException f) {
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		} catch (NoAlertPresentException f) {
			System.out.println("No unexpected alert");
		}
		Thread.sleep(7000);
		// pdf verification
		pdfCheck(hircaNewList, apparentCausesNew, apparentCausesAnswersNew, hml, options, step2);
		Thread.sleep(4000);
		// Switch to window
		driver.switchTo().window(window);
	}

	public void pdfCheck(List<String> hircaNewList, List<String> apparentCausesNew,
			List<String> apparentCausesAnswersNew, HashMap<String, String> hml, HashMap<String, Integer> options,
			List<String> step2) throws Exception {

		// specify your directory
		Path dir = Paths.get("C://Users//mama//Downloads//EFTestDownloadReports//");
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f))
				.max(Comparator.comparingLong(f -> f.toFile().lastModified()));
		try {
			System.out.println(lastFilePath.get());
		} catch (java.util.NoSuchElementException t) {

		}
		// Loads the file to check if correct data is present
		String fileName = lastFilePath.get().toString();
		File oldfile = new File(fileName);
		PDDocument pddoc = PDDocument.load(oldfile);
		// Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans = Arrays.asList(data.split("\r\n"));
		String newData1 = "";
		for (int i = 0; i < ans.size(); i++) {
			int n = ans.get(i).length() - 1;
			if (ans.get(i).charAt(n) == ' ')
				newData1 = newData1 + ans.get(i);
			else if (ans.get(i).charAt(n) != ' ')
				newData1 = newData1 + " " + ans.get(i);
		}
		newData1 = newData1.replace("  ", " ");
		newData1 = newData1.replace("/ ", "/");
		newData1 = newData1.replace("- ", "-");
		newData1 = newData1.replace("QTM -equipment qualification, testing and maintenance",
				"QTM - equipment qualification, testing and maintenance");
		System.out.println(newData1);
		// Verify all lists present in pdf
		for (int i = 0; i < hircaNewList.size(); i++) {
			// Add :
			int m = hircaNewList.get(i).indexOf(" ");
			if (Character.isDigit(hircaNewList.get(i).charAt(m - 1)) == true) {
				String s = hircaNewList.get(i).substring(0, m) + ": "
						+ hircaNewList.get(i).substring(m + 1, hircaNewList.get(i).length());
				softly.assertThat(newData1).as("test data").contains(s);
			}
		}
		for (int i = 0; i < apparentCausesNew.size(); i++) {
			softly.assertThat(newData1).as("test data").contains(apparentCausesNew.get(i));
		}
		for (int i = 0; i < apparentCausesAnswersNew.size(); i++) {
			softly.assertThat(newData1).as("test data").contains(apparentCausesAnswersNew.get(i));
		}
		for (int i = 0; i < step2.size(); i++) {
			softly.assertThat(newData1).as("test data").contains(step2.get(i));
		}
		// Check HML order for root cause
		checkOrderHMLRC(hml, options, newData1);
		// Check HML order for contributing factor
		int n = apparentCausesAnswersNew.size();
		int cf = n - options.get("Root causes");
		checkOrderHMLCF(hml, options, newData1, cf);
		// Close pdf
		pddoc.close();
	}

	public void checkOrderHMLCF(HashMap<String, String> hml, HashMap<String, Integer> options, String newData1,
			int cf) {

		if (cf > 0) {
			List<Integer> high = new ArrayList<Integer>();
			List<Integer> medium = new ArrayList<Integer>();
			List<Integer> low = new ArrayList<Integer>();
			List<Integer> none = new ArrayList<Integer>();
			for (Map.Entry<String, Integer> e : options.entrySet()) {
				// If it has 4 ticks in SURE then its a RC
				if (e.getValue() != 4) {
					String s2 = e.getKey();
					// Remove first : from options answer
					int m = s2.indexOf(":");
					if (m == -1)
						continue;
					String s = s2.substring(0, m) + s2.substring(m + 1, s2.length());
					if (hml.get(s) == "High") {
						if (newData1.indexOf(s + " High") > -1)
							high.add(newData1.indexOf(s + " High"));
						if (newData1.indexOf(s + "\n" + "High") > -1)
							high.add(newData1.indexOf(s + "\n" + "High"));
					}
					if (hml.get(s) == "Medium") {
						if (newData1.indexOf(s + " Medium") > -1)
							high.add(newData1.indexOf(s + " Medium"));
						if (newData1.indexOf(s + "\n" + "Medium") > -1)
							high.add(newData1.indexOf(s + "\n" + "Medium"));
					}
					if (hml.get(s) == "Low") {
						if (newData1.indexOf(s + " Low") > -1)
							high.add(newData1.indexOf(s + " Low"));
						if (newData1.indexOf(s + "\n" + "Low") > -1)
							high.add(newData1.indexOf(s + "\n" + "Low"));
					}
					if (hml.get(s) == "") {
						none.add(newData1.indexOf(s));
					}
				}
			}
			// Sort the lists
			Collections.sort(high);
			Collections.sort(medium);
			Collections.sort(low);
			Collections.sort(none);/*
									 * System.out.println(high); System.out.println(medium);
									 * System.out.println(low); System.out.println(none);
									 */
			// Verify the importance order
			if (medium.size() > 0 && high.size() > 0) {
				if (high.get(high.size() - 1) > medium.get(0))
					softly.fail("Medium cf are before High cf");
			}

			if (low.size() > 0 && medium.size() > 0) {
				if (medium.get(medium.size() - 1) > low.get(0))
					softly.fail("Low cf are before Medium cf");
			}
			if (none.size() > 0 && low.size() > 0) {
				if (low.get(low.size() - 1) > none.get(0))
					softly.fail("None cf are before Low cf");
			}
		}
	}

	public void checkOrderHMLRC(HashMap<String, String> hml, HashMap<String, Integer> options, String newData1) {

		if (options.get("Root causes") > 0) {
			List<Integer> high = new ArrayList<Integer>();
			List<Integer> medium = new ArrayList<Integer>();
			List<Integer> low = new ArrayList<Integer>();
			List<Integer> none = new ArrayList<Integer>();
			for (Map.Entry<String, Integer> e : options.entrySet()) {
				// If it has 4 ticks in SURE then its a RC
				if (e.getValue() == 4) {
					String s2 = e.getKey();
					// Remove first : from options answer
					int m = s2.indexOf(":");
					if (m == -1)
						continue;
					String s = s2.substring(0, m) + s2.substring(m + 1, s2.length());
					if (hml.get(s) == "High") {
						if (newData1.indexOf(s + " High") > -1)
							high.add(newData1.indexOf(s + " High"));
						if (newData1.indexOf(s + "\n" + "High") > -1)
							high.add(newData1.indexOf(s + "\n" + "High"));
					}
					if (hml.get(s) == "Medium") {
						if (newData1.indexOf(s + " Medium") > -1)
							high.add(newData1.indexOf(s + " Medium"));
						if (newData1.indexOf(s + "\n" + "Medium") > -1)
							high.add(newData1.indexOf(s + "\n" + "Medium"));
					}
					if (hml.get(s) == "Low") {
						if (newData1.indexOf(s + " Low") > -1)
							high.add(newData1.indexOf(s + " Low"));
						if (newData1.indexOf(s + "\n" + "Low") > -1)
							high.add(newData1.indexOf(s + "\n" + "Low"));
					}
					if (hml.get(s) == "") {
						none.add(newData1.indexOf(s));
					}
				}
			}
			// Sort the lists
			Collections.sort(high);
			Collections.sort(medium);
			Collections.sort(low);
			Collections.sort(none);/*
									 * System.out.println(high); System.out.println(medium);
									 * System.out.println(low); System.out.println(none);
									 */
			// Verify the importance order
			if (medium.size() > 0 && high.size() > 0) {
				if (high.get(high.size() - 1) > medium.get(0))
					softly.fail("Medium rc are before High rc");
			}
			if (low.size() > 0 && medium.size() > 0) {
				if (medium.get(medium.size() - 1) > low.get(0))
					softly.fail("Low rc are before Medium rc");
			}
			if (none.size() > 0 && low.size() > 0) {
				if (low.get(low.size() - 1) > none.get(0))
					softly.fail("None rc are before Low rc");
			}
		}
	}

	public void shareReport(WebDriver driver, String username, String password1, int y) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		String sharer = em3.decideSharer(y);
		String sharerAdded = em3.decideSharerAdded(y);
		// Clicks on share button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareButton)).click();
		// Enters username
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareTextBox)).sendKeys(sharer);
		Thread.sleep(500);
		// Selects from dropdown
		WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareDropdown));
		dropdown.findElement(opirca.FirstSelectionUnderDropdown).click();
		// Clicks on add user
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		// Verifies user added
		String user = wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.SharerAdded)).getText().trim();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		share3.shareTwice(driver, softly, 0);
		// Clicks on save
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ShareSaveButton)).click();
		// Verify share save sticky
		eirca2.verifyStickyShareSave(driver, softly);
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		// Checks the username of creator
		WebElement creator = wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.UserNameDisplayInReport));
		String creatorUsername = creator.getText().trim();
		System.out.println(creatorUsername);
		softly.assertThat(creatorUsername).as("test data").isEqualTo(username);
		// Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		// Verify Share icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAShareIconOrCriticalIcon));
		// Calls the Share check function
		share.receiptReport(driver, sharer, username, password1);
		// Clicks on OPiRCA side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASidePanel)).click();
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		// Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).click();
	}

	public void markCritical(WebDriver driver, String username, String password1, int y) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		// Clicks on mark critical
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		// Mark critical pop up
		eirca2.verifyMarkCriticalPopup(driver, softly);
		// Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		// Checks if marked critical
		share2.loadingServer(driver);
		String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
		softly.assertThat(s).as("test data").contains("ui-checkbox-on");
		// Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		// Verify Marked critical icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAShareIconOrCriticalIcon));
		// Verify presence of shared icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAShareIconWhenAlsoMarkedCritical));
		// Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).click();
		share2.loadingServer(driver);
		// Clicks on mark critical again
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		// Un-mark critical pop up
		eirca2.verifyUnMarkCriticalPopup(driver, softly);
		// Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.ConfirmPopupButton)).click();
		Thread.sleep(2000);
		share2.loadingServer(driver);
		String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical))
				.getAttribute("class");
		softly.assertThat(s1).as("test data").contains("ui-checkbox-off");
		// Verify report not retrieved by shared to person
		String sharer = em3.decideSharer(y);
		share.checkCriticalNotification(driver, sharer, username, password1, softly);
		// Clicks on O&PiRCA side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASidePanel)).click();
		// Wait for loading message to disappear
		share2.loadingServer(driver);
	}

	public List<String> selectHiRCALevel3(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Choose a number between 1 to 31 for number of selections
		Random random = new Random();
		int n;
		while (true) {
			n = random.nextInt(15);
			if (n == 0)
				continue;
			break;
		}
		// n=2;
		// Create a List to store HiRCA selections
		List<String> hircaL3 = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.HiRCADropdownMenuPopup));
			int y;
			// Choose a number between 1 and 31
			while (true) {
				y = random.nextInt(32);
				// if option is already checked then choose another number
				String s1 = ele.findElement(By.xpath(".//*[@data-option-index='" + y + "']/a")).getAttribute("class");
				if (y < 1)
					continue;
				else if (s1.contains("ui-checkbox-on"))
					continue;
				else
					break;
			}
			WebElement l = ele.findElement(By.xpath(".//*[@data-option-index='" + y + "']/a"));
			// Scroll to element
			share2.scrollToElement(driver, l);
			// Click on option
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", l);
			// Store selection name in list
			String s = l.getText().trim();
			hircaL3.add(s);
		}
		// Scroll to the top
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		// Close the pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.HiRCADropdownMenuCloseButton)).click();
		return hircaL3;
	}

	public List<String> storeApparentCauses(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 3);
		// Create a List to store apparent causes
		List<String> ac = new ArrayList<String>();
		int i = 1;
		while (true) {
			try {
				String s = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(".//*[@id='pii-opa-step1-causes']/ul/li[" + i + "]")))
						.getText().trim();
				ac.add(s);
				i = i + 1;
			} catch (org.openqa.selenium.TimeoutException e) {
				break;
			}
		}
		return ac;
	}

	public List<String> modifyListWithNoSemiColonForSUEP_SURE(List<String> apparentCausesAnswers) throws Exception {

		List<String> ac = new ArrayList<String>();
		for (int i = 0; i < apparentCausesAnswers.size(); i++) {
			String s = apparentCausesAnswers.get(i).trim();
			s = s.replace("]", "");
			s = s.replace("[", "");
			ac.add(s);
		}
		return ac;
	}

	public void verifyApparentCauses(WebDriver driver, List<String> apparentCausesAnswers) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Remove [ ] and spaces from list
		List<String> ac = op3.modifyList(apparentCausesAnswers);
		for (int i = 1; i < apparentCausesAnswers.size(); i++) {
			// Get text of answer in Step 3 under SURE
			String s = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + (i + 1) + "]/td[1]")))
					.getText().replaceAll("^( )*|( )*$", "");
			if (ac.contains(s) == false) {
				System.out.println("Step 3: not present: " + s + "\n" + ac.contains(s.replaceAll("^( )*|( )*$", "")));
				softly.fail("Apparent cause selected not present: " + s);
			}
		}
	}

	public Map<String, List<String>> opircaHiRCAApparentCauseList() throws Exception {

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		// 3.1
		List<String> l31 = new ArrayList<>(Arrays.asList("O5: Inadequate individual skills, rule use, or knowledge",
				"OP1: Inadequate commitment to implementation", "P1: Omission of program",
				"P2: Inadequate all-inclusiveness"));
		map.put("3.1 Individual specific", l31);
		// 3.2
		map.put("3.2 Supervisor specific", l31);
		// 3.3.1
		List<String> l331 = new ArrayList<>(Arrays.asList("O1: Inadequate organizational function or structure",
				"OP1: Inadequate commitment to implementation"));
		map.put("3.3.1 Inadequate resource allocation in the manager's group, by the manager", l331);
		// 3.3.2
		List<String> l332 = new ArrayList<>(Arrays.asList("OP1: Inadequate commitment to implementation"));
		map.put("3.3.2 Inadequate provision of needed training in the manager's group, by the manager", l332);
		// 3.3.3
		List<String> l333 = new ArrayList<>(Arrays.asList("OP4: Inadequate ORRA"));
		map.put("3.3.3 Inadequate accountability system in the manager's group, by the manager", l333);
		// 3.3.4
		List<String> l334 = new ArrayList<>(Arrays.asList("O3: Inadequate process design and improvement capabilities",
				"P1: Omission of program", "P2: Inadequate all-inclusiveness"));
		map.put("3.3.4 Inadequate prioritization and planning of work in the manager's group, by the manager", l334);
		// 3.3.5
		List<String> l335 = new ArrayList<>(Arrays.asList("O1: Inadequate organizational function or structure",
				"P1: Omission of program", "P2: Inadequate all-inclusiveness"));
		map.put("3.3.5 Inadequate standard setting by the manager in (1) behavior (2) procedure and LOPs", l335);
		// 3.3.6
		List<String> l336 = new ArrayList<>(Arrays.asList("OP2: Inadequate performance monitoring and trending"));
		map.put("3.3.6 Inadequate performance monitoring and trending in the manager's group", l336);
		// 3.3.7
		List<String> l337 = new ArrayList<>(Arrays.asList("OO1: Inadequate common goals/interests/accountability",
				"OO2: Inadequate interface between organizations",
				"OO3: Overlapping or omission of work functions between two interfacing organizations"));
		map.put("3.3.7 Inadequate establishment of common goals, common interests, and common accountability for team work in the manager's group",
				l337);
		// 3.3.8
		List<String> l338 = new ArrayList<>(Arrays.asList("P2: Inadequate all-inclusiveness"));
		map.put("3.3.8 Inadequate corrective actions program in the manager's group", l338);
		// 3.3.9
		List<String> l339 = new ArrayList<>(Arrays.asList("O4: Inadequate communication within organization"));
		map.put("3.3.9 Inadequate vertical communication system in the manager's group", l339);
		// 3.3.10
		map.put("3.3.10 Inadequate lateral communication in the manager's group", l339);
		// 3.4
		map.put("3.4 Inadequate critical thinking and questioning", l31);
		// 3.5
		map.put("3.5 Inadequate situation awareness", l31);
		// 3.6
		List<String> l36 = new ArrayList<>(
				Arrays.asList("P1: Omission of program", "P2: Inadequate all-inclusiveness"));
		map.put("3.6 Inadequate \"all-inclusiveness\"", l36);
		// 3.7
		List<String> l37 = new ArrayList<>(Arrays.asList("P3: Inadequate bypass control"));
		map.put("3.7 Inadequate bypass control", l37);
		// 3.8
		List<String> l38 = new ArrayList<>(Arrays.asList("P4: Inadequate clarity or incorrectness"));
		map.put("3.8 Inadequate clarity", l38);
		// 3.9
		List<String> l39 = new ArrayList<>(Arrays.asList("OP1: Inadequate commitment to implementation"));
		map.put("3.9 Inadequate training", l39);
		// 3.10
		map.put("3.10 Inadequate qualification", l39);
		// 3.11
		List<String> l311 = new ArrayList<>(
				Arrays.asList("OP2: Inadequate performance monitoring and trending", "OP4: Inadequate ORRA"));
		map.put("3.11 Inadequate job accountability", l311);
		// 3.12
		List<String> l312 = new ArrayList<>(Arrays.asList("O3: Inadequate process design and improvement capabilities",
				"P5: Excessive requirements"));
		map.put("3.12 Contributing factor for \"perceived burden\"", l312);
		// 3.13
		map.put("3.13 Contributing factor for \"undue motivation\"", l31);
		// 3.14
		List<String> l314 = new ArrayList<>(
				Arrays.asList("O4: Inadequate communication within organization", "OP4: Inadequate ORRA"));
		map.put("3.14 Contributing factor for \"low perceived risk\"", l314);
		// 3.15
		List<String> l315 = new ArrayList<>(Arrays.asList("O5: Inadequate individual skills, rule use, or knowledge",
				"OP1: Inadequate commitment to implementation", "P1: Omission of program"));
		map.put("3.15 Contributing factors for inadequate peer coaching (assistance)", l315);
		// 3.16
		map.put("3.16 Contributing factor for inattention-to-detail", l31);
		// 3.17
		List<String> l317 = new ArrayList<>(Arrays.asList("OP1: Inadequate commitment to implementation",
				"P1: Omission of program", "P2: Inadequate all-inclusiveness"));
		map.put("3.17 QTM - equipment qualification, testing and maintenance", l317);
		// 3.18
		map.put("3.18 Knowledge-based errors", l31);
		// 3.19
		map.put("3.19 Inadequate engagement at TO, PJB or MJB", l317);
		// 3.20
		map.put("3.20 HiRCA™ technology", l338);
		// 3.21
		map.put("3.21 High Risk Situations (TAPE", l31);
		// 3.22
		List<String> l322 = new ArrayList<>(Arrays.asList("OP2: Inadequate performance monitoring and trending",
				"OP3: Inadequate self evaluation or assessment", "P4: Inadequate clarity or incorrectness"));
		map.put("3.22 Incorrect Rules", l322);
		return map;
	}

	public void verifyCorrespondingApparentCauses(WebDriver driver, List<String> hircaL3, List<String> apparentCauses)
			throws Exception {

		// Get Map with HiRCA and its corresponding Apparent causes
		Map<String, List<String>> map = opircaHiRCAApparentCauseList();
		for (int i = 0; i < hircaL3.size(); i++) {
			// for 3.21 it didn't recognize superscript 3.21 High Risk Situations (TAPE
			if (hircaL3.get(i).startsWith("3.21"))
				apparentCauses.containsAll(map.get("3.21 High Risk Situations (TAPE"));
			else
				apparentCauses.containsAll(map.get((hircaL3).get(i)));
		}
	}

	public List<String> modifyStep1(WebDriver driver, List<String> hircaL3) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// create a new list without the unselected hirca level 3 option
		List<String> hircaNewList = new ArrayList<String>(hircaL3);
		// Click on Step 1 tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep1Tab)).click();
		System.out.println("PrintOut Step1 dropdown size" + hircaL3.size());
		if (hircaL3.size() <= 0) {
			return hircaNewList;
		}
		// Click on dropdown field
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.HiRCADropdownMenuButton)).click();
		// Choose a number between 0 and hircaL3.size()-1
		Random random = new Random();
		int n = random.nextInt(hircaL3.size());
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(hircaL3.get(n))));
		// Scroll to element
		share2.scrollToElement(driver, l);
		// Unselect the chosen HiRCA level 3 option
		try {
			l.click();
		} catch (org.openqa.selenium.ElementClickInterceptedException r) {
			l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(hircaL3.get(n))));
			// Scroll to element
			share2.scrollToElement(driver, l);
			l.click();
		}
		// Scroll to the top
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		// Close the pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.HiRCADropdownMenuCloseButton)).click();
		// remove the unselected option from list
		hircaNewList.remove(n);
		return hircaNewList;
	}

	public List<String> getOnlyNumberOfApparentCauses(List<String> apparentCausesNew) throws Exception {

		List<String> ac = new ArrayList<String>();
		for (int i = 0; i < apparentCausesNew.size(); i++) {
			// Get index of :
			int n = apparentCausesNew.get(i).indexOf(":");
			// get only number of the apparent cause
			String s = apparentCausesNew.get(i).substring(0, n);
			n = s.indexOf(".");
			if (n != -1) {
				String s1 = s.substring(0, n);
				// Add to list
				ac.add(s1);
			} else
				ac.add(s);
		}
		return ac;
	}

	public List<String> verifyModifiedStep3(WebDriver driver, List<String> apparentCausesNew,
			List<String> step2ApparentCausesAnswers) throws Exception {

		// Get first few characters in apparent causes and store in a list
		List<String> ac = getOnlyNumberOfApparentCauses(apparentCausesNew);
		List<String> step2 = getOnlyNumberOfApparentCauses(op3.modifyList(step2ApparentCausesAnswers));
		// Create list to store the new list for apparent cause answers
		List<String> ac1 = new ArrayList<String>();
		// Get text of answer in Step 3 under SURE
		int i = 2;
		while (true) {
			try {
				// Get text of apparent cause answer
				String s = driver.findElement(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]"))
						.getText().trim();
				// Remove first appearing : and store in list
				int m = s.indexOf(":");
				System.out.println("printOut#923 m String value: "+m);
				String s3 = s.substring(0, m);
				System.out.println("printOut#925 s3 String value: "+s3);
				String s4 =  s.substring(m + 1, s.length());
				System.out.println("printOut#927 s4 String value: "+s4);
				if (Character.isDigit(s.charAt(m - 1)) == true) {
					String s2 = s.substring(0, m) + s.substring(m + 1, s.length());
					System.out.println("printOut#930 s2 String value:" +s2);
					ac1.add(s2);
				}
				i = i + 1;
				int n = s.indexOf(".");
				System.out.println("printOut#935 n value: "+n);
				// Gets only apparent cause name from answer
				String s1 = s.substring(0, n);
				System.out.println("printOut#938 s1 String value: "+s1);
				if ((ac.contains(s1) == false)) {
					if (step2.contains(s1) == false) {
						System.out.println("printOut#941 s1 String value in contain loop"+s1);
						System.out.println("printOut#942 s1 value in ac.contains1 loop" +ac.contains(s1));
						System.out.println("printOut#943 ac value in contain loop" +ac);
						System.out.println("printOut#944 step2 contain s1 value in contain loop" +step2.contains(s1));
						System.out.println("printOut#945 step2 value in contain loop"+step2);
						softly.fail("Apparent cause unselected is still present: " + s);
					}
				}
			} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
				break;
			}
		}
		return ac1;
	}

	public void verifyHTML(WebDriver driver, List<String> hircaNewList, List<String> apparentCausesNew,
			List<String> apparentCausesAnswersNew, HashMap<String, String> hml, HashMap<String, Integer> options,
			List<String> apparentCausesSelected, List<String> step2QuestionAnswers,
			List<String> step2ApparentCausesAnswers) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Verify all text in 1st table in HTML
		String text = eirca2.textCreate(driver);
		// Event title
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.HTMLTable1EventTitle)).getText()
				.trim();
		String r3 = s4.replace("\u00AD", "");
		softly.assertThat(r3).as("test data").contains(text);
		// Location of event
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.HTMLTable1LocationOfEvent))
				.getText().trim();
		String r4 = s5.replace("\u00AD", "");
		softly.assertThat(r4).as("test data").isEqualTo(text);
		// Investigators
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.HTMLTable1Investigators)).getText()
				.trim();
		String r5 = s6.replace("\u00AD", "");
		softly.assertThat(r5).as("test data").isEqualTo(text);
		// Table 2
		// Problem Statment
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.HTMLTable2ProblemStatment))
				.getText().trim();
		String r6 = s7.replace("\u00AD", "");
		softly.assertThat(r6).as("test data").isEqualTo(text);
		/*
		 * am_not applicable //Timeline of event String s8 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.
		 * HTMLTable2Timeline)).getText().trim(); String r7 = s8.replace("\u00AD", "");
		 * softly.assertThat(r7).as("test data").isEqualTo(text);
		 */
		// Background info
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.HTMLTable2Background)).getText()
				.trim();
		String r8 = s9.replace("\u00AD", "");
		softly.assertThat(r8).as("test data").isEqualTo(text);
		// Number of root cause and contributing factors
		int rc, cf;
		if (apparentCausesAnswersNew.size() > 0) {
			rc = options.get("Root causes");
			// Get number of contributing factors
			cf = apparentCausesAnswersNew.size() - rc;
		} else {
			rc = 0;
			cf = 0;
		}
		// When no root causes present
		if (rc == 0) {
			// Verify the table doesnt have text before the table like "undefined"
			String undefined = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCARootCauseTable))
					.getText().trim();
			softly.assertThat(undefined).as("test data").doesNotContain("undefined \n");
			// Verify Root cause as n/a
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANoRCField1)).getText()
					.trim();
			softly.assertThat(s).as("test data").isEqualTo("n/a");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANoRCField2)).getText()
					.trim();
			softly.assertThat(s1).as("test data").isEqualTo("n/a");
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANoRCField3)).getText()
					.trim();
			softly.assertThat(s2).as("test data").isEqualTo("n/a");
		}
		// Also checks if High Medium Low order is correct in Level 3 answers
		int b = 4;
		// When root cause is present
		for (int i = 4; i <= rc + 3; i++) {
			// Verify the table doesnt have text before the table like "undefined"
			String undefined = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div[" + i + "]")))
					.getText().trim();
			softly.assertThat(undefined).as("test data").doesNotContain("undefined \n");
			// Get name of level 3 answer
			String s = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div[" + i + "]/table[1]/tbody/tr/td[1]")))
					.getText().trim();
			// Verify if this level 3 answer was selected
			if (apparentCausesAnswersNew.contains(s) == false) {
				softly.fail("Apparent cause answer is not suppose to be here: " + s);
			}
			// Add :
			int m = s.indexOf(" ");
			if (Character.isDigit(s.charAt(m - 1)) == true) {
				String s1 = s.substring(0, m) + ": " + s.substring(m + 1, s.length());
				// Check if it has 4 boxes ticked
				if (options.get(s1) != 4) {
					softly.fail("Not a root cause, Not all four boxes are ticked, only some are: " + options.get(s));
				}

			}
			// Get importance and verify
			String s1 = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div[" + i + "]/table[1]/tbody/tr/td[2]")))
					.getText().trim();
			// Verify high medium low
			softly.assertThat(s1).as("test data").isEqualTo(hml.get(s));
			// Verify order of High Medium Low
			if (s1.equals("High")) {
				if (b > 3 || b == 3) {
					b = 3;
					System.out.println("Order is correct:High");
				}
				if (b < 3)
					softly.fail("Currently in High Block: Order is wrong");
			}
			if (s1.equals("Medium")) {
				if (b > 2 || b == 2) {
					b = 2;
					System.out.println("Order is correct:Medium");
				}
				if (b < 2)
					softly.fail("Currently in Medium Block: Order is wrong");
			}
			if (s1.equals("Low")) {
				if (b > 1 || b == 1) {
					b = 1;
					System.out.println("Order is correct:Low");
				}
				if (b < 1)
					softly.fail("Currently in Low Block: Order is wrong");
			}
			if (s1.equals("") || s1 == "" || s1.equals(null)) {
				if (b > 0 || b == 0) {
					b = 0;
					System.out.println("Order is correct:None");
				}
				if (b < 0)
					softly.fail("Currently in None Block: Order is wrong");
			}
		}
		if (rc == 0) {
			// Because there will be a div with Root Cause as n/a
			rc = rc + 1;
		}
		// When no contributing factors present
		if (cf == 0) {
			// Verify the table doesnt have text before the table like "undefined"
			String undefined = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div[" + (rc + 4) + "]")))
					.getText().trim();
			softly.assertThat(undefined).as("test data").doesNotContain("undefined \n");
			// Verify Contributing factors as n/a
			String s = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='opa-rpt']/div[" + (rc + 4) + "]/table/tbody/tr/td[1]")))
					.getText().trim();
			softly.assertThat(s).as("test data").isEqualTo("n/a");
			String s1 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='opa-rpt']/div[" + (rc + 4) + "]/table/tbody/tr/td[2]")))
					.getText().trim();
			softly.assertThat(s1).as("test data").isEqualTo("n/a");
			String s2 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='opa-rpt']/div[" + (rc + 4) + "]/table/tbody/tr/td[3]")))
					.getText().trim();
			softly.assertThat(s2).as("test data").isEqualTo("n/a");
		}
		// When contributing factors are present
		int i = 1;
		b = 4;
		while (i <= cf) {
			// Verify the table doesnt have text before the table like "undefined"
			String undefined = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(".//*[@id='opa-rpt']/div[" + (rc + 4) + "]")))
					.getText().trim();
			softly.assertThat(undefined).as("test data").doesNotContain("undefined \n");
			// Get name of level 3 answer
			String s = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='opa-rpt']/div[" + (rc + 4) + "]/table/tbody/tr[" + i + "]/td[1]")))
					.getText().trim();
			// Verify if this level 3 answer was selected
			if (apparentCausesAnswersNew.contains(s) == false) {
				softly.fail("Apparent cause answer is not suppose to be here: " + s);
			}
			// Add :
			int m = s.indexOf(" ");
			if (Character.isDigit(s.charAt(m - 1)) == true) {
				String s1 = s.substring(0, m) + ": " + s.substring(m + 1, s.length());
				// Check if it has 4 boxes ticked
				if (options.get(s1) == 4) {
					softly.fail("Not a contributing factor, All four boxes are ticked, only some should be: "
							+ options.get(s));
				}
			}
			// Get importance and verify
			String s1 = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='opa-rpt']/div[" + (rc + 4) + "]/table/tbody/tr[" + i + "]/td[2]")))
					.getText().trim();
			// Verify high medium low
			softly.assertThat(s1).as("test data").isEqualTo(hml.get(s));
			// Increase i for next cf
			i = i + 1;
			// Verify order of High Medium Low
			if (s1.equals("High")) {
				if (b > 3 || b == 3) {
					b = 3;
					System.out.println("Order is correct:High");
				}
				if (b < 3)
					softly.fail("Currently in High Block: Order is wrong");
			}
			if (s1.equals("Medium")) {
				if (b > 2 || b == 2) {
					b = 2;
					System.out.println("Order is correct:Medium");
				}
				if (b < 2)
					softly.fail("Currently in Medium Block: Order is wrong");
			}
			if (s1.equals("Low")) {
				if (b > 1 || b == 1) {
					b = 1;
					System.out.println("Order is correct:Low");
				}
				if (b < 1)
					softly.fail("Currently in Low Block: Order is wrong");
			}
			if (s1.equals("") || s1 == "" || s1.equals(null)) {
				if (b > 0 || b == 0) {
					b = 0;
					System.out.println("Order is correct:None");
				}
				if (b < 0)
					softly.fail("Currently in None Block: Order is wrong");
			}
		}
		// Create a list
		List<String> list1 = new ArrayList<String>();
		// Verify Selected HiRCA Results
		i = 1;
		while (true) {
			try {
				String s = driver
						.findElement(By.xpath(
								".//*[@id='opa-rpt']/div[" + (rc + 5) + "]/table/tbody/tr[1]/td[1]/ul/li[" + i + "]"))
						.getText().trim();
				// Remove first appearing : and store in list, since hirca new list doesnt have
				// : after the numbering
				int m = s.indexOf(":");
				String s1 = s.replace(Character.toString(s.charAt(m)), "");
				list1.add(s1);
				i = i + 1;
			} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
				break;
			}
		}
		// Verify if Selected HiRCA Results list is same as new hirca list
		softly.assertThat(list1).as("test data").containsAll(hircaNewList);
		// Empty list1
		list1.clear();
		// Verify Apparent O&P causes
		i = 1;
		while (true) {
			try {
				String s = driver
						.findElement(By.xpath(
								".//*[@id='opa-rpt']/div[" + (rc + 5) + "]/table/tbody/tr[1]/td[2]/ul/li[" + i + "]"))
						.getText().trim();
				list1.add(s);
				i = i + 1;
			} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
				break;
			}
		}
		// Verify if Apparent O&P causes list is same as new apparent causes list
		softly.assertThat(list1).as("test data").containsAll(apparentCausesNew);
		// Empty list1
		list1.clear();
		// Verify Possible contributing factors
		i = 1;
		while (true) {
			try {
				String s = driver
						.findElement(By.xpath(".//*[@id='opa-rpt']/div[" + (rc + 5)
								+ "]/table/tbody/tr[2]/td/div/table/tbody/tr[" + i + "]/td[1]"))
						.getText().replaceAll("^( )*|( )*$", "");
				list1.add(s.replaceAll("^( )*|( )*$", ""));
				i = i + 1;
			} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
				break;
			}
		}
		// Remove : from list of apparent causes
		List<String> removeColon = new ArrayList<String>();
		for (int j = 0; j < apparentCausesSelected.size(); j++) {
			int m = apparentCausesSelected.get(j).indexOf(":");
			if (m != -1) {
				if (m < apparentCausesSelected.get(j).length()) {
					String s = apparentCausesSelected.get(j).substring(0, m)
							+ apparentCausesSelected.get(j).substring(m + 1, apparentCausesSelected.get(j).length());
					System.out.println("***" + s.replaceAll("^( )*|( )*$", "") + "***");
					removeColon.add(s.replaceAll("^( )*|( )*$", ""));
				}
			} else
				removeColon.add(apparentCausesSelected.get(j));
		}
		// Verify if Possible contributing factors or Apparent causes answers list is
		// same as new apparent causes answers list
		softly.assertThat(list1).as("test data").containsAll(removeColon);
		// Empty list1
		list1.clear();
		// Verify step 2 table
		op2.step2HTML(driver, softly, rc, step2QuestionAnswers, step2ApparentCausesAnswers, apparentCausesAnswersNew);
		// Verify contributing factors under SURE
		i = 1;
		while (true) {
			try {
				String s = driver
						.findElement(
								By.xpath(".//*[@id='opa-rpt']/div[" + (rc + 7) + "]/table/tbody/tr[" + i + "]/td[1]"))
						.getText().trim();
				System.out.println("s: " + s);
				list1.add(s);
				i = i + 1;
			} catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
				break;
			}
		}
		// Verify if Possible contributing factors or Apparent causes answers list is
		// same as new apparent causes answers list
		softly.assertThat(list1).as("test data").containsAll(apparentCausesAnswersNew);
		// Empty list1
		list1.clear();
	}

	public void verifySURE(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Verify SURE title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.PageTitle)).getText().trim();
		softly.assertThat(title).as("test data").contains("Step 3 - Root Causes Determination Checklist (SURE");
		// Verify SURE full form
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.SField)).getText().trim();
		softly.assertThat(s1).as("test data").isEqualTo("S: Substandard Practice?");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.UField)).getText().trim();
		softly.assertThat(s2).as("test data").isEqualTo("U: Under Management Control?");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.RField)).getText().trim();
		softly.assertThat(s3).as("test data").isEqualTo("R: Reduce Probability Significantly?");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.EField)).getText().trim();
		softly.assertThat(s4).as("test data").isEqualTo("E: Not an Effect of Other Contributing Factors?");
	}

	public List<String> getRootCausesFromStep3(WebDriver driver, HashMap<String, Integer> options, int rc, int n)
			throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<String> rccf = new ArrayList<String>();
		for (int i = 2; i <= n + 1; i++) {
			// Get text of apparent answer
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]"))).getText().trim();
			int boxesTicked = options.get(s);
			if ((rc == 1) && (boxesTicked == 4))
				rccf.add(s);
			if ((rc == 0) && (boxesTicked < 4))
				rccf.add(s);
		}
		return rccf;
	}

	public HashMap<String, Integer> markSUREStep3(WebDriver driver, List<String> apparentCausesAnswersNew)
			throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Scroll to top
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		// Verify SURE
		verifySURE(driver);
		// Hashmap for storing number of SURE checkboxes ticked
		HashMap<String, Integer> options = new HashMap<String, Integer>();
		// Get size of Apparent Causes Answers
		int n = apparentCausesAnswersNew.size();
		System.out
				.println("Total Numbers of RootCause and Contributing Factors:" + n + "\n" + apparentCausesAnswersNew);
		if (n < 1)
			return options;
		// Row no starts from 2
		// Count for root causes
		int r = 0;
		for (int i = 2; i <= n + 1; i++) {
			// Get text of apparent answer
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]"))).getText().trim();
			// Click on random SURE
			Random random = new Random();
			// Choose a number between 0 and 4 for number of selections
			int num = random.nextInt(5);
			if (num == 4)
				r = r + 1;
			// Store no of SURE checkboxes in hashmap: key=level 3 answer, value = no of
			// sure checks
			options.put(s, num);
			for (int j = 1; j <= num; j++) {
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[" + (j + 1) + "]/div/input")));
				// Scroll to element
				share2.scrollToElement(driver, l);
				// Click on checkbox of SURE
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", l);
			}
		}
		// Add no of root causes in hashmap
		options.put("Root causes", r);
		// System.out.println(options);
		// Scroll up
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		return options;
	}

	public void clickNextSkip(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		String skip = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).getAttribute("class");
		Thread.sleep(2000);
		if (skip.contains("ui-state-disabled")) {
			// Click on next
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)));
		} else {
			// Click on skip
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)));
		}
	}

	public HashMap<String, String> markHML(WebDriver driver, HashMap<String, Integer> options,
			List<String> apparentCausesAnswersNew, List<String> apparentCausesForStep3_modified,
			List<String> rootCauses, List<String> contributingFactors) throws Exception {
		   JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Hashmap for storing HML for root cause and contributing factors
		HashMap<String, String> hml = new HashMap<String, String>();
		// Verify title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.PageTitle)).getText().trim();
		softly.assertThat(title).as("test data")
				.contains("Step 4 - Level of Importance Attribution For Root Causes & Contributing Factors");
		// Get number of Root causes in Level 3 answers
		int count = options.get("Root causes");
		System.out.println("No of root causes:" + count);
		// Gets number of contributing factors
		int count1 = apparentCausesAnswersNew.size() - count;
		System.out.println("No of contributing factors:" + count1);
		
	// Custom code to randomly select all the available HML-
		List<WebElement> eleList = driver.findElements(By.xpath("//td[@class='pii-opa-td-hml']"));
		
		for (int t = 1; t < eleList.size(); t++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
			Thread.sleep(1000);
			jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("((//td[@class='pii-opa-td-hml'])[" + t + "]//div/div[" + randomNum + "])")));
			Thread.sleep(1000); 
			jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("((//td[@class='pii-opa-td-hml'])[" + t + "]//div/div[" + randomNum + "])")));
			Thread.sleep(1000); 
			//jse.executeScript("window.scrollBy(0,350)");
		}
		
/////////////////////am_below from OPiRCABug test		
		// tr starts at 2 and each root cause has 4 four rows
//		int i = 2;
//		// Verify if any root causes are appearing
//		while (i <= ((count * 3) + 1)) {
//			// HML random select
//			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[3]")));
//			// Scroll to element
//			share2.scrollToElement(driver, ele);
//			// Select a number between 0 to 3 for H,M,L
//			Random random = new Random();
//			int y = random.nextInt(4);
//			if (y != 0) {
//				// Click on H/M/L
//				wait.until(ExpectedConditions
//						.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i
//								+ "]/td[3]/fieldset/div/div[" + y + "]/label")))
//						.click();
//				if (y == 1)
//					hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]"))).getText(), "H");
//				if (y == 2)
//					hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]"))).getText(), "M");
//				if (y == 3)
//					hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]"))).getText(), "L");
//			} else
//				hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(
//						By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]"))).getText(), "");
//			// Increase i for extra root cause text boxes
//			i = i + 1;
//			// Enter text in 1st box Extent of condition
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]/textarea[1]"))).clear();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]/textarea[1]")))
//					.sendKeys(text);
//			// Enter text in 2nd box Operating Experience
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]/textarea[2]"))).clear();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]/textarea[2]")))
//					.sendKeys(text);
//			// Enter text in 3rd box Safety Culture
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]/textarea[3]"))).clear();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]/textarea[3]")))
//					.sendKeys(text);
//			// Increase i for corrective actions
//			i = i + 1;
//			// Enter text in corrective actions
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]/textarea[1]"))).clear();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]/textarea[1]")))
//					.sendKeys(text);
//			// Increase i for next root cause
//			i = i + 1;
//		}
//	
//
//		// Verifies if any contributing factors
//		// tr starts at 2 and each root cause has 4 four rows
//		int start = i - 1;
//		// Verify if any contributing factors are appearing
//		while (i <= ((count1 * 2) + start)) {
//			// HML random select
//			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[3]")));
//			// Scroll to element
//			share2.scrollToElement(driver, ele);
//			// Select a number between 0 to 3 for H,M,L
//			Random random = new Random();
//			int y = random.nextInt(4);
//			if (y != 0) {
//				// Click on H/M/L
//				wait.until(ExpectedConditions
//						.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i
//								+ "]/td[3]/fieldset/div/div[" + y + "]/label")))
//						.click();
//				if (y == 1)
//					hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]"))).getText(), "H");
//				if (y == 2)
//					hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]"))).getText(), "M");
//				if (y == 3)
//					hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]"))).getText(), "L");
//			} else
//				hml.put(wait.until(ExpectedConditions.visibilityOfElementLocated(
//						By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]"))).getText(), "");
//			// Increase i for changing corrective actions
//			i = i + 1;
//			// Enter text in corrective actions
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]/textarea[1]"))).clear();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]/textarea[1]")))
//					.sendKeys(text);
//			// Increase i for next contributing factor
//			i = i + 1;
//		}
////////////////////am_above from OPiRCABug test
		// Scroll up
		share2.scrollToTop(driver);
		jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-opa-button-next"))));
		System.out.println("printOut hml   "+hml);
		return hml;
	}

//		//Hashmap for storing HML for root cause and contributing factors
//		HashMap<String,String> hml= new HashMap<String,String>();
//		//No Level 3 selected then return
//		if(apparentCausesAnswersNew.size()==0)
//		{
//			System.out.println("No root causes or contributing factors");
//			return hml;
//		}
///////////////////////////////////////////////////////////////////////////
//		//Step4: Count number of {Root Cause} and {Contributing Factors} radio clicks
//		//Get number of Root causes in Level 3 answers
//		int count = options.get("Root causes");
//		System.out.println("No of root causes (count):"+count);
//		//Gets number of contributing factors
//		int count1 = apparentCausesAnswersNew.size()-count;
//		System.out.println("No of contributing factors (count1):"+count1);		
///////////////////////////////////////////////////////////////////////////
//		//tr starts at 2 and each root cause has 4 four rows
//		int i=2;
//		//check order of root cause
//		op2.verifyOrderOfRootCausesContributingFactorsInStep4(driver, rootCauses, softly, count, i, 1, 1,3);
//		//Verify if any root causes are appearing
//		while(i<=((count*3)+1))    // 2<=19
////		while(i!=2)    // 2<=19
//		{
//			//Get name of level 3 answer
//			
//			String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
////			String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("	//*[contains(text(),'STEP 1') or contains(text(),'STEP 2')]"))).getText().trim();
//			System.out.println("print level3 all String #1404:  " +"\n" +level3);
//			//Remove the 1st : from level 3
//			//Remove first appearing : and store in list
//			int m = level3.indexOf(":");
//			String s2 = level3.substring(0, m)+level3.substring(m+1, level3.length());
//		   System.out.println("print level3 all String after trim #1409:  " +"\n"+s2);
//			
//		   //Verify if this level 3 answer was selected
//			if(apparentCausesAnswersNew.contains(s2)==false)
//			{
//				softly.fail("Apparent Cause Answer is not suppose to be here: "+level3);
//			}
//			//Check if it has 4 boxes ticked
//			if(!options.isEmpty() && options.get(level3)!=4)
//			{
//				softly.fail("Not all four boxes are ticked, only some are: "+ options.get(level3));
//			}
/////////////////////////////////////////////////////////////////////////////
//			//Step4: Check if {Root Cause} radio click display as count
//			//Check if Apparent Cause answer is root cause
//			
//			String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div/input"))).getAttribute("checked");
//			
////			String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("*//div[@class='ui-radio']/label[text()='R']/following-sibling::input"))).getAttribute("checked");
//			softly.assertThat(lop1).as("test data").isEqualTo("true");
//			
//			//Check if Apparent Cause answer is not a contributing factor
//			String lop4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("disabled");
//			softly.assertThat(lop4).as("test data").isEqualTo("true");
//			
//			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]")));
//			//Scroll to element
//			share2.scrollToElement(driver, ele);
//////////////////////////////////////////////////////////////////////////////////////			
//			//Select a number between 0 to 3 for H,M,L
//			Random random =new Random();
//			int y=random.nextInt(4);
//			System.out.println("print y value #1441:  " +y);
//			if(y==1)
//			{
//				//Click on H
//				JavascriptExecutor executor = (JavascriptExecutor)driver;
//				executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
//				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
//				softly.assertThat(lop2).as("test data").isEqualTo("H");
//				//Insert in hashmap answer and hml
//				hml.put(s2, "High");
//			}
//			if(y==2)
//			{
//				//Click on M
//				JavascriptExecutor executor = (JavascriptExecutor)driver;
//				executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
//				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
//				softly.assertThat(lop2).as("test data").isEqualTo("M");
//				//Insert in hashmap answer and hml
//				hml.put(s2, "Medium");
//			}
//			if(y==3)
//			{
//				//Click on L
//				JavascriptExecutor executor = (JavascriptExecutor)driver;
//				executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
//				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
//				softly.assertThat(lop2).as("test data").isEqualTo("L");
//				//Insert in hashmap answer and hml
//				hml.put(s2, "Low");
//			}
//			if(y==0)
//			{
//				//Insert in hashmap answer and hml
//				hml.put(s2, "");
//			}
//			//Increase i for extra root cause text boxes
//			i=i+1;
//			//Increase i for changing corrective actions
//			i=i+1;
//			//tbr.sizeCheck(driver, By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td/textarea"),softly);
//			//Increase i for next root cause
//			i=i+1;
//		}
//		//Verifies if any contributing factors
//		//tr starts at 2 and each root cause has 4 four rows
//		int start = i-1;
//		//check order of contributing factors
//		op2.verifyOrderOfRootCausesContributingFactorsInStep4(driver, contributingFactors, softly, count1, i, 0, start,2);
//		//Verify if any contributing factors are appearing
//		System.out.println("print count1 before whileloop #1480: " + count1);
//		System.out.println("print start before whileloop #1480: " + start);
//		//while(i<=((count1*2)+start))
//		while(i<0)
//		{
//			//Get name of level 3 answer
//			String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
//			//Remove the 1st : from level 3
//			//Remove first appearing : and store in list
//			int m = level3.indexOf(":");
//			String s2 = level3.substring(0, m)+level3.substring(m+1, level3.length());
//			//Verify if this level 3 answer was selected
//			if(apparentCausesAnswersNew.contains(s2)==false)
//			{
//				softly.fail("Level 3 is not suppose to be here: "+s2);
//			}
//			//Check if it has 4 boxes ticked
//			if(!options.isEmpty() && options.get(level3)>3)
//			{
//				softly.fail("All four boxes are ticked"+ options.get(level3));
//			}
//			//Check if Level 3 is contributing factors
//			String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("checked");
//			softly.assertThat(lop1).as("test data").isEqualTo("true");
//			//Check if Level 3 is not a root cause
//			String lop4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div/input"))).getAttribute("disabled");
//			softly.assertThat(lop4).as("test data").isEqualTo("true");
//			//HML random select
//			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]")));
//			//Scroll to element
//			share2.scrollToElement(driver, ele);
//			//Select a number between 0 to 3 for H,M,L
//			Random random =new Random();
//			int y=random.nextInt(4);
//			System.out.println("pring y #1513: " +y);
//			if(y==1)
//			{
//				//Click on H
//				JavascriptExecutor executor = (JavascriptExecutor)driver;
//				executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
//				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
//				softly.assertThat(lop2).as("test data").isEqualTo("H");
//				//Insert in hashmap answer and hml
//				hml.put(s2, "High");
//			}
//			if(y==2)
//			{
//				//Click on M
//				JavascriptExecutor executor = (JavascriptExecutor)driver;
//				executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
//				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
//				softly.assertThat(lop2).as("test data").isEqualTo("M");
//				//Insert in hashmap answer and hml
//				hml.put(s2, "Medium");
//			}
//			if(y==3)
//			{
//				//Click on L
//				JavascriptExecutor executor = (JavascriptExecutor)driver;
//				executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
//				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
//				softly.assertThat(lop2).as("test data").isEqualTo("L");
//				//Insert in hashmap answer and hml
//				hml.put(s2, "Low");
//			}
//			if(y==0)
//			{
//				//Insert in hashmap answer and hml
//				hml.put(s2, "");
//			}
//			//Increase i for changing corrective actions
//			i=i+1;
//			tbr.sizeCheck(driver, By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td/textarea"),softly);
//			//Increase i for next contributing factor
//			i=i+1;
//		}
//		//Scroll up
//		share2.scrollToTop(driver);
//		Thread.sleep(2000);
//		share2.scrollToTop(driver);
//		Thread.sleep(2000);
//		return hml;
//		

	public List<String> changeApparentCausesListWithoutSerialNumber(List<String> apparentCausesNew) throws Exception {

		List<String> ac = new ArrayList<String>();
		for (int i = 0; i < apparentCausesNew.size(); i++) {
			int m = apparentCausesNew.get(i).indexOf(":");
			String s = apparentCausesNew.get(i).substring(m + 2, apparentCausesNew.get(i).length());
			ac.add(s);
		}
		// System.out.println(ac);
		return ac;
	}

	public List<String> verifyApparentCausesAnswers(WebDriver driver, List<String> apparentCausesNew) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// List for storing all checked apparent cause answers
		List<String> answers = new ArrayList<String>();
		// Create a list to store only title of apparent cause answer
		List<String> ac = changeApparentCausesListWithoutSerialNumber(apparentCausesNew);
		for (int i = 0; i < apparentCausesNew.size(); i++) {
			// Get title of page
			String title = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.PageTitle)).getText()
					.replaceAll("^( )*|( )*$", "");
			if (title.charAt(title.length() - 1) == ' ') {
				if (title.endsWith("  "))
					softly.assertThat(ac)
							.contains(title.substring(0, title.length() - 2).replaceAll("^( )*|( )*$", ""));
				else
					softly.assertThat(ac)
							.contains(title.substring(0, title.length() - 1).replaceAll("^( )*|( )*$", ""));
			} else
				softly.assertThat(ac).contains(title.trim());
			// Store selected apparent cause answers
			List<String> a = storeChangedApparentCauseAnswers(driver);
			// Scroll to top
			Thread.sleep(2000);
			share2.scrollToTop(driver);
			Thread.sleep(2000);
			// Add to master list
			answers.addAll(a);
			// Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		}
		return answers;
	}

	public List<String> storeChangedApparentCauseAnswers(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 3);
		List<String> ac = new ArrayList<String>();
		int y = 0;
		while (true) {
			try {
				y = y + 1;
				// Look for selected answer
				WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-opa-answers']/div[" + y + "]/fieldset/div/div/label")));
				WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='efi-opa-answers']/div[" + y + "]/fieldset/div/div/input")));
				if (e.isSelected()) {
					// Get answer name and store in list
					String s1 = l.getText().trim();
					ac.add(s1);
				} else
					continue;
			} catch (org.openqa.selenium.TimeoutException | NoSuchElementException r) {
				break;
			}
		}
		// call function to remove [ ] and add : in place of ]
		List<String> ac1 = op3.modifyList(ac);
		return ac1;
	}

	public void verifyOrderOfApparentCauseAnswersInStep3(WebDriver driver, List<String> apparentCausesSelected)
			throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Verify order
		// Counter for list
		int n = 0;
		System.out.println("Size:" + apparentCausesSelected.size());
		for (int i = 2; i <= (apparentCausesSelected.size() + 1); i++) {
			System.out.println("i = " + i + ", n = " + n);
			String s = wait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr[" + i + "]/td[1]")))
					.getText().replaceAll("^( )*|( )*$", "");
			softly.assertThat(s.replaceAll("^( )*|( )*$", "")).as("test data")
					.isEqualTo(apparentCausesSelected.get(n).replaceAll("^( )*|( )*$", ""));
			System.out.println(s + "\n" + apparentCausesSelected.get(n));
			n = n + 1;
		}
		// softly.assertAll();
	}

	public String pathOPiRCA(WebDriver driver, String username, String ev1) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// Scroll down
		share2.scrollToElement(driver,
				wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButtonAtBottomOfInfoTab)));
		// Click next
		jse.executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButtonAtBottomOfInfoTab)));
		// Scroll top
		Thread.sleep(1000);
		share2.scrollToTop(driver);
		Thread.sleep(1000);
		// Click Skip button for Sequence of Event
		jse.executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)));
		// Click on dropdown field
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.HiRCADropdownMenuButton)).click();
		// Select HiRCA options for level 3
		List<String> hircaL3 = selectHiRCALevel3(driver);
		// Check the description collapsible
		op3.collapsibleCheckDescription(driver, softly);
		// Store selected apparent causes in List
		List<String> apparentCauses = storeApparentCauses(driver);
		// Verify the apparent causes appearing
		verifyCorrespondingApparentCauses(driver, hircaL3, apparentCauses);
		if (hircaL3.isEmpty()) {
			// Click on skip if no selections made
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
		} else {
			// Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		}
		if (apparentCauses.isEmpty() == true) {
			// Click on skip if no selections made
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
		}
		// If any apparent causes selected then click on them and store in a list
		List<String> apparentCausesAnswers = op3.selectApparentCausesAnswers(driver, apparentCauses, softly);
		/*
		 * //Skip all Step 2 questions for (int i=0;i<12;i++) { //Click on skip
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.
		 * OPiRCASkipButton)).click(); }
		 */
		// Step2
		List<String> step2 = op2.opircaStep2(driver, softly);
		// Seperate list of Step 2 D1 to D12 answers
		List<String> step2QuestionAnswers = op2.step2QuestionsAnswersOnly(step2);
		// List of apparent causes selected under Step 2
		List<String> step2ApparentCausesAnswers = op2.step2ApparentCausesAnswersOnly(step2);
		System.out.println("PrintOutStep2ApparentCausesAnswers" + step2ApparentCausesAnswers);
		// Combine Apparent causes selected under step1 and step 2 for veryfing in step
		// 3/4 and reports
		List<String> apparentCausesForStep3 = op2.combineApparentCausesFromStep1AndStep2(apparentCausesAnswers,
				step2ApparentCausesAnswers);
		// Verify apparent causes selections in Step 3
		verifyApparentCauses(driver, apparentCausesForStep3);
		// Unselect one HiRCA Level 3 option
		List<String> hircaNewList = modifyStep1(driver, hircaL3);
		// Store new list of apparent causes
		List<String> apparentCausesNew = storeApparentCauses(driver);
		// Verify that apparent cause of only the selected HiRCA level 3 options are
		// visible
		verifyCorrespondingApparentCauses(driver, hircaNewList, apparentCausesNew);
		// Scroll top
		Thread.sleep(1000);
		share2.scrollToTop(driver);
		Thread.sleep(1000);
		// Click on next
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
		// Verify that apparent cause answers correspond to new HiRCA level 3 list
		List<String> apparentCausesSelected = verifyApparentCausesAnswers(driver, apparentCausesNew); /* only step 1 */
		// Click on Step 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep3Tab)).click();
		/*
		 * Verify the new apparent causes answers And Get new apparent causes answers:
		 * remove unselected ones
		 */
		List<String> apparentCausesAnswersNew = verifyModifiedStep3(driver, apparentCausesNew,
				step2ApparentCausesAnswers); /* full combined list */
		// Combine Apparent causes selected under step1 and step 2 for veryfing in step
		// 3/4 and reports
		List<String> apparentCausesForStep3_modified = op2
				.combineApparentCausesFromStep1AndStep2(apparentCausesSelected, step2ApparentCausesAnswers);
		System.out.println(apparentCausesForStep3_modified);
		// Verify order of apparent cause answers in Step 3
		verifyOrderOfApparentCauseAnswersInStep3(driver, apparentCausesForStep3_modified);
		// Select some checkboxes in Step 3 SURE
		HashMap<String, Integer> options = markSUREStep3(driver, apparentCausesAnswersNew);
		List<String> rootCauses = getRootCausesFromStep3(driver, options, 1, apparentCausesAnswersNew.size());
		List<String> contributingFactors = getRootCausesFromStep3(driver, options, 0, apparentCausesAnswersNew.size());
		// Click skip or next
		clickNextSkip(driver);
		// Mark HML for all apparent causes answers
		HashMap<String, String> hml = markHML(driver, options, apparentCausesAnswersNew,
				apparentCausesForStep3_modified, rootCauses, contributingFactors);
		// Click skip or next
		clickNextSkip(driver);
		// Step 5 click next/skip
		clickNextSkip(driver);
		// Scroll to top
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		// Clicks on save button
		jse.executeScript("return document.getElementById('efi-opa-button-save').click();");
		// Verify save pop up
		op2.verifySavePopup(driver, softly);
		// Clicks on save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavePopupTitle));
		jse.executeScript("return document.getElementById('pii-opa-dialog-confirmed').click();");
		// Verify save sticky
		op2.verifyStickySaveReport(driver, softly, username, eirca2.textCreate(driver), 0);
		// Clicks on Info tab
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoTab)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoTab)));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoTab)).click();
		// Creates the expected name of record
		String creationDate = driver.findElement(opirca.OPiRCAReportCreationDateTimeField).getAttribute("value").trim();
		String name = creationDate + "_" + username + "_" + ev1;
		System.out.println("Expected name of record: " + name);
		// Click on saved activities
		jse.executeScript("return document.getElementById('efi-opa-btn-savedactivities').click();");
		Thread.sleep(3000);
		// Clicks on O&P IRCA side panel
		jse.executeScript("return document.getElementById('pii-user-home-panel-btn-opa').click();");
		WebElement record = driver.findElement(opirca.OPiRCAFirstRecord);
		String recordName = record.getText().trim();
		if (record.isDisplayed()) {
			System.out.println("Record found: " + recordName);
		} else
			System.out.println("Record not found.");
		String r1 = recordName.replaceAll("\u00AD", "");
		softly.assertThat(name).as("test data").isEqualTo(r1);
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		// Clicks on first newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).click();
		// Wait for loading message to disappear
		share2.loadingServer(driver);
		// Verify Apparent Causes in HTML
		// verifyHTML(driver,hircaNewList,apparentCausesNew,apparentCausesAnswersNew,hml,options,apparentCausesSelected,
		// step2QuestionAnswers,step2ApparentCausesAnswers);
		// Open report
		openReport(driver, r1);
		// verify the report rename save popup overflow text
		op3.verifySavePopupAfterRename(driver, softly);
		// Download report
		downloadSelectFunction(driver, hircaNewList, apparentCausesNew, apparentCausesAnswersNew, hml, options,
				step2QuestionAnswers);
		Thread.sleep(2000);
		return r1;
	}

	public void deleteFiles(File folder) throws IOException {
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				String fileName = file.getName();
				boolean del = file.delete();
				System.out.println(fileName + " : got deleted ? " + del);
			} else if (file.isDirectory()) {
				deleteFiles(file);
			}
		}
	}

	public void downloadSelectFunction(WebDriver driver, List<String> hircaNewList, List<String> apparentCausesNew,
			List<String> apparentCausesAnswersNew, HashMap<String, String> hml, HashMap<String, Integer> options,
			List<String> step2) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		// Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		if (browserName.toLowerCase().contains("safari") == false) {
			// deletes files in reports folder before starting to download
			File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
			deleteFiles(file);
		}
		// Download report to check pdf
		if (browserName.equals("chrome"))
			downloadRecordChrome(driver, hircaNewList, apparentCausesNew, apparentCausesAnswersNew, hml, options,
					step2);
		if (browserName.equals("firefox"))
			downloadRecordFirefox(driver, hircaNewList, apparentCausesNew, apparentCausesAnswersNew, hml, options,
					step2);
		if (browserName.equals("internet explorer")) {
			if (v.startsWith("10"))
				downloadRecordIE10(driver, hircaNewList, apparentCausesNew, apparentCausesAnswersNew, hml, options,
						step2);
			if (v.startsWith("11"))
				downloadRecordIE11(driver, hircaNewList, apparentCausesNew, apparentCausesAnswersNew, hml, options,
						step2);
		}
		if (browserName.toLowerCase().contains("safari")) {
			// Clicks on first newly created record
			wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).click();
			// Wait for loading message
			share2.loadingServer(driver);
			driver.switchTo().defaultContent();
		}
		// Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
	}

	public int getCharCountFromTitle(WebDriver driver) throws Exception {

		// Get count of characters
		String s = driver.findElement(opirca.OPiRCATitleCharacterCount).getText().trim();
		s = s.substring(1, s.indexOf("/"));
		int count = Integer.parseInt(s);
		System.out.println(s + " " + count);
		return count;
	}

	public int getTotalCountFromTitle(WebDriver driver) throws Exception {

		// Get count of characters
		String s = driver.findElement(opirca.OPiRCATitleCharacterCount).getText();
		s = s.substring((s.indexOf("/") + 1), s.indexOf(")"));
		int count = Integer.parseInt(s);
		System.out.println(s + " " + count);
		return count;
	}

	public void checkTitleCountReset(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		// Enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAEventTitleField)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAEventTitleField)).sendKeys("aaaa");
		// Get count
		int count = getCharCountFromTitle(driver);
		if (count != 4)
			softly.fail("Count did not match: aaaa: " + count);
		// Clear text
		for (int i = 0; i < 4; i++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAEventTitleField))
					.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(250);
		}
		count = getCharCountFromTitle(driver);
		if (count != 1)
			softly.fail("Count did not match: aaaa: " + count);
	}

	public String reportCreate(WebDriver driver, String username) throws Exception {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String text = eirca2.textCreate(driver);
		// Clicks on O&P IRCA
		jse.executeScript("return document.getElementById('pii-a-menu-opirca').click();");
		// Verify new report pop up
		op2.verifyNewReportPopup(driver, softly);
		// Verify Error Messages for mandatory fields on Info page
		op2.verifyErrorMessagesInfoPage(driver, softly);
		// Check title count reset when characters are entered and deleted
//		checkTitleCountReset(driver);
		// Fills the mandatory fields
		// tbr.sizeCheck(driver, opirca.OPiRCAEventTitleField, softly);
		driver.findElement(opirca.OPiRCAEventTitleField).sendKeys(text);
		// Get count
		int count = getCharCountFromTitle(driver);
		int total = getTotalCountFromTitle(driver);
		for (int i = count + 1; i <= total; i++) {
			driver.findElement(opirca.OPiRCAEventTitleField).sendKeys("z");
		}
		// tbr.sizeCheck(driver, opirca.OPiRCAEventLocationField, softly);
		driver.findElement(opirca.OPiRCAEventLocationField).sendKeys(text);
		tbr.sizeCheck(driver, opirca.OPiRCAProblemStatementField, softly);
		driver.findElement(opirca.OPiRCAProblemStatementField).sendKeys(text);
//		tbr.sizeCheck(driver, opirca.OPiRCATimelineOfEventField, softly);
//		driver.findElement(opirca.OPiRCATimelineOfEventField).sendKeys(text);
		tbr.sizeCheck(driver, opirca.OPiRCABackgroundInfoField, softly);
		driver.findElement(opirca.OPiRCABackgroundInfoField).sendKeys(text);
		tbr.sizeCheck(driver, opirca.OPiRCAInvestigatorsField, softly);
		driver.findElement(opirca.OPiRCAInvestigatorsField).sendKeys(text);
		String ev1 = driver.findElement(opirca.OPiRCAEventTitleField).getAttribute("value").trim();
		String ev2 = driver.findElement(opirca.OPiRCAEventLocationField).getAttribute("value").trim();
		String ev3 = driver.findElement(opirca.OPiRCAProblemStatementField).getAttribute("value").trim();
//		String ev4 = driver.findElement(opirca.OPiRCATimelineOfEventField).getAttribute("value").trim();
		String ev5 = driver.findElement(opirca.OPiRCABackgroundInfoField).getAttribute("value").trim();
		String ev6 = driver.findElement(opirca.OPiRCAInvestigatorsField).getAttribute("value").trim();
		/*
		 * if ((ev1.equals(text)==false)) {
		 * driver.findElement(opirca.OPiRCAEventTitleField).clear();
		 * driver.findElement(opirca.OPiRCAEventTitleField).sendKeys(text); }
		 */
		if ((ev2.equals(text) == false)) {
			driver.findElement(opirca.OPiRCAEventLocationField).clear();
			driver.findElement(opirca.OPiRCAEventLocationField).sendKeys(text);
		}
		if ((ev3.equals(text) == false)) {
			driver.findElement(opirca.OPiRCAProblemStatementField).clear();
			driver.findElement(opirca.OPiRCAProblemStatementField).sendKeys(text);
		}
		/*
		 * if ((ev4.equals(text)==false)) {
		 * driver.findElement(opirca.OPiRCATimelineOfEventField).clear();
		 * driver.findElement(opirca.OPiRCATimelineOfEventField).sendKeys(text); }
		 */
		if ((ev5.equals(text) == false)) {
			driver.findElement(opirca.OPiRCABackgroundInfoField).clear();
			driver.findElement(opirca.OPiRCABackgroundInfoField).sendKeys(text);
		}
		if ((ev6.equals(text) == false)) {
			driver.findElement(opirca.OPiRCAInvestigatorsField).clear();
			driver.findElement(opirca.OPiRCAInvestigatorsField).sendKeys(text);
		}
		// Verify no errors
		op2.verifyNoErrorsOnInfoPage(driver);
		// Step1 and KALE-1838
		return pathOPiRCA(driver, username, ev1);
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}