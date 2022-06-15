package com.example.FirstDemo.userservice;

import com.example.FirstDemo.modelrequest.UserDetailsRequest;
import com.example.FirstDemo.modelresponse.user;

public interface UserService {
    user createUser(UserDetailsRequest userDetails);
}
