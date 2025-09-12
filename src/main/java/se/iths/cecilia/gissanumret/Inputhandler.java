package se.iths.cecilia.gissanumret;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputhandler {
    Scanner sc = new Scanner(System.in);

    public int userNumberInputCheck() {
        int userNumber = 0;
        try {
            userNumber = sc.nextInt();
            sc.nextLine();
            return userNumber;
        } catch
        (InputMismatchException e) {
            System.out.println("Wrong input");
            sc.nextLine();
        }
        return userNumber;
    }

    public void userPlayAgain() {
        System.out.println("Vill du spela igen? 1 / 0");
        int input = sc.nextInt();
        if (input == 1) {
            chooseLevel();
        } else {
            sc.close();
            System.exit(0);
        }
    }

    public void chooseLevel() {
        System.out.println("""
                Levels: \
                
                1) Easy\
                
                2) Normal\
                
                3) Hard\
                
                 Enter level of difficulty:\s""");

        int level = 0;

        while (level > 4 || level < 1) {
            level = userNumberInputCheck();
            if (level > 4 || level < 1) {
                System.out.println("Level does not exist. Please try again.");
            }
        }
        
        Game game;
        switch (level) {
            case 1:
                game = new Game();
                game.guessNumberEasy();
                break;
            case 2:
                game = new Game();
                game.guessNumberNormal();
                break;
            case 3:
                game = new Game();
                game.guessNumberDifficult();
                break;
        }
    }
}
