package pro.sky.java.course2.examinerservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.IncorrectQuestionsAmountException;
import pro.sky.java.course2.examinerservice.service.ExaminerService;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    @Override
    public Collection<Question> getQuestions(QuestionService questionService, int amount) {
        final int totalAmount = questionService.size();
        if(amount > totalAmount) {
            throw new IncorrectQuestionsAmountException(totalAmount, amount);
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
