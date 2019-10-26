package com.cpst.services;

import com.cpst.dal.querys.SprintQuery;
import com.cpst.dal.repositories.SprintRepository;
import com.cpst.dto.models.Sprint;
import com.cpst.interfaces.CpstService;
import com.cpst.interfaces.MongoDinamicQueryBuild;
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
public class SprintService implements CpstService<Sprint, SprintQuery> {

    private final SprintRepository sprintRepository;
    private final ProjectService projectService;
    private final MongoDinamicQueryBuild<Sprint> queryBuild;

    @Override
    public ResponseEntity<Sprint> createOrUpdate(Sprint object) {
        try {
            object.setProject_id(projectService.findById(object.getProject_id().getId()));
            return new ResponseEntity(sprintRepository.save(object), HttpStatus.CREATED);
        } catch (Exception ex) {
        }
        return new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }

    @Override
    public ResponseEntity delete(Sprint object) {
        try {
            sprintRepository.delete(object);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<List<Sprint>> findAll() {
        List<Sprint> list = sprintRepository.findAll();
        if (!list.isEmpty()) {
            new ResponseEntity(list, HttpStatus.FOUND);
        }
        return new ResponseEntity(Collections.emptyList(), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Sprint>> findByQuery(SprintQuery sprintQuery) {
        System.out.println(sprintQuery.toString());
        Optional<List<Sprint>> list = queryBuild.query(sprintQuery, Sprint.class);
        if (list.isPresent()) {
            return new ResponseEntity(list.get(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(Collections.emptyList(), HttpStatus.FOUND);
    }
}
