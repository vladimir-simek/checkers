package com.vladimirsimek.checkers;

import java.util.Scanner;

import static com.vladimirsimek.checkers.gui.*;

public class Main {

    public static final String blackSpot = "■";
    public static final String whiteSpot = "□";
    public static final String player2 = "©";
    public static final String player1 = "®";
    public static final String row = "-----------------------------------";
    public static String rawCoordinates;
    public static Scanner sc = new Scanner(System.in);
    public static int runTimeCycles = 2;
    public static String[][] fields = {
            {whiteSpot, player2, whiteSpot, player2, whiteSpot, player2, whiteSpot, player2},
            {player2, whiteSpot, player2, whiteSpot, player2, whiteSpot, player2, whiteSpot},
            {whiteSpot, player2, whiteSpot, player2, whiteSpot, player2, whiteSpot, player2},
            {blackSpot, whiteSpot, blackSpot, whiteSpot, blackSpot, whiteSpot, blackSpot, whiteSpot},
            {whiteSpot, blackSpot, whiteSpot, blackSpot, whiteSpot, blackSpot, whiteSpot, blackSpot},
            {player1, whiteSpot, player1, whiteSpot, player1, whiteSpot, player1, whiteSpot},
            {whiteSpot, player1, whiteSpot, player1, whiteSpot, player1, whiteSpot, player1},
            {player1, whiteSpot, player1, whiteSpot, player1, whiteSpot, player1, whiteSpot}
    };
    public static int player2amount = 12;
    public static int player1amount = 12;
    public static boolean playersLeft = true;


    public static void main(String[] args) {
        drawFields(fields);

        while (playersLeft) {
            runTimeCycles++;
            areHerePlayers();
            if (player2amount == 0 || player1amount == 0) { // If someone lost all checkers the game will end
                clearScreen();
                System.out.println("Good game well played!");
            }
            System.out.println(row);
            if (runTimeCycles % 2 == 0) {
                System.out.println("Write down coordinates for player number 2 \"x,y\".");
            } else System.out.println("Write down coordinates for player number 1 \"x,y\".");
            rawCoordinates = sc.next();
            if (isCoordinateValid(fields, rawCoordinates)) {
                System.out.println("ez");
            } else {
                notValidCoordinate();
            }
        }
    }
}
