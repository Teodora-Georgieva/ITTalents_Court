package main;

import main.cases.Case;
import main.jurists.Jurist;
import main.utils.Validator;

import java.util.*;

public class Court {
    private String name;
    private String address;
    private HashSet<Jurist> jurists;
    private HashSet<Case> cases;

    public Court(String name, String address){
        this.jurists = new HashSet<>();
        this.cases = new HashSet<>();
        if(Validator.validateString(name)){
            this.name = name;
        }
        else{
            this.name = "District Court Veliko Tarnovo";
        }

        if(Validator.validateString(address)){
            this.address = address;
        }
        else {
            this.address = "Veliko Tarnovo";
        }
    }

    public HashSet<Jurist> getJurists() {
        return jurists;
    }

    public void addCase(Case c){
        this.cases.add(c);
    }

    public void addJurist(Jurist j){
        this.jurists.add(j);
    }

    public void considerCases(){
        showAllJuristsWithNumOfCases();
        for(Case c : cases){
            int verdict = c.conduct();
            c.showChronology(verdict);
        }
        showAllJuristsWithNumOfCases();
    }

    public void showAllJuristsWithNumOfCases(){
        System.out.println("Showing all jurists with count of cases:");
        TreeMap<String, Integer> result = new TreeMap<>();
        for(Jurist jurist : jurists){
            result.put(jurist.getName(), jurist.getCountOfCases());
        }

        for(Map.Entry<String, Integer> e : result.entrySet()){
            System.out.println(e.getKey() + " - " +  e.getValue());
        }
        System.out.println();
    }
}