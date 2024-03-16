package com.exam.controller;

import com.exam.dto.Token;
import com.exam.entities.Category;
import com.exam.repository.CategoryRepository;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @PostMapping("/")
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        Category category1 = categoryService.createCategory(category);
        return ResponseEntity.ok(category1);
    }

    @DeleteMapping("/{cId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("cId") long  cId){
      categoryService.deleteCategory(cId);
        return ResponseEntity.ok(new Token("true"));
    }
    @GetMapping("/{cId}")
    public ResponseEntity<?> getCategory(@PathVariable("cId") long cId){
        return ResponseEntity.ok(categoryService.getCategory(cId));
    }
    @PutMapping("/")
    public ResponseEntity<?> updateCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.updateCategory(category), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);
    }


}
