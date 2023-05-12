package pro.sky.java.course2.examinerservice.exception;

public class AmountIsGreaterThanTotalQuestionsCountException extends RuntimeException {
    public AmountIsGreaterThanTotalQuestionsCountException(int totalAmount, int amount) {
        super("Requested amount of questions=" + amount + " is greater than "
                + totalAmount + " actual total of listed questions.");
    }
}
