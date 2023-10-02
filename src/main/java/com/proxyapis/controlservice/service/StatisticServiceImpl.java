package com.proxyapis.controlservice.service;

import com.proxyapis.controlservice.entity.StatisticEntity;
import com.proxyapis.controlservice.repository.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;

    public StatisticServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public List<StatisticEntity> findAll() {
        return statisticRepository.findAll();
    }

    @Override
    public StatisticEntity create(StatisticEntity statisticEntity) {
        return statisticRepository.save(statisticEntity);
    }
}
