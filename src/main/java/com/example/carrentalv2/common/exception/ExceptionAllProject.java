package com.example.carrentalv2.common.exception;

import lombok.Builder;

@Builder

public class ExceptionAllProject{
    public static final String USER_NOT_FOUND = "User not found !!!";
    public static final String ACCOUNT_EXIST_CODE = "001";
    public static final String ACCOUNT_EXIST_MESSAGE = "This user already has an account Created !!! ";
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account has been successfully created !!! ";
}
