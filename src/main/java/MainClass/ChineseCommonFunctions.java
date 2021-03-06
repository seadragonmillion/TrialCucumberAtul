package MainClass;


import PageObjects.*;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChineseCommonFunctions {

	EiRCAPageObj eirca = new EiRCAPageObj();
	ErrorMeterPageObj em = new ErrorMeterPageObj();
	HPIObj hpi = new HPIObj();
	HiRCAObj hc = new HiRCAObj();
	SRIPageObj sri = new SRIPageObj();
	OPiRCAPageObj opirca = new OPiRCAPageObj();
	JobObservationObj job = new JobObservationObj();
	PassReviewPageObj pr = new PassReviewPageObj();
	RemoteVerificationPageObj rv = new RemoteVerificationPageObj();
	CreateEquipPageObj equip = new CreateEquipPageObj();
	CreateHumanCasePageObj human = new CreateHumanCasePageObj();
	UserManagementPageObj um = new UserManagementPageObj();
	ShareCheckPageObj shareObj = new ShareCheckPageObj();
	ShareCheck2 share2 = new ShareCheck2();

	public String decideSharerChinese (WebDriver driver) throws Exception{

		String url = driver.getCurrentUrl();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		//Dev
		if(url.contains("kaleqa"))
		{
			if(browserName.contains("internet explorer")&&v.startsWith("11"))
			{
				String sharer ="jenkins_sharer_chinese_ie11";
				return sharer;
			}
			else
			{
				String sharer ="jenkins_sharer_chinese";
				return sharer;
			}
		}
		else
		{
			//Prod
			if(browserName.contains("internet explorer")&&v.startsWith("11"))
			{
				String sharer ="jenkins_sharer_chinese_ie11";
				return sharer;
			}
			else
			{
				String sharer ="jenkins_sharer_chinese";
				return sharer;
			}
		}
	}

	public String decideSharerAddedChinese(WebDriver driver) throws Exception{

		String url = driver.getCurrentUrl();
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		//Dev
		if(url.contains("kaleqa"))
		{
			if(browserName.contains("internet explorer")&&v.startsWith("11"))
			{
				String sharer ="QAA (jenkins_sharer_chinese_ie11)";
				return sharer;
			}
			else
			{
				String sharer ="QAA (jenkins_sharer_chinese)";
				return sharer;
			}
		}
		else
		{
			//Prod
			if(browserName.contains("internet explorer")&&v.startsWith("11"))
			{
				String sharer ="QAA (jenkins_sharer_chinese_ie11)";
				return sharer;
			}
			else
			{
				String sharer ="QAA (jenkins_sharer_chinese)";
				return sharer;
			}
		}
	}

	public void verifyChineseSharePage(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);	
		//Share save button
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareSaveButton)).getText();
		softly.assertThat(s).as("test data").isEqualTo("??????");
		//Share cancel button
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.SharePageCancelButton)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("??????");
		//Share activity with other users
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.SharedActivityWithOtherUsersHeading)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("????????????");
		//Shared to users (click to remove)
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.SharedToUsersLabel)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("?????????????????????????????????");
		//enter username
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ShareTextBox)).getAttribute("placeholder");
		softly.assertThat(s4).as("test data").isEqualTo("???????????????");
		//search and select existing users
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.ShareSearchSelectUsersLabel)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("?????????????????????: ");
		System.out.println("chinese share page verified");
	}

	public void verifyChineseRemoveSharerPopup(WebDriver driver, SoftAssertions softly, String sharer) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("????????????");
		//Verify question on pop up, sharer in format = QAA (ritica_only_nonadmin)
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("????????????????????? ["+sharer+"] ????????????????");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("???????????????????????????????????????");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("??????");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("??????");
		System.out.println("chinese remove sharer verified");
	}

	public void verifyChineseAddSharerPopup(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);		
		//Verify pop up header
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupHeader)).getText();
		softly.assertThat(s).as("test data").isEqualTo("????????????");
		//Verify question on pop up, sharer in format = QAA (ritica_only_nonadmin)
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("?????????????????????????????? [QAA (jenkins_1_nonadmin)]?");
		//Verify note under question
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupNote)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("????????????????????????????????????");
		//Cancel button
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmCancelButton)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("??????");
		//Open button
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("??????");
		System.out.println("chinese add sharer verified");
	}	

	public void verifyChineseLabelsButtonsNotificationPage(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Open
		String open = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationOpenButton)).getText();
		softly.assertThat(open).as("test data").isEqualTo("????????????");
		//read
		String read = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationReadButton)).getText();
		softly.assertThat(read).as("test data").isEqualTo("??????");
		//unread
		String unread = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationUnreadButton)).getText();
		softly.assertThat(unread).as("test data").isEqualTo("??????");
		//delete
		String delete =  wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationDeleteButton)).getText();
		softly.assertThat(delete).as("test data").isEqualTo("??????");
		//Column titles
		//Read
		String readColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationReadColumnTitle)).getText();
		softly.assertThat(readColumn).as("test data").isEqualTo("??????");
		//Date and Time
		String dateColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationDateTimeColumnTitle)).getText();
		softly.assertThat(dateColumn).as("test data").isEqualTo("???????????????");
		//From
		String fromColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NoitficationFromColumnTitle)).getText();
		softly.assertThat(fromColumn).as("test data").isEqualTo("??????");
		//Reason
		String reasonColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationReasonColumnTitle)).getText();
		softly.assertThat(reasonColumn).as("test data").isEqualTo("??????");
		//Report title
		String reportColumn = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.NotificationReportTitleColumnTitle)).getText();
		softly.assertThat(reportColumn).as("test data").isEqualTo("????????????");
		System.out.println("chinese notification page verified");
	}

	public void verifyErrorFreeBankModulesChineseMenu(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//human performance
		String hp = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.HumanPerformanceNameLink)).getText();
		softly.assertThat(hp).as("test data").isEqualTo("??????????????????");
		//Equipment Data Bank
		String db = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.EquipmentDataBankLink)).getText();
		softly.assertThat(db).as("test data").isEqualTo("????????????");
		//engineering fundamentals
		String ef = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.EngineeringFundamentalsNameLink)).getText();
		softly.assertThat(ef).as("test data").isEqualTo("??????????????????");
		//equipment performance
		String ep = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.EquipmentPerformanceNameLink)).getText();
		softly.assertThat(ep).as("test data").isEqualTo("??????????????????");
		//failure modes
		String fm = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.FailureModesNameLink)).getText();
		softly.assertThat(fm).as("test data").isEqualTo("??????????????????");
		//pdd
		String pdd = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.PreventionOfDesignDeficienciesNameLink)).getText();
		softly.assertThat(pdd).as("test data").isEqualTo("????????????????????????");
		//sri
		String sri = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.SRINameLink)).getText();
		softly.assertThat(sri).as("test data").isEqualTo("???????????????????????????");
		//equipment databank
		String ed = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.EquipmentDatabankNameLink)).getText();
		softly.assertThat(ed).as("test data").isEqualTo("????????????-????????????");
	}

	public void verifyKnowledgeModulesChineseMenu(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//event reports
		String er = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.EventReportLink)).getText();
		softly.assertThat(er).as("test data").isEqualTo("????????????");
		//jit wisdom
		String jw = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.JITWisdomLink)).getText();
		softly.assertThat(jw).as("test data").isEqualTo("????????????");
		//jit risk joggers
		String jrj = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.JITRiskJoggersLink)).getText();
		softly.assertThat(jrj).as("test data").isEqualTo("??????????????????");
		//knowledge bank
		String kb = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.KnowledgeBankLink)).getText();
		softly.assertThat(kb).as("test data").isEqualTo("?????????");
		//knowledge exchange
		String ke = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.KnowledgeExchangeLink)).getText();
		softly.assertThat(ke).as("test data").isEqualTo("????????????");
		//PAA
		String paa = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.PerformanceAccountabilityAnalyticsLink)).getText();
		softly.assertThat(paa).as("test data").isEqualTo("??????????????????");
	}

	public void verifyAnalysisModulesChineseMenu(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//error meter
		String er = wait.until(ExpectedConditions.visibilityOfElementLocated(em.ErrorMeterLink)).getText();
		softly.assertThat(er).as("test data").isEqualTo("SPV??????????????????");
		//hpi
		String hp = wait.until(ExpectedConditions.visibilityOfElementLocated(hpi.HPILink)).getText();
		softly.assertThat(hp).as("test data").isEqualTo("MainClass.HPI??? (???????????????)");
		//sri
		String sr = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRILink)).getText();
		softly.assertThat(sr).as("test data").isEqualTo("MainClass.SRI??? (?????????????????????)");
		//hirca
		String hir = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCALink)).getText();
		softly.assertThat(hir).as("test data").isEqualTo("HiRCA??? (????????????????????????)");
		//eirca
		String eir = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCALink)).getText();
		softly.assertThat(eir).as("test data").isEqualTo("MainClass.EiRCA??? (??????????????????)");
		//o&p
		String op = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCALink)).getText();
		softly.assertThat(op).as("test data").isEqualTo("O&P iRCA??? (????????????????????????)");
		//icca
		String ic = wait.until(ExpectedConditions.visibilityOfElementLocated(shareObj.ICCALink)).getText();
		softly.assertThat(ic).as("test data").isEqualTo("??????????????????");
		//job obs
		String jo = wait.until(ExpectedConditions.visibilityOfElementLocated(job.JobObservationLink)).getText();
		softly.assertThat(jo).as("test data").isEqualTo("????????????");
		//3 pass
		String p3 = wait.until(ExpectedConditions.visibilityOfElementLocated(pr.PassReviewLink)).getText();
		if(driver.getCurrentUrl().contains("kaleqa"))
			softly.assertThat(p3).as("test data").isEqualTo("???????????????");
		else
			softly.assertThat(p3).as("test data").isEqualTo("????????????");
		//rv
		String rev = wait.until(ExpectedConditions.visibilityOfElementLocated(rv.RVLink)).getText();
		softly.assertThat(rev).as("test data").isEqualTo("????????????");
	}

	public void verifyChineseMainMenuLinks(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Click on KALE HomePage
		wait.until(ExpectedConditions.visibilityOfElementLocated(equip.KaleHomePage)).click();
		//Click on Analysis
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.AnalysisLink)).click();
		verifyAnalysisModulesChineseMenu(driver,softly);
		//Click on Knowledge
		wait.until(ExpectedConditions.visibilityOfElementLocated(um.KnowledgeTopLink)).click();
		verifyKnowledgeModulesChineseMenu(driver,softly);
		//Click on Error-Free Bank
		wait.until(ExpectedConditions.visibilityOfElementLocated(human.ErrorFreeBankTopLink)).click();
		verifyErrorFreeBankModulesChineseMenu(driver,softly);
	}

	public void verifyChineseTabsInsideEiRCA(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//tabs
		//info
		String info = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.InfoTab)).getText();
		softly.assertThat(info).as("test data").isEqualTo("??????");
		//step1
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep1Tab)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("?????????");
		//step2
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep2Tab)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("?????????");
		//step3
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep3Tab)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("?????????");
		//step4
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep4Tab)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("?????????");
		//step5
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep5Tab)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("?????????");
		//step6
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep6Tab)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("?????????");
		//step7
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAStep7Tab)).getText();
		softly.assertThat(s7).as("test data").isEqualTo("?????????");
		//report
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAReportTab)).getText();
		softly.assertThat(s8).as("test data").isEqualTo("??????");
	}

	public void verifyChineseButtonsInfoTabEiRCA(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//new
		String info = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NewButton)).getText();
		softly.assertThat(info).as("test data").isEqualTo("??????");
		//save
		String save = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).getText();
		softly.assertThat(save).as("test data").isEqualTo("??????");
		//saved activities
		String savedActivities = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).getText();
		softly.assertThat(savedActivities).as("test data").isEqualTo("??????????????????");
		//next on the bottom
		String next = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NextButtonBottomOfInfoPage)).getText();
		softly.assertThat(next).as("test data").isEqualTo("?????????");
		//next
		String next1 = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCANextButton)).getText();
		softly.assertThat(next1).as("test data").isEqualTo("?????????");
	}

	public void verifyChineseButtonsReportTabEiRCA(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//new
		String info = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.NewButton)).getText();
		softly.assertThat(info).as("test data").isEqualTo("??????");
		//save
		String save = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASaveButton)).getText();
		softly.assertThat(save).as("test data").isEqualTo("??????");
		//saved activities
		String savedActivities = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCASavedActivitiesButton)).getText();
		softly.assertThat(savedActivities).as("test data").isEqualTo("??????????????????");		
		//download
		String dnld = wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.EiRCAReportTabDownloadButton)).getText();
		softly.assertThat(dnld).as("test data").isEqualTo("??????");
	}

	public void verifyChineseTabsInsideHiRCA(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//tabs
		//info
		String info = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAInfoTab)).getText();
		softly.assertThat(info).as("test data").isEqualTo("??????");
		//step1
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAStep1Tab)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("?????????");
		//step2
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAStep2Tab)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("?????????");
		//step3
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAStep3Tab)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("?????????");
		//step4
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAStep4Tab)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("?????????");
		//step5
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAStep5Tab)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("?????????");
		//report	
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAReportTab)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("??????");
	}

	public void verifyChineseButtonsInfoTabHiRCA(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//new
		String info = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCANewReportButton)).getText();
		softly.assertThat(info).as("test data").isEqualTo("??????");
		//save
		String save = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCASaveButton)).getText();
		softly.assertThat(save).as("test data").isEqualTo("??????");
		//saved activities
		String savedActivities = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCASavedActivitiesButton)).getText();
		softly.assertThat(savedActivities).as("test data").isEqualTo("??????????????????");
		//next on the bottom
		String next = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAInfoTabNextButtonAtBottom)).getText();
		softly.assertThat(next).as("test data").isEqualTo("?????????");		
	}

	public void verifyChineseButtonsReportTabHiRCA(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//new
		String info = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCANewReportButton)).getText();
		softly.assertThat(info).as("test data").isEqualTo("??????");
		//save
		String save = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCASaveButton)).getText();
		softly.assertThat(save).as("test data").isEqualTo("??????");
		//saved activities
		String savedActivities = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCASavedActivitiesButton)).getText();
		softly.assertThat(savedActivities).as("test data").isEqualTo("??????????????????");
		//finalize
		String finalize = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCAFinalizeButton)).getText();
		softly.assertThat(finalize).as("test data").isEqualTo("????????????");
		//back
		String back = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCABackButton)).getText();
		softly.assertThat(back).as("test data").isEqualTo("??????");
		//download
		String dnld = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCADownloadButton)).getText();
		softly.assertThat(dnld).as("test data").isEqualTo("??????");
	}

	public void verifyChineseButtonsInBetweenTabsHiRCA(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//new
		String info = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCANewReportButton)).getText();
		softly.assertThat(info).as("test data").isEqualTo("??????");
		//save
		String save = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCASaveButton)).getText();
		softly.assertThat(save).as("test data").isEqualTo("??????");
		//saved activities
		String savedActivities = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCASavedActivitiesButton)).getText();
		softly.assertThat(savedActivities).as("test data").isEqualTo("??????????????????");
		//skip
		String skip = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.SkipButton)).getText();
		softly.assertThat(skip).as("test data").isEqualTo("??????");
		//back
		String back = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.HiRCABackButton)).getText();
		softly.assertThat(back).as("test data").isEqualTo("??????");
		//next
		String next = wait.until(ExpectedConditions.visibilityOfElementLocated(hc.NextButton)).getText();
		softly.assertThat(next).as("test data").isEqualTo("?????????");
	}

	public void verifyChineseTabsInsideOPiRCA(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//tabs
		//info
		String info = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoTab)).getText();
		softly.assertThat(info).as("test data").isEqualTo("??????");
		//step1
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep1Tab)).getText();
		softly.assertThat(s1).as("test data").isEqualTo("?????????");
		//step2
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep2Tab)).getText();
		softly.assertThat(s2).as("test data").isEqualTo("?????????");
		//step3
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep3Tab)).getText();
		softly.assertThat(s3).as("test data").isEqualTo("?????????");
		//step4
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep4Tab)).getText();
		softly.assertThat(s4).as("test data").isEqualTo("?????????");
		//step5
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep5Tab)).getText();
		softly.assertThat(s5).as("test data").isEqualTo("?????????");
		//report
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTab)).getText();
		softly.assertThat(s6).as("test data").isEqualTo("??????");
	}

	public void verifyChineseButtonsInfoTabOPiRCA(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//new
		String info = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.NewButton)).getText();
		softly.assertThat(info).as("test data").isEqualTo("??????");
		//save
		String save = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveButton)).getText();
		softly.assertThat(save).as("test data").isEqualTo("??????");
		//saved activities
		String savedActivities = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavedActivitiesButton)).getText();
		softly.assertThat(savedActivities).as("test data").isEqualTo("??????????????????");
		//next on the bottom
		String next = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButtonAtBottomOfInfoTab)).getText();
		softly.assertThat(next).as("test data").isEqualTo("?????????");		
	}

	public void verifyChineseButtonsReportTabOPiRCA(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//new
		String info = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.NewButton)).getText();
		softly.assertThat(info).as("test data").isEqualTo("??????");
		//save
		String save = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveButton)).getText();
		softly.assertThat(save).as("test data").isEqualTo("??????");
		//saved activities
		String savedActivities = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavedActivitiesButton)).getText();
		softly.assertThat(savedActivities).as("test data").isEqualTo("??????????????????");
		//finalize
		String finalize = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFinalizeButton)).getText();
		softly.assertThat(finalize).as("test data").isEqualTo("????????????");
		//back
		String back = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCABackButton)).getText();
		softly.assertThat(back).as("test data").isEqualTo("??????");
		//download
		String dnld = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabDownloadButton)).getText();
		softly.assertThat(dnld).as("test data").isEqualTo("??????");
	}

	public void verifyChineseButtonsInBetweenTabsOPiRCA(WebDriver driver, SoftAssertions softly) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,30);
		//new
		String info = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.NewButton)).getText();
		softly.assertThat(info).as("test data").isEqualTo("??????");
		//save
		String save = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveButton)).getText();
		softly.assertThat(save).as("test data").isEqualTo("??????");
		//saved activities
		String savedActivities = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavedActivitiesButton)).getText();
		softly.assertThat(savedActivities).as("test data").isEqualTo("??????????????????");
		//skip
		String skip = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).getText();
		softly.assertThat(skip).as("test data").isEqualTo("??????");
		//back
		String back = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCABackButton)).getText();
		softly.assertThat(back).as("test data").isEqualTo("??????");
		//next
		String next = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).getText();
		softly.assertThat(next).as("test data").isEqualTo("?????????");
	}
}
