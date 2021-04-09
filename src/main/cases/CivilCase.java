package main.cases;

import main.IAccuser;
import main.citizens.Accuser;
import main.citizens.ICitizenAccuser;
import main.citizens.Witness;
import main.jurists.Attorney;

public class CivilCase extends Case{

    public CivilCase(ICitizenAccuser accuser) {
        super(accuser);
    }

    @Override
    int getMaxCountOfJurymen() {
        return 3;
    }

    @Override
    String getType() {
        return "CivilCase";
    }

    @Override
    void askingQuestions() {
        for(Attorney attorney : ((ICitizenAccuser)(accuser)).getAttorneys()){
            for (int i = 0; i < 3; i++) {
                attorney.askQuestion(getDefendant());
            }

            for(Witness witness : getWitnesses()) {
                for (int i = 0; i < 2; i++) {
                    attorney.askQuestion(witness);
                }
            }
        }
    }
}