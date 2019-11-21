package com.cooperstandard.scrum.controllers;

import com.cooperstandard.scrum.dto.models.User;
import com.cooperstandard.scrum.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor(onConstructor_ = {
        @Autowired
})
public class UserController {

    private final UserService userService;

    @GetMapping("/admin/user")
    public ResponseEntity<User> getUser(@RequestParam String username) {
        return userService.getUserByUserName(username);
    }

    @PostMapping("/admin/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createOrUpdate(user);
    }

}
