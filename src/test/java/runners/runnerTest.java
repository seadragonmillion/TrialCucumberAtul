package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/features/OPiRCABug.feature" ,
 glue= {"seleniumTests"}  ,
 tags= "@ChromeTest",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
 )

public class runnerTest {


}
