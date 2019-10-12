package com.cpst.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("User")
@Document("cad_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    private String id;
    private String username;
    private String password;

}
