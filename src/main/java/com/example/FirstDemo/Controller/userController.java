package com.example.FirstDemo.Controller;

import com.example.FirstDemo.exceptions.UserServiceException;
import com.example.FirstDemo.modelresponse.user;
import com.example.FirstDemo.modelrequest.UpdateUserDetailsRequest;
import com.example.FirstDemo.modelrequest.UserDetailsRequest;
import com.example.FirstDemo.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class userController {
    Map<String,user> users;
    @Autowired
    UserService userService;
    @GetMapping
    public String getUsers(@RequestParam("page") int page, @RequestParam(value = "limit",defaultValue = "50") int limit){
        return "get user was called with page = "+ page + " and limit = "+ limit;
    }
    @GetMapping(path="/{userId}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<user> getUser(@PathVariable String userId){
        //if(true) throw new UserServiceException("A user server exception is thrown");
        if(users.containsKey(userId))
        {
            return new ResponseEntity<>(users.get(userId),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<user> createUser(@Valid @RequestBody UserDetailsRequest userDetails){
        user value = userService.createUser(userDetails);
        return new ResponseEntity<user>(value,HttpStatus.OK);
    }

    @PutMapping(path="/{userId}")
    public user updateUser(@PathVariable String userId , @Valid @RequestBody UpdateUserDetailsRequest userDetails){
        user value = users.get(userId);
        value.setFirstname(userDetails.getFirstname());
        value.setLastname(userDetails.getLastname());
        users.put(userId,value);
        return value;
    }
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
