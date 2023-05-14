package pro.sky.java.course2.examinerservice.exception;

import pro.sky.java.course2.examinerservice.domain.Question;

public class QuestionNotFoundException extends QuestionException {
    public QuestionNotFoundException(Question question) {
        super("The question \"" + question.getQuestion() + "\" is not listed.");
    }

    public QuestionNotFoundException(int index) {
        super("Question index \"" + index + "\" points out of bounds.");
    }
}
