package com.motorsSmart.controllers;

import com.motorsSmart.domain.dtos.ProductDTO;
import com.motorsSmart.domain.entities.Product;
import com.motorsSmart.services.ProductService;
import com.motorsSmart.utils.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Route.BASE + Route.PRODUCTS, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "${environmen.url.origins}")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(Route.GETBY_CONTRAINS)
    public ResponseEntity<List<Product>> getProductByContrains(@PathVariable String contrains){
        return new ResponseEntity<List<Product>>(productService.getProductByContrains(contrains), HttpStatus.OK);
    }

    @DeleteMapping(Route.DELETE_PRODUCT)
    public ResponseEntity<Integer> deleteProducByName(@PathVariable String productName, @PathVariable Long idUserRegister){
        return new ResponseEntity<Integer>(productService.deleteProducByNameAndUserRegister(productName, idUserRegister), HttpStatus.OK);
    }

    @GetMapping(Route.GETALL)
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping(value = Route.REGISTER)
    public ResponseEntity<Long> resgiterProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<Long>(productService.saveProduct(productDTO), HttpStatus.OK);
    }

    @GetMapping(Route.GETBYMANE)
    public ResponseEntity<Product> getProductByName(@PathVariable String name){
        return new ResponseEntity<Product>(productService.getProductByName(name), HttpStatus.OK);
    }

    @PutMapping(Route.UPDATE)
    public ResponseEntity<Long> updateProductById(@PathVariable String name, @RequestBody ProductDTO product){
        return new ResponseEntity<Long>(productService.updateProductById(name, product), HttpStatus.OK);
    }

}
