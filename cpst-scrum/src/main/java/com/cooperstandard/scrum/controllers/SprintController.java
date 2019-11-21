package com.cooperstandard.scrum.controllers;

import com.cooperstandard.scrum.dal.querys.SprintQuery;
import com.cooperstandard.scrum.dto.models.Sprint;
import com.cooperstandard.scrum.interfaces.CpstController;
import com.cooperstandard.scrum.services.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/sprint")
@RequiredArgsConstructor(onConstructor_ = {
        @Autowired
})
public class SprintController implements CpstController<Sprint, SprintQuery> {

    private final SprintService sprintService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<Sprint> create(@RequestBody Sprint object) {
        return sprintService.createOrUpdate(object);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<Sprint> update(@RequestBody Sprint object) {
        return sprintService.createOrUpdate(object);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<Sprint> delete(@RequestBody Sprint object) {
        return sprintService.delete(object);
    }

    @Override
    @GetMapping("/query")
    public ResponseEntity<List<Sprint>> query(@RequestBody SprintQuery query) {
        return sprintService.findByQuery(query);
    }
}
