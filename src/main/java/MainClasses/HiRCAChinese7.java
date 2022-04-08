import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAChinese7 {

	public void chineseEventInfo (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Check if title contains chinese HiRCA
		String hirca_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		System.out.println(hirca_title);
		softly.assertThat(hirca_title).as("test data").contains(" - 事件信息");
		//Heading of event info page in chinese?
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(heading).as("test data").contains("输入事件信息");
		//Checks if the textboxes have the correct titles
		//Event title
		String ev_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title-label"))).getText();
		System.out.println(ev_title);
		softly.assertThat(ev_title).as("test data").contains("事件名称:");
		//Verify place holder of event title
		String ev_ph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).getAttribute("placeholder");
		System.out.println(ev_ph);
		softly.assertThat(ev_ph).as("test data").contains("输入 事件名称");
		//Event id
		String ev_id = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-event-crnumber']"))).getText();
		System.out.println(ev_id);
		softly.assertThat(ev_id).as("test data").contains("事件编号:");
		//Verify place holder of event id
		String ev_ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-crnumber"))).getAttribute("placeholder");
		System.out.println(ev_ph1);
		softly.assertThat(ev_ph1).as("test data").contains("输入 事件编号 (非必填)");
		//Event location
		String loc=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-event-location']"))).getText();
		System.out.println(loc);
		softly.assertThat(loc).as("test data").contains("事件发生地点:");
		//Verify place holder of event location
		String ev_ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-location"))).getAttribute("placeholder");
		System.out.println(ev_ph2);
		softly.assertThat(ev_ph2).as("test data").contains("输入 事件发生地点");
		//Department
		String dept=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[5]/fieldset/div/legend"))).getText();
		System.out.println(dept);
		softly.assertThat(dept).as("test data").contains("部门:");
		//Sub department
		String sub_dept=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[6]/fieldset/div/legend"))).getText();
		System.out.println(sub_dept);
		softly.assertThat(sub_dept).as("test data").contains("组:");
		//Date of event
		String date=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-event-date']"))).getText();
		System.out.println(date);
		softly.assertThat(date).as("test data").contains("日期与时间:");
		//Problem statement
		String prob=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-event-pbstatement']"))).getText();
		System.out.println(prob);
		softly.assertThat(prob).as("test data").contains("事件描述:");
		//Verify place holder of problem statement
		String ev_ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement"))).getAttribute("placeholder");
		System.out.println(ev_ph3);
		softly.assertThat(ev_ph3).as("test data").contains("输入 事件描述");
		//Executive summary
		String exec=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-event-execsummary']"))).getText();
		System.out.println(exec);
		softly.assertThat(exec).as("test data").contains("报告摘要:");
		//Verify place holder of executive summary
		String ev_ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-execsummary"))).getAttribute("placeholder");
		System.out.println(ev_ph4);
		softly.assertThat(ev_ph4).as("test data").contains("输入 报告摘要 (非必填)");
		//Timeline of event
		String timeline=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-event-events']"))).getText();
		System.out.println(timeline);
		softly.assertThat(timeline).as("test data").contains("事件详细过程（时序构建）:");
		//Verify place holder of timeline of event
		String ev_ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-events"))).getAttribute("placeholder");
		System.out.println(ev_ph5);
		softly.assertThat(ev_ph5).as("test data").contains("输入 事件详细过程（时序构建）");
		//Background information
		String back=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-event-bginfos']"))).getText();
		System.out.println(back);
		softly.assertThat(back).as("test data").contains("相关信息:");
		//Verify place holder of background information
		String ev_ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos"))).getAttribute("placeholder");
		System.out.println(ev_ph6);
		softly.assertThat(ev_ph6).as("test data").contains("输入 相关信息");
		//Supporting file (1)
		String supp1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-file-fieldcontain-label-0"))).getText();
		System.out.println(supp1);
		softly.assertThat(supp1).as("test data").contains("支援文件 (1):");
		//Header of supporting file
		String supp1_header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-filecollapsible-header-0"))).getText();
		System.out.println(supp1_header);
		softly.assertThat(supp1_header).as("test data").contains("支援文件描述细节");
		//Add new file button
		String newFilebutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewfile-button"))).getText();
		System.out.println(newFilebutton);
		softly.assertThat(newFilebutton).as("test data").contains("上传另一个档案");
		//Investigators
		String inve=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-event-investigators']"))).getText();
		System.out.println(inve);
		softly.assertThat(inve).as("test data").contains("事件调查员:");
		//Verify place holder of investigator
		String ev_ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-investigators"))).getAttribute("placeholder");
		System.out.println(ev_ph7);
		softly.assertThat(ev_ph7).as("test data").contains("输入 事件调查员");
		//Report creation date
		String repo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-event-repdatetime']"))).getText();
		System.out.println(repo);
		softly.assertThat(repo).as("test data").contains("报告编写时间:");
	}



	public void chineseStepOneq18 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();

		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.8 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(q11).as("test data").contains("[1.8] 犯错人员是否受过培训知道如何管理易出错精神状态和高风险");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();

		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");

		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("这个问题探讨了犯错人员是否知晓需提前准备避免易出错精神状态或高风险状态促成的个人失误。如果没有，需要进行培训。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();

		softly.assertThat(ans1).as("test data").contains("没有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();

		softly.assertThat(ans2).as("test data").contains("有，但超过两年了");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();

		softly.assertThat(ans3).as("test data").contains("两年内受过培训");
	}

	public void chineseStepOneq16 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();		
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.6 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(q11).as("test data").contains("[1.6] 犯错者违规时是否有旁人观看");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("这个问题是评估公司/组织文化。如果有许多工作人员目睹犯错者的失误行为却没有认加以干预，这是一个文化和管理问题，需制定标准和问责机制。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();		
		softly.assertThat(ans1).as("test data").contains("有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();		
		softly.assertThat(ans2).as("test data").contains("没有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();		
		softly.assertThat(ans3).as("test data").contains("未知");
	}

	public void chineseStepOneq17 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();		
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.7 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(q11).as("test data").contains("[1.7] 这个错误是否可以透过自检或独立检查避免");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("执行独立检查的程序步骤或自我检查可以以保证执行工作者的正确性。可在行动前执行独立检查（监护制），或在行动结束后执行独立验证。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();		
		softly.assertThat(ans1).as("test data").contains("不能");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();		
		softly.assertThat(ans2).as("test data").contains("能，程序有规定但未执行");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();		
		softly.assertThat(ans3).as("test data").contains("能，但程序未规定");
	}

	public void chineseStepOneq15 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();		
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.5 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(q11).as("test data").contains("[1.5] 若我是犯错者，我是否会犯同样的错？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();		
		softly.assertThat(ans1).as("test data").contains("不会");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();		
		softly.assertThat(ans2).as("test data").contains("会");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("这是一个替代实验，用于了解失误制造者是否对失误负责或他/她落入造成失误的陷阱里。假设您处于同一情况下，选择适用的答案。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
	}

	public void chineseStepOneq14 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();		
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.4 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(q11).as("test data").contains("[1.4] 此无意违规是粗心导致还是程序不当导致？");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();		
		softly.assertThat(ans1).as("test data").contains("粗心犯错");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();		
		softly.assertThat(ans2).as("test data").contains("程序不当");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("对于非故意的规则型错误（无意违规），存在两种可能性。一种是程序不当（规则存在不足），另一种是失误的人员警觉程度不足，未能遵循规则。请选择哪一种可能性适用于本情况。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
	}

	public void chineseStepOneq13 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();		
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.3 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(q11).as("test data").contains("[1.3] 若为规则型错误，是否为有意违规还是无意违规");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();		
		softly.assertThat(ans1).as("test data").contains("有意违规");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();		
		softly.assertThat(ans2).as("test data").contains("无意违规");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();		
		softly.assertThat(ans3).as("test data").contains("未知");
	}


	public void chineseStepOneq12 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();		
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.2 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(q11).as("test data").contains("[1.2] 始发事件的错误类型为何");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();		
		softly.assertThat(ans1).as("test data").contains("知识型错误");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(ans2).as("test data").contains("规则型错误");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();		
		softly.assertThat(ans3).as("test data").contains("技能型错误");
	}

	public void chineseStepOneq11 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();		
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.1 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(q11).as("test data").contains("[1.1] 始发事件为人因、设备失效还是天灾");
		//Reason entry
		String reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='pii-irca-reason-entry']"))).getText();		
		softly.assertThat(reason).as("test data").contains("填写原因:");
		//Reason entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-reason-entry"))).getAttribute("placeholder");
		softly.assertThat(ph1).as("test data").contains("可输入选择原因");
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();		
		softly.assertThat(ans1).as("test data").contains("人因");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();		
		softly.assertThat(ans2).as("test data").contains("设备失效");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(ans3).as("test data").contains("天灾");
	}
}
