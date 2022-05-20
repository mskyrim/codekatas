@calculator
Feature: RPN Calculator
  rpn calculator is an old calculator model
  base on a serial of operations

  Scenario Outline: addition operation
    Given i have an rpn calculator
    When i do addition operation with <input>
    Then the result is <expectedResult>
    Examples:
      | input   | expectedResult |
      | "3 1 +" | 4              |
      | "3 3 +" | 6              |
