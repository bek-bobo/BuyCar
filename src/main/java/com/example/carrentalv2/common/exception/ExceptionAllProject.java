package com.example.carrentalv2.common.exception;

import lombok.Builder;

@Builder

public class ExceptionAllProject{
    public static final String ACCOUNT_EXIST_CODE = "001";
    public static final String ACCOUNT_EXIST_MESSAGE = "This user already has an account Created !!! ";
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account has been successfully created !!! ";
    public static final String USER_NOT_FOUND = "user not found";
    public static final String CARD_NOT_FOUND = "card not found";
    public static final String PERMISSION_NOT_FOUND = "permission not found";
    public static final String ROLE_NOT_FOUND = "role not found";
    public static final String COMMENT_NOT_FOUND = "comment not found";
    public static final String RATING_NOT_FOUND = "Rating not found";
    public static final String CATEGORY_NOT_FOUND = "Category not found";
    public static final String COMPANY_NOT_FOUND = "Company not found";
    public static final String PRODUCT_NOT_FOUND = "Product not found";
    public static final String ORDER_NOT_FOUND = "Order not found";
}
