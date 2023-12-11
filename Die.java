import java.util.concurrent.ThreadLocalRandom;

public class Die {
    private int numSides;
    private int value;

    public Die() { //general constructor
        this.numSides = 6;
        this.value = 1;
    }

    public Die(int numSides) { //specific constructor
        this.numSides = numSides;
        this.value = 1;
    }

    public int roll() { //roll function
        int randomNum = ThreadLocalRandom.current().nextInt(1, this.numSides + 1); //generates a random number from 1 to sides max inclusive
        this.value = randomNum;
        return randomNum;
    }

    public int getNumSides() {
        return numSides;
    }

    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override //do we need this? its in the instructions but its not used in main
    public String toString(){
        return "Sides: " + this.numSides + "; Value: " + this.value;
    }
}
