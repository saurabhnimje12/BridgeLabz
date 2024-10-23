package org.example;

import java.util.regex.Pattern;

public class UserServiceImpl {
    public UserService checkFirstName = (fname) -> {
        String regex = "^[A-Z][a-z]{2}$";
        Pattern pattern = Pattern.compile(regex);
        boolean check = pattern.matcher(fname).matches();
        if (check) {
            return true;
        } else {
            throw new UserHandleException("Enter a Valid First Name Syntax and first Letter is Capital");
        }
    };

    public UserService checkLastName = (lname) -> {
        String regex = "^[A-Z][a-z]{2}$";
        if (Pattern.compile(regex).matcher(lname).matches()) {
            return true;
        } else {
            throw new UserHandleException("Enter a Valid Last Name Syntax and first Letter is Capital");
        }
    };

    public UserService checkEmail = (email) -> {
        String regex = "^[A-Za-z0-9+._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (Pattern.compile(regex).matcher(email).matches()) {
            return true;
        } else {
            throw new UserHandleException("Enter a valid Email ID");
        }
    };

    public UserService checkPhno = (phno) -> {
        String regex = "^[6-9]\\d{9}$";
        if (Pattern.compile(regex).matcher(phno).matches()) {
            return true;
        } else {
            throw new UserHandleException("Enter a Valid Phno");
        }
    };

    public UserService checkPazzword = (pazzword) -> {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        if (Pattern.compile(regex).matcher(pazzword).matches()) {
            return true;
        } else {
            throw new UserHandleException("Enter a Valid Password");
        }
    };

    public UserService checkAllEmail = (email) -> {
        String regex = "^[A-Za-z0-9+_%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,} (\\\\.[A-Za-z]{2,})*$";
        if (Pattern.compile(regex).matcher(email).matches()) {
            return true;
        } else {
            throw new UserHandleException("Enter a valid Email ID");
        }
    };
}




