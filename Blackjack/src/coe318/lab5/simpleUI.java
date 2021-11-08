package coe318.lab5;

import java.util.Scanner;

public class simpleUI implements UserInterface {

    private blackjackGame game;
    private Scanner user = new Scanner(System.in);
    boolean hit = true;
    @Override
    public void setGame(blackjackGame game) {
        this.game = game;
    }

    @Override
    public void display() {
//FIX THIS
        System.out.println("House has: " + this.game.getHouseCards().toString()); //House Cards
        System.out.println("You have: " + this.game.getYourCards().toString()); // Your cards
    }

    @Override
    public boolean hitMe() {
//FIX THIS
        System.out.println("Want a hit? (yes/no)");
        String userChoice = user.nextLine();
        if (userChoice.equals("Yes") || userChoice.equals("yes")){
            hit = true;
        }
        else if (userChoice.equals("No") || userChoice.equals("no")) {
            hit = false;
        }
        else {
            System.out.println("invalid input. Enter either yes or no.");
            hitMe();
        }
        return hit;
    }

    @Override
    public void gameOver() {
//FIX THIS
        this.display();
        int yourScore = game.score(game.getYourCards());
        int houseScore = game.score(game.getHouseCards());
        System.out.println("House Score: " + houseScore + " Your Score: " + yourScore);
        if ((yourScore > houseScore || houseScore > 21) && (yourScore <= 21)) {
            System.out.println("You Win.");
        } else {
            System.out.println("House Wins.");
        }
        System.out.println("Like, comment and subscribe.");
    }
}
