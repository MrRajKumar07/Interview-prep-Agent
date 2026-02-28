package com.example.interviewAgent.model;

import lombok.Data;

@Data
public class Question {
    private String question;
    private String answer;
    private String example;
    private String exampleWithCode;
}
