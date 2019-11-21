package com.cooperstandard.scrum.dto.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("Project")
@Document("cad_project")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project implements Serializable {

    private static final long serialVersionUID = 1762132305556833871L;
    @Id
    private String id;
    private String name;
    @DBRef
    private List<Sprint> sprints_ids;

}
