package com.sojicute.graphmap.mapper;

import com.sojicute.graphmap.domain.Node;
import com.sojicute.graphmap.dto.NodeDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NodeMapper {
    NodeMapper INSTANCE = Mappers.getMapper(NodeMapper.class);

    @Mapping(source = "label", target = "data.label")
    @Mapping(source = "posX", target = "position.x")
    @Mapping(source = "posY", target = "position.y")
    @Mapping(source = "backgroundColor", target = "style.backgroundColor")
    NodeDto toDto(Node node);

    @InheritInverseConfiguration
    Node toNode(NodeDto nodeDto);

}
