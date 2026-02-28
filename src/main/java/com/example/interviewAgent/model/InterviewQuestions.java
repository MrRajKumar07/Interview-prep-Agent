package com.example.interviewAgent.model;

import lombok.Data;
import java.util.List;

@Data
public class InterviewQuestions {
    private List<Question> questions;
    private List<QuizQuestion> quizQuestions;
}