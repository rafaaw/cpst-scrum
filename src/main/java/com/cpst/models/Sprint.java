package com.cpst.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("Sprint")
@Document("mov_sprints")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sprint extends Audit implements Serializable {

    @Id
    private String id;
    private String title;
    private String perfilCode;
    @DBRef(db = "cad_project")
    private String project_id;
    private LocalDate deliveryDate;
    private String responsible;
    private List<Stage> stages;
    private Integer priority;
    private String notes;

}