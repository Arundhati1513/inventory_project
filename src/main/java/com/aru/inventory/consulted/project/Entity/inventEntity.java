package com.aru.inventory.consulted.project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class inventEntity {
    //int id, int quantity, String desc
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer productId;
    private String quantity;
    private String brand;
    private String model;







}
