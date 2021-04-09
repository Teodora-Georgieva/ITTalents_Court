package main.citizens;

public class Witness extends Citizen{
    public Witness(String threeNames, String address, int age) {
        super(threeNames, address, age);
    }

    @Override
    public String getType() {
        return "Witness";
    }
}
