package org.example.RestControllers;

import org.example.Question;
import org.example.Services.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@RequestMapping("/exam/java/")
public class JavaQuestionController {
    private final QuestionService service;
    public JavaQuestionController(QuestionService service){
        this.service = service;
    }
    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,@RequestParam String answer){
        return service.add(question,answer);
    }
    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question,@RequestParam String answer){
        return service.remove(new Question(question,answer));
    }
    @GetMapping("/")
    public Collection<Question> getQuestions(){
        return service.getAll();
    }
}
