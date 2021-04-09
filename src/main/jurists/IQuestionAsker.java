package main.jurists;

import main.IAccuser;
import main.citizens.Citizen;

public interface IQuestionAsker {
    void askQuestion(Citizen citizen);
    void showAskedPeople();
}
