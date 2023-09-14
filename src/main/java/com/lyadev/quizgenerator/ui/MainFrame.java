package com.lyadev.quizgenerator.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        super("Main");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(200,200));
        this.setResizable(false);
        this.setVisible(true);
    }

}
