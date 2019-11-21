package com.cooperstandard.scrum.dal.resolvers;

import com.cooperstandard.scrum.dal.querys.ProjectQuery;
import com.cooperstandard.scrum.services.ProjectService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.cpst.dto.models.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor_ = {
        @Autowired
})
public class ProjectResolver implements GraphQLQueryResolver {

    private final ProjectService projectService;

    public List<Project> getProjects(ProjectQuery pesquisa) {
        return projectService.findByQuery(pesquisa).getBody();
    }
}
