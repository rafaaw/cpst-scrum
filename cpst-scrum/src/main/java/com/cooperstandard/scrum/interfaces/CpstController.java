package com.cooperstandard.scrum.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CpstController<T, S> {

    public ResponseEntity<T> create(T object);

    public ResponseEntity<T> update(T object);

    public ResponseEntity<T> delete(T object);

    public ResponseEntity<List<T>> query(S query);

}
