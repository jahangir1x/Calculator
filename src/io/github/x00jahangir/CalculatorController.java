package io.github.x00jahangir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;

import static java.lang.Math.max;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;
    private boolean needToClearResult = false;
    private boolean needToClearHistory = false;

    CalculatorController(CalculatorView view, CalculatorModel model) {
        calculatorView = view;
        calculatorModel = model;
        view.resetResult();

        //------------------------- Add listeners --------------------------------------------
        IntStream.range(0, 10).forEach(number -> {
            NumberButtonListener numberButtonListener = new NumberButtonListener();
            numberButtonListener.number = number;
            view.addNumberButtonListener(number, numberButtonListener);
        });

        view.addOperationButtonsListener(OperationType.ADD, new AdditionListener());
        view.addOperationButtonsListener(OperationType.SUBTRACT, new SubtractionListener());
        view.addOperationButtonsListener(OperationType.MULTIPLY, new MultiplyListener());
        view.addOperationButtonsListener(OperationType.DIVIDE, new DivisionListener());
        view.addOperationButtonsListener(OperationType.INVERT, new InvertListener());
        view.addOperationButtonsListener(OperationType.SQUARE, new SquareListener());
        view.addOperationButtonsListener(OperationType.SQUARE_ROOT, new SquareRootListener());
        view.addOperationButtonsListener(OperationType.NEGATE, new NegateListener());
        view.addDotListener(new DotListener());
        view.addResultShowListener(new ShowResultListener());
        view.addClearScreenListener(new ClearScreenListener());
        view.addClearPreviousInputListener(new ClearPreviousInputListener());
        //------------------------------------------------------------------------------------
    }

    private class NumberButtonListener implements ActionListener {
        public int number = 0;      // the number button to send this listener to.

        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = calculatorView.getResult();

            if (needToClearHistory) {
                calculatorView.setHistoryText("");
                needToClearHistory = false;
            }

            if (userInput.compareTo(Constants.RESET_TO_ZERO) == 0 || needToClearResult) {
                calculatorView.setResult("");
                calculatorView.setResult(Integer.toString(number));
                needToClearResult = false;
            } else {
                calculatorView.setResult(userInput + number);
            }
        }
    }

    private class ClearScreenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorView.resetResult();
            calculatorView.resetHistoryText();
            calculatorModel.setOperationType(OperationType.NONE);
        }

    }   // set result and history to show 0.

    private class ClearPreviousInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = calculatorView.getResult();
            calculatorView.setResult(userInput.substring(0, max(userInput.length() - 1, 0)));   // remove last character from result view.
        }

    }

    private class DotListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = calculatorView.getResult();
            if (userInput.compareTo("") == 0) {
                calculatorView.setResult(Constants.ZERO_DOT);
            } else {
                calculatorView.setResult(userInput + Constants.DOT);
            }
        }

    }

    private class InvertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearHistory = false;
            needToClearResult = true;
            String userInput = calculatorView.getResult();
            calculatorView.setHistoryText(Constants.INVERT + userInput + Constants.EQUAL);
            calculatorModel.invert(userInput);
            calculatorView.setResult(calculatorModel.getResult());
        }

    }

    private class SquareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearHistory = false;
            needToClearResult = true;
            String userInput = calculatorView.getResult();
            calculatorView.setHistoryText(userInput + Constants.SQUARE + Constants.EQUAL);
            calculatorModel.square(userInput);
            calculatorView.setResult(calculatorModel.getResult());
        }

    }

    private class SquareRootListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearHistory = false;
            needToClearResult = true;
            String userInput = calculatorView.getResult();
            calculatorView.setHistoryText(Constants.SQUARE_ROOT + userInput + Constants.EQUAL);
            calculatorModel.squareRoot(userInput);
            calculatorView.setResult(calculatorModel.getResult());
        }

    }

    private class NegateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearHistory = false;
            needToClearResult = true;
            String userInput = calculatorView.getResult();
            calculatorView.setHistoryText(userInput + Constants.MULTIPLY + Constants.NEGATE + Constants.EQUAL);
            calculatorModel.negate(userInput);
            calculatorView.setResult(calculatorModel.getResult());
        }

    }

    private class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearHistory = false;
            needToClearResult = true;
            String userInput = calculatorView.getResult();
            calculatorModel.multiply(userInput);
            calculatorView.setHistoryText(userInput + Constants.MULTIPLY);
        }

    }

    private class DivisionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearHistory = false;
            needToClearResult = true;
            String userInput = calculatorView.getResult();
            calculatorModel.divide(userInput);
            if (calculatorView.getHistoryText().compareTo(Constants.RESET_TO_ZERO) != 0) {
                calculatorView.setHistoryText(userInput + Constants.DIVIDE);
            }
        }

    }

    private class AdditionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearHistory = false;
            needToClearResult = true;
            String userInput = calculatorView.getResult();
            calculatorModel.add(userInput);
            calculatorView.setHistoryText(userInput + Constants.ADD);
        }

    }

    private class SubtractionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearHistory = false;
            needToClearResult = true;
            String userInput = calculatorView.getResult();
            calculatorModel.subtract(userInput);
            calculatorView.setHistoryText(userInput + Constants.SUBTRACT);
        }

    }

    private class ShowResultListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = calculatorView.getResult();
            calculatorView.setHistoryText(calculatorView.getHistoryText() + userInput + Constants.EQUAL);
            calculatorModel.evaluateResult(userInput);
            calculatorView.setResult(calculatorModel.getResult());
            if (needToClearHistory) {
                calculatorView.setHistoryText("");
            }
            needToClearResult = true;
            needToClearHistory = true;
            calculatorModel.setOperationType(OperationType.NONE);
        }

    }
}
