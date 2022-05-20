package rpncalculator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.Function;

public class RPNCalculator {
    public int calculate(String input) {

        String[] elements = input.split(" ");
        Deque<Integer> stack = new ArrayDeque<>();
        for (String element :
                elements) {
            if (Operation.isOperation(element)) {
                Operation operation = Operation.of(element);
                int res = operation.calculate(stack);
                stack.push(res);
            } else {
                int operand = Integer.parseInt(element);
                stack.push(operand);
            }
        }

        return stack.poll();
    }

    private enum Operation {
        ADD("+", stack -> {
            Integer rightOperand = stack.pop();
            Integer leftOperand = stack.pop();
            return leftOperand + rightOperand;
        }),
        SUB("-", stack -> {
            Integer rightOperand = stack.pop();
            Integer leftOperand = stack.pop();
            return leftOperand - rightOperand;
        }),
        DIV("/", stack -> {
            Integer rightOperand = stack.pop();
            Integer leftOperand = stack.pop();
            return leftOperand / rightOperand;
        }),
        MULT("*", stack -> {
            Integer rightOperand = stack.pop();
            Integer leftOperand = stack.pop();
            return leftOperand * rightOperand;
        }
        ),
        SQRT("SQRT", stack -> {
            Integer rightOperand = stack.pop();
            return (int) Math.sqrt(rightOperand);
        }
        ),
        MAX("MAX", stack -> {
            return stack.stream().max(Integer::compareTo).orElseThrow(IllegalStateException::new);
        }
        );

        private final String symbol;
        private final Function<Deque<Integer>, Integer> calculate;

        Operation(String symbol, Function<Deque<Integer>, Integer> calculate) {
            this.symbol = symbol;
            this.calculate = calculate;
        }

        public static Operation of(String operationType) {
            return Arrays.stream(values())
                    .filter(operation -> operation.symbol.equals(operationType))
                    .findFirst()
                    .orElseThrow(IllegalStateException::new);
        }

        public static boolean isOperation(String element) {
            return Arrays.stream(values())
                    .anyMatch(operation -> operation.symbol.equals(element));
        }

        public int calculate(Deque<Integer> stack) {
            return this.calculate.apply(stack);
        }
    }
}
