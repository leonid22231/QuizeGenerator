package com.lyadev.quizgenerator.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class Game {
    @JsonProperty("Levels")
    private List<Level> levels;
    private String dir;
    public Game(){
        levels = new ArrayList<>();
    }

    public void addLevel(Level level){
        levels.add(level);
    }
}
