package com.example.AppUser.service;

import com.example.AppUser.shared.UserDto;
import org.springframework.stereotype.Service;


public interface UserService {
    UserDto createUser(UserDto userDetails);
}
