package com.sojicute.graphmap.mapper;

import com.sojicute.graphmap.domain.Edge;
import com.sojicute.graphmap.dto.EdgeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface EdgeMapper {
    EdgeMapper INSTANCE = Mappers.getMapper(EdgeMapper.class);

    @Mapping(source = "type", target = "type")
    @Mapping(source = "animated", target = "animated")
    EdgeDto toDto(Edge edge);

    @Mapping(source = "type", target = "type")
    @Mapping(source = "animated", target = "animated")
    Edge toEdge(EdgeDto edgeDto);
}