package com.sojicute.graphmap.api;


import com.sojicute.graphmap.dto.GraphDto;
import com.sojicute.graphmap.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class GraphController {

    @Autowired
    private GraphService graphService;


    @GetMapping("/graph")
    public ResponseEntity<List<GraphDto>> getAllGraph() {
        List<GraphDto> graphs = graphService.findAll();
        return new ResponseEntity<>(graphs, HttpStatus.OK);
    }

    @GetMapping("/graph/{id}")
    public ResponseEntity<GraphDto> getGraph(@PathVariable("id") Long id) {
        GraphDto graph = graphService.findById(id);
        return new ResponseEntity<>(graph, HttpStatus.OK);
    }


    @PutMapping("/graph/{id}")
    public void updateGraph(@PathVariable("id")  Long id, @RequestBody GraphDto graphDto){
        graphService.updateGraph(id, graphDto);
    }

}
