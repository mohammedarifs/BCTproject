package runnerc;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="./src/test/java/Feature",extraGlue = {"Stepdefination","pretty"
        
},plugin = "html:target/cucumber-reports/CucumberTestReport.html",stepNotifications = true)
public class TestRunnerClass {
	
	
	

}
