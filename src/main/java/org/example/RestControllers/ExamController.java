package org.example.RestControllers;

import org.example.Question;
import org.example.Services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exam/")
public class ExamController {
    private final QuestionService questionService;
    public ExamController(QuestionService questionService){
        this.questionService = questionService;
    }
    @GetMapping("/get/{amount}")
    public Map<Integer, Map<String,String>> get(@PathVariable int amount){
        return questionService.get(amount);
    }
    @GetMapping("/java/add")
    public List<Question> add(@RequestParam String question, String answer){
        return questionService.add(question,answer);
    }
}
