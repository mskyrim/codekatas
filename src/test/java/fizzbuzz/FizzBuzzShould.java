package fizzbuzz;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class FizzBuzzShould {

    @Test
    public void return_1_when_input_is_1_as_non_divisible_by_3_nor_by_5(){
        // Given
        int input = 1;
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expected = "1";
        // When
        String result = fizzBuzz.fizzBuzzer(input);
        // Then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(result).isNotBlank();
        softAssertions.assertThat(result).isEqualTo(expected);
        softAssertions.assertAll();
    }

    @Test
    public void return_4_when_input_is_4_as_non_divisible_by_3_nor_by_5(){
        // Given
        int input = 4;
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expected = "4";
        // When
        String result = fizzBuzz.fizzBuzzer(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void return_fizz_when_input_is_3_as_divisible_by_3(){
        // Given
        int input = 3;
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expected = "fizz";
        // When
        String result = fizzBuzz.fizzBuzzer(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void return_fizz_when_input_is_6_as_divisible_by_3(){
        // Given
        int input = 6;
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expected = "fizz";
        // When
        String result = fizzBuzz.fizzBuzzer(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void return_buzz_when_input_is_5_as_divisible_by_5(){
        // Given
        int input = 5;
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expected = "buzz";
        // When
        String result = fizzBuzz.fizzBuzzer(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void return_buzz_when_input_is_10_as_divisible_by_5(){
        // Given
        int input = 10;
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expected = "buzz";
        // When
        String result = fizzBuzz.fizzBuzzer(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void return_fizzbuzz_when_input_is_15_as_divisible_by_3_and_by_5(){
        // Given
        int input = 15;
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expected = "fizzbuzz";
        // When
        String result = fizzBuzz.fizzBuzzer(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void return_fizzbuzz_when_input_is_30_as_divisible_by_3_and_by_5(){
        // Given
        int input = 30;
        FizzBuzz fizzBuzz = new FizzBuzz();
        String expected = "fizzbuzz";
        // When
        String result = fizzBuzz.fizzBuzzer(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }


}
