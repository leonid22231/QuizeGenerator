package com.lyadev.quizgenerator.ui;

import com.lyadev.quizgenerator.models.Game;
import com.lyadev.quizgenerator.models.Level;
import com.lyadev.quizgenerator.models.Question;

import javax.swing.*;
import java.awt.event.*;

public class GameFrame extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel id;
    private JList list1;

    private Game game;
    public GameFrame(Game game) {
        this.game = game;
        System.out.println(game.toString());
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setLocationRelativeTo(null);
        id.setText(game.getDir());
        updateGame();
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addLvl();
                updateGame();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
    public void addLvl(){
        Level level = new Level();
        level.setId(game.getLevels().size());
        game.addLevel(level);
    }
    private void updateGame(){
        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        for(Level level : game.getLevels()){
            defaultListModel.addElement("Level " + level.getId());
        }
        list1.setModel(defaultListModel);
    }
    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
