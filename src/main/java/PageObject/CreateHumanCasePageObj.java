import org.openqa.selenium.By;

public class CreateHumanCasePageObj {

	//User dropdown
	public By AdminOption = By.id("pii-user-admin");

	public By ErrorFreeBankTopLink = By.xpath(".//*[@id='links']/a[4]");

	//Errors in Human Cases
	public By CaseIDError = By.id("pii-admin-efsh-id-error");
	public By QuestionError = By.id("pii-admin-efsh-question-error");
	public By AnswerError = By.id("pii-admin-efsh-answer-error");
	public By PNGFileError = By.id("pii-admin-efsh-upload-file-input-error");
	public By KeywordError = By.id("pii-admin-efsh-keyword-list-input-error");
	public By TaskError = By.id("pii-admin-efsh-task-list-input-error");
	public By PurposeError = By.id("pii-admin-efsh-purpose-list-input-error");
	public By ConditionError = By.id("pii-admin-efsh-condition-list-input-error");
	//Admin>Human Cases
	public By ErrorFreeBankAdminLink = By.xpath(".//*[@id='pii-admin-efbank']/h3/a");
	public By HumanCasesLink = By.id("pii-admin-efsh-manage-button");
	public By HumanCaseSearchCaseIDAdmin = By.id("pii-admin-efsh-list-input");
	public By HumanCaseSearchCaseIDDropdownAdmin = By.id("pii-admin-efsh-list-ul");
	public By HumanCaseDeleteButton = By.id("pii-admin-efsh-button-delete");
	public By HumanCaseAdminPopupTitle = By.id("pii-admin-efsh-dialog-title");
	public By HumanCaseAdminPopupConfirmButton = By.id("pii-admin-efsh-dialog-confirmed");
	public By HumanCaseNewButton = By.id("pii-admin-efsh-button-new");
	public By HumanCaseIDField = By.id("pii-admin-efsh-id");
	public By HumanCaseIDFieldError = By.id("pii-admin-efsh-id-error");
	public By HumanCaseSlideError = By.id("pii-admin-efsh-upload-file-input-error");
	public By HumanCaseQuestion = By.id("pii-admin-efsh-question");
	public By HumanCaseAnswer = By.id("pii-admin-efsh-answer");
	public By HumanCaseKeywordNewField = By.id("pii-admin-efsh-keyword-search-input");
	public By HumanCaseKeywordNewAddButton = By.id("pii-admin-efsh-keyword-new");
	public By HumanCaseKeywordExistingList = By.xpath(".//*[@id='pii-admin-efsh-keyword-blocks']/div[2]/ul");
	public By FirstChildInList = By.cssSelector(".ui-first-child");
	public By FirstAndLastChildInList = By.cssSelector(".ui-first-child.ui-last-child");
	public By HumanCaseTaskNewField = By.id("pii-admin-efsh-task-search-input");
	public By HumanCaseTaskNewAddButton = By.id("pii-admin-efsh-task-new");
	public By HumanCaseTaskExistingList = By.xpath(".//*[@id='pii-admin-efsh-task-blocks']/div[2]/ul");
	public By HumanCasePurposeNewField = By.id("pii-admin-efsh-purpose-search-input");
	public By HumanCasePurposeNewAddButton = By.id("pii-admin-efsh-purpose-new");
	public By HumanCasePurposeExistingList = By.xpath(".//*[@id='pii-admin-efsh-purpose-blocks']/div[2]/ul");
	public By HumanCaseConditionNewField = By.id("pii-admin-efsh-condition-search-input");
	public By HumanCaseConditionNewAddButton = By.id("pii-admin-efsh-condition-new");
	public By HumanCaseConditionExistingList = By.xpath(".//*[@id='pii-admin-efsh-condition-blocks']/div[2]/ul");
	public By HumanCaseImageInputField = By.id("pii-admin-efsh-upload-file-input");
	public By HumanCaseImageInputCollapsible = By.xpath(".//*[@id='pii-admin-efsh-upload-form-selectedfiles-div']/h5/a");
	public By HumanCaseSlidesDivContainingErrorDottedLine = By.xpath(".//*[@id='pii-admin-efsh-upload-form']/div[2]/div[1]");
	public By HumanCaseSaveButton = By.id("pii-admin-efsh-button-save");
	public By HumanCaseEditButton = By.id("pii-admin-efsh-button-edit");
	public By HumanCaseExistingKeywordOnlyOne = By.xpath(".//*[@id='pii-admin-efsh-keyword-form']/div/ul/li/a");
	public By HumanCaseExistingTaskOnlyOne = By.xpath(".//*[@id='pii-admin-efsh-task-form']/div/ul/li/a");
	public By HumanCaseExistingPurposeOnlyOne = By.xpath(".//*[@id='pii-admin-efsh-purpose-form']/div/ul/li/a");
	public By HumanCaseExistingConditionOnlyOne = By.xpath(".//*[@id='pii-admin-efsh-condition-form']/div/ul/li/a");
	public By HumanCasesLink1Title = By.id("pii-admin-efsh-linktitle-0");
	public By HumanCasesLink1URL = By.id("pii-admin-efsh-linkurl-0");
	public By HumanCasesLink2Title = By.id("pii-admin-efsh-linktitle-1");
	public By HumanCasesLink2URL = By.id("pii-admin-efsh-linkurl-1");
	public By HumanCasesLink3Title = By.id("pii-admin-efsh-linktitle-2");
	public By HumanCasesLink3URL = By.id("pii-admin-efsh-linkurl-2");
	public By HumanCasesLink4Title = By.id("pii-admin-efsh-linktitle-3");
	public By HumanCasesLink4URL = By.id("pii-admin-efsh-linkurl-3");
	public By HumanCasesLink5Title = By.id("pii-admin-efsh-linktitle-4");
	public By HumanCasesLink5URL = By.id("pii-admin-efsh-linkurl-4");
	public By HumanCasesLink6Title = By.id("pii-admin-efsh-linktitle-5");
	public By HumanCasesLink6URL = By.id("pii-admin-efsh-linkurl-5");
	public By HumanCasesLink7Title = By.id("pii-admin-efsh-linktitle-6");
	public By HumanCasesLink7URL = By.id("pii-admin-efsh-linkurl-6");
	public By HumanCasesLink8Title = By.id("pii-admin-efsh-linktitle-7");
	public By HumanCasesLink8URL = By.id("pii-admin-efsh-linkurl-7");
	public By HumanCasesLink9Title = By.id("pii-admin-efsh-linktitle-8");
	public By HumanCasesLink9URL = By.id("pii-admin-efsh-linkurl-8");
	public By HumanCasesLink10Title = By.id("pii-admin-efsh-linktitle-9");
	public By HumanCasesLink10URL = By.id("pii-admin-efsh-linkurl-9");
	public By HumanCasesLink11Title = By.id("pii-admin-efsh-linktitle-10");
	public By HumanCasesLink11URL = By.id("pii-admin-efsh-linkurl-10");
	public By HumanCasesLink12Title = By.id("pii-admin-efsh-linktitle-11");
	public By HumanCasesLink12URL = By.id("pii-admin-efsh-linkurl-11");
	public By HumanCasesLink13Title = By.id("pii-admin-efsh-linktitle-12");
	public By HumanCasesLink13URL = By.id("pii-admin-efsh-linkurl-12");
	public By HumanCasesLink2VideoCheckbox = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-1']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By HumanCasesLink4VideoCheckbox = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-3']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By HumanCasesLink5VideoCheckbox = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-4']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By HumanCasesLink6VideoCheckbox = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-5']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By HumanCasesLinkTitleOnSide = By.id("pii-admin-efsh-linklabel-0");
	public By HumanCasesLink1TitleCrossSymbol = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-0']/div[1]/div/a");
	public By HumanCasesLink1URLCrossSymbol = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-0']/div[2]/table/tbody/tr[1]/td[2]/div/a");
	public By HumanCasesLink2TitleCrossSymbol = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-1']/div[1]/div/a");
	public By HumanCasesLink2URLCrossSymbol = By.xpath(".//*[@id='pii-admin-efsh-linkdiv-1']/div[2]/table/tbody/tr[1]/td[2]/div/a");
}
