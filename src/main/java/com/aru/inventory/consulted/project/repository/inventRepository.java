package com.aru.inventory.consulted.project.repository;

import com.aru.inventory.consulted.project.Entity.inventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface inventRepository extends JpaRepository<inventEntity,Integer> {
    void deleteById(Integer id);
}
