package com.exam.service.impl;

import com.exam.dto.UserDto;
import com.exam.dto.UserLoginDto;
import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

private  RoleRepository roleRepository;
private UserRepository userRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;


    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, RoleRepository roleRepository,PasswordEncoder passwordEncoder) {
       this.userRepository=userRepository;
       this.roleRepository=roleRepository;
        this.modelMapper =modelMapper;
        this.passwordEncoder=passwordEncoder;

    }

    public UserDto createUser(UserDto userDto){
        userDto.setRole("NORMAL");
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User save = userRepository.save(mapToEntiy(userDto));

        return mapToDto(save);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User byUsername = userRepository.findByUsername(username);
         return mapToDto(byUsername);
    }

    @Override
    public void deleteUserbyId(long id) {
            userRepository.deleteById(id);
    }

    @Override
    public UserDto userLogin(UserLoginDto userLoginDto) {
        User user = userRepository.findByUsername(userLoginDto.getUsername());
        if(user.getPassword().matches(userLoginDto.getPassword())){
///unfinished module
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    User mapToEntiy(UserDto userDto){
        User map = modelMapper.map(userDto, User.class);
        return map;
    }

    UserDto mapToDto(User user){
        UserDto map = modelMapper.map(user, UserDto.class);
        return map;
    }


}
