package com.exam.service;

import com.exam.entities.Category;
import com.exam.entities.Quiz;

import java.util.List;

public interface QuizService {
    Quiz createQuiz(Quiz quiz);
    List<Quiz> getAllQuiz();
    Quiz getQuiz(long id);
    void deleteQuiz(long id);
    Quiz updateQuiz(Quiz quiz);

    List<Quiz> getQuizByCid(Category category);
}
