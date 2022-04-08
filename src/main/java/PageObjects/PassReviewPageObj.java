package PageObjects;

import org.openqa.selenium.By;

public class PassReviewPageObj {

	public By ReviwerType = By.id("pii-3pr-tab-1-revtype");

	public By PassReviewLink = By.id("pii-a-menu-3pr");

	//HTML report
	public By PassReviewSidePanel = By.id("pii-user-home-panel-btn-3pr");
	public By FirstRecord = By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a");
	public By DeleteButton = By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[3]");
	public By ShareButton = By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[4]");
	public By PassReviewMarkCriticalIndicatorText = By.xpath(".//*[@id='3pr-rpt']/table[1]/tbody/tr/th/strong[1]");
	public By PassReviewShareIconOrCriticalIcon = By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a/span[1]");
	public By PassReviewShareIconWhenAlsoMarkedCritical = By.xpath(".//*[@id='pii-user-home-activities-3pr']/ul/li[2]/a/span[2]");

	//Basic Info
	public By NewButton = By.id("pii-3pr-new");
	public By InfoTab = By.id("pii-3pr-tab-1-a");
	public By Reviewer = By.id("pii-3pr-tab-1-reviewer");
	public By DocumentTitle = By.id("pii-3pr-tab-1-title");
	public By DocumentTitleCharacterCount = By.id("pii-3pr-tab-1-title-count");
	public By Organisation = By.id("pii-3pr-tab-1-org");
	public By DocumentType = By.id("pii-3pr-tab-1-doctype");
	public By SaveButton = By.id("pii-3pr-save");
	public By SavePopupHeader = By.id("pii-3pr-dialog-header");
	public By SavePopupNote = By.id("pii-3pr-dialog-note");
	public By SavePopupTitle = By.id("pii-3pr-dialog-title");
	public By SavePopupConfirmButton = By.id("pii-3pr-dialog-confirmed");
	public By SavePopupCancelButton = By.id("pii-3pr-dialog-cancel");
	public By SavedAcivitiesButton = By.id("pii-3pr-savedactivities");
	public By NextButttonAtBottom = By.xpath(".//*[@id='pii-3pr-tab-1-form']//button");
	//Errors
	public By InfoPageReviewerError = By.id("pii-3pr-tab-1-reviewer-error");
	public By InfoPageDocTitleError = By.id("pii-3pr-tab-1-title-error");
	public By InfoPageDocTypeError = By.id("pii-3pr-tab-1-doctype-error");
	public By InfoPageOrganizationError = By.id("pii-3pr-tab-1-org-error");

	//Pass 1 Tab elements
	public By Pass1RequirementText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[5]/table/tbody/tr/td[2]/textarea");	
	public By Pass1OperatingText = By.xpath("//*[@id='pii-3pr-tab-2']/div[8]/table/tbody/tr/td[2]/textarea");
	public By Pass1AssumptionText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[11]/table/tbody/tr/td[2]/textarea");
	public By Pass1ScopeText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[14]/table/tbody/tr/td[2]/textarea");
	public By Pass1TestingText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[16]/table/tbody/tr/td[2]/textarea");
	public By Pass1TestingText2Answer = By.xpath(".//*[@id='pii-3pr-tab-2']/div[17]/table/tbody/tr/td[2]/textarea");
	
//	public By Pass1RequirementText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[2]/td[2]/textarea");	
//	public By Pass1OperatingText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[3]/td[2]/textarea");
//	public By Pass1AssumptionText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[4]/td[2]/textarea");
//	public By Pass1ScopeText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[5]/td[2]/textarea");
//	public By Pass1TestingText = By.xpath(".//*[@id='pii-3pr-tab-2']/div[3]/table/tbody/tr[6]/td[2]/textarea");
	public By NextButton = By.id("pii-3pr-next");
	public By Pass1Tab = By.id("pii-3pr-tab-2-a");

	//Pass 2 Tab
	public By Pass2Tab = By.id("pii-3pr-tab-3-a");

	//Pass 3 Tab
	public By Pass3Tab1stTableTitle = By.xpath(".//*[@id='pii-3pr-tab-4']/div[1]");
	public By Pass3CriticalText = By.xpath(".//*[@id='pii-3pr-tab-4']/div[3]/table/tbody/tr[2]/td[2]/textarea");
	public By Pass3Tab = By.id("pii-3pr-tab-4-a");

	//HTML
	public By HTMLPass3CriticalText = By.xpath(".//*[@id='3pr-rpt']/div[8]/table/tbody/tr[2]/td[2]");
	public By HTMLPass3Tab1stTableTitle = By.xpath(".//*[@id='3pr-rpt']/div[8]/div");


}
