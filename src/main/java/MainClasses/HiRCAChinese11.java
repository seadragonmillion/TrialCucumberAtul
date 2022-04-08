import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAChinese11 {

	public void chineseLevel3SelectionsSUEP4th(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify all selections here
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(tr).as("test data").isEqualTo("3.1.1 能力不足");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(tr1).as("test data").isEqualTo("3.1.2 态度和任务不匹配");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(tr2).as("test data").isEqualTo("3.1.3 性格和任务不匹配");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(tr3).as("test data").isEqualTo("3.1.4 缺乏专业经验");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(tr4).as("test data").isEqualTo("3.1.5 对自我缺点认识不足，缺乏相应弥补措施");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(tr5).as("test data").isEqualTo("3.1.6 不适合工作（生病、有心事等）");
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(tr6).as("test data").isEqualTo("3.12.1 觉得获取工具和设备有负担");
		String tr7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(tr7).as("test data").isEqualTo("3.12.2 觉得获取文件或程序有负担");
		String tr8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(tr8).as("test data").isEqualTo("3.12.3 觉得获取和穿戴PPE有负担");
		String tr9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(tr9).as("test data").isEqualTo("3.12.4 觉得使用过于复杂或繁琐的程序有负担");
		String tr10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[22]/td[1]"))).getText();
		softly.assertThat(tr10).as("test data").isEqualTo("3.12.5 因觉得负担麻烦未到现场核实");
		String tr11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[24]/td[1]"))).getText();
		softly.assertThat(tr11).as("test data").isEqualTo("3.13.1 尽早完成工作，以便尽早回家");
		String tr12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[26]/td[1]"))).getText();
		softly.assertThat(tr12).as("test data").isEqualTo("3.13.2 尽早完成工作，以便获得奖励或免受惩罚");
		String tr13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[28]/td[1]"))).getText();
		softly.assertThat(tr13).as("test data").isEqualTo("3.13.3 尽早完成工作，以便开始其他工作（尤其是根据完成的工作量计算价钱的承包商）");
		String tr14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[30]/td[1]"))).getText();
		softly.assertThat(tr14).as("test data").isEqualTo("3.13.4 尽早完成工作，以便到更为舒适的环境中休息（尤其是在高温、有辐射或潮湿环境下工作）");
		String tr15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[32]/td[1]"))).getText();
		softly.assertThat(tr15).as("test data").isEqualTo("3.14.1 观察主管向下属提供反馈的频率和质量");
		String tr16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[34]/td[1]"))).getText();
		softly.assertThat(tr16).as("test data").isEqualTo("3.14.2 违反既定规定的情况不容易被知道（尤其是单独工作时）");
		String tr17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[36]/td[1]"))).getText();
		softly.assertThat(tr17).as("test data").isEqualTo("3.14.3 由于缺乏明确的问责制，认为违规的后果不严重");
		String tr18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[38]/td[1]"))).getText();
		softly.assertThat(tr18).as("test data").isEqualTo("3.14.4 违规造成的受伤风险被认为很低或没有");
		String tr19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[40]/td[1]"))).getText();
		softly.assertThat(tr19).as("test data").isEqualTo("3.14.5 由于有监护人在场，预期风险更低");
		String tr20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[42]/td[1]"))).getText();
		softly.assertThat(tr20).as("test data").isEqualTo("3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训");
		String tr21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[44]/td[1]"))).getText();
		softly.assertThat(tr21).as("test data").isEqualTo("3.15.2 未要求员工对纠正他人违规的情况承担责任");
		String tr22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[46]/td[1]"))).getText();
		softly.assertThat(tr22).as("test data").isEqualTo("3.15.3 员工未充分理解相关行为规范");
		String tr23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[48]/td[1]"))).getText();
		softly.assertThat(tr23).as("test data").contains("3.15.4 主管未到现场强化");
		softly.assertThat(tr23).as("test data").contains("同事指导");
		String tr24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[50]/td[1]"))).getText();
		softly.assertThat(tr24).as("test data").isEqualTo("3.21.1 未能识别和缓解时间相关的高风险情况，例如日常失误陷阱、工作时间、节假日影响等");
		String tr25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[52]/td[1]"))).getText();
		softly.assertThat(tr25).as("test data").isEqualTo("3.21.2 未能识别和缓解活动相关的高风险情况，例如伪装的首次执行操作、利益失衡、单项弱点失去管理、专门技能缺陷等等");
		String tr26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[54]/td[1]"))).getText();
		softly.assertThat(tr26).as("test data").isEqualTo("3.21.3 未能识别和缓解人员相关的高风险情况，例如能力、态度、性格、与人打交道的经验存在不足");
		String tr27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[56]/td[1]"))).getText();
		softly.assertThat(tr27).as("test data").isEqualTo("3.21.4 未能识别和缓解环境相关的高风险情况，例如工作条件恶劣（温度、照明、噪音、高辐射水平等等）以及人机接口（标牌、显示屏、控制器等）");
	}

	public void chineseLevel3SelectionsSUEP6th(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//Verify all selections here
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(tr).as("test data").isEqualTo("3.6.1 要求有遗漏");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(tr1).as("test data").isEqualTo("3.6.2 运行条件有遗漏");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(tr2).as("test data").isEqualTo("3.6.3 假设有遗漏");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(tr3).as("test data").isEqualTo("3.6.4 范围有遗漏");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(tr4).as("test data").isEqualTo("3.6.5 试验或测量有遗漏");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(tr5).as("test data").isEqualTo("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用\"不准做清单\"体现; (5) 参考资料; (6) 要求使用者反馈");
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(tr6).as("test data").isEqualTo("3.6.7 审查不到位导致制度有遗漏项");
		String tr7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(tr7).as("test data").isEqualTo("3.6.8 根本原因分析不到位导致制度有遗漏项");
		String tr8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(tr8).as("test data").isEqualTo("3.6.9 纠正措施执行不到位导致制度有遗漏项");
		String tr9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(tr9).as("test data").isEqualTo("3.7.1 进入和退出程序指引不到位");
		String tr10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[22]/td[1]"))).getText();
		softly.assertThat(tr10).as("test data").isEqualTo("3.7.2 对于单项弱点步骤未设置自检或是独立检查");
		String tr11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[24]/td[1]"))).getText();
		softly.assertThat(tr11).as("test data").isEqualTo("3.7.3 未识别出不可逆点(PNR)的操作步骤（予以审查），从而确保继续操作前先前的失误得到纠正");
		String tr12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[26]/td[1]"))).getText();
		softly.assertThat(tr12).as("test data").isEqualTo("3.7.4 未使用操作标记法来防止跳步或跳页");
		String tr13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[28]/td[1]"))).getText();
		softly.assertThat(tr13).as("test data").isEqualTo("3.7.5 未分析并缓解很有可能出现违章的情况（通过迹象核实、复核、禁止操作警告等方式）");
		String tr14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[30]/td[1]"))).getText();
		softly.assertThat(tr14).as("test data").isEqualTo("3.7.6 例行作业未有充分的及时提醒标牌预防粗心犯错");
		String tr15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[32]/td[1]"))).getText();
		softly.assertThat(tr15).as("test data").isEqualTo("3.7.7 未使用清单预防遗忘相关错误");
		String tr16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[34]/td[1]"))).getText();
		softly.assertThat(tr16).as("test data").isEqualTo("3.7.8 同事指导的好文化不到位，未能鼓励和强调守规行为标准");
		String tr17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[36]/td[1]"))).getText();
		softly.assertThat(tr17).as("test data").isEqualTo("3.7.9 审查不到位");
		String tr18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[38]/td[1]"))).getText();
		if(browserName.contains("safari"))
		{
			softly.assertThat(tr18).as("test data").contains("3.7.10 维修不到位:");
			softly.assertThat(tr18).as("test data").contains("(1) 预见性维修不到位 ");
			softly.assertThat(tr18).as("test data").contains("(2) 预防性维修不到位 ");
			softly.assertThat(tr18).as("test data").contains("3) 纠正性维修不到位 ");
			softly.assertThat(tr18).as("test data").contains("(4) 修后试验不到位 ");
			softly.assertThat(tr18).as("test data").contains("(5) 故障查找和根本原因分析不到位 ");
			softly.assertThat(tr18).as("test data").contains("(6) 维修失误");
		}
		else
			softly.assertThat(tr18).as("test data").isEqualTo("3.7.10 维修不到位: (1) 预见性维修不到位 (2) 预防性维修不到位 3) 纠正性维修不到位 (4) 修后试验不到位 (5) 故障查找和根本原因分析不到位 (6) 维修失误");
		String tr19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[40]/td[1]"))).getText();
		softly.assertThat(tr19).as("test data").isEqualTo("3.8.1 规则编写人经验不足，使用了模糊的或需自行判断的字词（例如，\"根据情况\"、\"根据需要\"、\"必要时\"等等）");
		String tr20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[42]/td[1]"))).getText();
		softly.assertThat(tr20).as("test data").isEqualTo("3.8.2 使用了不可定量的或需自行判断的条件（例如，检查\"足够多的\"样品）来避免内部QA审查");
		String tr21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[44]/td[1]"))).getText();
		softly.assertThat(tr21).as("test data").isEqualTo("3.8.3 要求判断执行程序步骤");
		String tr22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[46]/td[1]"))).getText();
		softly.assertThat(tr22).as("test data").isEqualTo("3.8.4 没有明确与其他程序之间的接口");
		String tr23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[48]/td[1]"))).getText();
		softly.assertThat(tr23).as("test data").contains("3.8.5 可读性不高（即：高于八年级阅读水平）");
		String tr24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[50]/td[1]"))).getText();
		softly.assertThat(tr24).as("test data").isEqualTo("3.8.6 程序里和设备上出现不明确和不一致的设备标识与识别");
		String tr25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[52]/td[1]"))).getText();
		softly.assertThat(tr25).as("test data").isEqualTo("3.8.7 时间敏感步骤未明确写出");
		String tr26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[54]/td[1]"))).getText();
		softly.assertThat(tr26).as("test data").isEqualTo("3.8.8 程序未明确量化，使用描述如：稳定、异常");
		String tr27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[56]/td[1]"))).getText();
		softly.assertThat(tr27).as("test data").contains("3.18.1 盲目信任: 关键信息使用质疑的态度");
		softly.assertThat(tr27).as("test data").contains("不到位");
		String tr241 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[58]/td[1]"))).getText();
		softly.assertThat(tr241).as("test data").isEqualTo("3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生");
		String tr251 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[60]/td[1]"))).getText();
		softly.assertThat(tr251).as("test data").isEqualTo("3.18.3 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障");
		String tr261 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[62]/td[1]"))).getText();
		softly.assertThat(tr261).as("test data").isEqualTo("3.18.4 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果");
		String tr271 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[64]/td[1]"))).getText();
		softly.assertThat(tr271).as("test data").contains("3.18.5 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析");
	}

	public void chineseLevel3SelectionsSUEP5th(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify all selections here
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(tr).as("test data").isEqualTo("3.16.1 疲倦: (1) 大约上午3-4点; (2) 大约下午2-3点; (3) 长时间工作后");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(tr1).as("test data").isEqualTo("3.16.2 注意力不集中（分心）: (1) 同时执行多个任务; (2) 被打断; (3) 有心事");
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(tr2).as("test data").isEqualTo("3.16.3 过度自信: (1) 首次执行的操作(FTE)，而没有寻求充分帮助；(2) 日常工作，而没有注意到微小变化和新情况；(3) 繁琐任务未定期自检 (如数据输入)；(4) 使用信息数据未审核且核实 (5) 不识别单项弱点也不自检单项弱点；(6) 按记忆中（印象中）的程序作业（未持程序作业）");
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(tr3).as("test data").isEqualTo("3.16.4 时间压力: 急着完工");
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(tr4).as("test data").isEqualTo("3.16.5 注意不足: 1.长时间工作而没有休息(> 140分钟); 2. 早上10点时做事; 3. 工作超过10小时");
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(tr5).as("test data").isEqualTo("3.16.6 学习技能时相关规定有误");
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(tr6).as("test data").isEqualTo("3.16.7 判断出错未能选择正确技能使用");
	}
	
	public void chineseLevel3SelectionsSUEP1st(WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify all selections here
		String tr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]"))).getText();
		System.out.println(tr);
		softly.assertThat(tr).as("test data").isEqualTo("3.2.1 组长强化标准方面的管理能力不足");
		String tr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[1]"))).getText();
		System.out.println(tr1);
		softly.assertThat(tr1).as("test data").isEqualTo("3.2.1 组长强化标准方面的管理能力不足");//"3.2.2 组长绩效反馈方面的管理能力不足"
		String tr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[1]"))).getText();
		System.out.println(tr2);
		softly.assertThat(tr2).as("test data").isEqualTo("3.2.1 组长强化标准方面的管理能力不足");//"3.2.3 组长召开经验反馈的管理技能不足"
		String tr3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]"))).getText();
		System.out.println(tr3);
		softly.assertThat(tr3).as("test data").isEqualTo("3.2.2 组长绩效反馈方面的管理能力不足");//"3.2.4 组长在岗培训方面管理能力不足"
		String tr4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[1]"))).getText();
		System.out.println(tr4);
		softly.assertThat(tr4).as("test data").isEqualTo("3.2.2 组长绩效反馈方面的管理能力不足");//"3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施"
		String tr5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[1]"))).getText();
		System.out.println(tr5);
		softly.assertThat(tr5).as("test data").isEqualTo("3.2.2 组长绩效反馈方面的管理能力不足");//"3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足"
		String tr6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[14]/td[1]"))).getText();
		System.out.println(tr6);
		softly.assertThat(tr6).as("test data").isEqualTo("3.2.3 组长召开经验反馈的管理技能不足");//"3.3.1 经理团队资源分配不到位"
		String tr7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[16]/td[1]"))).getText();
		System.out.println(tr7);
		softly.assertThat(tr7).as("test data").isEqualTo("3.2.3 组长召开经验反馈的管理技能不足");//"3.3.2 经理团队所需培训开展不充分"
		String tr8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[18]/td[1]"))).getText();
		System.out.println(tr8);
		softly.assertThat(tr8).as("test data").isEqualTo("3.2.3 组长召开经验反馈的管理技能不足");//"3.3.3 经理团队问责制不到位"
		String tr9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[20]/td[1]"))).getText();
		System.out.println(tr9);
		softly.assertThat(tr9).as("test data").isEqualTo("3.2.4 组长在岗培训方面管理能力不足");//"3.3.4 经理团队对确定工作优先级和计划方面不到位"
		String tr10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[22]/td[1]"))).getText();
		System.out.println(tr10);
		softly.assertThat(tr10).as("test data").isEqualTo("3.2.4 组长在岗培训方面管理能力不足");//"3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障"
		String tr11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[24]/td[1]"))).getText();
		System.out.println(tr11);
		softly.assertThat(tr11).as("test data").isEqualTo("3.2.4 组长在岗培训方面管理能力不足");//"3.3.6 经理团队绩效跟踪与趋势分析不到位"
		String tr12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[26]/td[1]"))).getText();
		System.out.println(tr12);
		softly.assertThat(tr12).as("test data").isEqualTo("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");//"3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任"
		String tr13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[28]/td[1]"))).getText();
		System.out.println(tr13);
		softly.assertThat(tr13).as("test data").isEqualTo("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");//"3.3.8 经理团队纠正行动不足"
		String tr14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[30]/td[1]"))).getText();
		System.out.println(tr14);
		softly.assertThat(tr14).as("test data").isEqualTo("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");//"3.3.9 经理团队垂直沟通体系不完善"
		String tr15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[32]/td[1]"))).getText();
		System.out.println(tr15);
		softly.assertThat(tr15).as("test data").isEqualTo("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");//"3.3.10 经理团队横向沟通体系不完善"
		String tr16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[34]/td[1]"))).getText();
		System.out.println(tr16);
		softly.assertThat(tr16).as("test data").isEqualTo("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");//"3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）"
		String tr17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[36]/td[1]"))).getText();
		System.out.println(tr17);
		softly.assertThat(tr17).as("test data").isEqualTo("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");//"3.4.2 采取行动前没有考虑易出错的心理状况"
		String tr18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[38]/td[1]"))).getText();
		System.out.println(tr18);
		softly.assertThat(tr18).as("test data").isEqualTo("3.3.1 经理团队资源分配不到位");//"3.4.3 采取行动前没有考虑高风险情境（如单项弱点）"
		String tr19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[40]/td[1]"))).getText();
		System.out.println(tr19);
		softly.assertThat(tr19).as("test data").isEqualTo("3.3.1 经理团队资源分配不到位");//"3.4.4 感到疑惑时质疑不充分"
		String tr20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[42]/td[1]"))).getText();
		System.out.println(tr20);
		softly.assertThat(tr20).as("test data").isEqualTo("3.3.2 经理团队所需培训开展不充分");//"3.4.5 任务准备过程中质疑不充分"
		String tr21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[44]/td[1]"))).getText();
		System.out.println(tr21);
		softly.assertThat(tr21).as("test data").isEqualTo("3.3.2 经理团队所需培训开展不充分");//"3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分"
		String tr22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[46]/td[1]"))).getText();
		System.out.println(tr22);
		softly.assertThat(tr22).as("test data").isEqualTo("3.3.3 经理团队问责制不到位");//"3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分"
		String tr23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[48]/td[1]"))).getText();
		System.out.println(tr23);
		softly.assertThat(tr23).as("test data").isEqualTo("3.3.3 经理团队问责制不到位");//"3.5.3 对人员表现的观察技能不足"
		String tr24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[50]/td[1]"))).getText();
		System.out.println(tr24);
		softly.assertThat(tr24).as("test data").isEqualTo("3.3.4 经理团队对确定工作优先级和计划方面不到位");//"3.5.4 对设备性能的观察技能不足"
		String tr25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[52]/td[1]"))).getText();
		System.out.println(tr25);
		softly.assertThat(tr25).as("test data").isEqualTo("3.3.4 经理团队对确定工作优先级和计划方面不到位");//"3.6.1 要求有遗漏"
		String tr26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[54]/td[1]"))).getText();
		System.out.println(tr26);
		softly.assertThat(tr26).as("test data").isEqualTo("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");//"3.6.2 运行条件有遗漏"
		String tr27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[56]/td[1]"))).getText();
		System.out.println(tr27);
		softly.assertThat(tr27).as("test data").isEqualTo("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");//"3.6.3 假设有遗漏"
		String tr28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[58]/td[1]"))).getText();
		System.out.println(tr28);
		softly.assertThat(tr28).as("test data").isEqualTo("3.3.6 经理团队绩效跟踪与趋势分析不到位");//"3.6.4 范围有遗漏"
		String tr29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[60]/td[1]"))).getText();
		System.out.println(tr29);
		softly.assertThat(tr29).as("test data").isEqualTo("3.3.6 经理团队绩效跟踪与趋势分析不到位");//"3.6.5 试验或测量有遗漏"
		String tr30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[62]/td[1]"))).getText();
		System.out.println(tr30);
		softly.assertThat(tr30).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");//"3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用"
	//	softly.assertThat(tr30).as("test data").contains("不准做清单");
	//	softly.assertThat(tr30).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		String tr31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[64]/td[1]"))).getText();
		System.out.println(tr31);
		softly.assertThat(tr31).as("test data").isEqualTo("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");//"3.6.7 审查不到位导致制度有遗漏项"
		String tr32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[66]/td[1]"))).getText();
		System.out.println(tr32);
		softly.assertThat(tr32).as("test data").isEqualTo("3.3.8 经理团队纠正行动不足");//"3.6.8 根本原因分析不到位导致制度有遗漏项"
		String tr33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[68]/td[1]"))).getText();
		System.out.println(tr33);
		softly.assertThat(tr33).as("test data").isEqualTo("3.3.8 经理团队纠正行动不足");//"3.6.9 纠正措施执行不到位导致制度有遗漏项"
		String tr34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[70]/td[1]"))).getText();
		System.out.println(tr34);
		softly.assertThat(tr34).as("test data").isEqualTo("3.3.9 经理团队垂直沟通体系不完善");//"3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺"
		String tr35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[72]/td[1]"))).getText();
		System.out.println(tr35);
		softly.assertThat(tr35).as("test data").isEqualTo("3.3.9 经理团队垂直沟通体系不完善");//"3.9.2 复训频率不高(>> 一年)"
		String tr36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[74]/td[1]"))).getText();
		System.out.println(tr36);
		softly.assertThat(tr36).as("test data").isEqualTo("3.3.10 经理团队横向沟通体系不完善");//"3.9.3 部门管理层未充分参与培训材料的编写和培训的实施"
		String tr37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[76]/td[1]"))).getText();
		System.out.println(tr37);
		softly.assertThat(tr37).as("test data").isEqualTo("3.3.10 经理团队横向沟通体系不完善");//"3.9.4 未将经验教训充分包含到培训中"
		String tr38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[78]/td[1]"))).getText();
		System.out.println(tr38);
		softly.assertThat(tr38).as("test data").isEqualTo("3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");//"3.9.5 所需培训开展不充分（脱岗）"
		String tr39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[80]/td[1]"))).getText();
		System.out.println(tr39);
		softly.assertThat(tr39).as("test data").isEqualTo("3.4.2 采取行动前没有考虑易出错的心理状况");//"3.9.6 所需培训开展不充分（在岗）"
		String tr40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[82]/td[1]"))).getText();
		System.out.println(tr40);
		softly.assertThat(tr40).as("test data").isEqualTo("3.4.3 采取行动前没有考虑高风险情境（如单项弱点）");//"3.10.1 关键岗位员工的作业授权不充分"
		String tr41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[84]/td[1]"))).getText();
		System.out.println(tr41);
		softly.assertThat(tr41).as("test data").isEqualTo("3.4.4 感到疑惑时质疑不充分");//"3.10.2 关键岗位主管和（或）经理授权不充分"
		String tr42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[86]/td[1]"))).getText();
		System.out.println(tr42);
		softly.assertThat(tr42).as("test data").isEqualTo("3.4.5 任务准备过程中质疑不充分");//"3.10.3 供应商服务（QA/RC、来源检查）授权不充分"
		String tr43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[88]/td[1]"))).getText();
		System.out.println(tr43);
		softly.assertThat(tr43).as("test data").isEqualTo("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");//"3.10.4 现场供应商人员授权不充分"
		String tr44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[90]/td[1]"))).getText();
		System.out.println(tr44);
		softly.assertThat(tr44).as("test data").isEqualTo("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");//"3.10.5 培训教员授权不充分"
		String tr45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[92]/td[1]"))).getText();
		System.out.println(tr45);
		softly.assertThat(tr45).as("test data").isEqualTo("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");//"3.11.1 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位"
		String tr46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[94]/td[1]"))).getText();
		System.out.println(tr46);
		softly.assertThat(tr46).as("test data").isEqualTo("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");//"3.11.2 即时反馈和持续强化(IF&CR)的管理技能不到位"
		String tr47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[96]/td[1]"))).getText();
		System.out.println(tr47);
		softly.assertThat(tr47).as("test data").isEqualTo("3.5.3 对人员表现的观察技能不足");//"3.11.3 用于绩效控制的奖惩制度不到位"
		String tr48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[98]/td[1]"))).getText();
		System.out.println(tr48);
		softly.assertThat(tr48).as("test data").isEqualTo("3.5.3 对人员表现的观察技能不足");//"3.11.4 问题报告、RCA和纠正行动不到位，给员工的反馈不到位"
		String tr49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[100]/td[1]"))).getText();
		System.out.println(tr49);
		softly.assertThat(tr49).as("test data").isEqualTo("3.5.4 对设备性能的观察技能不足");//"3.11.5 现场观察不充分，给员工的反馈不到位"
		String tr50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[102]/td[1]"))).getText();
		System.out.println(tr50);
		softly.assertThat(tr50).as("test data").isEqualTo("3.5.4 对设备性能的观察技能不足");//"3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训"
		String tr51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[104]/td[1]"))).getText();
		System.out.println(tr51);
		softly.assertThat(tr51).as("test data").isEqualTo("3.6.1 要求有遗漏");//"3.15.2 未要求员工对纠正他人违规的情况承担责任"
		String tr52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[106]/td[1]"))).getText();
		System.out.println(tr52);
		softly.assertThat(tr52).as("test data").isEqualTo("3.6.2 运行条件有遗漏");//"3.15.3 员工未充分理解相关行为规范"
		String tr53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[108]/td[1]"))).getText();
		System.out.println(tr53);
		softly.assertThat(tr53).as("test data").contains("3.6.3 假设有遗漏");//"3.15.4 主管未到现场强化"
		//softly.assertThat(tr53).as("test data").contains("同事指导");
		String tr54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[110]/td[1]"))).getText();
		System.out.println(tr54);
		softly.assertThat(tr54).as("test data").contains("3.6.4 范围有遗漏");//"3.18.1 盲目信任: 关键信息使用质疑的态度"
		//softly.assertThat(tr54).as("test data").contains("不到位");
		String tr55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[112]/td[1]"))).getText();
		System.out.println(tr55);
		softly.assertThat(tr55).as("test data").isEqualTo("3.6.5 试验或测量有遗漏");//"3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生"
		String tr56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[114]/td[1]"))).getText();
		System.out.println(tr56);
		softly.assertThat(tr56).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用");//"3.18.3 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障"
		softly.assertThat(tr56).as("test data").contains("不准做清单");
		softly.assertThat(tr56).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		String tr57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[116]/td[1]"))).getText();
		System.out.println(tr57);
		softly.assertThat(tr57).as("test data").isEqualTo("3.6.7 审查不到位导致制度有遗漏项");//"3.18.4 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果"
		String tr58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[118]/td[1]"))).getText();
		System.out.println(tr58);
		softly.assertThat(tr58).as("test data").isEqualTo("3.6.8 根本原因分析不到位导致制度有遗漏项");//"3.18.5 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析"
		String tr59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[120]/td[1]"))).getText();
		System.out.println(tr59);
		softly.assertThat(tr59).as("test data").isEqualTo("3.6.9 纠正措施执行不到位导致制度有遗漏项");//"3.22.1 对规则的现场试验不充分"
		String tr60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[122]/td[1]"))).getText();
		System.out.println(tr60);
		softly.assertThat(tr60).as("test data").isEqualTo("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");//"3.22.2 给规则编写人的反馈不充分，从而使其纠正错误规则"
		String tr61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[124]/td[1]"))).getText();
		System.out.println(tr61);
		softly.assertThat(tr61).as("test data").isEqualTo("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");//"3.22.3 盲目信任错误规则"
		String tr62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[126]/td[1]"))).getText();
		System.out.println(tr62);
		softly.assertThat(tr62).as("test data").isEqualTo("3.9.2 复训频率不高(>> 一年)");//"3.22.4 规则审核不到位"
		String tr63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[128]/td[1]"))).getText();
		System.out.println(tr63);
		softly.assertThat(tr63).as("test data").isEqualTo("3.9.2 复训频率不高(>> 一年)");//"3.22.5 工前会、班前会、交底会的规则不充分"
	}
	
	public List<String> chineseHTMLReport3rdPath (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List <String> verifyChinese = new ArrayList<String>();
		//Table3 rows RC
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table[1]/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1).as("test data").contains("不适用");
		verifyChinese.add(r1);
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table[1]/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r2).as("test data").contains("不适用");
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table[1]/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r3).as("test data").contains("不适用");

		//Table4 rows CF
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r13).as("test data").contains("不适用");
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r14).as("test data").contains("不适用");
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r15).as("test data").contains("不适用");
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
		softly.assertThat(r140).as("test data").contains("天灾");
		String r141 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r141).as("test data").contains("不适用");
		//1.2
		String r142 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r142).as("test data").contains("1.2 始发事件的错误类型为何？");
		verifyChinese.add(r142);
		String r143 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r143).as("test data").contains("不适用");
		String r144 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r144).as("test data").contains("不适用");
		//1.3
		String r191 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r191).as("test data").contains("1.3 若为规则型错误，是否为有意违规还是无意违规？");
		verifyChinese.add(r191);
		String r192 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r192).as("test data").contains("不适用");
		String r193 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r193).as("test data").contains("不适用");
		//1.4
		String r194 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(r194).as("test data").contains("1.4 此无意违规是粗心导致还是程序不当导致？");
		verifyChinese.add(r194);
		String r195 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[2]"))).getText();
		softly.assertThat(r195).as("test data").contains("不适用");
		String r196 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[4]/td[3]"))).getText();
		softly.assertThat(r196).as("test data").contains("不适用");
		//1.5
		String r197 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r197).as("test data").contains("1.5 若我是犯错者，我是否会犯同样的错？");
		verifyChinese.add(r197);
		String r198 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[2]"))).getText();
		softly.assertThat(r198).as("test data").contains("不适用");
		String r199 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r199).as("test data").contains("不适用");
		//1.6
		String r200 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(r200).as("test data").contains("1.6 犯错者违规时是否有旁人观看？");
		verifyChinese.add(r200);
		String r201 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[2]"))).getText();
		softly.assertThat(r201).as("test data").contains("不适用");
		String r202 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[6]/td[3]"))).getText();
		softly.assertThat(r202).as("test data").contains("不适用");
		//1.7
		String r222 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r222).as("test data").contains("1.7 这个错误是否可以透过自检或独立检查避免？");
		verifyChinese.add(r222);
		String r223 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[2]"))).getText();
		softly.assertThat(r223).as("test data").contains("不适用");
		String r224 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r224).as("test data").contains("不适用");
		//1.8
		String r225 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(r225).as("test data").contains("1.8 犯错人员是否受过培训知道如何管理易出错精神状态和高风险？");
		verifyChinese.add(r225);
		String r226 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[2]"))).getText();
		softly.assertThat(r226).as("test data").contains("不适用");
		String r227 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[8]/td[3]"))).getText();
		softly.assertThat(r227).as("test data").contains("不适用");
		//1.9
		String r312 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r312).as("test data").contains("1.9 犯错者在事后是否有经组长或管理层问责？");
		verifyChinese.add(r312);
		String r313 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[2]"))).getText();
		softly.assertThat(r313).as("test data").contains("不适用");
		String r314 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r314).as("test data").contains("不适用");
		//1.10
		String r377 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[1]"))).getText();
		softly.assertThat(r377).as("test data").contains("1.10 若有开班前会、工前会、交底会，为何犯错者未能意识到这个风险且缓解？");
		verifyChinese.add(r377);
		String r378 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[2]"))).getText();
		softly.assertThat(r378).as("test data").contains("不适用");
		String r379 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[10]/td[3]"))).getText();
		softly.assertThat(r379).as("test data").contains("不适用");
		//1.11
		String r380 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r380).as("test data").contains("1.11 这个错为何是现在发生而不是以前发生？");
		verifyChinese.add(r380);
		String r381 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[2]"))).getText();
		softly.assertThat(r381).as("test data").contains("不适用");
		String r382 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r382).as("test data").contains("不适用");
		//1.12
		String r3801 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[1]"))).getText();
		softly.assertThat(r3801).as("test data").contains("1.12 若班前会、工前会或交底会未执行，为什么？");
		verifyChinese.add(r3801);
		String r3811 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[2]"))).getText();
		softly.assertThat(r3811).as("test data").contains("不适用");
		String r3821 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[12]/td[3]"))).getText();
		softly.assertThat(r3821).as("test data").contains("不适用");
		//1.13
		String r38011 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r38011).as("test data").contains("1.13 错误的发生是否存在易出错精神状态或是高风险状态？");
		verifyChinese.add(r38011);
		String r38111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[2]"))).getText();
		softly.assertThat(r38111).as("test data").contains("不适用");
		String r384 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r384).as("test data").contains("不适用");
		//1.14
		String r385= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[1]"))).getText();
		softly.assertThat(r385).as("test data").contains("1.14 组长是否固定开展经验反馈？");
		verifyChinese.add(r385);
		String r386 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[2]"))).getText();
		softly.assertThat(r386).as("test data").contains("不适用");
		String r387 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[14]/td[3]"))).getText();
		softly.assertThat(r387).as("test data").contains("不适用");
		//1.15
		String r397= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r397).as("test data").contains("1.15 始发事件是否有单项弱点？");
		verifyChinese.add(r397);
		String r398 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[2]"))).getText();
		softly.assertThat(r398).as("test data").contains("不适用");
		String r399 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r399).as("test data").contains("不适用");
		//1.16
		String r454= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[1]"))).getText();
		softly.assertThat(r454).as("test data").contains("1.16 事件是与组长监督管理不当有关？");
		verifyChinese.add(r454);
		String r455 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[2]"))).getText();
		softly.assertThat(r455).as("test data").contains("不适用");
		String r456 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[16]/td[3]"))).getText();
		softly.assertThat(r456).as("test data").contains("不适用");
		//1.17
		String r487= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r487).as("test data").contains("1.17 事件是与经理管理不当有关？");
		verifyChinese.add(r487);
		String r488 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[2]"))).getText();
		softly.assertThat(r488).as("test data").contains("不适用");
		String r489 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r489).as("test data").contains("不适用");
		//1.18
		String r555= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[1]"))).getText();
		softly.assertThat(r555).as("test data").contains("1.18 事件是因程序规则有误导致？");
		verifyChinese.add(r555);
		String r556 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[2]"))).getText();
		softly.assertThat(r556).as("test data").contains("不适用");
		String r557 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[18]/td[3]"))).getText();
		softly.assertThat(r557).as("test data").contains("不适用");
		//1.19
		String r579= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r579).as("test data").contains("1.19 是否有类似事件重发的趋势？");
		verifyChinese.add(r579);
		String r580 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[2]"))).getText();
		softly.assertThat(r580).as("test data").contains("不适用");
		String r581 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r581).as("test data").contains("不适用");
		//1.20
		String r600= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[1]"))).getText();
		softly.assertThat(r600).as("test data").contains("1.20 错误是否与工作时发生改变有关？");
		verifyChinese.add(r600);
		String r601 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[2]"))).getText();
		softly.assertThat(r601).as("test data").contains("不适用");
		String r602 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/table/tbody/tr[20]/td[3]"))).getText();
		softly.assertThat(r602).as("test data").contains("不适用");

		//Table 7
		//Table 7 title
		String r621 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/div"))).getText();
		softly.assertThat(r621).as("test data").contains("失效屏障分析过程");
		verifyChinese.add(r621);

		//Table 7 headings
		String heading461 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading461).as("test data").contains("调查问题");
		verifyChinese.add(heading461);
		String heading47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading47).as("test data").contains("答案");
		verifyChinese.add(heading47);
		String heading48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading48).as("test data").contains("选择原因");
		verifyChinese.add(heading48);
		//Table 7 rows
		String r622 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r622).as("test data").contains("屏障是否存在能预防始发事件的发生？");
		verifyChinese.add(r622);
		String r623 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r623).as("test data").contains("不适用");
		verifyChinese.add(r623);
		String r624 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r624).as("test data").contains("不适用");
		String r625 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r625).as("test data").contains("2.21 哪些屏障可以预防此事件？");
		verifyChinese.add(r625);
		String r626 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r626).as("test data").contains("不适用");
		String r627 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[2]/td[3]"))).getText();
		softly.assertThat(r627).as("test data").contains("不适用");
		String r628 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r628).as("test data").contains("是否完善引导你进行人因事件分析？");
		verifyChinese.add(r628);
		String r629 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r629).as("test data").contains("不适用");
		String r630 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[7]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r630).as("test data").contains("不适用");

		//SUEP
		//SUEP titles
		String r631 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/div[1]"))).getText();
		softly.assertThat(r631).as("test data").contains("根本原因确认分析（SUEP）");
		verifyChinese.add(r631);
		String r632 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/div[2]"))).getText();
		softly.assertThat(r632).as("test data").contains(": 是否存在不合标准的实践?");
		verifyChinese.add(r632);
		String r633 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/div[3]"))).getText();
		softly.assertThat(r633).as("test data").contains(": 是否在管理层控制下?");
		verifyChinese.add(r633);
		String r634 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/div[4]"))).getText();
		softly.assertThat(r634).as("test data").contains(": 是否在事件时序早期?");
		verifyChinese.add(r634);
		String r635 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/div[5]"))).getText();
		softly.assertThat(r635).as("test data").contains(": 是否防止再次发生?");
		verifyChinese.add(r635);
		//SUEP table heading
		String heading49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading49).as("test data").contains("促成因素");
		verifyChinese.add(heading49);
		//SUEP table rows
		String r636 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r636).as("test data").contains("不适用");
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r30).as("test data").contains("不适用");
		String r31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r31).as("test data").contains("不适用");
		String r32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[1]/td[4]"))).getText();
		softly.assertThat(r32).as("test data").contains("不适用");
		String r33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[8]/table/tbody/tr[1]/td[5]"))).getText();
		softly.assertThat(r33).as("test data").contains("不适用");

		//HiRCA self checklist chinese, none selected
		//Title
		String title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[9]"))).getText();
		softly.assertThat(title2).as("test data").contains("略过: 调查员略过");
		//Heading
		String heading50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading50).as("test data").contains("类别");
		verifyChinese.add(heading50);
		String heading51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading51).as("test data").contains("调查内容");
		verifyChinese.add(heading51);
		String heading52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading52).as("test data").contains("完成打勾?");
		verifyChinese.add(heading52);
		//Row
		String r700 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r700).as("test data").contains("不适用");
		String r701 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r701).as("test data").contains("不适用");
		String r702 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[11]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r702).as("test data").contains("不适用");

		//Last Table
		//last table with reviewed by etc rows
		//title
		String title3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[12]"))).getText();
		softly.assertThat(title3).as("test data").contains("签字");
		verifyChinese.add(title3);
		//Rows
		String r703 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[13]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r703).as("test data").contains("编写");
		verifyChinese.add(r703);
		String r704 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[13]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r704).as("test data").contains("日期");
		verifyChinese.add(r704);
		String r705 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[13]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(r705).as("test data").contains("审查");
		verifyChinese.add(r705);
		String r706 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[13]/table/tbody/tr[2]/td[2]"))).getText();
		softly.assertThat(r706).as("test data").contains("日期");
		verifyChinese.add(r706);
		String r707 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[13]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r707).as("test data").contains("批准");
		verifyChinese.add(r707);
		String r708 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[13]/table/tbody/tr[3]/td[2]"))).getText();
		softly.assertThat(r708).as("test data").contains("日期");
		verifyChinese.add(r708);

		return verifyChinese;
	}
}
