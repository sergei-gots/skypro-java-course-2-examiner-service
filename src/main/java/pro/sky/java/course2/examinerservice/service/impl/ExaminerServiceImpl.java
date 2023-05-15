package pro.sky.java.course2.examinerservice.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.IncorrectQuestionsAmountException;
import pro.sky.java.course2.examinerservice.service.ExaminerService;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionServie;
    private final QuestionService mathQuestionServie;

    public ExaminerServiceImpl(@Qualifier("JavaQuestionService") QuestionService javaQuestionServie,
                               @Qualifier("MathQuestionService")QuestionService mathQuestionServie) {
        this.javaQuestionServie = javaQuestionServie;
        this.mathQuestionServie = mathQuestionServie;
    }

    @Override
    public Collection<Question> getJavaQuestions(int amount) {
        return getQuestions(javaQuestionServie, amount);
    }

    @Override
    public Collection<Question> getMathQuestions(int amount) {
        return getQuestions(mathQuestionServie, amount);
    }

    private Collection<Question> getQuestions(QuestionService questionService, int amount) {
        final int totalAmount = questionService.questionsCount();
        if(amount <0 || amount > totalAmount) {
            throw new IncorrectQuestionsAmountException(totalAmount, amount);
        }
        Collection<Question> collection = new HashSet<>(amount);
        while(collection.size() < amount) {
            collection.add(questionService.getRandomQuestion());
        }
        return collection;
    }
}
