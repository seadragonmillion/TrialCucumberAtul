package MainClass;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FontCheck {
	
	public void fontCheckAnalysisModule(WebElement l, SoftAssertions softly) throws Exception {
		
		String s = l.getCssValue("font-size");
		softly.assertThat(s).as("test data").isEqualTo("16px");
		String s1 = l.getCssValue("font-family");
		softly.assertThat(s1).as("test data").isEqualTo("open_sansregular");
		String s2 = l.getCssValue("font-weight");
		softly.assertThat(s2).as("test data").isEqualTo("300");
		String s3 = l.getCssValue("color");
		softly.assertThat(s3).as("test data").isEqualTo("rgba(0, 166, 81, 1)");
	}
	
	public void fontCheckAnalysisModuleFirefox(WebElement l, SoftAssertions softly) throws Exception {
		
		String s = l.getCssValue("font-size");
		softly.assertThat(s).as("test data").isEqualTo("16px");
		String s1 = l.getCssValue("font-family");
		softly.assertThat(s1).as("test data").isEqualTo("open_sansregular");
		String s2 = l.getCssValue("font-weight");
		softly.assertThat(s2).as("test data").isEqualTo("300");
		String s3 = l.getCssValue("color");
		softly.assertThat(s3).as("test data").isEqualTo("rgb(0, 166, 81)");
	}
	
	public void browserDecideFontCheck(WebDriver driver, SoftAssertions softly, WebElement l) throws Exception {
		
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if(browserName.equals("firefox")||browserName.contains("safari"))
			fontCheckAnalysisModuleFirefox(l,softly);
		else
			fontCheckAnalysisModule(l,softly);
	}
	
	public void analysisModuleFontCheck(WebDriver driver, SoftAssertions softly)throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		//error meter
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-em")));
		browserDecideFontCheck(driver, softly,l);
		//hpi
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hpi")));
		browserDecideFontCheck(driver, softly,l);
		//hirca
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca")));
		browserDecideFontCheck(driver, softly,l);
		//eirca
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-eirca")));
		browserDecideFontCheck(driver, softly,l);
		//opirca
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-opirca")));
		browserDecideFontCheck(driver, softly,l);
		//icca
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-icca")));
		browserDecideFontCheck(driver, softly,l);
		//job observation
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-jo")));
		browserDecideFontCheck(driver, softly,l);
		//3 pass review
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-3pr")));
		browserDecideFontCheck(driver, softly,l);
		//remote verification
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-rv")));
		browserDecideFontCheck(driver, softly,l);
	}

}
