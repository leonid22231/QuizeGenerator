package com.lyadev.quizgenerator.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class Game {
    private List<Level> levels;
    public Game(){
        levels = new ArrayList<>();
    }

    public void addLevel(Level level){
        levels.add(level);
    }
}
