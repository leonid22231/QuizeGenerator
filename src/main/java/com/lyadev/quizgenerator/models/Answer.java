package com.lyadev.quizgenerator.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Answer {
    @JsonProperty("answer_text")
    private String text;
    @JsonProperty("right")
    private Boolean right;
}
