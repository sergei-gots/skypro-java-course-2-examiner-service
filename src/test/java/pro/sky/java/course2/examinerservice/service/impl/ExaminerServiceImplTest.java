package pro.sky.java.course2.examinerservice.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.IncorrectQuestionsAmountException;
import pro.sky.java.course2.examinerservice.service.ExaminerService;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private QuestionService javaQuestionService;

    private QuestionService mathQuestionService;

    private ExaminerService examinerService;

    private final Set<Question> testQuestionsSet = Set.of(
            new Question("Q1", "A1"),
            new Question("Q2", "A2"),
            new Question("Q3", "A3"),
            new Question("Q4", "A4"),
            new Question("Q5", "A5"),
            new Question("Q6", "A6"),
            new Question("Q7", "A7"),
            new Question("Q8", "A8"));

    @BeforeEach
    public void beforeEach () {
        javaQuestionService = Mockito.mock(JavaQuestionServiceImpl.class);
        mathQuestionService = Mockito.mock(MathQuestionServiceImpl.class);
        examinerService = new ExaminerServiceImpl(javaQuestionService,mathQuestionService);
    }

    @Test
    void test_getJavaQuestions() {
        final int amount = 5;
        when(javaQuestionService.questionsCount()).thenReturn(testQuestionsSet.size());
        when(javaQuestionService.getRandomQuestion()).thenReturn(new Question("Q1", "A1"),   //1
                new Question("Q1", "A1"),   //2
                new Question("Q2", "A1"),   //3
                new Question("Q3", "A1"),   //4
                new Question("Q2", "A1"),   //5
                new Question("Q3", "A1"),   //6
                new Question("Q4", "A1"),   //7
                new Question("Q4", "A1"),   //8
                new Question("Q3", "A1"),   //8
                new Question("Q5", "A5"),    //10
                new Question("Q5", "A5"),
                new Question("Q6", "A6"));

        Collection<Question> questionCollection =
                examinerService.getJavaQuestions(amount);
        assertThat(questionCollection.size()).isEqualTo(amount);
        assertThat(questionCollection.stream().distinct().count()).isEqualTo(amount);
        assertThat(new ArrayList<>(questionCollection)).usingRecursiveComparison().asList().containsExactlyInAnyOrder(new Question("Q1", "A1"), new Question("Q2", "A1"), new Question("Q3", "A1"), new Question("Q4", "A1"), new Question("Q5", "A5"));
        verify(javaQuestionService, times(10)).getRandomQuestion();

    }

    @Test
    public void test_getJavaQuestions_when_negativeAmount() {
        assertThatExceptionOfType(IncorrectQuestionsAmountException.class)
                .isThrownBy(() -> examinerService.getJavaQuestions(-1));
    }

    @Test
    public void test_getJavaQuestions_when_amountIsTooGreat() {
        //GIVEN
        when(javaQuestionService.questionsCount()).thenReturn(testQuestionsSet.size());
        //THEN
        assertThatExceptionOfType(IncorrectQuestionsAmountException.class)
                .isThrownBy(() -> examinerService.getJavaQuestions(testQuestionsSet.size() + 1));
    }

    @Test
    void test_getMathQuestions() {
        final int amount = 5;
        when(mathQuestionService.questionsCount()).thenReturn(testQuestionsSet.size());
        when(mathQuestionService.getRandomQuestion()).thenReturn(new Question("Q1", "A1"),   //1
                new Question("Q1", "A1"),   //2
                new Question("Q2", "A1"),   //3
                new Question("Q3", "A1"),   //4
                new Question("Q2", "A1"),   //5
                new Question("Q3", "A1"),   //6
                new Question("Q4", "A1"),   //7
                new Question("Q4", "A1"),   //8
                new Question("Q3", "A1"),   //8
                new Question("Q5", "A5"),    //10
                new Question("Q5", "A5"),
                new Question("Q6", "A6"));

        Collection<Question> questionCollection =
                examinerService.getMathQuestions(amount);
        assertThat(questionCollection.size()).isEqualTo(amount);
        assertThat(questionCollection.stream().distinct().count()).isEqualTo(amount);
        assertThat(new ArrayList<>(questionCollection)).usingRecursiveComparison().asList().containsExactlyInAnyOrder(new Question("Q1", "A1"), new Question("Q2", "A1"), new Question("Q3", "A1"), new Question("Q4", "A1"), new Question("Q5", "A5"));
        verify(mathQuestionService, times(10)).getRandomQuestion();

    }

    @Test
    public void test_getMathQuestions_when_negativeAmount() {
        assertThatExceptionOfType(IncorrectQuestionsAmountException.class)
                .isThrownBy(() -> examinerService.getMathQuestions(-1));
    }

    @Test
    public void test_getMathQuestions_when_amountIsTooGreat() {
        //GIVEN
        when(mathQuestionService.questionsCount()).thenReturn(testQuestionsSet.size());
        //THEN
        assertThatExceptionOfType(IncorrectQuestionsAmountException.class)
                .isThrownBy(() -> examinerService.getMathQuestions(testQuestionsSet.size() + 1));
    }
}