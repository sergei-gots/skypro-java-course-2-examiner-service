package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class QuestionException extends RuntimeException {
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    public QuestionException(String message) {
        super(message);
    }

    public QuestionException(HttpStatus httpStatus, String message) {

        super(message);
        this.httpStatus = httpStatus;
    }

    public ResponseEntity<String> getResponseStatus() {
        return ResponseEntity.status(httpStatus)
                .contentType(MediaType.TEXT_HTML)
                .body("<html><h4 style=\"color: red\"><b>" + getMessage() + "</b></html>");
    }
}
