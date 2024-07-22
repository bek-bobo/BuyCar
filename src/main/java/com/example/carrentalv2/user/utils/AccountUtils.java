package com.example.carrentalv2.user.utils;

import java.time.Year;

public class AccountUtils {
    public static String generateAccountNumber(){

        Year correctYear = Year.now();

        int min = 100000;
        int max = 999999;
        int randNumber = (int) Math.floor(Math.random() * (max - min + 1) + min );

        String year = String.valueOf(correctYear);
        String randomNumber = String.valueOf(randNumber);

        StringBuilder accountNumber = new StringBuilder();

        return accountNumber.append(year).append(randomNumber).toString();
    }
}
