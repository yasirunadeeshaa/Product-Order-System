package com.test_6.Prouduct.controller;


import com.test_6.Prouduct.DTO.ProuductDTO;
import com.test_6.Prouduct.model.Prouduct;
import com.test_6.Prouduct.service.ProuductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class ProuductController {
    @Autowired
    private ProuductService productService;

    @GetMapping("/getproducts")
    public List<ProuductDTO> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{productId}")
    public ProuductDTO getProductById(@PathVariable Integer productId) {
        return productService.getProductByProductId(productId);
    }

    @PostMapping("/addproduct")
    public ProuductDTO saveProduct(@RequestBody ProuductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @PutMapping("/updateproduct")
    public ProuductDTO updateProduct(@RequestBody ProuductDTO prouductDTO) {
        return productService.updateProduct(prouductDTO);
    }

    @DeleteMapping("/deleteproduct/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {
        return productService.deleteProduct(productId);
    }
}