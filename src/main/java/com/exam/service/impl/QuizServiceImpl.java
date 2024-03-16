package com.exam.service.impl;

import com.exam.entities.Category;
import com.exam.entities.Quiz;
import com.exam.repository.QuizRepo;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepo quizRepo;
    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepo.findAll();
    }

    @Override
    public Quiz getQuiz(long id) {
        return quizRepo.findById(id).get();
    }

    @Override
    public void deleteQuiz(long id) {
        quizRepo.deleteById(id);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> getQuizByCid(Category category) {
        return quizRepo.findQuizByCategory(category);
    }
}
