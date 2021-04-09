package main.utils;

import java.util.Random;

public class Generator {
    private static String[] threeNames = {"Ivan Ivanov Petrov", "Petar Vasilev Vasilev", "Metodi Metodiev Ivanov",
                                           "Maria Ivanova Iordanova", "Iordan Todorov Petrov", "Dimitar Stoianov Kolev",
                                            "Petq Dimitrova Stoeva", "Nikolai Dragomirov Petrov", "Stefan Ivanov Todorov"};
    public static int generateRandomNumber(int min, int max){
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static String generateRandomThreeNames(){
        Random r = new Random();
        return threeNames[r.nextInt(threeNames.length)];
    }
}