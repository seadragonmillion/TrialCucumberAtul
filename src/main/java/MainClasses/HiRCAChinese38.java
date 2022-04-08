import kaleTestSoftware.HiRCAChinese34;
import kaleTestSoftware.HiRCAObj;
import kaleTestSoftware.ShareCheck2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiRCAChinese38 {

	HiRCAChinese34 hc34 = new HiRCAChinese34();
	HiRCAObj hirca = new HiRCAObj();
	ShareCheck2 share2 = new ShareCheck2();
	
	public void chineseStepOneL318 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(heading).as("test data").contains("知识型错误");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();

		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("是否有证据表明以下思维模式促使犯错人员在本失误中的判断错误？");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.18.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.18.1] 盲目信任: 关键信息使用质疑的态度QV&V℠不到位");
		//Click on 3.18.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();		
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.18.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).click();
		//2nd collapsible for 3.18.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c2).as("test data").contains("审查培训材料？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();		
		softly.assertThat(c22).as("test data").contains("审查以往类似事件？");
		//Click on 2nd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c3).as("test data").contains("提高质疑的态度");
		softly.assertThat(c3).as("test data").contains("培训");
		//Click on 3rd collapsible for 3.18.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.4.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.18.2] 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		//Click on 3.18.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();		
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");		
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.18.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).click();
		//2nd collapsible for 3.18.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c5).as("test data").contains("执行首次执行的任务而没有仔细规划?");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c23).as("test data").contains("过去有过超出能力工作的事件?");
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();

		softly.assertThat(c24).as("test data").contains("对设计工作推断不当而未执行适当试验?");
		//Click on 2nd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c6).as("test data").contains("行为培训，避免过度自信");
		//Click on 3rd collapsible for 3.18.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.18.3] 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		//Click on 3.18.3 to reveal evidence entry
		while(true)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3));
			String s3 = ele.getAttribute("class");
			if(s3.contains("ui-checkbox-on")==false)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
			}
			Thread.sleep(1000);
			if(s3.contains("ui-checkbox-on")==true)
				break;
		}
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();		
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))));
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");		
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.18.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).click();
		//2nd collapsible for 3.18.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.3
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();		
		softly.assertThat(c8).as("test data").contains("因忽略相关风险而未设置屏障");
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c25).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		//Click on 2nd collapsible for 3.18.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.3
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();		
		softly.assertThat(c9).as("test data").contains("改善风险控制项目");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c26).as("test data").contains("完善");
		softly.assertThat(c26).as("test data").contains("体系");
		//Click on 3rd collapsible for 3.18.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)).getText();
		softly.assertThat(q344).as("test data").contains("[3.18.4] 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		//Click on 3.18.4 to reveal evidence entry
		while(true)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4));
			String s3 = ele.getAttribute("class");
			if(s3.contains("ui-checkbox-on")==false)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
			}
			Thread.sleep(1000);
			if(s3.contains("ui-checkbox-on")==true)
				break;
		}
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();

		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))));
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");

		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.18.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)).click();
		//2nd collapsible for 3.18.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.4
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c14).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		//Click on 2nd collapsible for 3.18.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.4
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c17).as("test data").contains("审查以往决策的有效性，提高管理监督");
		//Click on 3rd collapsible for 3.18.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//3.18.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.18.5] 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
		//Click on 3.18.5 to reveal evidence entry
		while(true)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5));
			String s3 = ele.getAttribute("class");
			if(s3.contains("ui-checkbox-on")==false)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
			}
			Thread.sleep(1000);
			if(s3.contains("ui-checkbox-on")==true)
				break;
		}
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();

		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))));
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");

		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.18.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)).click();
		//2nd collapsible for 3.18.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.18.5
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();

		softly.assertThat(c19).as("test data").contains("审查管理监督或项目委员会会议纪要?");
		//Click on 2nd collapsible for 3.18.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//3rd collapsible 3.18.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.18.5
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();

		softly.assertThat(c21).as("test data").contains("提高决策、问题解决和计划的结构（委员会）和流程");
		//Click on 3rd collapsible for 3.18.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//Add new contributing factor button
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();

		softly.assertThat(c15).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		hc34.chineseAddContributingFactor(driver,softly);
	}

	public void chineseStepOneL34 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();		
		softly.assertThat(heading).as("test data").contains("关键思考和关键追问不充分");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();		
		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();		
		softly.assertThat(desc).as("test data").contains("是否多次遇到过这样的情况：如果花时间进行关键思考或关键追问，本来可以缓解失误？关键思考指的是省思如何让一天或一项任务获得成功；包括检查个人和他人的精神状态或检查程序问题。关键追问指的是探讨准备工作是否足以取得成功；包括澄清任何未知情况。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.4.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.4.1] 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");
		//Click on 3.4.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1));
		String s1 = ele.getAttribute("class");
		if(s1.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).getText();		
		softly.assertThat(ev1).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Evidence entry place holder
		String ph1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-0"))).getAttribute("placeholder");		
		softly.assertThat(ph1).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-0']/h4/a"))).click();
		//Click on 3.4.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).click();
		//2nd collapsible for 3.4.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();		
		softly.assertThat(c2).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.4.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();		
		softly.assertThat(c3).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.4.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		System.out.println(q342);
		softly.assertThat(q342).as("test data").contains("[3.4.2] 采取行动前没有考虑易出错的心理状况");
		//Click on 3.4.2 to reveal evidence entry
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2));
		String s2 = ele.getAttribute("class");
		if(s2.contains("ui-checkbox-on")==false)
			wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).click();
		Thread.sleep(1000);
		//Evidence entry
		String ev2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).getText();		
		softly.assertThat(ev2).as("test data").contains("支持证据");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Evidence entry place holder
		String ph2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-1"))).getAttribute("placeholder");		
		softly.assertThat(ph2).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-1']/h4/a"))).click();
		//Click on 3.4.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).click();
		//2nd collapsible for 3.4.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();		
		softly.assertThat(c5).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.4.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();		
		softly.assertThat(c6).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.4.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.4.3] 采取行动前没有考虑高风险情境（如单项弱点）");
		//Click on 3.4.3 to reveal evidence entry
		while(true)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3));
			String s3 = ele.getAttribute("class");
			if(s3.contains("ui-checkbox-on")==false)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
			}
			Thread.sleep(1000);
			if(s3.contains("ui-checkbox-on")==true)
				break;
		}
		//Evidence entry
		String ev3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).getText();		
		softly.assertThat(ev3).as("test data").contains("支持证据");
		//Click on evidence entry
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))));
		//Evidence entry place holder
		String ph3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-2"))).getAttribute("placeholder");		
		softly.assertThat(ph3).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-2']/h4/a"))).click();
		//Click on 3.4.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).click();
		//2nd collapsible for 3.4.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.3
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();		
		softly.assertThat(c8).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.4.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.3
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();		
		softly.assertThat(c9).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.4.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)).getText();		
		softly.assertThat(q344).as("test data").contains("[3.4.4] 感到疑惑时质疑不充分");
		//Click on 3.4.4 to reveal evidence entry
		while(true)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4));
			String s3 = ele.getAttribute("class");
			if(s3.contains("ui-checkbox-on")==false)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
			}
			Thread.sleep(1000);
			if(s3.contains("ui-checkbox-on")==true)
				break;
		}
		//Evidence entry
		String ev4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).getText();		
		softly.assertThat(ev4).as("test data").contains("支持证据");
		//Click on evidence entry
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))));
		//Evidence entry place holder
		String ph4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-3"))).getAttribute("placeholder");		
		softly.assertThat(ph4).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-3']/h4/a"))).click();
		//Click on 3.4.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)).click();
		//2nd collapsible for 3.4.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.4
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();		
		softly.assertThat(c14).as("test data").contains("访谈犯错者");
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();		
		softly.assertThat(c15).as("test data").contains("访谈主管");
		//Click on 2nd collapsible for 3.4.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.4.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.4
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();		
		softly.assertThat(c17).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.4.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.4.5] 任务准备过程中质疑不充分");
		//Click on 3.4.5 to reveal evidence entry
		while(true)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5));
			String s3 = ele.getAttribute("class");
			if(s3.contains("ui-checkbox-on")==false)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
			}
			Thread.sleep(1000);
			if(s3.contains("ui-checkbox-on")==true)
				break;
		}
		//Evidence entry
		String ev5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).getText();		
		softly.assertThat(ev5).as("test data").contains("支持证据");
		//Click on evidence entry
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))));
		//Evidence entry place holder
		String ph5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-4"))).getAttribute("placeholder");		
		softly.assertThat(ph5).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-4']/h4/a"))).click();
		//Click on 3.4.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)).click();
		//2nd collapsible for 3.4.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.4.5
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li"))).getText();		
		softly.assertThat(c19).as("test data").contains("访谈犯错者");
		//Click on 2nd collapsible for 3.4.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.4.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.4.5
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li"))).getText();		
		softly.assertThat(c21).as("test data").contains("开展关键思考和关键追问方面的培训");
		//Click on 3rd collapsible for 3.4.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//Add new contributing factor button
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();
		softly.assertThat(c22).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		hc34.chineseAddContributingFactor(driver,softly);
	}
}
