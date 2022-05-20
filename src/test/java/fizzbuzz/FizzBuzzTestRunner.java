package fizzbuzz;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/fizzbuzz.html"},
        features = {"classpath:features/fizzBuzzer.feature"},
        glue = {"fizzbuzz.stepdef"}
)
public class FizzBuzzTestRunner {
}
