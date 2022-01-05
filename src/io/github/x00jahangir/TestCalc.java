package io.github.x00jahangir;

import javax.swing.*;

public class TestCalc {
    private JPanel panel1;
    private JTextPane textHistory;
    private JTextArea textResult;
    private JButton buttonClearScreen;
    private JButton buttonClearPrevious;
    private JButton buttonInverse;
    private JButton buttonDivide;
    private JButton buttonSquare;
    private JButton buttonSquareRoot;
    private JButton buttonNum7;
    private JButton buttonNum4;
    private JButton buttonNum1;
    private JButton buttonNegate;
    private JButton buttonAbout;
    private JButton buttonNum8;
    private JButton buttonNum9;
    private JButton buttonMultiply;
    private JButton buttonNum5;
    private JButton buttonNum6;
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JButton buttonNum3;
    private JButton buttonNum2;
    private JButton buttonNum0;
    private JButton buttonDot;
    private JButton buttonEqual;

    TestCalc() {
        JFrame jFrame = new JFrame(Constants.APP_TITLE);        //
        jFrame.setContentPane(panel1);                  //
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //  JFrame settings
        jFrame.pack();                                          //
        jFrame.setVisible(true);                                //
    }

    public static void main(String[] args) {
        TestCalc test = new TestCalc();
    }
}
