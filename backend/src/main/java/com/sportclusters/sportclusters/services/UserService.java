package com.sportclusters.sportclusters.services;

import com.sportclusters.sportclusters.security.model.User;
import com.sportclusters.sportclusters.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@Component
public class UserService {
    @Autowired
    UserRepository userDb;


    public User findUser(UUID id){
        return userDb.findOne(id);
    }


}
