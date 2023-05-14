package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

public class QuestionsRepositoryIsNotModifiableException extends QuestionException {
    public QuestionsRepositoryIsNotModifiableException(QuestionRepository repository) {
        super(HttpStatus.METHOD_NOT_ALLOWED,
                "The repository of \"" + repository.getClass().getSimpleName()
                + "\" is not supposed to be modified at the time.");

    }
}
