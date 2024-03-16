package com.exam.service;

import com.exam.entities.Question;
import com.exam.entities.Quiz;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question);
    Question updateQuestion(Question question);
    List<Question> getAllQuestions();
    void deleteQuestion(long id);
    Question getQuestion(long id);
    List<Question> getQuestionsOfQuiz(Quiz quiz);
}
