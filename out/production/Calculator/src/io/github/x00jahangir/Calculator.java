package io.github.x00jahangir;

public class Calculator {
    public static void main(String[] args) {
        // MVC ---------------------------------------------------------------------------------
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorView calculatorView = new CalculatorView();
        CalculatorAboutView calculatorAboutView = new CalculatorAboutView();
        new CalculatorController(calculatorView, calculatorAboutView, calculatorModel);
        // -------------------------------------------------------------------------------------
    }
}
