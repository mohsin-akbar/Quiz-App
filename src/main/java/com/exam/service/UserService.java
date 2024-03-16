package com.exam.service;

import com.exam.dto.UserDto;
import com.exam.dto.UserLoginDto;
import com.exam.entities.User;

import java.util.List;
import java.util.Set;

public interface UserService {
   public UserDto createUser(UserDto userDto);

   UserDto getUserByUsername(String username);

   void deleteUserbyId(long id);

   UserDto userLogin(UserLoginDto userLoginDto);

    List<User> getAllUsers();
}
