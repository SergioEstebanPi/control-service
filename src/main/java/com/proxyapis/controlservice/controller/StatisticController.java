package com.proxyapis.controlservice.controller;

import com.proxyapis.controlservice.dto.StatisticDTO;
import com.proxyapis.controlservice.entity.StatisticEntity;
import com.proxyapis.controlservice.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {
        "http://localhost:8080",
        "http://localhost:4200"
})
@RestController
@RequestMapping("/statistics")
@Slf4j
public class StatisticController {

    private static final Logger logger = LoggerFactory.getLogger(StatisticController.class);
    private final StatisticService statisticService;
    private final ModelMapper mapper;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
        this.mapper = new ModelMapper();
    }

    @GetMapping
    public ResponseEntity<List<StatisticDTO>> findAll() {

        final List<StatisticEntity> statisticEntities = statisticService.findAll();

        final List<StatisticDTO> response = statisticEntities.stream()
                .map(statisticEntity -> mapper.map(statisticEntity, StatisticDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<StatisticDTO> create(@RequestBody @Valid StatisticDTO statisticDTO) {

        logger.info("--------------------------------------");
        logger.info("getSuccess " + statisticDTO.getSuccess());
        logger.info("getError " + statisticDTO.getError());
        logger.info("getDuration " + statisticDTO.getDuration());
        logger.info("getTotal " + statisticDTO.getTotal());
        logger.info("getRateLimit " + statisticDTO.getRateLimit());
        logger.info("getDate " + statisticDTO.getDate());
        logger.info("--------------------------------------");

        final StatisticEntity statisticEntity = statisticService.create(mapper.map(statisticDTO, StatisticEntity.class));

        final StatisticDTO response = mapper.map(statisticEntity, StatisticDTO.class);

        return ResponseEntity.ok(response);
    }
}
