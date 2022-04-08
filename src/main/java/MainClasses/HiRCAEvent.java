import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kaleTestSoftware.*;
import kaleTestSoftware.ErrorMeter3;
import kaleTestSoftware.HiRCA2;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAEvent {

	TextBoxResizing tbr = new TextBoxResizing ();
	EiRCA2 eirca2 = new EiRCA2();
	EiRCAPageObj eirca = new EiRCAPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	ShareCheck3 share3 = new ShareCheck3();
	ErrorMeter3 em3 = new ErrorMeter3 ();
	HiRCAObj hirca = new HiRCAObj();
	HiRCA2 hc2 = new HiRCA2();

	SoftAssertions softly = new SoftAssertions();
	public String reason1="I think I will buy the red car, or I will lease the blue one.";
	public String paragraph_investigators = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eu lorem sapien. Donec molestie ligula nec diam mollis scelerisque ac et orci. Phasellus facilisis urna quis nibh faucibus, quis vestibulum nunc fringilla. Sed efficitur elit a nulla ultrices, at cursus ligula pharetra. Ut sollicitudin libero in nunc iaculis, ac mollis eros finibus. Nam iaculis pretium augue, vel tristique ligula sodales id. Maecenas sit amet tellus lobortis, pellentesque urna non, rutrum ante. Etiam enim quam, porta vel iaculis tincidunt, feugiat in nisl.@#$%&*()"
			+"\n"
			+"Donec gravida ante congue orci dictum, ut pretium velit elementum. Aliquam mattis sapien ut felis consequat tempor. Integer eget justo libero. Etiam hendrerit massa odio, non scelerisque leo fringilla nec. Curabitur ac magna dolor. Suspendisse mi nisi, dictum non dolor sit amet, venenatis tempor ipsum. Praesent maximus mauris tortor, ut hendrerit est pulvinar vitae. Aenean vel justo dignissim, scelerisque urna ultricies, hendrerit magna. Etiam elementum accumsan turpis ut efficitur. Aliquam luctus, nulla eget faucibus fermentum, tortor eros dignissim ante, vitae fermentum tellus ligula consectetur ligula. Etiam sagittis nisl mi, sit amet scelerisque eros venenatis sit amet. Fusce facilisis nisl nunc, eu euismod dui tristique nec. Donec lorem enim, sodales eu sem in, feugiat varius nunc. Phasellus cursus laoreet sapien, ac posuere tortor!?:;"
			;
	public String paragraph_background= "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
			+"\n"+"\n"
			+"Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. The Apache FontBox library is an open source Java tool to obtain low level information from font files. FontBox is a subproject of Apache PDFBox. The Apache PDFBox library is an open source Java tool for working with PDF documents. This artefact contains commandline tools using Apache PDFBox."
			;
	public String paragraph_timeline = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for lorem ipsum will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose. I have a house."
			+"\n"+"\n"
			+"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The Apache PDFBox library is an open source Java tool for working with PDF documents. This artefact contains examples on how the library can be used."
			;
	public String paragraph_problem = "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it."
			+"\n"+"\n"
			+"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted."
			;
	public String text = "As it currently stands, this question is not a good fit for our Q&A format. We expect answers to be supported by facts.";
	public String executive= "According to the 1993 Israel-Palestinian peace accords, the final status of Jerusalem is meant to be discussed in the latter stages of peace talks.";
	public String event_id="Its a small world after all";
	public String text184 = "This list looks quite big but the setup is quite easy but time-consuming and once you are done with setup next time it will hardly take two min to start you.";

	public void deleteNewRecord(WebDriver driver, String recordName) throws Exception{	  

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Wait for loading message to disappear
		HiRCA2 obj1 = new HiRCA2();
		share2.loadingServer(driver);
		//Clicks on new record
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on delete button
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[3]"))));
		//Verify delete popup
		obj1.verifyDeleteReportPopup(driver, softly, recordName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
		//Clicks on delete report
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))));
		obj1.verifyStickyDeleteReport(driver, softly, recordName);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Verify record deleted
		//Get name of 1st record
		String name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).getText();
		System.out.println(name);
		if (name!=recordName)
			System.out.println("Record deleted "+name);
		else
			System.out.println("Record could not be deleted");
		while(true)
		{
			try{
				if (driver.findElement(By.className("sticky-note")).isDisplayed())
				{
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();

				}}catch (NoSuchElementException e)
			{
					break;
			}
			catch( StaleElementReferenceException f)
			{

				break;
			}
			catch (org.openqa.selenium.TimeoutException u)
			{
				break;
			}
			catch (org.openqa.selenium.JavascriptException o)
			{
				Thread.sleep(3000);
				break;
			}
		}

	}

	public void saveFourthReportCheckImages(WebDriver driver, String username, String password, Login obj, int f, String recordName, String reportTitle) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		HiRCA2 obj2 = new HiRCA2();
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		Thread.sleep(2000);
		Actions act = new Actions (driver);
		//Logout
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
		act.click(element).build().perform();
		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button")));
		act.click(element).build().perform();
		if(f==1)
			driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//Login
		obj.LoginUser(driver, username, password);
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
		//Wait for loading message to disappear		  
		share2.loadingServer(driver);
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Click on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear		  
		share2.loadingServer(driver);
		//Click on Open button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))));
		//Verify open pop up
		obj2.verifyOpenReportPopup(driver, softly, recordName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		//Clicks on open report
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))));
		//Clicks on Info tab
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();
		//Changes the event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys("changed title thrice");
		//Clicks on Save
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		//verify the popup overflow text
		obj2.verifySavePopupAfterRename(driver, softly);
		//Save pop verify
		obj2.verifySavePopup(driver, softly);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));
		//Verify save sticky
		obj2.verifyStickySaveReport(driver, softly, username, "changed title thrice", 0);
		Thread.sleep(1000);
		//Verify sticky image saved successfully
		obj2.verifySticky5ImageUploaded(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(2000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Scroll down and check for 5 images uploaded
		checkImagesPresentAfterReportNameChange(driver);
		String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		String newRecord=creationDate + "_"+username+"_"+ "changed title thrice";
		System.out.println(newRecord);
		share2.scrollToTop(driver);
		//Clicks on Saved activities
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		Thread.sleep(2000);
		//call delete function and delete the record also before deleting compare the record name if correct record is getting deleted
		deleteNewRecord(driver, newRecord);
	}

	public void saveThirdReportCheckImages(WebDriver driver, String username, String password, Login obj,int f, String recordName, String reportTitle) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		HiRCA2 obj2 = new HiRCA2();
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		Thread.sleep(2000);
		Actions act = new Actions (driver);
		//Logout
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
		act.click(element).build().perform();
		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button")));
		act.click(element).build().perform();
		if(f==1)
			driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//Login
		obj.LoginUser(driver, username, password);
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Click on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on Open button
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))).click();
		//Verify open pop up
		obj2.verifyOpenReportPopup(driver, softly, recordName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		//Clicks on open report
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Clicks on Info tab
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();
		//Changes the event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys("changed title twice");
		//Clicks on Save
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Save pop verify
		obj2.verifySavePopup(driver, softly);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));
		//Verify save sticky
		obj2.verifyStickySaveReport(driver, softly, username, "changed title twice", 0);
		Thread.sleep(1000);
		//Verify sticky image saved successfully
		obj2.verifySticky5ImageUploaded(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(2000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Scroll down and check for 5 images uploaded
		checkImagesPresentAfterReportNameChange(driver);
		String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		String newRecord=creationDate + "_"+username+"_"+ "changed title twice";
		System.out.println(newRecord);
		share2.scrollToTop(driver);
		//Clicks on Saved activities
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		Thread.sleep(2000);
		saveFourthReportCheckImages(driver, username, password, obj,f,newRecord,reportTitle);
		//call delete function and delete the record also before deleting compare the record name if correct record is getting deleted
		deleteNewRecord(driver, newRecord);
	}

	public void checkImagesPresentAfterReportNameChange(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		for (int i=0;i<=4;i++)
		{
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+i))));
			if(browserName.contains("safari"))
			{
				String file = "pii-irca-event-file-"+i;
				while(true)
				{
					jse.executeScript("document.getElementById('pii-irca-event-filecollapsible-header-"+i+"').focus();");
					jse.executeScript("arguments[0].click();", driver.findElement(By.id("pii-irca-event-filecollapsible-header-"+i)));
					if(driver.findElement(By.id(file)).isDisplayed())
						break;
				}	
				//Checks for image
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+i)));
				Thread.sleep(2000);		
			}
			else
			{
				//Clicks on collapsible
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))));
	//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-"+i))).click();
				//Checks for image
				jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+i))));
	//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-"+i)));
				Thread.sleep(2000);
				//Clicks on collapsible again
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-filecollapsible-"+i+"']/h4/a"))).click();
			}
		}
	}

	public void saveNewReport(WebDriver driver, String username, String password, Login obj,int f, String recordName, String reportTitle) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		HiRCA2 obj2 = new HiRCA2();
		//Clicks on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		Thread.sleep(2000);
		Actions act = new Actions (driver);
		//Logout
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname")));
		act.click(element).build().perform();
		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-signout-button")));
		act.click(element).build().perform();
		if(f==1)
			driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//Login
		obj.LoginUser(driver, username, password);
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		Thread.sleep(5000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Click on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Open button
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))).click();
		//Verify open pop up
		obj2.verifyOpenReportPopup(driver, softly, recordName);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		//Clicks on open report
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))));
		//Clicks on Info tab
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();
		//Changes the event title
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).clear();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys("changed title");
		//Clicks on Save
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		//Save pop verify
		obj2.verifySavePopup(driver, softly);
		//Clicks on Save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));
		//Verify save sticky
		obj2.verifyStickySaveReport(driver, softly, username, "changed title", 0);
		Thread.sleep(1000);
		//Verify sticky image saved successfully
		obj2.verifySticky5ImageUploaded(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(2000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Scroll down and check for 5 images uploaded
		checkImagesPresentAfterReportNameChange(driver);
		Thread.sleep(1000);
		String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		String newRecord=creationDate + "_"+username+"_"+ "changed title";
		System.out.println(newRecord);
		share2.scrollToTop(driver);
		//Clicks on Saved activities
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		Thread.sleep(2000);
		saveThirdReportCheckImages(driver, username, password, obj,f,newRecord,reportTitle);
		//call delete function and delete the record also before deleting compare the record name if correct record is getting deleted
		deleteNewRecord(driver, newRecord);
	}

	public void openReport(WebDriver driver, String recordName) throws Exception{

		HiRCA2 obj = new HiRCA2();
		//Clicks on Open button
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))).click();
		//Verify open pop up
		obj.verifyOpenReportPopup(driver, softly, recordName);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		//Clicks on open report
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))));
		//Clicks on Save
		jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		//Save pop verify
		obj.verifySavePopup(driver, softly);
		//Clicks on Save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		Thread.sleep(1000);
		//Clicks on Saved activities
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		Thread.sleep(2000);
		share2.loadingServer(driver);
	}


	public void downloadRecordChrome (WebDriver driver, String get_date, String get_time, String get_dept, String creationDate) throws Exception {

		//deletes files in reports folder before starting to download
		/*File file = new File("C://Users//mama//Pictures//");
		deleteFiles(file);*/
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String url = driver.getCurrentUrl();
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		String window = driver.getWindowHandle();
		//Clicks on download button
		jse.executeScript("arguments[0].scrollIntoView(true);", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Verify pdf pop up
		eirca2.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify download pop up
		eirca2.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		Thread.sleep(300);
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/ChromSavePDF5_amlocal.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("AutoItScript -SaveReport result: Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("AutoItScript -SaveReport result: No unexpected alert");
		}
//		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\ChromSavePDF5_amlocal.exe");
		/*am_not applicable
		List<String> results = new ArrayList<String>();
		File[] files = new File("C://Users//mama//Downloads//EFTestDownloadReports//").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		for (File file1 : files) {
			if (file1.isFile()) {
				results.add(file.getName());
			}
		}
		System.out.println(results.get(0));
		if(results.get(0).endsWith(".pdf")==false)
		{
			for(String winHandle : driver.getWindowHandles()){
				driver.switchTo().window(winHandle);
			}
			driver.close();
			driver.switchTo().window(window);
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(8000);
		}
		*/
//		pdfCheck(get_date,get_time,get_dept,creationDate,url);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);
	}


	public void downloadRecordFirefox(WebDriver driver,  String get_date, String get_time, String get_dept, String creationDate) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String url = driver.getCurrentUrl();
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Verify pdf pop up
		eirca2.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		eirca2.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
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
		Thread.sleep(4000);/*
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("viewerContainer"))).sendKeys(Keys.chord(Keys.CONTROL + "s"));
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Process p= Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/PDFReportFirefox.exe");
		p.waitFor();*/
		pdfCheck(get_date,get_time,get_dept,creationDate,url);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();


	}

	public void downloadRecordIE10(WebDriver driver,  String get_date, String get_time, String get_dept, String creationDate) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String url = driver.getCurrentUrl();
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		Thread.sleep(2000);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Verify pdf pop up
		eirca2.verifyStickyCreatePDF(driver, softly);
		Thread.sleep(3000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		eirca2.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert for picture 2");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert for picture 2");
		}
		Thread.sleep(7000);
		List<String> results = new ArrayList<String>();
		File[] files = new File("C://Users//mama//Downloads//EFTestDownloadReports//").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		for (File file1 : files) {
			if (file1.isFile()) {
				results.add(file.getName());
			}
		}
		System.out.println(results.get(0));
		if(results.get(0).endsWith(".pdf")==false)
		{
			deleteFiles(file);
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title")));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(4000);
			try {
				Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
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
		pdfCheck(get_date,get_time,get_dept,creationDate,url);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);				    		    	
	}


	public void downloadRecordIE11(WebDriver driver,  String get_date, String get_time, String get_dept, String creationDate) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String url = driver.getCurrentUrl();
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Verify pdf pop up
		eirca2.verifyStickyCreatePDF(driver, softly);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Verify download pop up
		eirca2.verifyDownloadReportPopup(driver, softly);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(4000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(8000);
		//pdf verification
		pdfCheck(get_date,get_time,get_dept,creationDate,url);
		Thread.sleep(4000);
		//Close pdf
		//Switch to window    	
		driver.switchTo().window(window);			    		    	
	}


	public List<RenderedImage> getImagesFromPDF(PDDocument document) throws IOException {
		List<RenderedImage> images = new ArrayList<>();
		for (PDPage page : document.getPages()) {
			images.addAll(getImagesFromResources(page.getResources()));
		}

		return images;
	}

	private List<RenderedImage> getImagesFromResources(PDResources resources) throws IOException {
		List<RenderedImage> images = new ArrayList<>();

		for (COSName xObjectName : resources.getXObjectNames()) {
			PDXObject xObject = resources.getXObject(xObjectName);

			if (xObject instanceof PDFormXObject) {
				images.addAll(getImagesFromResources(((PDFormXObject) xObject).getResources()));
			} else if (xObject instanceof PDImageXObject) {
				images.add(((PDImageXObject) xObject).getImage());
			}
		}

		return images;
	}

	public void pdfCheck( String get_date, String get_time, String get_dept, String creationDate, String url) throws Exception{

		List<String> results = new ArrayList<String>();
		//Gets the file name which has been downloaded
		File[] files = new File("C://Users//mama//Downloads//EFTestDownloadReports//").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		for (File file : files) {
			if (file.isFile()) {
				results.add(file.getName());
			}
		}
		System.out.println(results.get(0));
		//Loads the file to check if correct data is present
		String fileName="C://Users//mama//Downloads//EFTestDownloadReports//"+results.get(0);
		File oldfile = new File(fileName);
		//Checks number of images in pdf
		PDDocument pddoc= PDDocument.load(oldfile);
		List<RenderedImage> images = new ArrayList<>();
		images=getImagesFromPDF(pddoc);
		System.out.println("Number of images: "+images.size());
		softly.assertThat(images.size()).as("test data").isEqualTo(10);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		String newData1="";
		for (int i = 0; i < ans.size(); i++)
		{

			//System.out.println(ans.get(i));
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData1 = newData1+ans.get(i);
			if (ans.get(i).charAt(n)!=' ')
				newData1 = newData1+" "+ans.get(i);

		}
		String newData=newData1.replace("  ", " ");/*
		String newData3 = newData2.replaceAll("<??br>", "");
		String newData = newData3.replaceAll("[]", "");*/
		// System.out.println(newData);
		//Verifies event id
		event_id=event_id.replace("  ", " ");
		softly.assertThat(event_id).as("test data").isSubstringOf(newData);
		//Verifies title
		text184=text184.replace("  ", " ");
		softly.assertThat("Event title "+text184).as("test data").isSubstringOf(newData);
		//Verifies location of event
		text=text.replace("  ", " ");
		softly.assertThat(text).as("test data").isSubstringOf(newData);
		//Verifies investigators data
		paragraph_investigators=paragraph_investigators.replace("\n", "");
		paragraph_investigators=paragraph_investigators.replace("  ", " ");
		softly.assertThat("Investigators"+paragraph_investigators).as("test data").isSubstringOf(newData);
		//Verifies background data
		paragraph_background=paragraph_background.replace("\n", "");
		paragraph_background=paragraph_background.replace("  ", " ");
		softly.assertThat("Background information"+paragraph_background).as("test data").isSubstringOf(newData);
		//Verifies Timeline data
		paragraph_timeline=paragraph_timeline.replace("\n", "");
		paragraph_timeline=paragraph_timeline.replace("  ", " ");
		softly.assertThat("Timeline of event"+paragraph_timeline).as("test data").isSubstringOf(newData);
		//Verifies Problem statement
		paragraph_problem=paragraph_problem.replace("\n", "");
		paragraph_problem=paragraph_problem.replace("  ", " ");
		softly.assertThat("Problem statement"+paragraph_problem).as("test data").isSubstringOf(newData);
		//Verifies date
		softly.assertThat(get_date).as("test data").isSubstringOf(newData);
		//Verifies time
		softly.assertThat(get_time).as("test data").isSubstringOf(newData);
		//Verifies Department
		softly.assertThat(get_dept).as("test data").isSubstringOf(newData);
		//Verfies creation date
		softly.assertThat(creationDate).as("test data").isSubstringOf(newData);
		//Verifies executive summary
		executive=executive.replace("  ", " ");
		softly.assertThat(executive).as("test data").isSubstringOf(newData);
		//Verifies supporting reason in act of nature
		reason1=reason1.replace("  ", " ");
		softly.assertThat(reason1).as("test data").isSubstringOf(newData);
		//Verifies HiRCA self checklist
		softly.assertThat("General").as("test data").isSubstringOf(newData);
		softly.assertThat("All involved parties interviewed and all relevant data collected?").as("test data").isSubstringOf(newData);
		softly.assertThat("Past similar events examined?").as("test data").isSubstringOf(newData);
		softly.assertThat("Triggering event and related LOPs identified?").as("test data").isSubstringOf(newData);
		softly.assertThat("Triggering Event").as("test data").isSubstringOf(newData);
		softly.assertThat("Error type involving the triggering event determined?").as("test data").isSubstringOf(newData);
		softly.assertThat("Any equipment failure (if any) involving in the triggering event investigated for its triggering errors?").as("test data").isSubstringOf(newData);
		softly.assertThat("Contributing factors determined?").as("test data").isSubstringOf(newData);
		softly.assertThat("Root Causes").as("test data").isSubstringOf(newData);
		softly.assertThat("Root causes meeting SUEP").as("test data").isSubstringOf(newData);
		softly.assertThat("criteria?").as("test data").isSubstringOf(newData);
		softly.assertThat("Root causes surviving the CHOP'N").as("test data").isSubstringOf(newData);
		softly.assertThat("challenge?").as("test data").isSubstringOf(newData);
		softly.assertThat("Levels of importance for root causes identified?").as("test data").isSubstringOf(newData);
		softly.assertThat("Corrective Actions").as("test data").isSubstringOf(newData);
		softly.assertThat("Recommended corrective actions covering all root causes and contributing factors?").as("test data").isSubstringOf(newData);
		softly.assertThat("Recommended corrective actions cost effective?").as("test data").isSubstringOf(newData);
		//Verifies for Root Cause
		softly.assertThat("1.1 Was the triggering event a human error, an equipment failure, or an act of nature? Act of nature").as("test data").isSubstringOf(newData);
		softly.assertThat("1.2 What was the type of human error? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.3 For a rule-based error, was the error intentional or unintentional? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.4 Was the unintentional error related to inattention-to-detail behavior or inadequate rules? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.5 If I were the error-maker, would I make the same error? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.6 When the error-maker violated the established standards or policies, was there other staff looking on? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.7 Could the error have been prevented by self check or independent check? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.8 Was the error-maker trained to manage error-prone mental states and high risk situations? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.9 Was the error-maker held accountable after the event by his or her supervisor or by management? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.10 If a PJB (or PSM, TO, MJB) was held, why was the participant not aware so that he or she could mitigate the risk? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.11 Why did this error occur now, and not before? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.12 If PJB (or PSM, TO, MJB) was not performed, why? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.13 Was the error contributed to by error-prone mental states and/ or high-risk situations? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.14 Did the supervisor conduct routine meetings to discuss lessons learned? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.15 Did the event involve a single-point-vulnerability item? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.16 Was the error related to inadequate supervision? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.17 Did inadequate management by the manager contribute to this error? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.18 Was the error caused by incorrect rules? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.19 Was there a rising trend of similar errors? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("1.20 Was the error contributed to by changes during jobs? n/a n/a").as("test data").isSubstringOf(newData);
		//Verify LOP failure inquiry
		softly.assertThat("Were there LOPs in place to prevent the triggering event? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("2.21 What LOPs can prevent this event from happening? n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("2.22 Was HiRCA").as("test data").isSubstringOf(newData);
		softly.assertThat("adequate in leading this investigation? n/a n/a").as("test data").isSubstringOf(newData);
		//Verify SUEP
		softly.assertThat("Contributing factor(s) S U E P n/a n/a n/a n/a n/a").as("test data").isSubstringOf(newData);
		softly.assertThat("(SUEP) S: Substandard Practice? U: Under Management Control? E: Early in Event Sequence? P: Prevention Of Recurrence?").as("test data").isSubstringOf(newData);
		//Verify Missing LOPS
		softly.assertThat("Missing LOPs No missing LOPs specified").as("test data").isSubstringOf(newData);
		pddoc.close();	      
	}

	public void deleteFiles(File folder) throws IOException {
		File[] files = folder.listFiles();
		for(File file: files){
			if(file.isFile()){
				String fileName = file.getName();
				boolean del= file.delete();
				System.out.println(fileName + " : got deleted ? " + del);
			}else if(file.isDirectory()) {
				deleteFiles(file);
			}
		}
	}

	public void shareReport(WebDriver driver,String username, String password1,int y ) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String sharer = em3.decideSharer (y);
		String sharerAdded = em3.decideSharerAdded (y);
		//Switches to the iframe
		wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("pii-iframe-main"));
		share2.scrollToTop(driver);
		//Clicks on share button
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[4]"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[4]"))));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[4]"))).click();
		//Enters username
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-search-input"))).sendKeys(sharer);
		Thread.sleep(500);
		//Selects from dropdown
		WebElement dropdown = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div[2]/ul")));
		dropdown.findElement(By.cssSelector(".ui-first-child")).click();
		//Clicks on add user
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))));
		//Verifies user added
		String user=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhshare-blocks']/div/form/div/ul/li/a"))).getText();
		softly.assertThat(user).as("test data").isEqualTo(sharerAdded);
		share3.shareTwice (driver,softly,0);
		//Clicks on save
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-uhshare-save"))).click();
		//Verify share save sticky
		eirca2.verifyStickyShareSave(driver, softly);
		//Click back
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Share icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a/span[1]")));	
		//Calls the Share check function
		share.receiptReport(driver, sharer, username, password1);
		//Clicks on HiRCA side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();;
	}

	public void markCritical(WebDriver driver,String username, String password1,int y) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on mark critical
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		//Mark critical pop up
		eirca2.verifyMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Checks if marked critical		
		share2.loadingServer(driver);
		String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
		softly.assertThat(s).as("test data").contains("ui-checkbox-on");
		//Click back
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.BackButton)).click();
		share2.loadingServer(driver);
		//Verify Marked critical icon
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a/span[1]")));
		//Verify presence of shared icon 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a/span[2]")));
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		share2.loadingServer(driver);
		//Clicks on mark critical again
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).click();
		//Mark critical pop up
		eirca2.verifyUnMarkCriticalPopup(driver, softly);
		//Clicks on confirm change
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();		
		share2.loadingServer(driver);
		String s1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.MarkCritical)).getAttribute("class");
		softly.assertThat(s1).as("test data").contains("ui-checkbox-off");
		//Verify report not retrieved by shared to person
		String sharer = em3.decideSharer (y);
		share.checkCriticalNotification(driver, sharer, username, password1, softly);		
		//Clicks on HiRCA side panel
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
	}

	public void openCheckRecord(WebDriver driver, String username,  String get_date, String get_time, String get_dept, String creationDate) throws Exception{

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Checks for Event title data
		String eve_title =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr/td[2]"))).getText();
		softly.assertThat(eve_title).as("test data").isEqualTo(text184);
		//Checks for Date of event data
		String eve_date =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(eve_date).as("test data").isEqualTo(get_date);
		/*am_not applicable
		//Checks for Time of event data
		String eve_time =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[3]/td[4]"))).getText();
		softly.assertThat(eve_time).as("test data").isEqualTo(get_time);
		//Checks for Location of event data
		String eve_loc =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()[contains(.,'As it currently stands, this')]]"))).getText();
		softly.assertThat(eve_loc).as("test data").isEqualTo(text);
		//Checks for Department data
		String eve_dept =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(eve_dept).as("test data").isEqualTo(get_dept);
		*/
		
		//Checks for Investigators data
		String eve_inv =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[7]/td[2]"))).getText();
		/*String r = eve_inv.replaceAll("<??br>", "");
		String r1 = r.replaceAll("[]", "");*/
		if(browserName.contains("safari"))
			softly.assertThat(eve_inv).as("test data").isEqualTo(paragraph_investigators.replace("\n", ""));
		else
			softly.assertThat(eve_inv).as("test data").contains(paragraph_investigators);
		
		/*am_not applicable
		//Checks for Report creation date data
		String creation_date =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(creation_date).as("test data").isEqualTo(creationDate);
		*/
		//Checks for Problem statement data
		String eve_prob =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='pii-level45-table']//td[contains(text(),'But I must explain')]"))).getText();
		/*String r2 = eve_prob.replaceAll("<??br>", "");
		String r3 = r2.replaceAll("[]", "");*/
		if(browserName.contains("safari"))
			softly.assertThat(eve_prob).as("test data").isEqualTo(paragraph_problem.replace("\n", ""));
		else
			softly.assertThat(eve_prob).as("test data").isEqualTo(paragraph_problem);
		
		//Checks for Timeline of event data
		String eve_timeline =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[3]/td[2]"))).getText();
		/*String r4 = eve_timeline.replaceAll("<??br>", "");
		String r5 = r4.replaceAll("[]", "");*/
		if(browserName.contains("safari"))
			softly.assertThat(eve_timeline).as("test data").isEqualTo(paragraph_timeline.replace("\n", ""));
		else
			softly.assertThat(eve_timeline).as("test data").isEqualTo(paragraph_timeline);
		
		/*am_not applicable
		//Checks for Background information data
		String eve_back =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[4]/td[2]"))).getText();
		//String r6 = eve_back.replaceAll("<??br>", "");
		//String r7 = r6.replaceAll("[]", "");
		if(browserName.contains("safari"))
			softly.assertThat(eve_back).as("test data").isEqualTo(paragraph_background.replace("\n", ""));
		else
			softly.assertThat(eve_back).as("test data").isEqualTo(paragraph_background);
		//Check for creator
		String eve_creator =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(username).as("test data").isSubstringOf(eve_creator);
		System.out.println(eve_creator);
		//Check for Event id
		String eve_id= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(event_id).as("test data").isSubstringOf(eve_id);
		System.out.println(eve_id);
		//Check for Executive summary
		String eve_exec =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr/td[2]"))).getText();
		softly.assertThat(eve_exec).as("test data").isEqualTo(executive);
		*/
		/*am_not applicable
		//Verify the n/a in LOPs
		String lop1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[1]"))).getText();
		softly.assertThat(lop1).as("test data").isEqualTo("n/a");
		String lop2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[2]"))).getText();
		softly.assertThat(lop2).as("test data").isEqualTo("n/a");
		String lop3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[3]"))).getText();
		softly.assertThat(lop3).as("test data").isEqualTo("n/a");
		String lop4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr/td[1]"))).getText();
		softly.assertThat(lop4).as("test data").isEqualTo("n/a");
		String lop5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr/td[2]"))).getText();
		softly.assertThat(lop5).as("test data").isEqualTo("n/a");
		String lop6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr/td[3]"))).getText();
		softly.assertThat(lop6).as("test data").isEqualTo("n/a");
		String lop7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr/td"))).getText();
		softly.assertThat(lop7).as("test data").isEqualTo("No missing LOPs specified");
		
		//Verify root causes
		String rc1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(rc1).as("test data").isEqualTo("Act of nature");
		String rc2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(rc2).as("test data").isEqualTo(reason1);
		String rc3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(rc3).as("test data").isEqualTo("n/a");
		String rc4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(rc4).as("test data").isEqualTo("n/a");
		String rc5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(rc5).as("test data").isEqualTo("n/a");
		String rc6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(rc6).as("test data").isEqualTo("n/a");
		String rc7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(rc7).as("test data").isEqualTo("n/a");
		String rc8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(rc8).as("test data").isEqualTo("n/a");
		String rc9 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(rc9).as("test data").isEqualTo("n/a");
		String rc10 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(rc10).as("test data").isEqualTo("n/a");
		String rc11 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(rc11).as("test data").isEqualTo("n/a");
		String rc12 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(rc12).as("test data").isEqualTo("n/a");
		String rc13 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(rc13).as("test data").isEqualTo("n/a");
		String rc14 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(rc14).as("test data").isEqualTo("n/a");
		String rc15 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(rc15).as("test data").isEqualTo("n/a");
		String rc16 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(rc16).as("test data").isEqualTo("n/a");
		String rc17 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(rc17).as("test data").isEqualTo("n/a");
		String rc18 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(rc18).as("test data").isEqualTo("n/a");
		String rc19 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(rc19).as("test data").isEqualTo("n/a");
		String rc20 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(rc20).as("test data").isEqualTo("n/a");
		String rc21 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(rc21).as("test data").isEqualTo("n/a");
		String rc22 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(rc22).as("test data").isEqualTo("n/a");
		String rc23 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(rc23).as("test data").isEqualTo("n/a");
		String rc24 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(rc24).as("test data").isEqualTo("n/a");
		String rc25 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(rc25).as("test data").isEqualTo("n/a");
		String rc26 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(rc26).as("test data").isEqualTo("n/a");
		String rc27 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(rc27).as("test data").isEqualTo("n/a");
		String rc28 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(rc28).as("test data").isEqualTo("n/a");
		String rc29 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(rc29).as("test data").isEqualTo("n/a");
		String rc30 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(rc30).as("test data").isEqualTo("n/a");
		String rc31 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(rc31).as("test data").isEqualTo("n/a");
		String rc32 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(rc32).as("test data").isEqualTo("n/a");
		String rc33 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(rc33).as("test data").isEqualTo("n/a");
		String rc34 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(rc34).as("test data").isEqualTo("n/a");
		String rc35 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(rc35).as("test data").isEqualTo("n/a");
		String rc36 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(rc36).as("test data").isEqualTo("n/a");
		String rc37 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(rc37).as("test data").isEqualTo("n/a");
		String rc38 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(rc38).as("test data").isEqualTo("n/a");
		String rc39 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[2]"))).getText();
		softly.assertThat(rc39).as("test data").isEqualTo("n/a");
		String rc40 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(rc40).as("test data").isEqualTo("n/a");
		//Verify LOP failure inquiry
		String lop8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr/td[2]"))).getText();
		softly.assertThat(lop8).as("test data").isEqualTo("n/a");
		String lop9 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr/td[3]"))).getText();
		softly.assertThat(lop9).as("test data").isEqualTo("n/a");
		String lop10 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(lop10).as("test data").isEqualTo("n/a");
		String lop11 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(lop11).as("test data").isEqualTo("n/a");
		String lop12 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(lop12).as("test data").isEqualTo("n/a");
		String lop13 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(lop13).as("test data").isEqualTo("n/a");
		//Verify SUEP
		String rc41 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[1]"))).getText();
		softly.assertThat(rc41).as("test data").isEqualTo("n/a");
		String rc42 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[2]"))).getText();
		softly.assertThat(rc42).as("test data").isEqualTo("n/a");
		String rc43 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[3]"))).getText();
		softly.assertThat(rc43).as("test data").isEqualTo("n/a");
		String rc44 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[4]"))).getText();
		softly.assertThat(rc44).as("test data").isEqualTo("n/a");
		String rc45 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr/td[5]"))).getText();
		softly.assertThat(rc45).as("test data").isEqualTo("n/a");
		//Verify HiRCA checklist
		String rc46 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(rc46).as("test data").isEqualTo("General");
		String rc47 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(rc47).as("test data").isEqualTo("All involved parties interviewed and all relevant data collected?");
		String rc48 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(rc48).as("test data").isEqualTo("");
		String rc49 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(rc49).as("test data").isEqualTo("");
		String rc50 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(rc50).as("test data").isEqualTo("Past similar events examined?");
		String rc51 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(rc51).as("test data").isEqualTo("");
		String rc52 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(rc52).as("test data").isEqualTo("");
		String rc53 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(rc53).as("test data").isEqualTo("Triggering event and related LOPs identified?");
		String rc54 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(rc54).as("test data").isEqualTo("");
		String rc55 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(rc55).as("test data").isEqualTo("Triggering Event");
		String rc56 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(rc56.replace("   ", " ").replace("  ", " ")).as("test data").isEqualTo("Error type involving the triggering event determined?");
		String rc57 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(rc57).as("test data").isEqualTo("");
		String rc58 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(rc58).as("test data").isEqualTo("");
		String rc59 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(rc59).as("test data").isEqualTo("Any equipment failure (if any) involving in the triggering event investigated for its triggering errors?");
		String rc60 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(rc60).as("test data").isEqualTo("");
		String rc61 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(rc61).as("test data").isEqualTo("");
		String rc62 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(rc62).as("test data").isEqualTo("Contributing factors determined?");
		String rc63 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(rc63).as("test data").isEqualTo("");
		String rc64 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(rc64).as("test data").isEqualTo("Root Causes");
		String rc65 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(rc65).as("test data").contains("Root causes meeting SUEP");
		softly.assertThat(rc65).as("test data").contains(" criteria?");
		String rc66 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(rc66).as("test data").isEqualTo("");
		String rc67 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(rc67).as("test data").isEqualTo("");
		String rc68 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(rc68).as("test data").contains("Root causes surviving the CHOP'N");
		softly.assertThat(rc68).as("test data").contains(" challenge?");
		String rc69 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(rc69).as("test data").isEqualTo("");
		String rc70 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(rc70).as("test data").isEqualTo("");
		String rc71 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(rc71).as("test data").isEqualTo("Levels of importance for root causes identified?");
		String rc72 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(rc72).as("test data").isEqualTo("");
		String rc73 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(rc73).as("test data").isEqualTo("Corrective Actions");
		String rc74 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(rc74).as("test data").contains("Recommended corrective actions covering all root causes and contributing factors?");
		String rc75 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(rc75).as("test data").isEqualTo("");
		String rc76 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(rc76).as("test data").isEqualTo("");
		String rc77 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(rc77).as("test data").isEqualTo("Recommended corrective actions cost effective?");
		String rc78 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(rc78).as("test data").isEqualTo("");
		*/
		share2.scrollToAPoint(driver, 3300);
		Thread.sleep(2000);
		//int n =3500;
		//Checks the 5 images if appearing
		for (int j=0; j<5; j++){				  
		jse.executeScript("arguments[0].scrollIntoView(true);", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-h-event-report-filecollapsible-header-"+j))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-h-event-report-filecollapsible-header-"+j))));
		if(driver.findElement(By.id("pii-irca-h-event-report-file-img-"+j)).isDisplayed())
		{
			System.out.println("In HiRCA html report's Supporting file Image Title"+j+ "  is displayed");	
		}
		}
		//Checks the 5 images if appearing
		/*for (int j=0; j<5; j++)
		{				  
			//Click on Supporting file details
			Thread.sleep(500);
			String id = "pii-irca-h-event-report-filecollapsible-"+j;
			share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			if(browserName.contains("safari"))
			{
				while(true)
				{
					jse.executeScript("arguments[0].focus();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='"+id+"']/h4/a"))));
					jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='"+id+"']/h4/a"))));
					if(driver.findElement(By.xpath(".//*[@id='"+id+"']/div/div/table")).isDisplayed())
					{
						break;
					}
				}
			}
			else
			jse.executeScript("arguments[0].scrollIntoView(true);", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-h-event-report-filecollapsible-header-4"))));
			jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			*/
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			/*n=n+1200;
			String scroll ="scroll(0,"+n+")";
			jse.executeScript(scroll);*/
			/*
			String img = "pii-irca-h-event-report-file-img-"+j;
			share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(img))));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				System.out.println("Image "+ (j+1) + " is displayed");	

			}
		}*/
		Thread.sleep(1000);
		share2.scrollToTop(driver);
	}

	public void rootCause(WebDriver driver) throws Exception {

		WebDriverWait wait1 = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		
		/*am_below xpath not applicable
		//Clicks on next
		if(browserName.contains("safari"))
		{
			jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))));
			jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))));			
		}
		else
		{			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))).click();
		}
		*/
		//Clicks on next on Info page
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-controlgroup-controls ']/button[@type='submit']"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-controlgroup-controls ']/button[@type='submit']"))));
		//Clicks on skip button on Info Page:Sequence of Event
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(hirca.SkipButton)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(hirca.SkipButton)));
		//Click on Act of Nature
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))));
		//Verify the texts on the options
		String hum_err = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText();
		System.out.println(hum_err);
		softly.assertThat(hum_err).as("test data").isEqualTo("Human error");
		String eq_err = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText();
		System.out.println(eq_err);
		softly.assertThat(eq_err).as("test data").isEqualTo("Equipment failure");
		String nat_err = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText();
		System.out.println(nat_err);
		softly.assertThat(nat_err).as("test data").isEqualTo("Act of nature");
		String rc11 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		System.out.println(rc11);
		softly.assertThat(rc11).as("test data").contains("[1.1] Was the triggering event a human error, an equipment failure, or an act of nature?");
		//Enter data in reason entry
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason1);
		Thread.sleep(1000);
		//Click on garbage can
		hc2.clickOnTrashCan(driver);
		//Clicks on clear answers
		wait1.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(hirca.HiRCAPopupMessage));
		//Click on Act of Nature
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))));
		//Enter data in reason entry
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).sendKeys(reason1);
		//Click on next
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))));
		//Clicks on Root Cause
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))));
		Thread.sleep(2000);
		//Verify the n/a in LOPs
		String lop1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(lop1);
		softly.assertThat(lop1).as("test data").isEqualTo("n/a");
		String lop2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		System.out.println(lop2);
		softly.assertThat(lop2).as("test data").isEqualTo("n/a");
		String lop3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
		System.out.println(lop3);
		softly.assertThat(lop3).as("test data").isEqualTo("n/a");
		String lop4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[4]"))).getText();
		System.out.println(lop4);
		softly.assertThat(lop4).as("test data").isEqualTo("n/a");
		String lop5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[5]"))).getText();
		System.out.println(lop5);
		softly.assertThat(lop5).as("test data").isEqualTo("n/a");
		//Click on skip
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
		Thread.sleep(1000);
		//Verify the n/a in LOPs
		String lop6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(lop6);
		softly.assertThat(lop6).as("test data").isEqualTo("n/a");
		String lop7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		System.out.println(lop7);
		softly.assertThat(lop7).as("test data").isEqualTo("n/a");
		String lop8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
		System.out.println(lop8);
		softly.assertThat(lop8).as("test data").isEqualTo("n/a");
		//Click on skip
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
		Thread.sleep(1000);
		//Clicks on check boxes from top to bottom and unchecks them from bottom to top
		//Checks the check boxes
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]/div/input"))));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[3]/div/input"))).click();
		//Unchecks them all
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[3]/div/input"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]/div/input"))).click();
		//Click on skip
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))));
		Thread.sleep(1000);		  
	}

	public void uploadFiveImagesSafari(WebDriver driver, String username, String reportTitle) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		HiRCA2 obj1 = new HiRCA2();
		String filepath = "/Users/pamelachiu/Documents/Kale Case Test 1-20/Slide1.jpg";
		for (int j=0; j<5; j++)
		{
			//Click on Supporting file details
			Thread.sleep(500);
			String id = "pii-irca-event-filecollapsible-header-"+j;
			String file = "pii-irca-event-file-"+j;
			share2.scrollToElement(driver, driver.findElement(By.id(id)));			
			while(true)
			{
				jse.executeScript("document.getElementById('"+id+"').focus();");
				jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.elementToBeClickable(By.id(id))));
				if(driver.findElement(By.id(file)).isDisplayed())
					break;
			}
			//Uploads file
			WebElement l=driver.findElement(By.id(file));
			share2.scrollToElement(driver, l);
			l.sendKeys(filepath);
			String img = "pii-irca-event-file-img-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				//delete file
				String del = "pii-irca-event-file-remove-"+j;
				Thread.sleep(1000);
				share2.scrollToElement(driver, driver.findElement(By.id(del)));
				jse.executeScript("arguments[0].click();", driver.findElement(By.id(del))); 
				System.out.println("clicked for popup");
				//Delete file pop up
				obj1.verifyDeleteFilePopup(driver, softly, j+1);
				System.out.println("done with popup");
				share2.scrollToElement(driver, driver.findElement(hirca.HiRCAPopupConfirmButton));
				while (true)
				{
					jse.executeScript("document.getElementById('pii-irca-dialog-confirmed').focus();");
					jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));					
					try{
						wait.until(ExpectedConditions.invisibilityOfElementLocated(hirca.HiRCAPopupConfirmButton));
						break;
					}catch(org.openqa.selenium.TimeoutException t)
					{
						continue;
					}
				}
				if(j!=0)
				{
					share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-addnewfile-button")));
					jse.executeScript("arguments[0].click();", driver.findElement(By.id("pii-irca-addnewfile-button")));
					Thread.sleep(1000);
				}
				//Click on Supporting file details
				share2.scrollToElement(driver, driver.findElement(By.id(id)));
				while(true)
				{
					jse.executeScript("document.getElementById('"+id+"').focus();");
					jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.elementToBeClickable(By.id(id))));
					if(driver.findElement(By.id(file)).isDisplayed())
						break;
				}				
				//Fill title and description
				String title_id="pii-irca-event-file-title-"+j;
				jse.executeScript("document.getElementById('"+title_id+"').focus();");
				driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
				while(true)
				{    
					Thread.sleep(1000);
					String getTextFromBox = driver.findElement(By.id(title_id)).getAttribute("value");
					if(getTextFromBox.contains("Title0"+j))
						break;
					jse.executeScript("document.getElementById('"+title_id+"').focus();");
					driver.findElement(By.id(title_id)).clear();
					driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
				}
				String desc = "pii-irca-event-file-description-"+j;
				jse.executeScript("document.getElementById('"+desc+"').focus();");
				driver.findElement(By.id(desc)).sendKeys("Description0"+j);
				while(true)
				{
					Thread.sleep(1000);
					String getTextFromBox = driver.findElement(By.id(desc)).getAttribute("value");
					if(getTextFromBox.contains("Description0"+j))
						break;
					jse.executeScript("document.getElementById('"+desc+"').focus();");
					driver.findElement(By.id(desc)).clear();
					driver.findElement(By.id(desc)).sendKeys("Description0"+j);
				}				
				//re-upload file
				driver.findElement(By.id(file)).sendKeys(filepath);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
				Thread.sleep(2000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					//rotate file
					String rotate= "pii-irca-event-file-rotate-"+j;
					l=driver.findElement(By.id(rotate));
					share2.scrollToElement(driver, l);
					jse.executeScript("document.getElementById('"+rotate+"').focus();");
					jse.executeScript("arguments[0].click();",l);
				}
				Thread.sleep(2000);
				//Debug
				//Clicks on save without images
				share2.scrollToTop(driver);
				Thread.sleep(2000);
				//Clicks on Save
				share2.scrollToElement(driver, driver.findElement(By.id("efi-irca-button-save")));				
				jse.executeScript("document.getElementById('efi-irca-button-save').focus();");
				jse.executeScript("arguments[0].click();",driver.findElement(By.id("efi-irca-button-save")));
				//Save pop verify
				obj1.verifySavePopup(driver, softly);
				//Clicks on Save report
				jse.executeScript("document.getElementById('pii-irca-dialog-confirmed').focus();");
				jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));
				//Verify save sticky
				obj1.verifyStickySaveReport(driver, softly, username, reportTitle, 1);
				Thread.sleep(1500);
				obj1.verifySticky1ImageUploaded(driver,softly);
				//Wait for loading message to disappear
				share2.loadingServer(driver); 
				//jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(1000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					//Click on attach another file
					Thread.sleep(2000);
					WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
					share2.scrollToElement(driver, add);
					jse.executeScript("arguments[0].click();", add);
				}

			}
		}
		//Delete 3rd image
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))));
		jse.executeScript("document.getElementById('pii-irca-event-file-remove-2').focus();");
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))));
		jse.executeScript("document.getElementById('pii-irca-dialog-confirmed').focus();");
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));
		//Click on last collapsible
		share2.scrollToElement(driver, wait.until(ExpectedConditions.elementToBeClickable(By.id("pii-irca-event-filecollapsible-4"))));
		while(true)
		{
			jse.executeScript("document.getElementById('pii-irca-event-filecollapsible-header-4').focus();");
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(By.id("pii-irca-event-filecollapsible-header-4"))));
			if(driver.findElement(By.id("pii-irca-event-file-title-4")).isDisplayed())
				break;
		}	
		//Fill title and description
		jse.executeScript("document.getElementById('pii-irca-event-file-title-4').focus();");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-4"))).sendKeys("Title05");
		while(true)
		{
			Thread.sleep(1000);
			String getTextFromBox = driver.findElement(By.id("pii-irca-event-file-title-4")).getAttribute("value");
			if(getTextFromBox.contains("Title05"))
				break;
			jse.executeScript("document.getElementById('"+"pii-irca-event-file-title-4"+"').focus();");
			driver.findElement(By.id("pii-irca-event-file-title-4")).clear();
			driver.findElement(By.id("pii-irca-event-file-title-4")).sendKeys("Title05");
		}
		jse.executeScript("document.getElementById('pii-irca-event-file-description-4').focus();");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-description-4"))).sendKeys("Description05");
		while(true)
		{
			Thread.sleep(1000);
			String getTextFromBox = driver.findElement(By.id("pii-irca-event-file-description-4")).getAttribute("value");
			if(getTextFromBox.contains("Description05"))
				break;
			jse.executeScript("document.getElementById('"+"pii-irca-event-file-description-4"+"').focus();");
			driver.findElement(By.id("pii-irca-event-file-description-4")).clear();
			driver.findElement(By.id("pii-irca-event-file-description-4")).sendKeys("Description05");
		}
		//Upload image
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-button-4"))).sendKeys(filepath);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-4")));
		Thread.sleep(2000);
		//Clicks on save without images
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		//Clicks on Save
		jse.executeScript("document.getElementById('pii-irca-dialog-confirmed').focus();");
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage));
		jse.executeScript("document.getElementById('pii-irca-dialog-confirmed').focus();");
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.scrollToAPoint(driver, 2000);
	}

	public void uploadFiveImagesChrome(WebDriver driver, String username, String reportTitle) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		HiRCA2 obj1 = new HiRCA2();
		String filepath = "C:/Users/mama/Pictures/Upload/CCYC2355.JPG";
		//int n=500;
		for (int j=0; j<5; j++)
		{

			//Click on Supporting file details
			Thread.sleep(500);
			String id = "pii-irca-event-filecollapsible-"+j;
			share2.scrollToElement(driver, driver.findElement(By.id(id)));
			driver.findElement(By.id(id)).click();
			//Uploads file
			String file = "pii-irca-event-file-"+j;
			WebElement l=driver.findElement(By.id(file));
			//Actions act= new Actions(driver);
			//act.moveToElement(l).build().perform();
			l.sendKeys(filepath);
			String img = "pii-irca-event-file-img-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				//delete file
				String del = "pii-irca-event-file-remove-"+j;
				Thread.sleep(1000);
				driver.findElement(By.id(del)).click(); 			
				//Delete file pop up
				obj1.verifyDeleteFilePopup(driver, softly, j+1);
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
				if(j!=0)
				{
					share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-addnewfile-button")));
					driver.findElement(By.id("pii-irca-addnewfile-button")).click();
					Thread.sleep(1000);
					/*n=n+80;
					String scroll = "scroll(0,"+n+")";
					jse.executeScript(scroll);*/
				}
				//Click on Supporting file details
				share2.scrollToElement(driver, driver.findElement(By.id(id)));
				driver.findElement(By.id(id)).click();
				//Fill title and description
				String title_id="pii-irca-event-file-title-"+j;
				driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
				String desc = "pii-irca-event-file-description-"+j;
				driver.findElement(By.id(desc)).sendKeys("Description0"+j);
				//re-upload file
				driver.findElement(By.id(file)).sendKeys(filepath);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
				Thread.sleep(2000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					//rotate file
					String rotate= "pii-irca-event-file-rotate-"+j;
					l=driver.findElement(By.id(rotate));
					share2.scrollToElement(driver, l);
					//act.moveToElement(l).build().perform();
					//l.sendKeys(Keys.ARROW_DOWN);
					//l.sendKeys(Keys.ARROW_DOWN);
					/*for(int r=0;r<=j;r++)
					{
						Thread.sleep(2000);
						if(j==4)
							share2.scrollToAPoint(driver, 1100);

						l.click();
					}*/
				}
				Thread.sleep(2000);
				//Debug
				//Clicks on save without images
				share2.scrollToTop(driver);
				driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
				driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
				Thread.sleep(2000);
				//Clicks on Save
				driver.findElement(By.id("efi-irca-button-save")).click();
				//Save pop verify
				obj1.verifySavePopup(driver, softly);
				//Clicks on Save report
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
				//Verify save sticky
				obj1.verifyStickySaveReport(driver, softly, username, reportTitle, 1);
				Thread.sleep(1500);
				obj1.verifySticky1ImageUploaded(driver,softly);
				//Wait for loading message to disappear
				share2.loadingServer(driver); 
				jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(1000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					//Click on attach another file
					Thread.sleep(2000);
					WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
//					share2.scrollToElement(driver, add);
//					add.click();
					jse.executeScript("arguments[0].scrollIntoView(true);", add);
					jse.executeScript("arguments[0].click();", add);

				}

			}
		}
		//Delete 3rd image
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))));
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));
		//Click on attach another file
		Thread.sleep(2000);
		WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
		share2.scrollToElement(driver, add);
		add.click();
		//Click on last collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-4"))).click();
		//Fill title and description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-4"))).sendKeys("Title05");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-description-4"))).sendKeys("Description05");
		//Upload image
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-description-4"))));
		driver.findElement(By.id("pii-irca-event-file-4")).sendKeys(filepath);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-4")));
		Thread.sleep(2000);
		//Clicks on save without images
		share2.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		Thread.sleep(200);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));
		Thread.sleep(500);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.scrollToAPoint(driver, 2000);
	}

	public void uploadFiveImagesFirefox(WebDriver driver, String username, String reportTitle) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		HiRCA2 obj1 = new HiRCA2();
		//int n=500;
		for (int j=0; j<5; j++)
		{

			//Click on Supporting file details
			Thread.sleep(500);
			String id = "pii-irca-event-filecollapsible-"+j;
			share2.scrollToElement(driver, driver.findElement(By.id(id)));
			driver.findElement(By.id(id)).click();
			//Uploads file
			String file = "pii-irca-event-file-"+j;
			WebElement l=driver.findElement(By.id(file));
			/*act.moveToElement(l).build().perform();*/
			jse.executeScript("arguments[0].scrollIntoView();", l);
			jse.executeScript("arguments[0].click();", l);
			Thread.sleep(2000);
			Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumHiRCA.exe");
			p.waitFor();
			Thread.sleep(2000);
			String img = "pii-irca-event-file-img-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				//delete file
				String del = "pii-irca-event-file-remove-"+j;
				Thread.sleep(1000);				  
				driver.findElement(By.id(del)).click(); 		
				//Delete file pop up
				obj1.verifyDeleteFilePopup(driver, softly, j+1);
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
				if(j!=0)
				{
					driver.findElement(By.id("pii-irca-addnewfile-button")).click();
					//Thread.sleep(1000);
				/*	n=n+80;
					String scroll = "scroll(0,"+n+")";
					jse.executeScript(scroll);*/
				}
				Thread.sleep(2000);
				//Click on Supporting file details
				share2.scrollToElement(driver, driver.findElement(By.id(id)));
				driver.findElement(By.id(id)).click();
				//Fill title and description
				String title_id="pii-irca-event-file-title-"+j;
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(title_id))).sendKeys("Title0"+j);
				String desc = "pii-irca-event-file-description-"+j;
				driver.findElement(By.id(desc)).sendKeys("Description0"+j);
				//re-upload file
				l=driver.findElement(By.id(file));
				jse.executeScript("arguments[0].scrollIntoView();", l);
				jse.executeScript("arguments[0].click();", l);
				Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumHiRCA.exe");
				q.waitFor();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
				Thread.sleep(2000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					//rotate file
					String rotate= "pii-irca-event-file-rotate-"+j;
					for(int r=0;r<=j;r++)
					{
						Thread.sleep(2000);
						/*if(j==4)
							share2.scrollToAPoint(driver, 1000);*/
						l=driver.findElement(By.id(rotate));
						share2.scrollToElement(driver, l);
						//act.moveToElement(l).build().perform();
						//jse.executeScript("arguments[0].scrollIntoView();", l);
						l.click();
					}
				}
				//Debug
				//Clicks on save without images
				share2.scrollToTop(driver);
				driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
				driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
				//Clicks on Save
				driver.findElement(By.id("efi-irca-button-save")).click();
				//Save pop verify
				obj1.verifySavePopup(driver, softly);
				//Clicks on Save report
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
				//Verify save sticky
				obj1.verifyStickySaveReport(driver, softly, username, reportTitle, 1);
				Thread.sleep(1500);
				obj1.verifySticky1ImageUploaded(driver,softly);
				//Wait for loading message to disappear
				share2.loadingServer(driver);  
				jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(1000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					share2.scrollToAPoint(driver, 2000);
					//Click on attach another file
					Thread.sleep(2000);
					WebElement add= driver.findElement(By.id("pii-irca-addnewfile-button"));
					//jse.executeScript("arguments[0].scrollIntoView(true);", add);
					add.click();
				}

			}
		}
		//Delete 3rd image
		Thread.sleep(2000);
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		//Click on last collapsible
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-3"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-3"))).click();
		//Fill title and description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-3"))).sendKeys("Title05");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-description-3"))).sendKeys("Description05");
		//Upload image
		WebElement l=driver.findElement(By.id("pii-irca-event-file-4"));
		share2.scrollToElement(driver, l);
		jse.executeScript("arguments[0].click();", l);
		Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumHiRCA.exe");
		q.waitFor();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-4")));
		Thread.sleep(2000);
		//Clicks on save without images
		share2.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.scrollToAPoint(driver, 2000);
	}

	public void uploadFiveImagesIE10(WebDriver driver, String username, String reportTitle) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		HiRCA2 obj1 = new HiRCA2();
		//int n=450;
		for (int j=0; j<5; j++)
		{
			//Click on Supporting file details
			Thread.sleep(1500);
			String id = "pii-irca-event-filecollapsible-"+j;
			share2.scrollToElement(driver, driver.findElement(By.id(id)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
			//Uploads file
			String file = "pii-irca-event-file-"+j;/*
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(file))).click();
			  WebElement element =  driver.findElement(By.id(file));			  
			  act.doubleClick(element).build().perform();*/
			jse.executeScript("return document.getElementById('"+file+"').click();");
			Thread.sleep(8000);
			try {
				Process p = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpecetd alert for picture 2");
				driver.switchTo().alert().accept();
			}catch (NoAlertPresentException f){
				System.out.println ("No unexpected alert for picture 2");
			}
			Thread.sleep(6000);
			String img = "pii-irca-event-file-img-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				//delete file
				String del = "pii-irca-event-file-remove-"+j;
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(del))).click(); 
				//Delete file pop up
				obj1.verifyDeleteFilePopup(driver, softly, j+1);
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
				if(j!=0)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button"))).click();
					Thread.sleep(1000);
					/*n=n+180;
					String scroll = "scroll(0,"+n+")";
					jse.executeScript(scroll);*/
				}
				//Click on Supporting file details
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
				//Fill title and description
				String title_id="pii-irca-event-file-title-"+j;
				driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
				String desc = "pii-irca-event-file-description-"+j;
				driver.findElement(By.id(desc)).sendKeys("Description0"+j);
				//re-upload file
				/*  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(file))).click();
				  WebElement element1 =  driver.findElement(By.id(file));
				  Actions act1 = new Actions(driver);
				  act1.doubleClick(element1).build().perform();*/
				jse.executeScript("return document.getElementById('"+file+"').click();");
				Thread.sleep(8000);
				try {
					Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
					q.waitFor();
				}catch (UnhandledAlertException f){	
					System.out.println("Unexpected alert for picture 2");
					driver.switchTo().alert().accept();

				}catch (NoAlertPresentException f){
					System.out.println ("No unexpected alert for picture 2");
				}
				Thread.sleep(4000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
				Thread.sleep(2000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					//rotate file
					String rotate= "pii-irca-event-file-rotate-"+j;
					for(int r=0;r<=j;r++)
					{
						Thread.sleep(2000);
						share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(rotate))));
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(rotate))).click();
					}
				}
				//Debug
				//Clicks on save without images
				share2.scrollToTop(driver);
				Thread.sleep(3000);
				//Clicks on Save
				WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save")));
				share2.scrollToElement(driver, ele);
				while(true)
				{
					ele.click();
					Thread.sleep(3000);
					if(driver.findElement(hirca.HiRCAPopupConfirmButton).isDisplayed())
						break;
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton));
				//Clicks on Save report
				/* try{
				  wait.until(ExpectedConditions.visibilityOfElementLocated(HiRCAPopupMessage));
				  }catch (UnhandledAlertException f){	
					  System.out.println("Unexpecetd alert");
					  driver.switchTo().alert().accept();

			  	  }catch (NoAlertPresentException f){
			  		  System.out.println ("No unexpected alert");
			  		  }*/
				//Verify save pop up
				obj1.verifySavePopup(driver, softly);
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
				//Verify save sticky
				obj1.verifyStickySaveReport(driver, softly, username, reportTitle, 1);
				Thread.sleep(1500);
				obj1.verifySticky1ImageUploaded(driver,softly);
				//Wait for loading message to disappear
				share2.loadingServer(driver); 		  
				jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(1000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button"))));
					//Click on attach another file
					Thread.sleep(2000);
					WebElement add= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button")));
					//jse.executeScript("arguments[0].scrollIntoView(true);", add);
					add.click();
				}

			}
		}
		//Delete 3rd image
		Thread.sleep(2000);
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		//Click on last collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-3"))).click();
		//Fill title and description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-3"))).sendKeys("Title05");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-description-3"))).sendKeys("Description05");
		//Upload image
		WebElement l=driver.findElement(By.id("pii-irca-event-file-button-4"));
		//Scroll to element
		share2.scrollToElement(driver, l);
		Actions act1 = new Actions(driver);
		act1.doubleClick(l).build().perform();
		Thread.sleep(8000);
		Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/MozillaChrysanthemumJOBOBS.exe");
		q.waitFor();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-4")));
		Thread.sleep(2000);
		//Clicks on save without images
		share2.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		Thread.sleep(500);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.scrollToAPoint(driver, 2000);
	}


	public void uploadFiveImagesIE11(WebDriver driver, String username, String reportTitle) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		HiRCA2 obj1 = new HiRCA2();
		//int n=500;
		//int x=1800;
		for (int j=0; j<5; j++)
		{

			//Click on Supporting file details
			Thread.sleep(1500);
			String id = "pii-irca-event-filecollapsible-"+j;
			share2.scrollToElement(driver, driver.findElement(By.id(id)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
			//x=x+200;
			/*String scroll1 = "scroll(0,"+x+")";
			jse.executeScript(scroll1);*/
			//Uploads file
			String file = "pii-irca-event-file-"+j;
			share2.scrollToElement(driver, driver.findElement(By.id(file)));/*
			  WebElement element =  driver.findElement(By.id(file));
			  Actions act = new Actions(driver);
			  act.click(element).build().perform();*/
			jse.executeScript("return document.getElementById('"+file+"').click();");
			Thread.sleep(2000);
			try {
				Process p = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
				p.waitFor();
			}catch (UnhandledAlertException f){		
				System.out.println("Unexpected alert for picture 2");
				driver.switchTo().alert().accept();
			}catch (NoAlertPresentException f){
				System.out.println ("No unexpected alert for picture 2");
			}
			Thread.sleep(2000);
			String img = "pii-irca-event-file-img-"+j;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				//delete file
				String del = "pii-irca-event-file-remove-"+j;
				//Thread.sleep(1000);
				/*jse.executeScript("scroll(0,"+(x-150)+")");
				if(j==0||j==2||j==4 || j==3)
				{
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(del))).sendKeys(Keys.ARROW_UP);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(del))).sendKeys(Keys.ARROW_UP);
				}
				Thread.sleep(1000);*/
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(del))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(del))).click(); 
				//Delete file pop up
				obj1.verifyDeleteFilePopup(driver, softly, j+1);
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
				if(j!=0)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button"))).click();
					Thread.sleep(1000);
					/*n=n+150;
					String scroll = "scroll(0,"+n+")";
					jse.executeScript(scroll);*/
				}
				//Click on Supporting file details
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
				//Fill title and description
				String title_id="pii-irca-event-file-title-"+j;
				driver.findElement(By.id(title_id)).sendKeys("Title0"+j);
				String desc = "pii-irca-event-file-description-"+j;
				driver.findElement(By.id(desc)).sendKeys("Description0"+j);
				//re-upload file
				/*  WebElement element1 =  driver.findElement(By.id(file));
				  Actions act1 = new Actions(driver);
				  act1.click(element1).build().perform();*/
				jse.executeScript("return document.getElementById('"+file+"').click();");
				Thread.sleep(2000);
				try {
					Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
					q.waitFor();
				}catch (UnhandledAlertException f){	
					System.out.println("Unexpected alert for picture 2");
					driver.switchTo().alert().accept();

				}catch (NoAlertPresentException f){
					System.out.println ("No unexpected alert for picture 2");
				}
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
				Thread.sleep(2000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					//rotate file
					String rotate= "pii-irca-event-file-rotate-"+j;
					for(int r=0;r<=j;r++)
					{
						Thread.sleep(2000);
						share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(rotate))));
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(rotate))).click();
					}
				}
				//Debug
				//Clicks on save without images
				share2.scrollToTop(driver);
				Thread.sleep(2000);
				//Clicks on Save
				driver.findElement(By.id("efi-irca-button-save")).click();
				//Verify save pop up
				obj1.verifySavePopup(driver, softly);
				//Clicks on Save report
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
				//Verify save sticky
				obj1.verifyStickySaveReport(driver, softly, username, reportTitle, 1);
				Thread.sleep(1500);
				obj1.verifySticky1ImageUploaded(driver,softly);
				//Wait for loading message to disappear
				share2.loadingServer(driver);		  
				//jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(1000);
				if(driver.findElement(By.id(img)).isDisplayed())
				{
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button"))));
					//Click on attach another file
					Thread.sleep(2000);
					WebElement add= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button")));
					add.click();
				}

			}
		}
		//Delete 3rd image
		Thread.sleep(2000);
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-remove-2"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		//Click on last collapsible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-4"))).click();
		//Fill title and description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-title-4"))).sendKeys("Title05");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-description-4"))).sendKeys("Description05");
		//Upload image
		WebElement l=driver.findElement(By.id("pii-irca-event-file-button-4"));
		Actions act1 = new Actions(driver);
		act1.click(l).build().perform();
		Thread.sleep(8000);
		Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/IE11MozillaChrysanthemumJOBOBS.exe");
		q.waitFor();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-img-4")));
		Thread.sleep(2000);
		//Clicks on save without images
		share2.scrollToTop(driver);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.id("efi-irca-button-save")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(2000);
		//Clicks on Save
		driver.findElement(By.id("efi-irca-button-save")).click();
		//Verify save pop up
		obj1.verifySavePopup(driver, softly);
		//Clicks on Save report
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		//Verify save sticky
		obj1.verifyStickySaveReport(driver, softly, username, reportTitle, 1);
		Thread.sleep(4000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		share2.scrollToAPoint(driver, 2000);
	}

	public String hircaEventInfo(WebDriver driver, String username) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		HiRCA2 obj = new HiRCA2();
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//Clicks on Analysis 
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		}catch (UnhandledAlertException f){			  
			driver.switchTo().alert().dismiss();
		}
		//Clicks on HiRCA
		driver.findElement(By.id("pii-a-menu-hirca")).click();
		Thread.sleep(2000);
		//Checks if the textboxes have the correct titles
		String ev_title = driver.findElement(By.id("pii-irca-event-title-label")).getText();
		System.out.println(ev_title);
		softly.assertThat(ev_title).as("test data").isEqualTo("Event title:");
		String ev_id = driver.findElement(By.xpath(".//*[@for='pii-irca-event-crnumber']")).getText();
		System.out.println(ev_id);
		softly.assertThat(ev_id).as("test data").isEqualTo("Event ID:");
		String loc=driver.findElement(By.xpath(".//*[@for='pii-irca-event-location']")).getText();
		System.out.println(loc);
		softly.assertThat(loc).as("test data").isEqualTo("Location of event:");
		
		String date=driver.findElement(By.xpath(".//*[@for='pii-irca-event-date']")).getText();
		System.out.println(date);
		softly.assertThat(date).as("test data").isEqualTo("Date/Time of event:");
		
		String dept=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[5]/fieldset/div/legend")).getText();
		System.out.println(dept);
		softly.assertThat(dept).as("test data").isEqualTo("Department:");
		
		String sub_dept=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[6]/fieldset/div/legend")).getText();
		System.out.println(sub_dept);
		softly.assertThat(sub_dept).as("test data").isEqualTo("Sub-department:");
		
		String inve=driver.findElement(By.xpath(".//*[@for='pii-irca-event-investigators']")).getText();
		System.out.println(inve);
		softly.assertThat(inve).as("test data").isEqualTo("Investigators:");
		
		String exec=driver.findElement(By.xpath(".//*[@for='pii-irca-event-execsummary']")).getText();
		System.out.println(exec);
		softly.assertThat(exec).as("test data").isEqualTo("Executive summary:");
		
		String prob=driver.findElement(By.xpath(".//*[@for='pii-irca-event-pbstatement']")).getText();
		System.out.println(prob);
		softly.assertThat(prob).as("test data").isEqualTo("Problem statement:");
		
		/*am_not applicable
		String timeline=driver.findElement(By.xpath(".//*[@for='pii-irca-event-events']")).getText();
		System.out.println(timeline);
		softly.assertThat(timeline).as("test data").isEqualTo("Timeline of event:"); */
		
		String back=driver.findElement(By.xpath(".//*[@for='pii-irca-event-bginfos']")).getText();
		System.out.println(back);
		softly.assertThat(back).as("test data").isEqualTo("Background information:");
		
		String supp1 = driver.findElement(By.id("pii-irca-event-file-fieldcontain-label-0")).getText();
		System.out.println(supp1);
		softly.assertThat(supp1).as("test data").isEqualTo("Supporting file (1):");
	
		
		String repo=driver.findElement(By.xpath(".//*[@for='pii-irca-event-repdatetime']")).getText();
		System.out.println("Print out reportCreationDate    "+repo);
		softly.assertThat(repo).as("test data").isEqualTo("Report creation date:");
		//Checks if header appears
		WebElement header = driver.findElement(By.tagName("header"));
		if(header.isDisplayed())
		{
			System.out.println("Header is displayed");
			if (header.findElement(By.xpath(".//*[@class='pii-logo-div']/img")).isDisplayed())
				System.out.println("Logo is displayed");
			if(header.findElement(By.id("links")).isDisplayed())
			{
				System.out.println("Links are displayed");
				if(header.findElement(By.xpath(".//*[@id='links']/a")).isDisplayed())
					System.out.println("Knowledge link displayed");
				if(header.findElement(By.xpath(".//*[@id='links']/a[2]")).isDisplayed())
					System.out.println("Analysis link displayed");
				if(header.findElement(By.xpath(".//*[@id='links']/a[3]")).isDisplayed())
					System.out.println("Learning link displayed");
				if(header.findElement(By.xpath(".//*[@id='links']/a[4]")).isDisplayed())
					System.out.println("ErrorFree Bank link displayed");
			}

		}
		//Checks if footer appears
		WebElement footer = driver.findElement(By.tagName("footer")); 
		if(footer.isDisplayed())
		{
			System.out.println("Footer is displayed");
			if (footer.findElement(By.xpath(".//*[@class='ui-grid-c']/a")).isDisplayed())
				System.out.println("About link is displayed");
			if(footer.findElement(By.xpath(".//*[@class='ui-grid-c']/a[2]")).isDisplayed())
				System.out.println("Contact link displayed");
			if(footer.findElement(By.xpath(".//*[@class='ui-grid-c']/a[3]")).isDisplayed())
				System.out.println("Privacy link displayed");
			if(footer.findElement(By.xpath(".//*[@class='ui-grid-c']/a[4]")).isDisplayed())
				System.out.println("Help link displayed");

		}
		//Clicks on save to get error message
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		share2.verifyWarningPopupForError(driver, softly);
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		//Checks for the error message on each mandatory check box
		if(driver.findElement(By.id("pii-irca-event-title-error")).isDisplayed())
		{
			String error_title = driver.findElement(By.id("pii-irca-event-title-error")).getText();
			softly.assertThat(error_title).as("test data").isEqualTo("Event title is required");
			WebElement textbox1=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div"));
			WebElement error_title_dotted = textbox1.findElement(By.cssSelector(".ui-input-text.ui-body-inherit.ui-corner-all.ui-shadow-inset.ui-input-has-clear.error"));
			if (error_title_dotted.isDisplayed())
				System.out.println("Error dotted line displayed on event title textbox");
		}
		if(driver.findElement(By.id("pii-irca-event-location-error")).isDisplayed())
		{
			String error_location = driver.findElement(By.id("pii-irca-event-location-error")).getText();
			softly.assertThat(error_location).as("test data").isEqualTo("Location of event is required");
			WebElement textbox2=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[3]"));
			WebElement error_location_dotted = textbox2.findElement(By.cssSelector(".ui-input-text.ui-body-inherit.ui-corner-all.ui-shadow-inset.ui-input-has-clear.error"));
			if (error_location_dotted.isDisplayed())
				System.out.println("Error dotted line displayed on location of event textbox");
		}
		if(driver.findElement(By.id("pii-irca-event-department-error")).isDisplayed())
		{
			String error_dept = driver.findElement(By.id("pii-irca-event-department-error")).getText();
			softly.assertThat(error_dept).as("test data").isEqualTo("Department is required");
			WebElement textbox3;
			textbox3=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[5]"));
			WebElement error_dept_dotted = textbox3.findElement(By.cssSelector(".ui-btn.ui-icon-carat-d.ui-btn-icon-right.ui-corner-all.ui-shadow.ui-first-child.ui-last-child.error"));
			if (error_dept_dotted.isDisplayed())
				System.out.println("Error dotted line displayed on Department textbox");
		}
//		share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-event-pbstatement-error")));
		jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement-error"))));
		if(driver.findElement(By.id("pii-irca-event-pbstatement-error")).isDisplayed())
		{
			String error_prob = driver.findElement(By.id("pii-irca-event-pbstatement-error")).getText();
			softly.assertThat(error_prob).as("test data").isEqualTo("Problem statement is required");
			WebElement textbox4;
			textbox4=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[9]"));
			WebElement error_prob_dotted = textbox4.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow.error"));
			if (error_prob_dotted.isDisplayed())
				System.out.println("Error dotted line displayed on problem statement textbox");
		}
		
		/*am_not applicable
		share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-event-events-error")));
		if(driver.findElement(By.id("pii-irca-event-events-error")).isDisplayed())
		{
			String error_timeline = driver.findElement(By.id("pii-irca-event-events-error")).getText();
			softly.assertThat(error_timeline).as("test data").isEqualTo("Timeline of event is required");
			WebElement textbox5=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[10]"));
			WebElement error_timeline_dotted = textbox5.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow.error"));
			if (error_timeline_dotted.isDisplayed())
				System.out.println("Error dotted line displayed on timeline of event textbox");
		}*/
		
//		share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-event-bginfos-error")));
		jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos-error"))));
		if(driver.findElement(By.id("pii-irca-event-bginfos-error")).isDisplayed())
		{
			String error_back = driver.findElement(By.id("pii-irca-event-bginfos-error")).getText();
			softly.assertThat(error_back).as("test data").isEqualTo("Background information is required");
			WebElement textbox6=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[11]"));
			WebElement error_back_dotted = textbox6.findElement(By.xpath("//textarea[contains(@id,'pii-irca-event-bginfos')]"));
			if (error_back_dotted.isDisplayed())
				System.out.println("Error dotted line displayed on background information textbox");
		}
		
		/*am_not applicable
		share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-event-investigators-error")));
		if(driver.findElement(By.id("pii-irca-event-investigators-error")).isDisplayed())
		{
			String error_invest = driver.findElement(By.id("pii-irca-event-investigators-error")).getText();
			softly.assertThat(error_invest).as("test data").isEqualTo("Investigators is required");
			WebElement textbox7;
			textbox7=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[7]"));
			WebElement error_invest_dotted = textbox7.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow.error"));
			if (error_invest_dotted.isDisplayed())
				System.out.println("Error dotted line displayed on investigators textbox");
		}*/
		
		//Checks if after entering text if the error message and dotted line disappears
		//Investigators
//		share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-event-investigators")));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-investigators"))));
		driver.findElement(By.id("pii-irca-event-investigators")).sendKeys(paragraph_investigators);
		/*am_not applicable
		if(driver.findElement(By.id("pii-irca-event-investigators-error")).isDisplayed()==false)
		{
			String noerror_invest = driver.findElement(By.id("pii-irca-event-investigators-error")).getText();
			softly.assertThat(noerror_invest).as("test data").isEqualTo("");
			WebElement ttextbox7;
			ttextbox7=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[7]"));
			WebElement noerror_invest_dotted = ttextbox7.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow"));
			Thread.sleep(500);
			if (noerror_invest_dotted.isDisplayed())
				System.out.println("Error dotted line disappeared on investigators textbox");
		}*/
		
		//Clears some text
		for(int i =0; i<30; i++)
		{
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-investigators"))));
			driver.findElement(By.id("pii-irca-event-investigators")).sendKeys(Keys.BACK_SPACE); 
		}
		//Clears all text
		driver.findElement(By.id("pii-irca-event-investigators")).clear();
		//Re enters text
		driver.findElement(By.id("pii-irca-event-investigators")).sendKeys(paragraph_investigators);

		//Background info
//		share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-event-bginfos")));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos"))));
		driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys(paragraph_background);
		if(driver.findElement(By.id("pii-irca-event-bginfos-error")).isDisplayed()==false)
		{
			String noerror_back = driver.findElement(By.id("pii-irca-event-bginfos-error")).getText();
			softly.assertThat(noerror_back).as("test data").isEqualTo("");
			WebElement ttextbox6=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[11]"));
			WebElement noerror_back_dotted = ttextbox6.findElement(By.xpath("//textarea[contains(@id,'pii-irca-event-bginfos')]"));
			Thread.sleep(500);
			if (noerror_back_dotted.isDisplayed())
				System.out.println("Error dotted line disappeared on background information textbox");
		}
		//Clears some text
		for(int i =0; i<30; i++)
		{
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos"))));
			driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys(Keys.BACK_SPACE); 
		}
		//Clears all text
		driver.findElement(By.id("pii-irca-event-bginfos")).clear();
		//Re enters text
		driver.findElement(By.id("pii-irca-event-bginfos")).sendKeys(paragraph_background);

		/*am_not applicable
		//Timeline of event
		share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-event-events")));
		driver.findElement(By.id("pii-irca-event-events")).sendKeys(paragraph_timeline);
		if(driver.findElement(By.id("pii-irca-event-events-error")).isDisplayed()==false)
		{
			String noerror_timeline = driver.findElement(By.id("pii-irca-event-events-error")).getText();
			softly.assertThat(noerror_timeline).as("test data").isEqualTo("");
			WebElement ttextbox5=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[10]"));
			WebElement noerror_timeline_dotted = ttextbox5.findElement(By.cssSelector(".ui-input-text.ui-shadow-inset.ui-body-inherit.ui-corner-all.ui-textinput-autogrow"));
			Thread.sleep(500);
			if (noerror_timeline_dotted.isDisplayed())
				System.out.println("Error dotted line disappeared on timeline of event textbox");
		}
		
		//Clears some text
		for(int i =0; i<30; i++)
		{
			driver.findElement(By.id("pii-irca-event-events")).sendKeys(Keys.BACK_SPACE); 
		}
		//Clears all text
		driver.findElement(By.id("pii-irca-event-events")).clear();
		//Re enters text
		driver.findElement(By.id("pii-irca-event-events")).sendKeys(paragraph_timeline); */

		//Problem Statement
//		share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-event-pbstatement")));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement"))));
		driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys(paragraph_problem);
		if(driver.findElement(By.id("pii-irca-event-pbstatement-error")).isDisplayed()==false)
		{
			String noerror_prob = driver.findElement(By.id("pii-irca-event-pbstatement-error")).getText();
			softly.assertThat(noerror_prob).as("test data").isEqualTo("");
			WebElement ttextbox4;
			ttextbox4=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[9]"));
			WebElement noerror_prob_dotted = ttextbox4.findElement(By.xpath("//textarea[@id='pii-irca-event-pbstatement']"));
			if (noerror_prob_dotted.isDisplayed())
				System.out.println("Error dotted line disappeared on problem statement textbox");
		}
		//Clears some text
		for(int i =0; i<30; i++)
		{
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement"))));
			driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys(Keys.BACK_SPACE); 
		}
		//Clears all text
		driver.findElement(By.id("pii-irca-event-pbstatement")).clear();
		//Re enters text
		driver.findElement(By.id("pii-irca-event-pbstatement")).sendKeys(paragraph_problem);
		share2.scrollToTop(driver);

		//Department
//		share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-event-department")));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-location"))));
		WebElement dropdown = driver.findElement(By.id("pii-irca-event-department"));
		Select s = new Select (dropdown);
		s.selectByVisibleText("Construction");
		if(driver.findElement(By.id("pii-irca-event-department-error")).isDisplayed()==false)
		{
			String noerror_dept = driver.findElement(By.id("pii-irca-event-department-error")).getText();
			softly.assertThat(noerror_dept).as("test data").isEqualTo("");
			WebElement ttextbox3;
			ttextbox3=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[5]"));
			WebElement noerror_dept_dotted = ttextbox3.findElement(By.cssSelector(".ui-btn.ui-icon-carat-d.ui-btn-icon-right.ui-corner-all.ui-shadow.ui-first-child.ui-last-child"));
			if (noerror_dept_dotted.isDisplayed())
				System.out.println("Error dotted line disappeared on Department textbox");
		}

		//Location of event
//		share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-event-location")));
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-location"))));
		driver.findElement(By.id("pii-irca-event-location")).sendKeys(text);
		if(driver.findElement(By.id("pii-irca-event-location-error")).isDisplayed()==false)
		{
			String noerror_location = driver.findElement(By.id("pii-irca-event-location-error")).getText();
			softly.assertThat(noerror_location).as("test data").isEqualTo("");
			WebElement ttextbox2=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[3]"));
			WebElement noerror_location_dotted = ttextbox2.findElement(By.cssSelector(".ui-input-text.ui-body-inherit.ui-corner-all.ui-shadow-inset.ui-input-has-clear"));
			if (noerror_location_dotted.isDisplayed())
				System.out.println("Error dotted line disappeared on location of event textbox");
		}
		share2.scrollToTop(driver);
		//Clears some text
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-location"))));
		for(int i =0; i<20; i++)
		{
			driver.findElement(By.id("pii-irca-event-location")).sendKeys(Keys.BACK_SPACE); 
		}
		//Delete Location of Event X
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[3]/div/a"))));
		//Re enters text
		driver.findElement(By.id("pii-irca-event-location")).sendKeys(text);
		//Clears all text
		driver.findElement(By.id("pii-irca-event-location")).clear();
		//Re enters text
		driver.findElement(By.id("pii-irca-event-location")).sendKeys(text);

		//Event title
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))));
		driver.findElement(By.id("pii-irca-event-title")).sendKeys(text);
		if(driver.findElement(By.id("pii-irca-event-title-error")).isDisplayed()==false)
		{
			String noerror_title = driver.findElement(By.id("pii-irca-event-title-error")).getText();
			softly.assertThat(noerror_title).as("test data").isEqualTo("");
			WebElement ttextbox1=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div"));
			WebElement noerror_title_dotted = ttextbox1.findElement(By.cssSelector(".ui-input-text.ui-body-inherit.ui-corner-all.ui-shadow-inset.ui-input-has-clear"));
			if (noerror_title_dotted.isDisplayed())
				System.out.println("Error dotted line disappeared on event title textbox");
		}
		//Clears some text
		for(int i =0; i<20; i++)
		{
			driver.findElement(By.id("pii-irca-event-title")).sendKeys(Keys.BACK_SPACE); 
		}
		//Clears by cross mark
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))));
		driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div/div/a")).click();
		//Re enters text
		driver.findElement(By.id("pii-irca-event-title")).sendKeys(text);
		//Clears all text
		driver.findElement(By.id("pii-irca-event-title")).clear();
		//Re enters text
		driver.findElement(By.id("pii-irca-event-title")).sendKeys(text);

		//Checks event title text box limit
		driver.findElement(By.id("pii-irca-event-title")).clear();
		driver.findElement(By.id("pii-irca-event-title")).sendKeys(text184);
		Thread.sleep(1000);
		String limit_text = driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div/span")).getText(); 
		limit_text=limit_text.substring(5,8);
		int limit = Integer.parseInt(limit_text);
		System.out.println(limit_text+ " "+limit);
		for(int i=text184.length()+1; i<=limit+1;i++)
			driver.findElement(By.id("pii-irca-event-title")).sendKeys(".");

		if(driver.findElement(By.id("pii-irca-event-title-error")).isDisplayed())
		{
			String error_title = driver.findElement(By.id("pii-irca-event-title-error")).getText();
			softly.assertThat(error_title).as("test data").isEqualTo("Event title: is too long, 1 bytes too long.");
			WebElement textbox1=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div"));
			WebElement error_title_dotted = textbox1.findElement(By.cssSelector(".ui-input-text.ui-body-inherit.ui-corner-all.ui-shadow-inset.ui-input-has-clear.error"));
			if (error_title_dotted.isDisplayed())
				System.out.println("Error dotted line displayed on event title textbox");
		}
		driver.findElement(By.id("pii-irca-event-title")).sendKeys(Keys.BACK_SPACE);
		if(driver.findElement(By.id("pii-irca-event-title-error")).isDisplayed()==false)
		{
			String noerror_title = driver.findElement(By.id("pii-irca-event-title-error")).getText();
			softly.assertThat(noerror_title).as("test data").isEqualTo("");
			WebElement ttextbox1=driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div"));
			WebElement noerror_title_dotted = ttextbox1.findElement(By.cssSelector(".ui-input-text.ui-body-inherit.ui-corner-all.ui-shadow-inset.ui-input-has-clear"));
			if (noerror_title_dotted.isDisplayed())
				System.out.println("Error dotted line disappeared on event title textbox");
		}
		//Clears and reenters event title
		driver.findElement(By.id("pii-irca-event-title")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("pii-irca-event-title")).sendKeys(text184);

		//Check the date picker
		driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[4]/div/div[1]/div/a")).click();
		//Close the popup
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/a")).click();
		Thread.sleep(2000);
		//Click on date picker
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[4]/div/div[1]/div/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[4]/div/div[1]/div/a"))));
		//Check if the title is correct
		String date_title=driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/div/h1")).getText();
		System.out.println("Print out date_title/Date of Event  "+date_title);
		softly.assertThat(date_title).as("test data").isEqualTo("Date of event:");
		//Click on + sign for next month
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/a")).click();
		//Click on - sign for previous month
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/a")).click();
		//Select date as 1st
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div[2]/div")).click();

		//Check the time picker
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[4]/div/div[2]/div/a")).click();
		//Close the popup
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/a")));
		Thread.sleep(2000);
		//Click on time picker
		driver.findElement(By.xpath(".//*[@id='pii-irca-event-form']/div[4]/div/div[2]/div/a")).click();
		//Check if the title is correct
		String time_title=driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/div/h1")).getText();
		System.out.println(time_title);
		softly.assertThat(time_title).as("test data").isEqualTo("Time of event:");
		//Click on + second
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div")).click();
		//Click on - second
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div[3]")).click();
		//Click on + minute
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div")).click();
		//Click on - minute
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[3]")).click();
		Thread.sleep(2000);
		//Check the error on minute
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys("666");
		//Check if the error is correct
		String time_title_error_min=driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/div/h1/div")).getText();
		System.out.println(time_title_error_min);
		softly.assertThat(time_title_error_min).as("test data").isEqualTo("(warning: 0>=hours<=23)");
		//Enter minute
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys(Keys.CONTROL,"a");
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div/div[2]/input")).sendKeys("01");
		Thread.sleep(2000);
		//Check the error on second
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div[2]/input")).sendKeys("666");
		//Check if the error is correct
		String time_title_error_sec=driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/div/h1/div")).getText();
		System.out.println(time_title_error_sec);
		softly.assertThat(time_title_error_sec).as("test data").isEqualTo("(warning: 0>=minutes<=59)");
		//Enter second
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div[2]/input")).sendKeys(Keys.CONTROL,"a");
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div[2]/input")).sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div/div[2]/div[2]/input")).sendKeys("13");
		Thread.sleep(2000);
		//Click on set time
		while(true)
		{
			Thread.sleep(500);
			try{
				driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div/a"));
				driver.findElement(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']/div/span/div[2]/div/a")).click();
			}catch(NoSuchElementException t)
			{
				break;
			}
		}
		Thread.sleep(4000);
		//Debug
		//Scroll to Top
		try {
		share2.scrollToTop(driver);
		}catch(org.openqa.selenium.ElementNotInteractableException u){
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");}
		catch(Exception e) {
			WebElement element = driver.findElement(By.id("efi-irca-button-save"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}
		//Clicks on Save
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		//Clicks on Save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Verify save sticky
		obj.verifyStickySaveReport(driver, softly, username, text184, 0);
		Thread.sleep(500);
		//Wait for loading message
		share2.loadingServer(driver);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//Check if it allows for uploading more than one file
//		share2.scrollToElement(driver, driver.findElement(By.id("pii-irca-addnewfile-button")));
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button"))));
		jse.executeScript("arguments[0].click();",driver.findElement(By.id("pii-irca-addnewfile-button")));
		//Supporting file pop up
		obj.verifyNoSupportingFilePopup(driver, softly);
		String error_attach=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).getText();
		softly.assertThat(error_attach).as("test data").isEqualTo("Please use existing empty supporting file form above");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		//Uploads five images
		uploadFiveImages(driver,username,text184);
		Thread.sleep(1000);
		//Click on Supporting File-Title05 to retrieve collapsiple 
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-header-1"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-header-4"))));
		//Checks if all images have been uploaded
		//n=2000;
		for (int j=4; j>=0; j--)
		{

			//Click on Supporting file details
			Thread.sleep(500);
			String id = "pii-irca-event-filecollapsible-"+j;
			String file = "pii-irca-event-file-"+j;
//			share2.scrollToElement(driver, driver.findElement(By.id(id)));
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id(id)));
//			if(j!=4)
			if(j<=4)
			{
				if(browserName.contains("safari"))
				{
					while(true)
					{
						jse.executeScript("document.getElementById('pii-irca-event-filecollapsible-header-"+j+"').focus();");
						jse.executeScript("arguments[0].click();", driver.findElement(By.id("pii-irca-event-filecollapsible-header-"+j)));
						if(driver.findElement(By.id(file)).isDisplayed())
							break;
					}					
				}
				else
//					jse.executeScript("document.getElementById('pii-irca-event-filecollapsible-"+j+"').focus();");
					jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id(id)));
					jse.executeScript("arguments[0].click();", driver.findElement(By.id(id)));
					System.out.println("Supporting file collapsible is being clicked successfully");
					
			}
			WebElement img4 = driver.findElement(By.id("pii-irca-event-file-img-4")) ;
			jse.executeScript("arguments[0].scrollIntoView(true);", img4);
			if(driver.findElement(By.id("pii-irca-event-file-img-4")).isDisplayed())
			{
				System.out.println("Picture in Supporting file is being uploaded");
			}
/*			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(img)));
			if(driver.findElement(By.id(img)).isDisplayed())
			{
				System.out.println("Picture uploaded "+(j+1));
			}*/
		}
		//Scroll into View of date & time
		//Clicks on Save
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))));
		//Gets value of date
		String get_date = driver.findElement(By.id("pii-irca-event-date")).getAttribute("value");
		System.out.println(get_date);
		//Gets value of time
		String get_time = driver.findElement(By.id("pii-irca-event-time")).getAttribute("value");
		System.out.println(get_time);
		//Gets value of department
		String get_dept = driver.findElement(By.id("pii-irca-event-department")).getAttribute("value");
		System.out.println("Print out value of department    "+get_dept);
		
		/*am_below xpath not applicable 
		//		share2.scrollToElement(driver, wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))));
		//Clicks on next
		if(browserName.contains("safari"))
		{
			jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))));
			jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))));
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))).click();			
		}
		*/
		
		//Clicks on next
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-controlgroup-controls ']/button[@type='submit']"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-controlgroup-controls ']/button[@type='submit']"))));
		//Clicks on back
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))));
		jse.executeScript("arguments[0].click();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		//Fills optional data
		//Executive summary
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-execsummary"))));
//		tbr.sizeCheck(driver, By.id("pii-irca-event-execsummary"), softly);
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-execsummary"))));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-execsummary"))).sendKeys(executive);
		//Event id
		jse.executeScript("arguments[0].focus();", wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-crnumber"))));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-crnumber"))).sendKeys(event_id);
		//Clicks on Next and proceeds with Root Cause
		share2.scrollToAPoint(driver, 6500);
		rootCause(driver);
		share2.scrollToTop(driver);
		//Clicks on Save
		jse.executeScript("arguments[0].click();",driver.findElement(By.id("efi-irca-button-save")));
		//Clicks on Save report
		jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))));
		jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))));
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		Thread.sleep(500);
		//Wait for loading message
		share2.loadingServer(driver);
		//Clicks on Save
		jse.executeScript("arguments[0].click();",driver.findElement(By.id("efi-irca-button-save")));
		Thread.sleep(1000);
		//Wait for loading message
		share2.loadingServer(driver);
		//Clicks on Save report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-success")));
		Thread.sleep(1000);
		//All changed supporting files saved successfully
		//Clicks on Info tab
		jse.executeScript("arguments[0].click();",wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))));
		Thread.sleep(1000);
		//Create an expected name
		String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		String name = creationDate + "_"+username+"_"+ text184 ;
		System.out.println(name);
		//Clicks on Saved activities
		driver.findElement(By.id("efi-irca-btn-savedactivities")).click();
		Thread.sleep(2000);
		//Clicks on side panel
		driver.findElement(By.id("pii-user-home-panel-btn-irca")).click();
		Thread.sleep(2000);
		//Gets newly created record name
		WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"));
		String recordName = record.getText();
		if (record.isDisplayed())
		{
			System.out.println("Record found: "+ recordName);
		}
		else
			System.out.println ("Record not found.");
		//Checks if expected name and actual name is correct
		softly.assertThat(recordName).as("test data").isEqualTo(name);
		Thread.sleep(2000);
		//Opens new record and checks if entered data is same after being saved in report
		openCheckRecord(driver, username, get_date, get_time, get_dept, creationDate);
		Thread.sleep(2000);
		//Opens record
		openReport(driver,recordName);
		Thread.sleep(2000);
		//Downloads record
		downloadSelectFunction(driver, get_date, get_time, get_dept, creationDate);
		Thread.sleep(2000);		
		return recordName;
	}

	public void downloadSelectFunction (WebDriver driver, String get_date, String get_time, String get_dept, String creationDate) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println("Print BrowserVersion" +v);
		/*//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Pictures//");
		if(browserName.contains("safari")==false)
		{
			deleteFiles(file);
		}*/
		//Download report to check pdf
		if (browserName.equals("chrome"))
			downloadRecordChrome(driver, get_date, get_time, get_dept, creationDate);
		if (browserName.equals("firefox"))
			downloadRecordFirefox(driver, get_date, get_time, get_dept, creationDate);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				downloadRecordIE10(driver, get_date, get_time, get_dept, creationDate);
			if (v.startsWith("11"))
				downloadRecordIE11(driver, get_date, get_time, get_dept, creationDate);
		}
		if(browserName.contains("safari"))
		{
			//Clicks on first newly created record
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
			share2.loadingServer(driver);
			driver.switchTo().defaultContent();
		}
	}

	public void uploadFiveImages(WebDriver driver, String username, String text) throws Exception {

		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			Thread.sleep(10000);
			uploadFiveImagesChrome(driver,username,text);
		if (browserName.equals("firefox"))
			uploadFiveImagesFirefox(driver,username,text);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				uploadFiveImagesIE10(driver,username,text);
			if (v.startsWith("11"))
				uploadFiveImagesIE11(driver,username,text);
		}
		if(browserName.contains("safari"))
			uploadFiveImagesSafari(driver,username,text);
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}