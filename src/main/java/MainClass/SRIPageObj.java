package MainClass;

import org.openqa.selenium.By;

public class SRIPageObj {

	public By SRILink = By.id("pii-a-menu-sri");
	
	//Admin MainClass.SRI
	public By LoginNameOnTop = By.id("pii-user-loginname");
	public By AdminOption = By.id("pii-user-admin");
	public By AnalysisSideLink = By.xpath(".//*[@id='pii-admin-analysis']/h3/a");
	public By SRISideLink = By.id("pii-admin-sri-manage-button");
	public By SRIAdminSaveButton = By.id("pii-asri-button-save");
	public By SRIAdminPopupNote = By.id("pii-asri-dialog-note");
	public By SRIAdminPopupConfirmButton = By.id("pii-asri-dialog-confirmed");
	public By SRIAdminUndoButton = By.id("pii-asri-button-undo");
	//Components Tab
	public By SRIAdminComponentsTab = By.id("pii-asri-tab-1-a");
	public By SRIAdminComponentsTabMechanicalOption = By.xpath(".//*[@for='pii-asri-component-cat-mech']");
	public By SRIAdminComponentsTabElectricalOption = By.xpath(".//*[@for='pii-asri-component-cat-elec']");
	public By SRIAdminComponentNameFieldEnglish = By.id("pii-asri-component-name-en");
	public By SRIAdminComponentAddButton = By.id("pii-asri-component-add");
	public By SRIAdminComponentMessage = By.id("pii-asri-component-addnew-message");
	//Measurement Tab
	public By SRIAdminMeasurementTab = By.id("pii-asri-tab-2-a");
	public By SRIAdminMeasurementNameLabel = By.xpath(".//*[@id='pii-asri-tab-2-data']/div[1]/div[1]/div[1]");
	public By SRIAdminMeasurementNameFieldEnglish = By.id("pii-asri-meas-name");
	public By SRIAdminMeasurementTabMechanicalDropdown = By.id("pii-asri-meas-component-mech");
	public By SRIAdminMeasurementTabElectricalDropdown = By.id("pii-asri-meas-component-elec");
	public By SRIAdminMeasurementAddButton = By.id("pii-asri-meas-add");
	public By SRIAdminMeasurementMessage = By.id("pii-asri-meas-addnew-message");
	//Units Tab
	public By SRIAdminUnitsTab = By.id("pii-asri-tab-3-a");
	public By SRIAdminUnitName = By.id("pii-asri-unit-name");
	public By SRIAdminUnitTabMeasurementDropdown = By.id("pii-asri-unit-meas-select");
	public By SRIAdminUnitAddButton = By.id("pii-asri-unit-add");
	public By SRIAdminUnitMessage = By.id("pii-asri-unit-addnew-message");
	//Baseline Tab
	public By SRIAdminBaselinesTab = By.id("pii-asri-tab-4-a");
	public By SRIAdminBaselineTabMechanicalDropdown = By.id("pii-asri-baseline-component-mech");
	public By SRIAdminBaselineTabElectricalDropdown = By.id("pii-asri-baseline-component-elec");
	public By SRIAdminBaselineTabMeasurementDropdown = By.id("pii-asri-baseline-meas-new");
	public By SRIAdminBaselineTabUnitDropdown = By.id("pii-asri-baseline-unit-new");
	public By SRIAdminOPField = By.id("pii-asri-baseline-FS1-new");
	public By SRIAdminIFS1Field = By.id("pii-asri-baseline-FS2-new");
	public By SRIAdminIFS2Field = By.id("pii-asri-baseline-FS3-new");
	public By SRIAdminBaselineAddButton = By.id("pii-asri-baseline-add");
	public By SRIAdminBaselinePart2 = By.id("pii-asri-managebaselines-div");
	public By SRIAdminBaselineMessageLine1 = By.xpath(".//*[@id='pii-asri-managebaselines-div']/div[1]");
	public By SRIAdminBaselineMessageLine2 = By.xpath(".//*[@id='pii-asri-managebaselines-div']/div[2]");
	public By SRIAdminBaselineMessageLine3 = By.xpath(".//*[@id='pii-asri-managebaselines-div']/div[3]");
	public By SRIAdminBaselineMessageLine4 = By.xpath(".//*[@id='pii-asri-managebaselines-div']/div[4]");
	public By SRIAdminBaselienOPLimitLabel = By.xpath(".//*[@id='pii-asri-baseline-addnew-div']/div[1]/div[3]/div[1]");
	public By SRIAdminBaselienIFS1LimitLabel = By.xpath(".//*[@id='pii-asri-baseline-addnew-div']/div[1]/div[4]/div[1]");
	public By SRIAdminBaselienIFS2LimitLabel = By.xpath(".//*[@id='pii-asri-baseline-addnew-div']/div[1]/div[5]/div[1]");
	public By SRIAdminBaselineUnitForFirstRow = By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr[1]/td[3]/div/div/span");
	public By SRIAdminBaselineUnitForFirstRowSelect = By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr[1]/td[3]/div/div/select");
	public By SRIAdminBaselineMeasurementForFirstRow = By.xpath(".//*[@id='pii-asri-baseline-table']/tbody/tr[1]/td[2]/div/div/span");
	//Baseline Errors
	public By SRIBaselineErrorMessage = By.xpath(".//*[@id='pii-asri-baseline-addnew-message']/ul/li[1]");
	//Conclusion Tab
	public By SRIAdminConclusionsTab = By.id("pii-asri-tab-5-a");
	public By SRIAdminConclusionTabMechanicalDropdown = By.id("pii-asri-conclusion-component-mech");
	public By SRIAdminConclusionTabElectricalDropdown = By.id("pii-asri-conclusion-component-elec");
	public By SRIAdminConclusionTabMeasurementDropdown = By.id("pii-asri-conclusion-meas-new");
	public By SRIAdminFS1ConclusionField = By.id("pii-asri-conclusion-fs1conc-new");
	public By SRIAdminFS2ConclusionField = By.id("pii-asri-conclusion-fs2conc-new");
	public By SRIAdminFS3ConclusionField = By.id("pii-asri-conclusion-fs3conc-new");
	public By SRIAdminConclusionAddButton = By.id("pii-asri-conclusion-add");
	public By SRIAdminConclusionMeasurementForFirstRow = By.xpath(".//*[@id='pii-asri-conclusion-table']/tbody/tr[1]/td[2]/div/div/span");
	
	//Step1
	public By SRINewButton = By.id("pii-sri-new");
	public By SRIStep1Tab = By.id("pii-sri-tab-1-a");
	public By SRIStep1NextButton = By.id("pii-sri-tab-1-form-submit");
	public By Step1EventTitleLabel = By.id("pii-sri-tab-1-title-label");
	public By Step1TitleCharacterCount = By.id("pii-sri-tab-1-title-count");
	//public By Step1EventTitle = By.id("pii-sri-tab-1-title");
	public By Step1EventTitle = By.xpath("//div[starts-with(@class,'ui-input-text')]/input[@id='pii-sri-tab-1-title']");
	//public By Step1InspectionStaff = By.id("pii-sri-tab-1-inspection-staff");
	public By Step1InspectionStaff = By.xpath("//div[starts-with(@class,'ui-input-text')]/input[@id='pii-sri-tab-1-inspection-staff']");
	public By Step1Component = By.id("pii-sri-tab-1-component");
	public By Step1EventTitleErrorText = By.id("pii-sri-tab-1-title-error");
	public By Step1InspectionStaffErrorText = By.id("pii-sri-tab-1-inspection-staff-error");
	public By Step1ComponentErrorText = By.id("pii-sri-tab-1-component-error");
	public By Step1ComponentOther = By.id("pii-sri-tab-1-component-other");
	public By Step1ReportCreation = By.id("pii-sri-tab-1-repdatetime");
	public By Step1MechanicalComponentLabel = By.xpath(".//*[@for='pii-sri-tab-1-component-type-mech']");
	public By Step1ElectricalComponentLabel = By.xpath(".//*[@for='pii-sri-tab-1-component-type-elec']");
	//Step 2
	public By SRIStep2Tab = By.id("pii-sri-tab-2-a");
	public By Step2Measurement = By.id("pii-sri-newentry-measurement");
	public By Step2Unit = By.id("pii-sri-newentry-unit");
	public By Step2CalendarIconAddMeasurement = By.xpath(".//*[@id='pii-sri-addnew-div']/div/div[1]/div[2]/div/div/a");
	public By Step2ClockIconAddMeasurement = By.xpath(".//*[@id='pii-sri-addnew-div']/div/div[2]/div[2]/div/div/a");
	public By Step2DateField = By.xpath(".//*[@id='pii-sri-addnew-div']/div/div[1]/div[2]/div/div/input");
	public By Step2TimeField = By.xpath(".//*[@id='pii-sri-addnew-div']/div/div[2]/div[2]/div/div/input");
	public By Step2Measurment = By.id("pii-sri-newentry-measurement");
	public By Step2Value = By.id("pii-sri-newentry-value");
	public By Step2Notes = By.id("pii-sri-newentry-notes");
	public By Step2AddButton = By.id("pii-sri-newentry-add");
	public By Step2MeasurementDropDown = By.id("pii-sri-newentry-measurement-button");
	public By Step2Measurement1CalendarIcon = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[2]/div/div/a");
	public By Step2Measurement1ClockIcon = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[3]/div/div/a");
	public By Step2Measurement2CalendarIcon = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[3]/td[2]/div/div/a");
	public By Step2Measurement2ClockIcon = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[3]/td[3]/div/div/a");
	//1
	public By Step2Measurement1Date = By.id("pii-sri-tab-1-event-date");
	public By Step2Measurement1DateFirefox = By.id("pii-sri-tab-1-event0-date");
	public By Step2Measurement1Time = By.id("pii-sri-tab-1-event-time");
	public By Step2Measurement1TimeFirefox = By.id("pii-sri-tab-1-event0-time");
	public By Step2Measurement1Measurement =  By.id("pii-sri-newentry-measurement-button");
//	public By Step2Measurement1Measurement =  By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[4]/div/div/span");
	public By Step2Measurement1MeasurementSelectMenu =  By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[4]/div/div/select");
	public By Step2Measurement1Unit =  By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[5]/div/div/span");
	public By Step2Measurement1Value = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[6]/textarea");
	public By Step2Measurement1Note = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[7]/textarea");
	public By Step2Measurement1DeleteButton = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[1]/td[8]/a");
	//2
	public By Step2Measurement2Date = By.id("pii-sri-tab-1-event1-date");
	public By Step2Measurement2Time = By.id("pii-sri-tab-1-event1-time");
	public By Step2Measurement2Measurement = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[3]/td[4]/div/div/span");
	public By Step2Measurement2Unit = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[3]/td[5]/div/div/span");
	public By Step2Measurement2Value = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[3]/td[6]/textarea");
	public By Step2Measurement2Note = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[3]/td[7]/textarea");
	//3
	public By Step2Measurement3Date = By.id("pii-sri-tab-1-event2-date");
	public By Step2Measurement3Time = By.id("pii-sri-tab-1-event2-time");
	public By Step2Measurement3Measurement = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[5]/td[4]/div/div/span");
	public By Step2Measurement3Unit = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[5]/td[5]/div/div/span");
	public By Step2Measurement3Value = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[5]/td[6]/textarea");
	public By Step2Measurement3Note = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[5]/td[7]/textarea");
	//4
	public By Step2Measurement4Date = By.id("pii-sri-tab-1-event3-date");
	public By Step2Measurement4Time = By.id("pii-sri-tab-1-event3-time");
	public By Step2Measurement4Measurement = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[7]/td[4]/div/div/span");
	public By Step2Measurement4Unit = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[7]/td[5]/div/div/span");
	public By Step2Measurement4Value = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[7]/td[6]/textarea");
	public By Step2Measurement4Note = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[7]/td[7]/textarea");
	//5
	public By Step2Measurement5Date = By.id("pii-sri-tab-1-event4-date");
	public By Step2Measurement5Time = By.id("pii-sri-tab-1-event4-time");
	public By Step2Measurement5Measurement = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[9]/td[4]/div/div/span");
	public By Step2Measurement5Unit = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[9]/td[5]/div/div/span");
	public By Step2Measurement5Value = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[9]/td[6]/textarea");
	public By Step2Measurement5Note = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[9]/td[7]/textarea");
	//6
	public By Step2Measurement6Date = By.id("pii-sri-tab-1-event5-date");
	public By Step2Measurement6Time = By.id("pii-sri-tab-1-event5-time");
	public By Step2Measurement6Measurement = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[11]/td[4]/div/div/span");
	public By Step2Measurement6Unit = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[11]/td[5]/div/div/span");
	public By Step2Measurement6Value = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[11]/td[6]/textarea");
	public By Step2Measurement6Note = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[11]/td[7]/textarea");
	//7
	public By Step2Measurement7Date = By.id("pii-sri-tab-1-event6-date");
	public By Step2Measurement7Time = By.id("pii-sri-tab-1-event6-time");
	public By Step2Measurement7Measurement = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[13]/td[4]/div/div/span");
	public By Step2Measurement7Unit = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[13]/td[5]/div/div/span");
	public By Step2Measurement7Value = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[13]/td[6]/textarea");
	public By Step2Measurement7Note = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[13]/td[7]/textarea");
	//8
	public By Step2Measurement8Date = By.id("pii-sri-tab-1-event7-date");
	public By Step2Measurement8Time = By.id("pii-sri-tab-1-event7-time");
	public By Step2Measurement8Measurement = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[15]/td[4]/div/div/span");
	public By Step2Measurement8Unit = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[15]/td[5]/div/div/span");
	public By Step2Measurement8Value = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[15]/td[6]/textarea");
	public By Step2Measurement8Note = By.xpath(".//*[@id='pii-sri-events-table']/tbody/tr[15]/td[7]/textarea");
			
	public By SRINextButton = By.id("pii-sri-next");
	public By SRISaveButton = By.id("pii-sri-save");
	public By SRISavePopupHeader = By.id("pii-sri-dialog-header");
	public By SRISavePopupTitle = By.id("pii-sri-dialog-title");
	public By SRISavePopupNote = By.id("pii-sri-dialog-note");
	public By SRISaveConfirmButton = By.id("pii-sri-dialog-confirmed");
	public By SRISaveCancelButton = By.id("pii-sri-dialog-cancel");
	public By SRISavedActivitiesButton = By.id("pii-sri-savedactivities");
	public By SRINewRecord = By.xpath(".//*[@id='pii-user-home-activities-sri']/ul/li[2]/a");
	public By SRISidePanel = By.id("pii-user-home-panel-btn-sri");
	public By SRIShareIconOrCriticalIcon = By.xpath(".//*[@id='pii-user-home-activities-sri']/ul/li[2]/a/span[1]");
	public By SRIShareIconWhenAlsoMarkedCritical = By.xpath(".//*[@id='pii-user-home-activities-sri']/ul/li[2]/a/span[2]");
	public By SRIMarkCriticalIndicatorText = By.xpath(".//*[@id='sri-rpt']/div[1]/table/thead/tr/th/strong");
	
	//Report Tab
	
	public By ReportTabInspectionStaff = By.xpath(".//*[@id='pii-sri-tab-3']/div[1]/table/tbody/tr[1]/td[2]");
	public By ReportTabEventTitle = By.xpath("//*[contains(@class,'pii-level45-table')]//td[text()='Report title']");
	
//	public By ReportTabEventTitle = By.xpath(".//*[@id='pii-sri-tab-3']/div[1]/table/tbody/tr[1]/td[2]");
//	public By ReportTabInspectionStaff = By.xpath(".//*[@id='pii-sri-tab-3']/div[1]/table/tbody/tr[3]/td[2]");
	public By ReportTabComponent = By.xpath(".//*[@id='pii-sri-tab-3']/div[1]/table/tbody/tr[4]/td[2]");
	//from step 2
	//1
	public By ReportTabMeasurement1Date = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[2]");
	public By ReportTabMeasurement1Time = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[3]");
	public By ReportTabMeasurement1Measurement = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[4]");
	public By ReportTabMeasurement1Unit = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[5]");
	public By ReportTabMeasurement1Value = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[1]/td[6]");
	public By ReportTabMeasurement1Note = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[2]/td[2]");
	public By ReportTabMeasurement1ConclusionColorText = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[3]/td[1]");
	public By ReportTabMeasurement1Conclusion = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[4]/td[1]");
	//2
	public By ReportTabMeasurement2Date = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[5]/td[2]");
	public By ReportTabMeasurement2Time = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[5]/td[3]");
	public By ReportTabMeasurement2Measurement = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[5]/td[4]");
	public By ReportTabMeasurement2Unit = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[5]/td[5]");
	public By ReportTabMeasurement2Value = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[5]/td[6]");
	public By ReportTabMeasurement2Note = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[6]/td[2]");
	public By ReportTabMeasurement2ConclusionColorText = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[7]/td[1]");
	public By ReportTabMeasurement2Conclusion = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[8]/td[1]");
	//3
	public By ReportTabMeasurement3Date = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[9]/td[2]");
	public By ReportTabMeasurement3Time = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[9]/td[3]");
	public By ReportTabMeasurement3Measurement = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[9]/td[4]");
	public By ReportTabMeasurement3Unit = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[9]/td[5]");
	public By ReportTabMeasurement3Value = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[9]/td[6]");
	public By ReportTabMeasurement3Note = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[10]/td[2]");
	public By ReportTabMeasurement3ConclusionColorText = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[11]/td[1]");
	public By ReportTabMeasurement3Conclusion = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[12]/td[1]");
	//4
	public By ReportTabMeasurement4Date = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[13]/td[2]");
	public By ReportTabMeasurement4Time = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[13]/td[3]");
	public By ReportTabMeasurement4Measurement = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[13]/td[4]");
	public By ReportTabMeasurement4Unit = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[13]/td[5]");
	public By ReportTabMeasurement4Value = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[13]/td[6]");
	public By ReportTabMeasurement4Note = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[14]/td[2]");
	public By ReportTabMeasurement4ConclusionColorText = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[15]/td[1]");
	public By ReportTabMeasurement4Conclusion = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[16]/td[1]");
	//5
	public By ReportTabMeasurement5Date = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[17]/td[2]");
	public By ReportTabMeasurement5Time = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[17]/td[3]");
	public By ReportTabMeasurement5Measurement = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[17]/td[4]");
	public By ReportTabMeasurement5Unit = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[17]/td[5]");
	public By ReportTabMeasurement5Value = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[17]/td[6]");
	public By ReportTabMeasurement5Note = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[18]/td[2]");
	public By ReportTabMeasurement5ConclusionColorText = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[19]/td[1]");
	public By ReportTabMeasurement5Conclusion = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[20]/td[1]");
	//6
	public By ReportTabMeasurement6Date = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[21]/td[2]");
	public By ReportTabMeasurement6Time = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[21]/td[3]");
	public By ReportTabMeasurement6Measurement = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[21]/td[4]");
	public By ReportTabMeasurement6Unit = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[21]/td[5]");
	public By ReportTabMeasurement6Value = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[21]/td[6]");
	public By ReportTabMeasurement6Note = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[22]/td[2]");
	public By ReportTabMeasurement6ConclusionColorText = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[23]/td[1]");
	public By ReportTabMeasurement6Conclusion = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[24]/td[1]");
	//7
	public By ReportTabMeasurement7Date = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[25]/td[2]");
	public By ReportTabMeasurement7Time = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[25]/td[3]");
	public By ReportTabMeasurement7Measurement = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[25]/td[4]");
	public By ReportTabMeasurement7Unit = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[25]/td[5]");
	public By ReportTabMeasurement7Value = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[25]/td[6]");
	public By ReportTabMeasurement7Note = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[26]/td[2]");
	public By ReportTabMeasurement7ConclusionColorText = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[27]/td[1]");
	public By ReportTabMeasurement7Conclusion = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[28]/td[1]");
	//8
	public By ReportTabMeasurement8Date = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[29]/td[2]");
	public By ReportTabMeasurement8Time = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[29]/td[3]");
	public By ReportTabMeasurement8Measurement = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[29]/td[4]");
	public By ReportTabMeasurement8Unit = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[29]/td[5]");
	public By ReportTabMeasurement8Value = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[29]/td[6]");
	public By ReportTabMeasurement8Note = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[30]/td[2]");
	public By ReportTabMeasurement8ConclusionColorText = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[31]/td[1]");
	public By ReportTabMeasurement8Conclusion = By.xpath(".//*[@id='pii-sri-tab-3']/div[2]/table/tbody/tr[32]/td[1]");
	//HTML
	public By HTMLEventTitle = By.xpath(".//*[@id='sri-rpt']/div[1]/table/tbody/tr[1]/td[2]");
	public By HTMLInspectionStaff = By.xpath(".//*[@id='sri-rpt']/div[1]/table/tbody/tr[3]/td[2]");
	public By HTMLComponent = By.xpath(".//*[@id='sri-rpt']/div[1]/table/tbody/tr[4]/td[2]");
	//from step 2
	//1
	public By HTMLMeasurement1Date = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[2]");
	public By HTMLMeasurement1Time = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[3]");
	public By HTMLMeasurement1Measurement = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[4]");
	public By HTMLMeasurement1Unit = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[5]");
	public By HTMLMeasurement1Value = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[1]/td[6]");
	public By HTMLMeasurement1Note = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[2]/td[2]");
	public By HTMLMeasurement1ConclusionColorText = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[3]/td[1]");
	public By HTMLMeasurement1Conclusion = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[4]/td[1]");
	//2
	public By HTMLMeasurement2Date = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[5]/td[2]");
	public By HTMLMeasurement2Time = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[5]/td[3]");
	public By HTMLMeasurement2Measurement = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[5]/td[4]");
	public By HTMLMeasurement2Unit = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[5]/td[5]");
	public By HTMLMeasurement2Value = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[5]/td[6]");
	public By HTMLMeasurement2Note = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[6]/td[2]");
	public By HTMLMeasurement2ConclusionColorText = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[7]/td[1]");
	public By HTMLMeasurement2Conclusion = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[8]/td[1]");
	//3
	public By HTMLMeasurement3Date = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[9]/td[2]");
	public By HTMLMeasurement3Time = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[9]/td[3]");
	public By HTMLMeasurement3Measurement = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[9]/td[4]");
	public By HTMLMeasurement3Unit = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[9]/td[5]");
	public By HTMLMeasurement3Value = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[9]/td[6]");
	public By HTMLMeasurement3Note = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[10]/td[2]");
	public By HTMLMeasurement3ConclusionColorText = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[11]/td[1]");
	public By HTMLMeasurement3Conclusion = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[12]/td[1]");
	//4
	public By HTMLMeasurement4Date = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[13]/td[2]");
	public By HTMLMeasurement4Time = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[13]/td[3]");
	public By HTMLMeasurement4Measurement = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[13]/td[4]");
	public By HTMLMeasurement4Unit = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[13]/td[5]");
	public By HTMLMeasurement4Value = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[13]/td[6]");
	public By HTMLMeasurement4Note = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[14]/td[2]");
	public By HTMLMeasurement4ConclusionColorText = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[15]/td[1]");
	public By HTMLMeasurement4Conclusion = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[16]/td[1]");
	//5
	public By HTMLMeasurement5Date = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[17]/td[2]");
	public By HTMLMeasurement5Time = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[17]/td[3]");
	public By HTMLMeasurement5Measurement = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[17]/td[4]");
	public By HTMLMeasurement5Unit = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[17]/td[5]");
	public By HTMLMeasurement5Value = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[17]/td[6]");
	public By HTMLMeasurement5Note = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[18]/td[2]");
	public By HTMLMeasurement5ConclusionColorText = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[19]/td[1]");
	public By HTMLMeasurement5Conclusion = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[20]/td[1]");
	//6
	public By HTMLMeasurement6Date = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[21]/td[2]");
	public By HTMLMeasurement6Time = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[21]/td[3]");
	public By HTMLMeasurement6Measurement = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[21]/td[4]");
	public By HTMLMeasurement6Unit = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[21]/td[5]");
	public By HTMLMeasurement6Value = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[21]/td[6]");
	public By HTMLMeasurement6Note = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[22]/td[2]");
	public By HTMLMeasurement6ConclusionColorText = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[23]/td[1]");
	public By HTMLMeasurement6Conclusion = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[24]/td[1]");
	//7
	public By HTMLMeasurement7Date = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[25]/td[2]");
	public By HTMLMeasurement7Time = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[25]/td[3]");
	public By HTMLMeasurement7Measurement = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[25]/td[4]");
	public By HTMLMeasurement7Unit = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[25]/td[5]");
	public By HTMLMeasurement7Value = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[25]/td[6]");
	public By HTMLMeasurement7Note = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[26]/td[2]");
	public By HTMLMeasurement7ConclusionColorText = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[27]/td[1]");
	public By HTMLMeasurement7Conclusion = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[28]/td[1]");
	//8
	public By HTMLMeasurement8Date = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[29]/td[2]");
	public By HTMLMeasurement8Time = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[29]/td[3]");
	public By HTMLMeasurement8Measurement = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[29]/td[4]");
	public By HTMLMeasurement8Unit = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[29]/td[5]");
	public By HTMLMeasurement8Value = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[29]/td[6]");
	public By HTMLMeasurement8Note = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[30]/td[2]");
	public By HTMLMeasurement8ConclusionColorText = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[31]/td[1]");
	public By HTMLMeasurement8Conclusion = By.xpath(".//*[@id='sri-rpt']/div[2]/table/tbody/tr[32]/td[1]");

}
