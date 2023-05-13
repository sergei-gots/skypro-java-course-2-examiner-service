package pro.sky.java.course2.examinerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.AmountIsGreaterThanTotalQuestionsCountException;
import pro.sky.java.course2.examinerservice.exception.QuestionException;
import pro.sky.java.course2.examinerservice.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/java/{amount}")
    public Collection<Question> getRandomJavaQuestions(@PathVariable("amount") Integer amount) {
        return examinerService.getQuestions(Question.Exam.JAVA, amount);
    }

    @GetMapping("/math/{amount}")
    public Collection<Question> getRandomMathQuestions(@PathVariable("amount") Integer amount) {
        return examinerService.getQuestions(Question.Exam.MATH, amount);
    }

    @ExceptionHandler(value = AmountIsGreaterThanTotalQuestionsCountException.class)
    public ResponseEntity<String> handleBadRequest(QuestionException e) {
        return e.getResponseStatus();
    }
}
