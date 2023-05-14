package pro.sky.java.course2.examinerservice.repository.impl;

import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.QuestionNotFoundException;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


@Deprecated
abstract public class AbstractQuestionHashMapRepositoryImpl implements QuestionRepository {
    private HashMap<String, Question> questions;

    /** Should invoke method setQuestions
     */
    @PostConstruct
    abstract protected void initQuestions();

    protected void setQuestions(HashMap<String, Question> questions) {
        this.questions = questions;
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
            throw new QuestionNotFoundException(question);
        }
        return questions.remove(strQuestion);
    }

    @Override
    public Question get(Question question) {
        String  strQuestion = question.getQuestion();
        if (!questions.containsKey(strQuestion)) {
            throw new QuestionNotFoundException(question);
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
    public int size() {
        return questions.size();
    }
}
