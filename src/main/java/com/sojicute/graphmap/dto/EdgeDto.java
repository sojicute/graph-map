package com.sojicute.graphmap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EdgeDto {

    @JsonProperty("uuid")
    private Long id;

    @JsonProperty("id")
    private String edge_id;

    private String source;

    private String target;

    private String type;

    private Boolean animated;
}
