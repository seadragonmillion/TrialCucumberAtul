package PageObjects;

import org.openqa.selenium.By;

import java.util.Random;


public class CreateEquipPageObj {

	public By KaleHomePage = By.className("pii-logo-div-element-kale");

	//Equipment databank only search page
	public By EquipDropwdownTitle_1st = By.xpath(".//*[@id='pii-question-list-equip']/div[1]/h4/a/div");
	public By EquipDropwdownTitle_2nd = By.xpath(".//*[@id='pii-question-list-equip']/div[2]/h4/a/div");
	public By EquipDropwdownTitle_3rd = By.xpath(".//*[@id='pii-question-list-equip']/div[3]/h4/a/div");
	public By EquipSearchMessage = By.xpath(".//*[@id='pii-efse-search-message']/div");
	public By EquipSearchMessageErrorLink = By.xpath(".//*[@id='pii-efse-search-message']/div/a");
	public By PreventionOfDesignDeficienciesLink = By.linkText("Prevention of Design Deficiencies");
	public By EngineeringFundamentalsLink = By.linkText("Engineering Fundamentals");
	public By SRILink = By.linkText("Systematic Reliability Inspection");

	//Create equipment case page
	public By EquipCaseNewButton = By.id("pii-admin-efse-button-new");
	public By EquipCasePopupTitle = By.id("pii-admin-efse-dialog-title");
	public By EquipCasePopupConfirmButton = By.id("pii-admin-efse-dialog-confirmed");
	public By EquipCaseIDField = By.id("pii-admin-efse-id");
	public By EquipCaseIDFieldError = By.id("pii-admin-efse-id-error");
	public By EquipCaseTypes = By.id("pii-admin-efse-type-button");
	public By EquipCaseTypeFieldText = By.xpath(".//*[@id='pii-admin-efse-type-button']/span[1]");
	public By EquipCaseQuestion = By.id("pii-admin-efse-question");
	public By EquipCaseAnswer = By.id("pii-admin-efse-answer");
	public By EquipCaseNewKeywordField = By.id("pii-admin-efse-keyword-search-input");
	public By EquipCaseNewKeywordAddButton = By.id("pii-admin-efse-keyword-new");
	public By EquipCaseKeywordExistingList = By.xpath(".//*[@id='pii-admin-efse-keyword-blocks']/div[2]/form/ul");
	public By EquipImageUploadField = By.id("pii-admin-efse-upload-file-input");
	public By EquipImageCollapsible = By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles-div']/h5/a");
	public By EquipCaseSaveButton = By.id("pii-admin-efse-button-save");
	public By EquipCasesLink = By.id("pii-admin-efse-manage-button");
	public By EquipCaseSearchCaseIDAdmin = By.id("pii-admin-efse-list-input");
	public By EquipCaseSearchCaseIDDropdownAdmin = By.id("pii-admin-efse-list-ul");
	public By EquipCaseDeleteButton = By.id("pii-admin-efse-button-delete");
	public By EquipCaseEditButton = By.id("pii-admin-efse-button-edit");
	public By EquipCaseExistingKeywordOnlyOne = By.xpath(".//*[@id='pii-admin-efse-keyword-form']/div/ul/li/a");
	public By EquipCaseKeywordList = By.id("pii-admin-efse-keyword-list");
	public By EquipImageCollapsibleExpanded = By.xpath(".//*[@id='pii-admin-efse-upload-form-selectedfiles']/div");
	public By EquipCaseFields = By.id("pii-admin-efse-field-button");
	public By EquipCaseFieldsFieldText = By.xpath(".//*[@id='pii-admin-efse-field-button']/span[1]");
	public By EquipCaseDiscipline = By.id("pii-admin-efse-discipline-button");
	public By EquipCaseDisciplineFieldText = By.xpath(".//*[@id='pii-admin-efse-discipline-button']/span[1]");
	public By EquipListBoxTypes = By.id("pii-admin-efse-type-listbox");
	public By ListCrossSymbol = By.cssSelector(".ui-btn.ui-corner-all.ui-btn-left.ui-btn-icon-notext.ui-icon-delete");
	public By EquipListBoxTypesCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-type-listbox']/div/a");
	public By EquipListBoxDisciplineCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-discipline-listbox']/div/a");
	public By EquipListBoxDiscipline = By.id("pii-admin-efse-discipline-listbox");
	public By EquipListBoxFields = By.id("pii-admin-efse-field-listbox");
	public By EquipListBoxFieldsCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-field-listbox']/div/a");
	public By EquipCasesLink1Title = By.id("pii-admin-efse-linktitle-0");
	public By EquipCasesLink1URL = By.id("pii-admin-efse-linkurl-0");
	public By EquipCasesLink2Title = By.id("pii-admin-efse-linktitle-1");
	public By EquipCasesLink2URL = By.id("pii-admin-efse-linkurl-1");
	public By EquipCasesLink3Title = By.id("pii-admin-efse-linktitle-2");
	public By EquipCasesLink3URL = By.id("pii-admin-efse-linkurl-2");
	public By EquipCasesLink4Title = By.id("pii-admin-efse-linktitle-3");
	public By EquipCasesLink4URL = By.id("pii-admin-efse-linkurl-3");
	public By EquipCasesLink5Title = By.id("pii-admin-efse-linktitle-4");
	public By EquipCasesLink5URL = By.id("pii-admin-efse-linkurl-4");
	public By EquipCasesLink6Title = By.id("pii-admin-efse-linktitle-5");
	public By EquipCasesLink6URL = By.id("pii-admin-efse-linkurl-5");
	public By EquipCasesLink7Title = By.id("pii-admin-efse-linktitle-6");
	public By EquipCasesLink7URL = By.id("pii-admin-efse-linkurl-6");
	public By EquipCasesLink8Title = By.id("pii-admin-efse-linktitle-7");
	public By EquipCasesLink8URL = By.id("pii-admin-efse-linkurl-7");
	public By EquipCasesLink9Title = By.id("pii-admin-efse-linktitle-8");
	public By EquipCasesLink9URL = By.id("pii-admin-efse-linkurl-8");
	public By EquipCasesLink10Title = By.id("pii-admin-efse-linktitle-9");
	public By EquipCasesLink10URL = By.id("pii-admin-efse-linkurl-9");
	public By EquipCasesLink11Title = By.id("pii-admin-efse-linktitle-10");
	public By EquipCasesLink11URL = By.id("pii-admin-efse-linkurl-10");
	public By EquipCasesLink12Title = By.id("pii-admin-efse-linktitle-11");
	public By EquipCasesLink12URL = By.id("pii-admin-efse-linkurl-11");
	public By EquipCasesLink13Title = By.id("pii-admin-efse-linktitle-12");
	public By EquipCasesLink13URL = By.id("pii-admin-efse-linkurl-12");
	public By EquipCasesLink1VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-0']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLink2VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-1']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLink3VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-2']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLink4VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-3']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLink5VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-4']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLink6VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-5']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLink7VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-6']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLink8VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-7']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLink9VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-8']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLink10VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-9']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLink11VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-10']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLink12VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-11']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLink13VideoCheckbox = By.xpath(".//*[@id='pii-admin-efse-linkdiv-12']/div[2]/table/tbody/tr[1]/td[1]/div/label");
	public By EquipCasesLinkTitleOnSide = By.id("pii-admin-efse-linklabel-0");
	public By EquipCasesLink1TitleCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-linkdiv-0']/div[1]/div/a");
	public By EquipCasesLink1URLCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-linkdiv-0']/div[2]/table/tbody/tr[1]/td[2]/div/a");
	public By EquipCasesLink2TitleCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-linkdiv-1']/div[1]/div/a");
	public By EquipCasesLink2URLCrossSymbol = By.xpath(".//*[@id='pii-admin-efse-linkdiv-1']/div[2]/table/tbody/tr[1]/td[2]/div/a");

	public By EquipCasesTypeList = By.xpath(".//*[@id='pii-admin-efse-data-form']/div[2]/div/a/span[2]");
	public By EquipListTypesAdvancedLearning = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[1]/a");
	public By EquipListTypesCaseStudies = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[2]/a");
	public By EquipListTypesDesign = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[3]/a");
	public By EquipListTypesFailureModes = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[4]/a");
	public By EquipListTypesFundamentals = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[5]/a");
	public By EquipListTypesGeneral = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[6]/a");
	public By EquipListTypesSRI = By.xpath(".//*[@id='pii-admin-efse-type-menu']/li[7]/a");

	public By EquipCasesDisciplineList = By.xpath(".//*[@id='pii-admin-efse-data-form']/div[3]/div/a/span[2]");
	public By EquipListDisciplineElectrical = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[1]/a");
	public By EquipListDisciplineGeneral = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[2]/a");
	public By EquipListDisciplineIC = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[3]/a");
	public By EquipListDisciplineMechanical = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[4]/a");
	public By EquipListDisciplineSoftware = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[5]/a");
	public By EquipListDisciplineStructural = By.xpath(".//*[@id='pii-admin-efse-discipline-menu']/li[6]/a");

	public By EquipCasesFieldList = By.xpath(".//*[@id='pii-admin-efse-data-form']/div[4]/div/a/span[2]");
	public By EquipListFieldsAuto = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[1]/a");
	public By EquipListFieldsNuclear = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[2]/a");
	public By EquipListFieldsOther = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[3]/a");
	public By EquipListFieldsPharmaceutical = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[4]/a");
	public By EquipListFieldsWelding = By.xpath(".//*[@id='pii-admin-efse-field-menu']/li[5]/a");

	//Errors
	public By CaseIDError = By.id("pii-admin-efse-id-error");
	public By TypeError = By.id("pii-admin-efse-type-error");
	public By DisciplineError = By.id("pii-admin-efse-discipline-error");
	public By FieldError = By.id("pii-admin-efse-field-error");
	public By QuestionError = By.id("pii-admin-efse-question-error");
	public By AnswerError = By.id("pii-admin-efse-answer-error");
	public By PNGFileError = By.id("pii-admin-efse-upload-file-input-error");
	public By KeywordError = By.id("pii-admin-efse-keyword-list-input-error");
	
	//Related links slide
	//	public By RelatedLinksSlideTitle = By.xpath(".//*[@class='pii-linkslide']/div[1]/div");
	/*	public By RelatedLinksSlideLink1Title = By.xpath(".//*[@class='pii-linkslide']/div[2]");
	public By RelatedLinksSlideLink2Title = By.xpath(".//*[@class='pii-linkslide']/div[3]");
	public By RelatedLinksSlideLink3Title = By.xpath(".//*[@class='pii-linkslide']/div[4]");
	public By RelatedLinksSlideLink4Title = By.xpath(".//*[@class='pii-linkslide']/div[5]");
	public By RelatedLinksSlideLink5Title = By.xpath(".//*[@class='pii-linkslide']/div[6]");
	public By RelatedLinksSlideLink6Title = By.xpath(".//*[@class='pii-linkslide']/div[7]");
	public By RelatedLinksSlideLink7Title = By.xpath(".//*[@class='pii-linkslide']/div[8]");
	public By RelatedLinksSlideLink8Title = By.xpath(".//*[@class='pii-linkslide']/div[9]");
	public By RelatedLinksSlideLink9Title = By.xpath(".//*[@class='pii-linkslide']/div[10]");
	public By RelatedLinksSlideLink1URL = By.xpath(".//*[@class='pii-linkslide']/div[2]/a");
	public By RelatedLinksSlideLink2URL = By.xpath(".//*[@class='pii-linkslide']/div[3]/a");
	public By RelatedLinksSlideLink4URL = By.xpath(".//*[@class='pii-linkslide']/div[5]/a");
	 */
	
	public int selectNumberForType() throws Exception {

		//Choose a number between 
		Random random = new Random ();
		int x;
		//Choose a number between 1 and 6
		while(true)
		{
			x = random.nextInt(7);
			if(x==0)
				continue;
			break;
		}
		return x;
	}
}
