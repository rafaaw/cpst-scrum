package com.cooperstandard.scrum.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CpstService<T, R> {

    public ResponseEntity<T> createOrUpdate(T object);

    public ResponseEntity delete(T object);

    public ResponseEntity<List<T>> findAll();

    public ResponseEntity<List<T>> findByQuery(R query);

}
