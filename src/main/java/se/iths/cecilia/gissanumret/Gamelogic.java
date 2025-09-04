package se.iths.cecilia.gissanumret;

import java.util.Random;

public class Gamelogic {
    int antalGissningar = 0;
    int myNumber = GenerateNumber();

    public int GenerateNumber() {
        Random rand = new Random();
        myNumber = rand.nextInt(100);
        return myNumber;
    }

    public boolean CompareUserNumberAndMyNumber(int userNumber, int myNumber) {
        antalGissningar++;
        if (userNumber < myNumber) {
            System.out.println("DU gissar för lågt.");
            return true;
        } else if (userNumber > myNumber) {
            System.out.println("Du gissar för högt.");
            return true;
        } else {
            System.out.println("Du gissade rätt!");
            PrintVictoryMessage();
            return false;
        }
    }

    public void PrintVictoryMessage() {
        System.out.println("Grattis! Du vann.");
        System.out.println("Rekord: " + antalGissningar + " försök.");
    }
}
