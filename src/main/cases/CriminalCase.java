package main.cases;

import main.IAccuser;
import main.citizens.Witness;
import main.jurists.IQuestionAsker;
import main.jurists.Prosecutor;

public class CriminalCase extends Case{
    public CriminalCase(Prosecutor accuser) {
        super(accuser);
    }

    @Override
    int getMaxCountOfJurymen() {
        return 13;
    }

    @Override
    String getType() {
        return "CriminalCase";
    }

    @Override
    void askingQuestions() {
        for (int i = 0; i < 5; i++) {
            ((IQuestionAsker)(accuser)).askQuestion(getDefendant());
        }

        for(Witness witness : getWitnesses()){
            for (int i = 0; i < 5; i++) {
                ((IQuestionAsker)(accuser)).askQuestion(witness);
            }
        }

    }
}