import org.openqa.selenium.By;


public class ShareCheckPageObj {

	public By LoadingMessage = By.className("ui-icon-loading");
	public By StickyPopUp = By.cssSelector(".sticky.border-top-right.sticky-error");
	public By NotificationBell = By.id("pii-notification-button");
	public By NotificationFirstRecord = By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]");
	public By NotificationFirstRecordReportTitle = By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]/td[7]");
	public By NotificationOpenButton = By.id("pii-notif-report-btn");
	public By NotificationCount = By.id("pii-notification-count");
	public By NotificationFirstRecordDescriptionText = By.xpath(".//*[@id='pii-notif-jqgrid']/tbody/tr[2]/td[6]");
	public By NotificationReadButton = By.id("pii-notif-ack-btn");
	public By NotificationUnreadButton = By.id("pii-notif-unack-btn");
	public By NotificationDeleteButton = By.id("pii-notif-del-btn");
	public By NotificationReadConfirmButton = By.id("pii-notifcenter-dialog-confirmed");
	public By NotificationReadUnreadCancelButton = By.id("pii-notifcenter-dialog-cancel");
	public By NotificationReadUnreadPopUpHeader = By.id("pii-notifcenter-dialog-header");
	public By NotificationReadUnreadPopUpTitle = By.id("pii-notifcenter-dialog-title");
	public By NotificationReadUnreadPopUpNote = By.id("pii-notifcenter-dialog-note");
	public By NotificationReadColumnTitle = By.id("jqgh_pii-notif-jqgrid_Acked");
	public By NotificationDateTimeColumnTitle = By.id("jqgh_pii-notif-jqgrid_Date");
	public By NoitficationFromColumnTitle = By.id("jqgh_pii-notif-jqgrid_From");
	public By NotificationReasonColumnTitle = By.id("jqgh_pii-notif-jqgrid_Reason");
	public By NotificationReportTitleColumnTitle = By.id("jqgh_pii-notif-jqgrid_Title");
	public By LoginNameOnTopRight = By.id("pii-user-loginname");
	public By ActivityOnTopRight = By.id("pii-user-activity");
	public By AccountOnTopRight = By.id("pii-user-acct");
	public By ModuleTitle = By.id("pii-user-home-title");
	public By SharedReportDownloadButton = By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]");
	public By PIIContactButton = By.linkText("CONTACT");
	public By KALESupportButton = By.id("pii-contact-mailto");
	public By UserAccountSaveButton = By.id("pii-admin-user-button-save");
	public By UserAccountSavePopupTitle = By.id("pii-admin-user-dialog-title");
	public By UserAccountSavePopupSaveButton = By.id("pii-admin-user-dialog-confirmed");
	public By SharePageCancelButton = By.id("pii-uhshare-cancel");
	public By SharedToUsersLabel = By.id("pii-uhshare-shared-to-user-label");
	public By VerifierLabel = By.id("pii-uhshare-verifier-label");
	public By VerifierSectionDiv = By.id("pii-uhshare-verifier-list-div");
	public By SharedActivityWithOtherUsersHeading = By.id("pii-parag-title");
	public By ShareSearchSelectUsersLabel = By.id("pii-uhshare-search-select-user-label");
	public By KALEContactPage = By.linkText("CONTACT");
	
	//ICCA link
	public By ICCALink = By.id("pii-a-menu-icca");
	//Knowledge menu
	public By EventReportLink = By.xpath(".//*[@href='#efi-k-er']");
	public By JITWisdomLink = By.xpath(".//*[@href='#efi-k-jitwb']");
	public By JITRiskJoggersLink  = By.xpath(".//*[@href='#efi-k-jitmj']");
	public By KnowledgeBankLink  = By.xpath(".//*[@href='#pii-k-knowledge-bank']");
	public By KnowledgeExchangeLink  = By.xpath(".//*[@href='#pii-k-knowledge-exchange']");
	public By PerformanceAccountabilityAnalyticsLink  = By.xpath(".//*[@href='#pii-k-analytics-paa']");
	//ErrorFree bank name links
	public By HumanPerformanceNameLink = By.xpath(".//*[@href='#pii-learning']");
	public By EquipmentDataBankLink = By.xpath(".//*[@href='#pii-learning-equip?ALL']");
	public By EngineeringFundamentalsNameLink = By.xpath(".//*[@href='#pii-learning-equip?engFun']");
	public By EquipmentPerformanceNameLink = By.xpath(".//*[@href='#pii-learning-equip?noFMs']");
	public By FailureModesNameLink = By.xpath(".//*[@href='#pii-learning-equip?FMs']");
	public By PreventionOfDesignDeficienciesNameLink = By.xpath(".//*[@href='#pii-learning-equip?preDesDef']");
	public By SRINameLink = By.xpath(".//*[@href='#pii-learning-equip?SRI']");
	public By EquipmentDatabankNameLink = By.xpath(".//*[@href='#pii-learning-equip']");
}
