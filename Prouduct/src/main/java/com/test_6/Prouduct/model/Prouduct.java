package com.test_6.Prouduct.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Prouduct {
    @Id
    //private int id;
    private int productId;
    private String productName;
    private String description;
    private int forSale;
}