package com.example.interviewAgent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.interviewAgent.model.InterviewQuestionInput;
import com.example.interviewAgent.model.InterviewQuestions;
import com.example.interviewAgent.service.AiAgentService;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Added: Allows your React frontend to connect
public class AiAgentController {

    private final AiAgentService aiAgentService;

    @PostMapping("/interview-questions")
    public InterviewQuestions getInterviewQuestions(@RequestBody InterviewQuestionInput input) {
        return aiAgentService.getInterviewQuestions(input);
    }
}