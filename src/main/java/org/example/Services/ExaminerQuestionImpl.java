package org.example.Services;

import org.example.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class ExaminerQuestionImpl implements ExaminerService{
    private final QuestionService questionService;
    public ExaminerQuestionImpl(QuestionService questionService){
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount > 0){
            Collection<Question> collection = new ArrayList<>();
            for(int i = 0; i < amount; i++){
                collection.add(questionService.getRandomQuestion());
            }
            return collection;
        } else {
            return null;
        }
    }
}
