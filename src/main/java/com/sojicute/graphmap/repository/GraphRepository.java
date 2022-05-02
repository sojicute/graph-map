package com.sojicute.graphmap.repository;

import com.sojicute.graphmap.domain.Graph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphRepository extends JpaRepository<Graph, Long> {
    @Override
    List<Graph> findAll();
}
