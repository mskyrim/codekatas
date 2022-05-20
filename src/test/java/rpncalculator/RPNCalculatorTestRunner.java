package rpncalculator;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/RpnCalculator.html"},
        features = {"classpath:features/rpnCalculator.feature"},
        glue = {"rpncalculator.stepdefs"},
        tags = "@calculator"
)
public class RPNCalculatorTestRunner {
}
