package com.lyadev.quizgenerator.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Question {
    private String text,image;
    private List<Answer> answers;


}
