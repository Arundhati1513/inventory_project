package com.aru.inventory.consulted.project.service;

import com.aru.inventory.consulted.project.Entity.inventEntity;
import com.aru.inventory.consulted.project.exceptionhandling.inventExceptionHandling;
import com.aru.inventory.consulted.project.repository.inventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class inventServiceImpl  implements inventService{

     @Autowired
    private inventRepository repository;
    @Override
    public inventEntity createProduct(inventEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<inventEntity> resturnAllProducts() {
        return repository.findAll();
    }

    @Override
    public Optional<inventEntity> returnProduct(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<inventEntity> deleteById(Integer id) {
        Optional<inventEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            repository.deleteById(id);  // Delete the entity
            return entity;  // Return the entity that was deleted
        } else {
            throw new inventExceptionHandling("Entity with ID " + id + " not found");
        }
    }

}
