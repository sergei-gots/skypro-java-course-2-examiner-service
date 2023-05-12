package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

import java.util.Collection;
import java.util.Random;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final Random random = new Random();

    public JavaQuestionServiceImpl(QuestionRepository questionRepository) {
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

        return questionRepository.get(random.nextInt(questionRepository.count()));
    }

    @Override
    public int count() {
        return questionRepository.count();
    }
}
