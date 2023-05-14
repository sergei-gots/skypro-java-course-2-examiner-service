package pro.sky.java.course2.examinerservice.exception;

public class IncorrectQuestionsAmountException extends QuestionException {
    public IncorrectQuestionsAmountException(int totalAmount, int amount) {
        super("Requested amount of questions =" + amount + " is greater than "
                + totalAmount + " = actual total of listed questions.");
    }
}
