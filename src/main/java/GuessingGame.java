/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Classes to simulate three arcade games available to the user, with options to
 * view their respective score lists and search for a player's high score Solves
 * ICS4U Assignment: Culminating Assignment
 *
 * @author Dayna Dranitsaris
 * @version 1.0
 * @since 2022-01-26
 */
public class GuessingGame extends Game {

    //Class fields
    public static final String gameName = "Guessing Game";
    public static final String fileName = "GuessingGameScores.txt";

    //Method to play guessing game
    @Override
    public int play(int score, int guess, int number) {
        //If the player guesses the number
        if (score >= 0 && number == guess) {
            return 1;
            //If the player doesn't guess the number, but still has guesses left
        } else if (score > 0 && number != guess) {
            return 2;
            //If the player doesn't guess the number, and they are out of guesses
        } else if ((score == 0) && (guess != number)) {
            return 3;
        }
        return -1;
    }

    //Method to check if input is valid for guessing game. Must be an integer between 1 and 1000
    @Override
    public boolean checkInputValidity(String input) {
        try {
            Integer.parseInt(input);
            if ((Integer.parseInt(input) >= 0) && (Integer.parseInt(input) <= 1000)) {
                return true;
            } else {
            }
        } catch (NumberFormatException e) {
        }
        return false;
    }

    //Method to return an invalid input message
    @Override
    public String invalidInputMessage() {
        return "Invalid input!\nYou must enter an integer between 1 and 1000.";
    }

    //Method to return a win message
    public String winMessage(int score, int number) {
        return "You guessed it!\nThe number was "+number+".\nYour score is "+score+".";
    }

    //Method to return a lose message
    public String loseMessage(int score, int number) {
        return "You're out of guesses!\nThe number was "+number+".\nYour score is "+score+".";
    }
}
