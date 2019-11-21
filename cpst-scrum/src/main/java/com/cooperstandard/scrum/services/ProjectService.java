package com.cooperstandard.scrum.services;

import br.com.devengine.Errors;
import com.cooperstandard.scrum.dal.querys.ProjectQuery;
import com.cooperstandard.scrum.dal.repositories.ProjectRepository;
import com.cooperstandard.scrum.dto.models.Project;
import com.cooperstandard.scrum.interfaces.CpstService;
import com.cooperstandard.scrum.interfaces.MongoDinamicQueryBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {
        @Autowired
})
public class ProjectService implements CpstService<Project, ProjectQuery> {

    private final ProjectRepository projectRepository;
    private final MongoDinamicQueryBuild<Project> queryBuild;

    @Override
    public ResponseEntity<Project> createOrUpdate(Project object) {
        return Errors.tryCatchDefault(f -> new ResponseEntity(projectRepository.save(object), HttpStatus.CREATED), new ResponseEntity(object, HttpStatus.NOT_MODIFIED));
    }

    @Override
    public ResponseEntity delete(Project object) {
        return Errors.tryCatchDefault(f -> {
            projectRepository.delete(object);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }, new ResponseEntity(HttpStatus.NOT_ACCEPTABLE));
    }

    @Override
    public ResponseEntity<List<Project>> findAll() {
        List<Project> list = projectRepository.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(list, HttpStatus.FOUND);
    }

    public Project findById(String id) {
        return projectRepository.findById(id).orElse(new Project().builder().id(id).build());
    }

    @Override
    public ResponseEntity<List<Project>> findByQuery(ProjectQuery projectQuery) {
        System.out.println(projectQuery.toString());
        Optional<List<Project>> list = queryBuild.query(projectQuery, Project.class);
        if (list.isPresent()) {
            return new ResponseEntity(list.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity(Collections.emptyList(), HttpStatus.NOT_FOUND);
    }

}
