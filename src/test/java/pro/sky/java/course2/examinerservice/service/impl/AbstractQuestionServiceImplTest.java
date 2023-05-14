package pro.sky.java.course2.examinerservice.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Repeat;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exception.QuestionNotFoundException;
import pro.sky.java.course2.examinerservice.repository.impl.JavaQuestionRepositoryImpl;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


class AbstractQuestionServiceImplTest {
    private final QuestionService questionService =
            new JavaQuestionServiceImpl(new JavaQuestionRepositoryImpl());

    @BeforeEach
    public void beforeEach() {
        questionService.add("Q1", "A1");
        questionService.add("Q2", "A1");
        questionService.add("Q3", "A2");
        questionService.add("Q4", "A2");
    }

    @Test
    void test_add_and_get() {
        //GIVEN
        final int countBefore = questionService.questionsCount();
        //WHEN
        final Question actual = questionService.add("a question", "an answer");
        final Question expected = new Question("a question", "an answer");
        //THEN
        assertThat(questionService.questionsCount()).isEqualTo(countBefore + 1);
        assertThat(actual).isIn(questionService.getAll());
        assertThat(questionService.get(actual)).isEqualTo(expected);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testUniqueness_addQuestionAnswer_and_get() {
        //GIVEN
        final int countBefore = questionService.questionsCount();
        //WHEN
        final Question actualAddedBefore =
                questionService.add("a question", "an answer");
        final Question actual =
                questionService.add("a question", "another answer");
        final Question expected =
                new Question("a question", "another answer");
        //THEN
        assertThat(questionService.questionsCount()).isEqualTo(countBefore + 1);
        assertThat(actual).isIn(questionService.getAll());
        assertThat(actual).usingRecursiveComparison()
                .isEqualTo(actual);
        assertThat(actual).usingRecursiveComparison()
                .isNotEqualTo(actualAddedBefore);
        assertThat(questionService.get(expected))
                .usingRecursiveComparison()
                .comparingOnlyFields("answer")
                .isNotEqualTo(actualAddedBefore);
        assertThat(questionService.get(expected))
                .usingRecursiveComparison()
                .comparingOnlyFields("answer")
                .isEqualTo(actual);

    }

    @Test
    void testUniqueness_addQuestion_and_get() {
        //GIVEN
        final int countBefore = questionService.questionsCount();
        //WHEN
        final Question actualAddedBefore =
                questionService.add(new Question("a question", "an answer"));
        final Question actual =
                questionService.add(new Question("a question", "another answer"));
        final Question expected =
                new Question("a question", "another answer");
        //THEN
        assertThat(questionService.questionsCount()).isEqualTo(countBefore + 1);
        assertThat(actual).isIn(questionService.getAll());
        assertThat(actual).usingRecursiveComparison()
                .isEqualTo(actual);
        assertThat(actual).usingRecursiveComparison()
                .isNotEqualTo(actualAddedBefore);
        assertThat(questionService.get(expected))
                .usingRecursiveComparison()
                .comparingOnlyFields("answer")
                .isNotEqualTo(actualAddedBefore);
        assertThat(questionService.get(expected))
                .usingRecursiveComparison()
                .comparingOnlyFields("answer")
                .isEqualTo(actual);

    }

    @Test
    void test_addQuestion_and_get() {
        //GIVEN
        final int countBefore = questionService.questionsCount();
        //WHEN
        final Question actual = questionService.add(new Question("a question", "an answer"));
        final Question expected = new Question("a question", "an answer");
        //THEN
        assertThat(questionService.questionsCount()).isEqualTo(countBefore + 1);
        assertThat(actual).isIn(questionService.getAll());
        assertThat(questionService.get(actual)).isEqualTo(expected);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_remove() {
        //GIVEN
        final int countBefore = questionService.questionsCount();
        Question expected = questionService.get("Q1");
        //WHEN
        Question actual = questionService.remove(new Question("Q1", null));
        //THEN
        assertThat(actual).isEqualTo(expected);
        assertThat(questionService.questionsCount()).isEqualTo(countBefore - 1);
        assertThat(actual).isNotIn(questionService.getAll());
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(()->questionService.get(actual));
    }

    @Test
    void getAll_and_remove_and_add() {
        final int count = questionService.questionsCount();
        Collection<Question> actual = questionService.getAll();
        Collection<Question> actualModifiable = new ArrayList<>(actual);
        assertThat(actual.size()).isEqualTo(count);
        assertThat(actualModifiable)
                .usingRecursiveComparison()
                .asList()
                .containsExactlyInAnyOrder(
                            new Question("Q1", "A1"),
                            new Question("Q2", "A1"),
                            new Question("Q3", "A2"),
                            new Question("Q4", "A2")
                );
    }

    @RepeatedTest(100)
    public void test_getRandomQuestion() {
        Question actual = questionService.getRandomQuestion();
        assertThat(actual).isIn(questionService.getAll());
        assertThat(questionService.get(actual))
                .usingRecursiveComparison()
                .isEqualTo(actual);
    }
}
