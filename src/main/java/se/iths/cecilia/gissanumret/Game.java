package se.iths.cecilia.gissanumret;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Inputhandler inputhandler = new Inputhandler();
    Scanner sc = new Scanner(System.in);
    int level;
    boolean guessIncorrect = true;
    int antalGissningar = 0;

    public void chooseLevel() throws InputMismatchException {
        System.out.println("Enter level of difficulty:" +
                "\n1) Easy" +
                "\n2) Normal" +
                "\n3) Hard");
        level = sc.nextInt();
        switch (level) {
            case 1:
                GuessNumberEasy();
                break;
            case 2:
                GuessNumberNormal();
                break;
            case 3:
                GuessNumberDifficult();
                break;
            default:
                System.out.println("Level does not exist");
                break;
        }

    }

    public void GuessNumberEasy() {
        guessIncorrect = true;
        antalGissningar = 10;
        int myNumber = GenerateNumber(50);

        do {
            System.out.println("Antal gissningar kvar: " + antalGissningar);
            int userNumber = inputhandler.UserInputNumber();
            guessIncorrect = CompareUserNumberAndMyNumber(userNumber, myNumber);
            antalGissningar--;
        } while (guessIncorrect && antalGissningar != 0);

        if (antalGissningar == 0 && guessIncorrect) {
            System.out.println("You are out of moves. \n Correct answer: " + myNumber);
        }
        inputhandler.UserPlayAgain();
    }

    public void GuessNumberNormal() {
        guessIncorrect = true;
        antalGissningar = 8;
        int myNumber = GenerateNumber(100);

        do {
            System.out.println("Antal gissningar kvar: " + antalGissningar);
            int userNumber = inputhandler.UserInputNumber();
            guessIncorrect = CompareUserNumberAndMyNumber(userNumber, myNumber);
            antalGissningar--;
        } while (guessIncorrect && antalGissningar != 0);

        if (antalGissningar == 0 && guessIncorrect) {
            System.out.println("You are out of moves. \n Correct answer: " + myNumber);
        }
        inputhandler.UserPlayAgain();
    }

    public void GuessNumberDifficult() {
        guessIncorrect = true;
        antalGissningar = 12;
        int myNumber = GenerateNumber(1000);

        do {
            System.out.println("Antal gissningar kvar: " + antalGissningar);
            int userNumber = inputhandler.UserInputNumber();
            guessIncorrect = CompareUserNumberAndMyNumber(userNumber, myNumber);
            antalGissningar--;
        } while (guessIncorrect && antalGissningar != 0);

        if (antalGissningar == 0 && guessIncorrect) {
            System.out.println("You are out of moves. \n Correct answer: " + myNumber);
        }
        inputhandler.UserPlayAgain();
    }

    public int GenerateNumber(int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }

    public boolean CompareUserNumberAndMyNumber(int userNumber, int myNumber) {
        if (userNumber < myNumber) {
            System.out.println("Du gissar för lågt.");
            return true;
        } else if (userNumber > myNumber) {
            System.out.println("Du gissar för högt.");
            return true;
        } else {
            System.out.println("Du gissade rätt!");
            return false;
        }
    }
}
