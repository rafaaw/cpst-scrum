package com.cpst.dto.models;

import org.springframework.data.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Audit implements Serializable {

    private static final long serialVersionUID = 1160136996007730722L;
    @CreatedDate
    private LocalDateTime created;
    @CreatedBy
    private User createdUser;
    @LastModifiedDate
    private LocalDateTime modified;
    @LastModifiedBy
    private User modifiedUser;
    @Version
    private Integer version;

}
