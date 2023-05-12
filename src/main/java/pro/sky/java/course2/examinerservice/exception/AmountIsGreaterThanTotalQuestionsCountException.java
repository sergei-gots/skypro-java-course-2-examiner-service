package pro.sky.java.course2.examinerservice.exception;

public class AmountIsGreaterThanTotalQuestionsCountException extends QuestionException {
    public AmountIsGreaterThanTotalQuestionsCountException(int totalAmount, int amount) {
        super("Requested amount of questions =" + amount + " is greater than "
                + totalAmount + " = actual total of listed questions.");
    }
}
