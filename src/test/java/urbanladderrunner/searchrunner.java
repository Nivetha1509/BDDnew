package urbanladderrunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
	features=".//Features",
	glue={"stepdefinitions"},
plugin= {"html:target/cucumber-reports.html"})
public class searchrunner  {

	

}
