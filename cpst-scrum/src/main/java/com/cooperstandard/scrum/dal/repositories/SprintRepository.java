package com.cooperstandard.scrum.dal.repositories;

import com.cooperstandard.scrum.dto.models.Sprint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SprintRepository extends MongoRepository<Sprint, String> {
}
