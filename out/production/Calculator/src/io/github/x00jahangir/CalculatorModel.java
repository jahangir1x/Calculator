package io.github.x00jahangir;

import static java.lang.Math.floor;

public class CalculatorModel {
    private String result = "0.0";
    private OperationType operationType = OperationType.NONE;

    /**
     * parses double number and removes floating point if necessary. If result is absurd then returns Math Error
     *
     * @param number number to parse
     * @return
     */
    public String parseResult(double number) {
        if (!Double.isFinite(number)) {
            System.out.println("infinite number detected. showing Math Error");
            return "Math Error";
        } else if (Double.isNaN(number)) {
            System.out.println("Number is Nan. Showing Math Error");
            return "Math Error";
        } else if (number == floor(number)) {
            return String.valueOf((int) number);
        }
        return String.valueOf(number);
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    /**
     * @param userInput evaluate previously selected operation with supplied userInput.
     */
    public void evaluateResult(String userInput) {
        try {
            switch (operationType) {
                case ADD:
                    result = parseResult(Double.parseDouble(result) + Double.parseDouble(userInput));
                    break;
                case SUBTRACT:
                    result = parseResult(Double.parseDouble(result) - Double.parseDouble(userInput));
                    break;
                case DIVIDE:
                    result = parseResult(Double.parseDouble(result) / Double.parseDouble(userInput));
                    break;
                case MULTIPLY:
                    result = parseResult(Double.parseDouble(result) * Double.parseDouble(userInput));
                    break;
                case NONE:
                    result = parseResult(Double.parseDouble(userInput));
                    break;
            }
        } catch (Exception e) {
            System.out.println("error while parsing result. result reset to 0.0");
            result = "0.0";
        }
    }

    public String getResult() {
        return result;
    }

    public void divide(String userInput) {
        operationType = OperationType.DIVIDE;
        try {
            result = parseResult(Double.parseDouble(userInput));
        } catch (Exception e) {
            System.out.println("error while parsing result. result reset to 0.0");
            result = "0.0";
        }
    }

    public void multiply(String userInput) {
        operationType = OperationType.MULTIPLY;
        try {
            result = parseResult(Double.parseDouble(userInput));
        } catch (Exception e) {
            System.out.println("error while parsing result. result reset to 0.0");
            result = "0.0";
        }
    }

    public void add(String userInput) {
        operationType = OperationType.ADD;
        try {
            result = parseResult(Double.parseDouble(userInput));
        } catch (Exception e) {
            System.out.println("error while parsing result. result reset to 0.0");
            result = "0.0";
        }
    }

    public void subtract(String userInput) {
        operationType = OperationType.SUBTRACT;
        try {
            result = parseResult(Double.parseDouble(userInput));
        } catch (Exception e) {
            System.out.println("error while parsing result. result reset to 0.0");
            result = "0.0";
        }
    }

    public void invert(String userInput) {
        try {
            result = parseResult(1.0 / Double.parseDouble(userInput));
        } catch (Exception e) {
            System.out.println("error while parsing result. result reset to 0.0");
            result = "0.0";
        }
    }

    public void square(String userInput) {
        try {
            result = parseResult(Double.parseDouble(userInput) * Double.parseDouble(userInput));
        } catch (Exception e) {
            System.out.println("error while parsing result. result reset to 0.0");
            result = "0.0";
        }
    }

    public void squareRoot(String userInput) {
        try {
            result = parseResult(Math.sqrt(Double.parseDouble(userInput)));
        } catch (Exception e) {
            System.out.println("error while parsing result. result reset to 0.0");
            result = "0.0";
        }
    }

    public void negate(String userInput) {
        try {
            result = parseResult(Double.parseDouble(userInput) * (-1));
        } catch (Exception e) {
            System.out.println("error while parsing result. result reset to 0.0");
            result = "0.0";
        }
    }
}
