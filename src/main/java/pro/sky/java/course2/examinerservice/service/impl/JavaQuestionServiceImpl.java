package pro.sky.java.course2.examinerservice.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

@Service
@Component("JavaQuestionService")
public class JavaQuestionServiceImpl extends AbstractQuestionServiceImpl {

    public JavaQuestionServiceImpl(@Qualifier("JavaQuestionRepository") QuestionRepository questionRepository) {
        super(questionRepository);
    }


}
