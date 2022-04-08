package MainClass;

import PageObjects.HiRCAObj;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAChinese16 {	

	HiRCAObj hirca = new HiRCAObj();
	
	public void chineseStepOneq115 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();

		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.15 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(q11).as("test data").contains("[1.15] 始发事件是否有单项弱点？");
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

		softly.assertThat(desc).as("test data").contains("单项弱点（SPV）是指一个失效或执行不正确的程序步骤、行动、工具或一个设备引起后果事件或导致整个过程失效。此外，SPV是不会自我披露的，直至其导致最终故障发生才披露");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();

		softly.assertThat(ans1).as("test data").contains("有，但未提前识别");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();

		softly.assertThat(ans2).as("test data").contains("有，识别出单项弱点但未缓解");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();

		softly.assertThat(ans3).as("test data").contains("没有");
	}

	public void chineseStepOneq114 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();

		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.14 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(q11).as("test data").contains("[1.14] 组长是否固定开展经验反馈？");
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

		softly.assertThat(desc).as("test data").contains("这个问题探讨是否在日常经验反馈学习时上强调类似任务相关的风险与常见失误。经验教训学习会有两个目标：（1）学习如何预防类似事件；（2）主管强化标准要求");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();

		softly.assertThat(ans1).as("test data").contains("没有，但其他组长有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();

		softly.assertThat(ans2).as("test data").contains("没有，这为常态");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();

		softly.assertThat(ans3).as("test data").contains("有");
	}
	
	public void chineseStepOneq117 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();		
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.17 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(q11).as("test data").contains("[1.17] 事件是与经理管理不当有关？");
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
		softly.assertThat(desc).as("test data").contains("这个问题探讨了失误受管理效力影响的可能性；相关影响要素包括设定组织标准、绩效问责机制等。");
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

	public void chineseStepOneq116 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();		
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.16 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(q11).as("test data").contains("[1.16] 事件是与组长监督管理不当有关？");
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
		softly.assertThat(desc).as("test data").contains("这个问题探讨了失误受监管效力影响的可能性；相关影响要素包括行为标准的强化、绩效反馈、与现场员工交流、指导计划等。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();		
		softly.assertThat(ans1).as("test data").contains("是，跟其他组长相比下有缺失");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();		
		softly.assertThat(ans2).as("test data").contains("没有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();		
		softly.assertThat(ans3).as("test data").contains("未知");
	}
	
	public void chineseStepOneq113 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.13 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(q11).as("test data").contains("[1.13] 错误的发生是否存在易出错精神状态或是高风险状态？");
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
		softly.assertThat(desc).as("test data").contains("这个问题检查易出错精神状态或高风险状态是否被识别出。我们的研究表明存在16个易出错精神状态和16个高风险状态，它们会显著增加失误率（参见");
		softly.assertThat(desc).as("test data").contains("关于");
		softly.assertThat(desc).as("test data").contains("部分）。70%的失误是由于易出错精神状态推动产生的，不存在任何外部因素（例如：恶劣的工作条件、工作指令不当）。大约有30%的间接失误是由于异常、外部影响促成的，也就是我们熟知的高风险状态。高风险表示事件发生概率或后果方面的风险增加。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(ans1).as("test data").contains("没有，请重新思考您的答案");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(ans2).as("test data").contains("有");
	}

	public void chineseStepOneq112 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.12 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(q11).as("test data").contains("[1.12] 若班前会、工前会或交底会未执行，为什么？");
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
		softly.assertThat(desc).as("test data").contains("执行任务前，若执行班前会、工前会或交底会以可以提前识别和缓解风险。不执行若班前会、工前会或交底会将促进失误的发生。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(ans1).as("test data").contains("违反程序规定未执行");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(ans2).as("test data").contains("不当的程序要求而未执行");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(ans3).as("test data").contains("没有要求执行所以未执行");
	}

	public void chineseStepOneq111 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.11 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(q11).as("test data").contains("[1.11] 这个错为何是现在发生而不是以前发生？");
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
		softly.assertThat(desc).as("test data").contains("这个问题探讨了为什么这个失误在之前有没有发生过？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(ans1).as("test data").contains("新程序的使用未有妥当培训");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(ans2).as("test data").contains("对于犯错人员而言是新任务或是不熟悉的任务");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(ans3).as("test data").contains("过去有发生过类似错误");
	}

	public void chineseStepOneq19 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.9 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(q11).as("test data").contains("[1.9] 犯错者在事后是否有经组长或管理层问责？");
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
		softly.assertThat(desc).as("test data").contains("这个问题探讨了现有的问责机制。如果出现失误，无论是无意或有意的，都可从中学习到经验教训。问责机制不表示要接受惩罚，而是针对失误负责任。如果主管或管理层没有与犯错人员交谈，且没有完成全面调查，那么说明问责机制存在问题。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(ans1).as("test data").contains("没有");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(ans2).as("test data").contains("有");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(ans3).as("test data").contains("未知");
	}
	
	public void chineseStepOneq110 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();

		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.10 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(q11).as("test data").contains("[1.10] 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
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

		softly.assertThat(desc).as("test data").contains("这个问题探讨了开班前会、工前会、交底会在风险识别和缓解方面的效力");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();

		softly.assertThat(ans1).as("test data").contains("没有专心参与");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();

		softly.assertThat(ans2).as("test data").contains("因技能不足未讨论这个风险");
	}
	
	public void chineseStepOneq118 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.18 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(q11).as("test data").contains("[1.18] 事件是因程序规则有误导致？");
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
		softly.assertThat(desc).as("test data").contains("这个问题探讨了现有规制是否不仅促成这一实例的发生，还促成了这一失误的多次发生");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(ans2).as("test data").contains("不是");
	}
	
	public void chineseStepOneq120 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.20 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(q11).as("test data").contains("[1.20] 错误是否与工作时发生改变有关？");
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
		softly.assertThat(desc).as("test data").contains("这一问题探讨了工作过程中的变更是否促成失误发生的原因。工作过程中的变更可能会产生新的、不熟悉的事物，这会造成易出错状态的形成");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(ans2).as("test data").contains("是，为无法预测的天灾");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(ans3).as("test data").contains("否");
	}	
	
	public void chineseStepOneq119 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Heading
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-instant-rca-message"))).getText();
		softly.assertThat(heading).as("test data").contains("-第一步：调查始发事件根本原因");
		//1.19 question
		String q11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(q11).as("test data").contains("[1.19] 是否有类似事件重发的趋势？");
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
		softly.assertThat(desc).as("test data").contains("这个问题探讨了此事件是否与组织的绩效控制管理有关。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Answer 1
		String ans1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-0']"))).getText();
		softly.assertThat(ans1).as("test data").contains("是");
		//Answer 2
		String ans2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-1']"))).getText();
		softly.assertThat(ans2).as("test data").contains("没有，趋势下降");
		//Answer 3
		String ans3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@for='efi-irca-answer-2']"))).getText();
		softly.assertThat(ans3).as("test data").contains("没有");
	}
	
	public void chineseSUEP(WebDriver driver, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("第三步 - 判别根本原因");
		//S
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();
		softly.assertThat(s).as("test data").contains(": 是否存在不合标准的实践?");
		//U
		String u = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]"))).getText();
		softly.assertThat(u).as("test data").contains(": 是否在管理层控制下?");
		//E
		String e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]"))).getText();
		softly.assertThat(e).as("test data").contains(": 是否在事件时序早期?");
		//P
		String p = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]"))).getText();
		softly.assertThat(p).as("test data").contains(": 是否防止再次发生?");
		//Table heading
		String th = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[1]"))).getText();
		softly.assertThat(th).as("test data").contains("促成因素");
		/*
		//Row
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(tr).as("test data").contains("不适用");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(tr1).as("test data").contains("不适用");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(tr2).as("test data").contains("不适用");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[4]"))).getText();
		softly.assertThat(tr3).as("test data").contains("不适用");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[5]"))).getText();
		softly.assertThat(tr4).as("test data").contains("不适用");
		 */
	}

	public void chineseLOPRC(WebDriver driver, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Dialog header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupHeader)).getText();
		softly.assertThat(heading).as("test data").contains("屏障或根本原因分析");
		//Dialog title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupMessage)).getText();
		softly.assertThat(title).as("test data").contains("您要(1)继续分析屏障失效或是(2)前往根本原因分析？");
		//Dialog note
		String note = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupNote)).getText();
		softly.assertThat(note).as("test data").contains("提醒：屏障失效分析可以随时回头再做。");
		//Cancel button
		String cn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-cancel"))).getText();
		softly.assertThat(cn).as("test data").contains("取消");
		//LOP button
		String lop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).getText();
		softly.assertThat(lop).as("test data").contains("屏障");
		//Root cause button
		String rc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).getText();
		softly.assertThat(rc).as("test data").contains("根本原因");
	}
	
	public void chineseStep4(WebDriver driver, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();
		softly.assertThat(heading).as("test data").contains("第四步 - 判别根本原因和促成因素的重要性");
		//Table headers
		String th = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[1]"))).getText();
		softly.assertThat(th).as("test data").contains("始发事件的根本原因与促成因素");
		String th1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[2]"))).getText();
		softly.assertThat(th1).as("test data").contains("R:根本原因 或 C:促成因素");
		String th1d = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[2]/div"))).getText();
		softly.assertThat(th1d).as("test data").contains("(R 或 C)");
		String th2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[3]"))).getText();
		softly.assertThat(th2).as("test data").contains("重要性分级");
		String th2d = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[1]/th[3]/div"))).getText();
		softly.assertThat(th2d).as("test data").contains("(H:高, M:中 或 L:低)");
		/*
		//Row
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(tr).as("test data").contains("不适用");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(tr1).as("test data").contains("不适用");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(tr2).as("test data").contains("不适用");
		 */
	}
}
