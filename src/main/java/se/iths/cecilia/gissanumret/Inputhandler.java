package se.iths.cecilia.gissanumret;

import java.util.Scanner;

public class Inputhandler {
    Scanner sc = new Scanner(System.in);
    private Object UserPlayAgain;

    public int UserInputNumber() {
        System.out.print("Gissa: ");
        return sc.nextInt();
    }

    public void UserPlayAgain() {
        System.out.println("Vill du spela igen? 1 / 0");
        int input = sc.nextInt();
        if (input == 1) {
            Game game = new Game();
            game.GuessNumber();
            UserPlayAgain();
        } else {
            System.exit(0);
        }
    }
}
