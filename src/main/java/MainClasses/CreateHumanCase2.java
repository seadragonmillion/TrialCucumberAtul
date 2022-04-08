import kaleTestSoftware.CreateHumanCasePageObj;
import kaleTestSoftware.ShareCheck2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateHumanCase2 {

	CreateHumanCasePageObj chc = new CreateHumanCasePageObj();
	ShareCheck2 share2 = new ShareCheck2();

	public void verifyErrorOnPage (WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,40);
		//Scroll top
		share2.scrollToTop(driver);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(chc.HumanCaseSaveButton)).click();
		//share2.verifyWarningPopupForError(driver, softly);
		//Verify all errors
		String idError = driver.findElement(chc.CaseIDError).getText();
		softly.assertThat(idError).as("test data").isEqualTo("ID is required");
		String questionError = driver.findElement(chc.QuestionError).getText();
		softly.assertThat(questionError).as("test data").isEqualTo("Case question is required");
		String answerError = driver.findElement(chc.AnswerError).getText();
		softly.assertThat(answerError).as("test data").isEqualTo("Case answer is required");
		String imageError = driver.findElement(chc.PNGFileError).getText();
		softly.assertThat(imageError).as("test data").isEqualTo("Please select some PNG files with .png extension");
		String keywordError = driver.findElement(chc.KeywordError).getText();
		softly.assertThat(keywordError).as("test data").isEqualTo("Please attach some keywords to this case");
		String taskError = driver.findElement(chc.TaskError).getText();
		softly.assertThat(taskError).as("test data").isEqualTo("Please attach some tasks to this case");
		String purposeError = driver.findElement(chc.PurposeError).getText();
		softly.assertThat(purposeError).as("test data").isEqualTo("Please attach some purposes to this case");
		String conditionError = driver.findElement(chc.ConditionError).getText();
		softly.assertThat(conditionError).as("test data").isEqualTo("Please attach some conditions to this case");
		//softly.assertAll();
	}

}
