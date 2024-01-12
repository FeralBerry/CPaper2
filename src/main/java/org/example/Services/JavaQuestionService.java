package org.example.Services;
import org.example.Question;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService{
    private final Set<Question> questions;
    public JavaQuestionService(Set<Question> questions){
        this.questions = questions;
    }
    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question,answer);
        boolean firstQuestion = true;
        for (Question s :  this.questions) {
            if(s.getQuestion().equalsIgnoreCase(question)){
                this.questions.remove(s);
                this.questions.add(q);
                firstQuestion = false;
            }
        }
        if(firstQuestion){
            this.questions.add(q);
        }
        return q;
    }
    @Override
    public Question add(Question question) {
        this.questions.add(question);
        return question;
    }
    @Override
    public Question remove(Question question) {
        if(this.questions.contains(question)){
            this.questions.remove(question);
            return question;
        }
        return null;
    }
    @Override
    public Collection<Question> getAll() {
        return this.questions;
    }
    @Override
    public Question getRandomQuestion() {
        int size = this.questions.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for(Question obj : this.questions)
        {
            if (i == item)
                return obj;
            i++;
        }
        return null;
    }
}
