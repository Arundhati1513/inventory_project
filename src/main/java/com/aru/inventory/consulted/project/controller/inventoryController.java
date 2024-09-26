package com.aru.inventory.consulted.project.controller;

import com.aru.inventory.consulted.project.Entity.inventEntity;
import com.aru.inventory.consulted.project.service.inventService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class inventoryController {

    @Autowired
    private inventService service;

    @PostMapping
    ResponseEntity<inventEntity> createProduct(@RequestBody inventEntity entity){
       return new ResponseEntity<>(service.createProduct(entity),HttpStatus.CREATED) ;
    }



    @GetMapping
    ResponseEntity<List<inventEntity>> returnall(){
        return new ResponseEntity<>(service.resturnAllProducts(),HttpStatus.OK);

    }


   @GetMapping("/{id}")
   ResponseEntity<Optional<inventEntity>> returnproductById(@PathVariable Integer id)
   {
       return  new ResponseEntity<>(service.returnProduct(id),HttpStatus.OK);
   }



   @DeleteMapping("/{id}")
    ResponseEntity<Optional<inventEntity>> deleteByid(@PathVariable Integer id){
        return new ResponseEntity<>(service.deleteById(id),HttpStatus.OK);
   }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody inventEntity updatedEntity) {
        try {

            Optional<inventEntity> existingEntity = service.returnProduct(id);

            if (existingEntity.isPresent()) {

                inventEntity entityToUpdate = existingEntity.get();
                entityToUpdate.setQuantity(updatedEntity.getQuantity());
                entityToUpdate.setBrand(updatedEntity.getBrand());
                entityToUpdate.setModel(updatedEntity.getModel());



                inventEntity savedEntity = service.createProduct(entityToUpdate);


                return new ResponseEntity<>(savedEntity, HttpStatus.OK);
            } else {

                throw new EntityNotFoundException("Entity with ID " + id + " not found");
            }
        } catch (EntityNotFoundException ex) {

            return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {

            return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
