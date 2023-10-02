package com.proxyapis.controlservice.repository;

import com.proxyapis.controlservice.entity.StatisticEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends MongoRepository<StatisticEntity, String> {
}
