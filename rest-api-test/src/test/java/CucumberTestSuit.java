import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = { "pretty", "junit:target/cucumber-reports/cucumber.xml" }
)
public class CucumberTestSuit {

}
