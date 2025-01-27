/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.util.ArrayList;

/**
 * Classes to simulate three arcade games available to the user, with options to
 * view their respective score lists and search for a player's high score Solves 
 * ICS4U Assignment: Culminating Assignment
 *
 * @author Dayna Dranitsaris
 * @version 1.0
 * @since 2022-01-26
 */
public class Person implements Serializable {

    //Instance Fields
    private int age;
    private String name;
    private int guessingGameHighScore;
    private int fibonacciGameHighScore;
    private int rockPaperScissorsHighScore;

    //Constructors
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(int age, String name, int guessingGameHighScore, int fibonacciGameHighScore, int rockPaperScissorsHighScore) {
        this.age = age;
        this.name = name;
        this.guessingGameHighScore = guessingGameHighScore;
        this.rockPaperScissorsHighScore = rockPaperScissorsHighScore;
    }

    //Getter and setter methods
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGuessingGameHighScore() {
        return guessingGameHighScore;
    }

    public void setGuessingGameHighScore(int highScore) {
        this.guessingGameHighScore = highScore;
    }

    public int getFibonacciGameHighScore() {
        return fibonacciGameHighScore;
    }

    public void setFibonacciGameHighScore(int highScore) {
        this.fibonacciGameHighScore = highScore;
    }

    public int getRockPaperScissorsHighScore() {
        return rockPaperScissorsHighScore;
    }

    public void setRockPaperScissorsHighScore(int highScore) {
        this.rockPaperScissorsHighScore = highScore;
    }

    //Method to get high score of a given game
    public int getHighScore(String gameName) {
        if (gameName.equals(GuessingGame.gameName)) {
            return this.getGuessingGameHighScore();
        } else if (gameName.equals(FibonacciGame.gameName)) {
            return this.getFibonacciGameHighScore();
        } else if (gameName.equals(RockPaperScissors.gameName)) {
            return this.getRockPaperScissorsHighScore();
        }
        return -1;
    }

    //Method to set high score of a given game
    public void setHighScore(String gameName, int highScore) {
        if (gameName.equals(GuessingGame.gameName)) {
            this.setGuessingGameHighScore(highScore);
        } else if (gameName.equals(FibonacciGame.gameName)) {
            this.setFibonacciGameHighScore(highScore);
        } else if (gameName.equals(RockPaperScissors.gameName)) {
            this.setRockPaperScissorsHighScore(highScore);
        }
    }

    //Method; if user exists previously, log into their profile. If not, create new object of "Person"
    public static Person setPlayer(int age, String name, ArrayList<Person> people) {
        Person player = new Person(age, name);
        int arrayListSize = people.size();
        int i;
        if (arrayListSize > 0) {
            for (i = 0; i < arrayListSize; i++) {
                if ((people.get(i).getAge() == age) && (people.get(i).getName().equals(name))) {
                    player = people.get(i);
                    break;
                }
            }
            if (i == arrayListSize) {
                people.add(player);
            }
        } else {
            people.add(player);
        }
        return player;
    }

    //Method to write object to file
    public static void writeObjectToFile(ArrayList<Person> people) throws IOException {
        try {
            FileOutputStream f = new FileOutputStream(new File("People.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            //Write objects of "Person" to file
            for (int i = 0; i < people.size(); i++) {
                o.writeObject(people.get(i));
            }

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("Person object was not written to file because file could not be found.");
        } catch (IOException e) {
            System.out.println("Person object was not written to file");
        }
    }

    //Method to read object from file
    public static void readObjectFromFile(ArrayList<Person> people) throws ClassNotFoundException, IOException {
        //Create new FileInputStream object to read file
        FileInputStream fis = new FileInputStream("People.txt");
        //Create new ObjectInputStream object to read object from file
        ObjectInputStream obj = new ObjectInputStream(fis);
        try {
            Object currentObj;
            while ((currentObj = obj.readObject()) != null) {
                //Read objects of "Person" from file
                Person person = (Person) currentObj;
                //Adds object of "Person" to ArrayList
                people.add(person);
            }
        } catch (EOFException e) {
        }
    }
}
