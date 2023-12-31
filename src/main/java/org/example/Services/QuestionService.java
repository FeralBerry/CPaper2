package org.example.Services;
import org.example.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class QuestionService {
    private Question question;
    public QuestionService(){

    }


    public Map<Integer, Map<String, String>> get(int amount) {

    }

    public List<Question> add(String question, String answer) {
        List<Question> list = new ArrayList<>();
        list.add(new Question(question,answer));
        return list;
    }
}
