package pro.sky.java.course2.examinerservice.repository.impl;

import developer.util.QuestionUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashSet;


@Repository
@Component("MathQuestionRepository")
public class MathQuestionRepositoryImpl extends AbstractQuestionRepositoryImpl {

    @Override
    @PostConstruct
    protected void initQuestions() {
        setQuestions(new HashSet<>(QuestionUtils.initMathQuestions()));
        disableEdit();
    }
}
