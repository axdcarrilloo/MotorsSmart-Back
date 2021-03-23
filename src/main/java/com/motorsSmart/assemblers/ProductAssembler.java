package com.motorsSmart.assemblers;

import com.motorsSmart.domain.dtos.ProductDTO;
import com.motorsSmart.domain.entities.Product;
import com.motorsSmart.domain.entities.User;

public class ProductAssembler {

    public static Product convertProductDTOToDomain(ProductDTO productDTO, User user){
        return new Product().builder().productName(productDTO.getProductName()).quantity(productDTO.getQuantity())
                .dateAdmission(productDTO.getDateAdmission()).userRegister(user).build();
    }

}
