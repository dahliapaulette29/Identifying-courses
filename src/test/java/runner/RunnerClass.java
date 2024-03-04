package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features/Featurefile.feature" ,
		glue="stepDefinition",
		plugin = {"pretty", "html:reports/CucumberReport.html","rerun:target/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} ,
		dryRun=false,
		monochrome=true,
		publish=true)
public class RunnerClass {

}
