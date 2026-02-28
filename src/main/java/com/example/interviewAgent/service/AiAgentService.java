package com.example.interviewAgent.service;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.example.interviewAgent.model.InterviewQuestionInput;
import com.example.interviewAgent.model.InterviewQuestions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AiAgentService {

    private final ChatClient chatClient;
    
    @Value("classpath:/prompts/interview-coach.st")
    private Resource interviewTemplate;

    public AiAgentService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("You are a helpful AI Interview Preparation Assistant.")
                .build();
    }

    public InterviewQuestions getInterviewQuestions(InterviewQuestionInput input) {
        log.info("Generating questions for: {} - {}", input.getCourseName(), input.getTopicName());

        return chatClient.prompt()
                .user(u -> u.text(interviewTemplate)
                        .params(Map.of(
                                "level", input.getLevel(),
                                "course", input.getCourseName(),
                                "topic", input.getTopicName()
                        )))
                .call()
                .entity(InterviewQuestions.class);
    }
}