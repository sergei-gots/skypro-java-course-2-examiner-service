package pro.sky.java.course2.examinerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.IncorrectQuestionsAmountException;
import pro.sky.java.course2.examinerservice.exception.QuestionException;
import pro.sky.java.course2.examinerservice.service.ExaminerService;


import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/java/{amount}")
    public Collection<Question> getRandomJavaQuestions(@PathVariable("amount") Integer amount) {
        return examinerService.getJavaQuestions(amount);
    }

    @GetMapping("/math/{amount}")
    public Collection<Question> getRandomMathQuestions(@PathVariable("amount") Integer amount) {
        return examinerService.getMathQuestions(amount);
    }

    @ExceptionHandler(value = IncorrectQuestionsAmountException.class)
    public ResponseEntity<String> handleBadRequest(QuestionException e) {
        return e.getResponseStatus();
    }
}
