import java.util.ArrayList;
import java.util.List;

import kaleTestSoftware.HiRCAChinese22;
import kaleTestSoftware.HiRCAChinese23;
import kaleTestSoftware.HiRCAChinese24;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HiRCAChinese13 {
	
	HiRCAChinese22 hc22 = new HiRCAChinese22();
	HiRCAChinese23 hc23 = new HiRCAChinese23();
	HiRCAChinese24 hc24 = new HiRCAChinese24();

	public List<String> chineseHTMLReport1stPath (WebDriver driver, SoftAssertions softly) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		List <String> verifyChinese = new ArrayList<String>();
		//Table1 header 
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/thead/tr/th"))).getText();
		softly.assertThat(heading).as("test data").contains("事件信息");
		verifyChinese.add(heading);
		//Table1 Side titles of report 
		String title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(title1).as("test data").contains("事件名称");
		verifyChinese.add(title1);
		String title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(title2).as("test data").contains("事件编号");
		verifyChinese.add(title2);
		String title3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(title3).as("test data").contains("事件发生日期");
		verifyChinese.add(title3);
		String title4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(title4).as("test data").contains("事件发生时间");
		verifyChinese.add(title4);
		String title5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(title5).as("test data").contains("事件发生地点");
		verifyChinese.add(title5);
		String title6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(title6).as("test data").contains("部门");
		verifyChinese.add(title6);
		String title7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[6]/td[1]"))).getText();
		softly.assertThat(title7).as("test data").contains("组");
		verifyChinese.add(title7);
		String title8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(title8).as("test data").contains("事件调查员");
		verifyChinese.add(title8);
		String title9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[8]/td[1]"))).getText();
		softly.assertThat(title9).as("test data").contains("报告编写者");
		verifyChinese.add(title9);
		String title10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[1]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(title10).as("test data").contains("报告编写时间");
		verifyChinese.add(title10);
		//Table2 header 
		String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/thead/tr/th"))).getText();
		softly.assertThat(heading1).as("test data").contains("事件名称");
		verifyChinese.add(heading1);
		//Table2 Side titles of report 
		String title11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(title11).as("test data").contains("报告摘要");
		verifyChinese.add(title11);
		String title12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[2]/td[1]"))).getText();
		softly.assertThat(title12).as("test data").contains("事件描述");
		verifyChinese.add(title12);
		String title13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(title13).as("test data").contains("事件详细过程（时序构建）");
		verifyChinese.add(title13);
		String title14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[4]/td[1]"))).getText();
		softly.assertThat(title14).as("test data").contains("相关信息");
		verifyChinese.add(title14);
		//header
		String header3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[3]"))).getText();
		softly.assertThat(header3).as("test data").contains("事件原因");
		verifyChinese.add(header3);
		//Table3 header 
		String heading4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading4).as("test data").contains("根本原因");
		verifyChinese.add(heading4);
		String heading5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading5).as("test data").contains("重要性分级");
		verifyChinese.add(heading5);
		String heading6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading6).as("test data").contains("纠正行动");
		verifyChinese.add(heading6);
		//Table3 row
		String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1).as("test data").contains("不适用");
		verifyChinese.add(r1);
		String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr[1]/td[2]"))).getText();
		softly.assertThat(r2).as("test data").contains("不适用");
		verifyChinese.add(r2);
		String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r3).as("test data").contains("不适用");
		verifyChinese.add(r3);
		//Table4 header 
		String heading7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading7).as("test data").contains("促成因素");
		verifyChinese.add(heading7);
		String heading8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/thead/tr/th[2]"))).getText();
		softly.assertThat(heading8).as("test data").contains("重要性分级");
		verifyChinese.add(heading8);
		String heading9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/thead/tr/th[3]"))).getText();
		softly.assertThat(heading9).as("test data").contains("纠正行动");
		verifyChinese.add(heading9);
		//Table 5 heading
		String heading10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/thead/tr/th[1]"))).getText();
		softly.assertThat(heading10).as("test data").contains("缺少的屏障");
		verifyChinese.add(heading10);
		//Table 5 row
		String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r7).as("test data").contains("未缺少屏障");
		verifyChinese.add(r7);
		//header
		String header11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[6]/div"))).getText();
		softly.assertThat(header11).as("test data").contains("根本原因分析过程");
		verifyChinese.add(header11);
		//Table4 rows
		String r1a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[1]/td[1]"))).getText();
		softly.assertThat(r1a).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");
		verifyChinese.add(r1a);
		String r2a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[1]/td[3]"))).getText();
		softly.assertThat(r2a).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r2a);
		String r3a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[3]/td[1]"))).getText();
		softly.assertThat(r3a).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");//"3.2.2 组长绩效反馈方面的管理能力不足"
		verifyChinese.add(r3a);
		String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[3]/td[3]"))).getText();
		softly.assertThat(r4).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r4);
		String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[5]/td[1]"))).getText();
		softly.assertThat(r5).as("test data").contains("3.2.1 组长强化标准方面的管理能力不足");//"3.2.3 组长召开经验反馈的管理技能不足"
		verifyChinese.add(r5);
		String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[5]/td[3]"))).getText();
		softly.assertThat(r6).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r6);
		String r7a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[7]/td[1]"))).getText();
		softly.assertThat(r7a).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");//"3.2.4 组长在岗培训方面管理能力不足"
		verifyChinese.add(r7a);
		String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[7]/td[3]"))).getText();
		softly.assertThat(r8).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r8);
		String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[9]/td[1]"))).getText();
		softly.assertThat(r9).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");//"3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施"
		verifyChinese.add(r9);
		String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[9]/td[3]"))).getText();
		softly.assertThat(r10).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r10);
		String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[11]/td[1]"))).getText();
		softly.assertThat(r11).as("test data").contains("3.2.2 组长绩效反馈方面的管理能力不足");//"3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足"
		verifyChinese.add(r11);
		String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[11]/td[3]"))).getText();
		softly.assertThat(r12).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r12);
		String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[13]/td[1]"))).getText();
		softly.assertThat(r13).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");//"3.3.1 经理团队资源分配不到位"
		verifyChinese.add(r13);
		String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[13]/td[3]"))).getText();
		softly.assertThat(r14).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r14);
		String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[15]/td[1]"))).getText();
		softly.assertThat(r15).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");//"3.3.2 经理团队所需培训开展不充分"
		verifyChinese.add(r15);
		String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[15]/td[3]"))).getText();
		softly.assertThat(r16).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r16);
		String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[17]/td[1]"))).getText();
		softly.assertThat(r17).as("test data").contains("3.2.3 组长召开经验反馈的管理技能不足");//"3.3.3 经理团队问责制不到位"
		verifyChinese.add(r17);
		String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[17]/td[3]"))).getText();
		softly.assertThat(r18).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r18);
		String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[19]/td[1]"))).getText();
		softly.assertThat(r19).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");//"3.3.4 经理团队对确定工作优先级和计划方面不到位"
		verifyChinese.add(r19);
		String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[19]/td[3]"))).getText();
		softly.assertThat(r20).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r20);
		String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[21]/td[1]"))).getText();
		softly.assertThat(r21).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");//"3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障"
		verifyChinese.add(r21);
		String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[21]/td[3]"))).getText();
		softly.assertThat(r22).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r22);
		String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[23]/td[1]"))).getText();
		softly.assertThat(r23).as("test data").contains("3.2.4 组长在岗培训方面管理能力不足");//"3.3.6 经理团队绩效跟踪与趋势分析不到位"
		verifyChinese.add(r23);
		String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[23]/td[3]"))).getText();
		softly.assertThat(r24).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r24);
		String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[25]/td[1]"))).getText();
		softly.assertThat(r25).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");//"3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任"
		verifyChinese.add(r25);
		String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[25]/td[3]"))).getText();
		softly.assertThat(r26).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r26);
		String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[27]/td[1]"))).getText();
		softly.assertThat(r27).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");//"3.3.8 经理团队纠正行动不足"
		verifyChinese.add(r27);
		String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[27]/td[3]"))).getText();
		softly.assertThat(r28).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r28);
		String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[29]/td[1]"))).getText();
		softly.assertThat(r29).as("test data").contains("3.2.5 组长对团队缺点认识不足，缺乏相应弥补措施");//"3.3.9 经理团队垂直沟通体系不完善"
		verifyChinese.add(r29);
		String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[29]/td[3]"))).getText();
		softly.assertThat(r30).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r30);
		String r41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[31]/td[1]"))).getText();
		softly.assertThat(r41).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");//"3.3.10 经理团队横向沟通体系不完善"
		verifyChinese.add(r41);
		String r42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[31]/td[3]"))).getText();
		softly.assertThat(r42).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r42);
		String r43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[33]/td[1]"))).getText();
		softly.assertThat(r43).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");//"3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）"
		verifyChinese.add(r43);
		String r44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[33]/td[3]"))).getText();
		softly.assertThat(r44).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r44);
		String r45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[35]/td[1]"))).getText();
		softly.assertThat(r45).as("test data").contains("3.2.6 组长发出指令和后续贯彻的沟通及协调能力不足");//"3.4.2 采取行动前没有考虑易出错的心理状况"
		verifyChinese.add(r45);
		String r46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[35]/td[3]"))).getText();
		softly.assertThat(r46).as("test data").contains("监督管理方面的培训, 监督行为规范的管理");
		verifyChinese.add(r46);
		String r47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[37]/td[1]"))).getText();
		softly.assertThat(r47).as("test data").contains("3.3.1 经理团队资源分配不到位");//"3.4.3 采取行动前没有考虑高风险情境（如单项弱点）"
		verifyChinese.add(r47);
		String r48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[37]/td[3]"))).getText();
		softly.assertThat(r48).as("test data").contains("提升管理技能，完善资源分配体系");
		verifyChinese.add(r48);
		String r49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[39]/td[1]"))).getText();
		softly.assertThat(r49).as("test data").contains("3.3.1 经理团队资源分配不到位");//"3.4.4 感到疑惑时质疑不充分"
		verifyChinese.add(r49);
		String r50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[39]/td[3]"))).getText();
		softly.assertThat(r50).as("test data").contains("提升管理技能，完善资源分配体系");
		verifyChinese.add(r50);
		String r51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[41]/td[1]"))).getText();
		softly.assertThat(r51).as("test data").contains("3.3.2 经理团队所需培训开展不充分");//"3.4.5 任务准备过程中质疑不充分"
		verifyChinese.add(r51);
		String r52 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[41]/td[3]"))).getText();
		softly.assertThat(r52).as("test data").contains("成立培训计划委员会");
		verifyChinese.add(r52);
		String r53 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[43]/td[1]"))).getText();
		softly.assertThat(r53).as("test data").contains("3.3.2 经理团队所需培训开展不充分");//"3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分"
		verifyChinese.add(r53);
		String r54 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[43]/td[3]"))).getText();
		softly.assertThat(r54).as("test data").contains("成立培训计划委员会");
		verifyChinese.add(r54);
		String r55 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[45]/td[1]"))).getText();
		softly.assertThat(r55).as("test data").contains("3.3.3 经理团队问责制不到位");//"3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分"
		verifyChinese.add(r55);
		String r56 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[45]/td[3]"))).getText();
		softly.assertThat(r56).as("test data").contains("完善问责制");
		verifyChinese.add(r56);
		String r57 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[47]/td[1]"))).getText();
		softly.assertThat(r57).as("test data").contains("3.3.3 经理团队问责制不到位");//"3.5.3 对人员表现的观察技能不足"
		verifyChinese.add(r57);
		String r58 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[47]/td[3]"))).getText();
		softly.assertThat(r58).as("test data").contains("完善问责制");
		verifyChinese.add(r58);
		String r59 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[49]/td[1]"))).getText();
		softly.assertThat(r59).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");//"3.5.4 对设备性能的观察技能不足"
		verifyChinese.add(r59);
		String r60 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[49]/td[3]"))).getText();
		softly.assertThat(r60).as("test data").contains("完善管理优先级确定和计划体系？");
		verifyChinese.add(r60);
		String r61 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[51]/td[1]"))).getText();
		softly.assertThat(r61).as("test data").contains("3.3.4 经理团队对确定工作优先级和计划方面不到位");//"3.6.1 要求有遗漏"
		verifyChinese.add(r61);
		String r62 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[51]/td[3]"))).getText();
		softly.assertThat(r62).as("test data").contains("完善管理优先级确定和计划体系？");
		verifyChinese.add(r62);
		String r63 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[53]/td[1]"))).getText();
		softly.assertThat(r63).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");//"3.6.2 运行条件有遗漏"
		verifyChinese.add(r63);
		String r64 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[53]/td[3]"))).getText();
		softly.assertThat(r64).as("test data").contains("开展关于标准设定的管理培训, 开展关于程序和保护屏障设计的培训");
		verifyChinese.add(r64);
		String r65 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[55]/td[1]"))).getText();
		softly.assertThat(r65).as("test data").contains("3.3.5 经理管理人员对以下标准制定不充分：(1) 行为规范 (2) 程序和屏障");//"3.6.3 假设有遗漏"
		verifyChinese.add(r65);
		String r66 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[55]/td[3]"))).getText();
		softly.assertThat(r66).as("test data").contains("开展关于标准设定的管理培训, 开展关于程序和保护屏障设计的培训");
		verifyChinese.add(r66);
		String r67 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[57]/td[1]"))).getText();
		softly.assertThat(r67).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");//"3.6.4 范围有遗漏"
		verifyChinese.add(r67);
		String r68 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[57]/td[3]"))).getText();
		softly.assertThat(r68).as("test data").contains("定期开展共因分析, 改善绩效跟踪与趋势分析项目, 完善KPI");
		verifyChinese.add(r68);
		String r69 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[59]/td[1]"))).getText();
		softly.assertThat(r69).as("test data").contains("3.3.6 经理团队绩效跟踪与趋势分析不到位");//"3.6.5 试验或测量有遗漏"
		verifyChinese.add(r69);
		String r70 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[59]/td[3]"))).getText();
		softly.assertThat(r70).as("test data").contains("定期开展共因分析, 改善绩效跟踪与趋势分析项目, 完善KPI");
		verifyChinese.add(r70);
		String r71 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[61]/td[1]"))).getText();
		softly.assertThat(r71).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");//"3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用"
		//softly.assertThat(r71).as("test data").contains("不准做清单");
		//softly.assertThat(r71).as("test data").contains("体现; (5) 参考资料; (6) 要求使用者反馈");
		verifyChinese.add(r71);
		String r72 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[61]/td[3]"))).getText();
		softly.assertThat(r72).as("test data").contains("开展组织设计方面的管理培训, 在经理人员之间建立共同目标、共同利益和共同责任");
		verifyChinese.add(r72);
		String r73 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[63]/td[1]"))).getText();
		softly.assertThat(r73).as("test data").contains("3.3.7 经理团队内未充分建立关于团队合作的共同目标、共同利益和共同责任");//"3.6.7 审查不到位导致制度有遗漏项"
		verifyChinese.add(r73);
		String r74 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[63]/td[3]"))).getText();
		softly.assertThat(r74).as("test data").contains("开展组织设计方面的管理培训, 在经理人员之间建立共同目标、共同利益和共同责任");
		verifyChinese.add(r74);
		String r75 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[65]/td[1]"))).getText();
		softly.assertThat(r75).as("test data").contains("3.3.8 经理团队纠正行动不足");//"3.6.8 根本原因分析不到位导致制度有遗漏项"
		verifyChinese.add(r75);
		String r76 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[65]/td[3]"))).getText();
		softly.assertThat(r76).as("test data").contains("提高纠正行动计划的落实, 改善根本原因分析方法, 完善突发紧急问题（危机）管理机制");
		verifyChinese.add(r76);
		String r77 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[67]/td[1]"))).getText();
		softly.assertThat(r77).as("test data").contains("3.3.8 经理团队纠正行动不足");//"3.6.9 纠正措施执行不到位导致制度有遗漏项"
		verifyChinese.add(r77);
		String r78 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[67]/td[3]"))).getText();
		softly.assertThat(r78).as("test data").contains("提高纠正行动计划的落实, 改善根本原因分析方法, 完善突发紧急问题（危机）管理机制");
		verifyChinese.add(r78);
		String r79 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[69]/td[1]"))).getText();
		softly.assertThat(r79).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");//"3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺"
		verifyChinese.add(r79);
		String r80 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[69]/td[3]"))).getText();
		softly.assertThat(r80).as("test data").contains("完善垂直沟通体系");
		verifyChinese.add(r80);
		String r81 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[71]/td[1]"))).getText();
		softly.assertThat(r81).as("test data").contains("3.3.9 经理团队垂直沟通体系不完善");//"3.9.2 复训频率不高(>> 一年)"
		verifyChinese.add(r81);
		String r82 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[71]/td[3]"))).getText();
		softly.assertThat(r82).as("test data").contains("完善垂直沟通体系");
		verifyChinese.add(r82);
		String r83 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[73]/td[1]"))).getText();
		softly.assertThat(r83).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");//"3.9.3 部门管理层未充分参与培训材料的编写和培训的实施"
		verifyChinese.add(r83);
		String r84 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[73]/td[3]"))).getText();
		softly.assertThat(r84).as("test data").contains("完善程序设计, 制定共同目标和共同利益");
		verifyChinese.add(r84);
		String r85 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[75]/td[1]"))).getText();
		softly.assertThat(r85).as("test data").contains("3.3.10 经理团队横向沟通体系不完善");//"3.9.4 未将经验教训充分包含到培训中"
		verifyChinese.add(r85);
		String r86 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[75]/td[3]"))).getText();
		softly.assertThat(r86).as("test data").contains("完善程序设计, 制定共同目标和共同利益");
		verifyChinese.add(r86);
		String r87 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[77]/td[1]"))).getText();
		softly.assertThat(r87).as("test data").contains("3.4.1 采取行动前没有思考如何规划（如优先顺序、机会、沟通、时间管理等）");//"3.9.5 所需培训开展不充分（脱岗）"
		verifyChinese.add(r87);
		String r88 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[77]/td[3]"))).getText();
		softly.assertThat(r88).as("test data").contains("开展关键思考和关键追问方面的培训");
		verifyChinese.add(r88);
		String r89 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[79]/td[1]"))).getText();
		softly.assertThat(r89).as("test data").contains("3.4.2 采取行动前没有考虑易出错的心理状况");//"3.9.6 所需培训开展不充分（在岗）"
		verifyChinese.add(r89);
		String r90 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[79]/td[3]"))).getText();
		softly.assertThat(r90).as("test data").contains("开展关键思考和关键追问方面的培训");
		verifyChinese.add(r90);
		String r91 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[81]/td[1]"))).getText();
		softly.assertThat(r91).as("test data").contains("3.4.3 采取行动前没有考虑高风险情境（如单项弱点）");//"3.10.1 关键岗位员工的作业授权不充分"
		verifyChinese.add(r91);
		String r92 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[81]/td[3]"))).getText();
		softly.assertThat(r92).as("test data").contains("开展关键思考和关键追问方面的培训");
		verifyChinese.add(r92);
		String r93 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[83]/td[1]"))).getText();
		softly.assertThat(r93).as("test data").contains("3.4.4 感到疑惑时质疑不充分");//"3.10.2 关键岗位主管和（或）经理授权不充分"
		verifyChinese.add(r93);
		String r94 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[83]/td[3]"))).getText();
		softly.assertThat(r94).as("test data").contains("开展关键思考和关键追问方面的培训");
		verifyChinese.add(r94);
		String r95 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[85]/td[1]"))).getText();
		softly.assertThat(r95).as("test data").contains("3.4.5 任务准备过程中质疑不充分");//"3.10.3 供应商服务（QA/RC、来源检查）授权不充分"
		verifyChinese.add(r95);
		String r96 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[85]/td[3]"))).getText();
		softly.assertThat(r96).as("test data").contains("开展关键思考和关键追问方面的培训");
		verifyChinese.add(r96);
		String r97 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[87]/td[1]"))).getText();
		softly.assertThat(r97).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");//"3.10.4 现场供应商人员授权不充分"
		verifyChinese.add(r97);
		String r98 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[87]/td[3]"))).getText();
		softly.assertThat(r98).as("test data").contains("情况警觉培训, 作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		verifyChinese.add(r98);
		String r99 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[89]/td[1]"))).getText();
		softly.assertThat(r99).as("test data").contains("3.5.1 作业前情况警觉（如易出错的精神状态和高风险情况）不充分");//"3.10.5 培训教员授权不充分"
		verifyChinese.add(r99);
		String r100 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[89]/td[3]"))).getText();
		softly.assertThat(r100).as("test data").contains("情况警觉培训, 作业前情况警觉（如 TAPE、工前会等）关于何时、何人、何事的要求");
		verifyChinese.add(r100);
		String r101 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[91]/td[1]"))).getText();
		softly.assertThat(r101).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");//"3.11.1 绩效跟踪与趋势分析(PM&T)以及给员工的反馈不到位"
		verifyChinese.add(r101);
		String r102 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[91]/td[3]"))).getText();
		softly.assertThat(r102).as("test data").contains("情况警觉培训");
		verifyChinese.add(r102);
		String r103 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[93]/td[1]"))).getText();
		softly.assertThat(r103).as("test data").contains("3.5.2 作业过程中情况警觉（如易出错的精神状态和高风险情况）不充分");//"3.11.2 即时反馈和持续强化(IF&CR)的管理技能不到位"
		verifyChinese.add(r103);
		String r104 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[93]/td[3]"))).getText();
		softly.assertThat(r104).as("test data").contains("情况警觉培训");
		verifyChinese.add(r104);
		String r105 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[95]/td[1]"))).getText();
		softly.assertThat(r105).as("test data").contains("3.5.3 对人员表现的观察技能不足");//"3.11.3 用于绩效控制的奖惩制度不到位"
		verifyChinese.add(r105);
		String r106 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[95]/td[3]"))).getText();
		softly.assertThat(r106).as("test data").contains("开展人员表现观察技能方面的培训");
		verifyChinese.add(r106);
		String r107 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[97]/td[1]"))).getText();
		softly.assertThat(r107).as("test data").contains("3.5.3 对人员表现的观察技能不足");//"3.11.4 问题报告、RCA和纠正行动不到位，给员工的反馈不到位"
		verifyChinese.add(r107);
		String r108 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[97]/td[3]"))).getText();
		softly.assertThat(r108).as("test data").contains("开展人员表现观察技能方面的培训");
		verifyChinese.add(r108);
		String r109 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[99]/td[1]"))).getText();
		softly.assertThat(r109).as("test data").contains("3.5.4 对设备性能的观察技能不足");//"3.11.5 现场观察不充分，给员工的反馈不到位"
		verifyChinese.add(r109);
		String r110 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[99]/td[3]"))).getText();
		softly.assertThat(r110).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");
		verifyChinese.add(r110);
		String r111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[101]/td[1]"))).getText();
		softly.assertThat(r111).as("test data").contains("3.5.4 对设备性能的观察技能不足");//"3.15.1 员工未经过相互指导的培训，或纠正他人违规情况的培训"
		verifyChinese.add(r111);
		String r112 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[101]/td[3]"))).getText();
		softly.assertThat(r112).as("test data").contains("开展退化、异常和变化等设备性能观察技能方面的培训");
		verifyChinese.add(r112);
		String r113 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[103]/td[1]"))).getText();
		softly.assertThat(r113).as("test data").contains("3.6.1 要求有遗漏");//"3.15.2 未要求员工对纠正他人违规的情况承担责任"
		verifyChinese.add(r113);
		String r114 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[103]/td[3]"))).getText();
		softly.assertThat(r114).as("test data").contains("完善规则, 开展程序设计方面的培训");
		verifyChinese.add(r114);
		String r115 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[105]/td[1]"))).getText();
		softly.assertThat(r115).as("test data").contains("3.6.2 运行条件有遗漏");//"3.15.3 员工未充分理解相关行为规范"
		verifyChinese.add(r115);
		String r116 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[105]/td[3]"))).getText();
		softly.assertThat(r116).as("test data").contains("完善规则, 开展程序设计方面的培训");
		verifyChinese.add(r116);
		String r117 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[107]/td[1]"))).getText();
		softly.assertThat(r117).as("test data").contains("3.6.3 假设有遗漏");//"3.15.4 主管未到现场强化"
		//softly.assertThat(r117).as("test data").contains("同事指导");
		verifyChinese.add(r117);
		String r118 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[107]/td[3]"))).getText();
		softly.assertThat(r118).as("test data").contains("完善规则, 开展程序设计方面的培训");
		verifyChinese.add(r118);
		String r119 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[109]/td[1]"))).getText();
		softly.assertThat(r119).as("test data").contains("3.6.4 范围有遗漏");//"3.18.1 盲目信任: 关键信息使用质疑的态度"
		verifyChinese.add(r119);
		//softly.assertThat(r119).as("test data").contains("不到位");
		String r120 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[109]/td[3]"))).getText();
		softly.assertThat(r120).as("test data").contains("完善规则, 开展程序设计方面的培训");
		//softly.assertThat(r120).as("test data").contains(" 培训");
		verifyChinese.add(r120);
		String r121 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[111]/td[1]"))).getText();
		softly.assertThat(r121).as("test data").contains("3.6.5 试验或测量有遗漏");//"3.18.2 过度自信: (1) 高估自我效能; (2) 未意识到影响变化; (3) 未寻求他人智慧; (4) 没有从过去中学习; (5) 缺少屏障预防错误发生"
		verifyChinese.add(r121);
		String r122 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[111]/td[3]"))).getText();
		softly.assertThat(r122).as("test data").contains("完善规则, 开展程序设计方面的培训");
		verifyChinese.add(r122);
		String r123 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[113]/td[1]"))).getText();
		softly.assertThat(r123).as("test data").contains("3.6.6 遗漏以下信息: (1) 目的; (2) 先决条件; (3) 定义; (4) 经验反馈用\"不准做清单\"体现; (5) 参考资料; (6) 要求使用者反馈");//"3.18.3: 眼不见心不想: (1) 对低概率/高风险事件的风险控制不到位; (2) 忽略与绩效指标或激励无关的问题; (3) 因忽略相关风险而未设置屏障"
		verifyChinese.add(r123);
		String r124 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[113]/td[3]"))).getText();
		softly.assertThat(r124).as("test data").contains("开展程序设计编写培训, 改善程序编写导则");
	//	softly.assertThat(r124).as("test data").contains("), 完善PM&T体系");
		verifyChinese.add(r124);
		String r125 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[115]/td[1]"))).getText();
		softly.assertThat(r125).as("test data").contains("3.6.7 审查不到位导致制度有遗漏项");//"3.18.4: 未能及时止损: (1) 因自满和（或）无知，捍卫过去错误的决定或犹豫不决; (2) 期望通过重复同样的问题处理方法、标准或策略来实现不同的结果"
		verifyChinese.add(r125);
		String r126 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[115]/td[3]"))).getText();
		softly.assertThat(r126).as("test data").contains("开展程序审查培训");
		verifyChinese.add(r126);
		String r127 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[117]/td[1]"))).getText();
		softly.assertThat(r127).as("test data").contains("3.6.8 根本原因分析不到位导致制度有遗漏项");//"3.18.5: 陷入两选一的陷阱: 决策、问题解决或计划不充分，未能确保全面考虑多个选择方案进行分析"
		verifyChinese.add(r127);
		String r128 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[117]/td[3]"))).getText();
		softly.assertThat(r128).as("test data").contains("开展根本原因培训");
		verifyChinese.add(r128);
		String r129 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[119]/td[1]"))).getText();
		softly.assertThat(r129).as("test data").contains("3.6.9 纠正措施执行不到位导致制度有遗漏项");//"3.22.1: 对规则的现场试验不充分"
		verifyChinese.add(r129);
		String r130 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[119]/td[3]"))).getText();
		softly.assertThat(r130).as("test data").contains("改善纠正措施制度的监督与执行");
		verifyChinese.add(r130);
		String r131 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[121]/td[1]"))).getText();
		softly.assertThat(r131).as("test data").contains("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");//"3.22.2: 给规则编写人的反馈不充分，从而使其纠正错误规则"
		verifyChinese.add(r131);
		String r132 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[121]/td[3]"))).getText();
		softly.assertThat(r132).as("test data").contains("加强培训资源, 开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		verifyChinese.add(r132);
		String r133 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[123]/td[1]"))).getText();
		softly.assertThat(r133).as("test data").contains("3.9.1 培训材料在适用性、及时性或实用性方面有所欠缺");//"3.22.3: 盲目信任错误规则"
		verifyChinese.add(r133);
		String r134 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[123]/td[3]"))).getText();
		softly.assertThat(r134).as("test data").contains("加强培训资源, 开展作业任务分析，从而使培训材料、课程及时间与员工执行的任务相匹配");
		verifyChinese.add(r134);
		String r135 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[125]/td[1]"))).getText();
		softly.assertThat(r135).as("test data").contains("3.9.2 复训频率不高(>> 一年)");//"3.22.4: 规则审核不到位"
		verifyChinese.add(r135);
		String r136 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[125]/td[3]"))).getText();
		softly.assertThat(r136).as("test data").contains("增加复训频率，改善复训形式");
		verifyChinese.add(r136);
		String r137 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[127]/td[1]"))).getText();
		softly.assertThat(r137).as("test data").contains("3.9.2 复训频率不高(>> 一年)");//"3.22.5: 工前会、班前会、交底会的规则不充分"
		verifyChinese.add(r137);
		String r138 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[5]/table/tbody/tr[127]/td[3]"))).getText();
		softly.assertThat(r138).as("test data").contains("增加复训频率，改善复训形式");
		verifyChinese.add(r138);
		
		verifyChinese.addAll(hc22.chineseHTMLReport1stPath_hc22(driver, softly));
		verifyChinese.addAll(hc23.chineseHTMLReport1stPath_hc23(driver, softly));
		verifyChinese.addAll(hc24.chineseHTMLReport1stPath_hc24(driver, softly));
		return verifyChinese;
	}
}
		