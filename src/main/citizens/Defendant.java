package main.citizens;

public class Defendant extends DirectParticipant{
    public Defendant(String threeNames, String address, int age) {
        super(threeNames, address, age);
    }

    @Override
    public String getType() {
        return "Defendant";
    }
}
