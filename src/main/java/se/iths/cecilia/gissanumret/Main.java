package se.iths.cecilia.gissanumret;

public class Main {

    public static void main(String[] args) {
        Inputhandler inputhandler = new Inputhandler();
        while (true) {
            inputhandler.chooseLevel();
            inputhandler.userPlayAgain();
        }
    }
}