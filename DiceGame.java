import java.util.ArrayList;
import java.util.Scanner;

public class DiceGame {
    public static ArrayList<Integer> decideWinner(Player[] players) {
        int max = 0; //place to store maximum
        ArrayList<Integer> indexes = new ArrayList<Integer>(); //place to store list of integers of winners
        for(int i = 0; i < players.length; i++) { //this loop is to find the maximum
            Die die = players[i].getDie();
            if (die.getValue() > max) { //if dice value is bigger than the current max
                max = die.getValue(); //update max with that die value
            }
        }
        //max is now the actual maximum
        for(int i = 0; i < players.length; i++) { //this loop finds all the players who rolled that maximum
            Die die = players[i].getDie();
            if (die.getValue() == max) {
                indexes.add(i);
            }
        }
        return indexes;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the number of sides for the die being used: "); //get size of dice
        int diceSize = sc.nextInt();
        sc.nextLine();
        System.out.println("Please input the number of players: "); //get number of players
        int playerNumber = sc.nextInt();
        sc.nextLine();
        Player[] players = new Player[playerNumber]; //empty list of players
        for(int i = 1; i <= playerNumber; i++) { //populate the list of players with names and dice
            System.out.println("Enter the name of player " + i + ": ");
            String playerName = sc.nextLine();
            Die die = new Die(diceSize);
            players[i-1] = new Player(playerName, die);
        }
        System.out.println();
        for(int i = 1; i <= playerNumber; i++) { //go through list and roll each dice
            Die die = players[i-1].getDie();
            int value = die.roll();
            System.out.println(players[i-1].getName() + " rolled a " + value + " on a " + diceSize + " sided die.");
        }
        System.out.println();
        ArrayList<Integer> winners = decideWinner(players); //call winners method
        if (winners.size() == 1) { //if only one winner
            System.out.println(players[winners.get(0)].getName() + " won the game!");
        } else if (winners.size() == 2) { //two people tied
            System.out.println(players[winners.get(0)].getName() + " and " + players[winners.get(1)].getName() + " tied the game!" );
        } else {
            for (int i = 0; i < (winners.size() - 1); i++) { //more than two people tied (we can loop through "____ and " + "_____ and " up to the last name)
                System.out.print(players[winners.get(i)].getName() + " and ");
            }
            System.out.println(players[(winners.get(winners.size() - 1))].getName() + " tied the game!");
        }
    }
}
