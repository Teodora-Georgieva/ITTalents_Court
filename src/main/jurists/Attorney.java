package main.jurists;

public class Attorney extends Jurist implements IQuestionAsker {
    public Attorney(String name, int experience, int countOfCases) {
        super(name, experience, countOfCases);

    }

    @Override
    boolean validateCountOfCases(int countOfCases){
        return countOfCases >= 10;
    }

    @Override
    int setDefaultCountOfCases() {
        return 10;
    }

    @Override
    String getPosition() {
        return "Attorney";
    }


}