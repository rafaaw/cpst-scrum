package com.cpst.interfaces;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_ = {
        @Autowired
})
public class MongoDinamicQueryBuildImpl<T> implements MongoDinamicQueryBuild<T> {

    private final MongoOperations mongoOperations;

    @Override
    public Optional<List<T>> query(MongoDinamicQuery mongoDinamicQuery, Class resultType) {
        return Optional.ofNullable(mongoOperations.find(this.buildQuery(mongoDinamicQuery), resultType));
    }

    private Query buildQuery(MongoDinamicQuery dinamicQuery) {
        log.info("Building dinamic mongo query...");
        Query query = new Query();
        List<Criteria> criterias = new ArrayList();
        try {
            for (Field field : dinamicQuery.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(dinamicQuery) != null && !"serialVersionUID".equals(field.getName())) {
                    if (field.isAnnotationPresent(Id.class)) {
                        criterias.add(Criteria.where(field.getName()).is(field.get(dinamicQuery).toString()));
                    } else if (field.getType().equals(String.class)) {
                        criterias.add(Criteria.where(field.getName()).regex(".*".concat(field.get(dinamicQuery).toString().replaceAll(" ", ".*")).concat(".*"), "i"));
                    } else if (field.getType().equals(LocalDateTime.class) || field.getType().equals(LocalDate.class) || field.getType().equals(LocalTime.class)) {
                        criterias.add(new Criteria().orOperator(Criteria.where(field.getName()).gte(field.get(dinamicQuery)), Criteria.where(field.getName()).lte(field.get(dinamicQuery))));
                    } else {
                        criterias.add(Criteria.where(field.getName()).is(field.get(dinamicQuery)));
                    }
                }
            }
            log.info("Add criteria on query...");
            query.addCriteria(new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()])));
            log.info(query.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return query;
    }

}
