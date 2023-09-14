package com.lyadev.quizgenerator.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Level {
    private Integer id;
    private List<Question> answers;
}
