package com.cooperstandard.scrum.dal.querys;

import com.cooperstandard.scrum.interfaces.MongoDinamicQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectQuery implements MongoDinamicQuery {

    @Id
    private String id;
    private List<String> ids;
    private String name;
    private String sprint_id;
    private List<String> sprint_ids;

}
