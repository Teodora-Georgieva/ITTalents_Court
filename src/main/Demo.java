package main;

import main.cases.Case;
import main.cases.CivilCase;
import main.cases.CriminalCase;
import main.citizens.*;
import main.jurists.Attorney;
import main.jurists.Judge;
import main.jurists.Juryman;
import main.jurists.Prosecutor;
import main.utils.Generator;

import java.util.ArrayList;
import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {
        Court court = new Court("Raionen sud Veliko Tarnovo", "Veliko Tarnovo");
        ArrayList<Judge> judges = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String name = "Judge" + (i+1);
            Judge j = new Judge(name, 0, 0);
            court.addJurist(j);
            judges.add(j);
        }

        HashSet<Juryman> jurymen = new HashSet<>();
        for (int i = 0; i < 13; i++) {
            String name = "Juryman" + (i+1);
            Juryman j = new Juryman(name, 0, 0);
            court.addJurist(j);
            jurymen.add(j);
        }

        ArrayList<Attorney> attorneys = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String name = "Attorney" + (i+1);
            Attorney a = new Attorney(name, 0, 0);
            court.addJurist(a);
            attorneys.add(a);
        }

        ArrayList<Prosecutor> prosecutors = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String name = "Prosecutor" + (i+1);
            Prosecutor p = new Prosecutor(name, 0, 0);
            court.addJurist(p);
            prosecutors.add(p);
        }

        HashSet<Citizen> citizens = new HashSet<>();
        ArrayList<Accuser> accusers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String name = Generator.generateRandomThreeNames();
            Accuser a = new Accuser(name, "", Generator.generateRandomNumber(18, 60));
            citizens.add(a);
            accusers.add(a);
        }

        ArrayList<Defendant> defendants = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String name = Generator.generateRandomThreeNames();
            Defendant d = new Defendant(name, "", Generator.generateRandomNumber(18, 60));
            defendants.add(d);
        }

        HashSet<Witness> witnesses = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            String name = Generator.generateRandomThreeNames();
            witnesses.add(new Witness(name, "", Generator.generateRandomNumber(18, 60)));
        }

        ArrayList<Case> cases = new ArrayList<Case>();
        for (int i = 0; i < 3; i++) {
            Accuser accuser = accusers.get(Generator.generateRandomNumber(0, accusers.size() - 1));

            CivilCase civilCase = new CivilCase(accuser);
            int judgeIdx = Generator.generateRandomNumber(0, judges.size() - 1);
            civilCase.setJudge(judges.get(judgeIdx));
            civilCase.setJurymen(jurymen);
            int defendantIdx = Generator.generateRandomNumber(0, defendants.size() - 1);
            civilCase.setDefendant(defendants.get(defendantIdx));
            civilCase.setWitnesses(witnesses);
            cases.add(civilCase);
        }

        for (int i = 0; i < 3; i++) {
            Prosecutor accuser = prosecutors.get(Generator.generateRandomNumber(0, prosecutors.size() - 1));

            CriminalCase criminalCase = new CriminalCase(accuser);
            int judgeIdx = Generator.generateRandomNumber(0, judges.size() - 1);
            criminalCase.setJudge(judges.get(judgeIdx));
            criminalCase.setJurymen(jurymen);
            int defendantIdx = Generator.generateRandomNumber(0, defendants.size() - 1);
            criminalCase.setDefendant(defendants.get(defendantIdx));
            criminalCase.setWitnesses(witnesses);

            cases.add(criminalCase);
        }

        for(Case c : cases){
            court.addCase(c);
        }

        court.considerCases();
    }
}