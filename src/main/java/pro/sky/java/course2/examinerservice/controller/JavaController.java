package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")
public class JavaController {

    final private QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(String question, String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("")
    Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/remove")
    Question removeQuestion(String question, String answer) {
        return questionService.remove(new Question(question, answer));
    }
}
