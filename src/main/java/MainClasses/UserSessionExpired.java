import kaleTestSoftware.HiRCAChinese;
import kaleTestSoftware.Login;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserSessionExpired {

	Login login = new Login();
	HiRCAChinese hc = new HiRCAChinese();

	SoftAssertions softly = new SoftAssertions();

	public void loginSessionExpired (WebDriver driver, String username, String password) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int login1 = login.LoginUser(driver, username, password);
		System.out.println("Title after login: "+driver.getTitle());
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		if (login1==1)
		{
			while(true)
			{
				if (driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error")).isDisplayed())
				{
					WebElement ele =driver.findElement(By.cssSelector(".sticky.border-top-right.sticky-error"));
					ele.findElement(By.className("sticky-close")).click();
					break;
				}
				else break;
			}
		}	
		hc.changeToChinese(driver);
		//Logs out
		login.logout(driver);
		//Switches to main content
		driver.switchTo().defaultContent();
		//Login button is located and clicked
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button"))).click();
		//Get username data to check if empty
		String user = driver.findElement(By.id("pii-un")).getAttribute("value");
		if (user==""||user==null||user.equals(""))
			System.out.println("Username not remembered");
		else softly.fail("Username remembered even with Remember Me unchecked");
		//Enter Username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-un"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-un"))).sendKeys(username);
		//Enter password
		driver.findElement(By.id("pii-pw")).sendKeys(login.decodePassword(password));
		//Click on Remember Me
		driver.findElement(By.xpath(".//*[@class='ui-checkbox ui-mini']/label")).click();
		//Sign in button is located and clicked
		driver.findElement(By.id("pii-signin-button")).click();
		login.waitForIframe(driver);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		//Logs out
		login.logout(driver);
		//Switches to main content
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//Login button is located and clicked
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button"))).click();
		//Get username data to check if empty
		user = driver.findElement(By.id("pii-un")).getAttribute("value");
		softly.assertThat(user).as("test data").isEqualTo(username);
		//Un-check Remember Me
		try{
			driver.findElement(By.id("pii-signin-checkbox")).click();
		}catch(org.openqa.selenium.ElementNotInteractableException r)
		{
			jse.executeScript("arguments[0].focus()",driver.findElement(By.id("pii-signin-checkbox")));
			jse.executeScript("arguments[0].click()",driver.findElement(By.id("pii-signin-checkbox")));
		}
		try{
		//Enter password
		driver.findElement(By.id("pii-pw")).sendKeys(login.decodePassword(password));
		//Sign in button is located and clicked
		driver.findElement(By.id("pii-signin-button")).click();
		login.waitForIframe(driver);
		}catch(org.openqa.selenium.ElementNotInteractableException r)
		{
			Thread.sleep(1000);
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-pw")));
				//Enter password
				driver.findElement(By.id("pii-pw")).sendKeys(login.decodePassword(password));
				//Sign in button is located and clicked
				driver.findElement(By.id("pii-signin-button")).click();
				login.waitForIframe(driver);
			}catch(org.openqa.selenium.WebDriverException r1)
			{
				//Login button is located and clicked
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-login-button"))).click();
				login.LoginUser(driver, username, password);
			}
		}
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		//Comes exactly at the 55th minute
		System.out.println("Wait for 56 minutes for re-login message");
		Thread.sleep(3360000);
		//Check for re login message 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-div")));
		//Click on re-login button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-button"))).click();
		String expire1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message"))).getText();
		softly.assertThat(expire1).as("test data").contains("欲继续保持登入，");
		String expire2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-1"))).getText();
		softly.assertThat(expire2).as("test data").contains("倒数计时");
		String buttonRenterPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-button"))).getText();
		softly.assertThat(buttonRenterPassword).as("test data").contains("重新输入密码。");
		String passwordPlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-passwd"))).getAttribute("placeholder");
		softly.assertThat(passwordPlaceholder).as("test data").contains("密码");
		String cancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-passwd-cancel"))).getText();
		softly.assertThat(cancel).as("test data").contains("取消");
		//Enter password and press enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-passwd"))).sendKeys(login.decodePassword(password));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-header-message-passwd"))).sendKeys(Keys.ENTER);
		System.out.println("Logged in");
		hc.changeToEnglish(driver);
		//Logs out
		login.logout(driver);
	}
	
	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}
}
