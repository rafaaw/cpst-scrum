package com.cpst.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("Stage")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Stage extends Audit implements Serializable {

    private static final long serialVersionUID = -3908099928352863008L;
    private String id;
    private String name;
    private LocalDate startJob;
    private LocalDate endJob;

}
