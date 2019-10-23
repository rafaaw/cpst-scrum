package com.cpst.dal.repositories;

import com.cpst.dto.models.Sprint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SprintRepository extends MongoRepository<Sprint, String> {
}
