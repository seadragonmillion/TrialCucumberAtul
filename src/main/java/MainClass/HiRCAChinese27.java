package MainClass;


import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiRCAChinese27 {
	
	HiRCAChinese8 hc8 = new HiRCAChinese8();
	HiRCAChinese9 hc9 = new HiRCAChinese9();
	
	public void chineseReport1stPath_hc27 (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//3.22 table heading
		String heading39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading39).as("test data").contains("可能促成因素");
		String heading40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading40).as("test data").contains("支持证据");
		String heading41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading41).as("test data").contains("进一步调查");
		
		/*am_not applicable
		String heading42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading42).as("test data").contains("可能的纠正行动");*/
		//3.22 table rows
		String r558 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r558).as("test data").contains("3.22.1 对规则的现场试验不充分");
		String r559 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r559).as("test data").contains("不适用");
		String r560 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r560).as("test data").contains("有无现场试验？");
		String r561 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li"))).getText();
		softly.assertThat(r561).as("test data").contains("发布规则/程序前，执行现场试验");
		String r562 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r562).as("test data").contains("3.22.2 给规则编写人的反馈不充分，从而使其纠正错误规则");
		String r563 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r563).as("test data").contains("不适用");
		String r564 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r564).as("test data").contains("有无反馈？");
		String r565 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r565).as("test data").contains("设计出允许执行人员记录失误方便编写人改正的程序");
		String r566 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r566).as("test data").contains("制定遇到程序关键错误后要求停止操作的政策");
		String r567 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r567).as("test data").contains("3.22.3 盲目信任错误规则");
		String r568 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r568).as("test data").contains("不适用");
		String r569 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r569).as("test data").contains("是否要求澄清？");
		String r570 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r570).as("test data").contains("培训");
		String r571 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r571).as("test data").contains("3.22.4 规则审核不到位");
		String r572 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r572).as("test data").contains("不适用");
		String r573 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r573).as("test data").contains("程序/规则当时是如何审核的？");
		String r574 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r574).as("test data").contains("提供有效审核的相关培训");
		String r575 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r575).as("test data").contains("3.22.5 工前会、班前会、交底会的规则不充分");
		String r576 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r576).as("test data").contains("不适用");
		String r577 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li"))).getText();
		softly.assertThat(r577).as("test data").contains("工前会、班前会、交底会上是否识别出错误的规则/程序？");
		String r578 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[28]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li"))).getText();
		softly.assertThat(r578).as("test data").contains("完善关于工前会、班前会、交底会的规则");
		//1.19
		String r579= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(r579).as("test data").contains("1.19 是否有类似事件重发的趋势？");
		String r580 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[29]/td[2]"))).getText();
		softly.assertThat(r580).as("test data").contains("是");
		String r581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[29]/td[3]"))).getText();
		softly.assertThat(r581).as("test data").contains("不适用");
		//3.3 table heading
		String heading351 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading351).as("test data").contains("可能促成因素");
		String heading361 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading361).as("test data").contains("支持证据");
		String heading371 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading371).as("test data").contains("进一步调查");
		
		/*am_not applicable
		String heading381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading381).as("test data").contains("可能的纠正行动");*/
		//3.3 table rows
		String r4901 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r4901).as("test data").contains("3.3.1 经理团队资源分配不到位");
		String r4911 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r4911).as("test data").contains("不适用");
		String r4921 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r4921).as("test data").contains("是否一些工作组工作量过多，而另一些工作组工作量过少？");
		String r4931 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r4931).as("test data").contains("分配工作更多的是为了纠正问题，而不是防治问题？");
		String r4951 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li"))).getText();
		softly.assertThat(r4951).as("test data").contains("提升管理技能，完善资源分配体系");
		String r4971 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r4971).as("test data").contains("3.3.2 经理团队所需培训开展不充分");
		String r4981 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r4981).as("test data").contains("不适用");
		String r4991 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r4991).as("test data").contains("培训计划是否从提高效率和提高质量两个方面考虑？");
		String r5001 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r5001).as("test data").contains("成立培训计划委员会");
		String r5011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r5011).as("test data").contains("3.3.3 经理团队问责制不到位");
		String r5021 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r5021).as("test data").contains("不适用");
		String r5031 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5031).as("test data").contains("PM&T是否充分？");
		String r5041 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5041).as("test data").contains("JO是否充分？");
		String r5051 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5051).as("test data").contains("RCA是否充分？");
		String r5061 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r5061).as("test data").contains("ORRA是否充分？");
		String r5071 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r5071).as("test data").contains("完善问责制");
		String r5081 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r5081).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");
		String r5091 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r5091).as("test data").contains("不适用");
		String r5101 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5101).as("test data").contains("工作流程中没有包括工作优先级的确定？");
		String r5111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5111).as("test data").contains("优先级确定标准在时间、范围（质量）和成本三个方面没有平衡好？");
		String r5121 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r5121).as("test data").contains("完善管理优先级确定和计划体系？");
		String r5131 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r5131).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");
		String r5141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r5141).as("test data").contains("不适用");
		String r5151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5151).as("test data").contains("自我分析（自评）？");
		String r5161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5161).as("test data").contains("与表现优秀者对标？");
		String r5171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5171).as("test data").contains("开展关于标准设定的管理培训");
		String r5181 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5181).as("test data").contains("开展关于程序和保护屏障设计的培训");
		String r5191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r5191).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");
		String r5201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r5201).as("test data").contains("不适用");
		String r5211 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5211).as("test data").contains("KPI不充分？");
		String r5221 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5221).as("test data").contains("没有定期开展共因分析？");
		String r5231 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5231).as("test data").contains("未对类似事件或失误进行趋势分析？");
		String r5241 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5241).as("test data").contains("定期开展共因分析");
		String r5251 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5251).as("test data").contains("改善绩效跟踪与趋势分析项目");
		String r5261 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r5261).as("test data").contains("完善KPI");
		String r5271 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r5271).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");
		String r5281 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r5281).as("test data").contains("不适用");
		String r5291 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5291).as("test data").contains("经理之间的接口问题？");
		String r5301 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5301).as("test data").contains("主管或经理之间存在不和？");
		String r5311 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5311).as("test data").contains("因两个管理团队之间接口问题，导致工作没有做？");
		String r5321 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5321).as("test data").contains("开展组织设计方面的管理培训");
		String r5331 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5331).as("test data").contains("在经理人员之间建立共同目标、共同利益和共同责任");
		String r5341 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r5341).as("test data").contains("3.3.8 经理团队纠正行动不足");
		String r5351 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r5351).as("test data").contains("不适用");
		String r5361 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5361).as("test data").contains("根本原因分析不足导致事件重发？");
		String r5371 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5371).as("test data").contains("没有注意到关键的在变化的问题导致未能解决紧急问题？");
		String r5381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5381).as("test data").contains("纠正行动制定过多导致大量纠正行动仍然积压？");
		String r5391 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5391).as("test data").contains("提高纠正行动计划的落实");
		String r5401 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5401).as("test data").contains("改善根本原因分析方法");
		String r5411 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[8]/td[4]/ul/li[3]"))).getText();
		softly.assertThat(r5411).as("test data").contains("完善突发紧急问题（危机）管理机制");
		String r5421 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r5421).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");
		String r5431 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r5431).as("test data").contains("不适用");
		String r5441 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5441).as("test data").contains("方针培训？");
		String r5451 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5451).as("test data").contains("对员工的管理指导？");
		String r5461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[3]"))).getText();
		softly.assertThat(r5461).as("test data").contains("传达给员工的工作指令不充分？");
		String r5471 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[3]/ul/li[4]"))).getText();
		softly.assertThat(r5471).as("test data").contains("是否定期召开员工会议？");
		String r5481 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[9]/td[4]/ul/li"))).getText();
		softly.assertThat(r5481).as("test data").contains("完善垂直沟通体系");
		String r5491 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r5491).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");
		String r5501 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r5501).as("test data").contains("不适用");
		String r5511 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r5511).as("test data").contains("共同目标和共同利益不充分？");
		String r5521 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r5521).as("test data").contains("程序设计不当？");
		String r5531 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r5531).as("test data").contains("完善程序设计");
		String r5541 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[10]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r5541).as("test data").contains("制定共同目标和共同利益");
		//3.5
		String r582 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r582).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r583 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r583).as("test data").contains("不适用");
		String r584 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r584).as("test data").contains("情况警觉培训？");
		String r585 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r585).as("test data").contains("作业前意识体系的改善？");
		String r586 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r586).as("test data").contains("情况警觉培训");
		String r587 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[11]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r587).as("test data").contains("作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		String r588 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r588).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r589 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r589).as("test data").contains("不适用");
		String r590 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[12]/td[3]/ul/li"))).getText();
		softly.assertThat(r590).as("test data").contains("情况警觉培训？");
		String r591 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[12]/td[4]/ul/li"))).getText();
		softly.assertThat(r591).as("test data").contains("情况警觉培训");
		String r592 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r592).as("test data").contains("3.5.3 对人员表现的观察技能不足");
		String r593 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r593).as("test data").contains("不适用");
		String r594 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[13]/td[3]/ul/li"))).getText();
		softly.assertThat(r594).as("test data").contains("情况警觉培训？");
		String r595 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[13]/td[4]/ul/li"))).getText();
		softly.assertThat(r595).as("test data").contains("开展人员表现观察技能方面的培训");
		String r596 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r596).as("test data").contains("3.5.4 对设备性能的观察技能不足");
		String r597 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r597).as("test data").contains("不适用");
		String r598 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[14]/td[3]/ul/li"))).getText();
		softly.assertThat(r598).as("test data").contains("情况警觉培训？");
		String r599 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[30]/td[1]/div/table/tbody/tr[14]/td[4]/ul/li"))).getText();
		softly.assertThat(r599).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");
		//1.20
		String r600= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[31]/td[1]"))).getText();
		softly.assertThat(r600).as("test data").contains("1.20 错误是否与工作时发生改变有关？");
		String r601 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[31]/td[2]"))).getText();
		softly.assertThat(r601).as("test data").contains("是");
		String r602 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[31]/td[3]"))).getText();
		softly.assertThat(r602).as("test data").contains("不适用");
		//3.5 table heading
		String heading43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading43).as("test data").contains("可能促成因素");
		String heading44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading44).as("test data").contains("支持证据");
		String heading45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading45).as("test data").contains("进一步调查");
		
		/*am_not applicable
		String heading46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading46).as("test data").contains("可能的纠正行动");*/
		//3.5 rows
		String r603 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r603).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r604 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r604).as("test data").contains("不适用");
		String r605 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r605).as("test data").contains("情况警觉培训？");
		String r606 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r606).as("test data").contains("作业前意识体系的改善？");
		String r607 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r607).as("test data").contains("情况警觉培训");
		String r608 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r608).as("test data").contains("作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		String r609 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r609).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");
		String r610 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r610).as("test data").contains("不适用");
		String r611 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li"))).getText();
		softly.assertThat(r611).as("test data").contains("情况警觉培训？");
		String r612 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li"))).getText();
		softly.assertThat(r612).as("test data").contains("情况警觉培训");
		String r613 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r613).as("test data").contains("3.5.3 对人员表现的观察技能不足");
		String r614 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r614).as("test data").contains("不适用");
		String r615 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r615).as("test data").contains("情况警觉培训？");
		String r616 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li"))).getText();
		softly.assertThat(r616).as("test data").contains("开展人员表现观察技能方面的培训");
		String r617 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r617).as("test data").contains("3.5.4 对设备性能的观察技能不足");
		String r618 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r618).as("test data").contains("不适用");
		String r619 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li"))).getText();
		softly.assertThat(r619).as("test data").contains("情况警觉培训？");
		String r620 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[32]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li"))).getText();
		softly.assertThat(r620).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");

		//Table 7
		hc8.chineseTable7ReportTab(driver,softly);

		//SUEP title
		hc8.chineseSUEPFullFormReportTab(driver,softly);

		//SUEP table rows
		String r636 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r636).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");
		String r637 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r637).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");//"3.2.2 组长绩效反馈方面的管理能力不足"
		String r638 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r638).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");//"3.2.3 组长召开经验反馈的管理技能不足"
		String r639 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r639).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");//"3.2.4 组长在岗培训方面管理能力不足"
		String r640 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r640).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");//"3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施"
		String r641 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r641).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");//"3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足"
		String r642 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r642).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");//"3.3.1 经理团队资源分配不到位"
		String r643 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r643).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");//"3.3.2 经理团队所需培训开展不充分"
		String r644 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r644).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");//"3.3.3 经理团队问责制不到位"
		String r645 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r645).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");//"3.3.4 经理团队对确定工作优先级和计划方面不到位"
		String r646 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r646).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");//"3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障"
		String r647 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r647).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");//"3.3.6 经理团队绩效跟踪与趋势分析不到位"
		String r648 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r648).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");//"3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任"
		String r649 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r649).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");//"3.3.8 经理团队纠正行动不足"
		String r650 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(r650).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");//"3.3.9 经理团队垂直沟通体系不完善"
		String r651 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[31]/td[1]"))).getText();
		softly.assertThat(r651).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");//"3.3.10 经理团队横向沟通体系不完善"
		String r652 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[33]/td[1]"))).getText();
		softly.assertThat(r652).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");//"3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）"
		String r653 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[35]/td[1]"))).getText();
		softly.assertThat(r653).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");//"3.4.2 采取行动前没有考虑易出错的心理状况"
		String r654 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[37]/td[1]"))).getText();
		softly.assertThat(r654).as("test data").contains("3.3.1 经理团队资源分配不到位");//"3.4.3 采取行动前没有考虑高风险情境（如单项弱点）"
		String r655 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[39]/td[1]"))).getText();
		softly.assertThat(r655).as("test data").contains("3.3.1 经理团队资源分配不到位");//"3.4.4 感到疑惑时质疑不充分"
		String r656 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[41]/td[1]"))).getText();
		softly.assertThat(r656).as("test data").contains("3.3.2 经理团队所需培训开展不充分");//"3.4.5 任务准备过程中质疑不充分"
		String r657 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[43]/td[1]"))).getText();
		softly.assertThat(r657).as("test data").contains("3.3.2 经理团队所需培训开展不充分");//"3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分"
		String r658 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[45]/td[1]"))).getText();
		softly.assertThat(r658).as("test data").contains("3.3.3 经理团队问责制不到位");//"3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分"
		String r659 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[47]/td[1]"))).getText();
		softly.assertThat(r659).as("test data").contains("3.3.3 经理团队问责制不到位");//"3.5.3 对人员表现的观察技能不足"
		String r660 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[49]/td[1]"))).getText();
		softly.assertThat(r660).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");//"3.5.4 对设备性能的观察技能不足"
		String r661 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[51]/td[1]"))).getText();
		softly.assertThat(r661).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");//"3.6.1 要求有遗漏"
		String r662 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[53]/td[1]"))).getText();
		softly.assertThat(r662).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");//"3.6.2 运行条件有遗漏"
		String r663 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[55]/td[1]"))).getText();
		softly.assertThat(r663).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");//"3.6.3 假设有遗漏"
		String r664 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[57]/td[1]"))).getText();
		softly.assertThat(r664).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");//"3.6.4 范围有遗漏"
		String r665 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[59]/td[1]"))).getText();
		softly.assertThat(r665).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");//"3.6.5 试验或测量有遗漏"
		String r666 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[61]/td[1]"))).getText();
		softly.assertThat(r666).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");//"3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用"
	//	softly.assertThat(r666).as("test data").contains("不准做清单");
	//	softly.assertThat(r666).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		String r667 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[63]/td[1]"))).getText();
		softly.assertThat(r667).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");//"3.6.7 审查不到位导致制度有遗漏项"
		String r668 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[65]/td[1]"))).getText();
		softly.assertThat(r668).as("test data").contains("3.3.8 经理团队纠正行动不足");//"3.6.8 根本原因分析不到位导致制度有遗漏项"
		String r669 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[67]/td[1]"))).getText();
		softly.assertThat(r669).as("test data").contains("3.3.8 经理团队纠正行动不足");//"3.6.9 纠正措施执行不到位导致制度有遗漏项"
		String r670 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[69]/td[1]"))).getText();
		softly.assertThat(r670).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");//"3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺"
		String r671 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[71]/td[1]"))).getText();
		softly.assertThat(r671).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");//"3.9.2 复训频率不高(>> 一年)"
		String r672 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[73]/td[1]"))).getText();
		softly.assertThat(r672).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");//"3.9.3 部门管理层未充分参与培训材料的编写和培训的实施"
		String r673 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[75]/td[1]"))).getText();
		softly.assertThat(r673).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");//"3.9.4 未将经验教训充分包含到培训中"
		String r674 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[77]/td[1]"))).getText();
		softly.assertThat(r674).as("test data").contains("3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");//"3.9.5 所需培训开展不充分（脱岗）"
		String r675 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[79]/td[1]"))).getText();
		softly.assertThat(r675).as("test data").contains("3.4.2 采取行动前没有考虑易出错的心理状况");//"3.9.6 所需培训开展不充分（在岗）"
		String r676 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[81]/td[1]"))).getText();
		softly.assertThat(r676).as("test data").contains("3.4.3 采取行动前没有考虑高风险情境（如单项弱点）");//"3.10.1 关键岗位员工的作业授权不充分"
		String r677 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[83]/td[1]"))).getText();
		softly.assertThat(r677).as("test data").contains("3.4.4 感到疑惑时质疑不充分");//"3.10.2 关键岗位主管和（或）经理授权不充分"
		String r678 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[85]/td[1]"))).getText();
		softly.assertThat(r678).as("test data").contains("3.4.5 任务准备过程中质疑不充分");//"3.10.3 供应商服务（QA/RC、来源检查）授权不充分"
		String r679 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[87]/td[1]"))).getText();
		softly.assertThat(r679).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");//"3.10.4 现场供应商人员授权不充分"
		String r680 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[89]/td[1]"))).getText();
		softly.assertThat(r680).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");//"3.10.5 培训教员授权不充分"
		String r681 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[91]/td[1]"))).getText();
		softly.assertThat(r681).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");//"3.11.1 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位"
		String r682 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[93]/td[1]"))).getText();
		softly.assertThat(r682).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");//"3.11.2 即时反馈和持续强化(IF&CR)的管理技能不到位"
		String r683 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[95]/td[1]"))).getText();
		softly.assertThat(r683).as("test data").contains("3.5.3 对人员表现的观察技能不足");//"3.11.3 用于绩效控制的奖惩制度不到位"
		String r684 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[97]/td[1]"))).getText();
		softly.assertThat(r684).as("test data").contains("3.5.3 对人员表现的观察技能不足");//"3.11.4 问题报告、RCA和纠正行动不到位，给员工的反馈不到位"
		String r685 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[99]/td[1]"))).getText();
		softly.assertThat(r685).as("test data").contains("3.5.4 对设备性能的观察技能不足");//"3.11.5 现场观察不充分，给员工的反馈不到位"
		String r686 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[101]/td[1]"))).getText();
		softly.assertThat(r686).as("test data").contains("3.5.4 对设备性能的观察技能不足");//"3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训"
		String r687 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[103]/td[1]"))).getText();
		softly.assertThat(r687).as("test data").contains("3.6.1 要求有遗漏");//"3.15.2 未要求员工对纠正他人违规的情况承担责任"
		String r688 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[105]/td[1]"))).getText();
		softly.assertThat(r688).as("test data").contains("3.6.2 运行条件有遗漏");//"3.15.3 员工未充分理解相关行为规范"
		String r689 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[107]/td[1]"))).getText();
		softly.assertThat(r689).as("test data").contains("3.6.3 假设有遗漏");//"3.15.4 主管未到现场强化"
		//softly.assertThat(r689).as("test data").contains("同事指导");
		String r690 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[109]/td[1]"))).getText();
		softly.assertThat(r690).as("test data").contains("3.6.4 范围有遗漏");//"3.18.1 盲目信任: 关键信息使用质疑的态度"
		//softly.assertThat(r690).as("test data").contains("不到位");
		String r691 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[111]/td[1]"))).getText();
		softly.assertThat(r691).as("test data").contains("3.6.5 试验或测量有遗漏");//"3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生"
		String r692 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[113]/td[1]"))).getText();
		softly.assertThat(r692).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");//"3.18.3 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障"
		String r693 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[115]/td[1]"))).getText();
		softly.assertThat(r693).as("test data").contains("3.6.7 审查不到位导致制度有遗漏项");//"3.18.4 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果"
		String r694 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[117]/td[1]"))).getText();
		softly.assertThat(r694).as("test data").contains("3.6.8 根本原因分析不到位导致制度有遗漏项");//"3.18.5 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析"
		String r695 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[119]/td[1]"))).getText();
		softly.assertThat(r695).as("test data").contains("3.6.9 纠正措施执行不到位导致制度有遗漏项");//"3.22.1 对规则的现场试验不充分"
		String r696 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[121]/td[1]"))).getText();
		softly.assertThat(r696).as("test data").contains("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");//"3.22.2 给规则编写人的反馈不充分，从而使其纠正错误规则"
		String r697 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[123]/td[1]"))).getText();
		softly.assertThat(r697).as("test data").contains("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");//"3.22.3 盲目信任错误规则"
		String r698 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[125]/td[1]"))).getText();
		softly.assertThat(r698).as("test data").contains("3.9.2 复训频率不高(>> 一年)");//"3.22.4 规则审核不到位"
		String r699 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[127]/td[1]"))).getText();
		softly.assertThat(r699).as("test data").contains("3.9.2 复训频率不高(>> 一年)");//"3.22.5 工前会、班前会、交底会的规则不充分"

		//HiRCA self checklist chinese, none selected
		hc8.chineseHiRCASelfChecklistTitleReportTab(driver,softly);
		//Row
		String r700 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r700).as("test data").contains("不适用");
		String r701 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r701).as("test data").contains("不适用");
		String r702 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[10]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r702).as("test data").contains("不适用");

		//Last Table
		hc8.chineseLastTableReportTab(driver,softly);
	}
}
