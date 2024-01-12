package org.example.Services;


import org.example.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JavaQuestionServiceTest {
    @Test
    void add() {
        String QUESTION = "Тестовый вопрос 1";
        String ANSWER = "Тестовый ответ 1";
        String EXPECTED = "Тестовый вопрос 1\nТестовый ответ 1";
        Set<Question> questionSet = new HashSet<>();
        Question result = new JavaQuestionService(questionSet).add(new Question(QUESTION,ANSWER));
        Assertions.assertEquals(EXPECTED, result.toString());
    }
    @Test
    void testAdd() {
        String QUESTION = "Тестовый вопрос 1";
        String ANSWER = "Тестовый ответ 1";
        Question EXPECTED = new Question("Тестовый вопрос 1","Тестовый ответ 1");
        Set<Question> questionSet = new HashSet<>();
        Question result = new JavaQuestionService(questionSet).add(new Question(QUESTION,ANSWER));
        Assertions.assertEquals(EXPECTED, result);
    }
    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    void remove(String question, String answer, String expected) {
        Set<Arguments> collection = provideParamsForTest().collect(Collectors.toSet());
        Set<Question> questionSet = new HashSet<>();
        for (Arguments s : collection) {
            for(int i = 0; i < s.get().length; i++){
                questionSet.add(new Question(s.get()[0].toString(),s.get()[1].toString()));
            }
        }
        Question result = new JavaQuestionService(questionSet).remove(new Question(question,answer));
        Assertions.assertEquals(expected, result.toString());
    }
    @Test
    void getAll() {
        Set<Arguments> collection = provideParamsForTest().collect(Collectors.toSet());
        Set<Question> questionSet = new HashSet<>();
        for (Arguments s : collection) {
            for(int i = 0; i < s.get().length; i++){
                questionSet.add(new Question(s.get()[0].toString(),s.get()[1].toString()));
            }
        }
        Collection<Question> result = new JavaQuestionService(questionSet).getAll();
        Assertions.assertEquals(questionSet, result);
    }

    @Test
    void getRandomQuestion() {
        Set<Arguments> collection = provideParamsForTest().collect(Collectors.toSet());
        Set<Question> questionSet = new HashSet<>();
        for (Arguments s : collection) {
            for(int i = 0; i < s.get().length; i++){
                questionSet.add(new Question(s.get()[0].toString(),s.get()[1].toString()));
            }
        }
        Question randomQuestion = new JavaQuestionService(questionSet).getRandomQuestion();
        Set<Question> result = new HashSet<>();
        result.add(new Question("Тестовый вопрос 1","Тестовый ответ 1"));
        result.add(new Question("Тестовый вопрос 2","Тестовый ответ 2"));
        result.add(new Question("Тестовый вопрос 3","Тестовый ответ 3"));
        boolean hasObject = false;
        for (Question s: result) {
            if(s.toString().equalsIgnoreCase(randomQuestion.toString())){
                hasObject = true;
            }
        }
        Assertions.assertTrue(hasObject);
    }
    public Stream<Arguments> provideParamsForTest(){
        return Stream.of(
                Arguments.of("Тестовый вопрос 1","Тестовый ответ 1","Тестовый вопрос 1\nТестовый ответ 1"),
                Arguments.of("Тестовый вопрос 2","Тестовый ответ 2","Тестовый вопрос 2\nТестовый ответ 2"),
                Arguments.of("Тестовый вопрос 3","Тестовый ответ 3","Тестовый вопрос 3\nТестовый ответ 3")
        );
    }
}