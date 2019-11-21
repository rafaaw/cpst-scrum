package com.cooperstandard.scrum.dal.resolvers;

import com.cooperstandard.scrum.dal.querys.SprintQuery;
import com.cooperstandard.scrum.dto.models.Sprint;
import com.cooperstandard.scrum.services.SprintService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor_ = {
        @Autowired
})
public class SprintResolver implements GraphQLQueryResolver {

    private final SprintService sprintService;

    public List<Sprint> getSprints(SprintQuery pesquisa) {
        return sprintService.findByQuery(pesquisa).getBody();
    }
}
