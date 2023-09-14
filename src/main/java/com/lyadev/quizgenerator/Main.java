package com.lyadev.quizgenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyadev.quizgenerator.models.Game;
import com.lyadev.quizgenerator.models.Level;
import com.lyadev.quizgenerator.ui.MainFrame;

import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;

public class Main {
    /*
     <---------------Settings--------------->
        MAIN_DIR
     */
    private static String MAIN_DIR = "Games";
    private static String IMAGE_DIR = "Images";
    private static String LEVELS_FILE = "question.json";
    private static String GAMES_PATCH;
    private static List<Game> games;
    public static void main(String[] args) throws IOException {
        games = new ArrayList<>();

        String work_dir = System.getProperty("user.dir");
        GAMES_PATCH = work_dir+"\\"+MAIN_DIR+"\\";
        System.out.println("Games Dir " + GAMES_PATCH);
        File file = new File(GAMES_PATCH);
        if(!file.exists()){
            file.mkdir();
            System.out.println("Folder created");
        }else {
            System.out.println("Folder exist");
        }
        games = checkAllGames();
        JFrame jFrame = new JFrame("QuizGenerator");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(new MainFrame().jPanel);
        jFrame.pack();
        jFrame.setSize(600,400);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
    }
    private static List<Game> checkAllGames() throws IOException {
        File file = new File(GAMES_PATCH);

        Map<Long, File> testMap = new HashMap<>();
        String[] games = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(new File(dir, name).isDirectory()){
                    testMap.put(new File(dir,name).lastModified(),new File(dir,name));
                }
                return new File(dir,name).isDirectory();
            }
        });
        TreeMap<Long, File> test = new TreeMap<>();
        test.putAll(testMap);
        int i = games.length-1;
        for(Map.Entry<Long, File> entry : test.entrySet()){
            games[i] = entry.getValue().getName();
            i--;
        }
        assert games != null;
        if(games.length>0){
            List<String> listGames = validGames(games);
            List<Game> gameList = new ArrayList<>();
            System.out.println("Games found " + listGames.size());
            for(String name : listGames){
                String PATCH_TO_GAME = GAMES_PATCH+"\\"+name;
                String QUESTION_FILE = PATCH_TO_GAME+"\\"+LEVELS_FILE;
                File json = new File(QUESTION_FILE);
                ObjectMapper objectMapper = new ObjectMapper();
                Game game;
                try {
                    game = objectMapper.readValue(json, Game.class);
                }catch (Exception e) {
                    game = new Game();
                }


                game.setDir(name);

                gameList.add(game);
            }
         return gameList;
        }else {
            System.out.println("Games not found");
            return new ArrayList<Game>();
        }
    }
    private static List<String> validGames(String[] games){
        List<String> validGames = new ArrayList<>();
        for(String name : games){
            String PATCH_TO_GAME = GAMES_PATCH+"\\"+name;
            String IMAGE_FOLDER = PATCH_TO_GAME+"\\"+IMAGE_DIR;
            String QUESTION_FILE = PATCH_TO_GAME+"\\"+LEVELS_FILE;
            File file = new File(QUESTION_FILE);
            if(file.exists()){
                file = new File(IMAGE_FOLDER);
                if(file.exists()){
                    validGames.add(name);
                }
            }
        }

        return validGames;
    }
    public static void SaveGames(){

    }
    public static List<Game> allGames() throws IOException {
        games = checkAllGames();
        return games;
    }

    public static String getGamesPatch() {
        return GAMES_PATCH;
    }

    public static String getImageDir() {
        return IMAGE_DIR;
    }

    public static String getLevelsFile() {
        return LEVELS_FILE;
    }
}