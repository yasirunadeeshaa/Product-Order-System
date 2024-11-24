package com.test_6.Prouduct.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProuductDTO {
    //private int id;
    private int productId;
    private String productName;
    private String description;
    private int forSale;
}