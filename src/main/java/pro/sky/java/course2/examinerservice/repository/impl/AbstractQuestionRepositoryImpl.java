package pro.sky.java.course2.examinerservice.repository.impl;

import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.QuestionNotFoundException;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.*;


abstract public class AbstractQuestionRepositoryImpl implements QuestionRepository {
    private Set<Question> questions = new HashSet<>();

    /** Should invoke method setQuestions
     */
    @PostConstruct
    abstract protected void initQuestions();

    protected void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(Question question) {
        questions.remove(question);
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question = get(question));
        return question;
    }

    @Override
    public Question get(Question question) {
        return questions.stream()
                .filter(question::equals)
                .findFirst()
                .orElseThrow(()->new QuestionNotFoundException(question));
    }

    @Override
    public Question get(String question) {
        return get(new Question(question, null));
    }


    @Override
    public Question get(int index) {
        if(index< 0 || index > size()) {
            throw new QuestionNotFoundException(index);
        }
       return (Question)(questions.toArray()[index]);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
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
