package io.github.x00jahangir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;

import static java.lang.Math.max;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;
    private boolean needToClearScreen = false;

    CalculatorController(CalculatorView view, CalculatorModel model) {
        calculatorView = view;
        calculatorModel = model;

        view.resetResult();

        IntStream.range(0, 10).forEach(number -> {
            NumberButtonListener numberButtonListener = new NumberButtonListener();
            numberButtonListener.number = number;
            view.addNumberButtonListener(number, numberButtonListener);
        });

        view.addArithmeticListener(OperationType.ADD, new AdditionListener());
        view.addArithmeticListener(OperationType.SUBTRACT, new SubtractionListener());
        view.addArithmeticListener(OperationType.DIVIDE, new DivisionListener());
        view.addArithmeticListener(OperationType.MULTIPLY, new MultiplyListener());
        view.addArithmeticListener(OperationType.INVERT, new InvertListener());
        view.addArithmeticListener(OperationType.SQUARE, new SquareListener());
        view.addArithmeticListener(OperationType.SQUARE_ROOT, new SquareRootListener());
        view.addArithmeticListener(OperationType.NEGATE, new NegateListener());
        view.addDotListener(new DotListener());
        view.addClearScreenListener(new ClearScreenListener());
        view.addClearPreviousInputListener(new ClearPreviousInputListener());
        view.addResultShowListener(new ShowResultListener());
    }

    private class ClearScreenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorView.resetResult();
        }
    }

    private class ClearPreviousInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = calculatorView.getResult();
            calculatorView.setResult(userInput.substring(0, max(userInput.length() - 1, 0)));
        }
    }

    private class DotListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = calculatorView.getResult();
            if (userInput.compareTo("") == 0) {
                calculatorView.setResult("0.");
            } else {
                calculatorView.setResult(userInput + ".");
            }
        }
    }

    private class InvertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearScreen = true;
            String userInput = calculatorView.getResult();
            calculatorModel.invert(userInput);
            calculatorView.setResult(calculatorModel.getResult());
        }
    }

    private class SquareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearScreen = true;
            String userInput = calculatorView.getResult();
            calculatorModel.square(userInput);
            calculatorView.setResult(calculatorModel.getResult());
        }
    }

    private class SquareRootListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearScreen = true;
            String userInput = calculatorView.getResult();
            calculatorModel.squareRoot(userInput);
            calculatorView.setResult(calculatorModel.getResult());
        }
    }

    private class NegateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearScreen = true;
            String userInput = calculatorView.getResult();
            calculatorModel.negate(userInput);
            calculatorView.setResult(calculatorModel.getResult());
        }
    }

    private class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearScreen = true;
            String userInput = calculatorView.getResult();
            calculatorModel.multiply(userInput);
        }
    }

    private class DivisionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearScreen = true;
            String userInput = calculatorView.getResult();
            calculatorModel.divide(userInput);
        }
    }

    private class AdditionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearScreen = true;
            String userInput = calculatorView.getResult();
            calculatorModel.add(userInput);
        }
    }

    private class SubtractionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            needToClearScreen = true;
            String userInput = calculatorView.getResult();
            calculatorModel.subtract(userInput);
        }
    }

    private class ShowResultListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = calculatorView.getResult();
            calculatorModel.evaluateResult(userInput);
            calculatorView.setResult(calculatorModel.getResult());
            needToClearScreen = true;
        }
    }

    private class NumberButtonListener implements ActionListener {
        public int number = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = calculatorView.getResult();
            if (userInput.compareTo("0") == 0 || needToClearScreen) {
                calculatorView.setResult("");
                calculatorView.setResult(Integer.toString(number));
                needToClearScreen = false;
            } else {
                calculatorView.setResult(userInput + number);
            }
        }
    }
}
