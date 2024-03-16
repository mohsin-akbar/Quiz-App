package com.exam.dto;

import com.exam.entities.Question;
import com.exam.entities.Quiz;
import com.exam.entities.User;
import lombok.Data;

import java.util.List;

@Data
public class UserAnswer {
    private List<Question> answers;
    private User user;
    private Quiz quiz;
}
