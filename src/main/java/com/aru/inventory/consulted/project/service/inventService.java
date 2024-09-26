package com.aru.inventory.consulted.project.service;

import com.aru.inventory.consulted.project.Entity.inventEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface inventService {




    //create product
    inventEntity createProduct(inventEntity entity);



    //all products
    List<inventEntity>  resturnAllProducts();


    //return product byid
     Optional<inventEntity> returnProduct(Integer id);



     //delete by id
     Optional<inventEntity> deleteById(Integer id);
}
