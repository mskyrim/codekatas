package fizzbuzz.stepdef;

import fizzbuzz.FizzBuzz;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class FizzBuzzStepdefs {
    private int input;
    private String result;

    @Given("the input is {int}")
    public void theInputIsInput(int input) {
        System.out.println("-------------- " +input + " ---------");
        this.input = input;
    }

    @When("fizzBuzz the input")
    public void fizzbuzzTheInput() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        this.result = fizzBuzz.fizzBuzzer(this.input);
    }

    @Then("the result is {string}")
    public void theResultIsResult(String expectedResult) {
        Assertions.assertThat(this.result).isEqualTo(expectedResult);
    }
}
