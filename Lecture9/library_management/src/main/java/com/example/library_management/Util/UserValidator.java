package com.example.library_management.Util;

import com.example.library_management.Model.User;

public class UserValidator {

    public static boolean isValidUser(User user){
        if(user.getEmail()==null || user.getEmail()=="")
            return false;
        else return true;
    }
}