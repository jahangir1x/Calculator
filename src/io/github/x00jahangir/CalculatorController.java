package io.github.x00jahangir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;

    CalculatorController(CalculatorView view, CalculatorModel model) {
        calculatorView = view;
        calculatorModel = model;

        view.resetResult();

        IntStream.range(0, 10).forEach(number -> {
            NumberButtonListener numberButtonListener = new NumberButtonListener();
            numberButtonListener.number = number;
            view.addNumberButtonListener(number, numberButtonListener);
        });

        view.addArithmeticListener(OperationType.MULTIPLY, new MultiplyListener());
        view.addResultShowListener(new ShowResultListener());
    }

    private class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = calculatorView.getResult();
            calculatorModel.multiply(userInput);
            calculatorView.resetResult();
        }
    }

    private class ShowResultListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = calculatorView.getResult();
            calculatorModel.evaluateResult(userInput);
            calculatorView.setResult(calculatorModel.getResult());
        }
    }

    private class NumberButtonListener implements ActionListener{
        public int number = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = calculatorView.getResult();
            if (userInput.compareTo("0") == 0){
                calculatorView.setResult("");
                calculatorView.setResult(Integer.toString(number));
            }
            else{
                calculatorView.setResult(userInput + number);
            }
        }
    }
}
