package pro.sky.java.course2.examinerservice.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.IncorrectQuestionsAmountException;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final Set<Question> questionSet = Set.of(
            new Question("Q1", "A1"),
            new Question("Q2", "A2"),
            new Question("Q3", "A3"),
            new Question("Q4", "A4"),
            new Question("Q5", "A5"),
            new Question("Q6", "A6"),
            new Question("Q7", "A7"),
            new Question("Q8", "A8"));

    @Test
    void test_getQuestions() {
        final int amount = 5;
        when(questionService.questionsCount()).thenReturn(questionSet.size());
        when(questionService.getRandomQuestion()).thenReturn(new Question("Q1", "A1"),   //1
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
                examinerService.getQuestions(questionService, amount);
        assertThat(questionCollection.size()).isEqualTo(amount);
        assertThat(questionCollection.stream().distinct().count()).isEqualTo(amount);
        assertThat(new ArrayList<>(questionCollection)).usingRecursiveComparison().asList().containsExactlyInAnyOrder(new Question("Q1", "A1"), new Question("Q2", "A1"), new Question("Q3", "A1"), new Question("Q4", "A1"), new Question("Q5", "A5"));
        verify(questionService, times(10)).getRandomQuestion();

    }

    @Test
    public void test_getQuestions_when_negativeAmount() {
        assertThatExceptionOfType(IncorrectQuestionsAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(questionService, -1));
    }

    @Test
    public void test_getQuestions_when_amountIsTooGreat() {
        //GIVEN
        when(questionService.questionsCount()).thenReturn(questionSet.size());
        //THEN
        assertThatExceptionOfType(IncorrectQuestionsAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(questionService, questionSet.size() + 1));
    }
}