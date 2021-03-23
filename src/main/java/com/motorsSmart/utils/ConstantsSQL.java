package com.motorsSmart.utils;

public class ConstantsSQL {

    public static final String PRODUCTBY_CONTRAINS = "SELECT * FROM products pts " +
            "WHERE pts.product_name LIKE :contrains%";

    public static final String UPDATE_PRODUCT = "UPDATE products SET product_name = :productName, quantity = :quantity," +
            "id_user_update = :userUpdate WHERE id = :id";

}
