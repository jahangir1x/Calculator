package io.github.x00jahangir;

public class CalculatorModel {
    private int result = 0;
    private OperationType operationType;

    public void multiply(String userInput) {
        operationType = OperationType.MULTIPLY;
        System.out.println("stored mul");
        result = Integer.parseInt(userInput);
    }

    public void evaluateResult(String userInput){
        switch (operationType){
            case MULTIPLY:
                result = result * Integer.parseInt(userInput);
                System.out.println("result: " + result);
                break;
        }
    }

    public String getResult() {
        return Integer.toString(result);
    }
}
