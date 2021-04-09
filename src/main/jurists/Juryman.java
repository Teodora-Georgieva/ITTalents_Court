package main.jurists;

import java.util.Random;

public class Juryman extends Jurist{
    public Juryman(String name, int experience, int countOfCases) {
        super(name, experience, countOfCases);
    }

    @Override
    String getPosition() {
        return "Juryman";
    }

    public boolean decideIfGuilty(){
        Random r = new Random();
        return r.nextBoolean();
    }
}