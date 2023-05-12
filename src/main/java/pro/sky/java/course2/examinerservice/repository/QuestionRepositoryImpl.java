package pro.sky.java.course2.examinerservice.repository;

import development.QuestionUtils;
import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.NoSuchQuestionException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private HashMap<String, Question> questions;

    public QuestionRepositoryImpl() {}

    @PostConstruct
    private void init() {
        questions = new HashMap<>(QuestionUtils.initQuestions());
    }


    @Override
    public Question add(Question question) {
        if(questions == null) {
            questions = new HashMap<>();
        }
        questions.put(question.getQuestion(), question);
        return question;
    }

    @Override
    public Question remove(Question question) {

        String  strQuestion = question.getQuestion();
        if (!questions.containsKey(strQuestion)) {
            throw new NoSuchQuestionException(strQuestion);
        }
        return questions.remove(strQuestion);
    }

    @Override
    public Question get(Question question) {
        String  strQuestion = question.getQuestion();
        if (!questions.containsKey(strQuestion)) {
            throw new NoSuchQuestionException(strQuestion);
        }
        return questions.get(strQuestion);
    }

    @Override
    public Question get(int index) {
       return (Question)(questions.values().toArray()[index]);
    }

    @Override
    public Collection<Question> getAll() {
        return List.copyOf(questions.values());
    }

    @Override
    public Collection<Question> removeAll() {
        Collection<Question> collection = getAll();
        questions.clear();
        return collection;
    }

    @Override
    public int count() {
        return questions.size();
    }
}
