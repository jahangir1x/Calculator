package io.github.x00jahangir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorAboutView {
    private int window_width;
    private int window_height;
    private JFrame jFrame;
    private JPanel mainPanel;
    private JButton buttonGithub;
    private JButton buttonFacebook;
    private JButton buttonMail;

    CalculatorAboutView(){
        jFrame = new JFrame(Constants.ABOUT_TITLE);
        jFrame.setContentPane(mainPanel);
        jFrame.pack();
        jFrame.setIconImage(new ImageIcon(getClass().getResource("/res/logo.png")).getImage());
        window_width = jFrame.getWidth();
        window_height = jFrame.getHeight();
        jFrame.setVisible(false);
    }

    /**
     * set visibility of about window.
     * @param b
     */
    public void setVisible(boolean b){
        // get size of monitor and show window to the middle of screen.------------
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x_pos = (size.width / 2) - (window_width / 2);
        int y_pos = (size.height / 2) - (window_height / 2);
        jFrame.setBounds(x_pos, y_pos,window_width, window_height);
        // ------------------------------------------------------------------------
        jFrame.setVisible(b);
    }

    public void addGithubLinkListener(ActionListener actionListener){
        buttonGithub.addActionListener(actionListener);
    }

    public void addFacebookLinkListener(ActionListener actionListener){
        buttonFacebook.addActionListener(actionListener);
    }

    public void addMailAddressListener(ActionListener actionListener){
        buttonMail.addActionListener(actionListener);
    }

    public String getGithubLink(){
        return buttonGithub.getText();
    }

    public String getFacebookLink(){
        return buttonFacebook.getText();
    }

    public String getMailAddress(){
        return buttonMail.getText();
    }
}
