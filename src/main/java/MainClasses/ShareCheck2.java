import kaleTestSoftware.EiRCAPageObj;
import kaleTestSoftware.LoginPageObj;
import kaleTestSoftware.ShareCheckPageObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShareCheck2 {

	ShareCheckPageObj share = new ShareCheckPageObj();
	LoginPageObj lpo = new LoginPageObj();
	EiRCAPageObj eirca = new EiRCAPageObj();

	public void verifyNotificationDeletePopup(WebDriver driver, SoftAssertions softly, int chOrEn) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//Click on 1st record/notification
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord));
		if(ele.isSelected()==false)
		{
			try{
				executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
			}catch(StaleElementReferenceException r)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)).click();
			}
		}
		loadingServer(driver);
		//Click on unread
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationDeleteButton));
		if(ele.isEnabled()==false)
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
		ele.click();
		//Verify the header
		String header = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadUnreadPopUpHeader)).getText();			
		//Verify the title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadUnreadPopUpTitle)).getText();
		//Verify the title
		String warning = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadUnreadPopUpNote)).getText();
		//Verify the delete button
		String confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadConfirmButton)).getText();
		//Verify cancel button
		String cancel = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadUnreadCancelButton)).getText();
		if(chOrEn==0)
		{
			softly.assertThat(header).as("test data").isEqualTo("Delete Notification(s)");
			softly.assertThat(title).as("test data").isEqualTo("1 Report(s)/Notification(s) have been selected for deletion.");
			softly.assertThat(warning).as("test data").isEqualTo("Warning: the deleted notification(s) cannot be recovered.");
			softly.assertThat(confirm).as("test data").isEqualTo("delete");
			softly.assertThat(cancel).as("test data").isEqualTo("cancel");
		}
		else
		{
			softly.assertThat(header).as("test data").isEqualTo("删除通知");
			softly.assertThat(title).as("test data").isEqualTo("1 个报告将被删除.");
			softly.assertThat(warning).as("test data").isEqualTo("警告：删除通知后将无法复原");
			softly.assertThat(confirm).as("test data").isEqualTo("删除");
			softly.assertThat(cancel).as("test data").isEqualTo("取消");
			System.out.println("chinese delete notification verified");
		}
		//click on delete
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadConfirmButton)).click();
		verifyPopupAfterDeletingOneNotification(driver,softly,chOrEn);
	}

	public void verifyPopupAfterMarkingOneNotificationRead(WebDriver driver, SoftAssertions softly, int chOrEn) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Look for warning popup
		try{
			String warning = wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote)).getText();
			if(chOrEn==0)
				softly.assertThat(warning).as("test data").isEqualTo("1 Report(s)/Notification(s) marked as read.");
			else
				softly.assertThat(warning).as("test data").isEqualTo("1 个报告设为已读.");
			wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException t)
		{

		}
	}

	public void verifyPopupAfterMarkingOneNotificationUnRead(WebDriver driver, SoftAssertions softly, int chOrEn) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Look for warning popup
		try{
			String warning = wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote)).getText();
			if(chOrEn==0)
				softly.assertThat(warning).as("test data").isEqualTo("1 Report(s)/Notification(s) marked as unread.");
			else
				softly.assertThat(warning).as("test data").isEqualTo("1 个报告设为未读.");
			wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException t)
		{

		}
	}

	public void verifyPopupAfterDeletingOneNotification(WebDriver driver, SoftAssertions softly, int chOrEn) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Look for warning popup
		try{
			String warning = wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote)).getText();
			if(chOrEn==0)
				softly.assertThat(warning).as("test data").isEqualTo("1 Report(s)/Notification(s) deleted.");
			else
				softly.assertThat(warning).as("test data").isEqualTo("1 个报告已删除.");
			wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException t)
		{

		}
	}

	public void verifyNotificationReadPopup(WebDriver driver, SoftAssertions softly, int chOrEn) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify the header
		String header = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadUnreadPopUpHeader)).getText();
		//Verify the title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadUnreadPopUpTitle)).getText();
		//Verify the mark as read button
		String confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadConfirmButton)).getText();
		//Verify cancel button
		String cancel = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadUnreadCancelButton)).getText();
		if(chOrEn==0)
		{
			softly.assertThat(header).as("test data").isEqualTo("Mark As Read");
			softly.assertThat(title).as("test data").isEqualTo("1 Report(s)/Notification(s) have been selected to mark as read.");
			softly.assertThat(confirm).as("test data").isEqualTo("mark as read");
			softly.assertThat(cancel).as("test data").isEqualTo("cancel");
		}
		else
		{
			softly.assertThat(header).as("test data").isEqualTo("标为已读");
			softly.assertThat(title).as("test data").isEqualTo("1 个报告被选为已读.");
			softly.assertThat(confirm).as("test data").isEqualTo("确认标为已读");
			softly.assertThat(cancel).as("test data").isEqualTo("取消");
			System.out.println("chinese read notification verified");
		}
	}

	public void verifyNotificationUnreadPopup(WebDriver driver, SoftAssertions softly, int chOrEn) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//Click on 1st record/notification
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord));
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)).isSelected()==false)
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
		loadingServer(driver);
		//Click on unread
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationUnreadButton));
		for(int i=0;i<10;i++)
		{
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationUnreadButton)).isEnabled()==false)
			{
				if(i%2==0)
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)));
				else
					wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationFirstRecord)).click();
			}
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationUnreadButton)).isEnabled()==true)
				break;
		}
		loadingServer(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationUnreadButton)).click();
		//Verify the header
		String header = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadUnreadPopUpHeader)).getText();
		//Verify the title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadUnreadPopUpTitle)).getText();
		//Verify the mark as unread button
		String confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadConfirmButton)).getText();
		//Verify cancel button
		String cancel = wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadUnreadCancelButton)).getText();
		if(chOrEn==0)
		{
			softly.assertThat(header).as("test data").isEqualTo("Mark As Unread");
			softly.assertThat(title).as("test data").isEqualTo("1 Report(s)/Notification(s) have been selected to mark as unread.");
			softly.assertThat(confirm).as("test data").isEqualTo("mark as unread");
			softly.assertThat(cancel).as("test data").isEqualTo("cancel");
		}
		else
		{
			softly.assertThat(header).as("test data").isEqualTo("标为未读");
			softly.assertThat(title).as("test data").isEqualTo("1 个报告被选为未读.");
			softly.assertThat(confirm).as("test data").isEqualTo("确认标为未读");
			softly.assertThat(cancel).as("test data").isEqualTo("取消");
			System.out.println("chinese unread notification verified");
		}
		//click on mark as unread
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.NotificationReadConfirmButton)).click();
		verifyPopupAfterMarkingOneNotificationUnRead(driver,softly,chOrEn);
	}

	public void verifyNameDoesNotappearInListAfterSharerAdded (WebDriver driver, String sharer, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Enters sharer username
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareTextBox)).sendKeys("jenkins_1_nonadmin");
		Thread.sleep(2000);
		//Selects from dropdown
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareDropdown));
			softly.fail("Sharer appearing in list");
		}catch(org.openqa.selenium.TimeoutException r)
		{
			System.out.println("No select sharer list");
		}
	}

	public void verifyWarningPopupForError(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Look for warning popup
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(lpo.StickyWarningPopup));
		String warning = wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote)).getText();
		softly.assertThat(warning).as("test data").isEqualTo("Warning: cannot save until all errors in red are fixed.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();
	}

	public void verifyWarningPopupForSRIError(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Look for warning popup
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(lpo.StickyWarningPopup));
		String warning = wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote)).getText();
		softly.assertThat(warning).as("test data").isEqualTo("Please fix all errors mentioned in red.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();
	}

	public void loadingServer(WebDriver driver) throws Exception {

		while (true)
		{
			try{
				Thread.sleep(4000);
				if(driver.findElement(share.LoadingMessage).isDisplayed())
				{
					Thread.sleep(5000);
				}
				else
					break;
			}catch (NoSuchElementException | StaleElementReferenceException | JavascriptException e)
			{
				break;
			}
			catch (org.openqa.selenium.ScriptTimeoutException e)
			{
				Thread.sleep(6000);
			}
		}
	}

	public void checkIfUserProfileNoFieldsMissing(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on LoginName
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.LoginNameOnTopRight)).click();
		//Close any sticky if there
		while(true)
		{
			try{
				if (driver.findElement(lpo.StickyNote).isDisplayed())
				{
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();
				}
			}catch (NoSuchElementException |StaleElementReferenceException | org.openqa.selenium.TimeoutException | org.openqa.selenium.ElementNotInteractableException | JavascriptException e)
			{
				break;
			}
		}
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("internet")==false)
		{
			while(true)				
			{
				Thread.sleep(500);
				//Clicks on Account
				wait.until(ExpectedConditions.visibilityOfElementLocated(share.LoginNameOnTopRight)).click();
				Thread.sleep(500);
				if(driver.findElement(share.AccountOnTopRight).isDisplayed())
					break;
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(share.AccountOnTopRight)).click();
		}
		else
		{
			Actions act = new Actions (driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(share.LoginNameOnTopRight));
			WebElement element = driver.findElement(share.LoginNameOnTopRight);
			act.click(element).build().perform();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(share.AccountOnTopRight));
			element = driver.findElement(share.AccountOnTopRight);
			act.click(element).build().perform();
			Thread.sleep(2000);
		}
		// Change Group
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='pii-admin-user-groups-listbox']//ul//a[text()='admin' and contains(@class,'ui-checkbox-off')]"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'pii-admin-user-groups-listbox')]//a[text()='Close' and @role='button']"))).click();
		} catch (Exception e) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//*[contains(@id,'pii-admin-user-groups-listbox')]//a[text()='Close' and @role='button']")))
						.click();
			} catch (Exception e1) {
			}
		}
		scrollToTop(driver);
		while(true)				
		{
			Thread.sleep(500);
			//Clicks on save
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.UserAccountSaveButton)));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(share.UserAccountSaveButton)));
			Thread.sleep(500);
			if(browserName.contains("safari"))
				Thread.sleep(2000);
			if(driver.findElement(share.UserAccountSavePopupTitle).isDisplayed())
				break;
		}
		String saveMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(share.UserAccountSavePopupTitle)).getText().trim();
		softly.assertThat(saveMessage).as("test data").isEqualTo("Are you sure you want to save changes of current user data?");
		wait.until(ExpectedConditions.visibilityOfElementLocated(share.UserAccountSavePopupSaveButton)).click();
		//Waits for loading message to disappear
		loadingServer(driver);
	}

	public void scrollToAPoint(WebDriver driver, int yaxis)throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		try{
			jse.executeScript("scroll(0,"+yaxis+")");
		}catch (org.openqa.selenium.ScriptTimeoutException | JavascriptException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,"+yaxis+")");
		}
		Thread.sleep(1000);
	}

	public void scrollToElement(WebDriver driver, WebElement l)throws Exception{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Point p = l.getLocation();
		int yaxis= p.getY()-250;
		Thread.sleep(1000);
		try{
			jse.executeScript("scroll(0,"+yaxis+")");
		}catch (org.openqa.selenium.ScriptTimeoutException | JavascriptException | StaleElementReferenceException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,"+yaxis+")");
		}
		Thread.sleep(1000);
	}

	public void scrollToTop(WebDriver driver) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		try{
			jse.executeScript("scroll(0,0)");
		}catch (org.openqa.selenium.ScriptTimeoutException | JavascriptException r)
		{
			Thread.sleep(3000);
			jse.executeScript("scroll(0,0)");
		}
		Thread.sleep(1000);
	}
		public void scrollSmooth(WebDriver driver) throws Exception {
		    for(int i=0;i<6000;i++) {
		        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,0)", "");
		    }
		}
	      
	}
