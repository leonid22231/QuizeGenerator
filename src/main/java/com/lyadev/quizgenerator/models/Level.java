package com.lyadev.quizgenerator.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Level {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("questions")
    private List<Question> answers;
}
