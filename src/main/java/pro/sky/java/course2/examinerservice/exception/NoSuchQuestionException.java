package pro.sky.java.course2.examinerservice.exception;

public class NoSuchQuestionException extends QuestionException {
    public NoSuchQuestionException(String question) {
        super("The question \"" + question + "\" is not listed.");
    }
}
