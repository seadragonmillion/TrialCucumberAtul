import kaleTestSoftware.ErrorMeter2;
import kaleTestSoftware.ShareCheck2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TextBoxResizing {
	
	ErrorMeter2 em2 = new ErrorMeter2 ();
	ShareCheck2 share2 = new ShareCheck2();
	
	public void sizeCheck(WebDriver driver, By locator, SoftAssertions softly) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(" ");		
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.TAB);
		Thread.sleep(500);
		try{
			String sizeOriginal = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute("style");
		//Enter text
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(em2.error100Data(driver,driver.getCurrentUrl()).get(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.TAB);
		Thread.sleep(500);
		//Get new size
		String heightWithText = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute("style");
		//delete text
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.DELETE);
		Thread.sleep(500);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText().isEmpty()==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		//Verify if size is same as inital/original size
		String heightWithoutText = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute("style");
		//heightWithoutText to be same as sizeOriginal
		//softly.assertThat(heightWithoutText).as("test data").isEqualTo(sizeOriginal);
		double height1 = Double.parseDouble(heightWithoutText.substring(heightWithoutText.lastIndexOf("height:")+8, heightWithoutText.lastIndexOf("p")));
		double height2 = Double.parseDouble(sizeOriginal.substring(sizeOriginal.indexOf("height:")+8, sizeOriginal.lastIndexOf("p")));
/*		if(height1<(height2-6))
			softly.fail("For locator "+locator+"\n Starting size not correct: "+height1+", original height: "+height2);*/
		//both heights not equal
		double height3 = Double.parseDouble(heightWithText.substring(heightWithText.lastIndexOf("height:")+8, heightWithText.lastIndexOf("p")));
		if(height3==height1)
			softly.fail("For locator "+locator+"\n Height with text equal to height without text "+height3);
		//softly.assertThat(heightWithText).as("test data").isNotEqualTo(heightWithoutText);
		System.out.println(height1+" "+height2+ " "+height3);
		System.out.println(sizeOriginal+" "+heightWithoutText+" "+heightWithText);
		}catch(org.openqa.selenium.WebDriverException t){
			
		}
	}
	
	public void sizeCheckAfterAddingElement(WebDriver driver, By locatorOfTextBox, By locatorOfAddSign, SoftAssertions softly) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		String sizeOriginal = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorOfTextBox)).getAttribute("style");
		//Enter text
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorOfTextBox)).sendKeys(em2.error100Data(driver,driver.getCurrentUrl()).get(20));
		//Get new size
		String heightWithText = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorOfTextBox)).getAttribute("style");
		//Click on add
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorOfAddSign)).click();
		share2.loadingServer(driver);
		//Verify if size is same as inital/original size
		String heightWithoutText = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorOfTextBox)).getAttribute("style");
		//both heights not equal
		softly.assertThat(heightWithText).as("test data").isNotEqualTo(heightWithoutText);
		//heightWithoutText to be same as sizeOriginal
		softly.assertThat(heightWithoutText).as("test data").isEqualTo(sizeOriginal);
	}
	
}
