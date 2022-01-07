package io.github.x00jahangir;

import static java.lang.Math.floor;

public class CalculatorModel {
    private double result = 0.0;
    private OperationType operationType = OperationType.NONE;

    public String beautifyResult(double number) {
        if (!Double.isFinite(number)){
            return "Math Error";
        }
        else if (Double.isNaN(number)){
            return "Math Error";
        }
        else if (number == floor(number)) {
            return String.valueOf((int) number);
        }
        return String.valueOf(number);
    }

    public void setOperationType(OperationType operationType){
        this.operationType = operationType;
    }

    /**
     * @param userInput evaluate previously selected operation with supplied userInput.
     */
    public void evaluateResult(String userInput) {
        switch (operationType) {
            case ADD:
                result = result + Double.parseDouble(userInput);
                break;
            case SUBTRACT:
                result = result - Double.parseDouble(userInput);
                break;
            case DIVIDE:
                result = result / Double.parseDouble(userInput);
                break;
            case MULTIPLY:
                result = result * Double.parseDouble(userInput);
                break;
            case NONE:
                result = Double.parseDouble(userInput);
                break;
        }
    }

    public String getResult() {
        return Double.toString(result);
    }

    public void divide(String userInput) {
        operationType = OperationType.DIVIDE;
        result = Double.parseDouble(userInput);
    }

    public void multiply(String userInput) {
        operationType = OperationType.MULTIPLY;
        result = Double.parseDouble(userInput);
    }

    public void add(String userInput) {
        operationType = OperationType.ADD;
        result = Double.parseDouble(userInput);
    }

    public void subtract(String userInput) {
        operationType = OperationType.SUBTRACT;
        result = Double.parseDouble(userInput);
    }

    public void invert(String userInput) {
        result = 1 / Double.parseDouble(userInput);
    }

    public void square(String userInput) {
        result = (Double.parseDouble(userInput) * Double.parseDouble(userInput));
    }

    public void squareRoot(String userInput) {
        result = Math.sqrt(Double.parseDouble(userInput));
    }

    public void negate(String userInput) {
        result = Double.parseDouble(userInput) * (-1);
    }
}
