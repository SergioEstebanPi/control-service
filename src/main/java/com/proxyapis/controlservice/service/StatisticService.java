package com.proxyapis.controlservice.service;

import com.proxyapis.controlservice.entity.StatisticEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatisticService {
    List<StatisticEntity> findAll();
    StatisticEntity create(StatisticEntity statisticEntity);
}
