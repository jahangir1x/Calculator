package io.github.x00jahangir;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CalculatorView {
    public JPanel panelMain;
    private JPanel panelButtonHolder;
    private JTextArea textResult;
    private JButton buttonNum1;
    private JButton buttonNum2;
    private JButton buttonNum3;
    private JButton buttonNum4;
    private JButton buttonNum5;
    private JButton buttonNum6;
    private JButton buttonNum7;
    private JButton buttonNum8;
    private JButton buttonNum9;
    private JButton buttonNum0;
    private JButton buttonPercent;
    private JButton buttonClearScreen;
    private JButton buttonClearPrevious;
    private JButton buttonInverse;
    private JButton buttonSquare;
    private JButton buttonSquareRoot;
    private JButton buttonDivide;
    private JButton buttonMultiply;
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JButton buttonNegative;
    private JButton buttonDot;
    private JButton buttonEqual;

//    public CalculatorView() {
//        buttonNum9.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//    }

    public void addArithmeticListener(OperationType operationType, ActionListener actionListener) {
        switch (operationType) {
            case ADD:
                buttonPlus.addActionListener(actionListener);
                break;
            case SUBTRACT:
                buttonMinus.addActionListener(actionListener);
                break;
            case MULTIPLY:
                buttonMultiply.addActionListener(actionListener);
                break;
            case DIVIDE:
                buttonDivide.addActionListener(actionListener);
                break;
            case SQUARE_ROOT:
                buttonSquareRoot.addActionListener(actionListener);
                break;
        }
    }

    public void addClearScreenListener(ActionListener actionListener){
        buttonClearScreen.addActionListener(actionListener);
    }

    public void addNumberButtonListener(int number, ActionListener actionListener) {
        switch (number) {
            case 0:
                buttonNum0.addActionListener(actionListener);
                break;
            case 1:
                buttonNum1.addActionListener(actionListener);
                break;
            case 2:
                buttonNum2.addActionListener(actionListener);
                break;
            case 3:
                buttonNum3.addActionListener(actionListener);
                break;
            case 4:
                buttonNum4.addActionListener(actionListener);
                break;
            case 5:
                buttonNum5.addActionListener(actionListener);
                break;
            case 6:
                buttonNum6.addActionListener(actionListener);
                break;
            case 7:
                buttonNum7.addActionListener(actionListener);
                break;
            case 8:
                buttonNum8.addActionListener(actionListener);
                break;
            case 9:
                buttonNum9.addActionListener(actionListener);
                break;
        }
    }

    public String getResult() {
        return textResult.getText();
    }

    public void resetResult() {
        textResult.setText("0");
    }

    public void setResult(String result) {
        textResult.setText(result);
    }

    public static void main(String[] args) {

    }

    public void addResultShowListener(ActionListener actionListener) {
        buttonEqual.addActionListener(actionListener);
    }
}
