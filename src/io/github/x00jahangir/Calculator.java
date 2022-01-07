package io.github.x00jahangir;

import javax.swing.*;

import static java.lang.Math.floor;
import static java.lang.Math.max;

public class Calculator {
    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorView calculatorView = new CalculatorView();
        CalculatorAboutView calculatorAboutView = new CalculatorAboutView();
        new CalculatorController(calculatorView,calculatorAboutView, calculatorModel);
    }
}
