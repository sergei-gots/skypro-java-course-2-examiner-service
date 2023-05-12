package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class QuestionException extends RuntimeException {
    public QuestionException(String message) {
        super(message);
    }

    public ResponseEntity<String> getResponseStatus() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.TEXT_HTML)
                .body("<html><h4 style=\"color: red\"><b>" + getMessage() + "</b></html>");
    }
}
