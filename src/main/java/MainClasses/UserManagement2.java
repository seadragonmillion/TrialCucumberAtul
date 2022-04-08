import kaleTestSoftware.Login;
import kaleTestSoftware.LoginPageObj;
import kaleTestSoftware.ShareCheck2;
import kaleTestSoftware.UserManagementPageObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserManagement2 {

	UserManagementPageObj um = new UserManagementPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	Login login = new Login ();
	LoginPageObj lpo = new LoginPageObj();

	public void companyChangeAddress(WebDriver driver, String company_id, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Enters company id in ID field 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Clicks on newly created company id
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).click();
		Thread.sleep(3000);
		//Verify if company opened is correct one
		String verifyID=driver.findElement(By.id("pii-admin-cust-cid")).getAttribute("value");
		if(verifyID.equals(company_id))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit")));
			//Clicks on edit company
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))).click();
			//Changes the address
			driver.findElement(By.id("pii-admin-cust-address")).clear();
			driver.findElement(By.id("pii-admin-cust-address")).sendKeys("QAA edit company");
			//Clicks on Save
			driver.findElement(By.id("pii-admin-cust-button-save")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title"))).click();
			//Clicks on update company
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();		
			try{
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText();
				softly.assertThat(s).as("test data").contains("Company updated");
			}catch(org.openqa.selenium.TimeoutException r)
			{

			}
			//Enters company id in ID field 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id);
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
			share2.loadingServer(driver);
			//Clicks on newly created company id
			driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).click();
			share2.loadingServer(driver);
			//Checks if company address has been edited
			String changeAddress= driver.findElement(By.id("pii-admin-cust-address")).getAttribute("value");
			softly.assertThat(changeAddress).as("test data").isEqualTo("QAA edit company");
		}
	}

	public void verifyLoginNameCharactersAccepted(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		WebDriverWait wait1 = new WebDriverWait(driver,3);
		String arrayChar[] = {"!","#","$","%","&"," ","/","?",",","[]", "()", "{}","+","=",";",":","*","\\"};
		String loginPlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated(um.CreateUserLoginName)).getAttribute("placeholder");
		softly.assertThat(loginPlaceholder).as("test data").isEqualTo("Enter login name (alphabets, numbers or special characters: _-.@)");
		for (int i=0;i<arrayChar.length;i++)
		{
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(um.CreateUserLoginName)).clear();
			if(arrayChar[i].contains(" "))
				wait.until(ExpectedConditions.visibilityOfElementLocated(um.CreateUserLoginName)).sendKeys("abcd123"+arrayChar[i]+"abcd123");
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(um.CreateUserLoginName)).sendKeys("abcd123"+arrayChar[i]);
			wait.until(ExpectedConditions.visibilityOfElementLocated(um.UserProfileSaveButton)).click();
			Thread.sleep(500);
			try{				
				String error1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote)).getText();
				System.out.println(error1);
				String e1 = error1.replace("­", "");
				softly.assertThat(e1).as("test data").isEqualTo("Warning: Cannot save due to field <Login name> error: Incorrect value; please only enter alphabets, numbers or special characters: _-.@.");
				while(true)
				{
					try{
						wait1.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();
					}catch(org.openqa.selenium.WebDriverException r)
					{
						break;
					}
				}
			}catch(org.openqa.selenium.TimeoutException n)
			{

			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(um.CreateUserLoginName)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(um.CreateUserLoginName)).sendKeys("abcd123@._-");
		wait.until(ExpectedConditions.visibilityOfElementLocated(um.UserProfileSaveButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(um.EditUserMessageOnTop));
		wait.until(ExpectedConditions.visibilityOfElementLocated(um.CreateUserLoginName)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(um.CreateUserPassword)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(um.CreateUserReTypePassword)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();
	}

	public void verifyErrorOnCompanyPage (WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(um.CompanySaveButton)).click();
		//Verify all errors
		String idError = driver.findElement(um.CompanyIdError).getText();
		softly.assertThat(idError).as("test data").isEqualTo("Company ID is required");
		String nameError = driver.findElement(um.CompanyNameError).getText();
		softly.assertThat(nameError).as("test data").isEqualTo("Company name is required");
		String addressError = driver.findElement(um.CompanyAddressError).getText();
		softly.assertThat(addressError).as("test data").isEqualTo("Company address is required");
		String phoneError = driver.findElement(um.CompanyPhoneError).getText();
		softly.assertThat(phoneError).as("test data").isEqualTo("Company telephone is required");
		String busContactError = driver.findElement(um.CompanyBusinessContactError).getText();
		softly.assertThat(busContactError).as("test data").isEqualTo("Company business contact is required");
		String techContactError = driver.findElement(um.CompanyTechnicalContactError).getText();
		softly.assertThat(techContactError).as("test data").isEqualTo("Company technical contact is required");
		//softly.assertAll();
	}

	public void verifyNoCompanyIdError (WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Account	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		share2.loadingServer(driver);
		//Select nothing for company id
		Select dd = new Select (driver.findElement(By.id("pii-admin-user-customerId")));
		dd.selectByIndex(0);
		// Change Group
		share2.scrollToAPoint(driver, 600);
			try {
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))));
				//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))).click();
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//div[@id='pii-admin-user-groups-listbox']//ul//a[text()='admin' and contains(@class,'ui-checkbox-off')]")))
							.click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath("//*[contains(@id,'pii-admin-user-groups-listbox')]//a[text()='Close' and @role='button']")))
							.click();
				} catch (Exception e) {
					try {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath("//*[contains(@id,'pii-admin-user-groups-listbox')]//a[text()='Close' and @role='button']")))
								.click();	
					} catch (Exception e1) {
					}
				}
		//Click on save
			share2.scrollToTop(driver);
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))));
			jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Verify error
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(um.EditUserMessageOnTop)).getText().trim();
		softly.assertThat(message).as("test data").contains("Please select at least one user group");
	}

	public void createExistingUserAndVerifyErrorPopup(WebDriver driver, SoftAssertions softly, String company_id, String password,String email) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		//Clicks on create user
		driver.findElement(By.id("pii-admin-user-create")).click();
		Thread.sleep(2000);
		//Enters mandatory details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-loginname"))).sendKeys(company_id+"testcm");
		driver.findElement(By.id("pii-admin-user-name")).sendKeys(company_id+"testcm");
		driver.findElement(By.id("pii-admin-user-password")).sendKeys(login.decodePassword(password));
		driver.findElement(By.id("pii-admin-user-password-again")).sendKeys(login.decodePassword(password));
//		driver.findElement(By.id("pii-admin-user-company")).sendKeys("Sanity Test");
		driver.findElement(By.id("pii-admin-user-email")).sendKeys(email);
		String ev1 = driver.findElement(By.id("pii-admin-user-name")).getAttribute("value");
		String ev2 = driver.findElement(By.id("pii-admin-user-company")).getAttribute("value");
		String ev3 = driver.findElement(By.id("pii-admin-user-email")).getAttribute("value");
		if ((ev1.equals(company_id+"testcm")==false))
		{
			driver.findElement(By.id("pii-admin-user-name")).clear();
			driver.findElement(By.id("pii-admin-user-name")).sendKeys(company_id);
		}
		/*
		if ((ev2.equals("Sanity Test")==false))
		{
			driver.findElement(By.id("pii-admin-user-company")).clear();
			driver.findElement(By.id("pii-admin-user-company")).sendKeys("Sanity Test");
		}*/
		if ((ev3.equals(email)==false))
		{
			driver.findElement(By.id("pii-admin-user-email")).clear();
			driver.findElement(By.id("pii-admin-user-email")).sendKeys(email);
		}
		Select dd4 = new Select (driver.findElement(By.id("pii-admin-user-customerId")));
		dd4.selectByVisibleText(company_id);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))));
//		driver.findElement(By.id("pii-admin-user-groups-button")).click();
		WebElement ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		jse.executeScript("arguments[0].scrollIntoView();", ele1);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(company_id))));
//		ele1.findElement(By.linkText(company_id)).click();
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		Select dd2 = new Select (driver.findElement(By.id("pii-admin-user-dept")));
		dd2.selectByVisibleText("Accounting");
		Select dd3 = new Select (driver.findElement(By.id("pii-admin-user-jobtitle")));
		dd3.selectByVisibleText("Engineer");	
		//Click on Company Moderator as yes
		driver.findElement(By.xpath(".//*[@for='pii-admin-user-customerAdmin-yes']")).click();
		//Clicks on save button
		share2.scrollToTop(driver);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))));
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))));
		//driver.findElement(By.id("pii-admin-user-button-save")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title")));
		//Clicks on Save button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		Thread.sleep(1000);
		try{
			String error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText();
			softly.assertThat(error).as("test data").isEqualTo("User already exists: "+company_id+"testcm"+".");
			System.out.println(error);
			wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}		
	}
}
