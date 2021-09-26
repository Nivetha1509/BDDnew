package urbanladderrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	@CucumberOptions(
			features=".//Features",
			glue={"stepdefinitions"},
		plugin= {"html:target/cucumber-reports.html"})
		public class runner extends AbstractTestNGCucumberTests {

			

		}

