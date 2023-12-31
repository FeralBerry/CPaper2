package org.example.RestControllers;


import org.example.Question;
import org.example.Services.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/exam/")
public class ExamController {
    private final ExaminerService examinerService;
    public ExamController(ExaminerService examinerService){
        this.examinerService = examinerService;
    }
    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }
}
