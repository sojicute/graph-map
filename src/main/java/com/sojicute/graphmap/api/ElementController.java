package com.sojicute.graphmap.api;


import com.sojicute.graphmap.dto.NodeDto;
import com.sojicute.graphmap.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ElementController {

    @Autowired
    private ElementService elementService;

    @GetMapping("/graph/{graphId}/element")
    public ResponseEntity<List<NodeDto>> getAllElementsByGraphId(@PathVariable("graphId") Long graphId) {
        return new ResponseEntity<>(elementService.findElementsByGraphId(graphId), HttpStatus.OK);
    }


    @PutMapping("/graph/{graphId}/element")
    public ResponseEntity<List<NodeDto>> updateAllElementsByGraphId(@RequestBody List<NodeDto> nodeDtoList, @PathVariable("graphId") Long graphId) {
        return new ResponseEntity<>(elementService.updateElementsByGraphId(graphId, nodeDtoList), HttpStatus.OK);
    }


//    @PostMapping("/graph/{graphId}/element")
//    public ResponseEntity<NodeDto> postElementsByGraphId(@PathVariable("graphId") Long graphId) {
//        return new ResponseEntity<>()
//    }
}
