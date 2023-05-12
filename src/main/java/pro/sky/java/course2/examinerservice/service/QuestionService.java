package pro.sky.java.course2.examinerservice.service;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question get(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    /** Реализация метода getRandomQuestion осуществляется с помощью класса Random и его метода nextInt,
     * который в качестве параметра принимает максимальное число,
     * а затем возвращает вам результат в виде случайного числа от 0 до максимального числа из параметров
     * (не включительно).
     *
     * @return randomly chosen question.
     */
    Question getRandomQuestion();

    int count();
}
