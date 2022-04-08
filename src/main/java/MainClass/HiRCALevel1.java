package MainClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import PageObjects.HiRCAObj;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterables;


public class HiRCALevel1 {

	SoftAssertions softly = new SoftAssertions();
	HiRCAFunctionsForLevel1_2_3 hfl123 = new HiRCAFunctionsForLevel1_2_3();
	TextBoxResizing tbr = new TextBoxResizing ();
	ShareCheck2 share2 = new ShareCheck2();
	ShareCheck share = new ShareCheck();
	HiRCAObj hirca = new HiRCAObj();

	public String text(WebDriver driver) throws Exception{

		if(driver.getCurrentUrl().contains("kaleqa"))
			return ("HiRCA Level 1 <iframe> test");
		else
			return("HiRCA Level 1 test");
	}

	public String textEvidence(WebDriver driver) throws Exception{

		if(driver.getCurrentUrl().contains("kaleqa"))
			return ("HiRCA evidence <script> entry text to be counted");
		else
			return("HiRCA evidence entry text to be counted");
	}

	public List<String> variableText(WebDriver driver) throws Exception{
		List<String> text = new ArrayList<String>();
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			text.add("Curabitur lacinia odio sit <div> amet tellus vestibulum condimentum. The resting sundry overcomes above the focus.");
			text.add("Vestibulum eget lectus <table> ut ligula tempus ultrices ac rhoncus libero. When can the incentive breakfast strike? Every arithmetic walks!");
			text.add("Integer ac enim eget <script> nisl malesuada tempor nec eu turpis. Our coordinate yard sauces the machine beneath an esoteric temple. The teapot sweeps beside the nostalgia.");
			text.add("Donec in massa pulvinar, mattis <section> turpis ut, aliquam ligula.");
			text.add("Morbi dictum mi et <article> nisl interdum, vel iaculis lacus suscipit. The stroke pushes the coach beneath any wood outcome?");
			text.add("Ut eu quam non orci <input> consectetur vestibulum et scelerisque sapien. The debt destroys every refined boy behind an ethic. Whatever compound sweeps into the concealed noun. The tomato posts a helmet.");
			text.add("Morbi accumsan leo <br> non ex tempor, congue ullamcorper urna viverra. Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
			text.add("In quis enim a odio <string> venenatis scelerisque dignissim sed mauris.");
			text.add("Maecenas ultrices <title> nulla nec malesuada ullamcorper.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.");
			text.add("Mauris mattis nisi quis <span> rhoncus mollis. In addition to generating an entire comedy routine, the software provides additional means to make existing content funnier.");
			text.add("In auctor lorem quis <thead> eros fermentum ultricies a at nibh. The tray boils under a deprived alcoholic. How can a beaten populace fork the climbing developer?");
			text.add("Curabitur quis mauris <tbody> ullamcorper, ultricies orci non, porttitor diam. A chord degenerates into the based fairy.");
			text.add("Fusce aliquet libero <td> vel risus luctus ullamcorper.");
			text.add("Vestibulum non risus <tr> sit amet lorem blandit tempus.");
			text.add("Fusce gravida libero <th> a neque cursus gravida.");
			text.add("Proin eget urna <a> tempor, ullamcorper lectus eget, elementum massa. The assumed plotter rushs toward the anatomy.");
			text.add("Quisque at justo <strong> elementum, finibus elit ut, ultrices nibh.");
			text.add("Pellentesque nec nulla <iframe> vel neque tincidunt rutrum.");
			text.add("Donec dictum enim nec <div> mi pulvinar, nec consequat eros tristique. A sky deletes a curtain over the bearded parameter. A handicap escapes near the constant! The vicar dances a threshold opposite a rough limb. The architecture outcries the pat jack after the reflex. An article cruises in the wartime.");
			text.add("Vestibulum lobortis <div> diam vel erat congue pulvinar sed a tortor.");
			text.add("In non leo et nibh porttitor <div> lobortis. A pan disturbs the barrister. Its password invalidates the gospel. A silver bath rests. When will the tempting fossil escape a shade? The unsafe collective lands a populace. When will our digital threshold moan? The ice grabs this carpet.");
			text.add("Donec hendrerit lacus semper <div> justo bibendum fermentum. The lousy lung stirs across the pedestrian homosexual. A vocal distresses the tile. How does an ineffective disease refresh the imperial rage? The complicate potato edges the derived nostalgia.");
			text.add("Sed tempus nunc interdum <div> neque sodales, at mollis magna convallis.");
			text.add("Aliquam efficitur sem quis <div> facilisis aliquam. Why won't the horizon progress above a crash friendship? How will the fine muck break outside the boy?");
			text.add("Proin blandit ante <div> at molestie finibus.");
			text.add("Etiam quis lorem laoreet, <div> malesuada lorem in, tristique sem.");
			text.add("Maecenas vitae orci non <div> dui ultrices posuere vulputate at elit. Why can't a south toe the line? A borderline beams beside the scheme. Can the duplicate rebuild the coincidence? The tooth destroys a raw powder into the tribe. How will the uncommon article stretch after the theology? The tolerant blessed slashes an ass.");
			text.add("Mauris blandit elit sit <div> amet tellus dignissim, eget maximus sem dignissim.");
			text.add("Morbi in dui semper, sagittis <div> augue in, elementum lorem.");
			text.add("Vivamus ut lacus finibus, dictum <div> neque interdum, tincidunt eros. Why does the axiom aim a cathedral purpose? An archive opens my orbital below the dangerous misprint. The sixty filter prices her metric lesbian. A world appears in the enemy listener. When will a mailed system interrupt the attendant? The milk detail frightens the improving warehouse.");
			text.add("Duis vestibulum ipsum at dui <div> tincidunt, semper eleifend est congue.");
			text.add("Lorem ipsum dolor <div> sit amet, consectetur adipiscing elit.");
		}
		else{
			text.add("Curabitur lacinia odio sit amet tellus vestibulum condimentum. The resting sundry overcomes above the focus.");
			text.add("Vestibulum eget lectus ut ligula tempus ultrices ac rhoncus libero. When can the incentive breakfast strike? Every arithmetic walks!");
			text.add("Integer ac enim eget nisl malesuada tempor nec eu turpis. Our coordinate yard sauces the machine beneath an esoteric temple. The teapot sweeps beside the nostalgia.");
			text.add("Donec in massa pulvinar, mattis turpis ut, aliquam ligula.");
			text.add("Morbi dictum mi et nisl interdum, vel iaculis lacus suscipit. The stroke pushes the coach beneath any wood outcome?");
			text.add("Ut eu quam non orci consectetur vestibulum et scelerisque sapien. The debt destroys every refined boy behind an ethic. Whatever compound sweeps into the concealed noun. The tomato posts a helmet.");
			text.add("Morbi accumsan leo non ex tempor, congue ullamcorper urna viverra. Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
			text.add("In quis enim a odio venenatis scelerisque dignissim sed mauris.");
			text.add("Maecenas ultrices nulla nec malesuada ullamcorper.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.");
			text.add("Mauris mattis nisi quis rhoncus mollis. In addition to generating an entire comedy routine, the software provides additional means to make existing content funnier.");
			text.add("In auctor lorem quis eros fermentum ultricies a at nibh. The tray boils under a deprived alcoholic. How can a beaten populace fork the climbing developer?");
			text.add("Curabitur quis mauris ullamcorper, ultricies orci non, porttitor diam. A chord degenerates into the based fairy.");
			text.add("Fusce aliquet libero vel risus luctus ullamcorper.");
			text.add("Vestibulum non risus sit amet lorem blandit tempus.");
			text.add("Fusce gravida libero a neque cursus gravida.");
			text.add("Proin eget urna tempor, ullamcorper lectus eget, elementum massa. The assumed plotter rushs toward the anatomy.");
			text.add("Quisque at justo elementum, finibus elit ut, ultrices nibh.");
			text.add("Pellentesque nec nulla vel neque tincidunt rutrum.");
			text.add("Donec dictum enim nec mi pulvinar, nec consequat eros tristique. A sky deletes a curtain over the bearded parameter. A handicap escapes near the constant! The vicar dances a threshold opposite a rough limb. The architecture outcries the pat jack after the reflex. An article cruises in the wartime.");
			text.add("Vestibulum lobortis diam vel erat congue pulvinar sed a tortor.");
			text.add("In non leo et nibh porttitor lobortis. A pan disturbs the barrister. Its password invalidates the gospel. A silver bath rests. When will the tempting fossil escape a shade? The unsafe collective lands a populace. When will our digital threshold moan? The ice grabs this carpet.");
			text.add("Donec hendrerit lacus semper justo bibendum fermentum. The lousy lung stirs across the pedestrian homosexual. A vocal distresses the tile. How does an ineffective disease refresh the imperial rage? The complicate potato edges the derived nostalgia.");
			text.add("Sed tempus nunc interdum neque sodales, at mollis magna convallis.");
			text.add("Aliquam efficitur sem quis facilisis aliquam. Why won't the horizon progress above a crash friendship? How will the fine muck break outside the boy?");
			text.add("Proin blandit ante at molestie finibus.");
			text.add("Etiam quis lorem laoreet, malesuada lorem in, tristique sem.");
			text.add("Maecenas vitae orci non dui ultrices posuere vulputate at elit. Why can't a south toe the line? A borderline beams beside the scheme. Can the duplicate rebuild the coincidence? The tooth destroys a raw powder into the tribe. How will the uncommon article stretch after the theology? The tolerant blessed slashes an ass.");
			text.add("Mauris blandit elit sit amet tellus dignissim, eget maximus sem dignissim.");
			text.add("Morbi in dui semper, sagittis augue in, elementum lorem.");
			text.add("Vivamus ut lacus finibus, dictum neque interdum, tincidunt eros. Why does the axiom aim a cathedral purpose? An archive opens my orbital below the dangerous misprint. The sixty filter prices her metric lesbian. A world appears in the enemy listener. When will a mailed system interrupt the attendant? The milk detail frightens the improving warehouse.");
			text.add("Duis vestibulum ipsum at dui tincidunt, semper eleifend est congue.");
			text.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		}
		return text;
	}

	public List<String> modifyText(WebDriver driver) throws Exception{
		List<String> text = new ArrayList<String>();
		if(driver.getCurrentUrl().contains("kaleqa"))
		{
			text.add("Quisque at justo <div> elementum, finibus elit ut, ultrices nibh.");
			text.add("Pellentesque nec <input> nulla vel neque tincidunt rutrum.");
			text.add("Donec dictum enim <strong> nec mi pulvinar, nec consequat eros tristique.");
			text.add("Vestibulum lobortis <html> diam vel erat congue pulvinar sed a tortor.");
			text.add("In non leo et nibh <span> porttitor lobortis.");
			text.add("Donec hendrerit <article> lacus semper justo bibendum fermentum.");
			text.add("Sed tempus nunc <table> interdum neque sodales, at mollis magna convallis.");
			text.add("Aliquam efficitur <tbody> sem quis facilisis aliquam.");
			text.add("Proin blandit ante <thead> at molestie finibus.");
			text.add("Etiam quis lorem <td> laoreet, malesuada lorem in, tristique sem.");
			text.add("Maecenas vitae orci <tr> non dui ultrices posuere vulputate at elit.");
			text.add("Mauris blandit elit <section> sit amet tellus dignissim, eget maximus sem dignissim.");
			text.add("Morbi in dui semper, sagittis <a> augue in, elementum lorem.");
			text.add("Vivamus ut lacus <iframe> finibus, dictum neque interdum, tincidunt eros.");
			text.add("Duis vestibulum <div> ipsum at dui tincidunt, semper eleifend est congue.");
			text.add("Lorem ipsum dolor <div> sit amet, consectetur adipiscing elit.");
		}
		else{
			text.add("Quisque at justo elementum, finibus elit ut, ultrices nibh.");
			text.add("Pellentesque nec nulla vel neque tincidunt rutrum.");
			text.add("Donec dictum enim nec mi pulvinar, nec consequat eros tristique.");
			text.add("Vestibulum lobortis diam vel erat congue pulvinar sed a tortor.");
			text.add("In non leo et nibh porttitor lobortis.");
			text.add("Donec hendrerit lacus semper justo bibendum fermentum.");
			text.add("Sed tempus nunc interdum neque sodales, at mollis magna convallis.");
			text.add("Aliquam efficitur sem quis facilisis aliquam.");
			text.add("Proin blandit ante at molestie finibus.");
			text.add("Etiam quis lorem laoreet, malesuada lorem in, tristique sem.");
			text.add("Maecenas vitae orci non dui ultrices posuere vulputate at elit.");
			text.add("Mauris blandit elit sit amet tellus dignissim, eget maximus sem dignissim.");
			text.add("Morbi in dui semper, sagittis augue in, elementum lorem.");
			text.add("Vivamus ut lacus finibus, dictum neque interdum, tincidunt eros.");
			text.add("Duis vestibulum ipsum at dui tincidunt, semper eleifend est congue.");
			text.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		}
		return text;
	}

	public void verifyHTMLReport(WebDriver driver, List<String>lopOptions, HashMap<String,Integer>options, HashMap<String,String>hml, List<String>checklist, int d,MultiValuedMap<String,String>hircaNoteLopSURE) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Get List to compare
		List<String> varText = variableText(driver);
		List<String> modText = modifyText(driver);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//Verify first table
		//Checks for Event title data
		String eve_title =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr/td[2]"))).getText().trim();
		String r = eve_title.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo(text(driver));
		//Checks for Location of event data
		String eve_loc =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[4]/td[2]"))).getText().trim();
		String r1 = eve_loc.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").isEqualTo(text(driver));
		//Checks for Investigators data
		String eve_inv =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div/table/tbody/tr[7]/td[2]"))).getText().trim();
		String r2 = eve_inv.replaceAll("\u00AD", "");
		softly.assertThat(r2).as("test data").isEqualTo(text(driver));
		//Checks for Problem statement data
		String eve_prob =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[2]/td[2]"))).getText().trim();
		String r3 = eve_prob.replaceAll("\u00AD", "");
		softly.assertThat(r3).as("test data").isEqualTo(text(driver));
		//Checks for Timeline of event data
		String eve_timeline =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[3]/td[2]"))).getText().trim();
		String r4 = eve_timeline.replaceAll("\u00AD", "");
		softly.assertThat(r4).as("test data").isEqualTo(text(driver));
		//Checks for Background information data
		String eve_back =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[2]/table/tbody/tr[4]/td[2]"))).getText().trim();
		String r5 = eve_back.replaceAll("\u00AD", "");
		softly.assertThat(r5).as("test data").isEqualTo(text(driver));
		//List to help compare
		List<String>lopOptions1 = new ArrayList<String>();
		//Remove the ] from Level 3 answers
		for (int j=0;j<lopOptions.size();j++)
		{
			String p = lopOptions.get(j).replace("]", "");
			lopOptions1.add(p);
		}
		//verify if any root cause exists
		//int rc = Collections.frequency(options, 4);
		int rc,cf;
		if(lopOptions.size()>0)
		{
			rc = options.get("Root causes");
			System.out.println(rc);
			//Get number of contributing factors
			cf = lopOptions.size()-rc;
			System.out.println(cf);
		}
		else
		{
			rc=0;
			cf=0;
		}
		//When no root causes present
		if (rc==0)
		{
			//Verify Root cause as n/a
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[1]"))).getText().trim();
			softly.assertThat(s).as("test data").isEqualTo("n/a");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[2]"))).getText().trim();
			softly.assertThat(s1).as("test data").isEqualTo("n/a");
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div[4]/table/tbody/tr/td[3]"))).getText().trim();
			softly.assertThat(s2).as("test data").isEqualTo("n/a");		
		}
		//When root cause is present
		for (int i=4;i<=rc+3;i++)
		{
			//Get name of level 3 answer
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+i+"]/table/tbody/tr/td[1]"))).getText().trim();
			System.out.println(s);
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(s)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+s);
			}
			//Check if it has 4 boxes ticked
			if(options.get(s)!=4)
			{
				softly.fail("Not a root cause, Not all four boxes are ticked, only some are: "+ options.get(s));
			}
			//Get importance and verify
			//	String s1 = ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+i+"]/table/tbody/tr/td[2]")))).toString();
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+i+"]/table/tbody/tr/td[2]"))).getAttribute("textContent");
			//Get corresponding Importance value from hashmap
			String s2 = hml.get(s);
			//Verify high medium low
			if(browserName.contains("safari"))
				softly.assertThat(s1).as("test data").contains(s2);	
			else softly.assertThat(s1).as("test data").isEqualTo(s2);
			//Get corrective actions
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+i+"]/table/tbody/tr/td[3]"))).getText().trim();
			String re4 = s3.replaceAll("\u00AD", "");
			if(d==0)
			{
				if(varText.contains(re4)==false)
					softly.fail("Text wrong: "+re4);
				//softly.assertThat(s3).as("test data").isEqualTo(text);
			}
			if(d==1)
			{
				if(modText.contains(re4)==false)
					softly.fail("Text wrong: "+re4);
				//softly.assertThat(s3).as("test data").isEqualTo(text1);
			}
			int j=2;
			String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+i+"]/table/tbody/tr["+j+"]/td/span"))).getText().trim();
			List<String> temp = new ArrayList<String>(hircaNoteLopSURE.get(s));
			softly.assertThat(note).as("test data").isEqualTo(temp.get(0));
			j=j+1;
			//Verify Supporting Evidence
			String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+i+"]/table/tbody/tr["+j+"]/td"))).getText().trim();
			String re3 = s4.replaceAll("\u00AD", "");
			softly.assertThat(re3).as("test data").contains(textEvidence(driver));
			//Verify Extent of condition
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+i+"]/table[2]/tbody/tr[2]/td[2]"))).getText().trim();
			String re2 = s5.replaceAll("\u00AD", "");
			if(d==0)
			{
				if(varText.contains(re2)==false)
					softly.fail("Text wrong: "+re2);
				//softly.assertThat(s5).as("test data").isEqualTo(text);
			}
			if(d==1)
			{
				if(modText.contains(re2)==false)
					softly.fail("Text wrong: "+re2);
				//softly.assertThat(s5).as("test data").isEqualTo(text1);
			}
			//Verify Operating Experience
			String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+i+"]/table[2]/tbody/tr[3]/td[2]"))).getText().trim();
			String re1 = s6.replaceAll("\u00AD", "");
			if(d==0)
			{
				if(varText.contains(re1)==false)
					softly.fail("Text wrong: "+re1);
			}
			if(d==1)
			{
				if(modText.contains(re1)==false)
					softly.fail("Text wrong: "+re1);
			}
			//Verify Safety Culture
			String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+i+"]/table[2]/tbody/tr[4]/td[2]"))).getText().trim();
			String re = s7.replaceAll("\u00AD", "");
			if(d==0)
			{
				if(varText.contains(re)==false)
					softly.fail("Text wrong: "+re);
			}
			if(d==1)
			{
				if(modText.contains(re)==false)
					softly.fail("Text wrong: "+re);
			}
		}
		if(rc==0)
		{
			//Because there will be a div with Root Cause as n/a
			rc=rc+1;
		}		
		//When no contributing factors present
		if(cf==0)
		{
			//Verify Contributing factors as n/a
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr/td[1]"))).getText().trim();
			softly.assertThat(s).as("test data").isEqualTo("n/a");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr/td[2]"))).getText().trim();
			softly.assertThat(s1).as("test data").isEqualTo("n/a");
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr/td[3]"))).getText().trim();
			softly.assertThat(s2).as("test data").isEqualTo("n/a");					
		}
		//When contributing factors are present
		int i=1;
		if ((options.size()>0)&&(options.get("Root causes")!=0))
		{
			while(i<=(cf*2))
			{
				//Get name of level 3 answer
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
				System.out.println(s);
				//Verify if this level 3 answer was selected
				if(lopOptions1.contains(s)==false)
				{
					softly.fail("Level 3 is not suppose to be here: "+s);
				}
				//Check if it has 4 boxes ticked
				if(options.get(s)==4)
				{
					softly.fail("Not a contributing factor, All four boxes are ticked, only some should be: "+ options.get(s));
				}
				//Get importance and verify
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[2]"))).getText().trim();
				//Get corresponding Importance value from hashmap
				String s2 = hml.get(s);
				//Verify high medium low
				if(browserName.toLowerCase().contains("safari")==false)				
					softly.assertThat(s1).as("test data").isEqualTo(s2);
				else
				{
					softly.assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[2]"))).getAttribute("textContent").trim()).as("test data").isEqualTo(s2);
				}
				//Get corrective actions
				String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[3]"))).getText().trim();
				String re = s3.replaceAll("\u00AD", "");
				if(d==0)
				{
					if(varText.contains(re)==false)
						softly.fail("Text wrong: "+re);
					//softly.assertThat(s3).as("test data").isEqualTo(text);
				}
				if(d==1)
				{
					if(modText.contains(re)==false)
						softly.fail("Text wrong: "+re);
					//softly.assertThat(s3).as("test data").isEqualTo(text1);
				}
				//Increase i for supporting evidence
				i=i+1;
				String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td/span"))).getText().trim();
				List<String> temp = new ArrayList<String>(hircaNoteLopSURE.get(s));
				softly.assertThat(note).as("test data").isEqualTo(temp.get(0));
				i=i+1;
				//Verify Supporting Evidence
				String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td"))).getText().trim();
				String re5 = s4.replaceAll("\u00AD", "");
				softly.assertThat(re5).as("test data").contains(textEvidence(driver));
				//Increase i for next cf
				i=i+1;
			}
		}
		if ((options.size()>0)&&(options.get("Root causes")==0))
		{
			while(i<(cf*2))
			{
				//Get name of level 3 answer
				String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
				System.out.println(s);
				//Verify if this level 3 answer was selected
				if(lopOptions1.contains(s)==false)
				{
					softly.fail("Level 3 is not suppose to be here: "+s);
				}
				//Check if it has 4 boxes ticked
				if(options.get(s)==4)
				{
					softly.fail("Not a contributing factor, All four boxes are ticked, only some should be: "+ options.get(s));
				}
				//Get importance and verify
				String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[2]"))).getText().trim();
				//Get corresponding Importance value from hashmap
				String s2 = hml.get(s);
				//Verify high medium low
				if(browserName.toLowerCase().contains("safari")==false)				
					softly.assertThat(s1).as("test data").isEqualTo(s2);
				else
				{
					//softly.assertThat(((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[2]")))).toString()).as("test data").isEqualTo(s2);
					//softly.assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[2]"))).getAttribute("textContent")).as("test data").contains(s2);
				}
				//Get corrective actions
				String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[3]"))).getText().trim();
				String re1 = s3.replaceAll("\u00AD", "");
				if(d==0)
				{
					if(varText.contains(re1)==false)
						softly.fail("Text wrong: "+re1);
					//softly.assertThat(s3).as("test data").isEqualTo(text);
				}
				if(d==1)
				{
					if(modText.contains(re1)==false)
						softly.fail("Text wrong: "+re1);
					//softly.assertThat(s3).as("test data").isEqualTo(text1);
				}
				//Increase i for supporting evidence
				i=i+1;
				String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td/span"))).getText().trim();
				List<String> temp = new ArrayList<String>(hircaNoteLopSURE.get(s));
				softly.assertThat(note).as("test data").isEqualTo(temp.get(0)); 
				i=i+1;
				//Verify Supporting Evidence
				String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td"))).getText().trim();
				String re = s4.replaceAll("\u00AD", "");
				softly.assertThat(re).as("test data").contains(textEvidence(driver));
				//Increase i for next cf
				i=i+1;
			}
		}
		//Verify Root Cause Analysis
		String rc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+5)+"]/table/tbody/tr[1]/td[2]"))).getText().trim();
		softly.assertThat(rc1).as("test data").isEqualTo("Equipment failure");
		//Verify 3.17 answer under Root Cause Analysis
		for(i=1;i<=lopOptions1.size();i++)
		{
			try{
				String lop1=driver.findElement(By.xpath(".//*[@id='irca-rpt']/div["+(rc+5)+"]/table/tbody/tr[2]/td/div/table/tbody/tr["+i+"]/td[1]")).getText().trim();
				//Verify if this level 3 answer was selected
				if(lopOptions1.contains(lop1)==false)
				{
					softly.fail("Level 3 is not suppose to be here: "+lop1);
				}
				String lop2=driver.findElement(By.xpath(".//*[@id='irca-rpt']/div["+(rc+5)+"]/table/tbody/tr[2]/td/div/table/tbody/tr["+i+"]/td[2]")).getText().trim();
				String re = lop2.replaceAll("\u00AD", "");
				softly.assertThat(re).as("test data").isEqualTo(textEvidence(driver));
			}catch(NoSuchElementException u)
			{
				break;
			}		  
		}
		//Verify SUEP
		for(i=1;i<=lopOptions1.size();i++)
		{
			//Verify level3 answer
			String s1=driver.findElement(By.xpath(".//*[@id='irca-rpt']/div["+(rc+7)+"]/table/tbody/tr["+i+"]/td[1]")).getText().trim();
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(s1)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+s1);
			}
			//Number of SUEP checks
			int num = options.get(s1);
			if(num==0)
			{
				i=i+1;
				continue;
			}
			for (int j=1;j<=num;j++)
			{
				String s2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+7)+"]/table/tbody/tr["+i+"]/td["+(j+1)+"]"))).getText().trim();
				if(browserName.toLowerCase().contains("safari")==false)				
					softly.assertThat(s2).as("test data").isEqualTo("Yes");
				else
				{
					//softly.assertThat(((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+7)+"]/table/tbody/tr["+i+"]/td["+(j+1)+"]")))).toString()).as("test data").isEqualTo("Yes");
					softly.assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+7)+"]/table/tbody/tr["+i+"]/td["+(j+1)+"]"))).getAttribute("textContent")).as("test data").contains("Yes");
				}
			}
			i=i+1;
			String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='irca-rpt']/div["+(rc+7)+"]/table/tbody/tr["+i+"]/td/span"))).getText().trim();
			List<String> temp = new ArrayList<String>(hircaNoteLopSURE.get(s1));
			softly.assertThat(note).as("test data").isEqualTo(temp.get(0));
		}
		//No Level 3 answers selected, SUEP skipped increases one more div, so rc increased by 1
		if(lopOptions.size()==0)
			rc=rc+1;
		//Verify HiRCA self checklist
		//if checklist is empty then return
		if (checklist.size()==0)
			return;
		for(i=1;i<=11;i++)
		{
			//Get Area Checked
			String s1=driver.findElement(By.xpath(".//*[@id='irca-rpt']/div["+(rc+9)+"]/table/tbody/tr["+i+"]/td[2]")).getText().trim();
			//Verify if Yes
			if(checklist.contains(s1)==true)
			{
				String s2=driver.findElement(By.xpath(".//*[@id='irca-rpt']/div["+(rc+9)+"]/table/tbody/tr["+i+"]/td[3]")).getText().trim();
				softly.assertThat(s2).as("test data").isEqualTo("Yes");
			}
		}
	}

	public void deleteFiles(File folder) throws IOException {
		File[] files = folder.listFiles();
		for(File file: files){
			if(file.isFile()){
				String fileName = file.getName();
				boolean del= file.delete();
				System.out.println(fileName + " : got deleted ? " + del);
			}else if(file.isDirectory()) {
				deleteFiles(file);
			}
		}
	}

	public void downloadReportChrome (WebDriver driver, List<String>lopOptions, HashMap<String,String>hml,HashMap<String,Integer>options,List<String>checklist) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Pictures//");
//		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\ChromSavePDF5_amlocal.exe");
		Thread.sleep(8000);
		pdfCheck(driver,lopOptions,hml,options,checklist);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(1000);
	}

	public void downloadReportFirefox(WebDriver driver, List<String>lopOptions,HashMap<String,String>hml,HashMap<String,Integer>options,List<String>checklist) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(8000);
		for(String winHandle : driver.getWindowHandles())
		{
			System.out.println(winHandle);
			if(winHandle.isEmpty()==false)
			{
				if(winHandle.equals(window)==false)
					driver.switchTo().window(winHandle);
			}
		}
		Thread.sleep(4000);
		List<String> results = new ArrayList<String>();
		File[] files = new File("C://Users//mama//Downloads//EFTestDownloadReports//").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		for (File file1 : files) {
			if (file1.isFile()) {
				results.add(file.getName());
			}
		}
		System.out.println(results.get(0));
		if(results.get(0).endsWith(".pdf")==false)
		{
			driver.switchTo().window(window);
			deleteFiles(file);
			//Clicks on download button
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
			//Wait for loading message to disappear
			share2.loadingServer(driver);
			//Clicks on open pdf report
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
			Thread.sleep(8000);
			for(String winHandle : driver.getWindowHandles())
			{
				System.out.println(winHandle);
				if(winHandle.isEmpty()==false)
				{
					if(winHandle.equals(window)==false)
						driver.switchTo().window(winHandle);
				}
			}
			Thread.sleep(4000);
		}
		pdfCheck(driver,lopOptions,hml,options,checklist);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();      	    		    	
	}

	public void downloadReportIE(WebDriver driver, List<String>lopOptions,HashMap<String,String>hml,HashMap<String,Integer>options,List<String>checklist)throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		Thread.sleep(2000);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/rramakrishnan/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(7000);
		//pdf verification
		pdfCheck(driver,lopOptions,hml,options,checklist);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);				    		    	
	}


	public void downloadReportIE11(WebDriver driver, List<String>lopOptions,HashMap<String,String>hml,HashMap<String,Integer>options,List<String>checklist)throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on first newly created record
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		Thread.sleep(2000);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[2]"))).click();
		Thread.sleep(3000);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-title"))).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		Thread.sleep(3000);
		try {
			Process q = Runtime.getRuntime().exec("C:/Users/IEUser/AutoItScripts/SavePdf.exe");
			q.waitFor();
		}catch (UnhandledAlertException f){	
			System.out.println("Unexpected alert");
			driver.switchTo().alert().accept();

		}catch (NoAlertPresentException f){
			System.out.println ("No unexpected alert");
		}
		Thread.sleep(7000);
		//pdf verification
		pdfCheck(driver,lopOptions,hml,options,checklist);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);				    		    	
	}

	public void pdfCheck(WebDriver driver, List<String>lopOptions, HashMap<String,String>hml,HashMap<String,Integer>options, List<String>checklist) throws Exception{

		// specify your directory
		Path dir = Paths.get("C://Users//mama//Downloads//EFTestDownloadReports//");  
		// here we get the stream with full directory listing
		// exclude subdirectories from listing
		// finally get the last file using simple comparator by lastModified field
		Optional<Path> lastFilePath = Files.list(dir).filter(f -> !Files.isDirectory(f)).max(Comparator.comparingLong(f -> f.toFile().lastModified()));  
		try{
			System.out.println(lastFilePath.get());
		}catch(java.util.NoSuchElementException t)
		{

		}
		//Loads the file to check if correct data is present
		String fileName=lastFilePath.get().toString();
		File oldfile = new File(fileName);
		PDDocument pddoc= PDDocument.load(oldfile);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		System.out.println(ans);
		String newData1="";
		for (int i = 0; i < ans.size(); i++)
		{	        	
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData1 = newData1+ans.get(i);
			if (ans.get(i).charAt(n)!=' ')
				newData1 = newData1+" "+ans.get(i);	        	
		}
		int y=newData1.indexOf("℠");
		newData1 = new StringBuilder(newData1).insert(y+1, " ").toString();
		newData1=newData1.replace("  ", " ");
		System.out.println(newData1);
		//Verifies if selected RCs and CFs appear in pdf
		for (int i= 0; i<lopOptions.size();i++)
		{
			String s = lopOptions.get(i).replace("]", "");
			softly.assertThat(s).as("test data").isSubstringOf(newData1);
		}
		//Verifies if selected HiRCA checklist appears with yes in pdf
		for(int i=0;i<checklist.size();i++)
		{
			String s = checklist.get(i)+ " Yes";
			softly.assertThat(s).as("test data").isSubstringOf(newData1);
		}
		//Verify RC and CF text in pdf
		//Get List to compare
		List<String> varText = variableText(driver);
		List<String> modText = modifyText(driver);
		int c1=0;
		int c2=0;
		for (int i=0;i<varText.size();i++)
		{
			if(newData1.contains(varText.get(i)))
				c1 = c1+1;
		}
		for (int i=0;i<modText.size();i++)
		{
			if(newData1.contains(modText.get(i)))
				c2 = c2+1;
		}
		if((c1>0)||(c2>0))
		{
			if((c2==0) && (c1==0) && (lopOptions.size()>0))
				softly.fail("pdf doesn't contain any text from Step 4 text boxes");
		}
		//Verify SUEP Yes
		for (int i= 0; i<lopOptions.size();i++)
		{
			String s = lopOptions.get(i).replace("]", "");
			if(options.get(s)==4)
			{
				softly.assertThat(s+" Yes Yes Yes Yes").as("test data").isSubstringOf(newData1);
			}
			if(options.get(s)==3)
			{
				softly.assertThat(s+" Yes Yes Yes").as("test data").isSubstringOf(newData1);
			}
			if(options.get(s)==2)
			{
				softly.assertThat(s+" Yes Yes").as("test data").isSubstringOf(newData1);
			}
			if(options.get(s)==1)
			{
				softly.assertThat(s+" Yes").as("test data").isSubstringOf(newData1);
			}
			else
				softly.assertThat(s).as("test data").isSubstringOf(newData1);
		}
		//Counts number of times evidence entry was entered
		int n= lopOptions.size();
		if(newData1.contains(textEvidence(driver)))
		{
			Pattern p = Pattern.compile(textEvidence(driver));
			Matcher m = p.matcher(newData1);
			int count = 0;
			while (m.find()){
				count +=1;
			}
			System.out.println("No. of evidence entries: "+count);
			softly.assertThat(count).as("test data").isEqualTo(n*2);
		}
		System.out.println(options);
		System.out.println(hml);
		if(n>0)
		{
			//Check HML order for root cause
			if(options.get("Root causes")>0)
			{
				//Create 4 different lists to store level 3 for High, Medium, Low, ""
				List<String> highrc = new ArrayList<String>();
				List<String> mediumrc = new ArrayList<String>();
				List<String> lowrc = new ArrayList<String>();
				List<String> nonerc = new ArrayList<String>();
				for (Map.Entry<String, Integer> e : options.entrySet())
				{
					//If it has 4 ticks in SUEP then its a RC
					if(e.getValue()==4)
					{
						String s = e.getKey();
						if(s.startsWith("3.17.4"))
						{
							s=s.replace("3.17.4:", "3.17.4");
						}
						else
							s=s.replace(":", "");
						if(hml.get(s)=="High")
						{
							highrc.add(s);
						}
						if(hml.get(s)=="Medium")
						{
							mediumrc.add(s);
						}
						if(hml.get(s)=="Low")
						{
							lowrc.add(s);
						}
						if(hml.get(s)=="")
						{
							nonerc.add(s);
						}
					}    			   
				}
				//Sort the lists
				Collections.sort(highrc);
				Collections.sort(mediumrc);
				Collections.sort(lowrc);
				Collections.sort(nonerc);
				System.out.println(highrc);
				System.out.println(mediumrc);
				System.out.println(lowrc);
				System.out.println(nonerc);
				if(highrc.size()>0)
				{
					//Look for Level 3 answers with high importance and verify if index in pdf data is lower
					int index;
					int index1=newData1.indexOf((highrc.get(0)+ " High"))-1;
					for(int i =0;i<highrc.size();i++)
					{
						index = newData1.indexOf((highrc.get(i)+ " High"));
						if(index>index1)
						{
							index1 = index;
						}
						else softly.fail("Order for High is wrong for root cause in pdf");
					}
				}
				if(mediumrc.size()>0)
				{
					//Look for Level 3 answers with medium importance and verify if index in pdf data is lower
					int index;
					int index1=newData1.indexOf((mediumrc.get(0)+ " Medium"))-1;
					for(int i =0;i<mediumrc.size();i++)
					{
						index = newData1.indexOf((mediumrc.get(i)+ " Medium"));
						if(index>index1)
						{
							index1 = index;
						}
						else softly.fail("Order for Medium is wrong for root cause in pdf");
					}
				}
				if(lowrc.size()>0)
				{
					//Look for Level 3 answers with low importance and verify if index in pdf data is lower
					int index;
					int index1=newData1.indexOf((lowrc.get(0)+ " Low"))-1;
					for(int i =0;i<lowrc.size();i++)
					{
						index = newData1.indexOf((lowrc.get(i)+ " Low"));
						if(index>index1)
						{
							index1 = index;
						}
						else softly.fail("Order for Low is wrong for root cause in pdf");
					}
				}
				if(nonerc.size()>0)
				{
					//Look for Level 3 answers with no importance and verify if index in pdf data is lower
					int index;
					int index1=newData1.indexOf(nonerc.get(0))-1;
					for(int i =0;i<nonerc.size();i++)
					{
						index = newData1.indexOf(nonerc.get(i));
						if(index>index1)
						{
							index1 = index;
						}
						else softly.fail("Order for no importance is wrong for root cause in pdf");
					}
				}
				//Check if last high comes before 1st medium, 1st low, 1st none
				if(highrc.size()>0 && mediumrc.size()>0)
				{
					int index = newData1.indexOf(highrc.get(highrc.size()-1));
					int index1 = newData1.indexOf(mediumrc.get(0));
					if(index>index1)
						softly.fail("High importance comes after medium in root cause in pdf");
				}
				if(highrc.size()>0 && lowrc.size()>0)
				{
					int index = newData1.indexOf(highrc.get(highrc.size()-1));
					int index1 = newData1.indexOf(lowrc.get(0));
					if(index>index1)
						softly.fail("High importance comes after low in root cause in pdf");
				}
				if(highrc.size()>0 && nonerc.size()>0)
				{
					int index = newData1.indexOf(highrc.get(highrc.size()-1));
					int index1 = newData1.indexOf(nonerc.get(0));
					if(index>index1)
						softly.fail("High importance comes after none in root cause in pdf");
				}
				//Check if last medium comes before 1st low, 1st none
				if(mediumrc.size()>0 && lowrc.size()>0)
				{
					int index = newData1.indexOf(mediumrc.get(mediumrc.size()-1));
					int index1 = newData1.indexOf(lowrc.get(0));
					if(index>index1)
						softly.fail("Medium importance comes after low in root cause in pdf");
				}
				if(mediumrc.size()>0 && nonerc.size()>0)
				{
					int index = newData1.indexOf(mediumrc.get(mediumrc.size()-1));
					int index1 = newData1.indexOf(nonerc.get(0));
					if(index>index1)
						softly.fail("Medium importance comes after none in root cause in pdf");
				}
				//Check if last low comes before 1st none
				if(lowrc.size()>0 && nonerc.size()>0)
				{
					int index = newData1.indexOf(lowrc.get(lowrc.size()-1));
					int index1 = newData1.indexOf(nonerc.get(0));
					if(index>index1)
						softly.fail("Low importance comes after none in root cause in pdf");
				}
			}

			//Check HML order for contributing factor
			int cf = n-options.get("Root causes");
			if(cf>0)
			{
				//Create 4 different lists to store level 3 for High, Medium, Low, ""
				List<String> highcf = new ArrayList<String>();
				List<String> mediumcf = new ArrayList<String>();
				List<String> lowcf = new ArrayList<String>();
				List<String> nonecf = new ArrayList<String>();
				for (Map.Entry<String, Integer> e : options.entrySet())
				{
					//If it has 4 ticks in SUEP then its a RC
					if(e.getValue()!=4)
					{
						String s = e.getKey();
						if(s.startsWith("3.17.4"))
						{
							s=s.replace("3.17.4:", "3.17.4");
						}
						else
							s=s.replace(":", "");
						if(hml.get(s)=="High")
						{
							highcf.add(s);
						}
						if(hml.get(s)=="Medium")
						{
							mediumcf.add(s);
						}
						if(hml.get(s)=="Low")
						{
							lowcf.add(s);
						}
						if(hml.get(s)=="")
						{
							nonecf.add(s);
						}
					}    			   
				}
				//Sort the lists
				Collections.sort(highcf);
				Collections.sort(mediumcf);
				Collections.sort(lowcf);
				Collections.sort(nonecf);
				System.out.println(highcf);
				System.out.println(mediumcf);
				System.out.println(lowcf);
				System.out.println(nonecf);
				if(highcf.size()>0)
				{
					//Look for Level 3 answers with high importance and verify if index in pdf data is lower
					int index;
					int index1=newData1.indexOf((highcf.get(0)+ " High"))-1;
					for(int i =0;i<highcf.size();i++)
					{
						index = newData1.indexOf((highcf.get(i)+ " High"));
						if(index>index1)
						{
							index1 = index;
						}
						else softly.fail("Order for High is wrong for contributing factor in pdf");
					}
				}
				if(mediumcf.size()>0)
				{
					//Look for Level 3 answers with medium importance and verify if index in pdf data is lower
					int index;
					int index1=newData1.indexOf((mediumcf.get(0)+ " Medium"))-1;
					for(int i =0;i<mediumcf.size();i++)
					{
						index = newData1.indexOf((mediumcf.get(i)+ " Medium"));
						if(index>index1)
						{
							index1 = index;
						}
						else softly.fail("Order for Medium is wrong for contributing factor in pdf");
					}
				}
				if(lowcf.size()>0)
				{
					//Look for Level 3 answers with low importance and verify if index in pdf data is lower
					int index;
					int index1=newData1.indexOf((lowcf.get(0)+ " Low"))-1;
					for(int i =0;i<lowcf.size();i++)
					{
						index = newData1.indexOf((lowcf.get(i)+ " Low"));
						if(index>index1)
						{
							index1 = index;
						}
						else softly.fail("Order for Low is wrong for contributing factor in pdf");
					}
				}
				if(nonecf.size()>0)
				{
					//Look for Level 3 answers with no importance and verify if index in pdf data is lower
					int index;
					int index1=newData1.indexOf(nonecf.get(0))-1;
					for(int i =0;i<nonecf.size();i++)
					{
						index = newData1.indexOf(nonecf.get(i));
						if(index>index1)
						{
							index1 = index;
						}
						else softly.fail("Order for no importance is wrong for contributing factor in pdf");
					}
				}
				//Check if last high comes before 1st medium, 1st low, 1st none
				if(highcf.size()>0 && mediumcf.size()>0)
				{
					int index = newData1.indexOf(highcf.get(highcf.size()-1));
					int index1 = newData1.indexOf(mediumcf.get(0));
					if(index>index1)
						softly.fail("High importance comes after medium in contributing factor in pdf");
				}
				if(highcf.size()>0 && lowcf.size()>0)
				{
					int index = newData1.indexOf(highcf.get(highcf.size()-1));
					int index1 = newData1.indexOf(lowcf.get(0));
					if(index>index1)
						softly.fail("High importance comes after low in contributing factor in pdf");
				}
				if(highcf.size()>0 && nonecf.size()>0)
				{
					int index = newData1.indexOf(highcf.get(highcf.size()-1));
					int index1 = newData1.indexOf(nonecf.get(0));
					if(index>index1)
						softly.fail("High importance comes after none in contributing factor in pdf");
				}
				//Check if last medium comes before 1st low, 1st none
				if(mediumcf.size()>0 && lowcf.size()>0)
				{
					int index = newData1.indexOf(mediumcf.get(mediumcf.size()-1));
					int index1 = newData1.indexOf(lowcf.get(0));
					if(index>index1)
						softly.fail("Medium importance comes after low in contributing factor in pdf");
				}
				if(mediumcf.size()>0 && nonecf.size()>0)
				{
					int index = newData1.indexOf(mediumcf.get(mediumcf.size()-1));
					int index1 = newData1.indexOf(nonecf.get(0));
					if(index>index1)
						softly.fail("Medium importance comes after none in contributing factor in pdf");
				}
				//Check if last low comes before 1st none
				if(lowcf.size()>0 && nonecf.size()>0)
				{
					int index = newData1.indexOf(lowcf.get(lowcf.size()-1));
					int index1 = newData1.indexOf(nonecf.get(0));
					if(index>index1)
						softly.fail("Low importance comes after none in contributing factor in pdf");
				}
			}
		}    
		//Close pdf
		pddoc.close();

	}

	public void modifyReport(WebDriver driver, List<String>lopOptions, HashMap<String,Integer>options, HashMap<String,String>hml, List<String>checklist,MultiValuedMap<String,String>hircaNoteLopSURE) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(2000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		//Click on side panel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify HTML
		//verifyHTMLReport(driver, lopOptions, options, hml, checklist,0,hircaNoteLopSURE);
		//Click on Open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Go to Step 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-1"))).click();
		//Click next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Next or skip
		String skip=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip.contains("ui-state-disabled"))
		{
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		//Click on Root Cause
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed2"))).click();
		//Goes directly to Step 3
		//Modify SUEP
		HashMap<String,Integer> optionsNew = modifySUEP (driver,lopOptions,options);
		//Next or skip
		String skip1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip1.contains("ui-state-disabled"))
		{
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		//Modify Step 4
		HashMap<String,String> hmlNew=modifyStep4(driver,optionsNew,lopOptions);
		//Next or skip
		String skip2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip2.contains("ui-state-disabled"))
		{
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		//Modify Step 5
		List<String> checklistNew = modifyHiRCAChecklist(driver,checklist);
		//Next or skip
		String skip3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip3.contains("ui-state-disabled"))
		{
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		//Verify if on Report Tab by looking for finalize button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-finalize")));
		//verifyReport(driver, lopOptions, optionsNew, hmlNew, checklistNew,1,hircaNoteLopSURE);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("11"))
			{
				share2.loadingServer(driver);	
				//Clicks on Save
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
				//Clicks on Save report
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title")));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				share2.loadingServer(driver);
			}
		}
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			downloadReportChrome(driver,lopOptions,hmlNew,optionsNew,checklistNew);
		if (browserName.equals("firefox"))
			downloadReportFirefox(driver,lopOptions,hmlNew,optionsNew,checklistNew);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				downloadReportIE(driver,lopOptions,hmlNew,optionsNew,checklistNew);
			if (v.startsWith("11"))
				downloadReportIE11(driver,lopOptions,hmlNew,optionsNew,checklistNew);
		}
		if(browserName.toLowerCase().contains("safari"))
			driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
		//Click on side panel HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-panel-btn-irca"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on newly created record
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Verify HTML report
		//verifyHTMLReport(driver, lopOptions, optionsNew, hmlNew, checklistNew,1,hircaNoteLopSURE);
	}

	public List<String> modifyHiRCAChecklist(WebDriver driver,List<String> checklistOriginal) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Select checklist options randomly
		//List for HiRCA checklist
		List<String> checklist = new ArrayList<String>();
		//Pick number of options 0 to 11
		Random random = new Random();
		int options = random.nextInt(12);
		System.out.println("No of Hirca checklist options:"+options);
		int c;
		for(int i=1;i<=options;i++)
		{
			//Pick the checkbox
			while(true)
			{
				//Pick a number between 2 and 12 for tr
				c = random.nextInt(13);
				if(c<2)
					continue;
				else
					break;
			}
			System.out.println("tr:"+c);
			//Get name of selfchecklist and see if it was checked earlier, if yes un check it and continue
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+c+"]/td[2]"))).getText().trim();
			WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+c+"]/td[3]/div/input")));
			if(checklistOriginal.contains(s))
			{
				e.click();
				continue;
			}
			if(e.isSelected()==true)
				continue;
			else
				e.click();
			//Store area checked in list
			checklist.add(s);
		}
		System.out.println(checklist);
		return checklist;
	}

	public HashMap<String,String> modifyStep4(WebDriver driver,HashMap<String,Integer>options,List<String>lopOptions) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//Get text list
		List<String> modText = modifyText(driver);
		//Hashmap for storing HML for root cause and contributing factors
		HashMap<String,String> hml= new HashMap<String,String>();
		//No Level 3 selected then return
		if(lopOptions.size()==0)
		{
			System.out.println("No root causes or contributing factors");
			return hml;
		}
		//New lopOptions list with : instead of ]
		List <String>lopOptions1 = new ArrayList<String>();
		for(int h=0;h<lopOptions.size();h++)
		{
			String s = lopOptions.get(h).replace("]", ":").trim();
			lopOptions1.add(s);
		}
		//Get number of Root causes in Level 3 answers
		int count = options.get("Root causes");
		System.out.println("No of root causes:"+count);
		//Gets number of contributing factors
		int count1 = lopOptions1.size()-count;
		System.out.println("No of contributing factors:"+count1);		
		System.out.println("hml \n"+hml);
		//tr starts at 2 and each root cause has 4 four rows
		int i=2;
		//int scroll=42;
		Iterator<String> iter = Iterables.cycle(modText).iterator();
		//Verify if any root causes are appearing
		while(i<=((count*4)+1))
		{
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))));
			//Get name of level 3 answer
			String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
			System.out.println(level3);
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(level3)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+level3);
			}
			//verify level 3 answer without :
			//Get index in lopOptions1
			int n = lopOptions1.indexOf(level3);
			//Get level3 answer from lopOptions
			String l = lopOptions.get(n).replace("]", "");
			//String l = level3.substring(0, level3.indexOf(":"))+level3.substring(level3.indexOf(":")+1, level3.length());
			//Check if it has 4 boxes ticked
			if(options.get(l)!=4)
			{
				softly.fail("Not all four boxes are ticked, only some are: "+ options.get(l));
			}
			//Check if Level 3 is root cause
			String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div/input"))).getAttribute("checked");
			System.out.println(lop1);
			softly.assertThat(lop1).as("test data").isEqualTo("true");
			//Check if Level 3 is not a contributing factor
			String lop4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("disabled");
			System.out.println(lop4);
			softly.assertThat(lop4).as("test data").isEqualTo("true");
			//HML random select
			//Select a number between 0 to 3 for H,M,L
			Random random =new Random();
			int y;
			while (true)
			{
				y=random.nextInt(4);
				if(y<1)
					continue;
				else break;
			}	
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[1]/label"))));
			String oldValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
			System.out.println("old value and new value y: "+oldValue + y);
			if((y==1)/*&&(oldValue.contains("H")==false)*/)
			{
				//Click on H
				while(true)
				{
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue").equals("H"))
					{
						//if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue").equals(oldValue)==false)
						{
							break;
						}
					}
				}			
				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				System.out.println(lop2);
				softly.assertThat(lop2).as("test data").isEqualTo("H");
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "High");
			}
			if((y==2)/*&&(oldValue.contains("M")==false)*/)
			{
				//Click on M
				while(true)
				{
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).getAttribute("class").contains("ui-radio-on"))
						if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue").equals("M"))
						{
							//if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue").equals(oldValue)==false)
							{
								break;
							}
						}
				}
				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				System.out.println(lop2);
				softly.assertThat(lop2).as("test data").isEqualTo("M");
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "Medium");
			}
			if((y==3)/*&&(oldValue.contains("L")==false)*/)
			{
				//Click on L
				while(true)
				{
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).getAttribute("class").contains("ui-radio-on"))
					{
						if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue").equals("L"))
						{
							//if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue").equals(oldValue)==false)
							{
								break;
							}
						}
					}						
				}
				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				System.out.println(lop2);
				softly.assertThat(lop2).as("test data").isEqualTo("L");
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "Low");
			}
			if(y==0)
			{
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "");
			}
			//Increase i for evidence entry
			i=i+1;
			i=i+1;
			//Click on Evidence Entry
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))));
			//Verify the text
			String lop3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"))).getText().trim();
			System.out.println(lop3);
			String re = lop3.replaceAll("\u00AD", "");
			softly.assertThat(re).as("test data").isEqualTo(textEvidence(driver));
			//Click on Evidence Entry
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Increase i for extra root cause text boxes
			i=i+1;
			//Fill the text boxes 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[1]"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[1]"))).sendKeys(iter.next());
			}
			share2.scrollToElement(driver,wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[2]"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[2]"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[2]"))).sendKeys(iter.next());
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[3]"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[3]"))).sendKeys(iter.next());
			}
			//Increase i for changing corrective actions
			i=i+1;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).sendKeys(iter.next());
			}
			//Increase i for next root cause
			i=i+1;
			//Scroll down
			/*	scroll = scroll+475;
			jse.executeScript("scroll(0,"+scroll+")");*/
		}
		//Verifies if any contributing factors
		//tr starts at 2 and each root cause has 4 four rows
		System.out.println("Starting row of contributing factors:"+i);
		int start =i-1;
		//Verify if any root causes are appearing
		int x=4;
		while(i<=((count1*x)+start))
		{
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))));
			//Get name of level 3 answer
			String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
			System.out.println(level3);
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(level3)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+level3);
			}
			//verify level 3 answer without :
			int n = lopOptions1.indexOf(level3);
			String l = lopOptions.get(n).replace("]", "");
			//Check if it has 4 boxes ticked
			if(options.get(l)>3)
			{
				softly.fail("All four boxes are ticked"+ options.get(l));
			}
			//Check if Level 3 is contributing factors
			String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("checked");
			System.out.println(lop1);
			softly.assertThat(lop1).as("test data").isEqualTo("true");
			//Check if Level 3 is not a root cause
			String lop4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div/input"))).getAttribute("disabled");
			System.out.println(lop4);
			softly.assertThat(lop4).as("test data").isEqualTo("true");
			//HML random select
			//Select a number between 0 to 3 for H,M,L
			Random random =new Random();
			int y;
			while (true)
			{
				y=random.nextInt(4);
				if(y<1)
					continue;
				else break;
			}
			if(y==1)
			{
				//Click on H
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				System.out.println(lop2);
				softly.assertThat(lop2).as("test data").isEqualTo("H");
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "High");
			}
			if(y==2)
			{
				//Click on M
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				System.out.println(lop2);
				softly.assertThat(lop2).as("test data").isEqualTo("M");
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "Medium");
			}
			if(y==3)
			{
				//Click on L
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				System.out.println(lop2);
				softly.assertThat(lop2).as("test data").isEqualTo("L");
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "Low");
			}
			if(y==0)
			{
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "");
			}
			//Increase i for evidence entry
			i=i+1;
			i=i+1;
			//Click on Evidence Entry
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))));
			//Verify the text
			String lop3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"))).getText().trim();
			System.out.println(lop3);
			String re = lop3.replaceAll("\u00AD", "");
			softly.assertThat(re).as("test data").isEqualTo(textEvidence(driver));
			//Click on Evidence Entry
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			//Increase i for changing corrective actions
			i=i+1;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).sendKeys(iter.next());
			}
			//Increase i for next contributing factor
			i=i+1;
			//Scroll down
			/*scroll = scroll+215;
			jse.executeScript("scroll(0,"+scroll+")");*/
		}
		//Scroll up
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		System.out.println("Modify report hml:");
		System.out.println(hml);
		return hml;
	}

	public HashMap<String,Integer> modifySUEP (WebDriver driver, List<String> lopOptions, HashMap<String,Integer> optionsOriginal) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//Remove [] from lopOptions
		List<String> lopOptions1 = new ArrayList<String>();
		for(int k=0;k<lopOptions.size();k++)
		{
			String s =lopOptions.get(k).replace("[", "");
			String l = s.replace("]", "");
			lopOptions1.add(l);			
		}
		//Hashmap for storing number of SUEP checkboxes ticked
		HashMap<String,Integer> options = new HashMap<String,Integer> ();
		//Get size of 3.17 options
		int n=lopOptions1.size();
		if (n<1)
			return options;
		//Row no starts from 2
		int i=2;
		//Count for root causes
		int r=0;
		//Scroll down
		//share2.scrollToAPoint(driver, 1100);
		int k=3;
		while(i<=((n*k)+1))
		{
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))));
			//Get text of option of 3.17
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
			if(lopOptions1.contains(s5)==false)
			{
				softly.fail("3.17 option not present on Step 3 "+s5);
			}
			//Click on random SUEP
			Random random = new Random();
			//Choose a number between 0 and 4 for number of selections
			int num=random.nextInt(5);
			System.out.println(num);
			//Store no of SUEP checkboxes in hashmap: key=level 3 answer, value = no of suep checks
			options.put(s5, num);
			//Check if new selections is same or different than before
			//If same continue don't make any changes
			if(num==optionsOriginal.get(s5))
				continue;
			//If different unchecks the current selections
			else
			{
				for (int j=1;j<=optionsOriginal.get(s5);j++)
				{
					share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input"))));
					//Click on checkbox of SUEP
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input"))).click();
					}catch(org.openqa.selenium.WebDriverException t)
					{
						executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input"))));
					}
				}
			}
			if (num==4)
				r=r+1;
			for (int j=1;j<=num;j++)
			{
				share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input"))));
				//Click on checkbox of SUEP
				while(true)
				{
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input"))));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input"))).isSelected()==true)
						break;
				}
			}	
			//Increase i+1 for evidence entry
			i=i+1;
			i=i+1;
			//Verify Evidence Entry text not visible
			try{
				WebElement l = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"));
				if(l.isDisplayed()==true)
					softly.fail("Evidence Entry text visible");
			}catch (NoSuchElementException q)
			{
				System.out.println("No Evidence Entry text visible as the + sign for Evidence Entry has not been clicked");
			}
			//Click on Evidence Entry collapsible
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))));
			//Get text from Evidence Entry and verify if equal to text
			String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"))).getText().trim();
			String re = s6.replaceAll("\u00AD", "");
			softly.assertThat(re).as("test data").isEqualTo(textEvidence(driver));
			//Click on Evidence Entry collapsible
			try{ 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			}catch(org.openqa.selenium.WebDriverException t)
			{
				executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))));
			}
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			String browserName = cap.getBrowserName().toLowerCase();
			System.out.println(browserName);
			if(browserName.toLowerCase().contains("safari")==false)
			{
				//Verify Evidence Entry text not visible
				try{
					WebElement l = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"));
					if(l.isDisplayed()==true)
						softly.fail("Evidence Entry text visible: "+l.getText());
				}catch (NoSuchElementException q)
				{
					System.out.println("No Evidence Entry text visible as the + sign for Evidence Entry has not been clicked");
				}
			}
			//Increase i+1 for next option
			i=i+1;
		}
		//Add no of root causes in hashmap
		options.put("Root causes",r);
		System.out.println(options);
		//Scroll up
		share2.scrollToTop(driver);
		return options;
	}

	public int getCharCountFromTitle(WebDriver driver) throws Exception {

		//Get count of characters
		String s = driver.findElement(By.id("pii-irca-event-title-count")).getText().trim();
		s=s.substring(1,s.indexOf("/"));
		int count = Integer.parseInt(s);
		System.out.println(s+ " "+count);
		return count;
	}

	public void checkTitleCountReset(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Enter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys("aaaa");
		//Get count
		int count = getCharCountFromTitle(driver);
		if(count!=4)
			softly.fail("Count did not match: aaaa: " + count);
		//Clear text
		for(int i=0;i<4;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(250);
		}
		count = getCharCountFromTitle(driver);
		if(count!=1)
			softly.fail("Count did not match: aaaa: " + count);
	}

	public void HiRCAPathCheck(WebDriver driver, String username) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on Analysis 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-main-menu-button-a"))).click();
		//Clicks on HiRCA
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-a-menu-hirca"))).click();
		Thread.sleep(2000);
		//Check title count reset when characters are entered and deleted
		checkTitleCountReset(driver);
		//Event title
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-title"))).sendKeys(text(driver));
		//Location of event
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-location"))).sendKeys(text(driver));
		//Department
		WebElement dropdown = driver.findElement(By.id("pii-irca-event-department"));
		Select s = new Select (dropdown);
		s.selectByVisibleText("Construction");
		//Problem Statement
		tbr.sizeCheck(driver, By.id("pii-irca-event-pbstatement"),softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-pbstatement"))).sendKeys(text(driver));
		//Timeline of event
		tbr.sizeCheck(driver, By.id("pii-irca-event-events"),softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-events"))).sendKeys(text(driver));
		//Background info
		tbr.sizeCheck(driver, By.id("pii-irca-event-bginfos"),softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-bginfos"))).sendKeys(text(driver));
		//Investigators
		tbr.sizeCheck(driver, By.id("pii-irca-event-investigators"),softly);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-investigators"))).sendKeys(text(driver));
		//Gets value of date
		String get_date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-date"))).getAttribute("value");
		System.out.println(get_date);
		//Gets value of time
		String get_time = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-event-time"))).getAttribute("value");
		System.out.println(get_time);
		//Gets value of department
		String get_dept = driver.findElement(By.id("pii-irca-event-department")).getAttribute("value");
		System.out.println(get_dept);
		//scroll down
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-irca-event-form']/div[15]/div/button"))));
		Thread.sleep(2000);
		//Select Equipment failure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).click();
		//Get the question and answer of the Level 1 leading to Level 3
		String note = hfl123.getNoteShowingPreviousAnswer(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Verify 3.17
		List<String> lopOptions= verify317(driver);
		//Join the list with the note for SURE
		MultiValuedMap<String,String> hircaNoteLopSURE = hfl123.joinNoteWithAnswerForSURE(driver, note, lopOptions);/*
		System.out.println("******* \n"+hircaNoteLopSURE.get(lopOptions.get(0).replace("]", "").replace("[", "")));
		List<String> temp = new ArrayList<String>(hircaNoteLopSURE.get(lopOptions.get(0).replace("]", "").replace("[", "")));
		System.out.println("******* \n"+temp.get(0));*/
		//Join the list with the note for Step4
		HashMap<String,String> hircaNoteLopStep4 = hfl123.joinNoteWithAnswerWithSemicolon(driver, note, lopOptions);
		if(lopOptions.size()==0)
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		else 
		{
			//Click next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		//Click on LOP
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		//Click on Yes
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-initialquestions']/div/fieldset[1]/div/div/label"))));
		//Verify the LOP selection
		verifyLOP(driver);
		//Select random 3 options
		select3LOP(driver);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Click back
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-back"))).click();
		//Click on No
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-initialquestions']/div/fieldset[2]/div/div/label"))));
		//Click on modify
		wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)).click();
		//Click on next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		//Verify 2.21
		verify221(driver);
		//Click on skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify 2.22
		verify222(driver);
		//Click on skip
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		//Verify Step 3 SUEP
		HashMap<String,Integer> options = verifySUEP(driver,lopOptions, softly,hircaNoteLopSURE);
		String skip=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		Thread.sleep(2000);
		if(skip.contains("ui-state-disabled"))
		{
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		//Verify Step 4
		HashMap<String,String> hml =verifyStep4(driver,options,lopOptions,hircaNoteLopStep4);
		Thread.sleep(6000);
		String skip2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip2.contains("ui-state-disabled"))
		{
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		Thread.sleep(2000);
		//Verify Step 5
		List<String> checklist=verifyHiRCAChecklist(driver);
		Thread.sleep(4000);
		String skip1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).getAttribute("class");
		if(skip1.contains("ui-state-disabled"))
		{
			//Click on next
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-next"))).click();
		}
		else
		{
			//Click on skip
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-skip"))).click();
		}
		Thread.sleep(2000);
		//Verify if on Report Tab by looking for finalize button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-finalize")));
		//verifyReport(driver, lopOptions, options, hml, checklist,0, hircaNoteLopSURE);
		//Click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(hirca.HiRCAPopupConfirmButton)));
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		String v = cap.getVersion().toString();
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("11"))
			{
				share2.loadingServer(driver);	
				//Clicks on Save
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-button-save"))).click();
				//Clicks on Save report
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-title")));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-dialog-confirmed"))).click();
				share2.loadingServer(driver);
			}
		}
		share2.scrollToTop(driver);
		//Clicks on Info tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-tab-0"))).click();
		//Create an expected name
		String creationDate = driver.findElement(By.id("pii-irca-event-repdatetime")).getAttribute("value");
		String name = creationDate + "_"+username+"_"+ text(driver) ;
		System.out.println(name);	  
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-btn-savedactivities"))).click();
		//Gets newly created record name
		WebElement record = driver.findElement(By.xpath(".//*[@id='pii-user-home-activities-irca']/ul/li[2]/a"));
		String recordName = record.getText().trim();
		String r1 = recordName.replaceAll("\u00AD", "");
		if (record.isDisplayed())
		{
			System.out.println("Record found: "+ r1);
		}
		else
			System.out.println ("Record not found.");
		//Checks if expected name and actual name is correct
		softly.assertThat(r1).as("test data").isEqualTo(name);
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Download report to check pdf
		if (browserName.equals("chrome"))
			downloadReportChrome(driver,lopOptions,hml,options,checklist);
		if (browserName.equals("firefox"))
			downloadReportFirefox(driver,lopOptions,hml,options,checklist);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				downloadReportIE(driver,lopOptions,hml,options,checklist);
			if (v.startsWith("11"))
				downloadReportIE11(driver,lopOptions,hml,options,checklist);
		}
		if(browserName.toLowerCase().contains("safari"))
			driver.switchTo().defaultContent();
		//Modify report
		modifyReport(driver,lopOptions,options,hml,checklist,hircaNoteLopSURE);
	}

	public void deleteReport (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Click on delete
		WebElement delBtn=driver.findElement(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[3]"));
		jse.executeScript("arguments[0].scrollIntoView();", delBtn);
		jse.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='pii-uhome-buttons-rpt']/div/div/a[3]"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-user-home-dialog-confirmed"))).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
	}

	public void verifyReport(WebDriver driver, List<String>lopOptions, HashMap<String,Integer>options, HashMap<String,String>hml, List<String>checklist, int d, MultiValuedMap<String,String>hircaNoteLopSURE) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Get List to compare
		List<String> varText = variableText(driver);
		List<String> modText = modifyText(driver);
		//JavascriptExecutor executor = (JavascriptExecutor) driver;
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		//Verify first table
		//Checks for Event title data
		String eve_title =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div/table/tbody/tr/td[2]"))).getText().trim();
		String r = eve_title.replaceAll("\u00AD", "");
		softly.assertThat(r).as("test data").isEqualTo(text(driver));
		//Checks for Location of event data
		String eve_loc =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div/table/tbody/tr[4]/td[2]"))).getText().trim();
		String r1 = eve_loc.replaceAll("\u00AD", "");
		softly.assertThat(r1).as("test data").isEqualTo(text(driver));
		//Checks for Investigators data
		String eve_inv =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div/table/tbody/tr[7]/td[2]"))).getText().trim();
		String r2 = eve_inv.replaceAll("\u00AD", "");
		softly.assertThat(r2).as("test data").isEqualTo(text(driver));
		//Checks for Problem statement data
		String eve_prob =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[2]/td[2]"))).getText().trim();
		String r3 = eve_prob.replaceAll("\u00AD", "");
		softly.assertThat(r3).as("test data").isEqualTo(text(driver));
		//Checks for Timeline of event data
		String eve_timeline =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[3]/td[2]"))).getText().trim();
		String r4 = eve_timeline.replaceAll("\u00AD", "");
		softly.assertThat(r4).as("test data").isEqualTo(text(driver));
		//Checks for Background information data
		String eve_back =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[2]/table/tbody/tr[4]/td[2]"))).getText().trim();
		String r5 = eve_back.replaceAll("\u00AD", "");
		softly.assertThat(r5).as("test data").isEqualTo(text(driver));
		//Verify the n/a in LOPs
		//List to help compare
		List<String>lopOptions1 = new ArrayList<String>();
		//Remove the ] from Level 3 answers
		for (int j=0;j<lopOptions.size();j++)
		{
			String p = lopOptions.get(j).replace("]", "");
			lopOptions1.add(p);
		}
		//verify if any root cause exists
		//int rc = Collections.frequency(options, 4);
		int rc,cf;
		if(lopOptions.size()>0)
		{
			rc = options.get("Root causes");
			System.out.println(rc);
			//Get number of contributing factors
			cf = lopOptions.size()-rc;
			System.out.println(cf);
		}
		else
		{
			rc=0;
			cf=0;
		}
		//When no root causes present
		if (rc==0)
		{
			//Verify Root cause as n/a
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr/td[1]"))).getText().trim();
			softly.assertThat(s).as("test data").isEqualTo("n/a");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr/td[2]"))).getText().trim();
			softly.assertThat(s1).as("test data").isEqualTo("n/a");
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div[4]/table/tbody/tr/td[3]"))).getText().trim();
			softly.assertThat(s2).as("test data").isEqualTo("n/a");		
		}
		//When root cause is present
		for (int i=4;i<=rc+3;i++)
		{
			//Get name of level 3 answer
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table/tbody/tr/td[1]"))).getText().trim();
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(s)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+s);
			}
			//Check if it has 4 boxes ticked
			if(options.get(s)!=4)
			{
				softly.fail("Not a root cause, Not all four boxes are ticked, only some are: "+ options.get(s));
			}
			//Get importance and verify
			//String s1 = ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table/tbody/tr/td[2]")))).toString();
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table/tbody/tr/td[2]"))).getAttribute("textContent");
			//Get corresponding Importance value from hashmap
			String s2 = hml.get(s);
			//Verify high medium low
			/*	if(browserName.contains("safari"))
				softly.assertThat(s1).as("test data").contains(s2);
			else */
			if(browserName.toLowerCase().contains("safari")==false)				
				softly.assertThat(s1).as("test data").contains(s2);
			//Get corrective actions
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table/tbody/tr/td[3]"))).getText().trim();
			String re4 = s3.replaceAll("\u00AD", "");
			if(d==0)
			{
				if(varText.contains(re4)==false)
					softly.fail("Text wrong: "+re4);
				//softly.assertThat(s3).as("test data").isEqualTo(text);
			}
			if(d==1)
			{
				if(modText.contains(re4)==false)
					softly.fail("Text wrong: "+re4);
				//softly.assertThat(s3).as("test data").isEqualTo(text1);
			}
			int k=2;
			String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table/tbody/tr["+k+"]/td/span"))).getText().trim();
			List<String> temp = new ArrayList<String>(hircaNoteLopSURE.get(s));
			softly.assertThat(note).as("test data").isEqualTo(temp.get(0));
			k=k+1;
			//Verify Supporting Evidence
			String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table/tbody/tr["+k+"]/td"))).getText().trim();
			String re3 = s4.replaceAll("\u00AD", "");
			softly.assertThat(re3).as("test data").contains(textEvidence(driver));
			//Verify Extent of condition
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table[2]/tbody/tr[2]/td[2]"))).getText().trim();
			String re2 = s5.replaceAll("\u00AD", "");
			if(d==0)
			{
				if(varText.contains(re2)==false)
					softly.fail("Text wrong: "+re2);
				//softly.assertThat(s5).as("test data").isEqualTo(text);
			}
			if(d==1)
			{
				if(modText.contains(re2)==false)
					softly.fail("Text wrong: "+re2);
				//softly.assertThat(s5).as("test data").isEqualTo(text1);
			}
			//Verify Operating Experience
			String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table[2]/tbody/tr[3]/td[2]"))).getText().trim();
			String re1 = s6.replaceAll("\u00AD", "");
			if(d==0)
			{
				if(varText.contains(re1)==false)
					softly.fail("Text wrong: "+re1);
				//softly.assertThat(s6).as("test data").isEqualTo(text);
			}
			if(d==1)
			{
				if(modText.contains(re1)==false)
					softly.fail("Text wrong: "+re1);
				//softly.assertThat(s6).as("test data").isEqualTo(text1);
			}
			//Verify Safety Culture
			String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+i+"]/table[2]/tbody/tr[4]/td[2]"))).getText().trim();
			String re = s7.replaceAll("\u00AD", "");
			if(d==0)
			{
				if(varText.contains(re)==false)
					softly.fail("Text wrong: "+re);
				//softly.assertThat(s7).as("test data").isEqualTo(text);
			}
			if(d==1)
			{
				if(modText.contains(re)==false)
					softly.fail("Text wrong: "+re);
				//softly.assertThat(s7).as("test data").isEqualTo(text1);
			}
		}
		if(rc==0)
		{
			//Because there will be a div with Root Cause as n/a
			rc=rc+1;
		}		
		//When no contributing factors present
		if(cf==0)
		{
			//Verify Contributing factors as n/a
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr/td[1]"))).getText().trim();
			softly.assertThat(s).as("test data").isEqualTo("n/a");
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr/td[2]"))).getText().trim();
			softly.assertThat(s1).as("test data").isEqualTo("n/a");
			String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr/td[3]"))).getText().trim();
			softly.assertThat(s2).as("test data").isEqualTo("n/a");					
		}
		//When contributing factors are present
		int i=1;
		int k=3;
		while(i<=(cf*k))
		{
			//Get name of level 3 answer
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
			System.out.println(s);
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(s)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+s);
			}
			//Check if it has 4 boxes ticked
			if(options.get(s)==4)
			{
				softly.fail("Not a contributing factor, All four boxes are ticked, only some should be: "+ options.get(s));
			}
			//Get importance and verify
			String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[2]"))).getText().trim();
			//Get corresponding Importance value from hashmap
			String s2 = hml.get(s);
			//Verify high medium low
			if(browserName.contains("safari")==false)
				softly.assertThat(s1).as("test data").isEqualTo(s2);
			else
			{
				//softly.assertThat(executor.executeScript("return arguments[0].innerHTML;", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[2]"))))).as("test data").isEqualTo(s2);
				//softly.assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[2]"))).getAttribute("textContent")).as("test data").contains(s2);
			}
			//Get corrective actions
			String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td[3]"))).getText().trim();
			String re1 = s3.replaceAll("\u00AD", "");
			if(d==0)
			{
				if(varText.contains(re1)==false)
					softly.fail("Text wrong: "+re1);
				//softly.assertThat(s3).as("test data").isEqualTo(text);
			}
			if(d==1)
			{
				if(modText.contains(re1)==false)
					softly.fail("Text wrong: "+re1);
				//softly.assertThat(s3).as("test data").isEqualTo(text1);
			}
			//Increase i for supporting evidence
			i=i+1;
			String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td/span"))).getText().trim();
			List<String> temp = new ArrayList<String>(hircaNoteLopSURE.get(s));
			softly.assertThat(note).as("test data").isEqualTo(temp.get(0));
			i=i+1;
			//Verify Supporting Evidence
			String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+4)+"]/table/tbody/tr["+i+"]/td"))).getText().trim();
			String re = s4.replaceAll("\u00AD", "");
			softly.assertThat(re).as("test data").contains(textEvidence(driver));
			//Increase i for next cf
			i=i+1;			
		}
		//Verify Root Cause Analysis
		String rc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+5)+"]/table/tbody/tr[1]/td[2]"))).getText().trim();
		softly.assertThat(rc1).as("test data").isEqualTo("Equipment failure");
		//Verify 3.17 answer under Root Cause Analysis
		for(i=1;i<=lopOptions1.size();i++)
		{
			try{
				String lop1=driver.findElement(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+5)+"]/table/tbody/tr[2]/td/div/table/tbody/tr["+i+"]/td[1]")).getText().trim();
				//Verify if this level 3 answer was selected
				if(lopOptions1.contains(lop1)==false)
				{
					softly.fail("Level 3 is not suppose to be here: "+lop1);
				}
				String lop2=driver.findElement(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+5)+"]/table/tbody/tr[2]/td/div/table/tbody/tr["+i+"]/td[2]")).getText().trim();
				String re = lop2.replaceAll("\u00AD", "");
				softly.assertThat(re).as("test data").isEqualTo(textEvidence(driver));
			}catch(NoSuchElementException u)
			{
				break;
			}		  
		}
		//Verify SUEP
		for(i=1;i<=lopOptions1.size();i++)
		{
			//Verify level3 answer
			String s1=driver.findElement(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+7)+"]/table/tbody/tr["+i+"]/td[1]")).getText().trim();
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(s1)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+s1);
			}
			System.out.println(s1);
			//Number of SUEP checks
			int num = options.get(s1);
			if(num==0)
			{
				i=i+1;
				continue;
			}
			for (int j=1;j<=num;j++)
			{
				//String s2=executor.executeScript("return arguments[0].innerHTML;", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+7)+"]/table/tbody/tr["+i+"]/td["+(j+1)+"]")))).toString();
				String s2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+7)+"]/table/tbody/tr["+i+"]/td["+(j+1)+"]"))).getAttribute("textContent");
				softly.assertThat(s2).as("test data").contains("Yes");
			}
			i=i+1;
			String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+7)+"]/table/tbody/tr["+i+"]/td/span"))).getText().trim();
			List<String> temp = new ArrayList<String>(hircaNoteLopSURE.get(s1));
			softly.assertThat(note).as("test data").isEqualTo(temp.get(0));
		}
		//No Level 3 answers selected, SUEP skipped increases one more div, so rc increased by 1
		if(lopOptions.size()==0)
			rc=rc+1;
		//Verify HiRCA self checklist
		//if checklist is empty then return
		if (checklist.size()==0)
			return;
		for(i=1;i<=11;i++)
		{
			//Get Area Checked
			String s1=driver.findElement(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+9)+"]/table/tbody/tr["+i+"]/td[2]")).getText().trim();
			//Verify if Yes
			if(checklist.contains(s1)==true)
			{
				String s2=driver.findElement(By.xpath(".//*[@id='module-irca-rpt']/div["+(rc+9)+"]/table/tbody/tr["+i+"]/td[3]")).getText().trim();
				softly.assertThat(s2).as("test data").isEqualTo("Yes");
			}
		}
	}

	public HashMap<String,String> verifyStep4(WebDriver driver,HashMap<String,Integer>options,List<String>lopOptions,HashMap<String,String>hircaNoteLopStep4) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//Get text of varying length
		List<String> varText = variableText(driver);
		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		System.out.println(browserName);
		//Verify title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText().trim();
		softly.assertThat(title).as("test data").contains("Step 4 - Level of Importance Attribution For Root Causes & Contributing Factors");
		//Hashmap for storing HML for root cause and contributing factors
		HashMap<String,String> hml= new HashMap<String,String>();
		//No Level 3 selected then return
		if(lopOptions.size()==0)
		{
			System.out.println("No root causes or contributing factors");
			return hml;
		}
		//New lopOptions list with : instead of ]
		List <String>lopOptions1 = new ArrayList<String>();
		for(int h=0;h<lopOptions.size();h++)
		{
			String s = lopOptions.get(h).trim().replace("]", ":");
			lopOptions1.add(s);
		}
		System.out.println("lopOptions1: "+lopOptions1);
		//Get number of Root causes in Level 3 answers
		//int count = Collections.frequency(options, 4);
		int count = options.get("Root causes");
		System.out.println("No of root causes:"+count);
		//Gets number of contributing factors
		int count1 = lopOptions1.size()-count;
		System.out.println("No of contributing factors:"+count1);		
		//tr starts at 2 and each root cause has 4 four rows
		int i=2;
		//int scroll=42;
		Iterator<String> iter = Iterables.cycle(varText).iterator();
		int p=5;
		//Verify if any root causes are appearing
		while(i<=((count*p)+1))
		{
			//Get name of level 3 answer
			String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
			System.out.println(level3);
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(level3)==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+level3);
			}
			//verify level 3 answer without :
			//Get index in lopOptions1
			int n = lopOptions1.indexOf(level3);
			//Get level3 answer from lopOptions
			String l = lopOptions.get(n).replace("]", "");
			//Check if it has 4 boxes ticked
			if(options.get(l)!=4)
			{
				softly.fail("Not all four boxes are ticked, only some are: "+ options.get(l));
			}
			//Check if Level 3 is root cause
			String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div/input"))).getAttribute("checked");
			System.out.println(lop1);
			softly.assertThat(lop1).as("test data").isEqualTo("true");
			//Check if Level 3 is not a contributing factor
			String lop4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("disabled");
			System.out.println(lop4);
			softly.assertThat(lop4).as("test data").isEqualTo("true");
			//HML random select
			//Select a number between 0 to 3 for H,M,L
			Random random =new Random();
			int y=random.nextInt(4);
			//Click on H
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[1]/label"))));			
			if(y==1)
			{
				//Click on H
				//	share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
				while(true)
				{
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					if(browserName.contains("safari")==false)
					{
						jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
						jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
//						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
					}
					else executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).getAttribute("class").contains("ui-radio-on"))
						break;
				}
				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				System.out.println(lop2);
				softly.assertThat(lop2).as("test data").isEqualTo("H");
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "High");
			}
			if(y==2)
			{
				//Click on M
				//	share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
				while(true)
				{
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					if(browserName.contains("safari")==false)
					{
						jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
						jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
//						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
					}
					else executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).getAttribute("class").contains("ui-radio-on"))
						break;
				}
				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				System.out.println(lop2);
				softly.assertThat(lop2).as("test data").isEqualTo("M");
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "Medium");
			}
			if(y==3)
			{
				//Click on L
				//share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
				while(true)
				{
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					if(browserName.contains("safari")==false)
					{
						jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
						jse.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
	//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
					}
					else executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).getAttribute("class").contains("ui-radio-on"))
						break;
				}
				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				System.out.println(lop2);
				softly.assertThat(lop2).as("test data").isEqualTo("L");
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "Low");
			}
			if(y==0)
			{
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "");
			}
			//Increase i for evidence entry
			i=i+1;
			//Verify note
			String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/span"))).getText().trim();
			softly.assertThat(note).as("test data").isEqualTo(hircaNoteLopStep4.get(level3));
			i=i+1;
			//Verify Evidence Entry text not visible
			try{
				WebElement l1 = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"));
				if(l1.isDisplayed()==true)
					softly.fail("Evidence Entry text visible");
			}catch (NoSuchElementException q)
			{
				System.out.println("No Evidence Entry text visible as the + sign for Evidence Entry has not been clicked");
			}
			//Click on Evidence Entry
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))));
			Thread.sleep(1000);
			//Verify the text
			String lop3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"))).getText().trim();
			System.out.println(lop3);
			String r = lop3.replaceAll("\u00AD", "");
			softly.assertThat(r).as("test data").isEqualTo(textEvidence(driver));
			//Click on Evidence Entry
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))));
			//Verify Evidence Entry text not visible
			if(browserName.contains("safari")==false)
			{
				try{
					WebElement l1 = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"));
					if(l1.isDisplayed()==true)
						softly.fail("Evidence Entry text visible");
				}catch (NoSuchElementException q)
				{
					System.out.println("No Evidence Entry text visible as the + sign for Evidence Entry has not been clicked");
				}
			}
			//Increase i for extra root cause text boxes
			i=i+1;
			//Fill the text boxes
			if(iter.hasNext()) {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[1]"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[1]"))).sendKeys(iter.next());
			}
			if(iter.hasNext()) {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[1]"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[2]"))).sendKeys(iter.next());
			}
			if(iter.hasNext()) {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[3]"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea[3]"))).sendKeys(iter.next());
			}
			//Increase i for changing corrective actions
			i=i+1;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).sendKeys(iter.next());
			}
			//Increase i for next root cause
			i=i+1;
		}
		//Verifies if any contributing factors
		//tr starts at 2 and each root cause has 4 four rows
		System.out.println("Starting row of contributing factors:"+i);
		int start = i-1;
		//Verify if any contributing factors are appearing
		int x = 4;
		while(i<=((count1*x)+start))
		{
			//Get name of level 3 answer
			String level3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
			System.out.println(level3);
			System.out.println(lopOptions1);
			//Verify if this level 3 answer was selected
			if(lopOptions1.contains(level3.trim())==false)
			{
				softly.fail("Level 3 is not suppose to be here: "+level3);
			}
			//verify level 3 answer without :
			int n = lopOptions1.indexOf(level3.trim());
			System.out.println("n: "+n);
			String l="";
			try{
				l = l+lopOptions.get(n).replace("]", "");
				System.out.println(l);
			}catch(ArrayIndexOutOfBoundsException r)
			{
				System.out.println(lopOptions);
				l = l+lopOptions.get(n);
			}
			System.out.println(l);
			//Check if it has 4 boxes ticked
			try{
				if(options.get(l)>3)
				{
					softly.fail("All four boxes are ticked"+ options.get(l));
				}
			}catch(ArrayIndexOutOfBoundsException r)
			{
				System.out.println(l+"****\n"+options);
			}
			//Check if Level 3 is contributing factors
			String lop1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div[2]/input"))).getAttribute("checked");
			System.out.println(lop1);
			softly.assertThat(lop1).as("test data").isEqualTo("true");
			//Check if Level 3 is not a root cause
			String lop4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[2]/fieldset/div/div/input"))).getAttribute("disabled");
			System.out.println(lop4);
			softly.assertThat(lop4).as("test data").isEqualTo("true");
			//HML random select
			//Select a number between 0 to 3 for H,M,L
			Random random = new Random();
			int y=random.nextInt(4);
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div[1]/label"))));
			if(y==1)
			{
				//Click on H
				while(true)
				{
					if(browserName.contains("safari")==false)
					{
						executor.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
						executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
	//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
					}
					else executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).getAttribute("class").contains("ui-radio-on"))
						break;
				}
				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				System.out.println(lop2);
				softly.assertThat(lop2).as("test data").isEqualTo("H");
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "High");
			}
			if(y==2)
			{
				//Click on M
				while(true)
				{
					if(browserName.contains("safari")==false)
					{
						executor.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
						executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
						//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
					}
					else executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).getAttribute("class").contains("ui-radio-on"))
						break;
				}
				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				System.out.println(lop2);
				softly.assertThat(lop2).as("test data").isEqualTo("M");
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "Medium");
			}
			if(y==3)
			{
				//Click on L
				while(true)
				{
					if(browserName.contains("safari")==false)
					{
						executor.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
						executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
	//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).click();
					}
					else executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/label"))).getAttribute("class").contains("ui-radio-on"))
						break;
				}
				String lop2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[3]/fieldset/div/div["+y+"]/input"))).getAttribute("piivalue");
				System.out.println(lop2);
				softly.assertThat(lop2).as("test data").isEqualTo("L");
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "Low");
			}
			if(y==0)
			{
				//Insert level 3 answer without [, ] , : after the serial no (for eg, 3.17.1)
				hml.put(l, "");
			}
			//Increase i for evidence entry
			i=i+1;
			//Verify note
			String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/span"))).getText().trim();
			softly.assertThat(note).as("test data").isEqualTo(hircaNoteLopStep4.get(level3));
			i=i+1;
			//Verify Evidence Entry text not visible
			try{
				WebElement l1 = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"));
				if(l1.isDisplayed()==true)
					softly.fail("Evidence Entry text visible");
			}catch (NoSuchElementException q)
			{
				System.out.println("No Evidence Entry text visible as the + sign for Evidence Entry has not been clicked");
			}
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))));
			//Click on Evidence Entry
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))));
			//Verify the text
			String lop3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"))).getText().trim();
			System.out.println(lop3);
			String re = lop3.replaceAll("\u00AD", "");
			softly.assertThat(re).as("test data").isEqualTo(textEvidence(driver));
			//Click on Evidence Entry
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))));
			//Verify Evidence Entry text not visible
			if(browserName.contains("safari")==false)
			{
				try{
					WebElement l1 = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"));
					if(l1.isDisplayed()==true)
						softly.fail("Evidence Entry text visible");
				}catch (NoSuchElementException q)
				{
					System.out.println("No Evidence Entry text visible as the + sign for Evidence Entry has not been clicked");
				}
			}
			//Increase i for changing corrective actions
			i=i+1;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).clear();
			Thread.sleep(2000);
			if(iter.hasNext()) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/textarea"))).sendKeys(iter.next());
			}
			//Increase i for next contributing factor
			i=i+1;
		}
		//Scroll up
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		return hml;
	}

	public List<String> verifyHiRCAChecklist(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText().trim();
		softly.assertThat(title).as("test data").contains("Step 5 - HiRCA");
		softly.assertThat(title).as("test data").contains(" Self Checklist");
		//Verify category General and its questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[1]/strong"))).getText().trim();
		softly.assertThat(s1.replace("  ", " ")).as("test data").isEqualTo("General");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[2]/td[2]"))).getText().trim();
		softly.assertThat(s2.replace("  ", " ")).as("test data").isEqualTo("All involved parties interviewed and all relevant data collected?");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[3]/td[2]"))).getText().trim();
		softly.assertThat(s3.replace("  ", " ")).as("test data").isEqualTo("Past similar events examined?");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[4]/td[2]"))).getText().trim();
		softly.assertThat(s4.replace("  ", " ")).as("test data").isEqualTo("Triggering event and related LOPs identified?");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[1]/strong"))).getText().trim();
		softly.assertThat(s5.replace("  ", " ")).as("test data").isEqualTo("Triggering Event");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[5]/td[2]"))).getText().trim();
		softly.assertThat(s6.replace("  ", " ")).as("test data").isEqualTo("Error type involving the triggering event determined?");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[6]/td[2]"))).getText().trim();
		softly.assertThat(s7.replace("  ", " ")).as("test data").isEqualTo("Any equipment failure (if any) involving in the triggering event investigated for its triggering errors?");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[7]/td[2]"))).getText().trim();
		softly.assertThat(s8.replace("  ", " ")).as("test data").isEqualTo("Contributing factors determined?");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[1]/strong"))).getText().trim();
		softly.assertThat(s9.replace("  ", " ")).as("test data").isEqualTo("Root Causes");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[2]"))).getText().trim();
		softly.assertThat(s10.replace("  ", " ")).as("test data").contains("Root causes meeting SUEP");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[8]/td[2]"))).getText().trim();
		softly.assertThat(s11.replace("  ", " ")).as("test data").contains(" criteria?");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[2]"))).getText().trim();
		softly.assertThat(s12.replace("  ", " ")).as("test data").contains("Root causes surviving the CHOP'N");
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[9]/td[2]"))).getText().trim();
		softly.assertThat(s13.replace("  ", " ")).as("test data").contains(" challenge?");
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[10]/td[2]"))).getText().trim();
		softly.assertThat(s14.replace("  ", " ")).as("test data").isEqualTo("Levels of importance for root causes identified?");
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[1]/strong"))).getText().trim();
		softly.assertThat(s15.replace("  ", " ")).as("test data").isEqualTo("Corrective Actions");
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[11]/td[2]"))).getText().trim();
		softly.assertThat(s16.replace("  ", " ")).as("test data").isEqualTo("Recommended corrective actions covering all root causes and contributing factors?");
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr[12]/td[2]"))).getText().trim();
		softly.assertThat(s17.replace("  ", " ")).as("test data").isEqualTo("Recommended corrective actions cost effective?");
		//Select checklist options randomly
		//List for HiRCA checklist
		List<String> checklist = new ArrayList<String>();
		//Pick number of options 0 to 11
		Random random = new Random();
		int options = random.nextInt(12);
		System.out.println("No of Hirca checklist options:"+options);
		int c;
		for(int i=1;i<=options;i++)
		{
			//Pick the checkbox
			while(true)
			{
				//Pick a number between 2 and 12 for tr
				c = random.nextInt(13);
				if(c<2)
					continue;
				else
					break;
			}
			System.out.println("tr:"+c);
			WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+c+"]/td[3]/div/input")));
			if(e.isSelected()==true)
				continue;
			else
				e.click();
			//Store area checked in list
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+c+"]/td[2]"))).getText().trim();
			checklist.add(s);
		}
		System.out.println(checklist);
		return checklist;
	}

	public HashMap<String,Integer> verifySUEP (WebDriver driver, List<String> lopOptions, SoftAssertions softly, MultiValuedMap<String,String> hircaNoteLopSURE) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify SUEP title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText().trim();
		softly.assertThat(title).as("test data").contains("Step 3 - Root Causes Determination Checklist (SUEP");
		//Verify SUEP full form
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[1]"))).getText().trim();
		softly.assertThat(s1).as("test data").isEqualTo("S: Substandard Practice?");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]"))).getText().trim();
		softly.assertThat(s2).as("test data").isEqualTo("U: Under Management Control?");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]"))).getText().trim();
		softly.assertThat(s3).as("test data").isEqualTo("E: Early in Event Sequence?");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]"))).getText().trim();
		softly.assertThat(s4).as("test data").isEqualTo("P: Prevention Of Recurrence?");
		//Remove [] from lopOptions
		List<String> lopOptions1 = new ArrayList<String>();
		for(int k=0;k<lopOptions.size();k++)
		{
			String s =lopOptions.get(k).trim().replace("[", "");
			String l = s.replace("]", "");
			lopOptions1.add(l);			
		}
		//Hashmap for storing number of SUEP checkboxes ticked
		HashMap<String,Integer> options = new HashMap<String,Integer> ();
		//Get size of 3.17 options
		int n=lopOptions1.size();
		if (n<1)
			return options;
		//Row no starts from 2
		int i=2;
		//Count for root causes
		int r=0;
		int x=3;
		while(i<=((n*x)+1))
		{
			//Get text of option of 3.17
			String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td[1]"))).getText().trim();
			if(lopOptions1.contains(s5.trim())==false)
			{
				softly.fail("LOP option not present on Step 3 "+s5);
			}
			//Click on random SUEP
			Random random = new Random();
			//Choose a number between 0 and 4 for number of selections
			int num=random.nextInt(5);
			if (num==4)
				r=r+1;
			//Store no of SUEP checkboxes in hashmap: key=level 3 answer, value = no of suep checks
			options.put(s5.trim(), num);
			//Scroll to element
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]"))));
			for (int j=1;j<=num;j++)
			{
				Thread.sleep(1000);
				//Click on checkbox of SUEP
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				while(true)
				{
					executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input"))));
					if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td["+(j+1)+"]/div/input"))).isSelected()==true)
						break;
				}
			}
			//Increase i+1 for evidence entry
			i=i+1;
			String note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/span"))).getText().trim();
			if(note.substring(note.length()-1, note.length()).equals(" "))
			{
				String newNote1 = note.substring(0, note.length()-1);
				List<String> temp = new ArrayList<String>(hircaNoteLopSURE.get(s5));
				softly.assertThat(newNote1).as("test data").contains(temp.get(0));
			}
			if(note.contains(" :"))
			{
				String sub = hircaNoteLopSURE.get(s5).toString();
				String sub1 = sub.substring(0, sub.indexOf("?")).replace("[", "").replace("]", "");
				String sub2 = sub.substring(sub.indexOf("?")+3, sub.length()).replace("[", "").replace("]", "");
				softly.assertThat(note).as("test data").contains(sub1);
				softly.assertThat(note).as("test data").contains(sub2);
			}
			else
			{
				if(hircaNoteLopSURE.get(s5).contains(note)==false)
					softly.fail("Note is not correct in SUEP table in step 3: "+hircaNoteLopSURE.get(s5)+"\n"+note);
			}
			//contains((Collection<String>)hircaNoteLopSURE.get(s5));
			i=i+1;
			//Verify Evidence Entry text not visible
			try{
				WebElement l = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"));
				if(l.isDisplayed()==true)
					softly.fail("Evidence Entry text visible");
			}catch (NoSuchElementException q)
			{
				System.out.println("No Evidence Entry text visible as the + sign for Evidence Entry has not been clicked");
			}
			//Click on Evidence Entry collapsible
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))));
			if(driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div")).isDisplayed()==false)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			}
			//Get text from Evidence Entry and verify if equal to text
			String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"))).getText().trim();
			String re = s6.replaceAll("\u00AD", "");
			softly.assertThat(re).as("test data").isEqualTo(textEvidence(driver));
			//Click on Evidence Entry collapsible
			executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))));
			while(true)
			{
				if(driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div")).isDisplayed()==false)
				{
					break;
				}				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/h4/a"))).click();
			}
			//Verify Evidence Entry text not visible
			try{
				WebElement l = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/table/tbody/tr["+i+"]/td/div/div/div"));
				if(l.isDisplayed()==true)
					softly.fail("Evidence Entry text visible");
			}catch (NoSuchElementException q)
			{
				System.out.println("No Evidence Entry text visible as the + sign for Evidence Entry has not been clicked");
			}
			//Increase i+1 for next option
			i=i+1;
		}
		//Add no of root causes in hashmap
		options.put("Root causes",r);
		System.out.println(options);
		//Scroll up
		share2.scrollToTop(driver);
		Thread.sleep(2000);
		return options;
	}

	public void verify222 (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify LOP title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText().trim();
		softly.assertThat(title).as("test data").contains("[2.22] Was HiRCA");
		softly.assertThat(title).as("test data").contains("adequate in leading this investigation?");
		//Verify 3.17 questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s1).as("test data").isEqualTo("No");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s2).as("test data").isEqualTo("Yes, but need more training");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s3).as("test data").isEqualTo("Yes");
	}

	public void verify221(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify LOP title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText().trim();
		softly.assertThat(title).as("test data").contains("[2.21] What LOPs can prevent this event from happening?");
		//Verify 2.21 options for LOP
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s1).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s2).as("test data").isEqualTo("Concurrent check");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s3).as("test data").isEqualTo("Error-proof design");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s4).as("test data").isEqualTo("Independent check");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s5).as("test data").isEqualTo("JIT alarm");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s6).as("test data").isEqualTo("JIT reminder (signage, not-to do postings)");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s7).as("test data").isEqualTo("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s8).as("test data").isEqualTo("Peer coaching");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s9).as("test data").isEqualTo("Review (PNR, Technical review)");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s10).as("test data").isEqualTo("Self-check");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[12]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s11).as("test data").isEqualTo("Supervisory intervention");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[13]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s12).as("test data").isEqualTo("Other:");
	}

	public void verifyLOP(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(2000);
		//Verify LOP title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText().trim();
		softly.assertThat(title).as("test data").contains("[2.0] What were the failed LOPs (3 max) that caused this event to happen?");
		//Verify 3.17 questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s1).as("test data").isEqualTo("Briefings (PJB, MJB, PSM, TO, etc.)");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s2).as("test data").isEqualTo("Concurrent check");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s3).as("test data").isEqualTo("Error-proof design");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s4).as("test data").isEqualTo("Independent check");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s5).as("test data").isEqualTo("JIT alarm");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s6).as("test data").isEqualTo("JIT reminder (signage, not-to do postings)");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s7).as("test data").isEqualTo("Passive protection (safety net, fall protection, air bags, safety belt, etc.)");
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[9]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s8).as("test data").isEqualTo("Peer coaching");
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[10]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s9).as("test data").isEqualTo("Review (PNR, Technical review)");
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[11]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s10).as("test data").isEqualTo("Self-check");
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[12]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s11).as("test data").isEqualTo("Supervisory intervention");
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[13]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s12).as("test data").isEqualTo("Other:");
	}

	public void select3LOP (WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Scroll to the bottom
		share2.scrollToAPoint(driver, 1200);
		Random random = new Random();
		//Choose a number between 1 and 3 for number of selections
		int n;
		while (true)
		{
			n=random.nextInt(4);
			if (n<1)
				continue;
			break;
		}
		System.out.println("No of selections: "+n);
		int y;
		for (int i=1;i<=n;i++)
		{
			//Choose a number between 2 and 13 for LOPs
			while(true)
			{
				y=random.nextInt(9);
				System.out.println("Chose a no"+y);
				if(y==0||y==1)
					continue;
				String e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getAttribute("class");
				if(e.contains("ui-checkbox-on"))
					continue;
				break;
			}
			System.out.println("Picked a no");
			System.out.println("Option no: "+y);
			Thread.sleep(500);
			//Click on LOP
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
		}
		//Scroll to the top
		share2.scrollToTop(driver);
		Thread.sleep(2000);
	}

	public List<String> verify317(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify 3.17 title
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-question"))).getText().trim();
		softly.assertThat(title).as("test data").contains("QTM - equipment qualification, testing and maintenance");
		//Verify 3.17 questions
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[2]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s1).as("test data").contains("[3.17.1] Inadequate procurement and/or design specifications");
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[3]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s2).as("test data").contains("[3.17.2] Inadequate source audit / inspection QA/QC for compliance (if applicable)");
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[4]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s3).as("test data").contains("[3.17.3] Inadequate design qualification and/or testing before use");
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[5]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s4).as("test data").contains("[3.17.4] Inadequate operation: (1) Inadequate operation procedure; (2) Inadequate operating condition; (3) Operation errors");
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[6]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s5).as("test data").contains("[3.17.5] Inadequate periodic surveillance testing");
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[7]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s6).as("test data").contains("[3.17.6] Inadequate maintenance");
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div[8]/fieldset/div/div/label"))).getText().trim();
		softly.assertThat(s7).as("test data").contains("[3.17.7] Inadequate equipment labeling and identification");
		List<String> lopOptions = select317(driver);
		return lopOptions;
	}

	public List<String> select317(WebDriver driver) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		HiRCALOPBug obj = new HiRCALOPBug();
		List<String>  lopOptions1=new ArrayList<String>();
		//Verify collapsible of description
		obj.collapsibleCheckDescription(driver);
		//Click on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		//Verify Description text
		String lop3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-description-text"))).getText().trim();
		System.out.println(lop3);
		softly.assertThat(lop3).as("test data").contains("If the triggering event is caused by equipment, the user can do a preliminary assessment on the equipment's design spec qualification, testing and maintenance. It is recommended to use MainClass.EiRCA");
		softly.assertThat(lop3).as("test data").contains(" to do a troubleshooting specifically for equipment failures.");
		//Clicks on Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-description']/h4/a"))).click();
		Random random = new Random();
		//Choose a number between 0 and 7 for number of selections
		int n=random.nextInt(8);
		//n=0;
		System.out.println("No of selections: "+n);
		//If number of selections is 0 return empty list
		if(n==0)
			return lopOptions1;
		int y;
		for (int i=1;i<=n;i++)
		{
			//Choose a number between 2 and 8 for 3.17
			while(true)
			{
				y=random.nextInt(9);
				System.out.println("Chose a no"+y);
				if(y==0||y==1)
					continue;
				WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/input")));
				if(e.isSelected())
					continue;
				break;
			}
			System.out.println("Picked a no");
			System.out.println("Option no: "+y);
			Thread.sleep(500);
			share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			//Click on a lop inquiry in 3.17
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			while (true)
			{
				WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/input")));
				if(e.isSelected())
					break;
				else
					executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))));
			}
			//Click on Evidence Entry
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/h4/a"))));
			while (true)
			{
				if(driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/div/textarea")).isDisplayed()==true)
					break;
				else
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/h4/a"))).click();  
			}
			//Fill in evidence entry text
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/div/textarea"))).sendKeys(textEvidence(driver));
			//Click on Evidence Entry
			executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/h4/a"))));
			while (true)
			{
				try{
					if(driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/div/textarea")).isDisplayed()==false)
						break;
					else
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div/h4/a"))).click(); 
				}catch(NoSuchElementException r)
				{
					break;
				}
			}
			String s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div/label"))).getText().trim();
			//remove the [ from Level 3.17 options
			s=s.replace("[", "");
			lopOptions1.add(s.trim());
			//Check if Evidence Entry, Further Investigation and Possible corrective action are in collapsible form
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			String browserName = cap.getBrowserName().toLowerCase();
			if (browserName.contains("chrome")||browserName.contains("firefox")||browserName.contains("internet explorer"))
			{
				checkCollapsibleEEFIPCA(driver,y);
			}
		}
		//Add contributing factor
		lopOptions1.add(addContributingFactor(driver).trim());
		share2.scrollToTop(driver);	
		System.out.println(lopOptions1);
		return lopOptions1;
	}

	public String addContributingFactor(WebDriver driver) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Identify number of answers for a level 3
		int count = 2;
		int k=1;
		while(true)
		{
			try{
				k=k+1;
				String s = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div["+k+"]")).getAttribute("class");
				if(s.equals("ui-contain"))
					count = count + 1;
			}catch(NoSuchElementException e)
			{
				break;
			}
		}
		//Scroll to add cf button
		//Click on answer
		WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-button")));
		//Scroll to element
		share2.scrollToElement(driver, l);
		//Click on add new contributing factor
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", l);
		//Enter contributing factor
		share2.scrollToElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-cf"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-cf"))).sendKeys("contributing factor");
		Thread.sleep(1000);
		//Click on save
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pii-irca-addnewcf-save"))));
		Thread.sleep(1000);
		//Wait for loading message
		share2.loadingServer(driver);
		//Get text of new contributing factor
		l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+count+"]/fieldset/div/div/label")));
		//Click on Evidence Entry
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+count+"]/fieldset/div/div[2]/div/h4/a"))));
		//Fill in evidence entry text
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+count+"]/fieldset/div/div[2]/div/div/textarea"))).sendKeys(textEvidence(driver));
		String s1=l.getText().replace("[", "");
		//Get last index of r
		int n = s1.lastIndexOf("r");
		return s1.substring(0, n+1);
	}

	public void checkCollapsibleEEFIPCA(WebDriver driver,int y) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Verify Evidence Entry text not visible
		try{
			WebElement l = driver.findElement(By.id("efi-opa-evidence-text-"+(y-1)));
			if(l.isDisplayed()==true)
				softly.fail("Evidence Entry text visible");
		}catch (NoSuchElementException r)
		{
			System.out.println("No Evidence Entry visible as the + sign for Evidence Entry has not been clicked");
		}
		//Click on Evidence Entry
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-"+(y-2)+"']/h4/a"))));
		while (true)
		{
			if(driver.findElement(By.id("efi-irca-evidence-text-"+(y-2))).isDisplayed()==true)
				break;
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-"+(y-2)+"']/h4/a"))).click();  
		}
		//Verify Evidence Entry text
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("efi-irca-evidence-text-"+(y-2))));
		//Click on Evidence Entry again
		executor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-"+(y-2)+"']/h4/a"))));
		while (true)
		{
			if(driver.findElement(By.id("efi-irca-evidence-text-"+(y-2))).isDisplayed()==false)
				break;
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-evidence-text-div-"+(y-2)+"']/h4/a"))).click();  
		}
		//Verify Evidence Entry text not visible
		try{
			WebElement l = driver.findElement(By.id("efi-irca-evidence-text-"+(y-2)));
			if(l.isDisplayed()==true)
				softly.fail("Evidence Entry text visible");
		}catch (NoSuchElementException r)
		{
			System.out.println("No Evidence Entry text visible as the + sign for Evidence Entry has not been clicked");
		}

		//Verify Further Investigation text not visible
		try{
			WebElement l = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/div"));
			if(l.isDisplayed()==true)
				softly.fail("Further Investigation text visible");
		}catch (NoSuchElementException r)
		{
			System.out.println("No Further Investigation text visible as the + sign for Further Investigation has not been clicked");
		}
		//Click on Further Investigation
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/h4/a"))));
		//Verify Further Investigation text
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/div")));
		//Click on Further Investigation again
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/h4/a"))));
		//Verify Further Investigation text not visible
		try{
			WebElement l = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[2]/div"));
			if(l.isDisplayed()==true)
				softly.fail("Further Investigation text visible");
		}catch (NoSuchElementException r)
		{
			System.out.println("No Further Investigation text visible as the + sign for Further Investigation has not been clicked");
		}

		//Verify Possible Corrective Action text not visible
		try{
			WebElement l = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[3]/div"));
			if(l.isDisplayed()==true)
				softly.fail("Possible Corrective Action text visible");
		}catch (NoSuchElementException r)
		{
			System.out.println("No Possible Corrective Action text visible as the + sign for Possible Corrective Action has not been clicked");
		}
		//Click on Possible Corrective Action 
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[3]/h4/a"))));
		//Verify Possible Corrective Action text
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[3]/div")));
		//Click on Possible Corrective Action again
		executor.executeScript("arguments[0].click();",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[3]/h4/a"))));
		//Verify Possible Corrective Action text not visible
		try{
			WebElement l = driver.findElement(By.xpath(".//*[@id='efi-irca-answers']/div["+y+"]/fieldset/div/div[2]/div[3]/div"));
			if(l.isDisplayed()==true)
				softly.fail("Possible Corrective Action text visible");
		}catch (NoSuchElementException r)
		{
			System.out.println("No Possible Corrective Action text visible as the + sign for Possible Corrective Action has not been clicked");
		}
	}

	public void softAssert() throws Exception {
		softly.assertAll();
		System.gc();
	}

}
