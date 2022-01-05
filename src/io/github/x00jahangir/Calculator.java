package io.github.x00jahangir;

import javax.swing.*;

import java.awt.*;

import static java.lang.Math.floor;
import static java.lang.Math.max;

public class Calculator {
    public static void main(String[] args) {
        // -------------------------------- UI theme set --------------------------------------
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                // Not worth my time
            }
        }

        // ------------------------------------------------------------------------------------

        CalculatorModel model = new CalculatorModel();                              //
        CalculatorView view = new CalculatorView();                                 //  MVC
        CalculatorController controller = new CalculatorController(view, model);    //

        JFrame jFrame = new JFrame(Constants.APP_TITLE);        //
        jFrame.setContentPane(view.panelMain);                  //
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //  JFrame settings
        jFrame.pack();                                          //
        jFrame.setVisible(true);                                //
    }

    private String beautifyResult(double number) {
        if (number == floor(number)) {
            return "x";
        }
        return "y";
    }
}
