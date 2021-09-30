package com.hoang.multiThreadring.publisher.repository;

import com.hoang.multiThreadring.publisher.entity.ConfigEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SourceConfigRepository extends CrudRepository<ConfigEntity, String> {

    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Config c WHERE c.source = :source")
    void setSourceConfig(@Param("source") String source);
}
