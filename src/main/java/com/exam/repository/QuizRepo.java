package com.exam.repository;

import com.exam.entities.Category;
import com.exam.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepo extends JpaRepository<Quiz,Long> {
   List<Quiz> findQuizByCategory(Category category);
}
