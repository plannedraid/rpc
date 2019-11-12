/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rps;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author dymoo6791
 */
public class RPS {

    static int com;
    static Scanner in = new Scanner(System.in);
    static int user;
    static int userScore;
    static int comScore;
    static boolean run = true;
    static int ties;

    public static void main(String[] args) {
        userScore = 0;
        comScore = 0;
        ties = 0;
        Random rand = new Random();

        while (run) {
            com = rand.nextInt(4 - 1) + 1; //random number generator for com (1-3)
            System.out.println("-------------"); //Prompt user
            System.out.println("Enter one of the following numbers to start");
            System.out.println("1 Rock");
            System.out.println("2 Paper");
            System.out.println("3 Scissors");
            user = in.nextInt(); //user input

            userChoice(); //calls to user choice 

            comChoice(); //calls to method and returns com's choice based on random number

            outputScores(); //updates score based on com and user choice

            endProgram(); //end program when score reaches 5
        }
    }

    /** outputs coms choice based on random num gen
     *
     */
    public static void comChoice() {
        final String[] OUTPUT = {"Rock", "Paper", "Scissors"};
        if (com == 1) {
            System.out.println("Com picked " + OUTPUT[0]);
        } else if (com == 2) {
            System.out.println("Com picked " + OUTPUT[1]);
        } else if (com == 3) {
            System.out.println("Com picked " + OUTPUT[2]);
        }
    }
/**
 * outputs user choice based on user input
 */
    public static void userChoice() {
        final String[] OUTPUT = {"Rock", "Paper", "Scissors"};
        if (user == 1) {
            System.out.println("You picked " + OUTPUT[0]);
        } else if (user == 2) {
            System.out.println("You picked " + OUTPUT[1]);
        } else if (user == 3) {
            System.out.println("You picked " + OUTPUT[2]);
        }
    }
    /**
     * updates user score if user beat com
     * 
     * @return 
     */
    public static int userScoreUpdate() {
        if ((user == 1) && (com == 3)) {
            userScore++;
            System.out.print("Round win");
        } else if ((user == 2) && (com == 1)) {
            userScore++;
            System.out.print("Round win");
        } else if ((user == 3) && (com == 2)) {
            userScore++;
            System.out.print("Round win");
        }
        return userScore;
    }

    public static int tieCounter() {
        if (com == user) {
            System.out.print("Tie");//if com choice is the same as user choice output "Tie"
            ties++;
        }
        return ties;
    }

    public static int comScoreUpdate() {
        if ((com == 1) && (user == 3)) {
            comScore++;
            System.out.print("Round loss");
        } else if ((com == 2) && (user == 1)) {
            comScore++;
            System.out.print("Round loss");
        } else if ((com == 3) && (user == 2)) {
            comScore++;
            System.out.print("Round win");
        }
        return comScore;
    }

    public static boolean endProgram() {
        if (userScore == 5) {
            run = false; //if user wins 5 games end program
            System.out.println("You Win!");
        } else if (comScore == 5) {
            run = false; //if com wins 5 games end program
            System.out.println("Try Again");
        }
        return run;
    }

    public static void outputScores() {
        System.out.print("\tYour Score " + userScoreUpdate() + " Com Score " + comScoreUpdate() + " Ties " + tieCounter() + "\n");

    }
}
