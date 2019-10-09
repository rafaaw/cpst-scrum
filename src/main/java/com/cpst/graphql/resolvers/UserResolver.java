package com.cpst.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.cpst.models.User;
import com.cpst.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor_ = {
        @Autowired
})
public class UserResolver implements GraphQLQueryResolver {

    private final UserService userService;

    public List<User> getUsers() {
        return userService.getAllUsers().getBody();
    }

    public User getUser(String username) {
        return userService.getUserByUserName(username).getBody();
    }

}
