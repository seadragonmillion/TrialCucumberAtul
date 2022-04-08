package MainClass;


import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiRCAChinese29 {
	
	HiRCAChinese8 hc8 = new HiRCAChinese8();
	HiRCAChinese9 hc9 = new HiRCAChinese9();

	public void chineseReport5thPath (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Table3 row
		String r1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1a).as("test data").contains("不适用");
		String r2a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r2a).as("test data").contains("不适用");
		String r3a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r3a).as("test data").contains("不适用");
		//Table4 rows
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1).as("test data").contains("3.16.1 疲倦: (1) 大约上午3-4点; (2) 大约下午2-3点; (3) 长时间工作后");
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r2).as("test data").contains("休息时间管理,");
		softly.assertThat(r2).as("test data").contains("行为培训 (");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r3).as("test data").contains("3.16.2 注意力不集中（分心）: (1) 同时执行多个任务; (2) 被打断; (3) 有心事");
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r4).as("test data").contains("行为培训");
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r5).as("test data").contains("3.16.3 过度自信: (1) 首次执行的操作(FTE)，而没有寻求充分帮助；(2) 日常工作，而没有注意到微小变化和新情况；(3) 繁琐任务未定期自检 (如数据输入)；(4) 使用信息数据未审核且核实 (5) 不识别单项弱点也不自检单项弱点；(6) 按记忆中（印象中）的程序作业（未持程序作业）");
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r6).as("test data").contains("在工前会、班前会和交底会讨论单项弱点和首次作业,");
		softly.assertThat(r6).as("test data").contains("行为培训");
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r7).as("test data").contains("3.16.4 时间压力: 急着完工");
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r8).as("test data").contains("行为培训, 改善排程和计划系统");
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r9).as("test data").contains("3.16.5 注意不足: 1.长时间工作而没有休息(> 140分钟); 2. 早上10点时做事; 3. 工作超过10小时");
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r10).as("test data").contains("中间适当休息, 最大程度减少干扰");
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r11).as("test data").contains("3.16.6 学习技能时相关规定有误");
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r12).as("test data").contains("学习正确所需技能");
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r13).as("test data").contains("3.16.7 判断出错未能选择正确技能使用");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[5]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r14).as("test data").contains("培训技能的选择, 透过强化规定减少选择错误的机会");

		//Table 6 Header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading).as("test data").contains("调查问题");
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading1).as("test data").contains("答案");
		String heading2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading2).as("test data").contains("选择原因");
		//Table 6 Rows
		//1.1
		String r139 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r139).as("test data").contains("1.1 始发事件为人因、设备失效还是天灾？");
		String r140 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r140).as("test data").contains("人因");
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r141).as("test data").contains("不适用");
		//1.2
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r142).as("test data").contains("1.2 始发事件的错误类型为何？");
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r143).as("test data").contains("规则型错误");
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r144).as("test data").contains("不适用");
		//1.3
		String r67 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r67).as("test data").contains("1.3 若为规则型错误，是否为有意违规还是无意违规？");
		String r68 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r68).as("test data").contains("无意违规");
		String r69 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r69).as("test data").contains("不适用");
		//1.4
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r194).as("test data").contains("1.4 此无意违规是粗心导致还是程序不当导致？");
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r195).as("test data").contains("粗心犯错");
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r196).as("test data").contains("不适用");
		//3.16 table heading
		String heading3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading3).as("test data").contains("可能促成因素");
		String heading4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading4).as("test data").contains("支持证据");
		String heading5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading5).as("test data").contains("进一步调查");
		String heading6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading6).as("test data").contains("可能的纠正行动");
		//3.16 table rows
		String r145 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r145).as("test data").contains("3.16.1 疲倦: (1) 大约上午3-4点; (2) 大约下午2-3点; (3) 长时间工作后");
		String r146 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r146).as("test data").contains("不适用");
		String r147 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r147).as("test data").contains("查阅以往事件？");
		String r148 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r148).as("test data").contains("休息时间管理");
		String r70 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r70).as("test data").contains("行为培训 (");
		String r149 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r149).as("test data").contains("3.16.2 注意力不集中（分心）: (1) 同时执行多个任务; (2) 被打断; (3) 有心事");
		String r150 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r150).as("test data").contains("不适用");
		String r151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r151).as("test data").contains("访谈犯错者？");
		String r72 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r72).as("test data").contains("访谈同事？");
		String r152 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r152).as("test data").contains("行为培训");
		String r153 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r153).as("test data").contains("3.16.3 过度自信: (1) 首次执行的操作(FTE)，而没有寻求充分帮助；(2) 日常工作，而没有注意到微小变化和新情况；(3) 繁琐任务未定期自检 (如数据输入)；(4) 使用信息数据未审核且核实 (5) 不识别单项弱点也不自检单项弱点；(6) 按记忆中（印象中）的程序作业（未持程序作业）");
		String r154 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r154).as("test data").contains("不适用");
		String r155 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r155).as("test data").contains("访谈犯错者？");
		String r156 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r156).as("test data").contains("在工前会、班前会和交底会讨论单项弱点和首次作业");
		String r91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r91).as("test data").contains("行为培训");
		String r157 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r157).as("test data").contains("3.16.4 时间压力: 急着完工");
		String r158 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r158).as("test data").contains("不适用");
		String r159 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r159).as("test data").contains("现场观察？");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r15).as("test data").contains("访谈同事？");
		String r161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r161).as("test data").contains("行为培训");
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r16).as("test data").contains("改善排程和计划系统");
		String r162 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r162).as("test data").contains("3.16.5 注意不足: 1.长时间工作而没有休息(> 140分钟); 2. 早上10点时做事; 3. 工作超过10小时");
		String r163 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r163).as("test data").contains("不适用");
		String r164 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r164).as("test data").contains("现场观察？");
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r17).as("test data").contains("访谈同事？");
		String r165 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r165).as("test data").contains("中间适当休息");
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r18).as("test data").contains("最大程度减少干扰");
		String r166 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r166).as("test data").contains("3.16.6 学习技能时相关规定有误");
		String r167 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r167).as("test data").contains("不适用");
		String r168 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r168).as("test data").contains("审查技能相关规定");
		String r170 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li"))).getText();
		softly.assertThat(r170).as("test data").contains("学习正确所需技能");
		String r171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r171).as("test data").contains("3.16.7 判断出错未能选择正确技能使用");
		String r172 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r172).as("test data").contains("不适用");
		String r173 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li"))).getText();
		softly.assertThat(r173).as("test data").contains("访谈犯错人");
		String r176 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r176).as("test data").contains("培训技能的选择");
		String r74 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r74).as("test data").contains("透过强化规定减少选择错误的机会");
		//1.5
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r197).as("test data").contains("1.5 若我是犯错者，我是否会犯同样的错？");
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r198).as("test data").contains("略过");
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r199).as("test data").contains("不适用");
		//1.6
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r200).as("test data").contains("1.6 犯错者违规时是否有旁人观看？");
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r201).as("test data").contains("略过");
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r202).as("test data").contains("不适用");
		//1.7
		String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r222).as("test data").contains("1.7 这个错误是否可以透过自检或独立检查避免？");
		String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r223).as("test data").contains("略过");
		String r224 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r224).as("test data").contains("不适用");
		//1.8
		String r225 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r225).as("test data").contains("1.8 犯错人员是否受过培训知道如何管理易出错精神状态和高风险？");
		String r226 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r226).as("test data").contains("略过");
		String r227 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r227).as("test data").contains("不适用");
		//1.9
		String r312 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r312).as("test data").contains("1.9 犯错者在事后是否有经组长或管理层问责？");
		String r313 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r313).as("test data").contains("略过");
		String r314 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r314).as("test data").contains("不适用");		
		//1.10
		String r377 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r377).as("test data").contains("1.10 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		String r378 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r378).as("test data").contains("略过");
		String r379 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r379).as("test data").contains("不适用");
		//1.11
		String r380 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r380).as("test data").contains("1.11 这个错为何是现在发生而不是以前发生？");
		String r381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r381).as("test data").contains("略过");
		String r382 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r382).as("test data").contains("不适用");
		//1.12
		String r3801 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r3801).as("test data").contains("1.12 若班前会、工前会或交底会未执行，为什么？");
		String r3811 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r3811).as("test data").contains("略过");
		String r3821 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r3821).as("test data").contains("不适用");
		//1.13
		String r38011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r38011).as("test data").contains("1.13 错误的发生是否存在易出错精神状态或是高风险状态？");
		String r38111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r38111).as("test data").contains("略过");
		String r384 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r384).as("test data").contains("不适用");
		//1.14
		String r385= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r385).as("test data").contains("1.14 组长是否固定开展经验反馈？");
		String r386 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r386).as("test data").contains("略过");
		String r387 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r387).as("test data").contains("不适用");
		//1.15
		String r397= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r397).as("test data").contains("1.15 始发事件是否有单项弱点？");
		String r398 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(r398).as("test data").contains("略过");
		String r399 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(r399).as("test data").contains("不适用");
		//1.16
		String r454= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r454).as("test data").contains("1.16 事件是与组长监督管理不当有关？");
		String r455 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(r455).as("test data").contains("略过");
		String r456 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r456).as("test data").contains("不适用");
		//1.17
		String r487= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r487).as("test data").contains("1.17 事件是与经理管理不当有关？");
		String r488 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(r488).as("test data").contains("略过");
		String r489 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r489).as("test data").contains("不适用");
		//1.18
		String r555= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r555).as("test data").contains("1.18 事件是因程序规则有误导致？");
		String r556 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(r556).as("test data").contains("略过");
		String r557 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r557).as("test data").contains("不适用");
		//1.19
		String r579= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r579).as("test data").contains("1.19 是否有类似事件重发的趋势？");
		String r580 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[2]"))).getText();
		softly.assertThat(r580).as("test data").contains("略过");
		String r581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(r581).as("test data").contains("不适用");
		//1.20
		String r600= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r600).as("test data").contains("1.20 错误是否与工作时发生改变有关？");
		String r601 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[2]"))).getText();
		softly.assertThat(r601).as("test data").contains("略过");
		String r602 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[6]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r602).as("test data").contains("不适用");

		//Table 7
		hc8.chineseTable7ReportTab(driver,softly);

		//SUEP title
		hc8.chineseSUEPFullFormReportTab(driver,softly);

		//SUEP table rows
		String r636 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r636).as("test data").contains("3.16.1 疲倦: (1) 大约上午3-4点; (2) 大约下午2-3点; (3) 长时间工作后");
		String r637 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r637).as("test data").contains("3.16.2 注意力不集中（分心）: (1) 同时执行多个任务; (2) 被打断; (3) 有心事");
		String r638 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r638).as("test data").contains("3.16.3 过度自信: (1) 首次执行的操作(FTE)，而没有寻求充分帮助；(2) 日常工作，而没有注意到微小变化和新情况；(3) 繁琐任务未定期自检 (如数据输入)；(4) 使用信息数据未审核且核实 (5) 不识别单项弱点也不自检单项弱点；(6) 按记忆中（印象中）的程序作业（未持程序作业）");
		String r640 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r640).as("test data").contains("3.16.4 时间压力: 急着完工");
		String r641 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r641).as("test data").contains("3.16.5 注意不足: 1.长时间工作而没有休息(> 140分钟); 2. 早上10点时做事; 3. 工作超过10小时");
		String r642 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r642).as("test data").contains("3.16.6 学习技能时相关规定有误");
		String r643 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[8]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r643).as("test data").contains("3.16.7 判断出错未能选择正确技能使用");

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
