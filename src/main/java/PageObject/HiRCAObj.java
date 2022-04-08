import org.openqa.selenium.By;

public class HiRCAObj {

	public By PageTitle = By.id("efi-instant-rca-message");
	public By PageQuestion = By.id("efi-irca-question");
	public By ReasonEntryLabel = By.xpath(".//*[@for='pii-irca-reason-entry']");
	public By ReasonEntryField = By.id("pii-irca-reason-entry");
	public By Answer1 = By.xpath(".//*[@for='efi-irca-answer-0']");
	public By Answer2 = By.xpath(".//*[@for='efi-irca-answer-1']");
	public By Answer3 = By.xpath(".//*[@for='efi-irca-answer-2']");
	public By Answer4 = By.xpath(".//*[@for='efi-irca-answer-3']");
	public By Answer5 = By.xpath(".//*[@for='efi-irca-answer-4']");
	public By Answer6 = By.xpath(".//*[@for='efi-irca-answer-5']");
	public By Answer7 = By.xpath(".//*[@for='efi-irca-answer-6']");
	public By Answer8 = By.xpath(".//*[@for='efi-irca-answer-7']");
	public By Answer9 = By.xpath(".//*[@for='efi-irca-answer-8']");
	public By Answer10 = By.xpath(".//*[@for='efi-irca-answer-9']");
	public By Answer11 = By.xpath(".//*[@for='efi-irca-answer-10']");
	public By Answer12 = By.xpath(".//*[@for='efi-irca-answer-11']");
	public By NextButton = By.id("efi-irca-button-next");
	public By SkipButton = By.id("efi-irca-button-skip");
	public By DescriptionPlusSign = By.xpath(".//*[@id='efi-irca-description']/h4/a");
	public By DescriptionText = By.id("efi-irca-description-text");
	

	public By AnalysisLink = By.id("pii-main-menu-button-a");
	public By HiRCALink = By.id("pii-a-menu-hirca");

	//Info Page
	public By HiRCAEventTitleField = By.id("pii-irca-event-title");
	public By HiRCAEventLocationField = By.id("pii-irca-event-location");
	public By HiRCAInfoTabNextButtonAtBottom = By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button");
	public By HiRCASaveButton = By.id("efi-irca-button-save");
	public By HiRCASavedActivitiesButton = By.id("efi-irca-btn-savedactivities");
	public By HiRCANewReportButton = By.id("efi-irca-button-new");
	//other buttons
	public By HiRCAFinalizeButton = By.id("efi-irca-button-finalize");
	public By HiRCADownloadButton = By.id("efi-irca-button-download");
	public By HiRCABackButton = By.id("efi-irca-button-back");
	//Popup inside report
	public By HiRCAPopupHeader = By.id("pii-irca-dialog-header");
	public By HiRCAPopupMessage = By.id("pii-irca-dialog-title");
	public By HiRCAPopupNote = By.id("pii-irca-dialog-note");
	public By HiRCAPopupConfirmButton = By.id("pii-irca-dialog-confirmed");
	public By HiRCAPopupConfirmButton2 = By.id("pii-irca-dialog-confirmed2");
	public By HiRCAPopupCancelButton = By.id("pii-irca-dialog-cancel");
	//Tabs
	public By HiRCAInfoTab = By.id("efi-irca-tab-0");
	public By HiRCAStep1Tab = By.id("efi-irca-tab-1");
	public By HiRCAStep2Tab = By.id("efi-irca-tab-2");
	public By HiRCAStep3Tab = By.id("efi-irca-tab-3");
	public By HiRCAStep4Tab = By.id("efi-irca-tab-4");
	public By HiRCAStep5Tab = By.id("efi-irca-tab-5");
	public By HiRCAReportTab = By.id("efi-irca-tab-6");
	
	//Step 1
	public By HiRCAStep1AboutLink = By.id("pii-a-irca-rp1-btn");
	public By HiRCAStep1About4thParagraph = By.xpath(".//*[@id='pii-a-irca-rp1-html']/p[4]");
	//Step 5
	public By HiRCAStep5AboutLink = By.id("pii-a-irca-rp5-btn");
	public By HiRCAStep5AboutLastParagraphUnderBurp = By.xpath(".//*[@id='pii-a-irca-rp5']/div[1]/div[10]/p/small");
	public By HiRCAStep5AboutParagraphUnderTQA = By.xpath(".//*[@id='pii-a-irca-rp5']/div[1]/div[8]/p/small");
}
