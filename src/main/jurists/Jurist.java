package main.jurists;

import main.citizens.Citizen;
import main.utils.Validator;

import java.util.HashSet;
import java.util.Objects;

public abstract class Jurist {
    private static int juristId = 1;
    private String name;
    private String position;
    private int experience;
    private int countOfCases;
    private HashSet<Citizen> askedPeople;
    private int juristID;

    Jurist(String name, int experience, int countOfCases){
        this.juristID = juristId++;
        this.askedPeople = new HashSet<>();

        if(Validator.validateString(name)){
            this.name = name;
        }
        else{
            this.name = "Ivan Ivanov";
        }

        if(validateExperience(experience)){
            this.experience = experience;
        }
        else{
            this.experience = setDefaultExperience();
        }

        if(validateCountOfCases(countOfCases)){
            this.countOfCases = countOfCases;
        }
        else{
            this.countOfCases = setDefaultCountOfCases();
        }

        this.position = getPosition();
    }

    boolean validateCountOfCases(int countOfCases){
        return countOfCases >= 0;
    }

    int setDefaultCountOfCases(){
        return 0;
    }

    boolean validateExperience(int experience){
        return experience >= 0;
    }

    int setDefaultExperience(){
        return 0;
    }

    abstract String getPosition();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jurist jurist = (Jurist) o;
        return juristID == jurist.juristID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(juristID);
    }

    public void askQuestion(Citizen citizen){
        System.out.println(this.name + " asked " + citizen.getThreeNames() + " a question.");
        this.askedPeople.add(citizen);
    }

    void noteAnswers(){
        //TODO
    }

    public void increaseCountOfCases(){
        this.countOfCases++;
    }

    public void showAskedPeople(){
        System.out.println(this.name + " asked:");
        for(Citizen citizen : this.askedPeople){
            System.out.println(citizen);
        }
    }

    @Override
    public String toString() {
        return "name = " + name  + ", position = " + position + ", juristID = " + juristID ;
    }

    public String getName() {
        return name;
    }

    public int getCountOfCases() {
        return countOfCases;
    }
}