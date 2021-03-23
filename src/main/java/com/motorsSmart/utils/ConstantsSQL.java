package com.motorsSmart.utils;

public class ConstantsSQL {

    public static final String PRODUCTBY_CONTRAINS = "SELECT * FROM products pts " +
            "WHERE pts.product_name LIKE :contrains%";

}
