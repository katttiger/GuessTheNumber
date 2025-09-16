package se.iths.cecilia.gissanumret;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Inputhandler inputhandler = new Inputhandler();
    Scanner sc;
    int myNumber;
    boolean guessIncorrect;
    int antalGissningar;

    public Game() {
        this.inputhandler = new Inputhandler();
        this.sc = new Scanner(System.in);
        this.myNumber = 0;
        this.guessIncorrect = true;
        this.antalGissningar = 0;
    }

    public void guessNumberEasy() {
        antalGissningar = 10;
        myNumber = generateNumber(51);

        System.out.println("Number is between 0-50.");

        do {
            guessIncorrect = gameLogic(antalGissningar);
        } while (guessIncorrect && antalGissningar != 0);

        if (antalGissningar == 0 && guessIncorrect) {
            System.out.println("You are out of moves. \n Correct answer: " + myNumber);
        }
        inputhandler.userPlayAgain();
    }

    public void guessNumberNormal() {
        antalGissningar = 8;
        myNumber = generateNumber(101);

        System.out.println("Number is between 0-100.");

        do {
            guessIncorrect = gameLogic(antalGissningar);
        } while (guessIncorrect && antalGissningar != 0);

        if (antalGissningar == 0 && guessIncorrect) {
            System.out.println("You are out of moves. \n Correct answer: " + myNumber);
        }
        inputhandler.userPlayAgain();
    }

    public void guessNumberDifficult() {
        antalGissningar = 12;
        myNumber = generateNumber(1001);

        System.out.println("Number is between 0-1000.");


        do {
            guessIncorrect = gameLogic(antalGissningar);
        } while (guessIncorrect && antalGissningar != 0);

        if (antalGissningar == 0 && guessIncorrect) {
            System.out.println("You are out of moves. \n Correct answer: " + myNumber);
        }
        inputhandler.userPlayAgain();
    }

    public boolean gameLogic(int antalGissningar) {
        System.out.println("Antal gissningar kvar: " + antalGissningar);

        int userNumber = 0;

        do {
            userNumber = inputhandler.userNumberInputCheck();
        } while (userNumber == 0);

        guessIncorrect = compareUserNumberAndMyNumber(userNumber, myNumber);
        this.antalGissningar--;
        if (guessIncorrect) {
            return true;
        } else {
            return false;
        }
    }

    public int generateNumber(int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }

    public boolean compareUserNumberAndMyNumber(int userNumber, int myNumber) {
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
