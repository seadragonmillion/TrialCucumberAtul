package PageObjects;

import org.openqa.selenium.By;


public class CaseBrowsePageObj {

	public By ErrorFreeBankLinkHomePage = By.id("pii-main-menu-button-e");
	public By HumanPerformanceLink = By.linkText("Human Performance");
	public By EquipmentPerformanceLink = By.linkText("Equipment Performance");
	public By EquipmentDatabankOnlyLink = By.linkText("Equipment Data Bank (Instructor Only)");
	public By ElectricalFailureModeLink = By.linkText("Electrical Failure Modes");
	public By MechanicalFailureModeLink = By.linkText("Mechanical Failure Modes");
	public By FailureModeLink = By.linkText("Failure Modes");
	public By EquipmentDatabankOnlyLink1 = By.id("pii-e-menu-equipPII");

	//Error-free Bank Module page
	public By ErrorFreeBankTitle = By.cssSelector(".pii-menu-title-text.pii-menu-title-text-e");
	public By HumanPerformancePosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[1]/a");
	public By EngineeringFundamentalPosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[2]/a");
	public By EquipmentPerformancePosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[3]/a");
	public By FailureModesPosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[4]/a");
	public By PreventionOfDesignDeficienciesPosition = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[5]/a");
	public By SystematicReliabilityInspectionDevEquipmentDatabankOnlyPositionProd = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[6]/a");
	public By EquipmentDatabankOnlyPositionDev = By.xpath(".//*[@id='pii-e-menu']/article/div[2]/ul/li[7]/a");

	//Equipment Case
	public By EquipmentAddKeywordField = By.id("pii-admin-efse-keyword-search-input");
	public By EquipmentAddKeywordButton = By.id("pii-admin-efse-keyword-new");

	//Equipment Search
	public By EquipmentSearchLogo = By.xpath(".//*[@id='pii-user-image-equip']/img");
	public By EquipmentSearchKeywordLabel = By.xpath(".//*[@id='pii-keyword-block-equip']/div[4]/label");
	public By EquipmentSearchTitle = By.id("pii-efse-search-label");
	public By EquipmentSearchKeywordField = By.id("pii-efse-searchbykw-input");
	public By EquipmentSearchClearButton = By.id("pii-efse-clear");
	public By EquipmentSearchKeywordFieldSearchButton = By.id("pii-efse-searchbykw-btn");
	public By EquipmentDropDownList = By.xpath(".//*[@id='pii-efse-keyword-list']/li");
	public By EquipmentDropDownListTitle = By.xpath(".//*[@id='pii-efse-keyword-list']/li[2]");
	public By EquipmentSearchCaseIDFieldClearButton = By.xpath(".//*[@id='pii-keyword-block-equip']/div[3]/div/div/a");
	public By EquipmentSearchCaseIdField = By.id("pii-efse-searchbyid-input");
	public By EquipmentModuleTitle = By.id("pii-efse-search-label");
	public By EquipmentSearchDropDown = By.id("pii-efse-keyword-list");
	public By EquipmentSearchKeywordFieldClearButton = By.xpath(".//*[@id='pii-keyword-block-equip']/div[4]/div/div/a");
	public By EquipmentSearchCaseIDFieldSearchButton = By.id("pii-efse-searchbyid-btn");
	public By EquipSearch1stCollapsibleCases = By.xpath(".//*[@id='pii-question-list-equip']/div[1]/h4/a");
	public By EquipSearch2ndCollapsibleCases = By.xpath(".//*[@id='pii-question-list-equip']/div[2]/h4/a");
	public By CaseSearchDisciplineBoxText = By.xpath(".//*[@id='pii-efse-filter-discipline-button']/span[1]");
	public By CaseSearchDisciplineBox = By.id("pii-efse-filter-discipline-button");
	public By CaseSearchDisciplineList = By.id("pii-efse-filter-discipline-listbox");
	public By CaseSearchDisciplinePopupClose = By.xpath(".//*[@id='pii-efse-filter-discipline-listbox']/div/a");
	public By EquipCaseSearchListDisciplineElectrical = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[1]/a");
	public By EquipCaseSearchListDisciplineGeneral = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[2]/a");
	public By EquipCaseSearchListDisciplineIC = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[3]/a");
	public By EquipCaseSearchListDisciplineMechanical = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[4]/a");
	public By EquipCaseSearchListDisciplineSoftware = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[5]/a");
	public By EquipCaseSearchListDisciplineStructural = By.xpath(".//*[@id='pii-efse-filter-discipline-menu']/li[6]/a");
	public By CaseSearchFieldBox = By.id("pii-efse-filter-field-button");
	public By CaseSearchFieldList = By.id("pii-efse-filter-field-listbox");
	public By CaseSearchFieldPopupClose = By.xpath(".//*[@id='pii-efse-filter-field-listbox']/div/a");
	public By EquipCaseSearchListFieldAuto = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[1]/a");
	public By EquipCaseSearchListFieldNuclear = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[2]/a");
	public By EquipCaseSearchListFieldOther = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[3]/a");
	public By EquipCaseSearchListFieldPharmaceutical = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[4]/a");
	public By EquipCaseSearchListFieldWelding = By.xpath(".//*[@id='pii-efse-filter-field-menu']/li[5]/a");
	public By CaseSearchTypeBox = By.id("pii-efse-filter-type-button");
	public By CaseSearchTypeList = By.id("pii-efse-filter-type-listbox");
	public By CaseSearchTypesPopupClose = By.xpath(".//*[@id='pii-efse-filter-type-listbox']/div/a");
	public By EquipCaseSearchListTypesAdvancedLearning = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[1]/a");
	public By EquipCaseSearchListTypesCaseStudies = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[2]/a");
	public By EquipCaseSearchListTypesDesign = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[3]/a");
	public By EquipCaseSearchListTypesFailureMode = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[4]/a");
	public By EquipCaseSearchListTypesFundamentals = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[5]/a");
	public By EquipCaseSearchListTypesGeneral = By.xpath(".//*[@id='pii-efse-filter-type-menu']/li[6]/a");

	//Human Case
	public By HumanAddKeywordField = By.id("pii-admin-efsh-keyword-search-input");
	public By HumanAddKeywordButton = By.id("pii-admin-efsh-keyword-new");

	//Human Search
	public By HumanSearchLogo = By.xpath(".//*[@id='pii-user-image']/img");
	public By HumanSearchKeywordLabel = By.xpath(".//*[@for='pii-search-container-input']");
	public By HumanPerformanceSearchTitle = By.xpath(".//*[@id='pii-keyword-block']/div[2]");
	public By HumanSearchKeywordField = By.id("pii-efsh-searchbykw-input");
	public By HumanSearchClearButton = By.id("pii-efsh-clear");
	public By HumanSearchCaseIdField = By.id("pii-efsh-searchbyid-input");
	public By HumanSearchCaseIDFieldClearButton = By.xpath(".//*[@id='pii-keyword-block']/div[3]/div/div/a");
	public By HumanSearchCaseIDFieldSearchButton = By.id("pii-efsh-searchbyid-btn");
	public By HumanSearchDropDown = By.id("pii-efsh-keyword-list");
	public By HumanSearchKeywordFieldSearchButton = By.id("pii-efsh-searchbykw-btn");
	public By HumanDropDownList = By.xpath(".//*[@id='pii-efsh-keyword-list']/li");
	public By HumanDropDownListTitle = By.xpath(".//*[@id='pii-efsh-keyword-list']/li[2]");
	public By HumanSearchKeywordFieldClearButton = By.xpath(".//*[@id='pii-keyword-block']/div[4]/div/div/a");
	public By HumanSearchDropdownListLoaded = By.xpath(".//*[@id='pii-question-list']/div/h4/a/div");
	public By HumanSearch1stCollapsibleCases = By.xpath(".//*[@id='pii-question-list']/div[1]/h4/a");
	public By HumanSearch2ndCollapsibleCases = By.xpath(".//*[@id='pii-question-list']/div[2]/h4/a");
	public By HumanSearch3rdCollapsibleCases = By.xpath(".//*[@id='pii-question-list']/div[3]/h4/a");
	public By HumanSearch1stCollapsibleCasesText = By.xpath(".//*[@id='pii-question-list']/div[1]/h4/a/div");
	public By HumanSearch2ndCollapsibleCasesText = By.xpath(".//*[@id='pii-question-list']/div[2]/h4/a/div");
	public By HumanSearch3rdCollapsibleCasesText = By.xpath(".//*[@id='pii-question-list']/div[3]/h4/a/div");

	//Slides
	public By SlideNextButton = By.linkText("Next");
	public By SlidePreviousButton = By.linkText("Previous");

}
