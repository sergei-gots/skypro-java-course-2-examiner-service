package pro.sky.java.course2.examinerservice.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.QuestionNotFoundException;
import pro.sky.java.course2.examinerservice.exception.QuestionException;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaController {
    final private QuestionService questionService;

    public JavaController(@Qualifier("JavaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(String question, String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/get")
    public Question getQuestion(String question) {
        return questionService.get(new Question(question, null));
    }

    @GetMapping()
    Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/remove")
    Question removeQuestion(String question) {
        return questionService.remove(new Question(question, null));
    }

    @ExceptionHandler(value = QuestionNotFoundException.class)
    public ResponseEntity<String> handleBadRequest(QuestionException e) {
        return e.getResponseStatus();
    }
}
