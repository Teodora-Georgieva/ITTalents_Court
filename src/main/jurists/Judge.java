package main.jurists;

public class Judge extends Jurist{
    public Judge(String name, int experience, int countOfCases) {
        super(name, experience, countOfCases);
    }

    @Override
    boolean validateExperience(int experience) {
        return experience >= 5;
    }

    @Override
    int setDefaultExperience() {
        return 5;
    }

    @Override
    String getPosition() {
        return "Judge";
    }
}