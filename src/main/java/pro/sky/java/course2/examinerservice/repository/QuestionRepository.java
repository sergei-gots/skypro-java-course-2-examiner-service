package pro.sky.java.course2.examinerservice.repository;


import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionRepository {
    void disableEdit();
    Question add(Question question);

    Question remove(Question question);

    Question get(Question question);

    Question get(String question);

    Question get(int index);

    Collection<Question> getAll();

    Collection<Question> removeAll();

    int size();
}
