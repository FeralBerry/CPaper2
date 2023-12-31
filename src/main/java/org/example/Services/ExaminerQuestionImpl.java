package org.example.Services;

import org.example.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
@Service
public class ExaminerQuestionImpl implements ExaminerService{
    private Random random;
    private QuestionService questionService;
    public ExaminerQuestionImpl(QuestionService questionService){
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
