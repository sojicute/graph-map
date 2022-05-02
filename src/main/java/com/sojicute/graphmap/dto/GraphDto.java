package com.sojicute.graphmap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GraphDto {

    @JsonProperty("uuid")
    private Long id;

    private String name;

    @JsonProperty("nodes")
    private List<NodeDto> nodeDtoList;

    @JsonProperty("edges")
    private List<EdgeDto> edgeDtoList;

}