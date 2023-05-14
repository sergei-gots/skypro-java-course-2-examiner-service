package pro.sky.java.course2.examinerservice.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.IncorrectQuestionsAmountException;
import pro.sky.java.course2.examinerservice.exception.QuestionException;
import pro.sky.java.course2.examinerservice.service.ExaminerService;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExaminerService examinerService;
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;


    public ExamController(ExaminerService examinerService,
                          @Qualifier("JavaQuestionService") QuestionService javaQuestionService,
                          @Qualifier("MathQuestionService") QuestionService mathQuestionService) {
        this.examinerService = examinerService;
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/java/{amount}")
    public Collection<Question> getRandomJavaQuestions(@PathVariable("amount") Integer amount) {
        return examinerService.getQuestions(javaQuestionService, amount);
    }

    @GetMapping("/math/{amount}")
    public Collection<Question> getRandomMathQuestions(@PathVariable("amount") Integer amount) {
        return examinerService.getQuestions(mathQuestionService, amount);
    }

    @ExceptionHandler(value = IncorrectQuestionsAmountException.class)
    public ResponseEntity<String> handleBadRequest(QuestionException e) {
        return e.getResponseStatus();
    }
}
