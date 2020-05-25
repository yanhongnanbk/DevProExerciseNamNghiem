package com.yan.day05exercisetest;

import java.util.regex.Pattern;

public class Helper {
    public static boolean validPassword(String password){
        return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$",password);
    }

}
