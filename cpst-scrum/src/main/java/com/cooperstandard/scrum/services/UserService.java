package com.cooperstandard.scrum.services;

import com.cooperstandard.scrum.dal.repositories.UserRepositorie;
import com.cooperstandard.scrum.dto.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {
        @Autowired
})
public class UserService {

    private final UserRepositorie userRepositorie;

    public ResponseEntity<User> getUserByUserName(String username) {
        Optional<User> user = userRepositorie.findByUsername(username);
        if (!user.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(user.get(), HttpStatus.FOUND);
    }

    public ResponseEntity<User> createOrUpdate(User user) {
        return new ResponseEntity(userRepositorie.save(user), HttpStatus.CREATED);
    }

    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity(userRepositorie.findAll(), HttpStatus.FOUND);
    }

}
