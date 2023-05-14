package pro.sky.java.course2.examinerservice.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionService;


import java.util.Random;
import java.util.Collection;
import java.util.stream.Stream;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;


    public Stream<Arguments> getQuestionsParamTest() {
        return Stream.of(
                Arguments.of(javaQuestionService, 1),
                Arguments.of(javaQuestionService, 2),
                Arguments.of(javaQuestionService, 3),
                Arguments.of(javaQuestionService, 4),
                Arguments.of(javaQuestionService, 5),
                Arguments.of(javaQuestionService, 6),
                Arguments.of(javaQuestionService, 5),
                Arguments.of(javaQuestionService, 8),
                Arguments.of(javaQuestionService, 9),
                Arguments.of(javaQuestionService, 10)
                );
    }

    @ParameterizedTest
    @MethodSource("getQuestionsParamTest")
    void getQuestionsTest(QuestionService questionSErvice, int amount) {
        when(javaQuestionService.questionsCount())
                .thenReturn(10);

        when(javaQuestionService.getRandomQuestion())
                .thenReturn(questions[random.nextInt(10)]);


        Collection<Question> questionCollection = examinerService.getQuestions(javaQuestionService, amount);
        assertThat(questionCollection.size()).isEqualTo(amount);
        assertThat(questionCollection.stream().distinct().count()).isEqualTo(amount);
    }


    private Question[] questions;
    final private Random random = new Random();

    @BeforeAll
    public void beforeAll() {
        questions = new Question[10];
        for (int i = 0; i < 10 ; i++) {
            questions[i] = new Question("Q" + i, "A" + i);
        }
    }

}