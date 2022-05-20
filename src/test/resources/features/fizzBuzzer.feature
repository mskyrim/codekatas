Feature: Fizz buzzer of inputs

  Scenario Outline: should return input when input is not divisible by 3 or/and 5
    Given the input is <input>
    When fizzBuzz the input
    Then the result is <expectedResult>
    Examples:
      | input | expectedResult |
      | 1     | "1"      |
      | 2     | "2"      |
      | 4     | "4"      |

  Scenario Outline: should return "fizz" when input is divisible by 3 and not by 5
    Given the input is <input>
    When fizzBuzz the input
    Then the result is <expectedResult>
    Examples:
      | input | expectedResult |
      | 3     | "fizz"      |
      | 6     | "fizz"      |
      | 9     | "fizz"      |

  Scenario Outline: should return "buzz" when input is divisible by 5 and not by 3
    Given the input is <input>
    When fizzBuzz the input
    Then the result is <expectedResult>
    Examples:
      | input | expectedResult |
      | 5     | "buzz"      |
      | 10     | "buzz"      |
      | 25     | "buzz"      |

  Scenario Outline: should return "fizzbuzz" when input is divisible by 5 and by 3
    Given the input is <input>
    When fizzBuzz the input
    Then the result is <expectedResult>
    Examples:
      | input | expectedResult |
      | 15     | "fizzbuzz"      |
      | 30     | "fizzbuzz"      |
