package com.sojicute.graphmap.service;

import com.sojicute.graphmap.dto.GraphDto;

import java.util.List;

public interface GraphService {
    List<GraphDto> findAll();
    GraphDto findById(Long id);
    void updateGraph(Long id, GraphDto graphDto);
}
