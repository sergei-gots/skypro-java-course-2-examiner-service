package pro.sky.java.course2.examinerservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.domain.Question.Exam;
import pro.sky.java.course2.examinerservice.exception.AmountIsGreaterThanTotalQuestionsCountException;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("JavaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("MathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;

    }

    @Override
    public Collection<Question> getQuestions(Exam exam, int amount) {

        QuestionService questionService = (exam == Exam.JAVA )?
                javaQuestionService : mathQuestionService;
        final int totalAmount = questionService.count();
        if(amount > totalAmount) {
            throw new AmountIsGreaterThanTotalQuestionsCountException(totalAmount, amount);
        }
        Collection<Question> collection = new ArrayList<>(amount);
        Question question;
        for (int i = 0; i < amount; i++) {
            do {
                question = questionService.getRandomQuestion();
            } while (collection.contains(question));
            collection.add(question);

        }
        return collection;
    }
}
