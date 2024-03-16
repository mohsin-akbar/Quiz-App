package com.exam.service.impl;

import com.exam.entities.Question;
import com.exam.entities.Quiz;
import com.exam.repository.QuestionRepo;
import com.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepo questionRepo;
    @Override
    public Question createQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    @Override
    public void deleteQuestion(long id) {
        questionRepo.deleteById(id);
    }

    @Override
    public Question getQuestion(long id) {
        return questionRepo.findById(id).get();
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Quiz quiz) {
        return questionRepo.findByQuiz(quiz);
    }
}
