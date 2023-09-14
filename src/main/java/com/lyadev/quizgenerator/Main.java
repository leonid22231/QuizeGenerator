package com.lyadev.quizgenerator;

import com.lyadev.quizgenerator.models.Game;
import com.lyadev.quizgenerator.models.Level;
import com.lyadev.quizgenerator.ui.MainFrame;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.toString());
        Level level = new Level();
        game.addLevel(level);
        System.out.println(game.toString());
        MainFrame mainFrame = new MainFrame();
    }
}