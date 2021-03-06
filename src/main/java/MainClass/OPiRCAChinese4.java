package MainClass;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import PageObjects.OPiRCAPageObj;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OPiRCAChinese4 {

    OPiRCAPageObj opirca = new OPiRCAPageObj();
    OPiRCA3 op3 = new OPiRCA3();
    ShareCheck2 share2 = new ShareCheck2();
    ShareCheck share = new ShareCheck();

    public void OPiRCASkipStep1(WebDriver driver) throws Exception{

        WebDriverWait wait = new WebDriverWait(driver,10);
        OPiRCAChinese obj1 = new OPiRCAChinese();
        EiRCAChinese obj2 = new EiRCAChinese();
        //Go to Analysis
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.AnalysisLinkText)).click();
        //Clicks on MainClass.OPiRCA
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCALink)).click();
        //Create a new MainClass.OPiRCA report
        obj1.chineseEventInfoFill(driver, obj2.text);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
    }

    public int verifyApparentCauseAnswersStep2ReportTab(WebDriver driver, SoftAssertions softly, List<String>step2ApparentCausesAnswers, int rc, int i, int start, List<String>apparentCausesAnswersNew) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver,1);
        int j=0;
        System.out.println(i);
        //count no of apparent causes under each question of step 2
        while(true)
        {
            try{
                j=j+1;
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-opa-rpt']/div["+(rc+6)+"]/table/tbody/tr["+i+"]/td/div/table/tbody/tr["+j+"]/td[1]")));
            }catch(org.openqa.selenium.TimeoutException e)
            {
                break;
            }
        }
        //Create a sublist
        List<String> sub = new ArrayList<String>();
        for(int k = start; k<j;k++ )
        {
            String s = step2ApparentCausesAnswers.get(k).replace("[", "");
            String s1 = s.replace("]", "");
            sub.add(s1);
        }
        //Verify the apparent cause is in the sub list
        for(int k=1;k<j;k++)
        {
            String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-opa-rpt']/div["+(rc+6)+"]/table/tbody/tr["+i+"]/td/div/table/tbody/tr["+k+"]/td[1]"))).getText();
            if(sub.contains(s)==false)
            {
                if(apparentCausesAnswersNew.contains(s)==false)
                    softly.fail("Apparent cause not selected, yet is appearing in report tab under step2 "+s+"\n"+sub+"\n"+apparentCausesAnswersNew);
            }
        }
        System.out.println("end of apparent cause function "+i);
        return j;
    }

    public List<String> chineseReportTabStep2Variation3(WebDriver driver, SoftAssertions softly, int rc, List<String>step2QuestionAnswers, List<String>step2ApparentCausesAnswers, List<String>apparentCausesAnswersNew) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver,3);
        List<String> ac = new ArrayList<String>();
        ac.addAll(removeColonFromAnswers(op3.modifyList(step2ApparentCausesAnswers)));
        System.out.println(step2QuestionAnswers);
        int i = 1;
        //Counter for answers to d1 to d12
        int j = 0;
        int start = 0;
        while (true)
        {
            Thread.sleep(500);
            try{
                System.out.println(i);
                //div for step 2 will be rc+6
                String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-opa-rpt']/div["+(rc+6)+"]/table/tbody/tr["+i+"]/td[2]"))).getText();
                ac.add(s);
                int m = s.indexOf(":");
                String s1 = s.substring(m+2, s.length());
                System.out.println("step2 report tab "+s);
                if(j<12){
                    softly.assertThat(s).as("test data").isEqualTo(step2QuestionAnswers.get(j));
                }
                j=j+1;
                if(s.startsWith("D9.")||s.startsWith("D12."))
                {
                    if(s1.equals("Yes")||s1.equals("???"))
                    {
                        i=i+1;
                        String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-opa-rpt']/div["+(rc+6)+"]/table/tbody/tr["+i+"]/td[1]"))).getText();
                        if(s2.contains("is in conflict with answers")==true)
                            i=i+1;
                    }
                    else
                    {
                        i=i+1;
                        int k = verifyApparentCauseAnswersStep2ReportTab(driver,softly,step2ApparentCausesAnswers,rc,i,start,apparentCausesAnswersNew);
                        start = k-1;
                        i=i+1;
                        System.out.println("end of try catch "+i);
                    }
                }
                else if(s.startsWith("D10."))
                {
                    if(s1.contains("High")||s1.contains("????????????0.2???"))
                    {
                        i=i+1;
                        String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-opa-rpt']/div["+(rc+6)+"]/table/tbody/tr["+i+"]/td[1]"))).getText();
                        if(s2.contains("is in conflict with answers")==true)
                            i=i+1;
                    }
                    else
                    {
                        i=i+1;
                        int k = verifyApparentCauseAnswersStep2ReportTab(driver,softly,step2ApparentCausesAnswers,rc,i,start,apparentCausesAnswersNew);
                        start = k-1;
                        i=i+1;
                        System.out.println("end of try catch "+i);
                    }
                }
                else if(s1.equals("No"))
                {
                    i=i+1;
                    String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-opa-rpt']/div["+(rc+6)+"]/table/tbody/tr["+i+"]/td[1]"))).getText();
                    if(s2.contains("is in conflict with answers")==true)
                        i=i+1;
                }
                else
                {
                    i=i+1;
                    int k = verifyApparentCauseAnswersStep2ReportTab(driver,softly,step2ApparentCausesAnswers,rc,i,start,apparentCausesAnswersNew);
                    start = k-1;
                    i=i+1;
                    System.out.println("end of try catch "+i);
                }
            }catch(org.openqa.selenium.TimeoutException r)
            {
                System.out.println(r);
                break;
            }
        }
        return ac;
    }

    public void saveReport(WebDriver driver) throws Exception {

        WebDriverWait wait1 = new WebDriverWait(driver,10);
        //Clicks on Save
        wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveButton)).click();
        //Clicks on Save report
        wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavePopupTitle)).click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASaveConfirmButton)).click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.StickySuccess));
        //Wait for loading message
        share2.loadingServer(driver);
        Thread.sleep(1000);
        //Clicks on Saved activities
        wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASavedActivitiesButton)).click();
        Thread.sleep(2000);
        //Wait for loading message
        share2.loadingServer(driver);
        //Click on new record
        wait1.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAFirstRecord)).click();
        //Wait for loading message
        share2.loadingServer(driver);
    }

    public void OPiRCAStep2VariationPaths(WebDriver driver, SoftAssertions softly) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver,10);
        OPiRCA obj = new OPiRCA();
        OPiRCAChinese2 obj2 = new OPiRCAChinese2();
        HiRCALevel1 obj3 = new HiRCALevel1();
        OPiRCA2 obj4 = new OPiRCA2();
        //Skip step1
        OPiRCASkipStep1(driver);
        //Step 2 with No or yes but directly leads to next question
        chineseStep2AnswerLeadsToNextQuestion(driver);
        //Click skip step3
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        //Click skip step4
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        //Click skip step5
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        //Chinese verify report tab
        chineseReportTabStep2Variation2(driver,softly);
        Thread.sleep(1000);
        //Save report
        saveReport(driver);
        //Chinese verify HTML report
        List <String> verifyChinese=chineseHTMLReportStep2Variation2(driver,softly);
        Thread.sleep(1000);
        //Download report
        obj2.downloadReport(driver,verifyChinese, softly);
        //Delete report
        obj3.deleteReport(driver);
        //Skip step1
        OPiRCASkipStep1(driver);
        //Step 2 with answers leading to level 3
        List<String>ac=chineseStep2AnswerLeadingToLevel3(driver,softly);
        //Seperate list of Step 2 D1 to D12 answers
        List<String> step2QuestionAnswers = obj4.step2QuestionsAnswersOnly(ac);
        //List of apparent causes selected under Step 2
        List<String> step2ApparentCausesAnswers = obj4.step2ApparentCausesAnswersOnly(ac);
        //Create dummy list to add in function
        List<String>dummy = new ArrayList<String>();
        //Order the list
        List<String> orderedApparentCauses=obj4.combineApparentCausesFromStep1AndStep2(dummy, step2ApparentCausesAnswers);
        //Verify step 3 with selected
        obj.verifyApparentCauses(driver, orderedApparentCauses);
        //Click skip step3
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        //Verify Step 4
        verifyStep4WithRandomStep2Selections(driver,softly,orderedApparentCauses);
        //Click skip step4
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        //Click skip step5
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        //Remove : from all apparent cause answers
        List<String> a1 = removeColonFromAnswers(orderedApparentCauses);
        //Chinese verify report tab
        List<String> verifyChinese1 = chineseReportTabStep2Variation3(driver, softly, 0, step2QuestionAnswers, step2ApparentCausesAnswers, a1);
        Thread.sleep(1000);
        //Save report
        saveReport(driver);
        //Chinese verify HTML report
        obj4.step2HTML(driver, softly, 0, step2QuestionAnswers, step2ApparentCausesAnswers, a1);
        Thread.sleep(1000);
        //Download report
        obj2.downloadReport(driver,verifyChinese1, softly);
        //Delete report
        obj3.deleteReport(driver);
    }

    public List<String> removeColonFromAnswers(List<String> ac) throws Exception {

        List<String> a1 = new ArrayList<String>();
        for (int i=0;i<ac.size();i++)
        {
            int n = ac.get(i).indexOf(":");
            String s = ac.get(i).substring(0, n)+ac.get(i).substring(n+1, ac.get(i).length());
            a1.add(s);
        }
        return a1;
    }


    public void verifyStep4WithRandomStep2Selections(WebDriver driver, SoftAssertions softly,List<String> orderedApparentCauses) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver,5);
        List<String> ac = op3.modifyList(orderedApparentCauses);
        //Verify if any contributing factors are appearing
        int i=2;
        while(i<=((ac.size()*2)+1))
        {
            //Get name of level 3 answer
            String level3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]"))).getText();
            //Verify if this level 3 answer was selected
            if(orderedApparentCauses.contains(level3)==false)
            {
                softly.fail("Level 3 is not suppose to be here: "+level3);
            }
            //Increase i for changing corrective actions
            i=i+1;
            //Get label of corrective actions
            String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/label"))).getText();
            softly.assertThat(s).as("test data").contains("????????????:");
            String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/label/small"))).getText();
            softly.assertThat(s1).as("test data").contains("?????????????????????????????????????????????????????????????????????");
            //Verify text box has no alphabets
            String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/table/tbody/tr["+i+"]/td[1]/textarea"))).getText();
            checkIfEnglishCharactersExist(driver,s2,softly);
            //Increase i for next contributing factor
            i=i+1;
        }
    }

    public void checkIfEnglishCharactersExist(WebDriver driver, String s, SoftAssertions softly) throws Exception {

        String s1 = s.replace("Error-Free??", "");
        String s2 = s1.replace("QA", "");
        String s3 = s2.replace("O&P", "");
        Pattern p = Pattern.compile("[a-zA-Z]");
        boolean hasSpecialChar = p.matcher(s3).find();
        if(hasSpecialChar==true)
        {
            softly.fail("Should not contain any english characters: "+s3);
        }
    }

    public List<String> selectAllApparentCausesAnswers(WebDriver driver) throws Exception{

        WebDriverWait wait = new WebDriverWait(driver,5);
        WebDriverWait wait1 = new WebDriverWait(driver,2);
        List<String> ac = new ArrayList<String>();
        int count = 0;
        int k=1;
        //Identify number of answers for an apparent cause
        while(true)
        {
            try{
                String s = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+k+"]"))).getAttribute("class");
                k=k+1;
                if(s.equals("ui-contain"))
                    count = count +1;
            }catch(NoSuchElementException | org.openqa.selenium.TimeoutException e)
            {
                break;
            }
        }
        //Identify number of answers for an apparent cause
        for(int j=1;j<=count;j++)
        {
            //Check if answer is checked or not
            WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+j+"]/fieldset/div/div/input")));
            if(e.isSelected())
                continue;
            //Click on answer
            WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-opa-answers']/div["+j+"]/fieldset/div/div/label")));
            //Scroll to element
            share2.scrollToElement(driver, l);
            l.click();
            ac.add(l.getText());
        }
        //Scroll to top
        Thread.sleep(1000);
        share2.scrollToTop(driver);
        Thread.sleep(1000);
        //Click on next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
        return ac;
    }

    public void verifyChineseApparentCausesStep2(WebDriver driver, int n, String s) throws Exception {

        OPiRCAChinese obj = new OPiRCAChinese();
        //System.out.println(s);
        //D1
        if(s.startsWith("[D1]"))
        {
            if(n==1)
            {
                //o3
                obj.chineseApparentCauseO3(driver);
            }
            if(n==2)
            {
                //o1
                obj.chineseApparentCauseO1(driver);
            }
            if(n==3)
            {
                //o5
                obj.chineseApparentCauseO5(driver);
            }
        }
        //D2
        if(s.startsWith("[D2]"))
        {
            if((n==1)|| (n==2))
            {
                //op1
                obj.chineseApparentCauseOP1(driver);
            }
            if(n==3)
            {
                //o3
                obj.chineseApparentCauseO3(driver);
            }
            if(n==4)
            {
                //p5
                obj.chineseApparentCauseP5(driver);
            }
        }
        //D3
        if(s.startsWith("[D3]"))
        {
            if(n==1)
            {
                //p1
                obj.chineseApparentCauseP1(driver);
            }
            if(n==2)
            {
                //p2
                obj.chineseApparentCauseP2(driver);
            }
            if(n==3)
            {
                //p3
                obj.chineseApparentCauseP3(driver);
            }
            if(n==4)
            {
                //p4
                obj.chineseApparentCauseP4(driver);
            }
            if(n==5)
            {
                //op1
                obj.chineseApparentCauseOP1(driver);
            }
        }
        //D4
        if(s.startsWith("[D4]"))
        {
            if((n==1)|| (n==3))
            {
                //o1
                obj.chineseApparentCauseO1(driver);
            }
            if(n==2)
            {
                //o5
                obj.chineseApparentCauseO5(driver);
            }
            if(n==4)
            {
                //o3
                obj.chineseApparentCauseO3(driver);
            }
        }
        //D5
        if(s.startsWith("[D5]"))
        {
            if(n==1)
            {
                //o5
                obj.chineseApparentCauseO5(driver);
            }
            if(n==2)
            {
                //op4
                obj.chineseApparentCauseOP4(driver);
            }
            if(n==3)
            {
                //oo1
                obj.chineseApparentCauseOO1(driver);
            }
        }
        //D6
        if(s.startsWith("[D6]"))
        {
            if(n==1)
            {
                //op2
                obj.chineseApparentCauseOP2(driver);
            }
            if(n==2)
            {
                //o5
                obj.chineseApparentCauseO5(driver);
            }
            if(n==3)
            {
                //p1
                obj.chineseApparentCauseP1(driver);
            }
        }
        //D7
        if(s.startsWith("[D7]"))
        {
            if(n==1)
            {
                //o3
                obj.chineseApparentCauseO3(driver);
            }
            if(n==2)
            {
                //p5
                obj.chineseApparentCauseP5(driver);
            }
            if(n==3)
            {
                //p1
                obj.chineseApparentCauseP1(driver);
            }
        }
        //D9
        if(s.startsWith("[D9]"))
        {
            if(n==1)
            {
                //o5
                obj.chineseApparentCauseO5(driver);
            }
            if(n==4)
            {
                //op4
                obj.chineseApparentCauseOP4(driver);
            }
            if(n==2)
            {
                //op2
                obj.chineseApparentCauseOP2(driver);
            }
            if(n==3)
            {
                //oo1
                obj.chineseApparentCauseOO1(driver);
            }
        }
        //D11
        if(s.startsWith("[D11]"))
        {
            if(n==1)
            {
                //p5
                obj.chineseApparentCauseP5(driver);
            }
            if(n==2)
            {
                //p1
                obj.chineseApparentCauseP1(driver);
            }
        }
        //D12
        if(s.startsWith("[D12]"))
        {
            if(n==1)
            {
                //o5
                obj.chineseApparentCauseO5(driver);
            }
            if(n==2)
            {
                //op1
                obj.chineseApparentCauseOP1(driver);
            }
            if(n==3)
            {
                //p2
                obj.chineseApparentCauseP2(driver);
            }
        }
    }

    public void chineseApparentCauseO2(WebDriver driver, SoftAssertions softly) throws Exception{

        WebDriverWait wait = new WebDriverWait(driver,5);
        OPiRCAChinese obj1 = new OPiRCAChinese();
        //question
        String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
        softly.assertThat(heading).as("test data").contains("??????????????????????????????");
        //Click on Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionPlusSign)).click();
        //Description text
        String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionText)).getText();
        softly.assertThat(desc).as("test data").contains("??????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        softly.assertThat(desc).as("test data").contains("??????????????????????????????????????????: ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        //Click on Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionPlusSign)).click();
        //O1.1 question
        String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).getText();
        softly.assertThat(q1).as("test data").contains("[O2.1] ????????????????????????????????????");
        //Evidence entry collapsible text
        String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
        softly.assertThat(e1).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
        String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
        softly.assertThat(c1).as("test data").contains("?????????????????????");
        String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
        softly.assertThat(c2).as("test data").contains("???????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
        //O1.2 question
        String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer2)).getText();
        softly.assertThat(q2).as("test data").contains("[O2.2] ????????????????????????????????????????????????????????????");
        //Evidence entry collapsible text
        String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
        softly.assertThat(e2).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
        String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
        softly.assertThat(c3).as("test data").contains("?????????????????????");
        String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
        softly.assertThat(c4).as("test data").contains("??????????????????????????????????????????????????????????????????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
        //O1.3 question
        String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer3)).getText();
        softly.assertThat(q3).as("test data").contains("[O2.3] ??????????????????????????????????????????????????????????????????????????????");
        //Evidence entry collapsible text
        String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
        softly.assertThat(e3).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
        String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
        softly.assertThat(c5).as("test data").contains("?????????????????????");
        String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
        softly.assertThat(c6).as("test data").contains("??????????????????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
        //O1.4 question
        String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer4)).getText();
        softly.assertThat(q4).as("test data").contains("[O2.4] ????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        //Evidence entry collapsible text
        String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
        softly.assertThat(e4).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
        String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
        softly.assertThat(c7).as("test data").contains("?????????????????????");
        String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
        softly.assertThat(c8).as("test data").contains("?????????????????????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
        //Contributing factor
        obj1.chineseOPiRCAContributingFactor(driver);
    }

    public void chineseApparentCausePP1(WebDriver driver, SoftAssertions softly) throws Exception{

        WebDriverWait wait = new WebDriverWait(driver,5);
        OPiRCAChinese obj1 = new OPiRCAChinese();
        //question
        String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
        softly.assertThat(heading).as("test data").contains("????????????");
        //Click on Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionPlusSign)).click();
        //Description text
        String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionText)).getText();
        softly.assertThat(desc).as("test data").contains("?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        softly.assertThat(desc).as("test data").contains("?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        //Click on Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionPlusSign)).click();
        //O1.1 question
        String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).getText();
        softly.assertThat(q1).as("test data").contains("[PP1.1] ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        //Evidence entry collapsible text
        String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
        softly.assertThat(e1).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
        String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
        softly.assertThat(c1).as("test data").contains("?????????????????????");
        String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
        softly.assertThat(c2).as("test data").contains("???????????????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
        //O1.2 question
        String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer2)).getText();
        softly.assertThat(q2).as("test data").contains("[PP1.2] ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        //Evidence entry collapsible text
        String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
        softly.assertThat(e2).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
        String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
        softly.assertThat(c3).as("test data").contains("?????????????????????");
        String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
        softly.assertThat(c4).as("test data").contains("??????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
        //Contributing factor
        obj1.chineseOPiRCAContributingFactor(driver);
    }

    public void chineseApparentCausePP2(WebDriver driver, SoftAssertions softly) throws Exception{

        WebDriverWait wait = new WebDriverWait(driver,5);
        OPiRCAChinese obj1 = new OPiRCAChinese();
        //question
        String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
        softly.assertThat(heading).as("test data").contains("??????????????????");
        //Click on Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionPlusSign)).click();
        //Description text
        String desc = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionText)).getText();
        softly.assertThat(desc).as("test data").contains("???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        //Click on Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.Step1DescriptionPlusSign)).click();
        //P5.1 question
        String q1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).getText();
        softly.assertThat(q1).as("test data").contains("[PP2.1] ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        //Evidence entry collapsible text
        String e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry1)).getText();
        softly.assertThat(e1).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
        String c1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction1)).getText();
        softly.assertThat(c1).as("test data").contains("?????????????????????");
        String c2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction1Text1)).getText();
        softly.assertThat(c2).as("test data").contains("????????????-??????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction1)).click();
        //P5.2 question
        String q2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer2)).getText();
        softly.assertThat(q2).as("test data").contains("[PP2.2] ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        //Evidence entry collapsible text
        String e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry2)).getText();
        softly.assertThat(e2).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
        String c3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction2)).getText();
        softly.assertThat(c3).as("test data").contains("?????????????????????");
        String c4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction2Text1)).getText();
        softly.assertThat(c4).as("test data").contains("????????????-??????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction2)).click();
        //P5.3 question
        String q3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer3)).getText();
        softly.assertThat(q3).as("test data").contains("[PP2.3] ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        //Evidence entry collapsible text
        String e3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry3)).getText();
        softly.assertThat(e3).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
        String c5 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction3)).getText();
        softly.assertThat(c5).as("test data").contains("?????????????????????");
        String c6 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction3Text1)).getText();
        softly.assertThat(c6).as("test data").contains("????????????-??????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction3)).click();
        //P5.4 question
        String q4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer4)).getText();
        softly.assertThat(q4).as("test data").contains("[PP2.4] ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        //Evidence entry collapsible text
        String e4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry4)).getText();
        softly.assertThat(e4).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
        String c7 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction4)).getText();
        softly.assertThat(c7).as("test data").contains("?????????????????????");
        String c8 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction4Text1)).getText();
        softly.assertThat(c8).as("test data").contains("????????????-??????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction4)).click();
        //P5.5 question
        String q5 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer5)).getText();
        softly.assertThat(q5).as("test data").contains("[PP2.5] ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        //Evidence entry collapsible text
        String e5 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry5)).getText();
        softly.assertThat(e5).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
        String c9 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction5)).getText();
        softly.assertThat(c9).as("test data").contains("?????????????????????");
        String c10 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction5Text1)).getText();
        softly.assertThat(c10).as("test data").contains("????????????-??????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction5)).click();
        //Scroll down
        share2.scrollToAPoint(driver, 1500);
        //P5.6 question
        String q6 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer6)).getText();
        softly.assertThat(q6).as("test data").contains("[PP2.6] ??????????????????????????????????????????");
        //Evidence entry collapsible text
        String e6 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry6)).getText();
        softly.assertThat(e6).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
        String c11 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction6)).getText();
        softly.assertThat(c11).as("test data").contains("?????????????????????");
        String c12 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction6Text1)).getText();
        softly.assertThat(c12).as("test data").contains("????????????-??????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction6)).click();
        //P5.7 question
        String q7 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer7)).getText();
        softly.assertThat(q7).as("test data").contains("[PP2.7] ??????????????????????????????????????????????????????????????????");
        //Evidence entry collapsible text
        String e7 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerEvidenceEntry7)).getText();
        softly.assertThat(e7).as("test data").contains("????????????");
        //Corrective action
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
        String c13 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction7)).getText();
        softly.assertThat(c13).as("test data").contains("?????????????????????");
        String c14 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction7Text1)).getText();
        softly.assertThat(c14).as("test data").contains("????????????????????????????????????????????????????????????");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswerCorrectiveAction7)).click();
        //Contributing factor
        obj1.chineseOPiRCAContributingFactor(driver);
    }

    public List<String> chineseStep2AnswerLeadingToLevel3(WebDriver driver,SoftAssertions softly) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,10);
        OPiRCA2 obj2 = new OPiRCA2();
        OPiRCAChinese obj3 = new OPiRCAChinese();
        //Create list to add all apparent cause answers
        List<String> ac = new ArrayList<String>();
        //D1: integer is total no of answers in d1
        List<String> d1 = obj2.selectStep2D(driver,4,1,softly);
        //Select apparent cause for d1
        if(Integer.parseInt(d1.get(1))>0)
        {
            //Get 1st answer
            String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
            //Click next
            wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
            //Verify chinese
            verifyChineseApparentCausesStep2(driver,Integer.parseInt(d1.get(1)),s);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
        }
        //D2: integer is total no of answers in d2
        d1.addAll(obj2.selectStep2D(driver,5,1,softly));
        //Select apparent cause for d1
        if(Integer.parseInt(d1.get(3))>0)
        {
            //Get 1st answer
            String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
            //Click next
            wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
            //Verify chinese
            verifyChineseApparentCausesStep2(driver,Integer.parseInt(d1.get(3)),s);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
        }
        //D3: integer is total no of answers in d3
        d1.addAll(obj2.selectStep2D(driver,6,1,softly));
        //Select apparent cause for d3
        if(Integer.parseInt(d1.get(5))>0)
        {
            //Get 1st answer
            String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
            //Click next
            wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
            //Verify chinese
            verifyChineseApparentCausesStep2(driver,Integer.parseInt(d1.get(5)),s);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
        }
        //D4: integer is total no of answers in d4
        d1.addAll(obj2.selectStep2D(driver,5,1,softly));
        //Select apparent cause for d4
        if(Integer.parseInt(d1.get(7))>0)
        {
            //Get 1st answer
            String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
            //Click next
            wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
            //Verify chinese
            verifyChineseApparentCausesStep2(driver,Integer.parseInt(d1.get(7)),s);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
        }
        //D5: integer is total no of answers in d5
        d1.addAll(obj2.selectStep2D(driver,4,1,softly));
        //Select apparent cause for d5
        if(Integer.parseInt(d1.get(9))>0)
        {
            //Get 1st answer
            String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
            //Click next
            wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
            //Verify chinese
            verifyChineseApparentCausesStep2(driver,Integer.parseInt(d1.get(9)),s);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
            if(Integer.parseInt(d1.get(9))==3)
            {
                //oo2
                obj3.chineseApparentCauseOO2(driver);
                //Select Apparent cause answers
                ac.addAll(selectAllApparentCausesAnswers(driver));
                share2.scrollToTop(driver);
                //oo3
                obj3.chineseApparentCauseOO3(driver);
                //Select Apparent cause answers
                ac.addAll(selectAllApparentCausesAnswers(driver));
                share2.scrollToTop(driver);
            }
        }
        //D6: integer is total no of answers in d6
        d1.addAll(obj2.selectStep2D(driver,4,1,softly));
        //Select apparent cause for d6
        if(Integer.parseInt(d1.get(11))>0)
        {
            //Get 1st answer
            String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
            //Click next
            wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
            //Verify chinese
            verifyChineseApparentCausesStep2(driver,Integer.parseInt(d1.get(11)),s);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
            if(Integer.parseInt(d1.get(11))==3)
            {
                //p2
                obj3.chineseApparentCauseP2(driver);
                //Select Apparent cause answers
                ac.addAll(selectAllApparentCausesAnswers(driver));
                share2.scrollToTop(driver);
            }
        }
        //D7: integer is total no of answers in d7
        d1.addAll(obj2.selectStep2D(driver,4,1,softly));
        //Select apparent cause for d6
        if(Integer.parseInt(d1.get(13))>0)
        {
            //Get 1st answer
            String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
            //Click next
            wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
            //Verify chinese
            verifyChineseApparentCausesStep2(driver,Integer.parseInt(d1.get(13)),s);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
            if(Integer.parseInt(d1.get(13))==3)
            {
                //p2
                obj3.chineseApparentCauseP2(driver);
                //Select Apparent cause answers
                ac.addAll(selectAllApparentCausesAnswers(driver));
                share2.scrollToTop(driver);
            }
        }
        //D8
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).click();
        String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).getText();
        //add d8 text
        d1.add("D8.1: "+s);
        //add 0 to d1
        d1.add("0");
        //Select apparent cause for d8
        if(Integer.parseInt(d1.get(15))==0)
        {
            //Click next
            wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
            //o2
            chineseApparentCauseO2(driver, softly);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
        }
        //D9: integer is total no of answers in d9
        d1.addAll(obj2.selectStep2D(driver,5,1,softly));
        //Select apparent cause for d9
        if(Integer.parseInt(d1.get(17))>0)
        {
            //Get 1st answer
            String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
            //Click next
            wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
            //Verify chinese
            verifyChineseApparentCausesStep2(driver,Integer.parseInt(d1.get(17)),s1);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
        }
        //D10
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).click();
        String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).getText();
        //add d10 text
        d1.add("D10.1: "+s1);
        //add 0 to d1
        d1.add("0");
        //Select apparent cause for d10
        if(Integer.parseInt(d1.get(19))==0)
        {
            //Click next for op2
            wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
            obj3.chineseApparentCauseOP2(driver);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
            //op3
            obj3.chineseApparentCauseOP3(driver);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
            //pp1
            chineseApparentCausePP1(driver,softly);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
            //pp2
            chineseApparentCausePP2(driver,softly);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
            //o5
            obj3.chineseApparentCauseO5(driver);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
        }
        //D11: integer is total no of answers in d11
        d1.addAll(obj2.selectStep2D(driver,3,1,softly));
        //Select apparent cause for d6
        if(Integer.parseInt(d1.get(21))>0)
        {
            //Get 1st answer
            String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
            //Click next
            wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
            //Verify chinese
            verifyChineseApparentCausesStep2(driver,Integer.parseInt(d1.get(21)),s2);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
            if(Integer.parseInt(d1.get(21))==2)
            {
                //p2
                obj3.chineseApparentCauseP2(driver);
                //Select Apparent cause answers
                ac.addAll(selectAllApparentCausesAnswers(driver));
                share2.scrollToTop(driver);
            }
        }
        //D12: integer is total no of answers in d12
        d1.addAll(obj2.selectStep2D(driver,4,1,softly));
        //Select apparent cause for d9
        if(Integer.parseInt(d1.get(23))>0)
        {
            //Get 1st answer
            String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAInfoPageDesc)).getText();
            //Click next
            wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
            //Verify chinese
            verifyChineseApparentCausesStep2(driver,Integer.parseInt(d1.get(23)),s2);
            //Select Apparent cause answers
            ac.addAll(selectAllApparentCausesAnswers(driver));
            share2.scrollToTop(driver);
        }
        //Create a list to combine d1 and d12 answers and apparent causes selected
        List<String> combinedStep2 = new ArrayList<String>();
        for(int i=0;i<d1.size();i=i+2)
        {
            combinedStep2.add(d1.get(i));
        }
        //System.out.println(combinedStep2);
        combinedStep2.addAll(ac);
        return combinedStep2;
    }

    public List <String> chineseHTMLReportStep2Variation2(WebDriver driver, SoftAssertions softly) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver,10);
        List <String> ac = new ArrayList<String>();
        //Title
        String title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Title)).getText();
        softly.assertThat(title1).as("test data").contains("????????????????????????");
        ac.add(title1);
        //Headings
        String h1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Heading1)).getText();
        softly.assertThat(h1).as("test data").contains("????????????");
        ac.add(h1);
        String h2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Heading2)).getText();
        softly.assertThat(h2).as("test data").contains("??????");
        ac.add(h2);
        String h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Heading3)).getText();
        softly.assertThat(h3).as("test data").contains("????????????");
        ac.add(h3);
        //Row1
        String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row1Column1)).getText();
        softly.assertThat(r1).as("test data").contains("D1: ??????????????????????????????5%??????????????????");
        ac.add(r1);
        String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row1Column2)).getText();
        softly.assertThat(r2).as("test data").contains("D1.1: ???");
        ac.add(r2);
        String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row1Column3)).getText();
        softly.assertThat(r3).as("test data").contains("?????????");
        ac.add(r3);
        //Row2
        String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row2Column1)).getText();
        softly.assertThat(r4).as("test data").contains("D2: ???????????????????");
        ac.add(r4);
        String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row2Column2)).getText();
        softly.assertThat(r5).as("test data").contains("D2.1: ???");
        ac.add(r5);
        String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row2Column3)).getText();
        softly.assertThat(r6).as("test data").contains("?????????");
        //Row3
        String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row3Column1)).getText();
        softly.assertThat(r7).as("test data").contains("D3: ??????????????????????");
        ac.add(r7);
        String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row3Column2)).getText();
        softly.assertThat(r8).as("test data").contains("D3.1: ???");
        ac.add(r8);
        String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row3Column3)).getText();
        softly.assertThat(r9).as("test data").contains("?????????");
        //Row4
        String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row4Column1)).getText();
        softly.assertThat(r10).as("test data").contains("D4: ????????????????????????????????????????????????????????????????????????????????????????");
        ac.add(r10);
        String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row4Column2)).getText();
        softly.assertThat(r11).as("test data").contains("D4.1: ???");
        ac.add(r11);
        String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row4Column3)).getText();
        softly.assertThat(r12).as("test data").contains("?????????");
        //Row5
        String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row5Column1)).getText();
        softly.assertThat(r13).as("test data").contains("D5: ????????????????????????????????????????");
        ac.add(r13);
        String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row5Column2)).getText();
        softly.assertThat(r14).as("test data").contains("D5.1: ???");
        ac.add(r14);
        String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row5Column3)).getText();
        softly.assertThat(r15).as("test data").contains("?????????");
        //Row6
        String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row6Column1)).getText();
        softly.assertThat(r16).as("test data").contains("D6: ?????????????????????????????????????????????????????????????");
        ac.add(r16);
        String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row6Column2)).getText();
        softly.assertThat(r17).as("test data").contains("D6.1: ???");
        ac.add(r17);
        String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row6Column3)).getText();
        softly.assertThat(r18).as("test data").contains("?????????");
        //Row7
        String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row7Column1)).getText();
        softly.assertThat(r19).as("test data").contains("D7: ???????????????????????????");
        ac.add(r19);
        String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row7Column2)).getText();
        softly.assertThat(r20).as("test data").contains("D7.1: ???");
        ac.add(r20);
        String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row7Column3)).getText();
        softly.assertThat(r21).as("test data").contains("?????????");
        //Row8
        String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row8Column1)).getText();
        softly.assertThat(r22).as("test data").contains("D8: ????????????1????????????????????????????????????????????????????????????????????????????????????????????????");
        ac.add(r22);
        String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row8Column2)).getText();
        softly.assertThat(r23).as("test data").contains("D8.2: ???");
        ac.add(r23);
        String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row8Column3)).getText();
        softly.assertThat(r24).as("test data").contains("?????????");
        //Row9
        String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row9Column1)).getText();
        softly.assertThat(r25).as("test data").contains("D9: ???????????????????????????????????????????????????????????????????");
        ac.add(r25);
        String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row9Column2)).getText();
        softly.assertThat(r26).as("test data").contains("D9.1: ???");
        ac.add(r26);
        String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row9Column3)).getText();
        softly.assertThat(r27).as("test data").contains("?????????");
        //Row10
        String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row10Column1)).getText();
        softly.assertThat(r28).as("test data").contains("D10: ???????????????????????????????????????????????????????????????");
        ac.add(r28);
        String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row10Column2)).getText();
        softly.assertThat(r29).as("test data").contains("D10.2: ????????????0.2???");
        ac.add(r29);
        String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row10Column3)).getText();
        softly.assertThat(r30).as("test data").contains("?????????");
        //Row11
        String r31 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row11Column1)).getText();
        softly.assertThat(r31).as("test data").contains("D11: ??????????????????????????????20%??????????????????????????????????????????????");
        ac.add(r31);
        String r32 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row11Column2)).getText();
        softly.assertThat(r32).as("test data").contains("D11.1: ???");
        ac.add(r32);
        String r33 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row11Column3)).getText();
        softly.assertThat(r33).as("test data").contains("?????????");
        //Row12
        String r34 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row12Column1)).getText();
        softly.assertThat(r34).as("test data").contains("D12: ????????????????????????????????????????????????????????????????????????????");
        ac.add(r34);
        String r35 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row12Column2)).getText();
        softly.assertThat(r35).as("test data").contains("D12.1: ???");
        ac.add(r35);
        String r36 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAHTMLTable5Row12Column3)).getText();
        softly.assertThat(r36).as("test data").contains("?????????");
        return ac;
    }

    public void chineseReportTabStep2Variation2(WebDriver driver, SoftAssertions softly) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver,10);
        //Title
        String title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Title)).getText();
        softly.assertThat(title1).as("test data").contains("????????????????????????");
        //Headings
        String h1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Heading1)).getText();
        softly.assertThat(h1).as("test data").contains("????????????");
        String h2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Heading2)).getText();
        softly.assertThat(h2).as("test data").contains("??????");
        String h3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Heading3)).getText();
        softly.assertThat(h3).as("test data").contains("????????????");
        //Row1
        String r1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row1Column1)).getText();
        softly.assertThat(r1).as("test data").contains("D1: ??????????????????????????????5%??????????????????");
        String r2 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row1Column2)).getText();
        softly.assertThat(r2).as("test data").contains("D1.1: ???");
        String r3 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row1Column3)).getText();
        softly.assertThat(r3).as("test data").contains("?????????");
        //Row2
        String r4 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row2Column1)).getText();
        softly.assertThat(r4).as("test data").contains("D2: ???????????????????");
        String r5 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row2Column2)).getText();
        softly.assertThat(r5).as("test data").contains("D2.1: ???");
        String r6 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row2Column3)).getText();
        softly.assertThat(r6).as("test data").contains("?????????");
        //Row3
        String r7 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row3Column1)).getText();
        softly.assertThat(r7).as("test data").contains("D3: ??????????????????????");
        String r8 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row3Column2)).getText();
        softly.assertThat(r8).as("test data").contains("D3.1: ???");
        String r9 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row3Column3)).getText();
        softly.assertThat(r9).as("test data").contains("?????????");
        //Row4
        String r10 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row4Column1)).getText();
        softly.assertThat(r10).as("test data").contains("D4: ????????????????????????????????????????????????????????????????????????????????????????");
        String r11 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row4Column2)).getText();
        softly.assertThat(r11).as("test data").contains("D4.1: ???");
        String r12 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row4Column3)).getText();
        softly.assertThat(r12).as("test data").contains("?????????");
        //Row5
        String r13 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row5Column1)).getText();
        softly.assertThat(r13).as("test data").contains("D5: ????????????????????????????????????????");
        String r14 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row5Column2)).getText();
        softly.assertThat(r14).as("test data").contains("D5.1: ???");
        String r15 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row5Column3)).getText();
        softly.assertThat(r15).as("test data").contains("?????????");
        //Row6
        String r16 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row6Column1)).getText();
        softly.assertThat(r16).as("test data").contains("D6: ?????????????????????????????????????????????????????????????");
        String r17 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row6Column2)).getText();
        softly.assertThat(r17).as("test data").contains("D6.1: ???");
        String r18 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row6Column3)).getText();
        softly.assertThat(r18).as("test data").contains("?????????");
        //Row7
        String r19 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row7Column1)).getText();
        softly.assertThat(r19).as("test data").contains("D7: ???????????????????????????");
        String r20 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row7Column2)).getText();
        softly.assertThat(r20).as("test data").contains("D7.1: ???");
        String r21 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row7Column3)).getText();
        softly.assertThat(r21).as("test data").contains("?????????");
        //Row8
        String r22 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row8Column1)).getText();
        softly.assertThat(r22).as("test data").contains("D8: ????????????1????????????????????????????????????????????????????????????????????????????????????????????????");
        String r23 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row8Column2)).getText();
        softly.assertThat(r23).as("test data").contains("D8.2: ???");
        String r24 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row8Column3)).getText();
        softly.assertThat(r24).as("test data").contains("?????????");
        //Row9
        String r25 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row9Column1)).getText();
        softly.assertThat(r25).as("test data").contains("D9: ???????????????????????????????????????????????????????????????????");
        String r26 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row9Column2)).getText();
        softly.assertThat(r26).as("test data").contains("D9.1: ???");
        String r27 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row9Column3)).getText();
        softly.assertThat(r27).as("test data").contains("?????????");
        //Row10
        String r28 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row10Column1)).getText();
        softly.assertThat(r28).as("test data").contains("D10: ???????????????????????????????????????????????????????????????");
        String r29 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row10Column2)).getText();
        softly.assertThat(r29).as("test data").contains("D10.2: ????????????0.2???");
        String r30 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row10Column3)).getText();
        softly.assertThat(r30).as("test data").contains("?????????");
        //Row11
        String r31 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row11Column1)).getText();
        softly.assertThat(r31).as("test data").contains("D11: ??????????????????????????????20%??????????????????????????????????????????????");
        String r32 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row11Column2)).getText();
        softly.assertThat(r32).as("test data").contains("D11.1: ???");
        String r33 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row11Column3)).getText();
        softly.assertThat(r33).as("test data").contains("?????????");
        //Row12
        String r34 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row12Column1)).getText();
        softly.assertThat(r34).as("test data").contains("D12: ????????????????????????????????????????????????????????????????????????????");
        String r35 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row12Column2)).getText();
        softly.assertThat(r35).as("test data").contains("D12.1: ???");
        String r36 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAReportTabTable5Row12Column3)).getText();
        softly.assertThat(r36).as("test data").contains("?????????");
    }

    public void chineseStep2skip(WebDriver driver,SoftAssertions softly) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver,10);
        OPiRCAChinese obj1 = new OPiRCAChinese();
        //Verify chinese D1
        obj1.chineseStep2D1(driver);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        Thread.sleep(1000);
        //Verify chinese D2
        obj1.chineseStep2D2(driver);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        Thread.sleep(1000);
        //Verify chinese D3
        obj1.chineseStep2D3(driver);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        Thread.sleep(1000);
        //Verify chinese D4
        obj1.chineseStep2D4(driver);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        Thread.sleep(1000);
        //Verify chinese D5
        obj1.chineseStep2D5(driver);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        Thread.sleep(1000);
        //Verify chinese D6
        obj1.chineseStep2D6(driver);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        Thread.sleep(1000);
        //Verify chinese D7
        obj1.chineseStep2D7(driver);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        Thread.sleep(1000);
        //Verify chinese D8
        obj1.chineseStep2D8(driver);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        Thread.sleep(1000);
        //Verify chinese D9
        obj1.chineseStep2D9(driver);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        Thread.sleep(1000);
        //Verify chinese D10
        obj1.chineseStep2D10(driver);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        Thread.sleep(1000);
        //Verify chinese D11
        obj1.chineseStep2D11(driver);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
        Thread.sleep(1000);
        //Verify chinese D12
        obj1.chineseStep2D12(driver);
        bugKALE2493(driver,softly);
        //Click skip
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCASkipButton)).click();
    }

    public void bugKALE2494(WebDriver driver, SoftAssertions softly) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver,30);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //Click on About
        jse.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep5AboutLink)));
        jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep5AboutLink)));
        //Verify text for chinese
        String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep5AboutLastParagraphUnderBurp)).getText();
        softly.assertThat(s).as("test data").contains("????????????23???????????????4,500????????????");
        softly.assertThat(s).as("test data").contains("????????????????????????????????????????????????????????????????????????");
        String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep5AboutParagraphUnderTQA)).getText();
        softly.assertThat(s1).as("test data").isEqualTo("??????????????????????????????????????????????????????");
        //Click on About
        jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep5AboutLink)));
    }

    public void bugKALE2493(WebDriver driver, SoftAssertions softly) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver,30);
        //Click on About
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep2AboutLink)).click();
        //Verify text for chinese
        String s = wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep2About3rdParagraph)).getText();
        System.out.println("foundsm+fusesm: "+s);
        softly.assertThat(s).as("test data").doesNotContain("FOUNDSM");
        softly.assertThat(s).as("test data").doesNotContain("FUSESM");
        //Click on About
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAStep2AboutLink)).click();
    }

    public void chineseStep2AnswerLeadsToNextQuestion(WebDriver driver) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver,10);
        OPiRCAChinese obj1 = new OPiRCAChinese();
        //Verify chinese D1
        obj1.chineseStep2D1(driver);
        //Click D1.1
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).click();
        //Click next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
        Thread.sleep(1000);
        //Verify chinese D2
        obj1.chineseStep2D2(driver);
        //Click D2.1
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).click();
        //Click next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
        Thread.sleep(1000);
        //Verify chinese D3
        obj1.chineseStep2D3(driver);
        //Click D3.1
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).click();
        //Click next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
        Thread.sleep(1000);
        //Verify chinese D4
        obj1.chineseStep2D4(driver);
        //Click D4.1
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).click();
        //Click next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
        Thread.sleep(1000);
        //Verify chinese D5
        obj1.chineseStep2D5(driver);
        //Click D5.1
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).click();
        //Click next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
        Thread.sleep(1000);
        //Verify chinese D6
        obj1.chineseStep2D6(driver);
        //Click D6.1
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).click();
        //Click next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
        Thread.sleep(1000);
        //Verify chinese D7
        obj1.chineseStep2D7(driver);
        //Click D7.1
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).click();
        //Click next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
        Thread.sleep(1000);
        //Verify chinese D8
        obj1.chineseStep2D8(driver);
        //Click D8.2
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer2)).click();
        //Click next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
        Thread.sleep(1000);
        //Verify chinese D9
        obj1.chineseStep2D9(driver);
        //Click D9.1
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).click();
        //Click next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
        Thread.sleep(1000);
        //Verify chinese D10
        obj1.chineseStep2D10(driver);
        //Click D10.2
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer2)).click();
        //Click next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
        Thread.sleep(1000);
        //Verify chinese D11
        obj1.chineseStep2D11(driver);
        //Click D11.1
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).click();
        //Click next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
        Thread.sleep(1000);
        //Verify chinese D12
        obj1.chineseStep2D12(driver);
        //Click D12.1
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCAApparentCauseAnswer1)).click();
        //Click next
        wait.until(ExpectedConditions.visibilityOfElementLocated(opirca.OPiRCANextButton)).click();
    }

}