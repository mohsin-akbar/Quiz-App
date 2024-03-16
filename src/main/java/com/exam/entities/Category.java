package com.exam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cId;
    private String description;
    private String title;

    @OneToMany(mappedBy = "category" ,fetch = FetchType.EAGER,cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Quiz> quizzes=new ArrayList<>();

}
