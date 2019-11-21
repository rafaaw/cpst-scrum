package com.cooperstandard.scrum.dal.querys;

import com.cooperstandard.scrum.dto.models.Stage;
import com.cooperstandard.scrum.interfaces.MongoDinamicQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SprintQuery implements MongoDinamicQuery {

    @Id
    private String id;
    private List<String> ids;
    private String title;
    private String perfilCode;
    private String project_id;
    private LocalDate deliveryDate;
    private String responsible;
    private List<Stage> stages;
    private Integer priority;
    private String notes;

}
