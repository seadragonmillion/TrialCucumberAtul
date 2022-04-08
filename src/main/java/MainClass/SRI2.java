package MainClass;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import PageObjects.EiRCAPageObj;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SRI2 {

	ShareCheck2 share2 = new ShareCheck2();
	SRIPageObj sri = new SRIPageObj();
	EiRCAPageObj eirca = new EiRCAPageObj();
	SRIAdmin sriA = new SRIAdmin();
	SRIAdmin2 sriA2 = new SRIAdmin2();
	SRI3 sri3 = new SRI3();

	public String text = "MainClass.SRI sanity test";

	public void verifyHTML(WebDriver driver,  HashMap<String,String> storeDataStep1,  HashMap<String,String> storeDataStep2, SoftAssertions softly)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		//Verify data in Report tab
		//Event information
		//Event title
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLEventTitle)).getText();
		softly.assertThat(s).as("test data").isEqualTo(storeDataStep1.get("event title"));
		//Inspection staff
		String s1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLInspectionStaff)).getText();
		softly.assertThat(s1).as("test data").isEqualTo(storeDataStep1.get("inspection staff"));
		//Component
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLComponent)).getText();
		softly.assertThat(s2).as("test data").isEqualTo(storeDataStep1.get("component"));
		//Measurements
		//1
		//Date
		String date1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1Date)).getText();
		softly.assertThat(date1).as("test data").isEqualTo(storeDataStep2.get("date1"));
		//Time
		String time1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1Time)).getText();
		softly.assertThat(time1).as("test data").isEqualTo(storeDataStep2.get("time1"));
		//Measurement
		String measurement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1Measurement)).getText();
		softly.assertThat(measurement1).as("test data").isEqualTo(storeDataStep2.get("measurement1"));
		//unit
		String unit1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1Unit)).getText();
		softly.assertThat(unit1).as("test data").isEqualTo(storeDataStep2.get("unit1"));
		//Value
		String value1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1Value)).getText();
		softly.assertThat(value1).as("test data").isEqualTo(storeDataStep2.get("value1"));
		//Notes
		String note1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1Note)).getText();
		softly.assertThat(note1).as("test data").isEqualTo(storeDataStep2.get("note1"));
		//Conclusion
		String conclusion1 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1Conclusion)).getText();
		verifyConclusion(driver, conclusion1, value1, measurement1, softly);
		String conclusion1a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement1ConclusionColorText)).getText();
		verifyConclusionColorAndText(driver,conclusion1a,value1,measurement1,softly);
		//2
		//Date
		String date2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2Date)).getText();
		softly.assertThat(date2).as("test data").isEqualTo(storeDataStep2.get("date2"));
		//Time
		String time2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2Time)).getText();
		softly.assertThat(time2).as("test data").isEqualTo(storeDataStep2.get("time2"));
		//Measurement
		String measurement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2Measurement)).getText();
		softly.assertThat(measurement2).as("test data").isEqualTo(storeDataStep2.get("measurement2"));
		//unit
		String unit2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2Unit)).getText();
		softly.assertThat(unit2).as("test data").isEqualTo(storeDataStep2.get("unit2"));
		//Value
		String value2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2Value)).getText();
		softly.assertThat(value2).as("test data").isEqualTo(storeDataStep2.get("value2"));
		//Notes
		String note2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2Note)).getText();
		softly.assertThat(note2).as("test data").isEqualTo(storeDataStep2.get("note2"));
		//Conclusion
		String conclusion2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2Conclusion)).getText();
		verifyConclusion(driver, conclusion2, value2, measurement2, softly);
		String conclusion2a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement2ConclusionColorText)).getText();
		verifyConclusionColorAndText(driver,conclusion2a,value2,measurement2,softly);
		//3
		//Date
		String date3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement3Date)).getText();
		softly.assertThat(date3).as("test data").isEqualTo(storeDataStep2.get("date3"));
		//Time
		String time3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement3Time)).getText();
		softly.assertThat(time3).as("test data").isEqualTo(storeDataStep2.get("time3"));
		//Measurement
		String measurement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement3Measurement)).getText();
		softly.assertThat(measurement3).as("test data").isEqualTo(storeDataStep2.get("measurement3"));
		//unit
		String unit3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement3Unit)).getText();
		softly.assertThat(unit3).as("test data").isEqualTo(storeDataStep2.get("unit3"));
		//Value
		String value3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement3Value)).getText();
		softly.assertThat(value3).as("test data").isEqualTo(storeDataStep2.get("value3"));
		//Notes
		String note3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement3Note)).getText();
		softly.assertThat(note3).as("test data").isEqualTo(storeDataStep2.get("note3"));
		//Conclusion
		String conclusion3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement3Conclusion)).getText();
		verifyConclusion(driver, conclusion3, value3, measurement3, softly);
		String conclusion3a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement3ConclusionColorText)).getText();
		verifyConclusionColorAndText(driver,conclusion3a,value3,measurement3,softly);
		//4
		//Date
		String date4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement4Date)).getText();
		softly.assertThat(date4).as("test data").isEqualTo(storeDataStep2.get("date4"));
		//Time
		String time4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement4Time)).getText();
		softly.assertThat(time4).as("test data").isEqualTo(storeDataStep2.get("time4"));
		//Measurement
		String measurement4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement4Measurement)).getText();
		softly.assertThat(measurement4).as("test data").isEqualTo(storeDataStep2.get("measurement4"));
		//unit
		String unit4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement4Unit)).getText();
		softly.assertThat(unit4).as("test data").isEqualTo(storeDataStep2.get("unit4"));
		//Value
		String value4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement4Value)).getText();
		softly.assertThat(value4).as("test data").isEqualTo(storeDataStep2.get("value4"));
		//Notes
		String note4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement4Note)).getText();
		softly.assertThat(note4).as("test data").isEqualTo(storeDataStep2.get("note4"));
		//Conclusion
		String conclusion4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement4Conclusion)).getText();
		verifyConclusion(driver, conclusion4, value4, measurement4, softly);
		String conclusion4a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement4ConclusionColorText)).getText();
		verifyConclusionColorAndText(driver,conclusion4a,value4,measurement4,softly);
		//5
		//Date
		String date5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement5Date)).getText();
		softly.assertThat(date5).as("test data").isEqualTo(storeDataStep2.get("date5"));
		//Time
		String time5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement5Time)).getText();
		softly.assertThat(time5).as("test data").isEqualTo(storeDataStep2.get("time5"));
		//Measurement
		String measurement5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement5Measurement)).getText();
		softly.assertThat(measurement5).as("test data").isEqualTo(storeDataStep2.get("measurement5"));
		//unit
		String unit5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement5Unit)).getText();
		softly.assertThat(unit5).as("test data").isEqualTo(storeDataStep2.get("unit5"));
		//Value
		String value5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement5Value)).getText();
		softly.assertThat(value5).as("test data").isEqualTo(storeDataStep2.get("value5"));
		//Notes
		String note5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement5Note)).getText();
		softly.assertThat(note5).as("test data").isEqualTo(storeDataStep2.get("note5"));
		//Conclusion
		String conclusion5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement5Conclusion)).getText();
		verifyConclusion(driver, conclusion5, value5, measurement5, softly);
		String conclusion5a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement5ConclusionColorText)).getText();
		verifyConclusionColorAndText(driver,conclusion5a,value5,measurement5,softly);
		//6
		//Date
		String date6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement6Date)).getText();
		softly.assertThat(date6).as("test data").isEqualTo(storeDataStep2.get("date6"));
		//Time
		String time6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement6Time)).getText();
		softly.assertThat(time6).as("test data").isEqualTo(storeDataStep2.get("time6"));
		//Measurement
		String measurement6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement6Measurement)).getText();
		softly.assertThat(measurement6).as("test data").isEqualTo(storeDataStep2.get("measurement6"));
		//unit
		String unit6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement6Unit)).getText();
		softly.assertThat(unit6).as("test data").isEqualTo(storeDataStep2.get("unit6"));
		//Value
		String value6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement6Value)).getText();
		softly.assertThat(value6).as("test data").isEqualTo(storeDataStep2.get("value6"));
		//Notes
		String note6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement6Note)).getText();
		softly.assertThat(note6).as("test data").isEqualTo(storeDataStep2.get("note6"));
		//Conclusion
		String conclusion6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement6Conclusion)).getText();
		verifyConclusion(driver, conclusion6, value6, measurement6, softly);
		String conclusion6a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement6ConclusionColorText)).getText();
		verifyConclusionColorAndText(driver,conclusion6a,value6,measurement6,softly);
		//7
		//Date
		String date7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement7Date)).getText();
		softly.assertThat(date7).as("test data").isEqualTo(storeDataStep2.get("date7"));
		//Time
		String time7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement7Time)).getText();
		softly.assertThat(time7).as("test data").isEqualTo(storeDataStep2.get("time7"));
		//Measurement
		String measurement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement7Measurement)).getText();
		softly.assertThat(measurement7).as("test data").isEqualTo(storeDataStep2.get("measurement7"));
		//unit
		String unit7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement7Unit)).getText();
		softly.assertThat(unit7).as("test data").isEqualTo(storeDataStep2.get("unit7"));
		//Value
		String value7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement7Value)).getText();
		softly.assertThat(value7).as("test data").isEqualTo(storeDataStep2.get("value7"));
		//Notes
		String note7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement7Note)).getText();
		softly.assertThat(note7).as("test data").isEqualTo(storeDataStep2.get("note7"));
		//Conclusion
		String conclusion7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement7Conclusion)).getText();
		verifyConclusion(driver, conclusion7, value7, measurement7, softly);
		String conclusion7a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement7ConclusionColorText)).getText();
		verifyConclusionColorAndText(driver,conclusion7a,value7,measurement7,softly);
		//8
		//Date
		String date8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement8Date)).getText();
		softly.assertThat(date8).as("test data").isEqualTo(storeDataStep2.get("date8"));
		//Time
		String time8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement8Time)).getText();
		softly.assertThat(time8).as("test data").isEqualTo(storeDataStep2.get("time8"));
		//Measurement
		String measurement8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement8Measurement)).getText();
		softly.assertThat(measurement8).as("test data").isEqualTo(storeDataStep2.get("measurement8"));
		//unit
		String unit8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement8Unit)).getText();
		softly.assertThat(unit8).as("test data").isEqualTo(storeDataStep2.get("unit8"));
		//Value
		String value8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement8Value)).getText();
		softly.assertThat(value8).as("test data").isEqualTo(storeDataStep2.get("value8"));
		//Notes
		String note8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement8Note)).getText();
		softly.assertThat(note8).as("test data").isEqualTo(storeDataStep2.get("note8"));
		//Conclusion
		String conclusion8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement8Conclusion)).getText();
		verifyConclusion(driver, conclusion8, value8, measurement8, softly);
		String conclusion8a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.HTMLMeasurement8ConclusionColorText)).getText();
		verifyConclusionColorAndText(driver,conclusion8a,value8,measurement8,softly);
	}

	public void verifyConclusionColorAndText(WebDriver driver, String conclusion, String value, String measurement, SoftAssertions softly)throws Exception {

		if(measurement.equals(sriA2.mechanicalMeasurement1))
		{
			if(Double.parseDouble(value)<=Double.parseDouble(sriA2.mechanicalFSIBaseline1))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Normal Operation");
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.mechanicalFSIBaseline2))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.mechanicalFSIBaseline1)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Incipient Failure Stage 1");
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.mechanicalFSIBaseline3))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.mechanicalFSIBaseline2)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Incipient Failure Stage 2");
			}
			if(Double.parseDouble(value)>Double.parseDouble(sriA2.mechanicalFSIBaseline3))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Incipient Failure Stage 3");
			}
		}
		if(measurement.equals(sriA2.electricalMeasurement1))
		{
			if(Double.parseDouble(value)<=Double.parseDouble(sriA2.electricalFSIBaseline1))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Normal Operation");
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.electricalFSIBaseline2))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.electricalFSIBaseline1)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Incipient Failure Stage 1");
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.electricalFSIBaseline3))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.electricalFSIBaseline2)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Incipient Failure Stage 2");
			}
			if(Double.parseDouble(value)>Double.parseDouble(sriA2.electricalFSIBaseline3))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Incipient Failure Stage 3");
			}
		}
		if(measurement.equals(sriA2.mechanicalMeasurement2))			
		{
			if(Double.parseDouble(value)<=Double.parseDouble(sriA2.mechanicalFSIBaseline4))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Normal Operation");
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.mechanicalFSIBaseline5))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.mechanicalFSIBaseline4)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Incipient Failure Stage 1");
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.mechanicalFSIBaseline6))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.mechanicalFSIBaseline5)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Incipient Failure Stage 2");
			}
			if(Double.parseDouble(value)>Double.parseDouble(sriA2.mechanicalFSIBaseline6))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Incipient Failure Stage 3");
			}
		}
		if(measurement.equals(sriA2.electricalMeasurement2))
		{
			if(Double.parseDouble(value)<=Double.parseDouble(sriA2.electricalFSIBaseline4))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Normal Operation");
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.electricalFSIBaseline5))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.electricalFSIBaseline4)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Incipient Failure Stage 1");
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.electricalFSIBaseline6))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.electricalFSIBaseline5)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Incipient Failure Stage 2");
			}
			if(Double.parseDouble(value)>Double.parseDouble(sriA2.electricalFSIBaseline6))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Conclusion: Incipient Failure Stage 3");
			}
		}
	}

	public void verifyConclusion(WebDriver driver, String conclusion, String value, String measurement, SoftAssertions softly)throws Exception {

		if(measurement.equals(sriA2.mechanicalMeasurement1))
		{
			if(Double.parseDouble(value)<=Double.parseDouble(sriA2.mechanicalFSIBaseline1))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Within normal operation limits");
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.mechanicalFSIBaseline2))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.mechanicalFSIBaseline1)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo(sriA2.mechanicalFSIConclusion1);
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.mechanicalFSIBaseline3))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.mechanicalFSIBaseline2)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo(sriA2.mechanicalFSIConclusion2);
			}
			if(Double.parseDouble(value)>Double.parseDouble(sriA2.mechanicalFSIBaseline3))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo(sriA2.mechanicalFSIConclusion3);
			}
		}
		if(measurement.equals(sriA2.electricalMeasurement1))
		{
			if(Double.parseDouble(value)<=Double.parseDouble(sriA2.electricalFSIBaseline1))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Within normal operation limits");
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.electricalFSIBaseline2))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.electricalFSIBaseline1)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo(sriA2.electricalFSIConclusion1);
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.electricalFSIBaseline3))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.electricalFSIBaseline2)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo(sriA2.electricalFSIConclusion2);
			}
			if(Double.parseDouble(value)>Double.parseDouble(sriA2.electricalFSIBaseline3))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo(sriA2.electricalFSIConclusion3);
			}
		}
		if(measurement.equals(sriA2.mechanicalMeasurement2))			
		{
			if(Double.parseDouble(value)<=Double.parseDouble(sriA2.mechanicalFSIBaseline4))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Within normal operation limits");
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.mechanicalFSIBaseline5))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.mechanicalFSIBaseline4)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo(sriA2.mechanicalFSIConclusion1);
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.mechanicalFSIBaseline6))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.mechanicalFSIBaseline5)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo(sriA2.mechanicalFSIConclusion2);
			}
			if(Double.parseDouble(value)>Double.parseDouble(sriA2.mechanicalFSIBaseline6))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo(sriA2.mechanicalFSIConclusion3);
			}
		}
		if(measurement.equals(sriA2.electricalMeasurement2))
		{
			if(Double.parseDouble(value)<=Double.parseDouble(sriA2.electricalFSIBaseline4))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo("Within normal operation limits");
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.electricalFSIBaseline5))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.electricalFSIBaseline4)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo(sriA2.electricalFSIConclusion1);
			}
			if((Double.parseDouble(value)<=Double.parseDouble(sriA2.electricalFSIBaseline6))&&(Double.parseDouble(value)>Double.parseDouble(sriA2.electricalFSIBaseline5)))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo(sriA2.electricalFSIConclusion2);
			}
			if(Double.parseDouble(value)>Double.parseDouble(sriA2.electricalFSIBaseline6))
			{
				softly.assertThat(conclusion).as("test data").isEqualTo(sriA2.electricalFSIConclusion3);
			}
		}
	}

	public HashMap<String,String> getStep2AllData(WebDriver driver)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait1 = new WebDriverWait(driver,3);
		HashMap<String,String> storeData = new HashMap<String,String>();
		WebElement ele;
		//1
		//Get date 1
		try{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Date));
		}catch(org.openqa.selenium.TimeoutException t)
		{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1DateFirefox));
		}
		String s = ele.getAttribute("value");
		//Get time 1
		try{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Time));
		}catch(org.openqa.selenium.TimeoutException t)
		{
			ele = wait1.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1TimeFirefox));
		}
		String s1 = ele.getAttribute("value");
		//Get Measurement 1
		String s2 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Measurement)).getText();
		//Get unit 1
		String s2a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Unit)).getText();
		//Get value 1
		String s3 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Value)).getAttribute("value");
		//Get note 1
		String s4 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement1Note)).getAttribute("value");
		//2
		//Get date 2
		String s5 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Date)).getAttribute("value");
		//Get time 2
		String s6 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Time)).getAttribute("value");
		//Get Measurement 2
		String s7 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Measurement)).getText();
		//Get unit 
		String s7a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Unit)).getText();
		//Get value 2
		String s8 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Value)).getAttribute("value");
		//Get note 2
		String s9 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement2Note)).getAttribute("value");
		//3
		//Get date 
		String s10 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement3Date)).getAttribute("value");
		//Get time 
		String s11 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement3Time)).getAttribute("value");
		//Get Measurement 
		String s12 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement3Measurement)).getText();
		//Get unit 
		String s12a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement3Unit)).getText();
		//Get value 
		String s13 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement3Value)).getAttribute("value");
		//Get note 
		String s14 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement3Note)).getAttribute("value");		
		//4
		//Get date 
		String s15 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement4Date)).getAttribute("value");
		//Get time 
		String s16 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement4Time)).getAttribute("value");
		//Get Measurement 
		String s17 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement4Measurement)).getText();
		//Get unit 
		String s17a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement4Unit)).getText();
		//Get value 
		String s18 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement4Value)).getAttribute("value");
		//Get note 
		String s19 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement4Note)).getAttribute("value");
		//5
		//Get date 
		String s20 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement5Date)).getAttribute("value");
		//Get time 
		String s21 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement5Time)).getAttribute("value");
		//Get Measurement 
		String s22 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement5Measurement)).getText();
		//Get unit 
		String s22a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement5Unit)).getText();
		//Get value 
		String s23 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement5Value)).getAttribute("value");
		//Get note 
		String s24 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement5Note)).getAttribute("value");
		//6
		//Get date 
		String s25 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement6Date)).getAttribute("value");
		//Get time 
		String s26 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement6Time)).getAttribute("value");
		//Get Measurement 
		String s27 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement6Measurement)).getText();
		//Get unit 
		String s27a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement6Unit)).getText();
		//Get value 
		String s28 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement6Value)).getAttribute("value");
		//Get note 
		String s29 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement6Note)).getAttribute("value");
		//7
		//Get date 
		String s30 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement7Date)).getAttribute("value");
		//Get time 
		String s31 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement7Time)).getAttribute("value");
		//Get Measurement 
		String s32 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement7Measurement)).getText();
		//Get unit 
		String s32a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement7Unit)).getText();
		//Get value 
		String s33 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement7Value)).getAttribute("value");
		//Get note 
		String s34 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement7Note)).getAttribute("value");
		//8
		//Get date 
		String s35 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement8Date)).getAttribute("value");
		//Get time 
		String s36 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement8Time)).getAttribute("value");
		//Get Measurement 
		String s37 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement8Measurement)).getText();
		//Get unit 
		String s37a = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement8Unit)).getText();
		//Get value 
		String s38 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement8Value)).getAttribute("value");
		//Get note 
		String s39 = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.Step2Measurement8Note)).getAttribute("value");
		//1
		storeData.put("date1", s);
		storeData.put("time1", s1);
		storeData.put("measurement1", s2);
		storeData.put("unit1", s2a);
		storeData.put("value1", s3);
		storeData.put("note1", s4);
		//2
		storeData.put("date2", s5);
		storeData.put("time2", s6);
		storeData.put("measurement2", s7);
		storeData.put("unit2", s7a);
		storeData.put("value2", s8);
		storeData.put("note2", s9);
		//3
		storeData.put("date3", s10);
		storeData.put("time3", s11);
		storeData.put("measurement3", s12);
		storeData.put("unit3", s12a);
		storeData.put("value3", s13);
		storeData.put("note3", s14);
		//4
		storeData.put("date4", s15);
		storeData.put("time4", s16);
		storeData.put("measurement4", s17);
		storeData.put("unit4", s17a);
		storeData.put("value4", s18);
		storeData.put("note4", s19);
		//5
		storeData.put("date5", s20);
		storeData.put("time5", s21);
		storeData.put("measurement5", s22);
		storeData.put("unit5", s22a);
		storeData.put("value5", s23);
		storeData.put("note5", s24);
		//6
		storeData.put("date6", s25);
		storeData.put("time6", s26);
		storeData.put("measurement6", s27);
		storeData.put("unit6", s27a);
		storeData.put("value6", s28);
		storeData.put("note6", s29);
		//7
		storeData.put("date7", s30);
		storeData.put("time7", s31);
		storeData.put("measurement7", s32);
		storeData.put("unit7", s32a);
		storeData.put("value7", s33);
		storeData.put("note7", s34);
		//8
		storeData.put("date8", s35);
		storeData.put("time8", s36);
		storeData.put("measurement8", s37);
		storeData.put("unit8", s37a);
		storeData.put("value8", s38);
		storeData.put("note8", s39);
		return storeData;
	}

	public void verifySavePopupAfterRename(WebDriver driver, SoftAssertions softly, String recordName, String username, String password, String component)throws Exception {

		WebDriverWait wait = new WebDriverWait(driver,10);
		//Click on open button
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.OpenButton)).click();
		sri3.verifyOpenReportPopup(driver, softly, recordName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		//Click on Info tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRIStep1Tab)).click();
		//Enter a very long name in Event title
		driver.findElement(sri.Step1EventTitle).clear();
		driver.findElement(sri.Step1EventTitle).sendKeys("Really long text which will make the report name o overflow out of the popup");
		//click on save
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveButton)).click();
		//Verify the popup
		String s = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavePopupNote)).getText();
		softly.assertThat(s).as("test data").contains("‑");
		System.out.println(s);
		String overflow = wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavePopupNote)).getCssValue("word-wrap");
		softly.assertThat(overflow).as("test data").isEqualTo("break-word");
		System.out.println(overflow);
		//Click on cancel
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISaveCancelButton)).click();
		//Click on saved activities
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRISavedActivitiesButton)).click();
		share2.loadingServer(driver);
		//Click on first record
		wait.until(ExpectedConditions.visibilityOfElementLocated(sri.SRINewRecord)).click();		
		share2.loadingServer(driver);
		//download report
		downloadReport(driver,softly);
		//Delete a measurement inside report and verify the popup details
		sri3.deleteMeasurementFromStep2(driver, softly, username, password);
		//Verify Page Switches To Step2 Tab When Error Is Present
		sri3.verifyPageSwitchesToStep2TabWhenErrorIsPresent(driver, softly);
		//Change component and verify if unit also goes missing with measurement in Step 2
		sri3.changeComponentVerifyMissingMeasurementAndUnit(driver,component,softly);
	}

	public void downloadReport(WebDriver driver, SoftAssertions softly) throws Exception {

		//Get browser name
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String v = cap.getVersion().toString();
		//Download report to check pdf
		if (browserName.equals("chrome"))
			downloadReportChrome(driver,softly);
		if (browserName.equals("firefox"))
			downloadReportFirefox(driver,softly);
		if (browserName.equals("internet explorer"))
		{
			if (v.startsWith("10"))
				downloadReportIE10(driver,softly);
			if (v.startsWith("11"))
				downloadReportIE11(driver,softly);
		}
		if(browserName.toLowerCase().contains("safari"))
			driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//Switch to iframe
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pii-iframe-main']")));
	}

	public void downloadReportChrome(WebDriver driver, SoftAssertions softly) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
//		File file = new File("C://Users//rramakrishnan//report//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		String window = driver.getWindowHandle();
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
		Thread.sleep(8000);
		System.out.println("before pdfCheck before runtime");
		Runtime.getRuntime().exec("C:\\Users\\rramakrishnan\\AutoItScripts\\ChromSavePDF5_amlocal.exe");

//		pdfCheck(softly);
		
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		System.out.println("after forswitchWindow");
		
		driver.close();
		driver.switchTo().window(window);
		Thread.sleep(3000);		
	}

	public void downloadReportFirefox(WebDriver driver, SoftAssertions softly) throws Exception {

		//deletes files in reports folder before starting to download
		//File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		File file = new File("C://Users//rramakrishnan//report//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		System.out.println("original window: "+window);
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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
		Thread.sleep(2000);
		pdfCheck(softly);
		Thread.sleep(4000);
		driver.close();
		Thread.sleep(4000);
		driver.switchTo().window(window);
		driver.switchTo().defaultContent();	  
		Thread.sleep(3000);
	}

	public void downloadReportIE10(WebDriver driver, SoftAssertions softly) throws Exception {

		//deletes files in reports folder before starting to download
		//File = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		File file = new File("C://Users//rramakrishnan//report//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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
		pdfCheck(softly);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);	   
		Thread.sleep(3000);
	}

	public void downloadReportIE11(WebDriver driver, SoftAssertions softly) throws Exception {

		//deletes files in reports folder before starting to download
		File file = new File("C://Users//mama//Downloads//EFTestDownloadReports//");
		HiRCAEvent obj1 = new HiRCAEvent();
		obj1.deleteFiles(file);
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		//Clicks on download button
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.DownloadButton)).click();
		//Wait for loading message to disappear
		share2.loadingServer(driver);
		String window = driver.getWindowHandle();
		//Clicks on open pdf report
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupTitle)).click();
		wait1.until(ExpectedConditions.visibilityOfElementLocated(eirca.ConfirmPopupButton)).click();
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
//		pdfCheck(softly);
		Thread.sleep(4000);
		//Switch to window    	
		driver.switchTo().window(window);
		Thread.sleep(3000);
	}

	public void pdfCheck(SoftAssertions softly) throws Exception{

		// specify your directory
		//Path dir = Paths.get("C://Users//mama//Downloads//EFTestDownloadReports//");  
	Path dir = Paths.get("C://Users//mama//Pictures//");
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
//		String fileName=ret.get(0).toString();
		File oldfile = new File(fileName);
		PDDocument pddoc= PDDocument.load(oldfile);
		//Checks text in pdf
		String data = new PDFTextStripper().getText(pddoc);
		List<String> ans= Arrays.asList(data.split("\r\n"));
		System.out.println(ans);
		String newData2="";
		for (int i = 0; i < ans.size(); i++)
		{	        	
			int n=ans.get(i).length()-1;
			if (ans.get(i).charAt(n)==' ')
				newData2 = newData2+ans.get(i);
			if (ans.get(i).charAt(n)!=' ')
				newData2 = newData2+" "+ans.get(i);	        	
		}
		String newData1 = newData2.replace("  ", " ");
		//Verify text with html
		softly.assertThat(newData1).as("test data").contains(text);
		//Verify component/measurement/unit/conclusion
		softly.assertThat(newData1).as("test data").contains(sriA2.mechanicalComponent1);
		softly.assertThat(newData1).as("test data").contains(sriA2.mechanicalMeasurement1);
		softly.assertThat(newData1).as("test data").contains(sriA2.mechanicalMeasurement2);
		softly.assertThat(newData1).as("test data").contains(sriA2.mechanicalUnit1);
		softly.assertThat(newData1).as("test data").contains(sriA2.mechanicalUnit2);
		softly.assertThat(newData1).as("test data").contains("Within normal operation limits");
		softly.assertThat(newData1).as("test data").contains("Conclusion: Incipient Failure Stage 1");
		softly.assertThat(newData1).as("test data").contains("Conclusion: Incipient Failure Stage 2");
		softly.assertThat(newData1).as("test data").contains("Conclusion: Incipient Failure Stage 3");
		softly.assertThat(newData1).as("test data").contains("Conclusion: Normal Operation");
		softly.assertThat(newData1).as("test data").contains(sriA2.mechanicalFSIConclusion1);
		softly.assertThat(newData1).as("test data").contains(sriA2.mechanicalFSIConclusion2);
		softly.assertThat(newData1).as("test data").contains(sriA2.mechanicalFSIConclusion3);
		//Close pdf
		pddoc.close();
	}
}
