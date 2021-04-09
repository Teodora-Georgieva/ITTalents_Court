package main.citizens;

import main.jurists.Attorney;

import java.util.HashSet;

public class Accuser extends DirectParticipant implements ICitizenAccuser {
    public Accuser(String threeNames, String address, int age) {
        super(threeNames, address, age);
    }

    @Override
    public String getType() {
        return "Accuser";
    }

    @Override
    public void askingQuestions(Defendant defendant, HashSet<Witness> witnesses) {
        for(Attorney attorney : getAttorneys()){
            attorney.askQuestion(defendant); //in loop, several questions
            //.....
            for(Witness witness : witnesses){
                attorney.askQuestion(witness); //in loop, several questions
            }
        }
    }
}