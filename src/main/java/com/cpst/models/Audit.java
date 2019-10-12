package com.cpst.models;

import org.springframework.data.annotation.*;

import java.io.Serializable;
import java.time.Instant;

public class Audit implements Serializable {

    private static final long serialVersionUID = 1160136996007730722L;
    @CreatedDate
    private Instant created;
    @CreatedBy
    private String createdUser;
    @LastModifiedDate
    private Instant modified;
    @LastModifiedBy
    private String modifiedUser;
    @Version
    private Integer version;

}
