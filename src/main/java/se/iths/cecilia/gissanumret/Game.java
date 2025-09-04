package se.iths.cecilia.gissanumret;

public class Game {
    Gamelogic gamelogic = new Gamelogic();
    Inputhandler inputhandler = new Inputhandler();
    int antalGissningar;
    boolean guessIncorrect;

    public void GuessNumber() {
        guessIncorrect = true;
        antalGissningar = 0;
        
        do {
            int userNumber = inputhandler.UserInputNumber();
            guessIncorrect = gamelogic.CompareUserNumberAndMyNumber(userNumber, gamelogic.myNumber);
        } while (guessIncorrect == true);
    }
}
