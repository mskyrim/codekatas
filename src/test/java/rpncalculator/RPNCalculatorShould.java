package rpncalculator;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class RPNCalculatorShould {

    @Test
    public void return_1_when_input_is_1(){
        RPNCalculator rpnCalculator = new RPNCalculator();
        // given
        String input = "1";
        // when
        int result = rpnCalculator.calculate(input);
        // then
        Assert.assertEquals("Error not equals", 1, result);
    }

    @Test
    public void return_2_when_input_is_2(){
        RPNCalculator rpnCalculator = new RPNCalculator();
        // given
        String input = "2";
        // when
        int result = rpnCalculator.calculate(input);
        // then
        Assert.assertEquals("Error not equals", 2, result);
    }

    @Test
    public void return_3_when_input_is_1_2_add(){
        RPNCalculator rpnCalculator = new RPNCalculator();
        // given
        String input = "1 2 +";
        // when
        int result = rpnCalculator.calculate(input);
        // then
        Assert.assertEquals("Error not equals", 3, result);
    }


    @Test
    public void return_3_when_input_is_5_2_sub(){
        RPNCalculator rpnCalculator = new RPNCalculator();
        // given
        String input = "5 2 -";
        // when
        int result = rpnCalculator.calculate(input);
        // then
        Assert.assertEquals("Error not equals", 3, result);
    }

    @Test
    public void return_2_when_input_is_4_2_div(){
        RPNCalculator rpnCalculator = new RPNCalculator();
        // given
        String input = "4 2 /";
        // when
        int result = rpnCalculator.calculate(input);
        // then
        Assert.assertEquals("Error not equals", 2, result);
    }

    @Test
    public void return_4_when_input_is_2_2_multi(){
        RPNCalculator rpnCalculator = new RPNCalculator();
        // given
        String input = "2 2 *";
        // when
        int result = rpnCalculator.calculate(input);
        // then
        Assert.assertEquals("Error not equals", 4, result);
    }

    @Test
    public void return_3_when_input_is_4_2_add_3_sub(){
        RPNCalculator rpnCalculator = new RPNCalculator();
        // given
        String input = "4 2 + 3 -";
        // when
        int result = rpnCalculator.calculate(input);
        // then
        Assert.assertEquals("Error not equals", 3, result);
    }


    @Test
    public void return_141_when_input_is_3_5_8_mult_7_add_mult(){
        //Given
        String input = "3 5 8 * 7 + *";
        int expected = 141;
        RPNCalculator rpnCalculator = new RPNCalculator();

        //When
        int result = rpnCalculator.calculate(input);

        //Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void return_3_when_input_is_9_SQRT(){
        RPNCalculator rpnCalculator = new RPNCalculator();
        // given
        String input = "9 SQRT";
        // when
        int result = rpnCalculator.calculate(input);
        // then
        Assert.assertEquals("Error not equals", 3, result);
    }

    @Test
    public void return_8_when_input_is_5_8_1_4_2_MAX(){
        RPNCalculator rpnCalculator = new RPNCalculator();
        // given
        String input = "5 8 1 4 2 MAX";
        // when
        int result = rpnCalculator.calculate(input);
        // then
        Assert.assertEquals("Error not equals", 8, result);
    }

}
