package com.sojicute.graphmap.repository;

import com.sojicute.graphmap.domain.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementRepository extends JpaRepository<Node, Long> {
    List<Node> findElementsByGraphId(Long graphId);
}
