package MainClass;

import java.util.Base64;

import static org.junit.Assert.*;

import PageObjects.CreateEquipPageObj;

import PageObjects.LoginPageObj;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	SoftAssertions softly = new SoftAssertions();
	LoginPageObj lpo = new LoginPageObj();
	ShareCheck2 share = new ShareCheck2();
	CreateEquipPageObj equip = new CreateEquipPageObj();

	public String loginWarningMessage = "Warning: Only one current log in session per user is allowed. Any previous log in on another device or web browser will be automatically disconnected. Please report abnormal account activity and change password immediately.";
	public String failedLoginMessage = "Failed to login. Error details: cannot establish connection with KALE server; please try again later";

	public int LoginUser(WebDriver driver, String username, String password) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.WebPageMessage)).getText();
		System.out.println(s);
		assertEquals("\"An Error-Free Knowledge and Tool Bank\"", s);
		// MainClass.Login button is located and clicked
		wait.until(ExpectedConditions.elementToBeClickable(lpo.LoginButton)).click();
		// Enter Username
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.UserName));
		} catch (org.openqa.selenium.TimeoutException r) {
			// MainClass.Login button is located and clicked
			wait.until(ExpectedConditions.elementToBeClickable(lpo.LoginButton)).click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.UserName)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.UserName)).sendKeys(username);
		// Enter password
		driver.findElement(lpo.Password).clear();
		driver.findElement(lpo.Password).sendKeys(decodePassword(password));
		Thread.sleep(2000);
		String user = driver.findElement(lpo.UserName).getAttribute("value");
		String pw = driver.findElement(lpo.Password).getAttribute("value");
		int c = 1;
		int login = 0;
		if (user.equals(username) == true) {
			if (pw.equals(decodePassword(password)) == true) {
				verifySpaceRemoved(driver);
				// Sign in button is located and clicked
				driver.findElement(lpo.SignInButton).click();
				share.loadingServer(driver);
				while (c > 0) {
					share.loadingServer(driver);
					WebElement element = driver.findElement(lpo.SignInMessage);
					String text = element.getText();
					System.out.println(text);
					if (element.isDisplayed()) {
						if (text.isEmpty()) {
							System.out.println("Logged in");
							break;
						}
						if (text.isEmpty() == false) {
							driver.findElement(lpo.Password).sendKeys(decodePassword(password));
							// Sign in button is located and clicked
							driver.findElement(lpo.SignInButton).click();
							if (text.contains("Warning: This user has an existing login session"))
								login = 1;
							if (text.contains(failedLoginMessage)) {
								// Enter Username
								wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.UserName)).clear();
								wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.UserName))
										.sendKeys(username);
								// Enter password
								driver.findElement(lpo.Password).clear();
								driver.findElement(lpo.Password).sendKeys(decodePassword(password));
								// Sign in button is located and clicked
								driver.findElement(lpo.SignInButton).click();
								continue;
							}
							share.loadingServer(driver);
							break;
						}

					} else
						break;
				}
			}
		}
		if ((user.equals(username) == false) || (pw.equals(decodePassword(password)) == false)) {
			while (c > 0) {
				Thread.sleep(1000);
				driver.findElement(lpo.UserName).clear();
				driver.findElement(lpo.Password).clear();
				Thread.sleep(2000);
				// Username text field is located and the username is entered
				driver.findElement(lpo.UserName).sendKeys(username);
				// Password field is located and the password is entered
				driver.findElement(lpo.Password).sendKeys(decodePassword(password));
				Thread.sleep(2000);
				user = driver.findElement(lpo.UserName).getAttribute("value");
				pw = driver.findElement(lpo.Password).getAttribute("value");
				if (user.equals(username) == true) {
					if (pw.equals(decodePassword(password)) == true) {
						// Sign in button is located and clicked
						driver.findElement(lpo.SignInButton).click();
						share.loadingServer(driver);
						break;
					}
				}
			}
		}
		try {
			// Click on agree terms box
			wait1.until(ExpectedConditions.visibilityOfElementLocated(lpo.AgreeTermsButton));
		} catch (org.openqa.selenium.TimeoutException t) {
			waitForIframe(driver);
		}

/*		// Check for login warning message
		if (username.contains("chinese") == false)
			checkForWarningMessage(driver, login);*/
		return login;
	}

	public static void main(String[] args) {
		System.out.println(new Login().decodePassword("SHBAMTIzNDU"));
		byte[] encryptedPasswordBytes = Base64.getEncoder().encode("Password2021!".getBytes());
		String encryptedPassword = new String(encryptedPasswordBytes);
		System.out.println("Encrypted Password - " + encryptedPassword);
	}

	public void waitForIframe(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		while (true) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.Iframe));
				break;
			} catch (org.openqa.selenium.TimeoutException t) {
				continue;
			}
		}
	}

	public void checkForWarningMessage(WebDriver driver, int login) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		if (login == 1) {
			driver.switchTo().frame(driver.findElement(lpo.Iframe));
			try {
				String message = wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyNote)).getText();
				SoftAssertions.assertSoftly(softly1 -> {
					softly1.assertThat(message).as("test data").doesNotContain("<br");
					softly1.assertThat(message).as("test data").isEqualTo(loginWarningMessage);
				});
			} catch (org.openqa.selenium.TimeoutException e) {

			}
			driver.switchTo().defaultContent();
		}
	}

	public String decodePassword(String pw) {

		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(pw);
		String decryptedPassword = new String(decryptedPasswordBytes);
		return (decryptedPassword);
		
		
		
	}

	public void closePopUpSticky(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		while (true) {
			try {
				if (driver.findElement(lpo.StickyNote).isDisplayed()) {
					Thread.sleep(1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.StickyClose)).click();

				}
			} catch (NoSuchElementException e) {
				break;
			} catch (org.openqa.selenium.StaleElementReferenceException f) {

				break;
			} catch (org.openqa.selenium.TimeoutException u) {
				break;
			} catch (org.openqa.selenium.ElementNotInteractableException u) {
				break;
			} catch (org.openqa.selenium.JavascriptException t) {
				Thread.sleep(2000);
				break;
			}

		}
	}

	public void logout(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		closePopUpSticky(driver);
		Thread.sleep(4000);
		// Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String version = cap.getVersion();
		if (browserName.equals("firefox") || browserName.equals("chrome")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
			Thread.sleep(3000);
			while (true) {
				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LogOutButton)).click();
					break;
				} catch (org.openqa.selenium.TimeoutException
						| org.openqa.selenium.ElementClickInterceptedException t) {
					wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.KALELogo)).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
				}
			}
			Thread.sleep(5000);
		} else {
			closePopUpSticky(driver);
			Actions act = new Actions(driver);
			WebElement element;
			try {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight));
			} catch (org.openqa.selenium.TimeoutException t) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameMenuRight));
			}
			act.click(element).build().perform();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LogOutButton));
			element = driver.findElement(lpo.LogOutButton);
			if (version.startsWith("11")) {
				act.click(element).build().perform();
			}
			if (version.startsWith("10")) {
				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LogOutButton)).click();
				} catch (org.openqa.selenium.TimeoutException
						| org.openqa.selenium.ElementClickInterceptedException u) {
					wait.until(ExpectedConditions.visibilityOfElementLocated(equip.KaleHomePage)).click();
					try {
						element = wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight));
					} catch (org.openqa.selenium.TimeoutException t) {
						element = wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameMenuRight));
					}
					act.click(element).build().perform();
					Thread.sleep(3000);
					int i = 0;
					while (i < 10) {
						try {
							wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LogOutButton)).click();
							break;
						} catch (org.openqa.selenium.TimeoutException
								| org.openqa.selenium.ElementClickInterceptedException t) {
							wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.KALELogo)).click();
							wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.LoginNameOnTopRight)).click();
							i++;
						}
					}
				}
			}
			Thread.sleep(2000);
		}
		Thread.sleep(4000);
	}

	public void verifySpaceRemoved(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lpo.UserName)).sendKeys("  ");
		Thread.sleep(500);
	}

}
