package com.motorsSmart.repositories;

import com.motorsSmart.domain.entities.Product;
import com.motorsSmart.domain.entities.User;
import com.motorsSmart.utils.ConstantsSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query(value = ConstantsSQL.UPDATE_PRODUCT, nativeQuery = true)
    void updateProductById(@Param("id") Long id, @Param("productName") String productName,
                           @Param("quantity") Integer quantity, @Param("idUserUpdate") Long idUserUpdate);

    Product findByProductName(String name);

    Product findByProductNameAndUserRegister(String name, User userRegister);

    @Query(value = ConstantsSQL.PRODUCTBY_CONTRAINS, nativeQuery = true)
    List<Product> searchProductByContrains(@Param("contrains") String contrains);
}
