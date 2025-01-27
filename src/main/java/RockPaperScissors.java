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
public class RockPaperScissors extends Game {

    //Class fields
    public static final String gameName = "Rock Paper Scissors";
    public static final String fileName = "RockPaperScissorsScores.txt";
    private static String move;

    //Method to play rock paper scissors
    @Override
    public int play(int score, int choice, int number) {
        if (((number == 1) && (choice == 2)) || ((number == 2) && (choice == 3)) || ((number == 3) && (choice == 1))) {
            return 1;
        } else if (((number == 1) && (choice == 3)) || ((number == 2) && (choice == 1)) || ((number == 3) && (choice == 2))) {
            return 2;
        } else {
            return -1;
        }
    }

    //Method to check if input is valid for rock paper scissors
    @Override
    public boolean checkInputValidity(String input) {
        return true;
    }

    //Method to return an invalid input message
    @Override
    public String invalidInputMessage() {
        return null;
    }

    //Method to return a win message
    @Override
    public String winMessage(int score, int number) {
        if (number == 1) {
            move = "rock";
        } else if (number == 2) {
            move = "paper";
        } else if (number == 3) {
            move = "scissors";
        }
        return "You won!\nYour opponent picked " + move + ".";
    }

    //Method to return a lose message
    @Override
    public String loseMessage(int score, int number) {
        if (number == 1) {
            move = "rock";
        } else if (number == 2) {
            move = "paper";
        } else if (number == 3) {
            move = "scissors";
        }
        return "You lost!\nYour opponent picked " + move + ".\nYour score is " + score + ".";
    }

    //Method to return a tie message
    public String tieMessage(int score, int number) {
        if (number == 1) {
            move = "rock";
        } else if (number == 2) {
            move = "paper";
        } else if (number == 3) {
            move = "scissors";
        }
        return "It's a tie!\nYour opponent also picked " + move + ".\nTry again.";
    }
}
