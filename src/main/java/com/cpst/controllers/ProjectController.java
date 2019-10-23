package com.cpst.controllers;

import com.cpst.dal.querys.ProjectQuery;
import com.cpst.dto.models.Project;
import com.cpst.interfaces.CpstController;
import com.cpst.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/project")
@RequiredArgsConstructor(onConstructor_ = {
        @Autowired
})
public class ProjectController implements CpstController<Project, ProjectQuery> {

    private final ProjectService projectService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<Project> create(@RequestBody Project project) {
        return projectService.createOrUpdate(project);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<Project> update(@RequestBody Project project) {
        return projectService.createOrUpdate(project);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<Project> delete(@RequestBody Project project) {
        return projectService.delete(project);
    }

    @Override
    @GetMapping("/query")
    public ResponseEntity<List<Project>> query(@RequestBody ProjectQuery query){
        return projectService.findByQuery(query);
    }

}
