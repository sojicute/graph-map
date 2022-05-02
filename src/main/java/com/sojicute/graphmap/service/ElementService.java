package com.sojicute.graphmap.service;

import com.sojicute.graphmap.dto.NodeDto;

import java.util.List;

public interface ElementService {
    List<NodeDto> findElementsByGraphId(Long graphId);
    List<NodeDto> updateElementsByGraphId(Long graphId, List<NodeDto> nodeDtoList);
//    Node createElement();
//    Node updateElement(Long elementId);
//    void deleteElement();
}
