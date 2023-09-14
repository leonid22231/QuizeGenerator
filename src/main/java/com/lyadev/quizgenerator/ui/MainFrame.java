package com.lyadev.quizgenerator.ui;

import com.lyadev.quizgenerator.Main;
import com.lyadev.quizgenerator.models.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainFrame extends JFrame{
    public JPanel jPanel;
    private JList list1;
    private JButton button_create;
    private List<Game> allGames;

    public MainFrame() throws IOException {
        updateGames();
        button_create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateDialog createDialog = new CreateDialog();
                createDialog.pack();
                createDialog.setVisible(true);
                createDialog.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {

                    }

                    @Override
                    public void windowClosing(WindowEvent e) {

                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        try {
                            updateGames();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }
                });
            }
        });
        list1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2 && e.getButton()==MouseEvent.BUTTON1){
                    System.out.println(allGames.get(list1.locationToIndex(e.getPoint())).getDir());
                    for(Game game : allGames){
                        if(game.getDir().equals(allGames.get(list1.locationToIndex(e.getPoint())).getDir())){
                            GameFrame gameFrame = new GameFrame(game);
                            gameFrame.pack();
                            gameFrame.setSize(600,400);
                            gameFrame.setVisible(true);
                        }
                    }
                }if(e.getClickCount()==2 && e.getButton()==MouseEvent.BUTTON3){
                    list1.setSelectedIndex(list1.locationToIndex(e.getPoint()));
                    deleteGame(allGames.get(list1.locationToIndex(e.getPoint())).getDir());
                    try {
                        updateGames();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    public static void createGame(String name) throws IOException {
        if(!name.isEmpty()){
            System.out.println("Game name is '" + name+"'");
            String new_game = Main.getGamesPatch()+name;
            String quiz_file = new_game+"\\"+Main.getLevelsFile();
            new_game = new_game+"\\"+Main.getImageDir();
            new File(new_game).mkdirs();
            new File(quiz_file).createNewFile();
        }else System.out.println("Name is empty");
    }
    public static void deleteGame(String name){
        File file = new File(Main.getGamesPatch()+name);
        deleteDirectory(file);
    }
    static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                MainFrame.deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
    private void updateGames() throws IOException {
        DefaultListModel demoList = new DefaultListModel();
        allGames = Main.allGames();
        for(Game game : allGames){
            demoList.addElement(game.getDir());
        }
        list1.setModel(demoList);

    }

    private void createUIComponents() {
        list1 = new JList();
        JScrollPane jScrollPane = new JScrollPane(list1);
    }
}
