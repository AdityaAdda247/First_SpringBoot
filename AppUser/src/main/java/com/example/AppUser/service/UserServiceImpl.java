package com.example.AppUser.service;

import com.example.AppUser.data.UserEntity;
import com.example.AppUser.data.UserRepository;
import com.example.AppUser.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository=userRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }


    @Override
    public UserDto createUser(UserDto userDetails) {

        userDetails.setUserId(UUID.randomUUID().toString());
        userDetails.setEncryptedpassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDetails,UserEntity.class);
        userRepository.save(userEntity);
        UserDto value =modelMapper.map(userEntity,UserDto.class);
        return value;
    }
}
