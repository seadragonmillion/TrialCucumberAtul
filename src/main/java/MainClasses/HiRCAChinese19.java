import kaleTestSoftware.HiRCAChinese34;
import kaleTestSoftware.HiRCAChinese6;
import kaleTestSoftware.HiRCAObj;
import kaleTestSoftware.ShareCheck2;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAChinese19 {

	HiRCAChinese6 hc6 = new HiRCAChinese6();
	HiRCAChinese34 hc34 = new HiRCAChinese34();
	HiRCAObj hirca = new HiRCAObj();
	ShareCheck2 share2 = new ShareCheck2();
	
	public void chineseStepOneL37 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,60);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		//question
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText();

		softly.assertThat(heading).as("test data").contains("偏差控制");
		softly.assertThat(heading).as("test data").contains("不到位");
		//text under description 
		String textD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText();

		softly.assertThat(textD).as("test data").contains("若不适用点选skip略过。使用者可于底部新增促成因素。");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Description text
		String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText();

		softly.assertThat(desc).as("test data").contains("是否缺少操作标记、停工待检或要求而促使该失误的发生?");
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//3.7.1 question
		String q341 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).getText();
		System.out.println(q341);
		softly.assertThat(q341).as("test data").contains("[3.7.1] 进入和退出程序指引不到位");
		//Click on 3.7.1 to reveal evidence entry
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1));
		String s1 = ele.getAttribute("class");
			if(s1.contains("ui-checkbox-on")==false)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)));
			}
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
		//Click on 3.7.1 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer1)).click();
		//2nd collapsible for 3.7.1
		String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c1).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c2).as("test data").contains("访谈规则编写人？");
		String c26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c26).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.7.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.7.1
		String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c10).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c3).as("test data").contains("建立关于");
		softly.assertThat(c3).as("test data").contains("偏差控制");
		softly.assertThat(c3).as("test data").contains("的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		
		//3.7.2 question
		String q342 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).getText();
		softly.assertThat(q342).as("test data").contains("[3.7.2] 对于单项弱点步骤未设置自检或是独立检查");
		//Click on 3.7.2 to reveal evidence entry
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
		//Click on 3.7.2 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer2)).click();
		//2nd collapsible for 3.7.2
		String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c4).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		//text inside
		String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c5).as("test data").contains("访谈规则编写人？");
		String c34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c34).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.7.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.7.2
		String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c11).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		//text inside
		String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c6).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.7.3 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)));
		String q343 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).getText();
		System.out.println(q343);
		softly.assertThat(q343).as("test data").contains("[3.7.3] 未识别出不可逆点(PNR)的操作步骤（予以审查），从而确保继续操作前先前的失误得到纠正");
		//Click on 3.7.3 to reveal evidence entry
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
		//Click on 3.7.3 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer3)).click();
		//2nd collapsible for 3.7.3
		String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).getText();		
		softly.assertThat(c7).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.3
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();		
		softly.assertThat(c8).as("test data").contains("访谈规则编写人？");
		String c36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();		
		softly.assertThat(c36).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.7.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.7.3
		String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).getText();		
		softly.assertThat(c12).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.3
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();		
		softly.assertThat(c9).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.3
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.7.4 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)));
		String q344 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)).getText();		
		softly.assertThat(q344).as("test data").contains("[3.7.4] 未使用操作标记法来防止跳步或跳页");
		//Click on 3.7.4 to reveal evidence entry
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
		//Click on 3.7.4 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer4)).click();
		//2nd collapsible for 3.7.4
		String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c13).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.4
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c14).as("test data").contains("访谈规则编写人？");
		String c38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c38).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.7.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.7.4
		String c16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c16).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.4
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c17).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则审查人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.4
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.7.5 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)));
		String q345 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)).getText();
		System.out.println(q345);
		softly.assertThat(q345).as("test data").contains("[3.7.5] 未分析并缓解很有可能出现违章的情况（通过迹象核实、复核、禁止操作警告等方式）");
		//Click on 3.7.5 to reveal evidence entry
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
		//Click on 3.7.5 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer5)).click();
		//2nd collapsible for 3.7.5
		String c18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c18).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.5
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c19).as("test data").contains("访谈规则编写人？");
		String c22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c22).as("test data").contains("审查规则编写指导文件？");
		//Click on 2nd collapsible for 3.7.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.7.5
		String c20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c20).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.5
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c21).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.5
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//Scroll to the end
		share2.scrollToAPoint(driver, 1200);
		//3.7.6 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)));
		String q396 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)).getText();
		softly.assertThat(q396).as("test data").contains("[3.7.6] 例行作业未有充分的及时提醒标牌预防粗心犯错");
		//Click on 3.7.6 to reveal evidence entry
		while(true)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6));
			String s3 = ele.getAttribute("class");
			if(s3.contains("ui-checkbox-on")==false)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)));
			}
			Thread.sleep(1000);
			if(s3.contains("ui-checkbox-on")==true)
				break;
		}
		//Evidence entry
		String ev6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).getText();		
		softly.assertThat(ev6).as("test data").contains("支持证据");
		//Click on evidence entry
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))));
		//Evidence entry place holder
		String ph6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-5"))).getAttribute("placeholder");		
		softly.assertThat(ph6).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-5']/h4/a"))).click();
		//Click on 3.7.6 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer6)).click();
		//2nd collapsible for 3.7.6
		String c15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).getText();

		softly.assertThat(c15).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.6
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();

		softly.assertThat(c28).as("test data").contains("访谈规则编写人？");
		String c40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();

		softly.assertThat(c40).as("test data").contains("审查规则编写指导文件");
		//Click on 2nd collapsible for 3.7.6
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.7.6
		String c30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).getText();

		softly.assertThat(c30).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.6
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c31).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.6
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.7.7 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)));
		String q367 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)).getText();

		softly.assertThat(q367).as("test data").contains("[3.7.7] 未使用清单预防遗忘相关错误");
		//Click on 3.7.7 to reveal evidence entry
		while(true)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7));
			String s3 = ele.getAttribute("class");
			if(s3.contains("ui-checkbox-on")==false)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)));
			}
			Thread.sleep(1000);
			if(s3.contains("ui-checkbox-on")==true)
				break;
		}
		//Evidence entry
		String ev7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).getText();

		softly.assertThat(ev7).as("test data").contains("支持证据");
		//Click on evidence entry
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))));
		//Evidence entry place holder
		String ph7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-6"))).getAttribute("placeholder");

		softly.assertThat(ph7).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-6']/h4/a"))).click();
		//Click on 3.7.7 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer7)).click();
		//2nd collapsible for 3.7.7
		String c41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c41).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.7
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c42).as("test data").contains("访谈规则编写人？");
		String c43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c43).as("test data").contains("审查规则编写指导文件");
		//Click on 2nd collapsible for 3.7.7
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.7.7
		String c44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c44).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.7
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c45).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则编写人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.7
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.7.8 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)));
		String q368 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)).getText();

		softly.assertThat(q368).as("test data").contains("[3.7.8] 同事指导的好文化不到位，未能鼓励和强调守规行为标准");
		//Click on 3.7.8 to reveal evidence entry
		while(true)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8));
			String s3 = ele.getAttribute("class");
			if(s3.contains("ui-checkbox-on")==false)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)));
			}
			Thread.sleep(1000);
			if(s3.contains("ui-checkbox-on")==true)
				break;
		}
		//Evidence entry
		String ev8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).getText();
		softly.assertThat(ev8).as("test data").contains("支持证据");
		//Click on evidence entry
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))));
		//Evidence entry place holder
		String ph8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-7"))).getAttribute("placeholder");
		softly.assertThat(ph8).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-7']/h4/a"))).click();
		//Click on 3.7.8 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer8)).click();
		//2nd collapsible for 3.7.8
		String c46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c46).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.8
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c47).as("test data").contains("访谈犯错人");
		String c48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c48).as("test data").contains("访谈同事");
		//Click on 2nd collapsible for 3.7.8
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.7.8
		String c49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c49).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.8
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();

		softly.assertThat(c50).as("test data").contains("培训如何做好同事指导守规文化");
		String c23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/div/ul/li[2]"))).getText();

		softly.assertThat(c23).as("test data").contains("改善有缺陷的程序");
		//Click on 3rd collapsible for 3.7.8
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.7.9 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)));
		String q369 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)).getText();
		softly.assertThat(q369).as("test data").contains("[3.7.9] 审查不到位");
		//Click on 3.7.9 to reveal evidence entry
		while(true)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9));
			String s3 = ele.getAttribute("class");
			if(s3.contains("ui-checkbox-on")==false)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)));
			}
			Thread.sleep(1000);
			if(s3.contains("ui-checkbox-on")==true)
				break;
		}
		//Evidence entry
		String ev9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).getText();
		softly.assertThat(ev9).as("test data").contains("支持证据");
		//Click on evidence entry
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))));
		//Evidence entry place holder
		String ph9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-8"))).getAttribute("placeholder");
		softly.assertThat(ph9).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-8']/h4/a"))).click();
		//Click on 3.7.9 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer9)).click();
		//2nd collapsible for 3.7.9
		String c51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c51).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.9
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c52).as("test data").contains("访谈审查者?");
		String c53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c53).as("test data").contains("调查审查标准?");
		//Click on 2nd collapsible for 3.7.9
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.7.9
		String c54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c54).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.9
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c55).as("test data").contains("建立关于\"偏差控制\"的规则编写标准或指导文件\", \"规则审查人的培训、授权和问责");
		//Click on 3rd collapsible for 3.7.9
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//3.7.10 question
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10)));
		String q3691 = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10)).getText();
		if(browserName.contains("safari"))
		{
			softly.assertThat(q3691).as("test data").contains("[3.7.10] 维修不到位:");
			softly.assertThat(q3691).as("test data").contains("(1) 预见性维修不到位 ");
			softly.assertThat(q3691).as("test data").contains("(2) 预防性维修不到位 ");
			softly.assertThat(q3691).as("test data").contains("3) 纠正性维修不到位 ");
			softly.assertThat(q3691).as("test data").contains("(4) 修后试验不到位 ");
			softly.assertThat(q3691).as("test data").contains("(5) 故障查找和根本原因分析不到位 ");
			softly.assertThat(q3691).as("test data").contains("(6) 维修失误");
		}
		else
			softly.assertThat(q3691).as("test data").contains("[3.7.10] 维修不到位: (1) 预见性维修不到位 (2) 预防性维修不到位 3) 纠正性维修不到位 (4) 修后试验不到位 (5) 故障查找和根本原因分析不到位 (6) 维修失误");
		//Click on 3.7.10 to reveal evidence entry
		while(true)
		{
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10));
			String s3 = ele.getAttribute("class");
			if(s3.contains("ui-checkbox-on")==false)
			{
				jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10)));
				jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10)));
			}
			Thread.sleep(1000);
			if(s3.contains("ui-checkbox-on")==true)
				break;
		}
		//Evidence entry
		String ev91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).getText();
		softly.assertThat(ev91).as("test data").contains("支持证据");
		//Click on evidence entry
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))));
		//Evidence entry place holder
		String ph91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-9"))).getAttribute("placeholder");
		softly.assertThat(ph91).as("test data").contains("输入 支持证据 (非必填)");
		//Click on evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-9']/h4/a"))).click();
		//Click on 3.7.10 to disable evidence entry
		//wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.Answer10)).click();
		//2nd collapsible for 3.7.10
		String c25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).getText();
		softly.assertThat(c25).as("test data").contains("进一步调查");
		//Click on 2nd collapsible for 3.7.10
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))));
		//text inside
		String c24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[1]"))).getText();
		softly.assertThat(c24).as("test data").contains("与类似组织就维修实践进行对标");
		String c29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[2]"))).getText();
		softly.assertThat(c29).as("test data").contains("确定故障查找和根本原因分析报告的质量");
		String c32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/div/ul/li[3]"))).getText();
		softly.assertThat(c32).as("test data").contains("调查重复失效背后的共同原因");
		//Click on 2nd collapsible for 3.7.10
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[2]/h4/a"))).click();
		
		/*am_not applicable
		//3rd collapsible 3.7.10
		String c35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).getText();
		softly.assertThat(c35).as("test data").contains("可能的纠正行动");
		//Click on 3rd collapsible for 3.7.10
		jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))));
		jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))));
		//text inside
		String c37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/div/ul/li[1]"))).getText();
		softly.assertThat(c37).as("test data").contains("纠正维修大纲中的缺陷");
		//Click on 3rd collapsible for 3.7.10
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div[2]/div[3]/h4/a"))).click();
		*/
		//Add new contributing factor button
		String c33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button"))).getText();

		softly.assertThat(c33).as("test data").contains("新增促成因素");
		//Verify Add Contributing factor
		hc34.chineseAddContributingFactor(driver, softly);
		//Scroll to the top
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
	}
}
