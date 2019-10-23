package com.cpst.dal.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.cpst.dal.querys.ProjectQuery;
import com.cpst.dto.models.Project;
import com.cpst.services.ProjectService;
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
