package com.cpst.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("Project")
@Document("cad_project")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project extends Audit implements Serializable {

    private static final long serialVersionUID = 1762132305556833871L;
    @Id
    private String id;
    private String name;
    @DBRef(db = "mov_sprint")
    private List<String> sprints_ids;

}
