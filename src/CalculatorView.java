import javax.swing.*;

public class CalculatorView {
    private JPanel panelMain;
    private JPanel panelButtonHolder;
    private JTextArea textArea1;
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

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Calculator");
        jFrame.setContentPane(new CalculatorView().panelMain);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
