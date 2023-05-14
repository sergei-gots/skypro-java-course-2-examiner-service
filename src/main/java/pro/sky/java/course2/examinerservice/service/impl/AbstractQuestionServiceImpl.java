package pro.sky.java.course2.examinerservice.service.impl;

import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;
import java.util.Random;


abstract public class AbstractQuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final Random random = new Random();

    public AbstractQuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question get(Question question) {

        return questionRepository.get(question);
    }

    @Override
    public Question remove(Question question) {

        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {

        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {

        return questionRepository.get(random.nextInt(questionRepository.size()));
    }

    @Override
    public int questionsCount() {
        return questionRepository.size();
    }
}
