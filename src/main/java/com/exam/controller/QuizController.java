package com.exam.controller;

import com.exam.dto.Token;
import com.exam.entities.Category;
import com.exam.entities.Quiz;
import com.exam.repository.CategoryRepository;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;
    @Autowired
    private CategoryRepository categoryRepository;
    @PostMapping("/")
    public ResponseEntity<?> createQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(quizService.createQuiz(quiz));
    }
    @GetMapping("/{qid}")
    public ResponseEntity<?> getQuiz(@PathVariable("qid") long qid){
        return ResponseEntity.ok(quizService.getQuiz(qid));
    }
    @GetMapping("/category/{cId}")
    public ResponseEntity<?> getQuizesByCid(@PathVariable("cId") long cId){
        Category category = categoryRepository.findById(cId).get();
        List<Quiz> quizByCid = quizService.getQuizByCid(category);
        return ResponseEntity.ok(quizByCid);
    }
    @GetMapping("/")
    public ResponseEntity<?> getQuizes(){
        return ResponseEntity.ok(quizService.getAllQuiz());
    }

    @DeleteMapping("/{qid}")
    public ResponseEntity<?> deleteQuiz(@PathVariable("qid") long qid){
        quizService.deleteQuiz(qid);
        return ResponseEntity.ok(new Token("true"));
    }
    @PutMapping("/")
    public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz){
        return new ResponseEntity<>(quizService.updateQuiz(quiz), HttpStatus.CREATED);
    }
}
