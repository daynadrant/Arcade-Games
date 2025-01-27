
import java.util.ArrayList;
import java.io.*;

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
public abstract class Game {

    //Class fields
    static Person player;
    static ArrayList<Person> people = new ArrayList<>();

    //Abstract method defined in subclasses to play a given game
    public abstract int play(int score, int input, int answer);
    
    //Abstract method defined in subclasses to check input for validity
    public abstract boolean checkInputValidity(String input);
    
    //Abstract method defined in subclasses to output an invalid input message
    public abstract String invalidInputMessage();
    
    //Method to sort scores in descending order
    public static void sortScores(ArrayList<Integer> scores, ArrayList<String> names) {
        for (int i = 0; i < scores.size() - 1; i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                if (scores.get(i) < scores.get(j)) {
                    int temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                    String temp2 = names.get(i);
                    names.set(i, names.get(j));
                    names.set(j, temp2);
                }
            }
        }
    }

    //Method to read in names and scores from file. Sorts the lines into their respective ArrayLists
    public static void importScores(ArrayList<Integer> scores, ArrayList<String> names, String fileName) {
        try {
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            String line = read.readLine();
            while (line != null) {
                try {
                    scores.add(Integer.parseInt(line));
                } catch (NumberFormatException ex) {
                    names.add(line);
                }
                line = read.readLine();
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("Scores not read from file because file could not be found.");
        } catch (IOException e) {
            System.out.println("Scores not read from file.");
        }
    }

    //Method to return the high score of a given person in a given game
    public static int searchScores(ArrayList<Person> people, String name, String gameName) {
        int i;
        for (i = 0; i < people.size(); i++) {
            if (people.get(i).getName().equals(name)) {
                return people.get(i).getHighScore(gameName);
            }
        }
        return -1;
    }

    //Method to check if the current player has beaten their high score in a given game
    public static void replaceHighScore(int score, Person player, String gameName) {
        //If their current score is greater than their previous high score
        if (score > player.getHighScore(gameName)) {
            //Sets their new high score
            player.setHighScore(gameName, score);
        } 
    }

    //Method to write name and score to scores file of a given game
    public static void saveScore(int score, Person player, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter buffer = new BufferedWriter(fw);

            buffer.write(player.getName());
            buffer.newLine();
            buffer.write(Integer.toString(score));
            buffer.newLine();

            buffer.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Name and score were not saved to file.");
        }
    }

    //Abstract method defined in subclasses to output a win message for a given game
    public abstract String winMessage(int score, int number);
    
    //Abstract method defined in subclasses to output a lose message for a given game
    public abstract String loseMessage(int score, int number);
}
