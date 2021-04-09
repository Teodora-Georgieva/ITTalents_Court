package main.citizens;

import main.utils.Validator;

import java.util.Objects;

public abstract class Citizen {
    private String threeNames;
    private String address;
    private int age;
    private static int citizenId = 1;
    private int citizenID;

    Citizen(String threeNames, String address, int age){
        this.citizenID = citizenId++;

        if(Validator.validateCountOfNames(threeNames)){
            this.threeNames = threeNames;
        }
        else{
            this.threeNames = "Ivan Ivanov Petrov";
        }

        if(Validator.validateString(address)){
            this.address = address;
        }
        else{
            this.address = "Veliko Tarnovo";
        }

        if(age > 0){
             this.age = age;
        }
        else{
            this.age = 45;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return citizenID == citizen.citizenID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(citizenID);
    }

    public String getThreeNames() {
        return threeNames;
    }

    @Override
    public String toString() {
        return "threeNames: " + threeNames + ", type: " + getType() + ", citizenID = " + citizenID;
    }

    public abstract String getType();
}