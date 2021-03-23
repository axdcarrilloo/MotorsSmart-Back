package com.motorsSmart.services;

import com.motorsSmart.assemblers.ProductAssembler;
import com.motorsSmart.domain.dtos.ProductDTO;
import com.motorsSmart.domain.entities.Product;
import com.motorsSmart.domain.entities.User;
import com.motorsSmart.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    public Integer deleteProducByName(String productName){
        Integer result = 0;
        Product product = productRepository.findByProductName(productName);
        if(Objects.nonNull(product)){
            productRepository.deleteById(product.getId());
            result = 1;
        }
        return result;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Long saveProduct(ProductDTO productDTO) {
        User user = userService.getByUserId(productDTO.getIdUser());
        Long result = 0l;
        if(Objects.nonNull(user)){
            log.info("ProductService.java - saveProduct() -> Registrando producto " + productDTO.getProductName());
            if(Objects.isNull(getProductByName(productDTO.getProductName()))){
                result = productRepository.save(ProductAssembler.convertProductDTOToDomain(productDTO, user)).getId();
            }else{
                log.info("ProductService.java - saveProduct() -> El producto ya existe");
            }
        }else{
            log.info("ProductService.java - saveProduct() -> No se pudo registrar producto, verifique el  usuario");
        }
        return result;
    }

    public Product getProductByName(String name){
        log.info("ProductService.java - getProductByName() -> Connsultando producto por nombre");
        return productRepository.findByProductName(name);
    }

}
