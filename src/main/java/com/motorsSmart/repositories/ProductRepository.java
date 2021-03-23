package com.motorsSmart.repositories;

import com.motorsSmart.domain.entities.Product;
import com.motorsSmart.domain.entities.User;
import com.motorsSmart.utils.ConstantsSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductName(String name);

    Product findByProductNameAndUserRegister(String name, User userRegister);

    @Query(value = ConstantsSQL.PRODUCTBY_CONTRAINS, nativeQuery = true)
    List<Product> searchProductByContrains(@Param("contrains") String contrains);
}
