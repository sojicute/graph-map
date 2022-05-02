package com.sojicute.graphmap.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
public class Graph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "graph", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Node> nodes;

    @OneToMany(mappedBy = "graph", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Edge> edges;

}
