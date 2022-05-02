package com.sojicute.graphmap.service;

import com.sojicute.graphmap.domain.Edge;
import com.sojicute.graphmap.domain.Graph;
import com.sojicute.graphmap.domain.Node;
import com.sojicute.graphmap.dto.GraphDto;
import com.sojicute.graphmap.mapper.GraphMapper;
import com.sojicute.graphmap.repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GraphServiceImpl implements GraphService {

    @Autowired
    private GraphRepository graphRepository;

    @Autowired
    private GraphMapper graphMapper;


    @Override
    public List<GraphDto> findAll() {
        return graphRepository.findAll().stream().map(graphMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public GraphDto findById(Long id) {
        Graph graph = graphRepository.findById(id).get();
        return graphMapper.toDto(graph);
    }

    @Override
    public void updateGraph(Long id, GraphDto graphDto) {
        Graph graph = graphRepository.findById(id).get();
        graphMapper.updateModel(graphDto, graph);

        for (Node node: graph.getNodes()) {
            node.setGraph(graph);
        }

        for (Edge edge: graph.getEdges()) {
            edge.setGraph(graph);
        }

        graphRepository.save(graph);
    }
}
