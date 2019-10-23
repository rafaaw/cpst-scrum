package com.cpst.dal.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.cpst.dal.querys.SprintQuery;
import com.cpst.dto.models.Sprint;
import com.cpst.services.SprintService;
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
