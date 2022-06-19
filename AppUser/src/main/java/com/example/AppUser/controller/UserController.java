package com.example.AppUser.controller;

import com.example.AppUser.model.CreateUserRequestModel;
import com.example.AppUser.model.CreateUserResponseModel;
import com.example.AppUser.service.UserService;
import com.example.AppUser.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("status/check")
    public String status(){
        return "Working";
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(userDetails,UserDto.class);
        UserDto createUser=userService.createUser(userDto);
        CreateUserResponseModel value = modelMapper.map(createUser,CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(value);
    }
}
