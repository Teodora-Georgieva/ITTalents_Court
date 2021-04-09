package main.jurists;

import main.IAccuser;
import main.citizens.Defendant;
import main.citizens.Witness;

import java.util.HashSet;

public class Prosecutor extends Jurist implements IQuestionAsker, IAccuser {
    public Prosecutor(String name, int experience, int countOfCases) {
        super(name, experience, countOfCases);
    }

    @Override
    boolean validateExperience(int experience) {
        return experience >= 10;
    }

    @Override
    int setDefaultExperience() {
        return 10;
    }

    @Override
    String getPosition() {
        return "Prosecutor";
    }

    @Override
    public void askingQuestions(Defendant defendant, HashSet<Witness> witnesses) {
        //TODO
    }
}