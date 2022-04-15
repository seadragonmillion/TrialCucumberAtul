package seleniumTests;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MainClass.CaseBrowse;
import MainClass.CreateEquipmentCase;
import MainClass.CreateEquipmentCase3;
import MainClass.Login;
import MainClass.ShareCheck;
import MainClass.ShareCheck2;
import MainClass.beforeFunctions;
import PageObjects.CaseBrowsePageObj;
import PageObjects.CreateEquipPageObj;
import PageObjects.CreateHumanCasePageObj;
import PageObjects.LoginPageObj;



public class CreateEquipmentCaseTest {

	static WebDriver driver;
	List<String> eqCases = new ArrayList<String>();
	List<String> eeCases = new ArrayList<String>();
	
	CreateEquipPageObj equipObj = new CreateEquipPageObj();
	LoginPageObj lpo = new LoginPageObj();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	CaseBrowsePageObj cb = new CaseBrowsePageObj();
	CreateHumanCasePageObj chc = new CreateHumanCasePageObj();

	/**	@ClassRule
	public static TestRule watcher = new TestWatcher() {
		@Override
		protected void failed(Throwable throwable, Description description) {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile,
						new File("target/screenshots/"+"failshot.png"));
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}

		@Override
		protected void finished(Description description) {
			driver.quit();
		}
	};*/

	@Given("^user is on KALE Home Page \"([^\"]*)\" with username as \"([^\"]*)\" and password as \"([^\"]*)\" on browser \"([^\"]*)\"$")
	public void user_is_on_KALE_Home_Page_with_username_as_and_password_as_on_browser(String url, String username, String password, String browser) throws Exception {
		//Launch chrome browser
		beforeFunctions bf = new beforeFunctions();
		Login login = new Login();
		if(browser.equals("chrome"))
			driver = bf.beforeChromeTest(driver, url);
		if(browser.equals("firefox"))
			driver = bf.beforeFirefoxTest(driver, url);
		if(browser.equals("ie10"))
			driver = bf.beforeIE10Test(driver, url);
		if(browser.equals("ie11"))
			driver = bf.beforeIE11Test(driver, url);
		int login1 = login.LoginUser(driver, username, password);
		//Switches to the iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		try{
			if (login1==1)
			{
				WebDriverWait wait2 = new WebDriverWait(driver,20);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("sticky-close"))).click();
			}
		}catch (NoSuchElementException e){
			throw e;
		}
	}

	@When("she deletes previous cases for {string} in {string}")
	public void she_deletes_previous_cases_for_in(String caseType, String devAsiaUSIE11) throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(caseType.contains("equipment"))
		{
			if(devAsiaUSIE11.contains("devAsia"))
				obj1.deletePreviousCase(driver, obj3.eq_title);
			if(devAsiaUSIE11.contains("devAsiaIE11"))
				obj1.deletePreviousCase(driver, obj3.eq_titleie11);
			if(devAsiaUSIE11.contains("US"))
				obj1.deletePreviousCase(driver, obj3.eq_titleUS);
			if(devAsiaUSIE11.contains("USIE11"))
				obj1.deletePreviousCase(driver, obj3.eq_titleie11US);
		}
		else
		{
			if(devAsiaUSIE11.contains("devAsia"))
				obj1.deletePreviousCase(driver, obj3.ee_title);
			if(devAsiaUSIE11.contains("devAsiaIE11"))
				obj1.deletePreviousCase(driver, obj3.ee_titleie11);
			if(devAsiaUSIE11.contains("US"))
				obj1.deletePreviousCase(driver, obj3.ee_titleUS);
			if(devAsiaUSIE11.contains("USIE11"))
				obj1.deletePreviousCase(driver, obj3.ee_titleie11US);
		}
		Thread.sleep(2000);
	}

	@When("create cases for {string} in {string}")
	public void create_cases_for_in(String caseType, String devAsiaUSIE11) throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(caseType.contains("equipment"))
		{
			if(devAsiaUSIE11.contains("devAsia"))
				eqCases.addAll(obj1.createCase(driver, obj3.keyword_same_eq, obj3.key1_eq, obj3.key2_eq, obj3.key3_eq, obj3.eq_title));
			if(devAsiaUSIE11.contains("devAsiaIE11"))
				eqCases.addAll(obj1.createCase(driver, obj3.keyword_same_eqie11, obj3.key1_eqie11, obj3.key2_eqie11, obj3.key3_eqie11, obj3.eq_titleie11));
			if(devAsiaUSIE11.contains("US"))
				eqCases.addAll(obj1.createCase(driver, obj3.keyword_same_eqUS, obj3.key1_eqUS, obj3.key2_eqUS, obj3.key3_eqUS, obj3.eq_titleUS));
			if(devAsiaUSIE11.contains("USIE11"))
				eqCases.addAll(obj1.createCase(driver, obj3.keyword_same_eqie11US, obj3.key1_eqie11US, obj3.key2_eqie11US, obj3.key3_eqie11US, obj3.eq_titleie11US));
			System.out.println("Equip cases: " + eqCases);
		}
		else
		{
			if(devAsiaUSIE11.contains("devAsia"))
				eeCases.addAll(obj1.createCase(driver, obj3.keyword_same_ee, obj3.key1_ee, obj3.key2_ee, obj3.key3_ee, obj3.ee_title));
			if(devAsiaUSIE11.contains("devAsiaIE11"))
				eeCases.addAll(obj1.createCase(driver, obj3.keyword_same_eeie11, obj3.key1_eeie11, obj3.key2_eeie11, obj3.key3_eeie11, obj3.ee_titleie11));
			if(devAsiaUSIE11.contains("US"))
				eeCases.addAll(obj1.createCase(driver, obj3.keywordUS_same_ee, obj3.key1_eeUS, obj3.key2_eeUS, obj3.key3_eeUS, obj3.ee_titleUS));
			if(devAsiaUSIE11.contains("USIE11"))
				eeCases.addAll(obj1.createCase(driver, obj3.keyword_same_eeie11US, obj3.key1_eeie11US, obj3.key2_eeie11US, obj3.key3_eeie11US, obj3.ee_titleie11US));
			System.out.println("FM cases: " + eeCases);
		}
		Thread.sleep(2000);
	}

	@When("check slides for {string} in {string} for pii indicator {int}")
	public void check_slides_for_in_for_pii_indicator(String caseType, String devAsiaUSIE11, Integer piiNonpii) throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(caseType.contains("equipment"))
		{
			if(devAsiaUSIE11.contains("devAsia"))
				obj1.compareSlide(driver, eqCases.get(0), obj3.eq_title, piiNonpii);
			if(devAsiaUSIE11.contains("devAsiaIE11"))
				obj1.compareSlide(driver, eqCases.get(0), obj3.eq_titleie11, piiNonpii);
			if(devAsiaUSIE11.contains("US"))
				obj1.compareSlide(driver, eqCases.get(0), obj3.eq_titleUS, piiNonpii);
			if(devAsiaUSIE11.contains("USIE11"))
				obj1.compareSlide(driver, eqCases.get(0), obj3.eq_titleie11US, piiNonpii);
		}
		else
		{
			if(devAsiaUSIE11.contains("devAsia"))
				obj1.compareSlide(driver, eeCases.get(0), obj3.ee_title, piiNonpii);
			if(devAsiaUSIE11.contains("devAsiaIE11"))
				obj1.compareSlide(driver, eeCases.get(0), obj3.ee_titleie11, piiNonpii);
			if(devAsiaUSIE11.contains("US"))
				obj1.compareSlide(driver, eeCases.get(0), obj3.ee_titleUS, piiNonpii);
			if(devAsiaUSIE11.contains("USIE11"))
				obj1.compareSlide(driver, eeCases.get(0), obj3.ee_titleie11US, piiNonpii);
		}
		Thread.sleep(2000);
	}

	@When("search with keyword with all special characters")
	public void search_with_keyword_with_all_special_characters() throws Exception {

		CaseBrowse obj = new CaseBrowse();
		obj.searchWithKeyKeywordWithAllSpecialCharacters(driver, eqCases.get(0));
		Thread.sleep(2000);
	}

	@When("search with keyword with special character in middle")
	public void search_with_keyword_with_special_character_in_middle() throws Exception {

		CaseBrowse obj = new CaseBrowse();		
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		obj.searchWithKeywordKALE1964(driver, obj1.softly);
		Thread.sleep(2000);
	}

	@When("check the keyword search for {string} in {string} for pii indicator {int}")
	public void check_the_keyword_search_for_in_for_pii_indicator(String caseType, String devAsiaUSIE11, Integer piiNonpii) throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(caseType.contains("equipment"))
		{
			if(devAsiaUSIE11.contains("devAsia"))
				obj1.checkkeyword(driver, eqCases, obj3.keyword_same_eq, obj3.key1_eq, obj3.key2_eq, obj3.key3_eq, piiNonpii, obj3.eq_title);
			if(devAsiaUSIE11.contains("devAsiaIE11"))
				obj1.checkkeyword(driver, eqCases, obj3.keyword_same_eqie11, obj3.key1_eqie11, obj3.key2_eqie11, obj3.key3_eqie11, piiNonpii, obj3.eq_titleie11);
			if(devAsiaUSIE11.contains("US"))
				obj1.checkkeyword(driver, eqCases, obj3.keyword_same_eqUS, obj3.key1_eqUS, obj3.key2_eqUS, obj3.key3_eqUS, piiNonpii, obj3.eq_titleUS);
			if(devAsiaUSIE11.contains("USIE11"))
				obj1.checkkeyword(driver, eqCases, obj3.keyword_same_eqie11US, obj3.key1_eqie11US, obj3.key2_eqie11US, obj3.key3_eqie11US, piiNonpii, obj3.eq_titleie11US);
		}
		else
		{
			if(devAsiaUSIE11.contains("devAsia"))
				obj1.checkkeyword(driver, eeCases, obj3.keyword_same_ee, obj3.key1_ee, obj3.key2_ee, obj3.key3_ee, piiNonpii, obj3.ee_title);
			if(devAsiaUSIE11.contains("devAsiaIE11"))
				obj1.checkkeyword(driver, eeCases, obj3.keyword_same_eeie11, obj3.key1_eeie11, obj3.key2_eeie11, obj3.key3_eeie11, piiNonpii, obj3.ee_titleie11);
			if(devAsiaUSIE11.contains("US"))
				obj1.checkkeyword(driver, eeCases, obj3.keywordUS_same_ee, obj3.key1_eeUS, obj3.key2_eeUS, obj3.key3_eeUS, piiNonpii, obj3.ee_titleUS);
			if(devAsiaUSIE11.contains("USIE11"))
				obj1.checkkeyword(driver, eeCases, obj3.keyword_same_eeie11US, obj3.key1_eeie11US, obj3.key2_eeie11US, obj3.key3_eeie11US, piiNonpii, obj3.ee_titleie11US);
		}		
		Thread.sleep(2000);
	}

	@When("check for presence of equipment and failure mode cases in other case modules in {string}")
	public void check_for_presence_of_equipment_and_failure_mode_cases_in_other_case_modules_in(String devAsiaUSIE11) throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.checkCase(driver, eqCases.get(1), eeCases.get(1), obj3.keyword_same_eq, obj3.keyword_same_ee);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.checkCase(driver, eqCases.get(1), eeCases.get(1), obj3.keyword_same_eqie11, obj3.keyword_same_eeie11);
		if(devAsiaUSIE11.contains("US"))
			obj1.checkCase(driver, eqCases.get(1), eeCases.get(1), obj3.keyword_same_eqUS, obj3.keywordUS_same_ee);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.checkCase(driver, eqCases.get(1), eeCases.get(1), obj3.keyword_same_eqie11US, obj3.keyword_same_eeie11US);
		Thread.sleep(2000);
	}

	@When("look for equipment cases with type advanced learning in equipment databank in {string} with username as {string} and password as {string}")
	public void look_for_equipment_cases_with_type_advanced_learning_in_equipment_databank_in_with_username_as_and_password_as(String devAsiaUSIE11, String username, String password) throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.searchEquipmentDatabankOnly(driver,obj3.keyword_same_eq,eqCases,username,password);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.searchEquipmentDatabankOnly(driver,obj3.keyword_same_eqie11,eqCases,username,password);
		if(devAsiaUSIE11.contains("US"))
			obj1.searchEquipmentDatabankOnly(driver,obj3.keyword_same_eqUS,eqCases,username,password);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.searchEquipmentDatabankOnly(driver,obj3.keyword_same_eqie11US,eqCases,username,password);
		Thread.sleep(2000);
	}

	@When("look for equipment cases with all filters in {string} with username as {string} and password as {string}")
	public void look_for_equipment_cases_with_all_filters_in_with_username_as_and_password_as(String devAsiaUSIE11, String username, String password) throws Exception {
		
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.searchEquipmentPerformanceAllFilters(driver, obj3.keyword_same_eq, eqCases.get(5), username, password);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.searchEquipmentPerformanceAllFilters(driver, obj3.keyword_same_eqie11, eqCases.get(5), username, password);
		if(devAsiaUSIE11.contains("US"))
			obj1.searchEquipmentPerformanceAllFilters(driver, obj3.keyword_same_eqUS, eqCases.get(5), username, password);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.searchEquipmentPerformanceAllFilters(driver, obj3.keyword_same_eqie11US, eqCases.get(5), username, password);
		Thread.sleep(2000);
	}

	@When("change keyword and search for it in {string}")
	public void change_keyword_and_search_for_it_in(String devAsiaUSIE11) throws Exception {
		
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.changeKeywordKALE1969(driver,eqCases,obj3.keyword_same_eq);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.changeKeywordKALE1969(driver,eqCases,obj3.keyword_same_eqie11);
		if(devAsiaUSIE11.contains("US"))
			obj1.changeKeywordKALE1969(driver,eqCases,obj3.keyword_same_eqUS);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.changeKeywordKALE1969(driver,eqCases,obj3.keyword_same_eqie11US);
		Thread.sleep(2000);
	}

	@When("add keyword to equipment case and search for case in {string}")
	public void add_keyword_to_equipment_case_and_search_for_case_in(String devAsiaUSIE11) throws Exception {
		
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.addKeywordKALE2168(driver, eqCases, obj3.keyword_same_eq);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.addKeywordKALE2168(driver, eqCases, obj3.keyword_same_eqie11);
		if(devAsiaUSIE11.contains("US"))
			obj1.addKeywordKALE2168(driver, eqCases, obj3.keyword_same_eqUS);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.addKeywordKALE2168(driver, eqCases, obj3.keyword_same_eqie11US);
		Thread.sleep(2000);
	}

	@When("verify youtube link work in case in {string}")
	public void verify_youtube_link_work_in_case_in(String devAsiaUSIE11) throws Exception {
		
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.searchCaseWithLinks(driver, obj3.keyword_same_ee, eeCases, obj3.ee_title);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.searchCaseWithLinks(driver, obj3.keyword_same_eeie11, eeCases, obj3.ee_titleie11);
		if(devAsiaUSIE11.contains("US"))
			obj1.searchCaseWithLinks(driver, obj3.keywordUS_same_ee, eeCases, obj3.ee_titleUS);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.searchCaseWithLinks(driver, obj3.keyword_same_eeie11US, eeCases, obj3.ee_titleie11US);
		Thread.sleep(2000);
	}

	@When("view case with links and then a case without links in {string}")
	public void view_case_with_links_and_then_a_case_without_links_in(String devAsiaUSIE11) throws Exception {
		
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.viewCaseInAdmin(driver, eqCases, eeCases, obj3.keyword_same_eq);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.viewCaseInAdmin(driver, eqCases, eeCases, obj3.keyword_same_eqie11);
		if(devAsiaUSIE11.contains("US"))
			obj1.viewCaseInAdmin(driver, eqCases, eeCases, obj3.keyword_same_eqUS);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.viewCaseInAdmin(driver, eqCases, eeCases, obj3.keyword_same_eqie11US);
		Thread.sleep(2000);
	}

	@When("verify cases with and without links with same keyword in equipment databank only in {string}")
	public void verify_cases_with_and_without_links_with_same_keyword_in_equipment_databank_only_in(String devAsiaUSIE11) throws Exception {
		
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.searchCaseWithSameKeywordWithAndWithoutLinksInEquipDatabank(driver, obj3.keyword_same_ee, eeCases);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.searchCaseWithSameKeywordWithAndWithoutLinksInEquipDatabank(driver, obj3.keyword_same_eeie11, eeCases);
		if(devAsiaUSIE11.contains("US"))
			obj1.searchCaseWithSameKeywordWithAndWithoutLinksInEquipDatabank(driver, obj3.keywordUS_same_ee, eeCases);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.searchCaseWithSameKeywordWithAndWithoutLinksInEquipDatabank(driver, obj3.keyword_same_eeie11US, eeCases);
		Thread.sleep(2000);
	}

	@When("add an existing keyword to case with links and search for case in {string}")
	public void add_an_existing_keyword_to_case_with_links_and_search_for_case_in(String prodDev) throws Exception {
		
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CaseBrowse obj = new CaseBrowse();		
		if(prodDev.contains("dev"))
			obj1.addKeywordToLinkCaseAndSearchInEquipmentDatabank(driver, eeCases, obj.keywordEquipDev);
		if(prodDev.contains("prod"))
			obj1.addKeywordToLinkCaseAndSearchInEquipmentDatabank(driver, eeCases, obj.keywordEquipProd);
		Thread.sleep(2000);
	}

	@When("turn slide security on and click on links in related links slide in {string} with username as {string}")
	public void turn_slide_security_on_and_click_on_links_in_related_links_slide_in_with_username_as(String devAsiaUSIE11, String username) throws Exception {
		
		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		CreateEquipmentCase3 obj3 = new CreateEquipmentCase3();
		if(devAsiaUSIE11.contains("devAsia"))
			obj1.slideSecurityOnTest(driver, obj3.keyword_same_ee, eeCases, obj3.ee_title, username);
		if(devAsiaUSIE11.contains("devAsiaIE11"))
			obj1.slideSecurityOnTest(driver, obj3.keyword_same_eeie11, eeCases, obj3.ee_titleie11, username);
		if(devAsiaUSIE11.contains("US"))
			obj1.slideSecurityOnTest(driver, obj3.keywordUS_same_ee, eeCases, obj3.ee_titleUS, username);
		if(devAsiaUSIE11.contains("USIE11"))
			obj1.slideSecurityOnTest(driver, obj3.keyword_same_eeie11US, eeCases, obj3.ee_titleie11US, username);
		Thread.sleep(2000);
	}

	@When("edit links")
	public void edit_links() throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		obj1.editLinks(driver, eeCases);
		Thread.sleep(2000);
	}

	@When("delete links")
	public void delete_links() throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		obj1.deleteLinks(driver, eeCases);
		Thread.sleep(2000);
	}

	@When("delete cases for {string}")
	public void delete_cases_for_in(String caseType) throws Exception {

		CreateEquipmentCase obj1 = new CreateEquipmentCase();
		if(caseType.contains("equipment"))
			obj1.deleteCase(driver, eqCases);
		else
			obj1.deleteCase(driver, eeCases);
		Thread.sleep(2000);
	}

	@When("^logout from KALE$")
	public void logout_from_KALE() throws Exception {
		Login login = new Login();
		login.logout(driver);
		driver.manage().window().maximize();
	}


	@After
	public void tearDown(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png","Failure"); // ... and embed it in the report.
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile,
						new File("target/screenshots/"+"failshot.png"));
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
//		driver.quit();
		CreateEquipmentCase obj = new CreateEquipmentCase();
		obj.softAssert();
	}

}
