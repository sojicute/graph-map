package com.sojicute.graphmap.mapper;

import com.sojicute.graphmap.domain.Graph;
import com.sojicute.graphmap.dto.GraphDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {NodeMapper.class, EdgeMapper.class}, componentModel = "spring")
public interface GraphMapper {
    GraphMapper INSTANCE = Mappers.getMapper(GraphMapper.class);

    @Mapping(source = "nodes", target = "nodeDtoList")
    @Mapping(source = "edges", target = "edgeDtoList")
    GraphDto toDto(Graph graph);

    @Mapping(source = "nodeDtoList", target = "nodes")
    @Mapping(source = "edgeDtoList", target = "edges")
    Graph toGraph(GraphDto graphDto);

    @Mapping(source = "nodeDtoList", target = "nodes")
    @Mapping(source = "edgeDtoList", target = "edges")
    void updateModel(GraphDto graphDto, @MappingTarget Graph graph);
}