package com.example.FirstDemo.userservice;

import com.example.FirstDemo.modelrequest.UserDetailsRequest;
import com.example.FirstDemo.modelresponse.user;
import com.example.FirstDemo.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    Map<String,user> users;
    Utils utils;

    public UserServiceImpl(){}
    @Autowired
    public UserServiceImpl(Utils utils){
        this.utils = utils;
    }
    @Override
    public user createUser(UserDetailsRequest userDetails) {
        user value = new user();
        value.setEmail(userDetails.getEmail());
        value.setFirstname(userDetails.getFirstname());
        value.setLastname(userDetails.getLastname());
        String userId= utils.generateUserId();
        value.setUserId(userId);
        if(users==null) users = new HashMap<>();
        users.put(userId,value);
        return value;
    }
}
