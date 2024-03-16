package com.exam.controller;

import com.exam.dto.Token;
import com.exam.entities.Question;
import com.exam.entities.Quiz;
import com.exam.repository.QuestionRepo;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;



    @PostMapping("/")
    public ResponseEntity<?> createQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.createQuestion(question));
    }

    @PutMapping("/")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }
    @GetMapping("/{quesId}")
    public ResponseEntity<?> getQuestion(@PathVariable("quesId") long quesId){
        return ResponseEntity.ok(questionService.getQuestion(quesId));
    }

    @GetMapping("/quiz/{qId}")
    public ResponseEntity<?> getAllQuestionsOfQuiz(@PathVariable("qId") long qId){
        Quiz quiz = quizService.getQuiz(qId);
        List<Question> questions = quiz.getQuestions();
        if(questions.size()> quiz.getNoOfQuestion()){
           questions= questions.subList(0,quiz.getNoOfQuestion()+1);
        }
        Collections.shuffle(questions);//for shuffling questions
        return ResponseEntity.ok(questions);
    }

    @DeleteMapping("/{quesId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("quesId") long quesId){
        questionService.deleteQuestion(quesId);
        return ResponseEntity.ok(new Token("true"));
    }
    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
        int marksGot=0;
        int correctAnswer=0;
        int attempted=0;
       for(Question q:questions){
           Question question = questionService.getQuestion(q.getQuesId());
           if(q.getGivenAnswer().equals(question.getAnswer())){
              marksGot+=(question.getQuiz().getMaxMarks()/question.getQuiz().getNoOfQuestion());
              correctAnswer++;
          }
          if(q.getGivenAnswer()!=null){
              attempted++;
          }

       }
        Map<String,Integer> map=new HashMap<>();
        map.put("marksGot",marksGot);
        map.put("correctAnswer",correctAnswer);
        map.put("attempted",attempted);
        return ResponseEntity.ok(map);
    }


}
