import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import kaleTestSoftware.*;
import kaleTestSoftware.Login;
import kaleTestSoftware.LoginPageObj;
import kaleTestSoftware.ShareCheck;
import kaleTestSoftware.ShareCheck2;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserManagement {

	LoginPageObj lpo = new LoginPageObj();
	Login login = new Login();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	UserManagement2 um2 = new UserManagement2();
	UserManagementPageObj um = new UserManagementPageObj();
	CreateEquipPageObj equip = new CreateEquipPageObj();

	SoftAssertions softly = new SoftAssertions();
	public String emailDevie11 = "fakeemailtestqaaie11dev@gmail.com";
	public String emailDev = "piikaleemailtest01@gmail.com";
	//public String emailDev = "fakeemailtestqaa@gmail.com";
	public String emailUSie11 = "fakeemailtestqaaie11usa@gmail.com";
	public String emailUS = "piikaleemailtest01@gmail.com";
	public String emailAsiaie11 = "fakeemailtestqaaie11asia@gmail.com";
	public String emailAsia = "piikaleemailtest01@gmail.com";
	public String companyPII="pii";
	public String groupPII="pii";
	public String groupAdmin="admin";
	public String company_id1DevAsia="2017qaagroupedit1";
	public String company_id2DevAsia="2017qaagroupedit2";
	public String company_id1DevAsiaIE11="2017ie11qaagroupedit1";
	public String company_id2DevAsiaIE11="2017ie11qaagroupedit2";
	public String company_id1US="2017usqaagroupedit1";
	public String company_id2US="2017usqaagroupedit2";
	public String company_id1USIE11="2017usie11qaagroupedit1";
	public String company_id2USIE11="2017usie11sqaagroupedit2";
	public String group2DevAsia = "2017qaac1g2";
	public String group2DevAsiaIE11 = "2017ie11qaac1g2";
	public String group2US = "2017usqaac1g2";
	public String group2USIE11 = "2017usie11qaac1g2";
	public String company_idDevAsiaUS="aatestqaa";
	public String company_idDevAsiaUSIE11="aasanitytestie";

	public String dummyPassswordEncoded ="RHVtbXlwYXNzQDEyMw==";

	
	public void bugKALE1842 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on admin user name on top right corner
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		}catch(org.openqa.selenium.UnhandledAlertException t)
		{
			driver.switchTo().alert().dismiss();
		}
		//Click on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		if(driver.findElement(By.id("pii-admin-customers-button")).isDisplayed()==false)
		{
			//Click on Accounts
			driver.findElement(By.xpath(".//*[@id='pii-admin-accounts']/h3/a")).click();
		}	
		//Click on Companies
		driver.findElement(By.id("pii-admin-customers-button")).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))).click();
		//Click on collapsible departments sub-departments
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))).click();
		//Pick any one department randomly to un-tick
		//Choose 10 random numbers between 0 to 34
		Random random = new Random();
		int x = random.nextInt(35);
		System.out.println("chosen dept: "+x);
		//Get element's y coordinate
		WebElement dept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dept-table")));
		WebElement l = dept.findElement(By.xpath(".//*[@piiindex='"+x+"']"));
		Point p = l.getLocation();
		int yaxis= p.getY()-250;
		//Scroll to element
		Thread.sleep(2000);
		jse.executeScript("scroll(0,"+yaxis+")");
		Thread.sleep(2000);
		//Uncheck the department
		jse.executeScript("arguments[0].focus();", l);
		jse.executeScript("arguments[0].click();", l);
//		l.click();
		//Scroll up
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		//Click save
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on collapsible departments sub-departments
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))).click();
		//Verify if department is checked
		l=dept.findElement(By.xpath(".//*[@piiindex='"+x+"']"));
		System.out.println(l.isSelected());
		if(l.isSelected()==true)
		{
			softly.fail("department is still showing as checked");
		}
		//Click on edit
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))).click();
		//Click on collapsible departments sub-departments
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))).click();
		//Scroll to element
		Thread.sleep(2000);
		jse.executeScript("scroll(0,"+yaxis+")");
		Thread.sleep(2000);
		//Check the department
		jse.executeScript("arguments[0].focus();", l);
		jse.executeScript("arguments[0].click();", l);
//		l.click();
		//Scroll up
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		//Click save
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Sub-Department
		//Click on edit
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))).click();
		//Click on collapsible departments sub-departments
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))).click();
		//Pick any one department randomly to un-tick
		//Choose a random numbers between 0 to 2
		x = random.nextInt(3);
		System.out.println("chosen dept: "+x);
		//Get element's y coordinate
		WebElement sub = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-subdept-table")));
		l = sub.findElement(By.xpath(".//*[@piiindex='"+x+"']"));
		p = l.getLocation();
		yaxis= p.getY()-250;
		//Scroll to element
		Thread.sleep(2000);
		jse.executeScript("scroll(0,"+yaxis+")");
		Thread.sleep(2000);
		//Uncheck the sub department
		jse.executeScript("arguments[0].focus();", l);
		jse.executeScript("arguments[0].click();", l);
//		l.click();
		//Scroll up
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		//Click save
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on collapsible departments sub-departments
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))).click();
		//Verify if department is checked
		l=sub.findElement(By.xpath(".//*[@piiindex='"+x+"']"));
		System.out.println(l.isSelected());
		if(l.isSelected()==true)
		{
			softly.fail("department is still showing as checked");
		}
		//see if user account can be saved
		//share2.checkIfUserProfileNoFieldsMissing(driver, softly);
		//Logout
		Login obj1 = new Login();
		obj1.logout(driver);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			driver.switchTo().defaultContent();
		}
		Thread.sleep(4000);				
	}

	public void verifyGroupListGroupModeratorChange (WebDriver driver, String company_id1, String company_id2, String group2) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on create user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-create"))).click();
		Thread.sleep(2000);
		//Click on Select group dropdown
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))));
//		driver.findElement(By.id("pii-admin-user-groups-button")).click();
		//Verify Group List is empty
		try{
			driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-menu']/li[1]"));
			softly.fail("No Group list should exist without company selection");
		}catch (NoSuchElementException u)
		{
			System.out.println("Group list empty");
		}
		//Close group pop up
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		share2.scrollToAPoint(driver, 1500);
		//Click on Select group moderator
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-modgroups-button"))));
//		driver.findElement(By.id("pii-admin-user-modgroups-button")).click();
		//Verify Group moderator list is empty
		try{
			driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-menu']/li[1]"));
			softly.fail("No Group moderator list should exist without group selection");
		}catch (NoSuchElementException u)
		{
			System.out.println("Group moderator list empty");
		}
		//Close group moderator pop up
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-listbox-popup']/div/div/a")).click();
		//Select company1
		Select dd = new Select (driver.findElement(By.id("pii-admin-user-customerId")));
		dd.selectByVisibleText(company_id1);
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		//Click on Select group dropdown
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))));
//		driver.findElement(By.id("pii-admin-user-groups-button")).click();
		//Verify group1 of company1 is only present in list
		int c=2;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-menu']/li["+c+"]"));
				String s = driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-menu']/li["+c+"]/a")).getText();
				System.out.println(s);
				softly.assertThat(s).as("test data").isIn(company_id1,group2);
				c=c+1;
			}catch (NoSuchElementException u)
			{
				break;
			}
		}	
		//Select group1
		WebElement ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		jse.executeScript(  "arguments[0].scrollIntoView();", ele1);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(company_id1))));
//		ele1.findElement(By.linkText(company_id1)).click();
		//Close group pop up
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		share2.scrollToAPoint(driver, 1500);
		//Click on Select group moderator
		jse.executeScript("arguments[0].click();", driver.findElement(By.id("pii-admin-user-modgroups-button")));
		//Verify group moderator list
		c=2;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-menu']/li["+c+"]"));
				String s = driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-menu']/li["+c+"]/a")).getText();
				System.out.println(s);
				softly.assertThat(s).as("test data").isEqualTo(company_id1);
				c=c+1;
			}catch (NoSuchElementException u)
			{
				break;
			}
		}
		//Select moderated group 1
		ele1 = driver.findElement(By.id("pii-admin-user-modgroups-menu"));
		ele1.findElement(By.linkText(company_id1)).click();
		//Close group moderator pop up
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-listbox-popup']/div/div/a")).click();
		//Change to company 2
		dd.selectByVisibleText(company_id2);
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		//Click on Select group dropdown
		driver.findElement(By.id("pii-admin-user-groups-button")).click();
		//Verify group2 of company2 is only present in list
		c=2;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-menu']/li["+c+"]"));
				String s = driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-menu']/li["+c+"]/a")).getText();
				System.out.println(s);
				softly.assertThat(s).as("test data").isEqualTo(company_id2);
				c=c+1;
			}catch (NoSuchElementException u)
			{
				break;
			}
		}	
		//Select group2
		ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		ele1.findElement(By.linkText(company_id2)).click();
		//Close group pop up
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		share2.scrollToAPoint(driver, 1500);
		//Scroll intoView Groups
		jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))));
		//Click on Select group moderator
		jse.executeScript("arguments[0].click();", driver.findElement(By.id("pii-admin-user-modgroups-button")));
		//Verify group2 moderator list
		c=2;
		while(true)
		{
			try{
				driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-menu']/li["+c+"]"));
				String s = driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-menu']/li["+c+"]/a")).getText();
				System.out.println(s);
				softly.assertThat(s).as("test data").isEqualTo(company_id2);
				c=c+1;
			}catch (NoSuchElementException u)
			{
				break;
			}
		}
		//Select moderated group 2
		ele1 = driver.findElement(By.id("pii-admin-user-modgroups-menu"));
		ele1.findElement(By.linkText(company_id2)).click();
		//Close group moderator pop up
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-listbox-popup']/div/div/a")).click();
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public void userRetrieveAfterProfileView(WebDriver driver, String company_id, String username, String password, Login obj) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		//Logout and login as admin
		logoutLogin(driver,obj,username,password);		
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Click on Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		//Verify if User profile opened 
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-title"))).getText();
		softly.assertThat(s).as("test data").isEqualTo("User Profile");
		System.out.println(s);
		//Verify if username is displayed
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-loginname"))).getAttribute("value");
		softly.assertThat(s1).as("test data").isEqualTo(username);
		System.out.println(s1);
		Thread.sleep(4000);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Click on Admin
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Click on Accounts
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
		//Click on edit user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-edit"))).click();
		//Searches for newly created user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//Selects the newly created user
		WebElement select = driver.findElement(By.id("pii-admin-user-list"));
		WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		option.click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify login name of new user
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-loginname"))).getAttribute("value");
		System.out.println(s2);
		softly.assertThat(s2).as("test data").isEqualTo(company_id);
	}

	public void companyRetrieveAgain(WebDriver driver, String company_id) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clear company id from search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		//Click enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(Keys.ENTER);
		//Click on new button to create a company with same company id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-new"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title")));
		//Clicks on new company
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		//Enter same company id in company id field
		driver.findElement(By.id("pii-admin-cust-cid")).sendKeys(company_id);
		Thread.sleep(2000);
		//Verify error that company id exists
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-cid-error")));
		String s = ele.getText();
		softly.assertThat(s).as("test data").isEqualTo("This company ID is already in use");
		System.out.println(s);
		Thread.sleep(2000);
		//Enter company id in search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(company_id);
		Thread.sleep(2000);
		//Verify if table is still there
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table")));
		//Click enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//Verify if company comes up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")));
		Thread.sleep(2000);
		//Clear the field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		Thread.sleep(2000);
		//Enter company id in search field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(company_id);
		Thread.sleep(2000);
		//Verify if table is still there
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table")));
		//Verify that company "Not found" does not come up
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td"))).getText();
		softly.assertThat(s1).as("test data").isNotEqualTo("Not found");
		System.out.println(s1);
		//Click enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(Keys.ENTER);
		//Verify if company comes up and click on it
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td"))).click();
		//Verify that company "Not found" does not come up
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td"))).getText();
		softly.assertThat(s2).as("test data").isNotEqualTo("Not found");
		System.out.println(s2);
	}


	public void editGroupCheckAccess(WebDriver driver, String email, String company_id, String username, String password, String []op) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		activateUser(email,company_id,driver);
		//Logs out of admin user
		login.logout(driver);
		//Switches to main content
		driver.switchTo().defaultContent();
		loginAsNewUser(driver, company_id, password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equip.KaleHomePage)).click();
		checkAccess(driver, 0, op);
		Thread.sleep(2000);
		//Logs out
		login.logout(driver);
		//Switches to main content
		driver.switchTo().defaultContent();
		//login as admin
		int login1=login.LoginUser(driver, username, password);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
			if (login1==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException t){
			throw t;
		}
		Thread.sleep(5000);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Accounts
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
		//Clicks on Edit group
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-edit"))).click();
		Thread.sleep(2000);
		//Searches for newly created group
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).sendKeys(company_id);
		driver.findElement(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input")).sendKeys(Keys.ENTER);
		//Selects the newly created group
		WebElement select = driver.findElement(By.id("pii-admin-group-list"));
		WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		option.click();
		//Clicks on group modules list
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-modules-button"))).click();
		WebElement ele = driver.findElement(By.id("pii-admin-group-modules-menu"));
		Thread.sleep(1000);
		//Selects random number to make number of selections between 1 to 25
		Random random = new Random();
		List<Integer> num = new ArrayList<Integer>();
		int n;
		while (true)
		{
			n=random.nextInt(26);
			if (n<1)
				continue;
			break;
		}
		System.out.println(num.size());
		System.out.println("Number of modules: "+n);
		int m;
		num.clear();
		System.out.println(num.size());		
		for (int i=1;i<=n;i++)
		{
			//Picks a number to select a module
			//if(num)
			Collections.sort(num);
			while (true)
			{
				m=random.nextInt(26);
				if (m<1||m==16||m==17)
					continue;
				if(num.contains(m)==true)
					continue;
				break;
			}
			System.out.println(m);
			num.add(m);			
		}
		//Sorts number list
		Collections.sort(num);
		System.out.println(num);
		//Checks for the option selected and checks it
		for (m=0;m<n;m++)
		{
			if(num.get(m)==1)
			{
				//op[m]="Event Reports";
				op[m]="The Error-Free Zone";
			}
			if(num.get(m)==2)
			{
				//op[m]="JIT Wisdom";
				op[m]="Error-Free Document Preparation and Review";
			}
			if(num.get(m)==3)
			{
				//op[m]="JIT Memory Joggers";
				op[m]="Error-Free Instant Root Cause Analysis";
			}
			if(num.get(m)==4)
			{
				//op[m]="Knowledge Bank";
				op[m]="Error-Free Proactive Event Management for Event-Free";
			}
			if(num.get(m)==5)
			{
				//op[m]="Knowledge Exchange";
				op[m]="Error-Free Proactive Safety Management for Injury-Free";
			}
			if(num.get(m)==6)
			{
				//op[m]="Performance Accountability & Analytics";
				op[m]="Error-Free Procedure Design and Use";
			}
			if(num.get(m)==7)
			{
				//op[m]="SPV Error Meter";
				op[m]="Error-Free Technical Error Prevention for Failure-Free Equipment";
			}
			if(num.get(m)==8)
			{
				//op[m]="Human Performance Inspector";
				op[m]="Error-Free Troubleshooting";
			}
			if(num.get(m)==9)
			{
				//op[m]="Systematic Reliability Inspection";
				op[m]="Event Reports";
			}
			if(num.get(m)==10)
			{
				//op[m]="Human Error Instant RCA";
				op[m]="JIT Wisdom";
			}
			if(num.get(m)==11)
			{
				//op[m]="Equipment Failure Instant RCA";
				op[m]="JIT Memory Joggers";
			}
			if(num.get(m)==12)
			{
				//op[m]="Organization & Programmatic Instant RCA";
				op[m]="Knowledge Bank";
			}
			if(num.get(m)==13)
			{
				//op[m]="Instant Common Cause Analysis";
				op[m]="Knowledge Exchange";
			}
			if(num.get(m)==14)
			{
				//op[m]="Job Observation Analysis";
				op[m]="Performance Accountability & Analytics";
			}
			if(num.get(m)==15)
			{
				//op[m]="Error-Free Review";
				op[m]="Decision Instant RCA";
			}
			if(num.get(m)==16)
			{
				//op[m]="Remote Verification";
				op[m]="Error Free Instant Decision Making";
			}
			if(num.get(m)==17)
			{
				//op[m]="eLearning";
				op[m]="Equipment Failure Instant RCA";
			}
			if(num.get(m)==18)
			{
				//op[m]="Error-Free Trainings";
				op[m]="Executive Management Instant RCA";
			}
			if(num.get(m)==19)
			{
				//op[m]="Human Performance";
				op[m]="Error-Free Review";
			}
			if(num.get(m)==20)
			{
				//op[m]="Equipment Performance";
				op[m]="Human Error Instant RCA";
			}
			if(num.get(m)==21)
			{
				//op[m]="Engineering Fundamentals";
				op[m]="Human Performance Inspector";
			}
			if(num.get(m)==22)
			{
				//op[m]="Electrical Failure Modes";
				op[m]="Instant Common Cause Analysis";
			}	
			if(num.get(m)==23)
			{
				//op[m]="Mechanical Failure Modes";
				op[m]="iVerifier";
			}	
			if(num.get(m)==24)
			{
				//op[m]="Prevention of Design Deficiencies";
				op[m]="Job Observation Analysis";
			}	
			if(num.get(m)==25)
			{
				//op[m]="Systematic Reliability Inspection Search";
				op[m]="Organization & Programmatic Instant RCA";
			}	
			//Checks it
			share2.scrollToElement(driver, ele.findElement(By.linkText(op[m])));
			ele.findElement(By.linkText(op[m])).click();
			Thread.sleep(2000);
			String at=ele.findElement(By.linkText(op[m])).getAttribute("class");
			System.out.println(at);	
			if(at.contains("ui-checkbox-on")==false)
				op[m]=op[m]+"**";				
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='pii-admin-group-modules-dialog']/div/div/a")).click();
		//Clicks on save
		driver.findElement(By.id("pii-admin-group-button-save")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title"))).click();
		//Clicks on Save
		driver.findElement(By.id("pii-admin-group-dialog-confirmed")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		//Logs out
		login.logout(driver);
		//Logs in as dummy user
		driver.switchTo().defaultContent();
		loginAsNewUser(driver, company_id, password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(equip.KaleHomePage)).click();
		checkAccess(driver, 0, op);
	}

	public void editPassword(WebDriver driver, String email, String company_id, String username, String password) throws Exception{

		//Mark all messages in inbox as read
		emailMarkRead(email,driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-acct"))).click();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Changes password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-password"))).sendKeys("Dummypass@123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-password-again"))).sendKeys("Dummypass@123");
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Logs out
		login.logout(driver);
		driver.switchTo().defaultContent();
		//Login with new password
		login.LoginUser(driver, company_id, dummyPassswordEncoded);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		//Logs out
		login.logout(driver);
		//Switches to main content
		driver.switchTo().defaultContent();
		int login1 = login.LoginUser(driver, username, password);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
			if (login1==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException t){
			throw t;
		}
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Accounts
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
		//Clicks on Edit user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-edit"))).click();
		Thread.sleep(2000);
		//Searches for newly created user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(Keys.ENTER);
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Selects the newly created user
		WebElement select = driver.findElement(By.id("pii-admin-user-list"));
		WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		option.click();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on reset password send email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-resend-button"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		//Waits for loading message to disappear
		share2.loadingServer(driver);
		//Reads new password from email
		//Get current Time
		long currentTime = System.currentTimeMillis();
		//Add 15 minutes to it
		long time15 = currentTime + (15*60*1000);
		String SMTP_HOST = "smtp.gmail.com";
		String EMAIL_ADDRESS = "piikaleemailtest01@gmail.com";
		//String EMAIL_ADDRESS = email;
		String PASSWORD = "pii@2021";
		//String PASSWORD = "5sepkale";
		String INBOX_FOLDER = "INBOX";	    
		Properties props = new Properties();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("11"))
				props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
			else
				props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
		}
		else if (browserName.contains("safari"))
			props.load(new FileInputStream(new File( "/Users/pamelachiu/Downloads/smtp.properties" )));
		else
			props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect(SMTP_HOST, EMAIL_ADDRESS, PASSWORD);
		Folder inbox = store.getFolder(INBOX_FOLDER);
		inbox.open(Folder.READ_ONLY);
		Flags seen = new Flags(Flags.Flag.SEEN);
		FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
		Message[] messages1 = inbox.search(unseenFlagTerm);
		int messageCount1 = messages1.length;
		while(true)
		{
			Thread.sleep(2000);
			if(currentTime>time15)
			{
				System.out.println("Time elapsed for email: More than 15 minutes");
				excelStore();
				break;
			}
			if (messageCount1>0)
				break;
			messages1 = inbox.getMessages();
			Thread.sleep(1000);
			messages1 = inbox.search(unseenFlagTerm);
			messageCount1 = messages1.length;
		}
		System.out.println("Unread messages: "+messageCount1);
		for (int i = 0; i < messageCount1; i++) {
			Message message1 = messages1[i];
			System.out.println(i);
			System.out.println("Mail Subject:- " + messages1[i].getSubject());
			System.out.println("From: " + message1.getFrom());
			System.out.println("Text: " + message1.getContent().toString());
		}
		String emailText=messages1[messageCount1-1].getContent().toString();
		int n=emailText.indexOf("user account password has been reset to ");
		int e=emailText.indexOf(".</p><p>You may change this after your next login.");
		System.out.println(n);
		String activate=emailText.substring(n+40, e);
		System.out.println(activate);
		inbox.close(true);
		store.close();
		//Logs out
		login.logout(driver);
		//Login with new password
		driver.switchTo().defaultContent();
		//Login button is located and clicked
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button"))).click();
		//Enter Username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-un"))).sendKeys(company_id);
		//Enter password
		driver.findElement(By.id("pii-pw")).sendKeys(activate);
		Thread.sleep(2000);
		driver.findElement(By.id("pii-signin-button")).click();  
		login.waitForIframe(driver);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		//Logs out
		login.logout(driver);
		//Switches to main content
		driver.switchTo().defaultContent();
		//Login as admin
		login1 = login.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());  	
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
			if (login1==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException t){
			throw t;
		}
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Accounts
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
	}

	public String[] allModuleList () throws Exception {

		List<String> text = new ArrayList<String>();
		text.add("The Error-Free Zone");
		text.add("Error-Free Document Preparation and Review");
		text.add("Error-Free Instant Root Cause Analysis");
		text.add("Error-Free Proactive Management for Event-Free");
		text.add("Error-Free Proactive Safety Management for Injury-Free");
		text.add("Error-Free Procedure Design and Use");
		text.add("Error-Free Technical Error Prevention for Failure-Free Equipment");
		text.add("Error-Free Troubleshooting");
		text.add("Event Reports");
		text.add("JIT Wisdom");
		text.add("JIT Memory Joggers");
		text.add("Knowledge Bank");
		text.add("Knowledge Exchange");
		text.add("Performance Accountability & Analytics");
		text.add("Decision Instant RCA");
		text.add("Error Free Instant Decision Making");
		text.add("Equipment Management Instant RCA");
		text.add("Error-Free Review");
		text.add("Human Error Instant RCA");
		text.add("Human Performance Inspector");
		text.add("Instant Common Cause Analysis");
		text.add("iVerifier");
		text.add("Job Observation Analysis");
		text.add("Organization & Programmatic Instant RCA");
		text.add("SPV Error Meter");
		text.add("Systematic Reliability Inspection");
		text.add("eLearning");
		text.add("Error-Free Trainings");
		text.add("Human Performance");
		text.add("DREAM Library");
		text.add("Equipment Data Bank");
		text.add("Engineering Fundamentals");
		text.add("Equipment Performance");
		text.add("Electrical Failure Modes");
		text.add("Mechanical Failure Modes");
		text.add("Prevention of Design Deficiencies");
		text.add("Systematic Reliability Inspection Search");
		String[] list = text.stream().toArray(String[]::new);
		return list;
	}

	public void accessOneModule(WebDriver driver,HashMap<String, String> gpc2g2) throws Exception {

		Thread.sleep(2000);
		String []op = {gpc2g2.get("authorized modules")};
		//Check Access for the one module
		checkAccess(driver, 0, op);
	}

	public void logoutLogin(WebDriver driver, Login obj, String username, String password) throws Exception {

		//Logout as admin/new user
		obj.logout(driver);
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			driver.switchTo().defaultContent();
		}
		Thread.sleep(2000);
		//Login as new user/admin
		int login = obj.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
			if (login==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException |org.openqa.selenium.TimeoutException e){

		}
		//Thread.sleep(5000);
	}

	public void changeGroupCompany (WebDriver driver, String company_id, String groupChange, String companyChange) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Accounts
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
		//Click on edit user
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-edit"))));
		//Verify the message on top in edit user page
		try{
			String message = wait.until(ExpectedConditions.visibilityOfElementLocated(um.EditUserMessageOnTop)).getText().trim();
			softly.assertThat(message).as("test data").isEqualTo("Search and select a login name to edit");
		}catch(org.openqa.selenium.TimeoutException t)
		{

		}
		//Searches for newly created user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input")).sendKeys(Keys.ENTER);
		//Selects the newly created user
		WebElement select = driver.findElement(By.id("pii-admin-user-list"));
		WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		option.click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Change company id
		jse.executeScript("arguments[0].scrollIntoView(true);", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-customerAdmin-buttons"))));
		share2.scrollToElement(driver, driver.findElement(By.id("pii-admin-user-customerId")));
		Select dd1 = new Select (driver.findElement(By.id("pii-admin-user-customerId")));
		dd1.selectByVisibleText(companyChange);
		//Select pii group
//		share2.scrollToElement(driver, driver.findElement(By.id("pii-admin-user-groups-button")));
//		driver.findElement(By.id("pii-admin-user-groups-button")).click();
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))));
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(3000);
		WebElement ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		jse.executeScript("arguments[0].scrollIntoView();", ele1);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(groupChange))));
//		ele1.findElement(By.linkText(groupChange)).click();
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a"))));
//		driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		//Click on save
		WebElement savebtn = driver.findElement(By.id("pii-admin-user-button-save"));
		jse.executeScript("arguments[0].click()", savebtn);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-save"))).click();
		jse.executeScript("arguments[0].click()",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))));
		Thread.sleep(500);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
	}

	public void verifyGroupFields(WebDriver driver, HashMap<String, String>op) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);	
		//Get group name
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-name"))).getAttribute("value");
		//Verify group name in hashmap
		softly.assertThat(s).as("test data").isEqualTo(op.get("group name"));
		//Get company id
		String s1 = driver.findElement(By.id("pii-admin-group-cid")).getAttribute("value");
		//Verify company id in hashmap 
		softly.assertThat(s1).as("test data").isEqualTo(op.get("company id"));
		//Get expiration date 
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-expDate"))).getAttribute("value");
		String sub = s2.substring(s2.length()-2, s2.length());
		int n = Integer.parseInt(sub);
		n=n+1;
		String modifiedDate = s2.substring(0, s2.length()-2) + n;
		//Verify expiration date in hashmap 
		softly.assertThat(modifiedDate).as("test data").isEqualTo(op.get("expiration date"));
		//Get authorized cases
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-cases"))).getAttribute("value");
		//Verify authorized cases in hashmap
		softly.assertThat(s3).as("test data").isEqualTo(op.get("authorized cases"));
		/*
		//Get authorized modules
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-modules-button']/span"))).getText();
		//Verify authorized modules in hashmap
		softly.assertThat(s4).as("test data").isEqualTo(op.get("authorized modules"));*/
	}

	 public void groupView (WebDriver driver, String company_id1, String company_id2, String group2, HashMap<String, String>opc1g1,HashMap<String, String>opc1g2,HashMap<String, String>opc2g2) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,20);	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on Companies
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-customers-button"))).click();
		//Enters company id in ID field 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id1);
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on newly created company id
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))).click();
		//Get name of group to verify if group name is as expected
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-groups-jsgrid']/div[2]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(s).as("test data").isEqualTo(company_id1);
		//Click on group under company
		share2.scrollToAPoint(driver, 400);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-groups-jsgrid']/div[2]/table/tbody/tr[2]/td[1]"))));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify if group fields are as expected
		verifyGroupFields(driver, opc1g1);
		//Edit the group by changing the expiration date
		//Open pop up for expiration date
		driver.findElement(By.xpath(".//*[@title='Open Date Picker']")).click();
		Thread.sleep(2000);
		//Click on + sign for next month
		//WebElement ele1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-datebox-gridplus"))).click();
		Thread.sleep(2000);
		//Select a date
		WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-datebox-grid")));
		ele1.findElement(By.xpath(".//*[@class='ui-datebox-gridrow ui-datebox-gridrow-last']/div[1]")).click();
		//Clicks on save
		driver.findElement(By.id("pii-admin-group-button-save")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title")));
		//Clicks on Save
		driver.findElement(By.id("pii-admin-group-dialog-confirmed")).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on Companies
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-customers-button"))).click();
		//Enters company id in ID field 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id1);
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on newly created company id
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))).click();
		//Get name of group to verify if group name is as expected
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-groups-jsgrid']/div[2]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(s3).as("test data").isEqualTo(group2);
		//Click on group under company
		share2.scrollToAPoint(driver, 400);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-groups-jsgrid']/div[2]/table/tbody/tr[1]/td[1]"))));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify if group fields are as expected
		verifyGroupFields(driver, opc1g2);
		//Click on Companies
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-customers-button"))));
		//Enters company id in ID field 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id2);
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on newly created company id
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on edit
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))));
		//Get name of group to verify if group name is as expected
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-groups-jsgrid']/div[2]/table/tbody/tr/td[1]"))).getText();
		softly.assertThat(s4).as("test data").isEqualTo(company_id2);
		//Click on group under company
		share2.scrollToAPoint(driver, 400);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-groups-jsgrid']/div[2]/table/tbody/tr/td[1]"))));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify if group fields are as expected
		verifyGroupFields(driver, opc2g2);
	}

	public String[] chooseModule(WebDriver driver, List<Integer> num, int n, WebElement ele) throws Exception{

		String[]op=new String [30];
		//Checks for the option selected and checks it
		for (int m=0;m<n;m++)
		{
			if(num.get(m)>=16)
			{
				share2.scrollToAPoint(driver, 1500);
			}
			if(num.get(m)==1)
			{
				//op[m]="Event Reports";
				op[m]="The Error-Free Zone";
			}
			if(num.get(m)==2)
			{
				//op[m]="JIT Wisdom";
				op[m]="Error-Free Document Preparation and Review";
			}
			if(num.get(m)==3)
			{
				//op[m]="JIT Memory Joggers";
				op[m]="Error-Free Instant Root Cause Analysis";
			}
			if(num.get(m)==4)
			{
				//op[m]="Knowledge Bank";
				op[m]="Error-Free Proactive Event Management for Event-Free";
			}
			if(num.get(m)==5)
			{
				//op[m]="Knowledge Exchange";
				op[m]="Error-Free Proactive Safety Management for Injury-Free";
			}
			if(num.get(m)==6)
			{
				//op[m]="Performance Accountability & Analytics";
				op[m]="Error-Free Procedure Design and Use";
			}
			if(num.get(m)==7)
			{
				//op[m]="SPV Error Meter";
				op[m]="Error-Free Technical Error Prevention for Failure-Free Equipment";
			}
			if(num.get(m)==8)
			{
				//op[m]="Human Performance Inspector";
				op[m]="Error-Free Troubleshooting";
			}
			if(num.get(m)==9)
			{
				//op[m]="Systematic Reliability Inspection";
				op[m]="Event Reports";
			}
			if(num.get(m)==10)
			{
				//op[m]="Human Error Instant RCA";
				op[m]="JIT Wisdom";
			}
			if(num.get(m)==11)
			{
				//op[m]="Equipment Failure Instant RCA";
				op[m]="JIT Memory Joggers";
			}
			if(num.get(m)==12)
			{
			//op[m]="Organization & Programmatic Instant RCA";
				op[m]="Knowledge Bank";
			}
			if(num.get(m)==13)
			{
				//op[m]="Instant Common Cause Analysis";
				op[m]="Knowledge Exchange";
			}
			if(num.get(m)==14)
			{
				//op[m]="Job Observation Analysis";
				op[m]="Performance Accountability & Analytics";
			}
			if(num.get(m)==15)
			{
				//op[m]="Error-Free Review";
				op[m]="Decision Instant RCA";
			}
			if(num.get(m)==16)
			{
				//op[m]="Remote Verification";
				op[m]="Error Free Instant Decision Making";
			}
			if(num.get(m)==17)
			{
				share2.scrollToAPoint(driver, 1500);
				//op[m]="eLearning";
				op[m]="Equipment Failure Instant RCA";
			}
			if(num.get(m)==18)
			{
				//op[m]="Error-Free Trainings";
				op[m]="Executive Management Instant RCA";
			}
			if(num.get(m)==19)
			{
				//op[m]="Human Performance";
				op[m]="Error-Free Review";
			}
			if(num.get(m)==20)
			{
				//op[m]="Equipment Performance";
				op[m]="Human Error Instant RCA";
			}
			if(num.get(m)==21)
			{
				//op[m]="Engineering Fundamentals";
				op[m]="Human Performance Inspector";
}
			if(num.get(m)==22)
			{
				op[m]="Electrical Failure Modes";
				op[m]="Instant Common Cause Analysis";
			}	
			if(num.get(m)==23)
			{
				//op[m]="Mechanical Failure Modes";
				op[m]="iVerifier";
			}
			if(num.get(m)==24)
			{
				//op[m]="Prevention of Design Deficiencies";
				op[m]="Job Observation Analysis";
			}
			if(num.get(m)==25)
			{
				//op[m]="Systematic Reliability Inspection Search";
				op[m]="Organization & Programmatic Instant RCA";
			}	
			
			//Checks it
			share2.scrollToElement(driver, ele.findElement(By.linkText(op[m])));
			ele.findElement(By.linkText(op[m])).click();
			Thread.sleep(2000);
			String at=ele.findElement(By.linkText(op[m])).getAttribute("class");
			System.out.println(at);	
			if(at.contains("ui-checkbox-on")==false)
				op[m]=op[m]+"**";				
		}
		share2.scrollToTop(driver);
		return op;
	}

	public String [] createGroupWithRandomModules (WebDriver driver, String company_id, String groupname) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		Thread.sleep(2000);
		//Clicks on create group
		driver.findElement(By.id("pii-admin-group-create")).click();
		Thread.sleep(2000);
		//Fills all mandatory 
		driver.findElement(By.id("pii-admin-group-name")).clear();
		driver.findElement(By.id("pii-admin-group-name")).sendKeys(groupname);
		driver.findElement(By.id("pii-admin-group-cases")).clear();
		driver.findElement(By.id("pii-admin-group-cases")).sendKeys("ALL");
		String ev1 = driver.findElement(By.id("pii-admin-group-name")).getAttribute("value");
		String ev2 = driver.findElement(By.id("pii-admin-group-cases")).getAttribute("value");
		if ((ev1.equals(groupname)==false))
		{
			driver.findElement(By.id("pii-admin-group-name")).clear();
			driver.findElement(By.id("pii-admin-group-name")).sendKeys(groupname);
		}
		if ((ev2.equals("all")==false))
		{
			driver.findElement(By.id("pii-admin-group-cases")).clear();
			driver.findElement(By.id("pii-admin-group-cases")).sendKeys("ALL");
		}
		WebElement element = driver.findElement(By.id("pii-admin-group-cid"));
		Select dropdown = new Select (element);
		dropdown.selectByVisibleText(company_id);
		//Choose random number
		Random random = new Random();
		int n;
		List<Integer> num = new ArrayList<Integer>();
		while (true)
		{
			n=random.nextInt(20);
			if (n<1)
				continue;
			break;
		}
		System.out.println(num.size());
		System.out.println("Number of modules: "+n);
		int m;
		for (int i=1;i<=n;i++)
		{
			//Picks a number to select a module
			Collections.sort(num);
			while (true)
			{
				m=random.nextInt(22);
				if (m<1||m==16||m==17)
					continue;
				if(num.contains(m)==true)
					continue;
				break;
			}
			num.add(m);			
		}
		driver.findElement(By.id("pii-admin-group-modules-button")).click();
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-modules-menu")));
		//Choose module, Number of modules =n =1
		String [] op = chooseModule(driver,num,n, ele);
		System.out.println(Arrays.toString(op));
		try{
			driver.findElement(By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete")).click();
		}catch (NoSuchElementException e)
		{
			driver.findElement(By.xpath(".//*[@id='pii-admin-group-modules-dialog']/div/div/a")).click();
		}
		catch (ElementNotInteractableException e1)
		{
			driver.findElement(By.xpath(".//*[@id='pii-admin-group-modules-dialog']/div/div/a")).click();
		}
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title")));
		//Clicks on Save
		driver.findElement(By.id("pii-admin-group-dialog-confirmed")).click();
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		System.out.println("Group created");
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		return op;
	}

	
	public HashMap<String,String> createGroupWithExpirationDate (WebDriver driver, String company_id, String group) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		//Clicks on create group
		driver.findElement(By.id("pii-admin-group-create")).click();
		Thread.sleep(2000);
		//Fills all mandatory 
		driver.findElement(By.id("pii-admin-group-name")).clear();
		driver.findElement(By.id("pii-admin-group-name")).sendKeys(group);
		driver.findElement(By.id("pii-admin-group-cases")).clear();
		driver.findElement(By.id("pii-admin-group-cases")).sendKeys("ALL");
		String ev1 = driver.findElement(By.id("pii-admin-group-name")).getAttribute("value");
		String ev2 = driver.findElement(By.id("pii-admin-group-cases")).getAttribute("value");
		if ((ev1.equals(group)==false))
		{
			driver.findElement(By.id("pii-admin-group-name")).clear();
			driver.findElement(By.id("pii-admin-group-name")).sendKeys(group);
		}
		if ((ev2.equals("all")==false))
		{
			driver.findElement(By.id("pii-admin-group-cases")).clear();
			driver.findElement(By.id("pii-admin-group-cases")).sendKeys("ALL");
		}
		WebElement element = driver.findElement(By.id("pii-admin-group-cid"));
		Select dropdown = new Select (element);
		dropdown.selectByVisibleText(company_id);
		/*
		//Choose random number
		Random random = new Random();
		List<Integer> num = new ArrayList<Integer>();
		int num1;
		//Choose a number between 1 and 19 (does not include failure modes)
		while(true)
		{
			num1 = random.nextInt(20);
			System.out.println(num1);
			if(num1<1||num1==16||num1==17)
				continue;
			else break;
		}
		System.out.println("Number chosen "+num1);
		num.add(num1);
		//Click on Authorized module
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-modules-button"))));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-modules-menu")));
		//Choose module, Number of modules =n =1
		String [] op = chooseModule(driver,num,1, ele);
		System.out.println(Arrays.toString(op));
		try {
			driver.findElement(By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete")).click();
		} catch (Exception e) {
			try {
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-modules-dialog']/div/div/a"))));
			} catch (Exception e1) {
			}
			
		}
		*/
		//Fill expiration date
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@title='Open Date Picker']"))).click();
		Thread.sleep(2000);
		//Click on + sign for next month
		//WebElement ele1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='ui-popup-container fade in ui-popup-active']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-datebox-gridplus"))).click();
		Thread.sleep(2000);
		//Select a date
		WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-datebox-grid")));
		ele1.findElement(By.xpath(".//*[@class='ui-datebox-gridrow ui-datebox-gridrow-last']/div[5]")).click();
		//Clicks on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title")));
		//Clicks on Save
		driver.findElement(By.id("pii-admin-group-dialog-confirmed")).click();
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		System.out.println("Group created");
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Hashmap for group properties
		HashMap<String, String> gp = new HashMap<String,String>();
		//Get group name
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-name"))).getAttribute("value");
		//Add group name to hashmap gp
		gp.put("group name", s);
		//Get company id
		String s1 = driver.findElement(By.id("pii-admin-group-cid")).getAttribute("value");
		//Add company id to hashmap gp
		gp.put("company id", s1);
		//Get expiration date 
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-expDate"))).getAttribute("value");
		//Add expiration date to hashmap gp
		gp.put("expiration date", s2);
		//Get authorized cases
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-cases"))).getAttribute("value");
		//Add authorized cases to hashmap gp
		gp.put("authorized cases", s3);
		//Get authorized modules
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-modules-button']/span"))).getText();
		/*
		//Add authorized modules to hashmap gp
		gp.put("authorized modules", s4);*/
		System.out.println("printOutHashmapResultfor_CompanyN_groupN:  "+gp);
		return gp;
	}

	public void activateUser(String email,String company_id, WebDriver driver)throws Exception {

		//Get current Time
		long currentTime = System.currentTimeMillis();
		//Add 15 minutes to it
		long time15 = currentTime + (1*60*1000);
//		long time15 = currentTime + (15*60*1000);
		String SMTP_HOST = "smtp.gmail.com";
		String EMAIL_ADDRESS = "piikaleemailtest01@gmail.com";
		//String EMAIL_ADDRESS = email;
		String PASSWORD = "pii@2021";
		//String PASSWORD = "5sepkale";
		String INBOX_FOLDER = "INBOX";	    
		Properties props = new Properties();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("11"))
				props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
			else
				props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
		}		
		else if (browserName.contains("safari"))
			props.load(new FileInputStream(new File( "/Users/pamelachiu/Downloads/smtp.properties" )));
		else
			props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect(SMTP_HOST, EMAIL_ADDRESS, PASSWORD);
		Folder inbox = store.getFolder(INBOX_FOLDER);
		inbox.open(Folder.READ_ONLY);
		int messageCount = inbox.getMessageCount(); 
		System.out.println("Total Messages:- " + messageCount);
		
		Flags seen = new Flags(Flags.Flag.SEEN);
		FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
		Message[] messages1 = inbox.search(unseenFlagTerm);
		int messageCount1 = messages1.length;
		while(true)
		{
			Thread.sleep(2000);
			if(currentTime>time15)
			{
				System.out.println("Time elapsed for email: More than 15 minutes");
				excelStore();
				break;
			}
			if (messageCount1>0)
				break;
			messages1 = inbox.getMessages();
			Thread.sleep(1000);
			messages1 = inbox.search(unseenFlagTerm);
			messageCount1 = messages1.length;
		}
		System.out.println("Unread messages: "+messageCount1);
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < messageCount1; i++) {
			Message message1 = messages1[i];
			System.out.println(i);
			System.out.println("Mail Subject:- " + messages1[i].getSubject());
			System.out.println("From: " + message1.getFrom());
			System.out.println("Text: " + message1.getContent().toString());
			String subject=messages1[i].getSubject();
			if((subject.contains("Account Activation - Email 1/2"))&&(subject.contains("KALE")))
			{
				sb= new StringBuffer( message1.getContent().toString());
				String content = sb.toString();
				if(content.contains(company_id))
				{
					break;
				}
			}
		}
		
	
		String emailText=sb.toString();
		int n=emailText.indexOf("https");
		int e=emailText.indexOf(">click ");
		System.out.println();
		String activate=emailText.substring(n, e-1);
		System.out.println(activate);
		inbox.close(true);
		store.close();
		//Open activate URL in new window
		//Get Browser value
		WebDriver driver2 = null;
		//chrome
		if(browserName.equals("chrome"))
		{
			driver2= new ChromeDriver();
		}
		//firefox
		if(browserName.equals("firefox"))
		{
			driver2= new FirefoxDriver();
		}
		//ie
		if(browserName.equals("internet explorer"))
		{
			driver2= new InternetExplorerDriver();
		}        
		driver2.get(activate);
		Thread.sleep(2000);
		driver2.quit();
		//Wait for 10 seconds
		Thread.sleep(10000);
	}
	


	public void activateUserIE11(String email,WebDriver driver)throws Exception {

		//Get current Time
		long currentTime = System.currentTimeMillis();
		//Add 15 minutes to it
		long time15 = currentTime + (15*60*1000);
		String SMTP_HOST = "smtp.gmail.com";
		String EMAIL_ADDRESS = "piikaleemailtest01@gmail.com";
		//String EMAIL_ADDRESS = email;
		String PASSWORD = "pii@2021";
		//String PASSWORD = "5sepkale";
		String INBOX_FOLDER = "INBOX";	    
		Properties props = new Properties();
		props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect(SMTP_HOST, EMAIL_ADDRESS, PASSWORD);
		Folder inbox = store.getFolder(INBOX_FOLDER);
		inbox.open(Folder.READ_ONLY);
		int messageCount = inbox.getMessageCount(); 
		System.out.println("Total Messages:- " + messageCount);
		Flags seen = new Flags(Flags.Flag.SEEN);
		FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
		Message[] messages1 = inbox.search(unseenFlagTerm);
		int messageCount1 = messages1.length;
		while(true)
		{
			Thread.sleep(2000);
			if(currentTime>time15)
			{
				System.out.println("Time elapsed for email: More than 15 minutes");
				excelStore();
				break;
			}
			if (messageCount1>0)
				break;
			messages1 = inbox.getMessages();
			Thread.sleep(1000);
			messages1 = inbox.search(unseenFlagTerm);
			messageCount1 = messages1.length;
		}
		System.out.println("Unread messages: "+messageCount1);
		for (int i = 0; i < messageCount1; i++) {
			Message message1 = messages1[i];
			System.out.println(i);
			System.out.println("Mail Subject:- " + messages1[i].getSubject());
			System.out.println("From: " + message1.getFrom());
			System.out.println("Text: " + message1.getContent().toString());
		}
		String emailText=messages1[messageCount1-1].getContent().toString();
		int n=emailText.indexOf("https");
		int e=emailText.indexOf(">click ");
		System.out.println();
		String activate=emailText.substring(n, e-1);
		System.out.println(activate);
		inbox.close(true);
		store.close();
		//Open activate URL in new window
		//Get Browser value
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		WebDriver driver2 = null;
		//chrome
		if(browserName.equals("chrome"))
		{
			driver2= new ChromeDriver();
		}
		//firefox
		if(browserName.equals("firefox"))
		{
			driver2= new FirefoxDriver();
		}
		//ie
		if(browserName.equals("internet explorer"))
		{
			driver2= new InternetExplorerDriver();
		}        
		driver2.get(activate);
		Thread.sleep(2000);
		driver2.quit();
		//Wait for 10 seconds
		Thread.sleep(10000);
	}

	public void emailMarkRead(String email, WebDriver driver) throws Exception{

		String SMTP_HOST = "smtp.gmail.com";
		String EMAIL_ADDRESS = "piikaleemailtest01@gmail.com";    //"username@gmail.com"
		String PASSWORD = "pii@2021";    //password
		String INBOX_FOLDER = "INBOX";	    
		Properties props = new Properties();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		System.out.println(v);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("11"))
				props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
			else
				props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
		}
		else if (browserName.contains("safari"))
			props.load(new FileInputStream(new File( "/Users/pamelachiu/Downloads/smtp.properties" )));
		else
			props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect(SMTP_HOST, EMAIL_ADDRESS, PASSWORD);
		Folder inbox = store.getFolder(INBOX_FOLDER);
		inbox.open(Folder.READ_WRITE);
		Message[] messages = inbox.getMessages();
		inbox.setFlags(messages, new Flags(Flags.Flag.SEEN), true);
		System.out.println("Marked all messages read");	    
		inbox.close(true);
		store.close();
	}

	public void emailMarkReadIE11(String email) throws Exception{

		String SMTP_HOST = "smtp.gmail.com";
		String EMAIL_ADDRESS = "piikaleemailtest01@gmail.com";
		//String EMAIL_ADDRESS = email;
		String PASSWORD = "pii@2021";
		//String PASSWORD = "5sepkale";
		String INBOX_FOLDER = "INBOX";	    
		Properties props = new Properties();
		props.load(new FileInputStream(new File( "C:\\property\\smtp.properties" )));
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect(SMTP_HOST, EMAIL_ADDRESS, PASSWORD);
		Folder inbox = store.getFolder(INBOX_FOLDER);
		inbox.open(Folder.READ_WRITE);
		Message[] messages = inbox.getMessages();
		inbox.setFlags(messages, new Flags(Flags.Flag.SEEN), true);
		System.out.println("Marked all messages read");	    
		inbox.close(true);
		store.close();
	}

	public void deletesPreviousCMUser (WebDriver driver, String usercm) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		if(driver.findElement(By.id("pii-admin-customers-button")).isDisplayed()==false)
		{
			//Clicks on Accounts
			driver.findElement(By.xpath(".//*[@id='pii-admin-accounts']/h3/a")).click();
		}		  
		//Clicks on Edit user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-edit"))).click();
		Thread.sleep(2000);
		//Searches for newly created user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(usercm);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(Keys.ENTER);
		try{
			WebElement select = driver.findElement(By.id("pii-admin-user-list"));
			select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).clear();
			Thread.sleep(1000);
			deleteUser(driver, usercm);
		}catch (NoSuchElementException u1)
		{

		}
	}

	public void deletesPreviousGroup (WebDriver driver, String group2) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		um2.verifyNoCompanyIdError(driver,softly);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		if(driver.findElement(By.id("pii-admin-customers-button")).isDisplayed()==false)
		{
			//Clicks on Accounts
			driver.findElement(By.xpath(".//*[@id='pii-admin-accounts']/h3/a")).click();
		}		  
		//Clicks on Edit group
		driver.findElement(By.id("pii-admin-group-edit")).click();
		Thread.sleep(2000);
		//Searches for newly created group
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).sendKeys(group2);
		driver.findElement(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input")).sendKeys(Keys.ENTER);
		try{
			WebElement select = driver.findElement(By.id("pii-admin-group-list"));
			select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).clear();
			Thread.sleep(1000);
			deleteGroup(driver, group2);
		}catch (NoSuchElementException u1)
		{

		}
	}

	public void deletesPrevious (WebDriver driver, String company_id) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		if(driver.findElement(By.id("pii-admin-customers-button")).isDisplayed()==false)
		{
			//Clicks on Accounts
			driver.findElement(By.xpath(".//*[@id='pii-admin-accounts']/h3/a")).click();
		}		  
		//Clicks on Companies
		driver.findElement(By.id("pii-admin-customers-button")).click();
		//Enters company id in ID field 
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id);
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String comp = driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).getText();
		System.out.println("printOutCompanyIDPoolName:  "+comp);
		if(comp.contains(company_id))
		{
			//delete company, group, user
			//Goes to edit user and searches for user
			//Clicks on Edit user
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-edit"))).click();
			Thread.sleep(2000);
			//Searches for newly created user
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(Keys.ENTER);
			try{
				WebElement select = driver.findElement(By.id("pii-admin-user-list"));
				select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).clear();
				Thread.sleep(1000);
				deleteUser(driver, company_id);
				deleteGroup(driver, company_id);
				deleteCompany(driver, company_id);
			}catch (NoSuchElementException u)
			{
				//Clicks on Edit group
				driver.findElement(By.id("pii-admin-group-edit")).click();
				Thread.sleep(2000);
				//Searches for newly created group
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).sendKeys(company_id);
				driver.findElement(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input")).sendKeys(Keys.ENTER);
				try{
					WebElement select = driver.findElement(By.id("pii-admin-group-list"));
					select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).clear();
					Thread.sleep(1000);
					deleteGroup(driver, company_id);
					deleteCompany(driver, company_id);
				}catch (NoSuchElementException u1)
				{
					deleteCompany(driver, company_id);
				}
			}
		}
		else
		{
			System.out.println("Company does not exist, it can be created");
		}
		//Wait for loading message to disappear
		share2.loadingServer(driver);
	}

	public void createCompany (WebDriver driver, String company_id) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on companies
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-customers-button"))).click();
		Thread.sleep(2000);
		//CLicks on new button
		driver.findElement(By.id("pii-admin-cust-button-new")).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title")));
		//Clicks on new company
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		//Verify error
		um2.verifyErrorOnCompanyPage(driver, softly);
		//Fills all mandatory details
		driver.findElement(By.id("pii-admin-cust-cid")).sendKeys(company_id);
		driver.findElement(By.id("pii-admin-cust-name")).sendKeys("Sanity Test");
		driver.findElement(By.id("pii-admin-cust-address")).sendKeys("Sanity Test");
		driver.findElement(By.id("pii-admin-cust-tel")).sendKeys("123456");
		driver.findElement(By.id("pii-admin-cust-busCts")).sendKeys("Sanity Test");
		driver.findElement(By.id("pii-admin-cust-tecCts")).sendKeys("Sanity Test"); 
		String ev1 = driver.findElement(By.id("pii-admin-cust-cid")).getAttribute("value");
		String ev2 = driver.findElement(By.id("pii-admin-cust-name")).getAttribute("value");
		String ev3 = driver.findElement(By.id("pii-admin-cust-address")).getAttribute("value");
		String ev4 = driver.findElement(By.id("pii-admin-cust-tel")).getAttribute("value");
		String ev5 = driver.findElement(By.id("pii-admin-cust-busCts")).getAttribute("value");
		String ev6 = driver.findElement(By.id("pii-admin-cust-tecCts")).getAttribute("value");
		if ((ev1.equals(company_id)==false))
		{
			driver.findElement(By.id("pii-admin-cust-cid")).clear();
			driver.findElement(By.id("pii-admin-cust-cid")).sendKeys(company_id);
		}
		if ((ev2.equals("Sanity Test")==false))
		{
			driver.findElement(By.id("pii-admin-cust-name")).clear();
			driver.findElement(By.id("pii-admin-cust-name")).sendKeys("Sanity Test");
		}
		if ((ev3.equals("Sanity Test")==false))
		{
			driver.findElement(By.id("pii-admin-cust-address")).clear();
			driver.findElement(By.id("pii-admin-cust-address")).sendKeys("Sanity Test");
		}
		if ((ev4.equals("123456")==false))
		{
			driver.findElement(By.id("pii-admin-cust-tel")).clear();
			driver.findElement(By.id("pii-admin-cust-tel")).sendKeys("123456");
		}
		if ((ev5.equals("Sanity Test")==false))
		{
			driver.findElement(By.id("pii-admin-cust-busCts")).clear();
			driver.findElement(By.id("pii-admin-cust-busCts")).sendKeys("Sanity Test");
		}
		if ((ev6.equals("Sanity Test")==false))
		{
			driver.findElement(By.id("pii-admin-cust-tecCts")).clear();
			driver.findElement(By.id("pii-admin-cust-tecCts")).sendKeys("Sanity Test");
		}
		
		  //Click on departments collapsible
		  jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
		  //Scroll down
		  WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-subdept-input")));
		  Point p = ele.getLocation();
		  int yaxis= p.getY()-250;
		  //Scroll to element
		  Thread.sleep(2000);
		  jse.executeScript("scroll(0,"+yaxis+")");
		  Thread.sleep(2000);
		  //Enter a few sub departments
		  jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		  ele.clear();
		  ele.sendKeys("QAA 1");
		  ele.sendKeys(Keys.ENTER);
		  //Click on add 
		  jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))));
		  ele.clear();
		  ele.sendKeys("QAA 2");
		  ele.sendKeys(Keys.ENTER);
		  //Click on add 
		  jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))));
		  ele.clear();
		  ele.sendKeys("QAA 3");
		  ele.sendKeys(Keys.ENTER);
		  //Click on add 
		  jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))));
		  //Scroll top
		  Thread.sleep(2000);
		  share2.scrollToTop(driver);
		  Thread.sleep(2000);
		 
		//Clicks on save
		  jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title")));
		//Clicks on create company
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))));
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText();
			softly.assertThat(s).as("test data").contains("Company created");
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Enters company id in ID field 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(company_id);
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input")).sendKeys(Keys.ENTER);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on newly created company id
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		System.out.println("Company created");
		//Add subdepartments
		if((company_id.equals(company_idDevAsiaUS)==false)&&(company_id.equals(company_idDevAsiaUSIE11)==false))
			addSubDepartments(driver);
		else
			um2.companyChangeAddress(driver, company_id, softly);
	}

	public void verifyModuleList(WebDriver driver, WebElement ele) throws Exception {

		Thread.sleep(2000);
		ele.findElement(By.linkText("The Error-Free Zone"));
		ele.findElement(By.linkText("Error-Free Document Preparation and Review"));
		ele.findElement(By.linkText("Error-Free Instant Root Cause Analysis"));
		ele.findElement(By.linkText("Error-Free Proactive Event Management for Event-Free"));
		ele.findElement(By.linkText("Error-Free Proactive Safety Management for Injury-Free"));
		ele.findElement(By.linkText("Error-Free Procedure Design and Use"));
		ele.findElement(By.linkText("Error-Free Technical Error Prevention for Failure-Free Equipment"));
		ele.findElement(By.linkText("Error-Free Troubleshooting"));
		ele.findElement(By.linkText("Event Reports"));
		ele.findElement(By.linkText("JIT Wisdom"));
		ele.findElement(By.linkText("JIT Memory Joggers"));
		ele.findElement(By.linkText("Knowledge Bank"));
		ele.findElement(By.linkText("Knowledge Exchange"));
		ele.findElement(By.linkText("Performance Accountability & Analytics"));
		ele.findElement(By.linkText("SPV Error Meter"));
		ele.findElement(By.linkText("Human Performance Inspector"));
		ele.findElement(By.linkText("Systematic Reliability Inspection"));
		ele.findElement(By.linkText("Human Error Instant RCA"));
		ele.findElement(By.linkText("Decision Instant RCA"));
		ele.findElement(By.linkText("Error Free Instant Decision Making"));
		ele.findElement(By.linkText("Executive Management Instant RCA"));
		ele.findElement(By.linkText("Equipment Failure Instant RCA"));
		ele.findElement(By.linkText("Organization & Programmatic Instant RCA"));
		ele.findElement(By.linkText("Instant Common Cause Analysis"));
		ele.findElement(By.linkText("Job Observation Analysis"));
		ele.findElement(By.linkText("Error-Free Review"));
		ele.findElement(By.linkText("iVerifier"));
		ele.findElement(By.linkText("eLearning"));
		ele.findElement(By.linkText("Error-Free Trainings"));
		ele.findElement(By.linkText("Human Performance"));
		ele.findElement(By.linkText("DREAM Library"));
		ele.findElement(By.linkText("Equipment Data Bank"));
		ele.findElement(By.linkText("Engineering Fundamentals"));
		ele.findElement(By.linkText("Equipment Performance"));
		ele.findElement(By.linkText("Electrical Failure Modes"));
		ele.findElement(By.linkText("Mechanical Failure Modes"));
		ele.findElement(By.linkText("Prevention of Design Deficiencies"));
		ele.findElement(By.linkText("Systematic Reliability Inspection Search"));
	}

	public void createGroup (WebDriver driver, String company_id) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		//Clicks on create group
		driver.findElement(By.id("pii-admin-group-create")).click();
		Thread.sleep(2000);
		//Clicks on save
		driver.findElement(By.id("pii-admin-group-button-save")).click();
		String groupNameError = driver.findElement(By.xpath(".//*[@id='pii-admin-group-messages']/div")).getText();
		softly.assertThat(groupNameError).as("test data").contains("Warning - Cannot Save: a group must have a group name specified.");
		//Fills all mandatory 
		driver.findElement(By.id("pii-admin-group-name")).sendKeys(company_id);
		String ev1 = driver.findElement(By.id("pii-admin-group-name")).getAttribute("value");
		if ((ev1.equals(company_id)==false))
		{
			driver.findElement(By.id("pii-admin-group-name")).clear();
			driver.findElement(By.id("pii-admin-group-name")).sendKeys(company_id);
		}
		//Clicks on save
		driver.findElement(By.id("pii-admin-group-button-save")).click();
		String groupCompError = driver.findElement(By.xpath(".//*[@id='pii-admin-group-messages']/div")).getText();
		softly.assertThat(groupCompError).as("test data").contains("Warning - Cannot Save: a group must have a company id specified.");
		WebElement element = driver.findElement(By.id("pii-admin-group-cid"));
		Select dropdown = new Select (element);
		dropdown.selectByVisibleText(company_id);
		//Clicks on save
		driver.findElement(By.id("pii-admin-group-button-save")).click();
		String groupCaseError = driver.findElement(By.xpath(".//*[@id='pii-admin-group-messages']/div")).getText();
		softly.assertThat(groupCaseError).as("test data").contains("Error: Authorized Cases field is required");
		driver.findElement(By.id("pii-admin-group-cases")).sendKeys("all");
		String ev2 = driver.findElement(By.id("pii-admin-group-cases")).getAttribute("value");		
		if ((ev2.equals("all")==false))
		{
			driver.findElement(By.id("pii-admin-group-cases")).clear();
			driver.findElement(By.id("pii-admin-group-cases")).sendKeys("all");
		}
		driver.findElement(By.id("pii-admin-group-modules-button")).click();
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-modules-menu")));
		//Verify all modules are listed
		verifyModuleList(driver,ele);
		//Checks it
		ele.findElement(By.linkText("Human Error Instant RCA")).click();
		share2.scrollToTop(driver);
		 WebElement closebtn = driver.findElement(By.xpath(".//*[@id='pii-admin-group-modules-dialog']//a[@role='button' and contains(@class,'ui-btn')]"));
		 Actions builder = new Actions(driver);
		 builder.click(closebtn).build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-modules-dialog']//a[@role='button' and contains(@class,'ui-btn')]")));
		
		//Authorize Module's try&catch close button
		 /*
		try{
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete"))));
		}catch (NoSuchElementException e)
		{
			driver.findElement(By.xpath(".//*[@id='pii-admin-group-modules-dialog']//a[@role='button' and contains(@class,'ui-btn')]")).click();
		}
		catch (ElementNotInteractableException e1)
		{
			driver.findElement(By.xpath(".//*[@id='pii-admin-group-modules-dialog']/div/div/a")).click();
		}*/
		//Clicks on save
		share2.scrollToTop(driver);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-button-save"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-button-save"))));
//		driver.findElement(By.id("pii-admin-group-button-save")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title")));
		//Clicks on Save
		driver.findElement(By.id("pii-admin-group-dialog-confirmed")).click();
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		System.out.println("Group created");
		String groupCreated = driver.findElement(By.id("pii-admin-group-messages")).getText();
		softly.assertThat(groupCreated).as("test data").contains("Group created: "+company_id+".");
		//softly.assertAll();
	}

	public void createUserGM(WebDriver driver, String company_id, String password,String email) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Login obj = new Login ();
		Thread.sleep(2000);
		//Clicks on create user
		driver.findElement(By.id("pii-admin-user-create")).click();
		Thread.sleep(2000);
		//Enters mandatory details
		um2.verifyLoginNameCharactersAccepted(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-loginname"))).sendKeys(company_id+"testgroupm");
		driver.findElement(By.id("pii-admin-user-name")).sendKeys(company_id+"testgroupm");
		driver.findElement(By.id("pii-admin-user-password")).sendKeys(obj.decodePassword(password));
		driver.findElement(By.id("pii-admin-user-password-again")).sendKeys(obj.decodePassword(password));
//		driver.findElement(By.id("pii-admin-user-company")).sendKeys("Sanity Test");
		driver.findElement(By.id("pii-admin-user-email")).sendKeys(email);
		String ev1 = driver.findElement(By.id("pii-admin-user-name")).getAttribute("value");
//	String ev2 = driver.findElement(By.id("pii-admin-user-company")).getAttribute("value");
		String ev3 = driver.findElement(By.id("pii-admin-user-email")).getAttribute("value");
		if ((ev1.equals(company_id+"testgroupm")==false))
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
		//Select company
		Select dd4 = new Select (driver.findElement(By.id("pii-admin-user-customerId")));
		dd4.selectByVisibleText(company_id);
		//Select group
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))));
		//driver.findElement(By.id("pii-admin-user-groups-button")).click();
		WebElement ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		ele1.findElement(By.linkText(company_id)).click();
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		Select dd2 = new Select (driver.findElement(By.id("pii-admin-user-dept")));
		dd2.selectByVisibleText("Accounting");
		Select dd3 = new Select (driver.findElement(By.id("pii-admin-user-jobtitle")));
		dd3.selectByVisibleText("Engineer");	
		//Select group under group moderator
		driver.findElement(By.id("pii-admin-user-modgroups-button")).click();
		ele1 = driver.findElement(By.id("pii-admin-user-modgroups-menu"));
		//KALE 1316
		ele1.findElement(By.linkText(company_id)).click();
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-modgroups-listbox-popup']/div/div/a")).click();
		//Clicks on save button
		WebElement savebtn = driver.findElement(By.id("pii-admin-user-button-save"));
		WebElement popupbtn = driver.findElement(By.id("pii-admin-user-dialog-confirmed"));
		jse.executeScript("arguments[0].click()", savebtn);
		jse.executeScript("arguments[0].click()", popupbtn);
		//driver.findElement(By.id("pii-admin-user-button-save")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title")));
		//Clicks on Save button
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		System.out.println("User created");
		//Wait for loading message to disappear
		share2.loadingServer(driver);
	}	

	public void createUserCM(WebDriver driver, String company_id, String password,String email) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Login obj = new Login ();
		Thread.sleep(2000);
		//Clicks on create user
		driver.findElement(By.id("pii-admin-user-create")).click();
		Thread.sleep(2000);
		//Enters mandatory details
		um2.verifyLoginNameCharactersAccepted(driver, softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-loginname"))).sendKeys(company_id+"testcm");
		driver.findElement(By.id("pii-admin-user-name")).sendKeys(company_id+"testcm");
		driver.findElement(By.id("pii-admin-user-password")).sendKeys(obj.decodePassword(password));
		driver.findElement(By.id("pii-admin-user-password-again")).sendKeys(obj.decodePassword(password));
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
		WebElement ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		jse.executeScript("arguments[0].scrollIntoView();", ele1);
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(company_id))));
		
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a"))));
		Select dd2 = new Select (driver.findElement(By.id("pii-admin-user-dept")));
		dd2.selectByVisibleText("Accounting");
		Select dd3 = new Select (driver.findElement(By.id("pii-admin-user-jobtitle")));
		dd3.selectByVisibleText("Engineer");	
		//Click on Company Moderator as yes
		driver.findElement(By.xpath(".//*[@for='pii-admin-user-customerAdmin-yes']")).click();
		//Clicks on save button
		WebElement savebtn = driver.findElement(By.id("pii-admin-user-button-save"));
		WebElement dialogtitle = driver.findElement(By.id("pii-admin-user-dialog-title"));
		jse.executeScript("arguments[0].focus();", savebtn);
		jse.executeScript("arguments[0].click()", savebtn);
		jse.executeScript("arguments[0].scrollIntoView(true);", dialogtitle);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		Thread.sleep(1000);
		//jse.executeScript("arguments[0].click()", popupbtn);
		
		//driver.findElement(By.id("pii-admin-user-button-save")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title")));
		//Clicks on Save button
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		System.out.println("User created");
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		
		
		um2.createExistingUserAndVerifyErrorPopup(driver, softly, company_id, password, email);
	}

	public void addSubDepartments (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse =(JavascriptExecutor)driver;
		//Click on edit company
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))).click();
		//Click on departments collapsible
		WebElement debsub = driver.findElement(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", debsub);
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
		//Scroll down
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-subdept-input")));
		Point p = ele.getLocation();
		int yaxis= p.getY()-250;
		//Scroll to element
		Thread.sleep(2000);
		jse.executeScript("scroll(0,"+yaxis+")");
		Thread.sleep(2000);
		//Enter a few sub departments
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys("QAA 1");
		Thread.sleep(1000);
		ele.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//Click on add 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys("QAA 2");
		Thread.sleep(1000);
		ele.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//Click on add 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys("QAA 3");
		Thread.sleep(1000);
		ele.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//Click on add 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		//Scroll top
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		//Clicks on save
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
	}

	public void createUser(WebDriver driver, String company_id, String password,String email) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		Login obj = new Login ();
		Thread.sleep(2000);
		//Clicks on create user
		driver.findElement(By.id("pii-admin-user-create")).click();
		Thread.sleep(2000);
		//Enters mandatory details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-loginname"))).sendKeys(company_id);
		driver.findElement(By.id("pii-admin-user-name")).sendKeys(company_id);
		driver.findElement(By.id("pii-admin-user-password")).sendKeys(obj.decodePassword(password));
		driver.findElement(By.id("pii-admin-user-password-again")).sendKeys(obj.decodePassword(password));
		share2.scrollToAPoint(driver, 500);
		driver.findElement(By.id("pii-admin-user-company")).sendKeys("Sanity Test");
		driver.findElement(By.id("pii-admin-user-email")).sendKeys(email);
		String ev1 = driver.findElement(By.id("pii-admin-user-name")).getAttribute("value");
		String ev2 = driver.findElement(By.id("pii-admin-user-company")).getAttribute("value");
		String ev3 = driver.findElement(By.id("pii-admin-user-email")).getAttribute("value");
		if ((ev1.equals(company_id)==false))
		{
			driver.findElement(By.id("pii-admin-user-name")).clear();
			driver.findElement(By.id("pii-admin-user-name")).sendKeys(company_id);
		}
		/*company name
		if ((ev2.equals("Sanity Test")==false))
		{
			driver.findElement(By.xpath(".//input[@id='pii-admin-user-company']")).clear();
			driver.findElement(By.xpath(".//input[@id='pii-admin-user-company']")).sendKeys("Sanity Test");
		}*/
		if ((ev3.equals(email)==false))
		{
			driver.findElement(By.id("pii-admin-user-email")).clear();
			driver.findElement(By.id("pii-admin-user-email")).sendKeys(email);
		}
		Select dd4 = new Select (driver.findElement(By.id("pii-admin-user-customerId")));
		dd4.selectByVisibleText(company_id);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-groups-button"))));
//		driver.findElement(By.id("pii-admin-user-groups-button")).click();
		WebElement ele1 = driver.findElement(By.id("pii-admin-user-groups-menu"));
		ele1.findElement(By.linkText(company_id)).click();
		//ele1.findElement(By.className("ui-first-child ui-last-child")).click();
		//driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-dialog']/div/div/a")).click();
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-groups-listbox-popup']/div/div/a")).click();
		Select dd2 = new Select (driver.findElement(By.id("pii-admin-user-dept")));
		dd2.selectByVisibleText("Accounting");
		Select dd3 = new Select (driver.findElement(By.id("pii-admin-user-jobtitle")));
		dd3.selectByVisibleText("Engineer");	
		//Clicks on save button
		WebElement savebtn = driver.findElement(By.id("pii-admin-user-button-save"));
		WebElement dialogtitle = driver.findElement(By.id("pii-admin-user-dialog-title"));
		jse.executeScript("arguments[0].focus();", savebtn);
		jse.executeScript("arguments[0].click()", savebtn);
		jse.executeScript("arguments[0].scrollIntoView(true);", dialogtitle);
		//jse.executeScript("arguments[0].click()", popupbtn2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-confirmed"))).click();
		Thread.sleep(3000);
		
		//driver.findElement(By.id("pii-admin-user-button-save")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title")));
		//Clicks on Save button
		
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		System.out.println("User created");
		//Wait for loading message to disappear
		share2.loadingServer(driver);
	}

	public void loginAsNewUser(WebDriver driver, String company_id, String password) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		Login obj = new Login ();
		//If browser is firefox then switch to default content
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox"))
		{
			driver.switchTo().defaultContent();
		}
		Thread.sleep(2000);
		//Login
		int login = obj.LoginUser(driver, company_id, password);
		System.out.println("Title after login: "+driver.getTitle());
		//Thread.sleep(5000);
		try{
			//Click on agree terms box
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-license-checkbox-div']/fieldset/div/div/label"))).click();
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-license-next"))).click();
			//Scroll to end and click on I accept
			share2.scrollToAPoint(driver, 2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-license-accept"))).click();
			Thread.sleep(2000);
		}catch (org.openqa.selenium.TimeoutException e)
		{

		}
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		obj.waitForIframe(driver);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
			if (login==1)
			{
				//Thread.sleep(2000);
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException e){

		}catch(org.openqa.selenium.TimeoutException t){

		}
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		Thread.sleep(2000);
	}

	public WebElement goToHiRCA (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);		
		Thread.sleep(2000);
		//Clicks on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Wait for appearance of HIRCA page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-department-button")));
		//Get WebElement of department
		WebElement element = driver.findElement(By.id("pii-irca-event-department"));
		return element;
	}

	public void checkDeptList(WebDriver driver, List<String> dept1,List<String> dept,WebElement ele) throws Exception {

		int num=0;
		if (dept1.size()>dept.size())
			num = dept1.size();
		else num = dept.size();
		for (int i=1;i<=num;i++)
		{
			try{
				//Get each department name and check if it exists in the unchanged dept list
				String s = driver.findElement(By.xpath(".//*[@id='pii-irca-event-department']/option["+(i+1)+"]")).getText();
				if(dept1.contains(s)==true)
				{
					System.out.println(s + " exists");
				}
				if(dept.isEmpty()==false && dept1.contains(s)==false)
				{
					softly.fail(s + "does not exist in original list");
					System.out.println (dept1);
				}
				if(dept.isEmpty()==false)
				{
					if (dept.contains(s)==false)
					{
						System.out.println(s + " should not exist");
					}
					if (dept.contains(s)==true)
					{
						softly.fail(s + "exists");
						System.out.println (dept);
					}
				}
			}catch (NoSuchElementException u)
			{
				System.out.println("Didn't find department at index"+(i+1));
				break;
			}

		}
		//see if user account can be saved
		share2.checkIfUserProfileNoFieldsMissing(driver, softly);

	}


	public void editDept(WebDriver driver, String company_id, List<String> dept1) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Clicks on admin user name on top right corner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-loginname"))).click();
		//Clicks on admin option
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-admin"))).click();
		//Clicks on Accounts
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-accounts']/h3/a"))).click();
		//Clicks on Companies
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-customers-button"))).click();
		Thread.sleep(2000);
		//Enters company id in ID field 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(company_id);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(Keys.ENTER);
		//Clicks on newly created company id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td"))).click();
		Thread.sleep(2000);
		//Click on edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-edit"))).click();
		//Click on departments collapsible
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))).click();
		//Choose 10 random numbers between 0 to 34
		List<Integer> numbers = new ArrayList<Integer>();
		int x=-1;
		//Clear list
		numbers.clear();
		for (int i=0; i<10;i++)
		{
			Random random = new Random();
			System.out.println("Print out i    "+  i);
			
			while (true)
			{
				x = random.nextInt(35);
				System.out.println("numbers contains x    "+numbers.contains(x));
				if(numbers.contains(x)==true)
				{
					System.out.println("Print out x    "+x);
					continue;
				}
				else break;
			}	
			numbers.add(x);
		}
		//Sorts number list
		Collections.sort(numbers);
		System.out.println("Sort numbers #2531     "+ numbers);
		//Unselect any 10 departments and store the unselected ones in a list
		List<String> dept = new ArrayList<String>();
		for (int i=0;i<10;i++)
		{
			numbers.get(i);
			//Get element's y coordinate
			WebElement department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dept-table")));
			WebElement l = department.findElement(By.xpath(".//*[@piiindex='"+numbers.get(i)+"']"));
			Point p = l.getLocation();
			int yaxis= p.getY()-250;
			//Scroll to element
			jse.executeScript("scroll(0,"+yaxis+")");
			//Look for pii index number and click on checkbox
			jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@piiindex='"+numbers.get(i)+"']"))));
			jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@piiindex='"+numbers.get(i)+"']"))));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@piiindex='"+numbers.get(i)+"']"))).click();
			//Get department name and store
			String s =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-table']/tbody/tr["+(numbers.get(i)+2) +"]/td[1]"))).getText();
			dept.add(s);
		}
		//Adds a department
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dept-input"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dept-input"))).sendKeys("QAA sample department");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dept-input"))).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Click on add
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		dept1.add("QAA sample department");
		share2.scrollToTop(driver);
		//Save company
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-save"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//see if user account can be saved
		share2.checkIfUserProfileNoFieldsMissing(driver, softly);
	}

	public List<String> storeDepartmentList(WebDriver driver) throws Exception {

		List<String> dept1 = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(driver,20);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on departments collapsible
		share2.scrollToAPoint(driver, 600);
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-div']/h3/a"))));
		for (int i=2;i<=36;i++)
		{
			//Get department name and store
			String s =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-dept-table']/tbody/tr["+i+"]/td[1]"))).getText();
			dept1.add(s);
		}
		System.out.println("Original department list "+dept1);
		return dept1;	
	}

	public void excelStore() throws Exception {

		File file = new File("E:/EmailError.xlsx");		
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(file);
		// Access the required test data sheet
		XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelWSheet = ExcelWBook.getSheet("Sheet1");
		//Get number of rows
		int rows = ExcelWSheet.getPhysicalNumberOfRows();
		//Get current date 
		SimpleDateFormat sfdate = new SimpleDateFormat("MM/dd/yyy HH:mm:ss a");
		Date date = new Date();
		System.out.println(sfdate.format(date));
		//Create a new row for only images
		Row row1 = ExcelWSheet.createRow(rows);
		row1.createCell(0).setCellValue(sfdate.format(date));
		row1.createCell(1).setCellValue("No Email");
		//Close File input stream
		ExcelFile.close();
		//Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);
		ExcelWBook.write(outputStream);
		ExcelWBook.close();
		outputStream.close();
	}


	public void checkAccess(WebDriver driver, int login, String[]op) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,20);
		share2.loadingServer(driver);
		//Click on Knowledge
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-k"))).click();
		share2.loadingServer(driver);
		if (login==1)
		{
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}catch (org.openqa.selenium.TimeoutException | NoSuchElementException r){

			}
		}
		List<String>f = Arrays.asList(op);
		WebElement element;
		//Verify the modules selected
		share2.loadingServer(driver);
		if(f.contains("Event Reports"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Event Reports")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Event Reports enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("Event Reports disabled");
		}
		if(f.contains("JIT Wisdom"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JIT Wisdom")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("JIT Wisdom enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("JIT Wisdom disabled");
		}
		if(f.contains("JIT Risk Joggers"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JIT Risk Joggers")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("JIT Risk Joggers enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("JIT Risk Joggers disabled");
		}
		if(f.contains("Knowledge Bank"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge Bank")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Knowledge Bank enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("Knowledge Bank disabled");
		}
		if(f.contains("Knowledge Exchange"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge Exchange")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Knowledge Exchange enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("Knowledge Exchange disabled");
		}
		if(f.contains("Performance Accountability & Analytics"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Performance Accountability & Analytics")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Performance Accountability & Analytics enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Knowledge
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Knowledge"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("Performance Accountability & Analytics disabled");
		}
		share2.loadingServer(driver);
		//Clicks on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
		share2.loadingServer(driver);
		if(f.contains("SPV Error Meter"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("SPV Error Meter enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Analysis
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("SPV Error Meter disabled");
		}
		if(f.contains("Human Performance Inspector"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hpi")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("HPI enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Analysis
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("HPI disabled");
		}
		if(f.contains("Systematic Reliability Inspection"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-sri")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("SRI enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Analysis
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("SRI disabled");
		}
		if(f.contains("Human Error Instant RCA"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("HiRCA enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Analysis
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("HiRCA disabled");
		}
		if(f.contains("Equipment Failure Instant RCA"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-eirca")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("EiRCA enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Analysis
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("EiRCA disabled");
		}
		if(f.contains("Organization & Programmatic Instant RCA"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-opirca")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("O&PiRCA enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Analysis
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("O&PiRCA disabled");
		}
		if(f.contains("Instant Common Cause Analysis"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-icca")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("ICCA enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Analysis
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("ICCA disabled");
		}
		if(f.contains("Job Observation Analysis"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-jo")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Job Obs enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Analysis
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("Job Obs disabled");
		}
		if(f.contains("Error-Free Review"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-3pr")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Error-Free Review enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Analysis
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("Error-Free disabled");
		}
		if(f.contains("Remote Verification"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-rv")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Remote Verification enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Analysis
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Analysis"))).click();
				share2.loadingServer(driver);
			}
			else softly.fail("Remote Verification disabled");
		}
		share2.loadingServer(driver);
		//Clicks on Learning
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Learning"))).click();
		//Clicks on Error-Free Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
		share2.loadingServer(driver);
		if(f.contains("Human Performance"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Human Performance")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Human Performance enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Human Performance disabled");
		}
		if(f.contains("Equipment Performance"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Equipment Performance")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Equipment Performance enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Equipment Performance disabled");
		}
		if(f.contains("Engineering Fundamentals"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Engineering Fundamentals")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Engineering Fundamentals enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Engineering Fundamentals disabled");
		}
		if(f.contains("Electrical Failure Modes")||f.contains("Mechanical Failure Modes"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Failure Modes")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Failure Modes enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Failure Modes disabled");
		}
		if(f.contains("Prevention of Design Deficiencies"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Prevention of Design Deficiencies")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Prevention of Design Deficiencies enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Prevention of Design Deficiencies disabled");
		}
		if(f.contains("Systematic Reliability Inspection Search"))
		{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Systematic Reliability Inspection")));
			if(element.getAttribute("class").contains("ui-state-disabled")==false)
			{
				System.out.println("Systematic Reliability Inspection enabled");
				share2.loadingServer(driver);
				element.click();
				share2.loadingServer(driver);
				//Clicks on Error-Free Bank
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='links']/a[4]"))).click();
				Thread.sleep(2000);
			}
			else softly.fail("Systematic Reliability Inspection disabled");
		}
	}


	public void deleteUser(WebDriver driver, String company_id) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on Edit user
		driver.findElement(By.id("pii-admin-user-edit")).click();
		share2.loadingServer(driver);
		//Searches for newly created user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).clear();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input"))).sendKeys(company_id);
		driver.findElement(By.xpath(".//*[@id='pii-admin-user-list']/form/div/input")).sendKeys(Keys.ENTER);
		//Selects the newly created user
		WebElement select = driver.findElement(By.id("pii-admin-user-list"));
		WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		option.click();
		share2.loadingServer(driver);
		//Clicks on delete
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-button-delete"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title")));
		String noHtml = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-user-dialog-title"))).getText();
		softly.assertThat(noHtml).as("test data").doesNotContain("<br/>");
		//Clicks on delete user
		driver.findElement(By.id("pii-admin-user-dialog-confirmed")).click();
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		System.out.println("User deleted");
		share2.loadingServer(driver);
	}

	public void deleteGroup(WebDriver driver, String company_id) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on Edit group
		driver.findElement(By.id("pii-admin-group-edit")).click();
		share2.loadingServer(driver);
		//Verify the message on top in edit group page

		try{
			String message = wait.until(ExpectedConditions.visibilityOfElementLocated(um.EditGroupMessageOnTop)).getText().trim();
			softly.assertThat(message).as("test data").isEqualTo("Search and select group to edit");
		}catch(org.openqa.selenium.TimeoutException t)
		{

		}
		//Searches for newly created group
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).clear();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input"))).sendKeys(company_id);
		driver.findElement(By.xpath(".//*[@id='pii-admin-group-list']/form/div/input")).sendKeys(Keys.ENTER);
		//Selects the newly created group
		WebElement select = driver.findElement(By.id("pii-admin-group-list"));
		WebElement option = select.findElement(By.cssSelector(".ui-li-static.ui-body-inherit.ui-first-child.ui-last-child"));
		option.click();
		share2.loadingServer(driver);
		//Clicks on delete
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-button-delete"))).click();
		String noHtml = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title"))).getText();
		softly.assertThat(noHtml).as("test data").doesNotContain("<br/>");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-group-dialog-title")));
		//Clicks on delete group
		driver.findElement(By.id("pii-admin-group-dialog-confirmed")).click();
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note")));
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		System.out.println("Group deleted");
		share2.loadingServer(driver);
	}

	public void deleteCompany(WebDriver driver, String company_id) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,20);
		//Clicks on Companies
		driver.findElement(By.id("pii-admin-customers-button")).click();
		share2.loadingServer(driver);
		//Enters company id in ID field 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).clear();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(company_id);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div/table/tbody/tr[2]/td/input"))).sendKeys(Keys.ENTER);
		//Clicks on newly created company id
		driver.findElement(By.xpath(".//*[@id='pii-admin-cust-jsgrid']/div[2]/table/tbody/tr/td")).click();
		share2.loadingServer(driver);
		//Clicks on delete
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-button-delete"))).click();
		String noHtml = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title"))).getText();
		softly.assertThat(noHtml).as("test data").doesNotContain("<br/>");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-admin-cust-dialog-title")));
		//Clicks on delete company
		driver.findElement(By.id("pii-admin-cust-dialog-confirmed")).click();
		Thread.sleep(4000);
		try{
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-note"))).getText();
			softly.assertThat(s).as("test data").contains("Company deleted");
		}catch(org.openqa.selenium.TimeoutException r)
		{

		}
		System.out.println("Company deleted");
		share2.loadingServer(driver);
	}
	
/*
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
*/
}
