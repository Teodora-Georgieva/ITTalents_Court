package main.utils;

public abstract class Validator {
    public static boolean validateString(String s){
        return s != null && s.length() > 0;
    }

    public static boolean validateCountOfNames(String names){
        names = names.trim();
        String[] threeNames = names.split(" ");
        return threeNames.length == 3;
    }
}