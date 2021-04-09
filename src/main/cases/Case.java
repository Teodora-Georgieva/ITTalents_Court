package main.cases;

import main.IAccuser;
import main.citizens.Defendant;
import main.citizens.Witness;
import main.jurists.Attorney;
import main.jurists.IQuestionAsker;
import main.jurists.Judge;
import main.jurists.Juryman;
import main.utils.Generator;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Case {
    private String type;
    private Judge judge;
    private HashSet<Juryman> jurymen;
    private Defendant defendant;
    IAccuser accuser;
    private HashSet<Witness> witnesses;

    Case(IAccuser accuser)
    {
        this.type = getType();
        this.accuser = accuser;
        this.jurymen = new HashSet<>();
        this.witnesses = new HashSet<>();
    }

    public void setJudge(Judge judge) {
        if(judge != null) {
            this.judge = judge;
        }
        else{
            System.out.println("judge is null!");
        }
    }

    public void setJurymen(HashSet<Juryman> jurymen) {
        ArrayList<Juryman> jurymenToAdd = new ArrayList<>(jurymen);
        int i = 0;
        while(i < getMaxCountOfJurymen()){
            int jurymanIdx = Generator.generateRandomNumber(0, jurymen.size() - 1);
            if(this.jurymen.add(jurymenToAdd.get(jurymanIdx))){
                i++;
            }
        }
    }

    abstract int getMaxCountOfJurymen();
    abstract String getType();
    abstract void askingQuestions();

    public int conduct(){
        //TODO
        this.judge.increaseCountOfCases();
        for(Juryman juryman : this.jurymen){
            juryman.increaseCountOfCases();
        }

        //askingQuestions();
            accuser.askingQuestions(defendant, witnesses);

        for(Attorney attorney : defendant.getAttorneys()){
            for(Witness witness : witnesses){
                for (int i = 0; i < 5; i++) {
                    attorney.askQuestion(witness);
                }
            }
        }

        int isGuilty = 0;

        for(Juryman juryman : jurymen){
            if(juryman.decideIfGuilty()){
                isGuilty++;
            }
        }

        boolean defendantIsGuilty = (isGuilty > jurymen.size()/2) ? true : false;

        int yearsInJail = defendantIsGuilty ? Generator.generateRandomNumber(3, 40) : 0;
        return yearsInJail;
    }

    Defendant getDefendant() {
        return defendant;
    }

    HashSet<Witness> getWitnesses() {
        return witnesses;
    }

    public void showChronology(int verdict){
        System.out.println("Case of type: " + type);
        System.out.println("Judge: " + judge);
        System.out.println();
        for(Juryman juryman : jurymen) {
            System.out.println(juryman);
        }
        System.out.println();
        System.out.println("Defendant: " + defendant);
        System.out.println();
        System.out.println("Accuser: " + accuser);
        System.out.println();
        System.out.println("Witnesses: ");
        for(Witness witness : witnesses){
            System.out.println(witness);
        }
        System.out.println();

        System.out.println("Asked questions:");
        if(accuser instanceof IQuestionAsker) {
            ((IQuestionAsker) (accuser)).showAskedPeople();
        }

        System.out.println();

        System.out.print("Jurymen decided: defendant is ");
        if(verdict > 0){
            System.out.println("guilty");
        }
        else{
            System.out.println("not guilty");
        }

        System.out.println("Judge gave " + verdict + "years in jail");
    }

    public void setDefendant(Defendant defendant) {
        this.defendant = defendant;
    }

    public void setWitnesses(HashSet<Witness> witnesses) {
        this.witnesses = witnesses;
    }
}
