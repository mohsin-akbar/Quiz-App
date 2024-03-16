package com.exam.controller;

import com.exam.dto.Token;
import com.exam.dto.UserAnswer;
import com.exam.dto.UserDto;

import com.exam.dto.UserLoginDto;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test(){
        return "Welcome to Backent API";
    }


    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto user = userService.createUser(userDto);
        return ResponseEntity.ok(user);
    }
//geting user by username
    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable("username") String username){
        UserDto userDto = userService.getUserByUsername(username);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/userLogin")
    public ResponseEntity<UserDto> userLogin(@RequestBody UserLoginDto userLoginDto){
        UserDto userDto = userService.userLogin(userLoginDto);
        return ResponseEntity.ok(userDto);
    }
//deleting user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id){
        userService.deleteUserbyId(id);
        return ResponseEntity.ok(new Token("true"));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    //temporary login


     @PostMapping("/quizSubmit")
    public ResponseEntity<?> submitQuiz(@RequestBody UserAnswer userQuiz){
        System.out.println(userQuiz.toString());
        return ResponseEntity.ok(new Token("true"));
     }




}
