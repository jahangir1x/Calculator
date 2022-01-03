package io.github.x00jahangir;

import javax.swing.*;

import static java.lang.Math.max;

public class Calculator {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(view, model);

        JFrame jFrame = new JFrame(Constants.APP_TITLE);
        jFrame.setContentPane(view.panelMain);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

        String test = "aa";
        System.out.println(test.substring(0, max(test.length() - 1, 0)));
    }
}
