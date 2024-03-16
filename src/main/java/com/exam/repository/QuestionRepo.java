package com.exam.repository;

import com.exam.entities.Question;
import com.exam.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Long> {
    List<Question> findByQuiz(Quiz quiz);
}
