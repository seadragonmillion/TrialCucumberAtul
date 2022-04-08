package PageObjects;

import org.openqa.selenium.By;

public class JobObservationObj {

	//
	public By JobObservationLink = By.id("pii-a-menu-jo");
	public By JOSidePanel = By.id("pii-user-home-panel-btn-joa");
	public By JOFirstRecord = By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a");
	public By JOFirstRecordCriticalShareSign = By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a/span[1]");
	public By JOFirstRecordSharedWhenCriticalSign = By.xpath(".//*[@id='pii-user-home-activities-joa']/ul/li[2]/a/span[2]");
	//Buttons
	public By JONewButton = By.id("pii-joa-new");
	public By JOSaveButton = By.id("pii-joa-save");
	public By JODelButton = By.id("pii-joa-delete");
	public By JOPopupHeader = By.id("pii-joa-dialog-header");
	public By JOPopupTitle = By.id("pii-joa-dialog-title");
	public By JOPopupNote = By.id("pii-joa-dialog-note");
	public By JOPopupCancelButton = By.id("pii-joa-dialog-cancel");
	public By JOPopupConfirmButton = By.id("pii-joa-dialog-confirmed");
	public By JOSavedActivitiesButton = By.id("pii-joa-btn-savedactivities");
	public By JOStep1NextButton = By.xpath(".//*[@id='pii-joa-button-next");
	public By JOmiddleSubmitButton = By.id("pii-joa-submitjo");
	public By JOStep1SubmitJOButton = By.id("pii-joa-submitjo-footer");
	public By JOStep1GenerateReportButton = By.id("pii-joa-genrep");
	
	//Step 1
	public By Step1Observer = By.id("pii-joa-tab-1-observer");
	public By Step1Organization = By.id("pii-joa-tab-1-org");
	public By Step1Department = By.id("pii-joa-tab-1-dpt");
	public By Step1Location = By.id("pii-joa-tab-1-location");
	public By Step1JobObserved = By.id("pii-joa-tab-1-job");
	//Error on Step 1
	public By Step1ObserverError = By.id("pii-joa-tab-1-observer-error");
	public By Step1OrgError = By.id("pii-joa-tab-1-org-error");
	public By Step1DeptError = By.id("pii-joa-tab-1-dpt-error");
	public By Step1LocationError = By.id("pii-joa-tab-1-location-error");
	public By Step1JobObservedError = By.id("pii-joa-tab-1-job-error");
	//Step 2
	public By JOStep2NextButton = By.id("pii-joa-tab-2-next");
	public By JOStep2Date = By.id("pii-joa-tab-2-date");
	public By JOStep2Time = By.id("pii-joa-tab-2-time");
	public By JOStep2ImageArea = By.id("pii-joa-tab-2-photo-div");
	public By JOStep2ImageRotateButton = By.id("pii-joa-tab-2-rotate");
	public By JOStep2ImageUploadButton = By.id("pii-joa-tab-2-photo-input");
	public By JOStep2Image = By.id("pii-joa-tab-2-photo-img");
	public By JOStep2ImageClearButton = By.id("pii-joa-tab-2-clear");
	//Step 3
	public By Step3Tab = By.id("pii-joa-tab-3-a");
	public By Step3SkillBased = By.id("pii-joa-s3-SB");
	public By Step3RuleBased = By.id("pii-joa-s3-RB");
	public By Step3KnowledgeBased = By.id("pii-joa-s3-KB");
	public By Step3Equipment = By.id("pii-joa-s3-EQ");
	public By Step3Injury = By.id("pii-joa-s3-IN");
	//Step 4
	public By Step4Tab = By.id("pii-joa-tab-4-a");
	public By Step4LOSE_L = By.id("pii-joa-LOSE-L");
	public By Step4LOSE_O = By.id("pii-joa-LOSE-O");
	public By Step4LOSE_S = By.id("pii-joa-LOSE-S");
	public By Step4LOSE_E = By.id("pii-joa-LOSE-E");
	public By Step4CAD_C = By.id("pii-joa-CAD-C");
	public By Step4CAD_A = By.id("pii-joa-CAD-A");
	public By Step4CAD_D = By.id("pii-joa-CAD-D");
	public By Step4BOOST1 = By.id("pii-joa-BOOST-1");
	public By Step4BOOST2 = By.id("pii-joa-BOOST-2");
	public By Step4BOOST3 = By.id("pii-joa-BOOST-3");
	public By Step4BOOST4 = By.id("pii-joa-BOOST-4");
	public By Step4BOOST5 = By.id("pii-joa-BOOST-5");
	public By Step4TQA_T = By.id("pii-joa-TQA-T");
	public By Step4TQA_Q = By.id("pii-joa-TQA-Q");
	public By Step4TQA_A = By.id("pii-joa-TQA-A");
	public By Step4ABC_A = By.id("pii-joa-ABC-A");
	public By Step4ABC_B = By.id("pii-joa-ABC-B");
	public By Step4ABC_C = By.id("pii-joa-ABC-C");
	public By Step4BURP_B = By.id("pii-joa-BURP-B");
	public By Step4BURP_U = By.id("pii-joa-BURP-U");
	public By Step4BURP_R = By.id("pii-joa-BURP-R");
	public By Step4BURP_P = By.id("pii-joa-BURP-P");
	public By Step4DDOT1 = By.id("pii-joa-DDOT-1");
	public By Step4DDOT2 = By.id("pii-joa-DDOT-2");
	public By Step4DDOT3 = By.id("pii-joa-DDOT-3");
	public By Step4DDOT4 = By.id("pii-joa-DDOT-4");
	public By Step4DDOT5 = By.id("pii-joa-DDOT-5");
	//Step 5
	public By JOStep5NextButton = By.id("pii-joa-tab-5-button");
	public By Step5Answer1 = By.xpath(".//*[@for='pii-joa-tab-5-answer-0']");
	public By Step5Answer2 = By.xpath(".//*[@for='pii-joa-tab-5-answer-1']");
	public By Step5Answer3 = By.xpath(".//*[@for='pii-joa-tab-5-answer-2']");
	public By Step5Answer4 = By.xpath(".//*[@for='pii-joa-tab-5-answer-3']");
	public By Step5Answer5 = By.xpath(".//*[@for='pii-joa-tab-5-answer-4']");
	public By Step5Answer6 = By.xpath(".//*[@for='pii-joa-tab-5-answer-5']");
	public By Step5Answer7 = By.xpath(".//*[@for='pii-joa-tab-5-answer-6']");
	public By Step5Answer8 = By.xpath(".//*[@for='pii-joa-tab-5-answer-7']");
	public By Step5Answer9 = By.xpath(".//*[@for='pii-joa-tab-5-answer-8']");
	public By Step5Answer10 = By.xpath(".//*[@for='pii-joa-tab-5-answer-9']");
	public By Step5Notes = By.id("pii-joa-notes-step5");
	//Step 6
	public By Step6Answer1 = By.id("pii-joa-tab-6-answer-0");
	public By Step6Answer2 = By.id("pii-joa-tab-6-answer-1");
	public By Step6Notes = By.id("pii-joa-notes-step6");
	public By JOStep6BuildReportButton = By.id("pii-joa-tab-6-report");
	//Report tab
	public By ReportTabStep5Notes = By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[5]/span/ul/li[1]");
	public By ReportTabStep6Notes = By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[5]/span/ul/li[2]");
	public By ReportTabStep3And4Answers = By.xpath(".//*[@id='pii-jo-rpt-data']/div[6]/div[2]/span");
	//HTML
	public By HTMLMarkedCritical = By.xpath(".//*[@id='joa-rpt']/div/div/span[3]/strong");
	public By JODeleteButton = By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a");
	public By JOShareButton = By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]");
}
