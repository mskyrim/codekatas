package fizzbuzz;

public class FizzBuzz {

    public String fizzBuzzer(int input) {
        if(isDivisibleBy3(input) && isDivisibleBy5(input)){
            return "fizzbuzz";
        }
        if(isDivisibleBy3(input)){
            return "fizz";
        }
        if (isDivisibleBy5(input)) {
            return "buzz";
        }
        return String.valueOf(input);
    }

    private boolean isDivisibleBy5(int input) {
        return input % 5 == 0;
    }

    private boolean isDivisibleBy3(int input) {
        return input % 3 == 0;
    }
}
