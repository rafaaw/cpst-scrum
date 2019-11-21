package com.cooperstandard.scrum.dto.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("Stage")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Stage implements Serializable {

    private static final long serialVersionUID = -3908099928352863008L;
    private String id;
    private String name;
    private LocalDate startJob;
    private LocalDate endJob;

}
