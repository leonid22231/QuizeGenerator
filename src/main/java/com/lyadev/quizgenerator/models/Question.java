package com.lyadev.quizgenerator.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Question {
    @JsonProperty("id")
    private int id;
    @JsonProperty("question_text")
    private String text;
    @JsonProperty("question_image")
    private String image;
    @JsonProperty("question_answers")
    private List<Answer> answers;


}
