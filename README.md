# Arcade Games

A Java Swing desktop arcade with three games, per-game high-score lists, and a search for any player's best score. It was written as a Grade 12 ICS4U culminating assignment (January 2022).

## Games

- **Guessing Game**
- **Fibonacci Game**
- **Rock Paper Scissors**

Each game has its own play screen, a high-score list sorted from best to worst, and a screen to look up a particular player's score.

## How it's built

- **Swing GUI** designed with the NetBeans form editor, so every `Frm*.java` screen has a matching `.form` file.
- **`Game`** is an abstract base class (play, input validation, invalid-input message) extended by `GuessingGame` and `RockPaperScissors`, and used the same way by the Fibonacci game's `FibonacciGame` class. It also holds the shared code for importing scores from text files and sorting them.
- **`Person`** stores a player's name, age and high score for each game. Players are saved between runs by serializing them to `People.txt`, and per-game score lists are kept in text files such as `GuessingGameScores.txt` and `RockPaperScissorsScores.txt`.
- **Screens:** `FrmWelcomeScreen` is the entry point and opens `FrmMainMenu`, which leads to each game, its scores and its search screen.

```
src/main/java/   all Java sources and NetBeans .form files
*.png, *.jpeg    button and game artwork
target/          compiled classes from an earlier build
```

## Running

Open the project in NetBeans (or another IDE with Swing support) and run `FrmWelcomeScreen`. Run it from the project root so the image files are found.

## Status

This repo doesn't contain a build file (no `pom.xml` or NetBeans project folder), and three source files are missing from `src/main/java`: `FrmGuessingGame.java`, `FibonacciGame.java` and `FrmExit.java`. Because of that, compiling the sources with `javac` fails. Compiled versions of these classes exist in `target/classes` from an earlier build. Restoring the missing sources and adding a `pom.xml` would make the project build from a fresh clone.
