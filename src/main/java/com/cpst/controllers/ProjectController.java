package com.cpst.controllers;

import com.cpst.dal.querys.ProjectQuery;
import com.cpst.dto.models.Project;
import com.cpst.interfaces.CpstController;
import com.cpst.services.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("Document project controller")
public class ProjectController implements CpstController<Project, ProjectQuery> {

    private final ProjectService projectService;

    @Override
    @PostMapping("/create")
    @ApiOperation(value = "Save one project on database", response = Project.class)
    public ResponseEntity<Project> create(@RequestBody Project project) {
        return projectService.createOrUpdate(project);
    }

    @Override
    @PutMapping("/update")
    @ApiOperation(value = "Update one project on database", response = Project.class)
    public ResponseEntity<Project> update(@RequestBody Project project) {
        return projectService.createOrUpdate(project);
    }

    @Override
    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete one project on database", response = Project.class)
    public ResponseEntity<Project> delete(@RequestBody Project project) {
        return projectService.delete(project);
    }

    @Override
    @GetMapping("/query")
    @ApiOperation(value = "Found projects on query", response = Project[].class)
    public ResponseEntity<List<Project>> query(@RequestBody ProjectQuery query){
        return projectService.findByQuery(query);
    }

}
