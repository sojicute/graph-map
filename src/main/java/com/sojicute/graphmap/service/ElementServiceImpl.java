package com.sojicute.graphmap.service;

import com.sojicute.graphmap.domain.Node;
import com.sojicute.graphmap.dto.DataDto;
import com.sojicute.graphmap.dto.NodeDto;
import com.sojicute.graphmap.dto.PositionDto;
import com.sojicute.graphmap.repository.ElementRepository;
import com.sojicute.graphmap.repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ElementServiceImpl implements ElementService{

    @Autowired
    private GraphRepository graphRepository;

    @Autowired
    private ElementRepository elementRepository;

    @Override
    public List<NodeDto> findElementsByGraphId(Long graphId) {
        List<Node> nodeDtoList = elementRepository.findElementsByGraphId(graphId);
        return toNodeDto(nodeDtoList);
    }

    @Override
    public List<NodeDto> updateElementsByGraphId(Long graphId, List<NodeDto> nodeDtoList) {

        List<Node> nodes = elementRepository.findElementsByGraphId(graphId);

        for (NodeDto nodeDto: nodeDtoList) {
            for (Node node: nodes) {
                if (Objects.equals(node.getId(), nodeDto.getId())) {
                    node.setLabel(nodeDto.getData().getLabel());
                    node.setPosX(nodeDto.getPosition().getX());
                    node.setPosY(nodeDto.getPosition().getY());
                }
            }
        }

        return toNodeDto(elementRepository.saveAll(nodes));
    }

   public List<Node> toNode(List<NodeDto> nodeDtoList) {
        List<Node> nodes = new ArrayList<>();

        for (NodeDto nodeDto: nodeDtoList) {
            Node node = new Node();

            node.setLabel(nodeDto.getData().getLabel());
            node.setPosX(nodeDto.getPosition().getX());
            node.setPosY(nodeDto.getPosition().getY());

            nodes.add(node);
        }
        return nodes;
   }


    public List<NodeDto> toNodeDto(List<Node> nodes) {

        List<NodeDto> nodeDtoList = new ArrayList<>();

        for (Node node: nodes) {
            NodeDto nodeDto = new NodeDto();

            PositionDto position = new PositionDto();
            position.setX(node.getPosX());
            position.setY(node.getPosY());

            DataDto data = new DataDto();
            data.setLabel(node.getLabel());

            nodeDto.setId(node.getId());
            nodeDto.setPosition(position);
            nodeDto.setData(data);

            nodeDtoList.add(nodeDto);
        }
        return nodeDtoList;
    }

//    public NodeDto toNodeDto(Node node) {
//        NodeDto nodeDto = new NodeDto();
//
//        Position position = new Position();
//        position.setX(node.getPosX());
//        position.setY(node.getPosY());
//
//        NodeData data = new NodeData();
//        data.setLabel(node.getLabel());
//
//        nodeDto.setId(node.getId());
//        nodeDto.setPosition(position);
//        nodeDto.setData(data);
//
//        return nodeDto;
//    }
}
