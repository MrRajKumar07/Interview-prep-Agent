package com.example.interviewAgent.model;

import java.util.List;

import lombok.Data;

@Data
public class QuizQuestion {
    private String question;
    private List<String> options;
    private String correctOption;
    private String explanation; 
}
