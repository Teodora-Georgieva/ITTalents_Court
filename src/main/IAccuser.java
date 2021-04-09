package main;

import main.citizens.Defendant;
import main.citizens.Witness;
import main.jurists.Attorney;

import java.util.HashSet;

public interface IAccuser {
    public void askingQuestions(Defendant defendant, HashSet<Witness> witnesses);
}
