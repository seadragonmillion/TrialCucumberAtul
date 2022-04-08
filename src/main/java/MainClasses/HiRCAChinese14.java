import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAChinese14 {

	public List<String> chineseHTMLReport5thPath (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List <String> verifyChinese = new ArrayList<String>();
		//Table3 row
		String r1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1a).as("test data").contains("不适用");
		verifyChinese.add(r1a);
		String r2a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r2a).as("test data").contains("不适用");
		String r3a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r3a).as("test data").contains("不适用");
		//Table4 rows
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1).as("test data").contains("3.16.1 疲倦: (1) 大约上午3-4点; (2) 大约下午2-3点; (3) 长时间工作后");
		verifyChinese.add(r1);
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r2).as("test data").contains("休息时间管理,");
		softly.assertThat(r2).as("test data").contains("行为培训 (");
		verifyChinese.add("休息时间管理,");
		verifyChinese.add("行为培训");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r3).as("test data").contains("3.16.2 注意力不集中（分心）: (1) 同时执行多个任务; (2) 被打断; (3) 有心事");
		verifyChinese.add(r3);
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r4).as("test data").contains("行为培训");
		verifyChinese.add(r4);
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r5).as("test data").contains("3.16.3 过度自信: (1) 首次执行的操作(FTE)，而没有寻求充分帮助；(2) 日常工作，而没有注意到微小变化和新情况；(3) 繁琐任务未定期自检 (如数据输入)；(4) 使用信息数据未审核且核实 (5) 不识别单项弱点也不自检单项弱点；(6) 按记忆中（印象中）的程序作业（未持程序作业）");
		verifyChinese.add(r5);
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r6).as("test data").contains("在工前会、班前会和交底会讨论单项弱点和首次作业,");
		softly.assertThat(r6).as("test data").contains("行为培训");
		verifyChinese.add(r6);
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r7).as("test data").contains("3.16.4 时间压力: 急着完工");
		verifyChinese.add(r7);
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r8).as("test data").contains("行为培训, 改善排程和计划系统");
		verifyChinese.add(r8);
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r9).as("test data").contains("3.16.5 注意不足: 1.长时间工作而没有休息(> 140分钟); 2. 早上10点时做事; 3. 工作超过10小时");
		verifyChinese.add(r9);
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r10).as("test data").contains("中间适当休息, 最大程度减少干扰");
		verifyChinese.add(r10);
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r11).as("test data").contains("3.16.6 学习技能时相关规定有误");
		verifyChinese.add(r11);
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r12).as("test data").contains("学习正确所需技能");
		verifyChinese.add(r12);
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r13).as("test data").contains("3.16.7 判断出错未能选择正确技能使用");
		verifyChinese.add(r13);
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r14).as("test data").contains("培训技能的选择, 透过强化规定减少选择错误的机会");
		verifyChinese.add(r14);

		//Table 6 Header
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading).as("test data").contains("调查问题");
		verifyChinese.add(heading);
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading1).as("test data").contains("答案");
		verifyChinese.add(heading1);
		String heading2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading2).as("test data").contains("选择原因");
		verifyChinese.add(heading2);
		//Table 6 Rows
		//1.1
		String r139 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r139).as("test data").contains("1.1 始发事件为人因、设备失效还是天灾？");
		verifyChinese.add(r139);
		String r140 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r140).as("test data").contains("人因");
		verifyChinese.add(r140);
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r141).as("test data").contains("不适用");
		//1.2
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r142).as("test data").contains("1.2 始发事件的错误类型为何？");
		verifyChinese.add(r142);
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r143).as("test data").contains("规则型错误");
		verifyChinese.add(r143);
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r144).as("test data").contains("不适用");
		//1.3
		String r67 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r67).as("test data").contains("1.3 若为规则型错误，是否为有意违规还是无意违规？");
		verifyChinese.add(r67);
		String r68 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r68).as("test data").contains("无意违规");
		verifyChinese.add(r68);
		String r69 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r69).as("test data").contains("不适用");
		//1.4
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r194).as("test data").contains("1.4 此无意违规是粗心导致还是程序不当导致？");
		verifyChinese.add(r194);
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r195).as("test data").contains("粗心犯错");
		verifyChinese.add(r195);
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r196).as("test data").contains("不适用");
		//3.16 table heading
		String heading3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading3).as("test data").contains("可能促成因素");
		verifyChinese.add(heading3);
		String heading4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading4).as("test data").contains("支持证据");
		verifyChinese.add(heading4);
		String heading5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading5).as("test data").contains("进一步调查");
		verifyChinese.add(heading5);
		String heading6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/thead/tr/th[4]"))).getText();
		softly.assertThat(heading6).as("test data").contains("可能的纠正行动");
		verifyChinese.add(heading6);
		//3.16 table rows
		String r145 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r145).as("test data").contains("3.16.1 疲倦: (1) 大约上午3-4点; (2) 大约下午2-3点; (3) 长时间工作后");
		verifyChinese.add(r145);
		String r146 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r146).as("test data").contains("不适用");
		String r147 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[3]/ul/li"))).getText();
		softly.assertThat(r147).as("test data").contains("查阅以往事件？");
		verifyChinese.add(r147);
		String r148 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r148).as("test data").contains("休息时间管理");
		String r70 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[1]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r70).as("test data").contains("行为培训 (");
		String r149 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r149).as("test data").contains("3.16.2 注意力不集中（分心）: (1) 同时执行多个任务; (2) 被打断; (3) 有心事");
		verifyChinese.add(r149);
		String r150 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r150).as("test data").contains("不适用");
		String r151 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r151).as("test data").contains("访谈犯错者？");
		verifyChinese.add(r151);
		String r72 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r72).as("test data").contains("访谈同事？");
		verifyChinese.add(r72);
		String r152 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[2]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r152).as("test data").contains("行为培训");
		verifyChinese.add(r152);
		String r153 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r153).as("test data").contains("3.16.3 过度自信: (1) 首次执行的操作(FTE)，而没有寻求充分帮助；(2) 日常工作，而没有注意到微小变化和新情况；(3) 繁琐任务未定期自检 (如数据输入)；(4) 使用信息数据未审核且核实 (5) 不识别单项弱点也不自检单项弱点；(6) 按记忆中（印象中）的程序作业（未持程序作业）");
		verifyChinese.add(r153);
		String r154 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r154).as("test data").contains("不适用");
		String r155 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[3]/ul/li"))).getText();
		softly.assertThat(r155).as("test data").contains("访谈犯错者？");
		verifyChinese.add(r155);
		String r156 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r156).as("test data").contains("在工前会、班前会和交底会讨论单项弱点和首次作业");
		verifyChinese.add(r156);
		String r91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[3]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r91).as("test data").contains("行为培训");
		verifyChinese.add(r91);
		String r157 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r157).as("test data").contains("3.16.4 时间压力: 急着完工");
		verifyChinese.add(r157);
		String r158 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r158).as("test data").contains("不适用");
		String r159 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r159).as("test data").contains("现场观察？");
		verifyChinese.add(r159);
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r15).as("test data").contains("访谈同事？");
		verifyChinese.add(r15);
		String r161 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r161).as("test data").contains("行为培训");
		verifyChinese.add(r161);
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[4]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r16).as("test data").contains("改善排程和计划系统");
		verifyChinese.add(r16);
		String r162 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r162).as("test data").contains("3.16.5 注意不足: 1.长时间工作而没有休息(> 140分钟); 2. 早上10点时做事; 3. 工作超过10小时");
		verifyChinese.add(r162);
		String r163 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r163).as("test data").contains("不适用");
		String r164 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r164).as("test data").contains("现场观察？");
		verifyChinese.add(r164);
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[3]/ul/li[2]"))).getText();
		softly.assertThat(r17).as("test data").contains("访谈同事？");
		verifyChinese.add(r17);
		String r165 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r165).as("test data").contains("中间适当休息");
		verifyChinese.add(r165);
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[5]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r18).as("test data").contains("最大程度减少干扰");
		verifyChinese.add(r18);
		String r166 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r166).as("test data").contains("3.16.6 学习技能时相关规定有误");
		verifyChinese.add(r166);
		String r167 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r167).as("test data").contains("不适用");
		String r168 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[3]/ul/li[1]"))).getText();
		softly.assertThat(r168).as("test data").contains("审查技能相关规定");
		verifyChinese.add(r168);
		String r170 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[6]/td[4]/ul/li"))).getText();
		softly.assertThat(r170).as("test data").contains("学习正确所需技能");
		verifyChinese.add(r170);
		String r171 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r171).as("test data").contains("3.16.7 判断出错未能选择正确技能使用");
		verifyChinese.add(r171);
		String r172 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r172).as("test data").contains("不适用");
		String r173 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[3]/ul/li"))).getText();
		softly.assertThat(r173).as("test data").contains("访谈犯错人");
		verifyChinese.add(r173);
		String r176 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[1]"))).getText();
		softly.assertThat(r176).as("test data").contains("培训技能的选择");
		verifyChinese.add(r176);
		String r74 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]/div/table/tbody/tr[7]/td[4]/ul/li[2]"))).getText();
		softly.assertThat(r74).as("test data").contains("透过强化规定减少选择错误的机会");
		verifyChinese.add(r74);
		//1.5
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r197).as("test data").contains("1.5 若我是犯错者，我是否会犯同样的错？");
		verifyChinese.add(r197);
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r198).as("test data").contains("略过");
		verifyChinese.add(r198);
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r199).as("test data").contains("不适用");
		//1.6
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r200).as("test data").contains("1.6 犯错者违规时是否有旁人观看？");
		verifyChinese.add(r200);
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r201).as("test data").contains("略过");
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r202).as("test data").contains("不适用");
		//1.7
		String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r222).as("test data").contains("1.7 这个错误是否可以透过自检或独立检查避免？");
		verifyChinese.add(r222);
		String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r223).as("test data").contains("略过");
		String r224 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r224).as("test data").contains("不适用");
		//1.8
		String r225 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r225).as("test data").contains("1.8 犯错人员是否受过培训知道如何管理易出错精神状态和高风险？");
		verifyChinese.add(r225);
		String r226 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r226).as("test data").contains("略过");
		String r227 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r227).as("test data").contains("不适用");
		//1.9
		String r312 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r312).as("test data").contains("1.9 犯错者在事后是否有经组长或管理层问责？");
		verifyChinese.add(r312);
		String r313 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r313).as("test data").contains("略过");
		String r314 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r314).as("test data").contains("不适用");		
		//1.10
		String r377 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r377).as("test data").contains("1.10 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		verifyChinese.add(r377);
		String r378 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r378).as("test data").contains("略过");
		String r379 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r379).as("test data").contains("不适用");
		//1.11
		String r380 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r380).as("test data").contains("1.11 这个错为何是现在发生而不是以前发生？");
		verifyChinese.add(r380);
		String r381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r381).as("test data").contains("略过");
		String r382 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r382).as("test data").contains("不适用");
		//1.12
		String r3801 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r3801).as("test data").contains("1.12 若班前会、工前会或交底会未执行，为什么？");
		verifyChinese.add(r3801);
		String r3811 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r3811).as("test data").contains("略过");
		String r3821 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r3821).as("test data").contains("不适用");
		//1.13
		String r38011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r38011).as("test data").contains("1.13 错误的发生是否存在易出错精神状态或是高风险状态？");
		verifyChinese.add(r38011);
		String r38111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r38111).as("test data").contains("略过");
		String r384 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r384).as("test data").contains("不适用");
		//1.14
		String r385= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r385).as("test data").contains("1.14 组长是否固定开展经验反馈？");
		verifyChinese.add(r385);
		String r386 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r386).as("test data").contains("略过");
		String r387 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r387).as("test data").contains("不适用");
		//1.15
		String r397= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r397).as("test data").contains("1.15 始发事件是否有单项弱点？");
		verifyChinese.add(r397);
		String r398 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(r398).as("test data").contains("略过");
		String r399 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(r399).as("test data").contains("不适用");
		//1.16
		String r454= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r454).as("test data").contains("1.16 事件是与组长监督管理不当有关？");
		verifyChinese.add(r454);
		String r455 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(r455).as("test data").contains("略过");
		String r456 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r456).as("test data").contains("不适用");
		//1.17
		String r487= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r487).as("test data").contains("1.17 事件是与经理管理不当有关？");
		verifyChinese.add(r487);
		String r488 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(r488).as("test data").contains("略过");
		String r489 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r489).as("test data").contains("不适用");
		//1.18
		String r555= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r555).as("test data").contains("1.18 事件是因程序规则有误导致？");
		verifyChinese.add(r555);
		String r556 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(r556).as("test data").contains("略过");
		String r557 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r557).as("test data").contains("不适用");
		//1.19
		String r579= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r579).as("test data").contains("1.19 是否有类似事件重发的趋势？");
		verifyChinese.add(r579);
		String r580 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[2]"))).getText();
		softly.assertThat(r580).as("test data").contains("略过");
		String r581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(r581).as("test data").contains("不适用");
		//1.20
		String r600= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r600).as("test data").contains("1.20 错误是否与工作时发生改变有关？");
		verifyChinese.add(r600);
		String r601 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[21]/td[2]"))).getText();
		softly.assertThat(r601).as("test data").contains("略过");
		String r602 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r602).as("test data").contains("不适用");

		//Table 7
		//Table 7 title
		String r621 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/div"))).getText();
		softly.assertThat(r621).as("test data").contains("失效屏障分析过程");

		//Table 7 headings
		String heading461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading461).as("test data").contains("调查问题");
		String heading47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading47).as("test data").contains("答案");
		String heading48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading48).as("test data").contains("选择原因");
		//Table 7 rows
		String r622 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r622).as("test data").contains("屏障是否存在能预防始发事件的发生？");
		String r623 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r623).as("test data").contains("不适用");
		String r624 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r624).as("test data").contains("不适用");
		String r625 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r625).as("test data").contains("2.21 哪些屏障可以预防此事件？");
		String r626 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r626).as("test data").contains("不适用");
		String r627 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r627).as("test data").contains("不适用");
		String r628 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r628).as("test data").contains("是否完善引导你进行人因事件分析？");
		String r629 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r629).as("test data").contains("不适用");
		String r630 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r630).as("test data").contains("不适用");	

		//SUEP titles
		String r631 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/div[1]"))).getText();
		softly.assertThat(r631).as("test data").contains("根本原因确认分析（SUEP）");
		String r632 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/div[2]"))).getText();
		softly.assertThat(r632).as("test data").contains(": 是否存在不合标准的实践?");
		String r633 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/div[3]"))).getText();
		softly.assertThat(r633).as("test data").contains(": 是否在管理层控制下?");
		String r634 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/div[4]"))).getText();
		softly.assertThat(r634).as("test data").contains(": 是否在事件时序早期?");
		String r635 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/div[5]"))).getText();
		softly.assertThat(r635).as("test data").contains(": 是否防止再次发生?");
		//SUEP table heading
		String heading49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading49).as("test data").contains("促成因素");

		//SUEP table rows
		String r636 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r636).as("test data").contains("3.16.1 疲倦: (1) 大约上午3-4点; (2) 大约下午2-3点; (3) 长时间工作后");
		String r637 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r637).as("test data").contains("3.16.2 注意力不集中（分心）: (1) 同时执行多个任务; (2) 被打断; (3) 有心事");
		String r638 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r638).as("test data").contains("3.16.3 过度自信: (1) 首次执行的操作(FTE)，而没有寻求充分帮助；(2) 日常工作，而没有注意到微小变化和新情况；(3) 繁琐任务未定期自检 (如数据输入)；(4) 使用信息数据未审核且核实 (5) 不识别单项弱点也不自检单项弱点；(6) 按记忆中（印象中）的程序作业（未持程序作业）");
		String r640 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r640).as("test data").contains("3.16.4 时间压力: 急着完工");
		String r641 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r641).as("test data").contains("3.16.5 注意不足: 1.长时间工作而没有休息(> 140分钟); 2. 早上10点时做事; 3. 工作超过10小时");
		String r642 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r642).as("test data").contains("3.16.6 学习技能时相关规定有误");
		String r643 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r643).as("test data").contains("3.16.7 判断出错未能选择正确技能使用");

		//HiRCA self checklist chinese, none selected
		//Title
		String title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]"))).getText();
		softly.assertThat(title2).as("test data").contains("自检清单");
		//Heading
		String heading50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading50).as("test data").contains("类别");
		String heading51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading51).as("test data").contains("调查内容");
		String heading52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading52).as("test data").contains("完成打勾?");
		//Row
		String r700 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r700).as("test data").contains("不适用");
		String r701 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r701).as("test data").contains("不适用");
		String r702 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[10]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r702).as("test data").contains("不适用");

		//Last Table
		//last table with reviewed by etc rows
		//title
		String title3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]"))).getText();
		softly.assertThat(title3).as("test data").contains("签字");
		//Rows
		String r703 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[12]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r703).as("test data").contains("编写");
		String r704 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[12]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r704).as("test data").contains("日期");
		String r705 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[12]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r705).as("test data").contains("审查");
		String r706 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[12]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r706).as("test data").contains("日期");
		String r707 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[12]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r707).as("test data").contains("批准");
		String r708 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[12]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r708).as("test data").contains("日期");

		return verifyChinese;
	}
}
