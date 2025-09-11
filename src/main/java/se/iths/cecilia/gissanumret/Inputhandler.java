package se.iths.cecilia.gissanumret;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputhandler {
    Scanner sc = new Scanner(System.in);

    public int UserInputNumber() {
        try {
            System.out.print("Gissa: ");
            return sc.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Invalid input. Enter again.");
        }
    }

    public void UserPlayAgain() {
        System.out.println("Vill du spela igen? 1 / 0");
        int input = sc.nextInt();
        if (input == 1) {
            Game game = new Game();
            game.chooseLevel();
        } else {
            sc.close();
            System.exit(0);
        }
    }
}
