package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinition"},
    tags = "@activity1 or @activity2 or @activity3 or @activity4 0r @activity5 or @activity6"
)

@ConfigurationParameter(
    key = Constants.PLUGIN_PROPERTY_NAME,
    value = "pretty, usage, html:Reports/HTML_Report.html, junit:Reports/XML_Report.xml, json:Reports/JSON_Report.json"
)
public class TestRunner {
}



