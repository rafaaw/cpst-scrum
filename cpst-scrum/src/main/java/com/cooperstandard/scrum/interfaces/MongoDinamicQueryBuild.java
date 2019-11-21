package com.cooperstandard.scrum.interfaces;

import java.util.List;
import java.util.Optional;

public interface MongoDinamicQueryBuild<T> {

    public Optional<List<T>> query(MongoDinamicQuery mongoDinamicQuery, Class<T> resultType);

}