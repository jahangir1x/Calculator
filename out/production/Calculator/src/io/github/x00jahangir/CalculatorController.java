package io.github.x00jahangir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.stream.IntStream;

import static java.lang.Math.max;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorAboutView calculatorAboutView;
    private CalculatorModel calculatorModel;
    private boolean needToClearResult = false;
    private boolean needToClearHistory = false;

    CalculatorController(CalculatorView calculatorView, CalculatorAboutView calculatorAboutView, CalculatorModel calculatorModel) {
        this.calculatorView = calculatorView;
        this.calculatorAboutView = calculatorAboutView;
        this.calculatorModel = calculatorModel;
        calculatorView.resetResult();

        //------------------------- Add listeners --------------------------------------------------------------
        IntStream.range(0, 10).forEach(number -> {
            NumberButtonListener numberButtonListener = new NumberButtonListener();
            numberButtonListener.number = number;
            calculatorView.addNumberButtonListener(number, numberButtonListener);
        });

        calculatorView.addOperationButtonsListener(OperationType.ADD, new AdditionListener());
        calculatorView.addOperationButtonsListener(OperationType.SUBTRACT, new SubtractionListener());
        calculatorView.addOperationButtonsListener(OperationType.MULTIPLY, new MultiplyListener());
        calculatorView.addOperationButtonsListener(OperationType.DIVIDE, new DivisionListener());
        calculatorView.addOperationButtonsListener(OperationType.INVERT, new InvertListener());
        calculatorView.addOperationButtonsListener(OperationType.SQUARE, new SquareListener());
        calculatorView.addOperationButtonsListener(OperationType.SQUARE_ROOT, new SquareRootListener());
        calculatorView.addOperationButtonsListener(OperationType.NEGATE, new NegateListener());
        calculatorView.addDotListener(new DotListener());
        calculatorView.addResultShowListener(new ShowResultListener());
        calculatorView.addClearScreenListener(new ClearScreenListener());
        calculatorView.addClearPreviousInputListener(new ClearPreviousInputListener());
        calculatorView.addAboutListener(new AboutListener());
        calculatorAboutView.addGithubLinkListener(new GithubLinkListener());
        calculatorAboutView.addFacebookLinkListener(new FacebookLinkListener());
        calculatorAboutView.addMailAddressListener(new MailAddressListener());
        //------------------------------------------------------------------------------------------------------
    }

    /**
     * Opens given url in default browser.
     *
     * @param url url with protocol to view.
     */
    public static void openUrl(URL url) {
        try {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(url.toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class NumberButtonListener implements ActionListener {
        public int number = 0;      // the number button to send this listener to.

        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = calculatorView.getResult();

            if (needToClearHistory) {
                calculatorView.setHistoryText(" ");
                needToClearHistory = false;
            }

            if (userInput.compareTo(Constants.RESET_TO_ZERO) == 0 || needToClearResult) {
                calculatorView.setResult(" ");
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
            if (needToClearHistory) {
                calculatorView.setHistoryText(" ");
                needToClearHistory = false;
            }

            if (userInput.compareTo(Constants.RESET_TO_ZERO) == 0 ||
                    userInput.compareTo(" ") == 0 ||
                    needToClearResult
            ) {
                calculatorView.setResult(" ");
                calculatorView.setResult(Constants.ZERO_DOT);
                needToClearResult = false;
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
            calculatorView.setHistoryText(userInput + Constants.NEGATE + Constants.EQUAL);
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
                calculatorView.setHistoryText(" ");
            }
            needToClearResult = true;
            needToClearHistory = true;
            calculatorModel.setOperationType(OperationType.NONE);
        }

    }

    private class GithubLinkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                openUrl(new URL(calculatorAboutView.getGithubLink()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private class FacebookLinkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                openUrl(new URL(calculatorAboutView.getFacebookLink()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private class MailAddressListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                openUrl(new URL("mailto:" + calculatorAboutView.getMailAddress()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private class AboutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame jFrame = new JFrame();
            calculatorAboutView.setVisible(true);
        }
    }
}
