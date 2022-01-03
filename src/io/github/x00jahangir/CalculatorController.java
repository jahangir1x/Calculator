package io.github.x00jahangir;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;

    CalculatorController(CalculatorView view, CalculatorModel model){
        calculatorView = view;
        calculatorModel = model;
    }
}
