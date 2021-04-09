package main.citizens;

import main.jurists.Attorney;

import java.util.HashSet;

public abstract class DirectParticipant extends Citizen{
    private HashSet<Attorney> attorneys;

    DirectParticipant(String threeNames, String address, int age) {
        super(threeNames, address, age);
        this.attorneys = new HashSet<>();
    }

    public void addAttorney(Attorney attorney){
        this.attorneys.add(attorney);
    }

    public HashSet<Attorney> getAttorneys() {
        return attorneys;
    }
}