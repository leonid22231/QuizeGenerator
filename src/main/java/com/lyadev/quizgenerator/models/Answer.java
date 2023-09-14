package com.lyadev.quizgenerator.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Answer {
    private String text;
    private Boolean right;
}
