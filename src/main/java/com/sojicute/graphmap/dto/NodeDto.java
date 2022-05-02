package com.sojicute.graphmap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodeDto {

    @JsonProperty("uuid")
    private Long id;

    @JsonProperty("id")
    private String node_id;

    private String type;

    private StyleDto style;

    private DataDto data;

    private PositionDto position;
}
