package com.cooperstandard.scrum.dal.repositories;

import com.cooperstandard.scrum.dto.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
}
