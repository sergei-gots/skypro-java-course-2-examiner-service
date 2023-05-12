package pro.sky.java.course2.examinerservice.repository;

import development.QuestionUtils;
import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examinerservice.domain.Question;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private ArrayList<Question> questions;

    private QuestionRepositoryImpl() {}

    @PostConstruct
    private void init() {
        questions = new ArrayList<>(QuestionUtils.initQuestions());
    }


    @Override
    public Question add(Question question) {
        if(questions == null) {
            questions = new ArrayList<>();
        }
        if (questions.contains(question)) {
            throw new RuntimeException(); //throw new QuestionAlreadyAddedException(question);
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new RuntimeException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Question get(Question question) {
        if (!questions.contains(question)) {
            throw new RuntimeException();
        }
        return question;
    }

    @Override
    public Question get(int index) {
       return questions.get(index);
    }

    @Override
    public Collection<Question> getAll() {
        return List.copyOf(questions);
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
