package com.cooperstandard.scrum.dal.repositories;

import com.cooperstandard.scrum.dto.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositorie extends MongoRepository<User, String> {

    public Optional<User> findByUsername(String username);

}
