package rpncalculator.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import rpncalculator.RPNCalculator;

public class RPNCalculatorStepDefs {
    private int result;
    RPNCalculator rpnCalculator;

    @Then("the result is {int}")
    public void the_result_is(int expectedResult) {
        Assertions.assertThat(expectedResult).isEqualTo(result);
    }

    @Given("i have an rpn calculator")
    public void iHaveAnRpnCalculator() {
        this.rpnCalculator = new RPNCalculator();
    }

    @When("i do addition operation with {string}")
    public void iDoAdditionOperationWithInput(String input) {
        this.result = rpnCalculator.calculate(input);
    }
}
